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
package net.ibizsys.pscore.srv.sysdesign.service;

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
import net.ibizsys.pscore.srv.appdesign.entity.PSAppFunc;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppFuncBase;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPluginBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogicBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIActionBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdesign.dao.PSSysViewPanelLogicDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysViewPanelLogicDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSPanelLogicLink;
import net.ibizsys.pscore.srv.sysdesign.entity.PSPanelLogicLinkBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSPanelLogicNode;
import net.ibizsys.pscore.srv.sysdesign.entity.PSPanelLogicNodeBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSPanelLogicParam;
import net.ibizsys.pscore.srv.sysdesign.entity.PSPanelLogicParamBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewLogic;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewLogicBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanelItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanelItemBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanelLogic;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanelModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanelModelBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSPanelEngineService;
import net.ibizsys.pscore.srv.sysdesign.service.PSPanelEngineServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSPanelLogicLinkService;
import net.ibizsys.pscore.srv.sysdesign.service.PSPanelLogicLinkServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSPanelLogicNodeService;
import net.ibizsys.pscore.srv.sysdesign.service.PSPanelLogicNodeServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSPanelLogicParamService;
import net.ibizsys.pscore.srv.sysdesign.service.PSPanelLogicParamServiceBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysViewPanelLogicServiceBase
extends PSCoreSysServiceBase<PSSysViewPanelLogic> {
    private static final Log log = LogFactory.getLog(PSSysViewPanelLogicServiceBase.class);
    public static final String DATASET_CURPANEL = "CurPanel";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_CREATEWITHMODEL = "CreateWithModel";
    public static final String ACTION_GETDRAFTFROMWITHMODEL = "GetDraftFromWithModel";
    public static final String ACTION_GETDRAFTWITHMODEL = "GetDraftWithModel";
    public static final String ACTION_GETWITHMODEL = "GetWithModel";
    public static final String ACTION_UPDATEWITHMODEL = "UpdateWithModel";
    private PSSysViewPanelLogicDEModel pSSysViewPanelLogicDEModel;
    private PSSysViewPanelLogicDAO pSSysViewPanelLogicDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelLogicService";
    }

    public PSSysViewPanelLogicDEModel getPSSysViewPanelLogicDEModel() {
        if (this.pSSysViewPanelLogicDEModel == null) {
            try {
                this.pSSysViewPanelLogicDEModel = (PSSysViewPanelLogicDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysViewPanelLogicDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysViewPanelLogicDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysViewPanelLogicDEModel();
    }

    public PSSysViewPanelLogicDAO getPSSysViewPanelLogicDAO() {
        if (this.pSSysViewPanelLogicDAO == null) {
            try {
                this.pSSysViewPanelLogicDAO = (PSSysViewPanelLogicDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSSysViewPanelLogicDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysViewPanelLogicDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysViewPanelLogicDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURPANEL, (boolean)true) == 0) {
            return this.fetchCurPanel(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    protected DBFetchResult onfetchDataSetTemp(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURPANEL, (boolean)true) == 0) {
            return this.fetchTempCurPanel(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchTempDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSetTemp(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_CREATEWITHMODEL, (boolean)true) == 0) {
            this.createWithModel((PSSysViewPanelLogic)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_GETDRAFTFROMWITHMODEL, (boolean)true) == 0) {
            this.getDraftFromWithModel((PSSysViewPanelLogic)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_GETDRAFTWITHMODEL, (boolean)true) == 0) {
            this.getDraftWithModel((PSSysViewPanelLogic)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_GETWITHMODEL, (boolean)true) == 0) {
            this.getWithModel((PSSysViewPanelLogic)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_UPDATEWITHMODEL, (boolean)true) == 0) {
            this.updateWithModel((PSSysViewPanelLogic)iEntity);
            return;
        }
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurPanel(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURPANEL, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurPanel(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURPANEL, true);
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

    public void createWithModel(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_CREATEWITHMODEL, 0, pSSysViewPanelLogic, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSSysViewPanelLogic, ACTION_CREATEWITHMODEL);
        final PSSysViewPanelLogic pSSysViewPanelLogic2 = pSSysViewPanelLogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSSysViewPanelLogicServiceBase.this.getService(), PSSysViewPanelLogicServiceBase.ACTION_CREATEWITHMODEL, 40, pSSysViewPanelLogic2, null).getResult() != 1) {
                    PSSysViewPanelLogicServiceBase.this.onCreateWithModel(pSSysViewPanelLogic2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_CREATEWITHMODEL, 99, pSSysViewPanelLogic, null);
        }
    }

    protected void onCreateWithModel(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[CreateWithModel]");
    }

    public void getDraftFromWithModel(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_GETDRAFTFROMWITHMODEL, 0, pSSysViewPanelLogic, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSSysViewPanelLogic, ACTION_GETDRAFTFROMWITHMODEL);
        final PSSysViewPanelLogic pSSysViewPanelLogic2 = pSSysViewPanelLogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSSysViewPanelLogicServiceBase.this.getService(), PSSysViewPanelLogicServiceBase.ACTION_GETDRAFTFROMWITHMODEL, 40, pSSysViewPanelLogic2, null).getResult() != 1) {
                    PSSysViewPanelLogicServiceBase.this.onGetDraftFromWithModel(pSSysViewPanelLogic2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_GETDRAFTFROMWITHMODEL, 99, pSSysViewPanelLogic, null);
        }
    }

    protected void onGetDraftFromWithModel(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[GetDraftFromWithModel]");
    }

    public void getDraftWithModel(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_GETDRAFTWITHMODEL, 0, pSSysViewPanelLogic, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSSysViewPanelLogic, ACTION_GETDRAFTWITHMODEL);
        final PSSysViewPanelLogic pSSysViewPanelLogic2 = pSSysViewPanelLogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSSysViewPanelLogicServiceBase.this.getService(), PSSysViewPanelLogicServiceBase.ACTION_GETDRAFTWITHMODEL, 40, pSSysViewPanelLogic2, null).getResult() != 1) {
                    PSSysViewPanelLogicServiceBase.this.onGetDraftWithModel(pSSysViewPanelLogic2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_GETDRAFTWITHMODEL, 99, pSSysViewPanelLogic, null);
        }
    }

    protected void onGetDraftWithModel(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[GetDraftWithModel]");
    }

    public void getWithModel(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_GETWITHMODEL, 0, pSSysViewPanelLogic, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSSysViewPanelLogic, ACTION_GETWITHMODEL);
        final PSSysViewPanelLogic pSSysViewPanelLogic2 = pSSysViewPanelLogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSSysViewPanelLogicServiceBase.this.getService(), PSSysViewPanelLogicServiceBase.ACTION_GETWITHMODEL, 40, pSSysViewPanelLogic2, null).getResult() != 1) {
                    PSSysViewPanelLogicServiceBase.this.onGetWithModel(pSSysViewPanelLogic2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_GETWITHMODEL, 99, pSSysViewPanelLogic, null);
        }
    }

    protected void onGetWithModel(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[GetWithModel]");
    }

    public void updateWithModel(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_UPDATEWITHMODEL, 0, pSSysViewPanelLogic, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSSysViewPanelLogic, ACTION_UPDATEWITHMODEL);
        final PSSysViewPanelLogic pSSysViewPanelLogic2 = pSSysViewPanelLogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSSysViewPanelLogicServiceBase.this.getService(), PSSysViewPanelLogicServiceBase.ACTION_UPDATEWITHMODEL, 40, pSSysViewPanelLogic2, null).getResult() != 1) {
                    PSSysViewPanelLogicServiceBase.this.onUpdateWithModel(pSSysViewPanelLogic2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_UPDATEWITHMODEL, 99, pSSysViewPanelLogic, null);
        }
    }

    protected void onUpdateWithModel(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[UpdateWithModel]");
    }

    protected void onFillParentInfo(PSSysViewPanelLogic pSSysViewPanelLogic, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSVIEWPANELLOGIC_PSAPPFUNC_PSAPPFUNCID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppFuncService", (SessionFactory)this.getSessionFactory());
            PSAppFunc pSAppFunc = (PSAppFunc)iService.getDEModel().createEntity();
            pSAppFunc.set("PSAPPFUNCID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSAppFunc);
            } else {
                iService.get(pSAppFunc);
            }
            this.onFillParentInfo_PSAppFunc(pSSysViewPanelLogic, pSAppFunc);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSVIEWPANELLOGIC_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDataEntity);
            } else {
                iService.get(pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSSysViewPanelLogic, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSVIEWPANELLOGIC_PSDELOGIC_PSDELOGICID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDELogicService", (SessionFactory)this.getSessionFactory());
            PSDELogic pSDELogic = (PSDELogic)iService.getDEModel().createEntity();
            pSDELogic.set("PSDELOGICID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDELogic);
            } else {
                iService.get(pSDELogic);
            }
            this.onFillParentInfo_PSDELogic(pSSysViewPanelLogic, pSDELogic);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSVIEWPANELLOGIC_PSDEUIACTION_PSDEUIACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionService", (SessionFactory)this.getSessionFactory());
            PSDEUIAction pSDEUIAction = (PSDEUIAction)iService.getDEModel().createEntity();
            pSDEUIAction.set("PSDEUIACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEUIAction);
            } else {
                iService.get(pSDEUIAction);
            }
            this.onFillParentInfo_PSDEUIAction(pSSysViewPanelLogic, pSDEUIAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSVIEWPANELLOGIC_PSSYSPFPLUGIN_PSSYSPFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysPFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysPFPlugin pSSysPFPlugin = (PSSysPFPlugin)iService.getDEModel().createEntity();
            pSSysPFPlugin.set("PSSYSPFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysPFPlugin);
            } else {
                iService.get(pSSysPFPlugin);
            }
            this.onFillParentInfo_PSSysPFPlugin(pSSysViewPanelLogic, pSSysPFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSVIEWPANELLOGIC_PSSYSVIEWLOGIC_PSSYSVIEWLOGICID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysViewLogicService", (SessionFactory)this.getSessionFactory());
            PSSysViewLogic pSSysViewLogic = (PSSysViewLogic)iService.getDEModel().createEntity();
            pSSysViewLogic.set("PSSYSVIEWLOGICID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysViewLogic);
            } else {
                iService.get(pSSysViewLogic);
            }
            this.onFillParentInfo_PSSysViewLogic(pSSysViewPanelLogic, pSSysViewLogic);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSVIEWPANELLOGIC_PSSYSVIEWPANELITEM_PARAMPSPANELITEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelItemService", (SessionFactory)this.getSessionFactory());
            PSSysViewPanelItem pSSysViewPanelItem = (PSSysViewPanelItem)iService.getDEModel().createEntity();
            pSSysViewPanelItem.set("PSSYSVIEWPANELITEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysViewPanelItem);
            } else {
                iService.get(pSSysViewPanelItem);
            }
            this.onFillParentInfo_ParamPSPanelItem(pSSysViewPanelLogic, pSSysViewPanelItem);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSVIEWPANELLOGIC_PSSYSVIEWPANELITEM_PSSYSVIEWPANELITEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelItemService", (SessionFactory)this.getSessionFactory());
            PSSysViewPanelItem pSSysViewPanelItem = (PSSysViewPanelItem)iService.getDEModel().createEntity();
            pSSysViewPanelItem.set("PSSYSVIEWPANELITEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysViewPanelItem);
            } else {
                iService.get(pSSysViewPanelItem);
            }
            this.onFillParentInfo_PSSysViewPanelItem(pSSysViewPanelLogic, pSSysViewPanelItem);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSVIEWPANELLOGIC_PSSYSVIEWPANELMODEL_PSSYSVIEWPANELMODELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelModelService", (SessionFactory)this.getSessionFactory());
            PSSysViewPanelModel pSSysViewPanelModel = (PSSysViewPanelModel)iService.getDEModel().createEntity();
            pSSysViewPanelModel.set("PSSYSVIEWPANELMODELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysViewPanelModel);
            } else {
                iService.get(pSSysViewPanelModel);
            }
            this.onFillParentInfo_PSSysViewPanelModel(pSSysViewPanelLogic, pSSysViewPanelModel);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSVIEWPANELLOGIC_PSSYSVIEWPANEL_LAYOUTPSSYSVIEWPANELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelService", (SessionFactory)this.getSessionFactory());
            PSSysViewPanel pSSysViewPanel = (PSSysViewPanel)iService.getDEModel().createEntity();
            pSSysViewPanel.set("PSSYSVIEWPANELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysViewPanel);
            } else {
                iService.get(pSSysViewPanel);
            }
            this.onFillParentInfo_LayoutPSSysViewPanel(pSSysViewPanelLogic, pSSysViewPanel);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSVIEWPANELLOGIC_PSSYSVIEWPANEL_PSSYSVIEWPANELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelService", (SessionFactory)this.getSessionFactory());
            PSSysViewPanel pSSysViewPanel = (PSSysViewPanel)iService.getDEModel().createEntity();
            pSSysViewPanel.set("PSSYSVIEWPANELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysViewPanel);
            } else {
                iService.get(pSSysViewPanel);
            }
            this.onFillParentInfo_PSSysViewPanel(pSSysViewPanelLogic, pSSysViewPanel);
            return;
        }
        super.onFillParentInfo(pSSysViewPanelLogic, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSAppFunc(PSSysViewPanelLogic pSSysViewPanelLogic, PSAppFunc pSAppFunc) throws Exception {
        pSSysViewPanelLogic.setPSAppFuncId(pSAppFunc.getPSAppFuncId());
        pSSysViewPanelLogic.setPSAppFuncName(pSAppFunc.getPSAppFuncName());
    }

    protected void onFillParentInfo_PSDE(PSSysViewPanelLogic pSSysViewPanelLogic, PSDataEntity pSDataEntity) throws Exception {
        pSSysViewPanelLogic.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSSysViewPanelLogic.setPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_PSDELogic(PSSysViewPanelLogic pSSysViewPanelLogic, PSDELogic pSDELogic) throws Exception {
        pSSysViewPanelLogic.setPSDELogicId(pSDELogic.getPSDELogicId());
        pSSysViewPanelLogic.setPSDELogicName(pSDELogic.getPSDELogicName());
    }

    protected void onFillParentInfo_PSDEUIAction(PSSysViewPanelLogic pSSysViewPanelLogic, PSDEUIAction pSDEUIAction) throws Exception {
        pSSysViewPanelLogic.setPSDEUIActionId(pSDEUIAction.getPSDEUIActionId());
        pSSysViewPanelLogic.setPSDEUIActionName(pSDEUIAction.getPSDEUIActionName());
    }

    protected void onFillParentInfo_PSSysPFPlugin(PSSysViewPanelLogic pSSysViewPanelLogic, PSSysPFPlugin pSSysPFPlugin) throws Exception {
        pSSysViewPanelLogic.setPSSysPFPluginId(pSSysPFPlugin.getPSSysPFPluginId());
        pSSysViewPanelLogic.setPSSysPFPluginName(pSSysPFPlugin.getPSSysPFPluginName());
    }

    protected void onFillParentInfo_PSSysViewLogic(PSSysViewPanelLogic pSSysViewPanelLogic, PSSysViewLogic pSSysViewLogic) throws Exception {
        pSSysViewPanelLogic.setPSSysViewLogicId(pSSysViewLogic.getPSSysViewLogicId());
        pSSysViewPanelLogic.setPSSysViewLogicName(pSSysViewLogic.getPSSysViewLogicName());
    }

    protected void onFillParentInfo_ParamPSPanelItem(PSSysViewPanelLogic pSSysViewPanelLogic, PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        pSSysViewPanelLogic.setParamPSPanelItemId(pSSysViewPanelItem.getPSSysViewPanelItemId());
        pSSysViewPanelLogic.setParamPSPanelItemName(pSSysViewPanelItem.getPSSysViewPanelItemName());
    }

    protected void onFillParentInfo_PSSysViewPanelItem(PSSysViewPanelLogic pSSysViewPanelLogic, PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        pSSysViewPanelLogic.setPSSysViewPanelItemId(pSSysViewPanelItem.getPSSysViewPanelItemId());
        pSSysViewPanelLogic.setPSSysViewPanelItemName(pSSysViewPanelItem.getPSSysViewPanelItemName());
        if (pSSysViewPanelItem.getPSSysViewPanel() != null) {
            this.onFillParentInfo_PSSysViewPanel(pSSysViewPanelLogic, pSSysViewPanelItem.getPSSysViewPanel());
        }
    }

    protected void onFillParentInfo_PSSysViewPanelModel(PSSysViewPanelLogic pSSysViewPanelLogic, PSSysViewPanelModel pSSysViewPanelModel) throws Exception {
        pSSysViewPanelLogic.setPSSysViewPanelModelId(pSSysViewPanelModel.getPSSysViewPanelModelId());
        pSSysViewPanelLogic.setPSSysViewPanelModelName(pSSysViewPanelModel.getPSSysViewPanelModelName());
    }

    protected void onFillParentInfo_LayoutPSSysViewPanel(PSSysViewPanelLogic pSSysViewPanelLogic, PSSysViewPanel pSSysViewPanel) throws Exception {
        pSSysViewPanelLogic.setLayoutPSSysViewPanelId(pSSysViewPanel.getPSSysViewPanelId());
        pSSysViewPanelLogic.setLayoutPSSysViewPanelName(pSSysViewPanel.getPSSysViewPanelName());
    }

    protected void onFillParentInfo_PSSysViewPanel(PSSysViewPanelLogic pSSysViewPanelLogic, PSSysViewPanel pSSysViewPanel) throws Exception {
        pSSysViewPanelLogic.setPSSystemId(pSSysViewPanel.getPSSystemId());
        pSSysViewPanelLogic.setPSSysViewPanelId(pSSysViewPanel.getPSSysViewPanelId());
        pSSysViewPanelLogic.setPSSysViewPanelName(pSSysViewPanel.getPSSysViewPanelName());
    }

    protected void onFillEntityFullInfo(PSSysViewPanelLogic pSSysViewPanelLogic, boolean bl) throws Exception {
        if (bl && pSSysViewPanelLogic.getValidFlag() == null) {
            pSSysViewPanelLogic.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo(pSSysViewPanelLogic, bl);
        this.onFillEntityFullInfo_PSAppFunc(pSSysViewPanelLogic, bl);
        this.onFillEntityFullInfo_PSDE(pSSysViewPanelLogic, bl);
        this.onFillEntityFullInfo_PSDELogic(pSSysViewPanelLogic, bl);
        this.onFillEntityFullInfo_PSDEUIAction(pSSysViewPanelLogic, bl);
        this.onFillEntityFullInfo_PSSysPFPlugin(pSSysViewPanelLogic, bl);
        this.onFillEntityFullInfo_PSSysViewLogic(pSSysViewPanelLogic, bl);
        this.onFillEntityFullInfo_ParamPSPanelItem(pSSysViewPanelLogic, bl);
        this.onFillEntityFullInfo_PSSysViewPanelItem(pSSysViewPanelLogic, bl);
        this.onFillEntityFullInfo_PSSysViewPanelModel(pSSysViewPanelLogic, bl);
        this.onFillEntityFullInfo_LayoutPSSysViewPanel(pSSysViewPanelLogic, bl);
        this.onFillEntityFullInfo_PSSysViewPanel(pSSysViewPanelLogic, bl);
    }

    protected void onFillEntityFullInfo_PSAppFunc(PSSysViewPanelLogic pSSysViewPanelLogic, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDE(PSSysViewPanelLogic pSSysViewPanelLogic, boolean bl) throws Exception {
        if (pSSysViewPanelLogic.isPSDEIdDirty()) {
            if (pSSysViewPanelLogic.getPSDEId() != null) {
                if (pSSysViewPanelLogic.getPSDEId() == null || pSSysViewPanelLogic.getPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSSysViewPanelLogic.getPSDE();
                    pSSysViewPanelLogic.setPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSSysViewPanelLogic.setPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDELogic(PSSysViewPanelLogic pSSysViewPanelLogic, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEUIAction(PSSysViewPanelLogic pSSysViewPanelLogic, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysPFPlugin(PSSysViewPanelLogic pSSysViewPanelLogic, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysViewLogic(PSSysViewPanelLogic pSSysViewPanelLogic, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_ParamPSPanelItem(PSSysViewPanelLogic pSSysViewPanelLogic, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysViewPanelItem(PSSysViewPanelLogic pSSysViewPanelLogic, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysViewPanelModel(PSSysViewPanelLogic pSSysViewPanelLogic, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_LayoutPSSysViewPanel(PSSysViewPanelLogic pSSysViewPanelLogic, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysViewPanel(PSSysViewPanelLogic pSSysViewPanelLogic, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSysViewPanelLogic pSSysViewPanelLogic, boolean bl) throws Exception {
        super.onWriteBackParent(pSSysViewPanelLogic, bl);
    }

    public ArrayList<PSSysViewPanelLogic> selectByPSAppFunc(PSAppFuncBase pSAppFuncBase) throws Exception {
        return this.selectByPSAppFunc(pSAppFuncBase, "", -1);
    }

    public ArrayList<PSSysViewPanelLogic> selectByPSAppFunc(PSAppFuncBase pSAppFuncBase, String string) throws Exception {
        return this.selectByPSAppFunc(pSAppFuncBase, string, -1);
    }

    public ArrayList<PSSysViewPanelLogic> selectByPSAppFunc(PSAppFuncBase pSAppFuncBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSAPPFUNCID", (Object)pSAppFuncBase.getPSAppFuncId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSAppFuncCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSAppFuncCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysViewPanelLogic> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSSysViewPanelLogic> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSSysViewPanelLogic> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysViewPanelLogic> selectByPSDELogic(PSDELogicBase pSDELogicBase) throws Exception {
        return this.selectByPSDELogic(pSDELogicBase, "", -1);
    }

    public ArrayList<PSSysViewPanelLogic> selectByPSDELogic(PSDELogicBase pSDELogicBase, String string) throws Exception {
        return this.selectByPSDELogic(pSDELogicBase, string, -1);
    }

    public ArrayList<PSSysViewPanelLogic> selectByPSDELogic(PSDELogicBase pSDELogicBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysViewPanelLogic> selectByPSDEUIAction(PSDEUIActionBase pSDEUIActionBase) throws Exception {
        return this.selectByPSDEUIAction(pSDEUIActionBase, "", -1);
    }

    public ArrayList<PSSysViewPanelLogic> selectByPSDEUIAction(PSDEUIActionBase pSDEUIActionBase, String string) throws Exception {
        return this.selectByPSDEUIAction(pSDEUIActionBase, string, -1);
    }

    public ArrayList<PSSysViewPanelLogic> selectByPSDEUIAction(PSDEUIActionBase pSDEUIActionBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysViewPanelLogic> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, "", -1);
    }

    public ArrayList<PSSysViewPanelLogic> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, string, -1);
    }

    public ArrayList<PSSysViewPanelLogic> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysViewPanelLogic> selectByPSSysViewLogic(PSSysViewLogicBase pSSysViewLogicBase) throws Exception {
        return this.selectByPSSysViewLogic(pSSysViewLogicBase, "", -1);
    }

    public ArrayList<PSSysViewPanelLogic> selectByPSSysViewLogic(PSSysViewLogicBase pSSysViewLogicBase, String string) throws Exception {
        return this.selectByPSSysViewLogic(pSSysViewLogicBase, string, -1);
    }

    public ArrayList<PSSysViewPanelLogic> selectByPSSysViewLogic(PSSysViewLogicBase pSSysViewLogicBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysViewPanelLogic> selectByParamPSPanelItem(PSSysViewPanelItemBase pSSysViewPanelItemBase) throws Exception {
        return this.selectByParamPSPanelItem(pSSysViewPanelItemBase, "", -1);
    }

    public ArrayList<PSSysViewPanelLogic> selectByParamPSPanelItem(PSSysViewPanelItemBase pSSysViewPanelItemBase, String string) throws Exception {
        return this.selectByParamPSPanelItem(pSSysViewPanelItemBase, string, -1);
    }

    public ArrayList<PSSysViewPanelLogic> selectByParamPSPanelItem(PSSysViewPanelItemBase pSSysViewPanelItemBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PARAMPSPANELITEMID", (Object)pSSysViewPanelItemBase.getPSSysViewPanelItemId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByParamPSPanelItemCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByParamPSPanelItemCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysViewPanelLogic> selectTempByParamPSPanelItem(PSSysViewPanelItemBase pSSysViewPanelItemBase) throws Exception {
        return this.selectTempByParamPSPanelItem(pSSysViewPanelItemBase, "");
    }

    public ArrayList<PSSysViewPanelLogic> selectTempByParamPSPanelItem(PSSysViewPanelItemBase pSSysViewPanelItemBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PARAMPSPANELITEMID", (Object)pSSysViewPanelItemBase.getPSSysViewPanelItemId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByParamPSPanelItemCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByParamPSPanelItemCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysViewPanelLogic> selectByPSSysViewPanelItem(PSSysViewPanelItemBase pSSysViewPanelItemBase) throws Exception {
        return this.selectByPSSysViewPanelItem(pSSysViewPanelItemBase, "", -1);
    }

    public ArrayList<PSSysViewPanelLogic> selectByPSSysViewPanelItem(PSSysViewPanelItemBase pSSysViewPanelItemBase, String string) throws Exception {
        return this.selectByPSSysViewPanelItem(pSSysViewPanelItemBase, string, -1);
    }

    public ArrayList<PSSysViewPanelLogic> selectByPSSysViewPanelItem(PSSysViewPanelItemBase pSSysViewPanelItemBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSVIEWPANELITEMID", (Object)pSSysViewPanelItemBase.getPSSysViewPanelItemId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysViewPanelItemCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysViewPanelItemCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysViewPanelLogic> selectTempByPSSysViewPanelItem(PSSysViewPanelItemBase pSSysViewPanelItemBase) throws Exception {
        return this.selectTempByPSSysViewPanelItem(pSSysViewPanelItemBase, "");
    }

    public ArrayList<PSSysViewPanelLogic> selectTempByPSSysViewPanelItem(PSSysViewPanelItemBase pSSysViewPanelItemBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSVIEWPANELITEMID", (Object)pSSysViewPanelItemBase.getPSSysViewPanelItemId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSSysViewPanelItemCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSSysViewPanelItemCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysViewPanelLogic> selectByPSSysViewPanelModel(PSSysViewPanelModelBase pSSysViewPanelModelBase) throws Exception {
        return this.selectByPSSysViewPanelModel(pSSysViewPanelModelBase, "", -1);
    }

    public ArrayList<PSSysViewPanelLogic> selectByPSSysViewPanelModel(PSSysViewPanelModelBase pSSysViewPanelModelBase, String string) throws Exception {
        return this.selectByPSSysViewPanelModel(pSSysViewPanelModelBase, string, -1);
    }

    public ArrayList<PSSysViewPanelLogic> selectByPSSysViewPanelModel(PSSysViewPanelModelBase pSSysViewPanelModelBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSVIEWPANELMODELID", (Object)pSSysViewPanelModelBase.getPSSysViewPanelModelId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysViewPanelModelCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysViewPanelModelCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysViewPanelLogic> selectTempByPSSysViewPanelModel(PSSysViewPanelModelBase pSSysViewPanelModelBase) throws Exception {
        return this.selectTempByPSSysViewPanelModel(pSSysViewPanelModelBase, "");
    }

    public ArrayList<PSSysViewPanelLogic> selectTempByPSSysViewPanelModel(PSSysViewPanelModelBase pSSysViewPanelModelBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSVIEWPANELMODELID", (Object)pSSysViewPanelModelBase.getPSSysViewPanelModelId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSSysViewPanelModelCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSSysViewPanelModelCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysViewPanelLogic> selectByLayoutPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase) throws Exception {
        return this.selectByLayoutPSSysViewPanel(pSSysViewPanelBase, "", -1);
    }

    public ArrayList<PSSysViewPanelLogic> selectByLayoutPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase, String string) throws Exception {
        return this.selectByLayoutPSSysViewPanel(pSSysViewPanelBase, string, -1);
    }

    public ArrayList<PSSysViewPanelLogic> selectByLayoutPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("LAYOUTPSSYSVIEWPANELID", (Object)pSSysViewPanelBase.getPSSysViewPanelId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByLayoutPSSysViewPanelCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByLayoutPSSysViewPanelCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysViewPanelLogic> selectByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase) throws Exception {
        return this.selectByPSSysViewPanel(pSSysViewPanelBase, "", -1);
    }

    public ArrayList<PSSysViewPanelLogic> selectByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase, String string) throws Exception {
        return this.selectByPSSysViewPanel(pSSysViewPanelBase, string, -1);
    }

    public ArrayList<PSSysViewPanelLogic> selectByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysViewPanelLogic> selectTempByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase) throws Exception {
        return this.selectTempByPSSysViewPanel(pSSysViewPanelBase, "");
    }

    public ArrayList<PSSysViewPanelLogic> selectTempByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSVIEWPANELID", (Object)pSSysViewPanelBase.getPSSysViewPanelId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSSysViewPanelCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSSysViewPanelCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSAppFunc(PSAppFunc pSAppFunc) throws Exception {
        ArrayList<PSSysViewPanelLogic> arrayList = this.selectByPSAppFunc(pSAppFunc, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSAPPFUNC");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSAppFunc);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSVIEWPANELLOGIC_PSAPPFUNC_PSAPPFUNCID", "", iDataEntityModel.getName(), "PSSYSVIEWPANELLOGIC", iDataEntityModel.getDataInfo(pSAppFunc), arrayList.get(0)));
        }
    }

    public void resetPSAppFunc(PSAppFunc pSAppFunc) throws Exception {
        ArrayList<PSSysViewPanelLogic> arrayList = this.selectByPSAppFunc(pSAppFunc);
        for (PSSysViewPanelLogic pSSysViewPanelLogic : arrayList) {
            PSSysViewPanelLogic pSSysViewPanelLogic2 = (PSSysViewPanelLogic)this.getDEModel().createEntity();
            pSSysViewPanelLogic2.setPSSysViewPanelLogicId(pSSysViewPanelLogic.getPSSysViewPanelLogicId());
            pSSysViewPanelLogic2.setPSAppFuncId(null);
            this.update(pSSysViewPanelLogic2);
        }
    }

    public void removeByPSAppFunc(PSAppFunc pSAppFunc) throws Exception {
        final PSAppFunc pSAppFunc2 = pSAppFunc;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewPanelLogicServiceBase.this.onBeforeRemoveByPSAppFunc(pSAppFunc2);
                PSSysViewPanelLogicServiceBase.this.internalRemoveByPSAppFunc(pSAppFunc2);
                PSSysViewPanelLogicServiceBase.this.onAfterRemoveByPSAppFunc(pSAppFunc2);
            }
        });
    }

    protected void onBeforeRemoveByPSAppFunc(PSAppFunc pSAppFunc) throws Exception {
    }

    protected void internalRemoveByPSAppFunc(PSAppFunc pSAppFunc) throws Exception {
        ArrayList<PSSysViewPanelLogic> arrayList = this.selectByPSAppFunc(pSAppFunc);
        this.onBeforeRemoveByPSAppFunc(pSAppFunc, arrayList);
        for (PSSysViewPanelLogic pSSysViewPanelLogic : arrayList) {
            this.remove(pSSysViewPanelLogic);
        }
        this.onAfterRemoveByPSAppFunc(pSAppFunc, arrayList);
    }

    protected void onAfterRemoveByPSAppFunc(PSAppFunc pSAppFunc) throws Exception {
    }

    protected void onBeforeRemoveByPSAppFunc(PSAppFunc pSAppFunc, ArrayList<PSSysViewPanelLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSAppFunc(PSAppFunc pSAppFunc, ArrayList<PSSysViewPanelLogic> arrayList) throws Exception {
    }

    public void testRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysViewPanelLogic> arrayList = this.selectByPSDE(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSVIEWPANELLOGIC_PSDATAENTITY_PSDEID", "", iDataEntityModel.getName(), "PSSYSVIEWPANELLOGIC", iDataEntityModel.getDataInfo(pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysViewPanelLogic> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSSysViewPanelLogic pSSysViewPanelLogic : arrayList) {
            PSSysViewPanelLogic pSSysViewPanelLogic2 = (PSSysViewPanelLogic)this.getDEModel().createEntity();
            pSSysViewPanelLogic2.setPSSysViewPanelLogicId(pSSysViewPanelLogic.getPSSysViewPanelLogicId());
            pSSysViewPanelLogic2.setPSDEId(null);
            this.update(pSSysViewPanelLogic2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewPanelLogicServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSSysViewPanelLogicServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSSysViewPanelLogicServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysViewPanelLogic> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSSysViewPanelLogic pSSysViewPanelLogic : arrayList) {
            this.remove(pSSysViewPanelLogic);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSSysViewPanelLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSSysViewPanelLogic> arrayList) throws Exception {
    }

    public void testRemoveByPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSSysViewPanelLogic> arrayList = this.selectByPSDELogic(pSDELogic, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDELOGIC");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDELogic);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSVIEWPANELLOGIC_PSDELOGIC_PSDELOGICID", "", iDataEntityModel.getName(), "PSSYSVIEWPANELLOGIC", iDataEntityModel.getDataInfo(pSDELogic), arrayList.get(0)));
        }
    }

    public void resetPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSSysViewPanelLogic> arrayList = this.selectByPSDELogic(pSDELogic);
        for (PSSysViewPanelLogic pSSysViewPanelLogic : arrayList) {
            PSSysViewPanelLogic pSSysViewPanelLogic2 = (PSSysViewPanelLogic)this.getDEModel().createEntity();
            pSSysViewPanelLogic2.setPSSysViewPanelLogicId(pSSysViewPanelLogic.getPSSysViewPanelLogicId());
            pSSysViewPanelLogic2.setPSDELogicId(null);
            this.update(pSSysViewPanelLogic2);
        }
    }

    public void removeByPSDELogic(PSDELogic pSDELogic) throws Exception {
        final PSDELogic pSDELogic2 = pSDELogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewPanelLogicServiceBase.this.onBeforeRemoveByPSDELogic(pSDELogic2);
                PSSysViewPanelLogicServiceBase.this.internalRemoveByPSDELogic(pSDELogic2);
                PSSysViewPanelLogicServiceBase.this.onAfterRemoveByPSDELogic(pSDELogic2);
            }
        });
    }

    protected void onBeforeRemoveByPSDELogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void internalRemoveByPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSSysViewPanelLogic> arrayList = this.selectByPSDELogic(pSDELogic);
        this.onBeforeRemoveByPSDELogic(pSDELogic, arrayList);
        for (PSSysViewPanelLogic pSSysViewPanelLogic : arrayList) {
            this.remove(pSSysViewPanelLogic);
        }
        this.onAfterRemoveByPSDELogic(pSDELogic, arrayList);
    }

    protected void onAfterRemoveByPSDELogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void onBeforeRemoveByPSDELogic(PSDELogic pSDELogic, ArrayList<PSSysViewPanelLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDELogic(PSDELogic pSDELogic, ArrayList<PSSysViewPanelLogic> arrayList) throws Exception {
    }

    public void testRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
        ArrayList<PSSysViewPanelLogic> arrayList = this.selectByPSDEUIAction(pSDEUIAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEUIACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEUIAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSVIEWPANELLOGIC_PSDEUIACTION_PSDEUIACTIONID", "", iDataEntityModel.getName(), "PSSYSVIEWPANELLOGIC", iDataEntityModel.getDataInfo(pSDEUIAction), arrayList.get(0)));
        }
    }

    public void resetPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
        ArrayList<PSSysViewPanelLogic> arrayList = this.selectByPSDEUIAction(pSDEUIAction);
        for (PSSysViewPanelLogic pSSysViewPanelLogic : arrayList) {
            PSSysViewPanelLogic pSSysViewPanelLogic2 = (PSSysViewPanelLogic)this.getDEModel().createEntity();
            pSSysViewPanelLogic2.setPSSysViewPanelLogicId(pSSysViewPanelLogic.getPSSysViewPanelLogicId());
            pSSysViewPanelLogic2.setPSDEUIActionId(null);
            this.update(pSSysViewPanelLogic2);
        }
    }

    public void removeByPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
        final PSDEUIAction pSDEUIAction2 = pSDEUIAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewPanelLogicServiceBase.this.onBeforeRemoveByPSDEUIAction(pSDEUIAction2);
                PSSysViewPanelLogicServiceBase.this.internalRemoveByPSDEUIAction(pSDEUIAction2);
                PSSysViewPanelLogicServiceBase.this.onAfterRemoveByPSDEUIAction(pSDEUIAction2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
    }

    protected void internalRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
        ArrayList<PSSysViewPanelLogic> arrayList = this.selectByPSDEUIAction(pSDEUIAction);
        this.onBeforeRemoveByPSDEUIAction(pSDEUIAction, arrayList);
        for (PSSysViewPanelLogic pSSysViewPanelLogic : arrayList) {
            this.remove(pSSysViewPanelLogic);
        }
        this.onAfterRemoveByPSDEUIAction(pSDEUIAction, arrayList);
    }

    protected void onAfterRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
    }

    protected void onBeforeRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction, ArrayList<PSSysViewPanelLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction, ArrayList<PSSysViewPanelLogic> arrayList) throws Exception {
    }

    public void testRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSSysViewPanelLogic> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSPFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysPFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSVIEWPANELLOGIC_PSSYSPFPLUGIN_PSSYSPFPLUGINID", "", iDataEntityModel.getName(), "PSSYSVIEWPANELLOGIC", iDataEntityModel.getDataInfo(pSSysPFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSSysViewPanelLogic> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        for (PSSysViewPanelLogic pSSysViewPanelLogic : arrayList) {
            PSSysViewPanelLogic pSSysViewPanelLogic2 = (PSSysViewPanelLogic)this.getDEModel().createEntity();
            pSSysViewPanelLogic2.setPSSysViewPanelLogicId(pSSysViewPanelLogic.getPSSysViewPanelLogicId());
            pSSysViewPanelLogic2.setPSSysPFPluginId(null);
            this.update(pSSysViewPanelLogic2);
        }
    }

    public void removeByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        final PSSysPFPlugin pSSysPFPlugin2 = pSSysPFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewPanelLogicServiceBase.this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSSysViewPanelLogicServiceBase.this.internalRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSSysViewPanelLogicServiceBase.this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSSysViewPanelLogic> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
        for (PSSysViewPanelLogic pSSysViewPanelLogic : arrayList) {
            this.remove(pSSysViewPanelLogic);
        }
        this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSSysViewPanelLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSSysViewPanelLogic> arrayList) throws Exception {
    }

    public void testRemoveByPSSysViewLogic(PSSysViewLogic pSSysViewLogic) throws Exception {
        ArrayList<PSSysViewPanelLogic> arrayList = this.selectByPSSysViewLogic(pSSysViewLogic, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSVIEWLOGIC");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysViewLogic);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSVIEWPANELLOGIC_PSSYSVIEWLOGIC_PSSYSVIEWLOGICID", "", iDataEntityModel.getName(), "PSSYSVIEWPANELLOGIC", iDataEntityModel.getDataInfo(pSSysViewLogic), arrayList.get(0)));
        }
    }

    public void resetPSSysViewLogic(PSSysViewLogic pSSysViewLogic) throws Exception {
        ArrayList<PSSysViewPanelLogic> arrayList = this.selectByPSSysViewLogic(pSSysViewLogic);
        for (PSSysViewPanelLogic pSSysViewPanelLogic : arrayList) {
            PSSysViewPanelLogic pSSysViewPanelLogic2 = (PSSysViewPanelLogic)this.getDEModel().createEntity();
            pSSysViewPanelLogic2.setPSSysViewPanelLogicId(pSSysViewPanelLogic.getPSSysViewPanelLogicId());
            pSSysViewPanelLogic2.setPSSysViewLogicId(null);
            this.update(pSSysViewPanelLogic2);
        }
    }

    public void removeByPSSysViewLogic(PSSysViewLogic pSSysViewLogic) throws Exception {
        final PSSysViewLogic pSSysViewLogic2 = pSSysViewLogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewPanelLogicServiceBase.this.onBeforeRemoveByPSSysViewLogic(pSSysViewLogic2);
                PSSysViewPanelLogicServiceBase.this.internalRemoveByPSSysViewLogic(pSSysViewLogic2);
                PSSysViewPanelLogicServiceBase.this.onAfterRemoveByPSSysViewLogic(pSSysViewLogic2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysViewLogic(PSSysViewLogic pSSysViewLogic) throws Exception {
    }

    protected void internalRemoveByPSSysViewLogic(PSSysViewLogic pSSysViewLogic) throws Exception {
        ArrayList<PSSysViewPanelLogic> arrayList = this.selectByPSSysViewLogic(pSSysViewLogic);
        this.onBeforeRemoveByPSSysViewLogic(pSSysViewLogic, arrayList);
        for (PSSysViewPanelLogic pSSysViewPanelLogic : arrayList) {
            this.remove(pSSysViewPanelLogic);
        }
        this.onAfterRemoveByPSSysViewLogic(pSSysViewLogic, arrayList);
    }

    protected void onAfterRemoveByPSSysViewLogic(PSSysViewLogic pSSysViewLogic) throws Exception {
    }

    protected void onBeforeRemoveByPSSysViewLogic(PSSysViewLogic pSSysViewLogic, ArrayList<PSSysViewPanelLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysViewLogic(PSSysViewLogic pSSysViewLogic, ArrayList<PSSysViewPanelLogic> arrayList) throws Exception {
    }

    public void testRemoveByParamPSPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        ArrayList<PSSysViewPanelLogic> arrayList = this.selectByParamPSPanelItem(pSSysViewPanelItem, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSVIEWPANELITEM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysViewPanelItem);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSVIEWPANELLOGIC_PSSYSVIEWPANELITEM_PARAMPSPANELITEMID", "", iDataEntityModel.getName(), "PSSYSVIEWPANELLOGIC", iDataEntityModel.getDataInfo(pSSysViewPanelItem), arrayList.get(0)));
        }
    }

    public void resetParamPSPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        ArrayList<PSSysViewPanelLogic> arrayList = this.selectByParamPSPanelItem(pSSysViewPanelItem);
        for (PSSysViewPanelLogic pSSysViewPanelLogic : arrayList) {
            PSSysViewPanelLogic pSSysViewPanelLogic2 = (PSSysViewPanelLogic)this.getDEModel().createEntity();
            pSSysViewPanelLogic2.setPSSysViewPanelLogicId(pSSysViewPanelLogic.getPSSysViewPanelLogicId());
            pSSysViewPanelLogic2.setParamPSPanelItemId(null);
            this.update(pSSysViewPanelLogic2);
        }
    }

    public void resetTempParamPSPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        ArrayList<PSSysViewPanelLogic> arrayList = this.selectTempByParamPSPanelItem(pSSysViewPanelItem);
        for (PSSysViewPanelLogic pSSysViewPanelLogic : arrayList) {
            PSSysViewPanelLogic pSSysViewPanelLogic2 = (PSSysViewPanelLogic)this.getDEModel().createEntity();
            pSSysViewPanelLogic2.setPSSysViewPanelLogicId(pSSysViewPanelLogic.getPSSysViewPanelLogicId());
            pSSysViewPanelLogic2.setParamPSPanelItemId(null);
            this.updateTemp(pSSysViewPanelLogic2);
        }
    }

    public void removeByParamPSPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        final PSSysViewPanelItem pSSysViewPanelItem2 = pSSysViewPanelItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewPanelLogicServiceBase.this.onBeforeRemoveByParamPSPanelItem(pSSysViewPanelItem2);
                PSSysViewPanelLogicServiceBase.this.internalRemoveByParamPSPanelItem(pSSysViewPanelItem2);
                PSSysViewPanelLogicServiceBase.this.onAfterRemoveByParamPSPanelItem(pSSysViewPanelItem2);
            }
        });
    }

    protected void onBeforeRemoveByParamPSPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
    }

    protected void internalRemoveByParamPSPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        ArrayList<PSSysViewPanelLogic> arrayList = this.selectByParamPSPanelItem(pSSysViewPanelItem);
        this.onBeforeRemoveByParamPSPanelItem(pSSysViewPanelItem, arrayList);
        for (PSSysViewPanelLogic pSSysViewPanelLogic : arrayList) {
            this.remove(pSSysViewPanelLogic);
        }
        this.onAfterRemoveByParamPSPanelItem(pSSysViewPanelItem, arrayList);
    }

    protected void onAfterRemoveByParamPSPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
    }

    protected void onBeforeRemoveByParamPSPanelItem(PSSysViewPanelItem pSSysViewPanelItem, ArrayList<PSSysViewPanelLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByParamPSPanelItem(PSSysViewPanelItem pSSysViewPanelItem, ArrayList<PSSysViewPanelLogic> arrayList) throws Exception {
    }

    public void testRemoveByPSSysViewPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        ArrayList<PSSysViewPanelLogic> arrayList = this.selectByPSSysViewPanelItem(pSSysViewPanelItem, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSVIEWPANELITEM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysViewPanelItem);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSVIEWPANELLOGIC_PSSYSVIEWPANELITEM_PSSYSVIEWPANELITEMID", "", iDataEntityModel.getName(), "PSSYSVIEWPANELLOGIC", iDataEntityModel.getDataInfo(pSSysViewPanelItem), arrayList.get(0)));
        }
    }

    public void resetPSSysViewPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        ArrayList<PSSysViewPanelLogic> arrayList = this.selectByPSSysViewPanelItem(pSSysViewPanelItem);
        for (PSSysViewPanelLogic pSSysViewPanelLogic : arrayList) {
            PSSysViewPanelLogic pSSysViewPanelLogic2 = (PSSysViewPanelLogic)this.getDEModel().createEntity();
            pSSysViewPanelLogic2.setPSSysViewPanelLogicId(pSSysViewPanelLogic.getPSSysViewPanelLogicId());
            pSSysViewPanelLogic2.setPSSysViewPanelItemId(null);
            this.update(pSSysViewPanelLogic2);
        }
    }

    public void resetTempPSSysViewPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        ArrayList<PSSysViewPanelLogic> arrayList = this.selectTempByPSSysViewPanelItem(pSSysViewPanelItem);
        for (PSSysViewPanelLogic pSSysViewPanelLogic : arrayList) {
            PSSysViewPanelLogic pSSysViewPanelLogic2 = (PSSysViewPanelLogic)this.getDEModel().createEntity();
            pSSysViewPanelLogic2.setPSSysViewPanelLogicId(pSSysViewPanelLogic.getPSSysViewPanelLogicId());
            pSSysViewPanelLogic2.setPSSysViewPanelItemId(null);
            this.updateTemp(pSSysViewPanelLogic2);
        }
    }

    public void removeByPSSysViewPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        final PSSysViewPanelItem pSSysViewPanelItem2 = pSSysViewPanelItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewPanelLogicServiceBase.this.onBeforeRemoveByPSSysViewPanelItem(pSSysViewPanelItem2);
                PSSysViewPanelLogicServiceBase.this.internalRemoveByPSSysViewPanelItem(pSSysViewPanelItem2);
                PSSysViewPanelLogicServiceBase.this.onAfterRemoveByPSSysViewPanelItem(pSSysViewPanelItem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysViewPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
    }

    protected void internalRemoveByPSSysViewPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        ArrayList<PSSysViewPanelLogic> arrayList = this.selectByPSSysViewPanelItem(pSSysViewPanelItem);
        this.onBeforeRemoveByPSSysViewPanelItem(pSSysViewPanelItem, arrayList);
        for (PSSysViewPanelLogic pSSysViewPanelLogic : arrayList) {
            this.remove(pSSysViewPanelLogic);
        }
        this.onAfterRemoveByPSSysViewPanelItem(pSSysViewPanelItem, arrayList);
    }

    protected void onAfterRemoveByPSSysViewPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
    }

    protected void onBeforeRemoveByPSSysViewPanelItem(PSSysViewPanelItem pSSysViewPanelItem, ArrayList<PSSysViewPanelLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysViewPanelItem(PSSysViewPanelItem pSSysViewPanelItem, ArrayList<PSSysViewPanelLogic> arrayList) throws Exception {
    }

    public void testRemoveByPSSysViewPanelModel(PSSysViewPanelModel pSSysViewPanelModel) throws Exception {
        ArrayList<PSSysViewPanelLogic> arrayList = this.selectByPSSysViewPanelModel(pSSysViewPanelModel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSVIEWPANELMODEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysViewPanelModel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSVIEWPANELLOGIC_PSSYSVIEWPANELMODEL_PSSYSVIEWPANELMODELID", "", iDataEntityModel.getName(), "PSSYSVIEWPANELLOGIC", iDataEntityModel.getDataInfo(pSSysViewPanelModel), arrayList.get(0)));
        }
    }

    public void resetPSSysViewPanelModel(PSSysViewPanelModel pSSysViewPanelModel) throws Exception {
        ArrayList<PSSysViewPanelLogic> arrayList = this.selectByPSSysViewPanelModel(pSSysViewPanelModel);
        for (PSSysViewPanelLogic pSSysViewPanelLogic : arrayList) {
            PSSysViewPanelLogic pSSysViewPanelLogic2 = (PSSysViewPanelLogic)this.getDEModel().createEntity();
            pSSysViewPanelLogic2.setPSSysViewPanelLogicId(pSSysViewPanelLogic.getPSSysViewPanelLogicId());
            pSSysViewPanelLogic2.setPSSysViewPanelModelId(null);
            this.update(pSSysViewPanelLogic2);
        }
    }

    public void resetTempPSSysViewPanelModel(PSSysViewPanelModel pSSysViewPanelModel) throws Exception {
        ArrayList<PSSysViewPanelLogic> arrayList = this.selectTempByPSSysViewPanelModel(pSSysViewPanelModel);
        for (PSSysViewPanelLogic pSSysViewPanelLogic : arrayList) {
            PSSysViewPanelLogic pSSysViewPanelLogic2 = (PSSysViewPanelLogic)this.getDEModel().createEntity();
            pSSysViewPanelLogic2.setPSSysViewPanelLogicId(pSSysViewPanelLogic.getPSSysViewPanelLogicId());
            pSSysViewPanelLogic2.setPSSysViewPanelModelId(null);
            this.updateTemp(pSSysViewPanelLogic2);
        }
    }

    public void removeByPSSysViewPanelModel(PSSysViewPanelModel pSSysViewPanelModel) throws Exception {
        final PSSysViewPanelModel pSSysViewPanelModel2 = pSSysViewPanelModel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewPanelLogicServiceBase.this.onBeforeRemoveByPSSysViewPanelModel(pSSysViewPanelModel2);
                PSSysViewPanelLogicServiceBase.this.internalRemoveByPSSysViewPanelModel(pSSysViewPanelModel2);
                PSSysViewPanelLogicServiceBase.this.onAfterRemoveByPSSysViewPanelModel(pSSysViewPanelModel2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysViewPanelModel(PSSysViewPanelModel pSSysViewPanelModel) throws Exception {
    }

    protected void internalRemoveByPSSysViewPanelModel(PSSysViewPanelModel pSSysViewPanelModel) throws Exception {
        ArrayList<PSSysViewPanelLogic> arrayList = this.selectByPSSysViewPanelModel(pSSysViewPanelModel);
        this.onBeforeRemoveByPSSysViewPanelModel(pSSysViewPanelModel, arrayList);
        for (PSSysViewPanelLogic pSSysViewPanelLogic : arrayList) {
            this.remove(pSSysViewPanelLogic);
        }
        this.onAfterRemoveByPSSysViewPanelModel(pSSysViewPanelModel, arrayList);
    }

    protected void onAfterRemoveByPSSysViewPanelModel(PSSysViewPanelModel pSSysViewPanelModel) throws Exception {
    }

    protected void onBeforeRemoveByPSSysViewPanelModel(PSSysViewPanelModel pSSysViewPanelModel, ArrayList<PSSysViewPanelLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysViewPanelModel(PSSysViewPanelModel pSSysViewPanelModel, ArrayList<PSSysViewPanelLogic> arrayList) throws Exception {
    }

    public void testRemoveByLayoutPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSSysViewPanelLogic> arrayList = this.selectByLayoutPSSysViewPanel(pSSysViewPanel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSVIEWPANEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysViewPanel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSVIEWPANELLOGIC_PSSYSVIEWPANEL_LAYOUTPSSYSVIEWPANELID", "", iDataEntityModel.getName(), "PSSYSVIEWPANELLOGIC", iDataEntityModel.getDataInfo(pSSysViewPanel), arrayList.get(0)));
        }
    }

    public void resetLayoutPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSSysViewPanelLogic> arrayList = this.selectByLayoutPSSysViewPanel(pSSysViewPanel);
        for (PSSysViewPanelLogic pSSysViewPanelLogic : arrayList) {
            PSSysViewPanelLogic pSSysViewPanelLogic2 = (PSSysViewPanelLogic)this.getDEModel().createEntity();
            pSSysViewPanelLogic2.setPSSysViewPanelLogicId(pSSysViewPanelLogic.getPSSysViewPanelLogicId());
            pSSysViewPanelLogic2.setLayoutPSSysViewPanelId(null);
            this.update(pSSysViewPanelLogic2);
        }
    }

    public void removeByLayoutPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        final PSSysViewPanel pSSysViewPanel2 = pSSysViewPanel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewPanelLogicServiceBase.this.onBeforeRemoveByLayoutPSSysViewPanel(pSSysViewPanel2);
                PSSysViewPanelLogicServiceBase.this.internalRemoveByLayoutPSSysViewPanel(pSSysViewPanel2);
                PSSysViewPanelLogicServiceBase.this.onAfterRemoveByLayoutPSSysViewPanel(pSSysViewPanel2);
            }
        });
    }

    protected void onBeforeRemoveByLayoutPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
    }

    protected void internalRemoveByLayoutPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSSysViewPanelLogic> arrayList = this.selectByLayoutPSSysViewPanel(pSSysViewPanel);
        this.onBeforeRemoveByLayoutPSSysViewPanel(pSSysViewPanel, arrayList);
        for (PSSysViewPanelLogic pSSysViewPanelLogic : arrayList) {
            this.remove(pSSysViewPanelLogic);
        }
        this.onAfterRemoveByLayoutPSSysViewPanel(pSSysViewPanel, arrayList);
    }

    protected void onAfterRemoveByLayoutPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
    }

    protected void onBeforeRemoveByLayoutPSSysViewPanel(PSSysViewPanel pSSysViewPanel, ArrayList<PSSysViewPanelLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByLayoutPSSysViewPanel(PSSysViewPanel pSSysViewPanel, ArrayList<PSSysViewPanelLogic> arrayList) throws Exception {
    }

    public void testRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
    }

    public void resetPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSSysViewPanelLogic> arrayList = this.selectByPSSysViewPanel(pSSysViewPanel);
        for (PSSysViewPanelLogic pSSysViewPanelLogic : arrayList) {
            PSSysViewPanelLogic pSSysViewPanelLogic2 = (PSSysViewPanelLogic)this.getDEModel().createEntity();
            pSSysViewPanelLogic2.setPSSysViewPanelLogicId(pSSysViewPanelLogic.getPSSysViewPanelLogicId());
            pSSysViewPanelLogic2.setPSSysViewPanelId(null);
            this.update(pSSysViewPanelLogic2);
        }
    }

    public void resetTempPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSSysViewPanelLogic> arrayList = this.selectTempByPSSysViewPanel(pSSysViewPanel);
        for (PSSysViewPanelLogic pSSysViewPanelLogic : arrayList) {
            PSSysViewPanelLogic pSSysViewPanelLogic2 = (PSSysViewPanelLogic)this.getDEModel().createEntity();
            pSSysViewPanelLogic2.setPSSysViewPanelLogicId(pSSysViewPanelLogic.getPSSysViewPanelLogicId());
            pSSysViewPanelLogic2.setPSSysViewPanelId(null);
            this.updateTemp(pSSysViewPanelLogic2);
        }
    }

    public void removeByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        final PSSysViewPanel pSSysViewPanel2 = pSSysViewPanel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewPanelLogicServiceBase.this.onBeforeRemoveByPSSysViewPanel(pSSysViewPanel2);
                PSSysViewPanelLogicServiceBase.this.internalRemoveByPSSysViewPanel(pSSysViewPanel2);
                PSSysViewPanelLogicServiceBase.this.onAfterRemoveByPSSysViewPanel(pSSysViewPanel2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
    }

    protected void internalRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSSysViewPanelLogic> arrayList = this.selectByPSSysViewPanel(pSSysViewPanel);
        this.onBeforeRemoveByPSSysViewPanel(pSSysViewPanel, arrayList);
        for (PSSysViewPanelLogic pSSysViewPanelLogic : arrayList) {
            this.remove(pSSysViewPanelLogic);
        }
        this.onAfterRemoveByPSSysViewPanel(pSSysViewPanel, arrayList);
    }

    protected void onAfterRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
    }

    protected void onBeforeRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel, ArrayList<PSSysViewPanelLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel, ArrayList<PSSysViewPanelLogic> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSPanelEngineService)ServiceGlobal.getService(PSPanelEngineService.class, (SessionFactory)this.getSessionFactory());
        ((PSPanelEngineServiceBase)pSCoreSysServiceBase).testRemoveByNo2PSPanelLogic(pSSysViewPanelLogic);
        pSCoreSysServiceBase = (PSPanelEngineService)ServiceGlobal.getService(PSPanelEngineService.class, (SessionFactory)this.getSessionFactory());
        ((PSPanelEngineServiceBase)pSCoreSysServiceBase).testRemoveByNo3PSPanelLogic(pSSysViewPanelLogic);
        pSCoreSysServiceBase = (PSPanelEngineService)ServiceGlobal.getService(PSPanelEngineService.class, (SessionFactory)this.getSessionFactory());
        ((PSPanelEngineServiceBase)pSCoreSysServiceBase).testRemoveByNo4PSPanelLogic(pSSysViewPanelLogic);
        pSCoreSysServiceBase = (PSPanelEngineService)ServiceGlobal.getService(PSPanelEngineService.class, (SessionFactory)this.getSessionFactory());
        ((PSPanelEngineServiceBase)pSCoreSysServiceBase).testRemoveByPSPanelLogic(pSSysViewPanelLogic);
        pSCoreSysServiceBase = (PSPanelLogicLinkService)ServiceGlobal.getService(PSPanelLogicLinkService.class, (SessionFactory)this.getSessionFactory());
        ((PSPanelLogicLinkServiceBase)pSCoreSysServiceBase).testRemoveByPSSysViewPanelLogic(pSSysViewPanelLogic);
        ((PSPanelLogicLinkServiceBase)pSCoreSysServiceBase).resetPSSysViewPanelLogic(pSSysViewPanelLogic);
        pSCoreSysServiceBase = (PSPanelLogicNodeService)ServiceGlobal.getService(PSPanelLogicNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSPanelLogicNodeServiceBase)pSCoreSysServiceBase).testRemoveByPSSysViewPanelLogic(pSSysViewPanelLogic);
        ((PSPanelLogicNodeServiceBase)pSCoreSysServiceBase).removeByPSSysViewPanelLogic(pSSysViewPanelLogic);
        pSCoreSysServiceBase = (PSPanelLogicParamService)ServiceGlobal.getService(PSPanelLogicParamService.class, (SessionFactory)this.getSessionFactory());
        ((PSPanelLogicParamServiceBase)pSCoreSysServiceBase).testRemoveByPSSysViewPanelLogic(pSSysViewPanelLogic);
        ((PSPanelLogicParamServiceBase)pSCoreSysServiceBase).removeByPSSysViewPanelLogic(pSSysViewPanelLogic);
        super.onBeforeRemove(pSSysViewPanelLogic);
    }

    protected void onBeforeRemoveTemp(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSPanelLogicLinkService)ServiceGlobal.getService(PSPanelLogicLinkService.class, (SessionFactory)this.getSessionFactory());
        ((PSPanelLogicLinkServiceBase)pSCoreSysServiceBase).removeTempByPSSysViewPanelLogic(pSSysViewPanelLogic);
        pSCoreSysServiceBase = (PSPanelLogicNodeService)ServiceGlobal.getService(PSPanelLogicNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSPanelLogicNodeServiceBase)pSCoreSysServiceBase).removeTempByPSSysViewPanelLogic(pSSysViewPanelLogic);
        pSCoreSysServiceBase = (PSPanelLogicParamService)ServiceGlobal.getService(PSPanelLogicParamService.class, (SessionFactory)this.getSessionFactory());
        ((PSPanelLogicParamServiceBase)pSCoreSysServiceBase).removeTempByPSSysViewPanelLogic(pSSysViewPanelLogic);
        pSCoreSysServiceBase = (PSPanelEngineService)ServiceGlobal.getService(PSPanelEngineService.class, (SessionFactory)this.getSessionFactory());
        ((PSPanelEngineServiceBase)pSCoreSysServiceBase).resetTempPSPanelLogic(pSSysViewPanelLogic);
        pSCoreSysServiceBase = (PSPanelEngineService)ServiceGlobal.getService(PSPanelEngineService.class, (SessionFactory)this.getSessionFactory());
        ((PSPanelEngineServiceBase)pSCoreSysServiceBase).resetTempNo4PSPanelLogic(pSSysViewPanelLogic);
        pSCoreSysServiceBase = (PSPanelEngineService)ServiceGlobal.getService(PSPanelEngineService.class, (SessionFactory)this.getSessionFactory());
        ((PSPanelEngineServiceBase)pSCoreSysServiceBase).resetTempNo3PSPanelLogic(pSSysViewPanelLogic);
        pSCoreSysServiceBase = (PSPanelEngineService)ServiceGlobal.getService(PSPanelEngineService.class, (SessionFactory)this.getSessionFactory());
        ((PSPanelEngineServiceBase)pSCoreSysServiceBase).resetTempNo2PSPanelLogic(pSSysViewPanelLogic);
        super.onBeforeRemoveTemp(pSSysViewPanelLogic);
    }

    public void removeTempByParamPSPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        final PSSysViewPanelItem pSSysViewPanelItem2 = pSSysViewPanelItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewPanelLogicServiceBase.this.onBeforeRemoveTempByParamPSPanelItem(pSSysViewPanelItem2);
                PSSysViewPanelLogicServiceBase.this.internalRemoveTempByParamPSPanelItem(pSSysViewPanelItem2);
                PSSysViewPanelLogicServiceBase.this.onAfterRemoveTempByParamPSPanelItem(pSSysViewPanelItem2);
            }
        });
    }

    protected void onBeforeRemoveTempByParamPSPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
    }

    protected void internalRemoveTempByParamPSPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        ArrayList<PSSysViewPanelLogic> arrayList = this.selectTempByParamPSPanelItem(pSSysViewPanelItem);
        this.onBeforeRemoveTempByParamPSPanelItem(pSSysViewPanelItem, arrayList);
        for (PSSysViewPanelLogic pSSysViewPanelLogic : arrayList) {
            this.removeTemp(pSSysViewPanelLogic);
        }
        this.onAfterRemoveTempByParamPSPanelItem(pSSysViewPanelItem, arrayList);
    }

    protected void onAfterRemoveTempByParamPSPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
    }

    protected void onBeforeRemoveTempByParamPSPanelItem(PSSysViewPanelItem pSSysViewPanelItem, ArrayList<PSSysViewPanelLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByParamPSPanelItem(PSSysViewPanelItem pSSysViewPanelItem, ArrayList<PSSysViewPanelLogic> arrayList) throws Exception {
    }

    public void removeTempByPSSysViewPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        final PSSysViewPanelItem pSSysViewPanelItem2 = pSSysViewPanelItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewPanelLogicServiceBase.this.onBeforeRemoveTempByPSSysViewPanelItem(pSSysViewPanelItem2);
                PSSysViewPanelLogicServiceBase.this.internalRemoveTempByPSSysViewPanelItem(pSSysViewPanelItem2);
                PSSysViewPanelLogicServiceBase.this.onAfterRemoveTempByPSSysViewPanelItem(pSSysViewPanelItem2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSSysViewPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
    }

    protected void internalRemoveTempByPSSysViewPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        ArrayList<PSSysViewPanelLogic> arrayList = this.selectTempByPSSysViewPanelItem(pSSysViewPanelItem);
        this.onBeforeRemoveTempByPSSysViewPanelItem(pSSysViewPanelItem, arrayList);
        for (PSSysViewPanelLogic pSSysViewPanelLogic : arrayList) {
            this.removeTemp(pSSysViewPanelLogic);
        }
        this.onAfterRemoveTempByPSSysViewPanelItem(pSSysViewPanelItem, arrayList);
    }

    protected void onAfterRemoveTempByPSSysViewPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
    }

    protected void onBeforeRemoveTempByPSSysViewPanelItem(PSSysViewPanelItem pSSysViewPanelItem, ArrayList<PSSysViewPanelLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSSysViewPanelItem(PSSysViewPanelItem pSSysViewPanelItem, ArrayList<PSSysViewPanelLogic> arrayList) throws Exception {
    }

    public void removeTempByPSSysViewPanelModel(PSSysViewPanelModel pSSysViewPanelModel) throws Exception {
        final PSSysViewPanelModel pSSysViewPanelModel2 = pSSysViewPanelModel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewPanelLogicServiceBase.this.onBeforeRemoveTempByPSSysViewPanelModel(pSSysViewPanelModel2);
                PSSysViewPanelLogicServiceBase.this.internalRemoveTempByPSSysViewPanelModel(pSSysViewPanelModel2);
                PSSysViewPanelLogicServiceBase.this.onAfterRemoveTempByPSSysViewPanelModel(pSSysViewPanelModel2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSSysViewPanelModel(PSSysViewPanelModel pSSysViewPanelModel) throws Exception {
    }

    protected void internalRemoveTempByPSSysViewPanelModel(PSSysViewPanelModel pSSysViewPanelModel) throws Exception {
        ArrayList<PSSysViewPanelLogic> arrayList = this.selectTempByPSSysViewPanelModel(pSSysViewPanelModel);
        this.onBeforeRemoveTempByPSSysViewPanelModel(pSSysViewPanelModel, arrayList);
        for (PSSysViewPanelLogic pSSysViewPanelLogic : arrayList) {
            this.removeTemp(pSSysViewPanelLogic);
        }
        this.onAfterRemoveTempByPSSysViewPanelModel(pSSysViewPanelModel, arrayList);
    }

    protected void onAfterRemoveTempByPSSysViewPanelModel(PSSysViewPanelModel pSSysViewPanelModel) throws Exception {
    }

    protected void onBeforeRemoveTempByPSSysViewPanelModel(PSSysViewPanelModel pSSysViewPanelModel, ArrayList<PSSysViewPanelLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSSysViewPanelModel(PSSysViewPanelModel pSSysViewPanelModel, ArrayList<PSSysViewPanelLogic> arrayList) throws Exception {
    }

    public void removeTempByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        final PSSysViewPanel pSSysViewPanel2 = pSSysViewPanel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewPanelLogicServiceBase.this.onBeforeRemoveTempByPSSysViewPanel(pSSysViewPanel2);
                PSSysViewPanelLogicServiceBase.this.internalRemoveTempByPSSysViewPanel(pSSysViewPanel2);
                PSSysViewPanelLogicServiceBase.this.onAfterRemoveTempByPSSysViewPanel(pSSysViewPanel2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
    }

    protected void internalRemoveTempByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSSysViewPanelLogic> arrayList = this.selectTempByPSSysViewPanel(pSSysViewPanel);
        this.onBeforeRemoveTempByPSSysViewPanel(pSSysViewPanel, arrayList);
        for (PSSysViewPanelLogic pSSysViewPanelLogic : arrayList) {
            this.removeTemp(pSSysViewPanelLogic);
        }
        this.onAfterRemoveTempByPSSysViewPanel(pSSysViewPanel, arrayList);
    }

    protected void onAfterRemoveTempByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
    }

    protected void onBeforeRemoveTempByPSSysViewPanel(PSSysViewPanel pSSysViewPanel, ArrayList<PSSysViewPanelLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSSysViewPanel(PSSysViewPanel pSSysViewPanel, ArrayList<PSSysViewPanelLogic> arrayList) throws Exception {
    }

    protected void getRelatedDataTempMajor(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
        this.getRelatedDataTempMajor_PSPanelLogicParam(pSSysViewPanelLogic);
        this.getRelatedDataTempMajor_PSPanelLogicNode(pSSysViewPanelLogic);
        this.getRelatedDataTempMajor_PSPanelLogicLink(pSSysViewPanelLogic);
        super.getRelatedDataTempMajor(pSSysViewPanelLogic);
    }

    protected void getRelatedDataTempMajor_PSPanelLogicParam(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
        PSPanelLogicParamService pSPanelLogicParamService = (PSPanelLogicParamService)ServiceGlobal.getService(PSPanelLogicParamService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSPanelLogicParam> arrayList = null;
        String string = pSSysViewPanelLogic.getPSSysViewPanelLogicId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSPanelLogicParamService.selectByPSSysViewPanelLogic(pSSysViewPanelLogic) : pSPanelLogicParamService.selectTempByPSSysViewPanelLogic(pSSysViewPanelLogic);
        for (PSPanelLogicParam pSPanelLogicParam : arrayList) {
            pSPanelLogicParamService.getTempMajor(pSPanelLogicParam);
        }
    }

    protected void getRelatedDataTempMajor_PSPanelLogicNode(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
        PSPanelLogicNodeService pSPanelLogicNodeService = (PSPanelLogicNodeService)ServiceGlobal.getService(PSPanelLogicNodeService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSPanelLogicNode> arrayList = null;
        String string = pSSysViewPanelLogic.getPSSysViewPanelLogicId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSPanelLogicNodeService.selectByPSSysViewPanelLogic(pSSysViewPanelLogic) : pSPanelLogicNodeService.selectTempByPSSysViewPanelLogic(pSSysViewPanelLogic);
        for (PSPanelLogicNode pSPanelLogicNode : arrayList) {
            pSPanelLogicNodeService.getTempMajor(pSPanelLogicNode);
        }
    }

    protected void getRelatedDataTempMajor_PSPanelLogicLink(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
        PSPanelLogicLinkService pSPanelLogicLinkService = (PSPanelLogicLinkService)ServiceGlobal.getService(PSPanelLogicLinkService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSPanelLogicLink> arrayList = null;
        String string = pSSysViewPanelLogic.getPSSysViewPanelLogicId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSPanelLogicLinkService.selectByPSSysViewPanelLogic(pSSysViewPanelLogic) : pSPanelLogicLinkService.selectTempByPSSysViewPanelLogic(pSSysViewPanelLogic);
        for (PSPanelLogicLink pSPanelLogicLink : arrayList) {
            pSPanelLogicLinkService.getTempMajor(pSPanelLogicLink);
        }
    }

    protected void updateRelatedDataTempMajor(PSSysViewPanelLogic pSSysViewPanelLogic, PSSysViewPanelLogic pSSysViewPanelLogic2) throws Exception {
        ArrayList<PSPanelLogicLink> arrayList = this.updateRelatedDataTempMajor_removePSPanelLogicLink(pSSysViewPanelLogic, pSSysViewPanelLogic2);
        ArrayList<PSPanelLogicNode> arrayList2 = this.updateRelatedDataTempMajor_removePSPanelLogicNode(pSSysViewPanelLogic, pSSysViewPanelLogic2);
        ArrayList<PSPanelLogicParam> arrayList3 = this.updateRelatedDataTempMajor_removePSPanelLogicParam(pSSysViewPanelLogic, pSSysViewPanelLogic2);
        this.updateRelatedDataTempMajor_updatePSPanelLogicParam(pSSysViewPanelLogic, pSSysViewPanelLogic2, arrayList3);
        this.updateRelatedDataTempMajor_updatePSPanelLogicNode(pSSysViewPanelLogic, pSSysViewPanelLogic2, arrayList2);
        this.updateRelatedDataTempMajor_updatePSPanelLogicLink(pSSysViewPanelLogic, pSSysViewPanelLogic2, arrayList);
        super.updateRelatedDataTempMajor(pSSysViewPanelLogic, pSSysViewPanelLogic2);
    }

    protected ArrayList<PSPanelLogicParam> updateRelatedDataTempMajor_removePSPanelLogicParam(PSSysViewPanelLogic pSSysViewPanelLogic, PSSysViewPanelLogic pSSysViewPanelLogic2) throws Exception {
        PSPanelLogicParamService pSPanelLogicParamService = (PSPanelLogicParamService)ServiceGlobal.getService(PSPanelLogicParamService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSPanelLogicParam> arrayList = pSPanelLogicParamService.selectTempByPSSysViewPanelLogic(pSSysViewPanelLogic);
        ArrayList<PSPanelLogicParam> arrayList2 = pSPanelLogicParamService.selectByPSSysViewPanelLogic(pSSysViewPanelLogic2);
        HashMap<String, PSPanelLogicParam> hashMap = new HashMap<String, PSPanelLogicParam>();
        for (PSPanelLogicParam pSPanelLogicParam : arrayList2) {
            hashMap.put(pSPanelLogicParam.getPSPanelLogicParamId(), pSPanelLogicParam);
        }
        for (PSPanelLogicParam pSPanelLogicParam : arrayList) {
            Object object = pSPanelLogicParam.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSPanelLogicParam pSPanelLogicParam : hashMap.values()) {
            pSPanelLogicParamService.remove(pSPanelLogicParam);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSPanelLogicParam(PSSysViewPanelLogic pSSysViewPanelLogic, PSSysViewPanelLogic pSSysViewPanelLogic2, ArrayList<PSPanelLogicParam> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSPanelLogicParamService pSPanelLogicParamService = (PSPanelLogicParamService)ServiceGlobal.getService(PSPanelLogicParamService.class, (SessionFactory)this.getSessionFactory());
        for (PSPanelLogicParam pSPanelLogicParam : arrayList) {
            pSPanelLogicParamService.updateTempMajor(pSPanelLogicParam);
        }
    }

    protected ArrayList<PSPanelLogicNode> updateRelatedDataTempMajor_removePSPanelLogicNode(PSSysViewPanelLogic pSSysViewPanelLogic, PSSysViewPanelLogic pSSysViewPanelLogic2) throws Exception {
        PSPanelLogicNodeService pSPanelLogicNodeService = (PSPanelLogicNodeService)ServiceGlobal.getService(PSPanelLogicNodeService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSPanelLogicNode> arrayList = pSPanelLogicNodeService.selectTempByPSSysViewPanelLogic(pSSysViewPanelLogic);
        ArrayList<PSPanelLogicNode> arrayList2 = pSPanelLogicNodeService.selectByPSSysViewPanelLogic(pSSysViewPanelLogic2);
        HashMap<String, PSPanelLogicNode> hashMap = new HashMap<String, PSPanelLogicNode>();
        for (PSPanelLogicNode pSPanelLogicNode : arrayList2) {
            hashMap.put(pSPanelLogicNode.getPSPanelLogicNodeId(), pSPanelLogicNode);
        }
        for (PSPanelLogicNode pSPanelLogicNode : arrayList) {
            Object object = pSPanelLogicNode.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSPanelLogicNode pSPanelLogicNode : hashMap.values()) {
            pSPanelLogicNodeService.remove(pSPanelLogicNode);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSPanelLogicNode(PSSysViewPanelLogic pSSysViewPanelLogic, PSSysViewPanelLogic pSSysViewPanelLogic2, ArrayList<PSPanelLogicNode> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSPanelLogicNodeService pSPanelLogicNodeService = (PSPanelLogicNodeService)ServiceGlobal.getService(PSPanelLogicNodeService.class, (SessionFactory)this.getSessionFactory());
        for (PSPanelLogicNode pSPanelLogicNode : arrayList) {
            pSPanelLogicNodeService.updateTempMajor(pSPanelLogicNode);
        }
    }

    protected ArrayList<PSPanelLogicLink> updateRelatedDataTempMajor_removePSPanelLogicLink(PSSysViewPanelLogic pSSysViewPanelLogic, PSSysViewPanelLogic pSSysViewPanelLogic2) throws Exception {
        PSPanelLogicLinkService pSPanelLogicLinkService = (PSPanelLogicLinkService)ServiceGlobal.getService(PSPanelLogicLinkService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSPanelLogicLink> arrayList = pSPanelLogicLinkService.selectTempByPSSysViewPanelLogic(pSSysViewPanelLogic);
        ArrayList<PSPanelLogicLink> arrayList2 = pSPanelLogicLinkService.selectByPSSysViewPanelLogic(pSSysViewPanelLogic2);
        HashMap<String, PSPanelLogicLink> hashMap = new HashMap<String, PSPanelLogicLink>();
        for (PSPanelLogicLink pSPanelLogicLink : arrayList2) {
            hashMap.put(pSPanelLogicLink.getPSPanelLogicLinkId(), pSPanelLogicLink);
        }
        for (PSPanelLogicLink pSPanelLogicLink : arrayList) {
            Object object = pSPanelLogicLink.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSPanelLogicLink pSPanelLogicLink : hashMap.values()) {
            pSPanelLogicLinkService.remove(pSPanelLogicLink);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSPanelLogicLink(PSSysViewPanelLogic pSSysViewPanelLogic, PSSysViewPanelLogic pSSysViewPanelLogic2, ArrayList<PSPanelLogicLink> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSPanelLogicLinkService pSPanelLogicLinkService = (PSPanelLogicLinkService)ServiceGlobal.getService(PSPanelLogicLinkService.class, (SessionFactory)this.getSessionFactory());
        for (PSPanelLogicLink pSPanelLogicLink : arrayList) {
            pSPanelLogicLinkService.updateTempMajor(pSPanelLogicLink);
        }
    }

    protected void replaceParentInfo(PSSysViewPanelLogic pSSysViewPanelLogic, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSysViewPanelLogic, cloneSession);
        if (pSSysViewPanelLogic.getPSAppFuncId() != null && (iEntity = cloneSession.getEntity("PSAPPFUNC", (Object)pSSysViewPanelLogic.getPSAppFuncId())) != null) {
            this.onFillParentInfo_PSAppFunc(pSSysViewPanelLogic, (PSAppFunc)iEntity);
        }
        if (pSSysViewPanelLogic.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSSysViewPanelLogic.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSSysViewPanelLogic, (PSDataEntity)iEntity);
        }
        if (pSSysViewPanelLogic.getPSDELogicId() != null && (iEntity = cloneSession.getEntity("PSDELOGIC", (Object)pSSysViewPanelLogic.getPSDELogicId())) != null) {
            this.onFillParentInfo_PSDELogic(pSSysViewPanelLogic, (PSDELogic)iEntity);
        }
        if (pSSysViewPanelLogic.getPSDEUIActionId() != null && (iEntity = cloneSession.getEntity("PSDEUIACTION", (Object)pSSysViewPanelLogic.getPSDEUIActionId())) != null) {
            this.onFillParentInfo_PSDEUIAction(pSSysViewPanelLogic, (PSDEUIAction)iEntity);
        }
        if (pSSysViewPanelLogic.getPSSysPFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSPFPLUGIN", (Object)pSSysViewPanelLogic.getPSSysPFPluginId())) != null) {
            this.onFillParentInfo_PSSysPFPlugin(pSSysViewPanelLogic, (PSSysPFPlugin)iEntity);
        }
        if (pSSysViewPanelLogic.getPSSysViewLogicId() != null && (iEntity = cloneSession.getEntity("PSSYSVIEWLOGIC", (Object)pSSysViewPanelLogic.getPSSysViewLogicId())) != null) {
            this.onFillParentInfo_PSSysViewLogic(pSSysViewPanelLogic, (PSSysViewLogic)iEntity);
        }
        if (pSSysViewPanelLogic.getParamPSPanelItemId() != null && (iEntity = cloneSession.getEntity("PSSYSVIEWPANELITEM", (Object)pSSysViewPanelLogic.getParamPSPanelItemId())) != null) {
            this.onFillParentInfo_ParamPSPanelItem(pSSysViewPanelLogic, (PSSysViewPanelItem)iEntity);
        }
        if (pSSysViewPanelLogic.getPSSysViewPanelItemId() != null && (iEntity = cloneSession.getEntity("PSSYSVIEWPANELITEM", (Object)pSSysViewPanelLogic.getPSSysViewPanelItemId())) != null) {
            this.onFillParentInfo_PSSysViewPanelItem(pSSysViewPanelLogic, (PSSysViewPanelItem)iEntity);
        }
        if (pSSysViewPanelLogic.getPSSysViewPanelModelId() != null && (iEntity = cloneSession.getEntity("PSSYSVIEWPANELMODEL", (Object)pSSysViewPanelLogic.getPSSysViewPanelModelId())) != null) {
            this.onFillParentInfo_PSSysViewPanelModel(pSSysViewPanelLogic, (PSSysViewPanelModel)iEntity);
        }
        if (pSSysViewPanelLogic.getLayoutPSSysViewPanelId() != null && (iEntity = cloneSession.getEntity("PSSYSVIEWPANEL", (Object)pSSysViewPanelLogic.getLayoutPSSysViewPanelId())) != null) {
            this.onFillParentInfo_LayoutPSSysViewPanel(pSSysViewPanelLogic, (PSSysViewPanel)iEntity);
        }
        if (pSSysViewPanelLogic.getPSSysViewPanelId() != null && (iEntity = cloneSession.getEntity("PSSYSVIEWPANEL", (Object)pSSysViewPanelLogic.getPSSysViewPanelId())) != null) {
            this.onFillParentInfo_PSSysViewPanel(pSSysViewPanelLogic, (PSSysViewPanel)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysViewPanelLogic pSSysViewPanelLogic, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSysViewPanelLogic, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysViewPanelLogic pSSysViewPanelLogic, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AttrName(bl, pSSysViewPanelLogic, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSSysViewPanelLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CtrlEvent(bl, pSSysViewPanelLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CtrlEventArg(bl, pSSysViewPanelLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CtrlEventArg2(bl, pSSysViewPanelLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CtrlEventName(bl, pSSysViewPanelLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomCode(bl, pSSysViewPanelLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DstLogicType(bl, pSSysViewPanelLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LayoutPSSysViewPanelId(bl, pSSysViewPanelLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogicModel(bl, pSSysViewPanelLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogicParam(bl, pSSysViewPanelLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogicParam2(bl, pSSysViewPanelLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogicType(bl, pSSysViewPanelLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysViewPanelLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSSysViewPanelLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ParamPSPanelItemId(bl, pSSysViewPanelLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppFuncId(bl, pSSysViewPanelLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSSysViewPanelLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDELogicId(bl, pSSysViewPanelLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSSysViewPanelLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEUIActionId(bl, pSSysViewPanelLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysPFPluginId(bl, pSSysViewPanelLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysViewLogicId(bl, pSSysViewPanelLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysViewPanelId(bl, pSSysViewPanelLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysViewPanelItemId(bl, pSSysViewPanelLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysViewPanelLogicId(bl, pSSysViewPanelLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysViewPanelLogicName(bl, pSSysViewPanelLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysViewPanelModelId(bl, pSSysViewPanelLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Timer(bl, pSSysViewPanelLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSSysViewPanelLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSysViewPanelLogic, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AttrName(boolean bl, PSSysViewPanelLogic pSSysViewPanelLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelLogic.isAttrNameDirty() : !pSSysViewPanelLogic.isAttrNameDirty()) {
            return null;
        }
        String string = pSSysViewPanelLogic.getAttrName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AttrName_Default(pSSysViewPanelLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSSysViewPanelLogic pSSysViewPanelLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelLogic.isCodeNameDirty() : !pSSysViewPanelLogic.isCodeNameDirty()) {
            return null;
        }
        String string = pSSysViewPanelLogic.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSSysViewPanelLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CtrlEvent(boolean bl, PSSysViewPanelLogic pSSysViewPanelLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelLogic.isCtrlEventDirty() : !pSSysViewPanelLogic.isCtrlEventDirty()) {
            return null;
        }
        String string = pSSysViewPanelLogic.getCtrlEvent();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CtrlEvent_Default(pSSysViewPanelLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CTRLEVENT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CtrlEventArg(boolean bl, PSSysViewPanelLogic pSSysViewPanelLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelLogic.isCtrlEventArgDirty() : !pSSysViewPanelLogic.isCtrlEventArgDirty()) {
            return null;
        }
        String string = pSSysViewPanelLogic.getCtrlEventArg();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CtrlEventArg_Default(pSSysViewPanelLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CTRLEVENTARG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CtrlEventArg2(boolean bl, PSSysViewPanelLogic pSSysViewPanelLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelLogic.isCtrlEventArg2Dirty() : !pSSysViewPanelLogic.isCtrlEventArg2Dirty()) {
            return null;
        }
        String string = pSSysViewPanelLogic.getCtrlEventArg2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CtrlEventArg2_Default(pSSysViewPanelLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CTRLEVENTARG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CtrlEventName(boolean bl, PSSysViewPanelLogic pSSysViewPanelLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelLogic.isCtrlEventNameDirty() : !pSSysViewPanelLogic.isCtrlEventNameDirty()) {
            return null;
        }
        String string = pSSysViewPanelLogic.getCtrlEventName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CtrlEventName_Default(pSSysViewPanelLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CTRLEVENTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CustomCode(boolean bl, PSSysViewPanelLogic pSSysViewPanelLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelLogic.isCustomCodeDirty() : !pSSysViewPanelLogic.isCustomCodeDirty()) {
            return null;
        }
        String string = pSSysViewPanelLogic.getCustomCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomCode_Default(pSSysViewPanelLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_DstLogicType(boolean bl, PSSysViewPanelLogic pSSysViewPanelLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelLogic.isDstLogicTypeDirty() : !pSSysViewPanelLogic.isDstLogicTypeDirty()) {
            return null;
        }
        String string = pSSysViewPanelLogic.getDstLogicType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DstLogicType_Default(pSSysViewPanelLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_LayoutPSSysViewPanelId(boolean bl, PSSysViewPanelLogic pSSysViewPanelLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelLogic.isLayoutPSSysViewPanelIdDirty() : !pSSysViewPanelLogic.isLayoutPSSysViewPanelIdDirty()) {
            return null;
        }
        String string = pSSysViewPanelLogic.getLayoutPSSysViewPanelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LayoutPSSysViewPanelId_Default(pSSysViewPanelLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LAYOUTPSSYSVIEWPANELID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LogicModel(boolean bl, PSSysViewPanelLogic pSSysViewPanelLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelLogic.isLogicModelDirty() : !pSSysViewPanelLogic.isLogicModelDirty()) {
            return null;
        }
        String string = pSSysViewPanelLogic.getLogicModel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogicModel_Default(pSSysViewPanelLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOGICMODEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LogicParam(boolean bl, PSSysViewPanelLogic pSSysViewPanelLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelLogic.isLogicParamDirty() : !pSSysViewPanelLogic.isLogicParamDirty()) {
            return null;
        }
        String string = pSSysViewPanelLogic.getLogicParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogicParam_Default(pSSysViewPanelLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_LogicParam2(boolean bl, PSSysViewPanelLogic pSSysViewPanelLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelLogic.isLogicParam2Dirty() : !pSSysViewPanelLogic.isLogicParam2Dirty()) {
            return null;
        }
        String string = pSSysViewPanelLogic.getLogicParam2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogicParam2_Default(pSSysViewPanelLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_LogicType(boolean bl, PSSysViewPanelLogic pSSysViewPanelLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelLogic.isLogicTypeDirty() && !bl2 : !pSSysViewPanelLogic.isLogicTypeDirty()) {
            return null;
        }
        String string = pSSysViewPanelLogic.getLogicType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOGICTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogicType_Default(pSSysViewPanelLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOGICTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysViewPanelLogic pSSysViewPanelLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelLogic.isMemoDirty() : !pSSysViewPanelLogic.isMemoDirty()) {
            return null;
        }
        String string = pSSysViewPanelLogic.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSysViewPanelLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSSysViewPanelLogic pSSysViewPanelLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelLogic.isOrderValueDirty() : !pSSysViewPanelLogic.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSSysViewPanelLogic.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSSysViewPanelLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_ParamPSPanelItemId(boolean bl, PSSysViewPanelLogic pSSysViewPanelLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelLogic.isParamPSPanelItemIdDirty() : !pSSysViewPanelLogic.isParamPSPanelItemIdDirty()) {
            return null;
        }
        String string = pSSysViewPanelLogic.getParamPSPanelItemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ParamPSPanelItemId_Default(pSSysViewPanelLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAMPSPANELITEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSAppFuncId(boolean bl, PSSysViewPanelLogic pSSysViewPanelLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelLogic.isPSAppFuncIdDirty() : !pSSysViewPanelLogic.isPSAppFuncIdDirty()) {
            return null;
        }
        String string = pSSysViewPanelLogic.getPSAppFuncId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppFuncId_Default(pSSysViewPanelLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPFUNCID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSSysViewPanelLogic pSSysViewPanelLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelLogic.isPSDEIdDirty() : !pSSysViewPanelLogic.isPSDEIdDirty()) {
            return null;
        }
        String string = pSSysViewPanelLogic.getPSDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default(pSSysViewPanelLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDELogicId(boolean bl, PSSysViewPanelLogic pSSysViewPanelLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelLogic.isPSDELogicIdDirty() : !pSSysViewPanelLogic.isPSDELogicIdDirty()) {
            return null;
        }
        String string = pSSysViewPanelLogic.getPSDELogicId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDELogicId_Default(pSSysViewPanelLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSSysViewPanelLogic pSSysViewPanelLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelLogic.isPSDENameDirty() : !pSSysViewPanelLogic.isPSDENameDirty()) {
            return null;
        }
        String string = pSSysViewPanelLogic.getPSDEName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default(pSSysViewPanelLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEUIActionId(boolean bl, PSSysViewPanelLogic pSSysViewPanelLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelLogic.isPSDEUIActionIdDirty() : !pSSysViewPanelLogic.isPSDEUIActionIdDirty()) {
            return null;
        }
        String string = pSSysViewPanelLogic.getPSDEUIActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEUIActionId_Default(pSSysViewPanelLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysPFPluginId(boolean bl, PSSysViewPanelLogic pSSysViewPanelLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelLogic.isPSSysPFPluginIdDirty() : !pSSysViewPanelLogic.isPSSysPFPluginIdDirty()) {
            return null;
        }
        String string = pSSysViewPanelLogic.getPSSysPFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysPFPluginId_Default(pSSysViewPanelLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysViewLogicId(boolean bl, PSSysViewPanelLogic pSSysViewPanelLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelLogic.isPSSysViewLogicIdDirty() : !pSSysViewPanelLogic.isPSSysViewLogicIdDirty()) {
            return null;
        }
        String string = pSSysViewPanelLogic.getPSSysViewLogicId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysViewLogicId_Default(pSSysViewPanelLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysViewPanelId(boolean bl, PSSysViewPanelLogic pSSysViewPanelLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelLogic.isPSSysViewPanelIdDirty() && !bl2 : !pSSysViewPanelLogic.isPSSysViewPanelIdDirty()) {
            return null;
        }
        String string = pSSysViewPanelLogic.getPSSysViewPanelId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSVIEWPANELID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysViewPanelId_Default(pSSysViewPanelLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysViewPanelItemId(boolean bl, PSSysViewPanelLogic pSSysViewPanelLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelLogic.isPSSysViewPanelItemIdDirty() : !pSSysViewPanelLogic.isPSSysViewPanelItemIdDirty()) {
            return null;
        }
        String string = pSSysViewPanelLogic.getPSSysViewPanelItemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysViewPanelItemId_Default(pSSysViewPanelLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSVIEWPANELITEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysViewPanelLogicId(boolean bl, PSSysViewPanelLogic pSSysViewPanelLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelLogic.isPSSysViewPanelLogicIdDirty() && !bl2 : !pSSysViewPanelLogic.isPSSysViewPanelLogicIdDirty()) {
            return null;
        }
        String string = pSSysViewPanelLogic.getPSSysViewPanelLogicId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSVIEWPANELLOGICID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysViewPanelLogicId_Default(pSSysViewPanelLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSVIEWPANELLOGICID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysViewPanelLogicName(boolean bl, PSSysViewPanelLogic pSSysViewPanelLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelLogic.isPSSysViewPanelLogicNameDirty() && !bl2 : !pSSysViewPanelLogic.isPSSysViewPanelLogicNameDirty()) {
            return null;
        }
        String string = pSSysViewPanelLogic.getPSSysViewPanelLogicName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSVIEWPANELLOGICNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysViewPanelLogicName_Default(pSSysViewPanelLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSVIEWPANELLOGICNAME");
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
                string3 = "PSSYSVIEWPANELID";
                String string4 = this.checkFieldDupRule(this.getPSSysViewPanelLogicDEModel(), "PSSYSVIEWPANELLOGICNAME", string3, pSSysViewPanelLogic, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSSYSVIEWPANELLOGICNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysViewPanelModelId(boolean bl, PSSysViewPanelLogic pSSysViewPanelLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelLogic.isPSSysViewPanelModelIdDirty() : !pSSysViewPanelLogic.isPSSysViewPanelModelIdDirty()) {
            return null;
        }
        String string = pSSysViewPanelLogic.getPSSysViewPanelModelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysViewPanelModelId_Default(pSSysViewPanelLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSVIEWPANELMODELID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Timer(boolean bl, PSSysViewPanelLogic pSSysViewPanelLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelLogic.isTimerDirty() : !pSSysViewPanelLogic.isTimerDirty()) {
            return null;
        }
        Integer n = pSSysViewPanelLogic.getTimer();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Timer_Default(pSSysViewPanelLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSSysViewPanelLogic pSSysViewPanelLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelLogic.isValidFlagDirty() : !pSSysViewPanelLogic.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSSysViewPanelLogic.getValidFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSSysViewPanelLogic, bl2, bl3);
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

    protected void onSyncEntity(PSSysViewPanelLogic pSSysViewPanelLogic, boolean bl) throws Exception {
        super.onSyncEntity(pSSysViewPanelLogic, bl);
    }

    protected void onSyncIndexEntities(PSSysViewPanelLogic pSSysViewPanelLogic, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSysViewPanelLogic, bl);
    }

    public Object getDataContextValue(PSSysViewPanelLogic pSSysViewPanelLogic, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSysViewPanelLogic, string, iDataContextParam)) != null) {
            return object;
        }
        PSSysViewPanel pSSysViewPanel = pSSysViewPanelLogic.getPSSysViewPanel();
        if (pSSysViewPanel != null && pSSysViewPanel.contains(string)) {
            return pSSysViewPanel.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSysViewPanelLogic pSSysViewPanelLogic, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSysViewPanelLogic, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ATTRNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AttrName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"CTRLEVENT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CtrlEvent_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CTRLEVENTARG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CtrlEventArg_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CTRLEVENTARG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CtrlEventArg2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CTRLEVENTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CtrlEventName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CUSTOMCODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CustomCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTLOGICTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstLogicType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LAYOUTPSSYSVIEWPANELID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LayoutPSSysViewPanelId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LAYOUTPSSYSVIEWPANELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LayoutPSSysViewPanelName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGICMODEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogicModel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGICPARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogicParam_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGICPARAM2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogicParam2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGICTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogicType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARAMPSPANELITEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ParamPSPanelItemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARAMPSPANELITEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ParamPSPanelItemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPFUNCID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppFuncId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPFUNCNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppFuncName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSSYSPFPLUGINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysPFPluginId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSPFPLUGINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysPFPluginName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSVIEWLOGICID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysViewLogicId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSVIEWLOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysViewLogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSVIEWPANELID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysViewPanelId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSVIEWPANELITEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysViewPanelItemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSVIEWPANELITEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysViewPanelItemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSVIEWPANELLOGICID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysViewPanelLogicId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSVIEWPANELLOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysViewPanelLogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSVIEWPANELMODELID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysViewPanelModelId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSVIEWPANELMODELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysViewPanelModelName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSVIEWPANELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysViewPanelName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TIMER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Timer_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_CodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODENAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
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

    protected String onTestValueRule_CtrlEvent_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CTRLEVENT", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CtrlEventArg_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CTRLEVENTARG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CtrlEventArg2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CTRLEVENTARG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CtrlEventName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CTRLEVENTNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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
            if (this.checkFieldStringLengthRule("DSTLOGICTYPE", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LayoutPSSysViewPanelId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LAYOUTPSSYSVIEWPANELID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LayoutPSSysViewPanelName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LAYOUTPSSYSVIEWPANELNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LogicModel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LOGICMODEL", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
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

    protected String onTestValueRule_LogicType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LOGICTYPE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
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

    protected String onTestValueRule_ParamPSPanelItemId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PARAMPSPANELITEMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ParamPSPanelItemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PARAMPSPANELITEMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSAppFuncId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPFUNCID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSAppFuncName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPFUNCNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSysViewPanelItemId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSVIEWPANELITEMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysViewPanelItemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSVIEWPANELITEMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysViewPanelLogicId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSVIEWPANELLOGICID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysViewPanelLogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSVIEWPANELLOGICNAME", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false) && this.checkFieldRegExRule("PSSYSVIEWPANELLOGICNAME", iEntity, bl2, "[A-Za-z]+[\\w.]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u53ca\u70b9\u53f7\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u53ca\u70b9\u53f7\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysViewPanelModelId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSVIEWPANELMODELID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysViewPanelModelName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSVIEWPANELMODELNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_Timer_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSysViewPanelLogic)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
        super.onUpdateParent(pSSysViewPanelLogic);
    }

    @Override
    protected void exportCurXmlModel(PSSysViewPanelLogic pSSysViewPanelLogic, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSVIEWPANELLOGIC");
        if (!bl) {
            pSSysViewPanelLogic.setCreateDate(null);
            pSSysViewPanelLogic.setCreateMan(null);
            pSSysViewPanelLogic.setParamPSPanelItemName(null);
            pSSysViewPanelLogic.setPSSysViewPanelLogicId(null);
            pSSysViewPanelLogic.setUpdateDate(null);
            pSSysViewPanelLogic.setUpdateMan(null);
            pSSysViewPanelLogic.setParamPSPanelItemId(null);
            pSSysViewPanelLogic.setPSSysViewPanelItemId(null);
            pSSysViewPanelLogic.setPSSysViewPanelModelId(null);
            pSSysViewPanelLogic.setPSSystemId(null);
            pSSysViewPanelLogic.setPSSysViewPanelId(null);
            pSSysViewPanelLogic.setPSSysViewPanelName(null);
            super.exportCurXmlModel(pSSysViewPanelLogic, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSSysViewPanelLogic pSSysViewPanelLogic, XmlNode xmlNode) throws Exception {
        this.exportRelatedXmlModel_PSPanelLogicParam(pSSysViewPanelLogic, xmlNode);
        this.exportRelatedXmlModel_PSPanelLogicNode(pSSysViewPanelLogic, xmlNode);
        this.exportRelatedXmlModel_PSPanelLogicLink(pSSysViewPanelLogic, xmlNode);
        super.onExportRelatedXmlModel(pSSysViewPanelLogic, xmlNode);
    }

    protected void exportRelatedXmlModel_PSPanelLogicParam(PSSysViewPanelLogic pSSysViewPanelLogic, XmlNode xmlNode) throws Exception {
        PSPanelLogicParamService pSPanelLogicParamService = (PSPanelLogicParamService)ServiceGlobal.getService(PSPanelLogicParamService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSPanelLogicParam> arrayList = null;
        String string = pSSysViewPanelLogic.getPSSysViewPanelLogicId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSPanelLogicParamService.selectByPSSysViewPanelLogic(pSSysViewPanelLogic) : pSPanelLogicParamService.selectTempByPSSysViewPanelLogic(pSSysViewPanelLogic);
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSPANELLOGICPARAMS");
            xmlNode.addNode(xmlNode2);
            for (PSPanelLogicParam pSPanelLogicParam : arrayList) {
                pSPanelLogicParamService.exportXmlModel(pSPanelLogicParam, xmlNode2);
            }
        }
    }

    protected void exportRelatedXmlModel_PSPanelLogicNode(PSSysViewPanelLogic pSSysViewPanelLogic, XmlNode xmlNode) throws Exception {
        PSPanelLogicNodeService pSPanelLogicNodeService = (PSPanelLogicNodeService)ServiceGlobal.getService(PSPanelLogicNodeService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSPanelLogicNode> arrayList = null;
        String string = pSSysViewPanelLogic.getPSSysViewPanelLogicId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSPanelLogicNodeService.selectByPSSysViewPanelLogic(pSSysViewPanelLogic) : pSPanelLogicNodeService.selectTempByPSSysViewPanelLogic(pSSysViewPanelLogic);
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSPANELLOGICNODES");
            xmlNode.addNode(xmlNode2);
            for (PSPanelLogicNode pSPanelLogicNode : arrayList) {
                pSPanelLogicNodeService.exportXmlModel(pSPanelLogicNode, xmlNode2);
            }
        }
    }

    protected void exportRelatedXmlModel_PSPanelLogicLink(PSSysViewPanelLogic pSSysViewPanelLogic, XmlNode xmlNode) throws Exception {
        PSPanelLogicLinkService pSPanelLogicLinkService = (PSPanelLogicLinkService)ServiceGlobal.getService(PSPanelLogicLinkService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSPanelLogicLink> arrayList = null;
        String string = pSSysViewPanelLogic.getPSSysViewPanelLogicId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSPanelLogicLinkService.selectByPSSysViewPanelLogic(pSSysViewPanelLogic, "ORDER BY ORDERVALUE ASC") : pSPanelLogicLinkService.selectTempByPSSysViewPanelLogic(pSSysViewPanelLogic, "ORDER BY ORDERVALUE ASC");
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSPANELLOGICLINKS");
            xmlNode.addNode(xmlNode2);
            for (PSPanelLogicLink pSPanelLogicLink : arrayList) {
                pSPanelLogicLink.set("ORDERVALUE", null);
                pSPanelLogicLinkService.exportXmlModel(pSPanelLogicLink, xmlNode2);
            }
        }
    }

    @Override
    protected void onImportRelatedXmlModel(PSSysViewPanelLogic pSSysViewPanelLogic, XmlNode xmlNode) throws Exception {
        XmlNode xmlNode2 = xmlNode.getChildNodeByNodeName("PSPANELLOGICPARAMS");
        this.importRelatedXmlModel_PSPanelLogicParam(pSSysViewPanelLogic, xmlNode2);
        XmlNode xmlNode3 = xmlNode.getChildNodeByNodeName("PSPANELLOGICNODES");
        this.importRelatedXmlModel_PSPanelLogicNode(pSSysViewPanelLogic, xmlNode3);
        XmlNode xmlNode4 = xmlNode.getChildNodeByNodeName("PSPANELLOGICLINKS");
        this.importRelatedXmlModel_PSPanelLogicLink(pSSysViewPanelLogic, xmlNode4);
        super.onImportRelatedXmlModel(pSSysViewPanelLogic, xmlNode);
    }

    protected void importRelatedXmlModel_PSPanelLogicParam(PSSysViewPanelLogic pSSysViewPanelLogic, XmlNode xmlNode) throws Exception {
        PSPanelLogicParamService pSPanelLogicParamService = (PSPanelLogicParamService)ServiceGlobal.getService(PSPanelLogicParamService.class, (SessionFactory)this.getSessionFactory());
        String string = pSSysViewPanelLogic.getPSSysViewPanelLogicId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSPanelLogicParamService.removeByPSSysViewPanelLogic(pSSysViewPanelLogic);
        } else {
            pSPanelLogicParamService.removeTempByPSSysViewPanelLogic(pSSysViewPanelLogic);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSPanelLogicParam pSPanelLogicParam = new PSPanelLogicParam();
                pSPanelLogicParamService.fillParentInfo(pSPanelLogicParam, "DER1N", "DER1N_PSPANELLOGICPARAM_PSSYSVIEWPANELLOGIC_PSSYSVIEWPANELLOGICID", pSSysViewPanelLogic.getPSSysViewPanelLogicId());
                pSPanelLogicParamService.importXmlModel(pSPanelLogicParam, xmlNode2);
            }
        }
    }

    protected void importRelatedXmlModel_PSPanelLogicNode(PSSysViewPanelLogic pSSysViewPanelLogic, XmlNode xmlNode) throws Exception {
        PSPanelLogicNodeService pSPanelLogicNodeService = (PSPanelLogicNodeService)ServiceGlobal.getService(PSPanelLogicNodeService.class, (SessionFactory)this.getSessionFactory());
        String string = pSSysViewPanelLogic.getPSSysViewPanelLogicId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSPanelLogicNodeService.removeByPSSysViewPanelLogic(pSSysViewPanelLogic);
        } else {
            pSPanelLogicNodeService.removeTempByPSSysViewPanelLogic(pSSysViewPanelLogic);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSPanelLogicNode pSPanelLogicNode = new PSPanelLogicNode();
                pSPanelLogicNodeService.fillParentInfo(pSPanelLogicNode, "DER1N", "DER1N_PSPANELLOGICNODE_PSSYSVIEWPANELLOGIC_PSSYSVIEWPANELLOGICID", pSSysViewPanelLogic.getPSSysViewPanelLogicId());
                pSPanelLogicNodeService.importXmlModel(pSPanelLogicNode, xmlNode2);
            }
        }
    }

    protected void importRelatedXmlModel_PSPanelLogicLink(PSSysViewPanelLogic pSSysViewPanelLogic, XmlNode xmlNode) throws Exception {
        int n = 100;
        PSPanelLogicLinkService pSPanelLogicLinkService = (PSPanelLogicLinkService)ServiceGlobal.getService(PSPanelLogicLinkService.class, (SessionFactory)this.getSessionFactory());
        String string = pSSysViewPanelLogic.getPSSysViewPanelLogicId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSPanelLogicLinkService.removeByPSSysViewPanelLogic(pSSysViewPanelLogic);
        } else {
            pSPanelLogicLinkService.removeTempByPSSysViewPanelLogic(pSSysViewPanelLogic);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSPanelLogicLink pSPanelLogicLink = new PSPanelLogicLink();
                pSPanelLogicLink.setOrderValue(n);
                n += 100;
                pSPanelLogicLinkService.fillParentInfo(pSPanelLogicLink, "DER1N", "DER1N_PSPANELLOGICLINK_PSSYSVIEWPANELLOGIC_PSSYSVIEWPANELLOGICID", pSSysViewPanelLogic.getPSSysViewPanelLogicId());
                pSPanelLogicLinkService.importXmlModel(pSPanelLogicLink, xmlNode2);
            }
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysViewPanelLogic pSSysViewPanelLogic, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysViewPanelLogic, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSVIEWPANELID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSVIEWPANEL#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSVIEWPANELID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSVIEWPANELLOGIC_PSSYSVIEWPANEL_PSSYSVIEWPANELID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSVIEWPANELID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSVIEWPANELNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSSYSVIEWPANEL", (boolean)true) == 0) {
            iEntity.set("PSSYSVIEWPANELID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSSYSVIEWPANELID"};
    }

    @Override
    public String getModelV2Tag(PSSysViewPanelLogic pSSysViewPanelLogic) {
        if (!StringHelper.isNullOrEmpty((String)pSSysViewPanelLogic.getPSSysViewPanelLogicName())) {
            return pSSysViewPanelLogic.getPSSysViewPanelLogicName();
        }
        return super.getModelV2Tag(pSSysViewPanelLogic);
    }

    @Override
    public boolean setModelV2Tag(PSSysViewPanelLogic pSSysViewPanelLogic, String string) {
        pSSysViewPanelLogic.setPSSysViewPanelLogicName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSSYSVIEWPANELLOGICNAME", "");
        map.put("PSSYSVIEWPANELID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysViewPanelLogic pSSysViewPanelLogic, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysViewPanelLogic.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysViewPanelLogic, true);
        pSSysViewPanelLogic.set("PSSYSVIEWPANELLOGICNAME", string);
        if (this.select(pSSysViewPanelLogic, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysViewPanelLogic, true);
        return super.getModelV2Entity(pSSysViewPanelLogic, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysViewPanelLogic pSSysViewPanelLogic, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSSysViewPanelLogic, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        if (StringHelper.compare((String)"DER1N_PSPANELLOGICPARAM_PSSYSVIEWPANELLOGIC_PSSYSVIEWPANELLOGICID", (String)string, (boolean)true) == 0) {
            return false;
        }
        if (StringHelper.compare((String)"DER1N_PSPANELLOGICNODE_PSSYSVIEWPANELLOGIC_PSSYSVIEWPANELLOGICID", (String)string, (boolean)true) == 0) {
            return false;
        }
        return StringHelper.compare((String)"DER1N_PSPANELLOGICLINK_PSSYSVIEWPANELLOGIC_PSSYSVIEWPANELLOGICID", (String)string, (boolean)true) != 0;
    }

    @Override
    protected void onExportRelatedModelV2(PSSysViewPanelLogic pSSysViewPanelLogic, String string, String string2) throws Exception {
        Object var4_4 = null;
        super.onExportRelatedModelV2(pSSysViewPanelLogic, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSSysViewPanelLogic pSSysViewPanelLogic, ObjectNode objectNode, String string, boolean bl) throws Exception {
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSPANELLOGICPARAM_PSSYSVIEWPANELLOGIC_PSSYSVIEWPANELLOGICID")) {
            PSPanelLogicParamService panelLogicParamService = (PSPanelLogicParamService)ServiceGlobal.getService(PSPanelLogicParamService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<ObjectNode> panelLogicParams = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSVIEWPANELLOGIC#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSPANELLOGICPARAM", (Object)pSSysViewPanelLogic.getPSSysViewPanelLogicId()));
                if (file.exists()) {
                    panelLogicParams = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty(line)) continue;
                        panelLogicParams.add((ObjectNode)JsonNodeHelper.fromString(line));
                    }
                }
            } else {
                panelLogicParams = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSSYSVIEWPANELLOGIC#%1$s", (Object)pSSysViewPanelLogic.getPSSysViewPanelLogicId());
                for (PSPanelLogicParam panelLogicParam : panelLogicParamService.selectByPSSysViewPanelLogic(pSSysViewPanelLogic)) {
                    if (StringHelper.compare(scope, panelLogicParamService.getModelV2ResScope(panelLogicParam), (boolean)false) != 0) continue;
                    panelLogicParams.add(PSModelV2Helper.toJSONObject(panelLogicParam, false));
                }
            }
            if (panelLogicParams != null && panelLogicParams.size() > 0) {
                ArrayNode panelLogicParamNodes = objectNode.putArray(panelLogicParamService.getModelV2Name(false).toLowerCase());
                Collections.sort(panelLogicParams, new Comparator<ObjectNode>(){

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
                        if (objectNode.has("pspanellogicparamname")) {
                            string = objectNode.get("pspanellogicparamname").asText();
                        }
                        if (objectNode2.has("pspanellogicparamname")) {
                            string2 = objectNode2.get("pspanellogicparamname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode panelLogicParamNode : panelLogicParams) {
                    PSPanelLogicParam panelLogicParam = new PSPanelLogicParam();
                    PSModelV2Helper.fromJSONObject((IDataObject)panelLogicParam, panelLogicParamNode, false);
                    panelLogicParamNodes.add((JsonNode)panelLogicParamService.exportModelV2(panelLogicParam, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSPANELLOGICNODE_PSSYSVIEWPANELLOGIC_PSSYSVIEWPANELLOGICID")) {
            PSPanelLogicNodeService panelLogicNodeService = (PSPanelLogicNodeService)ServiceGlobal.getService(PSPanelLogicNodeService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<ObjectNode> panelLogicNodes = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSVIEWPANELLOGIC#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSPANELLOGICNODE", (Object)pSSysViewPanelLogic.getPSSysViewPanelLogicId()));
                if (file.exists()) {
                    panelLogicNodes = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty(line)) continue;
                        panelLogicNodes.add((ObjectNode)JsonNodeHelper.fromString(line));
                    }
                }
            } else {
                panelLogicNodes = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSSYSVIEWPANELLOGIC#%1$s", (Object)pSSysViewPanelLogic.getPSSysViewPanelLogicId());
                for (PSPanelLogicNode panelLogicNode : panelLogicNodeService.selectByPSSysViewPanelLogic(pSSysViewPanelLogic)) {
                    if (StringHelper.compare(scope, panelLogicNodeService.getModelV2ResScope(panelLogicNode), (boolean)false) != 0) continue;
                    panelLogicNodes.add(PSModelV2Helper.toJSONObject(panelLogicNode, false));
                }
            }
            if (panelLogicNodes != null && panelLogicNodes.size() > 0) {
                ArrayNode panelLogicNodeNodes = objectNode.putArray(panelLogicNodeService.getModelV2Name(false).toLowerCase());
                Collections.sort(panelLogicNodes, new Comparator<ObjectNode>(){

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
                        if (objectNode.has("pspanellogicnodename")) {
                            string = objectNode.get("pspanellogicnodename").asText();
                        }
                        if (objectNode2.has("pspanellogicnodename")) {
                            string2 = objectNode2.get("pspanellogicnodename").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode panelLogicNodeNode : panelLogicNodes) {
                    PSPanelLogicNode panelLogicNode = new PSPanelLogicNode();
                    PSModelV2Helper.fromJSONObject((IDataObject)panelLogicNode, panelLogicNodeNode, false);
                    panelLogicNodeNodes.add((JsonNode)panelLogicNodeService.exportModelV2(panelLogicNode, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSPANELLOGICLINK_PSSYSVIEWPANELLOGIC_PSSYSVIEWPANELLOGICID")) {
            PSPanelLogicLinkService panelLogicLinkService = (PSPanelLogicLinkService)ServiceGlobal.getService(PSPanelLogicLinkService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<ObjectNode> panelLogicLinks = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSVIEWPANELLOGIC#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSPANELLOGICLINK", (Object)pSSysViewPanelLogic.getPSSysViewPanelLogicId()));
                if (file.exists()) {
                    panelLogicLinks = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty(line)) continue;
                        panelLogicLinks.add((ObjectNode)JsonNodeHelper.fromString(line));
                    }
                }
            } else {
                panelLogicLinks = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSSYSVIEWPANELLOGIC#%1$s", (Object)pSSysViewPanelLogic.getPSSysViewPanelLogicId());
                for (PSPanelLogicLink panelLogicLink : panelLogicLinkService.selectByPSSysViewPanelLogic(pSSysViewPanelLogic)) {
                    if (StringHelper.compare(scope, panelLogicLinkService.getModelV2ResScope(panelLogicLink), (boolean)false) != 0) continue;
                    panelLogicLinks.add(PSModelV2Helper.toJSONObject(panelLogicLink, false));
                }
            }
            if (panelLogicLinks != null && panelLogicLinks.size() > 0) {
                ArrayNode panelLogicLinkNodes = objectNode.putArray(panelLogicLinkService.getModelV2Name(false).toLowerCase());
                Collections.sort(panelLogicLinks, new Comparator<ObjectNode>(){

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
                        if (objectNode.has("pspanellogiclinkname")) {
                            string = objectNode.get("pspanellogiclinkname").asText();
                        }
                        if (objectNode2.has("pspanellogiclinkname")) {
                            string2 = objectNode2.get("pspanellogiclinkname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode panelLogicLinkNode : panelLogicLinks) {
                    PSPanelLogicLink panelLogicLink = new PSPanelLogicLink();
                    PSModelV2Helper.fromJSONObject((IDataObject)panelLogicLink, panelLogicLinkNode, false);
                    panelLogicLinkNodes.add((JsonNode)panelLogicLinkService.exportModelV2(panelLogicLink, string));
                }
            }
        }
        super.onExportCurModelV2(pSSysViewPanelLogic, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
        String string;
        PSPanelLogicParamService panelLogicParamService = (PSPanelLogicParamService)ServiceGlobal.getService(PSPanelLogicParamService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSPanelLogicParam> panelLogicParams = panelLogicParamService.selectByPSSysViewPanelLogic(pSSysViewPanelLogic);
        String string2 = StringHelper.format((String)"PSSYSVIEWPANELLOGIC#%1$s", (Object)pSSysViewPanelLogic.getPSSysViewPanelLogicId());
        for (PSPanelLogicParam panelLogicParam : panelLogicParams) {
            string = panelLogicParamService.getModelV2ResScope(panelLogicParam);
            if (StringHelper.compare((String)string2, (String)string, (boolean)false) != 0) continue;
            panelLogicParamService.emptyModelV2(panelLogicParam);
        }
        SqlParamList sqlParamList = new SqlParamList();
        sqlParamList.addString(pSSysViewPanelLogic.getPSSysViewPanelLogicId());
        panelLogicParamService.getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        panelLogicParamService.getDAO().executeRawSql(null, "DELETE FROM T_SRFPSPANELLOGICPARAM WHERE PSSYSVIEWPANELLOGICID = ?", sqlParamList);
        PSPanelLogicNodeService panelLogicNodeService = (PSPanelLogicNodeService)ServiceGlobal.getService(PSPanelLogicNodeService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSPanelLogicNode> panelLogicNodes = panelLogicNodeService.selectByPSSysViewPanelLogic(pSSysViewPanelLogic);
        string2 = StringHelper.format((String)"PSSYSVIEWPANELLOGIC#%1$s", (Object)pSSysViewPanelLogic.getPSSysViewPanelLogicId());
        for (PSPanelLogicNode panelLogicNode : panelLogicNodes) {
            string = panelLogicNodeService.getModelV2ResScope(panelLogicNode);
            if (StringHelper.compare((String)string2, (String)string, (boolean)false) != 0) continue;
            panelLogicNodeService.emptyModelV2(panelLogicNode);
        }
        sqlParamList = new SqlParamList();
        sqlParamList.addString(pSSysViewPanelLogic.getPSSysViewPanelLogicId());
        panelLogicNodeService.getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        panelLogicNodeService.getDAO().executeRawSql(null, "DELETE FROM T_SRFPSPANELLOGICNODE WHERE PSSYSVIEWPANELLOGICID = ?", sqlParamList);
        PSPanelLogicLinkService panelLogicLinkService = (PSPanelLogicLinkService)ServiceGlobal.getService(PSPanelLogicLinkService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSPanelLogicLink> panelLogicLinks = panelLogicLinkService.selectByPSSysViewPanelLogic(pSSysViewPanelLogic);
        string2 = StringHelper.format((String)"PSSYSVIEWPANELLOGIC#%1$s", (Object)pSSysViewPanelLogic.getPSSysViewPanelLogicId());
        for (PSPanelLogicLink panelLogicLink : panelLogicLinks) {
            string = panelLogicLinkService.getModelV2ResScope(panelLogicLink);
            if (StringHelper.compare((String)string2, (String)string, (boolean)false) != 0) continue;
            panelLogicLinkService.emptyModelV2(panelLogicLink);
        }
        sqlParamList = new SqlParamList();
        sqlParamList.addString(pSSysViewPanelLogic.getPSSysViewPanelLogicId());
        panelLogicLinkService.getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        panelLogicLinkService.getDAO().executeRawSql(null, "DELETE FROM T_SRFPSPANELLOGICLINK WHERE PSSYSVIEWPANELLOGICID = ?", sqlParamList);
        super.onEmptyModelV2(pSSysViewPanelLogic);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSPanelLogicParamService)ServiceGlobal.getService(PSPanelLogicParamService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSPanelLogicNodeService)ServiceGlobal.getService(PSPanelLogicNodeService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSPanelLogicLinkService)ServiceGlobal.getService(PSPanelLogicLinkService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSSysViewPanelLogic pSSysViewPanelLogic, String string, String string2) throws Exception {
        IEntity iEntity = null;
        EntityBase entityBase = new PSPanelLogicParam();
        entityBase.set("PSSYSVIEWPANELLOGICID", pSSysViewPanelLogic.getPSSysViewPanelLogicId());
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSPanelLogicParamService)ServiceGlobal.getService(PSPanelLogicParamService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSPanelLogicNode();
        entityBase.set("PSSYSVIEWPANELLOGICID", pSSysViewPanelLogic.getPSSysViewPanelLogicId());
        pSCoreSysServiceBase = (PSPanelLogicNodeService)ServiceGlobal.getService(PSPanelLogicNodeService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSPanelLogicLink();
        entityBase.set("PSSYSVIEWPANELLOGICID", pSSysViewPanelLogic.getPSSysViewPanelLogicId());
        pSCoreSysServiceBase = (PSPanelLogicLinkService)ServiceGlobal.getService(PSPanelLogicLinkService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSSysViewPanelLogic, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSSysViewPanelLogic pSSysViewPanelLogic, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        PSPanelLogicParamService panelLogicParamService = (PSPanelLogicParamService)ServiceGlobal.getService(PSPanelLogicParamService.class, (SessionFactory)this.getSessionFactory());
        ArrayNode arrayNode = null;
        String string3 = panelLogicParamService.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                ObjectNode itemNode = (ObjectNode)arrayNode.get(i);
                PSPanelLogicParam panelLogicParam = new PSPanelLogicParam();
                panelLogicParam.setPSSysViewPanelLogicId(pSSysViewPanelLogic.getPSSysViewPanelLogicId());
                panelLogicParam.setPSSysViewPanelLogicName(pSSysViewPanelLogic.getPSSysViewPanelLogicName());
                panelLogicParamService.compileModelV2(panelLogicParam, itemNode, string, null, n);
            }
        } else {
            String path = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            File modelFolder = new File(path);
            if (modelFolder.exists()) {
                File[] files = modelFolder.listFiles();
                if (files != null) {
                    for (File file2 : files) {
                        if (!file2.isDirectory()) continue;
                        PSPanelLogicParam panelLogicParam = new PSPanelLogicParam();
                        panelLogicParam.setPSSysViewPanelLogicId(pSSysViewPanelLogic.getPSSysViewPanelLogicId());
                        panelLogicParam.setPSSysViewPanelLogicName(pSSysViewPanelLogic.getPSSysViewPanelLogicName());
                        panelLogicParamService.compileModelV2(panelLogicParam, null, string, file2.getCanonicalPath(), n);
                    }
                }
            }
        }
        PSPanelLogicNodeService panelLogicNodeService = (PSPanelLogicNodeService)ServiceGlobal.getService(PSPanelLogicNodeService.class, (SessionFactory)this.getSessionFactory());
        arrayNode = null;
        string3 = panelLogicNodeService.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                ObjectNode itemNode = (ObjectNode)arrayNode.get(i);
                PSPanelLogicNode panelLogicNode = new PSPanelLogicNode();
                panelLogicNode.setPSSysViewPanelLogicId(pSSysViewPanelLogic.getPSSysViewPanelLogicId());
                panelLogicNode.setPSSysViewPanelLogicName(pSSysViewPanelLogic.getPSSysViewPanelLogicName());
                panelLogicNodeService.compileModelV2(panelLogicNode, itemNode, string, null, n);
            }
        } else {
            String path = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            File modelFolder = new File(path);
            if (modelFolder.exists()) {
                File[] files = modelFolder.listFiles();
                if (files != null) {
                    for (File file2 : files) {
                        if (!file2.isDirectory()) continue;
                        PSPanelLogicNode panelLogicNode = new PSPanelLogicNode();
                        panelLogicNode.setPSSysViewPanelLogicId(pSSysViewPanelLogic.getPSSysViewPanelLogicId());
                        panelLogicNode.setPSSysViewPanelLogicName(pSSysViewPanelLogic.getPSSysViewPanelLogicName());
                        panelLogicNodeService.compileModelV2(panelLogicNode, null, string, file2.getCanonicalPath(), n);
                    }
                }
            }
        }
        PSPanelLogicLinkService panelLogicLinkService = (PSPanelLogicLinkService)ServiceGlobal.getService(PSPanelLogicLinkService.class, (SessionFactory)this.getSessionFactory());
        arrayNode = null;
        string3 = panelLogicLinkService.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                ObjectNode itemNode = (ObjectNode)arrayNode.get(i);
                PSPanelLogicLink panelLogicLink = new PSPanelLogicLink();
                panelLogicLink.setPSSysViewPanelLogicId(pSSysViewPanelLogic.getPSSysViewPanelLogicId());
                panelLogicLink.setPSSysViewPanelLogicName(pSSysViewPanelLogic.getPSSysViewPanelLogicName());
                panelLogicLinkService.compileModelV2(panelLogicLink, itemNode, string, null, n);
            }
        } else {
            String path = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            File modelFolder = new File(path);
            if (modelFolder.exists()) {
                File[] files = modelFolder.listFiles();
                if (files != null) {
                    for (File file2 : files) {
                        if (!file2.isDirectory()) continue;
                        PSPanelLogicLink panelLogicLink = new PSPanelLogicLink();
                        panelLogicLink.setPSSysViewPanelLogicId(pSSysViewPanelLogic.getPSSysViewPanelLogicId());
                        panelLogicLink.setPSSysViewPanelLogicName(pSSysViewPanelLogic.getPSSysViewPanelLogicName());
                        panelLogicLinkService.compileModelV2(panelLogicLink, null, string, file2.getCanonicalPath(), n);
                    }
                }
            }
        }
        super.onCompileRelatedModelV2(pSSysViewPanelLogic, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSSysViewPanelLogic pSSysViewPanelLogic, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSPANELLOGICPARAM_PSSYSVIEWPANELLOGIC_PSSYSVIEWPANELLOGICID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSPanelLogicParams(pSSysViewPanelLogic, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSPANELLOGICNODE_PSSYSVIEWPANELLOGIC_PSSYSVIEWPANELLOGICID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSPanelLogicNodes(pSSysViewPanelLogic, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSPANELLOGICLINK_PSSYSVIEWPANELLOGIC_PSSYSVIEWPANELLOGICID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSPanelLogicLinks(pSSysViewPanelLogic, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSSysViewPanelLogic, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSPanelLogicParams(PSSysViewPanelLogic pSSysViewPanelLogic, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSPANELLOGICPARAM", true), (boolean)false) == 0) {
            PSPanelLogicParamService pSPanelLogicParamService = (PSPanelLogicParamService)ServiceGlobal.getService(PSPanelLogicParamService.class, (SessionFactory)this.getSessionFactory());
            PSPanelLogicParam pSPanelLogicParam = new PSPanelLogicParam();
            pSPanelLogicParam.setPSPanelLogicParamId(pSMOSFile.getPSModelId());
            if (!pSPanelLogicParamService.get(pSPanelLogicParam, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSPanelLogicParam.getPSSysViewPanelLogicId(), (String)pSSysViewPanelLogic.getPSSysViewPanelLogicId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSPanelLogicParamService.exportModelV2(pSPanelLogicParam);
            pSPanelLogicParam.reset();
            if (!pSPanelLogicParamService.setModelV2ResScope(pSPanelLogicParam, "PSSYSVIEWPANELLOGIC", pSSysViewPanelLogic.getPSSysViewPanelLogicId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSPanelLogicParamService.importModelV2(pSPanelLogicParam, objectNode);
            SessionFactoryManager.commit();
            return pSPanelLogicParamService.getFile(pSPanelLogicParam);
        }
        return null;
    }

    protected PSMOSFile onPasteFile_PSPanelLogicNodes(PSSysViewPanelLogic pSSysViewPanelLogic, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSPANELLOGICNODE", true), (boolean)false) == 0) {
            PSPanelLogicNodeService pSPanelLogicNodeService = (PSPanelLogicNodeService)ServiceGlobal.getService(PSPanelLogicNodeService.class, (SessionFactory)this.getSessionFactory());
            PSPanelLogicNode pSPanelLogicNode = new PSPanelLogicNode();
            pSPanelLogicNode.setPSPanelLogicNodeId(pSMOSFile.getPSModelId());
            if (!pSPanelLogicNodeService.get(pSPanelLogicNode, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSPanelLogicNode.getPSSysViewPanelLogicId(), (String)pSSysViewPanelLogic.getPSSysViewPanelLogicId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSPanelLogicNodeService.exportModelV2(pSPanelLogicNode);
            pSPanelLogicNode.reset();
            if (!pSPanelLogicNodeService.setModelV2ResScope(pSPanelLogicNode, "PSSYSVIEWPANELLOGIC", pSSysViewPanelLogic.getPSSysViewPanelLogicId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSPanelLogicNodeService.importModelV2(pSPanelLogicNode, objectNode);
            SessionFactoryManager.commit();
            return pSPanelLogicNodeService.getFile(pSPanelLogicNode);
        }
        return null;
    }

    protected PSMOSFile onPasteFile_PSPanelLogicLinks(PSSysViewPanelLogic pSSysViewPanelLogic, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSPANELLOGICLINK", true), (boolean)false) == 0) {
            PSPanelLogicLinkService pSPanelLogicLinkService = (PSPanelLogicLinkService)ServiceGlobal.getService(PSPanelLogicLinkService.class, (SessionFactory)this.getSessionFactory());
            PSPanelLogicLink pSPanelLogicLink = new PSPanelLogicLink();
            pSPanelLogicLink.setPSPanelLogicLinkId(pSMOSFile.getPSModelId());
            if (!pSPanelLogicLinkService.get(pSPanelLogicLink, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSPanelLogicLink.getPSSysViewPanelLogicId(), (String)pSSysViewPanelLogic.getPSSysViewPanelLogicId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSPanelLogicLinkService.exportModelV2(pSPanelLogicLink);
            pSPanelLogicLink.reset();
            if (!pSPanelLogicLinkService.setModelV2ResScope(pSPanelLogicLink, "PSSYSVIEWPANELLOGIC", pSSysViewPanelLogic.getPSSysViewPanelLogicId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSPanelLogicLinkService.importModelV2(pSPanelLogicLink, objectNode);
            SessionFactoryManager.commit();
            return pSPanelLogicLinkService.getFile(pSPanelLogicLink);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSSysViewPanelLogic pSSysViewPanelLogic, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSPanelLogicParams(pSSysViewPanelLogic, list);
        this.onFillPasteHelps_PSPanelLogicNodes(pSSysViewPanelLogic, list);
        this.onFillPasteHelps_PSPanelLogicLinks(pSSysViewPanelLogic, list);
        super.onFillPasteHelps(pSSysViewPanelLogic, list);
    }

    protected void onFillPasteHelps_PSPanelLogicParams(PSSysViewPanelLogic pSSysViewPanelLogic, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSPANELLOGICPARAM");
        pSHelpSection.setSectionParam2("DER1N_PSPANELLOGICPARAM_PSSYSVIEWPANELLOGIC_PSSYSVIEWPANELLOGICID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u9762\u677f\u903b\u8f91]\u7684[\u9762\u677f\u903b\u8f91\u53c2\u6570]");
        list.add(pSHelpSection);
    }

    protected void onFillPasteHelps_PSPanelLogicNodes(PSSysViewPanelLogic pSSysViewPanelLogic, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSPANELLOGICNODE");
        pSHelpSection.setSectionParam2("DER1N_PSPANELLOGICNODE_PSSYSVIEWPANELLOGIC_PSSYSVIEWPANELLOGICID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u9762\u677f\u903b\u8f91]\u7684[\u9762\u677f\u903b\u8f91\u8282\u70b9]");
        list.add(pSHelpSection);
    }

    protected void onFillPasteHelps_PSPanelLogicLinks(PSSysViewPanelLogic pSSysViewPanelLogic, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSPANELLOGICLINK");
        pSHelpSection.setSectionParam2("DER1N_PSPANELLOGICLINK_PSSYSVIEWPANELLOGIC_PSSYSVIEWPANELLOGICID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u9762\u677f\u903b\u8f91]\u7684[\u9762\u677f\u903b\u8f91\u8fde\u63a5]");
        list.add(pSHelpSection);
    }
}
