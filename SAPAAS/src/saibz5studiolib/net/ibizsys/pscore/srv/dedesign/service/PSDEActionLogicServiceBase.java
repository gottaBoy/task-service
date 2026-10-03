/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
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
 *  net.ibizsys.paas.demodel.DEModelGlobal
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
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.demodel.DEModelGlobal;
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
import net.ibizsys.pscore.srv.dedesign.dao.PSDEActionLogicDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEActionLogicDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEActionBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEActionLogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataQuery;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataQueryBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSetBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSync;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSyncBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFValueRule;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFValueRuleBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFieldBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogicBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEMainState;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEMainStateBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDENotify;
import net.ibizsys.pscore.srv.dedesign.entity.PSDENotifyBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDER;
import net.ibizsys.pscore.srv.dedesign.entity.PSDERBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageResBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDELogicNode;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDELogicNodeBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPluginBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSequence;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSequenceBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysTranslator;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysTranslatorBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysValueRule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysValueRuleBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEActionLogicServiceBase
extends PSCoreSysServiceBase<PSDEActionLogic> {
    private static final Log log = LogFactory.getLog(PSDEActionLogicServiceBase.class);
    public static final String DATASET_CURSYS2 = "CurSys2";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDEActionLogicDEModel pSDEActionLogicDEModel;
    private PSDEActionLogicDAO pSDEActionLogicDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEActionLogicService";
    }

    public PSDEActionLogicDEModel getPSDEActionLogicDEModel() {
        if (this.pSDEActionLogicDEModel == null) {
            try {
                this.pSDEActionLogicDEModel = (PSDEActionLogicDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEActionLogicDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEActionLogicDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEActionLogicDEModel();
    }

    public PSDEActionLogicDAO getPSDEActionLogicDAO() {
        if (this.pSDEActionLogicDAO == null) {
            try {
                this.pSDEActionLogicDAO = (PSDEActionLogicDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDEActionLogicDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEActionLogicDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEActionLogicDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURSYS2, (boolean)true) == 0) {
            return this.fetchCurSys2(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurSys2(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYS2, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSDEActionLogic pSDEActionLogic, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEACTIONLOGIC_PSDATAENTITY_DSTPSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDataEntity);
            } else {
                iService.get(pSDataEntity);
            }
            this.onFillParentInfo_DstPSDE(pSDEActionLogic, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEACTIONLOGIC_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDataEntity);
            } else {
                iService.get(pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSDEActionLogic, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEACTIONLOGIC_PSDEACTION_DSTPSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEAction);
            } else {
                iService.get(pSDEAction);
            }
            this.onFillParentInfo_DstPSDEAction(pSDEActionLogic, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEACTIONLOGIC_PSDEACTION_PSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEAction);
            } else {
                iService.get(pSDEAction);
            }
            this.onFillParentInfo_PSDEAction(pSDEActionLogic, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEACTIONLOGIC_PSDEDATAQUERY_DSTPSDEDATAQUERYID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataQueryService", (SessionFactory)this.getSessionFactory());
            PSDEDataQuery pSDEDataQuery = (PSDEDataQuery)iService.getDEModel().createEntity();
            pSDEDataQuery.set("PSDEDATAQUERYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEDataQuery);
            } else {
                iService.get(pSDEDataQuery);
            }
            this.onFillParentInfo_DstPSDEDataQuery(pSDEActionLogic, pSDEDataQuery);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEACTIONLOGIC_PSDEDATASET_DSTPSDEDATASETID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService", (SessionFactory)this.getSessionFactory());
            PSDEDataSet pSDEDataSet = (PSDEDataSet)iService.getDEModel().createEntity();
            pSDEDataSet.set("PSDEDATASETID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEDataSet);
            } else {
                iService.get(pSDEDataSet);
            }
            this.onFillParentInfo_DstPSDEDataSet(pSDEActionLogic, pSDEDataSet);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEACTIONLOGIC_PSDEDATASYNC_PSDEDATASYNCID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataSyncService", (SessionFactory)this.getSessionFactory());
            PSDEDataSync pSDEDataSync = (PSDEDataSync)iService.getDEModel().createEntity();
            pSDEDataSync.set("PSDEDATASYNCID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEDataSync);
            } else {
                iService.get(pSDEDataSync);
            }
            this.onFillParentInfo_PSDEDataSync(pSDEActionLogic, pSDEDataSync);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEACTIONLOGIC_PSDEFIELD_PSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_PSDEF(pSDEActionLogic, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEACTIONLOGIC_PSDEFVALUERULE_PSDEFVALUERULEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFValueRuleService", (SessionFactory)this.getSessionFactory());
            PSDEFValueRule pSDEFValueRule = (PSDEFValueRule)iService.getDEModel().createEntity();
            pSDEFValueRule.set("PSDEFVALUERULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEFValueRule);
            } else {
                iService.get(pSDEFValueRule);
            }
            this.onFillParentInfo_PSDEFValueRule(pSDEActionLogic, pSDEFValueRule);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEACTIONLOGIC_PSDELOGIC_DSTPSDELOGICID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDELogicService", (SessionFactory)this.getSessionFactory());
            PSDELogic pSDELogic = (PSDELogic)iService.getDEModel().createEntity();
            pSDELogic.set("PSDELOGICID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDELogic);
            } else {
                iService.get(pSDELogic);
            }
            this.onFillParentInfo_DstPSDELogic(pSDEActionLogic, pSDELogic);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEACTIONLOGIC_PSDELOGIC_PSDELOGICID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDELogicService", (SessionFactory)this.getSessionFactory());
            PSDELogic pSDELogic = (PSDELogic)iService.getDEModel().createEntity();
            pSDELogic.set("PSDELOGICID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDELogic);
            } else {
                iService.get(pSDELogic);
            }
            this.onFillParentInfo_PSDELogic(pSDEActionLogic, pSDELogic);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEACTIONLOGIC_PSDEMAINSTATE_PSDEMAINSTATEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEMainStateService", (SessionFactory)this.getSessionFactory());
            PSDEMainState pSDEMainState = (PSDEMainState)iService.getDEModel().createEntity();
            pSDEMainState.set("PSDEMAINSTATEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEMainState);
            } else {
                iService.get(pSDEMainState);
            }
            this.onFillParentInfo_PSDEMainState(pSDEActionLogic, pSDEMainState);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEACTIONLOGIC_PSDENOTIFY_PSDENOTIFYID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDENotifyService", (SessionFactory)this.getSessionFactory());
            PSDENotify pSDENotify = (PSDENotify)iService.getDEModel().createEntity();
            pSDENotify.set("PSDENOTIFYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDENotify);
            } else {
                iService.get(pSDENotify);
            }
            this.onFillParentInfo_PSDENotify(pSDEActionLogic, pSDENotify);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEACTIONLOGIC_PSDER_MAJORPSDERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDERService", (SessionFactory)this.getSessionFactory());
            PSDER pSDER = (PSDER)iService.getDEModel().createEntity();
            pSDER.set("PSDERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDER);
            } else {
                iService.get(pSDER);
            }
            this.onFillParentInfo_MajorPSDEId(pSDEActionLogic, pSDER);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEACTIONLOGIC_PSDER_MINORPSDERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDERService", (SessionFactory)this.getSessionFactory());
            PSDER pSDER = (PSDER)iService.getDEModel().createEntity();
            pSDER.set("PSDERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDER);
            } else {
                iService.get(pSDER);
            }
            this.onFillParentInfo_MinorPSDER(pSDEActionLogic, pSDER);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEACTIONLOGIC_PSLANGUAGERES_ERRORPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSLanguageRes);
            } else {
                iService.get(pSLanguageRes);
            }
            this.onFillParentInfo_ErrorPSLanRes(pSDEActionLogic, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEACTIONLOGIC_PSSYSDELOGICNODE_PSSYSDELOGICNODEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDELogicNodeService", (SessionFactory)this.getSessionFactory());
            PSSysDELogicNode pSSysDELogicNode = (PSSysDELogicNode)iService.getDEModel().createEntity();
            pSSysDELogicNode.set("PSSYSDELOGICNODEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysDELogicNode);
            } else {
                iService.get(pSSysDELogicNode);
            }
            this.onFillParentInfo_PSSysDELogicNode(pSDEActionLogic, pSSysDELogicNode);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEACTIONLOGIC_PSSYSPFPLUGIN_PSSYSPFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysPFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysPFPlugin pSSysPFPlugin = (PSSysPFPlugin)iService.getDEModel().createEntity();
            pSSysPFPlugin.set("PSSYSPFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysPFPlugin);
            } else {
                iService.get(pSSysPFPlugin);
            }
            this.onFillParentInfo_PSSysPFPlugin(pSDEActionLogic, pSSysPFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEACTIONLOGIC_PSSYSSEQUENCE_PSSYSSEQUENCEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysSequenceService", (SessionFactory)this.getSessionFactory());
            PSSysSequence pSSysSequence = (PSSysSequence)iService.getDEModel().createEntity();
            pSSysSequence.set("PSSYSSEQUENCEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysSequence);
            } else {
                iService.get(pSSysSequence);
            }
            this.onFillParentInfo_PSSysSequence(pSDEActionLogic, pSSysSequence);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEACTIONLOGIC_PSSYSSFPLUGIN_PSSYSSFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysSFPlugin pSSysSFPlugin = (PSSysSFPlugin)iService.getDEModel().createEntity();
            pSSysSFPlugin.set("PSSYSSFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysSFPlugin);
            } else {
                iService.get(pSSysSFPlugin);
            }
            this.onFillParentInfo_PSSysSFPlugin(pSDEActionLogic, pSSysSFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEACTIONLOGIC_PSSYSTRANSLATOR_PSSYSTRANSLATORID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysTranslatorService", (SessionFactory)this.getSessionFactory());
            PSSysTranslator pSSysTranslator = (PSSysTranslator)iService.getDEModel().createEntity();
            pSSysTranslator.set("PSSYSTRANSLATORID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysTranslator);
            } else {
                iService.get(pSSysTranslator);
            }
            this.onFillParentInfo_PSSysTranslator(pSDEActionLogic, pSSysTranslator);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEACTIONLOGIC_PSSYSVALUERULE_PSSYSVALUERULEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysValueRuleService", (SessionFactory)this.getSessionFactory());
            PSSysValueRule pSSysValueRule = (PSSysValueRule)iService.getDEModel().createEntity();
            pSSysValueRule.set("PSSYSVALUERULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysValueRule);
            } else {
                iService.get(pSSysValueRule);
            }
            this.onFillParentInfo_PSSysValueRule(pSDEActionLogic, pSSysValueRule);
            return;
        }
        super.onFillParentInfo(pSDEActionLogic, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_DstPSDE(PSDEActionLogic pSDEActionLogic, PSDataEntity pSDataEntity) throws Exception {
        pSDEActionLogic.setDstPSDEId(pSDataEntity.getPSDataEntityId());
        pSDEActionLogic.setDstPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_PSDE(PSDEActionLogic pSDEActionLogic, PSDataEntity pSDataEntity) throws Exception {
        pSDEActionLogic.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSDEActionLogic.setPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_DstPSDEAction(PSDEActionLogic pSDEActionLogic, PSDEAction pSDEAction) throws Exception {
        pSDEActionLogic.setDstPSDEActionId(pSDEAction.getPSDEActionId());
        pSDEActionLogic.setDstPSDEActionName(pSDEAction.getPSDEActionName());
        if (pSDEAction.getPSDE() != null) {
            this.onFillParentInfo_DstPSDE(pSDEActionLogic, pSDEAction.getPSDE());
        }
    }

    protected void onFillParentInfo_PSDEAction(PSDEActionLogic pSDEActionLogic, PSDEAction pSDEAction) throws Exception {
        pSDEActionLogic.setPSDEActionId(pSDEAction.getPSDEActionId());
        pSDEActionLogic.setPSDEActionName(pSDEAction.getPSDEActionName());
        if (pSDEAction.getPSDE() != null) {
            this.onFillParentInfo_PSDE(pSDEActionLogic, pSDEAction.getPSDE());
        }
    }

    protected void onFillParentInfo_DstPSDEDataQuery(PSDEActionLogic pSDEActionLogic, PSDEDataQuery pSDEDataQuery) throws Exception {
        pSDEActionLogic.setDstPSDEDataQueryId(pSDEDataQuery.getPSDEDataQueryId());
        pSDEActionLogic.setDstPSDEDataQueryName(pSDEDataQuery.getPSDEDataQueryName());
    }

    protected void onFillParentInfo_DstPSDEDataSet(PSDEActionLogic pSDEActionLogic, PSDEDataSet pSDEDataSet) throws Exception {
        pSDEActionLogic.setDstPSDEDataSetId(pSDEDataSet.getPSDEDataSetId());
        pSDEActionLogic.setDstPSDEDataSetName(pSDEDataSet.getPSDEDataSetName());
    }

    protected void onFillParentInfo_PSDEDataSync(PSDEActionLogic pSDEActionLogic, PSDEDataSync pSDEDataSync) throws Exception {
        pSDEActionLogic.setPSDEDataSyncId(pSDEDataSync.getPSDEDataSyncId());
        pSDEActionLogic.setPSDEDataSyncName(pSDEDataSync.getPSDEDataSyncName());
    }

    protected void onFillParentInfo_PSDEF(PSDEActionLogic pSDEActionLogic, PSDEField pSDEField) throws Exception {
        pSDEActionLogic.setPSDEFId(pSDEField.getPSDEFieldId());
        pSDEActionLogic.setPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_PSDEFValueRule(PSDEActionLogic pSDEActionLogic, PSDEFValueRule pSDEFValueRule) throws Exception {
        pSDEActionLogic.setPSDEFValueRuleId(pSDEFValueRule.getPSDEFValueRuleId());
        pSDEActionLogic.setPSDEFValueRuleName(pSDEFValueRule.getPSDEFValueRuleName());
    }

    protected void onFillParentInfo_DstPSDELogic(PSDEActionLogic pSDEActionLogic, PSDELogic pSDELogic) throws Exception {
        pSDEActionLogic.setDstPSDELogicId(pSDELogic.getPSDELogicId());
        pSDEActionLogic.setDstPSDELogicName(pSDELogic.getPSDELogicName());
    }

    protected void onFillParentInfo_PSDELogic(PSDEActionLogic pSDEActionLogic, PSDELogic pSDELogic) throws Exception {
        pSDEActionLogic.setPSDELogicId(pSDELogic.getPSDELogicId());
        pSDEActionLogic.setPSDELogicName(pSDELogic.getPSDELogicName());
    }

    protected void onFillParentInfo_PSDEMainState(PSDEActionLogic pSDEActionLogic, PSDEMainState pSDEMainState) throws Exception {
        pSDEActionLogic.setPSDEMainStateId(pSDEMainState.getPSDEMainStateId());
        pSDEActionLogic.setPSDEMainStateName(pSDEMainState.getPSDEMainStateName());
    }

    protected void onFillParentInfo_PSDENotify(PSDEActionLogic pSDEActionLogic, PSDENotify pSDENotify) throws Exception {
        pSDEActionLogic.setPSDENotifyId(pSDENotify.getPSDENotifyId());
        pSDEActionLogic.setPSDENotifyName(pSDENotify.getPSDENotifyName());
    }

    protected void onFillParentInfo_MajorPSDEId(PSDEActionLogic pSDEActionLogic, PSDER pSDER) throws Exception {
        pSDEActionLogic.setMajorPSDERId(pSDER.getPSDERId());
        pSDEActionLogic.setMajorPSDERName(pSDER.getPSDERName());
    }

    protected void onFillParentInfo_MinorPSDER(PSDEActionLogic pSDEActionLogic, PSDER pSDER) throws Exception {
        pSDEActionLogic.setMinorPSDERId(pSDER.getPSDERId());
        pSDEActionLogic.setMinorPSDERName(pSDER.getPSDERName());
    }

    protected void onFillParentInfo_ErrorPSLanRes(PSDEActionLogic pSDEActionLogic, PSLanguageRes pSLanguageRes) throws Exception {
        pSDEActionLogic.setErrorPSLanResId(pSLanguageRes.getPSLanguageResId());
        pSDEActionLogic.setErrorPSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_PSSysDELogicNode(PSDEActionLogic pSDEActionLogic, PSSysDELogicNode pSSysDELogicNode) throws Exception {
        pSDEActionLogic.setPSSysDELogicNodeId(pSSysDELogicNode.getPSSysDELogicNodeId());
        pSDEActionLogic.setPSSysDELogicNodeName(pSSysDELogicNode.getPSSysDELogicNodeName());
    }

    protected void onFillParentInfo_PSSysPFPlugin(PSDEActionLogic pSDEActionLogic, PSSysPFPlugin pSSysPFPlugin) throws Exception {
        pSDEActionLogic.setPSSysPFPluginId(pSSysPFPlugin.getPSSysPFPluginId());
        pSDEActionLogic.setPSSysPFPluginName(pSSysPFPlugin.getPSSysPFPluginName());
    }

    protected void onFillParentInfo_PSSysSequence(PSDEActionLogic pSDEActionLogic, PSSysSequence pSSysSequence) throws Exception {
        pSDEActionLogic.setPSSysSequenceId(pSSysSequence.getPSSysSequenceId());
        pSDEActionLogic.setPSSysSequenceName(pSSysSequence.getPSSysSequenceName());
    }

    protected void onFillParentInfo_PSSysSFPlugin(PSDEActionLogic pSDEActionLogic, PSSysSFPlugin pSSysSFPlugin) throws Exception {
        pSDEActionLogic.setPSSysSFPluginId(pSSysSFPlugin.getPSSysSFPluginId());
        pSDEActionLogic.setPSSysSFPluginName(pSSysSFPlugin.getPSSysSFPluginName());
    }

    protected void onFillParentInfo_PSSysTranslator(PSDEActionLogic pSDEActionLogic, PSSysTranslator pSSysTranslator) throws Exception {
        pSDEActionLogic.setPSSysTranslatorId(pSSysTranslator.getPSSysTranslatorId());
        pSDEActionLogic.setPSSysTranslatorName(pSSysTranslator.getPSSysTranslatorName());
    }

    protected void onFillParentInfo_PSSysValueRule(PSDEActionLogic pSDEActionLogic, PSSysValueRule pSSysValueRule) throws Exception {
        pSDEActionLogic.setPSSysValueRuleId(pSSysValueRule.getPSSysValueRuleId());
        pSDEActionLogic.setPSSysValueRuleName(pSSysValueRule.getPSSysValueRuleName());
    }

    protected void onFillEntityFullInfo(PSDEActionLogic pSDEActionLogic, boolean bl) throws Exception {
        if (bl) {
            if (pSDEActionLogic.getPSDEActionLogicName() == null) {
                pSDEActionLogic.setPSDEActionLogicName((String)this.getDefaultValue(this.getWebContext(), "", "\u9644\u52a0\u903b\u8f91", 25));
            }
            if (pSDEActionLogic.getValidFlag() == null) {
                pSDEActionLogic.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo(pSDEActionLogic, bl);
        this.onFillEntityFullInfo_DstPSDE(pSDEActionLogic, bl);
        this.onFillEntityFullInfo_PSDE(pSDEActionLogic, bl);
        this.onFillEntityFullInfo_DstPSDEAction(pSDEActionLogic, bl);
        this.onFillEntityFullInfo_PSDEAction(pSDEActionLogic, bl);
        this.onFillEntityFullInfo_DstPSDEDataQuery(pSDEActionLogic, bl);
        this.onFillEntityFullInfo_DstPSDEDataSet(pSDEActionLogic, bl);
        this.onFillEntityFullInfo_PSDEDataSync(pSDEActionLogic, bl);
        this.onFillEntityFullInfo_PSDEF(pSDEActionLogic, bl);
        this.onFillEntityFullInfo_PSDEFValueRule(pSDEActionLogic, bl);
        this.onFillEntityFullInfo_DstPSDELogic(pSDEActionLogic, bl);
        this.onFillEntityFullInfo_PSDELogic(pSDEActionLogic, bl);
        this.onFillEntityFullInfo_PSDEMainState(pSDEActionLogic, bl);
        this.onFillEntityFullInfo_PSDENotify(pSDEActionLogic, bl);
        this.onFillEntityFullInfo_MajorPSDEId(pSDEActionLogic, bl);
        this.onFillEntityFullInfo_MinorPSDER(pSDEActionLogic, bl);
        this.onFillEntityFullInfo_ErrorPSLanRes(pSDEActionLogic, bl);
        this.onFillEntityFullInfo_PSSysDELogicNode(pSDEActionLogic, bl);
        this.onFillEntityFullInfo_PSSysPFPlugin(pSDEActionLogic, bl);
        this.onFillEntityFullInfo_PSSysSequence(pSDEActionLogic, bl);
        this.onFillEntityFullInfo_PSSysSFPlugin(pSDEActionLogic, bl);
        this.onFillEntityFullInfo_PSSysTranslator(pSDEActionLogic, bl);
        this.onFillEntityFullInfo_PSSysValueRule(pSDEActionLogic, bl);
    }

    protected void onFillEntityFullInfo_DstPSDE(PSDEActionLogic pSDEActionLogic, boolean bl) throws Exception {
        if (pSDEActionLogic.isDstPSDEIdDirty()) {
            if (pSDEActionLogic.getDstPSDEId() != null) {
                if (pSDEActionLogic.getDstPSDEId() == null || pSDEActionLogic.getDstPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSDEActionLogic.getDstPSDE();
                    pSDEActionLogic.setDstPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSDEActionLogic.setDstPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDE(PSDEActionLogic pSDEActionLogic, boolean bl) throws Exception {
        if (pSDEActionLogic.isPSDEIdDirty()) {
            if (pSDEActionLogic.getPSDEId() != null) {
                if (pSDEActionLogic.getPSDEId() == null || pSDEActionLogic.getPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSDEActionLogic.getPSDE();
                    pSDEActionLogic.setPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSDEActionLogic.setPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_DstPSDEAction(PSDEActionLogic pSDEActionLogic, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEAction(PSDEActionLogic pSDEActionLogic, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_DstPSDEDataQuery(PSDEActionLogic pSDEActionLogic, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_DstPSDEDataSet(PSDEActionLogic pSDEActionLogic, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEDataSync(PSDEActionLogic pSDEActionLogic, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEF(PSDEActionLogic pSDEActionLogic, boolean bl) throws Exception {
        if (pSDEActionLogic.isPSDEFIdDirty()) {
            if (pSDEActionLogic.getPSDEFId() != null) {
                if (pSDEActionLogic.getPSDEFId() == null || pSDEActionLogic.getPSDEFName() == null) {
                    PSDEField pSDEField = pSDEActionLogic.getPSDEF();
                    pSDEActionLogic.setPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSDEActionLogic.setPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDEFValueRule(PSDEActionLogic pSDEActionLogic, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_DstPSDELogic(PSDEActionLogic pSDEActionLogic, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDELogic(PSDEActionLogic pSDEActionLogic, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEMainState(PSDEActionLogic pSDEActionLogic, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDENotify(PSDEActionLogic pSDEActionLogic, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_MajorPSDEId(PSDEActionLogic pSDEActionLogic, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_MinorPSDER(PSDEActionLogic pSDEActionLogic, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_ErrorPSLanRes(PSDEActionLogic pSDEActionLogic, boolean bl) throws Exception {
        if (pSDEActionLogic.isErrorPSLanResIdDirty()) {
            if (pSDEActionLogic.getErrorPSLanResId() != null) {
                if (pSDEActionLogic.getErrorPSLanResId() == null || pSDEActionLogic.getErrorPSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSDEActionLogic.getErrorPSLanRes();
                    pSDEActionLogic.setErrorPSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSDEActionLogic.setErrorPSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysDELogicNode(PSDEActionLogic pSDEActionLogic, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysPFPlugin(PSDEActionLogic pSDEActionLogic, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysSequence(PSDEActionLogic pSDEActionLogic, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysSFPlugin(PSDEActionLogic pSDEActionLogic, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysTranslator(PSDEActionLogic pSDEActionLogic, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysValueRule(PSDEActionLogic pSDEActionLogic, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDEActionLogic pSDEActionLogic, boolean bl) throws Exception {
        super.onWriteBackParent(pSDEActionLogic, bl);
    }

    public ArrayList<PSDEActionLogic> selectByDstPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByDstPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSDEActionLogic> selectByDstPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByDstPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSDEActionLogic> selectByDstPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("DSTPSDEID", (Object)pSDataEntityBase.getPSDataEntityId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByDstPSDECond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByDstPSDECond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEActionLogic> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSDEActionLogic> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSDEActionLogic> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEActionLogic> selectByDstPSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByDstPSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSDEActionLogic> selectByDstPSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByDstPSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSDEActionLogic> selectByDstPSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("DSTPSDEACTIONID", (Object)pSDEActionBase.getPSDEActionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByDstPSDEActionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByDstPSDEActionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEActionLogic> selectByPSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByPSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSDEActionLogic> selectByPSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByPSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSDEActionLogic> selectByPSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEACTIONID", (Object)pSDEActionBase.getPSDEActionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEActionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEActionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEActionLogic> selectByDstPSDEDataQuery(PSDEDataQueryBase pSDEDataQueryBase) throws Exception {
        return this.selectByDstPSDEDataQuery(pSDEDataQueryBase, "", -1);
    }

    public ArrayList<PSDEActionLogic> selectByDstPSDEDataQuery(PSDEDataQueryBase pSDEDataQueryBase, String string) throws Exception {
        return this.selectByDstPSDEDataQuery(pSDEDataQueryBase, string, -1);
    }

    public ArrayList<PSDEActionLogic> selectByDstPSDEDataQuery(PSDEDataQueryBase pSDEDataQueryBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("DSTPSDEDATAQUERYID", (Object)pSDEDataQueryBase.getPSDEDataQueryId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByDstPSDEDataQueryCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByDstPSDEDataQueryCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEActionLogic> selectByDstPSDEDataSet(PSDEDataSetBase pSDEDataSetBase) throws Exception {
        return this.selectByDstPSDEDataSet(pSDEDataSetBase, "", -1);
    }

    public ArrayList<PSDEActionLogic> selectByDstPSDEDataSet(PSDEDataSetBase pSDEDataSetBase, String string) throws Exception {
        return this.selectByDstPSDEDataSet(pSDEDataSetBase, string, -1);
    }

    public ArrayList<PSDEActionLogic> selectByDstPSDEDataSet(PSDEDataSetBase pSDEDataSetBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("DSTPSDEDATASETID", (Object)pSDEDataSetBase.getPSDEDataSetId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByDstPSDEDataSetCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByDstPSDEDataSetCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEActionLogic> selectByPSDEDataSync(PSDEDataSyncBase pSDEDataSyncBase) throws Exception {
        return this.selectByPSDEDataSync(pSDEDataSyncBase, "", -1);
    }

    public ArrayList<PSDEActionLogic> selectByPSDEDataSync(PSDEDataSyncBase pSDEDataSyncBase, String string) throws Exception {
        return this.selectByPSDEDataSync(pSDEDataSyncBase, string, -1);
    }

    public ArrayList<PSDEActionLogic> selectByPSDEDataSync(PSDEDataSyncBase pSDEDataSyncBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEDATASYNCID", (Object)pSDEDataSyncBase.getPSDEDataSyncId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEDataSyncCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEDataSyncCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEActionLogic> selectByPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSDEActionLogic> selectByPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSDEActionLogic> selectByPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEActionLogic> selectByPSDEFValueRule(PSDEFValueRuleBase pSDEFValueRuleBase) throws Exception {
        return this.selectByPSDEFValueRule(pSDEFValueRuleBase, "", -1);
    }

    public ArrayList<PSDEActionLogic> selectByPSDEFValueRule(PSDEFValueRuleBase pSDEFValueRuleBase, String string) throws Exception {
        return this.selectByPSDEFValueRule(pSDEFValueRuleBase, string, -1);
    }

    public ArrayList<PSDEActionLogic> selectByPSDEFValueRule(PSDEFValueRuleBase pSDEFValueRuleBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEFVALUERULEID", (Object)pSDEFValueRuleBase.getPSDEFValueRuleId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEFValueRuleCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEFValueRuleCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEActionLogic> selectByDstPSDELogic(PSDELogicBase pSDELogicBase) throws Exception {
        return this.selectByDstPSDELogic(pSDELogicBase, "", -1);
    }

    public ArrayList<PSDEActionLogic> selectByDstPSDELogic(PSDELogicBase pSDELogicBase, String string) throws Exception {
        return this.selectByDstPSDELogic(pSDELogicBase, string, -1);
    }

    public ArrayList<PSDEActionLogic> selectByDstPSDELogic(PSDELogicBase pSDELogicBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("DSTPSDELOGICID", (Object)pSDELogicBase.getPSDELogicId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByDstPSDELogicCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByDstPSDELogicCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEActionLogic> selectByPSDELogic(PSDELogicBase pSDELogicBase) throws Exception {
        return this.selectByPSDELogic(pSDELogicBase, "", -1);
    }

    public ArrayList<PSDEActionLogic> selectByPSDELogic(PSDELogicBase pSDELogicBase, String string) throws Exception {
        return this.selectByPSDELogic(pSDELogicBase, string, -1);
    }

    public ArrayList<PSDEActionLogic> selectByPSDELogic(PSDELogicBase pSDELogicBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEActionLogic> selectByPSDEMainState(PSDEMainStateBase pSDEMainStateBase) throws Exception {
        return this.selectByPSDEMainState(pSDEMainStateBase, "", -1);
    }

    public ArrayList<PSDEActionLogic> selectByPSDEMainState(PSDEMainStateBase pSDEMainStateBase, String string) throws Exception {
        return this.selectByPSDEMainState(pSDEMainStateBase, string, -1);
    }

    public ArrayList<PSDEActionLogic> selectByPSDEMainState(PSDEMainStateBase pSDEMainStateBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEActionLogic> selectByPSDENotify(PSDENotifyBase pSDENotifyBase) throws Exception {
        return this.selectByPSDENotify(pSDENotifyBase, "", -1);
    }

    public ArrayList<PSDEActionLogic> selectByPSDENotify(PSDENotifyBase pSDENotifyBase, String string) throws Exception {
        return this.selectByPSDENotify(pSDENotifyBase, string, -1);
    }

    public ArrayList<PSDEActionLogic> selectByPSDENotify(PSDENotifyBase pSDENotifyBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDENOTIFYID", (Object)pSDENotifyBase.getPSDENotifyId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDENotifyCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDENotifyCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEActionLogic> selectByMajorPSDEId(PSDERBase pSDERBase) throws Exception {
        return this.selectByMajorPSDEId(pSDERBase, "", -1);
    }

    public ArrayList<PSDEActionLogic> selectByMajorPSDEId(PSDERBase pSDERBase, String string) throws Exception {
        return this.selectByMajorPSDEId(pSDERBase, string, -1);
    }

    public ArrayList<PSDEActionLogic> selectByMajorPSDEId(PSDERBase pSDERBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("MAJORPSDERID", (Object)pSDERBase.getPSDERId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByMajorPSDEIdCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByMajorPSDEIdCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEActionLogic> selectByMinorPSDER(PSDERBase pSDERBase) throws Exception {
        return this.selectByMinorPSDER(pSDERBase, "", -1);
    }

    public ArrayList<PSDEActionLogic> selectByMinorPSDER(PSDERBase pSDERBase, String string) throws Exception {
        return this.selectByMinorPSDER(pSDERBase, string, -1);
    }

    public ArrayList<PSDEActionLogic> selectByMinorPSDER(PSDERBase pSDERBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("MINORPSDERID", (Object)pSDERBase.getPSDERId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByMinorPSDERCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByMinorPSDERCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEActionLogic> selectByErrorPSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByErrorPSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSDEActionLogic> selectByErrorPSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByErrorPSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSDEActionLogic> selectByErrorPSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("ERRORPSLANRESID", (Object)pSLanguageResBase.getPSLanguageResId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByErrorPSLanResCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByErrorPSLanResCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEActionLogic> selectByPSSysDELogicNode(PSSysDELogicNodeBase pSSysDELogicNodeBase) throws Exception {
        return this.selectByPSSysDELogicNode(pSSysDELogicNodeBase, "", -1);
    }

    public ArrayList<PSDEActionLogic> selectByPSSysDELogicNode(PSSysDELogicNodeBase pSSysDELogicNodeBase, String string) throws Exception {
        return this.selectByPSSysDELogicNode(pSSysDELogicNodeBase, string, -1);
    }

    public ArrayList<PSDEActionLogic> selectByPSSysDELogicNode(PSSysDELogicNodeBase pSSysDELogicNodeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSDELOGICNODEID", (Object)pSSysDELogicNodeBase.getPSSysDELogicNodeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysDELogicNodeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysDELogicNodeCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEActionLogic> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, "", -1);
    }

    public ArrayList<PSDEActionLogic> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, string, -1);
    }

    public ArrayList<PSDEActionLogic> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEActionLogic> selectByPSSysSequence(PSSysSequenceBase pSSysSequenceBase) throws Exception {
        return this.selectByPSSysSequence(pSSysSequenceBase, "", -1);
    }

    public ArrayList<PSDEActionLogic> selectByPSSysSequence(PSSysSequenceBase pSSysSequenceBase, String string) throws Exception {
        return this.selectByPSSysSequence(pSSysSequenceBase, string, -1);
    }

    public ArrayList<PSDEActionLogic> selectByPSSysSequence(PSSysSequenceBase pSSysSequenceBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSSEQUENCEID", (Object)pSSysSequenceBase.getPSSysSequenceId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysSequenceCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysSequenceCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEActionLogic> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, "", -1);
    }

    public ArrayList<PSDEActionLogic> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, string, -1);
    }

    public ArrayList<PSDEActionLogic> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEActionLogic> selectByPSSysTranslator(PSSysTranslatorBase pSSysTranslatorBase) throws Exception {
        return this.selectByPSSysTranslator(pSSysTranslatorBase, "", -1);
    }

    public ArrayList<PSDEActionLogic> selectByPSSysTranslator(PSSysTranslatorBase pSSysTranslatorBase, String string) throws Exception {
        return this.selectByPSSysTranslator(pSSysTranslatorBase, string, -1);
    }

    public ArrayList<PSDEActionLogic> selectByPSSysTranslator(PSSysTranslatorBase pSSysTranslatorBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSTRANSLATORID", (Object)pSSysTranslatorBase.getPSSysTranslatorId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysTranslatorCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysTranslatorCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEActionLogic> selectByPSSysValueRule(PSSysValueRuleBase pSSysValueRuleBase) throws Exception {
        return this.selectByPSSysValueRule(pSSysValueRuleBase, "", -1);
    }

    public ArrayList<PSDEActionLogic> selectByPSSysValueRule(PSSysValueRuleBase pSSysValueRuleBase, String string) throws Exception {
        return this.selectByPSSysValueRule(pSSysValueRuleBase, string, -1);
    }

    public ArrayList<PSDEActionLogic> selectByPSSysValueRule(PSSysValueRuleBase pSSysValueRuleBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSVALUERULEID", (Object)pSSysValueRuleBase.getPSSysValueRuleId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysValueRuleCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysValueRuleCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByDstPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEActionLogic> arrayList = this.selectByDstPSDE(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEACTIONLOGIC_PSDATAENTITY_DSTPSDEID", "", iDataEntityModel.getName(), "PSDEACTIONLOGIC", iDataEntityModel.getDataInfo(pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetDstPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEActionLogic> arrayList = this.selectByDstPSDE(pSDataEntity);
        for (PSDEActionLogic pSDEActionLogic : arrayList) {
            PSDEActionLogic pSDEActionLogic2 = (PSDEActionLogic)this.getDEModel().createEntity();
            pSDEActionLogic2.setPSDEActionLogicId(pSDEActionLogic.getPSDEActionLogicId());
            pSDEActionLogic2.setDstPSDEId(null);
            this.update(pSDEActionLogic2);
        }
    }

    public void removeByDstPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEActionLogicServiceBase.this.onBeforeRemoveByDstPSDE(pSDataEntity2);
                PSDEActionLogicServiceBase.this.internalRemoveByDstPSDE(pSDataEntity2);
                PSDEActionLogicServiceBase.this.onAfterRemoveByDstPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByDstPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByDstPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEActionLogic> arrayList = this.selectByDstPSDE(pSDataEntity);
        this.onBeforeRemoveByDstPSDE(pSDataEntity, arrayList);
        for (PSDEActionLogic pSDEActionLogic : arrayList) {
            this.remove(pSDEActionLogic);
        }
        this.onAfterRemoveByDstPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByDstPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByDstPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEActionLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByDstPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEActionLogic> arrayList) throws Exception {
    }

    public void testRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEActionLogic> arrayList = this.selectByPSDE(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEACTIONLOGIC_PSDATAENTITY_PSDEID", "", iDataEntityModel.getName(), "PSDEACTIONLOGIC", iDataEntityModel.getDataInfo(pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEActionLogic> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSDEActionLogic pSDEActionLogic : arrayList) {
            PSDEActionLogic pSDEActionLogic2 = (PSDEActionLogic)this.getDEModel().createEntity();
            pSDEActionLogic2.setPSDEActionLogicId(pSDEActionLogic.getPSDEActionLogicId());
            pSDEActionLogic2.setPSDEId(null);
            this.update(pSDEActionLogic2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEActionLogicServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSDEActionLogicServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSDEActionLogicServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEActionLogic> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSDEActionLogic pSDEActionLogic : arrayList) {
            this.remove(pSDEActionLogic);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEActionLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEActionLogic> arrayList) throws Exception {
    }

    public void testRemoveByDstPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEActionLogic> arrayList = this.selectByDstPSDEAction(pSDEAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEACTIONLOGIC_PSDEACTION_DSTPSDEACTIONID", "", iDataEntityModel.getName(), "PSDEACTIONLOGIC", iDataEntityModel.getDataInfo(pSDEAction), arrayList.get(0)));
        }
    }

    public void resetDstPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEActionLogic> arrayList = this.selectByDstPSDEAction(pSDEAction);
        for (PSDEActionLogic pSDEActionLogic : arrayList) {
            PSDEActionLogic pSDEActionLogic2 = (PSDEActionLogic)this.getDEModel().createEntity();
            pSDEActionLogic2.setPSDEActionLogicId(pSDEActionLogic.getPSDEActionLogicId());
            pSDEActionLogic2.setDstPSDEActionId(null);
            this.update(pSDEActionLogic2);
        }
    }

    public void removeByDstPSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEActionLogicServiceBase.this.onBeforeRemoveByDstPSDEAction(pSDEAction2);
                PSDEActionLogicServiceBase.this.internalRemoveByDstPSDEAction(pSDEAction2);
                PSDEActionLogicServiceBase.this.onAfterRemoveByDstPSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByDstPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByDstPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEActionLogic> arrayList = this.selectByDstPSDEAction(pSDEAction);
        this.onBeforeRemoveByDstPSDEAction(pSDEAction, arrayList);
        for (PSDEActionLogic pSDEActionLogic : arrayList) {
            this.remove(pSDEActionLogic);
        }
        this.onAfterRemoveByDstPSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByDstPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByDstPSDEAction(PSDEAction pSDEAction, ArrayList<PSDEActionLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByDstPSDEAction(PSDEAction pSDEAction, ArrayList<PSDEActionLogic> arrayList) throws Exception {
    }

    public void testRemoveByPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    public void resetPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEActionLogic> arrayList = this.selectByPSDEAction(pSDEAction);
        for (PSDEActionLogic pSDEActionLogic : arrayList) {
            PSDEActionLogic pSDEActionLogic2 = (PSDEActionLogic)this.getDEModel().createEntity();
            pSDEActionLogic2.setPSDEActionLogicId(pSDEActionLogic.getPSDEActionLogicId());
            pSDEActionLogic2.setPSDEActionId(null);
            this.update(pSDEActionLogic2);
        }
    }

    public void removeByPSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEActionLogicServiceBase.this.onBeforeRemoveByPSDEAction(pSDEAction2);
                PSDEActionLogicServiceBase.this.internalRemoveByPSDEAction(pSDEAction2);
                PSDEActionLogicServiceBase.this.onAfterRemoveByPSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEActionLogic> arrayList = this.selectByPSDEAction(pSDEAction);
        this.onBeforeRemoveByPSDEAction(pSDEAction, arrayList);
        for (PSDEActionLogic pSDEActionLogic : arrayList) {
            this.remove(pSDEActionLogic);
        }
        this.onAfterRemoveByPSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByPSDEAction(PSDEAction pSDEAction, ArrayList<PSDEActionLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEAction(PSDEAction pSDEAction, ArrayList<PSDEActionLogic> arrayList) throws Exception {
    }

    public void testRemoveByDstPSDEDataQuery(PSDEDataQuery pSDEDataQuery) throws Exception {
        ArrayList<PSDEActionLogic> arrayList = this.selectByDstPSDEDataQuery(pSDEDataQuery, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEDATAQUERY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEDataQuery);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEACTIONLOGIC_PSDEDATAQUERY_DSTPSDEDATAQUERYID", "", iDataEntityModel.getName(), "PSDEACTIONLOGIC", iDataEntityModel.getDataInfo(pSDEDataQuery), arrayList.get(0)));
        }
    }

    public void resetDstPSDEDataQuery(PSDEDataQuery pSDEDataQuery) throws Exception {
        ArrayList<PSDEActionLogic> arrayList = this.selectByDstPSDEDataQuery(pSDEDataQuery);
        for (PSDEActionLogic pSDEActionLogic : arrayList) {
            PSDEActionLogic pSDEActionLogic2 = (PSDEActionLogic)this.getDEModel().createEntity();
            pSDEActionLogic2.setPSDEActionLogicId(pSDEActionLogic.getPSDEActionLogicId());
            pSDEActionLogic2.setDstPSDEDataQueryId(null);
            this.update(pSDEActionLogic2);
        }
    }

    public void removeByDstPSDEDataQuery(PSDEDataQuery pSDEDataQuery) throws Exception {
        final PSDEDataQuery pSDEDataQuery2 = pSDEDataQuery;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEActionLogicServiceBase.this.onBeforeRemoveByDstPSDEDataQuery(pSDEDataQuery2);
                PSDEActionLogicServiceBase.this.internalRemoveByDstPSDEDataQuery(pSDEDataQuery2);
                PSDEActionLogicServiceBase.this.onAfterRemoveByDstPSDEDataQuery(pSDEDataQuery2);
            }
        });
    }

    protected void onBeforeRemoveByDstPSDEDataQuery(PSDEDataQuery pSDEDataQuery) throws Exception {
    }

    protected void internalRemoveByDstPSDEDataQuery(PSDEDataQuery pSDEDataQuery) throws Exception {
        ArrayList<PSDEActionLogic> arrayList = this.selectByDstPSDEDataQuery(pSDEDataQuery);
        this.onBeforeRemoveByDstPSDEDataQuery(pSDEDataQuery, arrayList);
        for (PSDEActionLogic pSDEActionLogic : arrayList) {
            this.remove(pSDEActionLogic);
        }
        this.onAfterRemoveByDstPSDEDataQuery(pSDEDataQuery, arrayList);
    }

    protected void onAfterRemoveByDstPSDEDataQuery(PSDEDataQuery pSDEDataQuery) throws Exception {
    }

    protected void onBeforeRemoveByDstPSDEDataQuery(PSDEDataQuery pSDEDataQuery, ArrayList<PSDEActionLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByDstPSDEDataQuery(PSDEDataQuery pSDEDataQuery, ArrayList<PSDEActionLogic> arrayList) throws Exception {
    }

    public void testRemoveByDstPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDEActionLogic> arrayList = this.selectByDstPSDEDataSet(pSDEDataSet, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEDATASET");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEDataSet);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEACTIONLOGIC_PSDEDATASET_DSTPSDEDATASETID", "", iDataEntityModel.getName(), "PSDEACTIONLOGIC", iDataEntityModel.getDataInfo(pSDEDataSet), arrayList.get(0)));
        }
    }

    public void resetDstPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDEActionLogic> arrayList = this.selectByDstPSDEDataSet(pSDEDataSet);
        for (PSDEActionLogic pSDEActionLogic : arrayList) {
            PSDEActionLogic pSDEActionLogic2 = (PSDEActionLogic)this.getDEModel().createEntity();
            pSDEActionLogic2.setPSDEActionLogicId(pSDEActionLogic.getPSDEActionLogicId());
            pSDEActionLogic2.setDstPSDEDataSetId(null);
            this.update(pSDEActionLogic2);
        }
    }

    public void removeByDstPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        final PSDEDataSet pSDEDataSet2 = pSDEDataSet;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEActionLogicServiceBase.this.onBeforeRemoveByDstPSDEDataSet(pSDEDataSet2);
                PSDEActionLogicServiceBase.this.internalRemoveByDstPSDEDataSet(pSDEDataSet2);
                PSDEActionLogicServiceBase.this.onAfterRemoveByDstPSDEDataSet(pSDEDataSet2);
            }
        });
    }

    protected void onBeforeRemoveByDstPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void internalRemoveByDstPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDEActionLogic> arrayList = this.selectByDstPSDEDataSet(pSDEDataSet);
        this.onBeforeRemoveByDstPSDEDataSet(pSDEDataSet, arrayList);
        for (PSDEActionLogic pSDEActionLogic : arrayList) {
            this.remove(pSDEActionLogic);
        }
        this.onAfterRemoveByDstPSDEDataSet(pSDEDataSet, arrayList);
    }

    protected void onAfterRemoveByDstPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void onBeforeRemoveByDstPSDEDataSet(PSDEDataSet pSDEDataSet, ArrayList<PSDEActionLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByDstPSDEDataSet(PSDEDataSet pSDEDataSet, ArrayList<PSDEActionLogic> arrayList) throws Exception {
    }

    public void testRemoveByPSDEDataSync(PSDEDataSync pSDEDataSync) throws Exception {
        ArrayList<PSDEActionLogic> arrayList = this.selectByPSDEDataSync(pSDEDataSync, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEDATASYNC");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEDataSync);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEACTIONLOGIC_PSDEDATASYNC_PSDEDATASYNCID", "", iDataEntityModel.getName(), "PSDEACTIONLOGIC", iDataEntityModel.getDataInfo(pSDEDataSync), arrayList.get(0)));
        }
    }

    public void resetPSDEDataSync(PSDEDataSync pSDEDataSync) throws Exception {
        ArrayList<PSDEActionLogic> arrayList = this.selectByPSDEDataSync(pSDEDataSync);
        for (PSDEActionLogic pSDEActionLogic : arrayList) {
            PSDEActionLogic pSDEActionLogic2 = (PSDEActionLogic)this.getDEModel().createEntity();
            pSDEActionLogic2.setPSDEActionLogicId(pSDEActionLogic.getPSDEActionLogicId());
            pSDEActionLogic2.setPSDEDataSyncId(null);
            this.update(pSDEActionLogic2);
        }
    }

    public void removeByPSDEDataSync(PSDEDataSync pSDEDataSync) throws Exception {
        final PSDEDataSync pSDEDataSync2 = pSDEDataSync;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEActionLogicServiceBase.this.onBeforeRemoveByPSDEDataSync(pSDEDataSync2);
                PSDEActionLogicServiceBase.this.internalRemoveByPSDEDataSync(pSDEDataSync2);
                PSDEActionLogicServiceBase.this.onAfterRemoveByPSDEDataSync(pSDEDataSync2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEDataSync(PSDEDataSync pSDEDataSync) throws Exception {
    }

    protected void internalRemoveByPSDEDataSync(PSDEDataSync pSDEDataSync) throws Exception {
        ArrayList<PSDEActionLogic> arrayList = this.selectByPSDEDataSync(pSDEDataSync);
        this.onBeforeRemoveByPSDEDataSync(pSDEDataSync, arrayList);
        for (PSDEActionLogic pSDEActionLogic : arrayList) {
            this.remove(pSDEActionLogic);
        }
        this.onAfterRemoveByPSDEDataSync(pSDEDataSync, arrayList);
    }

    protected void onAfterRemoveByPSDEDataSync(PSDEDataSync pSDEDataSync) throws Exception {
    }

    protected void onBeforeRemoveByPSDEDataSync(PSDEDataSync pSDEDataSync, ArrayList<PSDEActionLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEDataSync(PSDEDataSync pSDEDataSync, ArrayList<PSDEActionLogic> arrayList) throws Exception {
    }

    public void testRemoveByPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEActionLogic> arrayList = this.selectByPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEACTIONLOGIC_PSDEFIELD_PSDEFID", "", iDataEntityModel.getName(), "PSDEACTIONLOGIC", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEActionLogic> arrayList = this.selectByPSDEF(pSDEField);
        for (PSDEActionLogic pSDEActionLogic : arrayList) {
            PSDEActionLogic pSDEActionLogic2 = (PSDEActionLogic)this.getDEModel().createEntity();
            pSDEActionLogic2.setPSDEActionLogicId(pSDEActionLogic.getPSDEActionLogicId());
            pSDEActionLogic2.setPSDEFId(null);
            this.update(pSDEActionLogic2);
        }
    }

    public void removeByPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEActionLogicServiceBase.this.onBeforeRemoveByPSDEF(pSDEField2);
                PSDEActionLogicServiceBase.this.internalRemoveByPSDEF(pSDEField2);
                PSDEActionLogicServiceBase.this.onAfterRemoveByPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEActionLogic> arrayList = this.selectByPSDEF(pSDEField);
        this.onBeforeRemoveByPSDEF(pSDEField, arrayList);
        for (PSDEActionLogic pSDEActionLogic : arrayList) {
            this.remove(pSDEActionLogic);
        }
        this.onAfterRemoveByPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByPSDEF(PSDEField pSDEField, ArrayList<PSDEActionLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEF(PSDEField pSDEField, ArrayList<PSDEActionLogic> arrayList) throws Exception {
    }

    public void testRemoveByPSDEFValueRule(PSDEFValueRule pSDEFValueRule) throws Exception {
        ArrayList<PSDEActionLogic> arrayList = this.selectByPSDEFValueRule(pSDEFValueRule, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFVALUERULE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEFValueRule);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEACTIONLOGIC_PSDEFVALUERULE_PSDEFVALUERULEID", "", iDataEntityModel.getName(), "PSDEACTIONLOGIC", iDataEntityModel.getDataInfo(pSDEFValueRule), arrayList.get(0)));
        }
    }

    public void resetPSDEFValueRule(PSDEFValueRule pSDEFValueRule) throws Exception {
        ArrayList<PSDEActionLogic> arrayList = this.selectByPSDEFValueRule(pSDEFValueRule);
        for (PSDEActionLogic pSDEActionLogic : arrayList) {
            PSDEActionLogic pSDEActionLogic2 = (PSDEActionLogic)this.getDEModel().createEntity();
            pSDEActionLogic2.setPSDEActionLogicId(pSDEActionLogic.getPSDEActionLogicId());
            pSDEActionLogic2.setPSDEFValueRuleId(null);
            this.update(pSDEActionLogic2);
        }
    }

    public void removeByPSDEFValueRule(PSDEFValueRule pSDEFValueRule) throws Exception {
        final PSDEFValueRule pSDEFValueRule2 = pSDEFValueRule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEActionLogicServiceBase.this.onBeforeRemoveByPSDEFValueRule(pSDEFValueRule2);
                PSDEActionLogicServiceBase.this.internalRemoveByPSDEFValueRule(pSDEFValueRule2);
                PSDEActionLogicServiceBase.this.onAfterRemoveByPSDEFValueRule(pSDEFValueRule2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEFValueRule(PSDEFValueRule pSDEFValueRule) throws Exception {
    }

    protected void internalRemoveByPSDEFValueRule(PSDEFValueRule pSDEFValueRule) throws Exception {
        ArrayList<PSDEActionLogic> arrayList = this.selectByPSDEFValueRule(pSDEFValueRule);
        this.onBeforeRemoveByPSDEFValueRule(pSDEFValueRule, arrayList);
        for (PSDEActionLogic pSDEActionLogic : arrayList) {
            this.remove(pSDEActionLogic);
        }
        this.onAfterRemoveByPSDEFValueRule(pSDEFValueRule, arrayList);
    }

    protected void onAfterRemoveByPSDEFValueRule(PSDEFValueRule pSDEFValueRule) throws Exception {
    }

    protected void onBeforeRemoveByPSDEFValueRule(PSDEFValueRule pSDEFValueRule, ArrayList<PSDEActionLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEFValueRule(PSDEFValueRule pSDEFValueRule, ArrayList<PSDEActionLogic> arrayList) throws Exception {
    }

    public void testRemoveByDstPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSDEActionLogic> arrayList = this.selectByDstPSDELogic(pSDELogic, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDELOGIC");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDELogic);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEACTIONLOGIC_PSDELOGIC_DSTPSDELOGICID", "", iDataEntityModel.getName(), "PSDEACTIONLOGIC", iDataEntityModel.getDataInfo(pSDELogic), arrayList.get(0)));
        }
    }

    public void resetDstPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSDEActionLogic> arrayList = this.selectByDstPSDELogic(pSDELogic);
        for (PSDEActionLogic pSDEActionLogic : arrayList) {
            PSDEActionLogic pSDEActionLogic2 = (PSDEActionLogic)this.getDEModel().createEntity();
            pSDEActionLogic2.setPSDEActionLogicId(pSDEActionLogic.getPSDEActionLogicId());
            pSDEActionLogic2.setDstPSDELogicId(null);
            this.update(pSDEActionLogic2);
        }
    }

    public void removeByDstPSDELogic(PSDELogic pSDELogic) throws Exception {
        final PSDELogic pSDELogic2 = pSDELogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEActionLogicServiceBase.this.onBeforeRemoveByDstPSDELogic(pSDELogic2);
                PSDEActionLogicServiceBase.this.internalRemoveByDstPSDELogic(pSDELogic2);
                PSDEActionLogicServiceBase.this.onAfterRemoveByDstPSDELogic(pSDELogic2);
            }
        });
    }

    protected void onBeforeRemoveByDstPSDELogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void internalRemoveByDstPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSDEActionLogic> arrayList = this.selectByDstPSDELogic(pSDELogic);
        this.onBeforeRemoveByDstPSDELogic(pSDELogic, arrayList);
        for (PSDEActionLogic pSDEActionLogic : arrayList) {
            this.remove(pSDEActionLogic);
        }
        this.onAfterRemoveByDstPSDELogic(pSDELogic, arrayList);
    }

    protected void onAfterRemoveByDstPSDELogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void onBeforeRemoveByDstPSDELogic(PSDELogic pSDELogic, ArrayList<PSDEActionLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByDstPSDELogic(PSDELogic pSDELogic, ArrayList<PSDEActionLogic> arrayList) throws Exception {
    }

    public void testRemoveByPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSDEActionLogic> arrayList = this.selectByPSDELogic(pSDELogic, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDELOGIC");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDELogic);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEACTIONLOGIC_PSDELOGIC_PSDELOGICID", "", iDataEntityModel.getName(), "PSDEACTIONLOGIC", iDataEntityModel.getDataInfo(pSDELogic), arrayList.get(0)));
        }
    }

    public void resetPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSDEActionLogic> arrayList = this.selectByPSDELogic(pSDELogic);
        for (PSDEActionLogic pSDEActionLogic : arrayList) {
            PSDEActionLogic pSDEActionLogic2 = (PSDEActionLogic)this.getDEModel().createEntity();
            pSDEActionLogic2.setPSDEActionLogicId(pSDEActionLogic.getPSDEActionLogicId());
            pSDEActionLogic2.setPSDELogicId(null);
            this.update(pSDEActionLogic2);
        }
    }

    public void removeByPSDELogic(PSDELogic pSDELogic) throws Exception {
        final PSDELogic pSDELogic2 = pSDELogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEActionLogicServiceBase.this.onBeforeRemoveByPSDELogic(pSDELogic2);
                PSDEActionLogicServiceBase.this.internalRemoveByPSDELogic(pSDELogic2);
                PSDEActionLogicServiceBase.this.onAfterRemoveByPSDELogic(pSDELogic2);
            }
        });
    }

    protected void onBeforeRemoveByPSDELogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void internalRemoveByPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSDEActionLogic> arrayList = this.selectByPSDELogic(pSDELogic);
        this.onBeforeRemoveByPSDELogic(pSDELogic, arrayList);
        for (PSDEActionLogic pSDEActionLogic : arrayList) {
            this.remove(pSDEActionLogic);
        }
        this.onAfterRemoveByPSDELogic(pSDELogic, arrayList);
    }

    protected void onAfterRemoveByPSDELogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void onBeforeRemoveByPSDELogic(PSDELogic pSDELogic, ArrayList<PSDEActionLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDELogic(PSDELogic pSDELogic, ArrayList<PSDEActionLogic> arrayList) throws Exception {
    }

    public void testRemoveByPSDEMainState(PSDEMainState pSDEMainState) throws Exception {
        ArrayList<PSDEActionLogic> arrayList = this.selectByPSDEMainState(pSDEMainState, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEMAINSTATE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEMainState);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEACTIONLOGIC_PSDEMAINSTATE_PSDEMAINSTATEID", "", iDataEntityModel.getName(), "PSDEACTIONLOGIC", iDataEntityModel.getDataInfo(pSDEMainState), arrayList.get(0)));
        }
    }

    public void resetPSDEMainState(PSDEMainState pSDEMainState) throws Exception {
        ArrayList<PSDEActionLogic> arrayList = this.selectByPSDEMainState(pSDEMainState);
        for (PSDEActionLogic pSDEActionLogic : arrayList) {
            PSDEActionLogic pSDEActionLogic2 = (PSDEActionLogic)this.getDEModel().createEntity();
            pSDEActionLogic2.setPSDEActionLogicId(pSDEActionLogic.getPSDEActionLogicId());
            pSDEActionLogic2.setPSDEMainStateId(null);
            this.update(pSDEActionLogic2);
        }
    }

    public void removeByPSDEMainState(PSDEMainState pSDEMainState) throws Exception {
        final PSDEMainState pSDEMainState2 = pSDEMainState;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEActionLogicServiceBase.this.onBeforeRemoveByPSDEMainState(pSDEMainState2);
                PSDEActionLogicServiceBase.this.internalRemoveByPSDEMainState(pSDEMainState2);
                PSDEActionLogicServiceBase.this.onAfterRemoveByPSDEMainState(pSDEMainState2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEMainState(PSDEMainState pSDEMainState) throws Exception {
    }

    protected void internalRemoveByPSDEMainState(PSDEMainState pSDEMainState) throws Exception {
        ArrayList<PSDEActionLogic> arrayList = this.selectByPSDEMainState(pSDEMainState);
        this.onBeforeRemoveByPSDEMainState(pSDEMainState, arrayList);
        for (PSDEActionLogic pSDEActionLogic : arrayList) {
            this.remove(pSDEActionLogic);
        }
        this.onAfterRemoveByPSDEMainState(pSDEMainState, arrayList);
    }

    protected void onAfterRemoveByPSDEMainState(PSDEMainState pSDEMainState) throws Exception {
    }

    protected void onBeforeRemoveByPSDEMainState(PSDEMainState pSDEMainState, ArrayList<PSDEActionLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEMainState(PSDEMainState pSDEMainState, ArrayList<PSDEActionLogic> arrayList) throws Exception {
    }

    public void testRemoveByPSDENotify(PSDENotify pSDENotify) throws Exception {
        ArrayList<PSDEActionLogic> arrayList = this.selectByPSDENotify(pSDENotify, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDENOTIFY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDENotify);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEACTIONLOGIC_PSDENOTIFY_PSDENOTIFYID", "", iDataEntityModel.getName(), "PSDEACTIONLOGIC", iDataEntityModel.getDataInfo(pSDENotify), arrayList.get(0)));
        }
    }

    public void resetPSDENotify(PSDENotify pSDENotify) throws Exception {
        ArrayList<PSDEActionLogic> arrayList = this.selectByPSDENotify(pSDENotify);
        for (PSDEActionLogic pSDEActionLogic : arrayList) {
            PSDEActionLogic pSDEActionLogic2 = (PSDEActionLogic)this.getDEModel().createEntity();
            pSDEActionLogic2.setPSDEActionLogicId(pSDEActionLogic.getPSDEActionLogicId());
            pSDEActionLogic2.setPSDENotifyId(null);
            this.update(pSDEActionLogic2);
        }
    }

    public void removeByPSDENotify(PSDENotify pSDENotify) throws Exception {
        final PSDENotify pSDENotify2 = pSDENotify;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEActionLogicServiceBase.this.onBeforeRemoveByPSDENotify(pSDENotify2);
                PSDEActionLogicServiceBase.this.internalRemoveByPSDENotify(pSDENotify2);
                PSDEActionLogicServiceBase.this.onAfterRemoveByPSDENotify(pSDENotify2);
            }
        });
    }

    protected void onBeforeRemoveByPSDENotify(PSDENotify pSDENotify) throws Exception {
    }

    protected void internalRemoveByPSDENotify(PSDENotify pSDENotify) throws Exception {
        ArrayList<PSDEActionLogic> arrayList = this.selectByPSDENotify(pSDENotify);
        this.onBeforeRemoveByPSDENotify(pSDENotify, arrayList);
        for (PSDEActionLogic pSDEActionLogic : arrayList) {
            this.remove(pSDEActionLogic);
        }
        this.onAfterRemoveByPSDENotify(pSDENotify, arrayList);
    }

    protected void onAfterRemoveByPSDENotify(PSDENotify pSDENotify) throws Exception {
    }

    protected void onBeforeRemoveByPSDENotify(PSDENotify pSDENotify, ArrayList<PSDEActionLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDENotify(PSDENotify pSDENotify, ArrayList<PSDEActionLogic> arrayList) throws Exception {
    }

    public void testRemoveByMajorPSDEId(PSDER pSDER) throws Exception {
        ArrayList<PSDEActionLogic> arrayList = this.selectByMajorPSDEId(pSDER, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDER);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEACTIONLOGIC_PSDER_MAJORPSDERID", "", iDataEntityModel.getName(), "PSDEACTIONLOGIC", iDataEntityModel.getDataInfo(pSDER), arrayList.get(0)));
        }
    }

    public void resetMajorPSDEId(PSDER pSDER) throws Exception {
        ArrayList<PSDEActionLogic> arrayList = this.selectByMajorPSDEId(pSDER);
        for (PSDEActionLogic pSDEActionLogic : arrayList) {
            PSDEActionLogic pSDEActionLogic2 = (PSDEActionLogic)this.getDEModel().createEntity();
            pSDEActionLogic2.setPSDEActionLogicId(pSDEActionLogic.getPSDEActionLogicId());
            pSDEActionLogic2.setMajorPSDERId(null);
            this.update(pSDEActionLogic2);
        }
    }

    public void removeByMajorPSDEId(PSDER pSDER) throws Exception {
        final PSDER pSDER2 = pSDER;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEActionLogicServiceBase.this.onBeforeRemoveByMajorPSDEId(pSDER2);
                PSDEActionLogicServiceBase.this.internalRemoveByMajorPSDEId(pSDER2);
                PSDEActionLogicServiceBase.this.onAfterRemoveByMajorPSDEId(pSDER2);
            }
        });
    }

    protected void onBeforeRemoveByMajorPSDEId(PSDER pSDER) throws Exception {
    }

    protected void internalRemoveByMajorPSDEId(PSDER pSDER) throws Exception {
        ArrayList<PSDEActionLogic> arrayList = this.selectByMajorPSDEId(pSDER);
        this.onBeforeRemoveByMajorPSDEId(pSDER, arrayList);
        for (PSDEActionLogic pSDEActionLogic : arrayList) {
            this.remove(pSDEActionLogic);
        }
        this.onAfterRemoveByMajorPSDEId(pSDER, arrayList);
    }

    protected void onAfterRemoveByMajorPSDEId(PSDER pSDER) throws Exception {
    }

    protected void onBeforeRemoveByMajorPSDEId(PSDER pSDER, ArrayList<PSDEActionLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByMajorPSDEId(PSDER pSDER, ArrayList<PSDEActionLogic> arrayList) throws Exception {
    }

    public void testRemoveByMinorPSDER(PSDER pSDER) throws Exception {
        ArrayList<PSDEActionLogic> arrayList = this.selectByMinorPSDER(pSDER, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDER);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEACTIONLOGIC_PSDER_MINORPSDERID", "", iDataEntityModel.getName(), "PSDEACTIONLOGIC", iDataEntityModel.getDataInfo(pSDER), arrayList.get(0)));
        }
    }

    public void resetMinorPSDER(PSDER pSDER) throws Exception {
        ArrayList<PSDEActionLogic> arrayList = this.selectByMinorPSDER(pSDER);
        for (PSDEActionLogic pSDEActionLogic : arrayList) {
            PSDEActionLogic pSDEActionLogic2 = (PSDEActionLogic)this.getDEModel().createEntity();
            pSDEActionLogic2.setPSDEActionLogicId(pSDEActionLogic.getPSDEActionLogicId());
            pSDEActionLogic2.setMinorPSDERId(null);
            this.update(pSDEActionLogic2);
        }
    }

    public void removeByMinorPSDER(PSDER pSDER) throws Exception {
        final PSDER pSDER2 = pSDER;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEActionLogicServiceBase.this.onBeforeRemoveByMinorPSDER(pSDER2);
                PSDEActionLogicServiceBase.this.internalRemoveByMinorPSDER(pSDER2);
                PSDEActionLogicServiceBase.this.onAfterRemoveByMinorPSDER(pSDER2);
            }
        });
    }

    protected void onBeforeRemoveByMinorPSDER(PSDER pSDER) throws Exception {
    }

    protected void internalRemoveByMinorPSDER(PSDER pSDER) throws Exception {
        ArrayList<PSDEActionLogic> arrayList = this.selectByMinorPSDER(pSDER);
        this.onBeforeRemoveByMinorPSDER(pSDER, arrayList);
        for (PSDEActionLogic pSDEActionLogic : arrayList) {
            this.remove(pSDEActionLogic);
        }
        this.onAfterRemoveByMinorPSDER(pSDER, arrayList);
    }

    protected void onAfterRemoveByMinorPSDER(PSDER pSDER) throws Exception {
    }

    protected void onBeforeRemoveByMinorPSDER(PSDER pSDER, ArrayList<PSDEActionLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByMinorPSDER(PSDER pSDER, ArrayList<PSDEActionLogic> arrayList) throws Exception {
    }

    public void testRemoveByErrorPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEActionLogic> arrayList = this.selectByErrorPSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEACTIONLOGIC_PSLANGUAGERES_ERRORPSLANRESID", "", iDataEntityModel.getName(), "PSDEACTIONLOGIC", iDataEntityModel.getDataInfo(pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetErrorPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEActionLogic> arrayList = this.selectByErrorPSLanRes(pSLanguageRes);
        for (PSDEActionLogic pSDEActionLogic : arrayList) {
            PSDEActionLogic pSDEActionLogic2 = (PSDEActionLogic)this.getDEModel().createEntity();
            pSDEActionLogic2.setPSDEActionLogicId(pSDEActionLogic.getPSDEActionLogicId());
            pSDEActionLogic2.setErrorPSLanResId(null);
            this.update(pSDEActionLogic2);
        }
    }

    public void removeByErrorPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEActionLogicServiceBase.this.onBeforeRemoveByErrorPSLanRes(pSLanguageRes2);
                PSDEActionLogicServiceBase.this.internalRemoveByErrorPSLanRes(pSLanguageRes2);
                PSDEActionLogicServiceBase.this.onAfterRemoveByErrorPSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByErrorPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByErrorPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEActionLogic> arrayList = this.selectByErrorPSLanRes(pSLanguageRes);
        this.onBeforeRemoveByErrorPSLanRes(pSLanguageRes, arrayList);
        for (PSDEActionLogic pSDEActionLogic : arrayList) {
            this.remove(pSDEActionLogic);
        }
        this.onAfterRemoveByErrorPSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByErrorPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByErrorPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEActionLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByErrorPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEActionLogic> arrayList) throws Exception {
    }

    public void testRemoveByPSSysDELogicNode(PSSysDELogicNode pSSysDELogicNode) throws Exception {
        ArrayList<PSDEActionLogic> arrayList = this.selectByPSSysDELogicNode(pSSysDELogicNode, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSDELOGICNODE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysDELogicNode);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEACTIONLOGIC_PSSYSDELOGICNODE_PSSYSDELOGICNODEID", "", iDataEntityModel.getName(), "PSDEACTIONLOGIC", iDataEntityModel.getDataInfo(pSSysDELogicNode), arrayList.get(0)));
        }
    }

    public void resetPSSysDELogicNode(PSSysDELogicNode pSSysDELogicNode) throws Exception {
        ArrayList<PSDEActionLogic> arrayList = this.selectByPSSysDELogicNode(pSSysDELogicNode);
        for (PSDEActionLogic pSDEActionLogic : arrayList) {
            PSDEActionLogic pSDEActionLogic2 = (PSDEActionLogic)this.getDEModel().createEntity();
            pSDEActionLogic2.setPSDEActionLogicId(pSDEActionLogic.getPSDEActionLogicId());
            pSDEActionLogic2.setPSSysDELogicNodeId(null);
            this.update(pSDEActionLogic2);
        }
    }

    public void removeByPSSysDELogicNode(PSSysDELogicNode pSSysDELogicNode) throws Exception {
        final PSSysDELogicNode pSSysDELogicNode2 = pSSysDELogicNode;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEActionLogicServiceBase.this.onBeforeRemoveByPSSysDELogicNode(pSSysDELogicNode2);
                PSDEActionLogicServiceBase.this.internalRemoveByPSSysDELogicNode(pSSysDELogicNode2);
                PSDEActionLogicServiceBase.this.onAfterRemoveByPSSysDELogicNode(pSSysDELogicNode2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysDELogicNode(PSSysDELogicNode pSSysDELogicNode) throws Exception {
    }

    protected void internalRemoveByPSSysDELogicNode(PSSysDELogicNode pSSysDELogicNode) throws Exception {
        ArrayList<PSDEActionLogic> arrayList = this.selectByPSSysDELogicNode(pSSysDELogicNode);
        this.onBeforeRemoveByPSSysDELogicNode(pSSysDELogicNode, arrayList);
        for (PSDEActionLogic pSDEActionLogic : arrayList) {
            this.remove(pSDEActionLogic);
        }
        this.onAfterRemoveByPSSysDELogicNode(pSSysDELogicNode, arrayList);
    }

    protected void onAfterRemoveByPSSysDELogicNode(PSSysDELogicNode pSSysDELogicNode) throws Exception {
    }

    protected void onBeforeRemoveByPSSysDELogicNode(PSSysDELogicNode pSSysDELogicNode, ArrayList<PSDEActionLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysDELogicNode(PSSysDELogicNode pSSysDELogicNode, ArrayList<PSDEActionLogic> arrayList) throws Exception {
    }

    public void testRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEActionLogic> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSPFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysPFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEACTIONLOGIC_PSSYSPFPLUGIN_PSSYSPFPLUGINID", "", iDataEntityModel.getName(), "PSDEACTIONLOGIC", iDataEntityModel.getDataInfo(pSSysPFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEActionLogic> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        for (PSDEActionLogic pSDEActionLogic : arrayList) {
            PSDEActionLogic pSDEActionLogic2 = (PSDEActionLogic)this.getDEModel().createEntity();
            pSDEActionLogic2.setPSDEActionLogicId(pSDEActionLogic.getPSDEActionLogicId());
            pSDEActionLogic2.setPSSysPFPluginId(null);
            this.update(pSDEActionLogic2);
        }
    }

    public void removeByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        final PSSysPFPlugin pSSysPFPlugin2 = pSSysPFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEActionLogicServiceBase.this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSDEActionLogicServiceBase.this.internalRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSDEActionLogicServiceBase.this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEActionLogic> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
        for (PSDEActionLogic pSDEActionLogic : arrayList) {
            this.remove(pSDEActionLogic);
        }
        this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSDEActionLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSDEActionLogic> arrayList) throws Exception {
    }

    public void testRemoveByPSSysSequence(PSSysSequence pSSysSequence) throws Exception {
        ArrayList<PSDEActionLogic> arrayList = this.selectByPSSysSequence(pSSysSequence, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSSEQUENCE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysSequence);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEACTIONLOGIC_PSSYSSEQUENCE_PSSYSSEQUENCEID", "", iDataEntityModel.getName(), "PSDEACTIONLOGIC", iDataEntityModel.getDataInfo(pSSysSequence), arrayList.get(0)));
        }
    }

    public void resetPSSysSequence(PSSysSequence pSSysSequence) throws Exception {
        ArrayList<PSDEActionLogic> arrayList = this.selectByPSSysSequence(pSSysSequence);
        for (PSDEActionLogic pSDEActionLogic : arrayList) {
            PSDEActionLogic pSDEActionLogic2 = (PSDEActionLogic)this.getDEModel().createEntity();
            pSDEActionLogic2.setPSDEActionLogicId(pSDEActionLogic.getPSDEActionLogicId());
            pSDEActionLogic2.setPSSysSequenceId(null);
            this.update(pSDEActionLogic2);
        }
    }

    public void removeByPSSysSequence(PSSysSequence pSSysSequence) throws Exception {
        final PSSysSequence pSSysSequence2 = pSSysSequence;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEActionLogicServiceBase.this.onBeforeRemoveByPSSysSequence(pSSysSequence2);
                PSDEActionLogicServiceBase.this.internalRemoveByPSSysSequence(pSSysSequence2);
                PSDEActionLogicServiceBase.this.onAfterRemoveByPSSysSequence(pSSysSequence2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysSequence(PSSysSequence pSSysSequence) throws Exception {
    }

    protected void internalRemoveByPSSysSequence(PSSysSequence pSSysSequence) throws Exception {
        ArrayList<PSDEActionLogic> arrayList = this.selectByPSSysSequence(pSSysSequence);
        this.onBeforeRemoveByPSSysSequence(pSSysSequence, arrayList);
        for (PSDEActionLogic pSDEActionLogic : arrayList) {
            this.remove(pSDEActionLogic);
        }
        this.onAfterRemoveByPSSysSequence(pSSysSequence, arrayList);
    }

    protected void onAfterRemoveByPSSysSequence(PSSysSequence pSSysSequence) throws Exception {
    }

    protected void onBeforeRemoveByPSSysSequence(PSSysSequence pSSysSequence, ArrayList<PSDEActionLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysSequence(PSSysSequence pSSysSequence, ArrayList<PSDEActionLogic> arrayList) throws Exception {
    }

    public void testRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSDEActionLogic> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSSFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysSFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEACTIONLOGIC_PSSYSSFPLUGIN_PSSYSSFPLUGINID", "", iDataEntityModel.getName(), "PSDEACTIONLOGIC", iDataEntityModel.getDataInfo(pSSysSFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSDEActionLogic> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        for (PSDEActionLogic pSDEActionLogic : arrayList) {
            PSDEActionLogic pSDEActionLogic2 = (PSDEActionLogic)this.getDEModel().createEntity();
            pSDEActionLogic2.setPSDEActionLogicId(pSDEActionLogic.getPSDEActionLogicId());
            pSDEActionLogic2.setPSSysSFPluginId(null);
            this.update(pSDEActionLogic2);
        }
    }

    public void removeByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        final PSSysSFPlugin pSSysSFPlugin2 = pSSysSFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEActionLogicServiceBase.this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSDEActionLogicServiceBase.this.internalRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSDEActionLogicServiceBase.this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSDEActionLogic> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
        for (PSDEActionLogic pSDEActionLogic : arrayList) {
            this.remove(pSDEActionLogic);
        }
        this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSDEActionLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSDEActionLogic> arrayList) throws Exception {
    }

    public void testRemoveByPSSysTranslator(PSSysTranslator pSSysTranslator) throws Exception {
        ArrayList<PSDEActionLogic> arrayList = this.selectByPSSysTranslator(pSSysTranslator, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSTRANSLATOR");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysTranslator);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEACTIONLOGIC_PSSYSTRANSLATOR_PSSYSTRANSLATORID", "", iDataEntityModel.getName(), "PSDEACTIONLOGIC", iDataEntityModel.getDataInfo(pSSysTranslator), arrayList.get(0)));
        }
    }

    public void resetPSSysTranslator(PSSysTranslator pSSysTranslator) throws Exception {
        ArrayList<PSDEActionLogic> arrayList = this.selectByPSSysTranslator(pSSysTranslator);
        for (PSDEActionLogic pSDEActionLogic : arrayList) {
            PSDEActionLogic pSDEActionLogic2 = (PSDEActionLogic)this.getDEModel().createEntity();
            pSDEActionLogic2.setPSDEActionLogicId(pSDEActionLogic.getPSDEActionLogicId());
            pSDEActionLogic2.setPSSysTranslatorId(null);
            this.update(pSDEActionLogic2);
        }
    }

    public void removeByPSSysTranslator(PSSysTranslator pSSysTranslator) throws Exception {
        final PSSysTranslator pSSysTranslator2 = pSSysTranslator;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEActionLogicServiceBase.this.onBeforeRemoveByPSSysTranslator(pSSysTranslator2);
                PSDEActionLogicServiceBase.this.internalRemoveByPSSysTranslator(pSSysTranslator2);
                PSDEActionLogicServiceBase.this.onAfterRemoveByPSSysTranslator(pSSysTranslator2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysTranslator(PSSysTranslator pSSysTranslator) throws Exception {
    }

    protected void internalRemoveByPSSysTranslator(PSSysTranslator pSSysTranslator) throws Exception {
        ArrayList<PSDEActionLogic> arrayList = this.selectByPSSysTranslator(pSSysTranslator);
        this.onBeforeRemoveByPSSysTranslator(pSSysTranslator, arrayList);
        for (PSDEActionLogic pSDEActionLogic : arrayList) {
            this.remove(pSDEActionLogic);
        }
        this.onAfterRemoveByPSSysTranslator(pSSysTranslator, arrayList);
    }

    protected void onAfterRemoveByPSSysTranslator(PSSysTranslator pSSysTranslator) throws Exception {
    }

    protected void onBeforeRemoveByPSSysTranslator(PSSysTranslator pSSysTranslator, ArrayList<PSDEActionLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysTranslator(PSSysTranslator pSSysTranslator, ArrayList<PSDEActionLogic> arrayList) throws Exception {
    }

    public void testRemoveByPSSysValueRule(PSSysValueRule pSSysValueRule) throws Exception {
        ArrayList<PSDEActionLogic> arrayList = this.selectByPSSysValueRule(pSSysValueRule, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSVALUERULE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysValueRule);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEACTIONLOGIC_PSSYSVALUERULE_PSSYSVALUERULEID", "", iDataEntityModel.getName(), "PSDEACTIONLOGIC", iDataEntityModel.getDataInfo(pSSysValueRule), arrayList.get(0)));
        }
    }

    public void resetPSSysValueRule(PSSysValueRule pSSysValueRule) throws Exception {
        ArrayList<PSDEActionLogic> arrayList = this.selectByPSSysValueRule(pSSysValueRule);
        for (PSDEActionLogic pSDEActionLogic : arrayList) {
            PSDEActionLogic pSDEActionLogic2 = (PSDEActionLogic)this.getDEModel().createEntity();
            pSDEActionLogic2.setPSDEActionLogicId(pSDEActionLogic.getPSDEActionLogicId());
            pSDEActionLogic2.setPSSysValueRuleId(null);
            this.update(pSDEActionLogic2);
        }
    }

    public void removeByPSSysValueRule(PSSysValueRule pSSysValueRule) throws Exception {
        final PSSysValueRule pSSysValueRule2 = pSSysValueRule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEActionLogicServiceBase.this.onBeforeRemoveByPSSysValueRule(pSSysValueRule2);
                PSDEActionLogicServiceBase.this.internalRemoveByPSSysValueRule(pSSysValueRule2);
                PSDEActionLogicServiceBase.this.onAfterRemoveByPSSysValueRule(pSSysValueRule2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysValueRule(PSSysValueRule pSSysValueRule) throws Exception {
    }

    protected void internalRemoveByPSSysValueRule(PSSysValueRule pSSysValueRule) throws Exception {
        ArrayList<PSDEActionLogic> arrayList = this.selectByPSSysValueRule(pSSysValueRule);
        this.onBeforeRemoveByPSSysValueRule(pSSysValueRule, arrayList);
        for (PSDEActionLogic pSDEActionLogic : arrayList) {
            this.remove(pSDEActionLogic);
        }
        this.onAfterRemoveByPSSysValueRule(pSSysValueRule, arrayList);
    }

    protected void onAfterRemoveByPSSysValueRule(PSSysValueRule pSSysValueRule) throws Exception {
    }

    protected void onBeforeRemoveByPSSysValueRule(PSSysValueRule pSSysValueRule, ArrayList<PSDEActionLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysValueRule(PSSysValueRule pSSysValueRule, ArrayList<PSDEActionLogic> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDEActionLogic pSDEActionLogic) throws Exception {
        super.onBeforeRemove(pSDEActionLogic);
    }

    protected void replaceParentInfo(PSDEActionLogic pSDEActionLogic, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDEActionLogic, cloneSession);
        if (pSDEActionLogic.getDstPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSDEActionLogic.getDstPSDEId())) != null) {
            this.onFillParentInfo_DstPSDE(pSDEActionLogic, (PSDataEntity)iEntity);
        }
        if (pSDEActionLogic.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSDEActionLogic.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSDEActionLogic, (PSDataEntity)iEntity);
        }
        if (pSDEActionLogic.getDstPSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSDEActionLogic.getDstPSDEActionId())) != null) {
            this.onFillParentInfo_DstPSDEAction(pSDEActionLogic, (PSDEAction)iEntity);
        }
        if (pSDEActionLogic.getPSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSDEActionLogic.getPSDEActionId())) != null) {
            this.onFillParentInfo_PSDEAction(pSDEActionLogic, (PSDEAction)iEntity);
        }
        if (pSDEActionLogic.getDstPSDEDataQueryId() != null && (iEntity = cloneSession.getEntity("PSDEDATAQUERY", (Object)pSDEActionLogic.getDstPSDEDataQueryId())) != null) {
            this.onFillParentInfo_DstPSDEDataQuery(pSDEActionLogic, (PSDEDataQuery)iEntity);
        }
        if (pSDEActionLogic.getDstPSDEDataSetId() != null && (iEntity = cloneSession.getEntity("PSDEDATASET", (Object)pSDEActionLogic.getDstPSDEDataSetId())) != null) {
            this.onFillParentInfo_DstPSDEDataSet(pSDEActionLogic, (PSDEDataSet)iEntity);
        }
        if (pSDEActionLogic.getPSDEDataSyncId() != null && (iEntity = cloneSession.getEntity("PSDEDATASYNC", (Object)pSDEActionLogic.getPSDEDataSyncId())) != null) {
            this.onFillParentInfo_PSDEDataSync(pSDEActionLogic, (PSDEDataSync)iEntity);
        }
        if (pSDEActionLogic.getPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSDEActionLogic.getPSDEFId())) != null) {
            this.onFillParentInfo_PSDEF(pSDEActionLogic, (PSDEField)iEntity);
        }
        if (pSDEActionLogic.getPSDEFValueRuleId() != null && (iEntity = cloneSession.getEntity("PSDEFVALUERULE", (Object)pSDEActionLogic.getPSDEFValueRuleId())) != null) {
            this.onFillParentInfo_PSDEFValueRule(pSDEActionLogic, (PSDEFValueRule)iEntity);
        }
        if (pSDEActionLogic.getDstPSDELogicId() != null && (iEntity = cloneSession.getEntity("PSDELOGIC", (Object)pSDEActionLogic.getDstPSDELogicId())) != null) {
            this.onFillParentInfo_DstPSDELogic(pSDEActionLogic, (PSDELogic)iEntity);
        }
        if (pSDEActionLogic.getPSDELogicId() != null && (iEntity = cloneSession.getEntity("PSDELOGIC", (Object)pSDEActionLogic.getPSDELogicId())) != null) {
            this.onFillParentInfo_PSDELogic(pSDEActionLogic, (PSDELogic)iEntity);
        }
        if (pSDEActionLogic.getPSDEMainStateId() != null && (iEntity = cloneSession.getEntity("PSDEMAINSTATE", (Object)pSDEActionLogic.getPSDEMainStateId())) != null) {
            this.onFillParentInfo_PSDEMainState(pSDEActionLogic, (PSDEMainState)iEntity);
        }
        if (pSDEActionLogic.getPSDENotifyId() != null && (iEntity = cloneSession.getEntity("PSDENOTIFY", (Object)pSDEActionLogic.getPSDENotifyId())) != null) {
            this.onFillParentInfo_PSDENotify(pSDEActionLogic, (PSDENotify)iEntity);
        }
        if (pSDEActionLogic.getMajorPSDERId() != null && (iEntity = cloneSession.getEntity("PSDER", (Object)pSDEActionLogic.getMajorPSDERId())) != null) {
            this.onFillParentInfo_MajorPSDEId(pSDEActionLogic, (PSDER)iEntity);
        }
        if (pSDEActionLogic.getMinorPSDERId() != null && (iEntity = cloneSession.getEntity("PSDER", (Object)pSDEActionLogic.getMinorPSDERId())) != null) {
            this.onFillParentInfo_MinorPSDER(pSDEActionLogic, (PSDER)iEntity);
        }
        if (pSDEActionLogic.getErrorPSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSDEActionLogic.getErrorPSLanResId())) != null) {
            this.onFillParentInfo_ErrorPSLanRes(pSDEActionLogic, (PSLanguageRes)iEntity);
        }
        if (pSDEActionLogic.getPSSysDELogicNodeId() != null && (iEntity = cloneSession.getEntity("PSSYSDELOGICNODE", (Object)pSDEActionLogic.getPSSysDELogicNodeId())) != null) {
            this.onFillParentInfo_PSSysDELogicNode(pSDEActionLogic, (PSSysDELogicNode)iEntity);
        }
        if (pSDEActionLogic.getPSSysPFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSPFPLUGIN", (Object)pSDEActionLogic.getPSSysPFPluginId())) != null) {
            this.onFillParentInfo_PSSysPFPlugin(pSDEActionLogic, (PSSysPFPlugin)iEntity);
        }
        if (pSDEActionLogic.getPSSysSequenceId() != null && (iEntity = cloneSession.getEntity("PSSYSSEQUENCE", (Object)pSDEActionLogic.getPSSysSequenceId())) != null) {
            this.onFillParentInfo_PSSysSequence(pSDEActionLogic, (PSSysSequence)iEntity);
        }
        if (pSDEActionLogic.getPSSysSFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSSFPLUGIN", (Object)pSDEActionLogic.getPSSysSFPluginId())) != null) {
            this.onFillParentInfo_PSSysSFPlugin(pSDEActionLogic, (PSSysSFPlugin)iEntity);
        }
        if (pSDEActionLogic.getPSSysTranslatorId() != null && (iEntity = cloneSession.getEntity("PSSYSTRANSLATOR", (Object)pSDEActionLogic.getPSSysTranslatorId())) != null) {
            this.onFillParentInfo_PSSysTranslator(pSDEActionLogic, (PSSysTranslator)iEntity);
        }
        if (pSDEActionLogic.getPSSysValueRuleId() != null && (iEntity = cloneSession.getEntity("PSSYSVALUERULE", (Object)pSDEActionLogic.getPSSysValueRuleId())) != null) {
            this.onFillParentInfo_PSSysValueRule(pSDEActionLogic, (PSSysValueRule)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDEActionLogic pSDEActionLogic, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDEActionLogic, bl);
    }

    protected void onCheckEntity(boolean bl, PSDEActionLogic pSDEActionLogic, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AttachMode(bl, pSDEActionLogic, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CloneParamFlag(bl, pSDEActionLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSDEActionLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomCode(bl, pSDEActionLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DataSyncEvent(bl, pSDEActionLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DstPSDEActionId(bl, pSDEActionLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DstPSDEDataQueryId(bl, pSDEActionLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DstPSDEDataSetId(bl, pSDEActionLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DstPSDEId(bl, pSDEActionLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DstPSDELogicId(bl, pSDEActionLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DstPSDEName(bl, pSDEActionLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaModelFlag(bl, pSDEActionLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ErrorCode(bl, pSDEActionLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ErrorMsg(bl, pSDEActionLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ErrorPSLanResId(bl, pSDEActionLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ErrorPSLanResName(bl, pSDEActionLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ExceptionObj(bl, pSDEActionLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IgnoreException(bl, pSDEActionLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_InternalLogic(bl, pSDEActionLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LockFlag(bl, pSDEActionLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogicHolder(bl, pSDEActionLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MajorPSDERId(bl, pSDEActionLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDEActionLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MinorPSDERId(bl, pSDEActionLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSDEActionLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PrepareLast(bl, pSDEActionLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PropertyMap(bl, pSDEActionLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEActionId(bl, pSDEActionLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEActionLogicId(bl, pSDEActionLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEActionLogicName(bl, pSDEActionLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDataSyncId(bl, pSDEActionLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFId(bl, pSDEActionLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFName(bl, pSDEActionLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFValueRuleId(bl, pSDEActionLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSDEActionLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDELogicId(bl, pSDEActionLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEMainStateId(bl, pSDEActionLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSDEActionLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDENotifyId(bl, pSDEActionLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaInstId(bl, pSDEActionLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDELogicNodeId(bl, pSDEActionLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysPFPluginId(bl, pSDEActionLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSequenceId(bl, pSDEActionLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSFPluginId(bl, pSDEActionLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysTranslatorId(bl, pSDEActionLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysValueRuleId(bl, pSDEActionLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSDEActionLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDEActionLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDEActionLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDEActionLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDEActionLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDEActionLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDEActionLogic, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AttachMode(boolean bl, PSDEActionLogic pSDEActionLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionLogic.isAttachModeDirty() && !bl2 : !pSDEActionLogic.isAttachModeDirty()) {
            return null;
        }
        String string = pSDEActionLogic.getAttachMode();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ATTACHMODE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_AttachMode_Default(pSDEActionLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ATTACHMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CloneParamFlag(boolean bl, PSDEActionLogic pSDEActionLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionLogic.isCloneParamFlagDirty() : !pSDEActionLogic.isCloneParamFlagDirty()) {
            return null;
        }
        Integer n = pSDEActionLogic.getCloneParamFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CloneParamFlag_Default(pSDEActionLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CLONEPARAMFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSDEActionLogic pSDEActionLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionLogic.isCodeNameDirty() : !pSDEActionLogic.isCodeNameDirty()) {
            return null;
        }
        String string = pSDEActionLogic.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSDEActionLogic, bl2, bl3);
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
                string3 = "PSDEACTIONID";
                String string4 = this.checkFieldDupRule(this.getPSDEActionLogicDEModel(), "CODENAME", string3, pSDEActionLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_CustomCode(boolean bl, PSDEActionLogic pSDEActionLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionLogic.isCustomCodeDirty() : !pSDEActionLogic.isCustomCodeDirty()) {
            return null;
        }
        String string = pSDEActionLogic.getCustomCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomCode_Default(pSDEActionLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_DataSyncEvent(boolean bl, PSDEActionLogic pSDEActionLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionLogic.isDataSyncEventDirty() : !pSDEActionLogic.isDataSyncEventDirty()) {
            return null;
        }
        Integer n = pSDEActionLogic.getDataSyncEvent();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DataSyncEvent_Default(pSDEActionLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DATASYNCEVENT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DstPSDEActionId(boolean bl, PSDEActionLogic pSDEActionLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionLogic.isDstPSDEActionIdDirty() : !pSDEActionLogic.isDstPSDEActionIdDirty()) {
            return null;
        }
        String string = pSDEActionLogic.getDstPSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DstPSDEActionId_Default(pSDEActionLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTPSDEACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DstPSDEDataQueryId(boolean bl, PSDEActionLogic pSDEActionLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionLogic.isDstPSDEDataQueryIdDirty() : !pSDEActionLogic.isDstPSDEDataQueryIdDirty()) {
            return null;
        }
        String string = pSDEActionLogic.getDstPSDEDataQueryId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DstPSDEDataQueryId_Default(pSDEActionLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTPSDEDATAQUERYID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DstPSDEDataSetId(boolean bl, PSDEActionLogic pSDEActionLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionLogic.isDstPSDEDataSetIdDirty() : !pSDEActionLogic.isDstPSDEDataSetIdDirty()) {
            return null;
        }
        String string = pSDEActionLogic.getDstPSDEDataSetId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DstPSDEDataSetId_Default(pSDEActionLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTPSDEDATASETID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DstPSDEId(boolean bl, PSDEActionLogic pSDEActionLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionLogic.isDstPSDEIdDirty() : !pSDEActionLogic.isDstPSDEIdDirty()) {
            return null;
        }
        String string = pSDEActionLogic.getDstPSDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DstPSDEId_Default(pSDEActionLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTPSDEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DstPSDELogicId(boolean bl, PSDEActionLogic pSDEActionLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionLogic.isDstPSDELogicIdDirty() : !pSDEActionLogic.isDstPSDELogicIdDirty()) {
            return null;
        }
        String string = pSDEActionLogic.getDstPSDELogicId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DstPSDELogicId_Default(pSDEActionLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTPSDELOGICID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DstPSDEName(boolean bl, PSDEActionLogic pSDEActionLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionLogic.isDstPSDENameDirty() : !pSDEActionLogic.isDstPSDENameDirty()) {
            return null;
        }
        String string = pSDEActionLogic.getDstPSDEName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DstPSDEName_Default(pSDEActionLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTPSDENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DynaModelFlag(boolean bl, PSDEActionLogic pSDEActionLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionLogic.isDynaModelFlagDirty() : !pSDEActionLogic.isDynaModelFlagDirty()) {
            return null;
        }
        Integer n = pSDEActionLogic.getDynaModelFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DynaModelFlag_Default(pSDEActionLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_ErrorCode(boolean bl, PSDEActionLogic pSDEActionLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionLogic.isErrorCodeDirty() : !pSDEActionLogic.isErrorCodeDirty()) {
            return null;
        }
        Integer n = pSDEActionLogic.getErrorCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ErrorCode_Default(pSDEActionLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ERRORCODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ErrorMsg(boolean bl, PSDEActionLogic pSDEActionLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionLogic.isErrorMsgDirty() : !pSDEActionLogic.isErrorMsgDirty()) {
            return null;
        }
        String string = pSDEActionLogic.getErrorMsg();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ErrorMsg_Default(pSDEActionLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ERRORMSG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ErrorPSLanResId(boolean bl, PSDEActionLogic pSDEActionLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionLogic.isErrorPSLanResIdDirty() : !pSDEActionLogic.isErrorPSLanResIdDirty()) {
            return null;
        }
        String string = pSDEActionLogic.getErrorPSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ErrorPSLanResId_Default(pSDEActionLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ERRORPSLANRESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ErrorPSLanResName(boolean bl, PSDEActionLogic pSDEActionLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionLogic.isErrorPSLanResNameDirty() : !pSDEActionLogic.isErrorPSLanResNameDirty()) {
            return null;
        }
        String string = pSDEActionLogic.getErrorPSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ErrorPSLanResName_Default(pSDEActionLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ERRORPSLANRESNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ExceptionObj(boolean bl, PSDEActionLogic pSDEActionLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionLogic.isExceptionObjDirty() : !pSDEActionLogic.isExceptionObjDirty()) {
            return null;
        }
        String string = pSDEActionLogic.getExceptionObj();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ExceptionObj_Default(pSDEActionLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXCEPTIONOBJ");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IgnoreException(boolean bl, PSDEActionLogic pSDEActionLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionLogic.isIgnoreExceptionDirty() : !pSDEActionLogic.isIgnoreExceptionDirty()) {
            return null;
        }
        Integer n = pSDEActionLogic.getIgnoreException();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_IgnoreException_Default(pSDEActionLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("IGNOREEXCEPTION");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_InternalLogic(boolean bl, PSDEActionLogic pSDEActionLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionLogic.isInternalLogicDirty() : !pSDEActionLogic.isInternalLogicDirty()) {
            return null;
        }
        Integer n = pSDEActionLogic.getInternalLogic();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_InternalLogic_Default(pSDEActionLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INTERNALLOGIC");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LockFlag(boolean bl, PSDEActionLogic pSDEActionLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionLogic.isLockFlagDirty() : !pSDEActionLogic.isLockFlagDirty()) {
            return null;
        }
        Integer n = pSDEActionLogic.getLockFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LockFlag_Default(pSDEActionLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_LogicHolder(boolean bl, PSDEActionLogic pSDEActionLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionLogic.isLogicHolderDirty() : !pSDEActionLogic.isLogicHolderDirty()) {
            return null;
        }
        Integer n = pSDEActionLogic.getLogicHolder();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LogicHolder_Default(pSDEActionLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOGICHOLDER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MajorPSDERId(boolean bl, PSDEActionLogic pSDEActionLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionLogic.isMajorPSDERIdDirty() : !pSDEActionLogic.isMajorPSDERIdDirty()) {
            return null;
        }
        String string = pSDEActionLogic.getMajorPSDERId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MajorPSDERId_Default(pSDEActionLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAJORPSDERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDEActionLogic pSDEActionLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionLogic.isMemoDirty() : !pSDEActionLogic.isMemoDirty()) {
            return null;
        }
        String string = pSDEActionLogic.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDEActionLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_MinorPSDERId(boolean bl, PSDEActionLogic pSDEActionLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionLogic.isMinorPSDERIdDirty() : !pSDEActionLogic.isMinorPSDERIdDirty()) {
            return null;
        }
        String string = pSDEActionLogic.getMinorPSDERId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MinorPSDERId_Default(pSDEActionLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MINORPSDERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSDEActionLogic pSDEActionLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionLogic.isOrderValueDirty() && !bl2 : !pSDEActionLogic.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSDEActionLogic.getOrderValue();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ORDERVALUE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSDEActionLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_PrepareLast(boolean bl, PSDEActionLogic pSDEActionLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionLogic.isPrepareLastDirty() : !pSDEActionLogic.isPrepareLastDirty()) {
            return null;
        }
        Integer n = pSDEActionLogic.getPrepareLast();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PrepareLast_Default(pSDEActionLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PREPARELAST");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PropertyMap(boolean bl, PSDEActionLogic pSDEActionLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionLogic.isPropertyMapDirty() : !pSDEActionLogic.isPropertyMapDirty()) {
            return null;
        }
        String string = pSDEActionLogic.getPropertyMap();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PropertyMap_Default(pSDEActionLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PROPERTYMAP");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEActionId(boolean bl, PSDEActionLogic pSDEActionLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionLogic.isPSDEActionIdDirty() && !bl2 : !pSDEActionLogic.isPSDEActionIdDirty()) {
            return null;
        }
        String string = pSDEActionLogic.getPSDEActionId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEACTIONID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEActionId_Default(pSDEActionLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEActionLogicId(boolean bl, PSDEActionLogic pSDEActionLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionLogic.isPSDEActionLogicIdDirty() && !bl2 : !pSDEActionLogic.isPSDEActionLogicIdDirty()) {
            return null;
        }
        String string = pSDEActionLogic.getPSDEActionLogicId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEACTIONLOGICID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEActionLogicId_Default(pSDEActionLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEACTIONLOGICID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEActionLogicName(boolean bl, PSDEActionLogic pSDEActionLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionLogic.isPSDEActionLogicNameDirty() && !bl2 : !pSDEActionLogic.isPSDEActionLogicNameDirty()) {
            return null;
        }
        String string = pSDEActionLogic.getPSDEActionLogicName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEACTIONLOGICNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEActionLogicName_Default(pSDEActionLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEACTIONLOGICNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEDataSyncId(boolean bl, PSDEActionLogic pSDEActionLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionLogic.isPSDEDataSyncIdDirty() : !pSDEActionLogic.isPSDEDataSyncIdDirty()) {
            return null;
        }
        String string = pSDEActionLogic.getPSDEDataSyncId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDataSyncId_Default(pSDEActionLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDATASYNCID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFId(boolean bl, PSDEActionLogic pSDEActionLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionLogic.isPSDEFIdDirty() : !pSDEActionLogic.isPSDEFIdDirty()) {
            return null;
        }
        String string = pSDEActionLogic.getPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFId_Default(pSDEActionLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEFName(boolean bl, PSDEActionLogic pSDEActionLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionLogic.isPSDEFNameDirty() : !pSDEActionLogic.isPSDEFNameDirty()) {
            return null;
        }
        String string = pSDEActionLogic.getPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFName_Default(pSDEActionLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEFValueRuleId(boolean bl, PSDEActionLogic pSDEActionLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionLogic.isPSDEFValueRuleIdDirty() : !pSDEActionLogic.isPSDEFValueRuleIdDirty()) {
            return null;
        }
        String string = pSDEActionLogic.getPSDEFValueRuleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFValueRuleId_Default(pSDEActionLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSDEActionLogic pSDEActionLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionLogic.isPSDEIdDirty() && !bl2 : !pSDEActionLogic.isPSDEIdDirty()) {
            return null;
        }
        String string = pSDEActionLogic.getPSDEId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default(pSDEActionLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDELogicId(boolean bl, PSDEActionLogic pSDEActionLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionLogic.isPSDELogicIdDirty() : !pSDEActionLogic.isPSDELogicIdDirty()) {
            return null;
        }
        String string = pSDEActionLogic.getPSDELogicId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDELogicId_PSDELogic(pSDEActionLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDELOGICID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
            string2 = this.onTestValueRule_PSDELogicId_Default(pSDEActionLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEMainStateId(boolean bl, PSDEActionLogic pSDEActionLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionLogic.isPSDEMainStateIdDirty() : !pSDEActionLogic.isPSDEMainStateIdDirty()) {
            return null;
        }
        String string = pSDEActionLogic.getPSDEMainStateId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEMainStateId_Default(pSDEActionLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSDEActionLogic pSDEActionLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionLogic.isPSDENameDirty() && !bl2 : !pSDEActionLogic.isPSDENameDirty()) {
            return null;
        }
        String string = pSDEActionLogic.getPSDEName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default(pSDEActionLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDENotifyId(boolean bl, PSDEActionLogic pSDEActionLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionLogic.isPSDENotifyIdDirty() : !pSDEActionLogic.isPSDENotifyIdDirty()) {
            return null;
        }
        String string = pSDEActionLogic.getPSDENotifyId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDENotifyId_Default(pSDEActionLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDENOTIFYID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDynaInstId(boolean bl, PSDEActionLogic pSDEActionLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionLogic.isPSDynaInstIdDirty() : !pSDEActionLogic.isPSDynaInstIdDirty()) {
            return null;
        }
        String string = pSDEActionLogic.getPSDynaInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaInstId_Default(pSDEActionLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysDELogicNodeId(boolean bl, PSDEActionLogic pSDEActionLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionLogic.isPSSysDELogicNodeIdDirty() : !pSDEActionLogic.isPSSysDELogicNodeIdDirty()) {
            return null;
        }
        String string = pSDEActionLogic.getPSSysDELogicNodeId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDELogicNodeId_Default(pSDEActionLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDELOGICNODEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysPFPluginId(boolean bl, PSDEActionLogic pSDEActionLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionLogic.isPSSysPFPluginIdDirty() : !pSDEActionLogic.isPSSysPFPluginIdDirty()) {
            return null;
        }
        String string = pSDEActionLogic.getPSSysPFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysPFPluginId_Default(pSDEActionLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysSequenceId(boolean bl, PSDEActionLogic pSDEActionLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionLogic.isPSSysSequenceIdDirty() : !pSDEActionLogic.isPSSysSequenceIdDirty()) {
            return null;
        }
        String string = pSDEActionLogic.getPSSysSequenceId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSequenceId_Default(pSDEActionLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSEQUENCEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysSFPluginId(boolean bl, PSDEActionLogic pSDEActionLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionLogic.isPSSysSFPluginIdDirty() : !pSDEActionLogic.isPSSysSFPluginIdDirty()) {
            return null;
        }
        String string = pSDEActionLogic.getPSSysSFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSFPluginId_Default(pSDEActionLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysTranslatorId(boolean bl, PSDEActionLogic pSDEActionLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionLogic.isPSSysTranslatorIdDirty() : !pSDEActionLogic.isPSSysTranslatorIdDirty()) {
            return null;
        }
        String string = pSDEActionLogic.getPSSysTranslatorId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysTranslatorId_Default(pSDEActionLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTRANSLATORID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysValueRuleId(boolean bl, PSDEActionLogic pSDEActionLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionLogic.isPSSysValueRuleIdDirty() : !pSDEActionLogic.isPSSysValueRuleIdDirty()) {
            return null;
        }
        String string = pSDEActionLogic.getPSSysValueRuleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysValueRuleId_Default(pSDEActionLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSVALUERULEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSDEActionLogic pSDEActionLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionLogic.isUserCatDirty() : !pSDEActionLogic.isUserCatDirty()) {
            return null;
        }
        String string = pSDEActionLogic.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSDEActionLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDEActionLogic pSDEActionLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionLogic.isUserTagDirty() : !pSDEActionLogic.isUserTagDirty()) {
            return null;
        }
        String string = pSDEActionLogic.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSDEActionLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDEActionLogic pSDEActionLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionLogic.isUserTag2Dirty() : !pSDEActionLogic.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDEActionLogic.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSDEActionLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDEActionLogic pSDEActionLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionLogic.isUserTag3Dirty() : !pSDEActionLogic.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDEActionLogic.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSDEActionLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDEActionLogic pSDEActionLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionLogic.isUserTag4Dirty() : !pSDEActionLogic.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDEActionLogic.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSDEActionLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDEActionLogic pSDEActionLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionLogic.isValidFlagDirty() && !bl2 : !pSDEActionLogic.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDEActionLogic.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSDEActionLogic, bl2, bl3);
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

    protected void onSyncEntity(PSDEActionLogic pSDEActionLogic, boolean bl) throws Exception {
        super.onSyncEntity(pSDEActionLogic, bl);
    }

    protected void onSyncIndexEntities(PSDEActionLogic pSDEActionLogic, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDEActionLogic, bl);
    }

    public Object getDataContextValue(PSDEActionLogic pSDEActionLogic, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDEACTION", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"DSTPSDEACTIONID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"DSTPSDEACTIONNAME", (boolean)true) == 0) && (object = super.getDataContextValue(pSDEActionLogic, "dstpsdeid", iDataContextParam)) != null) {
                return object;
            }
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDEDATAQUERY", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"DSTPSDEDATAQUERYID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"DSTPSDEDATAQUERYNAME", (boolean)true) == 0) && (object = super.getDataContextValue(pSDEActionLogic, "dstpsdeid", iDataContextParam)) != null) {
                return object;
            }
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDEDATASET", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"DSTPSDEDATASETID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"DSTPSDEDATASETNAME", (boolean)true) == 0) && (object = super.getDataContextValue(pSDEActionLogic, "dstpsdeid", iDataContextParam)) != null) {
                return object;
            }
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDELOGIC", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"DSTPSDELOGICID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"DSTPSDELOGICNAME", (boolean)true) == 0) && (object = super.getDataContextValue(pSDEActionLogic, "dstpsdeid", iDataContextParam)) != null) {
                return object;
            }
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDER", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"MAJORPSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"MAJORPSDERID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"MAJORPSDERNAME", (boolean)true) == 0) && (object = super.getDataContextValue(pSDEActionLogic, "psdeid", iDataContextParam)) != null) {
                return object;
            }
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDER", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"MINORPSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"MINORPSDERID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"MINORPSDERNAME", (boolean)true) == 0) && (object = super.getDataContextValue(pSDEActionLogic, "psdeid", iDataContextParam)) != null) {
                return object;
            }
        }
        if ((object = super.getDataContextValue(pSDEActionLogic, string, iDataContextParam)) != null) {
            return object;
        }
        PSDataEntity pSDataEntity = pSDEActionLogic.getPSDE();
        if (pSDataEntity != null && pSDataEntity.contains(string)) {
            return pSDataEntity.get(string);
        }
        PSDEAction pSDEAction = pSDEActionLogic.getPSDEAction();
        if (pSDEAction != null && pSDEAction.contains(string)) {
            return pSDEAction.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDEActionLogic pSDEActionLogic, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDEActionLogic, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ATTACHMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AttachMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CLONEPARAMFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CloneParamFlag_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"DATASYNCEVENT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DataSyncEvent_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSDEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSDEActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSDEACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSDEActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSDEDATAQUERYID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSDEDataQueryId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSDEDATAQUERYNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSDEDataQueryName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSDEDATASETID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSDEDataSetId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSDEDATASETNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSDEDataSetName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSDELOGICID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSDELogicId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSDELOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSDELogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DYNAMODELFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaModelFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ERRORCODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ErrorCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ERRORMSG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ErrorMsg_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ERRORPSLANRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ErrorPSLanResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ERRORPSLANRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ErrorPSLanResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXCEPTIONOBJ", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ExceptionObj_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"IGNOREEXCEPTION", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IgnoreException_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INTERNALLOGIC", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_InternalLogic_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOCKFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LockFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGICHOLDER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogicHolder_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAJORPSDERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MajorPSDERId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAJORPSDERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MajorPSDERName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MINORPSDERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MinorPSDERId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MINORPSDERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MinorPSDERName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PREPARELAST", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PrepareLast_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PROPERTYMAP", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PropertyMap_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEACTIONLOGICID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEActionLogicId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEACTIONLOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEActionLogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDATASYNCID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDataSyncId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDATASYNCNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDataSyncName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSDELOGICID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"PSDELOGIC", (boolean)true) == 0) {
            return this.onTestValueRule_PSDELogicId_PSDELogic(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDELOGICID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDELogicId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDELOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDELogicName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSDENOTIFYID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDENotifyId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDENOTIFYNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDENotifyName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDELOGICNODEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDELogicNodeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDELOGICNODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDELogicNodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSPFPLUGINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysPFPluginId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSPFPLUGINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysPFPluginName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSEQUENCEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSequenceId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSEQUENCENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSequenceName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSFPLUGINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSFPluginId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSFPLUGINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSFPluginName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTRANSLATORID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysTranslatorId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTRANSLATORNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysTranslatorName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSVALUERULEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysValueRuleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSVALUERULENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysValueRuleName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_AttachMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ATTACHMODE", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CloneParamFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_DataSyncEvent_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DstPSDEActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSDEACTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstPSDEActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSDEACTIONNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstPSDEDataQueryId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSDEDATAQUERYID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstPSDEDataQueryName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSDEDATAQUERYNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstPSDEDataSetId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSDEDATASETID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstPSDEDataSetName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSDEDATASETNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstPSDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSDEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstPSDELogicId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSDELOGICID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstPSDELogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSDELOGICNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstPSDEName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSDENAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
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

    protected String onTestValueRule_ErrorCode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ErrorMsg_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ERRORMSG", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ErrorPSLanResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ERRORPSLANRESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ErrorPSLanResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ERRORPSLANRESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ExceptionObj_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EXCEPTIONOBJ", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_IgnoreException_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_InternalLogic_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_LockFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_LogicHolder_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_MajorPSDERId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MAJORPSDERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MajorPSDERName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MAJORPSDERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_MinorPSDERId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MINORPSDERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MinorPSDERName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MINORPSDERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PrepareLast_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PropertyMap_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PROPERTYMAP", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEACTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEActionLogicId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEACTIONLOGICID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEActionLogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEACTIONLOGICNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEACTIONNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDataSyncId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDATASYNCID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDataSyncName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDATASYNCNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_PSDELogicId_PSDELogic(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldDataSetRule("PSDELOGICID", "PSDELOGIC", "CurDE", iEntity, bl2, null, null, "\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d", true)) {
                return null;
            }
            return "\u5b9e\u4f53\u903b\u8f91\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d";
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

    protected String onTestValueRule_PSDENotifyId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDENOTIFYID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDENotifyName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDENOTIFYNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSysDELogicNodeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDELOGICNODEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysDELogicNodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDELOGICNODENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSysSequenceId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSEQUENCEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysSequenceName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSEQUENCENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSysTranslatorId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTRANSLATORID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysTranslatorName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTRANSLATORNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysValueRuleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSVALUERULEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysValueRuleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSVALUERULENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSDEActionLogic pSDEActionLogic) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDEActionLogic)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDEActionLogic pSDEActionLogic) throws Exception {
        IService iService;
        Object object = pSDEActionLogic.get("DSTPSDEID");
        if (object != null) {
            iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSDEACTIONLOGIC_PSDATAENTITY_DSTPSDEID", object);
        }
        if ((object = pSDEActionLogic.get("PSDEID")) != null) {
            iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSDEACTIONLOGIC_PSDATAENTITY_PSDEID", object);
        }
        if ((object = pSDEActionLogic.get("PSDEACTIONID")) != null) {
            iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSDEACTIONLOGIC_PSDEACTION_PSDEACTIONID", object);
        }
        super.onUpdateParent(pSDEActionLogic);
    }

    protected boolean isNeedUpdateParent() {
        return true;
    }

    @Override
    protected void exportCurXmlModel(PSDEActionLogic pSDEActionLogic, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEACTIONLOGIC");
        if (!bl) {
            pSDEActionLogic.setCreateDate(null);
            pSDEActionLogic.setCreateMan(null);
            pSDEActionLogic.setPSDEActionLogicId(null);
            pSDEActionLogic.setUpdateDate(null);
            pSDEActionLogic.setUpdateMan(null);
            super.exportCurXmlModel(pSDEActionLogic, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDEActionLogic pSDEActionLogic, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDEActionLogic, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEACTIONID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDEACTION#%1$s", (Object)string);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDATAENTITY#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEACTIONID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDEACTIONLOGIC_PSDEACTION_PSDEACTIONID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDEACTIONLOGIC_PSDATAENTITY_PSDEID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEACTIONID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEACTIONNAME", null);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSDENAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSDEACTION", (boolean)true) == 0) {
            iEntity.set("PSDEACTIONID", (Object)string2);
            return true;
        }
        if (StringHelper.compare((String)string, (String)"PSDATAENTITY", (boolean)true) == 0) {
            iEntity.set("PSDEID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSDEACTIONID", "PSDEID"};
    }

    @Override
    public String getModelV2Tag(PSDEActionLogic pSDEActionLogic) {
        if (!StringHelper.isNullOrEmpty((String)pSDEActionLogic.getCodeName())) {
            return pSDEActionLogic.getCodeName();
        }
        return super.getModelV2Tag(pSDEActionLogic);
    }

    @Override
    public boolean setModelV2Tag(PSDEActionLogic pSDEActionLogic, String string) {
        pSDEActionLogic.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("PSDEACTIONID", "");
        map.put("PSDEID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDEActionLogic pSDEActionLogic, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDEActionLogic.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDEActionLogic, true);
        pSDEActionLogic.set("CODENAME", string);
        if (this.select(pSDEActionLogic, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSDEActionLogic, true);
        return super.getModelV2Entity(pSDEActionLogic, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDEActionLogic pSDEActionLogic, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return false;
        }
        return super.testCompileCurModelV2(pSDEActionLogic, objectNode, string, string2, n);
    }
}

