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
import net.ibizsys.pscore.srv.dedesign.dao.PSDEListDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEListDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEActionBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSetBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFieldBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEList;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEListItem;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEListItemBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEListLogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEListLogicBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogicBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDER;
import net.ibizsys.pscore.srv.dedesign.entity.PSDERBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEToolbar;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEToolbarBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUAGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUAGroupBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBaseBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormDetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormDetailServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEListItemService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEListItemServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEListLogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEListLogicServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewCtrlService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewCtrlServiceBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdesign.entity.PSACHandler;
import net.ibizsys.pscore.srv.sysdesign.entity.PSACHandlerBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeList;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeListBase;
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
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanelBase;
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

public abstract class PSDEListServiceBase
extends PSCoreSysServiceBase<PSDEList> {
    private static final Log log = LogFactory.getLog(PSDEListServiceBase.class);
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
    private PSDEListDEModel pSDEListDEModel;
    private PSDEListDAO pSDEListDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEListService";
    }

    public PSDEListDEModel getPSDEListDEModel() {
        if (this.pSDEListDEModel == null) {
            try {
                this.pSDEListDEModel = (PSDEListDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEListDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEListDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEListDEModel();
    }

    public PSDEListDAO getPSDEListDAO() {
        if (this.pSDEListDAO == null) {
            try {
                this.pSDEListDAO = (PSDEListDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDEListDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEListDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEListDAO();
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
            this.createWithModel((PSDEList)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_GETDRAFTFROMWITHMODEL, (boolean)true) == 0) {
            this.getDraftFromWithModel((PSDEList)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_GETDRAFTWITHMODEL, (boolean)true) == 0) {
            this.getDraftWithModel((PSDEList)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_GETWITHMODEL, (boolean)true) == 0) {
            this.getWithModel((PSDEList)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_JITPREVIEW, (boolean)true) == 0) {
            this.jITPreview((PSDEList)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_UPDATEWITHMODEL, (boolean)true) == 0) {
            this.updateWithModel((PSDEList)iEntity);
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

    public void createWithModel(PSDEList pSDEList) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_CREATEWITHMODEL, 0, pSDEList, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDEList, ACTION_CREATEWITHMODEL);
        final PSDEList pSDEList2 = pSDEList;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEListServiceBase.this.getService(), PSDEListServiceBase.ACTION_CREATEWITHMODEL, 40, pSDEList2, null).getResult() != 1) {
                    PSDEListServiceBase.this.onCreateWithModel(pSDEList2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_CREATEWITHMODEL, 99, pSDEList, null);
        }
    }

    protected void onCreateWithModel(PSDEList pSDEList) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[CreateWithModel]");
    }

    public void getDraftFromWithModel(PSDEList pSDEList) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_GETDRAFTFROMWITHMODEL, 0, pSDEList, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDEList, ACTION_GETDRAFTFROMWITHMODEL);
        final PSDEList pSDEList2 = pSDEList;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEListServiceBase.this.getService(), PSDEListServiceBase.ACTION_GETDRAFTFROMWITHMODEL, 40, pSDEList2, null).getResult() != 1) {
                    PSDEListServiceBase.this.onGetDraftFromWithModel(pSDEList2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_GETDRAFTFROMWITHMODEL, 99, pSDEList, null);
        }
    }

    protected void onGetDraftFromWithModel(PSDEList pSDEList) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[GetDraftFromWithModel]");
    }

    public void getDraftWithModel(PSDEList pSDEList) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_GETDRAFTWITHMODEL, 0, pSDEList, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDEList, ACTION_GETDRAFTWITHMODEL);
        final PSDEList pSDEList2 = pSDEList;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEListServiceBase.this.getService(), PSDEListServiceBase.ACTION_GETDRAFTWITHMODEL, 40, pSDEList2, null).getResult() != 1) {
                    PSDEListServiceBase.this.onGetDraftWithModel(pSDEList2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_GETDRAFTWITHMODEL, 99, pSDEList, null);
        }
    }

    protected void onGetDraftWithModel(PSDEList pSDEList) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[GetDraftWithModel]");
    }

    public void getWithModel(PSDEList pSDEList) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_GETWITHMODEL, 0, pSDEList, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDEList, ACTION_GETWITHMODEL);
        final PSDEList pSDEList2 = pSDEList;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEListServiceBase.this.getService(), PSDEListServiceBase.ACTION_GETWITHMODEL, 40, pSDEList2, null).getResult() != 1) {
                    PSDEListServiceBase.this.onGetWithModel(pSDEList2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_GETWITHMODEL, 99, pSDEList, null);
        }
    }

    protected void onGetWithModel(PSDEList pSDEList) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[GetWithModel]");
    }

    public void jITPreview(PSDEList pSDEList) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_JITPREVIEW, 0, pSDEList, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDEList, ACTION_JITPREVIEW);
        final PSDEList pSDEList2 = pSDEList;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEListServiceBase.this.getService(), PSDEListServiceBase.ACTION_JITPREVIEW, 40, pSDEList2, null).getResult() != 1) {
                    PSDEListServiceBase.this.onJITPreview(pSDEList2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_JITPREVIEW, 99, pSDEList, null);
        }
    }

    protected void onJITPreview(PSDEList pSDEList) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[JITPREVIEW]");
    }

    public void updateWithModel(PSDEList pSDEList) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_UPDATEWITHMODEL, 0, pSDEList, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDEList, ACTION_UPDATEWITHMODEL);
        final PSDEList pSDEList2 = pSDEList;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEListServiceBase.this.getService(), PSDEListServiceBase.ACTION_UPDATEWITHMODEL, 40, pSDEList2, null).getResult() != 1) {
                    PSDEListServiceBase.this.onUpdateWithModel(pSDEList2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_UPDATEWITHMODEL, 99, pSDEList, null);
        }
    }

    protected void onUpdateWithModel(PSDEList pSDEList) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[UpdateWithModel]");
    }

    protected void onFillParentInfo(PSDEList pSDEList, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELIST_PSACHANDLER_PSACHANDLERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSACHandlerService", (SessionFactory)this.getSessionFactory());
            PSACHandler pSACHandler = (PSACHandler)iService.getDEModel().createEntity();
            pSACHandler.set("PSACHANDLERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSACHandler);
            } else {
                iService.get(pSACHandler);
            }
            this.onFillParentInfo_PSACHandler(pSDEList, pSACHandler);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELIST_PSCODELIST_GROUPPSCODELISTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService", (SessionFactory)this.getSessionFactory());
            PSCodeList pSCodeList = (PSCodeList)iService.getDEModel().createEntity();
            pSCodeList.set("PSCODELISTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSCodeList);
            } else {
                iService.get(pSCodeList);
            }
            this.onFillParentInfo_GroupPSCodeList(pSDEList, pSCodeList);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELIST_PSCODELIST_SWIMLANEPSCODELISTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService", (SessionFactory)this.getSessionFactory());
            PSCodeList pSCodeList = (PSCodeList)iService.getDEModel().createEntity();
            pSCodeList.set("PSCODELISTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSCodeList);
            } else {
                iService.get(pSCodeList);
            }
            this.onFillParentInfo_SwimlanePSCodeList(pSDEList, pSCodeList);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELIST_PSCTRLLOGICGROUP_PSCTRLLOGICGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSCtrlLogicGroupService", (SessionFactory)this.getSessionFactory());
            PSCtrlLogicGroup pSCtrlLogicGroup = (PSCtrlLogicGroup)iService.getDEModel().createEntity();
            pSCtrlLogicGroup.set("PSCTRLLOGICGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSCtrlLogicGroup);
            } else {
                iService.get(pSCtrlLogicGroup);
            }
            this.onFillParentInfo_PSCtrlLogicGroup(pSDEList, pSCtrlLogicGroup);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELIST_PSCTRLMSG_PSCTRLMSGID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSCtrlMsgService", (SessionFactory)this.getSessionFactory());
            PSCtrlMsg pSCtrlMsg = (PSCtrlMsg)iService.getDEModel().createEntity();
            pSCtrlMsg.set("PSCTRLMSGID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSCtrlMsg);
            } else {
                iService.get(pSCtrlMsg);
            }
            this.onFillParentInfo_PSCtrlMsg(pSDEList, pSCtrlMsg);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELIST_PSDATAENTITY_GROUPPSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDataEntity);
            } else {
                iService.get(pSDataEntity);
            }
            this.onFillParentInfo_GroupPSDE(pSDEList, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELIST_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDataEntity);
            } else {
                iService.get(pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSDEList, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELIST_PSDEACTION_COPYPSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEAction);
            } else {
                iService.get(pSDEAction);
            }
            this.onFillParentInfo_CopyPSDEAction(pSDEList, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELIST_PSDEACTION_CREATEPSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEAction);
            } else {
                iService.get(pSDEAction);
            }
            this.onFillParentInfo_CreatePSDEAction(pSDEList, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELIST_PSDEACTION_GETDRAFTPSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEAction);
            } else {
                iService.get(pSDEAction);
            }
            this.onFillParentInfo_GetDraftPSDEAction(pSDEList, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELIST_PSDEACTION_GETPSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEAction);
            } else {
                iService.get(pSDEAction);
            }
            this.onFillParentInfo_GetPSDEAction(pSDEList, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELIST_PSDEACTION_GROUPMOVEPSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEAction);
            } else {
                iService.get(pSDEAction);
            }
            this.onFillParentInfo_GroupMovePSDEAction(pSDEList, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELIST_PSDEACTION_MOVEPSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEAction);
            } else {
                iService.get(pSDEAction);
            }
            this.onFillParentInfo_MovePSDEAction(pSDEList, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELIST_PSDEACTION_REMOVEPSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEAction);
            } else {
                iService.get(pSDEAction);
            }
            this.onFillParentInfo_RemovePSDEAction(pSDEList, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELIST_PSDEACTION_UPDATEPSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEAction);
            } else {
                iService.get(pSDEAction);
            }
            this.onFillParentInfo_UpdatePSDEAction(pSDEList, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELIST_PSDEACTION_USER2PSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEAction);
            } else {
                iService.get(pSDEAction);
            }
            this.onFillParentInfo_User2PSDEAction(pSDEList, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELIST_PSDEACTION_USERPSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEAction);
            } else {
                iService.get(pSDEAction);
            }
            this.onFillParentInfo_UserPSDEAction(pSDEList, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELIST_PSDEDATASET_ASYNCPSDEDSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService", (SessionFactory)this.getSessionFactory());
            PSDEDataSet pSDEDataSet = (PSDEDataSet)iService.getDEModel().createEntity();
            pSDEDataSet.set("PSDEDATASETID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEDataSet);
            } else {
                iService.get(pSDEDataSet);
            }
            this.onFillParentInfo_AsyncPSDEDS(pSDEList, pSDEDataSet);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELIST_PSDEDATASET_PSDEDSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService", (SessionFactory)this.getSessionFactory());
            PSDEDataSet pSDEDataSet = (PSDEDataSet)iService.getDEModel().createEntity();
            pSDEDataSet.set("PSDEDATASETID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEDataSet);
            } else {
                iService.get(pSDEDataSet);
            }
            this.onFillParentInfo_PSDEDS(pSDEList, pSDEDataSet);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELIST_PSDEFIELD_GROUPPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_GroupPSDEF(pSDEList, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELIST_PSDEFIELD_GROUPTEXTPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_GroupTextPSDEF(pSDEList, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELIST_PSDEFIELD_MINORSORTPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_MinorSortPSDEF(pSDEList, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELIST_PSDEFIELD_ORDERVALUEPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_OrderValuePSDEF(pSDEList, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELIST_PSDEFIELD_SWIMLANEPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_SwimlanePSDEF(pSDEList, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELIST_PSDELOGIC_ADPSDELOGICID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDELogicService", (SessionFactory)this.getSessionFactory());
            PSDELogic pSDELogic = (PSDELogic)iService.getDEModel().createEntity();
            pSDELogic.set("PSDELOGICID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDELogic);
            } else {
                iService.get(pSDELogic);
            }
            this.onFillParentInfo_ADPSDELogic(pSDEList, pSDELogic);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELIST_PSDER_NAVPSDERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDERService", (SessionFactory)this.getSessionFactory());
            PSDER pSDER = (PSDER)iService.getDEModel().createEntity();
            pSDER.set("PSDERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDER);
            } else {
                iService.get(pSDER);
            }
            this.onFillParentInfo_NavPSDER(pSDEList, pSDER);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELIST_PSDETOOLBAR_BATPSDETOOLBARID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEToolbarService", (SessionFactory)this.getSessionFactory());
            PSDEToolbar pSDEToolbar = (PSDEToolbar)iService.getDEModel().createEntity();
            pSDEToolbar.set("PSDETOOLBARID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEToolbar);
            } else {
                iService.get(pSDEToolbar);
            }
            this.onFillParentInfo_BatPSDEToolbar(pSDEList, pSDEToolbar);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELIST_PSDETOOLBAR_QUICKPSDETOOLBARID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEToolbarService", (SessionFactory)this.getSessionFactory());
            PSDEToolbar pSDEToolbar = (PSDEToolbar)iService.getDEModel().createEntity();
            pSDEToolbar.set("PSDETOOLBARID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEToolbar);
            } else {
                iService.get(pSDEToolbar);
            }
            this.onFillParentInfo_QuickPSDEToolbar(pSDEList, pSDEToolbar);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELIST_PSDEUAGROUP_GROUPPSDEUAGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupService", (SessionFactory)this.getSessionFactory());
            PSDEUAGroup pSDEUAGroup = (PSDEUAGroup)iService.getDEModel().createEntity();
            pSDEUAGroup.set("PSDEUAGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEUAGroup);
            } else {
                iService.get(pSDEUAGroup);
            }
            this.onFillParentInfo_GroupPSDEUAGroup(pSDEList, pSDEUAGroup);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELIST_PSDEUAGROUP_NO2PSDEUAGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupService", (SessionFactory)this.getSessionFactory());
            PSDEUAGroup pSDEUAGroup = (PSDEUAGroup)iService.getDEModel().createEntity();
            pSDEUAGroup.set("PSDEUAGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEUAGroup);
            } else {
                iService.get(pSDEUAGroup);
            }
            this.onFillParentInfo_No2PSDEUAGroup(pSDEList, pSDEUAGroup);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELIST_PSDEUAGROUP_PSDEUAGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupService", (SessionFactory)this.getSessionFactory());
            PSDEUAGroup pSDEUAGroup = (PSDEUAGroup)iService.getDEModel().createEntity();
            pSDEUAGroup.set("PSDEUAGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEUAGroup);
            } else {
                iService.get(pSDEUAGroup);
            }
            this.onFillParentInfo_PSDEUAGroup(pSDEList, pSDEUAGroup);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELIST_PSDEVIEWBASE_NAVPSDEVIEWBASEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService", (SessionFactory)this.getSessionFactory());
            PSDEViewBase pSDEViewBase = (PSDEViewBase)iService.getDEModel().createEntity();
            pSDEViewBase.set("PSDEVIEWBASEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEViewBase);
            } else {
                iService.get(pSDEViewBase);
            }
            this.onFillParentInfo_NavPSDEViewBase(pSDEList, pSDEViewBase);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELIST_PSLANGUAGERES_EMPTYTEXTPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSLanguageRes);
            } else {
                iService.get(pSLanguageRes);
            }
            this.onFillParentInfo_EmptyTextPSLanRes(pSDEList, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELIST_PSSYSCSS_GROUPPSSYSCSSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService", (SessionFactory)this.getSessionFactory());
            PSSysCss pSSysCss = (PSSysCss)iService.getDEModel().createEntity();
            pSSysCss.set("PSSYSCSSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysCss);
            } else {
                iService.get(pSSysCss);
            }
            this.onFillParentInfo_GroupPSSysCss(pSDEList, pSSysCss);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELIST_PSSYSCSS_ITEMPSSYSCSSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService", (SessionFactory)this.getSessionFactory());
            PSSysCss pSSysCss = (PSSysCss)iService.getDEModel().createEntity();
            pSSysCss.set("PSSYSCSSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysCss);
            } else {
                iService.get(pSSysCss);
            }
            this.onFillParentInfo_ItemPSSysCss(pSDEList, pSSysCss);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELIST_PSSYSCSS_PSSYSCSSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService", (SessionFactory)this.getSessionFactory());
            PSSysCss pSSysCss = (PSSysCss)iService.getDEModel().createEntity();
            pSSysCss.set("PSSYSCSSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysCss);
            } else {
                iService.get(pSSysCss);
            }
            this.onFillParentInfo_PSSysCss(pSDEList, pSSysCss);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELIST_PSSYSPFPLUGIN_GROUPPSSYSPFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysPFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysPFPlugin pSSysPFPlugin = (PSSysPFPlugin)iService.getDEModel().createEntity();
            pSSysPFPlugin.set("PSSYSPFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysPFPlugin);
            } else {
                iService.get(pSSysPFPlugin);
            }
            this.onFillParentInfo_GroupPSSysPFPlugin(pSDEList, pSSysPFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELIST_PSSYSPFPLUGIN_ITEMPSSYSPFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysPFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysPFPlugin pSSysPFPlugin = (PSSysPFPlugin)iService.getDEModel().createEntity();
            pSSysPFPlugin.set("PSSYSPFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysPFPlugin);
            } else {
                iService.get(pSSysPFPlugin);
            }
            this.onFillParentInfo_ItemPSSysPFPlugin(pSDEList, pSSysPFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELIST_PSSYSPFPLUGIN_PSSYSPFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysPFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysPFPlugin pSSysPFPlugin = (PSSysPFPlugin)iService.getDEModel().createEntity();
            pSSysPFPlugin.set("PSSYSPFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysPFPlugin);
            } else {
                iService.get(pSSysPFPlugin);
            }
            this.onFillParentInfo_PSSysPFPlugin(pSDEList, pSSysPFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELIST_PSSYSREQITEM_PSSYSREQITEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemService", (SessionFactory)this.getSessionFactory());
            PSSysReqItem pSSysReqItem = (PSSysReqItem)iService.getDEModel().createEntity();
            pSSysReqItem.set("PSSYSREQITEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysReqItem);
            } else {
                iService.get(pSSysReqItem);
            }
            this.onFillParentInfo_PSSysReqItem(pSDEList, pSSysReqItem);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELIST_PSSYSVIEWPANEL_PSSYSVIEWPANELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelService", (SessionFactory)this.getSessionFactory());
            PSSysViewPanel pSSysViewPanel = (PSSysViewPanel)iService.getDEModel().createEntity();
            pSSysViewPanel.set("PSSYSVIEWPANELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysViewPanel);
            } else {
                iService.get(pSSysViewPanel);
            }
            this.onFillParentInfo_PSSysViewPanel(pSDEList, pSSysViewPanel);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELIST_PSVIEWMSGGROUP_PSVIEWMSGGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSViewMsgGroupService", (SessionFactory)this.getSessionFactory());
            PSViewMsgGroup pSViewMsgGroup = (PSViewMsgGroup)iService.getDEModel().createEntity();
            pSViewMsgGroup.set("PSVIEWMSGGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSViewMsgGroup);
            } else {
                iService.get(pSViewMsgGroup);
            }
            this.onFillParentInfo_PSViewMsgGroup(pSDEList, pSViewMsgGroup);
            return;
        }
        super.onFillParentInfo(pSDEList, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSACHandler(PSDEList pSDEList, PSACHandler pSACHandler) throws Exception {
        pSDEList.setPSACHandlerId(pSACHandler.getPSACHandlerId());
        pSDEList.setPSACHandlerName(pSACHandler.getPSACHandlerName());
    }

    protected void onFillParentInfo_GroupPSCodeList(PSDEList pSDEList, PSCodeList pSCodeList) throws Exception {
        pSDEList.setGroupPSCodeListId(pSCodeList.getPSCodeListId());
        pSDEList.setGroupPSCodeListName(pSCodeList.getPSCodeListName());
    }

    protected void onFillParentInfo_SwimlanePSCodeList(PSDEList pSDEList, PSCodeList pSCodeList) throws Exception {
        pSDEList.setSwimlanePSCodeListId(pSCodeList.getPSCodeListId());
        pSDEList.setSwimlanePSCodeListName(pSCodeList.getPSCodeListName());
    }

    protected void onFillParentInfo_PSCtrlLogicGroup(PSDEList pSDEList, PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        pSDEList.setPSCtrlLogicGroupId(pSCtrlLogicGroup.getPSCtrlLogicGroupId());
        pSDEList.setPSCtrlLogicGroupName(pSCtrlLogicGroup.getPSCtrlLogicGroupName());
    }

    protected void onFillParentInfo_PSCtrlMsg(PSDEList pSDEList, PSCtrlMsg pSCtrlMsg) throws Exception {
        pSDEList.setPSCtrlMsgId(pSCtrlMsg.getPSCtrlMsgId());
        pSDEList.setPSCtrlMsgName(pSCtrlMsg.getPSCtrlMsgName());
    }

    protected void onFillParentInfo_GroupPSDE(PSDEList pSDEList, PSDataEntity pSDataEntity) throws Exception {
        pSDEList.setGroupPSDEId(pSDataEntity.getPSDataEntityId());
        pSDEList.setGroupPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_PSDE(PSDEList pSDEList, PSDataEntity pSDataEntity) throws Exception {
        pSDEList.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSDEList.setPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_CopyPSDEAction(PSDEList pSDEList, PSDEAction pSDEAction) throws Exception {
        pSDEList.setCopyPSDEActionId(pSDEAction.getPSDEActionId());
        pSDEList.setCopyPSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_CreatePSDEAction(PSDEList pSDEList, PSDEAction pSDEAction) throws Exception {
        pSDEList.setCreatePSDEActionId(pSDEAction.getPSDEActionId());
        pSDEList.setCreatePSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_GetDraftPSDEAction(PSDEList pSDEList, PSDEAction pSDEAction) throws Exception {
        pSDEList.setGetDraftPSDEActionId(pSDEAction.getPSDEActionId());
        pSDEList.setGetDraftPSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_GetPSDEAction(PSDEList pSDEList, PSDEAction pSDEAction) throws Exception {
        pSDEList.setGetPSDEActionId(pSDEAction.getPSDEActionId());
        pSDEList.setGetPSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_GroupMovePSDEAction(PSDEList pSDEList, PSDEAction pSDEAction) throws Exception {
        pSDEList.setGroupMovePSDEActionId(pSDEAction.getPSDEActionId());
        pSDEList.setGroupMovePSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_MovePSDEAction(PSDEList pSDEList, PSDEAction pSDEAction) throws Exception {
        pSDEList.setMovePSDEActionId(pSDEAction.getPSDEActionId());
        pSDEList.setMovePSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_RemovePSDEAction(PSDEList pSDEList, PSDEAction pSDEAction) throws Exception {
        pSDEList.setRemovePSDEActionId(pSDEAction.getPSDEActionId());
        pSDEList.setRemovePSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_UpdatePSDEAction(PSDEList pSDEList, PSDEAction pSDEAction) throws Exception {
        pSDEList.setUpdatePSDEActionId(pSDEAction.getPSDEActionId());
        pSDEList.setUpdatePSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_User2PSDEAction(PSDEList pSDEList, PSDEAction pSDEAction) throws Exception {
        pSDEList.setUser2PSDEActionId(pSDEAction.getPSDEActionId());
        pSDEList.setUser2PSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_UserPSDEAction(PSDEList pSDEList, PSDEAction pSDEAction) throws Exception {
        pSDEList.setUserPSDEActionId(pSDEAction.getPSDEActionId());
        pSDEList.setUserPSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_AsyncPSDEDS(PSDEList pSDEList, PSDEDataSet pSDEDataSet) throws Exception {
        pSDEList.setAsyncPSDEDSId(pSDEDataSet.getPSDEDataSetId());
        pSDEList.setAsyncPSDEDSName(pSDEDataSet.getPSDEDataSetName());
    }

    protected void onFillParentInfo_PSDEDS(PSDEList pSDEList, PSDEDataSet pSDEDataSet) throws Exception {
        pSDEList.setPSDEDSId(pSDEDataSet.getPSDEDataSetId());
        pSDEList.setPSDEDSName(pSDEDataSet.getPSDEDataSetName());
    }

    protected void onFillParentInfo_GroupPSDEF(PSDEList pSDEList, PSDEField pSDEField) throws Exception {
        pSDEList.setGroupPSDEFId(pSDEField.getPSDEFieldId());
        pSDEList.setGroupPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_GroupTextPSDEF(PSDEList pSDEList, PSDEField pSDEField) throws Exception {
        pSDEList.setGroupTextPSDEFId(pSDEField.getPSDEFieldId());
        pSDEList.setGroupTextPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_MinorSortPSDEF(PSDEList pSDEList, PSDEField pSDEField) throws Exception {
        pSDEList.setMinorSortPSDEFId(pSDEField.getPSDEFieldId());
        pSDEList.setMinorSortPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_OrderValuePSDEF(PSDEList pSDEList, PSDEField pSDEField) throws Exception {
        pSDEList.setOrderValuePSDEFId(pSDEField.getPSDEFieldId());
        pSDEList.setOrderValuePSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_SwimlanePSDEF(PSDEList pSDEList, PSDEField pSDEField) throws Exception {
        pSDEList.setSwimlanePSDEFId(pSDEField.getPSDEFieldId());
        pSDEList.setSwimlanePSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_ADPSDELogic(PSDEList pSDEList, PSDELogic pSDELogic) throws Exception {
        pSDEList.setADPSDELogicId(pSDELogic.getPSDELogicId());
        pSDEList.setADPSDELogicName(pSDELogic.getPSDELogicName());
    }

    protected void onFillParentInfo_NavPSDER(PSDEList pSDEList, PSDER pSDER) throws Exception {
        pSDEList.setNavPSDERId(pSDER.getPSDERId());
        pSDEList.setNavPSDERName(pSDER.getPSDERName());
    }

    protected void onFillParentInfo_BatPSDEToolbar(PSDEList pSDEList, PSDEToolbar pSDEToolbar) throws Exception {
        pSDEList.setBatPSDEToolbarId(pSDEToolbar.getPSDEToolbarId());
        pSDEList.setBatPSDEToolbarName(pSDEToolbar.getPSDEToolbarName());
    }

    protected void onFillParentInfo_QuickPSDEToolbar(PSDEList pSDEList, PSDEToolbar pSDEToolbar) throws Exception {
        pSDEList.setQuickPSDEToolbarId(pSDEToolbar.getPSDEToolbarId());
        pSDEList.setQuickPSDEToolbarName(pSDEToolbar.getPSDEToolbarName());
    }

    protected void onFillParentInfo_GroupPSDEUAGroup(PSDEList pSDEList, PSDEUAGroup pSDEUAGroup) throws Exception {
        pSDEList.setGroupPSDEUAGroupId(pSDEUAGroup.getPSDEUAGroupId());
        pSDEList.setGroupPSDEUAGroupName(pSDEUAGroup.getPSDEUAGroupName());
    }

    protected void onFillParentInfo_No2PSDEUAGroup(PSDEList pSDEList, PSDEUAGroup pSDEUAGroup) throws Exception {
        pSDEList.setNo2PSDEUAGroupId(pSDEUAGroup.getPSDEUAGroupId());
        pSDEList.setNo2PSDEUAGroupName(pSDEUAGroup.getPSDEUAGroupName());
    }

    protected void onFillParentInfo_PSDEUAGroup(PSDEList pSDEList, PSDEUAGroup pSDEUAGroup) throws Exception {
        pSDEList.setPSDEUAGroupId(pSDEUAGroup.getPSDEUAGroupId());
        pSDEList.setPSDEUAGroupName(pSDEUAGroup.getPSDEUAGroupName());
    }

    protected void onFillParentInfo_NavPSDEViewBase(PSDEList pSDEList, PSDEViewBase pSDEViewBase) throws Exception {
        pSDEList.setNavPSDEViewBaseId(pSDEViewBase.getPSDEViewBaseId());
        pSDEList.setNavPSDEViewBaseName(pSDEViewBase.getPSDEViewBaseName());
    }

    protected void onFillParentInfo_EmptyTextPSLanRes(PSDEList pSDEList, PSLanguageRes pSLanguageRes) throws Exception {
        pSDEList.setEmptyTextPSLanResId(pSLanguageRes.getPSLanguageResId());
        pSDEList.setEmptyTextPSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_GroupPSSysCss(PSDEList pSDEList, PSSysCss pSSysCss) throws Exception {
        pSDEList.setGroupPSSysCssId(pSSysCss.getPSSysCssId());
        pSDEList.setGroupPSSysCssName(pSSysCss.getPSSysCssName());
    }

    protected void onFillParentInfo_ItemPSSysCss(PSDEList pSDEList, PSSysCss pSSysCss) throws Exception {
        pSDEList.setItemPSSysCssId(pSSysCss.getPSSysCssId());
        pSDEList.setItemPSSysCssName(pSSysCss.getPSSysCssName());
    }

    protected void onFillParentInfo_PSSysCss(PSDEList pSDEList, PSSysCss pSSysCss) throws Exception {
        pSDEList.setPSSysCssId(pSSysCss.getPSSysCssId());
        pSDEList.setPSSysCssName(pSSysCss.getPSSysCssName());
    }

    protected void onFillParentInfo_GroupPSSysPFPlugin(PSDEList pSDEList, PSSysPFPlugin pSSysPFPlugin) throws Exception {
        pSDEList.setGroupPSSysPFPluginId(pSSysPFPlugin.getPSSysPFPluginId());
        pSDEList.setGroupPSSysPFPluginName(pSSysPFPlugin.getPSSysPFPluginName());
    }

    protected void onFillParentInfo_ItemPSSysPFPlugin(PSDEList pSDEList, PSSysPFPlugin pSSysPFPlugin) throws Exception {
        pSDEList.setItemPSSysPFPluginId(pSSysPFPlugin.getPSSysPFPluginId());
        pSDEList.setItemPSSysPFPluginName(pSSysPFPlugin.getPSSysPFPluginName());
    }

    protected void onFillParentInfo_PSSysPFPlugin(PSDEList pSDEList, PSSysPFPlugin pSSysPFPlugin) throws Exception {
        pSDEList.setPSSysPFPluginId(pSSysPFPlugin.getPSSysPFPluginId());
        pSDEList.setPSSysPFPluginName(pSSysPFPlugin.getPSSysPFPluginName());
    }

    protected void onFillParentInfo_PSSysReqItem(PSDEList pSDEList, PSSysReqItem pSSysReqItem) throws Exception {
        pSDEList.setPSSysReqItemId(pSSysReqItem.getPSSysReqItemId());
        pSDEList.setPSSysReqItemName(pSSysReqItem.getPSSysReqItemName());
    }

    protected void onFillParentInfo_PSSysViewPanel(PSDEList pSDEList, PSSysViewPanel pSSysViewPanel) throws Exception {
        pSDEList.setPSSysViewPanelId(pSSysViewPanel.getPSSysViewPanelId());
        pSDEList.setPSSysViewPanelName(pSSysViewPanel.getPSSysViewPanelName());
    }

    protected void onFillParentInfo_PSViewMsgGroup(PSDEList pSDEList, PSViewMsgGroup pSViewMsgGroup) throws Exception {
        pSDEList.setPSViewMsgGroupId(pSViewMsgGroup.getPSViewMsgGroupId());
        pSDEList.setPSViewMsgGroupName(pSViewMsgGroup.getPSViewMsgGroupName());
    }

    protected void onFillEntityFullInfo(PSDEList pSDEList, boolean bl) throws Exception {
        if (bl && pSDEList.getPSDEListName() == null) {
            pSDEList.setPSDEListName((String)this.getDefaultValue(this.getWebContext(), "USER", "List", 25));
        }
        super.onFillEntityFullInfo(pSDEList, bl);
        this.onFillEntityFullInfo_PSACHandler(pSDEList, bl);
        this.onFillEntityFullInfo_GroupPSCodeList(pSDEList, bl);
        this.onFillEntityFullInfo_SwimlanePSCodeList(pSDEList, bl);
        this.onFillEntityFullInfo_PSCtrlLogicGroup(pSDEList, bl);
        this.onFillEntityFullInfo_PSCtrlMsg(pSDEList, bl);
        this.onFillEntityFullInfo_GroupPSDE(pSDEList, bl);
        this.onFillEntityFullInfo_PSDE(pSDEList, bl);
        this.onFillEntityFullInfo_CopyPSDEAction(pSDEList, bl);
        this.onFillEntityFullInfo_CreatePSDEAction(pSDEList, bl);
        this.onFillEntityFullInfo_GetDraftPSDEAction(pSDEList, bl);
        this.onFillEntityFullInfo_GetPSDEAction(pSDEList, bl);
        this.onFillEntityFullInfo_GroupMovePSDEAction(pSDEList, bl);
        this.onFillEntityFullInfo_MovePSDEAction(pSDEList, bl);
        this.onFillEntityFullInfo_RemovePSDEAction(pSDEList, bl);
        this.onFillEntityFullInfo_UpdatePSDEAction(pSDEList, bl);
        this.onFillEntityFullInfo_User2PSDEAction(pSDEList, bl);
        this.onFillEntityFullInfo_UserPSDEAction(pSDEList, bl);
        this.onFillEntityFullInfo_AsyncPSDEDS(pSDEList, bl);
        this.onFillEntityFullInfo_PSDEDS(pSDEList, bl);
        this.onFillEntityFullInfo_GroupPSDEF(pSDEList, bl);
        this.onFillEntityFullInfo_GroupTextPSDEF(pSDEList, bl);
        this.onFillEntityFullInfo_MinorSortPSDEF(pSDEList, bl);
        this.onFillEntityFullInfo_OrderValuePSDEF(pSDEList, bl);
        this.onFillEntityFullInfo_SwimlanePSDEF(pSDEList, bl);
        this.onFillEntityFullInfo_ADPSDELogic(pSDEList, bl);
        this.onFillEntityFullInfo_NavPSDER(pSDEList, bl);
        this.onFillEntityFullInfo_BatPSDEToolbar(pSDEList, bl);
        this.onFillEntityFullInfo_QuickPSDEToolbar(pSDEList, bl);
        this.onFillEntityFullInfo_GroupPSDEUAGroup(pSDEList, bl);
        this.onFillEntityFullInfo_No2PSDEUAGroup(pSDEList, bl);
        this.onFillEntityFullInfo_PSDEUAGroup(pSDEList, bl);
        this.onFillEntityFullInfo_NavPSDEViewBase(pSDEList, bl);
        this.onFillEntityFullInfo_EmptyTextPSLanRes(pSDEList, bl);
        this.onFillEntityFullInfo_GroupPSSysCss(pSDEList, bl);
        this.onFillEntityFullInfo_ItemPSSysCss(pSDEList, bl);
        this.onFillEntityFullInfo_PSSysCss(pSDEList, bl);
        this.onFillEntityFullInfo_GroupPSSysPFPlugin(pSDEList, bl);
        this.onFillEntityFullInfo_ItemPSSysPFPlugin(pSDEList, bl);
        this.onFillEntityFullInfo_PSSysPFPlugin(pSDEList, bl);
        this.onFillEntityFullInfo_PSSysReqItem(pSDEList, bl);
        this.onFillEntityFullInfo_PSSysViewPanel(pSDEList, bl);
        this.onFillEntityFullInfo_PSViewMsgGroup(pSDEList, bl);
    }

    protected void onFillEntityFullInfo_PSACHandler(PSDEList pSDEList, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_GroupPSCodeList(PSDEList pSDEList, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_SwimlanePSCodeList(PSDEList pSDEList, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSCtrlLogicGroup(PSDEList pSDEList, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSCtrlMsg(PSDEList pSDEList, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_GroupPSDE(PSDEList pSDEList, boolean bl) throws Exception {
        if (pSDEList.isGroupPSDEIdDirty()) {
            if (pSDEList.getGroupPSDEId() != null) {
                if (pSDEList.getGroupPSDEId() == null || pSDEList.getGroupPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSDEList.getGroupPSDE();
                    pSDEList.setGroupPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSDEList.setGroupPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDE(PSDEList pSDEList, boolean bl) throws Exception {
        if (pSDEList.isPSDEIdDirty()) {
            if (pSDEList.getPSDEId() != null) {
                if (pSDEList.getPSDEId() == null || pSDEList.getPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSDEList.getPSDE();
                    pSDEList.setPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSDEList.setPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_CopyPSDEAction(PSDEList pSDEList, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_CreatePSDEAction(PSDEList pSDEList, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_GetDraftPSDEAction(PSDEList pSDEList, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_GetPSDEAction(PSDEList pSDEList, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_GroupMovePSDEAction(PSDEList pSDEList, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_MovePSDEAction(PSDEList pSDEList, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_RemovePSDEAction(PSDEList pSDEList, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_UpdatePSDEAction(PSDEList pSDEList, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_User2PSDEAction(PSDEList pSDEList, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_UserPSDEAction(PSDEList pSDEList, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_AsyncPSDEDS(PSDEList pSDEList, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEDS(PSDEList pSDEList, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_GroupPSDEF(PSDEList pSDEList, boolean bl) throws Exception {
        if (pSDEList.isGroupPSDEFIdDirty()) {
            if (pSDEList.getGroupPSDEFId() != null) {
                if (pSDEList.getGroupPSDEFId() == null || pSDEList.getGroupPSDEFName() == null) {
                    PSDEField pSDEField = pSDEList.getGroupPSDEF();
                    pSDEList.setGroupPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSDEList.setGroupPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_GroupTextPSDEF(PSDEList pSDEList, boolean bl) throws Exception {
        if (pSDEList.isGroupTextPSDEFIdDirty()) {
            if (pSDEList.getGroupTextPSDEFId() != null) {
                if (pSDEList.getGroupTextPSDEFId() == null || pSDEList.getGroupTextPSDEFName() == null) {
                    PSDEField pSDEField = pSDEList.getGroupTextPSDEF();
                    pSDEList.setGroupTextPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSDEList.setGroupTextPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_MinorSortPSDEF(PSDEList pSDEList, boolean bl) throws Exception {
        if (pSDEList.isMinorSortPSDEFIdDirty()) {
            if (pSDEList.getMinorSortPSDEFId() != null) {
                if (pSDEList.getMinorSortPSDEFId() == null || pSDEList.getMinorSortPSDEFName() == null) {
                    PSDEField pSDEField = pSDEList.getMinorSortPSDEF();
                    pSDEList.setMinorSortPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSDEList.setMinorSortPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_OrderValuePSDEF(PSDEList pSDEList, boolean bl) throws Exception {
        if (pSDEList.isOrderValuePSDEFIdDirty()) {
            if (pSDEList.getOrderValuePSDEFId() != null) {
                if (pSDEList.getOrderValuePSDEFId() == null || pSDEList.getOrderValuePSDEFName() == null) {
                    PSDEField pSDEField = pSDEList.getOrderValuePSDEF();
                    pSDEList.setOrderValuePSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSDEList.setOrderValuePSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_SwimlanePSDEF(PSDEList pSDEList, boolean bl) throws Exception {
        if (pSDEList.isSwimlanePSDEFIdDirty()) {
            if (pSDEList.getSwimlanePSDEFId() != null) {
                if (pSDEList.getSwimlanePSDEFId() == null || pSDEList.getSwimlanePSDEFName() == null) {
                    PSDEField pSDEField = pSDEList.getSwimlanePSDEF();
                    pSDEList.setSwimlanePSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSDEList.setSwimlanePSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_ADPSDELogic(PSDEList pSDEList, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_NavPSDER(PSDEList pSDEList, boolean bl) throws Exception {
        if (pSDEList.isNavPSDERIdDirty()) {
            if (pSDEList.getNavPSDERId() != null) {
                if (pSDEList.getNavPSDERId() == null || pSDEList.getNavPSDERName() == null) {
                    PSDER pSDER = pSDEList.getNavPSDER();
                    pSDEList.setNavPSDERName(pSDER.getPSDERName());
                }
            } else {
                pSDEList.setNavPSDERName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_BatPSDEToolbar(PSDEList pSDEList, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_QuickPSDEToolbar(PSDEList pSDEList, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_GroupPSDEUAGroup(PSDEList pSDEList, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_No2PSDEUAGroup(PSDEList pSDEList, boolean bl) throws Exception {
        if (pSDEList.isNo2PSDEUAGroupIdDirty()) {
            if (pSDEList.getNo2PSDEUAGroupId() != null) {
                if (pSDEList.getNo2PSDEUAGroupId() == null || pSDEList.getNo2PSDEUAGroupName() == null) {
                    PSDEUAGroup pSDEUAGroup = pSDEList.getNo2PSDEUAGroup();
                    pSDEList.setNo2PSDEUAGroupName(pSDEUAGroup.getPSDEUAGroupName());
                }
            } else {
                pSDEList.setNo2PSDEUAGroupName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDEUAGroup(PSDEList pSDEList, boolean bl) throws Exception {
        if (pSDEList.isPSDEUAGroupIdDirty()) {
            if (pSDEList.getPSDEUAGroupId() != null) {
                if (pSDEList.getPSDEUAGroupId() == null || pSDEList.getPSDEUAGroupName() == null) {
                    PSDEUAGroup pSDEUAGroup = pSDEList.getPSDEUAGroup();
                    pSDEList.setPSDEUAGroupName(pSDEUAGroup.getPSDEUAGroupName());
                }
            } else {
                pSDEList.setPSDEUAGroupName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_NavPSDEViewBase(PSDEList pSDEList, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_EmptyTextPSLanRes(PSDEList pSDEList, boolean bl) throws Exception {
        if (pSDEList.isEmptyTextPSLanResIdDirty()) {
            if (pSDEList.getEmptyTextPSLanResId() != null) {
                if (pSDEList.getEmptyTextPSLanResId() == null || pSDEList.getEmptyTextPSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSDEList.getEmptyTextPSLanRes();
                    pSDEList.setEmptyTextPSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSDEList.setEmptyTextPSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_GroupPSSysCss(PSDEList pSDEList, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_ItemPSSysCss(PSDEList pSDEList, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysCss(PSDEList pSDEList, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_GroupPSSysPFPlugin(PSDEList pSDEList, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_ItemPSSysPFPlugin(PSDEList pSDEList, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysPFPlugin(PSDEList pSDEList, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysReqItem(PSDEList pSDEList, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysViewPanel(PSDEList pSDEList, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSViewMsgGroup(PSDEList pSDEList, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDEList pSDEList, boolean bl) throws Exception {
        super.onWriteBackParent(pSDEList, bl);
    }

    public ArrayList<PSDEList> selectByPSACHandler(PSACHandlerBase pSACHandlerBase) throws Exception {
        return this.selectByPSACHandler(pSACHandlerBase, "", -1);
    }

    public ArrayList<PSDEList> selectByPSACHandler(PSACHandlerBase pSACHandlerBase, String string) throws Exception {
        return this.selectByPSACHandler(pSACHandlerBase, string, -1);
    }

    public ArrayList<PSDEList> selectByPSACHandler(PSACHandlerBase pSACHandlerBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEList> selectByGroupPSCodeList(PSCodeListBase pSCodeListBase) throws Exception {
        return this.selectByGroupPSCodeList(pSCodeListBase, "", -1);
    }

    public ArrayList<PSDEList> selectByGroupPSCodeList(PSCodeListBase pSCodeListBase, String string) throws Exception {
        return this.selectByGroupPSCodeList(pSCodeListBase, string, -1);
    }

    public ArrayList<PSDEList> selectByGroupPSCodeList(PSCodeListBase pSCodeListBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEList> selectBySwimlanePSCodeList(PSCodeListBase pSCodeListBase) throws Exception {
        return this.selectBySwimlanePSCodeList(pSCodeListBase, "", -1);
    }

    public ArrayList<PSDEList> selectBySwimlanePSCodeList(PSCodeListBase pSCodeListBase, String string) throws Exception {
        return this.selectBySwimlanePSCodeList(pSCodeListBase, string, -1);
    }

    public ArrayList<PSDEList> selectBySwimlanePSCodeList(PSCodeListBase pSCodeListBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("SWIMLANEPSCODELISTID", (Object)pSCodeListBase.getPSCodeListId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectBySwimlanePSCodeListCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectBySwimlanePSCodeListCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEList> selectByPSCtrlLogicGroup(PSCtrlLogicGroupBase pSCtrlLogicGroupBase) throws Exception {
        return this.selectByPSCtrlLogicGroup(pSCtrlLogicGroupBase, "", -1);
    }

    public ArrayList<PSDEList> selectByPSCtrlLogicGroup(PSCtrlLogicGroupBase pSCtrlLogicGroupBase, String string) throws Exception {
        return this.selectByPSCtrlLogicGroup(pSCtrlLogicGroupBase, string, -1);
    }

    public ArrayList<PSDEList> selectByPSCtrlLogicGroup(PSCtrlLogicGroupBase pSCtrlLogicGroupBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEList> selectByPSCtrlMsg(PSCtrlMsgBase pSCtrlMsgBase) throws Exception {
        return this.selectByPSCtrlMsg(pSCtrlMsgBase, "", -1);
    }

    public ArrayList<PSDEList> selectByPSCtrlMsg(PSCtrlMsgBase pSCtrlMsgBase, String string) throws Exception {
        return this.selectByPSCtrlMsg(pSCtrlMsgBase, string, -1);
    }

    public ArrayList<PSDEList> selectByPSCtrlMsg(PSCtrlMsgBase pSCtrlMsgBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEList> selectByGroupPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByGroupPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSDEList> selectByGroupPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByGroupPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSDEList> selectByGroupPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("GROUPPSDEID", (Object)pSDataEntityBase.getPSDataEntityId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByGroupPSDECond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByGroupPSDECond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEList> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSDEList> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSDEList> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEList> selectByCopyPSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByCopyPSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSDEList> selectByCopyPSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByCopyPSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSDEList> selectByCopyPSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEList> selectByCreatePSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByCreatePSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSDEList> selectByCreatePSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByCreatePSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSDEList> selectByCreatePSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEList> selectByGetDraftPSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByGetDraftPSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSDEList> selectByGetDraftPSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByGetDraftPSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSDEList> selectByGetDraftPSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEList> selectByGetPSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByGetPSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSDEList> selectByGetPSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByGetPSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSDEList> selectByGetPSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEList> selectByGroupMovePSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByGroupMovePSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSDEList> selectByGroupMovePSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByGroupMovePSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSDEList> selectByGroupMovePSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("GROUPMOVEPSDEACTIONID", (Object)pSDEActionBase.getPSDEActionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByGroupMovePSDEActionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByGroupMovePSDEActionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEList> selectByMovePSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByMovePSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSDEList> selectByMovePSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByMovePSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSDEList> selectByMovePSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("MOVEPSDEACTIONID", (Object)pSDEActionBase.getPSDEActionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByMovePSDEActionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByMovePSDEActionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEList> selectByRemovePSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByRemovePSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSDEList> selectByRemovePSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByRemovePSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSDEList> selectByRemovePSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEList> selectByUpdatePSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByUpdatePSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSDEList> selectByUpdatePSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByUpdatePSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSDEList> selectByUpdatePSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEList> selectByUser2PSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByUser2PSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSDEList> selectByUser2PSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByUser2PSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSDEList> selectByUser2PSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEList> selectByUserPSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByUserPSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSDEList> selectByUserPSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByUserPSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSDEList> selectByUserPSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEList> selectByAsyncPSDEDS(PSDEDataSetBase pSDEDataSetBase) throws Exception {
        return this.selectByAsyncPSDEDS(pSDEDataSetBase, "", -1);
    }

    public ArrayList<PSDEList> selectByAsyncPSDEDS(PSDEDataSetBase pSDEDataSetBase, String string) throws Exception {
        return this.selectByAsyncPSDEDS(pSDEDataSetBase, string, -1);
    }

    public ArrayList<PSDEList> selectByAsyncPSDEDS(PSDEDataSetBase pSDEDataSetBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("ASYNCPSDEDSID", (Object)pSDEDataSetBase.getPSDEDataSetId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByAsyncPSDEDSCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByAsyncPSDEDSCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEList> selectByPSDEDS(PSDEDataSetBase pSDEDataSetBase) throws Exception {
        return this.selectByPSDEDS(pSDEDataSetBase, "", -1);
    }

    public ArrayList<PSDEList> selectByPSDEDS(PSDEDataSetBase pSDEDataSetBase, String string) throws Exception {
        return this.selectByPSDEDS(pSDEDataSetBase, string, -1);
    }

    public ArrayList<PSDEList> selectByPSDEDS(PSDEDataSetBase pSDEDataSetBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEList> selectByGroupPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByGroupPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSDEList> selectByGroupPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByGroupPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSDEList> selectByGroupPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("GROUPPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByGroupPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByGroupPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEList> selectByGroupTextPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByGroupTextPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSDEList> selectByGroupTextPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByGroupTextPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSDEList> selectByGroupTextPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("GROUPTEXTPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByGroupTextPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByGroupTextPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEList> selectByMinorSortPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByMinorSortPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSDEList> selectByMinorSortPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByMinorSortPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSDEList> selectByMinorSortPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEList> selectByOrderValuePSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByOrderValuePSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSDEList> selectByOrderValuePSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByOrderValuePSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSDEList> selectByOrderValuePSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("ORDERVALUEPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByOrderValuePSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByOrderValuePSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEList> selectBySwimlanePSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectBySwimlanePSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSDEList> selectBySwimlanePSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectBySwimlanePSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSDEList> selectBySwimlanePSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("SWIMLANEPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectBySwimlanePSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectBySwimlanePSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEList> selectByADPSDELogic(PSDELogicBase pSDELogicBase) throws Exception {
        return this.selectByADPSDELogic(pSDELogicBase, "", -1);
    }

    public ArrayList<PSDEList> selectByADPSDELogic(PSDELogicBase pSDELogicBase, String string) throws Exception {
        return this.selectByADPSDELogic(pSDELogicBase, string, -1);
    }

    public ArrayList<PSDEList> selectByADPSDELogic(PSDELogicBase pSDELogicBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEList> selectByNavPSDER(PSDERBase pSDERBase) throws Exception {
        return this.selectByNavPSDER(pSDERBase, "", -1);
    }

    public ArrayList<PSDEList> selectByNavPSDER(PSDERBase pSDERBase, String string) throws Exception {
        return this.selectByNavPSDER(pSDERBase, string, -1);
    }

    public ArrayList<PSDEList> selectByNavPSDER(PSDERBase pSDERBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("NAVPSDERID", (Object)pSDERBase.getPSDERId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByNavPSDERCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByNavPSDERCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEList> selectByBatPSDEToolbar(PSDEToolbarBase pSDEToolbarBase) throws Exception {
        return this.selectByBatPSDEToolbar(pSDEToolbarBase, "", -1);
    }

    public ArrayList<PSDEList> selectByBatPSDEToolbar(PSDEToolbarBase pSDEToolbarBase, String string) throws Exception {
        return this.selectByBatPSDEToolbar(pSDEToolbarBase, string, -1);
    }

    public ArrayList<PSDEList> selectByBatPSDEToolbar(PSDEToolbarBase pSDEToolbarBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("BATPSDETOOLBARID", (Object)pSDEToolbarBase.getPSDEToolbarId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByBatPSDEToolbarCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByBatPSDEToolbarCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEList> selectByQuickPSDEToolbar(PSDEToolbarBase pSDEToolbarBase) throws Exception {
        return this.selectByQuickPSDEToolbar(pSDEToolbarBase, "", -1);
    }

    public ArrayList<PSDEList> selectByQuickPSDEToolbar(PSDEToolbarBase pSDEToolbarBase, String string) throws Exception {
        return this.selectByQuickPSDEToolbar(pSDEToolbarBase, string, -1);
    }

    public ArrayList<PSDEList> selectByQuickPSDEToolbar(PSDEToolbarBase pSDEToolbarBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("QUICKPSDETOOLBARID", (Object)pSDEToolbarBase.getPSDEToolbarId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByQuickPSDEToolbarCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByQuickPSDEToolbarCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEList> selectByGroupPSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase) throws Exception {
        return this.selectByGroupPSDEUAGroup(pSDEUAGroupBase, "", -1);
    }

    public ArrayList<PSDEList> selectByGroupPSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase, String string) throws Exception {
        return this.selectByGroupPSDEUAGroup(pSDEUAGroupBase, string, -1);
    }

    public ArrayList<PSDEList> selectByGroupPSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("GROUPPSDEUAGROUPID", (Object)pSDEUAGroupBase.getPSDEUAGroupId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByGroupPSDEUAGroupCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByGroupPSDEUAGroupCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEList> selectByNo2PSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase) throws Exception {
        return this.selectByNo2PSDEUAGroup(pSDEUAGroupBase, "", -1);
    }

    public ArrayList<PSDEList> selectByNo2PSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase, String string) throws Exception {
        return this.selectByNo2PSDEUAGroup(pSDEUAGroupBase, string, -1);
    }

    public ArrayList<PSDEList> selectByNo2PSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("NO2PSDEUAGROUPID", (Object)pSDEUAGroupBase.getPSDEUAGroupId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByNo2PSDEUAGroupCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByNo2PSDEUAGroupCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEList> selectByPSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase) throws Exception {
        return this.selectByPSDEUAGroup(pSDEUAGroupBase, "", -1);
    }

    public ArrayList<PSDEList> selectByPSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase, String string) throws Exception {
        return this.selectByPSDEUAGroup(pSDEUAGroupBase, string, -1);
    }

    public ArrayList<PSDEList> selectByPSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEList> selectByNavPSDEViewBase(PSDEViewBaseBase pSDEViewBaseBase) throws Exception {
        return this.selectByNavPSDEViewBase(pSDEViewBaseBase, "", -1);
    }

    public ArrayList<PSDEList> selectByNavPSDEViewBase(PSDEViewBaseBase pSDEViewBaseBase, String string) throws Exception {
        return this.selectByNavPSDEViewBase(pSDEViewBaseBase, string, -1);
    }

    public ArrayList<PSDEList> selectByNavPSDEViewBase(PSDEViewBaseBase pSDEViewBaseBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("NAVPSDEVIEWBASEID", (Object)pSDEViewBaseBase.getPSDEViewBaseId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByNavPSDEViewBaseCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByNavPSDEViewBaseCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEList> selectByEmptyTextPSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByEmptyTextPSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSDEList> selectByEmptyTextPSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByEmptyTextPSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSDEList> selectByEmptyTextPSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEList> selectByGroupPSSysCss(PSSysCssBase pSSysCssBase) throws Exception {
        return this.selectByGroupPSSysCss(pSSysCssBase, "", -1);
    }

    public ArrayList<PSDEList> selectByGroupPSSysCss(PSSysCssBase pSSysCssBase, String string) throws Exception {
        return this.selectByGroupPSSysCss(pSSysCssBase, string, -1);
    }

    public ArrayList<PSDEList> selectByGroupPSSysCss(PSSysCssBase pSSysCssBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("GROUPPSSYSCSSID", (Object)pSSysCssBase.getPSSysCssId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByGroupPSSysCssCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByGroupPSSysCssCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEList> selectByItemPSSysCss(PSSysCssBase pSSysCssBase) throws Exception {
        return this.selectByItemPSSysCss(pSSysCssBase, "", -1);
    }

    public ArrayList<PSDEList> selectByItemPSSysCss(PSSysCssBase pSSysCssBase, String string) throws Exception {
        return this.selectByItemPSSysCss(pSSysCssBase, string, -1);
    }

    public ArrayList<PSDEList> selectByItemPSSysCss(PSSysCssBase pSSysCssBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("ITEMPSSYSCSSID", (Object)pSSysCssBase.getPSSysCssId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByItemPSSysCssCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByItemPSSysCssCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEList> selectByPSSysCss(PSSysCssBase pSSysCssBase) throws Exception {
        return this.selectByPSSysCss(pSSysCssBase, "", -1);
    }

    public ArrayList<PSDEList> selectByPSSysCss(PSSysCssBase pSSysCssBase, String string) throws Exception {
        return this.selectByPSSysCss(pSSysCssBase, string, -1);
    }

    public ArrayList<PSDEList> selectByPSSysCss(PSSysCssBase pSSysCssBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEList> selectByGroupPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase) throws Exception {
        return this.selectByGroupPSSysPFPlugin(pSSysPFPluginBase, "", -1);
    }

    public ArrayList<PSDEList> selectByGroupPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string) throws Exception {
        return this.selectByGroupPSSysPFPlugin(pSSysPFPluginBase, string, -1);
    }

    public ArrayList<PSDEList> selectByGroupPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("GROUPPSSYSPFPLUGINID", (Object)pSSysPFPluginBase.getPSSysPFPluginId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByGroupPSSysPFPluginCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByGroupPSSysPFPluginCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEList> selectByItemPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase) throws Exception {
        return this.selectByItemPSSysPFPlugin(pSSysPFPluginBase, "", -1);
    }

    public ArrayList<PSDEList> selectByItemPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string) throws Exception {
        return this.selectByItemPSSysPFPlugin(pSSysPFPluginBase, string, -1);
    }

    public ArrayList<PSDEList> selectByItemPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("ITEMPSSYSPFPLUGINID", (Object)pSSysPFPluginBase.getPSSysPFPluginId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByItemPSSysPFPluginCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByItemPSSysPFPluginCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEList> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, "", -1);
    }

    public ArrayList<PSDEList> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, string, -1);
    }

    public ArrayList<PSDEList> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEList> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase) throws Exception {
        return this.selectByPSSysReqItem(pSSysReqItemBase, "", -1);
    }

    public ArrayList<PSDEList> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase, String string) throws Exception {
        return this.selectByPSSysReqItem(pSSysReqItemBase, string, -1);
    }

    public ArrayList<PSDEList> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEList> selectByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase) throws Exception {
        return this.selectByPSSysViewPanel(pSSysViewPanelBase, "", -1);
    }

    public ArrayList<PSDEList> selectByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase, String string) throws Exception {
        return this.selectByPSSysViewPanel(pSSysViewPanelBase, string, -1);
    }

    public ArrayList<PSDEList> selectByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEList> selectByPSViewMsgGroup(PSViewMsgGroupBase pSViewMsgGroupBase) throws Exception {
        return this.selectByPSViewMsgGroup(pSViewMsgGroupBase, "", -1);
    }

    public ArrayList<PSDEList> selectByPSViewMsgGroup(PSViewMsgGroupBase pSViewMsgGroupBase, String string) throws Exception {
        return this.selectByPSViewMsgGroup(pSViewMsgGroupBase, string, -1);
    }

    public ArrayList<PSDEList> selectByPSViewMsgGroup(PSViewMsgGroupBase pSViewMsgGroupBase, String string, int n) throws Exception {
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
        ArrayList<PSDEList> arrayList = this.selectByPSACHandler(pSACHandler, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSACHANDLER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSACHandler);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELIST_PSACHANDLER_PSACHANDLERID", "", iDataEntityModel.getName(), "PSDELIST", iDataEntityModel.getDataInfo(pSACHandler), arrayList.get(0)));
        }
    }

    public void resetPSACHandler(PSACHandler pSACHandler) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByPSACHandler(pSACHandler);
        for (PSDEList pSDEList : arrayList) {
            PSDEList pSDEList2 = (PSDEList)this.getDEModel().createEntity();
            pSDEList2.setPSDEListId(pSDEList.getPSDEListId());
            pSDEList2.setPSACHandlerId(null);
            this.update(pSDEList2);
        }
    }

    public void removeByPSACHandler(PSACHandler pSACHandler) throws Exception {
        final PSACHandler pSACHandler2 = pSACHandler;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEListServiceBase.this.onBeforeRemoveByPSACHandler(pSACHandler2);
                PSDEListServiceBase.this.internalRemoveByPSACHandler(pSACHandler2);
                PSDEListServiceBase.this.onAfterRemoveByPSACHandler(pSACHandler2);
            }
        });
    }

    protected void onBeforeRemoveByPSACHandler(PSACHandler pSACHandler) throws Exception {
    }

    protected void internalRemoveByPSACHandler(PSACHandler pSACHandler) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByPSACHandler(pSACHandler);
        this.onBeforeRemoveByPSACHandler(pSACHandler, arrayList);
        for (PSDEList pSDEList : arrayList) {
            this.remove(pSDEList);
        }
        this.onAfterRemoveByPSACHandler(pSACHandler, arrayList);
    }

    protected void onAfterRemoveByPSACHandler(PSACHandler pSACHandler) throws Exception {
    }

    protected void onBeforeRemoveByPSACHandler(PSACHandler pSACHandler, ArrayList<PSDEList> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSACHandler(PSACHandler pSACHandler, ArrayList<PSDEList> arrayList) throws Exception {
    }

    public void testRemoveByGroupPSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByGroupPSCodeList(pSCodeList, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSCODELIST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSCodeList);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELIST_PSCODELIST_GROUPPSCODELISTID", "", iDataEntityModel.getName(), "PSDELIST", iDataEntityModel.getDataInfo(pSCodeList), arrayList.get(0)));
        }
    }

    public void resetGroupPSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByGroupPSCodeList(pSCodeList);
        for (PSDEList pSDEList : arrayList) {
            PSDEList pSDEList2 = (PSDEList)this.getDEModel().createEntity();
            pSDEList2.setPSDEListId(pSDEList.getPSDEListId());
            pSDEList2.setGroupPSCodeListId(null);
            this.update(pSDEList2);
        }
    }

    public void removeByGroupPSCodeList(PSCodeList pSCodeList) throws Exception {
        final PSCodeList pSCodeList2 = pSCodeList;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEListServiceBase.this.onBeforeRemoveByGroupPSCodeList(pSCodeList2);
                PSDEListServiceBase.this.internalRemoveByGroupPSCodeList(pSCodeList2);
                PSDEListServiceBase.this.onAfterRemoveByGroupPSCodeList(pSCodeList2);
            }
        });
    }

    protected void onBeforeRemoveByGroupPSCodeList(PSCodeList pSCodeList) throws Exception {
    }

    protected void internalRemoveByGroupPSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByGroupPSCodeList(pSCodeList);
        this.onBeforeRemoveByGroupPSCodeList(pSCodeList, arrayList);
        for (PSDEList pSDEList : arrayList) {
            this.remove(pSDEList);
        }
        this.onAfterRemoveByGroupPSCodeList(pSCodeList, arrayList);
    }

    protected void onAfterRemoveByGroupPSCodeList(PSCodeList pSCodeList) throws Exception {
    }

    protected void onBeforeRemoveByGroupPSCodeList(PSCodeList pSCodeList, ArrayList<PSDEList> arrayList) throws Exception {
    }

    protected void onAfterRemoveByGroupPSCodeList(PSCodeList pSCodeList, ArrayList<PSDEList> arrayList) throws Exception {
    }

    public void testRemoveBySwimlanePSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectBySwimlanePSCodeList(pSCodeList, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSCODELIST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSCodeList);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELIST_PSCODELIST_SWIMLANEPSCODELISTID", "", iDataEntityModel.getName(), "PSDELIST", iDataEntityModel.getDataInfo(pSCodeList), arrayList.get(0)));
        }
    }

    public void resetSwimlanePSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectBySwimlanePSCodeList(pSCodeList);
        for (PSDEList pSDEList : arrayList) {
            PSDEList pSDEList2 = (PSDEList)this.getDEModel().createEntity();
            pSDEList2.setPSDEListId(pSDEList.getPSDEListId());
            pSDEList2.setSwimlanePSCodeListId(null);
            this.update(pSDEList2);
        }
    }

    public void removeBySwimlanePSCodeList(PSCodeList pSCodeList) throws Exception {
        final PSCodeList pSCodeList2 = pSCodeList;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEListServiceBase.this.onBeforeRemoveBySwimlanePSCodeList(pSCodeList2);
                PSDEListServiceBase.this.internalRemoveBySwimlanePSCodeList(pSCodeList2);
                PSDEListServiceBase.this.onAfterRemoveBySwimlanePSCodeList(pSCodeList2);
            }
        });
    }

    protected void onBeforeRemoveBySwimlanePSCodeList(PSCodeList pSCodeList) throws Exception {
    }

    protected void internalRemoveBySwimlanePSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectBySwimlanePSCodeList(pSCodeList);
        this.onBeforeRemoveBySwimlanePSCodeList(pSCodeList, arrayList);
        for (PSDEList pSDEList : arrayList) {
            this.remove(pSDEList);
        }
        this.onAfterRemoveBySwimlanePSCodeList(pSCodeList, arrayList);
    }

    protected void onAfterRemoveBySwimlanePSCodeList(PSCodeList pSCodeList) throws Exception {
    }

    protected void onBeforeRemoveBySwimlanePSCodeList(PSCodeList pSCodeList, ArrayList<PSDEList> arrayList) throws Exception {
    }

    protected void onAfterRemoveBySwimlanePSCodeList(PSCodeList pSCodeList, ArrayList<PSDEList> arrayList) throws Exception {
    }

    public void testRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByPSCtrlLogicGroup(pSCtrlLogicGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSCTRLLOGICGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSCtrlLogicGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELIST_PSCTRLLOGICGROUP_PSCTRLLOGICGROUPID", "", iDataEntityModel.getName(), "PSDELIST", iDataEntityModel.getDataInfo(pSCtrlLogicGroup), arrayList.get(0)));
        }
    }

    public void resetPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByPSCtrlLogicGroup(pSCtrlLogicGroup);
        for (PSDEList pSDEList : arrayList) {
            PSDEList pSDEList2 = (PSDEList)this.getDEModel().createEntity();
            pSDEList2.setPSDEListId(pSDEList.getPSDEListId());
            pSDEList2.setPSCtrlLogicGroupId(null);
            this.update(pSDEList2);
        }
    }

    public void removeByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        final PSCtrlLogicGroup pSCtrlLogicGroup2 = pSCtrlLogicGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEListServiceBase.this.onBeforeRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup2);
                PSDEListServiceBase.this.internalRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup2);
                PSDEListServiceBase.this.onAfterRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup2);
            }
        });
    }

    protected void onBeforeRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
    }

    protected void internalRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByPSCtrlLogicGroup(pSCtrlLogicGroup);
        this.onBeforeRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup, arrayList);
        for (PSDEList pSDEList : arrayList) {
            this.remove(pSDEList);
        }
        this.onAfterRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup, arrayList);
    }

    protected void onAfterRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
    }

    protected void onBeforeRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup, ArrayList<PSDEList> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup, ArrayList<PSDEList> arrayList) throws Exception {
    }

    public void testRemoveByPSCtrlMsg(PSCtrlMsg pSCtrlMsg) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByPSCtrlMsg(pSCtrlMsg, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSCTRLMSG");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSCtrlMsg);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELIST_PSCTRLMSG_PSCTRLMSGID", "", iDataEntityModel.getName(), "PSDELIST", iDataEntityModel.getDataInfo(pSCtrlMsg), arrayList.get(0)));
        }
    }

    public void resetPSCtrlMsg(PSCtrlMsg pSCtrlMsg) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByPSCtrlMsg(pSCtrlMsg);
        for (PSDEList pSDEList : arrayList) {
            PSDEList pSDEList2 = (PSDEList)this.getDEModel().createEntity();
            pSDEList2.setPSDEListId(pSDEList.getPSDEListId());
            pSDEList2.setPSCtrlMsgId(null);
            this.update(pSDEList2);
        }
    }

    public void removeByPSCtrlMsg(PSCtrlMsg pSCtrlMsg) throws Exception {
        final PSCtrlMsg pSCtrlMsg2 = pSCtrlMsg;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEListServiceBase.this.onBeforeRemoveByPSCtrlMsg(pSCtrlMsg2);
                PSDEListServiceBase.this.internalRemoveByPSCtrlMsg(pSCtrlMsg2);
                PSDEListServiceBase.this.onAfterRemoveByPSCtrlMsg(pSCtrlMsg2);
            }
        });
    }

    protected void onBeforeRemoveByPSCtrlMsg(PSCtrlMsg pSCtrlMsg) throws Exception {
    }

    protected void internalRemoveByPSCtrlMsg(PSCtrlMsg pSCtrlMsg) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByPSCtrlMsg(pSCtrlMsg);
        this.onBeforeRemoveByPSCtrlMsg(pSCtrlMsg, arrayList);
        for (PSDEList pSDEList : arrayList) {
            this.remove(pSDEList);
        }
        this.onAfterRemoveByPSCtrlMsg(pSCtrlMsg, arrayList);
    }

    protected void onAfterRemoveByPSCtrlMsg(PSCtrlMsg pSCtrlMsg) throws Exception {
    }

    protected void onBeforeRemoveByPSCtrlMsg(PSCtrlMsg pSCtrlMsg, ArrayList<PSDEList> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSCtrlMsg(PSCtrlMsg pSCtrlMsg, ArrayList<PSDEList> arrayList) throws Exception {
    }

    public void testRemoveByGroupPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByGroupPSDE(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELIST_PSDATAENTITY_GROUPPSDEID", "", iDataEntityModel.getName(), "PSDELIST", iDataEntityModel.getDataInfo(pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetGroupPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByGroupPSDE(pSDataEntity);
        for (PSDEList pSDEList : arrayList) {
            PSDEList pSDEList2 = (PSDEList)this.getDEModel().createEntity();
            pSDEList2.setPSDEListId(pSDEList.getPSDEListId());
            pSDEList2.setGroupPSDEId(null);
            this.update(pSDEList2);
        }
    }

    public void removeByGroupPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEListServiceBase.this.onBeforeRemoveByGroupPSDE(pSDataEntity2);
                PSDEListServiceBase.this.internalRemoveByGroupPSDE(pSDataEntity2);
                PSDEListServiceBase.this.onAfterRemoveByGroupPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByGroupPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByGroupPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByGroupPSDE(pSDataEntity);
        this.onBeforeRemoveByGroupPSDE(pSDataEntity, arrayList);
        for (PSDEList pSDEList : arrayList) {
            this.remove(pSDEList);
        }
        this.onAfterRemoveByGroupPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByGroupPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByGroupPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEList> arrayList) throws Exception {
    }

    protected void onAfterRemoveByGroupPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEList> arrayList) throws Exception {
    }

    public void testRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSDEList pSDEList : arrayList) {
            PSDEList pSDEList2 = (PSDEList)this.getDEModel().createEntity();
            pSDEList2.setPSDEListId(pSDEList.getPSDEListId());
            pSDEList2.setPSDEId(null);
            this.update(pSDEList2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEListServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSDEListServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSDEListServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSDEList pSDEList : arrayList) {
            this.remove(pSDEList);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEList> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEList> arrayList) throws Exception {
    }

    public void testRemoveByCopyPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByCopyPSDEAction(pSDEAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELIST_PSDEACTION_COPYPSDEACTIONID", "", iDataEntityModel.getName(), "PSDELIST", iDataEntityModel.getDataInfo(pSDEAction), arrayList.get(0)));
        }
    }

    public void resetCopyPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByCopyPSDEAction(pSDEAction);
        for (PSDEList pSDEList : arrayList) {
            PSDEList pSDEList2 = (PSDEList)this.getDEModel().createEntity();
            pSDEList2.setPSDEListId(pSDEList.getPSDEListId());
            pSDEList2.setCopyPSDEActionId(null);
            this.update(pSDEList2);
        }
    }

    public void removeByCopyPSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEListServiceBase.this.onBeforeRemoveByCopyPSDEAction(pSDEAction2);
                PSDEListServiceBase.this.internalRemoveByCopyPSDEAction(pSDEAction2);
                PSDEListServiceBase.this.onAfterRemoveByCopyPSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByCopyPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByCopyPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByCopyPSDEAction(pSDEAction);
        this.onBeforeRemoveByCopyPSDEAction(pSDEAction, arrayList);
        for (PSDEList pSDEList : arrayList) {
            this.remove(pSDEList);
        }
        this.onAfterRemoveByCopyPSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByCopyPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByCopyPSDEAction(PSDEAction pSDEAction, ArrayList<PSDEList> arrayList) throws Exception {
    }

    protected void onAfterRemoveByCopyPSDEAction(PSDEAction pSDEAction, ArrayList<PSDEList> arrayList) throws Exception {
    }

    public void testRemoveByCreatePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByCreatePSDEAction(pSDEAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELIST_PSDEACTION_CREATEPSDEACTIONID", "", iDataEntityModel.getName(), "PSDELIST", iDataEntityModel.getDataInfo(pSDEAction), arrayList.get(0)));
        }
    }

    public void resetCreatePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByCreatePSDEAction(pSDEAction);
        for (PSDEList pSDEList : arrayList) {
            PSDEList pSDEList2 = (PSDEList)this.getDEModel().createEntity();
            pSDEList2.setPSDEListId(pSDEList.getPSDEListId());
            pSDEList2.setCreatePSDEActionId(null);
            this.update(pSDEList2);
        }
    }

    public void removeByCreatePSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEListServiceBase.this.onBeforeRemoveByCreatePSDEAction(pSDEAction2);
                PSDEListServiceBase.this.internalRemoveByCreatePSDEAction(pSDEAction2);
                PSDEListServiceBase.this.onAfterRemoveByCreatePSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByCreatePSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByCreatePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByCreatePSDEAction(pSDEAction);
        this.onBeforeRemoveByCreatePSDEAction(pSDEAction, arrayList);
        for (PSDEList pSDEList : arrayList) {
            this.remove(pSDEList);
        }
        this.onAfterRemoveByCreatePSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByCreatePSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByCreatePSDEAction(PSDEAction pSDEAction, ArrayList<PSDEList> arrayList) throws Exception {
    }

    protected void onAfterRemoveByCreatePSDEAction(PSDEAction pSDEAction, ArrayList<PSDEList> arrayList) throws Exception {
    }

    public void testRemoveByGetDraftPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByGetDraftPSDEAction(pSDEAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELIST_PSDEACTION_GETDRAFTPSDEACTIONID", "", iDataEntityModel.getName(), "PSDELIST", iDataEntityModel.getDataInfo(pSDEAction), arrayList.get(0)));
        }
    }

    public void resetGetDraftPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByGetDraftPSDEAction(pSDEAction);
        for (PSDEList pSDEList : arrayList) {
            PSDEList pSDEList2 = (PSDEList)this.getDEModel().createEntity();
            pSDEList2.setPSDEListId(pSDEList.getPSDEListId());
            pSDEList2.setGetDraftPSDEActionId(null);
            this.update(pSDEList2);
        }
    }

    public void removeByGetDraftPSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEListServiceBase.this.onBeforeRemoveByGetDraftPSDEAction(pSDEAction2);
                PSDEListServiceBase.this.internalRemoveByGetDraftPSDEAction(pSDEAction2);
                PSDEListServiceBase.this.onAfterRemoveByGetDraftPSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByGetDraftPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByGetDraftPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByGetDraftPSDEAction(pSDEAction);
        this.onBeforeRemoveByGetDraftPSDEAction(pSDEAction, arrayList);
        for (PSDEList pSDEList : arrayList) {
            this.remove(pSDEList);
        }
        this.onAfterRemoveByGetDraftPSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByGetDraftPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByGetDraftPSDEAction(PSDEAction pSDEAction, ArrayList<PSDEList> arrayList) throws Exception {
    }

    protected void onAfterRemoveByGetDraftPSDEAction(PSDEAction pSDEAction, ArrayList<PSDEList> arrayList) throws Exception {
    }

    public void testRemoveByGetPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByGetPSDEAction(pSDEAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELIST_PSDEACTION_GETPSDEACTIONID", "", iDataEntityModel.getName(), "PSDELIST", iDataEntityModel.getDataInfo(pSDEAction), arrayList.get(0)));
        }
    }

    public void resetGetPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByGetPSDEAction(pSDEAction);
        for (PSDEList pSDEList : arrayList) {
            PSDEList pSDEList2 = (PSDEList)this.getDEModel().createEntity();
            pSDEList2.setPSDEListId(pSDEList.getPSDEListId());
            pSDEList2.setGetPSDEActionId(null);
            this.update(pSDEList2);
        }
    }

    public void removeByGetPSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEListServiceBase.this.onBeforeRemoveByGetPSDEAction(pSDEAction2);
                PSDEListServiceBase.this.internalRemoveByGetPSDEAction(pSDEAction2);
                PSDEListServiceBase.this.onAfterRemoveByGetPSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByGetPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByGetPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByGetPSDEAction(pSDEAction);
        this.onBeforeRemoveByGetPSDEAction(pSDEAction, arrayList);
        for (PSDEList pSDEList : arrayList) {
            this.remove(pSDEList);
        }
        this.onAfterRemoveByGetPSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByGetPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByGetPSDEAction(PSDEAction pSDEAction, ArrayList<PSDEList> arrayList) throws Exception {
    }

    protected void onAfterRemoveByGetPSDEAction(PSDEAction pSDEAction, ArrayList<PSDEList> arrayList) throws Exception {
    }

    public void testRemoveByGroupMovePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByGroupMovePSDEAction(pSDEAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELIST_PSDEACTION_GROUPMOVEPSDEACTIONID", "", iDataEntityModel.getName(), "PSDELIST", iDataEntityModel.getDataInfo(pSDEAction), arrayList.get(0)));
        }
    }

    public void resetGroupMovePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByGroupMovePSDEAction(pSDEAction);
        for (PSDEList pSDEList : arrayList) {
            PSDEList pSDEList2 = (PSDEList)this.getDEModel().createEntity();
            pSDEList2.setPSDEListId(pSDEList.getPSDEListId());
            pSDEList2.setGroupMovePSDEActionId(null);
            this.update(pSDEList2);
        }
    }

    public void removeByGroupMovePSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEListServiceBase.this.onBeforeRemoveByGroupMovePSDEAction(pSDEAction2);
                PSDEListServiceBase.this.internalRemoveByGroupMovePSDEAction(pSDEAction2);
                PSDEListServiceBase.this.onAfterRemoveByGroupMovePSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByGroupMovePSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByGroupMovePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByGroupMovePSDEAction(pSDEAction);
        this.onBeforeRemoveByGroupMovePSDEAction(pSDEAction, arrayList);
        for (PSDEList pSDEList : arrayList) {
            this.remove(pSDEList);
        }
        this.onAfterRemoveByGroupMovePSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByGroupMovePSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByGroupMovePSDEAction(PSDEAction pSDEAction, ArrayList<PSDEList> arrayList) throws Exception {
    }

    protected void onAfterRemoveByGroupMovePSDEAction(PSDEAction pSDEAction, ArrayList<PSDEList> arrayList) throws Exception {
    }

    public void testRemoveByMovePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByMovePSDEAction(pSDEAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELIST_PSDEACTION_MOVEPSDEACTIONID", "", iDataEntityModel.getName(), "PSDELIST", iDataEntityModel.getDataInfo(pSDEAction), arrayList.get(0)));
        }
    }

    public void resetMovePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByMovePSDEAction(pSDEAction);
        for (PSDEList pSDEList : arrayList) {
            PSDEList pSDEList2 = (PSDEList)this.getDEModel().createEntity();
            pSDEList2.setPSDEListId(pSDEList.getPSDEListId());
            pSDEList2.setMovePSDEActionId(null);
            this.update(pSDEList2);
        }
    }

    public void removeByMovePSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEListServiceBase.this.onBeforeRemoveByMovePSDEAction(pSDEAction2);
                PSDEListServiceBase.this.internalRemoveByMovePSDEAction(pSDEAction2);
                PSDEListServiceBase.this.onAfterRemoveByMovePSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByMovePSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByMovePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByMovePSDEAction(pSDEAction);
        this.onBeforeRemoveByMovePSDEAction(pSDEAction, arrayList);
        for (PSDEList pSDEList : arrayList) {
            this.remove(pSDEList);
        }
        this.onAfterRemoveByMovePSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByMovePSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByMovePSDEAction(PSDEAction pSDEAction, ArrayList<PSDEList> arrayList) throws Exception {
    }

    protected void onAfterRemoveByMovePSDEAction(PSDEAction pSDEAction, ArrayList<PSDEList> arrayList) throws Exception {
    }

    public void testRemoveByRemovePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByRemovePSDEAction(pSDEAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELIST_PSDEACTION_REMOVEPSDEACTIONID", "", iDataEntityModel.getName(), "PSDELIST", iDataEntityModel.getDataInfo(pSDEAction), arrayList.get(0)));
        }
    }

    public void resetRemovePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByRemovePSDEAction(pSDEAction);
        for (PSDEList pSDEList : arrayList) {
            PSDEList pSDEList2 = (PSDEList)this.getDEModel().createEntity();
            pSDEList2.setPSDEListId(pSDEList.getPSDEListId());
            pSDEList2.setRemovePSDEActionId(null);
            this.update(pSDEList2);
        }
    }

    public void removeByRemovePSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEListServiceBase.this.onBeforeRemoveByRemovePSDEAction(pSDEAction2);
                PSDEListServiceBase.this.internalRemoveByRemovePSDEAction(pSDEAction2);
                PSDEListServiceBase.this.onAfterRemoveByRemovePSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByRemovePSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByRemovePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByRemovePSDEAction(pSDEAction);
        this.onBeforeRemoveByRemovePSDEAction(pSDEAction, arrayList);
        for (PSDEList pSDEList : arrayList) {
            this.remove(pSDEList);
        }
        this.onAfterRemoveByRemovePSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByRemovePSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByRemovePSDEAction(PSDEAction pSDEAction, ArrayList<PSDEList> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRemovePSDEAction(PSDEAction pSDEAction, ArrayList<PSDEList> arrayList) throws Exception {
    }

    public void testRemoveByUpdatePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByUpdatePSDEAction(pSDEAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELIST_PSDEACTION_UPDATEPSDEACTIONID", "", iDataEntityModel.getName(), "PSDELIST", iDataEntityModel.getDataInfo(pSDEAction), arrayList.get(0)));
        }
    }

    public void resetUpdatePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByUpdatePSDEAction(pSDEAction);
        for (PSDEList pSDEList : arrayList) {
            PSDEList pSDEList2 = (PSDEList)this.getDEModel().createEntity();
            pSDEList2.setPSDEListId(pSDEList.getPSDEListId());
            pSDEList2.setUpdatePSDEActionId(null);
            this.update(pSDEList2);
        }
    }

    public void removeByUpdatePSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEListServiceBase.this.onBeforeRemoveByUpdatePSDEAction(pSDEAction2);
                PSDEListServiceBase.this.internalRemoveByUpdatePSDEAction(pSDEAction2);
                PSDEListServiceBase.this.onAfterRemoveByUpdatePSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByUpdatePSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByUpdatePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByUpdatePSDEAction(pSDEAction);
        this.onBeforeRemoveByUpdatePSDEAction(pSDEAction, arrayList);
        for (PSDEList pSDEList : arrayList) {
            this.remove(pSDEList);
        }
        this.onAfterRemoveByUpdatePSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByUpdatePSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByUpdatePSDEAction(PSDEAction pSDEAction, ArrayList<PSDEList> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUpdatePSDEAction(PSDEAction pSDEAction, ArrayList<PSDEList> arrayList) throws Exception {
    }

    public void testRemoveByUser2PSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByUser2PSDEAction(pSDEAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELIST_PSDEACTION_USER2PSDEACTIONID", "", iDataEntityModel.getName(), "PSDELIST", iDataEntityModel.getDataInfo(pSDEAction), arrayList.get(0)));
        }
    }

    public void resetUser2PSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByUser2PSDEAction(pSDEAction);
        for (PSDEList pSDEList : arrayList) {
            PSDEList pSDEList2 = (PSDEList)this.getDEModel().createEntity();
            pSDEList2.setPSDEListId(pSDEList.getPSDEListId());
            pSDEList2.setUser2PSDEActionId(null);
            this.update(pSDEList2);
        }
    }

    public void removeByUser2PSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEListServiceBase.this.onBeforeRemoveByUser2PSDEAction(pSDEAction2);
                PSDEListServiceBase.this.internalRemoveByUser2PSDEAction(pSDEAction2);
                PSDEListServiceBase.this.onAfterRemoveByUser2PSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByUser2PSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByUser2PSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByUser2PSDEAction(pSDEAction);
        this.onBeforeRemoveByUser2PSDEAction(pSDEAction, arrayList);
        for (PSDEList pSDEList : arrayList) {
            this.remove(pSDEList);
        }
        this.onAfterRemoveByUser2PSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByUser2PSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByUser2PSDEAction(PSDEAction pSDEAction, ArrayList<PSDEList> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUser2PSDEAction(PSDEAction pSDEAction, ArrayList<PSDEList> arrayList) throws Exception {
    }

    public void testRemoveByUserPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByUserPSDEAction(pSDEAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELIST_PSDEACTION_USERPSDEACTIONID", "", iDataEntityModel.getName(), "PSDELIST", iDataEntityModel.getDataInfo(pSDEAction), arrayList.get(0)));
        }
    }

    public void resetUserPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByUserPSDEAction(pSDEAction);
        for (PSDEList pSDEList : arrayList) {
            PSDEList pSDEList2 = (PSDEList)this.getDEModel().createEntity();
            pSDEList2.setPSDEListId(pSDEList.getPSDEListId());
            pSDEList2.setUserPSDEActionId(null);
            this.update(pSDEList2);
        }
    }

    public void removeByUserPSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEListServiceBase.this.onBeforeRemoveByUserPSDEAction(pSDEAction2);
                PSDEListServiceBase.this.internalRemoveByUserPSDEAction(pSDEAction2);
                PSDEListServiceBase.this.onAfterRemoveByUserPSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByUserPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByUserPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByUserPSDEAction(pSDEAction);
        this.onBeforeRemoveByUserPSDEAction(pSDEAction, arrayList);
        for (PSDEList pSDEList : arrayList) {
            this.remove(pSDEList);
        }
        this.onAfterRemoveByUserPSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByUserPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByUserPSDEAction(PSDEAction pSDEAction, ArrayList<PSDEList> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUserPSDEAction(PSDEAction pSDEAction, ArrayList<PSDEList> arrayList) throws Exception {
    }

    public void testRemoveByAsyncPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByAsyncPSDEDS(pSDEDataSet, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEDATASET");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEDataSet);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELIST_PSDEDATASET_ASYNCPSDEDSID", "", iDataEntityModel.getName(), "PSDELIST", iDataEntityModel.getDataInfo(pSDEDataSet), arrayList.get(0)));
        }
    }

    public void resetAsyncPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByAsyncPSDEDS(pSDEDataSet);
        for (PSDEList pSDEList : arrayList) {
            PSDEList pSDEList2 = (PSDEList)this.getDEModel().createEntity();
            pSDEList2.setPSDEListId(pSDEList.getPSDEListId());
            pSDEList2.setAsyncPSDEDSId(null);
            this.update(pSDEList2);
        }
    }

    public void removeByAsyncPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        final PSDEDataSet pSDEDataSet2 = pSDEDataSet;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEListServiceBase.this.onBeforeRemoveByAsyncPSDEDS(pSDEDataSet2);
                PSDEListServiceBase.this.internalRemoveByAsyncPSDEDS(pSDEDataSet2);
                PSDEListServiceBase.this.onAfterRemoveByAsyncPSDEDS(pSDEDataSet2);
            }
        });
    }

    protected void onBeforeRemoveByAsyncPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void internalRemoveByAsyncPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByAsyncPSDEDS(pSDEDataSet);
        this.onBeforeRemoveByAsyncPSDEDS(pSDEDataSet, arrayList);
        for (PSDEList pSDEList : arrayList) {
            this.remove(pSDEList);
        }
        this.onAfterRemoveByAsyncPSDEDS(pSDEDataSet, arrayList);
    }

    protected void onAfterRemoveByAsyncPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void onBeforeRemoveByAsyncPSDEDS(PSDEDataSet pSDEDataSet, ArrayList<PSDEList> arrayList) throws Exception {
    }

    protected void onAfterRemoveByAsyncPSDEDS(PSDEDataSet pSDEDataSet, ArrayList<PSDEList> arrayList) throws Exception {
    }

    public void testRemoveByPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByPSDEDS(pSDEDataSet, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEDATASET");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEDataSet);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELIST_PSDEDATASET_PSDEDSID", "", iDataEntityModel.getName(), "PSDELIST", iDataEntityModel.getDataInfo(pSDEDataSet), arrayList.get(0)));
        }
    }

    public void resetPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByPSDEDS(pSDEDataSet);
        for (PSDEList pSDEList : arrayList) {
            PSDEList pSDEList2 = (PSDEList)this.getDEModel().createEntity();
            pSDEList2.setPSDEListId(pSDEList.getPSDEListId());
            pSDEList2.setPSDEDSId(null);
            this.update(pSDEList2);
        }
    }

    public void removeByPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        final PSDEDataSet pSDEDataSet2 = pSDEDataSet;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEListServiceBase.this.onBeforeRemoveByPSDEDS(pSDEDataSet2);
                PSDEListServiceBase.this.internalRemoveByPSDEDS(pSDEDataSet2);
                PSDEListServiceBase.this.onAfterRemoveByPSDEDS(pSDEDataSet2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void internalRemoveByPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByPSDEDS(pSDEDataSet);
        this.onBeforeRemoveByPSDEDS(pSDEDataSet, arrayList);
        for (PSDEList pSDEList : arrayList) {
            this.remove(pSDEList);
        }
        this.onAfterRemoveByPSDEDS(pSDEDataSet, arrayList);
    }

    protected void onAfterRemoveByPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void onBeforeRemoveByPSDEDS(PSDEDataSet pSDEDataSet, ArrayList<PSDEList> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEDS(PSDEDataSet pSDEDataSet, ArrayList<PSDEList> arrayList) throws Exception {
    }

    public void testRemoveByGroupPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByGroupPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELIST_PSDEFIELD_GROUPPSDEFID", "", iDataEntityModel.getName(), "PSDELIST", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetGroupPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByGroupPSDEF(pSDEField);
        for (PSDEList pSDEList : arrayList) {
            PSDEList pSDEList2 = (PSDEList)this.getDEModel().createEntity();
            pSDEList2.setPSDEListId(pSDEList.getPSDEListId());
            pSDEList2.setGroupPSDEFId(null);
            this.update(pSDEList2);
        }
    }

    public void removeByGroupPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEListServiceBase.this.onBeforeRemoveByGroupPSDEF(pSDEField2);
                PSDEListServiceBase.this.internalRemoveByGroupPSDEF(pSDEField2);
                PSDEListServiceBase.this.onAfterRemoveByGroupPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByGroupPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByGroupPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByGroupPSDEF(pSDEField);
        this.onBeforeRemoveByGroupPSDEF(pSDEField, arrayList);
        for (PSDEList pSDEList : arrayList) {
            this.remove(pSDEList);
        }
        this.onAfterRemoveByGroupPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByGroupPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByGroupPSDEF(PSDEField pSDEField, ArrayList<PSDEList> arrayList) throws Exception {
    }

    protected void onAfterRemoveByGroupPSDEF(PSDEField pSDEField, ArrayList<PSDEList> arrayList) throws Exception {
    }

    public void testRemoveByGroupTextPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByGroupTextPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELIST_PSDEFIELD_GROUPTEXTPSDEFID", "", iDataEntityModel.getName(), "PSDELIST", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetGroupTextPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByGroupTextPSDEF(pSDEField);
        for (PSDEList pSDEList : arrayList) {
            PSDEList pSDEList2 = (PSDEList)this.getDEModel().createEntity();
            pSDEList2.setPSDEListId(pSDEList.getPSDEListId());
            pSDEList2.setGroupTextPSDEFId(null);
            this.update(pSDEList2);
        }
    }

    public void removeByGroupTextPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEListServiceBase.this.onBeforeRemoveByGroupTextPSDEF(pSDEField2);
                PSDEListServiceBase.this.internalRemoveByGroupTextPSDEF(pSDEField2);
                PSDEListServiceBase.this.onAfterRemoveByGroupTextPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByGroupTextPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByGroupTextPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByGroupTextPSDEF(pSDEField);
        this.onBeforeRemoveByGroupTextPSDEF(pSDEField, arrayList);
        for (PSDEList pSDEList : arrayList) {
            this.remove(pSDEList);
        }
        this.onAfterRemoveByGroupTextPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByGroupTextPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByGroupTextPSDEF(PSDEField pSDEField, ArrayList<PSDEList> arrayList) throws Exception {
    }

    protected void onAfterRemoveByGroupTextPSDEF(PSDEField pSDEField, ArrayList<PSDEList> arrayList) throws Exception {
    }

    public void testRemoveByMinorSortPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByMinorSortPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELIST_PSDEFIELD_MINORSORTPSDEFID", "", iDataEntityModel.getName(), "PSDELIST", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetMinorSortPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByMinorSortPSDEF(pSDEField);
        for (PSDEList pSDEList : arrayList) {
            PSDEList pSDEList2 = (PSDEList)this.getDEModel().createEntity();
            pSDEList2.setPSDEListId(pSDEList.getPSDEListId());
            pSDEList2.setMinorSortPSDEFId(null);
            this.update(pSDEList2);
        }
    }

    public void removeByMinorSortPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEListServiceBase.this.onBeforeRemoveByMinorSortPSDEF(pSDEField2);
                PSDEListServiceBase.this.internalRemoveByMinorSortPSDEF(pSDEField2);
                PSDEListServiceBase.this.onAfterRemoveByMinorSortPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByMinorSortPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByMinorSortPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByMinorSortPSDEF(pSDEField);
        this.onBeforeRemoveByMinorSortPSDEF(pSDEField, arrayList);
        for (PSDEList pSDEList : arrayList) {
            this.remove(pSDEList);
        }
        this.onAfterRemoveByMinorSortPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByMinorSortPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByMinorSortPSDEF(PSDEField pSDEField, ArrayList<PSDEList> arrayList) throws Exception {
    }

    protected void onAfterRemoveByMinorSortPSDEF(PSDEField pSDEField, ArrayList<PSDEList> arrayList) throws Exception {
    }

    public void testRemoveByOrderValuePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByOrderValuePSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELIST_PSDEFIELD_ORDERVALUEPSDEFID", "", iDataEntityModel.getName(), "PSDELIST", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetOrderValuePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByOrderValuePSDEF(pSDEField);
        for (PSDEList pSDEList : arrayList) {
            PSDEList pSDEList2 = (PSDEList)this.getDEModel().createEntity();
            pSDEList2.setPSDEListId(pSDEList.getPSDEListId());
            pSDEList2.setOrderValuePSDEFId(null);
            this.update(pSDEList2);
        }
    }

    public void removeByOrderValuePSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEListServiceBase.this.onBeforeRemoveByOrderValuePSDEF(pSDEField2);
                PSDEListServiceBase.this.internalRemoveByOrderValuePSDEF(pSDEField2);
                PSDEListServiceBase.this.onAfterRemoveByOrderValuePSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByOrderValuePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByOrderValuePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByOrderValuePSDEF(pSDEField);
        this.onBeforeRemoveByOrderValuePSDEF(pSDEField, arrayList);
        for (PSDEList pSDEList : arrayList) {
            this.remove(pSDEList);
        }
        this.onAfterRemoveByOrderValuePSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByOrderValuePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByOrderValuePSDEF(PSDEField pSDEField, ArrayList<PSDEList> arrayList) throws Exception {
    }

    protected void onAfterRemoveByOrderValuePSDEF(PSDEField pSDEField, ArrayList<PSDEList> arrayList) throws Exception {
    }

    public void testRemoveBySwimlanePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectBySwimlanePSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELIST_PSDEFIELD_SWIMLANEPSDEFID", "", iDataEntityModel.getName(), "PSDELIST", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetSwimlanePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectBySwimlanePSDEF(pSDEField);
        for (PSDEList pSDEList : arrayList) {
            PSDEList pSDEList2 = (PSDEList)this.getDEModel().createEntity();
            pSDEList2.setPSDEListId(pSDEList.getPSDEListId());
            pSDEList2.setSwimlanePSDEFId(null);
            this.update(pSDEList2);
        }
    }

    public void removeBySwimlanePSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEListServiceBase.this.onBeforeRemoveBySwimlanePSDEF(pSDEField2);
                PSDEListServiceBase.this.internalRemoveBySwimlanePSDEF(pSDEField2);
                PSDEListServiceBase.this.onAfterRemoveBySwimlanePSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveBySwimlanePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveBySwimlanePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectBySwimlanePSDEF(pSDEField);
        this.onBeforeRemoveBySwimlanePSDEF(pSDEField, arrayList);
        for (PSDEList pSDEList : arrayList) {
            this.remove(pSDEList);
        }
        this.onAfterRemoveBySwimlanePSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveBySwimlanePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveBySwimlanePSDEF(PSDEField pSDEField, ArrayList<PSDEList> arrayList) throws Exception {
    }

    protected void onAfterRemoveBySwimlanePSDEF(PSDEField pSDEField, ArrayList<PSDEList> arrayList) throws Exception {
    }

    public void testRemoveByADPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByADPSDELogic(pSDELogic, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDELOGIC");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDELogic);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELIST_PSDELOGIC_ADPSDELOGICID", "", iDataEntityModel.getName(), "PSDELIST", iDataEntityModel.getDataInfo(pSDELogic), arrayList.get(0)));
        }
    }

    public void resetADPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByADPSDELogic(pSDELogic);
        for (PSDEList pSDEList : arrayList) {
            PSDEList pSDEList2 = (PSDEList)this.getDEModel().createEntity();
            pSDEList2.setPSDEListId(pSDEList.getPSDEListId());
            pSDEList2.setADPSDELogicId(null);
            this.update(pSDEList2);
        }
    }

    public void removeByADPSDELogic(PSDELogic pSDELogic) throws Exception {
        final PSDELogic pSDELogic2 = pSDELogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEListServiceBase.this.onBeforeRemoveByADPSDELogic(pSDELogic2);
                PSDEListServiceBase.this.internalRemoveByADPSDELogic(pSDELogic2);
                PSDEListServiceBase.this.onAfterRemoveByADPSDELogic(pSDELogic2);
            }
        });
    }

    protected void onBeforeRemoveByADPSDELogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void internalRemoveByADPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByADPSDELogic(pSDELogic);
        this.onBeforeRemoveByADPSDELogic(pSDELogic, arrayList);
        for (PSDEList pSDEList : arrayList) {
            this.remove(pSDEList);
        }
        this.onAfterRemoveByADPSDELogic(pSDELogic, arrayList);
    }

    protected void onAfterRemoveByADPSDELogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void onBeforeRemoveByADPSDELogic(PSDELogic pSDELogic, ArrayList<PSDEList> arrayList) throws Exception {
    }

    protected void onAfterRemoveByADPSDELogic(PSDELogic pSDELogic, ArrayList<PSDEList> arrayList) throws Exception {
    }

    public void testRemoveByNavPSDER(PSDER pSDER) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByNavPSDER(pSDER, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDER);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELIST_PSDER_NAVPSDERID", "", iDataEntityModel.getName(), "PSDELIST", iDataEntityModel.getDataInfo(pSDER), arrayList.get(0)));
        }
    }

    public void resetNavPSDER(PSDER pSDER) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByNavPSDER(pSDER);
        for (PSDEList pSDEList : arrayList) {
            PSDEList pSDEList2 = (PSDEList)this.getDEModel().createEntity();
            pSDEList2.setPSDEListId(pSDEList.getPSDEListId());
            pSDEList2.setNavPSDERId(null);
            this.update(pSDEList2);
        }
    }

    public void removeByNavPSDER(PSDER pSDER) throws Exception {
        final PSDER pSDER2 = pSDER;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEListServiceBase.this.onBeforeRemoveByNavPSDER(pSDER2);
                PSDEListServiceBase.this.internalRemoveByNavPSDER(pSDER2);
                PSDEListServiceBase.this.onAfterRemoveByNavPSDER(pSDER2);
            }
        });
    }

    protected void onBeforeRemoveByNavPSDER(PSDER pSDER) throws Exception {
    }

    protected void internalRemoveByNavPSDER(PSDER pSDER) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByNavPSDER(pSDER);
        this.onBeforeRemoveByNavPSDER(pSDER, arrayList);
        for (PSDEList pSDEList : arrayList) {
            this.remove(pSDEList);
        }
        this.onAfterRemoveByNavPSDER(pSDER, arrayList);
    }

    protected void onAfterRemoveByNavPSDER(PSDER pSDER) throws Exception {
    }

    protected void onBeforeRemoveByNavPSDER(PSDER pSDER, ArrayList<PSDEList> arrayList) throws Exception {
    }

    protected void onAfterRemoveByNavPSDER(PSDER pSDER, ArrayList<PSDEList> arrayList) throws Exception {
    }

    public void testRemoveByBatPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByBatPSDEToolbar(pSDEToolbar, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDETOOLBAR");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEToolbar);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELIST_PSDETOOLBAR_BATPSDETOOLBARID", "", iDataEntityModel.getName(), "PSDELIST", iDataEntityModel.getDataInfo(pSDEToolbar), arrayList.get(0)));
        }
    }

    public void resetBatPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByBatPSDEToolbar(pSDEToolbar);
        for (PSDEList pSDEList : arrayList) {
            PSDEList pSDEList2 = (PSDEList)this.getDEModel().createEntity();
            pSDEList2.setPSDEListId(pSDEList.getPSDEListId());
            pSDEList2.setBatPSDEToolbarId(null);
            this.update(pSDEList2);
        }
    }

    public void removeByBatPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
        final PSDEToolbar pSDEToolbar2 = pSDEToolbar;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEListServiceBase.this.onBeforeRemoveByBatPSDEToolbar(pSDEToolbar2);
                PSDEListServiceBase.this.internalRemoveByBatPSDEToolbar(pSDEToolbar2);
                PSDEListServiceBase.this.onAfterRemoveByBatPSDEToolbar(pSDEToolbar2);
            }
        });
    }

    protected void onBeforeRemoveByBatPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
    }

    protected void internalRemoveByBatPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByBatPSDEToolbar(pSDEToolbar);
        this.onBeforeRemoveByBatPSDEToolbar(pSDEToolbar, arrayList);
        for (PSDEList pSDEList : arrayList) {
            this.remove(pSDEList);
        }
        this.onAfterRemoveByBatPSDEToolbar(pSDEToolbar, arrayList);
    }

    protected void onAfterRemoveByBatPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
    }

    protected void onBeforeRemoveByBatPSDEToolbar(PSDEToolbar pSDEToolbar, ArrayList<PSDEList> arrayList) throws Exception {
    }

    protected void onAfterRemoveByBatPSDEToolbar(PSDEToolbar pSDEToolbar, ArrayList<PSDEList> arrayList) throws Exception {
    }

    public void testRemoveByQuickPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByQuickPSDEToolbar(pSDEToolbar, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDETOOLBAR");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEToolbar);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELIST_PSDETOOLBAR_QUICKPSDETOOLBARID", "", iDataEntityModel.getName(), "PSDELIST", iDataEntityModel.getDataInfo(pSDEToolbar), arrayList.get(0)));
        }
    }

    public void resetQuickPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByQuickPSDEToolbar(pSDEToolbar);
        for (PSDEList pSDEList : arrayList) {
            PSDEList pSDEList2 = (PSDEList)this.getDEModel().createEntity();
            pSDEList2.setPSDEListId(pSDEList.getPSDEListId());
            pSDEList2.setQuickPSDEToolbarId(null);
            this.update(pSDEList2);
        }
    }

    public void removeByQuickPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
        final PSDEToolbar pSDEToolbar2 = pSDEToolbar;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEListServiceBase.this.onBeforeRemoveByQuickPSDEToolbar(pSDEToolbar2);
                PSDEListServiceBase.this.internalRemoveByQuickPSDEToolbar(pSDEToolbar2);
                PSDEListServiceBase.this.onAfterRemoveByQuickPSDEToolbar(pSDEToolbar2);
            }
        });
    }

    protected void onBeforeRemoveByQuickPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
    }

    protected void internalRemoveByQuickPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByQuickPSDEToolbar(pSDEToolbar);
        this.onBeforeRemoveByQuickPSDEToolbar(pSDEToolbar, arrayList);
        for (PSDEList pSDEList : arrayList) {
            this.remove(pSDEList);
        }
        this.onAfterRemoveByQuickPSDEToolbar(pSDEToolbar, arrayList);
    }

    protected void onAfterRemoveByQuickPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
    }

    protected void onBeforeRemoveByQuickPSDEToolbar(PSDEToolbar pSDEToolbar, ArrayList<PSDEList> arrayList) throws Exception {
    }

    protected void onAfterRemoveByQuickPSDEToolbar(PSDEToolbar pSDEToolbar, ArrayList<PSDEList> arrayList) throws Exception {
    }

    public void testRemoveByGroupPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByGroupPSDEUAGroup(pSDEUAGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEUAGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEUAGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELIST_PSDEUAGROUP_GROUPPSDEUAGROUPID", "", iDataEntityModel.getName(), "PSDELIST", iDataEntityModel.getDataInfo(pSDEUAGroup), arrayList.get(0)));
        }
    }

    public void resetGroupPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByGroupPSDEUAGroup(pSDEUAGroup);
        for (PSDEList pSDEList : arrayList) {
            PSDEList pSDEList2 = (PSDEList)this.getDEModel().createEntity();
            pSDEList2.setPSDEListId(pSDEList.getPSDEListId());
            pSDEList2.setGroupPSDEUAGroupId(null);
            this.update(pSDEList2);
        }
    }

    public void removeByGroupPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        final PSDEUAGroup pSDEUAGroup2 = pSDEUAGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEListServiceBase.this.onBeforeRemoveByGroupPSDEUAGroup(pSDEUAGroup2);
                PSDEListServiceBase.this.internalRemoveByGroupPSDEUAGroup(pSDEUAGroup2);
                PSDEListServiceBase.this.onAfterRemoveByGroupPSDEUAGroup(pSDEUAGroup2);
            }
        });
    }

    protected void onBeforeRemoveByGroupPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
    }

    protected void internalRemoveByGroupPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByGroupPSDEUAGroup(pSDEUAGroup);
        this.onBeforeRemoveByGroupPSDEUAGroup(pSDEUAGroup, arrayList);
        for (PSDEList pSDEList : arrayList) {
            this.remove(pSDEList);
        }
        this.onAfterRemoveByGroupPSDEUAGroup(pSDEUAGroup, arrayList);
    }

    protected void onAfterRemoveByGroupPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
    }

    protected void onBeforeRemoveByGroupPSDEUAGroup(PSDEUAGroup pSDEUAGroup, ArrayList<PSDEList> arrayList) throws Exception {
    }

    protected void onAfterRemoveByGroupPSDEUAGroup(PSDEUAGroup pSDEUAGroup, ArrayList<PSDEList> arrayList) throws Exception {
    }

    public void testRemoveByNo2PSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByNo2PSDEUAGroup(pSDEUAGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEUAGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEUAGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELIST_PSDEUAGROUP_NO2PSDEUAGROUPID", "", iDataEntityModel.getName(), "PSDELIST", iDataEntityModel.getDataInfo(pSDEUAGroup), arrayList.get(0)));
        }
    }

    public void resetNo2PSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByNo2PSDEUAGroup(pSDEUAGroup);
        for (PSDEList pSDEList : arrayList) {
            PSDEList pSDEList2 = (PSDEList)this.getDEModel().createEntity();
            pSDEList2.setPSDEListId(pSDEList.getPSDEListId());
            pSDEList2.setNo2PSDEUAGroupId(null);
            this.update(pSDEList2);
        }
    }

    public void removeByNo2PSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        final PSDEUAGroup pSDEUAGroup2 = pSDEUAGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEListServiceBase.this.onBeforeRemoveByNo2PSDEUAGroup(pSDEUAGroup2);
                PSDEListServiceBase.this.internalRemoveByNo2PSDEUAGroup(pSDEUAGroup2);
                PSDEListServiceBase.this.onAfterRemoveByNo2PSDEUAGroup(pSDEUAGroup2);
            }
        });
    }

    protected void onBeforeRemoveByNo2PSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
    }

    protected void internalRemoveByNo2PSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByNo2PSDEUAGroup(pSDEUAGroup);
        this.onBeforeRemoveByNo2PSDEUAGroup(pSDEUAGroup, arrayList);
        for (PSDEList pSDEList : arrayList) {
            this.remove(pSDEList);
        }
        this.onAfterRemoveByNo2PSDEUAGroup(pSDEUAGroup, arrayList);
    }

    protected void onAfterRemoveByNo2PSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
    }

    protected void onBeforeRemoveByNo2PSDEUAGroup(PSDEUAGroup pSDEUAGroup, ArrayList<PSDEList> arrayList) throws Exception {
    }

    protected void onAfterRemoveByNo2PSDEUAGroup(PSDEUAGroup pSDEUAGroup, ArrayList<PSDEList> arrayList) throws Exception {
    }

    public void testRemoveByPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByPSDEUAGroup(pSDEUAGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEUAGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEUAGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELIST_PSDEUAGROUP_PSDEUAGROUPID", "", iDataEntityModel.getName(), "PSDELIST", iDataEntityModel.getDataInfo(pSDEUAGroup), arrayList.get(0)));
        }
    }

    public void resetPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByPSDEUAGroup(pSDEUAGroup);
        for (PSDEList pSDEList : arrayList) {
            PSDEList pSDEList2 = (PSDEList)this.getDEModel().createEntity();
            pSDEList2.setPSDEListId(pSDEList.getPSDEListId());
            pSDEList2.setPSDEUAGroupId(null);
            this.update(pSDEList2);
        }
    }

    public void removeByPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        final PSDEUAGroup pSDEUAGroup2 = pSDEUAGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEListServiceBase.this.onBeforeRemoveByPSDEUAGroup(pSDEUAGroup2);
                PSDEListServiceBase.this.internalRemoveByPSDEUAGroup(pSDEUAGroup2);
                PSDEListServiceBase.this.onAfterRemoveByPSDEUAGroup(pSDEUAGroup2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
    }

    protected void internalRemoveByPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByPSDEUAGroup(pSDEUAGroup);
        this.onBeforeRemoveByPSDEUAGroup(pSDEUAGroup, arrayList);
        for (PSDEList pSDEList : arrayList) {
            this.remove(pSDEList);
        }
        this.onAfterRemoveByPSDEUAGroup(pSDEUAGroup, arrayList);
    }

    protected void onAfterRemoveByPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
    }

    protected void onBeforeRemoveByPSDEUAGroup(PSDEUAGroup pSDEUAGroup, ArrayList<PSDEList> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEUAGroup(PSDEUAGroup pSDEUAGroup, ArrayList<PSDEList> arrayList) throws Exception {
    }

    public void testRemoveByNavPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByNavPSDEViewBase(pSDEViewBase, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVIEWBASE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEViewBase);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELIST_PSDEVIEWBASE_NAVPSDEVIEWBASEID", "", iDataEntityModel.getName(), "PSDELIST", iDataEntityModel.getDataInfo(pSDEViewBase), arrayList.get(0)));
        }
    }

    public void resetNavPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByNavPSDEViewBase(pSDEViewBase);
        for (PSDEList pSDEList : arrayList) {
            PSDEList pSDEList2 = (PSDEList)this.getDEModel().createEntity();
            pSDEList2.setPSDEListId(pSDEList.getPSDEListId());
            pSDEList2.setNavPSDEViewBaseId(null);
            this.update(pSDEList2);
        }
    }

    public void removeByNavPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
        final PSDEViewBase pSDEViewBase2 = pSDEViewBase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEListServiceBase.this.onBeforeRemoveByNavPSDEViewBase(pSDEViewBase2);
                PSDEListServiceBase.this.internalRemoveByNavPSDEViewBase(pSDEViewBase2);
                PSDEListServiceBase.this.onAfterRemoveByNavPSDEViewBase(pSDEViewBase2);
            }
        });
    }

    protected void onBeforeRemoveByNavPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void internalRemoveByNavPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByNavPSDEViewBase(pSDEViewBase);
        this.onBeforeRemoveByNavPSDEViewBase(pSDEViewBase, arrayList);
        for (PSDEList pSDEList : arrayList) {
            this.remove(pSDEList);
        }
        this.onAfterRemoveByNavPSDEViewBase(pSDEViewBase, arrayList);
    }

    protected void onAfterRemoveByNavPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void onBeforeRemoveByNavPSDEViewBase(PSDEViewBase pSDEViewBase, ArrayList<PSDEList> arrayList) throws Exception {
    }

    protected void onAfterRemoveByNavPSDEViewBase(PSDEViewBase pSDEViewBase, ArrayList<PSDEList> arrayList) throws Exception {
    }

    public void testRemoveByEmptyTextPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByEmptyTextPSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELIST_PSLANGUAGERES_EMPTYTEXTPSLANRESID", "", iDataEntityModel.getName(), "PSDELIST", iDataEntityModel.getDataInfo(pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetEmptyTextPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByEmptyTextPSLanRes(pSLanguageRes);
        for (PSDEList pSDEList : arrayList) {
            PSDEList pSDEList2 = (PSDEList)this.getDEModel().createEntity();
            pSDEList2.setPSDEListId(pSDEList.getPSDEListId());
            pSDEList2.setEmptyTextPSLanResId(null);
            this.update(pSDEList2);
        }
    }

    public void removeByEmptyTextPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEListServiceBase.this.onBeforeRemoveByEmptyTextPSLanRes(pSLanguageRes2);
                PSDEListServiceBase.this.internalRemoveByEmptyTextPSLanRes(pSLanguageRes2);
                PSDEListServiceBase.this.onAfterRemoveByEmptyTextPSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByEmptyTextPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByEmptyTextPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByEmptyTextPSLanRes(pSLanguageRes);
        this.onBeforeRemoveByEmptyTextPSLanRes(pSLanguageRes, arrayList);
        for (PSDEList pSDEList : arrayList) {
            this.remove(pSDEList);
        }
        this.onAfterRemoveByEmptyTextPSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByEmptyTextPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByEmptyTextPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEList> arrayList) throws Exception {
    }

    protected void onAfterRemoveByEmptyTextPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEList> arrayList) throws Exception {
    }

    public void testRemoveByGroupPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByGroupPSSysCss(pSSysCss, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSCSS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysCss);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELIST_PSSYSCSS_GROUPPSSYSCSSID", "", iDataEntityModel.getName(), "PSDELIST", iDataEntityModel.getDataInfo(pSSysCss), arrayList.get(0)));
        }
    }

    public void resetGroupPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByGroupPSSysCss(pSSysCss);
        for (PSDEList pSDEList : arrayList) {
            PSDEList pSDEList2 = (PSDEList)this.getDEModel().createEntity();
            pSDEList2.setPSDEListId(pSDEList.getPSDEListId());
            pSDEList2.setGroupPSSysCssId(null);
            this.update(pSDEList2);
        }
    }

    public void removeByGroupPSSysCss(PSSysCss pSSysCss) throws Exception {
        final PSSysCss pSSysCss2 = pSSysCss;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEListServiceBase.this.onBeforeRemoveByGroupPSSysCss(pSSysCss2);
                PSDEListServiceBase.this.internalRemoveByGroupPSSysCss(pSSysCss2);
                PSDEListServiceBase.this.onAfterRemoveByGroupPSSysCss(pSSysCss2);
            }
        });
    }

    protected void onBeforeRemoveByGroupPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void internalRemoveByGroupPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByGroupPSSysCss(pSSysCss);
        this.onBeforeRemoveByGroupPSSysCss(pSSysCss, arrayList);
        for (PSDEList pSDEList : arrayList) {
            this.remove(pSDEList);
        }
        this.onAfterRemoveByGroupPSSysCss(pSSysCss, arrayList);
    }

    protected void onAfterRemoveByGroupPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void onBeforeRemoveByGroupPSSysCss(PSSysCss pSSysCss, ArrayList<PSDEList> arrayList) throws Exception {
    }

    protected void onAfterRemoveByGroupPSSysCss(PSSysCss pSSysCss, ArrayList<PSDEList> arrayList) throws Exception {
    }

    public void testRemoveByItemPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByItemPSSysCss(pSSysCss, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSCSS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysCss);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELIST_PSSYSCSS_ITEMPSSYSCSSID", "", iDataEntityModel.getName(), "PSDELIST", iDataEntityModel.getDataInfo(pSSysCss), arrayList.get(0)));
        }
    }

    public void resetItemPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByItemPSSysCss(pSSysCss);
        for (PSDEList pSDEList : arrayList) {
            PSDEList pSDEList2 = (PSDEList)this.getDEModel().createEntity();
            pSDEList2.setPSDEListId(pSDEList.getPSDEListId());
            pSDEList2.setItemPSSysCssId(null);
            this.update(pSDEList2);
        }
    }

    public void removeByItemPSSysCss(PSSysCss pSSysCss) throws Exception {
        final PSSysCss pSSysCss2 = pSSysCss;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEListServiceBase.this.onBeforeRemoveByItemPSSysCss(pSSysCss2);
                PSDEListServiceBase.this.internalRemoveByItemPSSysCss(pSSysCss2);
                PSDEListServiceBase.this.onAfterRemoveByItemPSSysCss(pSSysCss2);
            }
        });
    }

    protected void onBeforeRemoveByItemPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void internalRemoveByItemPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByItemPSSysCss(pSSysCss);
        this.onBeforeRemoveByItemPSSysCss(pSSysCss, arrayList);
        for (PSDEList pSDEList : arrayList) {
            this.remove(pSDEList);
        }
        this.onAfterRemoveByItemPSSysCss(pSSysCss, arrayList);
    }

    protected void onAfterRemoveByItemPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void onBeforeRemoveByItemPSSysCss(PSSysCss pSSysCss, ArrayList<PSDEList> arrayList) throws Exception {
    }

    protected void onAfterRemoveByItemPSSysCss(PSSysCss pSSysCss, ArrayList<PSDEList> arrayList) throws Exception {
    }

    public void testRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByPSSysCss(pSSysCss, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSCSS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysCss);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELIST_PSSYSCSS_PSSYSCSSID", "", iDataEntityModel.getName(), "PSDELIST", iDataEntityModel.getDataInfo(pSSysCss), arrayList.get(0)));
        }
    }

    public void resetPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByPSSysCss(pSSysCss);
        for (PSDEList pSDEList : arrayList) {
            PSDEList pSDEList2 = (PSDEList)this.getDEModel().createEntity();
            pSDEList2.setPSDEListId(pSDEList.getPSDEListId());
            pSDEList2.setPSSysCssId(null);
            this.update(pSDEList2);
        }
    }

    public void removeByPSSysCss(PSSysCss pSSysCss) throws Exception {
        final PSSysCss pSSysCss2 = pSSysCss;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEListServiceBase.this.onBeforeRemoveByPSSysCss(pSSysCss2);
                PSDEListServiceBase.this.internalRemoveByPSSysCss(pSSysCss2);
                PSDEListServiceBase.this.onAfterRemoveByPSSysCss(pSSysCss2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void internalRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByPSSysCss(pSSysCss);
        this.onBeforeRemoveByPSSysCss(pSSysCss, arrayList);
        for (PSDEList pSDEList : arrayList) {
            this.remove(pSDEList);
        }
        this.onAfterRemoveByPSSysCss(pSSysCss, arrayList);
    }

    protected void onAfterRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void onBeforeRemoveByPSSysCss(PSSysCss pSSysCss, ArrayList<PSDEList> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysCss(PSSysCss pSSysCss, ArrayList<PSDEList> arrayList) throws Exception {
    }

    public void testRemoveByGroupPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByGroupPSSysPFPlugin(pSSysPFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSPFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysPFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELIST_PSSYSPFPLUGIN_GROUPPSSYSPFPLUGINID", "", iDataEntityModel.getName(), "PSDELIST", iDataEntityModel.getDataInfo(pSSysPFPlugin), arrayList.get(0)));
        }
    }

    public void resetGroupPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByGroupPSSysPFPlugin(pSSysPFPlugin);
        for (PSDEList pSDEList : arrayList) {
            PSDEList pSDEList2 = (PSDEList)this.getDEModel().createEntity();
            pSDEList2.setPSDEListId(pSDEList.getPSDEListId());
            pSDEList2.setGroupPSSysPFPluginId(null);
            this.update(pSDEList2);
        }
    }

    public void removeByGroupPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        final PSSysPFPlugin pSSysPFPlugin2 = pSSysPFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEListServiceBase.this.onBeforeRemoveByGroupPSSysPFPlugin(pSSysPFPlugin2);
                PSDEListServiceBase.this.internalRemoveByGroupPSSysPFPlugin(pSSysPFPlugin2);
                PSDEListServiceBase.this.onAfterRemoveByGroupPSSysPFPlugin(pSSysPFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByGroupPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void internalRemoveByGroupPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByGroupPSSysPFPlugin(pSSysPFPlugin);
        this.onBeforeRemoveByGroupPSSysPFPlugin(pSSysPFPlugin, arrayList);
        for (PSDEList pSDEList : arrayList) {
            this.remove(pSDEList);
        }
        this.onAfterRemoveByGroupPSSysPFPlugin(pSSysPFPlugin, arrayList);
    }

    protected void onAfterRemoveByGroupPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByGroupPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSDEList> arrayList) throws Exception {
    }

    protected void onAfterRemoveByGroupPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSDEList> arrayList) throws Exception {
    }

    public void testRemoveByItemPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByItemPSSysPFPlugin(pSSysPFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSPFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysPFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELIST_PSSYSPFPLUGIN_ITEMPSSYSPFPLUGINID", "", iDataEntityModel.getName(), "PSDELIST", iDataEntityModel.getDataInfo(pSSysPFPlugin), arrayList.get(0)));
        }
    }

    public void resetItemPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByItemPSSysPFPlugin(pSSysPFPlugin);
        for (PSDEList pSDEList : arrayList) {
            PSDEList pSDEList2 = (PSDEList)this.getDEModel().createEntity();
            pSDEList2.setPSDEListId(pSDEList.getPSDEListId());
            pSDEList2.setItemPSSysPFPluginId(null);
            this.update(pSDEList2);
        }
    }

    public void removeByItemPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        final PSSysPFPlugin pSSysPFPlugin2 = pSSysPFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEListServiceBase.this.onBeforeRemoveByItemPSSysPFPlugin(pSSysPFPlugin2);
                PSDEListServiceBase.this.internalRemoveByItemPSSysPFPlugin(pSSysPFPlugin2);
                PSDEListServiceBase.this.onAfterRemoveByItemPSSysPFPlugin(pSSysPFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByItemPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void internalRemoveByItemPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByItemPSSysPFPlugin(pSSysPFPlugin);
        this.onBeforeRemoveByItemPSSysPFPlugin(pSSysPFPlugin, arrayList);
        for (PSDEList pSDEList : arrayList) {
            this.remove(pSDEList);
        }
        this.onAfterRemoveByItemPSSysPFPlugin(pSSysPFPlugin, arrayList);
    }

    protected void onAfterRemoveByItemPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByItemPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSDEList> arrayList) throws Exception {
    }

    protected void onAfterRemoveByItemPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSDEList> arrayList) throws Exception {
    }

    public void testRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSPFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysPFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELIST_PSSYSPFPLUGIN_PSSYSPFPLUGINID", "", iDataEntityModel.getName(), "PSDELIST", iDataEntityModel.getDataInfo(pSSysPFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        for (PSDEList pSDEList : arrayList) {
            PSDEList pSDEList2 = (PSDEList)this.getDEModel().createEntity();
            pSDEList2.setPSDEListId(pSDEList.getPSDEListId());
            pSDEList2.setPSSysPFPluginId(null);
            this.update(pSDEList2);
        }
    }

    public void removeByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        final PSSysPFPlugin pSSysPFPlugin2 = pSSysPFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEListServiceBase.this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSDEListServiceBase.this.internalRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSDEListServiceBase.this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
        for (PSDEList pSDEList : arrayList) {
            this.remove(pSDEList);
        }
        this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSDEList> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSDEList> arrayList) throws Exception {
    }

    public void testRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByPSSysReqItem(pSSysReqItem, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSREQITEM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysReqItem);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELIST_PSSYSREQITEM_PSSYSREQITEMID", "", iDataEntityModel.getName(), "PSDELIST", iDataEntityModel.getDataInfo(pSSysReqItem), arrayList.get(0)));
        }
    }

    public void resetPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByPSSysReqItem(pSSysReqItem);
        for (PSDEList pSDEList : arrayList) {
            PSDEList pSDEList2 = (PSDEList)this.getDEModel().createEntity();
            pSDEList2.setPSDEListId(pSDEList.getPSDEListId());
            pSDEList2.setPSSysReqItemId(null);
            this.update(pSDEList2);
        }
    }

    public void removeByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        final PSSysReqItem pSSysReqItem2 = pSSysReqItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEListServiceBase.this.onBeforeRemoveByPSSysReqItem(pSSysReqItem2);
                PSDEListServiceBase.this.internalRemoveByPSSysReqItem(pSSysReqItem2);
                PSDEListServiceBase.this.onAfterRemoveByPSSysReqItem(pSSysReqItem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
    }

    protected void internalRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByPSSysReqItem(pSSysReqItem);
        this.onBeforeRemoveByPSSysReqItem(pSSysReqItem, arrayList);
        for (PSDEList pSDEList : arrayList) {
            this.remove(pSDEList);
        }
        this.onAfterRemoveByPSSysReqItem(pSSysReqItem, arrayList);
    }

    protected void onAfterRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
    }

    protected void onBeforeRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem, ArrayList<PSDEList> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem, ArrayList<PSDEList> arrayList) throws Exception {
    }

    public void testRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByPSSysViewPanel(pSSysViewPanel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSVIEWPANEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysViewPanel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELIST_PSSYSVIEWPANEL_PSSYSVIEWPANELID", "", iDataEntityModel.getName(), "PSDELIST", iDataEntityModel.getDataInfo(pSSysViewPanel), arrayList.get(0)));
        }
    }

    public void resetPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByPSSysViewPanel(pSSysViewPanel);
        for (PSDEList pSDEList : arrayList) {
            PSDEList pSDEList2 = (PSDEList)this.getDEModel().createEntity();
            pSDEList2.setPSDEListId(pSDEList.getPSDEListId());
            pSDEList2.setPSSysViewPanelId(null);
            this.update(pSDEList2);
        }
    }

    public void removeByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        final PSSysViewPanel pSSysViewPanel2 = pSSysViewPanel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEListServiceBase.this.onBeforeRemoveByPSSysViewPanel(pSSysViewPanel2);
                PSDEListServiceBase.this.internalRemoveByPSSysViewPanel(pSSysViewPanel2);
                PSDEListServiceBase.this.onAfterRemoveByPSSysViewPanel(pSSysViewPanel2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
    }

    protected void internalRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByPSSysViewPanel(pSSysViewPanel);
        this.onBeforeRemoveByPSSysViewPanel(pSSysViewPanel, arrayList);
        for (PSDEList pSDEList : arrayList) {
            this.remove(pSDEList);
        }
        this.onAfterRemoveByPSSysViewPanel(pSSysViewPanel, arrayList);
    }

    protected void onAfterRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
    }

    protected void onBeforeRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel, ArrayList<PSDEList> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel, ArrayList<PSDEList> arrayList) throws Exception {
    }

    public void testRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByPSViewMsgGroup(pSViewMsgGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSVIEWMSGGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSViewMsgGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELIST_PSVIEWMSGGROUP_PSVIEWMSGGROUPID", "", iDataEntityModel.getName(), "PSDELIST", iDataEntityModel.getDataInfo(pSViewMsgGroup), arrayList.get(0)));
        }
    }

    public void resetPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByPSViewMsgGroup(pSViewMsgGroup);
        for (PSDEList pSDEList : arrayList) {
            PSDEList pSDEList2 = (PSDEList)this.getDEModel().createEntity();
            pSDEList2.setPSDEListId(pSDEList.getPSDEListId());
            pSDEList2.setPSViewMsgGroupId(null);
            this.update(pSDEList2);
        }
    }

    public void removeByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
        final PSViewMsgGroup pSViewMsgGroup2 = pSViewMsgGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEListServiceBase.this.onBeforeRemoveByPSViewMsgGroup(pSViewMsgGroup2);
                PSDEListServiceBase.this.internalRemoveByPSViewMsgGroup(pSViewMsgGroup2);
                PSDEListServiceBase.this.onAfterRemoveByPSViewMsgGroup(pSViewMsgGroup2);
            }
        });
    }

    protected void onBeforeRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
    }

    protected void internalRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
        ArrayList<PSDEList> arrayList = this.selectByPSViewMsgGroup(pSViewMsgGroup);
        this.onBeforeRemoveByPSViewMsgGroup(pSViewMsgGroup, arrayList);
        for (PSDEList pSDEList : arrayList) {
            this.remove(pSDEList);
        }
        this.onAfterRemoveByPSViewMsgGroup(pSViewMsgGroup, arrayList);
    }

    protected void onAfterRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
    }

    protected void onBeforeRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup, ArrayList<PSDEList> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup, ArrayList<PSDEList> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDEList pSDEList) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEFormDetailService)ServiceGlobal.getService(PSDEFormDetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFormDetailServiceBase)pSCoreSysServiceBase).testRemoveByMDPSDEList(pSDEList);
        pSCoreSysServiceBase = (PSDEListItemService)ServiceGlobal.getService(PSDEListItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEListItemServiceBase)pSCoreSysServiceBase).testRemoveByPSDEList(pSDEList);
        ((PSDEListItemServiceBase)pSCoreSysServiceBase).removeByPSDEList(pSDEList);
        pSCoreSysServiceBase = (PSDEListLogicService)ServiceGlobal.getService(PSDEListLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEListLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSDEList(pSDEList);
        ((PSDEListLogicServiceBase)pSCoreSysServiceBase).removeByPSDEList(pSDEList);
        pSCoreSysServiceBase = (PSDEViewCtrlService)ServiceGlobal.getService(PSDEViewCtrlService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEViewCtrlServiceBase)pSCoreSysServiceBase).testRemoveByPSDEList(pSDEList);
        pSCoreSysServiceBase = (PSSysPortletService)ServiceGlobal.getService(PSSysPortletService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysPortletServiceBase)pSCoreSysServiceBase).testRemoveByPSDEList(pSDEList);
        pSCoreSysServiceBase = (PSSysViewPanelItemService)ServiceGlobal.getService(PSSysViewPanelItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysViewPanelItemServiceBase)pSCoreSysServiceBase).testRemoveByPSDEList(pSDEList);
        super.onBeforeRemove(pSDEList);
    }

    protected void onBeforeRemoveTemp(PSDEList pSDEList) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEListLogicService)ServiceGlobal.getService(PSDEListLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEListLogicServiceBase)pSCoreSysServiceBase).removeTempByPSDEList(pSDEList);
        pSCoreSysServiceBase = (PSDEListItemService)ServiceGlobal.getService(PSDEListItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEListItemServiceBase)pSCoreSysServiceBase).removeTempByPSDEList(pSDEList);
        super.onBeforeRemoveTemp(pSDEList);
    }

    protected void getRelatedDataTempMajor(PSDEList pSDEList) throws Exception {
        this.getRelatedDataTempMajor_PSDEListItem(pSDEList);
        this.getRelatedDataTempMajor_PSDEListLogic(pSDEList);
        super.getRelatedDataTempMajor(pSDEList);
    }

    protected void getRelatedDataTempMajor_PSDEListItem(PSDEList pSDEList) throws Exception {
        PSDEListItemService pSDEListItemService = (PSDEListItemService)ServiceGlobal.getService(PSDEListItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEListItem> arrayList = null;
        String string = pSDEList.getPSDEListId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEListItemService.selectByPSDEList(pSDEList) : pSDEListItemService.selectTempByPSDEList(pSDEList);
        for (PSDEListItem pSDEListItem : arrayList) {
            pSDEListItemService.getTempMajor(pSDEListItem);
        }
    }

    protected void getRelatedDataTempMajor_PSDEListLogic(PSDEList pSDEList) throws Exception {
        PSDEListLogicService pSDEListLogicService = (PSDEListLogicService)ServiceGlobal.getService(PSDEListLogicService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEListLogic> arrayList = null;
        String string = pSDEList.getPSDEListId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEListLogicService.selectByPSDEList(pSDEList) : pSDEListLogicService.selectTempByPSDEList(pSDEList);
        for (PSDEListLogic pSDEListLogic : arrayList) {
            pSDEListLogicService.getTempMajor(pSDEListLogic);
        }
    }

    protected void updateRelatedDataTempMajor(PSDEList pSDEList, PSDEList pSDEList2) throws Exception {
        ArrayList<PSDEListLogic> arrayList = this.updateRelatedDataTempMajor_removePSDEListLogic(pSDEList, pSDEList2);
        ArrayList<PSDEListItem> arrayList2 = this.updateRelatedDataTempMajor_removePSDEListItem(pSDEList, pSDEList2);
        this.updateRelatedDataTempMajor_updatePSDEListItem(pSDEList, pSDEList2, arrayList2);
        this.updateRelatedDataTempMajor_updatePSDEListLogic(pSDEList, pSDEList2, arrayList);
        super.updateRelatedDataTempMajor(pSDEList, pSDEList2);
    }

    protected ArrayList<PSDEListItem> updateRelatedDataTempMajor_removePSDEListItem(PSDEList pSDEList, PSDEList pSDEList2) throws Exception {
        PSDEListItemService pSDEListItemService = (PSDEListItemService)ServiceGlobal.getService(PSDEListItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEListItem> arrayList = pSDEListItemService.selectTempByPSDEList(pSDEList);
        ArrayList<PSDEListItem> arrayList2 = pSDEListItemService.selectByPSDEList(pSDEList2);
        HashMap<String, PSDEListItem> hashMap = new HashMap<String, PSDEListItem>();
        for (PSDEListItem pSDEListItem : arrayList2) {
            hashMap.put(pSDEListItem.getPSDEListItemId(), pSDEListItem);
        }
        for (PSDEListItem pSDEListItem : arrayList) {
            Object object = pSDEListItem.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSDEListItem pSDEListItem : hashMap.values()) {
            pSDEListItemService.remove(pSDEListItem);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSDEListItem(PSDEList pSDEList, PSDEList pSDEList2, ArrayList<PSDEListItem> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSDEListItemService pSDEListItemService = (PSDEListItemService)ServiceGlobal.getService(PSDEListItemService.class, (SessionFactory)this.getSessionFactory());
        for (PSDEListItem pSDEListItem : arrayList) {
            pSDEListItemService.updateTempMajor(pSDEListItem);
        }
    }

    protected ArrayList<PSDEListLogic> updateRelatedDataTempMajor_removePSDEListLogic(PSDEList pSDEList, PSDEList pSDEList2) throws Exception {
        PSDEListLogicService pSDEListLogicService = (PSDEListLogicService)ServiceGlobal.getService(PSDEListLogicService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEListLogic> arrayList = pSDEListLogicService.selectTempByPSDEList(pSDEList);
        ArrayList<PSDEListLogic> arrayList2 = pSDEListLogicService.selectByPSDEList(pSDEList2);
        HashMap<String, PSDEListLogic> hashMap = new HashMap<String, PSDEListLogic>();
        for (PSDEListLogic pSDEListLogic : arrayList2) {
            hashMap.put(pSDEListLogic.getPSDEListLogicId(), pSDEListLogic);
        }
        for (PSDEListLogic pSDEListLogic : arrayList) {
            Object object = pSDEListLogic.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSDEListLogic pSDEListLogic : hashMap.values()) {
            pSDEListLogicService.remove(pSDEListLogic);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSDEListLogic(PSDEList pSDEList, PSDEList pSDEList2, ArrayList<PSDEListLogic> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSDEListLogicService pSDEListLogicService = (PSDEListLogicService)ServiceGlobal.getService(PSDEListLogicService.class, (SessionFactory)this.getSessionFactory());
        for (PSDEListLogic pSDEListLogic : arrayList) {
            pSDEListLogicService.updateTempMajor(pSDEListLogic);
        }
    }

    protected void replaceParentInfo(PSDEList pSDEList, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDEList, cloneSession);
        if (pSDEList.getPSACHandlerId() != null && (iEntity = cloneSession.getEntity("PSACHANDLER", (Object)pSDEList.getPSACHandlerId())) != null) {
            this.onFillParentInfo_PSACHandler(pSDEList, (PSACHandler)iEntity);
        }
        if (pSDEList.getGroupPSCodeListId() != null && (iEntity = cloneSession.getEntity("PSCODELIST", (Object)pSDEList.getGroupPSCodeListId())) != null) {
            this.onFillParentInfo_GroupPSCodeList(pSDEList, (PSCodeList)iEntity);
        }
        if (pSDEList.getSwimlanePSCodeListId() != null && (iEntity = cloneSession.getEntity("PSCODELIST", (Object)pSDEList.getSwimlanePSCodeListId())) != null) {
            this.onFillParentInfo_SwimlanePSCodeList(pSDEList, (PSCodeList)iEntity);
        }
        if (pSDEList.getPSCtrlLogicGroupId() != null && (iEntity = cloneSession.getEntity("PSCTRLLOGICGROUP", (Object)pSDEList.getPSCtrlLogicGroupId())) != null) {
            this.onFillParentInfo_PSCtrlLogicGroup(pSDEList, (PSCtrlLogicGroup)iEntity);
        }
        if (pSDEList.getPSCtrlMsgId() != null && (iEntity = cloneSession.getEntity("PSCTRLMSG", (Object)pSDEList.getPSCtrlMsgId())) != null) {
            this.onFillParentInfo_PSCtrlMsg(pSDEList, (PSCtrlMsg)iEntity);
        }
        if (pSDEList.getGroupPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSDEList.getGroupPSDEId())) != null) {
            this.onFillParentInfo_GroupPSDE(pSDEList, (PSDataEntity)iEntity);
        }
        if (pSDEList.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSDEList.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSDEList, (PSDataEntity)iEntity);
        }
        if (pSDEList.getCopyPSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSDEList.getCopyPSDEActionId())) != null) {
            this.onFillParentInfo_CopyPSDEAction(pSDEList, (PSDEAction)iEntity);
        }
        if (pSDEList.getCreatePSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSDEList.getCreatePSDEActionId())) != null) {
            this.onFillParentInfo_CreatePSDEAction(pSDEList, (PSDEAction)iEntity);
        }
        if (pSDEList.getGetDraftPSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSDEList.getGetDraftPSDEActionId())) != null) {
            this.onFillParentInfo_GetDraftPSDEAction(pSDEList, (PSDEAction)iEntity);
        }
        if (pSDEList.getGetPSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSDEList.getGetPSDEActionId())) != null) {
            this.onFillParentInfo_GetPSDEAction(pSDEList, (PSDEAction)iEntity);
        }
        if (pSDEList.getGroupMovePSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSDEList.getGroupMovePSDEActionId())) != null) {
            this.onFillParentInfo_GroupMovePSDEAction(pSDEList, (PSDEAction)iEntity);
        }
        if (pSDEList.getMovePSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSDEList.getMovePSDEActionId())) != null) {
            this.onFillParentInfo_MovePSDEAction(pSDEList, (PSDEAction)iEntity);
        }
        if (pSDEList.getRemovePSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSDEList.getRemovePSDEActionId())) != null) {
            this.onFillParentInfo_RemovePSDEAction(pSDEList, (PSDEAction)iEntity);
        }
        if (pSDEList.getUpdatePSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSDEList.getUpdatePSDEActionId())) != null) {
            this.onFillParentInfo_UpdatePSDEAction(pSDEList, (PSDEAction)iEntity);
        }
        if (pSDEList.getUser2PSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSDEList.getUser2PSDEActionId())) != null) {
            this.onFillParentInfo_User2PSDEAction(pSDEList, (PSDEAction)iEntity);
        }
        if (pSDEList.getUserPSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSDEList.getUserPSDEActionId())) != null) {
            this.onFillParentInfo_UserPSDEAction(pSDEList, (PSDEAction)iEntity);
        }
        if (pSDEList.getAsyncPSDEDSId() != null && (iEntity = cloneSession.getEntity("PSDEDATASET", (Object)pSDEList.getAsyncPSDEDSId())) != null) {
            this.onFillParentInfo_AsyncPSDEDS(pSDEList, (PSDEDataSet)iEntity);
        }
        if (pSDEList.getPSDEDSId() != null && (iEntity = cloneSession.getEntity("PSDEDATASET", (Object)pSDEList.getPSDEDSId())) != null) {
            this.onFillParentInfo_PSDEDS(pSDEList, (PSDEDataSet)iEntity);
        }
        if (pSDEList.getGroupPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSDEList.getGroupPSDEFId())) != null) {
            this.onFillParentInfo_GroupPSDEF(pSDEList, (PSDEField)iEntity);
        }
        if (pSDEList.getGroupTextPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSDEList.getGroupTextPSDEFId())) != null) {
            this.onFillParentInfo_GroupTextPSDEF(pSDEList, (PSDEField)iEntity);
        }
        if (pSDEList.getMinorSortPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSDEList.getMinorSortPSDEFId())) != null) {
            this.onFillParentInfo_MinorSortPSDEF(pSDEList, (PSDEField)iEntity);
        }
        if (pSDEList.getOrderValuePSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSDEList.getOrderValuePSDEFId())) != null) {
            this.onFillParentInfo_OrderValuePSDEF(pSDEList, (PSDEField)iEntity);
        }
        if (pSDEList.getSwimlanePSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSDEList.getSwimlanePSDEFId())) != null) {
            this.onFillParentInfo_SwimlanePSDEF(pSDEList, (PSDEField)iEntity);
        }
        if (pSDEList.getADPSDELogicId() != null && (iEntity = cloneSession.getEntity("PSDELOGIC", (Object)pSDEList.getADPSDELogicId())) != null) {
            this.onFillParentInfo_ADPSDELogic(pSDEList, (PSDELogic)iEntity);
        }
        if (pSDEList.getNavPSDERId() != null && (iEntity = cloneSession.getEntity("PSDER", (Object)pSDEList.getNavPSDERId())) != null) {
            this.onFillParentInfo_NavPSDER(pSDEList, (PSDER)iEntity);
        }
        if (pSDEList.getBatPSDEToolbarId() != null && (iEntity = cloneSession.getEntity("PSDETOOLBAR", (Object)pSDEList.getBatPSDEToolbarId())) != null) {
            this.onFillParentInfo_BatPSDEToolbar(pSDEList, (PSDEToolbar)iEntity);
        }
        if (pSDEList.getQuickPSDEToolbarId() != null && (iEntity = cloneSession.getEntity("PSDETOOLBAR", (Object)pSDEList.getQuickPSDEToolbarId())) != null) {
            this.onFillParentInfo_QuickPSDEToolbar(pSDEList, (PSDEToolbar)iEntity);
        }
        if (pSDEList.getGroupPSDEUAGroupId() != null && (iEntity = cloneSession.getEntity("PSDEUAGROUP", (Object)pSDEList.getGroupPSDEUAGroupId())) != null) {
            this.onFillParentInfo_GroupPSDEUAGroup(pSDEList, (PSDEUAGroup)iEntity);
        }
        if (pSDEList.getNo2PSDEUAGroupId() != null && (iEntity = cloneSession.getEntity("PSDEUAGROUP", (Object)pSDEList.getNo2PSDEUAGroupId())) != null) {
            this.onFillParentInfo_No2PSDEUAGroup(pSDEList, (PSDEUAGroup)iEntity);
        }
        if (pSDEList.getPSDEUAGroupId() != null && (iEntity = cloneSession.getEntity("PSDEUAGROUP", (Object)pSDEList.getPSDEUAGroupId())) != null) {
            this.onFillParentInfo_PSDEUAGroup(pSDEList, (PSDEUAGroup)iEntity);
        }
        if (pSDEList.getNavPSDEViewBaseId() != null && (iEntity = cloneSession.getEntity("PSDEVIEWBASE", (Object)pSDEList.getNavPSDEViewBaseId())) != null) {
            this.onFillParentInfo_NavPSDEViewBase(pSDEList, (PSDEViewBase)iEntity);
        }
        if (pSDEList.getEmptyTextPSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSDEList.getEmptyTextPSLanResId())) != null) {
            this.onFillParentInfo_EmptyTextPSLanRes(pSDEList, (PSLanguageRes)iEntity);
        }
        if (pSDEList.getGroupPSSysCssId() != null && (iEntity = cloneSession.getEntity("PSSYSCSS", (Object)pSDEList.getGroupPSSysCssId())) != null) {
            this.onFillParentInfo_GroupPSSysCss(pSDEList, (PSSysCss)iEntity);
        }
        if (pSDEList.getItemPSSysCssId() != null && (iEntity = cloneSession.getEntity("PSSYSCSS", (Object)pSDEList.getItemPSSysCssId())) != null) {
            this.onFillParentInfo_ItemPSSysCss(pSDEList, (PSSysCss)iEntity);
        }
        if (pSDEList.getPSSysCssId() != null && (iEntity = cloneSession.getEntity("PSSYSCSS", (Object)pSDEList.getPSSysCssId())) != null) {
            this.onFillParentInfo_PSSysCss(pSDEList, (PSSysCss)iEntity);
        }
        if (pSDEList.getGroupPSSysPFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSPFPLUGIN", (Object)pSDEList.getGroupPSSysPFPluginId())) != null) {
            this.onFillParentInfo_GroupPSSysPFPlugin(pSDEList, (PSSysPFPlugin)iEntity);
        }
        if (pSDEList.getItemPSSysPFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSPFPLUGIN", (Object)pSDEList.getItemPSSysPFPluginId())) != null) {
            this.onFillParentInfo_ItemPSSysPFPlugin(pSDEList, (PSSysPFPlugin)iEntity);
        }
        if (pSDEList.getPSSysPFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSPFPLUGIN", (Object)pSDEList.getPSSysPFPluginId())) != null) {
            this.onFillParentInfo_PSSysPFPlugin(pSDEList, (PSSysPFPlugin)iEntity);
        }
        if (pSDEList.getPSSysReqItemId() != null && (iEntity = cloneSession.getEntity("PSSYSREQITEM", (Object)pSDEList.getPSSysReqItemId())) != null) {
            this.onFillParentInfo_PSSysReqItem(pSDEList, (PSSysReqItem)iEntity);
        }
        if (pSDEList.getPSSysViewPanelId() != null && (iEntity = cloneSession.getEntity("PSSYSVIEWPANEL", (Object)pSDEList.getPSSysViewPanelId())) != null) {
            this.onFillParentInfo_PSSysViewPanel(pSDEList, (PSSysViewPanel)iEntity);
        }
        if (pSDEList.getPSViewMsgGroupId() != null && (iEntity = cloneSession.getEntity("PSVIEWMSGGROUP", (Object)pSDEList.getPSViewMsgGroupId())) != null) {
            this.onFillParentInfo_PSViewMsgGroup(pSDEList, (PSViewMsgGroup)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDEList pSDEList, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDEList, bl);
        pSDEList.resetLVTag();
        pSDEList.resetLVTag2();
        pSDEList.resetLVTag3();
        pSDEList.resetLVTag4();
    }

    protected void onCheckEntity(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_ADPSDELogicId(bl, pSDEList, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AppendDEItems(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AsyncPSDEDSId(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BatPSDEToolbarId(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BusyIndicator(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CopyPSDEActionId(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CreatePSDEActionId(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomCond(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomType(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaModelFlag(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EmptyText(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EmptyTextPSLanResId(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EmptyTextPSLanResName(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableEdit(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableItemPriv(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnablePagingBar(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GetDraftPSDEActionId(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GetPSDEActionId(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupBarCloseMode(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupMode(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupMovePSDEActionId(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupPSCodeListId(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupPSDEFId(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupPSDEFName(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupPSDEId(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupPSDEName(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupPSDEUAGroupId(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupPSSysCssId(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupPSSysPFPluginId(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupStyle(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupTextPSDEFId(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupTextPSDEFName(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ItemPSSysCssId(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ItemPSSysPFPluginId(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ListModel(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LockFlag(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogicName(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LVTag(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LVTag2(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LVTag3(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LVTag4(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MinorSortDir(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MinorSortPSDEFId(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MinorSortPSDEFName(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MobListStyle(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MovePSDEActionId(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MultiSelect(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NavPSDERId(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NavPSDERName(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NavPSDEViewBaseId(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NavViewFilter(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NavViewHeight(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NavViewMaxHeight(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NavViewMaxWidth(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NavViewMinHeight(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NavViewMinWidth(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NavViewParam(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NavViewPos(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NavViewShowMode(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NavViewWidth(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_No2PSDEUAGroupId(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_No2PSDEUAGroupName(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NoSort(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValuePSDEFId(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValuePSDEFName(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PageSize(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSACHandlerId(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCtrlLogicGroupId(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCtrlMsgId(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDSId(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEListId(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEListName(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEUAGroupId(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEUAGroupName(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaInstId(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysCssId(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysPFPluginId(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysReqItemId(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysViewPanelId(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSViewMsgGroupId(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_QuickPSDEToolbarId(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RemovePSDEActionId(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ShowHeader(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SRFSysPub(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SwimlanePSCodeListId(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SwimlanePSDEFId(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SwimlanePSDEFName(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ToDoTask(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UpdatePSDEActionId(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_User2PSDEActionId(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserPSDEActionId(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDEList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDEList, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_ADPSDELogicId(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isADPSDELogicIdDirty() : !pSDEList.isADPSDELogicIdDirty()) {
            return null;
        }
        String string = pSDEList.getADPSDELogicId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ADPSDELogicId_Default(pSDEList, bl2, bl3);
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

    protected EntityFieldError onCheckField_AppendDEItems(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isAppendDEItemsDirty() : !pSDEList.isAppendDEItemsDirty()) {
            return null;
        }
        Integer n = pSDEList.getAppendDEItems();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_AppendDEItems_Default(pSDEList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("APPENDDEITEMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AsyncPSDEDSId(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isAsyncPSDEDSIdDirty() : !pSDEList.isAsyncPSDEDSIdDirty()) {
            return null;
        }
        String string = pSDEList.getAsyncPSDEDSId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AsyncPSDEDSId_Default(pSDEList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ASYNCPSDEDSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BatPSDEToolbarId(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isBatPSDEToolbarIdDirty() : !pSDEList.isBatPSDEToolbarIdDirty()) {
            return null;
        }
        String string = pSDEList.getBatPSDEToolbarId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BatPSDEToolbarId_Default(pSDEList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BATPSDETOOLBARID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BusyIndicator(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isBusyIndicatorDirty() : !pSDEList.isBusyIndicatorDirty()) {
            return null;
        }
        Integer n = pSDEList.getBusyIndicator();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_BusyIndicator_Default(pSDEList, bl2, bl3);
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

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isCodeNameDirty() && !bl2 : !pSDEList.isCodeNameDirty()) {
            return null;
        }
        String string = pSDEList.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSDEList, bl2, bl3);
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
                String string4 = this.checkFieldDupRule(this.getPSDEListDEModel(), "CODENAME", string3, pSDEList, bl2, bl3);
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

    protected EntityFieldError onCheckField_CopyPSDEActionId(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isCopyPSDEActionIdDirty() : !pSDEList.isCopyPSDEActionIdDirty()) {
            return null;
        }
        String string = pSDEList.getCopyPSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CopyPSDEActionId_Default(pSDEList, bl2, bl3);
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

    protected EntityFieldError onCheckField_CreatePSDEActionId(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isCreatePSDEActionIdDirty() : !pSDEList.isCreatePSDEActionIdDirty()) {
            return null;
        }
        String string = pSDEList.getCreatePSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CreatePSDEActionId_Default(pSDEList, bl2, bl3);
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

    protected EntityFieldError onCheckField_CustomCond(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isCustomCondDirty() : !pSDEList.isCustomCondDirty()) {
            return null;
        }
        String string = pSDEList.getCustomCond();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomCond_Default(pSDEList, bl2, bl3);
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

    protected EntityFieldError onCheckField_CustomType(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isCustomTypeDirty() : !pSDEList.isCustomTypeDirty()) {
            return null;
        }
        String string = pSDEList.getCustomType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomType_Default(pSDEList, bl2, bl3);
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

    protected EntityFieldError onCheckField_DynaModelFlag(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isDynaModelFlagDirty() : !pSDEList.isDynaModelFlagDirty()) {
            return null;
        }
        Integer n = pSDEList.getDynaModelFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DynaModelFlag_Default(pSDEList, bl2, bl3);
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

    protected EntityFieldError onCheckField_EmptyText(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isEmptyTextDirty() : !pSDEList.isEmptyTextDirty()) {
            return null;
        }
        String string = pSDEList.getEmptyText();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EmptyText_Default(pSDEList, bl2, bl3);
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

    protected EntityFieldError onCheckField_EmptyTextPSLanResId(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isEmptyTextPSLanResIdDirty() : !pSDEList.isEmptyTextPSLanResIdDirty()) {
            return null;
        }
        String string = pSDEList.getEmptyTextPSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EmptyTextPSLanResId_Default(pSDEList, bl2, bl3);
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

    protected EntityFieldError onCheckField_EmptyTextPSLanResName(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isEmptyTextPSLanResNameDirty() : !pSDEList.isEmptyTextPSLanResNameDirty()) {
            return null;
        }
        String string = pSDEList.getEmptyTextPSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EmptyTextPSLanResName_Default(pSDEList, bl2, bl3);
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

    protected EntityFieldError onCheckField_EnableEdit(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isEnableEditDirty() : !pSDEList.isEnableEditDirty()) {
            return null;
        }
        Integer n = pSDEList.getEnableEdit();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableEdit_Default(pSDEList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEEDIT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableItemPriv(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isEnableItemPrivDirty() : !pSDEList.isEnableItemPrivDirty()) {
            return null;
        }
        Integer n = pSDEList.getEnableItemPriv();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableItemPriv_Default(pSDEList, bl2, bl3);
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

    protected EntityFieldError onCheckField_EnablePagingBar(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isEnablePagingBarDirty() : !pSDEList.isEnablePagingBarDirty()) {
            return null;
        }
        Integer n = pSDEList.getEnablePagingBar();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnablePagingBar_Default(pSDEList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEPAGINGBAR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GetDraftPSDEActionId(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isGetDraftPSDEActionIdDirty() : !pSDEList.isGetDraftPSDEActionIdDirty()) {
            return null;
        }
        String string = pSDEList.getGetDraftPSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GetDraftPSDEActionId_Default(pSDEList, bl2, bl3);
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

    protected EntityFieldError onCheckField_GetPSDEActionId(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isGetPSDEActionIdDirty() : !pSDEList.isGetPSDEActionIdDirty()) {
            return null;
        }
        String string = pSDEList.getGetPSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GetPSDEActionId_Default(pSDEList, bl2, bl3);
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

    protected EntityFieldError onCheckField_GroupBarCloseMode(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isGroupBarCloseModeDirty() : !pSDEList.isGroupBarCloseModeDirty()) {
            return null;
        }
        Integer n = pSDEList.getGroupBarCloseMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_GroupBarCloseMode_Default(pSDEList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GROUPBARCLOSEMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GroupMode(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isGroupModeDirty() : !pSDEList.isGroupModeDirty()) {
            return null;
        }
        String string = pSDEList.getGroupMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GroupMode_Default(pSDEList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GROUPMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GroupMovePSDEActionId(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isGroupMovePSDEActionIdDirty() : !pSDEList.isGroupMovePSDEActionIdDirty()) {
            return null;
        }
        String string = pSDEList.getGroupMovePSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GroupMovePSDEActionId_Default(pSDEList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GROUPMOVEPSDEACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GroupPSCodeListId(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isGroupPSCodeListIdDirty() : !pSDEList.isGroupPSCodeListIdDirty()) {
            return null;
        }
        String string = pSDEList.getGroupPSCodeListId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GroupPSCodeListId_Default(pSDEList, bl2, bl3);
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

    protected EntityFieldError onCheckField_GroupPSDEFId(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isGroupPSDEFIdDirty() : !pSDEList.isGroupPSDEFIdDirty()) {
            return null;
        }
        String string = pSDEList.getGroupPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GroupPSDEFId_Default(pSDEList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GROUPPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GroupPSDEFName(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isGroupPSDEFNameDirty() : !pSDEList.isGroupPSDEFNameDirty()) {
            return null;
        }
        String string = pSDEList.getGroupPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GroupPSDEFName_Default(pSDEList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GROUPPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GroupPSDEId(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isGroupPSDEIdDirty() : !pSDEList.isGroupPSDEIdDirty()) {
            return null;
        }
        String string = pSDEList.getGroupPSDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GroupPSDEId_Default(pSDEList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GROUPPSDEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GroupPSDEName(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isGroupPSDENameDirty() : !pSDEList.isGroupPSDENameDirty()) {
            return null;
        }
        String string = pSDEList.getGroupPSDEName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GroupPSDEName_Default(pSDEList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GROUPPSDENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GroupPSDEUAGroupId(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isGroupPSDEUAGroupIdDirty() : !pSDEList.isGroupPSDEUAGroupIdDirty()) {
            return null;
        }
        String string = pSDEList.getGroupPSDEUAGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GroupPSDEUAGroupId_Default(pSDEList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GROUPPSDEUAGROUPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GroupPSSysCssId(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isGroupPSSysCssIdDirty() : !pSDEList.isGroupPSSysCssIdDirty()) {
            return null;
        }
        String string = pSDEList.getGroupPSSysCssId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GroupPSSysCssId_Default(pSDEList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GROUPPSSYSCSSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GroupPSSysPFPluginId(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isGroupPSSysPFPluginIdDirty() : !pSDEList.isGroupPSSysPFPluginIdDirty()) {
            return null;
        }
        String string = pSDEList.getGroupPSSysPFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GroupPSSysPFPluginId_Default(pSDEList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GROUPPSSYSPFPLUGINID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GroupStyle(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isGroupStyleDirty() : !pSDEList.isGroupStyleDirty()) {
            return null;
        }
        String string = pSDEList.getGroupStyle();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GroupStyle_Default(pSDEList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GROUPSTYLE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GroupTextPSDEFId(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isGroupTextPSDEFIdDirty() : !pSDEList.isGroupTextPSDEFIdDirty()) {
            return null;
        }
        String string = pSDEList.getGroupTextPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GroupTextPSDEFId_Default(pSDEList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GROUPTEXTPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GroupTextPSDEFName(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isGroupTextPSDEFNameDirty() : !pSDEList.isGroupTextPSDEFNameDirty()) {
            return null;
        }
        String string = pSDEList.getGroupTextPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GroupTextPSDEFName_Default(pSDEList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GROUPTEXTPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ItemPSSysCssId(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isItemPSSysCssIdDirty() : !pSDEList.isItemPSSysCssIdDirty()) {
            return null;
        }
        String string = pSDEList.getItemPSSysCssId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ItemPSSysCssId_Default(pSDEList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ITEMPSSYSCSSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ItemPSSysPFPluginId(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isItemPSSysPFPluginIdDirty() : !pSDEList.isItemPSSysPFPluginIdDirty()) {
            return null;
        }
        String string = pSDEList.getItemPSSysPFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ItemPSSysPFPluginId_Default(pSDEList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ITEMPSSYSPFPLUGINID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ListModel(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isListModelDirty() : !pSDEList.isListModelDirty()) {
            return null;
        }
        String string = pSDEList.getListModel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ListModel_Default(pSDEList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LISTMODEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LockFlag(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isLockFlagDirty() : !pSDEList.isLockFlagDirty()) {
            return null;
        }
        Integer n = pSDEList.getLockFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LockFlag_Default(pSDEList, bl2, bl3);
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

    protected EntityFieldError onCheckField_LogicName(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isLogicNameDirty() : !pSDEList.isLogicNameDirty()) {
            return null;
        }
        String string = pSDEList.getLogicName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogicName_Default(pSDEList, bl2, bl3);
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

    protected EntityFieldError onCheckField_LVTag(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isLVTagDirty() : !pSDEList.isLVTagDirty()) {
            return null;
        }
        String string = pSDEList.getLVTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LVTag_Default(pSDEList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LVTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LVTag2(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isLVTag2Dirty() : !pSDEList.isLVTag2Dirty()) {
            return null;
        }
        String string = pSDEList.getLVTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LVTag2_Default(pSDEList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LVTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LVTag3(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isLVTag3Dirty() : !pSDEList.isLVTag3Dirty()) {
            return null;
        }
        String string = pSDEList.getLVTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LVTag3_Default(pSDEList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LVTAG3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LVTag4(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isLVTag4Dirty() : !pSDEList.isLVTag4Dirty()) {
            return null;
        }
        String string = pSDEList.getLVTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LVTag4_Default(pSDEList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LVTAG4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isMemoDirty() : !pSDEList.isMemoDirty()) {
            return null;
        }
        String string = pSDEList.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDEList, bl2, bl3);
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

    protected EntityFieldError onCheckField_MinorSortDir(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isMinorSortDirDirty() : !pSDEList.isMinorSortDirDirty()) {
            return null;
        }
        String string = pSDEList.getMinorSortDir();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MinorSortDir_Default(pSDEList, bl2, bl3);
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

    protected EntityFieldError onCheckField_MinorSortPSDEFId(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isMinorSortPSDEFIdDirty() : !pSDEList.isMinorSortPSDEFIdDirty()) {
            return null;
        }
        String string = pSDEList.getMinorSortPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MinorSortPSDEFId_MinorSortPSDEF(pSDEList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MINORSORTPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
            string2 = this.onTestValueRule_MinorSortPSDEFId_Default(pSDEList, bl2, bl3);
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

    protected EntityFieldError onCheckField_MinorSortPSDEFName(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isMinorSortPSDEFNameDirty() : !pSDEList.isMinorSortPSDEFNameDirty()) {
            return null;
        }
        String string = pSDEList.getMinorSortPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MinorSortPSDEFName_Default(pSDEList, bl2, bl3);
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

    protected EntityFieldError onCheckField_MobListStyle(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isMobListStyleDirty() : !pSDEList.isMobListStyleDirty()) {
            return null;
        }
        String string = pSDEList.getMobListStyle();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MobListStyle_Default(pSDEList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MOBLISTSTYLE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MovePSDEActionId(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isMovePSDEActionIdDirty() : !pSDEList.isMovePSDEActionIdDirty()) {
            return null;
        }
        String string = pSDEList.getMovePSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MovePSDEActionId_Default(pSDEList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MOVEPSDEACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MultiSelect(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isMultiSelectDirty() : !pSDEList.isMultiSelectDirty()) {
            return null;
        }
        Integer n = pSDEList.getMultiSelect();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_MultiSelect_Default(pSDEList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MULTISELECT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NavPSDERId(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isNavPSDERIdDirty() : !pSDEList.isNavPSDERIdDirty()) {
            return null;
        }
        String string = pSDEList.getNavPSDERId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NavPSDERId_Default(pSDEList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NAVPSDERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NavPSDERName(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isNavPSDERNameDirty() : !pSDEList.isNavPSDERNameDirty()) {
            return null;
        }
        String string = pSDEList.getNavPSDERName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NavPSDERName_Default(pSDEList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NAVPSDERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NavPSDEViewBaseId(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isNavPSDEViewBaseIdDirty() : !pSDEList.isNavPSDEViewBaseIdDirty()) {
            return null;
        }
        String string = pSDEList.getNavPSDEViewBaseId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NavPSDEViewBaseId_Default(pSDEList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NAVPSDEVIEWBASEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NavViewFilter(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isNavViewFilterDirty() : !pSDEList.isNavViewFilterDirty()) {
            return null;
        }
        String string = pSDEList.getNavViewFilter();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NavViewFilter_Default(pSDEList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NAVVIEWFILTER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NavViewHeight(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isNavViewHeightDirty() : !pSDEList.isNavViewHeightDirty()) {
            return null;
        }
        Double d = pSDEList.getNavViewHeight();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_NavViewHeight_Default(pSDEList, bl2, bl3);
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

    protected EntityFieldError onCheckField_NavViewMaxHeight(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isNavViewMaxHeightDirty() : !pSDEList.isNavViewMaxHeightDirty()) {
            return null;
        }
        Double d = pSDEList.getNavViewMaxHeight();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_NavViewMaxHeight_Default(pSDEList, bl2, bl3);
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

    protected EntityFieldError onCheckField_NavViewMaxWidth(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isNavViewMaxWidthDirty() : !pSDEList.isNavViewMaxWidthDirty()) {
            return null;
        }
        Double d = pSDEList.getNavViewMaxWidth();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_NavViewMaxWidth_Default(pSDEList, bl2, bl3);
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

    protected EntityFieldError onCheckField_NavViewMinHeight(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isNavViewMinHeightDirty() : !pSDEList.isNavViewMinHeightDirty()) {
            return null;
        }
        Double d = pSDEList.getNavViewMinHeight();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_NavViewMinHeight_Default(pSDEList, bl2, bl3);
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

    protected EntityFieldError onCheckField_NavViewMinWidth(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isNavViewMinWidthDirty() : !pSDEList.isNavViewMinWidthDirty()) {
            return null;
        }
        Double d = pSDEList.getNavViewMinWidth();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_NavViewMinWidth_Default(pSDEList, bl2, bl3);
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

    protected EntityFieldError onCheckField_NavViewParam(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isNavViewParamDirty() : !pSDEList.isNavViewParamDirty()) {
            return null;
        }
        String string = pSDEList.getNavViewParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NavViewParam_Default(pSDEList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NAVVIEWPARAM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NavViewPos(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isNavViewPosDirty() : !pSDEList.isNavViewPosDirty()) {
            return null;
        }
        String string = pSDEList.getNavViewPos();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NavViewPos_Default(pSDEList, bl2, bl3);
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

    protected EntityFieldError onCheckField_NavViewShowMode(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isNavViewShowModeDirty() : !pSDEList.isNavViewShowModeDirty()) {
            return null;
        }
        Integer n = pSDEList.getNavViewShowMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_NavViewShowMode_Default(pSDEList, bl2, bl3);
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

    protected EntityFieldError onCheckField_NavViewWidth(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isNavViewWidthDirty() : !pSDEList.isNavViewWidthDirty()) {
            return null;
        }
        Double d = pSDEList.getNavViewWidth();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_NavViewWidth_Default(pSDEList, bl2, bl3);
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

    protected EntityFieldError onCheckField_No2PSDEUAGroupId(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isNo2PSDEUAGroupIdDirty() : !pSDEList.isNo2PSDEUAGroupIdDirty()) {
            return null;
        }
        String string = pSDEList.getNo2PSDEUAGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_No2PSDEUAGroupId_Default(pSDEList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NO2PSDEUAGROUPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_No2PSDEUAGroupName(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isNo2PSDEUAGroupNameDirty() : !pSDEList.isNo2PSDEUAGroupNameDirty()) {
            return null;
        }
        String string = pSDEList.getNo2PSDEUAGroupName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_No2PSDEUAGroupName_Default(pSDEList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NO2PSDEUAGROUPNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NoSort(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isNoSortDirty() : !pSDEList.isNoSortDirty()) {
            return null;
        }
        Integer n = pSDEList.getNoSort();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_NoSort_Default(pSDEList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NOSORT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OrderValuePSDEFId(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isOrderValuePSDEFIdDirty() : !pSDEList.isOrderValuePSDEFIdDirty()) {
            return null;
        }
        String string = pSDEList.getOrderValuePSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_OrderValuePSDEFId_Default(pSDEList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ORDERVALUEPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OrderValuePSDEFName(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isOrderValuePSDEFNameDirty() : !pSDEList.isOrderValuePSDEFNameDirty()) {
            return null;
        }
        String string = pSDEList.getOrderValuePSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_OrderValuePSDEFName_Default(pSDEList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ORDERVALUEPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PageSize(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isPageSizeDirty() : !pSDEList.isPageSizeDirty()) {
            return null;
        }
        Integer n = pSDEList.getPageSize();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PageSize_Default(pSDEList, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSACHandlerId(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isPSACHandlerIdDirty() : !pSDEList.isPSACHandlerIdDirty()) {
            return null;
        }
        String string = pSDEList.getPSACHandlerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSACHandlerId_Default(pSDEList, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSCtrlLogicGroupId(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isPSCtrlLogicGroupIdDirty() : !pSDEList.isPSCtrlLogicGroupIdDirty()) {
            return null;
        }
        String string = pSDEList.getPSCtrlLogicGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCtrlLogicGroupId_Default(pSDEList, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSCtrlMsgId(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isPSCtrlMsgIdDirty() : !pSDEList.isPSCtrlMsgIdDirty()) {
            return null;
        }
        String string = pSDEList.getPSCtrlMsgId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCtrlMsgId_Default(pSDEList, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEDSId(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isPSDEDSIdDirty() : !pSDEList.isPSDEDSIdDirty()) {
            return null;
        }
        String string = pSDEList.getPSDEDSId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDSId_Default(pSDEList, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isPSDEIdDirty() && !bl2 : !pSDEList.isPSDEIdDirty()) {
            return null;
        }
        String string = pSDEList.getPSDEId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default(pSDEList, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEListId(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isPSDEListIdDirty() && !bl2 : !pSDEList.isPSDEListIdDirty()) {
            return null;
        }
        String string = pSDEList.getPSDEListId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDELISTID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEListId_Default(pSDEList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDELISTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEListName(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isPSDEListNameDirty() && !bl2 : !pSDEList.isPSDEListNameDirty()) {
            return null;
        }
        String string = pSDEList.getPSDEListName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDELISTNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEListName_Default(pSDEList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDELISTNAME");
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
                String string4 = this.checkFieldDupRule(this.getPSDEListDEModel(), "PSDELISTNAME", string3, pSDEList, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDELISTNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isPSDENameDirty() && !bl2 : !pSDEList.isPSDENameDirty()) {
            return null;
        }
        String string = pSDEList.getPSDEName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default(pSDEList, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEUAGroupId(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isPSDEUAGroupIdDirty() : !pSDEList.isPSDEUAGroupIdDirty()) {
            return null;
        }
        String string = pSDEList.getPSDEUAGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEUAGroupId_Default(pSDEList, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEUAGroupName(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isPSDEUAGroupNameDirty() : !pSDEList.isPSDEUAGroupNameDirty()) {
            return null;
        }
        String string = pSDEList.getPSDEUAGroupName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEUAGroupName_Default(pSDEList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEUAGROUPNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDynaInstId(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isPSDynaInstIdDirty() : !pSDEList.isPSDynaInstIdDirty()) {
            return null;
        }
        String string = pSDEList.getPSDynaInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaInstId_Default(pSDEList, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysCssId(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isPSSysCssIdDirty() : !pSDEList.isPSSysCssIdDirty()) {
            return null;
        }
        String string = pSDEList.getPSSysCssId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysCssId_Default(pSDEList, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysPFPluginId(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isPSSysPFPluginIdDirty() : !pSDEList.isPSSysPFPluginIdDirty()) {
            return null;
        }
        String string = pSDEList.getPSSysPFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysPFPluginId_Default(pSDEList, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysReqItemId(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isPSSysReqItemIdDirty() : !pSDEList.isPSSysReqItemIdDirty()) {
            return null;
        }
        String string = pSDEList.getPSSysReqItemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysReqItemId_Default(pSDEList, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysViewPanelId(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isPSSysViewPanelIdDirty() : !pSDEList.isPSSysViewPanelIdDirty()) {
            return null;
        }
        String string = pSDEList.getPSSysViewPanelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysViewPanelId_Default(pSDEList, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSViewMsgGroupId(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isPSViewMsgGroupIdDirty() : !pSDEList.isPSViewMsgGroupIdDirty()) {
            return null;
        }
        String string = pSDEList.getPSViewMsgGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSViewMsgGroupId_Default(pSDEList, bl2, bl3);
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

    protected EntityFieldError onCheckField_QuickPSDEToolbarId(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isQuickPSDEToolbarIdDirty() : !pSDEList.isQuickPSDEToolbarIdDirty()) {
            return null;
        }
        String string = pSDEList.getQuickPSDEToolbarId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_QuickPSDEToolbarId_Default(pSDEList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("QUICKPSDETOOLBARID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RemovePSDEActionId(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isRemovePSDEActionIdDirty() : !pSDEList.isRemovePSDEActionIdDirty()) {
            return null;
        }
        String string = pSDEList.getRemovePSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RemovePSDEActionId_Default(pSDEList, bl2, bl3);
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

    protected EntityFieldError onCheckField_ShowHeader(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isShowHeaderDirty() : !pSDEList.isShowHeaderDirty()) {
            return null;
        }
        Integer n = pSDEList.getShowHeader();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ShowHeader_Default(pSDEList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SHOWHEADER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SRFSysPub(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isSRFSysPubDirty() : !pSDEList.isSRFSysPubDirty()) {
            return null;
        }
        Integer n = pSDEList.getSRFSysPub();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SRFSysPub_Default(pSDEList, bl2, bl3);
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

    protected EntityFieldError onCheckField_SwimlanePSCodeListId(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isSwimlanePSCodeListIdDirty() : !pSDEList.isSwimlanePSCodeListIdDirty()) {
            return null;
        }
        String string = pSDEList.getSwimlanePSCodeListId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SwimlanePSCodeListId_Default(pSDEList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SWIMLANEPSCODELISTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SwimlanePSDEFId(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isSwimlanePSDEFIdDirty() : !pSDEList.isSwimlanePSDEFIdDirty()) {
            return null;
        }
        String string = pSDEList.getSwimlanePSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SwimlanePSDEFId_Default(pSDEList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SWIMLANEPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SwimlanePSDEFName(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isSwimlanePSDEFNameDirty() : !pSDEList.isSwimlanePSDEFNameDirty()) {
            return null;
        }
        String string = pSDEList.getSwimlanePSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SwimlanePSDEFName_Default(pSDEList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SWIMLANEPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ToDoTask(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isToDoTaskDirty() : !pSDEList.isToDoTaskDirty()) {
            return null;
        }
        String string = pSDEList.getToDoTask();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ToDoTask_Default(pSDEList, bl2, bl3);
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

    protected EntityFieldError onCheckField_UpdatePSDEActionId(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isUpdatePSDEActionIdDirty() : !pSDEList.isUpdatePSDEActionIdDirty()) {
            return null;
        }
        String string = pSDEList.getUpdatePSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UpdatePSDEActionId_Default(pSDEList, bl2, bl3);
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

    protected EntityFieldError onCheckField_User2PSDEActionId(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isUser2PSDEActionIdDirty() : !pSDEList.isUser2PSDEActionIdDirty()) {
            return null;
        }
        String string = pSDEList.getUser2PSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_User2PSDEActionId_Default(pSDEList, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserPSDEActionId(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isUserPSDEActionIdDirty() : !pSDEList.isUserPSDEActionIdDirty()) {
            return null;
        }
        String string = pSDEList.getUserPSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserPSDEActionId_Default(pSDEList, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isUserTagDirty() : !pSDEList.isUserTagDirty()) {
            return null;
        }
        String string = pSDEList.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSDEList, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDEList pSDEList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEList.isUserTag2Dirty() : !pSDEList.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDEList.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSDEList, bl2, bl3);
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

    protected void onSyncEntity(PSDEList pSDEList, boolean bl) throws Exception {
        super.onSyncEntity(pSDEList, bl);
    }

    protected void onSyncIndexEntities(PSDEList pSDEList, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDEList, bl);
    }

    public Object getDataContextValue(PSDEList pSDEList, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null && StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDEACTION", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"GROUPMOVEPSDEACTIONID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"GROUPMOVEPSDEACTIONNAME", (boolean)true) == 0) && (object = super.getDataContextValue(pSDEList, "grouppsdeid", iDataContextParam)) != null) {
            return object;
        }
        object = super.getDataContextValue(pSDEList, string, iDataContextParam);
        if (object != null) {
            return object;
        }
        PSDataEntity pSDataEntity = pSDEList.getPSDE();
        if (pSDataEntity != null && pSDataEntity.contains(string)) {
            return pSDataEntity.get(string);
        }
        return null;
    }

    protected void onExportRelatedModel(PSDEList pSDEList, ArrayList<JSONObject> arrayList, int n) throws Exception {
        this.onExportRelatedModel_PSDEListItem_PSDEList(pSDEList, arrayList, n);
        this.onExportRelatedModel_PSDEListLogic_PSDEList(pSDEList, arrayList, n);
        super.onExportRelatedModel(pSDEList, arrayList, n);
    }

    protected void onExportRelatedModel_PSDEListItem_PSDEList(PSDEList pSDEList, ArrayList<JSONObject> arrayList, int n) throws Exception {
        PSDEListItemService pSDEListItemService = (PSDEListItemService)ServiceGlobal.getService(PSDEListItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEListItem> arrayList2 = pSDEListItemService.selectByPSDEList(pSDEList);
        if ((n & 2) != 0) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("srfdeid", (Object)"6bd0fb04c84d7b9a0cd3618c6101fd05");
            jSONObject.put("srfdename", (Object)"PSDELISTITEM");
            jSONObject.put("srfder1nsync", (Object)"true");
            jSONObject.put("srfder1nid", (Object)"DER1N_PSDELISTITEM_PSDELIST_PSDELISTID");
            jSONObject.put("srfarg", (Object)DataObject.getStringValue((IDataObject)pSDEList, (String)"PSDELISTID", (String)""));
            jSONObject.put("srfarg2", (Object)"");
            arrayList.add(jSONObject);
        }
        for (PSDEListItem pSDEListItem : arrayList2) {
            if (DataObject.getIntegerValue((IDataObject)pSDEListItem, (String)"srfsyspub", (int)1) == 0) continue;
            pSDEListItemService.exportModel(pSDEListItem, arrayList, n);
        }
    }

    protected void onExportRelatedModel_PSDEListLogic_PSDEList(PSDEList pSDEList, ArrayList<JSONObject> arrayList, int n) throws Exception {
        PSDEListLogicService pSDEListLogicService = (PSDEListLogicService)ServiceGlobal.getService(PSDEListLogicService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEListLogic> arrayList2 = pSDEListLogicService.selectByPSDEList(pSDEList);
        if ((n & 2) != 0) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("srfdeid", (Object)"93e462b5ae14281338147996788c827e");
            jSONObject.put("srfdename", (Object)"PSDELISTLOGIC");
            jSONObject.put("srfder1nsync", (Object)"true");
            jSONObject.put("srfder1nid", (Object)"DER1N_PSDELISTLOGIC_PSDELIST_PSDELISTID");
            jSONObject.put("srfarg", (Object)DataObject.getStringValue((IDataObject)pSDEList, (String)"PSDELISTID", (String)""));
            jSONObject.put("srfarg2", (Object)"");
            arrayList.add(jSONObject);
        }
        for (PSDEListLogic pSDEListLogic : arrayList2) {
            if (DataObject.getIntegerValue((IDataObject)pSDEListLogic, (String)"srfsyspub", (int)1) == 0) continue;
            pSDEListLogicService.exportModel(pSDEListLogic, arrayList, n);
        }
    }

    protected void onExportMajorModel(PSDEList pSDEList, ArrayList<JSONObject> arrayList, int n) throws Exception {
        this.onExportMajorModel_EmptyTextPSLanRes(pSDEList, arrayList, n);
        super.onExportMajorModel(pSDEList, arrayList, n);
    }

    protected void onExportMajorModel_EmptyTextPSLanRes(PSDEList pSDEList, ArrayList<JSONObject> arrayList, int n) throws Exception {
        if (pSDEList.getEmptyTextPSLanRes() != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            iService.exportModel(pSDEList.getEmptyTextPSLanRes(), arrayList, n);
        }
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ADPSDELOGICID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ADPSDELogicId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ADPSDELOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ADPSDELogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"APPENDDEITEMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AppendDEItems_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ASYNCPSDEDSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AsyncPSDEDSId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ASYNCPSDEDSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AsyncPSDEDSName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BATPSDETOOLBARID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BatPSDEToolbarId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BATPSDETOOLBARNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BatPSDEToolbarName_Default(iEntity, bl, bl2);
        }
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
        if (StringHelper.compare((String)string, (String)"CUSTOMCOND", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CustomCond_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CUSTOMTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CustomType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DYNAMODELFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaModelFlag_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"ENABLEEDIT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableEdit_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEITEMPRIV", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableItemPriv_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEPAGINGBAR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnablePagingBar_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"GROUPBARCLOSEMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupBarCloseMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPMOVEPSDEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupMovePSDEActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPMOVEPSDEACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupMovePSDEActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPPSCODELISTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupPSCodeListId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPPSCODELISTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupPSCodeListName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPPSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupPSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPPSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupPSDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPPSDEUAGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupPSDEUAGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPPSDEUAGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupPSDEUAGroupName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPPSSYSCSSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupPSSysCssId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPPSSYSCSSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupPSSysCssName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPPSSYSPFPLUGINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupPSSysPFPluginId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPPSSYSPFPLUGINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupPSSysPFPluginName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPSTYLE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupStyle_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPTEXTPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupTextPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPTEXTPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupTextPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ITEMPSSYSCSSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ItemPSSysCssId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ITEMPSSYSCSSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ItemPSSysCssName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ITEMPSSYSPFPLUGINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ItemPSSysPFPluginId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ITEMPSSYSPFPLUGINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ItemPSSysPFPluginName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LISTMODEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ListModel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOCKFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LockFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LVTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LVTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LVTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LVTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LVTAG3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LVTag3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LVTAG4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LVTag4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MINORSORTDIR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MinorSortDir_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MINORSORTPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"MINORSORTPSDEF", (boolean)true) == 0) {
            return this.onTestValueRule_MinorSortPSDEFId_MinorSortPSDEF(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MINORSORTPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MinorSortPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MINORSORTPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MinorSortPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MOBLISTSTYLE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MobListStyle_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MOVEPSDEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MovePSDEActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MOVEPSDEACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MovePSDEActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MULTISELECT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MultiSelect_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NAVPSDERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NavPSDERId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NAVPSDERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NavPSDERName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NAVPSDEVIEWBASEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NavPSDEViewBaseId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NAVPSDEVIEWBASENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NavPSDEViewBaseName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NAVVIEWFILTER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NavViewFilter_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"NAVVIEWPARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NavViewParam_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"NO2PSDEUAGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_No2PSDEUAGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO2PSDEUAGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_No2PSDEUAGroupName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NOSORT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NoSort_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUEPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValuePSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUEPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValuePSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PAGESIZE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PageSize_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSDEDSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDSId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDSName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDELISTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEListId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDELISTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEListName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEUAGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEUAGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEUAGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEUAGroupName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaInstId_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSSYSVIEWPANELID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysViewPanelId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSVIEWPANELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysViewPanelName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSVIEWMSGGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSViewMsgGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSVIEWMSGGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSViewMsgGroupName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"QUICKPSDETOOLBARID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_QuickPSDEToolbarId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"QUICKPSDETOOLBARNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_QuickPSDEToolbarName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REMOVEPSDEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RemovePSDEActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REMOVEPSDEACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RemovePSDEActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SHOWHEADER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ShowHeader_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SRFSYSPUB", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SRFSysPub_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SWIMLANEPSCODELISTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SwimlanePSCodeListId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SWIMLANEPSCODELISTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SwimlanePSCodeListName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SWIMLANEPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SwimlanePSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SWIMLANEPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SwimlanePSDEFName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_AppendDEItems_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_AsyncPSDEDSId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ASYNCPSDEDSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AsyncPSDEDSName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ASYNCPSDEDSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BatPSDEToolbarId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BATPSDETOOLBARID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BatPSDEToolbarName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BATPSDETOOLBARNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_DynaModelFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_EnableEdit_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableItemPriv_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnablePagingBar_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_GroupBarCloseMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_GroupMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GROUPMODE", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GroupMovePSDEActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GROUPMOVEPSDEACTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GroupMovePSDEActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GROUPMOVEPSDEACTIONNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected String onTestValueRule_GroupPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GROUPPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GroupPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GROUPPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GroupPSDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GROUPPSDEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GroupPSDEName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GROUPPSDENAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GroupPSDEUAGroupId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GROUPPSDEUAGROUPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GroupPSDEUAGroupName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GROUPPSDEUAGROUPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GroupPSSysCssId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GROUPPSSYSCSSID", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GroupPSSysCssName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GROUPPSSYSCSSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GroupPSSysPFPluginId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GROUPPSSYSPFPLUGINID", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GroupPSSysPFPluginName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GROUPPSSYSPFPLUGINNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GroupStyle_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GROUPSTYLE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GroupTextPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GROUPTEXTPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GroupTextPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GROUPTEXTPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ItemPSSysCssId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ITEMPSSYSCSSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ItemPSSysCssName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ITEMPSSYSCSSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ItemPSSysPFPluginId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ITEMPSSYSPFPLUGINID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ItemPSSysPFPluginName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ITEMPSSYSPFPLUGINNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ListModel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LISTMODEL", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
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

    protected String onTestValueRule_LVTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LVTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LVTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LVTAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LVTag3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LVTAG3", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LVTag4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LVTAG4", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
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

    protected String onTestValueRule_MinorSortPSDEFId_MinorSortPSDEF(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldDataSetRule("MINORSORTPSDEFID", "PSDEFIELD", DATASET_CURDE, iEntity, bl2, null, null, "\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d", true)) {
                return null;
            }
            return "\u9ed8\u8ba4\u6392\u5e8f\u5c5e\u6027\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d";
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

    protected String onTestValueRule_MobListStyle_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MOBLISTSTYLE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MovePSDEActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MOVEPSDEACTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MovePSDEActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MOVEPSDEACTIONNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MultiSelect_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_NavPSDERId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NAVPSDERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_NavPSDERName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NAVPSDERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_NavPSDEViewBaseId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NAVPSDEVIEWBASEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_NavPSDEViewBaseName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NAVPSDEVIEWBASENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_NavViewFilter_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NAVVIEWFILTER", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
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

    protected String onTestValueRule_NavViewParam_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NAVVIEWPARAM", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected String onTestValueRule_No2PSDEUAGroupId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NO2PSDEUAGROUPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_No2PSDEUAGroupName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NO2PSDEUAGROUPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_NoSort_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_OrderValuePSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ORDERVALUEPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OrderValuePSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ORDERVALUEPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PageSize_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_PSDEListId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDELISTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEListName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDELISTNAME", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false) && this.checkFieldRegExRule("PSDELISTNAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
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

    protected String onTestValueRule_QuickPSDEToolbarId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("QUICKPSDETOOLBARID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_QuickPSDEToolbarName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("QUICKPSDETOOLBARNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_ShowHeader_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_SRFSysPub_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_SwimlanePSCodeListId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SWIMLANEPSCODELISTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SwimlanePSCodeListName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SWIMLANEPSCODELISTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SwimlanePSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SWIMLANEPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SwimlanePSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SWIMLANEPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
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

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSDEList pSDEList) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDEList)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDEList pSDEList) throws Exception {
        Object object = pSDEList.get("PSDEID");
        if (object != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSDELIST_PSDATAENTITY_PSDEID", object);
        }
        super.onUpdateParent(pSDEList);
    }

    protected boolean isNeedUpdateParent() {
        return true;
    }

    protected void onCopyDetails(PSDEList pSDEList, Object object) throws Exception {
        PSDEList pSDEList2 = new PSDEList();
        pSDEList2.set("PSDELISTID", object);
        String string = DataObject.getStringValue((Object)pSDEList.get("PSDELISTID"));
        super.onCopyDetails(pSDEList, object);
    }

    @Override
    protected void exportCurXmlModel(PSDEList pSDEList, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDELIST");
        if (!bl) {
            super.exportCurXmlModel(pSDEList, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSDEList pSDEList, XmlNode xmlNode) throws Exception {
        this.exportRelatedXmlModel_PSDEListItem(pSDEList, xmlNode);
        this.exportRelatedXmlModel_PSDEListLogic(pSDEList, xmlNode);
        super.onExportRelatedXmlModel(pSDEList, xmlNode);
    }

    protected void exportRelatedXmlModel_PSDEListItem(PSDEList pSDEList, XmlNode xmlNode) throws Exception {
        PSDEListItemService pSDEListItemService = (PSDEListItemService)ServiceGlobal.getService(PSDEListItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEListItem> arrayList = null;
        String string = pSDEList.getPSDEListId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEListItemService.selectByPSDEList(pSDEList, "ORDER BY ORDERVALUE ASC") : pSDEListItemService.selectTempByPSDEList(pSDEList, "ORDER BY ORDERVALUE ASC");
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSDELISTITEMS");
            xmlNode.addNode(xmlNode2);
            for (PSDEListItem pSDEListItem : arrayList) {
                pSDEListItem.set("ORDERVALUE", null);
                pSDEListItemService.exportXmlModel(pSDEListItem, xmlNode2);
            }
        }
    }

    protected void exportRelatedXmlModel_PSDEListLogic(PSDEList pSDEList, XmlNode xmlNode) throws Exception {
        PSDEListLogicService pSDEListLogicService = (PSDEListLogicService)ServiceGlobal.getService(PSDEListLogicService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEListLogic> arrayList = null;
        String string = pSDEList.getPSDEListId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEListLogicService.selectByPSDEList(pSDEList, "ORDER BY ORDERVALUE ASC") : pSDEListLogicService.selectTempByPSDEList(pSDEList, "ORDER BY ORDERVALUE ASC");
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSDELISTLOGICS");
            xmlNode.addNode(xmlNode2);
            for (PSDEListLogic pSDEListLogic : arrayList) {
                pSDEListLogic.set("ORDERVALUE", null);
                pSDEListLogicService.exportXmlModel(pSDEListLogic, xmlNode2);
            }
        }
    }

    @Override
    protected void onImportRelatedXmlModel(PSDEList pSDEList, XmlNode xmlNode) throws Exception {
        XmlNode xmlNode2 = xmlNode.getChildNodeByNodeName("PSDELISTITEMS");
        this.importRelatedXmlModel_PSDEListItem(pSDEList, xmlNode2);
        XmlNode xmlNode3 = xmlNode.getChildNodeByNodeName("PSDELISTLOGICS");
        this.importRelatedXmlModel_PSDEListLogic(pSDEList, xmlNode3);
        super.onImportRelatedXmlModel(pSDEList, xmlNode);
    }

    protected void importRelatedXmlModel_PSDEListItem(PSDEList pSDEList, XmlNode xmlNode) throws Exception {
        int n = 100;
        PSDEListItemService pSDEListItemService = (PSDEListItemService)ServiceGlobal.getService(PSDEListItemService.class, (SessionFactory)this.getSessionFactory());
        String string = pSDEList.getPSDEListId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSDEListItemService.removeByPSDEList(pSDEList);
        } else {
            pSDEListItemService.removeTempByPSDEList(pSDEList);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSDEListItem pSDEListItem = new PSDEListItem();
                pSDEListItem.setOrderValue(n);
                n += 100;
                pSDEListItemService.fillParentInfo(pSDEListItem, "DER1N", "DER1N_PSDELISTITEM_PSDELIST_PSDELISTID", pSDEList.getPSDEListId());
                pSDEListItemService.importXmlModel(pSDEListItem, xmlNode2);
            }
        }
    }

    protected void importRelatedXmlModel_PSDEListLogic(PSDEList pSDEList, XmlNode xmlNode) throws Exception {
        int n = 100;
        PSDEListLogicService pSDEListLogicService = (PSDEListLogicService)ServiceGlobal.getService(PSDEListLogicService.class, (SessionFactory)this.getSessionFactory());
        String string = pSDEList.getPSDEListId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSDEListLogicService.removeByPSDEList(pSDEList);
        } else {
            pSDEListLogicService.removeTempByPSDEList(pSDEList);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSDEListLogic pSDEListLogic = new PSDEListLogic();
                pSDEListLogic.setOrderValue(n);
                n += 100;
                pSDEListLogicService.fillParentInfo(pSDEListLogic, "DER1N", "DER1N_PSDELISTLOGIC_PSDELIST_PSDELISTID", pSDEList.getPSDEListId());
                pSDEListLogicService.importXmlModel(pSDEListLogic, xmlNode2);
            }
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDEList pSDEList, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDEList, string);
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
            return "DER1N_PSDELIST_PSDATAENTITY_PSDEID";
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
    public String getModelV2Tag(PSDEList pSDEList) {
        if (!StringHelper.isNullOrEmpty((String)pSDEList.getPSDEListName())) {
            return pSDEList.getPSDEListName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSDEList.getCodeName())) {
            return pSDEList.getCodeName();
        }
        return super.getModelV2Tag(pSDEList);
    }

    @Override
    public boolean setModelV2Tag(PSDEList pSDEList, String string) {
        pSDEList.setPSDEListName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSDELISTNAME", "");
        map.put("CODENAME", "");
        map.put("CODENAME", "");
        map.put("PSDELISTNAME", "");
        map.put("PSDEID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDEList pSDEList, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDEList.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDEList, true);
        pSDEList.set("PSDELISTNAME", string);
        if (this.select(pSDEList, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSDEList, true);
        return super.getModelV2Entity(pSDEList, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDEList pSDEList, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSDEList, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        if (StringHelper.compare((String)"DER1N_PSDELISTITEM_PSDELIST_PSDELISTID", (String)string, (boolean)true) == 0) {
            return false;
        }
        return StringHelper.compare((String)"DER1N_PSDELISTLOGIC_PSDELIST_PSDELISTID", (String)string, (boolean)true) != 0;
    }

    @Override
    protected void onExportRelatedModelV2(PSDEList pSDEList, String string, String string2) throws Exception {
        Object var4_4 = null;
        super.onExportRelatedModelV2(pSDEList, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSDEList pSDEList, ObjectNode objectNode, String string, boolean bl) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDELISTITEM_PSDELIST_PSDELISTID")) {
            pSCoreSysServiceBase = (PSDEListItemService)ServiceGlobal.getService(PSDEListItemService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<ObjectNode> arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                File file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDELIST#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDELISTITEM", (Object)pSDEList.getPSDEListId()));
                if (file.exists()) {
                    arrayList = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty(line)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString(line));
                    }
                }
            } else {
                arrayList = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSDELIST#%1$s", (Object)pSDEList.getPSDEListId());
                for (PSDEListItem item : ((PSDEListItemServiceBase)pSCoreSysServiceBase).selectByPSDEList(pSDEList)) {
                    if (StringHelper.compare(scope, ((PSDEListItemServiceBase)pSCoreSysServiceBase).getModelV2ResScope(item), false) != 0) continue;
                    arrayList.add(PSModelV2Helper.toJSONObject(item, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                ArrayNode arrayNode = objectNode.putArray(pSCoreSysServiceBase.getModelV2Name(false).toLowerCase());
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
                        if (objectNode.has("psdelistitemname")) {
                            string = objectNode.get("psdelistitemname").asText();
                        }
                        if (objectNode2.has("psdelistitemname")) {
                            string2 = objectNode2.get("psdelistitemname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode childNode : arrayList) {
                    PSDEListItem item = new PSDEListItem();
                    PSModelV2Helper.fromJSONObject(item, childNode, false);
                    arrayNode.add((JsonNode)pSCoreSysServiceBase.exportModelV2(item, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDELISTLOGIC_PSDELIST_PSDELISTID")) {
            pSCoreSysServiceBase = (PSDEListLogicService)ServiceGlobal.getService(PSDEListLogicService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<ObjectNode> arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                File file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDELIST#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDELISTLOGIC", (Object)pSDEList.getPSDEListId()));
                if (file.exists()) {
                    arrayList = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty(line)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString(line));
                    }
                }
            } else {
                arrayList = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSDELIST#%1$s", (Object)pSDEList.getPSDEListId());
                for (PSDEListLogic logic : ((PSDEListLogicServiceBase)pSCoreSysServiceBase).selectByPSDEList(pSDEList)) {
                    if (StringHelper.compare(scope, ((PSDEListLogicServiceBase)pSCoreSysServiceBase).getModelV2ResScope(logic), false) != 0) continue;
                    arrayList.add(PSModelV2Helper.toJSONObject(logic, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                ArrayNode arrayNode = objectNode.putArray(pSCoreSysServiceBase.getModelV2Name(false).toLowerCase());
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
                        if (objectNode.has("psdelistlogicname")) {
                            string = objectNode.get("psdelistlogicname").asText();
                        }
                        if (objectNode2.has("psdelistlogicname")) {
                            string2 = objectNode2.get("psdelistlogicname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode childNode : arrayList) {
                    PSDEListLogic logic = new PSDEListLogic();
                    PSModelV2Helper.fromJSONObject(logic, childNode, false);
                    arrayNode.add((JsonNode)pSCoreSysServiceBase.exportModelV2(logic, string));
                }
            }
        }
        super.onExportCurModelV2(pSDEList, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSDEList pSDEList) throws Exception {
        String string;
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEListItemService)ServiceGlobal.getService(PSDEListItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEListItem> items = ((PSDEListItemServiceBase)pSCoreSysServiceBase).selectByPSDEList(pSDEList);
        String string2 = StringHelper.format((String)"PSDELIST#%1$s", (Object)pSDEList.getPSDEListId());
        for (PSDEListItem entityBase : items) {
            string = ((PSDEListItemServiceBase)pSCoreSysServiceBase).getModelV2ResScope(entityBase);
            if (StringHelper.compare((String)string2, (String)string, (boolean)false) != 0) continue;
            pSCoreSysServiceBase.emptyModelV2(entityBase);
        }
        SqlParamList params = new SqlParamList();
        params.addString(pSDEList.getPSDEListId());
        ((PSDEListItemServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        ((PSDEListItemServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "DELETE FROM T_SRFPSDELISTITEM WHERE PSDELISTID = ?", params);
        pSCoreSysServiceBase = (PSDEListLogicService)ServiceGlobal.getService(PSDEListLogicService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEListLogic> logics = ((PSDEListLogicServiceBase)pSCoreSysServiceBase).selectByPSDEList(pSDEList);
        string2 = StringHelper.format((String)"PSDELIST#%1$s", (Object)pSDEList.getPSDEListId());
        for (PSDEListLogic pSDEListLogic : logics) {
            string = ((PSDEListLogicServiceBase)pSCoreSysServiceBase).getModelV2ResScope(pSDEListLogic);
            if (StringHelper.compare((String)string2, (String)string, (boolean)false) != 0) continue;
            pSCoreSysServiceBase.emptyModelV2(pSDEListLogic);
        }
        params = new SqlParamList();
        params.addString(pSDEList.getPSDEListId());
        ((PSDEListLogicServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        ((PSDEListLogicServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "DELETE FROM T_SRFPSDELISTLOGIC WHERE PSDELISTID = ?", params);
        super.onEmptyModelV2(pSDEList);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEListItemService)ServiceGlobal.getService(PSDEListItemService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSDEListLogicService)ServiceGlobal.getService(PSDEListLogicService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSDEList pSDEList, String string, String string2) throws Exception {
        IEntity iEntity = null;
        EntityBase entityBase = new PSDEListItem();
        entityBase.set("PSDELISTID", pSDEList.getPSDEListId());
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEListItemService)ServiceGlobal.getService(PSDEListItemService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSDEListLogic();
        entityBase.set("PSDELISTID", pSDEList.getPSDEListId());
        pSCoreSysServiceBase = (PSDEListLogicService)ServiceGlobal.getService(PSDEListLogicService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSDEList, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSDEList pSDEList, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEListItemService)ServiceGlobal.getService(PSDEListItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayNode arrayNode = null;
        String string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                ObjectNode childNode = (ObjectNode)arrayNode.get(i);
                PSDEListItem item = new PSDEListItem();
                item.setListPSDEId(pSDEList.getPSDEId());
                item.setPSDEListId(pSDEList.getPSDEListId());
                item.setPSDEListName(pSDEList.getPSDEListName());
                pSCoreSysServiceBase.compileModelV2(item, childNode, string, null, n);
            }
        } else {
            String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            File directory = new File(string4);
            if (directory.exists()) {
                for (File childDirectory : directory.listFiles()) {
                    if (!childDirectory.isDirectory()) continue;
                    PSDEListItem item = new PSDEListItem();
                    item.setListPSDEId(pSDEList.getPSDEId());
                    item.setPSDEListId(pSDEList.getPSDEListId());
                    item.setPSDEListName(pSDEList.getPSDEListName());
                    pSCoreSysServiceBase.compileModelV2(item, null, string, childDirectory.getCanonicalPath(), n);
                }
            }
        }
        pSCoreSysServiceBase = (PSDEListLogicService)ServiceGlobal.getService(PSDEListLogicService.class, (SessionFactory)this.getSessionFactory());
        arrayNode = null;
        string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                ObjectNode childNode = (ObjectNode)arrayNode.get(i);
                PSDEListLogic logic = new PSDEListLogic();
                logic.setPSDEListId(pSDEList.getPSDEListId());
                logic.setPSDEListName(pSDEList.getPSDEListName());
                pSCoreSysServiceBase.compileModelV2(logic, childNode, string, null, n);
            }
        } else {
            String string5 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            File directory = new File(string5);
            if (directory.exists()) {
                for (File childDirectory : directory.listFiles()) {
                    if (!childDirectory.isDirectory()) continue;
                    PSDEListLogic logic = new PSDEListLogic();
                    logic.setPSDEListId(pSDEList.getPSDEListId());
                    logic.setPSDEListName(pSDEList.getPSDEListName());
                    pSCoreSysServiceBase.compileModelV2(logic, null, string, childDirectory.getCanonicalPath(), n);
                }
            }
        }
        super.onCompileRelatedModelV2(pSDEList, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSDEList pSDEList, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSDELISTITEM_PSDELIST_PSDELISTID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSDEListItems(pSDEList, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSDELISTLOGIC_PSDELIST_PSDELISTID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSDEListLogics(pSDEList, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSDEList, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSDEListItems(PSDEList pSDEList, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDELISTITEM", true), (boolean)false) == 0) {
            PSDEListItemService pSDEListItemService = (PSDEListItemService)ServiceGlobal.getService(PSDEListItemService.class, (SessionFactory)this.getSessionFactory());
            PSDEListItem pSDEListItem = new PSDEListItem();
            pSDEListItem.setPSDEListItemId(pSMOSFile.getPSModelId());
            if (!pSDEListItemService.get(pSDEListItem, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSDEListItem.getPSDEListId(), (String)pSDEList.getPSDEListId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSDEListItemService.exportModelV2(pSDEListItem);
            pSDEListItem.reset();
            if (!pSDEListItemService.setModelV2ResScope(pSDEListItem, "PSDELIST", pSDEList.getPSDEListId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSDEListItemService.importModelV2(pSDEListItem, objectNode);
            SessionFactoryManager.commit();
            return pSDEListItemService.getFile(pSDEListItem);
        }
        return null;
    }

    protected PSMOSFile onPasteFile_PSDEListLogics(PSDEList pSDEList, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDELISTLOGIC", true), (boolean)false) == 0) {
            PSDEListLogicService pSDEListLogicService = (PSDEListLogicService)ServiceGlobal.getService(PSDEListLogicService.class, (SessionFactory)this.getSessionFactory());
            PSDEListLogic pSDEListLogic = new PSDEListLogic();
            pSDEListLogic.setPSDEListLogicId(pSMOSFile.getPSModelId());
            if (!pSDEListLogicService.get(pSDEListLogic, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSDEListLogic.getPSDEListId(), (String)pSDEList.getPSDEListId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSDEListLogicService.exportModelV2(pSDEListLogic);
            pSDEListLogic.reset();
            if (!pSDEListLogicService.setModelV2ResScope(pSDEListLogic, "PSDELIST", pSDEList.getPSDEListId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSDEListLogicService.importModelV2(pSDEListLogic, objectNode);
            SessionFactoryManager.commit();
            return pSDEListLogicService.getFile(pSDEListLogic);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSDEList pSDEList, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSDEListItems(pSDEList, list);
        this.onFillPasteHelps_PSDEListLogics(pSDEList, list);
        super.onFillPasteHelps(pSDEList, list);
    }

    protected void onFillPasteHelps_PSDEListItems(PSDEList pSDEList, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDELISTITEM");
        pSHelpSection.setSectionParam2("DER1N_PSDELISTITEM_PSDELIST_PSDELISTID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5b9e\u4f53\u5217\u8868]\u7684[\u5b9e\u4f53\u591a\u6570\u636e\u90e8\u4ef6\u9879]");
        list.add(pSHelpSection);
    }

    protected void onFillPasteHelps_PSDEListLogics(PSDEList pSDEList, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDELISTLOGIC");
        pSHelpSection.setSectionParam2("DER1N_PSDELISTLOGIC_PSDELIST_PSDELISTID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5b9e\u4f53\u5217\u8868]\u7684[\u5b9e\u4f53\u5217\u8868\u903b\u8f91]");
        list.add(pSHelpSection);
    }

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSDEList pSDEList, boolean bl) {
        return defaultValueMap;
    }

    static {
        defaultValueMap.put("PSDELISTNAME", "List");
    }
}
