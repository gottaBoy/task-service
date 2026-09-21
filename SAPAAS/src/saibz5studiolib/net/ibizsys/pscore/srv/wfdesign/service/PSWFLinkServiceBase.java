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
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEForm;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFormBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBaseBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeList;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeListBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageResBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.ibizsys.pscore.srv.wfdesign.dao.PSWFLinkDAO;
import net.ibizsys.pscore.srv.wfdesign.demodel.PSWFLinkDEModel;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFLink;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFLinkCond;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFLinkCondBase;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFLinkRole;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFLinkRoleBase;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFProcess;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFProcessBase;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFRole;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFRoleBase;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFVersion;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFVersionBase;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWorkflow;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWorkflowBase;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFLinkCondService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFLinkCondServiceBase;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFLinkRoleService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFLinkRoleServiceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSWFLinkServiceBase
extends PSCoreSysServiceBase<PSWFLink> {
    private static final Log log = LogFactory.getLog(PSWFLinkServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String DATASET_IA = "IA";
    public static final String ACTION_CREATEWITHMODEL = "CreateWithModel";
    public static final String ACTION_GETWITHMODEL = "GetWithModel";
    public static final String ACTION_UPDATEWITHMODEL = "UpdateWithModel";
    private PSWFLinkDEModel pSWFLinkDEModel;
    private PSWFLinkDAO pSWFLinkDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.wfdesign.service.PSWFLinkService";
    }

    public PSWFLinkDEModel getPSWFLinkDEModel() {
        if (this.pSWFLinkDEModel == null) {
            try {
                this.pSWFLinkDEModel = (PSWFLinkDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.wfdesign.demodel.PSWFLinkDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSWFLinkDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSWFLinkDEModel();
    }

    public PSWFLinkDAO getPSWFLinkDAO() {
        if (this.pSWFLinkDAO == null) {
            try {
                this.pSWFLinkDAO = (PSWFLinkDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.wfdesign.dao.PSWFLinkDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSWFLinkDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSWFLinkDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
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
        if (StringHelper.compare((String)string, (String)DATASET_IA, (boolean)true) == 0) {
            return this.fetchTempIA(iDEDataSetFetchContext);
        }
        return super.onfetchDataSetTemp(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_CREATEWITHMODEL, (boolean)true) == 0) {
            this.createWithModel((PSWFLink)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_GETWITHMODEL, (boolean)true) == 0) {
            this.getWithModel((PSWFLink)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_UPDATEWITHMODEL, (boolean)true) == 0) {
            this.updateWithModel((PSWFLink)iEntity);
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

    public DBFetchResult fetchIA(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_IA, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempIA(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_IA, true);
        return dBFetchResult;
    }

    public void createWithModel(PSWFLink pSWFLink) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_CREATEWITHMODEL, 0, (IEntity)pSWFLink, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSWFLink, ACTION_CREATEWITHMODEL);
        final PSWFLink pSWFLink2 = pSWFLink;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSWFLinkServiceBase.this.getService(), PSWFLinkServiceBase.ACTION_CREATEWITHMODEL, 40, (IEntity)pSWFLink2, null).getResult() != 1) {
                    PSWFLinkServiceBase.this.onCreateWithModel(pSWFLink2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_CREATEWITHMODEL, 99, (IEntity)pSWFLink, null);
        }
    }

    protected void onCreateWithModel(PSWFLink pSWFLink) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[CreateWithModel]");
    }

    public void getWithModel(PSWFLink pSWFLink) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_GETWITHMODEL, 0, (IEntity)pSWFLink, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSWFLink, ACTION_GETWITHMODEL);
        final PSWFLink pSWFLink2 = pSWFLink;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSWFLinkServiceBase.this.getService(), PSWFLinkServiceBase.ACTION_GETWITHMODEL, 40, (IEntity)pSWFLink2, null).getResult() != 1) {
                    PSWFLinkServiceBase.this.onGetWithModel(pSWFLink2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_GETWITHMODEL, 99, (IEntity)pSWFLink, null);
        }
    }

    protected void onGetWithModel(PSWFLink pSWFLink) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[GetWithModel]");
    }

    public void updateWithModel(PSWFLink pSWFLink) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_UPDATEWITHMODEL, 0, (IEntity)pSWFLink, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSWFLink, ACTION_UPDATEWITHMODEL);
        final PSWFLink pSWFLink2 = pSWFLink;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSWFLinkServiceBase.this.getService(), PSWFLinkServiceBase.ACTION_UPDATEWITHMODEL, 40, (IEntity)pSWFLink2, null).getResult() != 1) {
                    PSWFLinkServiceBase.this.onUpdateWithModel(pSWFLink2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_UPDATEWITHMODEL, 99, (IEntity)pSWFLink, null);
        }
    }

    protected void onUpdateWithModel(PSWFLink pSWFLink) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[UpdateWithModel]");
    }

    protected void onFillParentInfo(PSWFLink pSWFLink, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFLINK_PSCODELIST_ACTIONPSCODELISTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService", (SessionFactory)this.getSessionFactory());
            PSCodeList pSCodeList = (PSCodeList)iService.getDEModel().createEntity();
            pSCodeList.set("PSCODELISTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSCodeList);
            } else {
                iService.get((IEntity)pSCodeList);
            }
            this.onFillParentInfo_ActionPSCodeList(pSWFLink, pSCodeList);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFLINK_PSDEFORM_MOBPSDEFORMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFormService", (SessionFactory)this.getSessionFactory());
            PSDEForm pSDEForm = (PSDEForm)iService.getDEModel().createEntity();
            pSDEForm.set("PSDEFORMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEForm);
            } else {
                iService.get((IEntity)pSDEForm);
            }
            this.onFillParentInfo_MobPSDEForm(pSWFLink, pSDEForm);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFLINK_PSDEFORM_PSDEFORMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFormService", (SessionFactory)this.getSessionFactory());
            PSDEForm pSDEForm = (PSDEForm)iService.getDEModel().createEntity();
            pSDEForm.set("PSDEFORMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEForm);
            } else {
                iService.get((IEntity)pSDEForm);
            }
            this.onFillParentInfo_PSDEForm(pSWFLink, pSDEForm);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFLINK_PSDEVIEWBASE_MOBPSDEVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService", (SessionFactory)this.getSessionFactory());
            PSDEViewBase pSDEViewBase = (PSDEViewBase)iService.getDEModel().createEntity();
            pSDEViewBase.set("PSDEVIEWBASEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEViewBase);
            } else {
                iService.get((IEntity)pSDEViewBase);
            }
            this.onFillParentInfo_MobPSDEView(pSWFLink, pSDEViewBase);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFLINK_PSDEVIEWBASE_PSDEVIEWBASEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService", (SessionFactory)this.getSessionFactory());
            PSDEViewBase pSDEViewBase = (PSDEViewBase)iService.getDEModel().createEntity();
            pSDEViewBase.set("PSDEVIEWBASEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEViewBase);
            } else {
                iService.get((IEntity)pSDEViewBase);
            }
            this.onFillParentInfo_PSDEViewBase(pSWFLink, pSDEViewBase);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFLINK_PSLANGUAGERES_LNPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSLanguageRes);
            } else {
                iService.get((IEntity)pSLanguageRes);
            }
            this.onFillParentInfo_LNPSLanRes(pSWFLink, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFLINK_PSLANGUAGERES_TIPPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSLanguageRes);
            } else {
                iService.get((IEntity)pSLanguageRes);
            }
            this.onFillParentInfo_TipPSLanRes(pSWFLink, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFLINK_PSWFPROCESS_FROMPSWFPROCID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfdesign.service.PSWFProcessService", (SessionFactory)this.getSessionFactory());
            PSWFProcess pSWFProcess = (PSWFProcess)iService.getDEModel().createEntity();
            pSWFProcess.set("PSWFPROCESSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSWFProcess);
            } else {
                iService.get((IEntity)pSWFProcess);
            }
            this.onFillParentInfo_FromPSWFProc(pSWFLink, pSWFProcess);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFLINK_PSWFPROCESS_TOPSWFPROCID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfdesign.service.PSWFProcessService", (SessionFactory)this.getSessionFactory());
            PSWFProcess pSWFProcess = (PSWFProcess)iService.getDEModel().createEntity();
            pSWFProcess.set("PSWFPROCESSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSWFProcess);
            } else {
                iService.get((IEntity)pSWFProcess);
            }
            this.onFillParentInfo_ToPSWFProc(pSWFLink, pSWFProcess);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFLINK_PSWFROLE_PSWFROLEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfdesign.service.PSWFRoleService", (SessionFactory)this.getSessionFactory());
            PSWFRole pSWFRole = (PSWFRole)iService.getDEModel().createEntity();
            pSWFRole.set("PSWFROLEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSWFRole);
            } else {
                iService.get((IEntity)pSWFRole);
            }
            this.onFillParentInfo_PSWFRole(pSWFLink, pSWFRole);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFLINK_PSWFVERSION_PSWFVERSIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfdesign.service.PSWFVersionService", (SessionFactory)this.getSessionFactory());
            PSWFVersion pSWFVersion = (PSWFVersion)iService.getDEModel().createEntity();
            pSWFVersion.set("PSWFVERSIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSWFVersion);
            } else {
                iService.get((IEntity)pSWFVersion);
            }
            this.onFillParentInfo_PSWFVersion(pSWFLink, pSWFVersion);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFLINK_PSWORKFLOW_PSWFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfdesign.service.PSWorkflowService", (SessionFactory)this.getSessionFactory());
            PSWorkflow pSWorkflow = (PSWorkflow)iService.getDEModel().createEntity();
            pSWorkflow.set("PSWORKFLOWID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSWorkflow);
            } else {
                iService.get((IEntity)pSWorkflow);
            }
            this.onFillParentInfo_PSWF(pSWFLink, pSWorkflow);
            return;
        }
        super.onFillParentInfo((IEntity)pSWFLink, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        if (StringHelper.compare((String)string, (String)"DER1N_PSWFLINK_PSWFVERSION_PSWFVERSIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfdesign.service.PSWFVersionService", (SessionFactory)this.getSessionFactory());
            PSWFVersion pSWFVersion = (PSWFVersion)iService.getDEModel().createEntity();
            pSWFVersion.set("PSWFVERSIONID", string2);
            return this.onSyncDER1NData_PSWFVersion(pSWFVersion, string3);
        }
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_ActionPSCodeList(PSWFLink pSWFLink, PSCodeList pSCodeList) throws Exception {
        pSWFLink.setActionPSCodeListId(pSCodeList.getPSCodeListId());
        pSWFLink.setActionPSCodeListName(pSCodeList.getPSCodeListName());
    }

    protected void onFillParentInfo_MobPSDEForm(PSWFLink pSWFLink, PSDEForm pSDEForm) throws Exception {
        pSWFLink.setMobFormCodeName(pSDEForm.getCodeName());
        pSWFLink.setMobPSDEFormId(pSDEForm.getPSDEFormId());
        pSWFLink.setMobPSDEFormName(pSDEForm.getPSDEFormName());
    }

    protected void onFillParentInfo_PSDEForm(PSWFLink pSWFLink, PSDEForm pSDEForm) throws Exception {
        pSWFLink.setFormCodeName(pSDEForm.getCodeName());
        pSWFLink.setPSDEFormId(pSDEForm.getPSDEFormId());
        pSWFLink.setPSDEFormName(pSDEForm.getPSDEFormName());
    }

    protected void onFillParentInfo_MobPSDEView(PSWFLink pSWFLink, PSDEViewBase pSDEViewBase) throws Exception {
        pSWFLink.setMobPSDEViewId(pSDEViewBase.getPSDEViewBaseId());
        pSWFLink.setMobPSDEViewName(pSDEViewBase.getPSDEViewBaseName());
        pSWFLink.setMobViewCodeName(pSDEViewBase.getCodeName());
    }

    protected void onFillParentInfo_PSDEViewBase(PSWFLink pSWFLink, PSDEViewBase pSDEViewBase) throws Exception {
        pSWFLink.setPSDEViewBaseId(pSDEViewBase.getPSDEViewBaseId());
        pSWFLink.setPSDEViewBaseName(pSDEViewBase.getPSDEViewBaseName());
        pSWFLink.setViewCodeName(pSDEViewBase.getCodeName());
    }

    protected void onFillParentInfo_LNPSLanRes(PSWFLink pSWFLink, PSLanguageRes pSLanguageRes) throws Exception {
        pSWFLink.setLNPSLanResId(pSLanguageRes.getPSLanguageResId());
        pSWFLink.setLNPSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_TipPSLanRes(PSWFLink pSWFLink, PSLanguageRes pSLanguageRes) throws Exception {
        pSWFLink.setTipPSLanResId(pSLanguageRes.getPSLanguageResId());
        pSWFLink.setTipPSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_FromPSWFProc(PSWFLink pSWFLink, PSWFProcess pSWFProcess) throws Exception {
        pSWFLink.setFromPSWFProcId(pSWFProcess.getPSWFProcessId());
        pSWFLink.setFromPSWFProcName(pSWFProcess.getPSWFProcessName());
        pSWFLink.setPSDEId(pSWFProcess.getPSDEId());
        pSWFLink.setPSWFDEId(pSWFProcess.getPSWFDEId());
    }

    protected void onFillParentInfo_ToPSWFProc(PSWFLink pSWFLink, PSWFProcess pSWFProcess) throws Exception {
        pSWFLink.setToPSWFProcId(pSWFProcess.getPSWFProcessId());
        pSWFLink.setToPSWFProcName(pSWFProcess.getPSWFProcessName());
    }

    protected void onFillParentInfo_PSWFRole(PSWFLink pSWFLink, PSWFRole pSWFRole) throws Exception {
        pSWFLink.setPSWFRoleId(pSWFRole.getPSWFRoleId());
        pSWFLink.setPSWFRoleName(pSWFRole.getPSWFRoleName());
    }

    protected void onFillParentInfo_PSWFVersion(PSWFLink pSWFLink, PSWFVersion pSWFVersion) throws Exception {
        pSWFLink.setPSSystemId(pSWFVersion.getPSSystemId());
        pSWFLink.setPSWFVersionId(pSWFVersion.getPSWFVersionId());
        pSWFLink.setPSWFVersionName(pSWFVersion.getPSWFVersionName());
        pSWFLink.setWFEngineType(pSWFVersion.getWFEngineType());
        if (pSWFVersion.getPSWF() != null) {
            this.onFillParentInfo_PSWF(pSWFLink, pSWFVersion.getPSWF());
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
            ArrayList<PSWFLink> arrayList = this.selectByPSWFVersion(pSWFVersion);
            for (PSWFLink pSWFLink : arrayList) {
                if (hashMap.containsKey(DataObject.getStringValue((IDataObject)pSWFLink, (String)"PSWFLINKID", (String)""))) continue;
                this.remove((IEntity)pSWFLink);
            }
        }
        return null;
    }

    protected void onFillParentInfo_PSWF(PSWFLink pSWFLink, PSWorkflow pSWorkflow) throws Exception {
        pSWFLink.setPSWFId(pSWorkflow.getPSWorkflowId());
        pSWFLink.setPSWFName(pSWorkflow.getPSWorkflowName());
    }

    protected void onFillEntityFullInfo(PSWFLink pSWFLink, boolean bl) throws Exception {
        if (bl) {
            if (pSWFLink.getCustomCondFlag() == null) {
                pSWFLink.setCustomCondFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSWFLink.getDefaultLink() == null) {
                pSWFLink.setDefaultLink((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSWFLink.getEnable() == null) {
                pSWFLink.setEnable((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
            if (pSWFLink.getSomeRoleFlag() == null) {
                pSWFLink.setSomeRoleFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
        }
        super.onFillEntityFullInfo((IEntity)pSWFLink, bl);
        this.onFillEntityFullInfo_ActionPSCodeList(pSWFLink, bl);
        this.onFillEntityFullInfo_MobPSDEForm(pSWFLink, bl);
        this.onFillEntityFullInfo_PSDEForm(pSWFLink, bl);
        this.onFillEntityFullInfo_MobPSDEView(pSWFLink, bl);
        this.onFillEntityFullInfo_PSDEViewBase(pSWFLink, bl);
        this.onFillEntityFullInfo_LNPSLanRes(pSWFLink, bl);
        this.onFillEntityFullInfo_TipPSLanRes(pSWFLink, bl);
        this.onFillEntityFullInfo_FromPSWFProc(pSWFLink, bl);
        this.onFillEntityFullInfo_ToPSWFProc(pSWFLink, bl);
        this.onFillEntityFullInfo_PSWFRole(pSWFLink, bl);
        this.onFillEntityFullInfo_PSWFVersion(pSWFLink, bl);
        this.onFillEntityFullInfo_PSWF(pSWFLink, bl);
    }

    protected void onFillEntityFullInfo_ActionPSCodeList(PSWFLink pSWFLink, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_MobPSDEForm(PSWFLink pSWFLink, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEForm(PSWFLink pSWFLink, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_MobPSDEView(PSWFLink pSWFLink, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEViewBase(PSWFLink pSWFLink, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_LNPSLanRes(PSWFLink pSWFLink, boolean bl) throws Exception {
        if (pSWFLink.isLNPSLanResIdDirty()) {
            if (pSWFLink.getLNPSLanResId() != null) {
                if (pSWFLink.getLNPSLanResId() == null || pSWFLink.getLNPSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSWFLink.getLNPSLanRes();
                    pSWFLink.setLNPSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSWFLink.setLNPSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_TipPSLanRes(PSWFLink pSWFLink, boolean bl) throws Exception {
        if (pSWFLink.isTipPSLanResIdDirty()) {
            if (pSWFLink.getTipPSLanResId() != null) {
                if (pSWFLink.getTipPSLanResId() == null || pSWFLink.getTipPSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSWFLink.getTipPSLanRes();
                    pSWFLink.setTipPSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSWFLink.setTipPSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_FromPSWFProc(PSWFLink pSWFLink, boolean bl) throws Exception {
        if (pSWFLink.isFromPSWFProcIdDirty()) {
            if (pSWFLink.getFromPSWFProcId() != null) {
                if (pSWFLink.getFromPSWFProcId() == null || pSWFLink.getFromPSWFProcName() == null) {
                    PSWFProcess pSWFProcess = pSWFLink.getFromPSWFProc();
                    pSWFLink.setFromPSWFProcName(pSWFProcess.getPSWFProcessName());
                    pSWFLink.setPSDEId(pSWFProcess.getPSDEId());
                    pSWFLink.setPSWFDEId(pSWFProcess.getPSWFDEId());
                }
            } else {
                pSWFLink.setFromPSWFProcName(null);
                pSWFLink.setPSDEId(null);
                pSWFLink.setPSWFDEId(null);
            }
        }
    }

    protected void onFillEntityFullInfo_ToPSWFProc(PSWFLink pSWFLink, boolean bl) throws Exception {
        if (pSWFLink.isToPSWFProcIdDirty()) {
            if (pSWFLink.getToPSWFProcId() != null) {
                if (pSWFLink.getToPSWFProcId() == null || pSWFLink.getToPSWFProcName() == null) {
                    PSWFProcess pSWFProcess = pSWFLink.getToPSWFProc();
                    pSWFLink.setToPSWFProcName(pSWFProcess.getPSWFProcessName());
                }
            } else {
                pSWFLink.setToPSWFProcName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSWFRole(PSWFLink pSWFLink, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSWFVersion(PSWFLink pSWFLink, boolean bl) throws Exception {
        if (pSWFLink.isPSWFVersionIdDirty()) {
            if (pSWFLink.getPSWFVersionId() != null) {
                PSWFVersion pSWFVersion;
                if (pSWFLink.getPSWFVersionId() == null || pSWFLink.getPSWFVersionName() == null) {
                    pSWFVersion = pSWFLink.getPSWFVersion();
                    pSWFLink.setPSSystemId(pSWFVersion.getPSSystemId());
                    pSWFLink.setPSWFVersionName(pSWFVersion.getPSWFVersionName());
                    pSWFLink.setWFEngineType(pSWFVersion.getWFEngineType());
                }
                pSWFVersion = pSWFLink.getPSWFVersion();
                if (DataTypeHelper.compare((int)25, (Object)pSWFVersion.getPSWFId(), (Object)pSWFLink.getPSWFId()) != 0L) {
                    pSWFLink.setPSWFId(pSWFVersion.getPSWFId());
                    this.onFillEntityFullInfo_PSWF(pSWFLink, bl);
                }
            } else {
                pSWFLink.setPSSystemId(null);
                pSWFLink.setPSWFVersionName(null);
                pSWFLink.setWFEngineType(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSWF(PSWFLink pSWFLink, boolean bl) throws Exception {
        if (pSWFLink.isPSWFIdDirty()) {
            if (pSWFLink.getPSWFId() != null) {
                if (pSWFLink.getPSWFId() == null || pSWFLink.getPSWFName() == null) {
                    PSWorkflow pSWorkflow = pSWFLink.getPSWF();
                    pSWFLink.setPSWFName(pSWorkflow.getPSWorkflowName());
                }
            } else {
                pSWFLink.setPSWFName(null);
            }
        }
    }

    protected void onWriteBackParent(PSWFLink pSWFLink, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSWFLink, bl);
    }

    public ArrayList<PSWFLink> selectByActionPSCodeList(PSCodeListBase pSCodeListBase) throws Exception {
        return this.selectByActionPSCodeList(pSCodeListBase, "", -1);
    }

    public ArrayList<PSWFLink> selectByActionPSCodeList(PSCodeListBase pSCodeListBase, String string) throws Exception {
        return this.selectByActionPSCodeList(pSCodeListBase, string, -1);
    }

    public ArrayList<PSWFLink> selectByActionPSCodeList(PSCodeListBase pSCodeListBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("ACTIONPSCODELISTID", (Object)pSCodeListBase.getPSCodeListId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByActionPSCodeListCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByActionPSCodeListCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWFLink> selectByMobPSDEForm(PSDEFormBase pSDEFormBase) throws Exception {
        return this.selectByMobPSDEForm(pSDEFormBase, "", -1);
    }

    public ArrayList<PSWFLink> selectByMobPSDEForm(PSDEFormBase pSDEFormBase, String string) throws Exception {
        return this.selectByMobPSDEForm(pSDEFormBase, string, -1);
    }

    public ArrayList<PSWFLink> selectByMobPSDEForm(PSDEFormBase pSDEFormBase, String string, int n) throws Exception {
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

    public ArrayList<PSWFLink> selectByPSDEForm(PSDEFormBase pSDEFormBase) throws Exception {
        return this.selectByPSDEForm(pSDEFormBase, "", -1);
    }

    public ArrayList<PSWFLink> selectByPSDEForm(PSDEFormBase pSDEFormBase, String string) throws Exception {
        return this.selectByPSDEForm(pSDEFormBase, string, -1);
    }

    public ArrayList<PSWFLink> selectByPSDEForm(PSDEFormBase pSDEFormBase, String string, int n) throws Exception {
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

    public ArrayList<PSWFLink> selectByMobPSDEView(PSDEViewBaseBase pSDEViewBaseBase) throws Exception {
        return this.selectByMobPSDEView(pSDEViewBaseBase, "", -1);
    }

    public ArrayList<PSWFLink> selectByMobPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string) throws Exception {
        return this.selectByMobPSDEView(pSDEViewBaseBase, string, -1);
    }

    public ArrayList<PSWFLink> selectByMobPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string, int n) throws Exception {
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

    public ArrayList<PSWFLink> selectByPSDEViewBase(PSDEViewBaseBase pSDEViewBaseBase) throws Exception {
        return this.selectByPSDEViewBase(pSDEViewBaseBase, "", -1);
    }

    public ArrayList<PSWFLink> selectByPSDEViewBase(PSDEViewBaseBase pSDEViewBaseBase, String string) throws Exception {
        return this.selectByPSDEViewBase(pSDEViewBaseBase, string, -1);
    }

    public ArrayList<PSWFLink> selectByPSDEViewBase(PSDEViewBaseBase pSDEViewBaseBase, String string, int n) throws Exception {
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

    public ArrayList<PSWFLink> selectByLNPSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByLNPSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSWFLink> selectByLNPSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByLNPSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSWFLink> selectByLNPSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
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

    public ArrayList<PSWFLink> selectByTipPSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByTipPSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSWFLink> selectByTipPSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByTipPSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSWFLink> selectByTipPSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
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

    public ArrayList<PSWFLink> selectByFromPSWFProc(PSWFProcessBase pSWFProcessBase) throws Exception {
        return this.selectByFromPSWFProc(pSWFProcessBase, "", -1);
    }

    public ArrayList<PSWFLink> selectByFromPSWFProc(PSWFProcessBase pSWFProcessBase, String string) throws Exception {
        return this.selectByFromPSWFProc(pSWFProcessBase, string, -1);
    }

    public ArrayList<PSWFLink> selectByFromPSWFProc(PSWFProcessBase pSWFProcessBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("FROMPSWFPROCID", (Object)pSWFProcessBase.getPSWFProcessId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByFromPSWFProcCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByFromPSWFProcCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWFLink> selectTempByFromPSWFProc(PSWFProcessBase pSWFProcessBase) throws Exception {
        return this.selectTempByFromPSWFProc(pSWFProcessBase, "");
    }

    public ArrayList<PSWFLink> selectTempByFromPSWFProc(PSWFProcessBase pSWFProcessBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("FROMPSWFPROCID", (Object)pSWFProcessBase.getPSWFProcessId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByFromPSWFProcCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByFromPSWFProcCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWFLink> selectByToPSWFProc(PSWFProcessBase pSWFProcessBase) throws Exception {
        return this.selectByToPSWFProc(pSWFProcessBase, "", -1);
    }

    public ArrayList<PSWFLink> selectByToPSWFProc(PSWFProcessBase pSWFProcessBase, String string) throws Exception {
        return this.selectByToPSWFProc(pSWFProcessBase, string, -1);
    }

    public ArrayList<PSWFLink> selectByToPSWFProc(PSWFProcessBase pSWFProcessBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("TOPSWFPROCID", (Object)pSWFProcessBase.getPSWFProcessId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByToPSWFProcCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByToPSWFProcCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWFLink> selectTempByToPSWFProc(PSWFProcessBase pSWFProcessBase) throws Exception {
        return this.selectTempByToPSWFProc(pSWFProcessBase, "");
    }

    public ArrayList<PSWFLink> selectTempByToPSWFProc(PSWFProcessBase pSWFProcessBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("TOPSWFPROCID", (Object)pSWFProcessBase.getPSWFProcessId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByToPSWFProcCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByToPSWFProcCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWFLink> selectByPSWFRole(PSWFRoleBase pSWFRoleBase) throws Exception {
        return this.selectByPSWFRole(pSWFRoleBase, "", -1);
    }

    public ArrayList<PSWFLink> selectByPSWFRole(PSWFRoleBase pSWFRoleBase, String string) throws Exception {
        return this.selectByPSWFRole(pSWFRoleBase, string, -1);
    }

    public ArrayList<PSWFLink> selectByPSWFRole(PSWFRoleBase pSWFRoleBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSWFROLEID", (Object)pSWFRoleBase.getPSWFRoleId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSWFRoleCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSWFRoleCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWFLink> selectByPSWFVersion(PSWFVersionBase pSWFVersionBase) throws Exception {
        return this.selectByPSWFVersion(pSWFVersionBase, "", -1);
    }

    public ArrayList<PSWFLink> selectByPSWFVersion(PSWFVersionBase pSWFVersionBase, String string) throws Exception {
        return this.selectByPSWFVersion(pSWFVersionBase, string, -1);
    }

    public ArrayList<PSWFLink> selectByPSWFVersion(PSWFVersionBase pSWFVersionBase, String string, int n) throws Exception {
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

    public ArrayList<PSWFLink> selectTempByPSWFVersion(PSWFVersionBase pSWFVersionBase) throws Exception {
        return this.selectTempByPSWFVersion(pSWFVersionBase, "");
    }

    public ArrayList<PSWFLink> selectTempByPSWFVersion(PSWFVersionBase pSWFVersionBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSWFVERSIONID", (Object)pSWFVersionBase.getPSWFVersionId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSWFVersionCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSWFVersionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWFLink> selectByPSWF(PSWorkflowBase pSWorkflowBase) throws Exception {
        return this.selectByPSWF(pSWorkflowBase, "", -1);
    }

    public ArrayList<PSWFLink> selectByPSWF(PSWorkflowBase pSWorkflowBase, String string) throws Exception {
        return this.selectByPSWF(pSWorkflowBase, string, -1);
    }

    public ArrayList<PSWFLink> selectByPSWF(PSWorkflowBase pSWorkflowBase, String string, int n) throws Exception {
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

    public void testRemoveByActionPSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSWFLink> arrayList = this.selectByActionPSCodeList(pSCodeList, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSCODELIST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSCodeList);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWFLINK_PSCODELIST_ACTIONPSCODELISTID", "", iDataEntityModel.getName(), "PSWFLINK", iDataEntityModel.getDataInfo((IEntity)pSCodeList), arrayList.get(0)));
        }
    }

    public void resetActionPSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSWFLink> arrayList = this.selectByActionPSCodeList(pSCodeList);
        for (PSWFLink pSWFLink : arrayList) {
            PSWFLink pSWFLink2 = (PSWFLink)this.getDEModel().createEntity();
            pSWFLink2.setPSWFLinkId(pSWFLink.getPSWFLinkId());
            pSWFLink2.setActionPSCodeListId(null);
            this.update(pSWFLink2);
        }
    }

    public void removeByActionPSCodeList(PSCodeList pSCodeList) throws Exception {
        final PSCodeList pSCodeList2 = pSCodeList;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFLinkServiceBase.this.onBeforeRemoveByActionPSCodeList(pSCodeList2);
                PSWFLinkServiceBase.this.internalRemoveByActionPSCodeList(pSCodeList2);
                PSWFLinkServiceBase.this.onAfterRemoveByActionPSCodeList(pSCodeList2);
            }
        });
    }

    protected void onBeforeRemoveByActionPSCodeList(PSCodeList pSCodeList) throws Exception {
    }

    protected void internalRemoveByActionPSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSWFLink> arrayList = this.selectByActionPSCodeList(pSCodeList);
        this.onBeforeRemoveByActionPSCodeList(pSCodeList, arrayList);
        for (PSWFLink pSWFLink : arrayList) {
            this.remove((IEntity)pSWFLink);
        }
        this.onAfterRemoveByActionPSCodeList(pSCodeList, arrayList);
    }

    protected void onAfterRemoveByActionPSCodeList(PSCodeList pSCodeList) throws Exception {
    }

    protected void onBeforeRemoveByActionPSCodeList(PSCodeList pSCodeList, ArrayList<PSWFLink> arrayList) throws Exception {
    }

    protected void onAfterRemoveByActionPSCodeList(PSCodeList pSCodeList, ArrayList<PSWFLink> arrayList) throws Exception {
    }

    public void testRemoveByMobPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSWFLink> arrayList = this.selectByMobPSDEForm(pSDEForm, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFORM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEForm);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWFLINK_PSDEFORM_MOBPSDEFORMID", "", iDataEntityModel.getName(), "PSWFLINK", iDataEntityModel.getDataInfo((IEntity)pSDEForm), arrayList.get(0)));
        }
    }

    public void resetMobPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSWFLink> arrayList = this.selectByMobPSDEForm(pSDEForm);
        for (PSWFLink pSWFLink : arrayList) {
            PSWFLink pSWFLink2 = (PSWFLink)this.getDEModel().createEntity();
            pSWFLink2.setPSWFLinkId(pSWFLink.getPSWFLinkId());
            pSWFLink2.setMobPSDEFormId(null);
            this.update(pSWFLink2);
        }
    }

    public void removeByMobPSDEForm(PSDEForm pSDEForm) throws Exception {
        final PSDEForm pSDEForm2 = pSDEForm;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFLinkServiceBase.this.onBeforeRemoveByMobPSDEForm(pSDEForm2);
                PSWFLinkServiceBase.this.internalRemoveByMobPSDEForm(pSDEForm2);
                PSWFLinkServiceBase.this.onAfterRemoveByMobPSDEForm(pSDEForm2);
            }
        });
    }

    protected void onBeforeRemoveByMobPSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void internalRemoveByMobPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSWFLink> arrayList = this.selectByMobPSDEForm(pSDEForm);
        this.onBeforeRemoveByMobPSDEForm(pSDEForm, arrayList);
        for (PSWFLink pSWFLink : arrayList) {
            this.remove((IEntity)pSWFLink);
        }
        this.onAfterRemoveByMobPSDEForm(pSDEForm, arrayList);
    }

    protected void onAfterRemoveByMobPSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void onBeforeRemoveByMobPSDEForm(PSDEForm pSDEForm, ArrayList<PSWFLink> arrayList) throws Exception {
    }

    protected void onAfterRemoveByMobPSDEForm(PSDEForm pSDEForm, ArrayList<PSWFLink> arrayList) throws Exception {
    }

    public void testRemoveByPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSWFLink> arrayList = this.selectByPSDEForm(pSDEForm, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFORM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEForm);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWFLINK_PSDEFORM_PSDEFORMID", "", iDataEntityModel.getName(), "PSWFLINK", iDataEntityModel.getDataInfo((IEntity)pSDEForm), arrayList.get(0)));
        }
    }

    public void resetPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSWFLink> arrayList = this.selectByPSDEForm(pSDEForm);
        for (PSWFLink pSWFLink : arrayList) {
            PSWFLink pSWFLink2 = (PSWFLink)this.getDEModel().createEntity();
            pSWFLink2.setPSWFLinkId(pSWFLink.getPSWFLinkId());
            pSWFLink2.setPSDEFormId(null);
            this.update(pSWFLink2);
        }
    }

    public void removeByPSDEForm(PSDEForm pSDEForm) throws Exception {
        final PSDEForm pSDEForm2 = pSDEForm;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFLinkServiceBase.this.onBeforeRemoveByPSDEForm(pSDEForm2);
                PSWFLinkServiceBase.this.internalRemoveByPSDEForm(pSDEForm2);
                PSWFLinkServiceBase.this.onAfterRemoveByPSDEForm(pSDEForm2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void internalRemoveByPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSWFLink> arrayList = this.selectByPSDEForm(pSDEForm);
        this.onBeforeRemoveByPSDEForm(pSDEForm, arrayList);
        for (PSWFLink pSWFLink : arrayList) {
            this.remove((IEntity)pSWFLink);
        }
        this.onAfterRemoveByPSDEForm(pSDEForm, arrayList);
    }

    protected void onAfterRemoveByPSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void onBeforeRemoveByPSDEForm(PSDEForm pSDEForm, ArrayList<PSWFLink> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEForm(PSDEForm pSDEForm, ArrayList<PSWFLink> arrayList) throws Exception {
    }

    public void testRemoveByMobPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSWFLink> arrayList = this.selectByMobPSDEView(pSDEViewBase, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVIEWBASE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEViewBase);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWFLINK_PSDEVIEWBASE_MOBPSDEVIEWID", "", iDataEntityModel.getName(), "PSWFLINK", iDataEntityModel.getDataInfo((IEntity)pSDEViewBase), arrayList.get(0)));
        }
    }

    public void resetMobPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSWFLink> arrayList = this.selectByMobPSDEView(pSDEViewBase);
        for (PSWFLink pSWFLink : arrayList) {
            PSWFLink pSWFLink2 = (PSWFLink)this.getDEModel().createEntity();
            pSWFLink2.setPSWFLinkId(pSWFLink.getPSWFLinkId());
            pSWFLink2.setMobPSDEViewId(null);
            this.update(pSWFLink2);
        }
    }

    public void removeByMobPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        final PSDEViewBase pSDEViewBase2 = pSDEViewBase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFLinkServiceBase.this.onBeforeRemoveByMobPSDEView(pSDEViewBase2);
                PSWFLinkServiceBase.this.internalRemoveByMobPSDEView(pSDEViewBase2);
                PSWFLinkServiceBase.this.onAfterRemoveByMobPSDEView(pSDEViewBase2);
            }
        });
    }

    protected void onBeforeRemoveByMobPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void internalRemoveByMobPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSWFLink> arrayList = this.selectByMobPSDEView(pSDEViewBase);
        this.onBeforeRemoveByMobPSDEView(pSDEViewBase, arrayList);
        for (PSWFLink pSWFLink : arrayList) {
            this.remove((IEntity)pSWFLink);
        }
        this.onAfterRemoveByMobPSDEView(pSDEViewBase, arrayList);
    }

    protected void onAfterRemoveByMobPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void onBeforeRemoveByMobPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSWFLink> arrayList) throws Exception {
    }

    protected void onAfterRemoveByMobPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSWFLink> arrayList) throws Exception {
    }

    public void testRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSWFLink> arrayList = this.selectByPSDEViewBase(pSDEViewBase, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVIEWBASE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEViewBase);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWFLINK_PSDEVIEWBASE_PSDEVIEWBASEID", "", iDataEntityModel.getName(), "PSWFLINK", iDataEntityModel.getDataInfo((IEntity)pSDEViewBase), arrayList.get(0)));
        }
    }

    public void resetPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSWFLink> arrayList = this.selectByPSDEViewBase(pSDEViewBase);
        for (PSWFLink pSWFLink : arrayList) {
            PSWFLink pSWFLink2 = (PSWFLink)this.getDEModel().createEntity();
            pSWFLink2.setPSWFLinkId(pSWFLink.getPSWFLinkId());
            pSWFLink2.setPSDEViewBaseId(null);
            this.update(pSWFLink2);
        }
    }

    public void removeByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
        final PSDEViewBase pSDEViewBase2 = pSDEViewBase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFLinkServiceBase.this.onBeforeRemoveByPSDEViewBase(pSDEViewBase2);
                PSWFLinkServiceBase.this.internalRemoveByPSDEViewBase(pSDEViewBase2);
                PSWFLinkServiceBase.this.onAfterRemoveByPSDEViewBase(pSDEViewBase2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void internalRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSWFLink> arrayList = this.selectByPSDEViewBase(pSDEViewBase);
        this.onBeforeRemoveByPSDEViewBase(pSDEViewBase, arrayList);
        for (PSWFLink pSWFLink : arrayList) {
            this.remove((IEntity)pSWFLink);
        }
        this.onAfterRemoveByPSDEViewBase(pSDEViewBase, arrayList);
    }

    protected void onAfterRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void onBeforeRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase, ArrayList<PSWFLink> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase, ArrayList<PSWFLink> arrayList) throws Exception {
    }

    public void testRemoveByLNPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSWFLink> arrayList = this.selectByLNPSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWFLINK_PSLANGUAGERES_LNPSLANRESID", "", iDataEntityModel.getName(), "PSWFLINK", iDataEntityModel.getDataInfo((IEntity)pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetLNPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSWFLink> arrayList = this.selectByLNPSLanRes(pSLanguageRes);
        for (PSWFLink pSWFLink : arrayList) {
            PSWFLink pSWFLink2 = (PSWFLink)this.getDEModel().createEntity();
            pSWFLink2.setPSWFLinkId(pSWFLink.getPSWFLinkId());
            pSWFLink2.setLNPSLanResId(null);
            this.update(pSWFLink2);
        }
    }

    public void removeByLNPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFLinkServiceBase.this.onBeforeRemoveByLNPSLanRes(pSLanguageRes2);
                PSWFLinkServiceBase.this.internalRemoveByLNPSLanRes(pSLanguageRes2);
                PSWFLinkServiceBase.this.onAfterRemoveByLNPSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByLNPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByLNPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSWFLink> arrayList = this.selectByLNPSLanRes(pSLanguageRes);
        this.onBeforeRemoveByLNPSLanRes(pSLanguageRes, arrayList);
        for (PSWFLink pSWFLink : arrayList) {
            this.remove((IEntity)pSWFLink);
        }
        this.onAfterRemoveByLNPSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByLNPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByLNPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSWFLink> arrayList) throws Exception {
    }

    protected void onAfterRemoveByLNPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSWFLink> arrayList) throws Exception {
    }

    public void testRemoveByTipPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSWFLink> arrayList = this.selectByTipPSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWFLINK_PSLANGUAGERES_TIPPSLANRESID", "", iDataEntityModel.getName(), "PSWFLINK", iDataEntityModel.getDataInfo((IEntity)pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetTipPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSWFLink> arrayList = this.selectByTipPSLanRes(pSLanguageRes);
        for (PSWFLink pSWFLink : arrayList) {
            PSWFLink pSWFLink2 = (PSWFLink)this.getDEModel().createEntity();
            pSWFLink2.setPSWFLinkId(pSWFLink.getPSWFLinkId());
            pSWFLink2.setTipPSLanResId(null);
            this.update(pSWFLink2);
        }
    }

    public void removeByTipPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFLinkServiceBase.this.onBeforeRemoveByTipPSLanRes(pSLanguageRes2);
                PSWFLinkServiceBase.this.internalRemoveByTipPSLanRes(pSLanguageRes2);
                PSWFLinkServiceBase.this.onAfterRemoveByTipPSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByTipPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByTipPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSWFLink> arrayList = this.selectByTipPSLanRes(pSLanguageRes);
        this.onBeforeRemoveByTipPSLanRes(pSLanguageRes, arrayList);
        for (PSWFLink pSWFLink : arrayList) {
            this.remove((IEntity)pSWFLink);
        }
        this.onAfterRemoveByTipPSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByTipPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByTipPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSWFLink> arrayList) throws Exception {
    }

    protected void onAfterRemoveByTipPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSWFLink> arrayList) throws Exception {
    }

    public void testRemoveByFromPSWFProc(PSWFProcess pSWFProcess) throws Exception {
    }

    public void resetFromPSWFProc(PSWFProcess pSWFProcess) throws Exception {
        ArrayList<PSWFLink> arrayList = this.selectByFromPSWFProc(pSWFProcess);
        for (PSWFLink pSWFLink : arrayList) {
            PSWFLink pSWFLink2 = (PSWFLink)this.getDEModel().createEntity();
            pSWFLink2.setPSWFLinkId(pSWFLink.getPSWFLinkId());
            pSWFLink2.setFromPSWFProcId(null);
            this.update(pSWFLink2);
        }
    }

    public void resetTempFromPSWFProc(PSWFProcess pSWFProcess) throws Exception {
        ArrayList<PSWFLink> arrayList = this.selectTempByFromPSWFProc(pSWFProcess);
        for (PSWFLink pSWFLink : arrayList) {
            PSWFLink pSWFLink2 = (PSWFLink)this.getDEModel().createEntity();
            pSWFLink2.setPSWFLinkId(pSWFLink.getPSWFLinkId());
            pSWFLink2.setFromPSWFProcId(null);
            this.updateTemp((IEntity)pSWFLink2);
        }
    }

    public void removeByFromPSWFProc(PSWFProcess pSWFProcess) throws Exception {
        final PSWFProcess pSWFProcess2 = pSWFProcess;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFLinkServiceBase.this.onBeforeRemoveByFromPSWFProc(pSWFProcess2);
                PSWFLinkServiceBase.this.internalRemoveByFromPSWFProc(pSWFProcess2);
                PSWFLinkServiceBase.this.onAfterRemoveByFromPSWFProc(pSWFProcess2);
            }
        });
    }

    protected void onBeforeRemoveByFromPSWFProc(PSWFProcess pSWFProcess) throws Exception {
    }

    protected void internalRemoveByFromPSWFProc(PSWFProcess pSWFProcess) throws Exception {
        ArrayList<PSWFLink> arrayList = this.selectByFromPSWFProc(pSWFProcess);
        this.onBeforeRemoveByFromPSWFProc(pSWFProcess, arrayList);
        for (PSWFLink pSWFLink : arrayList) {
            this.remove((IEntity)pSWFLink);
        }
        this.onAfterRemoveByFromPSWFProc(pSWFProcess, arrayList);
    }

    protected void onAfterRemoveByFromPSWFProc(PSWFProcess pSWFProcess) throws Exception {
    }

    protected void onBeforeRemoveByFromPSWFProc(PSWFProcess pSWFProcess, ArrayList<PSWFLink> arrayList) throws Exception {
    }

    protected void onAfterRemoveByFromPSWFProc(PSWFProcess pSWFProcess, ArrayList<PSWFLink> arrayList) throws Exception {
    }

    public void testRemoveByToPSWFProc(PSWFProcess pSWFProcess) throws Exception {
    }

    public void resetToPSWFProc(PSWFProcess pSWFProcess) throws Exception {
        ArrayList<PSWFLink> arrayList = this.selectByToPSWFProc(pSWFProcess);
        for (PSWFLink pSWFLink : arrayList) {
            PSWFLink pSWFLink2 = (PSWFLink)this.getDEModel().createEntity();
            pSWFLink2.setPSWFLinkId(pSWFLink.getPSWFLinkId());
            pSWFLink2.setToPSWFProcId(null);
            this.update(pSWFLink2);
        }
    }

    public void resetTempToPSWFProc(PSWFProcess pSWFProcess) throws Exception {
        ArrayList<PSWFLink> arrayList = this.selectTempByToPSWFProc(pSWFProcess);
        for (PSWFLink pSWFLink : arrayList) {
            PSWFLink pSWFLink2 = (PSWFLink)this.getDEModel().createEntity();
            pSWFLink2.setPSWFLinkId(pSWFLink.getPSWFLinkId());
            pSWFLink2.setToPSWFProcId(null);
            this.updateTemp((IEntity)pSWFLink2);
        }
    }

    public void removeByToPSWFProc(PSWFProcess pSWFProcess) throws Exception {
        final PSWFProcess pSWFProcess2 = pSWFProcess;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFLinkServiceBase.this.onBeforeRemoveByToPSWFProc(pSWFProcess2);
                PSWFLinkServiceBase.this.internalRemoveByToPSWFProc(pSWFProcess2);
                PSWFLinkServiceBase.this.onAfterRemoveByToPSWFProc(pSWFProcess2);
            }
        });
    }

    protected void onBeforeRemoveByToPSWFProc(PSWFProcess pSWFProcess) throws Exception {
    }

    protected void internalRemoveByToPSWFProc(PSWFProcess pSWFProcess) throws Exception {
        ArrayList<PSWFLink> arrayList = this.selectByToPSWFProc(pSWFProcess);
        this.onBeforeRemoveByToPSWFProc(pSWFProcess, arrayList);
        for (PSWFLink pSWFLink : arrayList) {
            this.remove((IEntity)pSWFLink);
        }
        this.onAfterRemoveByToPSWFProc(pSWFProcess, arrayList);
    }

    protected void onAfterRemoveByToPSWFProc(PSWFProcess pSWFProcess) throws Exception {
    }

    protected void onBeforeRemoveByToPSWFProc(PSWFProcess pSWFProcess, ArrayList<PSWFLink> arrayList) throws Exception {
    }

    protected void onAfterRemoveByToPSWFProc(PSWFProcess pSWFProcess, ArrayList<PSWFLink> arrayList) throws Exception {
    }

    public void testRemoveByPSWFRole(PSWFRole pSWFRole) throws Exception {
        ArrayList<PSWFLink> arrayList = this.selectByPSWFRole(pSWFRole, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSWFROLE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSWFRole);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWFLINK_PSWFROLE_PSWFROLEID", "", iDataEntityModel.getName(), "PSWFLINK", iDataEntityModel.getDataInfo((IEntity)pSWFRole), arrayList.get(0)));
        }
    }

    public void resetPSWFRole(PSWFRole pSWFRole) throws Exception {
        ArrayList<PSWFLink> arrayList = this.selectByPSWFRole(pSWFRole);
        for (PSWFLink pSWFLink : arrayList) {
            PSWFLink pSWFLink2 = (PSWFLink)this.getDEModel().createEntity();
            pSWFLink2.setPSWFLinkId(pSWFLink.getPSWFLinkId());
            pSWFLink2.setPSWFRoleId(null);
            this.update(pSWFLink2);
        }
    }

    public void removeByPSWFRole(PSWFRole pSWFRole) throws Exception {
        final PSWFRole pSWFRole2 = pSWFRole;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFLinkServiceBase.this.onBeforeRemoveByPSWFRole(pSWFRole2);
                PSWFLinkServiceBase.this.internalRemoveByPSWFRole(pSWFRole2);
                PSWFLinkServiceBase.this.onAfterRemoveByPSWFRole(pSWFRole2);
            }
        });
    }

    protected void onBeforeRemoveByPSWFRole(PSWFRole pSWFRole) throws Exception {
    }

    protected void internalRemoveByPSWFRole(PSWFRole pSWFRole) throws Exception {
        ArrayList<PSWFLink> arrayList = this.selectByPSWFRole(pSWFRole);
        this.onBeforeRemoveByPSWFRole(pSWFRole, arrayList);
        for (PSWFLink pSWFLink : arrayList) {
            this.remove((IEntity)pSWFLink);
        }
        this.onAfterRemoveByPSWFRole(pSWFRole, arrayList);
    }

    protected void onAfterRemoveByPSWFRole(PSWFRole pSWFRole) throws Exception {
    }

    protected void onBeforeRemoveByPSWFRole(PSWFRole pSWFRole, ArrayList<PSWFLink> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSWFRole(PSWFRole pSWFRole, ArrayList<PSWFLink> arrayList) throws Exception {
    }

    public void testRemoveByPSWFVersion(PSWFVersion pSWFVersion) throws Exception {
    }

    public void resetPSWFVersion(PSWFVersion pSWFVersion) throws Exception {
        ArrayList<PSWFLink> arrayList = this.selectByPSWFVersion(pSWFVersion);
        for (PSWFLink pSWFLink : arrayList) {
            PSWFLink pSWFLink2 = (PSWFLink)this.getDEModel().createEntity();
            pSWFLink2.setPSWFLinkId(pSWFLink.getPSWFLinkId());
            pSWFLink2.setPSWFVersionId(null);
            this.update(pSWFLink2);
        }
    }

    public void resetTempPSWFVersion(PSWFVersion pSWFVersion) throws Exception {
        ArrayList<PSWFLink> arrayList = this.selectTempByPSWFVersion(pSWFVersion);
        for (PSWFLink pSWFLink : arrayList) {
            PSWFLink pSWFLink2 = (PSWFLink)this.getDEModel().createEntity();
            pSWFLink2.setPSWFLinkId(pSWFLink.getPSWFLinkId());
            pSWFLink2.setPSWFVersionId(null);
            this.updateTemp((IEntity)pSWFLink2);
        }
    }

    public void removeByPSWFVersion(PSWFVersion pSWFVersion) throws Exception {
        final PSWFVersion pSWFVersion2 = pSWFVersion;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFLinkServiceBase.this.onBeforeRemoveByPSWFVersion(pSWFVersion2);
                PSWFLinkServiceBase.this.internalRemoveByPSWFVersion(pSWFVersion2);
                PSWFLinkServiceBase.this.onAfterRemoveByPSWFVersion(pSWFVersion2);
            }
        });
    }

    protected void onBeforeRemoveByPSWFVersion(PSWFVersion pSWFVersion) throws Exception {
    }

    protected void internalRemoveByPSWFVersion(PSWFVersion pSWFVersion) throws Exception {
        ArrayList<PSWFLink> arrayList = this.selectByPSWFVersion(pSWFVersion);
        this.onBeforeRemoveByPSWFVersion(pSWFVersion, arrayList);
        for (PSWFLink pSWFLink : arrayList) {
            this.remove((IEntity)pSWFLink);
        }
        this.onAfterRemoveByPSWFVersion(pSWFVersion, arrayList);
    }

    protected void onAfterRemoveByPSWFVersion(PSWFVersion pSWFVersion) throws Exception {
    }

    protected void onBeforeRemoveByPSWFVersion(PSWFVersion pSWFVersion, ArrayList<PSWFLink> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSWFVersion(PSWFVersion pSWFVersion, ArrayList<PSWFLink> arrayList) throws Exception {
    }

    public void testRemoveByPSWF(PSWorkflow pSWorkflow) throws Exception {
        ArrayList<PSWFLink> arrayList = this.selectByPSWF(pSWorkflow, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSWORKFLOW");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSWorkflow);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWFLINK_PSWORKFLOW_PSWFID", "", iDataEntityModel.getName(), "PSWFLINK", iDataEntityModel.getDataInfo((IEntity)pSWorkflow), arrayList.get(0)));
        }
    }

    public void resetPSWF(PSWorkflow pSWorkflow) throws Exception {
        ArrayList<PSWFLink> arrayList = this.selectByPSWF(pSWorkflow);
        for (PSWFLink pSWFLink : arrayList) {
            PSWFLink pSWFLink2 = (PSWFLink)this.getDEModel().createEntity();
            pSWFLink2.setPSWFLinkId(pSWFLink.getPSWFLinkId());
            pSWFLink2.setPSWFId(null);
            this.update(pSWFLink2);
        }
    }

    public void removeByPSWF(PSWorkflow pSWorkflow) throws Exception {
        final PSWorkflow pSWorkflow2 = pSWorkflow;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFLinkServiceBase.this.onBeforeRemoveByPSWF(pSWorkflow2);
                PSWFLinkServiceBase.this.internalRemoveByPSWF(pSWorkflow2);
                PSWFLinkServiceBase.this.onAfterRemoveByPSWF(pSWorkflow2);
            }
        });
    }

    protected void onBeforeRemoveByPSWF(PSWorkflow pSWorkflow) throws Exception {
    }

    protected void internalRemoveByPSWF(PSWorkflow pSWorkflow) throws Exception {
        ArrayList<PSWFLink> arrayList = this.selectByPSWF(pSWorkflow);
        this.onBeforeRemoveByPSWF(pSWorkflow, arrayList);
        for (PSWFLink pSWFLink : arrayList) {
            this.remove((IEntity)pSWFLink);
        }
        this.onAfterRemoveByPSWF(pSWorkflow, arrayList);
    }

    protected void onAfterRemoveByPSWF(PSWorkflow pSWorkflow) throws Exception {
    }

    protected void onBeforeRemoveByPSWF(PSWorkflow pSWorkflow, ArrayList<PSWFLink> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSWF(PSWorkflow pSWorkflow, ArrayList<PSWFLink> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSWFLink pSWFLink) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSWFLinkCondService)ServiceGlobal.getService(PSWFLinkCondService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFLinkCondServiceBase)pSCoreSysServiceBase).testRemoveByPSWFLink(pSWFLink);
        ((PSWFLinkCondServiceBase)pSCoreSysServiceBase).removeByPSWFLink(pSWFLink);
        pSCoreSysServiceBase = (PSWFLinkRoleService)ServiceGlobal.getService(PSWFLinkRoleService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFLinkRoleServiceBase)pSCoreSysServiceBase).testRemoveByPSWFLink(pSWFLink);
        ((PSWFLinkRoleServiceBase)pSCoreSysServiceBase).removeByPSWFLink(pSWFLink);
        super.onBeforeRemove(pSWFLink);
    }

    protected void onBeforeRemoveTemp(PSWFLink pSWFLink) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSWFLinkRoleService)ServiceGlobal.getService(PSWFLinkRoleService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFLinkRoleServiceBase)pSCoreSysServiceBase).removeTempByPSWFLink(pSWFLink);
        pSCoreSysServiceBase = (PSWFLinkCondService)ServiceGlobal.getService(PSWFLinkCondService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFLinkCondServiceBase)pSCoreSysServiceBase).removeTempByPSWFLink(pSWFLink);
        super.onBeforeRemoveTemp((IEntity)pSWFLink);
    }

    public void removeTempByFromPSWFProc(PSWFProcess pSWFProcess) throws Exception {
        final PSWFProcess pSWFProcess2 = pSWFProcess;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFLinkServiceBase.this.onBeforeRemoveTempByFromPSWFProc(pSWFProcess2);
                PSWFLinkServiceBase.this.internalRemoveTempByFromPSWFProc(pSWFProcess2);
                PSWFLinkServiceBase.this.onAfterRemoveTempByFromPSWFProc(pSWFProcess2);
            }
        });
    }

    protected void onBeforeRemoveTempByFromPSWFProc(PSWFProcess pSWFProcess) throws Exception {
    }

    protected void internalRemoveTempByFromPSWFProc(PSWFProcess pSWFProcess) throws Exception {
        ArrayList<PSWFLink> arrayList = this.selectTempByFromPSWFProc(pSWFProcess);
        this.onBeforeRemoveTempByFromPSWFProc(pSWFProcess, arrayList);
        for (PSWFLink pSWFLink : arrayList) {
            this.removeTemp((IEntity)pSWFLink);
        }
        this.onAfterRemoveTempByFromPSWFProc(pSWFProcess, arrayList);
    }

    protected void onAfterRemoveTempByFromPSWFProc(PSWFProcess pSWFProcess) throws Exception {
    }

    protected void onBeforeRemoveTempByFromPSWFProc(PSWFProcess pSWFProcess, ArrayList<PSWFLink> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByFromPSWFProc(PSWFProcess pSWFProcess, ArrayList<PSWFLink> arrayList) throws Exception {
    }

    public void removeTempByToPSWFProc(PSWFProcess pSWFProcess) throws Exception {
        final PSWFProcess pSWFProcess2 = pSWFProcess;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFLinkServiceBase.this.onBeforeRemoveTempByToPSWFProc(pSWFProcess2);
                PSWFLinkServiceBase.this.internalRemoveTempByToPSWFProc(pSWFProcess2);
                PSWFLinkServiceBase.this.onAfterRemoveTempByToPSWFProc(pSWFProcess2);
            }
        });
    }

    protected void onBeforeRemoveTempByToPSWFProc(PSWFProcess pSWFProcess) throws Exception {
    }

    protected void internalRemoveTempByToPSWFProc(PSWFProcess pSWFProcess) throws Exception {
        ArrayList<PSWFLink> arrayList = this.selectTempByToPSWFProc(pSWFProcess);
        this.onBeforeRemoveTempByToPSWFProc(pSWFProcess, arrayList);
        for (PSWFLink pSWFLink : arrayList) {
            this.removeTemp((IEntity)pSWFLink);
        }
        this.onAfterRemoveTempByToPSWFProc(pSWFProcess, arrayList);
    }

    protected void onAfterRemoveTempByToPSWFProc(PSWFProcess pSWFProcess) throws Exception {
    }

    protected void onBeforeRemoveTempByToPSWFProc(PSWFProcess pSWFProcess, ArrayList<PSWFLink> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByToPSWFProc(PSWFProcess pSWFProcess, ArrayList<PSWFLink> arrayList) throws Exception {
    }

    public void removeTempByPSWFVersion(PSWFVersion pSWFVersion) throws Exception {
        final PSWFVersion pSWFVersion2 = pSWFVersion;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFLinkServiceBase.this.onBeforeRemoveTempByPSWFVersion(pSWFVersion2);
                PSWFLinkServiceBase.this.internalRemoveTempByPSWFVersion(pSWFVersion2);
                PSWFLinkServiceBase.this.onAfterRemoveTempByPSWFVersion(pSWFVersion2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSWFVersion(PSWFVersion pSWFVersion) throws Exception {
    }

    protected void internalRemoveTempByPSWFVersion(PSWFVersion pSWFVersion) throws Exception {
        ArrayList<PSWFLink> arrayList = this.selectTempByPSWFVersion(pSWFVersion);
        this.onBeforeRemoveTempByPSWFVersion(pSWFVersion, arrayList);
        for (PSWFLink pSWFLink : arrayList) {
            this.removeTemp((IEntity)pSWFLink);
        }
        this.onAfterRemoveTempByPSWFVersion(pSWFVersion, arrayList);
    }

    protected void onAfterRemoveTempByPSWFVersion(PSWFVersion pSWFVersion) throws Exception {
    }

    protected void onBeforeRemoveTempByPSWFVersion(PSWFVersion pSWFVersion, ArrayList<PSWFLink> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSWFVersion(PSWFVersion pSWFVersion, ArrayList<PSWFLink> arrayList) throws Exception {
    }

    protected void getRelatedDataTempMajor(PSWFLink pSWFLink) throws Exception {
        this.getRelatedDataTempMajor_PSWFLinkCond(pSWFLink);
        this.getRelatedDataTempMajor_PSWFLinkRole(pSWFLink);
        super.getRelatedDataTempMajor((IEntity)pSWFLink);
    }

    protected void getRelatedDataTempMajor_PSWFLinkCond(PSWFLink pSWFLink) throws Exception {
        PSWFLinkCondService pSWFLinkCondService = (PSWFLinkCondService)ServiceGlobal.getService(PSWFLinkCondService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSWFLinkCond> arrayList = null;
        String string = pSWFLink.getPSWFLinkId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSWFLinkCondService.selectByPSWFLink(pSWFLink) : pSWFLinkCondService.selectTempByPSWFLink(pSWFLink);
        PSWFLinkServiceBase.sortHierarchyEntities(arrayList, (String)"PSWFLINKCONDID", (String)"PPSWFLINKCONDID");
        for (PSWFLinkCond pSWFLinkCond : arrayList) {
            pSWFLinkCondService.getTempMajor(pSWFLinkCond);
        }
    }

    protected void getRelatedDataTempMajor_PSWFLinkRole(PSWFLink pSWFLink) throws Exception {
        PSWFLinkRoleService pSWFLinkRoleService = (PSWFLinkRoleService)ServiceGlobal.getService(PSWFLinkRoleService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSWFLinkRole> arrayList = null;
        String string = pSWFLink.getPSWFLinkId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSWFLinkRoleService.selectByPSWFLink(pSWFLink) : pSWFLinkRoleService.selectTempByPSWFLink(pSWFLink);
        for (PSWFLinkRole pSWFLinkRole : arrayList) {
            pSWFLinkRoleService.getTempMajor(pSWFLinkRole);
        }
    }

    protected void updateRelatedDataTempMajor(PSWFLink pSWFLink, PSWFLink pSWFLink2) throws Exception {
        ArrayList<PSWFLinkRole> arrayList = this.updateRelatedDataTempMajor_removePSWFLinkRole(pSWFLink, pSWFLink2);
        ArrayList<PSWFLinkCond> arrayList2 = this.updateRelatedDataTempMajor_removePSWFLinkCond(pSWFLink, pSWFLink2);
        this.updateRelatedDataTempMajor_updatePSWFLinkCond(pSWFLink, pSWFLink2, arrayList2);
        this.updateRelatedDataTempMajor_updatePSWFLinkRole(pSWFLink, pSWFLink2, arrayList);
        super.updateRelatedDataTempMajor((IEntity)pSWFLink, (IEntity)pSWFLink2);
    }

    protected ArrayList<PSWFLinkCond> updateRelatedDataTempMajor_removePSWFLinkCond(PSWFLink pSWFLink, PSWFLink pSWFLink2) throws Exception {
        PSWFLinkCondService pSWFLinkCondService = (PSWFLinkCondService)ServiceGlobal.getService(PSWFLinkCondService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSWFLinkCond> arrayList = pSWFLinkCondService.selectTempByPSWFLink(pSWFLink);
        ArrayList<PSWFLinkCond> arrayList2 = pSWFLinkCondService.selectByPSWFLink(pSWFLink2);
        HashMap<String, PSWFLinkCond> hashMap = new HashMap<String, PSWFLinkCond>();
        for (PSWFLinkCond pSWFLinkCond : arrayList2) {
            hashMap.put(pSWFLinkCond.getPSWFLinkCondId(), pSWFLinkCond);
        }
        PSWFLinkServiceBase.sortHierarchyEntities(arrayList, (String)"PSWFLINKCONDID", (String)"PPSWFLINKCONDID");
        for (PSWFLinkCond pSWFLinkCond : arrayList) {
            Object object = pSWFLinkCond.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSWFLinkCond pSWFLinkCond : hashMap.values()) {
            pSWFLinkCondService.remove((IEntity)pSWFLinkCond);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSWFLinkCond(PSWFLink pSWFLink, PSWFLink pSWFLink2, ArrayList<PSWFLinkCond> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSWFLinkCondService pSWFLinkCondService = (PSWFLinkCondService)ServiceGlobal.getService(PSWFLinkCondService.class, (SessionFactory)this.getSessionFactory());
        for (PSWFLinkCond pSWFLinkCond : arrayList) {
            pSWFLinkCondService.updateTempMajor(pSWFLinkCond);
        }
    }

    protected ArrayList<PSWFLinkRole> updateRelatedDataTempMajor_removePSWFLinkRole(PSWFLink pSWFLink, PSWFLink pSWFLink2) throws Exception {
        PSWFLinkRoleService pSWFLinkRoleService = (PSWFLinkRoleService)ServiceGlobal.getService(PSWFLinkRoleService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSWFLinkRole> arrayList = pSWFLinkRoleService.selectTempByPSWFLink(pSWFLink);
        ArrayList<PSWFLinkRole> arrayList2 = pSWFLinkRoleService.selectByPSWFLink(pSWFLink2);
        HashMap<String, PSWFLinkRole> hashMap = new HashMap<String, PSWFLinkRole>();
        for (PSWFLinkRole pSWFLinkRole : arrayList2) {
            hashMap.put(pSWFLinkRole.getPSWFLinkRoleId(), pSWFLinkRole);
        }
        for (PSWFLinkRole pSWFLinkRole : arrayList) {
            Object object = pSWFLinkRole.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSWFLinkRole pSWFLinkRole : hashMap.values()) {
            pSWFLinkRoleService.remove((IEntity)pSWFLinkRole);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSWFLinkRole(PSWFLink pSWFLink, PSWFLink pSWFLink2, ArrayList<PSWFLinkRole> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSWFLinkRoleService pSWFLinkRoleService = (PSWFLinkRoleService)ServiceGlobal.getService(PSWFLinkRoleService.class, (SessionFactory)this.getSessionFactory());
        for (PSWFLinkRole pSWFLinkRole : arrayList) {
            pSWFLinkRoleService.updateTempMajor(pSWFLinkRole);
        }
    }

    protected void replaceParentInfo(PSWFLink pSWFLink, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSWFLink, cloneSession);
        if (pSWFLink.getActionPSCodeListId() != null && (iEntity = cloneSession.getEntity("PSCODELIST", (Object)pSWFLink.getActionPSCodeListId())) != null) {
            this.onFillParentInfo_ActionPSCodeList(pSWFLink, (PSCodeList)iEntity);
        }
        if (pSWFLink.getMobPSDEFormId() != null && (iEntity = cloneSession.getEntity("PSDEFORM", (Object)pSWFLink.getMobPSDEFormId())) != null) {
            this.onFillParentInfo_MobPSDEForm(pSWFLink, (PSDEForm)iEntity);
        }
        if (pSWFLink.getPSDEFormId() != null && (iEntity = cloneSession.getEntity("PSDEFORM", (Object)pSWFLink.getPSDEFormId())) != null) {
            this.onFillParentInfo_PSDEForm(pSWFLink, (PSDEForm)iEntity);
        }
        if (pSWFLink.getMobPSDEViewId() != null && (iEntity = cloneSession.getEntity("PSDEVIEWBASE", (Object)pSWFLink.getMobPSDEViewId())) != null) {
            this.onFillParentInfo_MobPSDEView(pSWFLink, (PSDEViewBase)iEntity);
        }
        if (pSWFLink.getPSDEViewBaseId() != null && (iEntity = cloneSession.getEntity("PSDEVIEWBASE", (Object)pSWFLink.getPSDEViewBaseId())) != null) {
            this.onFillParentInfo_PSDEViewBase(pSWFLink, (PSDEViewBase)iEntity);
        }
        if (pSWFLink.getLNPSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSWFLink.getLNPSLanResId())) != null) {
            this.onFillParentInfo_LNPSLanRes(pSWFLink, (PSLanguageRes)iEntity);
        }
        if (pSWFLink.getTipPSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSWFLink.getTipPSLanResId())) != null) {
            this.onFillParentInfo_TipPSLanRes(pSWFLink, (PSLanguageRes)iEntity);
        }
        if (pSWFLink.getFromPSWFProcId() != null && (iEntity = cloneSession.getEntity("PSWFPROCESS", (Object)pSWFLink.getFromPSWFProcId())) != null) {
            this.onFillParentInfo_FromPSWFProc(pSWFLink, (PSWFProcess)iEntity);
        }
        if (pSWFLink.getToPSWFProcId() != null && (iEntity = cloneSession.getEntity("PSWFPROCESS", (Object)pSWFLink.getToPSWFProcId())) != null) {
            this.onFillParentInfo_ToPSWFProc(pSWFLink, (PSWFProcess)iEntity);
        }
        if (pSWFLink.getPSWFRoleId() != null && (iEntity = cloneSession.getEntity("PSWFROLE", (Object)pSWFLink.getPSWFRoleId())) != null) {
            this.onFillParentInfo_PSWFRole(pSWFLink, (PSWFRole)iEntity);
        }
        if (pSWFLink.getPSWFVersionId() != null && (iEntity = cloneSession.getEntity("PSWFVERSION", (Object)pSWFLink.getPSWFVersionId())) != null) {
            this.onFillParentInfo_PSWFVersion(pSWFLink, (PSWFVersion)iEntity);
        }
        if (pSWFLink.getPSWFId() != null && (iEntity = cloneSession.getEntity("PSWORKFLOW", (Object)pSWFLink.getPSWFId())) != null) {
            this.onFillParentInfo_PSWF(pSWFLink, (PSWorkflow)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSWFLink pSWFLink, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSWFLink, bl);
    }

    protected void onCheckEntity(boolean bl, PSWFLink pSWFLink, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_ActionField(bl, pSWFLink, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ActionPSCodeListId(bl, pSWFLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ActorFields(bl, pSWFLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSWFLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CondModel(bl, pSWFLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomCond(bl, pSWFLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomCondFlag(bl, pSWFLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DefaultLink(bl, pSWFLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DstEndPoint(bl, pSWFLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaModelFlag(bl, pSWFLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Enable(bl, pSWFLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableMobile(bl, pSWFLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FromPSWFProcId(bl, pSWFLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FromPSWFProcName(bl, pSWFLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Label(bl, pSWFLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LNPSLanResId(bl, pSWFLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LNPSLanResName(bl, pSWFLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogicName(bl, pSWFLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSWFLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MemoField(bl, pSWFLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MobPSDEFormId(bl, pSWFLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MobPSDEViewId(bl, pSWFLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ModelId(bl, pSWFLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NextCond(bl, pSWFLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSWFLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFormId(bl, pSWFLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEViewBaseId(bl, pSWFLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaInstId(bl, pSWFLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWFId(bl, pSWFLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWFLinkId(bl, pSWFLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWFLinkName(bl, pSWFLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWFName(bl, pSWFLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWFRoleId(bl, pSWFLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWFVersionId(bl, pSWFLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWFVersionName(bl, pSWFLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ShapeParams(bl, pSWFLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SomeRoleFlag(bl, pSWFLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SrcEndPoint(bl, pSWFLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ThreadFlag(bl, pSWFLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ThreadName(bl, pSWFLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TipPSLanResId(bl, pSWFLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TipPSLanResName(bl, pSWFLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ToPSWFProcId(bl, pSWFLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ToPSWFProcName(bl, pSWFLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSWFLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserData(bl, pSWFLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserData2(bl, pSWFLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSWFLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSWFLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSWFLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSWFLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFLinkType(bl, pSWFLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSWFLink, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_ActionField(boolean bl, PSWFLink pSWFLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFLink.isActionFieldDirty() : !pSWFLink.isActionFieldDirty()) {
            return null;
        }
        String string = pSWFLink.getActionField();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ActionField_Default((IEntity)pSWFLink, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ACTIONFIELD");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ActionPSCodeListId(boolean bl, PSWFLink pSWFLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFLink.isActionPSCodeListIdDirty() : !pSWFLink.isActionPSCodeListIdDirty()) {
            return null;
        }
        String string = pSWFLink.getActionPSCodeListId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ActionPSCodeListId_Default((IEntity)pSWFLink, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ACTIONPSCODELISTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ActorFields(boolean bl, PSWFLink pSWFLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFLink.isActorFieldsDirty() : !pSWFLink.isActorFieldsDirty()) {
            return null;
        }
        String string = pSWFLink.getActorFields();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ActorFields_Default((IEntity)pSWFLink, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ACTORFIELDS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSWFLink pSWFLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFLink.isCodeNameDirty() : !pSWFLink.isCodeNameDirty()) {
            return null;
        }
        String string = pSWFLink.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default((IEntity)pSWFLink, bl2, bl3);
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
                string3 = "FROMPSWFPROCID";
                String string4 = this.checkFieldDupRule(this.getPSWFLinkDEModel(), "CODENAME", string3, pSWFLink, bl2, bl3);
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

    protected EntityFieldError onCheckField_CondModel(boolean bl, PSWFLink pSWFLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFLink.isCondModelDirty() : !pSWFLink.isCondModelDirty()) {
            return null;
        }
        String string = pSWFLink.getCondModel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CondModel_Default((IEntity)pSWFLink, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONDMODEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CustomCond(boolean bl, PSWFLink pSWFLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFLink.isCustomCondDirty() : !pSWFLink.isCustomCondDirty()) {
            return null;
        }
        String string = pSWFLink.getCustomCond();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomCond_Default((IEntity)pSWFLink, bl2, bl3);
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

    protected EntityFieldError onCheckField_CustomCondFlag(boolean bl, PSWFLink pSWFLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFLink.isCustomCondFlagDirty() : !pSWFLink.isCustomCondFlagDirty()) {
            return null;
        }
        Integer n = pSWFLink.getCustomCondFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CustomCondFlag_Default((IEntity)pSWFLink, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CUSTOMCONDFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DefaultLink(boolean bl, PSWFLink pSWFLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFLink.isDefaultLinkDirty() : !pSWFLink.isDefaultLinkDirty()) {
            return null;
        }
        Integer n = pSWFLink.getDefaultLink();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DefaultLink_Default((IEntity)pSWFLink, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFAULTLINK");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            bl4 = DataTypeHelper.compare((int)9, (Object)n, (Object)"1") == 0L;
            if (bl4) {
                String string = "";
                string = "FROMPSWFPROCID";
                String string2 = this.checkFieldDupRule(this.getPSWFLinkDEModel(), "DEFAULTLINK", string, pSWFLink, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string2)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("DEFAULTLINK");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string2);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DstEndPoint(boolean bl, PSWFLink pSWFLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFLink.isDstEndPointDirty() : !pSWFLink.isDstEndPointDirty()) {
            return null;
        }
        String string = pSWFLink.getDstEndPoint();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DstEndPoint_Default((IEntity)pSWFLink, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTENDPOINT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DynaModelFlag(boolean bl, PSWFLink pSWFLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFLink.isDynaModelFlagDirty() : !pSWFLink.isDynaModelFlagDirty()) {
            return null;
        }
        Integer n = pSWFLink.getDynaModelFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DynaModelFlag_Default((IEntity)pSWFLink, bl2, bl3);
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

    protected EntityFieldError onCheckField_Enable(boolean bl, PSWFLink pSWFLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFLink.isEnableDirty() && !bl2 : !pSWFLink.isEnableDirty()) {
            return null;
        }
        Integer n = pSWFLink.getEnable();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_Enable_Default((IEntity)pSWFLink, bl2, bl3);
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

    protected EntityFieldError onCheckField_EnableMobile(boolean bl, PSWFLink pSWFLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFLink.isEnableMobileDirty() : !pSWFLink.isEnableMobileDirty()) {
            return null;
        }
        Integer n = pSWFLink.getEnableMobile();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableMobile_Default((IEntity)pSWFLink, bl2, bl3);
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

    protected EntityFieldError onCheckField_FromPSWFProcId(boolean bl, PSWFLink pSWFLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFLink.isFromPSWFProcIdDirty() : !pSWFLink.isFromPSWFProcIdDirty()) {
            return null;
        }
        String string = pSWFLink.getFromPSWFProcId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FromPSWFProcId_Default((IEntity)pSWFLink, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FROMPSWFPROCID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FromPSWFProcName(boolean bl, PSWFLink pSWFLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFLink.isFromPSWFProcNameDirty() : !pSWFLink.isFromPSWFProcNameDirty()) {
            return null;
        }
        String string = pSWFLink.getFromPSWFProcName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FromPSWFProcName_Default((IEntity)pSWFLink, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FROMPSWFPROCNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Label(boolean bl, PSWFLink pSWFLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFLink.isLabelDirty() : !pSWFLink.isLabelDirty()) {
            return null;
        }
        String string = pSWFLink.getLabel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Label_Default((IEntity)pSWFLink, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LABEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LNPSLanResId(boolean bl, PSWFLink pSWFLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFLink.isLNPSLanResIdDirty() : !pSWFLink.isLNPSLanResIdDirty()) {
            return null;
        }
        String string = pSWFLink.getLNPSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LNPSLanResId_Default((IEntity)pSWFLink, bl2, bl3);
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

    protected EntityFieldError onCheckField_LNPSLanResName(boolean bl, PSWFLink pSWFLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFLink.isLNPSLanResNameDirty() : !pSWFLink.isLNPSLanResNameDirty()) {
            return null;
        }
        String string = pSWFLink.getLNPSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LNPSLanResName_Default((IEntity)pSWFLink, bl2, bl3);
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

    protected EntityFieldError onCheckField_LogicName(boolean bl, PSWFLink pSWFLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFLink.isLogicNameDirty() : !pSWFLink.isLogicNameDirty()) {
            return null;
        }
        String string = pSWFLink.getLogicName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogicName_Default((IEntity)pSWFLink, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSWFLink pSWFLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFLink.isMemoDirty() : !pSWFLink.isMemoDirty()) {
            return null;
        }
        String string = pSWFLink.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSWFLink, bl2, bl3);
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

    protected EntityFieldError onCheckField_MemoField(boolean bl, PSWFLink pSWFLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFLink.isMemoFieldDirty() : !pSWFLink.isMemoFieldDirty()) {
            return null;
        }
        String string = pSWFLink.getMemoField();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MemoField_Default((IEntity)pSWFLink, bl2, bl3);
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

    protected EntityFieldError onCheckField_MobPSDEFormId(boolean bl, PSWFLink pSWFLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFLink.isMobPSDEFormIdDirty() : !pSWFLink.isMobPSDEFormIdDirty()) {
            return null;
        }
        String string = pSWFLink.getMobPSDEFormId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MobPSDEFormId_Default((IEntity)pSWFLink, bl2, bl3);
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

    protected EntityFieldError onCheckField_MobPSDEViewId(boolean bl, PSWFLink pSWFLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFLink.isMobPSDEViewIdDirty() : !pSWFLink.isMobPSDEViewIdDirty()) {
            return null;
        }
        String string = pSWFLink.getMobPSDEViewId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MobPSDEViewId_Default((IEntity)pSWFLink, bl2, bl3);
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

    protected EntityFieldError onCheckField_ModelId(boolean bl, PSWFLink pSWFLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFLink.isModelIdDirty() : !pSWFLink.isModelIdDirty()) {
            return null;
        }
        String string = pSWFLink.getModelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ModelId_Default((IEntity)pSWFLink, bl2, bl3);
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

    protected EntityFieldError onCheckField_NextCond(boolean bl, PSWFLink pSWFLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFLink.isNextCondDirty() : !pSWFLink.isNextCondDirty()) {
            return null;
        }
        String string = pSWFLink.getNextCond();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NextCond_Default((IEntity)pSWFLink, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NEXTCOND");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSWFLink pSWFLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFLink.isOrderValueDirty() && !bl2 : !pSWFLink.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSWFLink.getOrderValue();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ORDERVALUE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default((IEntity)pSWFLink, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEFormId(boolean bl, PSWFLink pSWFLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFLink.isPSDEFormIdDirty() : !pSWFLink.isPSDEFormIdDirty()) {
            return null;
        }
        String string = pSWFLink.getPSDEFormId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFormId_Default((IEntity)pSWFLink, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEViewBaseId(boolean bl, PSWFLink pSWFLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFLink.isPSDEViewBaseIdDirty() : !pSWFLink.isPSDEViewBaseIdDirty()) {
            return null;
        }
        String string = pSWFLink.getPSDEViewBaseId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEViewBaseId_Default((IEntity)pSWFLink, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDynaInstId(boolean bl, PSWFLink pSWFLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFLink.isPSDynaInstIdDirty() : !pSWFLink.isPSDynaInstIdDirty()) {
            return null;
        }
        String string = pSWFLink.getPSDynaInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaInstId_Default((IEntity)pSWFLink, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSWFId(boolean bl, PSWFLink pSWFLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFLink.isPSWFIdDirty() : !pSWFLink.isPSWFIdDirty()) {
            return null;
        }
        String string = pSWFLink.getPSWFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWFId_Default((IEntity)pSWFLink, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSWFLinkId(boolean bl, PSWFLink pSWFLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFLink.isPSWFLinkIdDirty() && !bl2 : !pSWFLink.isPSWFLinkIdDirty()) {
            return null;
        }
        String string = pSWFLink.getPSWFLinkId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWFLINKID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWFLinkId_Default((IEntity)pSWFLink, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWFLINKID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWFLinkName(boolean bl, PSWFLink pSWFLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFLink.isPSWFLinkNameDirty() && !bl2 : !pSWFLink.isPSWFLinkNameDirty()) {
            return null;
        }
        String string = pSWFLink.getPSWFLinkName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWFLINKNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWFLinkName_Default((IEntity)pSWFLink, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWFLINKNAME");
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
                string3 = "FROMPSWFPROCID";
                String string4 = this.checkFieldDupRule(this.getPSWFLinkDEModel(), "PSWFLINKNAME", string3, pSWFLink, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSWFLINKNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWFName(boolean bl, PSWFLink pSWFLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFLink.isPSWFNameDirty() : !pSWFLink.isPSWFNameDirty()) {
            return null;
        }
        String string = pSWFLink.getPSWFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWFName_Default((IEntity)pSWFLink, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSWFRoleId(boolean bl, PSWFLink pSWFLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFLink.isPSWFRoleIdDirty() : !pSWFLink.isPSWFRoleIdDirty()) {
            return null;
        }
        String string = pSWFLink.getPSWFRoleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWFRoleId_Default((IEntity)pSWFLink, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWFROLEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWFVersionId(boolean bl, PSWFLink pSWFLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFLink.isPSWFVersionIdDirty() : !pSWFLink.isPSWFVersionIdDirty()) {
            return null;
        }
        String string = pSWFLink.getPSWFVersionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWFVersionId_Default((IEntity)pSWFLink, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSWFVersionName(boolean bl, PSWFLink pSWFLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFLink.isPSWFVersionNameDirty() : !pSWFLink.isPSWFVersionNameDirty()) {
            return null;
        }
        String string = pSWFLink.getPSWFVersionName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWFVersionName_Default((IEntity)pSWFLink, bl2, bl3);
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

    protected EntityFieldError onCheckField_ShapeParams(boolean bl, PSWFLink pSWFLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFLink.isShapeParamsDirty() : !pSWFLink.isShapeParamsDirty()) {
            return null;
        }
        String string = pSWFLink.getShapeParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ShapeParams_Default((IEntity)pSWFLink, bl2, bl3);
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

    protected EntityFieldError onCheckField_SomeRoleFlag(boolean bl, PSWFLink pSWFLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFLink.isSomeRoleFlagDirty() : !pSWFLink.isSomeRoleFlagDirty()) {
            return null;
        }
        Integer n = pSWFLink.getSomeRoleFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SomeRoleFlag_Default((IEntity)pSWFLink, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SOMEROLEFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SrcEndPoint(boolean bl, PSWFLink pSWFLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFLink.isSrcEndPointDirty() : !pSWFLink.isSrcEndPointDirty()) {
            return null;
        }
        String string = pSWFLink.getSrcEndPoint();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SrcEndPoint_Default((IEntity)pSWFLink, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SRCENDPOINT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ThreadFlag(boolean bl, PSWFLink pSWFLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFLink.isThreadFlagDirty() : !pSWFLink.isThreadFlagDirty()) {
            return null;
        }
        Integer n = pSWFLink.getThreadFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ThreadFlag_Default((IEntity)pSWFLink, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("THREADFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ThreadName(boolean bl, PSWFLink pSWFLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFLink.isThreadNameDirty() : !pSWFLink.isThreadNameDirty()) {
            return null;
        }
        String string = pSWFLink.getThreadName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ThreadName_Default((IEntity)pSWFLink, bl2, bl3);
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

    protected EntityFieldError onCheckField_TipPSLanResId(boolean bl, PSWFLink pSWFLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFLink.isTipPSLanResIdDirty() : !pSWFLink.isTipPSLanResIdDirty()) {
            return null;
        }
        String string = pSWFLink.getTipPSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TipPSLanResId_Default((IEntity)pSWFLink, bl2, bl3);
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

    protected EntityFieldError onCheckField_TipPSLanResName(boolean bl, PSWFLink pSWFLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFLink.isTipPSLanResNameDirty() : !pSWFLink.isTipPSLanResNameDirty()) {
            return null;
        }
        String string = pSWFLink.getTipPSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TipPSLanResName_Default((IEntity)pSWFLink, bl2, bl3);
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

    protected EntityFieldError onCheckField_ToPSWFProcId(boolean bl, PSWFLink pSWFLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFLink.isToPSWFProcIdDirty() : !pSWFLink.isToPSWFProcIdDirty()) {
            return null;
        }
        String string = pSWFLink.getToPSWFProcId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ToPSWFProcId_Default((IEntity)pSWFLink, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TOPSWFPROCID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ToPSWFProcName(boolean bl, PSWFLink pSWFLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFLink.isToPSWFProcNameDirty() : !pSWFLink.isToPSWFProcNameDirty()) {
            return null;
        }
        String string = pSWFLink.getToPSWFProcName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ToPSWFProcName_Default((IEntity)pSWFLink, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TOPSWFPROCNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSWFLink pSWFLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFLink.isUserCatDirty() : !pSWFLink.isUserCatDirty()) {
            return null;
        }
        String string = pSWFLink.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default((IEntity)pSWFLink, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserData(boolean bl, PSWFLink pSWFLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFLink.isUserDataDirty() : !pSWFLink.isUserDataDirty()) {
            return null;
        }
        String string = pSWFLink.getUserData();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserData_Default((IEntity)pSWFLink, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserData2(boolean bl, PSWFLink pSWFLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFLink.isUserData2Dirty() : !pSWFLink.isUserData2Dirty()) {
            return null;
        }
        String string = pSWFLink.getUserData2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserData2_Default((IEntity)pSWFLink, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSWFLink pSWFLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFLink.isUserTagDirty() : !pSWFLink.isUserTagDirty()) {
            return null;
        }
        String string = pSWFLink.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSWFLink, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSWFLink pSWFLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFLink.isUserTag2Dirty() : !pSWFLink.isUserTag2Dirty()) {
            return null;
        }
        String string = pSWFLink.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSWFLink, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSWFLink pSWFLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFLink.isUserTag3Dirty() : !pSWFLink.isUserTag3Dirty()) {
            return null;
        }
        String string = pSWFLink.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default((IEntity)pSWFLink, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSWFLink pSWFLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFLink.isUserTag4Dirty() : !pSWFLink.isUserTag4Dirty()) {
            return null;
        }
        String string = pSWFLink.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default((IEntity)pSWFLink, bl2, bl3);
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

    protected EntityFieldError onCheckField_WFLinkType(boolean bl, PSWFLink pSWFLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFLink.isWFLinkTypeDirty() && !bl2 : !pSWFLink.isWFLinkTypeDirty()) {
            return null;
        }
        String string = pSWFLink.getWFLinkType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFLINKTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_WFLinkType_Default((IEntity)pSWFLink, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFLINKTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSWFLink pSWFLink, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSWFLink, bl);
    }

    protected void onSyncIndexEntities(PSWFLink pSWFLink, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSWFLink, bl);
    }

    public Object getDataContextValue(PSWFLink pSWFLink, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSWFLink, string, iDataContextParam)) != null) {
            return object;
        }
        PSWFProcess pSWFProcess = pSWFLink.getFromPSWFProc();
        if (pSWFProcess != null && pSWFProcess.contains(string)) {
            return pSWFProcess.get(string);
        }
        return null;
    }

    protected void onExportRelatedModel(PSWFLink pSWFLink, ArrayList<JSONObject> arrayList, int n) throws Exception {
        this.onExportRelatedModel_PSWFLinkRole_PSWFLink(pSWFLink, arrayList, n);
        this.onExportRelatedModel_PSWFLinkCond_PSWFLink(pSWFLink, arrayList, n);
        super.onExportRelatedModel((IEntity)pSWFLink, arrayList, n);
    }

    protected void onExportRelatedModel_PSWFLinkRole_PSWFLink(PSWFLink pSWFLink, ArrayList<JSONObject> arrayList, int n) throws Exception {
        PSWFLinkRoleService pSWFLinkRoleService = (PSWFLinkRoleService)ServiceGlobal.getService(PSWFLinkRoleService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSWFLinkRole> arrayList2 = pSWFLinkRoleService.selectByPSWFLink(pSWFLink);
        if ((n & 2) != 0) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("srfdeid", (Object)"0ea0dfa6075cb861b83b6a6b77ada57d");
            jSONObject.put("srfdename", (Object)"PSWFLINKROLE");
            jSONObject.put("srfder1nsync", (Object)"true");
            jSONObject.put("srfder1nid", (Object)"DER1N_PSWFLINKROLE_PSWFLINK_PSWFLINKID");
            jSONObject.put("srfarg", (Object)DataObject.getStringValue((IDataObject)pSWFLink, (String)"PSWFLINKID", (String)""));
            jSONObject.put("srfarg2", (Object)"");
            arrayList.add(jSONObject);
        }
        for (PSWFLinkRole pSWFLinkRole : arrayList2) {
            if (DataObject.getIntegerValue((IDataObject)pSWFLinkRole, (String)"srfsyspub", (int)1) == 0) continue;
            pSWFLinkRoleService.exportModel(pSWFLinkRole, arrayList, n);
        }
    }

    protected void onExportRelatedModel_PSWFLinkCond_PSWFLink(PSWFLink pSWFLink, ArrayList<JSONObject> arrayList, int n) throws Exception {
        PSWFLinkCondService pSWFLinkCondService = (PSWFLinkCondService)ServiceGlobal.getService(PSWFLinkCondService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSWFLinkCond> arrayList2 = pSWFLinkCondService.selectByPSWFLink(pSWFLink);
        if ((n & 2) != 0) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("srfdeid", (Object)"ada60d1006720390bf27b0e79d48b0b7");
            jSONObject.put("srfdename", (Object)"PSWFLINKCOND");
            jSONObject.put("srfder1nsync", (Object)"true");
            jSONObject.put("srfder1nid", (Object)"DER1N_PSWFLINKCOND_PSWFLINK_PSWFLINKID");
            jSONObject.put("srfarg", (Object)DataObject.getStringValue((IDataObject)pSWFLink, (String)"PSWFLINKID", (String)""));
            jSONObject.put("srfarg2", (Object)"");
            arrayList.add(jSONObject);
        }
        for (PSWFLinkCond pSWFLinkCond : arrayList2) {
            if (DataObject.getIntegerValue((IDataObject)pSWFLinkCond, (String)"srfsyspub", (int)1) == 0) continue;
            pSWFLinkCondService.exportModel(pSWFLinkCond, arrayList, n);
        }
    }

    protected void onExportMajorModel(PSWFLink pSWFLink, ArrayList<JSONObject> arrayList, int n) throws Exception {
        this.onExportMajorModel_LNPSLanRes(pSWFLink, arrayList, n);
        this.onExportMajorModel_TipPSLanRes(pSWFLink, arrayList, n);
        super.onExportMajorModel((IEntity)pSWFLink, arrayList, n);
    }

    protected void onExportMajorModel_LNPSLanRes(PSWFLink pSWFLink, ArrayList<JSONObject> arrayList, int n) throws Exception {
        if (pSWFLink.getLNPSLanRes() != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            iService.exportModel((IEntity)pSWFLink.getLNPSLanRes(), arrayList, n);
        }
    }

    protected void onExportMajorModel_TipPSLanRes(PSWFLink pSWFLink, ArrayList<JSONObject> arrayList, int n) throws Exception {
        if (pSWFLink.getTipPSLanRes() != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            iService.exportModel((IEntity)pSWFLink.getTipPSLanRes(), arrayList, n);
        }
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ACTIONFIELD", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ActionField_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ACTIONPSCODELISTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ActionPSCodeListId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ACTIONPSCODELISTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ActionPSCodeListName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ACTORFIELDS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ActorFields_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CONDMODEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CondModel_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"CUSTOMCONDFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CustomCondFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEFAULTLINK", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DefaultLink_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTENDPOINT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstEndPoint_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DYNAMODELFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaModelFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Enable_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEMOBILE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableMobile_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FORMCODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FormCodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FROMPSWFPROCID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FromPSWFProcId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FROMPSWFPROCNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FromPSWFProcName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LABEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Label_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LNPSLANRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LNPSLanResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LNPSLANRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LNPSLanResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogicName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"MOBPSDEVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MobPSDEViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MOBPSDEVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MobPSDEViewName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MOBVIEWCODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MobViewCodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MODELID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ModelId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NEXTCOND", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NextCond_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSDEVIEWBASEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEViewBaseId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVIEWBASENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEViewBaseName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWFDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWFLINKID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFLinkId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWFLINKNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFLinkName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWFROLEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFRoleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWFROLENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFRoleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWFVERSIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFVersionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWFVERSIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFVersionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SHAPEPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ShapeParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SOMEROLEFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SomeRoleFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SRCENDPOINT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SrcEndPoint_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"THREADFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ThreadFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"THREADNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ThreadName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TIPPSLANRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TipPSLanResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TIPPSLANRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TipPSLanResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TOPSWFPROCID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ToPSWFProcId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TOPSWFPROCNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ToPSWFProcName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"VIEWCODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ViewCodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WFENGINETYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WFEngineType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WFLINKTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WFLinkType_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_ActionField_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ACTIONFIELD", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ActionPSCodeListId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ACTIONPSCODELISTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ActionPSCodeListName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ACTIONPSCODELISTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ActorFields_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ACTORFIELDS", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected String onTestValueRule_CondModel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONDMODEL", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
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

    protected String onTestValueRule_CustomCondFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DefaultLink_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DstEndPoint_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTENDPOINT", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
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

    protected String onTestValueRule_Enable_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableMobile_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_FromPSWFProcId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FROMPSWFPROCID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FromPSWFProcName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FROMPSWFPROCNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Label_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LABEL", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
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

    protected String onTestValueRule_MobViewCodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MOBVIEWCODENAME", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
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

    protected String onTestValueRule_NextCond_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NEXTCOND", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_PSWFLinkId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWFLINKID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWFLinkName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWFLINKNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_PSWFRoleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWFROLEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWFRoleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWFROLENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_SomeRoleFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_SrcEndPoint_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SRCENDPOINT", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ThreadFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_ToPSWFProcId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TOPSWFPROCID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ToPSWFProcName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TOPSWFPROCNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_WFLinkType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFLINKTYPE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSWFLink pSWFLink) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSWFLink)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSWFLink pSWFLink) throws Exception {
        super.onUpdateParent((IEntity)pSWFLink);
    }

    protected void onCopyDetails(PSWFLink pSWFLink, Object object) throws Exception {
        PSWFLink pSWFLink2 = new PSWFLink();
        pSWFLink2.set("PSWFLINKID", object);
        String string = DataObject.getStringValue((Object)pSWFLink.get("PSWFLINKID"));
        super.onCopyDetails((IEntity)pSWFLink, object);
    }

    @Override
    protected void exportCurXmlModel(PSWFLink pSWFLink, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSWFLINK");
        if (!bl) {
            pSWFLink.setFromPSWFProcId(null);
            pSWFLink.setPSDEId(null);
            pSWFLink.setPSWFDEId(null);
            pSWFLink.setToPSWFProcId(null);
            pSWFLink.setPSSystemId(null);
            pSWFLink.setPSWFVersionId(null);
            pSWFLink.setPSWFVersionName(null);
            pSWFLink.setWFEngineType(null);
            super.exportCurXmlModel(pSWFLink, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSWFLink pSWFLink, XmlNode xmlNode) throws Exception {
        this.exportRelatedXmlModel_PSWFLinkCond(pSWFLink, xmlNode);
        this.exportRelatedXmlModel_PSWFLinkRole(pSWFLink, xmlNode);
        super.onExportRelatedXmlModel(pSWFLink, xmlNode);
    }

    protected void exportRelatedXmlModel_PSWFLinkCond(PSWFLink pSWFLink, XmlNode xmlNode) throws Exception {
        PSWFLinkCondService pSWFLinkCondService = (PSWFLinkCondService)ServiceGlobal.getService(PSWFLinkCondService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSWFLinkCond> arrayList = null;
        String string = pSWFLink.getPSWFLinkId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSWFLinkCondService.selectByPSWFLink(pSWFLink, "ORDER BY ORDERVALUE ASC") : pSWFLinkCondService.selectTempByPSWFLink(pSWFLink, "ORDER BY ORDERVALUE ASC");
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSWFLINKCONDS");
            xmlNode.addNode(xmlNode2);
            for (PSWFLinkCond pSWFLinkCond : arrayList) {
                if (pSWFLinkCond.getPPSWFLinkCondId() != null) continue;
                pSWFLinkCond.set("ORDERVALUE", null);
                pSWFLinkCondService.exportXmlModel(pSWFLinkCond, xmlNode2);
            }
        }
    }

    protected void exportRelatedXmlModel_PSWFLinkRole(PSWFLink pSWFLink, XmlNode xmlNode) throws Exception {
        PSWFLinkRoleService pSWFLinkRoleService = (PSWFLinkRoleService)ServiceGlobal.getService(PSWFLinkRoleService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSWFLinkRole> arrayList = null;
        String string = pSWFLink.getPSWFLinkId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSWFLinkRoleService.selectByPSWFLink(pSWFLink) : pSWFLinkRoleService.selectTempByPSWFLink(pSWFLink);
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSWFLINKROLES");
            xmlNode.addNode(xmlNode2);
            for (PSWFLinkRole pSWFLinkRole : arrayList) {
                pSWFLinkRoleService.exportXmlModel(pSWFLinkRole, xmlNode2);
            }
        }
    }

    @Override
    protected void onImportRelatedXmlModel(PSWFLink pSWFLink, XmlNode xmlNode) throws Exception {
        XmlNode xmlNode2 = xmlNode.getChildNodeByNodeName("PSWFLINKCONDS");
        this.importRelatedXmlModel_PSWFLinkCond(pSWFLink, xmlNode2);
        XmlNode xmlNode3 = xmlNode.getChildNodeByNodeName("PSWFLINKROLES");
        this.importRelatedXmlModel_PSWFLinkRole(pSWFLink, xmlNode3);
        super.onImportRelatedXmlModel(pSWFLink, xmlNode);
    }

    protected void importRelatedXmlModel_PSWFLinkCond(PSWFLink pSWFLink, XmlNode xmlNode) throws Exception {
        int n = 100;
        PSWFLinkCondService pSWFLinkCondService = (PSWFLinkCondService)ServiceGlobal.getService(PSWFLinkCondService.class, (SessionFactory)this.getSessionFactory());
        String string = pSWFLink.getPSWFLinkId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSWFLinkCondService.removeByPSWFLink(pSWFLink);
        } else {
            pSWFLinkCondService.removeTempByPSWFLink(pSWFLink);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSWFLinkCond pSWFLinkCond = new PSWFLinkCond();
                pSWFLinkCond.setOrderValue(n);
                n += 100;
                pSWFLinkCondService.fillParentInfo((IEntity)pSWFLinkCond, "DER1N", "DER1N_PSWFLINKCOND_PSWFLINK_PSWFLINKID", pSWFLink.getPSWFLinkId());
                pSWFLinkCondService.importXmlModel(pSWFLinkCond, xmlNode2);
            }
        }
    }

    protected void importRelatedXmlModel_PSWFLinkRole(PSWFLink pSWFLink, XmlNode xmlNode) throws Exception {
        PSWFLinkRoleService pSWFLinkRoleService = (PSWFLinkRoleService)ServiceGlobal.getService(PSWFLinkRoleService.class, (SessionFactory)this.getSessionFactory());
        String string = pSWFLink.getPSWFLinkId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSWFLinkRoleService.removeByPSWFLink(pSWFLink);
        } else {
            pSWFLinkRoleService.removeTempByPSWFLink(pSWFLink);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSWFLinkRole pSWFLinkRole = new PSWFLinkRole();
                pSWFLinkRoleService.fillParentInfo((IEntity)pSWFLinkRole, "DER1N", "DER1N_PSWFLINKROLE_PSWFLINK_PSWFLINKID", pSWFLink.getPSWFLinkId());
                pSWFLinkRoleService.importXmlModel(pSWFLinkRole, xmlNode2);
            }
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSWFLink pSWFLink, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSWFLink, string);
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
            return "DER1N_PSWFLINK_PSWFVERSION_PSWFVERSIONID";
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
    public String getModelV2Tag(PSWFLink pSWFLink) {
        if (!StringHelper.isNullOrEmpty((String)pSWFLink.getCodeName())) {
            return pSWFLink.getCodeName();
        }
        return super.getModelV2Tag(pSWFLink);
    }

    @Override
    public boolean setModelV2Tag(PSWFLink pSWFLink, String string) {
        pSWFLink.setCodeName(string);
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
    public boolean getModelV2Entity(PSWFLink pSWFLink, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSWFLink.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSWFLink, true);
        pSWFLink.set("CODENAME", string);
        if (this.select(pSWFLink, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSWFLink, true);
        return super.getModelV2Entity(pSWFLink, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSWFLink pSWFLink, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSWFLink, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        if (StringHelper.compare((String)"DER1N_PSWFLINKROLE_PSWFLINK_PSWFLINKID", (String)string, (boolean)true) == 0) {
            return false;
        }
        return StringHelper.compare((String)"DER1N_PSWFLINKCOND_PSWFLINK_PSWFLINKID", (String)string, (boolean)true) != 0;
    }

    @Override
    protected void onExportRelatedModelV2(PSWFLink pSWFLink, String string, String string2) throws Exception {
        Object var4_4 = null;
        super.onExportRelatedModelV2(pSWFLink, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSWFLink pSWFLink, ObjectNode objectNode, String string, boolean bl) throws Exception {
        Object object;
        EntityBase entityBase2;
        Object object2;
        ArrayNode arrayNode;
        Object object3;
        ArrayList<PSWFLinkRole> arrayList;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSWFLINKROLE_PSWFLINK_PSWFLINKID")) {
            pSCoreSysServiceBase = (PSWFLinkRoleService)ServiceGlobal.getService(PSWFLinkRoleService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSWFLINK#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSWFLINKROLE", (Object)pSWFLink.getPSWFLinkId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object3 = PSModelV2Helper.readFile2(file);
                    arrayNode = ((ArrayList)object3).iterator();
                    while (arrayNode.hasNext()) {
                        object2 = (String)arrayNode.next();
                        if (StringHelper.isNullOrEmpty((String)object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString((String)object2);
                        arrayList.add((PSWFLinkRole)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList<PSWFLinkRole>();
                object3 = ((PSWFLinkRoleServiceBase)pSCoreSysServiceBase).selectByPSWFLink(pSWFLink);
                arrayNode = StringHelper.format((String)"PSWFLINK#%1$s", (Object)pSWFLink.getPSWFLinkId());
                object2 = ((ArrayList)object3).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSWFLinkRole)object2.next();
                    object = ((PSWFLinkRoleServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare(arrayNode, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSWFLinkRole)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
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
                        if (objectNode.has("pswflinkrolename")) {
                            string = objectNode.get("pswflinkrolename").asText();
                        }
                        if (objectNode2.has("pswflinkrolename")) {
                            string2 = objectNode2.get("pswflinkrolename").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSWFLinkRole();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    arrayNode.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSWFLINKCOND_PSWFLINK_PSWFLINKID")) {
            pSCoreSysServiceBase = (PSWFLinkCondService)ServiceGlobal.getService(PSWFLinkCondService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSWFLINK#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSWFLINKCOND", (Object)pSWFLink.getPSWFLinkId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object3 = PSModelV2Helper.readFile2(file);
                    arrayNode = ((ArrayList)object3).iterator();
                    while (arrayNode.hasNext()) {
                        object2 = (String)arrayNode.next();
                        if (StringHelper.isNullOrEmpty(object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSWFLinkRole)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList();
                object3 = ((PSWFLinkCondServiceBase)pSCoreSysServiceBase).selectByPSWFLink(pSWFLink);
                arrayNode = StringHelper.format((String)"PSWFLINK#%1$s", (Object)pSWFLink.getPSWFLinkId());
                object2 = ((ArrayList)object3).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSWFLinkCond)object2.next();
                    object = ((PSWFLinkCondServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare((String)arrayNode, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSWFLinkRole)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
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
                        if (objectNode.has("pswflinkcondname")) {
                            string = objectNode.get("pswflinkcondname").asText();
                        }
                        if (objectNode2.has("pswflinkcondname")) {
                            string2 = objectNode2.get("pswflinkcondname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSWFLinkCond();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    ((PSWFLinkCondBase)object).remove("ordervalue");
                    arrayNode.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        super.onExportCurModelV2(pSWFLink, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSWFLink pSWFLink) throws Exception {
        String string;
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSWFLinkRoleService)ServiceGlobal.getService(PSWFLinkRoleService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<EntityBase> arrayList = ((PSWFLinkRoleServiceBase)pSCoreSysServiceBase).selectByPSWFLink(pSWFLink);
        String string2 = StringHelper.format((String)"PSWFLINK#%1$s", (Object)pSWFLink.getPSWFLinkId());
        for (PSWFLinkRole entityBase : arrayList) {
            string = ((PSWFLinkRoleServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase);
            if (StringHelper.compare((String)string2, (String)string, (boolean)false) != 0) continue;
            pSCoreSysServiceBase.emptyModelV2(entityBase);
        }
        Object object = new SqlParamList();
        object.addString(pSWFLink.getPSWFLinkId());
        ((PSWFLinkRoleServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        ((PSWFLinkRoleServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "DELETE FROM T_SRFPSWFLINKROLE WHERE PSWFLINKID = ?", (SqlParamList)object);
        pSCoreSysServiceBase = (PSWFLinkCondService)ServiceGlobal.getService(PSWFLinkCondService.class, (SessionFactory)this.getSessionFactory());
        arrayList = ((PSWFLinkCondServiceBase)pSCoreSysServiceBase).selectByPSWFLink(pSWFLink);
        string2 = StringHelper.format((String)"PSWFLINK#%1$s", (Object)pSWFLink.getPSWFLinkId());
        for (PSWFLinkCond pSWFLinkCond : arrayList) {
            string = ((PSWFLinkCondServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)pSWFLinkCond);
            if (StringHelper.compare((String)string2, (String)string, (boolean)false) != 0) continue;
            pSCoreSysServiceBase.emptyModelV2(pSWFLinkCond);
        }
        object = new SqlParamList();
        object.addString(pSWFLink.getPSWFLinkId());
        ((PSWFLinkCondServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        ((PSWFLinkCondServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "DELETE FROM T_SRFPSWFLINKCOND WHERE PSWFLINKID = ?", (SqlParamList)object);
        super.onEmptyModelV2(pSWFLink);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSWFLinkRoleService)ServiceGlobal.getService(PSWFLinkRoleService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSWFLinkCondService)ServiceGlobal.getService(PSWFLinkCondService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSWFLink pSWFLink, String string, String string2) throws Exception {
        IEntity iEntity = null;
        EntityBase entityBase = new PSWFLinkRole();
        entityBase.set("PSWFLINKID", pSWFLink.getPSWFLinkId());
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSWFLinkRoleService)ServiceGlobal.getService(PSWFLinkRoleService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSWFLinkCond();
        entityBase.set("PSWFLINKID", pSWFLink.getPSWFLinkId());
        pSCoreSysServiceBase = (PSWFLinkCondService)ServiceGlobal.getService(PSWFLinkCondService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSWFLink, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSWFLink pSWFLink, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        File[] fileArray;
        Object object;
        Object object2;
        int n2;
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSWFLinkRoleService)ServiceGlobal.getService(PSWFLinkRoleService.class, (SessionFactory)this.getSessionFactory());
        ArrayNode arrayNode = null;
        String string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (n2 = 0; n2 < arrayNode.size(); ++n2) {
                object2 = (ObjectNode)arrayNode.get(n2);
                object = new PSWFLinkRole();
                ((PSWFLinkRoleBase)object).setPSWFLinkId(pSWFLink.getPSWFLinkId());
                ((PSWFLinkRoleBase)object).setPSWFLinkName(pSWFLink.getPSWFLinkName());
                ((PSWFLinkRoleBase)object).setPSWFProcessId(pSWFLink.getFromPSWFProcId());
                ((PSWFLinkRoleBase)object).setPSWFVersionId(pSWFLink.getPSWFVersionId());
                pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
            }
        } else {
            String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            object2 = new File(string4);
            if (((File)object2).exists()) {
                object = ((File)object2).listFiles();
                fileArray = object;
                int n3 = fileArray.length;
                for (int i = 0; i < n3; ++i) {
                    File file = fileArray[i];
                    if (!file.isDirectory()) continue;
                    PSWFLinkRole serializable = new PSWFLinkRole();
                    serializable.setPSWFLinkId(pSWFLink.getPSWFLinkId());
                    serializable.setPSWFLinkName(pSWFLink.getPSWFLinkName());
                    serializable.setPSWFProcessId(pSWFLink.getFromPSWFProcId());
                    serializable.setPSWFVersionId(pSWFLink.getPSWFVersionId());
                    pSCoreSysServiceBase.compileModelV2(serializable, null, string, file.getCanonicalPath(), n);
                }
            }
        }
        pSCoreSysServiceBase = (PSWFLinkCondService)ServiceGlobal.getService(PSWFLinkCondService.class, (SessionFactory)this.getSessionFactory());
        arrayNode = null;
        string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
        n2 = 0;
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                object = (ObjectNode)arrayNode.get(i);
                fileArray = new PSWFLinkCond();
                fileArray.setPSWFLinkId(pSWFLink.getPSWFLinkId());
                fileArray.setPSWFLinkName(pSWFLink.getPSWFLinkName());
                fileArray.setOrderValue(n2 += 10);
                pSCoreSysServiceBase.compileModelV2(fileArray, (ObjectNode)object, string, null, n);
            }
        } else {
            object2 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            object = new File((String)object2);
            if (((File)object).exists()) {
                for (File file : fileArray = ((File)object).listFiles()) {
                    if (!file.isDirectory()) continue;
                    PSWFLinkCond pSWFLinkCond = new PSWFLinkCond();
                    pSWFLinkCond.setPSWFLinkId(pSWFLink.getPSWFLinkId());
                    pSWFLinkCond.setPSWFLinkName(pSWFLink.getPSWFLinkName());
                    pSCoreSysServiceBase.compileModelV2(pSWFLinkCond, null, string, file.getCanonicalPath(), n);
                }
            }
        }
        super.onCompileRelatedModelV2(pSWFLink, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSWFLink pSWFLink, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSWFLINKROLE_PSWFLINK_PSWFLINKID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSWFLinkRoles(pSWFLink, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSWFLINKCOND_PSWFLINK_PSWFLINKID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSWFLinkConds(pSWFLink, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSWFLink, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSWFLinkRoles(PSWFLink pSWFLink, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSWFLINKROLE", true), (boolean)false) == 0) {
            PSWFLinkRoleService pSWFLinkRoleService = (PSWFLinkRoleService)ServiceGlobal.getService(PSWFLinkRoleService.class, (SessionFactory)this.getSessionFactory());
            PSWFLinkRole pSWFLinkRole = new PSWFLinkRole();
            pSWFLinkRole.setPSWFLinkRoleId(pSMOSFile.getPSModelId());
            if (!pSWFLinkRoleService.get((IEntity)pSWFLinkRole, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSWFLinkRole.getPSWFLinkId(), (String)pSWFLink.getPSWFLinkId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSWFLinkRoleService.exportModelV2(pSWFLinkRole);
            pSWFLinkRole.reset();
            if (!pSWFLinkRoleService.setModelV2ResScope((IEntity)pSWFLinkRole, "PSWFLINK", pSWFLink.getPSWFLinkId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSWFLinkRoleService.importModelV2(pSWFLinkRole, objectNode);
            SessionFactoryManager.commit();
            return pSWFLinkRoleService.getFile((IEntity)pSWFLinkRole);
        }
        return null;
    }

    protected PSMOSFile onPasteFile_PSWFLinkConds(PSWFLink pSWFLink, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSWFLINKCOND", true), (boolean)false) == 0) {
            PSWFLinkCondService pSWFLinkCondService = (PSWFLinkCondService)ServiceGlobal.getService(PSWFLinkCondService.class, (SessionFactory)this.getSessionFactory());
            PSWFLinkCond pSWFLinkCond = new PSWFLinkCond();
            pSWFLinkCond.setPSWFLinkCondId(pSMOSFile.getPSModelId());
            if (!pSWFLinkCondService.get((IEntity)pSWFLinkCond, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSWFLinkCond.getPSWFLinkId(), (String)pSWFLink.getPSWFLinkId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSWFLinkCondService.exportModelV2(pSWFLinkCond);
            pSWFLinkCond.reset();
            if (!pSWFLinkCondService.setModelV2ResScope((IEntity)pSWFLinkCond, "PSWFLINK", pSWFLink.getPSWFLinkId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSWFLinkCondService.importModelV2(pSWFLinkCond, objectNode);
            SessionFactoryManager.commit();
            return pSWFLinkCondService.getFile((IEntity)pSWFLinkCond);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSWFLink pSWFLink, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSWFLinkRoles(pSWFLink, list);
        this.onFillPasteHelps_PSWFLinkConds(pSWFLink, list);
        super.onFillPasteHelps(pSWFLink, list);
    }

    protected void onFillPasteHelps_PSWFLinkRoles(PSWFLink pSWFLink, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSWFLINKROLE");
        pSHelpSection.setSectionParam2("DER1N_PSWFLINKROLE_PSWFLINK_PSWFLINKID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u6d41\u7a0b\u5904\u7406\u8fde\u63a5]\u7684[\u6d41\u7a0b\u5904\u7406\u8fde\u63a5\u89d2\u8272]");
        list.add(pSHelpSection);
    }

    protected void onFillPasteHelps_PSWFLinkConds(PSWFLink pSWFLink, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSWFLINKCOND");
        pSHelpSection.setSectionParam2("DER1N_PSWFLINKCOND_PSWFLINK_PSWFLINKID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u6d41\u7a0b\u5904\u7406\u8fde\u63a5]\u7684[\u6d41\u7a0b\u5904\u7406\u8fde\u63a5\u6761\u4ef6]");
        list.add(pSHelpSection);
    }

    @Override
    public Object getDataType(PSWFLink pSWFLink) throws Exception {
        return pSWFLink.getWFLinkType();
    }
}

