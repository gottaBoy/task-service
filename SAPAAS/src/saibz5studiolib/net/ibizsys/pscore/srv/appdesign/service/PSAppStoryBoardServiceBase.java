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
package net.ibizsys.pscore.srv.appdesign.service;

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
import net.ibizsys.pscore.srv.appdesign.dao.PSAppStoryBoardDAO;
import net.ibizsys.pscore.srv.appdesign.demodel.PSAppStoryBoardDEModel;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppSBItem;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppSBItemBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppSBItemRS;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppSBItemRSBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppStoryBoard;
import net.ibizsys.pscore.srv.appdesign.service.PSAppSBItemRSService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppSBItemRSServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppSBItemService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppSBItemServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysAppBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSAppStoryBoardServiceBase
extends PSCoreSysServiceBase<PSAppStoryBoard> {
    private static final Log log = LogFactory.getLog(PSAppStoryBoardServiceBase.class);
    public static final String DATASET_CURAPP = "CurApp";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_X_ADDSYNCMODELTASK = "X_ADDSYNCMODELTASK";
    public static final String ACTION_CREATEWITHMODEL = "CreateWithModel";
    public static final String ACTION_GETDRAFTFROMWITHMODEL = "GetDraftFromWithModel";
    public static final String ACTION_GETDRAFTWITHMODEL = "GetDraftWithModel";
    public static final String ACTION_GETWITHMODEL = "GetWithModel";
    public static final String ACTION_UPDATEWITHMODEL = "UpdateWithModel";
    private static Map<String, String> defaultValueMap = new HashMap<String, String>();
    private PSAppStoryBoardDEModel pSAppStoryBoardDEModel;
    private PSAppStoryBoardDAO pSAppStoryBoardDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.appdesign.service.PSAppStoryBoardService";
    }

    public PSAppStoryBoardDEModel getPSAppStoryBoardDEModel() {
        if (this.pSAppStoryBoardDEModel == null) {
            try {
                this.pSAppStoryBoardDEModel = (PSAppStoryBoardDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.appdesign.demodel.PSAppStoryBoardDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSAppStoryBoardDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSAppStoryBoardDEModel();
    }

    public PSAppStoryBoardDAO getPSAppStoryBoardDAO() {
        if (this.pSAppStoryBoardDAO == null) {
            try {
                this.pSAppStoryBoardDAO = (PSAppStoryBoardDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.appdesign.dao.PSAppStoryBoardDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSAppStoryBoardDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSAppStoryBoardDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURAPP, (boolean)true) == 0) {
            return this.fetchCurApp(iDEDataSetFetchContext);
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
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchTempDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSetTemp(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_X_ADDSYNCMODELTASK, (boolean)true) == 0) {
            this.addSyncModelTask((PSAppStoryBoard)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_CREATEWITHMODEL, (boolean)true) == 0) {
            this.createWithModel((PSAppStoryBoard)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_GETDRAFTFROMWITHMODEL, (boolean)true) == 0) {
            this.getDraftFromWithModel((PSAppStoryBoard)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_GETDRAFTWITHMODEL, (boolean)true) == 0) {
            this.getDraftWithModel((PSAppStoryBoard)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_GETWITHMODEL, (boolean)true) == 0) {
            this.getWithModel((PSAppStoryBoard)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_UPDATEWITHMODEL, (boolean)true) == 0) {
            this.updateWithModel((PSAppStoryBoard)iEntity);
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

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, true);
        return dBFetchResult;
    }

    public void addSyncModelTask(PSAppStoryBoard pSAppStoryBoard) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_X_ADDSYNCMODELTASK, 0, (IEntity)pSAppStoryBoard, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSAppStoryBoard, ACTION_X_ADDSYNCMODELTASK);
        final PSAppStoryBoard pSAppStoryBoard2 = pSAppStoryBoard;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSAppStoryBoardServiceBase.this.getService(), PSAppStoryBoardServiceBase.ACTION_X_ADDSYNCMODELTASK, 40, (IEntity)pSAppStoryBoard2, null).getResult() != 1) {
                    PSAppStoryBoardServiceBase.this.onAddSyncModelTask(pSAppStoryBoard2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_X_ADDSYNCMODELTASK, 99, (IEntity)pSAppStoryBoard, null);
        }
    }

    protected void onAddSyncModelTask(PSAppStoryBoard pSAppStoryBoard) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[X_ADDSYNCMODELTASK]");
    }

    public void createWithModel(PSAppStoryBoard pSAppStoryBoard) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_CREATEWITHMODEL, 0, (IEntity)pSAppStoryBoard, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSAppStoryBoard, ACTION_CREATEWITHMODEL);
        final PSAppStoryBoard pSAppStoryBoard2 = pSAppStoryBoard;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSAppStoryBoardServiceBase.this.getService(), PSAppStoryBoardServiceBase.ACTION_CREATEWITHMODEL, 40, (IEntity)pSAppStoryBoard2, null).getResult() != 1) {
                    PSAppStoryBoardServiceBase.this.onCreateWithModel(pSAppStoryBoard2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_CREATEWITHMODEL, 99, (IEntity)pSAppStoryBoard, null);
        }
    }

    protected void onCreateWithModel(PSAppStoryBoard pSAppStoryBoard) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[CreateWithModel]");
    }

    public void getDraftFromWithModel(PSAppStoryBoard pSAppStoryBoard) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_GETDRAFTFROMWITHMODEL, 0, (IEntity)pSAppStoryBoard, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSAppStoryBoard, ACTION_GETDRAFTFROMWITHMODEL);
        final PSAppStoryBoard pSAppStoryBoard2 = pSAppStoryBoard;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSAppStoryBoardServiceBase.this.getService(), PSAppStoryBoardServiceBase.ACTION_GETDRAFTFROMWITHMODEL, 40, (IEntity)pSAppStoryBoard2, null).getResult() != 1) {
                    PSAppStoryBoardServiceBase.this.onGetDraftFromWithModel(pSAppStoryBoard2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_GETDRAFTFROMWITHMODEL, 99, (IEntity)pSAppStoryBoard, null);
        }
    }

    protected void onGetDraftFromWithModel(PSAppStoryBoard pSAppStoryBoard) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[GetDraftFromWithModel]");
    }

    public void getDraftWithModel(PSAppStoryBoard pSAppStoryBoard) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_GETDRAFTWITHMODEL, 0, (IEntity)pSAppStoryBoard, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSAppStoryBoard, ACTION_GETDRAFTWITHMODEL);
        final PSAppStoryBoard pSAppStoryBoard2 = pSAppStoryBoard;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSAppStoryBoardServiceBase.this.getService(), PSAppStoryBoardServiceBase.ACTION_GETDRAFTWITHMODEL, 40, (IEntity)pSAppStoryBoard2, null).getResult() != 1) {
                    PSAppStoryBoardServiceBase.this.onGetDraftWithModel(pSAppStoryBoard2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_GETDRAFTWITHMODEL, 99, (IEntity)pSAppStoryBoard, null);
        }
    }

    protected void onGetDraftWithModel(PSAppStoryBoard pSAppStoryBoard) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[GetDraftWithModel]");
    }

    public void getWithModel(PSAppStoryBoard pSAppStoryBoard) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_GETWITHMODEL, 0, (IEntity)pSAppStoryBoard, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSAppStoryBoard, ACTION_GETWITHMODEL);
        final PSAppStoryBoard pSAppStoryBoard2 = pSAppStoryBoard;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSAppStoryBoardServiceBase.this.getService(), PSAppStoryBoardServiceBase.ACTION_GETWITHMODEL, 40, (IEntity)pSAppStoryBoard2, null).getResult() != 1) {
                    PSAppStoryBoardServiceBase.this.onGetWithModel(pSAppStoryBoard2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_GETWITHMODEL, 99, (IEntity)pSAppStoryBoard, null);
        }
    }

    protected void onGetWithModel(PSAppStoryBoard pSAppStoryBoard) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[GetWithModel]");
    }

    public void updateWithModel(PSAppStoryBoard pSAppStoryBoard) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_UPDATEWITHMODEL, 0, (IEntity)pSAppStoryBoard, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSAppStoryBoard, ACTION_UPDATEWITHMODEL);
        final PSAppStoryBoard pSAppStoryBoard2 = pSAppStoryBoard;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSAppStoryBoardServiceBase.this.getService(), PSAppStoryBoardServiceBase.ACTION_UPDATEWITHMODEL, 40, (IEntity)pSAppStoryBoard2, null).getResult() != 1) {
                    PSAppStoryBoardServiceBase.this.onUpdateWithModel(pSAppStoryBoard2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_UPDATEWITHMODEL, 99, (IEntity)pSAppStoryBoard, null);
        }
    }

    protected void onUpdateWithModel(PSAppStoryBoard pSAppStoryBoard) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[UpdateWithModel]");
    }

    protected void onFillParentInfo(PSAppStoryBoard pSAppStoryBoard, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPSTORYBOARD_PSSYSAPP_PSSYSAPPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService", (SessionFactory)this.getSessionFactory());
            PSSysApp pSSysApp = (PSSysApp)iService.getDEModel().createEntity();
            pSSysApp.set("PSSYSAPPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysApp);
            } else {
                iService.get((IEntity)pSSysApp);
            }
            this.onFillParentInfo_PSSysApp(pSAppStoryBoard, pSSysApp);
            return;
        }
        super.onFillParentInfo((IEntity)pSAppStoryBoard, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSSysApp(PSAppStoryBoard pSAppStoryBoard, PSSysApp pSSysApp) throws Exception {
        pSAppStoryBoard.setPSSysAppId(pSSysApp.getPSSysAppId());
        pSAppStoryBoard.setPSSysAppName(pSSysApp.getPSSysAppName());
    }

    protected void onFillEntityFullInfo(PSAppStoryBoard pSAppStoryBoard, boolean bl) throws Exception {
        if (bl) {
            if (pSAppStoryBoard.getCodeName() == null) {
                pSAppStoryBoard.setCodeName((String)this.getDefaultValue(this.getWebContext(), "USER", "StoryBoard", 25));
            }
            if (pSAppStoryBoard.getDefaultFlag() == null) {
                pSAppStoryBoard.setDefaultFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSAppStoryBoard.getPSAppStoryBoardName() == null) {
                pSAppStoryBoard.setPSAppStoryBoardName((String)this.getDefaultValue(this.getWebContext(), "USER", "\u6545\u4e8b\u677f", 25));
            }
            if (pSAppStoryBoard.getValidFlag() == null) {
                pSAppStoryBoard.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo((IEntity)pSAppStoryBoard, bl);
        this.onFillEntityFullInfo_PSSysApp(pSAppStoryBoard, bl);
    }

    protected void onFillEntityFullInfo_PSSysApp(PSAppStoryBoard pSAppStoryBoard, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSAppStoryBoard pSAppStoryBoard, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSAppStoryBoard, bl);
    }

    public ArrayList<PSAppStoryBoard> selectByPSSysApp(PSSysAppBase pSSysAppBase) throws Exception {
        return this.selectByPSSysApp(pSSysAppBase, "", -1);
    }

    public ArrayList<PSAppStoryBoard> selectByPSSysApp(PSSysAppBase pSSysAppBase, String string) throws Exception {
        return this.selectByPSSysApp(pSSysAppBase, string, -1);
    }

    public ArrayList<PSAppStoryBoard> selectByPSSysApp(PSSysAppBase pSSysAppBase, String string, int n) throws Exception {
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

    public void testRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
        ArrayList<PSAppStoryBoard> arrayList = this.selectByPSSysApp(pSSysApp, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSAPP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysApp);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPSTORYBOARD_PSSYSAPP_PSSYSAPPID", "", iDataEntityModel.getName(), "PSAPPSTORYBOARD", iDataEntityModel.getDataInfo((IEntity)pSSysApp), arrayList.get(0)));
        }
    }

    public void resetPSSysApp(PSSysApp pSSysApp) throws Exception {
        ArrayList<PSAppStoryBoard> arrayList = this.selectByPSSysApp(pSSysApp);
        for (PSAppStoryBoard pSAppStoryBoard : arrayList) {
            PSAppStoryBoard pSAppStoryBoard2 = (PSAppStoryBoard)this.getDEModel().createEntity();
            pSAppStoryBoard2.setPSAppStoryBoardId(pSAppStoryBoard.getPSAppStoryBoardId());
            pSAppStoryBoard2.setPSSysAppId(null);
            this.update(pSAppStoryBoard2);
        }
    }

    public void removeByPSSysApp(PSSysApp pSSysApp) throws Exception {
        final PSSysApp pSSysApp2 = pSSysApp;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppStoryBoardServiceBase.this.onBeforeRemoveByPSSysApp(pSSysApp2);
                PSAppStoryBoardServiceBase.this.internalRemoveByPSSysApp(pSSysApp2);
                PSAppStoryBoardServiceBase.this.onAfterRemoveByPSSysApp(pSSysApp2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    protected void internalRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
        ArrayList<PSAppStoryBoard> arrayList = this.selectByPSSysApp(pSSysApp);
        this.onBeforeRemoveByPSSysApp(pSSysApp, arrayList);
        for (PSAppStoryBoard pSAppStoryBoard : arrayList) {
            this.remove((IEntity)pSAppStoryBoard);
        }
        this.onAfterRemoveByPSSysApp(pSSysApp, arrayList);
    }

    protected void onAfterRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    protected void onBeforeRemoveByPSSysApp(PSSysApp pSSysApp, ArrayList<PSAppStoryBoard> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysApp(PSSysApp pSSysApp, ArrayList<PSAppStoryBoard> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSAppStoryBoard pSAppStoryBoard) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSAppSBItemRSService)ServiceGlobal.getService(PSAppSBItemRSService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppSBItemRSServiceBase)pSCoreSysServiceBase).testRemoveByPSAppStoryBoard(pSAppStoryBoard);
        ((PSAppSBItemRSServiceBase)pSCoreSysServiceBase).removeByPSAppStoryBoard(pSAppStoryBoard);
        pSCoreSysServiceBase = (PSAppSBItemService)ServiceGlobal.getService(PSAppSBItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppSBItemServiceBase)pSCoreSysServiceBase).testRemoveByPSAppStoryBoard(pSAppStoryBoard);
        ((PSAppSBItemServiceBase)pSCoreSysServiceBase).removeByPSAppStoryBoard(pSAppStoryBoard);
        super.onBeforeRemove(pSAppStoryBoard);
    }

    protected void onBeforeRemoveTemp(PSAppStoryBoard pSAppStoryBoard) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSAppSBItemRSService)ServiceGlobal.getService(PSAppSBItemRSService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppSBItemRSServiceBase)pSCoreSysServiceBase).removeTempByPSAppStoryBoard(pSAppStoryBoard);
        pSCoreSysServiceBase = (PSAppSBItemService)ServiceGlobal.getService(PSAppSBItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppSBItemServiceBase)pSCoreSysServiceBase).removeTempByPSAppStoryBoard(pSAppStoryBoard);
        super.onBeforeRemoveTemp((IEntity)pSAppStoryBoard);
    }

    protected void getRelatedDataTempMajor(PSAppStoryBoard pSAppStoryBoard) throws Exception {
        this.getRelatedDataTempMajor_PSAppSBItem(pSAppStoryBoard);
        this.getRelatedDataTempMajor_PSAppSBItemRS(pSAppStoryBoard);
        super.getRelatedDataTempMajor((IEntity)pSAppStoryBoard);
    }

    protected void getRelatedDataTempMajor_PSAppSBItem(PSAppStoryBoard pSAppStoryBoard) throws Exception {
        PSAppSBItemService pSAppSBItemService = (PSAppSBItemService)ServiceGlobal.getService(PSAppSBItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSAppSBItem> arrayList = null;
        String string = pSAppStoryBoard.getPSAppStoryBoardId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSAppSBItemService.selectByPSAppStoryBoard(pSAppStoryBoard) : pSAppSBItemService.selectTempByPSAppStoryBoard(pSAppStoryBoard);
        for (PSAppSBItem pSAppSBItem : arrayList) {
            pSAppSBItemService.getTempMajor(pSAppSBItem);
        }
    }

    protected void getRelatedDataTempMajor_PSAppSBItemRS(PSAppStoryBoard pSAppStoryBoard) throws Exception {
        PSAppSBItemRSService pSAppSBItemRSService = (PSAppSBItemRSService)ServiceGlobal.getService(PSAppSBItemRSService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSAppSBItemRS> arrayList = null;
        String string = pSAppStoryBoard.getPSAppStoryBoardId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSAppSBItemRSService.selectByPSAppStoryBoard(pSAppStoryBoard) : pSAppSBItemRSService.selectTempByPSAppStoryBoard(pSAppStoryBoard);
        for (PSAppSBItemRS pSAppSBItemRS : arrayList) {
            pSAppSBItemRSService.getTempMajor(pSAppSBItemRS);
        }
    }

    protected void updateRelatedDataTempMajor(PSAppStoryBoard pSAppStoryBoard, PSAppStoryBoard pSAppStoryBoard2) throws Exception {
        ArrayList<PSAppSBItemRS> arrayList = this.updateRelatedDataTempMajor_removePSAppSBItemRS(pSAppStoryBoard, pSAppStoryBoard2);
        ArrayList<PSAppSBItem> arrayList2 = this.updateRelatedDataTempMajor_removePSAppSBItem(pSAppStoryBoard, pSAppStoryBoard2);
        this.updateRelatedDataTempMajor_updatePSAppSBItem(pSAppStoryBoard, pSAppStoryBoard2, arrayList2);
        this.updateRelatedDataTempMajor_updatePSAppSBItemRS(pSAppStoryBoard, pSAppStoryBoard2, arrayList);
        super.updateRelatedDataTempMajor((IEntity)pSAppStoryBoard, (IEntity)pSAppStoryBoard2);
    }

    protected ArrayList<PSAppSBItem> updateRelatedDataTempMajor_removePSAppSBItem(PSAppStoryBoard pSAppStoryBoard, PSAppStoryBoard pSAppStoryBoard2) throws Exception {
        PSAppSBItemService pSAppSBItemService = (PSAppSBItemService)ServiceGlobal.getService(PSAppSBItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSAppSBItem> arrayList = pSAppSBItemService.selectTempByPSAppStoryBoard(pSAppStoryBoard);
        ArrayList<PSAppSBItem> arrayList2 = pSAppSBItemService.selectByPSAppStoryBoard(pSAppStoryBoard2);
        HashMap<String, PSAppSBItem> hashMap = new HashMap<String, PSAppSBItem>();
        for (PSAppSBItem pSAppSBItem : arrayList2) {
            hashMap.put(pSAppSBItem.getPSAppSBItemId(), pSAppSBItem);
        }
        for (PSAppSBItem pSAppSBItem : arrayList) {
            Object object = pSAppSBItem.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSAppSBItem pSAppSBItem : hashMap.values()) {
            pSAppSBItemService.remove((IEntity)pSAppSBItem);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSAppSBItem(PSAppStoryBoard pSAppStoryBoard, PSAppStoryBoard pSAppStoryBoard2, ArrayList<PSAppSBItem> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSAppSBItemService pSAppSBItemService = (PSAppSBItemService)ServiceGlobal.getService(PSAppSBItemService.class, (SessionFactory)this.getSessionFactory());
        for (PSAppSBItem pSAppSBItem : arrayList) {
            pSAppSBItemService.updateTempMajor(pSAppSBItem);
        }
    }

    protected ArrayList<PSAppSBItemRS> updateRelatedDataTempMajor_removePSAppSBItemRS(PSAppStoryBoard pSAppStoryBoard, PSAppStoryBoard pSAppStoryBoard2) throws Exception {
        PSAppSBItemRSService pSAppSBItemRSService = (PSAppSBItemRSService)ServiceGlobal.getService(PSAppSBItemRSService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSAppSBItemRS> arrayList = pSAppSBItemRSService.selectTempByPSAppStoryBoard(pSAppStoryBoard);
        ArrayList<PSAppSBItemRS> arrayList2 = pSAppSBItemRSService.selectByPSAppStoryBoard(pSAppStoryBoard2);
        HashMap<String, PSAppSBItemRS> hashMap = new HashMap<String, PSAppSBItemRS>();
        for (PSAppSBItemRS pSAppSBItemRS : arrayList2) {
            hashMap.put(pSAppSBItemRS.getPSAppSBItemRSId(), pSAppSBItemRS);
        }
        for (PSAppSBItemRS pSAppSBItemRS : arrayList) {
            Object object = pSAppSBItemRS.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSAppSBItemRS pSAppSBItemRS : hashMap.values()) {
            pSAppSBItemRSService.remove((IEntity)pSAppSBItemRS);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSAppSBItemRS(PSAppStoryBoard pSAppStoryBoard, PSAppStoryBoard pSAppStoryBoard2, ArrayList<PSAppSBItemRS> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSAppSBItemRSService pSAppSBItemRSService = (PSAppSBItemRSService)ServiceGlobal.getService(PSAppSBItemRSService.class, (SessionFactory)this.getSessionFactory());
        for (PSAppSBItemRS pSAppSBItemRS : arrayList) {
            pSAppSBItemRSService.updateTempMajor(pSAppSBItemRS);
        }
    }

    protected void replaceParentInfo(PSAppStoryBoard pSAppStoryBoard, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSAppStoryBoard, cloneSession);
        if (pSAppStoryBoard.getPSSysAppId() != null && (iEntity = cloneSession.getEntity("PSSYSAPP", (Object)pSAppStoryBoard.getPSSysAppId())) != null) {
            this.onFillParentInfo_PSSysApp(pSAppStoryBoard, (PSSysApp)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSAppStoryBoard pSAppStoryBoard, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSAppStoryBoard, bl);
    }

    protected void onCheckEntity(boolean bl, PSAppStoryBoard pSAppStoryBoard, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CodeName(bl, pSAppStoryBoard, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DefaultFlag(bl, pSAppStoryBoard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSAppStoryBoard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppStoryBoardId(bl, pSAppStoryBoard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppStoryBoardName(bl, pSAppStoryBoard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaInstId(bl, pSAppStoryBoard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysAppId(bl, pSAppStoryBoard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SBModel(bl, pSAppStoryBoard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SBTag(bl, pSAppStoryBoard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SBTag2(bl, pSAppStoryBoard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSAppStoryBoard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSAppStoryBoard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSAppStoryBoard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSAppStoryBoard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSAppStoryBoard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSAppStoryBoard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSAppStoryBoard, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSAppStoryBoard pSAppStoryBoard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppStoryBoard.isCodeNameDirty() && !bl2 : !pSAppStoryBoard.isCodeNameDirty()) {
            return null;
        }
        String string = pSAppStoryBoard.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default((IEntity)pSAppStoryBoard, bl2, bl3);
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
                string3 = "PSSYSAPPID";
                String string4 = this.checkFieldDupRule(this.getPSAppStoryBoardDEModel(), "CODENAME", string3, pSAppStoryBoard, bl2, bl3);
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

    protected EntityFieldError onCheckField_DefaultFlag(boolean bl, PSAppStoryBoard pSAppStoryBoard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppStoryBoard.isDefaultFlagDirty() && !bl2 : !pSAppStoryBoard.isDefaultFlagDirty()) {
            return null;
        }
        Integer n = pSAppStoryBoard.getDefaultFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFAULTFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_DefaultFlag_Default((IEntity)pSAppStoryBoard, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFAULTFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            bl4 = DataTypeHelper.compare((int)9, (Object)n, (Object)"1") == 0L;
            if (bl4) {
                String string = "";
                string = "PSSYSAPPID";
                String string2 = this.checkFieldDupRule(this.getPSAppStoryBoardDEModel(), "DEFAULTFLAG", string, pSAppStoryBoard, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string2)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("DEFAULTFLAG");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string2);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSAppStoryBoard pSAppStoryBoard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppStoryBoard.isMemoDirty() : !pSAppStoryBoard.isMemoDirty()) {
            return null;
        }
        String string = pSAppStoryBoard.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSAppStoryBoard, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSAppStoryBoardId(boolean bl, PSAppStoryBoard pSAppStoryBoard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppStoryBoard.isPSAppStoryBoardIdDirty() && !bl2 : !pSAppStoryBoard.isPSAppStoryBoardIdDirty()) {
            return null;
        }
        String string = pSAppStoryBoard.getPSAppStoryBoardId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPSTORYBOARDID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppStoryBoardId_Default((IEntity)pSAppStoryBoard, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPSTORYBOARDID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSAppStoryBoardName(boolean bl, PSAppStoryBoard pSAppStoryBoard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppStoryBoard.isPSAppStoryBoardNameDirty() && !bl2 : !pSAppStoryBoard.isPSAppStoryBoardNameDirty()) {
            return null;
        }
        String string = pSAppStoryBoard.getPSAppStoryBoardName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPSTORYBOARDNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppStoryBoardName_Default((IEntity)pSAppStoryBoard, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPSTORYBOARDNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDynaInstId(boolean bl, PSAppStoryBoard pSAppStoryBoard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppStoryBoard.isPSDynaInstIdDirty() : !pSAppStoryBoard.isPSDynaInstIdDirty()) {
            return null;
        }
        String string = pSAppStoryBoard.getPSDynaInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaInstId_Default((IEntity)pSAppStoryBoard, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysAppId(boolean bl, PSAppStoryBoard pSAppStoryBoard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppStoryBoard.isPSSysAppIdDirty() && !bl2 : !pSAppStoryBoard.isPSSysAppIdDirty()) {
            return null;
        }
        String string = pSAppStoryBoard.getPSSysAppId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSAPPID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysAppId_Default((IEntity)pSAppStoryBoard, bl2, bl3);
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

    protected EntityFieldError onCheckField_SBModel(boolean bl, PSAppStoryBoard pSAppStoryBoard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppStoryBoard.isSBModelDirty() : !pSAppStoryBoard.isSBModelDirty()) {
            return null;
        }
        String string = pSAppStoryBoard.getSBModel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SBModel_Default((IEntity)pSAppStoryBoard, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SBMODEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SBTag(boolean bl, PSAppStoryBoard pSAppStoryBoard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppStoryBoard.isSBTagDirty() : !pSAppStoryBoard.isSBTagDirty()) {
            return null;
        }
        String string = pSAppStoryBoard.getSBTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SBTag_Default((IEntity)pSAppStoryBoard, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SBTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SBTag2(boolean bl, PSAppStoryBoard pSAppStoryBoard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppStoryBoard.isSBTag2Dirty() : !pSAppStoryBoard.isSBTag2Dirty()) {
            return null;
        }
        String string = pSAppStoryBoard.getSBTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SBTag2_Default((IEntity)pSAppStoryBoard, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SBTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSAppStoryBoard pSAppStoryBoard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppStoryBoard.isUserCatDirty() : !pSAppStoryBoard.isUserCatDirty()) {
            return null;
        }
        String string = pSAppStoryBoard.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default((IEntity)pSAppStoryBoard, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSAppStoryBoard pSAppStoryBoard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppStoryBoard.isUserTagDirty() : !pSAppStoryBoard.isUserTagDirty()) {
            return null;
        }
        String string = pSAppStoryBoard.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSAppStoryBoard, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSAppStoryBoard pSAppStoryBoard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppStoryBoard.isUserTag2Dirty() : !pSAppStoryBoard.isUserTag2Dirty()) {
            return null;
        }
        String string = pSAppStoryBoard.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSAppStoryBoard, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSAppStoryBoard pSAppStoryBoard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppStoryBoard.isUserTag3Dirty() : !pSAppStoryBoard.isUserTag3Dirty()) {
            return null;
        }
        String string = pSAppStoryBoard.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default((IEntity)pSAppStoryBoard, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSAppStoryBoard pSAppStoryBoard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppStoryBoard.isUserTag4Dirty() : !pSAppStoryBoard.isUserTag4Dirty()) {
            return null;
        }
        String string = pSAppStoryBoard.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default((IEntity)pSAppStoryBoard, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSAppStoryBoard pSAppStoryBoard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppStoryBoard.isValidFlagDirty() && !bl2 : !pSAppStoryBoard.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSAppStoryBoard.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSAppStoryBoard, bl2, bl3);
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

    protected void onSyncEntity(PSAppStoryBoard pSAppStoryBoard, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSAppStoryBoard, bl);
    }

    protected void onSyncIndexEntities(PSAppStoryBoard pSAppStoryBoard, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSAppStoryBoard, bl);
    }

    public Object getDataContextValue(PSAppStoryBoard pSAppStoryBoard, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSAppStoryBoard, string, iDataContextParam)) != null) {
            return object;
        }
        PSSysApp pSSysApp = pSAppStoryBoard.getPSSysApp();
        if (pSSysApp != null && pSSysApp.contains(string)) {
            return pSSysApp.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSAppStoryBoard pSAppStoryBoard, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSAppStoryBoard, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEFAULTFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DefaultFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPSTORYBOARDID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppStoryBoardId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPSTORYBOARDNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppStoryBoardName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAPPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAppId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAPPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAppName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SBMODEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SBModel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SBTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SBTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SBTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SBTag2_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_CodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODENAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false) && this.checkFieldRegExRule("CODENAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
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

    protected String onTestValueRule_DefaultFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_PSAppStoryBoardId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPSTORYBOARDID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSAppStoryBoardName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPSTORYBOARDNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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
            if (this.checkFieldStringLengthRule("PSDYNAINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
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

    protected String onTestValueRule_SBModel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SBMODEL", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SBTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SBTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SBTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SBTAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected boolean onMergeChild(String string, String string2, PSAppStoryBoard pSAppStoryBoard) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSAppStoryBoard)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSAppStoryBoard pSAppStoryBoard) throws Exception {
        super.onUpdateParent((IEntity)pSAppStoryBoard);
    }

    @Override
    protected void exportCurXmlModel(PSAppStoryBoard pSAppStoryBoard, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSAPPSTORYBOARD");
        if (!bl) {
            pSAppStoryBoard.setCreateDate(null);
            pSAppStoryBoard.setCreateMan(null);
            pSAppStoryBoard.setPSAppStoryBoardId(null);
            pSAppStoryBoard.setUpdateDate(null);
            pSAppStoryBoard.setUpdateMan(null);
            super.exportCurXmlModel(pSAppStoryBoard, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSAppStoryBoard pSAppStoryBoard, XmlNode xmlNode) throws Exception {
        this.exportRelatedXmlModel_PSAppSBItem(pSAppStoryBoard, xmlNode);
        this.exportRelatedXmlModel_PSAppSBItemRS(pSAppStoryBoard, xmlNode);
        super.onExportRelatedXmlModel(pSAppStoryBoard, xmlNode);
    }

    protected void exportRelatedXmlModel_PSAppSBItem(PSAppStoryBoard pSAppStoryBoard, XmlNode xmlNode) throws Exception {
        PSAppSBItemService pSAppSBItemService = (PSAppSBItemService)ServiceGlobal.getService(PSAppSBItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSAppSBItem> arrayList = null;
        String string = pSAppStoryBoard.getPSAppStoryBoardId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSAppSBItemService.selectByPSAppStoryBoard(pSAppStoryBoard) : pSAppSBItemService.selectTempByPSAppStoryBoard(pSAppStoryBoard);
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSAPPSBITEMS");
            xmlNode.addNode(xmlNode2);
            for (PSAppSBItem pSAppSBItem : arrayList) {
                pSAppSBItemService.exportXmlModel(pSAppSBItem, xmlNode2);
            }
        }
    }

    protected void exportRelatedXmlModel_PSAppSBItemRS(PSAppStoryBoard pSAppStoryBoard, XmlNode xmlNode) throws Exception {
        PSAppSBItemRSService pSAppSBItemRSService = (PSAppSBItemRSService)ServiceGlobal.getService(PSAppSBItemRSService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSAppSBItemRS> arrayList = null;
        String string = pSAppStoryBoard.getPSAppStoryBoardId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSAppSBItemRSService.selectByPSAppStoryBoard(pSAppStoryBoard, "ORDER BY ORDERVALUE ASC") : pSAppSBItemRSService.selectTempByPSAppStoryBoard(pSAppStoryBoard, "ORDER BY ORDERVALUE ASC");
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSAPPSBITEMRSS");
            xmlNode.addNode(xmlNode2);
            for (PSAppSBItemRS pSAppSBItemRS : arrayList) {
                pSAppSBItemRS.set("ORDERVALUE", null);
                pSAppSBItemRSService.exportXmlModel(pSAppSBItemRS, xmlNode2);
            }
        }
    }

    @Override
    protected void onImportRelatedXmlModel(PSAppStoryBoard pSAppStoryBoard, XmlNode xmlNode) throws Exception {
        XmlNode xmlNode2 = xmlNode.getChildNodeByNodeName("PSAPPSBITEMS");
        this.importRelatedXmlModel_PSAppSBItem(pSAppStoryBoard, xmlNode2);
        XmlNode xmlNode3 = xmlNode.getChildNodeByNodeName("PSAPPSBITEMRSS");
        this.importRelatedXmlModel_PSAppSBItemRS(pSAppStoryBoard, xmlNode3);
        super.onImportRelatedXmlModel(pSAppStoryBoard, xmlNode);
    }

    protected void importRelatedXmlModel_PSAppSBItem(PSAppStoryBoard pSAppStoryBoard, XmlNode xmlNode) throws Exception {
        PSAppSBItemService pSAppSBItemService = (PSAppSBItemService)ServiceGlobal.getService(PSAppSBItemService.class, (SessionFactory)this.getSessionFactory());
        String string = pSAppStoryBoard.getPSAppStoryBoardId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSAppSBItemService.removeByPSAppStoryBoard(pSAppStoryBoard);
        } else {
            pSAppSBItemService.removeTempByPSAppStoryBoard(pSAppStoryBoard);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSAppSBItem pSAppSBItem = new PSAppSBItem();
                pSAppSBItemService.fillParentInfo((IEntity)pSAppSBItem, "DER1N", "DER1N_PSAPPSBITEM_PSAPPSTORYBOARD_PSAPPSTORYBOARDID", pSAppStoryBoard.getPSAppStoryBoardId());
                pSAppSBItemService.importXmlModel(pSAppSBItem, xmlNode2);
            }
        }
    }

    protected void importRelatedXmlModel_PSAppSBItemRS(PSAppStoryBoard pSAppStoryBoard, XmlNode xmlNode) throws Exception {
        int n = 100;
        PSAppSBItemRSService pSAppSBItemRSService = (PSAppSBItemRSService)ServiceGlobal.getService(PSAppSBItemRSService.class, (SessionFactory)this.getSessionFactory());
        String string = pSAppStoryBoard.getPSAppStoryBoardId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSAppSBItemRSService.removeByPSAppStoryBoard(pSAppStoryBoard);
        } else {
            pSAppSBItemRSService.removeTempByPSAppStoryBoard(pSAppStoryBoard);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSAppSBItemRS pSAppSBItemRS = new PSAppSBItemRS();
                pSAppSBItemRS.setOrderValue(n);
                n += 100;
                pSAppSBItemRSService.fillParentInfo((IEntity)pSAppSBItemRS, "DER1N", "DER1N_PSAPPSBITEMRS_PSAPPSTORYBOARD_PSAPPSTORYBOARDID", pSAppStoryBoard.getPSAppStoryBoardId());
                pSAppSBItemRSService.importXmlModel(pSAppSBItemRS, xmlNode2);
            }
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSAppStoryBoard pSAppStoryBoard, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSAppStoryBoard, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSAPPID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSAPP#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSAPPID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSAPPSTORYBOARD_PSSYSAPP_PSSYSAPPID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSAPPID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSAPPNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSSYSAPP", (boolean)true) == 0) {
            iEntity.set("PSSYSAPPID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSSYSAPPID"};
    }

    @Override
    public String getModelV2Tag(PSAppStoryBoard pSAppStoryBoard) {
        if (!StringHelper.isNullOrEmpty((String)pSAppStoryBoard.getCodeName())) {
            return pSAppStoryBoard.getCodeName();
        }
        return super.getModelV2Tag(pSAppStoryBoard);
    }

    @Override
    public boolean setModelV2Tag(PSAppStoryBoard pSAppStoryBoard, String string) {
        pSAppStoryBoard.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("CODENAME", "");
        map.put("PSSYSAPPID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSAppStoryBoard pSAppStoryBoard, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSAppStoryBoard.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSAppStoryBoard, true);
        pSAppStoryBoard.set("CODENAME", string);
        if (this.select(pSAppStoryBoard, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSAppStoryBoard, true);
        return super.getModelV2Entity(pSAppStoryBoard, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSAppStoryBoard pSAppStoryBoard, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSAppStoryBoard, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        if (StringHelper.compare((String)"DER1N_PSAPPSBITEM_PSAPPSTORYBOARD_PSAPPSTORYBOARDID", (String)string, (boolean)true) == 0) {
            return false;
        }
        return StringHelper.compare((String)"DER1N_PSAPPSBITEMRS_PSAPPSTORYBOARD_PSAPPSTORYBOARDID", (String)string, (boolean)true) != 0;
    }

    @Override
    protected void onExportRelatedModelV2(PSAppStoryBoard pSAppStoryBoard, String string, String string2) throws Exception {
        Object var4_4 = null;
        super.onExportRelatedModelV2(pSAppStoryBoard, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSAppStoryBoard pSAppStoryBoard, ObjectNode objectNode, String string, boolean bl) throws Exception {
        Object object;
        EntityBase entityBase2;
        Object object2;
        ArrayNode arrayNode;
        Object object3;
        ArrayList<PSAppSBItem> arrayList;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSAPPSBITEM_PSAPPSTORYBOARD_PSAPPSTORYBOARDID")) {
            pSCoreSysServiceBase = (PSAppSBItemService)ServiceGlobal.getService(PSAppSBItemService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSAPPSTORYBOARD#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSAPPSBITEM", (Object)pSAppStoryBoard.getPSAppStoryBoardId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object3 = PSModelV2Helper.readFile2(file);
                    arrayNode = ((ArrayList)object3).iterator();
                    while (arrayNode.hasNext()) {
                        object2 = (String)arrayNode.next();
                        if (StringHelper.isNullOrEmpty((String)object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString((String)object2);
                        arrayList.add((PSAppSBItem)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList<PSAppSBItem>();
                object3 = ((PSAppSBItemServiceBase)pSCoreSysServiceBase).selectByPSAppStoryBoard(pSAppStoryBoard);
                arrayNode = StringHelper.format((String)"PSAPPSTORYBOARD#%1$s", (Object)pSAppStoryBoard.getPSAppStoryBoardId());
                object2 = ((ArrayList)object3).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSAppSBItem)object2.next();
                    object = ((PSAppSBItemServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare(arrayNode, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSAppSBItem)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                object3 = pSCoreSysServiceBase.getModelV2Name(false);
                arrayNode = objectNode.putArray(((String)object3).toLowerCase());
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
                        if (objectNode.has("psappsbitemname")) {
                            string = objectNode.get("psappsbitemname").asText();
                        }
                        if (objectNode2.has("psappsbitemname")) {
                            string2 = objectNode2.get("psappsbitemname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSAppSBItem();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    arrayNode.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSAPPSBITEMRS_PSAPPSTORYBOARD_PSAPPSTORYBOARDID")) {
            pSCoreSysServiceBase = (PSAppSBItemRSService)ServiceGlobal.getService(PSAppSBItemRSService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSAPPSTORYBOARD#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSAPPSBITEMRS", (Object)pSAppStoryBoard.getPSAppStoryBoardId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object3 = PSModelV2Helper.readFile2(file);
                    arrayNode = ((ArrayList)object3).iterator();
                    while (arrayNode.hasNext()) {
                        object2 = (String)arrayNode.next();
                        if (StringHelper.isNullOrEmpty(object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSAppSBItem)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList();
                object3 = ((PSAppSBItemRSServiceBase)pSCoreSysServiceBase).selectByPSAppStoryBoard(pSAppStoryBoard);
                arrayNode = StringHelper.format((String)"PSAPPSTORYBOARD#%1$s", (Object)pSAppStoryBoard.getPSAppStoryBoardId());
                object2 = ((ArrayList)object3).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSAppSBItemRS)object2.next();
                    object = ((PSAppSBItemRSServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare((String)arrayNode, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSAppSBItem)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                object3 = pSCoreSysServiceBase.getModelV2Name(false);
                arrayNode = objectNode.putArray(((String)object3).toLowerCase());
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
                        if (objectNode.has("psappsbitemrsname")) {
                            string = objectNode.get("psappsbitemrsname").asText();
                        }
                        if (objectNode2.has("psappsbitemrsname")) {
                            string2 = objectNode2.get("psappsbitemrsname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSAppSBItemRS();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    arrayNode.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        super.onExportCurModelV2(pSAppStoryBoard, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSAppStoryBoard pSAppStoryBoard) throws Exception {
        String string;
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSAppSBItemService)ServiceGlobal.getService(PSAppSBItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<EntityBase> arrayList = ((PSAppSBItemServiceBase)pSCoreSysServiceBase).selectByPSAppStoryBoard(pSAppStoryBoard);
        String string2 = StringHelper.format((String)"PSAPPSTORYBOARD#%1$s", (Object)pSAppStoryBoard.getPSAppStoryBoardId());
        for (PSAppSBItem entityBase : arrayList) {
            string = ((PSAppSBItemServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase);
            if (StringHelper.compare((String)string2, (String)string, (boolean)false) != 0) continue;
            pSCoreSysServiceBase.emptyModelV2(entityBase);
        }
        Object object = new SqlParamList();
        object.addString(pSAppStoryBoard.getPSAppStoryBoardId());
        ((PSAppSBItemServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        ((PSAppSBItemServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "DELETE FROM T_SRFPSAPPSBITEM WHERE PSAPPSTORYBOARDID = ?", (SqlParamList)object);
        pSCoreSysServiceBase = (PSAppSBItemRSService)ServiceGlobal.getService(PSAppSBItemRSService.class, (SessionFactory)this.getSessionFactory());
        arrayList = ((PSAppSBItemRSServiceBase)pSCoreSysServiceBase).selectByPSAppStoryBoard(pSAppStoryBoard);
        string2 = StringHelper.format((String)"PSAPPSTORYBOARD#%1$s", (Object)pSAppStoryBoard.getPSAppStoryBoardId());
        for (PSAppSBItemRS pSAppSBItemRS : arrayList) {
            string = ((PSAppSBItemRSServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)pSAppSBItemRS);
            if (StringHelper.compare((String)string2, (String)string, (boolean)false) != 0) continue;
            pSCoreSysServiceBase.emptyModelV2(pSAppSBItemRS);
        }
        object = new SqlParamList();
        object.addString(pSAppStoryBoard.getPSAppStoryBoardId());
        ((PSAppSBItemRSServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        ((PSAppSBItemRSServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "DELETE FROM T_SRFPSAPPSBITEMRS WHERE PSAPPSTORYBOARDID = ?", (SqlParamList)object);
        super.onEmptyModelV2(pSAppStoryBoard);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSAppSBItemService)ServiceGlobal.getService(PSAppSBItemService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSAppSBItemRSService)ServiceGlobal.getService(PSAppSBItemRSService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSAppStoryBoard pSAppStoryBoard, String string, String string2) throws Exception {
        IEntity iEntity = null;
        EntityBase entityBase = new PSAppSBItem();
        entityBase.set("PSAPPSTORYBOARDID", pSAppStoryBoard.getPSAppStoryBoardId());
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSAppSBItemService)ServiceGlobal.getService(PSAppSBItemService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSAppSBItemRS();
        entityBase.set("PSAPPSTORYBOARDID", pSAppStoryBoard.getPSAppStoryBoardId());
        pSCoreSysServiceBase = (PSAppSBItemRSService)ServiceGlobal.getService(PSAppSBItemRSService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSAppStoryBoard, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSAppStoryBoard pSAppStoryBoard, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        EntityBase entityBase;
        Object object;
        Object object2;
        int n2;
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSAppSBItemService)ServiceGlobal.getService(PSAppSBItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayNode arrayNode = null;
        String string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (n2 = 0; n2 < arrayNode.size(); ++n2) {
                object2 = (ObjectNode)arrayNode.get(n2);
                object = new PSAppSBItem();
                ((PSAppSBItemBase)object).setPSAppStoryBoardId(pSAppStoryBoard.getPSAppStoryBoardId());
                ((PSAppSBItemBase)object).setPSAppStoryBoardName(pSAppStoryBoard.getPSAppStoryBoardName());
                ((PSAppSBItemBase)object).setPSSysAppId(pSAppStoryBoard.getPSSysAppId());
                ((PSAppSBItemService)pSCoreSysServiceBase).compileModelV2((PSAppSBItem)object, (ObjectNode)object2, string, (String)null, n);
            }
        } else {
            String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            object2 = new File(string4);
            if (((File)object2).exists()) {
                object = ((File)object2).listFiles();
                for (Object object3 : object) {
                    if (!((File)object3).isDirectory()) continue;
                    entityBase = new PSAppSBItem();
                    entityBase.setPSAppStoryBoardId(pSAppStoryBoard.getPSAppStoryBoardId());
                    entityBase.setPSAppStoryBoardName(pSAppStoryBoard.getPSAppStoryBoardName());
                    entityBase.setPSSysAppId(pSAppStoryBoard.getPSSysAppId());
                    ((PSAppSBItemService)pSCoreSysServiceBase).compileModelV2((PSAppSBItem)entityBase, (ObjectNode)null, string, ((File)object3).getCanonicalPath(), n);
                }
            }
        }
        pSCoreSysServiceBase = (PSAppSBItemRSService)ServiceGlobal.getService(PSAppSBItemRSService.class, (SessionFactory)this.getSessionFactory());
        arrayNode = null;
        string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (n2 = 0; n2 < arrayNode.size(); ++n2) {
                object2 = (ObjectNode)arrayNode.get(n2);
                object = new PSAppSBItemRS();
                ((PSAppSBItemRSBase)object).setPSAppStoryBoardId(pSAppStoryBoard.getPSAppStoryBoardId());
                ((PSAppSBItemRSBase)object).setPSAppStoryBoardName(pSAppStoryBoard.getPSAppStoryBoardName());
                ((PSAppSBItemRSBase)object).setPSSysAppId(pSAppStoryBoard.getPSSysAppId());
                ((PSAppSBItemRSService)pSCoreSysServiceBase).compileModelV2((PSAppSBItemRS)object, (ObjectNode)object2, string, (String)null, n);
            }
        } else {
            String string5 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            object2 = new File(string5);
            if (((File)object2).exists()) {
                for (Object object3 : object = ((File)object2).listFiles()) {
                    if (!((File)object3).isDirectory()) continue;
                    entityBase = new PSAppSBItemRS();
                    entityBase.setPSAppStoryBoardId(pSAppStoryBoard.getPSAppStoryBoardId());
                    entityBase.setPSAppStoryBoardName(pSAppStoryBoard.getPSAppStoryBoardName());
                    entityBase.setPSSysAppId(pSAppStoryBoard.getPSSysAppId());
                    ((PSAppSBItemRSService)pSCoreSysServiceBase).compileModelV2((PSAppSBItemRS)entityBase, (ObjectNode)null, string, ((File)object3).getCanonicalPath(), n);
                }
            }
        }
        super.onCompileRelatedModelV2(pSAppStoryBoard, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSAppStoryBoard pSAppStoryBoard, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSAPPSBITEM_PSAPPSTORYBOARD_PSAPPSTORYBOARDID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSAppSBItems(pSAppStoryBoard, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSAPPSBITEMRS_PSAPPSTORYBOARD_PSAPPSTORYBOARDID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSAppSBItemRSs(pSAppStoryBoard, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSAppStoryBoard, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSAppSBItems(PSAppStoryBoard pSAppStoryBoard, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSAPPSBITEM", true), (boolean)false) == 0) {
            PSAppSBItemService pSAppSBItemService = (PSAppSBItemService)ServiceGlobal.getService(PSAppSBItemService.class, (SessionFactory)this.getSessionFactory());
            PSAppSBItem pSAppSBItem = new PSAppSBItem();
            pSAppSBItem.setPSAppSBItemId(pSMOSFile.getPSModelId());
            if (!pSAppSBItemService.get((IEntity)pSAppSBItem, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSAppSBItem.getPSAppStoryBoardId(), (String)pSAppStoryBoard.getPSAppStoryBoardId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSAppSBItemService.exportModelV2(pSAppSBItem);
            pSAppSBItem.reset();
            if (!pSAppSBItemService.setModelV2ResScope((IEntity)pSAppSBItem, "PSAPPSTORYBOARD", pSAppStoryBoard.getPSAppStoryBoardId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSAppSBItemService.importModelV2(pSAppSBItem, objectNode);
            SessionFactoryManager.commit();
            return pSAppSBItemService.getFile((IEntity)pSAppSBItem);
        }
        return null;
    }

    protected PSMOSFile onPasteFile_PSAppSBItemRSs(PSAppStoryBoard pSAppStoryBoard, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSAPPSBITEMRS", true), (boolean)false) == 0) {
            PSAppSBItemRSService pSAppSBItemRSService = (PSAppSBItemRSService)ServiceGlobal.getService(PSAppSBItemRSService.class, (SessionFactory)this.getSessionFactory());
            PSAppSBItemRS pSAppSBItemRS = new PSAppSBItemRS();
            pSAppSBItemRS.setPSAppSBItemRSId(pSMOSFile.getPSModelId());
            if (!pSAppSBItemRSService.get((IEntity)pSAppSBItemRS, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSAppSBItemRS.getPSAppStoryBoardId(), (String)pSAppStoryBoard.getPSAppStoryBoardId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSAppSBItemRSService.exportModelV2(pSAppSBItemRS);
            pSAppSBItemRS.reset();
            if (!pSAppSBItemRSService.setModelV2ResScope((IEntity)pSAppSBItemRS, "PSAPPSTORYBOARD", pSAppStoryBoard.getPSAppStoryBoardId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSAppSBItemRSService.importModelV2(pSAppSBItemRS, objectNode);
            SessionFactoryManager.commit();
            return pSAppSBItemRSService.getFile((IEntity)pSAppSBItemRS);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSAppStoryBoard pSAppStoryBoard, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSAppSBItems(pSAppStoryBoard, list);
        this.onFillPasteHelps_PSAppSBItemRSs(pSAppStoryBoard, list);
        super.onFillPasteHelps(pSAppStoryBoard, list);
    }

    protected void onFillPasteHelps_PSAppSBItems(PSAppStoryBoard pSAppStoryBoard, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSAPPSBITEM");
        pSHelpSection.setSectionParam2("DER1N_PSAPPSBITEM_PSAPPSTORYBOARD_PSAPPSTORYBOARDID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5e94\u7528\u6545\u4e8b\u677f]\u7684[\u5e94\u7528\u6545\u4e8b\u677f\u9879\u76ee]");
        list.add(pSHelpSection);
    }

    protected void onFillPasteHelps_PSAppSBItemRSs(PSAppStoryBoard pSAppStoryBoard, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSAPPSBITEMRS");
        pSHelpSection.setSectionParam2("DER1N_PSAPPSBITEMRS_PSAPPSTORYBOARD_PSAPPSTORYBOARDID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5e94\u7528\u6545\u4e8b\u677f]\u7684[\u5e94\u7528\u6545\u4e8b\u677f\u9879\u76ee\u5173\u7cfb]");
        list.add(pSHelpSection);
    }

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSAppStoryBoard pSAppStoryBoard, boolean bl) {
        return defaultValueMap;
    }

    static {
        defaultValueMap.put("CODENAME", "StoryBoard");
        defaultValueMap.put("PSAPPSTORYBOARDNAME", "\u6545\u4e8b\u677f");
    }
}

