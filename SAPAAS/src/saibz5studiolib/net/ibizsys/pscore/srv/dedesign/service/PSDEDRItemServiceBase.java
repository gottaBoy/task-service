/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
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
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.demodel.IDELogicModel
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
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDELogicModel;
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
import net.ibizsys.pscore.srv.dedesign.dao.PSDEDRItemDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEDRItemDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEActionBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDRGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDRGroupBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDRItem;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogicBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEOPPriv;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEOPPrivBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDER;
import net.ibizsys.pscore.srv.dedesign.entity.PSDERBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBaseBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDRDetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDRDetailServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormDetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormDetailServiceBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageResBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCss;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCssBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImage;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImageBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysPDTView;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysPDTViewBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUniRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUniResBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelItemServiceBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEDRItemServiceBase
extends PSCoreSysServiceBase<PSDEDRItem> {
    private static final Log log = LogFactory.getLog(PSDEDRItemServiceBase.class);
    public static final String DATASET_CURAPP = "CurApp";
    public static final String DATASET_CURDE = "CurDE";
    public static final String DATASET_CURDEREF = "CurDERef";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String DATASET_FORMTYPE = "FormType";
    public static final String ACTION_CALCREFDEID = "CalcRefDEId";
    private static Map<String, String> defaultValueMap = new HashMap<String, String>();
    private PSDEDRItemDEModel pSDEDRItemDEModel;
    private PSDEDRItemDAO pSDEDRItemDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEDRItemService";
    }

    public PSDEDRItemDEModel getPSDEDRItemDEModel() {
        if (this.pSDEDRItemDEModel == null) {
            try {
                this.pSDEDRItemDEModel = (PSDEDRItemDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEDRItemDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEDRItemDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEDRItemDEModel();
    }

    public PSDEDRItemDAO getPSDEDRItemDAO() {
        if (this.pSDEDRItemDAO == null) {
            try {
                this.pSDEDRItemDAO = (PSDEDRItemDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDEDRItemDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEDRItemDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEDRItemDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURAPP, (boolean)true) == 0) {
            return this.fetchCurApp(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDE, (boolean)true) == 0) {
            return this.fetchCurDE(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDEREF, (boolean)true) == 0) {
            return this.fetchCurDERef(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_FORMTYPE, (boolean)true) == 0) {
            return this.fetchFormType(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_CALCREFDEID, (boolean)true) == 0) {
            this.calcRefDEId((PSDEDRItem)iEntity);
            return;
        }
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurApp(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURAPP, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurDE(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDE, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurDERef(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDEREF, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchFormType(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_FORMTYPE, false);
        return dBFetchResult;
    }

    public void calcRefDEId(PSDEDRItem pSDEDRItem) throws Exception {
        final PSDEDRItem pSDEDRItem2 = pSDEDRItem;
        pSDEDRItem2.setSessionFactory(this.getSessionFactory());
        this.testDEMainStateAction(pSDEDRItem, ACTION_CALCREFDEID);
        final IDELogicModel iDELogicModel = (IDELogicModel)this.getPSDEDRItemDEModel().getDELogic(ACTION_CALCREFDEID);
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                ActionContext actionContext = new ActionContext(null);
                actionContext.setParam(iDELogicModel.getDefaultParamName(), (Object)pSDEDRItem2);
                actionContext.setSessionFactory(PSDEDRItemServiceBase.this.getSessionFactory());
                iDELogicModel.execute((IActionContext)actionContext);
            }
        });
    }

    protected void onFillParentInfo(PSDEDRItem pSDEDRItem, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDRITEM_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDataEntity);
            } else {
                iService.get(pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSDEDRItem, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDRITEM_PSDEACTION_TESTPSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEAction);
            } else {
                iService.get(pSDEAction);
            }
            this.onFillParentInfo_TestPSDEAction(pSDEDRItem, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDRITEM_PSDEDRGROUP_PSDEDRGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDRGroupService", (SessionFactory)this.getSessionFactory());
            PSDEDRGroup pSDEDRGroup = (PSDEDRGroup)iService.getDEModel().createEntity();
            pSDEDRGroup.set("PSDEDRGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEDRGroup);
            } else {
                iService.get(pSDEDRGroup);
            }
            this.onFillParentInfo_PSDEDRGroup(pSDEDRItem, pSDEDRGroup);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDRITEM_PSDELOGIC_TESTPSDELOGICID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDELogicService", (SessionFactory)this.getSessionFactory());
            PSDELogic pSDELogic = (PSDELogic)iService.getDEModel().createEntity();
            pSDELogic.set("PSDELOGICID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDELogic);
            } else {
                iService.get(pSDELogic);
            }
            this.onFillParentInfo_TestPSDELogic(pSDEDRItem, pSDELogic);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDRITEM_PSDEOPPRIV_PSDEOPPRIVID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEOPPrivService", (SessionFactory)this.getSessionFactory());
            PSDEOPPriv pSDEOPPriv = (PSDEOPPriv)iService.getDEModel().createEntity();
            pSDEOPPriv.set("PSDEOPPRIVID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEOPPriv);
            } else {
                iService.get(pSDEOPPriv);
            }
            this.onFillParentInfo_PSDEOPPriv(pSDEDRItem, pSDEOPPriv);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDRITEM_PSDER_PSDERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDERService", (SessionFactory)this.getSessionFactory());
            PSDER pSDER = (PSDER)iService.getDEModel().createEntity();
            pSDER.set("PSDERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDER);
            } else {
                iService.get(pSDER);
            }
            this.onFillParentInfo_PSDER(pSDEDRItem, pSDER);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDRITEM_PSDEVIEWBASE_PSDEVIEWBASEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService", (SessionFactory)this.getSessionFactory());
            PSDEViewBase pSDEViewBase = (PSDEViewBase)iService.getDEModel().createEntity();
            pSDEViewBase.set("PSDEVIEWBASEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEViewBase);
            } else {
                iService.get(pSDEViewBase);
            }
            this.onFillParentInfo_PSDEViewBase(pSDEDRItem, pSDEViewBase);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDRITEM_PSLANGUAGERES_CAPPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSLanguageRes);
            } else {
                iService.get(pSLanguageRes);
            }
            this.onFillParentInfo_CapPSLanRes(pSDEDRItem, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDRITEM_PSLANGUAGERES_TIPPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSLanguageRes);
            } else {
                iService.get(pSLanguageRes);
            }
            this.onFillParentInfo_TipPSLanRes(pSDEDRItem, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDRITEM_PSSYSCSS_PSSYSCSSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService", (SessionFactory)this.getSessionFactory());
            PSSysCss pSSysCss = (PSSysCss)iService.getDEModel().createEntity();
            pSSysCss.set("PSSYSCSSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysCss);
            } else {
                iService.get(pSSysCss);
            }
            this.onFillParentInfo_PSSysCss(pSDEDRItem, pSSysCss);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDRITEM_PSSYSIMAGE_PSSYSIMAGEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysImageService", (SessionFactory)this.getSessionFactory());
            PSSysImage pSSysImage = (PSSysImage)iService.getDEModel().createEntity();
            pSSysImage.set("PSSYSIMAGEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysImage);
            } else {
                iService.get(pSSysImage);
            }
            this.onFillParentInfo_PSSysImage(pSDEDRItem, pSSysImage);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDRITEM_PSSYSPDTVIEW_PSSYSPDTVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysPDTViewService", (SessionFactory)this.getSessionFactory());
            PSSysPDTView pSSysPDTView = (PSSysPDTView)iService.getDEModel().createEntity();
            pSSysPDTView.set("PSSYSPDTVIEWID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysPDTView);
            } else {
                iService.get(pSSysPDTView);
            }
            this.onFillParentInfo_PSSysPTDView(pSDEDRItem, pSSysPDTView);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDRITEM_PSSYSPFPLUGIN_HEADERPSSYSPFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysPFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysPFPlugin pSSysPFPlugin = (PSSysPFPlugin)iService.getDEModel().createEntity();
            pSSysPFPlugin.set("PSSYSPFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysPFPlugin);
            } else {
                iService.get(pSSysPFPlugin);
            }
            this.onFillParentInfo_HeaderPSSysPFPlugin(pSDEDRItem, pSSysPFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDRITEM_PSSYSUNIRES_PSSYSUNIRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysUniResService", (SessionFactory)this.getSessionFactory());
            PSSysUniRes pSSysUniRes = (PSSysUniRes)iService.getDEModel().createEntity();
            pSSysUniRes.set("PSSYSUNIRESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysUniRes);
            } else {
                iService.get(pSSysUniRes);
            }
            this.onFillParentInfo_PSSysUniRes(pSDEDRItem, pSSysUniRes);
            return;
        }
        super.onFillParentInfo(pSDEDRItem, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDE(PSDEDRItem pSDEDRItem, PSDataEntity pSDataEntity) throws Exception {
        pSDEDRItem.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSDEDRItem.setPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_TestPSDEAction(PSDEDRItem pSDEDRItem, PSDEAction pSDEAction) throws Exception {
        pSDEDRItem.setTestPSDEActionId(pSDEAction.getPSDEActionId());
        pSDEDRItem.setTestPSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_PSDEDRGroup(PSDEDRItem pSDEDRItem, PSDEDRGroup pSDEDRGroup) throws Exception {
        pSDEDRItem.setPSDEDRGroupId(pSDEDRGroup.getPSDEDRGroupId());
        pSDEDRItem.setPSDEDRGroupName(pSDEDRGroup.getPSDEDRGroupName());
    }

    protected void onFillParentInfo_TestPSDELogic(PSDEDRItem pSDEDRItem, PSDELogic pSDELogic) throws Exception {
        pSDEDRItem.setTestPSDELogicId(pSDELogic.getPSDELogicId());
        pSDEDRItem.setTestPSDELogicName(pSDELogic.getPSDELogicName());
    }

    protected void onFillParentInfo_PSDEOPPriv(PSDEDRItem pSDEDRItem, PSDEOPPriv pSDEOPPriv) throws Exception {
        pSDEDRItem.setPSDEOPPrivId(pSDEOPPriv.getPSDEOPPrivId());
        pSDEDRItem.setPSDEOPPrivName(pSDEOPPriv.getPSDEOPPrivName());
    }

    protected void onFillParentInfo_PSDER(PSDEDRItem pSDEDRItem, PSDER pSDER) throws Exception {
        pSDEDRItem.setPSDERId(pSDER.getPSDERId());
        pSDEDRItem.setPSDERName(pSDER.getPSDERName());
        if (pSDER.getMajorPSDE() != null) {
            this.onFillParentInfo_PSDE(pSDEDRItem, pSDER.getMajorPSDE());
        }
    }

    protected void onFillParentInfo_PSDEViewBase(PSDEDRItem pSDEDRItem, PSDEViewBase pSDEViewBase) throws Exception {
        pSDEDRItem.setPSDEViewBaseId(pSDEViewBase.getPSDEViewBaseId());
        pSDEDRItem.setPSDEViewBaseName(pSDEViewBase.getPSDEViewBaseName());
        pSDEDRItem.setViewCodeName(pSDEViewBase.getCodeName());
    }

    protected void onFillParentInfo_CapPSLanRes(PSDEDRItem pSDEDRItem, PSLanguageRes pSLanguageRes) throws Exception {
        pSDEDRItem.setCapPSLanResId(pSLanguageRes.getPSLanguageResId());
        pSDEDRItem.setCapPSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_TipPSLanRes(PSDEDRItem pSDEDRItem, PSLanguageRes pSLanguageRes) throws Exception {
        pSDEDRItem.setTipPSLanResId(pSLanguageRes.getPSLanguageResId());
        pSDEDRItem.setTipPSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_PSSysCss(PSDEDRItem pSDEDRItem, PSSysCss pSSysCss) throws Exception {
        pSDEDRItem.setPSSysCssId(pSSysCss.getPSSysCssId());
        pSDEDRItem.setPSSysCssName(pSSysCss.getPSSysCssName());
    }

    protected void onFillParentInfo_PSSysImage(PSDEDRItem pSDEDRItem, PSSysImage pSSysImage) throws Exception {
        pSDEDRItem.setPSSysImageId(pSSysImage.getPSSysImageId());
        pSDEDRItem.setPSSysImageName(pSSysImage.getPSSysImageName());
    }

    protected void onFillParentInfo_PSSysPTDView(PSDEDRItem pSDEDRItem, PSSysPDTView pSSysPDTView) throws Exception {
        pSDEDRItem.setPSSysPDTViewId(pSSysPDTView.getPSSysPDTViewId());
        pSDEDRItem.setPSSysPDTViewName(pSSysPDTView.getPSSysPDTViewName());
    }

    protected void onFillParentInfo_HeaderPSSysPFPlugin(PSDEDRItem pSDEDRItem, PSSysPFPlugin pSSysPFPlugin) throws Exception {
        pSDEDRItem.setHeaderPSSysPFPluginId(pSSysPFPlugin.getPSSysPFPluginId());
        pSDEDRItem.setHeaderPSSysPFPluginName(pSSysPFPlugin.getPSSysPFPluginName());
    }

    protected void onFillParentInfo_PSSysUniRes(PSDEDRItem pSDEDRItem, PSSysUniRes pSSysUniRes) throws Exception {
        pSDEDRItem.setPSSysUniResId(pSSysUniRes.getPSSysUniResId());
        pSDEDRItem.setPSSysUniResName(pSSysUniRes.getPSSysUniResName());
    }

    protected void onFillEntityFullInfo(PSDEDRItem pSDEDRItem, boolean bl) throws Exception {
        if (bl) {
            if (pSDEDRItem.getCodeName() == null) {
                pSDEDRItem.setCodeName((String)this.getDefaultValue(this.getWebContext(), "USER", "DRItem", 25));
            }
            if (pSDEDRItem.getTestCustomMode() == null) {
                pSDEDRItem.setTestCustomMode((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
        }
        super.onFillEntityFullInfo(pSDEDRItem, bl);
        this.onFillEntityFullInfo_PSDE(pSDEDRItem, bl);
        this.onFillEntityFullInfo_TestPSDEAction(pSDEDRItem, bl);
        this.onFillEntityFullInfo_PSDEDRGroup(pSDEDRItem, bl);
        this.onFillEntityFullInfo_TestPSDELogic(pSDEDRItem, bl);
        this.onFillEntityFullInfo_PSDEOPPriv(pSDEDRItem, bl);
        this.onFillEntityFullInfo_PSDER(pSDEDRItem, bl);
        this.onFillEntityFullInfo_PSDEViewBase(pSDEDRItem, bl);
        this.onFillEntityFullInfo_CapPSLanRes(pSDEDRItem, bl);
        this.onFillEntityFullInfo_TipPSLanRes(pSDEDRItem, bl);
        this.onFillEntityFullInfo_PSSysCss(pSDEDRItem, bl);
        this.onFillEntityFullInfo_PSSysImage(pSDEDRItem, bl);
        this.onFillEntityFullInfo_PSSysPTDView(pSDEDRItem, bl);
        this.onFillEntityFullInfo_HeaderPSSysPFPlugin(pSDEDRItem, bl);
        this.onFillEntityFullInfo_PSSysUniRes(pSDEDRItem, bl);
    }

    protected void onFillEntityFullInfo_PSDE(PSDEDRItem pSDEDRItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_TestPSDEAction(PSDEDRItem pSDEDRItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEDRGroup(PSDEDRItem pSDEDRItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_TestPSDELogic(PSDEDRItem pSDEDRItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEOPPriv(PSDEDRItem pSDEDRItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDER(PSDEDRItem pSDEDRItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEViewBase(PSDEDRItem pSDEDRItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_CapPSLanRes(PSDEDRItem pSDEDRItem, boolean bl) throws Exception {
        if (pSDEDRItem.isCapPSLanResIdDirty()) {
            if (pSDEDRItem.getCapPSLanResId() != null) {
                if (pSDEDRItem.getCapPSLanResId() == null || pSDEDRItem.getCapPSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSDEDRItem.getCapPSLanRes();
                    pSDEDRItem.setCapPSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSDEDRItem.setCapPSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_TipPSLanRes(PSDEDRItem pSDEDRItem, boolean bl) throws Exception {
        if (pSDEDRItem.isTipPSLanResIdDirty()) {
            if (pSDEDRItem.getTipPSLanResId() != null) {
                if (pSDEDRItem.getTipPSLanResId() == null || pSDEDRItem.getTipPSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSDEDRItem.getTipPSLanRes();
                    pSDEDRItem.setTipPSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSDEDRItem.setTipPSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysCss(PSDEDRItem pSDEDRItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysImage(PSDEDRItem pSDEDRItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysPTDView(PSDEDRItem pSDEDRItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_HeaderPSSysPFPlugin(PSDEDRItem pSDEDRItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysUniRes(PSDEDRItem pSDEDRItem, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDEDRItem pSDEDRItem, boolean bl) throws Exception {
        super.onWriteBackParent(pSDEDRItem, bl);
    }

    public ArrayList<PSDEDRItem> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSDEDRItem> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSDEDRItem> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEDRItem> selectByTestPSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByTestPSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSDEDRItem> selectByTestPSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByTestPSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSDEDRItem> selectByTestPSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("TESTPSDEACTIONID", (Object)pSDEActionBase.getPSDEActionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByTestPSDEActionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByTestPSDEActionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEDRItem> selectByPSDEDRGroup(PSDEDRGroupBase pSDEDRGroupBase) throws Exception {
        return this.selectByPSDEDRGroup(pSDEDRGroupBase, "", -1);
    }

    public ArrayList<PSDEDRItem> selectByPSDEDRGroup(PSDEDRGroupBase pSDEDRGroupBase, String string) throws Exception {
        return this.selectByPSDEDRGroup(pSDEDRGroupBase, string, -1);
    }

    public ArrayList<PSDEDRItem> selectByPSDEDRGroup(PSDEDRGroupBase pSDEDRGroupBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEDRGROUPID", (Object)pSDEDRGroupBase.getPSDEDRGroupId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEDRGroupCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEDRGroupCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEDRItem> selectByTestPSDELogic(PSDELogicBase pSDELogicBase) throws Exception {
        return this.selectByTestPSDELogic(pSDELogicBase, "", -1);
    }

    public ArrayList<PSDEDRItem> selectByTestPSDELogic(PSDELogicBase pSDELogicBase, String string) throws Exception {
        return this.selectByTestPSDELogic(pSDELogicBase, string, -1);
    }

    public ArrayList<PSDEDRItem> selectByTestPSDELogic(PSDELogicBase pSDELogicBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("TESTPSDELOGICID", (Object)pSDELogicBase.getPSDELogicId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByTestPSDELogicCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByTestPSDELogicCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEDRItem> selectByPSDEOPPriv(PSDEOPPrivBase pSDEOPPrivBase) throws Exception {
        return this.selectByPSDEOPPriv(pSDEOPPrivBase, "", -1);
    }

    public ArrayList<PSDEDRItem> selectByPSDEOPPriv(PSDEOPPrivBase pSDEOPPrivBase, String string) throws Exception {
        return this.selectByPSDEOPPriv(pSDEOPPrivBase, string, -1);
    }

    public ArrayList<PSDEDRItem> selectByPSDEOPPriv(PSDEOPPrivBase pSDEOPPrivBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEDRItem> selectByPSDER(PSDERBase pSDERBase) throws Exception {
        return this.selectByPSDER(pSDERBase, "", -1);
    }

    public ArrayList<PSDEDRItem> selectByPSDER(PSDERBase pSDERBase, String string) throws Exception {
        return this.selectByPSDER(pSDERBase, string, -1);
    }

    public ArrayList<PSDEDRItem> selectByPSDER(PSDERBase pSDERBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEDRItem> selectByPSDEViewBase(PSDEViewBaseBase pSDEViewBaseBase) throws Exception {
        return this.selectByPSDEViewBase(pSDEViewBaseBase, "", -1);
    }

    public ArrayList<PSDEDRItem> selectByPSDEViewBase(PSDEViewBaseBase pSDEViewBaseBase, String string) throws Exception {
        return this.selectByPSDEViewBase(pSDEViewBaseBase, string, -1);
    }

    public ArrayList<PSDEDRItem> selectByPSDEViewBase(PSDEViewBaseBase pSDEViewBaseBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEDRItem> selectByCapPSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByCapPSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSDEDRItem> selectByCapPSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByCapPSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSDEDRItem> selectByCapPSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEDRItem> selectByTipPSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByTipPSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSDEDRItem> selectByTipPSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByTipPSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSDEDRItem> selectByTipPSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("TIPPSLANRESID", (Object)pSLanguageResBase.getPSLanguageResId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByTipPSLanResCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByTipPSLanResCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEDRItem> selectByPSSysCss(PSSysCssBase pSSysCssBase) throws Exception {
        return this.selectByPSSysCss(pSSysCssBase, "", -1);
    }

    public ArrayList<PSDEDRItem> selectByPSSysCss(PSSysCssBase pSSysCssBase, String string) throws Exception {
        return this.selectByPSSysCss(pSSysCssBase, string, -1);
    }

    public ArrayList<PSDEDRItem> selectByPSSysCss(PSSysCssBase pSSysCssBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEDRItem> selectByPSSysImage(PSSysImageBase pSSysImageBase) throws Exception {
        return this.selectByPSSysImage(pSSysImageBase, "", -1);
    }

    public ArrayList<PSDEDRItem> selectByPSSysImage(PSSysImageBase pSSysImageBase, String string) throws Exception {
        return this.selectByPSSysImage(pSSysImageBase, string, -1);
    }

    public ArrayList<PSDEDRItem> selectByPSSysImage(PSSysImageBase pSSysImageBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEDRItem> selectByPSSysPTDView(PSSysPDTViewBase pSSysPDTViewBase) throws Exception {
        return this.selectByPSSysPTDView(pSSysPDTViewBase, "", -1);
    }

    public ArrayList<PSDEDRItem> selectByPSSysPTDView(PSSysPDTViewBase pSSysPDTViewBase, String string) throws Exception {
        return this.selectByPSSysPTDView(pSSysPDTViewBase, string, -1);
    }

    public ArrayList<PSDEDRItem> selectByPSSysPTDView(PSSysPDTViewBase pSSysPDTViewBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSPDTVIEWID", (Object)pSSysPDTViewBase.getPSSysPDTViewId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysPTDViewCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysPTDViewCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEDRItem> selectByHeaderPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase) throws Exception {
        return this.selectByHeaderPSSysPFPlugin(pSSysPFPluginBase, "", -1);
    }

    public ArrayList<PSDEDRItem> selectByHeaderPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string) throws Exception {
        return this.selectByHeaderPSSysPFPlugin(pSSysPFPluginBase, string, -1);
    }

    public ArrayList<PSDEDRItem> selectByHeaderPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("HEADERPSSYSPFPLUGINID", (Object)pSSysPFPluginBase.getPSSysPFPluginId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByHeaderPSSysPFPluginCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByHeaderPSSysPFPluginCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEDRItem> selectByPSSysUniRes(PSSysUniResBase pSSysUniResBase) throws Exception {
        return this.selectByPSSysUniRes(pSSysUniResBase, "", -1);
    }

    public ArrayList<PSDEDRItem> selectByPSSysUniRes(PSSysUniResBase pSSysUniResBase, String string) throws Exception {
        return this.selectByPSSysUniRes(pSSysUniResBase, string, -1);
    }

    public ArrayList<PSDEDRItem> selectByPSSysUniRes(PSSysUniResBase pSSysUniResBase, String string, int n) throws Exception {
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

    public void testRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEDRItem> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSDEDRItem pSDEDRItem : arrayList) {
            PSDEDRItem pSDEDRItem2 = (PSDEDRItem)this.getDEModel().createEntity();
            pSDEDRItem2.setPSDEDRItemId(pSDEDRItem.getPSDEDRItemId());
            pSDEDRItem2.setPSDEId(null);
            this.update(pSDEDRItem2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDRItemServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSDEDRItemServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSDEDRItemServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEDRItem> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSDEDRItem pSDEDRItem : arrayList) {
            this.remove(pSDEDRItem);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEDRItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEDRItem> arrayList) throws Exception {
    }

    public void testRemoveByTestPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEDRItem> arrayList = this.selectByTestPSDEAction(pSDEAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDRITEM_PSDEACTION_TESTPSDEACTIONID", "", iDataEntityModel.getName(), "PSDEDRITEM", iDataEntityModel.getDataInfo(pSDEAction), arrayList.get(0)));
        }
    }

    public void resetTestPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEDRItem> arrayList = this.selectByTestPSDEAction(pSDEAction);
        for (PSDEDRItem pSDEDRItem : arrayList) {
            PSDEDRItem pSDEDRItem2 = (PSDEDRItem)this.getDEModel().createEntity();
            pSDEDRItem2.setPSDEDRItemId(pSDEDRItem.getPSDEDRItemId());
            pSDEDRItem2.setTestPSDEActionId(null);
            this.update(pSDEDRItem2);
        }
    }

    public void removeByTestPSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDRItemServiceBase.this.onBeforeRemoveByTestPSDEAction(pSDEAction2);
                PSDEDRItemServiceBase.this.internalRemoveByTestPSDEAction(pSDEAction2);
                PSDEDRItemServiceBase.this.onAfterRemoveByTestPSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByTestPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByTestPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEDRItem> arrayList = this.selectByTestPSDEAction(pSDEAction);
        this.onBeforeRemoveByTestPSDEAction(pSDEAction, arrayList);
        for (PSDEDRItem pSDEDRItem : arrayList) {
            this.remove(pSDEDRItem);
        }
        this.onAfterRemoveByTestPSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByTestPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByTestPSDEAction(PSDEAction pSDEAction, ArrayList<PSDEDRItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByTestPSDEAction(PSDEAction pSDEAction, ArrayList<PSDEDRItem> arrayList) throws Exception {
    }

    public void testRemoveByPSDEDRGroup(PSDEDRGroup pSDEDRGroup) throws Exception {
        ArrayList<PSDEDRItem> arrayList = this.selectByPSDEDRGroup(pSDEDRGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEDRGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEDRGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDRITEM_PSDEDRGROUP_PSDEDRGROUPID", "", iDataEntityModel.getName(), "PSDEDRITEM", iDataEntityModel.getDataInfo(pSDEDRGroup), arrayList.get(0)));
        }
    }

    public void resetPSDEDRGroup(PSDEDRGroup pSDEDRGroup) throws Exception {
        ArrayList<PSDEDRItem> arrayList = this.selectByPSDEDRGroup(pSDEDRGroup);
        for (PSDEDRItem pSDEDRItem : arrayList) {
            PSDEDRItem pSDEDRItem2 = (PSDEDRItem)this.getDEModel().createEntity();
            pSDEDRItem2.setPSDEDRItemId(pSDEDRItem.getPSDEDRItemId());
            pSDEDRItem2.setPSDEDRGroupId(null);
            this.update(pSDEDRItem2);
        }
    }

    public void removeByPSDEDRGroup(PSDEDRGroup pSDEDRGroup) throws Exception {
        final PSDEDRGroup pSDEDRGroup2 = pSDEDRGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDRItemServiceBase.this.onBeforeRemoveByPSDEDRGroup(pSDEDRGroup2);
                PSDEDRItemServiceBase.this.internalRemoveByPSDEDRGroup(pSDEDRGroup2);
                PSDEDRItemServiceBase.this.onAfterRemoveByPSDEDRGroup(pSDEDRGroup2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEDRGroup(PSDEDRGroup pSDEDRGroup) throws Exception {
    }

    protected void internalRemoveByPSDEDRGroup(PSDEDRGroup pSDEDRGroup) throws Exception {
        ArrayList<PSDEDRItem> arrayList = this.selectByPSDEDRGroup(pSDEDRGroup);
        this.onBeforeRemoveByPSDEDRGroup(pSDEDRGroup, arrayList);
        for (PSDEDRItem pSDEDRItem : arrayList) {
            this.remove(pSDEDRItem);
        }
        this.onAfterRemoveByPSDEDRGroup(pSDEDRGroup, arrayList);
    }

    protected void onAfterRemoveByPSDEDRGroup(PSDEDRGroup pSDEDRGroup) throws Exception {
    }

    protected void onBeforeRemoveByPSDEDRGroup(PSDEDRGroup pSDEDRGroup, ArrayList<PSDEDRItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEDRGroup(PSDEDRGroup pSDEDRGroup, ArrayList<PSDEDRItem> arrayList) throws Exception {
    }

    public void testRemoveByTestPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSDEDRItem> arrayList = this.selectByTestPSDELogic(pSDELogic, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDELOGIC");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDELogic);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDRITEM_PSDELOGIC_TESTPSDELOGICID", "", iDataEntityModel.getName(), "PSDEDRITEM", iDataEntityModel.getDataInfo(pSDELogic), arrayList.get(0)));
        }
    }

    public void resetTestPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSDEDRItem> arrayList = this.selectByTestPSDELogic(pSDELogic);
        for (PSDEDRItem pSDEDRItem : arrayList) {
            PSDEDRItem pSDEDRItem2 = (PSDEDRItem)this.getDEModel().createEntity();
            pSDEDRItem2.setPSDEDRItemId(pSDEDRItem.getPSDEDRItemId());
            pSDEDRItem2.setTestPSDELogicId(null);
            this.update(pSDEDRItem2);
        }
    }

    public void removeByTestPSDELogic(PSDELogic pSDELogic) throws Exception {
        final PSDELogic pSDELogic2 = pSDELogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDRItemServiceBase.this.onBeforeRemoveByTestPSDELogic(pSDELogic2);
                PSDEDRItemServiceBase.this.internalRemoveByTestPSDELogic(pSDELogic2);
                PSDEDRItemServiceBase.this.onAfterRemoveByTestPSDELogic(pSDELogic2);
            }
        });
    }

    protected void onBeforeRemoveByTestPSDELogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void internalRemoveByTestPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSDEDRItem> arrayList = this.selectByTestPSDELogic(pSDELogic);
        this.onBeforeRemoveByTestPSDELogic(pSDELogic, arrayList);
        for (PSDEDRItem pSDEDRItem : arrayList) {
            this.remove(pSDEDRItem);
        }
        this.onAfterRemoveByTestPSDELogic(pSDELogic, arrayList);
    }

    protected void onAfterRemoveByTestPSDELogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void onBeforeRemoveByTestPSDELogic(PSDELogic pSDELogic, ArrayList<PSDEDRItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByTestPSDELogic(PSDELogic pSDELogic, ArrayList<PSDEDRItem> arrayList) throws Exception {
    }

    public void testRemoveByPSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSDEDRItem> arrayList = this.selectByPSDEOPPriv(pSDEOPPriv, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEOPPRIV");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEOPPriv);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDRITEM_PSDEOPPRIV_PSDEOPPRIVID", "", iDataEntityModel.getName(), "PSDEDRITEM", iDataEntityModel.getDataInfo(pSDEOPPriv), arrayList.get(0)));
        }
    }

    public void resetPSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSDEDRItem> arrayList = this.selectByPSDEOPPriv(pSDEOPPriv);
        for (PSDEDRItem pSDEDRItem : arrayList) {
            PSDEDRItem pSDEDRItem2 = (PSDEDRItem)this.getDEModel().createEntity();
            pSDEDRItem2.setPSDEDRItemId(pSDEDRItem.getPSDEDRItemId());
            pSDEDRItem2.setPSDEOPPrivId(null);
            this.update(pSDEDRItem2);
        }
    }

    public void removeByPSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        final PSDEOPPriv pSDEOPPriv2 = pSDEOPPriv;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDRItemServiceBase.this.onBeforeRemoveByPSDEOPPriv(pSDEOPPriv2);
                PSDEDRItemServiceBase.this.internalRemoveByPSDEOPPriv(pSDEOPPriv2);
                PSDEDRItemServiceBase.this.onAfterRemoveByPSDEOPPriv(pSDEOPPriv2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
    }

    protected void internalRemoveByPSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSDEDRItem> arrayList = this.selectByPSDEOPPriv(pSDEOPPriv);
        this.onBeforeRemoveByPSDEOPPriv(pSDEOPPriv, arrayList);
        for (PSDEDRItem pSDEDRItem : arrayList) {
            this.remove(pSDEDRItem);
        }
        this.onAfterRemoveByPSDEOPPriv(pSDEOPPriv, arrayList);
    }

    protected void onAfterRemoveByPSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
    }

    protected void onBeforeRemoveByPSDEOPPriv(PSDEOPPriv pSDEOPPriv, ArrayList<PSDEDRItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEOPPriv(PSDEOPPriv pSDEOPPriv, ArrayList<PSDEDRItem> arrayList) throws Exception {
    }

    public void testRemoveByPSDER(PSDER pSDER) throws Exception {
    }

    public void resetPSDER(PSDER pSDER) throws Exception {
        ArrayList<PSDEDRItem> arrayList = this.selectByPSDER(pSDER);
        for (PSDEDRItem pSDEDRItem : arrayList) {
            PSDEDRItem pSDEDRItem2 = (PSDEDRItem)this.getDEModel().createEntity();
            pSDEDRItem2.setPSDEDRItemId(pSDEDRItem.getPSDEDRItemId());
            pSDEDRItem2.setPSDERId(null);
            this.update(pSDEDRItem2);
        }
    }

    public void removeByPSDER(PSDER pSDER) throws Exception {
        final PSDER pSDER2 = pSDER;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDRItemServiceBase.this.onBeforeRemoveByPSDER(pSDER2);
                PSDEDRItemServiceBase.this.internalRemoveByPSDER(pSDER2);
                PSDEDRItemServiceBase.this.onAfterRemoveByPSDER(pSDER2);
            }
        });
    }

    protected void onBeforeRemoveByPSDER(PSDER pSDER) throws Exception {
    }

    protected void internalRemoveByPSDER(PSDER pSDER) throws Exception {
        ArrayList<PSDEDRItem> arrayList = this.selectByPSDER(pSDER);
        this.onBeforeRemoveByPSDER(pSDER, arrayList);
        for (PSDEDRItem pSDEDRItem : arrayList) {
            this.remove(pSDEDRItem);
        }
        this.onAfterRemoveByPSDER(pSDER, arrayList);
    }

    protected void onAfterRemoveByPSDER(PSDER pSDER) throws Exception {
    }

    protected void onBeforeRemoveByPSDER(PSDER pSDER, ArrayList<PSDEDRItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDER(PSDER pSDER, ArrayList<PSDEDRItem> arrayList) throws Exception {
    }

    public void testRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEDRItem> arrayList = this.selectByPSDEViewBase(pSDEViewBase, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVIEWBASE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEViewBase);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDRITEM_PSDEVIEWBASE_PSDEVIEWBASEID", "", iDataEntityModel.getName(), "PSDEDRITEM", iDataEntityModel.getDataInfo(pSDEViewBase), arrayList.get(0)));
        }
    }

    public void resetPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEDRItem> arrayList = this.selectByPSDEViewBase(pSDEViewBase);
        for (PSDEDRItem pSDEDRItem : arrayList) {
            PSDEDRItem pSDEDRItem2 = (PSDEDRItem)this.getDEModel().createEntity();
            pSDEDRItem2.setPSDEDRItemId(pSDEDRItem.getPSDEDRItemId());
            pSDEDRItem2.setPSDEViewBaseId(null);
            this.update(pSDEDRItem2);
        }
    }

    public void removeByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
        final PSDEViewBase pSDEViewBase2 = pSDEViewBase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDRItemServiceBase.this.onBeforeRemoveByPSDEViewBase(pSDEViewBase2);
                PSDEDRItemServiceBase.this.internalRemoveByPSDEViewBase(pSDEViewBase2);
                PSDEDRItemServiceBase.this.onAfterRemoveByPSDEViewBase(pSDEViewBase2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void internalRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEDRItem> arrayList = this.selectByPSDEViewBase(pSDEViewBase);
        this.onBeforeRemoveByPSDEViewBase(pSDEViewBase, arrayList);
        for (PSDEDRItem pSDEDRItem : arrayList) {
            this.remove(pSDEDRItem);
        }
        this.onAfterRemoveByPSDEViewBase(pSDEViewBase, arrayList);
    }

    protected void onAfterRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void onBeforeRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase, ArrayList<PSDEDRItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase, ArrayList<PSDEDRItem> arrayList) throws Exception {
    }

    public void testRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEDRItem> arrayList = this.selectByCapPSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDRITEM_PSLANGUAGERES_CAPPSLANRESID", "", iDataEntityModel.getName(), "PSDEDRITEM", iDataEntityModel.getDataInfo(pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEDRItem> arrayList = this.selectByCapPSLanRes(pSLanguageRes);
        for (PSDEDRItem pSDEDRItem : arrayList) {
            PSDEDRItem pSDEDRItem2 = (PSDEDRItem)this.getDEModel().createEntity();
            pSDEDRItem2.setPSDEDRItemId(pSDEDRItem.getPSDEDRItemId());
            pSDEDRItem2.setCapPSLanResId(null);
            this.update(pSDEDRItem2);
        }
    }

    public void removeByCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDRItemServiceBase.this.onBeforeRemoveByCapPSLanRes(pSLanguageRes2);
                PSDEDRItemServiceBase.this.internalRemoveByCapPSLanRes(pSLanguageRes2);
                PSDEDRItemServiceBase.this.onAfterRemoveByCapPSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEDRItem> arrayList = this.selectByCapPSLanRes(pSLanguageRes);
        this.onBeforeRemoveByCapPSLanRes(pSLanguageRes, arrayList);
        for (PSDEDRItem pSDEDRItem : arrayList) {
            this.remove(pSDEDRItem);
        }
        this.onAfterRemoveByCapPSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEDRItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEDRItem> arrayList) throws Exception {
    }

    public void testRemoveByTipPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEDRItem> arrayList = this.selectByTipPSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDRITEM_PSLANGUAGERES_TIPPSLANRESID", "", iDataEntityModel.getName(), "PSDEDRITEM", iDataEntityModel.getDataInfo(pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetTipPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEDRItem> arrayList = this.selectByTipPSLanRes(pSLanguageRes);
        for (PSDEDRItem pSDEDRItem : arrayList) {
            PSDEDRItem pSDEDRItem2 = (PSDEDRItem)this.getDEModel().createEntity();
            pSDEDRItem2.setPSDEDRItemId(pSDEDRItem.getPSDEDRItemId());
            pSDEDRItem2.setTipPSLanResId(null);
            this.update(pSDEDRItem2);
        }
    }

    public void removeByTipPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDRItemServiceBase.this.onBeforeRemoveByTipPSLanRes(pSLanguageRes2);
                PSDEDRItemServiceBase.this.internalRemoveByTipPSLanRes(pSLanguageRes2);
                PSDEDRItemServiceBase.this.onAfterRemoveByTipPSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByTipPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByTipPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEDRItem> arrayList = this.selectByTipPSLanRes(pSLanguageRes);
        this.onBeforeRemoveByTipPSLanRes(pSLanguageRes, arrayList);
        for (PSDEDRItem pSDEDRItem : arrayList) {
            this.remove(pSDEDRItem);
        }
        this.onAfterRemoveByTipPSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByTipPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByTipPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEDRItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByTipPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEDRItem> arrayList) throws Exception {
    }

    public void testRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDEDRItem> arrayList = this.selectByPSSysCss(pSSysCss, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSCSS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysCss);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDRITEM_PSSYSCSS_PSSYSCSSID", "", iDataEntityModel.getName(), "PSDEDRITEM", iDataEntityModel.getDataInfo(pSSysCss), arrayList.get(0)));
        }
    }

    public void resetPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDEDRItem> arrayList = this.selectByPSSysCss(pSSysCss);
        for (PSDEDRItem pSDEDRItem : arrayList) {
            PSDEDRItem pSDEDRItem2 = (PSDEDRItem)this.getDEModel().createEntity();
            pSDEDRItem2.setPSDEDRItemId(pSDEDRItem.getPSDEDRItemId());
            pSDEDRItem2.setPSSysCssId(null);
            this.update(pSDEDRItem2);
        }
    }

    public void removeByPSSysCss(PSSysCss pSSysCss) throws Exception {
        final PSSysCss pSSysCss2 = pSSysCss;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDRItemServiceBase.this.onBeforeRemoveByPSSysCss(pSSysCss2);
                PSDEDRItemServiceBase.this.internalRemoveByPSSysCss(pSSysCss2);
                PSDEDRItemServiceBase.this.onAfterRemoveByPSSysCss(pSSysCss2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void internalRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDEDRItem> arrayList = this.selectByPSSysCss(pSSysCss);
        this.onBeforeRemoveByPSSysCss(pSSysCss, arrayList);
        for (PSDEDRItem pSDEDRItem : arrayList) {
            this.remove(pSDEDRItem);
        }
        this.onAfterRemoveByPSSysCss(pSSysCss, arrayList);
    }

    protected void onAfterRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void onBeforeRemoveByPSSysCss(PSSysCss pSSysCss, ArrayList<PSDEDRItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysCss(PSSysCss pSSysCss, ArrayList<PSDEDRItem> arrayList) throws Exception {
    }

    public void testRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
        ArrayList<PSDEDRItem> arrayList = this.selectByPSSysImage(pSSysImage, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSIMAGE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysImage);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDRITEM_PSSYSIMAGE_PSSYSIMAGEID", "", iDataEntityModel.getName(), "PSDEDRITEM", iDataEntityModel.getDataInfo(pSSysImage), arrayList.get(0)));
        }
    }

    public void resetPSSysImage(PSSysImage pSSysImage) throws Exception {
        ArrayList<PSDEDRItem> arrayList = this.selectByPSSysImage(pSSysImage);
        for (PSDEDRItem pSDEDRItem : arrayList) {
            PSDEDRItem pSDEDRItem2 = (PSDEDRItem)this.getDEModel().createEntity();
            pSDEDRItem2.setPSDEDRItemId(pSDEDRItem.getPSDEDRItemId());
            pSDEDRItem2.setPSSysImageId(null);
            this.update(pSDEDRItem2);
        }
    }

    public void removeByPSSysImage(PSSysImage pSSysImage) throws Exception {
        final PSSysImage pSSysImage2 = pSSysImage;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDRItemServiceBase.this.onBeforeRemoveByPSSysImage(pSSysImage2);
                PSDEDRItemServiceBase.this.internalRemoveByPSSysImage(pSSysImage2);
                PSDEDRItemServiceBase.this.onAfterRemoveByPSSysImage(pSSysImage2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
    }

    protected void internalRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
        ArrayList<PSDEDRItem> arrayList = this.selectByPSSysImage(pSSysImage);
        this.onBeforeRemoveByPSSysImage(pSSysImage, arrayList);
        for (PSDEDRItem pSDEDRItem : arrayList) {
            this.remove(pSDEDRItem);
        }
        this.onAfterRemoveByPSSysImage(pSSysImage, arrayList);
    }

    protected void onAfterRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
    }

    protected void onBeforeRemoveByPSSysImage(PSSysImage pSSysImage, ArrayList<PSDEDRItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysImage(PSSysImage pSSysImage, ArrayList<PSDEDRItem> arrayList) throws Exception {
    }

    public void testRemoveByPSSysPTDView(PSSysPDTView pSSysPDTView) throws Exception {
        ArrayList<PSDEDRItem> arrayList = this.selectByPSSysPTDView(pSSysPDTView, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSPDTVIEW");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysPDTView);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDRITEM_PSSYSPDTVIEW_PSSYSPDTVIEWID", "", iDataEntityModel.getName(), "PSDEDRITEM", iDataEntityModel.getDataInfo(pSSysPDTView), arrayList.get(0)));
        }
    }

    public void resetPSSysPTDView(PSSysPDTView pSSysPDTView) throws Exception {
        ArrayList<PSDEDRItem> arrayList = this.selectByPSSysPTDView(pSSysPDTView);
        for (PSDEDRItem pSDEDRItem : arrayList) {
            PSDEDRItem pSDEDRItem2 = (PSDEDRItem)this.getDEModel().createEntity();
            pSDEDRItem2.setPSDEDRItemId(pSDEDRItem.getPSDEDRItemId());
            pSDEDRItem2.setPSSysPDTViewId(null);
            this.update(pSDEDRItem2);
        }
    }

    public void removeByPSSysPTDView(PSSysPDTView pSSysPDTView) throws Exception {
        final PSSysPDTView pSSysPDTView2 = pSSysPDTView;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDRItemServiceBase.this.onBeforeRemoveByPSSysPTDView(pSSysPDTView2);
                PSDEDRItemServiceBase.this.internalRemoveByPSSysPTDView(pSSysPDTView2);
                PSDEDRItemServiceBase.this.onAfterRemoveByPSSysPTDView(pSSysPDTView2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysPTDView(PSSysPDTView pSSysPDTView) throws Exception {
    }

    protected void internalRemoveByPSSysPTDView(PSSysPDTView pSSysPDTView) throws Exception {
        ArrayList<PSDEDRItem> arrayList = this.selectByPSSysPTDView(pSSysPDTView);
        this.onBeforeRemoveByPSSysPTDView(pSSysPDTView, arrayList);
        for (PSDEDRItem pSDEDRItem : arrayList) {
            this.remove(pSDEDRItem);
        }
        this.onAfterRemoveByPSSysPTDView(pSSysPDTView, arrayList);
    }

    protected void onAfterRemoveByPSSysPTDView(PSSysPDTView pSSysPDTView) throws Exception {
    }

    protected void onBeforeRemoveByPSSysPTDView(PSSysPDTView pSSysPDTView, ArrayList<PSDEDRItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysPTDView(PSSysPDTView pSSysPDTView, ArrayList<PSDEDRItem> arrayList) throws Exception {
    }

    public void testRemoveByHeaderPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEDRItem> arrayList = this.selectByHeaderPSSysPFPlugin(pSSysPFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSPFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysPFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDRITEM_PSSYSPFPLUGIN_HEADERPSSYSPFPLUGINID", "", iDataEntityModel.getName(), "PSDEDRITEM", iDataEntityModel.getDataInfo(pSSysPFPlugin), arrayList.get(0)));
        }
    }

    public void resetHeaderPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEDRItem> arrayList = this.selectByHeaderPSSysPFPlugin(pSSysPFPlugin);
        for (PSDEDRItem pSDEDRItem : arrayList) {
            PSDEDRItem pSDEDRItem2 = (PSDEDRItem)this.getDEModel().createEntity();
            pSDEDRItem2.setPSDEDRItemId(pSDEDRItem.getPSDEDRItemId());
            pSDEDRItem2.setHeaderPSSysPFPluginId(null);
            this.update(pSDEDRItem2);
        }
    }

    public void removeByHeaderPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        final PSSysPFPlugin pSSysPFPlugin2 = pSSysPFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDRItemServiceBase.this.onBeforeRemoveByHeaderPSSysPFPlugin(pSSysPFPlugin2);
                PSDEDRItemServiceBase.this.internalRemoveByHeaderPSSysPFPlugin(pSSysPFPlugin2);
                PSDEDRItemServiceBase.this.onAfterRemoveByHeaderPSSysPFPlugin(pSSysPFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByHeaderPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void internalRemoveByHeaderPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEDRItem> arrayList = this.selectByHeaderPSSysPFPlugin(pSSysPFPlugin);
        this.onBeforeRemoveByHeaderPSSysPFPlugin(pSSysPFPlugin, arrayList);
        for (PSDEDRItem pSDEDRItem : arrayList) {
            this.remove(pSDEDRItem);
        }
        this.onAfterRemoveByHeaderPSSysPFPlugin(pSSysPFPlugin, arrayList);
    }

    protected void onAfterRemoveByHeaderPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByHeaderPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSDEDRItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByHeaderPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSDEDRItem> arrayList) throws Exception {
    }

    public void testRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
        ArrayList<PSDEDRItem> arrayList = this.selectByPSSysUniRes(pSSysUniRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSUNIRES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysUniRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDRITEM_PSSYSUNIRES_PSSYSUNIRESID", "", iDataEntityModel.getName(), "PSDEDRITEM", iDataEntityModel.getDataInfo(pSSysUniRes), arrayList.get(0)));
        }
    }

    public void resetPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
        ArrayList<PSDEDRItem> arrayList = this.selectByPSSysUniRes(pSSysUniRes);
        for (PSDEDRItem pSDEDRItem : arrayList) {
            PSDEDRItem pSDEDRItem2 = (PSDEDRItem)this.getDEModel().createEntity();
            pSDEDRItem2.setPSDEDRItemId(pSDEDRItem.getPSDEDRItemId());
            pSDEDRItem2.setPSSysUniResId(null);
            this.update(pSDEDRItem2);
        }
    }

    public void removeByPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
        final PSSysUniRes pSSysUniRes2 = pSSysUniRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDRItemServiceBase.this.onBeforeRemoveByPSSysUniRes(pSSysUniRes2);
                PSDEDRItemServiceBase.this.internalRemoveByPSSysUniRes(pSSysUniRes2);
                PSDEDRItemServiceBase.this.onAfterRemoveByPSSysUniRes(pSSysUniRes2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
    }

    protected void internalRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
        ArrayList<PSDEDRItem> arrayList = this.selectByPSSysUniRes(pSSysUniRes);
        this.onBeforeRemoveByPSSysUniRes(pSSysUniRes, arrayList);
        for (PSDEDRItem pSDEDRItem : arrayList) {
            this.remove(pSDEDRItem);
        }
        this.onAfterRemoveByPSSysUniRes(pSSysUniRes, arrayList);
    }

    protected void onAfterRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
    }

    protected void onBeforeRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes, ArrayList<PSDEDRItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes, ArrayList<PSDEDRItem> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDEDRItem pSDEDRItem) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEFormDetailService)ServiceGlobal.getService(PSDEFormDetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFormDetailServiceBase)pSCoreSysServiceBase).testRemoveByPSDEDRItem(pSDEDRItem);
        pSCoreSysServiceBase = (PSSysViewPanelItemService)ServiceGlobal.getService(PSSysViewPanelItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysViewPanelItemServiceBase)pSCoreSysServiceBase).testRemoveByPSDEDRItem(pSDEDRItem);
        pSCoreSysServiceBase = (PSDEDRDetailService)ServiceGlobal.getService(PSDEDRDetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDRDetailServiceBase)pSCoreSysServiceBase).testRemoveByPSDEDRItem(pSDEDRItem);
        ((PSDEDRDetailServiceBase)pSCoreSysServiceBase).removeByPSDEDRItem(pSDEDRItem);
        super.onBeforeRemove(pSDEDRItem);
    }

    protected void replaceParentInfo(PSDEDRItem pSDEDRItem, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDEDRItem, cloneSession);
        if (pSDEDRItem.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSDEDRItem.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSDEDRItem, (PSDataEntity)iEntity);
        }
        if (pSDEDRItem.getTestPSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSDEDRItem.getTestPSDEActionId())) != null) {
            this.onFillParentInfo_TestPSDEAction(pSDEDRItem, (PSDEAction)iEntity);
        }
        if (pSDEDRItem.getPSDEDRGroupId() != null && (iEntity = cloneSession.getEntity("PSDEDRGROUP", (Object)pSDEDRItem.getPSDEDRGroupId())) != null) {
            this.onFillParentInfo_PSDEDRGroup(pSDEDRItem, (PSDEDRGroup)iEntity);
        }
        if (pSDEDRItem.getTestPSDELogicId() != null && (iEntity = cloneSession.getEntity("PSDELOGIC", (Object)pSDEDRItem.getTestPSDELogicId())) != null) {
            this.onFillParentInfo_TestPSDELogic(pSDEDRItem, (PSDELogic)iEntity);
        }
        if (pSDEDRItem.getPSDEOPPrivId() != null && (iEntity = cloneSession.getEntity("PSDEOPPRIV", (Object)pSDEDRItem.getPSDEOPPrivId())) != null) {
            this.onFillParentInfo_PSDEOPPriv(pSDEDRItem, (PSDEOPPriv)iEntity);
        }
        if (pSDEDRItem.getPSDERId() != null && (iEntity = cloneSession.getEntity("PSDER", (Object)pSDEDRItem.getPSDERId())) != null) {
            this.onFillParentInfo_PSDER(pSDEDRItem, (PSDER)iEntity);
        }
        if (pSDEDRItem.getPSDEViewBaseId() != null && (iEntity = cloneSession.getEntity("PSDEVIEWBASE", (Object)pSDEDRItem.getPSDEViewBaseId())) != null) {
            this.onFillParentInfo_PSDEViewBase(pSDEDRItem, (PSDEViewBase)iEntity);
        }
        if (pSDEDRItem.getCapPSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSDEDRItem.getCapPSLanResId())) != null) {
            this.onFillParentInfo_CapPSLanRes(pSDEDRItem, (PSLanguageRes)iEntity);
        }
        if (pSDEDRItem.getTipPSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSDEDRItem.getTipPSLanResId())) != null) {
            this.onFillParentInfo_TipPSLanRes(pSDEDRItem, (PSLanguageRes)iEntity);
        }
        if (pSDEDRItem.getPSSysCssId() != null && (iEntity = cloneSession.getEntity("PSSYSCSS", (Object)pSDEDRItem.getPSSysCssId())) != null) {
            this.onFillParentInfo_PSSysCss(pSDEDRItem, (PSSysCss)iEntity);
        }
        if (pSDEDRItem.getPSSysImageId() != null && (iEntity = cloneSession.getEntity("PSSYSIMAGE", (Object)pSDEDRItem.getPSSysImageId())) != null) {
            this.onFillParentInfo_PSSysImage(pSDEDRItem, (PSSysImage)iEntity);
        }
        if (pSDEDRItem.getPSSysPDTViewId() != null && (iEntity = cloneSession.getEntity("PSSYSPDTVIEW", (Object)pSDEDRItem.getPSSysPDTViewId())) != null) {
            this.onFillParentInfo_PSSysPTDView(pSDEDRItem, (PSSysPDTView)iEntity);
        }
        if (pSDEDRItem.getHeaderPSSysPFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSPFPLUGIN", (Object)pSDEDRItem.getHeaderPSSysPFPluginId())) != null) {
            this.onFillParentInfo_HeaderPSSysPFPlugin(pSDEDRItem, (PSSysPFPlugin)iEntity);
        }
        if (pSDEDRItem.getPSSysUniResId() != null && (iEntity = cloneSession.getEntity("PSSYSUNIRES", (Object)pSDEDRItem.getPSSysUniResId())) != null) {
            this.onFillParentInfo_PSSysUniRes(pSDEDRItem, (PSSysUniRes)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDEDRItem pSDEDRItem, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDEDRItem, bl);
        pSDEDRItem.resetCodeName();
    }

    protected void onCheckEntity(boolean bl, PSDEDRItem pSDEDRItem, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CapPSLanResId(bl, pSDEDRItem, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CapPSLanResName(bl, pSDEDRItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSDEDRItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CounterId(bl, pSDEDRItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CounterMode(bl, pSDEDRItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Data(bl, pSDEDRItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DRItemType(bl, pSDEDRItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaModelFlag(bl, pSDEDRItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableMode(bl, pSDEDRItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HeaderPSSysPFPluginId(bl, pSDEDRItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ItemTag(bl, pSDEDRItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ItemTag2(bl, pSDEDRItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LockFlag(bl, pSDEDRItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDEDRItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MinorPSDEId(bl, pSDEDRItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NavViewFilter(bl, pSDEDRItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NavViewFilterDesc(bl, pSDEDRItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSDEDRItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PDTViewFlag(bl, pSDEDRItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDRGroupId(bl, pSDEDRItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDRItemId(bl, pSDEDRItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDRItemName(bl, pSDEDRItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSDEDRItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEOPPrivId(bl, pSDEDRItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDERId(bl, pSDEDRItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEViewBaseId(bl, pSDEDRItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaInstId(bl, pSDEDRItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysCssId(bl, pSDEDRItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysImageId(bl, pSDEDRItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysPDTViewId(bl, pSDEDRItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysUniResId(bl, pSDEDRItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SRFSysPub(bl, pSDEDRItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TestCustomCode(bl, pSDEDRItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TestCustomMode(bl, pSDEDRItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TestPSDEActionId(bl, pSDEDRItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TestPSDELogicId(bl, pSDEDRItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TipPSLanResId(bl, pSDEDRItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TipPSLanResName(bl, pSDEDRItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TooltipInfo(bl, pSDEDRItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSDEDRItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDEDRItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDEDRItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDEDRItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDEDRItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ViewParams(bl, pSDEDRItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ViewPSDEId(bl, pSDEDRItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDEDRItem, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CapPSLanResId(boolean bl, PSDEDRItem pSDEDRItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRItem.isCapPSLanResIdDirty() : !pSDEDRItem.isCapPSLanResIdDirty()) {
            return null;
        }
        String string = pSDEDRItem.getCapPSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CapPSLanResId_Default(pSDEDRItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_CapPSLanResName(boolean bl, PSDEDRItem pSDEDRItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRItem.isCapPSLanResNameDirty() : !pSDEDRItem.isCapPSLanResNameDirty()) {
            return null;
        }
        String string = pSDEDRItem.getCapPSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CapPSLanResName_Default(pSDEDRItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSDEDRItem pSDEDRItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRItem.isCodeNameDirty() : !pSDEDRItem.isCodeNameDirty()) {
            return null;
        }
        String string = pSDEDRItem.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSDEDRItem, bl2, bl3);
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
                String string4 = this.checkFieldDupRule(this.getPSDEDRItemDEModel(), "CODENAME", string3, pSDEDRItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_CounterId(boolean bl, PSDEDRItem pSDEDRItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRItem.isCounterIdDirty() : !pSDEDRItem.isCounterIdDirty()) {
            return null;
        }
        String string = pSDEDRItem.getCounterId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CounterId_Default(pSDEDRItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("COUNTERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CounterMode(boolean bl, PSDEDRItem pSDEDRItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRItem.isCounterModeDirty() : !pSDEDRItem.isCounterModeDirty()) {
            return null;
        }
        Integer n = pSDEDRItem.getCounterMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CounterMode_Default(pSDEDRItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("COUNTERMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Data(boolean bl, PSDEDRItem pSDEDRItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRItem.isDataDirty() : !pSDEDRItem.isDataDirty()) {
            return null;
        }
        String string = pSDEDRItem.getData();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Data_Default(pSDEDRItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DATA");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DRItemType(boolean bl, PSDEDRItem pSDEDRItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRItem.isDRItemTypeDirty() && !bl2 : !pSDEDRItem.isDRItemTypeDirty()) {
            return null;
        }
        String string = pSDEDRItem.getDRItemType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DRITEMTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_DRItemType_Default(pSDEDRItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DRITEMTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DynaModelFlag(boolean bl, PSDEDRItem pSDEDRItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRItem.isDynaModelFlagDirty() : !pSDEDRItem.isDynaModelFlagDirty()) {
            return null;
        }
        Integer n = pSDEDRItem.getDynaModelFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DynaModelFlag_Default(pSDEDRItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_EnableMode(boolean bl, PSDEDRItem pSDEDRItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRItem.isEnableModeDirty() : !pSDEDRItem.isEnableModeDirty()) {
            return null;
        }
        String string = pSDEDRItem.getEnableMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EnableMode_Default(pSDEDRItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_HeaderPSSysPFPluginId(boolean bl, PSDEDRItem pSDEDRItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRItem.isHeaderPSSysPFPluginIdDirty() : !pSDEDRItem.isHeaderPSSysPFPluginIdDirty()) {
            return null;
        }
        String string = pSDEDRItem.getHeaderPSSysPFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_HeaderPSSysPFPluginId_Default(pSDEDRItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HEADERPSSYSPFPLUGINID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ItemTag(boolean bl, PSDEDRItem pSDEDRItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRItem.isItemTagDirty() : !pSDEDRItem.isItemTagDirty()) {
            return null;
        }
        String string = pSDEDRItem.getItemTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ItemTag_Default(pSDEDRItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ITEMTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ItemTag2(boolean bl, PSDEDRItem pSDEDRItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRItem.isItemTag2Dirty() : !pSDEDRItem.isItemTag2Dirty()) {
            return null;
        }
        String string = pSDEDRItem.getItemTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ItemTag2_Default(pSDEDRItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ITEMTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LockFlag(boolean bl, PSDEDRItem pSDEDRItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRItem.isLockFlagDirty() : !pSDEDRItem.isLockFlagDirty()) {
            return null;
        }
        Integer n = pSDEDRItem.getLockFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LockFlag_Default(pSDEDRItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDEDRItem pSDEDRItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRItem.isMemoDirty() : !pSDEDRItem.isMemoDirty()) {
            return null;
        }
        String string = pSDEDRItem.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDEDRItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_MinorPSDEId(boolean bl, PSDEDRItem pSDEDRItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRItem.isMinorPSDEIdDirty() : !pSDEDRItem.isMinorPSDEIdDirty()) {
            return null;
        }
        String string = pSDEDRItem.getMinorPSDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MinorPSDEId_Default(pSDEDRItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MINORPSDEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NavViewFilter(boolean bl, PSDEDRItem pSDEDRItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRItem.isNavViewFilterDirty() : !pSDEDRItem.isNavViewFilterDirty()) {
            return null;
        }
        String string = pSDEDRItem.getNavViewFilter();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NavViewFilter_Default(pSDEDRItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_NavViewFilterDesc(boolean bl, PSDEDRItem pSDEDRItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRItem.isNavViewFilterDescDirty() : !pSDEDRItem.isNavViewFilterDescDirty()) {
            return null;
        }
        String string = pSDEDRItem.getNavViewFilterDesc();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NavViewFilterDesc_Default(pSDEDRItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NAVVIEWFILTERDESC");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSDEDRItem pSDEDRItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRItem.isOrderValueDirty() : !pSDEDRItem.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSDEDRItem.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSDEDRItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PDTViewFlag(boolean bl, PSDEDRItem pSDEDRItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRItem.isPDTViewFlagDirty() : !pSDEDRItem.isPDTViewFlagDirty()) {
            return null;
        }
        Integer n = pSDEDRItem.getPDTViewFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PDTViewFlag_Default(pSDEDRItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PDTVIEWFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEDRGroupId(boolean bl, PSDEDRItem pSDEDRItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRItem.isPSDEDRGroupIdDirty() : !pSDEDRItem.isPSDEDRGroupIdDirty()) {
            return null;
        }
        String string = pSDEDRItem.getPSDEDRGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDRGroupId_Default(pSDEDRItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDRGROUPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEDRItemId(boolean bl, PSDEDRItem pSDEDRItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRItem.isPSDEDRItemIdDirty() && !bl2 : !pSDEDRItem.isPSDEDRItemIdDirty()) {
            return null;
        }
        String string = pSDEDRItem.getPSDEDRItemId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDRITEMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDRItemId_Default(pSDEDRItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDRITEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEDRItemName(boolean bl, PSDEDRItem pSDEDRItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRItem.isPSDEDRItemNameDirty() && !bl2 : !pSDEDRItem.isPSDEDRItemNameDirty()) {
            return null;
        }
        String string = pSDEDRItem.getPSDEDRItemName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDRITEMNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDRItemName_Default(pSDEDRItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDRITEMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSDEDRItem pSDEDRItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRItem.isPSDEIdDirty() && !bl2 : !pSDEDRItem.isPSDEIdDirty()) {
            return null;
        }
        String string = pSDEDRItem.getPSDEId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default(pSDEDRItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEOPPrivId(boolean bl, PSDEDRItem pSDEDRItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRItem.isPSDEOPPrivIdDirty() : !pSDEDRItem.isPSDEOPPrivIdDirty()) {
            return null;
        }
        String string = pSDEDRItem.getPSDEOPPrivId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEOPPrivId_Default(pSDEDRItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDERId(boolean bl, PSDEDRItem pSDEDRItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRItem.isPSDERIdDirty() : !pSDEDRItem.isPSDERIdDirty()) {
            return null;
        }
        String string = pSDEDRItem.getPSDERId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDERId_Default(pSDEDRItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEViewBaseId(boolean bl, PSDEDRItem pSDEDRItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRItem.isPSDEViewBaseIdDirty() : !pSDEDRItem.isPSDEViewBaseIdDirty()) {
            return null;
        }
        String string = pSDEDRItem.getPSDEViewBaseId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEViewBaseId_Default(pSDEDRItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDynaInstId(boolean bl, PSDEDRItem pSDEDRItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRItem.isPSDynaInstIdDirty() : !pSDEDRItem.isPSDynaInstIdDirty()) {
            return null;
        }
        String string = pSDEDRItem.getPSDynaInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaInstId_Default(pSDEDRItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysCssId(boolean bl, PSDEDRItem pSDEDRItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRItem.isPSSysCssIdDirty() : !pSDEDRItem.isPSSysCssIdDirty()) {
            return null;
        }
        String string = pSDEDRItem.getPSSysCssId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysCssId_Default(pSDEDRItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysImageId(boolean bl, PSDEDRItem pSDEDRItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRItem.isPSSysImageIdDirty() : !pSDEDRItem.isPSSysImageIdDirty()) {
            return null;
        }
        String string = pSDEDRItem.getPSSysImageId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysImageId_Default(pSDEDRItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysPDTViewId(boolean bl, PSDEDRItem pSDEDRItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRItem.isPSSysPDTViewIdDirty() : !pSDEDRItem.isPSSysPDTViewIdDirty()) {
            return null;
        }
        String string = pSDEDRItem.getPSSysPDTViewId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysPDTViewId_Default(pSDEDRItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSPDTVIEWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysUniResId(boolean bl, PSDEDRItem pSDEDRItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRItem.isPSSysUniResIdDirty() : !pSDEDRItem.isPSSysUniResIdDirty()) {
            return null;
        }
        String string = pSDEDRItem.getPSSysUniResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysUniResId_Default(pSDEDRItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_SRFSysPub(boolean bl, PSDEDRItem pSDEDRItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRItem.isSRFSysPubDirty() : !pSDEDRItem.isSRFSysPubDirty()) {
            return null;
        }
        Integer n = pSDEDRItem.getSRFSysPub();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SRFSysPub_Default(pSDEDRItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_TestCustomCode(boolean bl, PSDEDRItem pSDEDRItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRItem.isTestCustomCodeDirty() : !pSDEDRItem.isTestCustomCodeDirty()) {
            return null;
        }
        String string = pSDEDRItem.getTestCustomCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TestCustomCode_Default(pSDEDRItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TESTCUSTOMCODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TestCustomMode(boolean bl, PSDEDRItem pSDEDRItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRItem.isTestCustomModeDirty() : !pSDEDRItem.isTestCustomModeDirty()) {
            return null;
        }
        Integer n = pSDEDRItem.getTestCustomMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_TestCustomMode_Default(pSDEDRItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TESTCUSTOMMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TestPSDEActionId(boolean bl, PSDEDRItem pSDEDRItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRItem.isTestPSDEActionIdDirty() : !pSDEDRItem.isTestPSDEActionIdDirty()) {
            return null;
        }
        String string = pSDEDRItem.getTestPSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TestPSDEActionId_TestPSDEAction(pSDEDRItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TESTPSDEACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
            string2 = this.onTestValueRule_TestPSDEActionId_Default(pSDEDRItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TESTPSDEACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TestPSDELogicId(boolean bl, PSDEDRItem pSDEDRItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRItem.isTestPSDELogicIdDirty() : !pSDEDRItem.isTestPSDELogicIdDirty()) {
            return null;
        }
        String string = pSDEDRItem.getTestPSDELogicId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TestPSDELogicId_Default(pSDEDRItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TESTPSDELOGICID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TipPSLanResId(boolean bl, PSDEDRItem pSDEDRItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRItem.isTipPSLanResIdDirty() : !pSDEDRItem.isTipPSLanResIdDirty()) {
            return null;
        }
        String string = pSDEDRItem.getTipPSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TipPSLanResId_Default(pSDEDRItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TIPPSLANRESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TipPSLanResName(boolean bl, PSDEDRItem pSDEDRItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRItem.isTipPSLanResNameDirty() : !pSDEDRItem.isTipPSLanResNameDirty()) {
            return null;
        }
        String string = pSDEDRItem.getTipPSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TipPSLanResName_Default(pSDEDRItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TIPPSLANRESNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TooltipInfo(boolean bl, PSDEDRItem pSDEDRItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRItem.isTooltipInfoDirty() : !pSDEDRItem.isTooltipInfoDirty()) {
            return null;
        }
        String string = pSDEDRItem.getTooltipInfo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TooltipInfo_Default(pSDEDRItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TOOLTIPINFO");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSDEDRItem pSDEDRItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRItem.isUserCatDirty() : !pSDEDRItem.isUserCatDirty()) {
            return null;
        }
        String string = pSDEDRItem.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSDEDRItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDEDRItem pSDEDRItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRItem.isUserTagDirty() : !pSDEDRItem.isUserTagDirty()) {
            return null;
        }
        String string = pSDEDRItem.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSDEDRItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDEDRItem pSDEDRItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRItem.isUserTag2Dirty() : !pSDEDRItem.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDEDRItem.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSDEDRItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDEDRItem pSDEDRItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRItem.isUserTag3Dirty() : !pSDEDRItem.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDEDRItem.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSDEDRItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDEDRItem pSDEDRItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRItem.isUserTag4Dirty() : !pSDEDRItem.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDEDRItem.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSDEDRItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_ViewParams(boolean bl, PSDEDRItem pSDEDRItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRItem.isViewParamsDirty() : !pSDEDRItem.isViewParamsDirty()) {
            return null;
        }
        String string = pSDEDRItem.getViewParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ViewParams_Default(pSDEDRItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_ViewPSDEId(boolean bl, PSDEDRItem pSDEDRItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRItem.isViewPSDEIdDirty() : !pSDEDRItem.isViewPSDEIdDirty()) {
            return null;
        }
        String string = pSDEDRItem.getViewPSDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ViewPSDEId_Default(pSDEDRItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VIEWPSDEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDEDRItem pSDEDRItem, boolean bl) throws Exception {
        super.onSyncEntity(pSDEDRItem, bl);
    }

    protected void onSyncIndexEntities(PSDEDRItem pSDEDRItem, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDEDRItem, bl);
    }

    public Object getDataContextValue(PSDEDRItem pSDEDRItem, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null && StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDEVIEWBASE", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"PSDEVIEWBASEID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"PSDEVIEWBASENAME", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"VIEWCODENAME", (boolean)true) == 0) && (object = super.getDataContextValue(pSDEDRItem, "viewpsdeid", iDataContextParam)) != null) {
            return object;
        }
        object = super.getDataContextValue(pSDEDRItem, string, iDataContextParam);
        if (object != null) {
            return object;
        }
        PSDataEntity pSDataEntity = pSDEDRItem.getPSDE();
        if (pSDataEntity != null && pSDataEntity.contains(string)) {
            return pSDataEntity.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDEDRItem pSDEDRItem, ArrayList<JSONObject> arrayList, int n) throws Exception {
        this.onExportMajorModel_CapPSLanRes(pSDEDRItem, arrayList, n);
        super.onExportMajorModel(pSDEDRItem, arrayList, n);
    }

    protected void onExportMajorModel_CapPSLanRes(PSDEDRItem pSDEDRItem, ArrayList<JSONObject> arrayList, int n) throws Exception {
        if (pSDEDRItem.getCapPSLanRes() != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            iService.exportModel(pSDEDRItem.getCapPSLanRes(), arrayList, n);
        }
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CAPPSLANRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CapPSLanResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CAPPSLANRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CapPSLanResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"COUNTERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CounterId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"COUNTERMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CounterMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DATA", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Data_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DRITEMTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DRItemType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DYNAMODELFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaModelFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HEADERPSSYSPFPLUGINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HeaderPSSysPFPluginId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HEADERPSSYSPFPLUGINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HeaderPSSysPFPluginName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ITEMTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ItemTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ITEMTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ItemTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOCKFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LockFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MINORPSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MinorPSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NAVVIEWFILTER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NavViewFilter_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NAVVIEWFILTERDESC", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NavViewFilterDesc_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PDTVIEWFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PDTViewFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDRGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDRGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDRGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDRGroupName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDRITEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDRItemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDRITEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDRItemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSDYNAINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSCSSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysCssId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSCSSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysCssName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSIMAGEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysImageId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSIMAGENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysImageName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSPDTVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysPDTViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSPDTVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysPDTViewName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSUNIRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysUniResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSUNIRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysUniResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SRFSYSPUB", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SRFSysPub_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TESTCUSTOMCODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TestCustomCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TESTCUSTOMMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TestCustomMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TESTPSDEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"TESTPSDEACTION", (boolean)true) == 0) {
            return this.onTestValueRule_TestPSDEActionId_TestPSDEAction(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TESTPSDEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TestPSDEActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TESTPSDEACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TestPSDEActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TESTPSDELOGICID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TestPSDELogicId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TESTPSDELOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TestPSDELogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TIPPSLANRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TipPSLanResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TIPPSLANRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TipPSLanResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TOOLTIPINFO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TooltipInfo_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"VIEWCODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ViewCodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VIEWPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ViewParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VIEWPSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ViewPSDEId_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
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

    protected String onTestValueRule_CounterId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("COUNTERID", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CounterMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_Data_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DATA", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DRItemType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DRITEMTYPE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DynaModelFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ENABLEMODE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_HeaderPSSysPFPluginId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("HEADERPSSYSPFPLUGINID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_HeaderPSSysPFPluginName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("HEADERPSSYSPFPLUGINNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ItemTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ITEMTAG", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ItemTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ITEMTAG2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_MinorPSDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MINORPSDEID", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
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

    protected String onTestValueRule_NavViewFilterDesc_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NAVVIEWFILTERDESC", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PDTViewFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSDEDRGroupId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDRGROUPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDRGroupName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDRGROUPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDRItemId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDRITEMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDRItemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDRITEMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSDERId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDERName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSysPDTViewId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSPDTVIEWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysPDTViewName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSPDTVIEWNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_SRFSysPub_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_TestCustomCode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TESTCUSTOMCODE", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TestCustomMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_TestPSDEActionId_TestPSDEAction(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldDataSetRule("TESTPSDEACTIONID", "PSDEACTION", DATASET_CURDE, iEntity, bl2, null, null, "\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d", true)) {
                return null;
            }
            return "\u5224\u65ad\u542f\u7528\u5b9e\u4f53\u884c\u4e3a\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TestPSDEActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TESTPSDEACTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TestPSDEActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TESTPSDEACTIONNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TestPSDELogicId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TESTPSDELOGICID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TestPSDELogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TESTPSDELOGICNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TipPSLanResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TIPPSLANRESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TipPSLanResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TIPPSLANRESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TooltipInfo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TOOLTIPINFO", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
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

    protected String onTestValueRule_ViewCodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VIEWCODENAME", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ViewParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VIEWPARAMS", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ViewPSDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VIEWPSDEID", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSDEDRItem pSDEDRItem) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDEDRItem)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDEDRItem pSDEDRItem) throws Exception {
        IService iService;
        Object object = pSDEDRItem.get("PSDEID");
        if (object != null) {
            iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSDEDRITEM_PSDATAENTITY_PSDEID", object);
        }
        if ((object = pSDEDRItem.get("PSDERID")) != null) {
            iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDERService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSDEDRITEM_PSDER_PSDERID", object);
        }
        super.onUpdateParent(pSDEDRItem);
    }

    protected boolean isNeedUpdateParent() {
        return true;
    }

    @Override
    protected void exportCurXmlModel(PSDEDRItem pSDEDRItem, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEDRITEM");
        if (!bl) {
            pSDEDRItem.setCreateDate(null);
            pSDEDRItem.setCreateMan(null);
            pSDEDRItem.setPSDEDRItemId(null);
            pSDEDRItem.setUpdateDate(null);
            pSDEDRItem.setUpdateMan(null);
            super.exportCurXmlModel(pSDEDRItem, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDEDRItem pSDEDRItem, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDEDRItem, string);
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
            return "DER1N_PSDEDRITEM_PSDATAENTITY_PSDEID";
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
    public String getModelV2Tag(PSDEDRItem pSDEDRItem) {
        if (!StringHelper.isNullOrEmpty((String)pSDEDRItem.getCodeName())) {
            return pSDEDRItem.getCodeName();
        }
        return super.getModelV2Tag(pSDEDRItem);
    }

    @Override
    public boolean setModelV2Tag(PSDEDRItem pSDEDRItem, String string) {
        pSDEDRItem.setCodeName(string);
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
    public boolean getModelV2Entity(PSDEDRItem pSDEDRItem, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDEDRItem.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDEDRItem, true);
        pSDEDRItem.set("CODENAME", string);
        if (this.select(pSDEDRItem, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSDEDRItem, true);
        return super.getModelV2Entity(pSDEDRItem, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDEDRItem pSDEDRItem, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSDEDRItem, objectNode, string, string2, n);
    }

    @Override
    public Object getDataType(PSDEDRItem pSDEDRItem) throws Exception {
        return pSDEDRItem.getDRItemType();
    }

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSDEDRItem pSDEDRItem, boolean bl) {
        return defaultValueMap;
    }

    static {
        defaultValueMap.put("CODENAME", "DRItem");
    }
}

