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
import net.ibizsys.pscore.srv.dedesign.dao.PSDEFValueRuleDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEFValueRuleDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFVRCond;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFVRCondBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFValueRule;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFieldBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEForm;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFormBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionLogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionLogicServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionVRService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionVRServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDSParamService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDSParamServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFIVRService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFIVRServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFSFItemService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFSFItemServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFVRCondService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFVRCondServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFVRDSParamService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFVRDSParamServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGEIVRService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGEIVRServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicNodeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicNodeServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDESAVRService;
import net.ibizsys.pscore.srv.dedesign.service.PSDESAVRServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEVRGrpDetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEVRGrpDetailServiceBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageResBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItemBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPluginBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDEActionParamService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDEActionParamServiceBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEFValueRuleServiceBase
extends PSCoreSysServiceBase<PSDEFValueRule> {
    private static final Log log = LogFactory.getLog(PSDEFValueRuleServiceBase.class);
    public static final String DATASET_CURDE = "CurDE";
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_CREATEWITHMODEL = "CreateWithModel";
    public static final String ACTION_GETDRAFTFROMWITHMODEL = "GetDraftFromWithModel";
    public static final String ACTION_GETDRAFTWITHMODEL = "GetDraftWithModel";
    public static final String ACTION_GETWITHMODEL = "GetWithModel";
    public static final String ACTION_PREVIEWSAVE = "PreviewSave";
    public static final String ACTION_UPDATEWITHMODEL = "UpdateWithModel";
    private static Map<String, String> defaultValueMap = new HashMap<String, String>();
    private PSDEFValueRuleDEModel pSDEFValueRuleDEModel;
    private PSDEFValueRuleDAO pSDEFValueRuleDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEFValueRuleService";
    }

    public PSDEFValueRuleDEModel getPSDEFValueRuleDEModel() {
        if (this.pSDEFValueRuleDEModel == null) {
            try {
                this.pSDEFValueRuleDEModel = (PSDEFValueRuleDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEFValueRuleDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEFValueRuleDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEFValueRuleDEModel();
    }

    public PSDEFValueRuleDAO getPSDEFValueRuleDAO() {
        if (this.pSDEFValueRuleDAO == null) {
            try {
                this.pSDEFValueRuleDAO = (PSDEFValueRuleDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDEFValueRuleDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEFValueRuleDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEFValueRuleDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURDE, (boolean)true) == 0) {
            return this.fetchCurDE(iDEDataSetFetchContext);
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
        if (StringHelper.compare((String)string, (String)DATASET_CURDE, (boolean)true) == 0) {
            return this.fetchTempCurDE(iDEDataSetFetchContext);
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
            this.createWithModel((PSDEFValueRule)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_GETDRAFTFROMWITHMODEL, (boolean)true) == 0) {
            this.getDraftFromWithModel((PSDEFValueRule)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_GETDRAFTWITHMODEL, (boolean)true) == 0) {
            this.getDraftWithModel((PSDEFValueRule)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_GETWITHMODEL, (boolean)true) == 0) {
            this.getWithModel((PSDEFValueRule)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_PREVIEWSAVE, (boolean)true) == 0) {
            this.previewSave((PSDEFValueRule)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_UPDATEWITHMODEL, (boolean)true) == 0) {
            this.updateWithModel((PSDEFValueRule)iEntity);
            return;
        }
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

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, true);
        return dBFetchResult;
    }

    public void createWithModel(PSDEFValueRule pSDEFValueRule) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_CREATEWITHMODEL, 0, (IEntity)pSDEFValueRule, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSDEFValueRule, ACTION_CREATEWITHMODEL);
        final PSDEFValueRule pSDEFValueRule2 = pSDEFValueRule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEFValueRuleServiceBase.this.getService(), PSDEFValueRuleServiceBase.ACTION_CREATEWITHMODEL, 40, (IEntity)pSDEFValueRule2, null).getResult() != 1) {
                    PSDEFValueRuleServiceBase.this.onCreateWithModel(pSDEFValueRule2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_CREATEWITHMODEL, 99, (IEntity)pSDEFValueRule, null);
        }
    }

    protected void onCreateWithModel(PSDEFValueRule pSDEFValueRule) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[CreateWithModel]");
    }

    public void getDraftFromWithModel(PSDEFValueRule pSDEFValueRule) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_GETDRAFTFROMWITHMODEL, 0, (IEntity)pSDEFValueRule, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSDEFValueRule, ACTION_GETDRAFTFROMWITHMODEL);
        final PSDEFValueRule pSDEFValueRule2 = pSDEFValueRule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEFValueRuleServiceBase.this.getService(), PSDEFValueRuleServiceBase.ACTION_GETDRAFTFROMWITHMODEL, 40, (IEntity)pSDEFValueRule2, null).getResult() != 1) {
                    PSDEFValueRuleServiceBase.this.onGetDraftFromWithModel(pSDEFValueRule2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_GETDRAFTFROMWITHMODEL, 99, (IEntity)pSDEFValueRule, null);
        }
    }

    protected void onGetDraftFromWithModel(PSDEFValueRule pSDEFValueRule) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[GetDraftFromWithModel]");
    }

    public void getDraftWithModel(PSDEFValueRule pSDEFValueRule) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_GETDRAFTWITHMODEL, 0, (IEntity)pSDEFValueRule, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSDEFValueRule, ACTION_GETDRAFTWITHMODEL);
        final PSDEFValueRule pSDEFValueRule2 = pSDEFValueRule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEFValueRuleServiceBase.this.getService(), PSDEFValueRuleServiceBase.ACTION_GETDRAFTWITHMODEL, 40, (IEntity)pSDEFValueRule2, null).getResult() != 1) {
                    PSDEFValueRuleServiceBase.this.onGetDraftWithModel(pSDEFValueRule2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_GETDRAFTWITHMODEL, 99, (IEntity)pSDEFValueRule, null);
        }
    }

    protected void onGetDraftWithModel(PSDEFValueRule pSDEFValueRule) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[GetDraftWithModel]");
    }

    public void getWithModel(PSDEFValueRule pSDEFValueRule) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_GETWITHMODEL, 0, (IEntity)pSDEFValueRule, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSDEFValueRule, ACTION_GETWITHMODEL);
        final PSDEFValueRule pSDEFValueRule2 = pSDEFValueRule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEFValueRuleServiceBase.this.getService(), PSDEFValueRuleServiceBase.ACTION_GETWITHMODEL, 40, (IEntity)pSDEFValueRule2, null).getResult() != 1) {
                    PSDEFValueRuleServiceBase.this.onGetWithModel(pSDEFValueRule2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_GETWITHMODEL, 99, (IEntity)pSDEFValueRule, null);
        }
    }

    protected void onGetWithModel(PSDEFValueRule pSDEFValueRule) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[GetWithModel]");
    }

    public void previewSave(PSDEFValueRule pSDEFValueRule) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_PREVIEWSAVE, 0, (IEntity)pSDEFValueRule, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSDEFValueRule, ACTION_PREVIEWSAVE);
        final PSDEFValueRule pSDEFValueRule2 = pSDEFValueRule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEFValueRuleServiceBase.this.getService(), PSDEFValueRuleServiceBase.ACTION_PREVIEWSAVE, 40, (IEntity)pSDEFValueRule2, null).getResult() != 1) {
                    PSDEFValueRuleServiceBase.this.onPreviewSave(pSDEFValueRule2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_PREVIEWSAVE, 99, (IEntity)pSDEFValueRule, null);
        }
    }

    protected void onPreviewSave(PSDEFValueRule pSDEFValueRule) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[PreviewSave]");
    }

    public void updateWithModel(PSDEFValueRule pSDEFValueRule) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_UPDATEWITHMODEL, 0, (IEntity)pSDEFValueRule, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSDEFValueRule, ACTION_UPDATEWITHMODEL);
        final PSDEFValueRule pSDEFValueRule2 = pSDEFValueRule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEFValueRuleServiceBase.this.getService(), PSDEFValueRuleServiceBase.ACTION_UPDATEWITHMODEL, 40, (IEntity)pSDEFValueRule2, null).getResult() != 1) {
                    PSDEFValueRuleServiceBase.this.onUpdateWithModel(pSDEFValueRule2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_UPDATEWITHMODEL, 99, (IEntity)pSDEFValueRule, null);
        }
    }

    protected void onUpdateWithModel(PSDEFValueRule pSDEFValueRule) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[UpdateWithModel]");
    }

    protected void onFillParentInfo(PSDEFValueRule pSDEFValueRule, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFVALUERULE_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSDEFValueRule, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFVALUERULE_PSDEFIELD_PSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_PSDEF(pSDEFValueRule, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFVALUERULE_PSDEFORM_PSDEFORMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFormService", (SessionFactory)this.getSessionFactory());
            PSDEForm pSDEForm = (PSDEForm)iService.getDEModel().createEntity();
            pSDEForm.set("PSDEFORMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEForm);
            } else {
                iService.get((IEntity)pSDEForm);
            }
            this.onFillParentInfo_PSDEForm(pSDEFValueRule, pSDEForm);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFVALUERULE_PSLANGUAGERES_RIPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSLanguageRes);
            } else {
                iService.get((IEntity)pSLanguageRes);
            }
            this.onFillParentInfo_RIPSLanRes(pSDEFValueRule, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFVALUERULE_PSSYSDYNAMODEL_PSSYSDYNAMODELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService", (SessionFactory)this.getSessionFactory());
            PSSysDynaModel pSSysDynaModel = (PSSysDynaModel)iService.getDEModel().createEntity();
            pSSysDynaModel.set("PSSYSDYNAMODELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysDynaModel);
            } else {
                iService.get((IEntity)pSSysDynaModel);
            }
            this.onFillParentInfo_PSSysDynaModel(pSDEFValueRule, pSSysDynaModel);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFVALUERULE_PSSYSPFPLUGIN_PSSYSPFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysPFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysPFPlugin pSSysPFPlugin = (PSSysPFPlugin)iService.getDEModel().createEntity();
            pSSysPFPlugin.set("PSSYSPFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysPFPlugin);
            } else {
                iService.get((IEntity)pSSysPFPlugin);
            }
            this.onFillParentInfo_PSSysPFPlugin(pSDEFValueRule, pSSysPFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFVALUERULE_PSSYSREQITEM_PSSYSREQITEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemService", (SessionFactory)this.getSessionFactory());
            PSSysReqItem pSSysReqItem = (PSSysReqItem)iService.getDEModel().createEntity();
            pSSysReqItem.set("PSSYSREQITEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysReqItem);
            } else {
                iService.get((IEntity)pSSysReqItem);
            }
            this.onFillParentInfo_PSSysReqItem(pSDEFValueRule, pSSysReqItem);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFVALUERULE_PSSYSSFPLUGIN_PSSYSSFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysSFPlugin pSSysSFPlugin = (PSSysSFPlugin)iService.getDEModel().createEntity();
            pSSysSFPlugin.set("PSSYSSFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysSFPlugin);
            } else {
                iService.get((IEntity)pSSysSFPlugin);
            }
            this.onFillParentInfo_PSSysSFPlugin(pSDEFValueRule, pSSysSFPlugin);
            return;
        }
        super.onFillParentInfo((IEntity)pSDEFValueRule, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDE(PSDEFValueRule pSDEFValueRule, PSDataEntity pSDataEntity) throws Exception {
        pSDEFValueRule.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSDEFValueRule.setPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_PSDEF(PSDEFValueRule pSDEFValueRule, PSDEField pSDEField) throws Exception {
        pSDEFValueRule.setPSDEFId(pSDEField.getPSDEFieldId());
        pSDEFValueRule.setPSDEFName(pSDEField.getPSDEFieldName());
        if (pSDEField.getPSDE() != null) {
            this.onFillParentInfo_PSDE(pSDEFValueRule, pSDEField.getPSDE());
        }
    }

    protected void onFillParentInfo_PSDEForm(PSDEFValueRule pSDEFValueRule, PSDEForm pSDEForm) throws Exception {
        pSDEFValueRule.setPSDEFormId(pSDEForm.getPSDEFormId());
        pSDEFValueRule.setPSDEFormName(pSDEForm.getPSDEFormName());
    }

    protected void onFillParentInfo_RIPSLanRes(PSDEFValueRule pSDEFValueRule, PSLanguageRes pSLanguageRes) throws Exception {
        pSDEFValueRule.setRIPSLanResId(pSLanguageRes.getPSLanguageResId());
        pSDEFValueRule.setRIPSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_PSSysDynaModel(PSDEFValueRule pSDEFValueRule, PSSysDynaModel pSSysDynaModel) throws Exception {
        pSDEFValueRule.setPSSysDynaModelId(pSSysDynaModel.getPSSysDynaModelId());
        pSDEFValueRule.setPSSysDynaModelName(pSSysDynaModel.getPSSysDynaModelName());
    }

    protected void onFillParentInfo_PSSysPFPlugin(PSDEFValueRule pSDEFValueRule, PSSysPFPlugin pSSysPFPlugin) throws Exception {
        pSDEFValueRule.setPSSysPFPluginId(pSSysPFPlugin.getPSSysPFPluginId());
        pSDEFValueRule.setPSSysPFPluginName(pSSysPFPlugin.getPSSysPFPluginName());
    }

    protected void onFillParentInfo_PSSysReqItem(PSDEFValueRule pSDEFValueRule, PSSysReqItem pSSysReqItem) throws Exception {
        pSDEFValueRule.setPSSysReqItemId(pSSysReqItem.getPSSysReqItemId());
        pSDEFValueRule.setPSSysReqItemName(pSSysReqItem.getPSSysReqItemName());
    }

    protected void onFillParentInfo_PSSysSFPlugin(PSDEFValueRule pSDEFValueRule, PSSysSFPlugin pSSysSFPlugin) throws Exception {
        pSDEFValueRule.setPSSysSFPluginId(pSSysSFPlugin.getPSSysSFPluginId());
        pSDEFValueRule.setPSSysSFPluginName(pSSysSFPlugin.getPSSysSFPluginName());
    }

    protected void onFillEntityFullInfo(PSDEFValueRule pSDEFValueRule, boolean bl) throws Exception {
        if (bl) {
            if (pSDEFValueRule.getCodeName() == null) {
                pSDEFValueRule.setCodeName((String)this.getDefaultValue(this.getWebContext(), "USER", "DEFValueRule", 25));
            }
            if (pSDEFValueRule.getDefaultMode() == null) {
                pSDEFValueRule.setDefaultMode((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
            if (pSDEFValueRule.getPSDEFValueRuleName() == null) {
                pSDEFValueRule.setPSDEFValueRuleName((String)this.getDefaultValue(this.getWebContext(), "USER", "\u503c\u89c4\u5219", 25));
            }
            if (pSDEFValueRule.getVRType() == null) {
                pSDEFValueRule.setVRType((String)this.getDefaultValue(this.getWebContext(), "", "NORMAL", 25));
            }
        }
        super.onFillEntityFullInfo((IEntity)pSDEFValueRule, bl);
        this.onFillEntityFullInfo_PSDE(pSDEFValueRule, bl);
        this.onFillEntityFullInfo_PSDEF(pSDEFValueRule, bl);
        this.onFillEntityFullInfo_PSDEForm(pSDEFValueRule, bl);
        this.onFillEntityFullInfo_RIPSLanRes(pSDEFValueRule, bl);
        this.onFillEntityFullInfo_PSSysDynaModel(pSDEFValueRule, bl);
        this.onFillEntityFullInfo_PSSysPFPlugin(pSDEFValueRule, bl);
        this.onFillEntityFullInfo_PSSysReqItem(pSDEFValueRule, bl);
        this.onFillEntityFullInfo_PSSysSFPlugin(pSDEFValueRule, bl);
    }

    protected void onFillEntityFullInfo_PSDE(PSDEFValueRule pSDEFValueRule, boolean bl) throws Exception {
        if (pSDEFValueRule.isPSDEIdDirty()) {
            if (pSDEFValueRule.getPSDEId() != null) {
                if (pSDEFValueRule.getPSDEId() == null || pSDEFValueRule.getPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSDEFValueRule.getPSDE();
                    pSDEFValueRule.setPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSDEFValueRule.setPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDEF(PSDEFValueRule pSDEFValueRule, boolean bl) throws Exception {
        if (pSDEFValueRule.isPSDEFIdDirty()) {
            if (pSDEFValueRule.getPSDEFId() != null) {
                PSDEField pSDEField;
                if (pSDEFValueRule.getPSDEFId() == null || pSDEFValueRule.getPSDEFName() == null) {
                    pSDEField = pSDEFValueRule.getPSDEF();
                    pSDEFValueRule.setPSDEFName(pSDEField.getPSDEFieldName());
                }
                if (DataTypeHelper.compare((int)25, (Object)(pSDEField = pSDEFValueRule.getPSDEF()).getPSDEId(), (Object)pSDEFValueRule.getPSDEId()) != 0L) {
                    pSDEFValueRule.setPSDEId(pSDEField.getPSDEId());
                    this.onFillEntityFullInfo_PSDE(pSDEFValueRule, bl);
                }
            } else {
                pSDEFValueRule.setPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDEForm(PSDEFValueRule pSDEFValueRule, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_RIPSLanRes(PSDEFValueRule pSDEFValueRule, boolean bl) throws Exception {
        if (pSDEFValueRule.isRIPSLanResIdDirty()) {
            if (pSDEFValueRule.getRIPSLanResId() != null) {
                if (pSDEFValueRule.getRIPSLanResId() == null || pSDEFValueRule.getRIPSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSDEFValueRule.getRIPSLanRes();
                    pSDEFValueRule.setRIPSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSDEFValueRule.setRIPSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysDynaModel(PSDEFValueRule pSDEFValueRule, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysPFPlugin(PSDEFValueRule pSDEFValueRule, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysReqItem(PSDEFValueRule pSDEFValueRule, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysSFPlugin(PSDEFValueRule pSDEFValueRule, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDEFValueRule pSDEFValueRule, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDEFValueRule, bl);
    }

    public ArrayList<PSDEFValueRule> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSDEFValueRule> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSDEFValueRule> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEFValueRule> selectByPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSDEFValueRule> selectByPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSDEFValueRule> selectByPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFValueRule> selectByPSDEForm(PSDEFormBase pSDEFormBase) throws Exception {
        return this.selectByPSDEForm(pSDEFormBase, "", -1);
    }

    public ArrayList<PSDEFValueRule> selectByPSDEForm(PSDEFormBase pSDEFormBase, String string) throws Exception {
        return this.selectByPSDEForm(pSDEFormBase, string, -1);
    }

    public ArrayList<PSDEFValueRule> selectByPSDEForm(PSDEFormBase pSDEFormBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEFValueRule> selectByRIPSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByRIPSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSDEFValueRule> selectByRIPSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByRIPSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSDEFValueRule> selectByRIPSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("RIPSLANRESID", (Object)pSLanguageResBase.getPSLanguageResId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByRIPSLanResCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByRIPSLanResCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFValueRule> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, "", -1);
    }

    public ArrayList<PSDEFValueRule> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, string, -1);
    }

    public ArrayList<PSDEFValueRule> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEFValueRule> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, "", -1);
    }

    public ArrayList<PSDEFValueRule> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, string, -1);
    }

    public ArrayList<PSDEFValueRule> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEFValueRule> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase) throws Exception {
        return this.selectByPSSysReqItem(pSSysReqItemBase, "", -1);
    }

    public ArrayList<PSDEFValueRule> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase, String string) throws Exception {
        return this.selectByPSSysReqItem(pSSysReqItemBase, string, -1);
    }

    public ArrayList<PSDEFValueRule> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEFValueRule> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, "", -1);
    }

    public ArrayList<PSDEFValueRule> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, string, -1);
    }

    public ArrayList<PSDEFValueRule> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string, int n) throws Exception {
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

    public void testRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEFValueRule> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSDEFValueRule pSDEFValueRule : arrayList) {
            PSDEFValueRule pSDEFValueRule2 = (PSDEFValueRule)this.getDEModel().createEntity();
            pSDEFValueRule2.setPSDEFValueRuleId(pSDEFValueRule.getPSDEFValueRuleId());
            pSDEFValueRule2.setPSDEId(null);
            this.update(pSDEFValueRule2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFValueRuleServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSDEFValueRuleServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSDEFValueRuleServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEFValueRule> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSDEFValueRule pSDEFValueRule : arrayList) {
            this.remove((IEntity)pSDEFValueRule);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEFValueRule> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEFValueRule> arrayList) throws Exception {
    }

    public void testRemoveByPSDEF(PSDEField pSDEField) throws Exception {
    }

    public void resetPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEFValueRule> arrayList = this.selectByPSDEF(pSDEField);
        for (PSDEFValueRule pSDEFValueRule : arrayList) {
            PSDEFValueRule pSDEFValueRule2 = (PSDEFValueRule)this.getDEModel().createEntity();
            pSDEFValueRule2.setPSDEFValueRuleId(pSDEFValueRule.getPSDEFValueRuleId());
            pSDEFValueRule2.setPSDEFId(null);
            this.update(pSDEFValueRule2);
        }
    }

    public void removeByPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFValueRuleServiceBase.this.onBeforeRemoveByPSDEF(pSDEField2);
                PSDEFValueRuleServiceBase.this.internalRemoveByPSDEF(pSDEField2);
                PSDEFValueRuleServiceBase.this.onAfterRemoveByPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEFValueRule> arrayList = this.selectByPSDEF(pSDEField);
        this.onBeforeRemoveByPSDEF(pSDEField, arrayList);
        for (PSDEFValueRule pSDEFValueRule : arrayList) {
            this.remove((IEntity)pSDEFValueRule);
        }
        this.onAfterRemoveByPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByPSDEF(PSDEField pSDEField, ArrayList<PSDEFValueRule> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEF(PSDEField pSDEField, ArrayList<PSDEFValueRule> arrayList) throws Exception {
    }

    public void testRemoveByPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSDEFValueRule> arrayList = this.selectByPSDEForm(pSDEForm, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFORM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEForm);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFVALUERULE_PSDEFORM_PSDEFORMID", "", iDataEntityModel.getName(), "PSDEFVALUERULE", iDataEntityModel.getDataInfo((IEntity)pSDEForm), arrayList.get(0)));
        }
    }

    public void resetPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSDEFValueRule> arrayList = this.selectByPSDEForm(pSDEForm);
        for (PSDEFValueRule pSDEFValueRule : arrayList) {
            PSDEFValueRule pSDEFValueRule2 = (PSDEFValueRule)this.getDEModel().createEntity();
            pSDEFValueRule2.setPSDEFValueRuleId(pSDEFValueRule.getPSDEFValueRuleId());
            pSDEFValueRule2.setPSDEFormId(null);
            this.update(pSDEFValueRule2);
        }
    }

    public void removeByPSDEForm(PSDEForm pSDEForm) throws Exception {
        final PSDEForm pSDEForm2 = pSDEForm;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFValueRuleServiceBase.this.onBeforeRemoveByPSDEForm(pSDEForm2);
                PSDEFValueRuleServiceBase.this.internalRemoveByPSDEForm(pSDEForm2);
                PSDEFValueRuleServiceBase.this.onAfterRemoveByPSDEForm(pSDEForm2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void internalRemoveByPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSDEFValueRule> arrayList = this.selectByPSDEForm(pSDEForm);
        this.onBeforeRemoveByPSDEForm(pSDEForm, arrayList);
        for (PSDEFValueRule pSDEFValueRule : arrayList) {
            this.remove((IEntity)pSDEFValueRule);
        }
        this.onAfterRemoveByPSDEForm(pSDEForm, arrayList);
    }

    protected void onAfterRemoveByPSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void onBeforeRemoveByPSDEForm(PSDEForm pSDEForm, ArrayList<PSDEFValueRule> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEForm(PSDEForm pSDEForm, ArrayList<PSDEFValueRule> arrayList) throws Exception {
    }

    public void testRemoveByRIPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEFValueRule> arrayList = this.selectByRIPSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFVALUERULE_PSLANGUAGERES_RIPSLANRESID", "", iDataEntityModel.getName(), "PSDEFVALUERULE", iDataEntityModel.getDataInfo((IEntity)pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetRIPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEFValueRule> arrayList = this.selectByRIPSLanRes(pSLanguageRes);
        for (PSDEFValueRule pSDEFValueRule : arrayList) {
            PSDEFValueRule pSDEFValueRule2 = (PSDEFValueRule)this.getDEModel().createEntity();
            pSDEFValueRule2.setPSDEFValueRuleId(pSDEFValueRule.getPSDEFValueRuleId());
            pSDEFValueRule2.setRIPSLanResId(null);
            this.update(pSDEFValueRule2);
        }
    }

    public void removeByRIPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFValueRuleServiceBase.this.onBeforeRemoveByRIPSLanRes(pSLanguageRes2);
                PSDEFValueRuleServiceBase.this.internalRemoveByRIPSLanRes(pSLanguageRes2);
                PSDEFValueRuleServiceBase.this.onAfterRemoveByRIPSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByRIPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByRIPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEFValueRule> arrayList = this.selectByRIPSLanRes(pSLanguageRes);
        this.onBeforeRemoveByRIPSLanRes(pSLanguageRes, arrayList);
        for (PSDEFValueRule pSDEFValueRule : arrayList) {
            this.remove((IEntity)pSDEFValueRule);
        }
        this.onAfterRemoveByRIPSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByRIPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByRIPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEFValueRule> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRIPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEFValueRule> arrayList) throws Exception {
    }

    public void testRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSDEFValueRule> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSDYNAMODEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysDynaModel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFVALUERULE_PSSYSDYNAMODEL_PSSYSDYNAMODELID", "", iDataEntityModel.getName(), "PSDEFVALUERULE", iDataEntityModel.getDataInfo((IEntity)pSSysDynaModel), arrayList.get(0)));
        }
    }

    public void resetPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSDEFValueRule> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        for (PSDEFValueRule pSDEFValueRule : arrayList) {
            PSDEFValueRule pSDEFValueRule2 = (PSDEFValueRule)this.getDEModel().createEntity();
            pSDEFValueRule2.setPSDEFValueRuleId(pSDEFValueRule.getPSDEFValueRuleId());
            pSDEFValueRule2.setPSSysDynaModelId(null);
            this.update(pSDEFValueRule2);
        }
    }

    public void removeByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        final PSSysDynaModel pSSysDynaModel2 = pSSysDynaModel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFValueRuleServiceBase.this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSDEFValueRuleServiceBase.this.internalRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSDEFValueRuleServiceBase.this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void internalRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSDEFValueRule> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
        for (PSDEFValueRule pSDEFValueRule : arrayList) {
            this.remove((IEntity)pSDEFValueRule);
        }
        this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSDEFValueRule> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSDEFValueRule> arrayList) throws Exception {
    }

    public void testRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEFValueRule> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSPFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysPFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFVALUERULE_PSSYSPFPLUGIN_PSSYSPFPLUGINID", "", iDataEntityModel.getName(), "PSDEFVALUERULE", iDataEntityModel.getDataInfo((IEntity)pSSysPFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEFValueRule> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        for (PSDEFValueRule pSDEFValueRule : arrayList) {
            PSDEFValueRule pSDEFValueRule2 = (PSDEFValueRule)this.getDEModel().createEntity();
            pSDEFValueRule2.setPSDEFValueRuleId(pSDEFValueRule.getPSDEFValueRuleId());
            pSDEFValueRule2.setPSSysPFPluginId(null);
            this.update(pSDEFValueRule2);
        }
    }

    public void removeByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        final PSSysPFPlugin pSSysPFPlugin2 = pSSysPFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFValueRuleServiceBase.this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSDEFValueRuleServiceBase.this.internalRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSDEFValueRuleServiceBase.this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEFValueRule> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
        for (PSDEFValueRule pSDEFValueRule : arrayList) {
            this.remove((IEntity)pSDEFValueRule);
        }
        this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSDEFValueRule> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSDEFValueRule> arrayList) throws Exception {
    }

    public void testRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<PSDEFValueRule> arrayList = this.selectByPSSysReqItem(pSSysReqItem, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSREQITEM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysReqItem);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFVALUERULE_PSSYSREQITEM_PSSYSREQITEMID", "", iDataEntityModel.getName(), "PSDEFVALUERULE", iDataEntityModel.getDataInfo((IEntity)pSSysReqItem), arrayList.get(0)));
        }
    }

    public void resetPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<PSDEFValueRule> arrayList = this.selectByPSSysReqItem(pSSysReqItem);
        for (PSDEFValueRule pSDEFValueRule : arrayList) {
            PSDEFValueRule pSDEFValueRule2 = (PSDEFValueRule)this.getDEModel().createEntity();
            pSDEFValueRule2.setPSDEFValueRuleId(pSDEFValueRule.getPSDEFValueRuleId());
            pSDEFValueRule2.setPSSysReqItemId(null);
            this.update(pSDEFValueRule2);
        }
    }

    public void removeByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        final PSSysReqItem pSSysReqItem2 = pSSysReqItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFValueRuleServiceBase.this.onBeforeRemoveByPSSysReqItem(pSSysReqItem2);
                PSDEFValueRuleServiceBase.this.internalRemoveByPSSysReqItem(pSSysReqItem2);
                PSDEFValueRuleServiceBase.this.onAfterRemoveByPSSysReqItem(pSSysReqItem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
    }

    protected void internalRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<PSDEFValueRule> arrayList = this.selectByPSSysReqItem(pSSysReqItem);
        this.onBeforeRemoveByPSSysReqItem(pSSysReqItem, arrayList);
        for (PSDEFValueRule pSDEFValueRule : arrayList) {
            this.remove((IEntity)pSDEFValueRule);
        }
        this.onAfterRemoveByPSSysReqItem(pSSysReqItem, arrayList);
    }

    protected void onAfterRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
    }

    protected void onBeforeRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem, ArrayList<PSDEFValueRule> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem, ArrayList<PSDEFValueRule> arrayList) throws Exception {
    }

    public void testRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSDEFValueRule> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSSFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysSFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFVALUERULE_PSSYSSFPLUGIN_PSSYSSFPLUGINID", "", iDataEntityModel.getName(), "PSDEFVALUERULE", iDataEntityModel.getDataInfo((IEntity)pSSysSFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSDEFValueRule> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        for (PSDEFValueRule pSDEFValueRule : arrayList) {
            PSDEFValueRule pSDEFValueRule2 = (PSDEFValueRule)this.getDEModel().createEntity();
            pSDEFValueRule2.setPSDEFValueRuleId(pSDEFValueRule.getPSDEFValueRuleId());
            pSDEFValueRule2.setPSSysSFPluginId(null);
            this.update(pSDEFValueRule2);
        }
    }

    public void removeByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        final PSSysSFPlugin pSSysSFPlugin2 = pSSysSFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFValueRuleServiceBase.this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSDEFValueRuleServiceBase.this.internalRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSDEFValueRuleServiceBase.this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSDEFValueRule> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
        for (PSDEFValueRule pSDEFValueRule : arrayList) {
            this.remove((IEntity)pSDEFValueRule);
        }
        this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSDEFValueRule> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSDEFValueRule> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDEFValueRule pSDEFValueRule) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEActionLogicService)ServiceGlobal.getService(PSDEActionLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEActionLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSDEFValueRule(pSDEFValueRule);
        pSCoreSysServiceBase = (PSDEActionParamService)ServiceGlobal.getService(PSDEActionParamService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEActionParamServiceBase)pSCoreSysServiceBase).testRemoveByPSDEFValueRule(pSDEFValueRule);
        pSCoreSysServiceBase = (PSDEActionVRService)ServiceGlobal.getService(PSDEActionVRService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEActionVRServiceBase)pSCoreSysServiceBase).testRemoveByPSDEFVR(pSDEFValueRule);
        pSCoreSysServiceBase = (PSDEDSParamService)ServiceGlobal.getService(PSDEDSParamService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDSParamServiceBase)pSCoreSysServiceBase).testRemoveByPSDEFValueRule(pSDEFValueRule);
        pSCoreSysServiceBase = (PSDEFIVRService)ServiceGlobal.getService(PSDEFIVRService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFIVRServiceBase)pSCoreSysServiceBase).testRemoveByPSDEFVR(pSDEFValueRule);
        pSCoreSysServiceBase = (PSDEFSFItemService)ServiceGlobal.getService(PSDEFSFItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFSFItemServiceBase)pSCoreSysServiceBase).testRemoveByPSDEFValueRule(pSDEFValueRule);
        pSCoreSysServiceBase = (PSDEFVRCondService)ServiceGlobal.getService(PSDEFVRCondService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFVRCondServiceBase)pSCoreSysServiceBase).testRemoveByPSDEFVR(pSDEFValueRule);
        ((PSDEFVRCondServiceBase)pSCoreSysServiceBase).removeByPSDEFVR(pSDEFValueRule);
        pSCoreSysServiceBase = (PSDEFVRDSParamService)ServiceGlobal.getService(PSDEFVRDSParamService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFVRDSParamServiceBase)pSCoreSysServiceBase).testRemoveByPSDEFVR(pSDEFValueRule);
        ((PSDEFVRDSParamServiceBase)pSCoreSysServiceBase).removeByPSDEFVR(pSDEFValueRule);
        pSCoreSysServiceBase = (PSDEGEIVRService)ServiceGlobal.getService(PSDEGEIVRService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEGEIVRServiceBase)pSCoreSysServiceBase).testRemoveByPSDEFVR(pSDEFValueRule);
        pSCoreSysServiceBase = (PSDELogicNodeService)ServiceGlobal.getService(PSDELogicNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDELogicNodeServiceBase)pSCoreSysServiceBase).testRemoveByDstPSDEFValueRule(pSDEFValueRule);
        pSCoreSysServiceBase = (PSDESAVRService)ServiceGlobal.getService(PSDESAVRService.class, (SessionFactory)this.getSessionFactory());
        ((PSDESAVRServiceBase)pSCoreSysServiceBase).testRemoveByPSDEFVR(pSDEFValueRule);
        pSCoreSysServiceBase = (PSDEVRGrpDetailService)ServiceGlobal.getService(PSDEVRGrpDetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEVRGrpDetailServiceBase)pSCoreSysServiceBase).testRemoveByPSDEFValueRule(pSDEFValueRule);
        super.onBeforeRemove(pSDEFValueRule);
    }

    protected void onBeforeRemoveTemp(PSDEFValueRule pSDEFValueRule) throws Exception {
        PSDEFVRCondService pSDEFVRCondService = (PSDEFVRCondService)ServiceGlobal.getService(PSDEFVRCondService.class, (SessionFactory)this.getSessionFactory());
        pSDEFVRCondService.removeTempByPSDEFVR(pSDEFValueRule);
        super.onBeforeRemoveTemp((IEntity)pSDEFValueRule);
    }

    protected void getRelatedDataTempMajor(PSDEFValueRule pSDEFValueRule) throws Exception {
        this.getRelatedDataTempMajor_PSDEFVRCond(pSDEFValueRule);
        super.getRelatedDataTempMajor((IEntity)pSDEFValueRule);
    }

    protected void getRelatedDataTempMajor_PSDEFVRCond(PSDEFValueRule pSDEFValueRule) throws Exception {
        PSDEFVRCondService pSDEFVRCondService = (PSDEFVRCondService)ServiceGlobal.getService(PSDEFVRCondService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEFVRCond> arrayList = null;
        String string = pSDEFValueRule.getPSDEFValueRuleId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEFVRCondService.selectByPSDEFVR(pSDEFValueRule) : pSDEFVRCondService.selectTempByPSDEFVR(pSDEFValueRule);
        PSDEFValueRuleServiceBase.sortHierarchyEntities(arrayList, (String)"PSDEFVRCONDID", (String)"PPSDEFVRCONDID");
        for (PSDEFVRCond pSDEFVRCond : arrayList) {
            pSDEFVRCondService.getTempMajor(pSDEFVRCond);
        }
    }

    protected void updateRelatedDataTempMajor(PSDEFValueRule pSDEFValueRule, PSDEFValueRule pSDEFValueRule2) throws Exception {
        ArrayList<PSDEFVRCond> arrayList = this.updateRelatedDataTempMajor_removePSDEFVRCond(pSDEFValueRule, pSDEFValueRule2);
        this.updateRelatedDataTempMajor_updatePSDEFVRCond(pSDEFValueRule, pSDEFValueRule2, arrayList);
        super.updateRelatedDataTempMajor((IEntity)pSDEFValueRule, (IEntity)pSDEFValueRule2);
    }

    protected ArrayList<PSDEFVRCond> updateRelatedDataTempMajor_removePSDEFVRCond(PSDEFValueRule pSDEFValueRule, PSDEFValueRule pSDEFValueRule2) throws Exception {
        PSDEFVRCondService pSDEFVRCondService = (PSDEFVRCondService)ServiceGlobal.getService(PSDEFVRCondService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEFVRCond> arrayList = pSDEFVRCondService.selectTempByPSDEFVR(pSDEFValueRule);
        ArrayList<PSDEFVRCond> arrayList2 = pSDEFVRCondService.selectByPSDEFVR(pSDEFValueRule2);
        HashMap<String, PSDEFVRCond> hashMap = new HashMap<String, PSDEFVRCond>();
        for (PSDEFVRCond pSDEFVRCond : arrayList2) {
            hashMap.put(pSDEFVRCond.getPSDEFVRCondId(), pSDEFVRCond);
        }
        PSDEFValueRuleServiceBase.sortHierarchyEntities(arrayList, (String)"PSDEFVRCONDID", (String)"PPSDEFVRCONDID");
        for (PSDEFVRCond pSDEFVRCond : arrayList) {
            Object object = pSDEFVRCond.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSDEFVRCond pSDEFVRCond : hashMap.values()) {
            pSDEFVRCondService.remove((IEntity)pSDEFVRCond);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSDEFVRCond(PSDEFValueRule pSDEFValueRule, PSDEFValueRule pSDEFValueRule2, ArrayList<PSDEFVRCond> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSDEFVRCondService pSDEFVRCondService = (PSDEFVRCondService)ServiceGlobal.getService(PSDEFVRCondService.class, (SessionFactory)this.getSessionFactory());
        for (PSDEFVRCond pSDEFVRCond : arrayList) {
            pSDEFVRCondService.updateTempMajor(pSDEFVRCond);
        }
    }

    protected void replaceParentInfo(PSDEFValueRule pSDEFValueRule, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDEFValueRule, cloneSession);
        if (pSDEFValueRule.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSDEFValueRule.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSDEFValueRule, (PSDataEntity)iEntity);
        }
        if (pSDEFValueRule.getPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSDEFValueRule.getPSDEFId())) != null) {
            this.onFillParentInfo_PSDEF(pSDEFValueRule, (PSDEField)iEntity);
        }
        if (pSDEFValueRule.getPSDEFormId() != null && (iEntity = cloneSession.getEntity("PSDEFORM", (Object)pSDEFValueRule.getPSDEFormId())) != null) {
            this.onFillParentInfo_PSDEForm(pSDEFValueRule, (PSDEForm)iEntity);
        }
        if (pSDEFValueRule.getRIPSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSDEFValueRule.getRIPSLanResId())) != null) {
            this.onFillParentInfo_RIPSLanRes(pSDEFValueRule, (PSLanguageRes)iEntity);
        }
        if (pSDEFValueRule.getPSSysDynaModelId() != null && (iEntity = cloneSession.getEntity("PSSYSDYNAMODEL", (Object)pSDEFValueRule.getPSSysDynaModelId())) != null) {
            this.onFillParentInfo_PSSysDynaModel(pSDEFValueRule, (PSSysDynaModel)iEntity);
        }
        if (pSDEFValueRule.getPSSysPFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSPFPLUGIN", (Object)pSDEFValueRule.getPSSysPFPluginId())) != null) {
            this.onFillParentInfo_PSSysPFPlugin(pSDEFValueRule, (PSSysPFPlugin)iEntity);
        }
        if (pSDEFValueRule.getPSSysReqItemId() != null && (iEntity = cloneSession.getEntity("PSSYSREQITEM", (Object)pSDEFValueRule.getPSSysReqItemId())) != null) {
            this.onFillParentInfo_PSSysReqItem(pSDEFValueRule, (PSSysReqItem)iEntity);
        }
        if (pSDEFValueRule.getPSSysSFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSSFPLUGIN", (Object)pSDEFValueRule.getPSSysSFPluginId())) != null) {
            this.onFillParentInfo_PSSysSFPlugin(pSDEFValueRule, (PSSysSFPlugin)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDEFValueRule pSDEFValueRule, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDEFValueRule, bl);
    }

    protected void onCheckEntity(boolean bl, PSDEFValueRule pSDEFValueRule, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CheckDefault(bl, pSDEFValueRule, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSDEFValueRule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomCode(bl, pSDEFValueRule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomMode(bl, pSDEFValueRule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DefaultMode(bl, pSDEFValueRule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LockFlag(bl, pSDEFValueRule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDEFValueRule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSDEFValueRule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFId(bl, pSDEFValueRule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFName(bl, pSDEFValueRule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFormId(bl, pSDEFValueRule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFValueRuleId(bl, pSDEFValueRule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFValueRuleName(bl, pSDEFValueRule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSDEFValueRule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSDEFValueRule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDynaModelId(bl, pSDEFValueRule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysPFPluginId(bl, pSDEFValueRule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysReqItemId(bl, pSDEFValueRule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSFPluginId(bl, pSDEFValueRule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RIPSLanResId(bl, pSDEFValueRule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RIPSLanResName(bl, pSDEFValueRule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RuleHolder(bl, pSDEFValueRule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RuleInfo(bl, pSDEFValueRule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RuleTag(bl, pSDEFValueRule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RuleTag2(bl, pSDEFValueRule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ToDoTask(bl, pSDEFValueRule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSDEFValueRule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDEFValueRule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDEFValueRule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDEFValueRule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDEFValueRule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_VRMode(bl, pSDEFValueRule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_VRModel(bl, pSDEFValueRule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_VRType(bl, pSDEFValueRule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDEFValueRule, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CheckDefault(boolean bl, PSDEFValueRule pSDEFValueRule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFValueRule.isCheckDefaultDirty() : !pSDEFValueRule.isCheckDefaultDirty()) {
            return null;
        }
        Integer n = pSDEFValueRule.getCheckDefault();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CheckDefault_Default((IEntity)pSDEFValueRule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CHECKDEFAULT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSDEFValueRule pSDEFValueRule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFValueRule.isCodeNameDirty() : !pSDEFValueRule.isCodeNameDirty()) {
            return null;
        }
        String string = pSDEFValueRule.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default((IEntity)pSDEFValueRule, bl2, bl3);
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
                string3 = "PSDEFID";
                String string4 = this.checkFieldDupRule(this.getPSDEFValueRuleDEModel(), "CODENAME", string3, pSDEFValueRule, bl2, bl3);
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

    protected EntityFieldError onCheckField_CustomCode(boolean bl, PSDEFValueRule pSDEFValueRule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFValueRule.isCustomCodeDirty() : !pSDEFValueRule.isCustomCodeDirty()) {
            return null;
        }
        String string = pSDEFValueRule.getCustomCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomCode_Default((IEntity)pSDEFValueRule, bl2, bl3);
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

    protected EntityFieldError onCheckField_CustomMode(boolean bl, PSDEFValueRule pSDEFValueRule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFValueRule.isCustomModeDirty() : !pSDEFValueRule.isCustomModeDirty()) {
            return null;
        }
        Integer n = pSDEFValueRule.getCustomMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CustomMode_Default((IEntity)pSDEFValueRule, bl2, bl3);
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

    protected EntityFieldError onCheckField_DefaultMode(boolean bl, PSDEFValueRule pSDEFValueRule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFValueRule.isDefaultModeDirty() && !bl2 : !pSDEFValueRule.isDefaultModeDirty()) {
            return null;
        }
        Integer n = pSDEFValueRule.getDefaultMode();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFAULTMODE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_DefaultMode_Default((IEntity)pSDEFValueRule, bl2, bl3);
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
                string = "PSDEFID";
                String string2 = this.checkFieldDupRule(this.getPSDEFValueRuleDEModel(), "DEFAULTMODE", string, pSDEFValueRule, bl2, bl3);
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

    protected EntityFieldError onCheckField_LockFlag(boolean bl, PSDEFValueRule pSDEFValueRule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFValueRule.isLockFlagDirty() : !pSDEFValueRule.isLockFlagDirty()) {
            return null;
        }
        Integer n = pSDEFValueRule.getLockFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LockFlag_Default((IEntity)pSDEFValueRule, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDEFValueRule pSDEFValueRule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFValueRule.isMemoDirty() : !pSDEFValueRule.isMemoDirty()) {
            return null;
        }
        String string = pSDEFValueRule.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDEFValueRule, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSDEFValueRule pSDEFValueRule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFValueRule.isOrderValueDirty() : !pSDEFValueRule.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSDEFValueRule.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default((IEntity)pSDEFValueRule, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEFId(boolean bl, PSDEFValueRule pSDEFValueRule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFValueRule.isPSDEFIdDirty() && !bl2 : !pSDEFValueRule.isPSDEFIdDirty()) {
            return null;
        }
        String string = pSDEFValueRule.getPSDEFId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFId_PSDEF((IEntity)pSDEFValueRule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
            string2 = this.onTestValueRule_PSDEFId_Default((IEntity)pSDEFValueRule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFName(boolean bl, PSDEFValueRule pSDEFValueRule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFValueRule.isPSDEFNameDirty() && !bl2 : !pSDEFValueRule.isPSDEFNameDirty()) {
            return null;
        }
        String string = pSDEFValueRule.getPSDEFName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFName_Default((IEntity)pSDEFValueRule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFormId(boolean bl, PSDEFValueRule pSDEFValueRule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFValueRule.isPSDEFormIdDirty() : !pSDEFValueRule.isPSDEFormIdDirty()) {
            return null;
        }
        String string = pSDEFValueRule.getPSDEFormId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFormId_Default((IEntity)pSDEFValueRule, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEFValueRuleId(boolean bl, PSDEFValueRule pSDEFValueRule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFValueRule.isPSDEFValueRuleIdDirty() && !bl2 : !pSDEFValueRule.isPSDEFValueRuleIdDirty()) {
            return null;
        }
        String string = pSDEFValueRule.getPSDEFValueRuleId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFVALUERULEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFValueRuleId_Default((IEntity)pSDEFValueRule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFVALUERULEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFValueRuleName(boolean bl, PSDEFValueRule pSDEFValueRule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFValueRule.isPSDEFValueRuleNameDirty() && !bl2 : !pSDEFValueRule.isPSDEFValueRuleNameDirty()) {
            return null;
        }
        String string = pSDEFValueRule.getPSDEFValueRuleName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFVALUERULENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFValueRuleName_Default((IEntity)pSDEFValueRule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFVALUERULENAME");
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
                string3 = "PSDEFID";
                String string4 = this.checkFieldDupRule(this.getPSDEFValueRuleDEModel(), "PSDEFVALUERULENAME", string3, pSDEFValueRule, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDEFVALUERULENAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSDEFValueRule pSDEFValueRule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFValueRule.isPSDEIdDirty() && !bl2 : !pSDEFValueRule.isPSDEIdDirty()) {
            return null;
        }
        String string = pSDEFValueRule.getPSDEId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default((IEntity)pSDEFValueRule, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSDEFValueRule pSDEFValueRule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFValueRule.isPSDENameDirty() && !bl2 : !pSDEFValueRule.isPSDENameDirty()) {
            return null;
        }
        String string = pSDEFValueRule.getPSDEName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default((IEntity)pSDEFValueRule, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysDynaModelId(boolean bl, PSDEFValueRule pSDEFValueRule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFValueRule.isPSSysDynaModelIdDirty() : !pSDEFValueRule.isPSSysDynaModelIdDirty()) {
            return null;
        }
        String string = pSDEFValueRule.getPSSysDynaModelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDynaModelId_Default((IEntity)pSDEFValueRule, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysPFPluginId(boolean bl, PSDEFValueRule pSDEFValueRule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFValueRule.isPSSysPFPluginIdDirty() : !pSDEFValueRule.isPSSysPFPluginIdDirty()) {
            return null;
        }
        String string = pSDEFValueRule.getPSSysPFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysPFPluginId_Default((IEntity)pSDEFValueRule, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysReqItemId(boolean bl, PSDEFValueRule pSDEFValueRule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFValueRule.isPSSysReqItemIdDirty() : !pSDEFValueRule.isPSSysReqItemIdDirty()) {
            return null;
        }
        String string = pSDEFValueRule.getPSSysReqItemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysReqItemId_Default((IEntity)pSDEFValueRule, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysSFPluginId(boolean bl, PSDEFValueRule pSDEFValueRule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFValueRule.isPSSysSFPluginIdDirty() : !pSDEFValueRule.isPSSysSFPluginIdDirty()) {
            return null;
        }
        String string = pSDEFValueRule.getPSSysSFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSFPluginId_Default((IEntity)pSDEFValueRule, bl2, bl3);
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

    protected EntityFieldError onCheckField_RIPSLanResId(boolean bl, PSDEFValueRule pSDEFValueRule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFValueRule.isRIPSLanResIdDirty() : !pSDEFValueRule.isRIPSLanResIdDirty()) {
            return null;
        }
        String string = pSDEFValueRule.getRIPSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RIPSLanResId_Default((IEntity)pSDEFValueRule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RIPSLANRESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RIPSLanResName(boolean bl, PSDEFValueRule pSDEFValueRule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFValueRule.isRIPSLanResNameDirty() : !pSDEFValueRule.isRIPSLanResNameDirty()) {
            return null;
        }
        String string = pSDEFValueRule.getRIPSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RIPSLanResName_Default((IEntity)pSDEFValueRule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RIPSLANRESNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RuleHolder(boolean bl, PSDEFValueRule pSDEFValueRule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFValueRule.isRuleHolderDirty() : !pSDEFValueRule.isRuleHolderDirty()) {
            return null;
        }
        Integer n = pSDEFValueRule.getRuleHolder();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_RuleHolder_Default((IEntity)pSDEFValueRule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RULEHOLDER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RuleInfo(boolean bl, PSDEFValueRule pSDEFValueRule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFValueRule.isRuleInfoDirty() : !pSDEFValueRule.isRuleInfoDirty()) {
            return null;
        }
        String string = pSDEFValueRule.getRuleInfo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RuleInfo_Default((IEntity)pSDEFValueRule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RULEINFO");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RuleTag(boolean bl, PSDEFValueRule pSDEFValueRule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFValueRule.isRuleTagDirty() : !pSDEFValueRule.isRuleTagDirty()) {
            return null;
        }
        String string = pSDEFValueRule.getRuleTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RuleTag_Default((IEntity)pSDEFValueRule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RULETAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RuleTag2(boolean bl, PSDEFValueRule pSDEFValueRule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFValueRule.isRuleTag2Dirty() : !pSDEFValueRule.isRuleTag2Dirty()) {
            return null;
        }
        String string = pSDEFValueRule.getRuleTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RuleTag2_Default((IEntity)pSDEFValueRule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RULETAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ToDoTask(boolean bl, PSDEFValueRule pSDEFValueRule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFValueRule.isToDoTaskDirty() : !pSDEFValueRule.isToDoTaskDirty()) {
            return null;
        }
        String string = pSDEFValueRule.getToDoTask();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ToDoTask_Default((IEntity)pSDEFValueRule, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSDEFValueRule pSDEFValueRule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFValueRule.isUserCatDirty() : !pSDEFValueRule.isUserCatDirty()) {
            return null;
        }
        String string = pSDEFValueRule.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default((IEntity)pSDEFValueRule, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDEFValueRule pSDEFValueRule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFValueRule.isUserTagDirty() : !pSDEFValueRule.isUserTagDirty()) {
            return null;
        }
        String string = pSDEFValueRule.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSDEFValueRule, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDEFValueRule pSDEFValueRule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFValueRule.isUserTag2Dirty() : !pSDEFValueRule.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDEFValueRule.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSDEFValueRule, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDEFValueRule pSDEFValueRule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFValueRule.isUserTag3Dirty() : !pSDEFValueRule.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDEFValueRule.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default((IEntity)pSDEFValueRule, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDEFValueRule pSDEFValueRule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFValueRule.isUserTag4Dirty() : !pSDEFValueRule.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDEFValueRule.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default((IEntity)pSDEFValueRule, bl2, bl3);
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

    protected EntityFieldError onCheckField_VRMode(boolean bl, PSDEFValueRule pSDEFValueRule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFValueRule.isVRModeDirty() : !pSDEFValueRule.isVRModeDirty()) {
            return null;
        }
        String string = pSDEFValueRule.getVRMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_VRMode_Default((IEntity)pSDEFValueRule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VRMODE");
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
                string3 = "PSDEFID";
                String string4 = this.checkFieldDupRule(this.getPSDEFValueRuleDEModel(), "VRMODE", string3, pSDEFValueRule, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("VRMODE");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_VRModel(boolean bl, PSDEFValueRule pSDEFValueRule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFValueRule.isVRModelDirty() : !pSDEFValueRule.isVRModelDirty()) {
            return null;
        }
        String string = pSDEFValueRule.getVRModel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_VRModel_Default((IEntity)pSDEFValueRule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VRMODEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_VRType(boolean bl, PSDEFValueRule pSDEFValueRule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFValueRule.isVRTypeDirty() : !pSDEFValueRule.isVRTypeDirty()) {
            return null;
        }
        String string = pSDEFValueRule.getVRType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_VRType_Default((IEntity)pSDEFValueRule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VRTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDEFValueRule pSDEFValueRule, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDEFValueRule, bl);
    }

    protected void onSyncIndexEntities(PSDEFValueRule pSDEFValueRule, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDEFValueRule, bl);
    }

    public Object getDataContextValue(PSDEFValueRule pSDEFValueRule, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDEFValueRule, string, iDataContextParam)) != null) {
            return object;
        }
        PSDataEntity pSDataEntity = pSDEFValueRule.getPSDE();
        if (pSDataEntity != null && pSDataEntity.contains(string)) {
            return pSDataEntity.get(string);
        }
        PSDEField pSDEField = pSDEFValueRule.getPSDEF();
        if (pSDEField != null && pSDEField.contains(string)) {
            return pSDEField.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDEFValueRule pSDEFValueRule, ArrayList<JSONObject> arrayList, int n) throws Exception {
        this.onExportMajorModel_RIPSLanRes(pSDEFValueRule, arrayList, n);
        super.onExportMajorModel((IEntity)pSDEFValueRule, arrayList, n);
    }

    protected void onExportMajorModel_RIPSLanRes(PSDEFValueRule pSDEFValueRule, ArrayList<JSONObject> arrayList, int n) throws Exception {
        if (pSDEFValueRule.getRIPSLanRes() != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            iService.exportModel((IEntity)pSDEFValueRule.getRIPSLanRes(), arrayList, n);
        }
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CHECKDEFAULT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CheckDefault_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"DEFAULTMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DefaultMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOCKFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LockFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"PSDEF", (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFId_PSDEF(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFORMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFormId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFORMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFormName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFVALUERULEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFValueRuleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFVALUERULENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFValueRuleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSSYSSFPLUGINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSFPluginId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSFPLUGINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSFPluginName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RIPSLANRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RIPSLanResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RIPSLANRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RIPSLanResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RULEHOLDER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RuleHolder_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RULEINFO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RuleInfo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RULETAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RuleTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RULETAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RuleTag2_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"VRMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_VRMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VRMODEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_VRModel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VRTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_VRType_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_CheckDefault_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_DefaultMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldSimpleRule("DEFAULTMODE", iEntity, bl2, "NOTEQ", null, "1", "", true) || this.checkFieldQueryCountRule2("DEFAULTMODE", "DQ0001", iEntity, bl2, 0, true, 0, true, "\u5f53\u524d\u5c5e\u6027\u5df2\u7ecf\u5b58\u5728\u9ed8\u8ba4\u89c4\u5219", false, true)) {
                return null;
            }
            return "\u5c5e\u6027\u53ea\u80fd\u7531\u4e00\u4e2a\u9ed8\u8ba4\u89c4\u5219";
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

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSDEFId_PSDEF(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldDataSetRule("PSDEFID", "PSDEFIELD", DATASET_CURDE, iEntity, bl2, null, null, "\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d", true)) {
                return null;
            }
            return "\u5b9e\u4f53\u5c5e\u6027\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_PSDEFValueRuleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFVALUERULEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFValueRuleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFVALUERULENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_RIPSLanResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RIPSLANRESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RIPSLanResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RIPSLANRESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RuleHolder_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_RuleInfo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RULEINFO", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RuleTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RULETAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RuleTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RULETAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
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

    protected String onTestValueRule_VRMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VRMODE", iEntity, bl2, null, false, 10, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_VRModel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VRMODEL", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_VRType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VRTYPE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSDEFValueRule pSDEFValueRule) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDEFValueRule)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDEFValueRule pSDEFValueRule) throws Exception {
        IService iService;
        Object object = pSDEFValueRule.get("PSDEID");
        if (object != null) {
            iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSDEFVALUERULE_PSDATAENTITY_PSDEID", object);
        }
        if ((object = pSDEFValueRule.get("PSDEFID")) != null) {
            iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSDEFVALUERULE_PSDEFIELD_PSDEFID", object);
        }
        super.onUpdateParent((IEntity)pSDEFValueRule);
    }

    protected boolean isNeedUpdateParent() {
        return true;
    }

    protected void onCopyDetails(PSDEFValueRule pSDEFValueRule, Object object) throws Exception {
        PSDEFValueRule pSDEFValueRule2 = new PSDEFValueRule();
        pSDEFValueRule2.set("PSDEFVALUERULEID", object);
        String string = DataObject.getStringValue((Object)pSDEFValueRule.get("PSDEFVALUERULEID"));
        super.onCopyDetails((IEntity)pSDEFValueRule, object);
    }

    @Override
    protected void exportCurXmlModel(PSDEFValueRule pSDEFValueRule, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEFVALUERULE");
        if (!bl) {
            pSDEFValueRule.setCreateDate(null);
            pSDEFValueRule.setCreateMan(null);
            pSDEFValueRule.setPSDEFValueRuleId(null);
            pSDEFValueRule.setUpdateDate(null);
            pSDEFValueRule.setUpdateMan(null);
            super.exportCurXmlModel(pSDEFValueRule, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSDEFValueRule pSDEFValueRule, XmlNode xmlNode) throws Exception {
        this.exportRelatedXmlModel_PSDEFVRCond(pSDEFValueRule, xmlNode);
        super.onExportRelatedXmlModel(pSDEFValueRule, xmlNode);
    }

    protected void exportRelatedXmlModel_PSDEFVRCond(PSDEFValueRule pSDEFValueRule, XmlNode xmlNode) throws Exception {
        PSDEFVRCondService pSDEFVRCondService = (PSDEFVRCondService)ServiceGlobal.getService(PSDEFVRCondService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEFVRCond> arrayList = null;
        String string = pSDEFValueRule.getPSDEFValueRuleId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEFVRCondService.selectByPSDEFVR(pSDEFValueRule, "ORDER BY ORDERVALUE ASC") : pSDEFVRCondService.selectTempByPSDEFVR(pSDEFValueRule, "ORDER BY ORDERVALUE ASC");
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSDEFVRCONDS");
            xmlNode.addNode(xmlNode2);
            for (PSDEFVRCond pSDEFVRCond : arrayList) {
                if (pSDEFVRCond.getPPSDEFVRCondId() != null) continue;
                pSDEFVRCond.set("ORDERVALUE", null);
                pSDEFVRCondService.exportXmlModel(pSDEFVRCond, xmlNode2);
            }
        }
    }

    @Override
    protected void onImportRelatedXmlModel(PSDEFValueRule pSDEFValueRule, XmlNode xmlNode) throws Exception {
        XmlNode xmlNode2 = xmlNode.getChildNodeByNodeName("PSDEFVRCONDS");
        this.importRelatedXmlModel_PSDEFVRCond(pSDEFValueRule, xmlNode2);
        super.onImportRelatedXmlModel(pSDEFValueRule, xmlNode);
    }

    protected void importRelatedXmlModel_PSDEFVRCond(PSDEFValueRule pSDEFValueRule, XmlNode xmlNode) throws Exception {
        int n = 100;
        PSDEFVRCondService pSDEFVRCondService = (PSDEFVRCondService)ServiceGlobal.getService(PSDEFVRCondService.class, (SessionFactory)this.getSessionFactory());
        String string = pSDEFValueRule.getPSDEFValueRuleId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSDEFVRCondService.removeByPSDEFVR(pSDEFValueRule);
        } else {
            pSDEFVRCondService.removeTempByPSDEFVR(pSDEFValueRule);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSDEFVRCond pSDEFVRCond = new PSDEFVRCond();
                pSDEFVRCond.setOrderValue(n);
                n += 100;
                pSDEFVRCondService.fillParentInfo((IEntity)pSDEFVRCond, "DER1N", "DER1N_PSDEFVRCOND_PSDEFVALUERULE_PSDEFVRID", pSDEFValueRule.getPSDEFValueRuleId());
                pSDEFVRCondService.importXmlModel(pSDEFVRCond, xmlNode2);
            }
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDEFValueRule pSDEFValueRule, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDEFValueRule, string);
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
            return "DER1N_PSDEFVALUERULE_PSDATAENTITY_PSDEID";
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
    public String getModelV2Tag(PSDEFValueRule pSDEFValueRule) {
        if (!StringHelper.isNullOrEmpty((String)pSDEFValueRule.getCodeName())) {
            return pSDEFValueRule.getCodeName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSDEFValueRule.getPSDEFValueRuleName())) {
            return pSDEFValueRule.getPSDEFValueRuleName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSDEFValueRule.getCodeName())) {
            return pSDEFValueRule.getCodeName();
        }
        return super.getModelV2Tag(pSDEFValueRule);
    }

    @Override
    public boolean setModelV2Tag(PSDEFValueRule pSDEFValueRule, String string) {
        pSDEFValueRule.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("PSDEFVALUERULENAME", "");
        map.put("CODENAME", "");
        map.put("PSDEID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDEFValueRule pSDEFValueRule, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDEFValueRule.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDEFValueRule, true);
        pSDEFValueRule.set("CODENAME", string);
        if (this.select(pSDEFValueRule, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSDEFValueRule, true);
        return super.getModelV2Entity(pSDEFValueRule, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDEFValueRule pSDEFValueRule, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSDEFValueRule, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        return StringHelper.compare((String)"DER1N_PSDEFVRCOND_PSDEFVALUERULE_PSDEFVRID", (String)string, (boolean)true) != 0;
    }

    @Override
    protected void onExportRelatedModelV2(PSDEFValueRule pSDEFValueRule, String string, String string2) throws Exception {
        Object var4_4 = null;
        super.onExportRelatedModelV2(pSDEFValueRule, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSDEFValueRule pSDEFValueRule, ObjectNode objectNode, String string, boolean bl) throws Exception {
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDEFVRCOND_PSDEFVALUERULE_PSDEFVRID")) {
            Object object;
            PSDEFVRCond pSDEFVRCond2;
            Object object2;
            Object object3;
            Object object4;
            PSDEFVRCondService pSDEFVRCondService = (PSDEFVRCondService)ServiceGlobal.getService(PSDEFVRCondService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<PSDEFVRCond> arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDEFVALUERULE#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDEFVRCOND", (Object)pSDEFValueRule.getPSDEFValueRuleId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty((String)object2)) continue;
                        pSDEFVRCond2 = (ObjectNode)JsonNodeHelper.fromString((String)object2);
                        arrayList.add(pSDEFVRCond2);
                    }
                }
            } else {
                arrayList = new ArrayList<PSDEFVRCond>();
                object4 = pSDEFVRCondService.selectByPSDEFVR(pSDEFValueRule);
                object3 = StringHelper.format((String)"PSDEFVALUERULE#%1$s", (Object)pSDEFValueRule.getPSDEFValueRuleId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    pSDEFVRCond2 = object2.next();
                    object = pSDEFVRCondService.getModelV2ResScope((IEntity)pSDEFVRCond2);
                    if (StringHelper.compare((String)object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSDEFVRCond)PSModelV2Helper.toJSONObject((IEntity)pSDEFVRCond2, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                object4 = pSDEFVRCondService.getModelV2Name(false);
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
                        if (objectNode.has("psdefvrcondname")) {
                            string = objectNode.get("psdefvrcondname").asText();
                        }
                        if (objectNode2.has("psdefvrcondname")) {
                            string2 = objectNode2.get("psdefvrcondname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (PSDEFVRCond pSDEFVRCond2 : arrayList) {
                    object = new PSDEFVRCond();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)pSDEFVRCond2, false);
                    ((PSDEFVRCondBase)object).remove("ordervalue");
                    object3.add((JsonNode)pSDEFVRCondService.exportModelV2(object, string));
                }
            }
        }
        super.onExportCurModelV2(pSDEFValueRule, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSDEFValueRule pSDEFValueRule) throws Exception {
        PSDEFVRCondService pSDEFVRCondService = (PSDEFVRCondService)ServiceGlobal.getService(PSDEFVRCondService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEFVRCond> arrayList = pSDEFVRCondService.selectByPSDEFVR(pSDEFValueRule);
        String string = StringHelper.format((String)"PSDEFVALUERULE#%1$s", (Object)pSDEFValueRule.getPSDEFValueRuleId());
        for (PSDEFVRCond pSDEFVRCond : arrayList) {
            String string2 = pSDEFVRCondService.getModelV2ResScope((IEntity)pSDEFVRCond);
            if (StringHelper.compare((String)string, (String)string2, (boolean)false) != 0) continue;
            pSDEFVRCondService.emptyModelV2(pSDEFVRCond);
        }
        SqlParamList sqlParamList = new SqlParamList();
        sqlParamList.addString(pSDEFValueRule.getPSDEFValueRuleId());
        pSDEFVRCondService.getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        pSDEFVRCondService.getDAO().executeRawSql(null, "DELETE FROM T_SRFPSDEFVRCOND WHERE PSDEFVRID = ?", sqlParamList);
        super.onEmptyModelV2(pSDEFValueRule);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSDEFVRCondService pSDEFVRCondService = (PSDEFVRCondService)ServiceGlobal.getService(PSDEFVRCondService.class, (SessionFactory)this.getSessionFactory());
        if (pSDEFVRCondService.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSDEFValueRule pSDEFValueRule, String string, String string2) throws Exception {
        IEntity iEntity = null;
        PSDEFVRCond pSDEFVRCond = new PSDEFVRCond();
        pSDEFVRCond.set("PSDEFVRID", pSDEFValueRule.getPSDEFValueRuleId());
        PSDEFVRCondService pSDEFVRCondService = (PSDEFVRCondService)ServiceGlobal.getService(PSDEFVRCondService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSDEFVRCondService.getModelV2Entity(pSDEFVRCond, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSDEFValueRule, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSDEFValueRule pSDEFValueRule, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        PSDEFVRCondService pSDEFVRCondService = (PSDEFVRCondService)ServiceGlobal.getService(PSDEFVRCondService.class, (SessionFactory)this.getSessionFactory());
        ArrayNode arrayNode = null;
        String string3 = pSDEFVRCondService.getModelV2Name(null, false);
        int n2 = 0;
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                ObjectNode objectNode2 = (ObjectNode)arrayNode.get(i);
                PSDEFVRCond pSDEFVRCond = new PSDEFVRCond();
                pSDEFVRCond.setPSDEFVRId(pSDEFValueRule.getPSDEFValueRuleId());
                pSDEFVRCond.setPSDEFVRName(pSDEFValueRule.getPSDEFValueRuleName());
                pSDEFVRCond.setOrderValue(n2 += 10);
                pSDEFVRCondService.compileModelV2(pSDEFVRCond, objectNode2, string, null, n);
            }
        } else {
            String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            File file = new File(string4);
            if (file.exists()) {
                File[] fileArray;
                for (File file2 : fileArray = file.listFiles()) {
                    if (!file2.isDirectory()) continue;
                    PSDEFVRCond pSDEFVRCond = new PSDEFVRCond();
                    pSDEFVRCond.setPSDEFVRId(pSDEFValueRule.getPSDEFValueRuleId());
                    pSDEFVRCond.setPSDEFVRName(pSDEFValueRule.getPSDEFValueRuleName());
                    pSDEFVRCondService.compileModelV2(pSDEFVRCond, null, string, file2.getCanonicalPath(), n);
                }
            }
        }
        super.onCompileRelatedModelV2(pSDEFValueRule, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSDEFValueRule pSDEFValueRule, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSDEFVRCOND_PSDEFVALUERULE_PSDEFVRID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSDEFVRConds(pSDEFValueRule, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSDEFValueRule, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSDEFVRConds(PSDEFValueRule pSDEFValueRule, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDEFVRCOND", true), (boolean)false) == 0) {
            PSDEFVRCondService pSDEFVRCondService = (PSDEFVRCondService)ServiceGlobal.getService(PSDEFVRCondService.class, (SessionFactory)this.getSessionFactory());
            PSDEFVRCond pSDEFVRCond = new PSDEFVRCond();
            pSDEFVRCond.setPSDEFVRCondId(pSMOSFile.getPSModelId());
            if (!pSDEFVRCondService.get((IEntity)pSDEFVRCond, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSDEFVRCond.getPSDEFVRId(), (String)pSDEFValueRule.getPSDEFValueRuleId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSDEFVRCondService.exportModelV2(pSDEFVRCond);
            pSDEFVRCond.reset();
            if (!pSDEFVRCondService.setModelV2ResScope((IEntity)pSDEFVRCond, "PSDEFVALUERULE", pSDEFValueRule.getPSDEFValueRuleId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSDEFVRCondService.importModelV2(pSDEFVRCond, objectNode);
            SessionFactoryManager.commit();
            return pSDEFVRCondService.getFile((IEntity)pSDEFVRCond);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSDEFValueRule pSDEFValueRule, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSDEFVRConds(pSDEFValueRule, list);
        super.onFillPasteHelps(pSDEFValueRule, list);
    }

    protected void onFillPasteHelps_PSDEFVRConds(PSDEFValueRule pSDEFValueRule, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDEFVRCOND");
        pSHelpSection.setSectionParam2("DER1N_PSDEFVRCOND_PSDEFVALUERULE_PSDEFVRID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5b9e\u4f53\u5c5e\u6027\u503c\u89c4\u5219]\u7684[\u5c5e\u6027\u503c\u89c4\u5219\u9879]");
        list.add(pSHelpSection);
    }

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSDEFValueRule pSDEFValueRule, boolean bl) {
        return defaultValueMap;
    }

    static {
        defaultValueMap.put("CODENAME", "DEFValueRule");
        defaultValueMap.put("PSDEFVALUERULENAME", "\u503c\u89c4\u5219");
    }
}

