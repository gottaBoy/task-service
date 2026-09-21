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
package net.ibizsys.pscore.srv.sysdesign.service;

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
import net.ibizsys.pscore.srv.config.entity.PSSysResource;
import net.ibizsys.pscore.srv.config.entity.PSSysResourceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGroupBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEACModeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEACModeServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicNodeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicNodeServiceBase;
import net.ibizsys.pscore.srv.sysdesign.dao.PSSysUtilDEDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysUtilDEDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDERGroup;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDERGroupBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModuleBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysServiceAPI;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysServiceAPIBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDataSyncAgent;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDataSyncAgentBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysModelGroup;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysModelGroupBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPluginBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUtilDE;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysBackServiceService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysBackServiceServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysMsgQueueService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysMsgQueueServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysMsgTargetService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysMsgTargetServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUniStateService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUniStateServiceBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysUtilDEServiceBase
extends PSCoreSysServiceBase<PSSysUtilDE> {
    private static final Log log = LogFactory.getLog(PSSysUtilDEServiceBase.class);
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String DATASET_FORMTYPE = "FormType";
    private static Map<String, String> defaultValueMap = new HashMap<String, String>();
    private PSSysUtilDEDEModel pSSysUtilDEDEModel;
    private PSSysUtilDEDAO pSSysUtilDEDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSSysUtilDEService";
    }

    public PSSysUtilDEDEModel getPSSysUtilDEDEModel() {
        if (this.pSSysUtilDEDEModel == null) {
            try {
                this.pSSysUtilDEDEModel = (PSSysUtilDEDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysUtilDEDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysUtilDEDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysUtilDEDEModel();
    }

    public PSSysUtilDEDAO getPSSysUtilDEDAO() {
        if (this.pSSysUtilDEDAO == null) {
            try {
                this.pSSysUtilDEDAO = (PSSysUtilDEDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSSysUtilDEDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysUtilDEDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysUtilDEDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURSYS, (boolean)true) == 0) {
            return this.fetchCurSys(iDEDataSetFetchContext);
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
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurSys(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYS, false);
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

    protected void onFillParentInfo(PSSysUtilDE pSSysUtilDE, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSUTILDE_PSDATAENTITY_UTILPSDE10ID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_UtilPSDE10(pSSysUtilDE, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSUTILDE_PSDATAENTITY_UTILPSDE11ID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_UtilPSDE11(pSSysUtilDE, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSUTILDE_PSDATAENTITY_UTILPSDE12ID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_UtilPSDE12(pSSysUtilDE, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSUTILDE_PSDATAENTITY_UTILPSDE13ID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_UtilPSDE13(pSSysUtilDE, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSUTILDE_PSDATAENTITY_UTILPSDE14ID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_UtilPSDE14(pSSysUtilDE, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSUTILDE_PSDATAENTITY_UTILPSDE15ID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_UtilPSDE15(pSSysUtilDE, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSUTILDE_PSDATAENTITY_UTILPSDE16ID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_UtilPSDE16(pSSysUtilDE, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSUTILDE_PSDATAENTITY_UTILPSDE17ID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_UtilPSDE17(pSSysUtilDE, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSUTILDE_PSDATAENTITY_UTILPSDE18ID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_UtilPSDE18(pSSysUtilDE, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSUTILDE_PSDATAENTITY_UTILPSDE19ID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_UtilPSDE19(pSSysUtilDE, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSUTILDE_PSDATAENTITY_UTILPSDE20ID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_UtilPSDE20(pSSysUtilDE, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSUTILDE_PSDATAENTITY_UTILPSDE2ID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_UtilPSDE2(pSSysUtilDE, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSUTILDE_PSDATAENTITY_UTILPSDE3ID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_UtilPSDE3(pSSysUtilDE, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSUTILDE_PSDATAENTITY_UTILPSDE4ID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_UtilPSDE4(pSSysUtilDE, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSUTILDE_PSDATAENTITY_UTILPSDE5ID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_UtilPSDE5(pSSysUtilDE, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSUTILDE_PSDATAENTITY_UTILPSDE6ID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_UtilPSDE6(pSSysUtilDE, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSUTILDE_PSDATAENTITY_UTILPSDE7ID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_UtilPSDE7(pSSysUtilDE, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSUTILDE_PSDATAENTITY_UTILPSDE8ID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_UtilPSDE8(pSSysUtilDE, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSUTILDE_PSDATAENTITY_UTILPSDE9ID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_UtilPSDE9(pSSysUtilDE, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSUTILDE_PSDATAENTITY_UTILPSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_UtilPSDE(pSSysUtilDE, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSUTILDE_PSDEGROUP_PSDEGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEGroupService", (SessionFactory)this.getSessionFactory());
            PSDEGroup pSDEGroup = (PSDEGroup)iService.getDEModel().createEntity();
            pSDEGroup.set("PSDEGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEGroup);
            } else {
                iService.get((IEntity)pSDEGroup);
            }
            this.onFillParentInfo_PSDEGroup(pSSysUtilDE, pSDEGroup);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSUTILDE_PSDERGROUP_PSDERGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDERGroupService", (SessionFactory)this.getSessionFactory());
            PSDERGroup pSDERGroup = (PSDERGroup)iService.getDEModel().createEntity();
            pSDERGroup.set("PSDERGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDERGroup);
            } else {
                iService.get((IEntity)pSDERGroup);
            }
            this.onFillParentInfo_PSDERGroup(pSSysUtilDE, pSDERGroup);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSUTILDE_PSMODULE_PSMODULEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSModuleService", (SessionFactory)this.getSessionFactory());
            PSModule pSModule = (PSModule)iService.getDEModel().createEntity();
            pSModule.set("PSMODULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSModule);
            } else {
                iService.get((IEntity)pSModule);
            }
            this.onFillParentInfo_PSModule(pSSysUtilDE, pSModule);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSUTILDE_PSSUBSYSSERVICEAPI_PSSUBSYSSERVICEAPIID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSubSysServiceAPIService", (SessionFactory)this.getSessionFactory());
            PSSubSysServiceAPI pSSubSysServiceAPI = (PSSubSysServiceAPI)iService.getDEModel().createEntity();
            pSSubSysServiceAPI.set("PSSUBSYSSERVICEAPIID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSubSysServiceAPI);
            } else {
                iService.get((IEntity)pSSubSysServiceAPI);
            }
            this.onFillParentInfo_PSSubSysServiceAPI(pSSysUtilDE, pSSubSysServiceAPI);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSUTILDE_PSSYSDATASYNCAGENT_INPSSYSDATASYNCAGENTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDataSyncAgentService", (SessionFactory)this.getSessionFactory());
            PSSysDataSyncAgent pSSysDataSyncAgent = (PSSysDataSyncAgent)iService.getDEModel().createEntity();
            pSSysDataSyncAgent.set("PSSYSDATASYNCAGENTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysDataSyncAgent);
            } else {
                iService.get((IEntity)pSSysDataSyncAgent);
            }
            this.onFillParentInfo_InPSSysDataSyncAgent(pSSysUtilDE, pSSysDataSyncAgent);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSUTILDE_PSSYSDATASYNCAGENT_OUTPSSYSDATASYNCAGENTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDataSyncAgentService", (SessionFactory)this.getSessionFactory());
            PSSysDataSyncAgent pSSysDataSyncAgent = (PSSysDataSyncAgent)iService.getDEModel().createEntity();
            pSSysDataSyncAgent.set("PSSYSDATASYNCAGENTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysDataSyncAgent);
            } else {
                iService.get((IEntity)pSSysDataSyncAgent);
            }
            this.onFillParentInfo_OutPSSysDataSyncAgent(pSSysUtilDE, pSSysDataSyncAgent);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSUTILDE_PSSYSDYNAMODEL_PSSYSDYNAMODELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService", (SessionFactory)this.getSessionFactory());
            PSSysDynaModel pSSysDynaModel = (PSSysDynaModel)iService.getDEModel().createEntity();
            pSSysDynaModel.set("PSSYSDYNAMODELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysDynaModel);
            } else {
                iService.get((IEntity)pSSysDynaModel);
            }
            this.onFillParentInfo_PSSysDynaModel(pSSysUtilDE, pSSysDynaModel);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSUTILDE_PSSYSMODELGROUP_PSSYSMODELGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysModelGroupService", (SessionFactory)this.getSessionFactory());
            PSSysModelGroup pSSysModelGroup = (PSSysModelGroup)iService.getDEModel().createEntity();
            pSSysModelGroup.set("PSSYSMODELGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysModelGroup);
            } else {
                iService.get((IEntity)pSSysModelGroup);
            }
            this.onFillParentInfo_PSSysModelGroup(pSSysUtilDE, pSSysModelGroup);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSUTILDE_PSSYSRESOURCE_OUTPSSYSRESOURCEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysResourceService", (SessionFactory)this.getSessionFactory());
            PSSysResource pSSysResource = (PSSysResource)iService.getDEModel().createEntity();
            pSSysResource.set("PSSYSRESOURCEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysResource);
            } else {
                iService.get((IEntity)pSSysResource);
            }
            this.onFillParentInfo_OutPSSysResource(pSSysUtilDE, pSSysResource);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSUTILDE_PSSYSRESOURCE_PSSYSRESOURCEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysResourceService", (SessionFactory)this.getSessionFactory());
            PSSysResource pSSysResource = (PSSysResource)iService.getDEModel().createEntity();
            pSSysResource.set("PSSYSRESOURCEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysResource);
            } else {
                iService.get((IEntity)pSSysResource);
            }
            this.onFillParentInfo_PSSysResource(pSSysUtilDE, pSSysResource);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSUTILDE_PSSYSSFPLUGIN_PSSYSSFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysSFPlugin pSSysSFPlugin = (PSSysSFPlugin)iService.getDEModel().createEntity();
            pSSysSFPlugin.set("PSSYSSFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysSFPlugin);
            } else {
                iService.get((IEntity)pSSysSFPlugin);
            }
            this.onFillParentInfo_PSSysSFPlugin(pSSysUtilDE, pSSysSFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSUTILDE_PSSYSTEM_PSSYSTEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemService", (SessionFactory)this.getSessionFactory());
            PSSystem pSSystem = (PSSystem)iService.getDEModel().createEntity();
            pSSystem.set("PSSYSTEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSystem);
            } else {
                iService.get((IEntity)pSSystem);
            }
            this.onFillParentInfo_PSSystem(pSSysUtilDE, pSSystem);
            return;
        }
        super.onFillParentInfo((IEntity)pSSysUtilDE, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_UtilPSDE10(PSSysUtilDE pSSysUtilDE, PSDataEntity pSDataEntity) throws Exception {
        pSSysUtilDE.setUtilPSDE10Id(pSDataEntity.getPSDataEntityId());
        pSSysUtilDE.setUtilPSDE10Name(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_UtilPSDE11(PSSysUtilDE pSSysUtilDE, PSDataEntity pSDataEntity) throws Exception {
        pSSysUtilDE.setUtilPSDE11Id(pSDataEntity.getPSDataEntityId());
        pSSysUtilDE.setUtilPSDE11Name(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_UtilPSDE12(PSSysUtilDE pSSysUtilDE, PSDataEntity pSDataEntity) throws Exception {
        pSSysUtilDE.setUtilPSDE12Id(pSDataEntity.getPSDataEntityId());
        pSSysUtilDE.setUtilPSDE12Name(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_UtilPSDE13(PSSysUtilDE pSSysUtilDE, PSDataEntity pSDataEntity) throws Exception {
        pSSysUtilDE.setUtilPSDE13Id(pSDataEntity.getPSDataEntityId());
        pSSysUtilDE.setUtilPSDE13Name(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_UtilPSDE14(PSSysUtilDE pSSysUtilDE, PSDataEntity pSDataEntity) throws Exception {
        pSSysUtilDE.setUtilPSDE14Id(pSDataEntity.getPSDataEntityId());
        pSSysUtilDE.setUtilPSDE14Name(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_UtilPSDE15(PSSysUtilDE pSSysUtilDE, PSDataEntity pSDataEntity) throws Exception {
        pSSysUtilDE.setUtilPSDE15Id(pSDataEntity.getPSDataEntityId());
        pSSysUtilDE.setUtilPSDE15Name(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_UtilPSDE16(PSSysUtilDE pSSysUtilDE, PSDataEntity pSDataEntity) throws Exception {
        pSSysUtilDE.setUtilPSDE16Id(pSDataEntity.getPSDataEntityId());
        pSSysUtilDE.setUtilPSDE16Name(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_UtilPSDE17(PSSysUtilDE pSSysUtilDE, PSDataEntity pSDataEntity) throws Exception {
        pSSysUtilDE.setUtilPSDE17Id(pSDataEntity.getPSDataEntityId());
        pSSysUtilDE.setUtilPSDE17Name(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_UtilPSDE18(PSSysUtilDE pSSysUtilDE, PSDataEntity pSDataEntity) throws Exception {
        pSSysUtilDE.setUtilPSDE18Id(pSDataEntity.getPSDataEntityId());
        pSSysUtilDE.setUtilPSDE18Name(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_UtilPSDE19(PSSysUtilDE pSSysUtilDE, PSDataEntity pSDataEntity) throws Exception {
        pSSysUtilDE.setUtilPSDE19Id(pSDataEntity.getPSDataEntityId());
        pSSysUtilDE.setUtilPSDE19Name(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_UtilPSDE20(PSSysUtilDE pSSysUtilDE, PSDataEntity pSDataEntity) throws Exception {
        pSSysUtilDE.setUtilPSDE20Id(pSDataEntity.getPSDataEntityId());
        pSSysUtilDE.setUtilPSDE20Name(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_UtilPSDE2(PSSysUtilDE pSSysUtilDE, PSDataEntity pSDataEntity) throws Exception {
        pSSysUtilDE.setUtilPSDE2Id(pSDataEntity.getPSDataEntityId());
        pSSysUtilDE.setUtilPSDE2Name(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_UtilPSDE3(PSSysUtilDE pSSysUtilDE, PSDataEntity pSDataEntity) throws Exception {
        pSSysUtilDE.setUtilPSDE3Id(pSDataEntity.getPSDataEntityId());
        pSSysUtilDE.setUtilPSDE3Name(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_UtilPSDE4(PSSysUtilDE pSSysUtilDE, PSDataEntity pSDataEntity) throws Exception {
        pSSysUtilDE.setUtilPSDE4Id(pSDataEntity.getPSDataEntityId());
        pSSysUtilDE.setUtilPSDE4Name(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_UtilPSDE5(PSSysUtilDE pSSysUtilDE, PSDataEntity pSDataEntity) throws Exception {
        pSSysUtilDE.setUtilPSDE5Id(pSDataEntity.getPSDataEntityId());
        pSSysUtilDE.setUtilPSDE5Name(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_UtilPSDE6(PSSysUtilDE pSSysUtilDE, PSDataEntity pSDataEntity) throws Exception {
        pSSysUtilDE.setUtilPSDE6Id(pSDataEntity.getPSDataEntityId());
        pSSysUtilDE.setUtilPSDE6Name(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_UtilPSDE7(PSSysUtilDE pSSysUtilDE, PSDataEntity pSDataEntity) throws Exception {
        pSSysUtilDE.setUtilPSDE7Id(pSDataEntity.getPSDataEntityId());
        pSSysUtilDE.setUtilPSDE7Name(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_UtilPSDE8(PSSysUtilDE pSSysUtilDE, PSDataEntity pSDataEntity) throws Exception {
        pSSysUtilDE.setUtilPSDE8Id(pSDataEntity.getPSDataEntityId());
        pSSysUtilDE.setUtilPSDE8Name(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_UtilPSDE9(PSSysUtilDE pSSysUtilDE, PSDataEntity pSDataEntity) throws Exception {
        pSSysUtilDE.setUtilPSDE9Id(pSDataEntity.getPSDataEntityId());
        pSSysUtilDE.setUtilPSDE9Name(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_UtilPSDE(PSSysUtilDE pSSysUtilDE, PSDataEntity pSDataEntity) throws Exception {
        pSSysUtilDE.setUtilPSDEId(pSDataEntity.getPSDataEntityId());
        pSSysUtilDE.setUtilPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_PSDEGroup(PSSysUtilDE pSSysUtilDE, PSDEGroup pSDEGroup) throws Exception {
        pSSysUtilDE.setPSDEGroupId(pSDEGroup.getPSDEGroupId());
        pSSysUtilDE.setPSDEGroupName(pSDEGroup.getPSDEGroupName());
    }

    protected void onFillParentInfo_PSDERGroup(PSSysUtilDE pSSysUtilDE, PSDERGroup pSDERGroup) throws Exception {
        pSSysUtilDE.setPSDERGroupId(pSDERGroup.getPSDERGroupId());
        pSSysUtilDE.setPSDERGroupName(pSDERGroup.getPSDERGroupName());
    }

    protected void onFillParentInfo_PSModule(PSSysUtilDE pSSysUtilDE, PSModule pSModule) throws Exception {
        pSSysUtilDE.setPSModuleId(pSModule.getPSModuleId());
        pSSysUtilDE.setPSModuleName(pSModule.getPSModuleName());
    }

    protected void onFillParentInfo_PSSubSysServiceAPI(PSSysUtilDE pSSysUtilDE, PSSubSysServiceAPI pSSubSysServiceAPI) throws Exception {
        pSSysUtilDE.setPSSubSysServiceAPIId(pSSubSysServiceAPI.getPSSubSysServiceAPIId());
        pSSysUtilDE.setPSSubSysServiceAPIName(pSSubSysServiceAPI.getPSSubSysServiceAPIName());
    }

    protected void onFillParentInfo_InPSSysDataSyncAgent(PSSysUtilDE pSSysUtilDE, PSSysDataSyncAgent pSSysDataSyncAgent) throws Exception {
        pSSysUtilDE.setInPSSysDataSyncAgentId(pSSysDataSyncAgent.getPSSysDataSyncAgentId());
        pSSysUtilDE.setInPSSysDataSyncAgentName(pSSysDataSyncAgent.getPSSysDataSyncAgentName());
    }

    protected void onFillParentInfo_OutPSSysDataSyncAgent(PSSysUtilDE pSSysUtilDE, PSSysDataSyncAgent pSSysDataSyncAgent) throws Exception {
        pSSysUtilDE.setOutPSSysDataSyncAgentId(pSSysDataSyncAgent.getPSSysDataSyncAgentId());
        pSSysUtilDE.setOutPSSysDataSyncAgentName(pSSysDataSyncAgent.getPSSysDataSyncAgentName());
    }

    protected void onFillParentInfo_PSSysDynaModel(PSSysUtilDE pSSysUtilDE, PSSysDynaModel pSSysDynaModel) throws Exception {
        pSSysUtilDE.setPSSysDynaModelId(pSSysDynaModel.getPSSysDynaModelId());
        pSSysUtilDE.setPSSysDynaModelName(pSSysDynaModel.getPSSysDynaModelName());
    }

    protected void onFillParentInfo_PSSysModelGroup(PSSysUtilDE pSSysUtilDE, PSSysModelGroup pSSysModelGroup) throws Exception {
        pSSysUtilDE.setPSSysModelGroupId(pSSysModelGroup.getPSSysModelGroupId());
        pSSysUtilDE.setPSSysModelGroupName(pSSysModelGroup.getPSSysModelGroupName());
    }

    protected void onFillParentInfo_OutPSSysResource(PSSysUtilDE pSSysUtilDE, PSSysResource pSSysResource) throws Exception {
        pSSysUtilDE.setOutPSSysResourceId(pSSysResource.getPSSysResourceId());
        pSSysUtilDE.setOutPSSysResourceName(pSSysResource.getPSSysResourceName());
    }

    protected void onFillParentInfo_PSSysResource(PSSysUtilDE pSSysUtilDE, PSSysResource pSSysResource) throws Exception {
        pSSysUtilDE.setPSSysResourceId(pSSysResource.getPSSysResourceId());
        pSSysUtilDE.setPSSysResourceName(pSSysResource.getPSSysResourceName());
    }

    protected void onFillParentInfo_PSSysSFPlugin(PSSysUtilDE pSSysUtilDE, PSSysSFPlugin pSSysSFPlugin) throws Exception {
        pSSysUtilDE.setPSSysSFPluginId(pSSysSFPlugin.getPSSysSFPluginId());
        pSSysUtilDE.setPSSysSFPluginName(pSSysSFPlugin.getPSSysSFPluginName());
    }

    protected void onFillParentInfo_PSSystem(PSSysUtilDE pSSysUtilDE, PSSystem pSSystem) throws Exception {
        pSSysUtilDE.setPSSystemId(pSSystem.getPSSystemId());
        pSSysUtilDE.setPSSystemName(pSSystem.getPSSystemName());
    }

    protected void onFillEntityFullInfo(PSSysUtilDE pSSysUtilDE, boolean bl) throws Exception {
        if (bl) {
            if (pSSysUtilDE.getCodeName() == null) {
                pSSysUtilDE.setCodeName((String)this.getDefaultValue(this.getWebContext(), "USER", "SysUtil", 25));
            }
            if (pSSysUtilDE.getValidFlag() == null) {
                pSSysUtilDE.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo((IEntity)pSSysUtilDE, bl);
        this.onFillEntityFullInfo_UtilPSDE10(pSSysUtilDE, bl);
        this.onFillEntityFullInfo_UtilPSDE11(pSSysUtilDE, bl);
        this.onFillEntityFullInfo_UtilPSDE12(pSSysUtilDE, bl);
        this.onFillEntityFullInfo_UtilPSDE13(pSSysUtilDE, bl);
        this.onFillEntityFullInfo_UtilPSDE14(pSSysUtilDE, bl);
        this.onFillEntityFullInfo_UtilPSDE15(pSSysUtilDE, bl);
        this.onFillEntityFullInfo_UtilPSDE16(pSSysUtilDE, bl);
        this.onFillEntityFullInfo_UtilPSDE17(pSSysUtilDE, bl);
        this.onFillEntityFullInfo_UtilPSDE18(pSSysUtilDE, bl);
        this.onFillEntityFullInfo_UtilPSDE19(pSSysUtilDE, bl);
        this.onFillEntityFullInfo_UtilPSDE20(pSSysUtilDE, bl);
        this.onFillEntityFullInfo_UtilPSDE2(pSSysUtilDE, bl);
        this.onFillEntityFullInfo_UtilPSDE3(pSSysUtilDE, bl);
        this.onFillEntityFullInfo_UtilPSDE4(pSSysUtilDE, bl);
        this.onFillEntityFullInfo_UtilPSDE5(pSSysUtilDE, bl);
        this.onFillEntityFullInfo_UtilPSDE6(pSSysUtilDE, bl);
        this.onFillEntityFullInfo_UtilPSDE7(pSSysUtilDE, bl);
        this.onFillEntityFullInfo_UtilPSDE8(pSSysUtilDE, bl);
        this.onFillEntityFullInfo_UtilPSDE9(pSSysUtilDE, bl);
        this.onFillEntityFullInfo_UtilPSDE(pSSysUtilDE, bl);
        this.onFillEntityFullInfo_PSDEGroup(pSSysUtilDE, bl);
        this.onFillEntityFullInfo_PSDERGroup(pSSysUtilDE, bl);
        this.onFillEntityFullInfo_PSModule(pSSysUtilDE, bl);
        this.onFillEntityFullInfo_PSSubSysServiceAPI(pSSysUtilDE, bl);
        this.onFillEntityFullInfo_InPSSysDataSyncAgent(pSSysUtilDE, bl);
        this.onFillEntityFullInfo_OutPSSysDataSyncAgent(pSSysUtilDE, bl);
        this.onFillEntityFullInfo_PSSysDynaModel(pSSysUtilDE, bl);
        this.onFillEntityFullInfo_PSSysModelGroup(pSSysUtilDE, bl);
        this.onFillEntityFullInfo_OutPSSysResource(pSSysUtilDE, bl);
        this.onFillEntityFullInfo_PSSysResource(pSSysUtilDE, bl);
        this.onFillEntityFullInfo_PSSysSFPlugin(pSSysUtilDE, bl);
        this.onFillEntityFullInfo_PSSystem(pSSysUtilDE, bl);
    }

    protected void onFillEntityFullInfo_UtilPSDE10(PSSysUtilDE pSSysUtilDE, boolean bl) throws Exception {
        if (pSSysUtilDE.isUtilPSDE10IdDirty()) {
            if (pSSysUtilDE.getUtilPSDE10Id() != null) {
                if (pSSysUtilDE.getUtilPSDE10Id() == null || pSSysUtilDE.getUtilPSDE10Name() == null) {
                    PSDataEntity pSDataEntity = pSSysUtilDE.getUtilPSDE10();
                    pSSysUtilDE.setUtilPSDE10Name(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSSysUtilDE.setUtilPSDE10Name(null);
            }
        }
    }

    protected void onFillEntityFullInfo_UtilPSDE11(PSSysUtilDE pSSysUtilDE, boolean bl) throws Exception {
        if (pSSysUtilDE.isUtilPSDE11IdDirty()) {
            if (pSSysUtilDE.getUtilPSDE11Id() != null) {
                if (pSSysUtilDE.getUtilPSDE11Id() == null || pSSysUtilDE.getUtilPSDE11Name() == null) {
                    PSDataEntity pSDataEntity = pSSysUtilDE.getUtilPSDE11();
                    pSSysUtilDE.setUtilPSDE11Name(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSSysUtilDE.setUtilPSDE11Name(null);
            }
        }
    }

    protected void onFillEntityFullInfo_UtilPSDE12(PSSysUtilDE pSSysUtilDE, boolean bl) throws Exception {
        if (pSSysUtilDE.isUtilPSDE12IdDirty()) {
            if (pSSysUtilDE.getUtilPSDE12Id() != null) {
                if (pSSysUtilDE.getUtilPSDE12Id() == null || pSSysUtilDE.getUtilPSDE12Name() == null) {
                    PSDataEntity pSDataEntity = pSSysUtilDE.getUtilPSDE12();
                    pSSysUtilDE.setUtilPSDE12Name(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSSysUtilDE.setUtilPSDE12Name(null);
            }
        }
    }

    protected void onFillEntityFullInfo_UtilPSDE13(PSSysUtilDE pSSysUtilDE, boolean bl) throws Exception {
        if (pSSysUtilDE.isUtilPSDE13IdDirty()) {
            if (pSSysUtilDE.getUtilPSDE13Id() != null) {
                if (pSSysUtilDE.getUtilPSDE13Id() == null || pSSysUtilDE.getUtilPSDE13Name() == null) {
                    PSDataEntity pSDataEntity = pSSysUtilDE.getUtilPSDE13();
                    pSSysUtilDE.setUtilPSDE13Name(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSSysUtilDE.setUtilPSDE13Name(null);
            }
        }
    }

    protected void onFillEntityFullInfo_UtilPSDE14(PSSysUtilDE pSSysUtilDE, boolean bl) throws Exception {
        if (pSSysUtilDE.isUtilPSDE14IdDirty()) {
            if (pSSysUtilDE.getUtilPSDE14Id() != null) {
                if (pSSysUtilDE.getUtilPSDE14Id() == null || pSSysUtilDE.getUtilPSDE14Name() == null) {
                    PSDataEntity pSDataEntity = pSSysUtilDE.getUtilPSDE14();
                    pSSysUtilDE.setUtilPSDE14Name(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSSysUtilDE.setUtilPSDE14Name(null);
            }
        }
    }

    protected void onFillEntityFullInfo_UtilPSDE15(PSSysUtilDE pSSysUtilDE, boolean bl) throws Exception {
        if (pSSysUtilDE.isUtilPSDE15IdDirty()) {
            if (pSSysUtilDE.getUtilPSDE15Id() != null) {
                if (pSSysUtilDE.getUtilPSDE15Id() == null || pSSysUtilDE.getUtilPSDE15Name() == null) {
                    PSDataEntity pSDataEntity = pSSysUtilDE.getUtilPSDE15();
                    pSSysUtilDE.setUtilPSDE15Name(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSSysUtilDE.setUtilPSDE15Name(null);
            }
        }
    }

    protected void onFillEntityFullInfo_UtilPSDE16(PSSysUtilDE pSSysUtilDE, boolean bl) throws Exception {
        if (pSSysUtilDE.isUtilPSDE16IdDirty()) {
            if (pSSysUtilDE.getUtilPSDE16Id() != null) {
                if (pSSysUtilDE.getUtilPSDE16Id() == null || pSSysUtilDE.getUtilPSDE16Name() == null) {
                    PSDataEntity pSDataEntity = pSSysUtilDE.getUtilPSDE16();
                    pSSysUtilDE.setUtilPSDE16Name(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSSysUtilDE.setUtilPSDE16Name(null);
            }
        }
    }

    protected void onFillEntityFullInfo_UtilPSDE17(PSSysUtilDE pSSysUtilDE, boolean bl) throws Exception {
        if (pSSysUtilDE.isUtilPSDE17IdDirty()) {
            if (pSSysUtilDE.getUtilPSDE17Id() != null) {
                if (pSSysUtilDE.getUtilPSDE17Id() == null || pSSysUtilDE.getUtilPSDE17Name() == null) {
                    PSDataEntity pSDataEntity = pSSysUtilDE.getUtilPSDE17();
                    pSSysUtilDE.setUtilPSDE17Name(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSSysUtilDE.setUtilPSDE17Name(null);
            }
        }
    }

    protected void onFillEntityFullInfo_UtilPSDE18(PSSysUtilDE pSSysUtilDE, boolean bl) throws Exception {
        if (pSSysUtilDE.isUtilPSDE18IdDirty()) {
            if (pSSysUtilDE.getUtilPSDE18Id() != null) {
                if (pSSysUtilDE.getUtilPSDE18Id() == null || pSSysUtilDE.getUtilPSDE18Name() == null) {
                    PSDataEntity pSDataEntity = pSSysUtilDE.getUtilPSDE18();
                    pSSysUtilDE.setUtilPSDE18Name(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSSysUtilDE.setUtilPSDE18Name(null);
            }
        }
    }

    protected void onFillEntityFullInfo_UtilPSDE19(PSSysUtilDE pSSysUtilDE, boolean bl) throws Exception {
        if (pSSysUtilDE.isUtilPSDE19IdDirty()) {
            if (pSSysUtilDE.getUtilPSDE19Id() != null) {
                if (pSSysUtilDE.getUtilPSDE19Id() == null || pSSysUtilDE.getUtilPSDE19Name() == null) {
                    PSDataEntity pSDataEntity = pSSysUtilDE.getUtilPSDE19();
                    pSSysUtilDE.setUtilPSDE19Name(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSSysUtilDE.setUtilPSDE19Name(null);
            }
        }
    }

    protected void onFillEntityFullInfo_UtilPSDE20(PSSysUtilDE pSSysUtilDE, boolean bl) throws Exception {
        if (pSSysUtilDE.isUtilPSDE20IdDirty()) {
            if (pSSysUtilDE.getUtilPSDE20Id() != null) {
                if (pSSysUtilDE.getUtilPSDE20Id() == null || pSSysUtilDE.getUtilPSDE20Name() == null) {
                    PSDataEntity pSDataEntity = pSSysUtilDE.getUtilPSDE20();
                    pSSysUtilDE.setUtilPSDE20Name(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSSysUtilDE.setUtilPSDE20Name(null);
            }
        }
    }

    protected void onFillEntityFullInfo_UtilPSDE2(PSSysUtilDE pSSysUtilDE, boolean bl) throws Exception {
        if (pSSysUtilDE.isUtilPSDE2IdDirty()) {
            if (pSSysUtilDE.getUtilPSDE2Id() != null) {
                if (pSSysUtilDE.getUtilPSDE2Id() == null || pSSysUtilDE.getUtilPSDE2Name() == null) {
                    PSDataEntity pSDataEntity = pSSysUtilDE.getUtilPSDE2();
                    pSSysUtilDE.setUtilPSDE2Name(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSSysUtilDE.setUtilPSDE2Name(null);
            }
        }
    }

    protected void onFillEntityFullInfo_UtilPSDE3(PSSysUtilDE pSSysUtilDE, boolean bl) throws Exception {
        if (pSSysUtilDE.isUtilPSDE3IdDirty()) {
            if (pSSysUtilDE.getUtilPSDE3Id() != null) {
                if (pSSysUtilDE.getUtilPSDE3Id() == null || pSSysUtilDE.getUtilPSDE3Name() == null) {
                    PSDataEntity pSDataEntity = pSSysUtilDE.getUtilPSDE3();
                    pSSysUtilDE.setUtilPSDE3Name(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSSysUtilDE.setUtilPSDE3Name(null);
            }
        }
    }

    protected void onFillEntityFullInfo_UtilPSDE4(PSSysUtilDE pSSysUtilDE, boolean bl) throws Exception {
        if (pSSysUtilDE.isUtilPSDE4IdDirty()) {
            if (pSSysUtilDE.getUtilPSDE4Id() != null) {
                if (pSSysUtilDE.getUtilPSDE4Id() == null || pSSysUtilDE.getUtilPSDE4Name() == null) {
                    PSDataEntity pSDataEntity = pSSysUtilDE.getUtilPSDE4();
                    pSSysUtilDE.setUtilPSDE4Name(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSSysUtilDE.setUtilPSDE4Name(null);
            }
        }
    }

    protected void onFillEntityFullInfo_UtilPSDE5(PSSysUtilDE pSSysUtilDE, boolean bl) throws Exception {
        if (pSSysUtilDE.isUtilPSDE5IdDirty()) {
            if (pSSysUtilDE.getUtilPSDE5Id() != null) {
                if (pSSysUtilDE.getUtilPSDE5Id() == null || pSSysUtilDE.getUtilPSDE5Name() == null) {
                    PSDataEntity pSDataEntity = pSSysUtilDE.getUtilPSDE5();
                    pSSysUtilDE.setUtilPSDE5Name(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSSysUtilDE.setUtilPSDE5Name(null);
            }
        }
    }

    protected void onFillEntityFullInfo_UtilPSDE6(PSSysUtilDE pSSysUtilDE, boolean bl) throws Exception {
        if (pSSysUtilDE.isUtilPSDE6IdDirty()) {
            if (pSSysUtilDE.getUtilPSDE6Id() != null) {
                if (pSSysUtilDE.getUtilPSDE6Id() == null || pSSysUtilDE.getUtilPSDE6Name() == null) {
                    PSDataEntity pSDataEntity = pSSysUtilDE.getUtilPSDE6();
                    pSSysUtilDE.setUtilPSDE6Name(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSSysUtilDE.setUtilPSDE6Name(null);
            }
        }
    }

    protected void onFillEntityFullInfo_UtilPSDE7(PSSysUtilDE pSSysUtilDE, boolean bl) throws Exception {
        if (pSSysUtilDE.isUtilPSDE7IdDirty()) {
            if (pSSysUtilDE.getUtilPSDE7Id() != null) {
                if (pSSysUtilDE.getUtilPSDE7Id() == null || pSSysUtilDE.getUtilPSDE7Name() == null) {
                    PSDataEntity pSDataEntity = pSSysUtilDE.getUtilPSDE7();
                    pSSysUtilDE.setUtilPSDE7Name(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSSysUtilDE.setUtilPSDE7Name(null);
            }
        }
    }

    protected void onFillEntityFullInfo_UtilPSDE8(PSSysUtilDE pSSysUtilDE, boolean bl) throws Exception {
        if (pSSysUtilDE.isUtilPSDE8IdDirty()) {
            if (pSSysUtilDE.getUtilPSDE8Id() != null) {
                if (pSSysUtilDE.getUtilPSDE8Id() == null || pSSysUtilDE.getUtilPSDE8Name() == null) {
                    PSDataEntity pSDataEntity = pSSysUtilDE.getUtilPSDE8();
                    pSSysUtilDE.setUtilPSDE8Name(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSSysUtilDE.setUtilPSDE8Name(null);
            }
        }
    }

    protected void onFillEntityFullInfo_UtilPSDE9(PSSysUtilDE pSSysUtilDE, boolean bl) throws Exception {
        if (pSSysUtilDE.isUtilPSDE9IdDirty()) {
            if (pSSysUtilDE.getUtilPSDE9Id() != null) {
                if (pSSysUtilDE.getUtilPSDE9Id() == null || pSSysUtilDE.getUtilPSDE9Name() == null) {
                    PSDataEntity pSDataEntity = pSSysUtilDE.getUtilPSDE9();
                    pSSysUtilDE.setUtilPSDE9Name(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSSysUtilDE.setUtilPSDE9Name(null);
            }
        }
    }

    protected void onFillEntityFullInfo_UtilPSDE(PSSysUtilDE pSSysUtilDE, boolean bl) throws Exception {
        if (pSSysUtilDE.isUtilPSDEIdDirty()) {
            if (pSSysUtilDE.getUtilPSDEId() != null) {
                if (pSSysUtilDE.getUtilPSDEId() == null || pSSysUtilDE.getUtilPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSSysUtilDE.getUtilPSDE();
                    pSSysUtilDE.setUtilPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSSysUtilDE.setUtilPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDEGroup(PSSysUtilDE pSSysUtilDE, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDERGroup(PSSysUtilDE pSSysUtilDE, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSModule(PSSysUtilDE pSSysUtilDE, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSubSysServiceAPI(PSSysUtilDE pSSysUtilDE, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_InPSSysDataSyncAgent(PSSysUtilDE pSSysUtilDE, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_OutPSSysDataSyncAgent(PSSysUtilDE pSSysUtilDE, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysDynaModel(PSSysUtilDE pSSysUtilDE, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysModelGroup(PSSysUtilDE pSSysUtilDE, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_OutPSSysResource(PSSysUtilDE pSSysUtilDE, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysResource(PSSysUtilDE pSSysUtilDE, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysSFPlugin(PSSysUtilDE pSSysUtilDE, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSystem(PSSysUtilDE pSSysUtilDE, boolean bl) throws Exception {
        if (pSSysUtilDE.isPSSystemIdDirty()) {
            if (pSSysUtilDE.getPSSystemId() != null) {
                if (pSSysUtilDE.getPSSystemId() == null || pSSysUtilDE.getPSSystemName() == null) {
                    PSSystem pSSystem = pSSysUtilDE.getPSSystem();
                    pSSysUtilDE.setPSSystemName(pSSystem.getPSSystemName());
                }
            } else {
                pSSysUtilDE.setPSSystemName(null);
            }
        }
    }

    protected void onWriteBackParent(PSSysUtilDE pSSysUtilDE, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSSysUtilDE, bl);
    }

    public ArrayList<PSSysUtilDE> selectByUtilPSDE10(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByUtilPSDE10(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSSysUtilDE> selectByUtilPSDE10(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByUtilPSDE10(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSSysUtilDE> selectByUtilPSDE10(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("UTILPSDE10ID", (Object)pSDataEntityBase.getPSDataEntityId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByUtilPSDE10Cond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByUtilPSDE10Cond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysUtilDE> selectByUtilPSDE11(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByUtilPSDE11(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSSysUtilDE> selectByUtilPSDE11(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByUtilPSDE11(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSSysUtilDE> selectByUtilPSDE11(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("UTILPSDE11ID", (Object)pSDataEntityBase.getPSDataEntityId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByUtilPSDE11Cond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByUtilPSDE11Cond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysUtilDE> selectByUtilPSDE12(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByUtilPSDE12(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSSysUtilDE> selectByUtilPSDE12(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByUtilPSDE12(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSSysUtilDE> selectByUtilPSDE12(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("UTILPSDE12ID", (Object)pSDataEntityBase.getPSDataEntityId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByUtilPSDE12Cond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByUtilPSDE12Cond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysUtilDE> selectByUtilPSDE13(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByUtilPSDE13(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSSysUtilDE> selectByUtilPSDE13(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByUtilPSDE13(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSSysUtilDE> selectByUtilPSDE13(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("UTILPSDE13ID", (Object)pSDataEntityBase.getPSDataEntityId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByUtilPSDE13Cond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByUtilPSDE13Cond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysUtilDE> selectByUtilPSDE14(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByUtilPSDE14(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSSysUtilDE> selectByUtilPSDE14(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByUtilPSDE14(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSSysUtilDE> selectByUtilPSDE14(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("UTILPSDE14ID", (Object)pSDataEntityBase.getPSDataEntityId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByUtilPSDE14Cond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByUtilPSDE14Cond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysUtilDE> selectByUtilPSDE15(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByUtilPSDE15(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSSysUtilDE> selectByUtilPSDE15(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByUtilPSDE15(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSSysUtilDE> selectByUtilPSDE15(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("UTILPSDE15ID", (Object)pSDataEntityBase.getPSDataEntityId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByUtilPSDE15Cond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByUtilPSDE15Cond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysUtilDE> selectByUtilPSDE16(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByUtilPSDE16(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSSysUtilDE> selectByUtilPSDE16(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByUtilPSDE16(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSSysUtilDE> selectByUtilPSDE16(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("UTILPSDE16ID", (Object)pSDataEntityBase.getPSDataEntityId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByUtilPSDE16Cond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByUtilPSDE16Cond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysUtilDE> selectByUtilPSDE17(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByUtilPSDE17(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSSysUtilDE> selectByUtilPSDE17(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByUtilPSDE17(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSSysUtilDE> selectByUtilPSDE17(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("UTILPSDE17ID", (Object)pSDataEntityBase.getPSDataEntityId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByUtilPSDE17Cond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByUtilPSDE17Cond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysUtilDE> selectByUtilPSDE18(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByUtilPSDE18(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSSysUtilDE> selectByUtilPSDE18(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByUtilPSDE18(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSSysUtilDE> selectByUtilPSDE18(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("UTILPSDE18ID", (Object)pSDataEntityBase.getPSDataEntityId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByUtilPSDE18Cond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByUtilPSDE18Cond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysUtilDE> selectByUtilPSDE19(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByUtilPSDE19(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSSysUtilDE> selectByUtilPSDE19(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByUtilPSDE19(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSSysUtilDE> selectByUtilPSDE19(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("UTILPSDE19ID", (Object)pSDataEntityBase.getPSDataEntityId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByUtilPSDE19Cond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByUtilPSDE19Cond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysUtilDE> selectByUtilPSDE20(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByUtilPSDE20(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSSysUtilDE> selectByUtilPSDE20(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByUtilPSDE20(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSSysUtilDE> selectByUtilPSDE20(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("UTILPSDE20ID", (Object)pSDataEntityBase.getPSDataEntityId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByUtilPSDE20Cond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByUtilPSDE20Cond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysUtilDE> selectByUtilPSDE2(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByUtilPSDE2(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSSysUtilDE> selectByUtilPSDE2(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByUtilPSDE2(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSSysUtilDE> selectByUtilPSDE2(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("UTILPSDE2ID", (Object)pSDataEntityBase.getPSDataEntityId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByUtilPSDE2Cond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByUtilPSDE2Cond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysUtilDE> selectByUtilPSDE3(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByUtilPSDE3(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSSysUtilDE> selectByUtilPSDE3(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByUtilPSDE3(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSSysUtilDE> selectByUtilPSDE3(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("UTILPSDE3ID", (Object)pSDataEntityBase.getPSDataEntityId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByUtilPSDE3Cond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByUtilPSDE3Cond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysUtilDE> selectByUtilPSDE4(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByUtilPSDE4(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSSysUtilDE> selectByUtilPSDE4(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByUtilPSDE4(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSSysUtilDE> selectByUtilPSDE4(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("UTILPSDE4ID", (Object)pSDataEntityBase.getPSDataEntityId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByUtilPSDE4Cond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByUtilPSDE4Cond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysUtilDE> selectByUtilPSDE5(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByUtilPSDE5(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSSysUtilDE> selectByUtilPSDE5(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByUtilPSDE5(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSSysUtilDE> selectByUtilPSDE5(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("UTILPSDE5ID", (Object)pSDataEntityBase.getPSDataEntityId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByUtilPSDE5Cond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByUtilPSDE5Cond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysUtilDE> selectByUtilPSDE6(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByUtilPSDE6(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSSysUtilDE> selectByUtilPSDE6(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByUtilPSDE6(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSSysUtilDE> selectByUtilPSDE6(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("UTILPSDE6ID", (Object)pSDataEntityBase.getPSDataEntityId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByUtilPSDE6Cond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByUtilPSDE6Cond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysUtilDE> selectByUtilPSDE7(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByUtilPSDE7(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSSysUtilDE> selectByUtilPSDE7(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByUtilPSDE7(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSSysUtilDE> selectByUtilPSDE7(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("UTILPSDE7ID", (Object)pSDataEntityBase.getPSDataEntityId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByUtilPSDE7Cond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByUtilPSDE7Cond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysUtilDE> selectByUtilPSDE8(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByUtilPSDE8(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSSysUtilDE> selectByUtilPSDE8(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByUtilPSDE8(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSSysUtilDE> selectByUtilPSDE8(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("UTILPSDE8ID", (Object)pSDataEntityBase.getPSDataEntityId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByUtilPSDE8Cond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByUtilPSDE8Cond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysUtilDE> selectByUtilPSDE9(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByUtilPSDE9(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSSysUtilDE> selectByUtilPSDE9(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByUtilPSDE9(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSSysUtilDE> selectByUtilPSDE9(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("UTILPSDE9ID", (Object)pSDataEntityBase.getPSDataEntityId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByUtilPSDE9Cond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByUtilPSDE9Cond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysUtilDE> selectByUtilPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByUtilPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSSysUtilDE> selectByUtilPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByUtilPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSSysUtilDE> selectByUtilPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("UTILPSDEID", (Object)pSDataEntityBase.getPSDataEntityId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByUtilPSDECond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByUtilPSDECond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysUtilDE> selectByPSDEGroup(PSDEGroupBase pSDEGroupBase) throws Exception {
        return this.selectByPSDEGroup(pSDEGroupBase, "", -1);
    }

    public ArrayList<PSSysUtilDE> selectByPSDEGroup(PSDEGroupBase pSDEGroupBase, String string) throws Exception {
        return this.selectByPSDEGroup(pSDEGroupBase, string, -1);
    }

    public ArrayList<PSSysUtilDE> selectByPSDEGroup(PSDEGroupBase pSDEGroupBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEGROUPID", (Object)pSDEGroupBase.getPSDEGroupId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEGroupCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEGroupCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysUtilDE> selectByPSDERGroup(PSDERGroupBase pSDERGroupBase) throws Exception {
        return this.selectByPSDERGroup(pSDERGroupBase, "", -1);
    }

    public ArrayList<PSSysUtilDE> selectByPSDERGroup(PSDERGroupBase pSDERGroupBase, String string) throws Exception {
        return this.selectByPSDERGroup(pSDERGroupBase, string, -1);
    }

    public ArrayList<PSSysUtilDE> selectByPSDERGroup(PSDERGroupBase pSDERGroupBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDERGROUPID", (Object)pSDERGroupBase.getPSDERGroupId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDERGroupCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDERGroupCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysUtilDE> selectByPSModule(PSModuleBase pSModuleBase) throws Exception {
        return this.selectByPSModule(pSModuleBase, "", -1);
    }

    public ArrayList<PSSysUtilDE> selectByPSModule(PSModuleBase pSModuleBase, String string) throws Exception {
        return this.selectByPSModule(pSModuleBase, string, -1);
    }

    public ArrayList<PSSysUtilDE> selectByPSModule(PSModuleBase pSModuleBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSMODULEID", (Object)pSModuleBase.getPSModuleId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSModuleCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSModuleCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysUtilDE> selectByPSSubSysServiceAPI(PSSubSysServiceAPIBase pSSubSysServiceAPIBase) throws Exception {
        return this.selectByPSSubSysServiceAPI(pSSubSysServiceAPIBase, "", -1);
    }

    public ArrayList<PSSysUtilDE> selectByPSSubSysServiceAPI(PSSubSysServiceAPIBase pSSubSysServiceAPIBase, String string) throws Exception {
        return this.selectByPSSubSysServiceAPI(pSSubSysServiceAPIBase, string, -1);
    }

    public ArrayList<PSSysUtilDE> selectByPSSubSysServiceAPI(PSSubSysServiceAPIBase pSSubSysServiceAPIBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSUBSYSSERVICEAPIID", (Object)pSSubSysServiceAPIBase.getPSSubSysServiceAPIId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSubSysServiceAPICond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSubSysServiceAPICond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysUtilDE> selectByInPSSysDataSyncAgent(PSSysDataSyncAgentBase pSSysDataSyncAgentBase) throws Exception {
        return this.selectByInPSSysDataSyncAgent(pSSysDataSyncAgentBase, "", -1);
    }

    public ArrayList<PSSysUtilDE> selectByInPSSysDataSyncAgent(PSSysDataSyncAgentBase pSSysDataSyncAgentBase, String string) throws Exception {
        return this.selectByInPSSysDataSyncAgent(pSSysDataSyncAgentBase, string, -1);
    }

    public ArrayList<PSSysUtilDE> selectByInPSSysDataSyncAgent(PSSysDataSyncAgentBase pSSysDataSyncAgentBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("INPSSYSDATASYNCAGENTID", (Object)pSSysDataSyncAgentBase.getPSSysDataSyncAgentId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByInPSSysDataSyncAgentCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByInPSSysDataSyncAgentCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysUtilDE> selectByOutPSSysDataSyncAgent(PSSysDataSyncAgentBase pSSysDataSyncAgentBase) throws Exception {
        return this.selectByOutPSSysDataSyncAgent(pSSysDataSyncAgentBase, "", -1);
    }

    public ArrayList<PSSysUtilDE> selectByOutPSSysDataSyncAgent(PSSysDataSyncAgentBase pSSysDataSyncAgentBase, String string) throws Exception {
        return this.selectByOutPSSysDataSyncAgent(pSSysDataSyncAgentBase, string, -1);
    }

    public ArrayList<PSSysUtilDE> selectByOutPSSysDataSyncAgent(PSSysDataSyncAgentBase pSSysDataSyncAgentBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("OUTPSSYSDATASYNCAGENTID", (Object)pSSysDataSyncAgentBase.getPSSysDataSyncAgentId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByOutPSSysDataSyncAgentCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByOutPSSysDataSyncAgentCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysUtilDE> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, "", -1);
    }

    public ArrayList<PSSysUtilDE> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, string, -1);
    }

    public ArrayList<PSSysUtilDE> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysUtilDE> selectByPSSysModelGroup(PSSysModelGroupBase pSSysModelGroupBase) throws Exception {
        return this.selectByPSSysModelGroup(pSSysModelGroupBase, "", -1);
    }

    public ArrayList<PSSysUtilDE> selectByPSSysModelGroup(PSSysModelGroupBase pSSysModelGroupBase, String string) throws Exception {
        return this.selectByPSSysModelGroup(pSSysModelGroupBase, string, -1);
    }

    public ArrayList<PSSysUtilDE> selectByPSSysModelGroup(PSSysModelGroupBase pSSysModelGroupBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSMODELGROUPID", (Object)pSSysModelGroupBase.getPSSysModelGroupId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysModelGroupCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysModelGroupCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysUtilDE> selectByOutPSSysResource(PSSysResourceBase pSSysResourceBase) throws Exception {
        return this.selectByOutPSSysResource(pSSysResourceBase, "", -1);
    }

    public ArrayList<PSSysUtilDE> selectByOutPSSysResource(PSSysResourceBase pSSysResourceBase, String string) throws Exception {
        return this.selectByOutPSSysResource(pSSysResourceBase, string, -1);
    }

    public ArrayList<PSSysUtilDE> selectByOutPSSysResource(PSSysResourceBase pSSysResourceBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("OUTPSSYSRESOURCEID", (Object)pSSysResourceBase.getPSSysResourceId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByOutPSSysResourceCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByOutPSSysResourceCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysUtilDE> selectByPSSysResource(PSSysResourceBase pSSysResourceBase) throws Exception {
        return this.selectByPSSysResource(pSSysResourceBase, "", -1);
    }

    public ArrayList<PSSysUtilDE> selectByPSSysResource(PSSysResourceBase pSSysResourceBase, String string) throws Exception {
        return this.selectByPSSysResource(pSSysResourceBase, string, -1);
    }

    public ArrayList<PSSysUtilDE> selectByPSSysResource(PSSysResourceBase pSSysResourceBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSRESOURCEID", (Object)pSSysResourceBase.getPSSysResourceId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysResourceCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysResourceCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysUtilDE> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, "", -1);
    }

    public ArrayList<PSSysUtilDE> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, string, -1);
    }

    public ArrayList<PSSysUtilDE> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysUtilDE> selectByPSSystem(PSSystemBase pSSystemBase) throws Exception {
        return this.selectByPSSystem(pSSystemBase, "", -1);
    }

    public ArrayList<PSSysUtilDE> selectByPSSystem(PSSystemBase pSSystemBase, String string) throws Exception {
        return this.selectByPSSystem(pSSystemBase, string, -1);
    }

    public ArrayList<PSSysUtilDE> selectByPSSystem(PSSystemBase pSSystemBase, String string, int n) throws Exception {
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

    public void testRemoveByUtilPSDE10(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByUtilPSDE10(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSUTILDE_PSDATAENTITY_UTILPSDE10ID", "", iDataEntityModel.getName(), "PSSYSUTILDE", iDataEntityModel.getDataInfo((IEntity)pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetUtilPSDE10(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByUtilPSDE10(pSDataEntity);
        for (PSSysUtilDE pSSysUtilDE : arrayList) {
            PSSysUtilDE pSSysUtilDE2 = (PSSysUtilDE)this.getDEModel().createEntity();
            pSSysUtilDE2.setPSSysUtilDEId(pSSysUtilDE.getPSSysUtilDEId());
            pSSysUtilDE2.setUtilPSDE10Id(null);
            this.update(pSSysUtilDE2);
        }
    }

    public void removeByUtilPSDE10(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysUtilDEServiceBase.this.onBeforeRemoveByUtilPSDE10(pSDataEntity2);
                PSSysUtilDEServiceBase.this.internalRemoveByUtilPSDE10(pSDataEntity2);
                PSSysUtilDEServiceBase.this.onAfterRemoveByUtilPSDE10(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByUtilPSDE10(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByUtilPSDE10(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByUtilPSDE10(pSDataEntity);
        this.onBeforeRemoveByUtilPSDE10(pSDataEntity, arrayList);
        for (PSSysUtilDE pSSysUtilDE : arrayList) {
            this.remove((IEntity)pSSysUtilDE);
        }
        this.onAfterRemoveByUtilPSDE10(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByUtilPSDE10(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByUtilPSDE10(PSDataEntity pSDataEntity, ArrayList<PSSysUtilDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUtilPSDE10(PSDataEntity pSDataEntity, ArrayList<PSSysUtilDE> arrayList) throws Exception {
    }

    public void testRemoveByUtilPSDE11(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByUtilPSDE11(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSUTILDE_PSDATAENTITY_UTILPSDE11ID", "", iDataEntityModel.getName(), "PSSYSUTILDE", iDataEntityModel.getDataInfo((IEntity)pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetUtilPSDE11(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByUtilPSDE11(pSDataEntity);
        for (PSSysUtilDE pSSysUtilDE : arrayList) {
            PSSysUtilDE pSSysUtilDE2 = (PSSysUtilDE)this.getDEModel().createEntity();
            pSSysUtilDE2.setPSSysUtilDEId(pSSysUtilDE.getPSSysUtilDEId());
            pSSysUtilDE2.setUtilPSDE11Id(null);
            this.update(pSSysUtilDE2);
        }
    }

    public void removeByUtilPSDE11(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysUtilDEServiceBase.this.onBeforeRemoveByUtilPSDE11(pSDataEntity2);
                PSSysUtilDEServiceBase.this.internalRemoveByUtilPSDE11(pSDataEntity2);
                PSSysUtilDEServiceBase.this.onAfterRemoveByUtilPSDE11(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByUtilPSDE11(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByUtilPSDE11(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByUtilPSDE11(pSDataEntity);
        this.onBeforeRemoveByUtilPSDE11(pSDataEntity, arrayList);
        for (PSSysUtilDE pSSysUtilDE : arrayList) {
            this.remove((IEntity)pSSysUtilDE);
        }
        this.onAfterRemoveByUtilPSDE11(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByUtilPSDE11(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByUtilPSDE11(PSDataEntity pSDataEntity, ArrayList<PSSysUtilDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUtilPSDE11(PSDataEntity pSDataEntity, ArrayList<PSSysUtilDE> arrayList) throws Exception {
    }

    public void testRemoveByUtilPSDE12(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByUtilPSDE12(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSUTILDE_PSDATAENTITY_UTILPSDE12ID", "", iDataEntityModel.getName(), "PSSYSUTILDE", iDataEntityModel.getDataInfo((IEntity)pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetUtilPSDE12(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByUtilPSDE12(pSDataEntity);
        for (PSSysUtilDE pSSysUtilDE : arrayList) {
            PSSysUtilDE pSSysUtilDE2 = (PSSysUtilDE)this.getDEModel().createEntity();
            pSSysUtilDE2.setPSSysUtilDEId(pSSysUtilDE.getPSSysUtilDEId());
            pSSysUtilDE2.setUtilPSDE12Id(null);
            this.update(pSSysUtilDE2);
        }
    }

    public void removeByUtilPSDE12(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysUtilDEServiceBase.this.onBeforeRemoveByUtilPSDE12(pSDataEntity2);
                PSSysUtilDEServiceBase.this.internalRemoveByUtilPSDE12(pSDataEntity2);
                PSSysUtilDEServiceBase.this.onAfterRemoveByUtilPSDE12(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByUtilPSDE12(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByUtilPSDE12(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByUtilPSDE12(pSDataEntity);
        this.onBeforeRemoveByUtilPSDE12(pSDataEntity, arrayList);
        for (PSSysUtilDE pSSysUtilDE : arrayList) {
            this.remove((IEntity)pSSysUtilDE);
        }
        this.onAfterRemoveByUtilPSDE12(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByUtilPSDE12(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByUtilPSDE12(PSDataEntity pSDataEntity, ArrayList<PSSysUtilDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUtilPSDE12(PSDataEntity pSDataEntity, ArrayList<PSSysUtilDE> arrayList) throws Exception {
    }

    public void testRemoveByUtilPSDE13(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByUtilPSDE13(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSUTILDE_PSDATAENTITY_UTILPSDE13ID", "", iDataEntityModel.getName(), "PSSYSUTILDE", iDataEntityModel.getDataInfo((IEntity)pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetUtilPSDE13(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByUtilPSDE13(pSDataEntity);
        for (PSSysUtilDE pSSysUtilDE : arrayList) {
            PSSysUtilDE pSSysUtilDE2 = (PSSysUtilDE)this.getDEModel().createEntity();
            pSSysUtilDE2.setPSSysUtilDEId(pSSysUtilDE.getPSSysUtilDEId());
            pSSysUtilDE2.setUtilPSDE13Id(null);
            this.update(pSSysUtilDE2);
        }
    }

    public void removeByUtilPSDE13(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysUtilDEServiceBase.this.onBeforeRemoveByUtilPSDE13(pSDataEntity2);
                PSSysUtilDEServiceBase.this.internalRemoveByUtilPSDE13(pSDataEntity2);
                PSSysUtilDEServiceBase.this.onAfterRemoveByUtilPSDE13(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByUtilPSDE13(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByUtilPSDE13(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByUtilPSDE13(pSDataEntity);
        this.onBeforeRemoveByUtilPSDE13(pSDataEntity, arrayList);
        for (PSSysUtilDE pSSysUtilDE : arrayList) {
            this.remove((IEntity)pSSysUtilDE);
        }
        this.onAfterRemoveByUtilPSDE13(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByUtilPSDE13(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByUtilPSDE13(PSDataEntity pSDataEntity, ArrayList<PSSysUtilDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUtilPSDE13(PSDataEntity pSDataEntity, ArrayList<PSSysUtilDE> arrayList) throws Exception {
    }

    public void testRemoveByUtilPSDE14(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByUtilPSDE14(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSUTILDE_PSDATAENTITY_UTILPSDE14ID", "", iDataEntityModel.getName(), "PSSYSUTILDE", iDataEntityModel.getDataInfo((IEntity)pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetUtilPSDE14(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByUtilPSDE14(pSDataEntity);
        for (PSSysUtilDE pSSysUtilDE : arrayList) {
            PSSysUtilDE pSSysUtilDE2 = (PSSysUtilDE)this.getDEModel().createEntity();
            pSSysUtilDE2.setPSSysUtilDEId(pSSysUtilDE.getPSSysUtilDEId());
            pSSysUtilDE2.setUtilPSDE14Id(null);
            this.update(pSSysUtilDE2);
        }
    }

    public void removeByUtilPSDE14(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysUtilDEServiceBase.this.onBeforeRemoveByUtilPSDE14(pSDataEntity2);
                PSSysUtilDEServiceBase.this.internalRemoveByUtilPSDE14(pSDataEntity2);
                PSSysUtilDEServiceBase.this.onAfterRemoveByUtilPSDE14(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByUtilPSDE14(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByUtilPSDE14(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByUtilPSDE14(pSDataEntity);
        this.onBeforeRemoveByUtilPSDE14(pSDataEntity, arrayList);
        for (PSSysUtilDE pSSysUtilDE : arrayList) {
            this.remove((IEntity)pSSysUtilDE);
        }
        this.onAfterRemoveByUtilPSDE14(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByUtilPSDE14(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByUtilPSDE14(PSDataEntity pSDataEntity, ArrayList<PSSysUtilDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUtilPSDE14(PSDataEntity pSDataEntity, ArrayList<PSSysUtilDE> arrayList) throws Exception {
    }

    public void testRemoveByUtilPSDE15(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByUtilPSDE15(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSUTILDE_PSDATAENTITY_UTILPSDE15ID", "", iDataEntityModel.getName(), "PSSYSUTILDE", iDataEntityModel.getDataInfo((IEntity)pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetUtilPSDE15(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByUtilPSDE15(pSDataEntity);
        for (PSSysUtilDE pSSysUtilDE : arrayList) {
            PSSysUtilDE pSSysUtilDE2 = (PSSysUtilDE)this.getDEModel().createEntity();
            pSSysUtilDE2.setPSSysUtilDEId(pSSysUtilDE.getPSSysUtilDEId());
            pSSysUtilDE2.setUtilPSDE15Id(null);
            this.update(pSSysUtilDE2);
        }
    }

    public void removeByUtilPSDE15(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysUtilDEServiceBase.this.onBeforeRemoveByUtilPSDE15(pSDataEntity2);
                PSSysUtilDEServiceBase.this.internalRemoveByUtilPSDE15(pSDataEntity2);
                PSSysUtilDEServiceBase.this.onAfterRemoveByUtilPSDE15(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByUtilPSDE15(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByUtilPSDE15(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByUtilPSDE15(pSDataEntity);
        this.onBeforeRemoveByUtilPSDE15(pSDataEntity, arrayList);
        for (PSSysUtilDE pSSysUtilDE : arrayList) {
            this.remove((IEntity)pSSysUtilDE);
        }
        this.onAfterRemoveByUtilPSDE15(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByUtilPSDE15(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByUtilPSDE15(PSDataEntity pSDataEntity, ArrayList<PSSysUtilDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUtilPSDE15(PSDataEntity pSDataEntity, ArrayList<PSSysUtilDE> arrayList) throws Exception {
    }

    public void testRemoveByUtilPSDE16(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByUtilPSDE16(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSUTILDE_PSDATAENTITY_UTILPSDE16ID", "", iDataEntityModel.getName(), "PSSYSUTILDE", iDataEntityModel.getDataInfo((IEntity)pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetUtilPSDE16(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByUtilPSDE16(pSDataEntity);
        for (PSSysUtilDE pSSysUtilDE : arrayList) {
            PSSysUtilDE pSSysUtilDE2 = (PSSysUtilDE)this.getDEModel().createEntity();
            pSSysUtilDE2.setPSSysUtilDEId(pSSysUtilDE.getPSSysUtilDEId());
            pSSysUtilDE2.setUtilPSDE16Id(null);
            this.update(pSSysUtilDE2);
        }
    }

    public void removeByUtilPSDE16(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysUtilDEServiceBase.this.onBeforeRemoveByUtilPSDE16(pSDataEntity2);
                PSSysUtilDEServiceBase.this.internalRemoveByUtilPSDE16(pSDataEntity2);
                PSSysUtilDEServiceBase.this.onAfterRemoveByUtilPSDE16(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByUtilPSDE16(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByUtilPSDE16(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByUtilPSDE16(pSDataEntity);
        this.onBeforeRemoveByUtilPSDE16(pSDataEntity, arrayList);
        for (PSSysUtilDE pSSysUtilDE : arrayList) {
            this.remove((IEntity)pSSysUtilDE);
        }
        this.onAfterRemoveByUtilPSDE16(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByUtilPSDE16(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByUtilPSDE16(PSDataEntity pSDataEntity, ArrayList<PSSysUtilDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUtilPSDE16(PSDataEntity pSDataEntity, ArrayList<PSSysUtilDE> arrayList) throws Exception {
    }

    public void testRemoveByUtilPSDE17(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByUtilPSDE17(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSUTILDE_PSDATAENTITY_UTILPSDE17ID", "", iDataEntityModel.getName(), "PSSYSUTILDE", iDataEntityModel.getDataInfo((IEntity)pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetUtilPSDE17(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByUtilPSDE17(pSDataEntity);
        for (PSSysUtilDE pSSysUtilDE : arrayList) {
            PSSysUtilDE pSSysUtilDE2 = (PSSysUtilDE)this.getDEModel().createEntity();
            pSSysUtilDE2.setPSSysUtilDEId(pSSysUtilDE.getPSSysUtilDEId());
            pSSysUtilDE2.setUtilPSDE17Id(null);
            this.update(pSSysUtilDE2);
        }
    }

    public void removeByUtilPSDE17(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysUtilDEServiceBase.this.onBeforeRemoveByUtilPSDE17(pSDataEntity2);
                PSSysUtilDEServiceBase.this.internalRemoveByUtilPSDE17(pSDataEntity2);
                PSSysUtilDEServiceBase.this.onAfterRemoveByUtilPSDE17(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByUtilPSDE17(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByUtilPSDE17(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByUtilPSDE17(pSDataEntity);
        this.onBeforeRemoveByUtilPSDE17(pSDataEntity, arrayList);
        for (PSSysUtilDE pSSysUtilDE : arrayList) {
            this.remove((IEntity)pSSysUtilDE);
        }
        this.onAfterRemoveByUtilPSDE17(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByUtilPSDE17(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByUtilPSDE17(PSDataEntity pSDataEntity, ArrayList<PSSysUtilDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUtilPSDE17(PSDataEntity pSDataEntity, ArrayList<PSSysUtilDE> arrayList) throws Exception {
    }

    public void testRemoveByUtilPSDE18(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByUtilPSDE18(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSUTILDE_PSDATAENTITY_UTILPSDE18ID", "", iDataEntityModel.getName(), "PSSYSUTILDE", iDataEntityModel.getDataInfo((IEntity)pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetUtilPSDE18(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByUtilPSDE18(pSDataEntity);
        for (PSSysUtilDE pSSysUtilDE : arrayList) {
            PSSysUtilDE pSSysUtilDE2 = (PSSysUtilDE)this.getDEModel().createEntity();
            pSSysUtilDE2.setPSSysUtilDEId(pSSysUtilDE.getPSSysUtilDEId());
            pSSysUtilDE2.setUtilPSDE18Id(null);
            this.update(pSSysUtilDE2);
        }
    }

    public void removeByUtilPSDE18(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysUtilDEServiceBase.this.onBeforeRemoveByUtilPSDE18(pSDataEntity2);
                PSSysUtilDEServiceBase.this.internalRemoveByUtilPSDE18(pSDataEntity2);
                PSSysUtilDEServiceBase.this.onAfterRemoveByUtilPSDE18(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByUtilPSDE18(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByUtilPSDE18(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByUtilPSDE18(pSDataEntity);
        this.onBeforeRemoveByUtilPSDE18(pSDataEntity, arrayList);
        for (PSSysUtilDE pSSysUtilDE : arrayList) {
            this.remove((IEntity)pSSysUtilDE);
        }
        this.onAfterRemoveByUtilPSDE18(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByUtilPSDE18(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByUtilPSDE18(PSDataEntity pSDataEntity, ArrayList<PSSysUtilDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUtilPSDE18(PSDataEntity pSDataEntity, ArrayList<PSSysUtilDE> arrayList) throws Exception {
    }

    public void testRemoveByUtilPSDE19(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByUtilPSDE19(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSUTILDE_PSDATAENTITY_UTILPSDE19ID", "", iDataEntityModel.getName(), "PSSYSUTILDE", iDataEntityModel.getDataInfo((IEntity)pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetUtilPSDE19(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByUtilPSDE19(pSDataEntity);
        for (PSSysUtilDE pSSysUtilDE : arrayList) {
            PSSysUtilDE pSSysUtilDE2 = (PSSysUtilDE)this.getDEModel().createEntity();
            pSSysUtilDE2.setPSSysUtilDEId(pSSysUtilDE.getPSSysUtilDEId());
            pSSysUtilDE2.setUtilPSDE19Id(null);
            this.update(pSSysUtilDE2);
        }
    }

    public void removeByUtilPSDE19(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysUtilDEServiceBase.this.onBeforeRemoveByUtilPSDE19(pSDataEntity2);
                PSSysUtilDEServiceBase.this.internalRemoveByUtilPSDE19(pSDataEntity2);
                PSSysUtilDEServiceBase.this.onAfterRemoveByUtilPSDE19(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByUtilPSDE19(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByUtilPSDE19(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByUtilPSDE19(pSDataEntity);
        this.onBeforeRemoveByUtilPSDE19(pSDataEntity, arrayList);
        for (PSSysUtilDE pSSysUtilDE : arrayList) {
            this.remove((IEntity)pSSysUtilDE);
        }
        this.onAfterRemoveByUtilPSDE19(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByUtilPSDE19(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByUtilPSDE19(PSDataEntity pSDataEntity, ArrayList<PSSysUtilDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUtilPSDE19(PSDataEntity pSDataEntity, ArrayList<PSSysUtilDE> arrayList) throws Exception {
    }

    public void testRemoveByUtilPSDE20(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByUtilPSDE20(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSUTILDE_PSDATAENTITY_UTILPSDE20ID", "", iDataEntityModel.getName(), "PSSYSUTILDE", iDataEntityModel.getDataInfo((IEntity)pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetUtilPSDE20(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByUtilPSDE20(pSDataEntity);
        for (PSSysUtilDE pSSysUtilDE : arrayList) {
            PSSysUtilDE pSSysUtilDE2 = (PSSysUtilDE)this.getDEModel().createEntity();
            pSSysUtilDE2.setPSSysUtilDEId(pSSysUtilDE.getPSSysUtilDEId());
            pSSysUtilDE2.setUtilPSDE20Id(null);
            this.update(pSSysUtilDE2);
        }
    }

    public void removeByUtilPSDE20(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysUtilDEServiceBase.this.onBeforeRemoveByUtilPSDE20(pSDataEntity2);
                PSSysUtilDEServiceBase.this.internalRemoveByUtilPSDE20(pSDataEntity2);
                PSSysUtilDEServiceBase.this.onAfterRemoveByUtilPSDE20(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByUtilPSDE20(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByUtilPSDE20(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByUtilPSDE20(pSDataEntity);
        this.onBeforeRemoveByUtilPSDE20(pSDataEntity, arrayList);
        for (PSSysUtilDE pSSysUtilDE : arrayList) {
            this.remove((IEntity)pSSysUtilDE);
        }
        this.onAfterRemoveByUtilPSDE20(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByUtilPSDE20(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByUtilPSDE20(PSDataEntity pSDataEntity, ArrayList<PSSysUtilDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUtilPSDE20(PSDataEntity pSDataEntity, ArrayList<PSSysUtilDE> arrayList) throws Exception {
    }

    public void testRemoveByUtilPSDE2(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByUtilPSDE2(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSUTILDE_PSDATAENTITY_UTILPSDE2ID", "", iDataEntityModel.getName(), "PSSYSUTILDE", iDataEntityModel.getDataInfo((IEntity)pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetUtilPSDE2(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByUtilPSDE2(pSDataEntity);
        for (PSSysUtilDE pSSysUtilDE : arrayList) {
            PSSysUtilDE pSSysUtilDE2 = (PSSysUtilDE)this.getDEModel().createEntity();
            pSSysUtilDE2.setPSSysUtilDEId(pSSysUtilDE.getPSSysUtilDEId());
            pSSysUtilDE2.setUtilPSDE2Id(null);
            this.update(pSSysUtilDE2);
        }
    }

    public void removeByUtilPSDE2(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysUtilDEServiceBase.this.onBeforeRemoveByUtilPSDE2(pSDataEntity2);
                PSSysUtilDEServiceBase.this.internalRemoveByUtilPSDE2(pSDataEntity2);
                PSSysUtilDEServiceBase.this.onAfterRemoveByUtilPSDE2(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByUtilPSDE2(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByUtilPSDE2(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByUtilPSDE2(pSDataEntity);
        this.onBeforeRemoveByUtilPSDE2(pSDataEntity, arrayList);
        for (PSSysUtilDE pSSysUtilDE : arrayList) {
            this.remove((IEntity)pSSysUtilDE);
        }
        this.onAfterRemoveByUtilPSDE2(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByUtilPSDE2(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByUtilPSDE2(PSDataEntity pSDataEntity, ArrayList<PSSysUtilDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUtilPSDE2(PSDataEntity pSDataEntity, ArrayList<PSSysUtilDE> arrayList) throws Exception {
    }

    public void testRemoveByUtilPSDE3(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByUtilPSDE3(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSUTILDE_PSDATAENTITY_UTILPSDE3ID", "", iDataEntityModel.getName(), "PSSYSUTILDE", iDataEntityModel.getDataInfo((IEntity)pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetUtilPSDE3(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByUtilPSDE3(pSDataEntity);
        for (PSSysUtilDE pSSysUtilDE : arrayList) {
            PSSysUtilDE pSSysUtilDE2 = (PSSysUtilDE)this.getDEModel().createEntity();
            pSSysUtilDE2.setPSSysUtilDEId(pSSysUtilDE.getPSSysUtilDEId());
            pSSysUtilDE2.setUtilPSDE3Id(null);
            this.update(pSSysUtilDE2);
        }
    }

    public void removeByUtilPSDE3(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysUtilDEServiceBase.this.onBeforeRemoveByUtilPSDE3(pSDataEntity2);
                PSSysUtilDEServiceBase.this.internalRemoveByUtilPSDE3(pSDataEntity2);
                PSSysUtilDEServiceBase.this.onAfterRemoveByUtilPSDE3(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByUtilPSDE3(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByUtilPSDE3(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByUtilPSDE3(pSDataEntity);
        this.onBeforeRemoveByUtilPSDE3(pSDataEntity, arrayList);
        for (PSSysUtilDE pSSysUtilDE : arrayList) {
            this.remove((IEntity)pSSysUtilDE);
        }
        this.onAfterRemoveByUtilPSDE3(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByUtilPSDE3(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByUtilPSDE3(PSDataEntity pSDataEntity, ArrayList<PSSysUtilDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUtilPSDE3(PSDataEntity pSDataEntity, ArrayList<PSSysUtilDE> arrayList) throws Exception {
    }

    public void testRemoveByUtilPSDE4(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByUtilPSDE4(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSUTILDE_PSDATAENTITY_UTILPSDE4ID", "", iDataEntityModel.getName(), "PSSYSUTILDE", iDataEntityModel.getDataInfo((IEntity)pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetUtilPSDE4(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByUtilPSDE4(pSDataEntity);
        for (PSSysUtilDE pSSysUtilDE : arrayList) {
            PSSysUtilDE pSSysUtilDE2 = (PSSysUtilDE)this.getDEModel().createEntity();
            pSSysUtilDE2.setPSSysUtilDEId(pSSysUtilDE.getPSSysUtilDEId());
            pSSysUtilDE2.setUtilPSDE4Id(null);
            this.update(pSSysUtilDE2);
        }
    }

    public void removeByUtilPSDE4(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysUtilDEServiceBase.this.onBeforeRemoveByUtilPSDE4(pSDataEntity2);
                PSSysUtilDEServiceBase.this.internalRemoveByUtilPSDE4(pSDataEntity2);
                PSSysUtilDEServiceBase.this.onAfterRemoveByUtilPSDE4(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByUtilPSDE4(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByUtilPSDE4(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByUtilPSDE4(pSDataEntity);
        this.onBeforeRemoveByUtilPSDE4(pSDataEntity, arrayList);
        for (PSSysUtilDE pSSysUtilDE : arrayList) {
            this.remove((IEntity)pSSysUtilDE);
        }
        this.onAfterRemoveByUtilPSDE4(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByUtilPSDE4(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByUtilPSDE4(PSDataEntity pSDataEntity, ArrayList<PSSysUtilDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUtilPSDE4(PSDataEntity pSDataEntity, ArrayList<PSSysUtilDE> arrayList) throws Exception {
    }

    public void testRemoveByUtilPSDE5(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByUtilPSDE5(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSUTILDE_PSDATAENTITY_UTILPSDE5ID", "", iDataEntityModel.getName(), "PSSYSUTILDE", iDataEntityModel.getDataInfo((IEntity)pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetUtilPSDE5(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByUtilPSDE5(pSDataEntity);
        for (PSSysUtilDE pSSysUtilDE : arrayList) {
            PSSysUtilDE pSSysUtilDE2 = (PSSysUtilDE)this.getDEModel().createEntity();
            pSSysUtilDE2.setPSSysUtilDEId(pSSysUtilDE.getPSSysUtilDEId());
            pSSysUtilDE2.setUtilPSDE5Id(null);
            this.update(pSSysUtilDE2);
        }
    }

    public void removeByUtilPSDE5(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysUtilDEServiceBase.this.onBeforeRemoveByUtilPSDE5(pSDataEntity2);
                PSSysUtilDEServiceBase.this.internalRemoveByUtilPSDE5(pSDataEntity2);
                PSSysUtilDEServiceBase.this.onAfterRemoveByUtilPSDE5(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByUtilPSDE5(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByUtilPSDE5(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByUtilPSDE5(pSDataEntity);
        this.onBeforeRemoveByUtilPSDE5(pSDataEntity, arrayList);
        for (PSSysUtilDE pSSysUtilDE : arrayList) {
            this.remove((IEntity)pSSysUtilDE);
        }
        this.onAfterRemoveByUtilPSDE5(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByUtilPSDE5(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByUtilPSDE5(PSDataEntity pSDataEntity, ArrayList<PSSysUtilDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUtilPSDE5(PSDataEntity pSDataEntity, ArrayList<PSSysUtilDE> arrayList) throws Exception {
    }

    public void testRemoveByUtilPSDE6(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByUtilPSDE6(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSUTILDE_PSDATAENTITY_UTILPSDE6ID", "", iDataEntityModel.getName(), "PSSYSUTILDE", iDataEntityModel.getDataInfo((IEntity)pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetUtilPSDE6(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByUtilPSDE6(pSDataEntity);
        for (PSSysUtilDE pSSysUtilDE : arrayList) {
            PSSysUtilDE pSSysUtilDE2 = (PSSysUtilDE)this.getDEModel().createEntity();
            pSSysUtilDE2.setPSSysUtilDEId(pSSysUtilDE.getPSSysUtilDEId());
            pSSysUtilDE2.setUtilPSDE6Id(null);
            this.update(pSSysUtilDE2);
        }
    }

    public void removeByUtilPSDE6(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysUtilDEServiceBase.this.onBeforeRemoveByUtilPSDE6(pSDataEntity2);
                PSSysUtilDEServiceBase.this.internalRemoveByUtilPSDE6(pSDataEntity2);
                PSSysUtilDEServiceBase.this.onAfterRemoveByUtilPSDE6(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByUtilPSDE6(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByUtilPSDE6(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByUtilPSDE6(pSDataEntity);
        this.onBeforeRemoveByUtilPSDE6(pSDataEntity, arrayList);
        for (PSSysUtilDE pSSysUtilDE : arrayList) {
            this.remove((IEntity)pSSysUtilDE);
        }
        this.onAfterRemoveByUtilPSDE6(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByUtilPSDE6(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByUtilPSDE6(PSDataEntity pSDataEntity, ArrayList<PSSysUtilDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUtilPSDE6(PSDataEntity pSDataEntity, ArrayList<PSSysUtilDE> arrayList) throws Exception {
    }

    public void testRemoveByUtilPSDE7(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByUtilPSDE7(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSUTILDE_PSDATAENTITY_UTILPSDE7ID", "", iDataEntityModel.getName(), "PSSYSUTILDE", iDataEntityModel.getDataInfo((IEntity)pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetUtilPSDE7(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByUtilPSDE7(pSDataEntity);
        for (PSSysUtilDE pSSysUtilDE : arrayList) {
            PSSysUtilDE pSSysUtilDE2 = (PSSysUtilDE)this.getDEModel().createEntity();
            pSSysUtilDE2.setPSSysUtilDEId(pSSysUtilDE.getPSSysUtilDEId());
            pSSysUtilDE2.setUtilPSDE7Id(null);
            this.update(pSSysUtilDE2);
        }
    }

    public void removeByUtilPSDE7(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysUtilDEServiceBase.this.onBeforeRemoveByUtilPSDE7(pSDataEntity2);
                PSSysUtilDEServiceBase.this.internalRemoveByUtilPSDE7(pSDataEntity2);
                PSSysUtilDEServiceBase.this.onAfterRemoveByUtilPSDE7(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByUtilPSDE7(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByUtilPSDE7(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByUtilPSDE7(pSDataEntity);
        this.onBeforeRemoveByUtilPSDE7(pSDataEntity, arrayList);
        for (PSSysUtilDE pSSysUtilDE : arrayList) {
            this.remove((IEntity)pSSysUtilDE);
        }
        this.onAfterRemoveByUtilPSDE7(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByUtilPSDE7(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByUtilPSDE7(PSDataEntity pSDataEntity, ArrayList<PSSysUtilDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUtilPSDE7(PSDataEntity pSDataEntity, ArrayList<PSSysUtilDE> arrayList) throws Exception {
    }

    public void testRemoveByUtilPSDE8(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByUtilPSDE8(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSUTILDE_PSDATAENTITY_UTILPSDE8ID", "", iDataEntityModel.getName(), "PSSYSUTILDE", iDataEntityModel.getDataInfo((IEntity)pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetUtilPSDE8(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByUtilPSDE8(pSDataEntity);
        for (PSSysUtilDE pSSysUtilDE : arrayList) {
            PSSysUtilDE pSSysUtilDE2 = (PSSysUtilDE)this.getDEModel().createEntity();
            pSSysUtilDE2.setPSSysUtilDEId(pSSysUtilDE.getPSSysUtilDEId());
            pSSysUtilDE2.setUtilPSDE8Id(null);
            this.update(pSSysUtilDE2);
        }
    }

    public void removeByUtilPSDE8(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysUtilDEServiceBase.this.onBeforeRemoveByUtilPSDE8(pSDataEntity2);
                PSSysUtilDEServiceBase.this.internalRemoveByUtilPSDE8(pSDataEntity2);
                PSSysUtilDEServiceBase.this.onAfterRemoveByUtilPSDE8(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByUtilPSDE8(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByUtilPSDE8(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByUtilPSDE8(pSDataEntity);
        this.onBeforeRemoveByUtilPSDE8(pSDataEntity, arrayList);
        for (PSSysUtilDE pSSysUtilDE : arrayList) {
            this.remove((IEntity)pSSysUtilDE);
        }
        this.onAfterRemoveByUtilPSDE8(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByUtilPSDE8(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByUtilPSDE8(PSDataEntity pSDataEntity, ArrayList<PSSysUtilDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUtilPSDE8(PSDataEntity pSDataEntity, ArrayList<PSSysUtilDE> arrayList) throws Exception {
    }

    public void testRemoveByUtilPSDE9(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByUtilPSDE9(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSUTILDE_PSDATAENTITY_UTILPSDE9ID", "", iDataEntityModel.getName(), "PSSYSUTILDE", iDataEntityModel.getDataInfo((IEntity)pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetUtilPSDE9(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByUtilPSDE9(pSDataEntity);
        for (PSSysUtilDE pSSysUtilDE : arrayList) {
            PSSysUtilDE pSSysUtilDE2 = (PSSysUtilDE)this.getDEModel().createEntity();
            pSSysUtilDE2.setPSSysUtilDEId(pSSysUtilDE.getPSSysUtilDEId());
            pSSysUtilDE2.setUtilPSDE9Id(null);
            this.update(pSSysUtilDE2);
        }
    }

    public void removeByUtilPSDE9(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysUtilDEServiceBase.this.onBeforeRemoveByUtilPSDE9(pSDataEntity2);
                PSSysUtilDEServiceBase.this.internalRemoveByUtilPSDE9(pSDataEntity2);
                PSSysUtilDEServiceBase.this.onAfterRemoveByUtilPSDE9(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByUtilPSDE9(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByUtilPSDE9(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByUtilPSDE9(pSDataEntity);
        this.onBeforeRemoveByUtilPSDE9(pSDataEntity, arrayList);
        for (PSSysUtilDE pSSysUtilDE : arrayList) {
            this.remove((IEntity)pSSysUtilDE);
        }
        this.onAfterRemoveByUtilPSDE9(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByUtilPSDE9(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByUtilPSDE9(PSDataEntity pSDataEntity, ArrayList<PSSysUtilDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUtilPSDE9(PSDataEntity pSDataEntity, ArrayList<PSSysUtilDE> arrayList) throws Exception {
    }

    public void testRemoveByUtilPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByUtilPSDE(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSUTILDE_PSDATAENTITY_UTILPSDEID", "", iDataEntityModel.getName(), "PSSYSUTILDE", iDataEntityModel.getDataInfo((IEntity)pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetUtilPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByUtilPSDE(pSDataEntity);
        for (PSSysUtilDE pSSysUtilDE : arrayList) {
            PSSysUtilDE pSSysUtilDE2 = (PSSysUtilDE)this.getDEModel().createEntity();
            pSSysUtilDE2.setPSSysUtilDEId(pSSysUtilDE.getPSSysUtilDEId());
            pSSysUtilDE2.setUtilPSDEId(null);
            this.update(pSSysUtilDE2);
        }
    }

    public void removeByUtilPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysUtilDEServiceBase.this.onBeforeRemoveByUtilPSDE(pSDataEntity2);
                PSSysUtilDEServiceBase.this.internalRemoveByUtilPSDE(pSDataEntity2);
                PSSysUtilDEServiceBase.this.onAfterRemoveByUtilPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByUtilPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByUtilPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByUtilPSDE(pSDataEntity);
        this.onBeforeRemoveByUtilPSDE(pSDataEntity, arrayList);
        for (PSSysUtilDE pSSysUtilDE : arrayList) {
            this.remove((IEntity)pSSysUtilDE);
        }
        this.onAfterRemoveByUtilPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByUtilPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByUtilPSDE(PSDataEntity pSDataEntity, ArrayList<PSSysUtilDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUtilPSDE(PSDataEntity pSDataEntity, ArrayList<PSSysUtilDE> arrayList) throws Exception {
    }

    public void testRemoveByPSDEGroup(PSDEGroup pSDEGroup) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByPSDEGroup(pSDEGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSUTILDE_PSDEGROUP_PSDEGROUPID", "", iDataEntityModel.getName(), "PSSYSUTILDE", iDataEntityModel.getDataInfo((IEntity)pSDEGroup), arrayList.get(0)));
        }
    }

    public void resetPSDEGroup(PSDEGroup pSDEGroup) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByPSDEGroup(pSDEGroup);
        for (PSSysUtilDE pSSysUtilDE : arrayList) {
            PSSysUtilDE pSSysUtilDE2 = (PSSysUtilDE)this.getDEModel().createEntity();
            pSSysUtilDE2.setPSSysUtilDEId(pSSysUtilDE.getPSSysUtilDEId());
            pSSysUtilDE2.setPSDEGroupId(null);
            this.update(pSSysUtilDE2);
        }
    }

    public void removeByPSDEGroup(PSDEGroup pSDEGroup) throws Exception {
        final PSDEGroup pSDEGroup2 = pSDEGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysUtilDEServiceBase.this.onBeforeRemoveByPSDEGroup(pSDEGroup2);
                PSSysUtilDEServiceBase.this.internalRemoveByPSDEGroup(pSDEGroup2);
                PSSysUtilDEServiceBase.this.onAfterRemoveByPSDEGroup(pSDEGroup2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEGroup(PSDEGroup pSDEGroup) throws Exception {
    }

    protected void internalRemoveByPSDEGroup(PSDEGroup pSDEGroup) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByPSDEGroup(pSDEGroup);
        this.onBeforeRemoveByPSDEGroup(pSDEGroup, arrayList);
        for (PSSysUtilDE pSSysUtilDE : arrayList) {
            this.remove((IEntity)pSSysUtilDE);
        }
        this.onAfterRemoveByPSDEGroup(pSDEGroup, arrayList);
    }

    protected void onAfterRemoveByPSDEGroup(PSDEGroup pSDEGroup) throws Exception {
    }

    protected void onBeforeRemoveByPSDEGroup(PSDEGroup pSDEGroup, ArrayList<PSSysUtilDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEGroup(PSDEGroup pSDEGroup, ArrayList<PSSysUtilDE> arrayList) throws Exception {
    }

    public void testRemoveByPSDERGroup(PSDERGroup pSDERGroup) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByPSDERGroup(pSDERGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDERGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDERGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSUTILDE_PSDERGROUP_PSDERGROUPID", "", iDataEntityModel.getName(), "PSSYSUTILDE", iDataEntityModel.getDataInfo((IEntity)pSDERGroup), arrayList.get(0)));
        }
    }

    public void resetPSDERGroup(PSDERGroup pSDERGroup) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByPSDERGroup(pSDERGroup);
        for (PSSysUtilDE pSSysUtilDE : arrayList) {
            PSSysUtilDE pSSysUtilDE2 = (PSSysUtilDE)this.getDEModel().createEntity();
            pSSysUtilDE2.setPSSysUtilDEId(pSSysUtilDE.getPSSysUtilDEId());
            pSSysUtilDE2.setPSDERGroupId(null);
            this.update(pSSysUtilDE2);
        }
    }

    public void removeByPSDERGroup(PSDERGroup pSDERGroup) throws Exception {
        final PSDERGroup pSDERGroup2 = pSDERGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysUtilDEServiceBase.this.onBeforeRemoveByPSDERGroup(pSDERGroup2);
                PSSysUtilDEServiceBase.this.internalRemoveByPSDERGroup(pSDERGroup2);
                PSSysUtilDEServiceBase.this.onAfterRemoveByPSDERGroup(pSDERGroup2);
            }
        });
    }

    protected void onBeforeRemoveByPSDERGroup(PSDERGroup pSDERGroup) throws Exception {
    }

    protected void internalRemoveByPSDERGroup(PSDERGroup pSDERGroup) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByPSDERGroup(pSDERGroup);
        this.onBeforeRemoveByPSDERGroup(pSDERGroup, arrayList);
        for (PSSysUtilDE pSSysUtilDE : arrayList) {
            this.remove((IEntity)pSSysUtilDE);
        }
        this.onAfterRemoveByPSDERGroup(pSDERGroup, arrayList);
    }

    protected void onAfterRemoveByPSDERGroup(PSDERGroup pSDERGroup) throws Exception {
    }

    protected void onBeforeRemoveByPSDERGroup(PSDERGroup pSDERGroup, ArrayList<PSSysUtilDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDERGroup(PSDERGroup pSDERGroup, ArrayList<PSSysUtilDE> arrayList) throws Exception {
    }

    public void testRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByPSModule(pSModule, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSMODULE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSModule);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSUTILDE_PSMODULE_PSMODULEID", "", iDataEntityModel.getName(), "PSSYSUTILDE", iDataEntityModel.getDataInfo((IEntity)pSModule), arrayList.get(0)));
        }
    }

    public void resetPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByPSModule(pSModule);
        for (PSSysUtilDE pSSysUtilDE : arrayList) {
            PSSysUtilDE pSSysUtilDE2 = (PSSysUtilDE)this.getDEModel().createEntity();
            pSSysUtilDE2.setPSSysUtilDEId(pSSysUtilDE.getPSSysUtilDEId());
            pSSysUtilDE2.setPSModuleId(null);
            this.update(pSSysUtilDE2);
        }
    }

    public void removeByPSModule(PSModule pSModule) throws Exception {
        final PSModule pSModule2 = pSModule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysUtilDEServiceBase.this.onBeforeRemoveByPSModule(pSModule2);
                PSSysUtilDEServiceBase.this.internalRemoveByPSModule(pSModule2);
                PSSysUtilDEServiceBase.this.onAfterRemoveByPSModule(pSModule2);
            }
        });
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void internalRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByPSModule(pSModule);
        this.onBeforeRemoveByPSModule(pSModule, arrayList);
        for (PSSysUtilDE pSSysUtilDE : arrayList) {
            this.remove((IEntity)pSSysUtilDE);
        }
        this.onAfterRemoveByPSModule(pSModule, arrayList);
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule, ArrayList<PSSysUtilDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule, ArrayList<PSSysUtilDE> arrayList) throws Exception {
    }

    public void testRemoveByPSSubSysServiceAPI(PSSubSysServiceAPI pSSubSysServiceAPI) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByPSSubSysServiceAPI(pSSubSysServiceAPI, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSUBSYSSERVICEAPI");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSubSysServiceAPI);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSUTILDE_PSSUBSYSSERVICEAPI_PSSUBSYSSERVICEAPIID", "", iDataEntityModel.getName(), "PSSYSUTILDE", iDataEntityModel.getDataInfo((IEntity)pSSubSysServiceAPI), arrayList.get(0)));
        }
    }

    public void resetPSSubSysServiceAPI(PSSubSysServiceAPI pSSubSysServiceAPI) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByPSSubSysServiceAPI(pSSubSysServiceAPI);
        for (PSSysUtilDE pSSysUtilDE : arrayList) {
            PSSysUtilDE pSSysUtilDE2 = (PSSysUtilDE)this.getDEModel().createEntity();
            pSSysUtilDE2.setPSSysUtilDEId(pSSysUtilDE.getPSSysUtilDEId());
            pSSysUtilDE2.setPSSubSysServiceAPIId(null);
            this.update(pSSysUtilDE2);
        }
    }

    public void removeByPSSubSysServiceAPI(PSSubSysServiceAPI pSSubSysServiceAPI) throws Exception {
        final PSSubSysServiceAPI pSSubSysServiceAPI2 = pSSubSysServiceAPI;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysUtilDEServiceBase.this.onBeforeRemoveByPSSubSysServiceAPI(pSSubSysServiceAPI2);
                PSSysUtilDEServiceBase.this.internalRemoveByPSSubSysServiceAPI(pSSubSysServiceAPI2);
                PSSysUtilDEServiceBase.this.onAfterRemoveByPSSubSysServiceAPI(pSSubSysServiceAPI2);
            }
        });
    }

    protected void onBeforeRemoveByPSSubSysServiceAPI(PSSubSysServiceAPI pSSubSysServiceAPI) throws Exception {
    }

    protected void internalRemoveByPSSubSysServiceAPI(PSSubSysServiceAPI pSSubSysServiceAPI) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByPSSubSysServiceAPI(pSSubSysServiceAPI);
        this.onBeforeRemoveByPSSubSysServiceAPI(pSSubSysServiceAPI, arrayList);
        for (PSSysUtilDE pSSysUtilDE : arrayList) {
            this.remove((IEntity)pSSysUtilDE);
        }
        this.onAfterRemoveByPSSubSysServiceAPI(pSSubSysServiceAPI, arrayList);
    }

    protected void onAfterRemoveByPSSubSysServiceAPI(PSSubSysServiceAPI pSSubSysServiceAPI) throws Exception {
    }

    protected void onBeforeRemoveByPSSubSysServiceAPI(PSSubSysServiceAPI pSSubSysServiceAPI, ArrayList<PSSysUtilDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSubSysServiceAPI(PSSubSysServiceAPI pSSubSysServiceAPI, ArrayList<PSSysUtilDE> arrayList) throws Exception {
    }

    public void testRemoveByInPSSysDataSyncAgent(PSSysDataSyncAgent pSSysDataSyncAgent) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByInPSSysDataSyncAgent(pSSysDataSyncAgent, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSDATASYNCAGENT");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysDataSyncAgent);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSUTILDE_PSSYSDATASYNCAGENT_INPSSYSDATASYNCAGENTID", "", iDataEntityModel.getName(), "PSSYSUTILDE", iDataEntityModel.getDataInfo((IEntity)pSSysDataSyncAgent), arrayList.get(0)));
        }
    }

    public void resetInPSSysDataSyncAgent(PSSysDataSyncAgent pSSysDataSyncAgent) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByInPSSysDataSyncAgent(pSSysDataSyncAgent);
        for (PSSysUtilDE pSSysUtilDE : arrayList) {
            PSSysUtilDE pSSysUtilDE2 = (PSSysUtilDE)this.getDEModel().createEntity();
            pSSysUtilDE2.setPSSysUtilDEId(pSSysUtilDE.getPSSysUtilDEId());
            pSSysUtilDE2.setInPSSysDataSyncAgentId(null);
            this.update(pSSysUtilDE2);
        }
    }

    public void removeByInPSSysDataSyncAgent(PSSysDataSyncAgent pSSysDataSyncAgent) throws Exception {
        final PSSysDataSyncAgent pSSysDataSyncAgent2 = pSSysDataSyncAgent;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysUtilDEServiceBase.this.onBeforeRemoveByInPSSysDataSyncAgent(pSSysDataSyncAgent2);
                PSSysUtilDEServiceBase.this.internalRemoveByInPSSysDataSyncAgent(pSSysDataSyncAgent2);
                PSSysUtilDEServiceBase.this.onAfterRemoveByInPSSysDataSyncAgent(pSSysDataSyncAgent2);
            }
        });
    }

    protected void onBeforeRemoveByInPSSysDataSyncAgent(PSSysDataSyncAgent pSSysDataSyncAgent) throws Exception {
    }

    protected void internalRemoveByInPSSysDataSyncAgent(PSSysDataSyncAgent pSSysDataSyncAgent) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByInPSSysDataSyncAgent(pSSysDataSyncAgent);
        this.onBeforeRemoveByInPSSysDataSyncAgent(pSSysDataSyncAgent, arrayList);
        for (PSSysUtilDE pSSysUtilDE : arrayList) {
            this.remove((IEntity)pSSysUtilDE);
        }
        this.onAfterRemoveByInPSSysDataSyncAgent(pSSysDataSyncAgent, arrayList);
    }

    protected void onAfterRemoveByInPSSysDataSyncAgent(PSSysDataSyncAgent pSSysDataSyncAgent) throws Exception {
    }

    protected void onBeforeRemoveByInPSSysDataSyncAgent(PSSysDataSyncAgent pSSysDataSyncAgent, ArrayList<PSSysUtilDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByInPSSysDataSyncAgent(PSSysDataSyncAgent pSSysDataSyncAgent, ArrayList<PSSysUtilDE> arrayList) throws Exception {
    }

    public void testRemoveByOutPSSysDataSyncAgent(PSSysDataSyncAgent pSSysDataSyncAgent) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByOutPSSysDataSyncAgent(pSSysDataSyncAgent, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSDATASYNCAGENT");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysDataSyncAgent);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSUTILDE_PSSYSDATASYNCAGENT_OUTPSSYSDATASYNCAGENTID", "", iDataEntityModel.getName(), "PSSYSUTILDE", iDataEntityModel.getDataInfo((IEntity)pSSysDataSyncAgent), arrayList.get(0)));
        }
    }

    public void resetOutPSSysDataSyncAgent(PSSysDataSyncAgent pSSysDataSyncAgent) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByOutPSSysDataSyncAgent(pSSysDataSyncAgent);
        for (PSSysUtilDE pSSysUtilDE : arrayList) {
            PSSysUtilDE pSSysUtilDE2 = (PSSysUtilDE)this.getDEModel().createEntity();
            pSSysUtilDE2.setPSSysUtilDEId(pSSysUtilDE.getPSSysUtilDEId());
            pSSysUtilDE2.setOutPSSysDataSyncAgentId(null);
            this.update(pSSysUtilDE2);
        }
    }

    public void removeByOutPSSysDataSyncAgent(PSSysDataSyncAgent pSSysDataSyncAgent) throws Exception {
        final PSSysDataSyncAgent pSSysDataSyncAgent2 = pSSysDataSyncAgent;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysUtilDEServiceBase.this.onBeforeRemoveByOutPSSysDataSyncAgent(pSSysDataSyncAgent2);
                PSSysUtilDEServiceBase.this.internalRemoveByOutPSSysDataSyncAgent(pSSysDataSyncAgent2);
                PSSysUtilDEServiceBase.this.onAfterRemoveByOutPSSysDataSyncAgent(pSSysDataSyncAgent2);
            }
        });
    }

    protected void onBeforeRemoveByOutPSSysDataSyncAgent(PSSysDataSyncAgent pSSysDataSyncAgent) throws Exception {
    }

    protected void internalRemoveByOutPSSysDataSyncAgent(PSSysDataSyncAgent pSSysDataSyncAgent) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByOutPSSysDataSyncAgent(pSSysDataSyncAgent);
        this.onBeforeRemoveByOutPSSysDataSyncAgent(pSSysDataSyncAgent, arrayList);
        for (PSSysUtilDE pSSysUtilDE : arrayList) {
            this.remove((IEntity)pSSysUtilDE);
        }
        this.onAfterRemoveByOutPSSysDataSyncAgent(pSSysDataSyncAgent, arrayList);
    }

    protected void onAfterRemoveByOutPSSysDataSyncAgent(PSSysDataSyncAgent pSSysDataSyncAgent) throws Exception {
    }

    protected void onBeforeRemoveByOutPSSysDataSyncAgent(PSSysDataSyncAgent pSSysDataSyncAgent, ArrayList<PSSysUtilDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByOutPSSysDataSyncAgent(PSSysDataSyncAgent pSSysDataSyncAgent, ArrayList<PSSysUtilDE> arrayList) throws Exception {
    }

    public void testRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSDYNAMODEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysDynaModel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSUTILDE_PSSYSDYNAMODEL_PSSYSDYNAMODELID", "", iDataEntityModel.getName(), "PSSYSUTILDE", iDataEntityModel.getDataInfo((IEntity)pSSysDynaModel), arrayList.get(0)));
        }
    }

    public void resetPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        for (PSSysUtilDE pSSysUtilDE : arrayList) {
            PSSysUtilDE pSSysUtilDE2 = (PSSysUtilDE)this.getDEModel().createEntity();
            pSSysUtilDE2.setPSSysUtilDEId(pSSysUtilDE.getPSSysUtilDEId());
            pSSysUtilDE2.setPSSysDynaModelId(null);
            this.update(pSSysUtilDE2);
        }
    }

    public void removeByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        final PSSysDynaModel pSSysDynaModel2 = pSSysDynaModel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysUtilDEServiceBase.this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSSysUtilDEServiceBase.this.internalRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSSysUtilDEServiceBase.this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void internalRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
        for (PSSysUtilDE pSSysUtilDE : arrayList) {
            this.remove((IEntity)pSSysUtilDE);
        }
        this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSSysUtilDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSSysUtilDE> arrayList) throws Exception {
    }

    public void testRemoveByPSSysModelGroup(PSSysModelGroup pSSysModelGroup) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByPSSysModelGroup(pSSysModelGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSMODELGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysModelGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSUTILDE_PSSYSMODELGROUP_PSSYSMODELGROUPID", "", iDataEntityModel.getName(), "PSSYSUTILDE", iDataEntityModel.getDataInfo((IEntity)pSSysModelGroup), arrayList.get(0)));
        }
    }

    public void resetPSSysModelGroup(PSSysModelGroup pSSysModelGroup) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByPSSysModelGroup(pSSysModelGroup);
        for (PSSysUtilDE pSSysUtilDE : arrayList) {
            PSSysUtilDE pSSysUtilDE2 = (PSSysUtilDE)this.getDEModel().createEntity();
            pSSysUtilDE2.setPSSysUtilDEId(pSSysUtilDE.getPSSysUtilDEId());
            pSSysUtilDE2.setPSSysModelGroupId(null);
            this.update(pSSysUtilDE2);
        }
    }

    public void removeByPSSysModelGroup(PSSysModelGroup pSSysModelGroup) throws Exception {
        final PSSysModelGroup pSSysModelGroup2 = pSSysModelGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysUtilDEServiceBase.this.onBeforeRemoveByPSSysModelGroup(pSSysModelGroup2);
                PSSysUtilDEServiceBase.this.internalRemoveByPSSysModelGroup(pSSysModelGroup2);
                PSSysUtilDEServiceBase.this.onAfterRemoveByPSSysModelGroup(pSSysModelGroup2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysModelGroup(PSSysModelGroup pSSysModelGroup) throws Exception {
    }

    protected void internalRemoveByPSSysModelGroup(PSSysModelGroup pSSysModelGroup) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByPSSysModelGroup(pSSysModelGroup);
        this.onBeforeRemoveByPSSysModelGroup(pSSysModelGroup, arrayList);
        for (PSSysUtilDE pSSysUtilDE : arrayList) {
            this.remove((IEntity)pSSysUtilDE);
        }
        this.onAfterRemoveByPSSysModelGroup(pSSysModelGroup, arrayList);
    }

    protected void onAfterRemoveByPSSysModelGroup(PSSysModelGroup pSSysModelGroup) throws Exception {
    }

    protected void onBeforeRemoveByPSSysModelGroup(PSSysModelGroup pSSysModelGroup, ArrayList<PSSysUtilDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysModelGroup(PSSysModelGroup pSSysModelGroup, ArrayList<PSSysUtilDE> arrayList) throws Exception {
    }

    public void testRemoveByOutPSSysResource(PSSysResource pSSysResource) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByOutPSSysResource(pSSysResource, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSRESOURCE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysResource);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSUTILDE_PSSYSRESOURCE_OUTPSSYSRESOURCEID", "", iDataEntityModel.getName(), "PSSYSUTILDE", iDataEntityModel.getDataInfo((IEntity)pSSysResource), arrayList.get(0)));
        }
    }

    public void resetOutPSSysResource(PSSysResource pSSysResource) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByOutPSSysResource(pSSysResource);
        for (PSSysUtilDE pSSysUtilDE : arrayList) {
            PSSysUtilDE pSSysUtilDE2 = (PSSysUtilDE)this.getDEModel().createEntity();
            pSSysUtilDE2.setPSSysUtilDEId(pSSysUtilDE.getPSSysUtilDEId());
            pSSysUtilDE2.setOutPSSysResourceId(null);
            this.update(pSSysUtilDE2);
        }
    }

    public void removeByOutPSSysResource(PSSysResource pSSysResource) throws Exception {
        final PSSysResource pSSysResource2 = pSSysResource;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysUtilDEServiceBase.this.onBeforeRemoveByOutPSSysResource(pSSysResource2);
                PSSysUtilDEServiceBase.this.internalRemoveByOutPSSysResource(pSSysResource2);
                PSSysUtilDEServiceBase.this.onAfterRemoveByOutPSSysResource(pSSysResource2);
            }
        });
    }

    protected void onBeforeRemoveByOutPSSysResource(PSSysResource pSSysResource) throws Exception {
    }

    protected void internalRemoveByOutPSSysResource(PSSysResource pSSysResource) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByOutPSSysResource(pSSysResource);
        this.onBeforeRemoveByOutPSSysResource(pSSysResource, arrayList);
        for (PSSysUtilDE pSSysUtilDE : arrayList) {
            this.remove((IEntity)pSSysUtilDE);
        }
        this.onAfterRemoveByOutPSSysResource(pSSysResource, arrayList);
    }

    protected void onAfterRemoveByOutPSSysResource(PSSysResource pSSysResource) throws Exception {
    }

    protected void onBeforeRemoveByOutPSSysResource(PSSysResource pSSysResource, ArrayList<PSSysUtilDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByOutPSSysResource(PSSysResource pSSysResource, ArrayList<PSSysUtilDE> arrayList) throws Exception {
    }

    public void testRemoveByPSSysResource(PSSysResource pSSysResource) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByPSSysResource(pSSysResource, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSRESOURCE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysResource);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSUTILDE_PSSYSRESOURCE_PSSYSRESOURCEID", "", iDataEntityModel.getName(), "PSSYSUTILDE", iDataEntityModel.getDataInfo((IEntity)pSSysResource), arrayList.get(0)));
        }
    }

    public void resetPSSysResource(PSSysResource pSSysResource) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByPSSysResource(pSSysResource);
        for (PSSysUtilDE pSSysUtilDE : arrayList) {
            PSSysUtilDE pSSysUtilDE2 = (PSSysUtilDE)this.getDEModel().createEntity();
            pSSysUtilDE2.setPSSysUtilDEId(pSSysUtilDE.getPSSysUtilDEId());
            pSSysUtilDE2.setPSSysResourceId(null);
            this.update(pSSysUtilDE2);
        }
    }

    public void removeByPSSysResource(PSSysResource pSSysResource) throws Exception {
        final PSSysResource pSSysResource2 = pSSysResource;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysUtilDEServiceBase.this.onBeforeRemoveByPSSysResource(pSSysResource2);
                PSSysUtilDEServiceBase.this.internalRemoveByPSSysResource(pSSysResource2);
                PSSysUtilDEServiceBase.this.onAfterRemoveByPSSysResource(pSSysResource2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysResource(PSSysResource pSSysResource) throws Exception {
    }

    protected void internalRemoveByPSSysResource(PSSysResource pSSysResource) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByPSSysResource(pSSysResource);
        this.onBeforeRemoveByPSSysResource(pSSysResource, arrayList);
        for (PSSysUtilDE pSSysUtilDE : arrayList) {
            this.remove((IEntity)pSSysUtilDE);
        }
        this.onAfterRemoveByPSSysResource(pSSysResource, arrayList);
    }

    protected void onAfterRemoveByPSSysResource(PSSysResource pSSysResource) throws Exception {
    }

    protected void onBeforeRemoveByPSSysResource(PSSysResource pSSysResource, ArrayList<PSSysUtilDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysResource(PSSysResource pSSysResource, ArrayList<PSSysUtilDE> arrayList) throws Exception {
    }

    public void testRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSSFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysSFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSUTILDE_PSSYSSFPLUGIN_PSSYSSFPLUGINID", "", iDataEntityModel.getName(), "PSSYSUTILDE", iDataEntityModel.getDataInfo((IEntity)pSSysSFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        for (PSSysUtilDE pSSysUtilDE : arrayList) {
            PSSysUtilDE pSSysUtilDE2 = (PSSysUtilDE)this.getDEModel().createEntity();
            pSSysUtilDE2.setPSSysUtilDEId(pSSysUtilDE.getPSSysUtilDEId());
            pSSysUtilDE2.setPSSysSFPluginId(null);
            this.update(pSSysUtilDE2);
        }
    }

    public void removeByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        final PSSysSFPlugin pSSysSFPlugin2 = pSSysSFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysUtilDEServiceBase.this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSSysUtilDEServiceBase.this.internalRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSSysUtilDEServiceBase.this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
        for (PSSysUtilDE pSSysUtilDE : arrayList) {
            this.remove((IEntity)pSSysUtilDE);
        }
        this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSSysUtilDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSSysUtilDE> arrayList) throws Exception {
    }

    public void testRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByPSSystem(pSSystem, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSTEM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSystem);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSUTILDE_PSSYSTEM_PSSYSTEMID", "", iDataEntityModel.getName(), "PSSYSUTILDE", iDataEntityModel.getDataInfo((IEntity)pSSystem), arrayList.get(0)));
        }
    }

    public void resetPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByPSSystem(pSSystem);
        for (PSSysUtilDE pSSysUtilDE : arrayList) {
            PSSysUtilDE pSSysUtilDE2 = (PSSysUtilDE)this.getDEModel().createEntity();
            pSSysUtilDE2.setPSSysUtilDEId(pSSysUtilDE.getPSSysUtilDEId());
            pSSysUtilDE2.setPSSystemId(null);
            this.update(pSSysUtilDE2);
        }
    }

    public void removeByPSSystem(PSSystem pSSystem) throws Exception {
        final PSSystem pSSystem2 = pSSystem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysUtilDEServiceBase.this.onBeforeRemoveByPSSystem(pSSystem2);
                PSSysUtilDEServiceBase.this.internalRemoveByPSSystem(pSSystem2);
                PSSysUtilDEServiceBase.this.onAfterRemoveByPSSystem(pSSystem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void internalRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysUtilDE> arrayList = this.selectByPSSystem(pSSystem);
        this.onBeforeRemoveByPSSystem(pSSystem, arrayList);
        for (PSSysUtilDE pSSysUtilDE : arrayList) {
            this.remove((IEntity)pSSysUtilDE);
        }
        this.onAfterRemoveByPSSystem(pSSystem, arrayList);
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSysUtilDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSysUtilDE> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysUtilDE pSSysUtilDE) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEACModeService)ServiceGlobal.getService(PSDEACModeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEACModeServiceBase)pSCoreSysServiceBase).testRemoveByAIFactoryPSSysUtilDE(pSSysUtilDE);
        pSCoreSysServiceBase = (PSDELogicNodeService)ServiceGlobal.getService(PSDELogicNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDELogicNodeServiceBase)pSCoreSysServiceBase).testRemoveByPSSysUtilDE(pSSysUtilDE);
        pSCoreSysServiceBase = (PSSysBackServiceService)ServiceGlobal.getService(PSSysBackServiceService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysBackServiceServiceBase)pSCoreSysServiceBase).testRemoveByPSSysUtilDE(pSSysUtilDE);
        pSCoreSysServiceBase = (PSSysMsgQueueService)ServiceGlobal.getService(PSSysMsgQueueService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysMsgQueueServiceBase)pSCoreSysServiceBase).testRemoveByPSSysUtilDE(pSSysUtilDE);
        pSCoreSysServiceBase = (PSSysMsgTargetService)ServiceGlobal.getService(PSSysMsgTargetService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysMsgTargetServiceBase)pSCoreSysServiceBase).testRemoveByPSSysUtilDE(pSSysUtilDE);
        pSCoreSysServiceBase = (PSSysUniStateService)ServiceGlobal.getService(PSSysUniStateService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysUniStateServiceBase)pSCoreSysServiceBase).testRemoveByPSSysUtilDE(pSSysUtilDE);
        super.onBeforeRemove(pSSysUtilDE);
    }

    protected void replaceParentInfo(PSSysUtilDE pSSysUtilDE, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSSysUtilDE, cloneSession);
        if (pSSysUtilDE.getUtilPSDE10Id() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSSysUtilDE.getUtilPSDE10Id())) != null) {
            this.onFillParentInfo_UtilPSDE10(pSSysUtilDE, (PSDataEntity)iEntity);
        }
        if (pSSysUtilDE.getUtilPSDE11Id() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSSysUtilDE.getUtilPSDE11Id())) != null) {
            this.onFillParentInfo_UtilPSDE11(pSSysUtilDE, (PSDataEntity)iEntity);
        }
        if (pSSysUtilDE.getUtilPSDE12Id() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSSysUtilDE.getUtilPSDE12Id())) != null) {
            this.onFillParentInfo_UtilPSDE12(pSSysUtilDE, (PSDataEntity)iEntity);
        }
        if (pSSysUtilDE.getUtilPSDE13Id() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSSysUtilDE.getUtilPSDE13Id())) != null) {
            this.onFillParentInfo_UtilPSDE13(pSSysUtilDE, (PSDataEntity)iEntity);
        }
        if (pSSysUtilDE.getUtilPSDE14Id() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSSysUtilDE.getUtilPSDE14Id())) != null) {
            this.onFillParentInfo_UtilPSDE14(pSSysUtilDE, (PSDataEntity)iEntity);
        }
        if (pSSysUtilDE.getUtilPSDE15Id() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSSysUtilDE.getUtilPSDE15Id())) != null) {
            this.onFillParentInfo_UtilPSDE15(pSSysUtilDE, (PSDataEntity)iEntity);
        }
        if (pSSysUtilDE.getUtilPSDE16Id() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSSysUtilDE.getUtilPSDE16Id())) != null) {
            this.onFillParentInfo_UtilPSDE16(pSSysUtilDE, (PSDataEntity)iEntity);
        }
        if (pSSysUtilDE.getUtilPSDE17Id() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSSysUtilDE.getUtilPSDE17Id())) != null) {
            this.onFillParentInfo_UtilPSDE17(pSSysUtilDE, (PSDataEntity)iEntity);
        }
        if (pSSysUtilDE.getUtilPSDE18Id() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSSysUtilDE.getUtilPSDE18Id())) != null) {
            this.onFillParentInfo_UtilPSDE18(pSSysUtilDE, (PSDataEntity)iEntity);
        }
        if (pSSysUtilDE.getUtilPSDE19Id() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSSysUtilDE.getUtilPSDE19Id())) != null) {
            this.onFillParentInfo_UtilPSDE19(pSSysUtilDE, (PSDataEntity)iEntity);
        }
        if (pSSysUtilDE.getUtilPSDE20Id() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSSysUtilDE.getUtilPSDE20Id())) != null) {
            this.onFillParentInfo_UtilPSDE20(pSSysUtilDE, (PSDataEntity)iEntity);
        }
        if (pSSysUtilDE.getUtilPSDE2Id() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSSysUtilDE.getUtilPSDE2Id())) != null) {
            this.onFillParentInfo_UtilPSDE2(pSSysUtilDE, (PSDataEntity)iEntity);
        }
        if (pSSysUtilDE.getUtilPSDE3Id() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSSysUtilDE.getUtilPSDE3Id())) != null) {
            this.onFillParentInfo_UtilPSDE3(pSSysUtilDE, (PSDataEntity)iEntity);
        }
        if (pSSysUtilDE.getUtilPSDE4Id() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSSysUtilDE.getUtilPSDE4Id())) != null) {
            this.onFillParentInfo_UtilPSDE4(pSSysUtilDE, (PSDataEntity)iEntity);
        }
        if (pSSysUtilDE.getUtilPSDE5Id() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSSysUtilDE.getUtilPSDE5Id())) != null) {
            this.onFillParentInfo_UtilPSDE5(pSSysUtilDE, (PSDataEntity)iEntity);
        }
        if (pSSysUtilDE.getUtilPSDE6Id() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSSysUtilDE.getUtilPSDE6Id())) != null) {
            this.onFillParentInfo_UtilPSDE6(pSSysUtilDE, (PSDataEntity)iEntity);
        }
        if (pSSysUtilDE.getUtilPSDE7Id() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSSysUtilDE.getUtilPSDE7Id())) != null) {
            this.onFillParentInfo_UtilPSDE7(pSSysUtilDE, (PSDataEntity)iEntity);
        }
        if (pSSysUtilDE.getUtilPSDE8Id() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSSysUtilDE.getUtilPSDE8Id())) != null) {
            this.onFillParentInfo_UtilPSDE8(pSSysUtilDE, (PSDataEntity)iEntity);
        }
        if (pSSysUtilDE.getUtilPSDE9Id() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSSysUtilDE.getUtilPSDE9Id())) != null) {
            this.onFillParentInfo_UtilPSDE9(pSSysUtilDE, (PSDataEntity)iEntity);
        }
        if (pSSysUtilDE.getUtilPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSSysUtilDE.getUtilPSDEId())) != null) {
            this.onFillParentInfo_UtilPSDE(pSSysUtilDE, (PSDataEntity)iEntity);
        }
        if (pSSysUtilDE.getPSDEGroupId() != null && (iEntity = cloneSession.getEntity("PSDEGROUP", (Object)pSSysUtilDE.getPSDEGroupId())) != null) {
            this.onFillParentInfo_PSDEGroup(pSSysUtilDE, (PSDEGroup)iEntity);
        }
        if (pSSysUtilDE.getPSDERGroupId() != null && (iEntity = cloneSession.getEntity("PSDERGROUP", (Object)pSSysUtilDE.getPSDERGroupId())) != null) {
            this.onFillParentInfo_PSDERGroup(pSSysUtilDE, (PSDERGroup)iEntity);
        }
        if (pSSysUtilDE.getPSModuleId() != null && (iEntity = cloneSession.getEntity("PSMODULE", (Object)pSSysUtilDE.getPSModuleId())) != null) {
            this.onFillParentInfo_PSModule(pSSysUtilDE, (PSModule)iEntity);
        }
        if (pSSysUtilDE.getPSSubSysServiceAPIId() != null && (iEntity = cloneSession.getEntity("PSSUBSYSSERVICEAPI", (Object)pSSysUtilDE.getPSSubSysServiceAPIId())) != null) {
            this.onFillParentInfo_PSSubSysServiceAPI(pSSysUtilDE, (PSSubSysServiceAPI)iEntity);
        }
        if (pSSysUtilDE.getInPSSysDataSyncAgentId() != null && (iEntity = cloneSession.getEntity("PSSYSDATASYNCAGENT", (Object)pSSysUtilDE.getInPSSysDataSyncAgentId())) != null) {
            this.onFillParentInfo_InPSSysDataSyncAgent(pSSysUtilDE, (PSSysDataSyncAgent)iEntity);
        }
        if (pSSysUtilDE.getOutPSSysDataSyncAgentId() != null && (iEntity = cloneSession.getEntity("PSSYSDATASYNCAGENT", (Object)pSSysUtilDE.getOutPSSysDataSyncAgentId())) != null) {
            this.onFillParentInfo_OutPSSysDataSyncAgent(pSSysUtilDE, (PSSysDataSyncAgent)iEntity);
        }
        if (pSSysUtilDE.getPSSysDynaModelId() != null && (iEntity = cloneSession.getEntity("PSSYSDYNAMODEL", (Object)pSSysUtilDE.getPSSysDynaModelId())) != null) {
            this.onFillParentInfo_PSSysDynaModel(pSSysUtilDE, (PSSysDynaModel)iEntity);
        }
        if (pSSysUtilDE.getPSSysModelGroupId() != null && (iEntity = cloneSession.getEntity("PSSYSMODELGROUP", (Object)pSSysUtilDE.getPSSysModelGroupId())) != null) {
            this.onFillParentInfo_PSSysModelGroup(pSSysUtilDE, (PSSysModelGroup)iEntity);
        }
        if (pSSysUtilDE.getOutPSSysResourceId() != null && (iEntity = cloneSession.getEntity("PSSYSRESOURCE", (Object)pSSysUtilDE.getOutPSSysResourceId())) != null) {
            this.onFillParentInfo_OutPSSysResource(pSSysUtilDE, (PSSysResource)iEntity);
        }
        if (pSSysUtilDE.getPSSysResourceId() != null && (iEntity = cloneSession.getEntity("PSSYSRESOURCE", (Object)pSSysUtilDE.getPSSysResourceId())) != null) {
            this.onFillParentInfo_PSSysResource(pSSysUtilDE, (PSSysResource)iEntity);
        }
        if (pSSysUtilDE.getPSSysSFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSSFPLUGIN", (Object)pSSysUtilDE.getPSSysSFPluginId())) != null) {
            this.onFillParentInfo_PSSysSFPlugin(pSSysUtilDE, (PSSysSFPlugin)iEntity);
        }
        if (pSSysUtilDE.getPSSystemId() != null && (iEntity = cloneSession.getEntity("PSSYSTEM", (Object)pSSysUtilDE.getPSSystemId())) != null) {
            this.onFillParentInfo_PSSystem(pSSysUtilDE, (PSSystem)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysUtilDE pSSysUtilDE, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSSysUtilDE, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AuthAccessTokenUri(bl, pSSysUtilDE, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AuthClientId(bl, pSSysUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AuthClientSecret(bl, pSSysUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AuthMode(bl, pSSysUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AuthParam(bl, pSSysUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AuthParam2(bl, pSSysUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSSysUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomCode(bl, pSSysUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomMode(bl, pSSysUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_InPSSysDataSyncAgentId(bl, pSSysUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSSysUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OutPSSysDataSyncAgentId(bl, pSSysUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OutPSSysResourceId(bl, pSSysUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEGroupId(bl, pSSysUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDERGroupId(bl, pSSysUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModuleId(bl, pSSysUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSubSysServiceAPIId(bl, pSSysUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDynaModelId(bl, pSSysUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysModelGroupId(bl, pSSysUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysResourceId(bl, pSSysUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSFPluginId(bl, pSSysUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSSysUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemName(bl, pSSysUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysUtilDEId(bl, pSSysUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysUtilDEName(bl, pSSysUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ServiceParam(bl, pSSysUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ServiceParam2(bl, pSSysUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ServicePath(bl, pSSysUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UniqueTag(bl, pSSysUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSysUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSysUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSysUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilObj(bl, pSSysUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilParam(bl, pSSysUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilParam10(bl, pSSysUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilParam11(bl, pSSysUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilParam12(bl, pSSysUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilParam2(bl, pSSysUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilParam3(bl, pSSysUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilParam4(bl, pSSysUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilParam5(bl, pSSysUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilParam6(bl, pSSysUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilParam7(bl, pSSysUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilParam8(bl, pSSysUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilParam9(bl, pSSysUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilParams(bl, pSSysUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDE10Id(bl, pSSysUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDE10Name(bl, pSSysUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDE11Id(bl, pSSysUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDE11Name(bl, pSSysUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDE12Id(bl, pSSysUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDE12Name(bl, pSSysUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDE13Id(bl, pSSysUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDE13Name(bl, pSSysUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDE14Id(bl, pSSysUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDE14Name(bl, pSSysUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDE15Id(bl, pSSysUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDE15Name(bl, pSSysUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDE16Id(bl, pSSysUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDE16Name(bl, pSSysUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDE17Id(bl, pSSysUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDE17Name(bl, pSSysUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDE18Id(bl, pSSysUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDE18Name(bl, pSSysUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDE19Id(bl, pSSysUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDE19Name(bl, pSSysUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDE20Id(bl, pSSysUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDE20Name(bl, pSSysUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDE2Id(bl, pSSysUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDE2Name(bl, pSSysUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDE3Id(bl, pSSysUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDE3Name(bl, pSSysUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDE4Id(bl, pSSysUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDE4Name(bl, pSSysUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDE5Id(bl, pSSysUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDE5Name(bl, pSSysUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDE6Id(bl, pSSysUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDE6Name(bl, pSSysUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDE7Id(bl, pSSysUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDE7Name(bl, pSSysUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDE8Id(bl, pSSysUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDE8Name(bl, pSSysUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDE9Id(bl, pSSysUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDE9Name(bl, pSSysUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDEId(bl, pSSysUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDEName(bl, pSSysUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilTag(bl, pSSysUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilTag2(bl, pSSysUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilType(bl, pSSysUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSSysUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSSysUtilDE, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AuthAccessTokenUri(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUtilDE.isAuthAccessTokenUriDirty() : !pSSysUtilDE.isAuthAccessTokenUriDirty()) {
            return null;
        }
        String string = pSSysUtilDE.getAuthAccessTokenUri();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AuthAccessTokenUri_Default((IEntity)pSSysUtilDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AUTHACCESSTOKENURI");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AuthClientId(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUtilDE.isAuthClientIdDirty() : !pSSysUtilDE.isAuthClientIdDirty()) {
            return null;
        }
        String string = pSSysUtilDE.getAuthClientId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AuthClientId_Default((IEntity)pSSysUtilDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AUTHCLIENTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AuthClientSecret(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUtilDE.isAuthClientSecretDirty() : !pSSysUtilDE.isAuthClientSecretDirty()) {
            return null;
        }
        String string = pSSysUtilDE.getAuthClientSecret();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AuthClientSecret_Default((IEntity)pSSysUtilDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AUTHCLIENTSECRET");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AuthMode(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUtilDE.isAuthModeDirty() : !pSSysUtilDE.isAuthModeDirty()) {
            return null;
        }
        String string = pSSysUtilDE.getAuthMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AuthMode_Default((IEntity)pSSysUtilDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AUTHMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AuthParam(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUtilDE.isAuthParamDirty() : !pSSysUtilDE.isAuthParamDirty()) {
            return null;
        }
        String string = pSSysUtilDE.getAuthParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AuthParam_Default((IEntity)pSSysUtilDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AUTHPARAM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AuthParam2(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUtilDE.isAuthParam2Dirty() : !pSSysUtilDE.isAuthParam2Dirty()) {
            return null;
        }
        String string = pSSysUtilDE.getAuthParam2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AuthParam2_Default((IEntity)pSSysUtilDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AUTHPARAM2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUtilDE.isCodeNameDirty() : !pSSysUtilDE.isCodeNameDirty()) {
            return null;
        }
        String string = pSSysUtilDE.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default((IEntity)pSSysUtilDE, bl2, bl3);
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
                string3 = "PSSYSTEMID";
                string3 = string3 + ";";
                string3 = string3 + "PSMODULEID";
                String string4 = this.checkFieldDupRule(this.getPSSysUtilDEDEModel(), "CODENAME", string3, pSSysUtilDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_CustomCode(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUtilDE.isCustomCodeDirty() : !pSSysUtilDE.isCustomCodeDirty()) {
            return null;
        }
        String string = pSSysUtilDE.getCustomCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomCode_Default((IEntity)pSSysUtilDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_CustomMode(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUtilDE.isCustomModeDirty() : !pSSysUtilDE.isCustomModeDirty()) {
            return null;
        }
        Integer n = pSSysUtilDE.getCustomMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CustomMode_Default((IEntity)pSSysUtilDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_InPSSysDataSyncAgentId(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUtilDE.isInPSSysDataSyncAgentIdDirty() : !pSSysUtilDE.isInPSSysDataSyncAgentIdDirty()) {
            return null;
        }
        String string = pSSysUtilDE.getInPSSysDataSyncAgentId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_InPSSysDataSyncAgentId_Default((IEntity)pSSysUtilDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INPSSYSDATASYNCAGENTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUtilDE.isMemoDirty() : !pSSysUtilDE.isMemoDirty()) {
            return null;
        }
        String string = pSSysUtilDE.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSSysUtilDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUtilDE.isOrderValueDirty() : !pSSysUtilDE.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSSysUtilDE.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default((IEntity)pSSysUtilDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_OutPSSysDataSyncAgentId(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUtilDE.isOutPSSysDataSyncAgentIdDirty() : !pSSysUtilDE.isOutPSSysDataSyncAgentIdDirty()) {
            return null;
        }
        String string = pSSysUtilDE.getOutPSSysDataSyncAgentId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_OutPSSysDataSyncAgentId_Default((IEntity)pSSysUtilDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("OUTPSSYSDATASYNCAGENTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OutPSSysResourceId(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUtilDE.isOutPSSysResourceIdDirty() : !pSSysUtilDE.isOutPSSysResourceIdDirty()) {
            return null;
        }
        String string = pSSysUtilDE.getOutPSSysResourceId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_OutPSSysResourceId_Default((IEntity)pSSysUtilDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("OUTPSSYSRESOURCEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEGroupId(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUtilDE.isPSDEGroupIdDirty() : !pSSysUtilDE.isPSDEGroupIdDirty()) {
            return null;
        }
        String string = pSSysUtilDE.getPSDEGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEGroupId_Default((IEntity)pSSysUtilDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEGROUPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDERGroupId(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUtilDE.isPSDERGroupIdDirty() : !pSSysUtilDE.isPSDERGroupIdDirty()) {
            return null;
        }
        String string = pSSysUtilDE.getPSDERGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDERGroupId_Default((IEntity)pSSysUtilDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDERGROUPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSModuleId(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUtilDE.isPSModuleIdDirty() : !pSSysUtilDE.isPSModuleIdDirty()) {
            return null;
        }
        String string = pSSysUtilDE.getPSModuleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModuleId_Default((IEntity)pSSysUtilDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODULEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSubSysServiceAPIId(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUtilDE.isPSSubSysServiceAPIIdDirty() : !pSSysUtilDE.isPSSubSysServiceAPIIdDirty()) {
            return null;
        }
        String string = pSSysUtilDE.getPSSubSysServiceAPIId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSubSysServiceAPIId_Default((IEntity)pSSysUtilDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSUBSYSSERVICEAPIID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysDynaModelId(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUtilDE.isPSSysDynaModelIdDirty() : !pSSysUtilDE.isPSSysDynaModelIdDirty()) {
            return null;
        }
        String string = pSSysUtilDE.getPSSysDynaModelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDynaModelId_Default((IEntity)pSSysUtilDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysModelGroupId(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUtilDE.isPSSysModelGroupIdDirty() : !pSSysUtilDE.isPSSysModelGroupIdDirty()) {
            return null;
        }
        String string = pSSysUtilDE.getPSSysModelGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysModelGroupId_Default((IEntity)pSSysUtilDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSMODELGROUPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysResourceId(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUtilDE.isPSSysResourceIdDirty() : !pSSysUtilDE.isPSSysResourceIdDirty()) {
            return null;
        }
        String string = pSSysUtilDE.getPSSysResourceId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysResourceId_Default((IEntity)pSSysUtilDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSRESOURCEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysSFPluginId(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUtilDE.isPSSysSFPluginIdDirty() : !pSSysUtilDE.isPSSysSFPluginIdDirty()) {
            return null;
        }
        String string = pSSysUtilDE.getPSSysSFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSFPluginId_Default((IEntity)pSSysUtilDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUtilDE.isPSSystemIdDirty() && !bl2 : !pSSysUtilDE.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSSysUtilDE.getPSSystemId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default((IEntity)pSSysUtilDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemName(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUtilDE.isPSSystemNameDirty() && !bl2 : !pSSysUtilDE.isPSSystemNameDirty()) {
            return null;
        }
        String string = pSSysUtilDE.getPSSystemName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemName_Default((IEntity)pSSysUtilDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysUtilDEId(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUtilDE.isPSSysUtilDEIdDirty() && !bl2 : !pSSysUtilDE.isPSSysUtilDEIdDirty()) {
            return null;
        }
        String string = pSSysUtilDE.getPSSysUtilDEId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSUTILDEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysUtilDEId_Default((IEntity)pSSysUtilDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSUTILDEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysUtilDEName(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUtilDE.isPSSysUtilDENameDirty() && !bl2 : !pSSysUtilDE.isPSSysUtilDENameDirty()) {
            return null;
        }
        String string = pSSysUtilDE.getPSSysUtilDEName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSUTILDENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysUtilDEName_Default((IEntity)pSSysUtilDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSUTILDENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ServiceParam(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUtilDE.isServiceParamDirty() : !pSSysUtilDE.isServiceParamDirty()) {
            return null;
        }
        String string = pSSysUtilDE.getServiceParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ServiceParam_Default((IEntity)pSSysUtilDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SERVICEPARAM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ServiceParam2(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUtilDE.isServiceParam2Dirty() : !pSSysUtilDE.isServiceParam2Dirty()) {
            return null;
        }
        String string = pSSysUtilDE.getServiceParam2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ServiceParam2_Default((IEntity)pSSysUtilDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SERVICEPARAM2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ServicePath(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUtilDE.isServicePathDirty() : !pSSysUtilDE.isServicePathDirty()) {
            return null;
        }
        String string = pSSysUtilDE.getServicePath();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ServicePath_Default((IEntity)pSSysUtilDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SERVICEPATH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UniqueTag(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUtilDE.isUniqueTagDirty() : !pSSysUtilDE.isUniqueTagDirty()) {
            return null;
        }
        String string = pSSysUtilDE.getUniqueTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UniqueTag_Default((IEntity)pSSysUtilDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UNIQUETAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUtilDE.isUserCatDirty() : !pSSysUtilDE.isUserCatDirty()) {
            return null;
        }
        String string = pSSysUtilDE.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default((IEntity)pSSysUtilDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUtilDE.isUserTagDirty() : !pSSysUtilDE.isUserTagDirty()) {
            return null;
        }
        String string = pSSysUtilDE.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSSysUtilDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUtilDE.isUserTag2Dirty() : !pSSysUtilDE.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysUtilDE.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSSysUtilDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUtilDE.isUserTag3Dirty() : !pSSysUtilDE.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSysUtilDE.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default((IEntity)pSSysUtilDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUtilDE.isUserTag4Dirty() : !pSSysUtilDE.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSysUtilDE.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default((IEntity)pSSysUtilDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_UtilObj(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUtilDE.isUtilObjDirty() : !pSSysUtilDE.isUtilObjDirty()) {
            return null;
        }
        String string = pSSysUtilDE.getUtilObj();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilObj_Default((IEntity)pSSysUtilDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILOBJ");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilParam(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUtilDE.isUtilParamDirty() : !pSSysUtilDE.isUtilParamDirty()) {
            return null;
        }
        String string = pSSysUtilDE.getUtilParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilParam_Default((IEntity)pSSysUtilDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILPARAM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilParam10(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUtilDE.isUtilParam10Dirty() : !pSSysUtilDE.isUtilParam10Dirty()) {
            return null;
        }
        Integer n = pSSysUtilDE.getUtilParam10();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_UtilParam10_Default((IEntity)pSSysUtilDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILPARAM10");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilParam11(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUtilDE.isUtilParam11Dirty() : !pSSysUtilDE.isUtilParam11Dirty()) {
            return null;
        }
        String string = pSSysUtilDE.getUtilParam11();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilParam11_Default((IEntity)pSSysUtilDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILPARAM11");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilParam12(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUtilDE.isUtilParam12Dirty() : !pSSysUtilDE.isUtilParam12Dirty()) {
            return null;
        }
        String string = pSSysUtilDE.getUtilParam12();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilParam12_Default((IEntity)pSSysUtilDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILPARAM12");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilParam2(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUtilDE.isUtilParam2Dirty() : !pSSysUtilDE.isUtilParam2Dirty()) {
            return null;
        }
        String string = pSSysUtilDE.getUtilParam2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilParam2_Default((IEntity)pSSysUtilDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILPARAM2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilParam3(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUtilDE.isUtilParam3Dirty() : !pSSysUtilDE.isUtilParam3Dirty()) {
            return null;
        }
        String string = pSSysUtilDE.getUtilParam3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilParam3_Default((IEntity)pSSysUtilDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILPARAM3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilParam4(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUtilDE.isUtilParam4Dirty() : !pSSysUtilDE.isUtilParam4Dirty()) {
            return null;
        }
        String string = pSSysUtilDE.getUtilParam4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilParam4_Default((IEntity)pSSysUtilDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILPARAM4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilParam5(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUtilDE.isUtilParam5Dirty() : !pSSysUtilDE.isUtilParam5Dirty()) {
            return null;
        }
        Integer n = pSSysUtilDE.getUtilParam5();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_UtilParam5_Default((IEntity)pSSysUtilDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILPARAM5");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilParam6(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUtilDE.isUtilParam6Dirty() : !pSSysUtilDE.isUtilParam6Dirty()) {
            return null;
        }
        Integer n = pSSysUtilDE.getUtilParam6();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_UtilParam6_Default((IEntity)pSSysUtilDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILPARAM6");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilParam7(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUtilDE.isUtilParam7Dirty() : !pSSysUtilDE.isUtilParam7Dirty()) {
            return null;
        }
        Integer n = pSSysUtilDE.getUtilParam7();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_UtilParam7_Default((IEntity)pSSysUtilDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILPARAM7");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilParam8(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUtilDE.isUtilParam8Dirty() : !pSSysUtilDE.isUtilParam8Dirty()) {
            return null;
        }
        Integer n = pSSysUtilDE.getUtilParam8();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_UtilParam8_Default((IEntity)pSSysUtilDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILPARAM8");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilParam9(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUtilDE.isUtilParam9Dirty() : !pSSysUtilDE.isUtilParam9Dirty()) {
            return null;
        }
        Integer n = pSSysUtilDE.getUtilParam9();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_UtilParam9_Default((IEntity)pSSysUtilDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILPARAM9");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilParams(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUtilDE.isUtilParamsDirty() : !pSSysUtilDE.isUtilParamsDirty()) {
            return null;
        }
        String string = pSSysUtilDE.getUtilParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilParams_Default((IEntity)pSSysUtilDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilPSDE10Id(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUtilDE.isUtilPSDE10IdDirty() : !pSSysUtilDE.isUtilPSDE10IdDirty()) {
            return null;
        }
        String string = pSSysUtilDE.getUtilPSDE10Id();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDE10Id_Default((IEntity)pSSysUtilDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILPSDE10ID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilPSDE10Name(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUtilDE.isUtilPSDE10NameDirty() : !pSSysUtilDE.isUtilPSDE10NameDirty()) {
            return null;
        }
        String string = pSSysUtilDE.getUtilPSDE10Name();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDE10Name_Default((IEntity)pSSysUtilDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILPSDE10NAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilPSDE11Id(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUtilDE.isUtilPSDE11IdDirty() : !pSSysUtilDE.isUtilPSDE11IdDirty()) {
            return null;
        }
        String string = pSSysUtilDE.getUtilPSDE11Id();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDE11Id_Default((IEntity)pSSysUtilDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILPSDE11ID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilPSDE11Name(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUtilDE.isUtilPSDE11NameDirty() : !pSSysUtilDE.isUtilPSDE11NameDirty()) {
            return null;
        }
        String string = pSSysUtilDE.getUtilPSDE11Name();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDE11Name_Default((IEntity)pSSysUtilDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILPSDE11NAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilPSDE12Id(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUtilDE.isUtilPSDE12IdDirty() : !pSSysUtilDE.isUtilPSDE12IdDirty()) {
            return null;
        }
        String string = pSSysUtilDE.getUtilPSDE12Id();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDE12Id_Default((IEntity)pSSysUtilDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILPSDE12ID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilPSDE12Name(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUtilDE.isUtilPSDE12NameDirty() : !pSSysUtilDE.isUtilPSDE12NameDirty()) {
            return null;
        }
        String string = pSSysUtilDE.getUtilPSDE12Name();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDE12Name_Default((IEntity)pSSysUtilDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILPSDE12NAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilPSDE13Id(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUtilDE.isUtilPSDE13IdDirty() : !pSSysUtilDE.isUtilPSDE13IdDirty()) {
            return null;
        }
        String string = pSSysUtilDE.getUtilPSDE13Id();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDE13Id_Default((IEntity)pSSysUtilDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILPSDE13ID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilPSDE13Name(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUtilDE.isUtilPSDE13NameDirty() : !pSSysUtilDE.isUtilPSDE13NameDirty()) {
            return null;
        }
        String string = pSSysUtilDE.getUtilPSDE13Name();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDE13Name_Default((IEntity)pSSysUtilDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILPSDE13NAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilPSDE14Id(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUtilDE.isUtilPSDE14IdDirty() : !pSSysUtilDE.isUtilPSDE14IdDirty()) {
            return null;
        }
        String string = pSSysUtilDE.getUtilPSDE14Id();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDE14Id_Default((IEntity)pSSysUtilDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILPSDE14ID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilPSDE14Name(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUtilDE.isUtilPSDE14NameDirty() : !pSSysUtilDE.isUtilPSDE14NameDirty()) {
            return null;
        }
        String string = pSSysUtilDE.getUtilPSDE14Name();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDE14Name_Default((IEntity)pSSysUtilDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILPSDE14NAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilPSDE15Id(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUtilDE.isUtilPSDE15IdDirty() : !pSSysUtilDE.isUtilPSDE15IdDirty()) {
            return null;
        }
        String string = pSSysUtilDE.getUtilPSDE15Id();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDE15Id_Default((IEntity)pSSysUtilDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILPSDE15ID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilPSDE15Name(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUtilDE.isUtilPSDE15NameDirty() : !pSSysUtilDE.isUtilPSDE15NameDirty()) {
            return null;
        }
        String string = pSSysUtilDE.getUtilPSDE15Name();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDE15Name_Default((IEntity)pSSysUtilDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILPSDE15NAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilPSDE16Id(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUtilDE.isUtilPSDE16IdDirty() : !pSSysUtilDE.isUtilPSDE16IdDirty()) {
            return null;
        }
        String string = pSSysUtilDE.getUtilPSDE16Id();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDE16Id_Default((IEntity)pSSysUtilDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILPSDE16ID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilPSDE16Name(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUtilDE.isUtilPSDE16NameDirty() : !pSSysUtilDE.isUtilPSDE16NameDirty()) {
            return null;
        }
        String string = pSSysUtilDE.getUtilPSDE16Name();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDE16Name_Default((IEntity)pSSysUtilDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILPSDE16NAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilPSDE17Id(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUtilDE.isUtilPSDE17IdDirty() : !pSSysUtilDE.isUtilPSDE17IdDirty()) {
            return null;
        }
        String string = pSSysUtilDE.getUtilPSDE17Id();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDE17Id_Default((IEntity)pSSysUtilDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILPSDE17ID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilPSDE17Name(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUtilDE.isUtilPSDE17NameDirty() : !pSSysUtilDE.isUtilPSDE17NameDirty()) {
            return null;
        }
        String string = pSSysUtilDE.getUtilPSDE17Name();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDE17Name_Default((IEntity)pSSysUtilDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILPSDE17NAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilPSDE18Id(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUtilDE.isUtilPSDE18IdDirty() : !pSSysUtilDE.isUtilPSDE18IdDirty()) {
            return null;
        }
        String string = pSSysUtilDE.getUtilPSDE18Id();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDE18Id_Default((IEntity)pSSysUtilDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILPSDE18ID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilPSDE18Name(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUtilDE.isUtilPSDE18NameDirty() : !pSSysUtilDE.isUtilPSDE18NameDirty()) {
            return null;
        }
        String string = pSSysUtilDE.getUtilPSDE18Name();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDE18Name_Default((IEntity)pSSysUtilDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILPSDE18NAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilPSDE19Id(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUtilDE.isUtilPSDE19IdDirty() : !pSSysUtilDE.isUtilPSDE19IdDirty()) {
            return null;
        }
        String string = pSSysUtilDE.getUtilPSDE19Id();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDE19Id_Default((IEntity)pSSysUtilDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILPSDE19ID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilPSDE19Name(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUtilDE.isUtilPSDE19NameDirty() : !pSSysUtilDE.isUtilPSDE19NameDirty()) {
            return null;
        }
        String string = pSSysUtilDE.getUtilPSDE19Name();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDE19Name_Default((IEntity)pSSysUtilDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILPSDE19NAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilPSDE20Id(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUtilDE.isUtilPSDE20IdDirty() : !pSSysUtilDE.isUtilPSDE20IdDirty()) {
            return null;
        }
        String string = pSSysUtilDE.getUtilPSDE20Id();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDE20Id_Default((IEntity)pSSysUtilDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILPSDE20ID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilPSDE20Name(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUtilDE.isUtilPSDE20NameDirty() : !pSSysUtilDE.isUtilPSDE20NameDirty()) {
            return null;
        }
        String string = pSSysUtilDE.getUtilPSDE20Name();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDE20Name_Default((IEntity)pSSysUtilDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILPSDE20NAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilPSDE2Id(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUtilDE.isUtilPSDE2IdDirty() : !pSSysUtilDE.isUtilPSDE2IdDirty()) {
            return null;
        }
        String string = pSSysUtilDE.getUtilPSDE2Id();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDE2Id_Default((IEntity)pSSysUtilDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILPSDE2ID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilPSDE2Name(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUtilDE.isUtilPSDE2NameDirty() : !pSSysUtilDE.isUtilPSDE2NameDirty()) {
            return null;
        }
        String string = pSSysUtilDE.getUtilPSDE2Name();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDE2Name_Default((IEntity)pSSysUtilDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILPSDE2NAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilPSDE3Id(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUtilDE.isUtilPSDE3IdDirty() : !pSSysUtilDE.isUtilPSDE3IdDirty()) {
            return null;
        }
        String string = pSSysUtilDE.getUtilPSDE3Id();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDE3Id_Default((IEntity)pSSysUtilDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILPSDE3ID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilPSDE3Name(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUtilDE.isUtilPSDE3NameDirty() : !pSSysUtilDE.isUtilPSDE3NameDirty()) {
            return null;
        }
        String string = pSSysUtilDE.getUtilPSDE3Name();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDE3Name_Default((IEntity)pSSysUtilDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILPSDE3NAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilPSDE4Id(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUtilDE.isUtilPSDE4IdDirty() : !pSSysUtilDE.isUtilPSDE4IdDirty()) {
            return null;
        }
        String string = pSSysUtilDE.getUtilPSDE4Id();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDE4Id_Default((IEntity)pSSysUtilDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILPSDE4ID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilPSDE4Name(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUtilDE.isUtilPSDE4NameDirty() : !pSSysUtilDE.isUtilPSDE4NameDirty()) {
            return null;
        }
        String string = pSSysUtilDE.getUtilPSDE4Name();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDE4Name_Default((IEntity)pSSysUtilDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILPSDE4NAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilPSDE5Id(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUtilDE.isUtilPSDE5IdDirty() : !pSSysUtilDE.isUtilPSDE5IdDirty()) {
            return null;
        }
        String string = pSSysUtilDE.getUtilPSDE5Id();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDE5Id_Default((IEntity)pSSysUtilDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILPSDE5ID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilPSDE5Name(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUtilDE.isUtilPSDE5NameDirty() : !pSSysUtilDE.isUtilPSDE5NameDirty()) {
            return null;
        }
        String string = pSSysUtilDE.getUtilPSDE5Name();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDE5Name_Default((IEntity)pSSysUtilDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILPSDE5NAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilPSDE6Id(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUtilDE.isUtilPSDE6IdDirty() : !pSSysUtilDE.isUtilPSDE6IdDirty()) {
            return null;
        }
        String string = pSSysUtilDE.getUtilPSDE6Id();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDE6Id_Default((IEntity)pSSysUtilDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILPSDE6ID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilPSDE6Name(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUtilDE.isUtilPSDE6NameDirty() : !pSSysUtilDE.isUtilPSDE6NameDirty()) {
            return null;
        }
        String string = pSSysUtilDE.getUtilPSDE6Name();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDE6Name_Default((IEntity)pSSysUtilDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILPSDE6NAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilPSDE7Id(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUtilDE.isUtilPSDE7IdDirty() : !pSSysUtilDE.isUtilPSDE7IdDirty()) {
            return null;
        }
        String string = pSSysUtilDE.getUtilPSDE7Id();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDE7Id_Default((IEntity)pSSysUtilDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILPSDE7ID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilPSDE7Name(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUtilDE.isUtilPSDE7NameDirty() : !pSSysUtilDE.isUtilPSDE7NameDirty()) {
            return null;
        }
        String string = pSSysUtilDE.getUtilPSDE7Name();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDE7Name_Default((IEntity)pSSysUtilDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILPSDE7NAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilPSDE8Id(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUtilDE.isUtilPSDE8IdDirty() : !pSSysUtilDE.isUtilPSDE8IdDirty()) {
            return null;
        }
        String string = pSSysUtilDE.getUtilPSDE8Id();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDE8Id_Default((IEntity)pSSysUtilDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILPSDE8ID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilPSDE8Name(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUtilDE.isUtilPSDE8NameDirty() : !pSSysUtilDE.isUtilPSDE8NameDirty()) {
            return null;
        }
        String string = pSSysUtilDE.getUtilPSDE8Name();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDE8Name_Default((IEntity)pSSysUtilDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILPSDE8NAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilPSDE9Id(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUtilDE.isUtilPSDE9IdDirty() : !pSSysUtilDE.isUtilPSDE9IdDirty()) {
            return null;
        }
        String string = pSSysUtilDE.getUtilPSDE9Id();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDE9Id_Default((IEntity)pSSysUtilDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILPSDE9ID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilPSDE9Name(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUtilDE.isUtilPSDE9NameDirty() : !pSSysUtilDE.isUtilPSDE9NameDirty()) {
            return null;
        }
        String string = pSSysUtilDE.getUtilPSDE9Name();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDE9Name_Default((IEntity)pSSysUtilDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILPSDE9NAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilPSDEId(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUtilDE.isUtilPSDEIdDirty() : !pSSysUtilDE.isUtilPSDEIdDirty()) {
            return null;
        }
        String string = pSSysUtilDE.getUtilPSDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDEId_Default((IEntity)pSSysUtilDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILPSDEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilPSDEName(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUtilDE.isUtilPSDENameDirty() : !pSSysUtilDE.isUtilPSDENameDirty()) {
            return null;
        }
        String string = pSSysUtilDE.getUtilPSDEName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDEName_Default((IEntity)pSSysUtilDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILPSDENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilTag(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUtilDE.isUtilTagDirty() : !pSSysUtilDE.isUtilTagDirty()) {
            return null;
        }
        String string = pSSysUtilDE.getUtilTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilTag_Default((IEntity)pSSysUtilDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilTag2(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUtilDE.isUtilTag2Dirty() : !pSSysUtilDE.isUtilTag2Dirty()) {
            return null;
        }
        String string = pSSysUtilDE.getUtilTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilTag2_Default((IEntity)pSSysUtilDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilType(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUtilDE.isUtilTypeDirty() && !bl2 : !pSSysUtilDE.isUtilTypeDirty()) {
            return null;
        }
        String string = pSSysUtilDE.getUtilType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilType_Default((IEntity)pSSysUtilDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSSysUtilDE pSSysUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUtilDE.isValidFlagDirty() && !bl2 : !pSSysUtilDE.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSSysUtilDE.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSSysUtilDE, bl2, bl3);
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

    protected void onSyncEntity(PSSysUtilDE pSSysUtilDE, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSSysUtilDE, bl);
    }

    protected void onSyncIndexEntities(PSSysUtilDE pSSysUtilDE, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSSysUtilDE, bl);
    }

    public Object getDataContextValue(PSSysUtilDE pSSysUtilDE, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSSysUtilDE, string, iDataContextParam)) != null) {
            return object;
        }
        PSModule pSModule = pSSysUtilDE.getPSModule();
        if (pSModule != null && pSModule.contains(string)) {
            return pSModule.get(string);
        }
        PSSystem pSSystem = pSSysUtilDE.getPSSystem();
        if (pSSystem != null && pSSystem.contains(string)) {
            return pSSystem.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSysUtilDE pSSysUtilDE, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSSysUtilDE, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"AUTHACCESSTOKENURI", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AuthAccessTokenUri_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AUTHCLIENTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AuthClientId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AUTHCLIENTSECRET", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AuthClientSecret_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AUTHMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AuthMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AUTHPARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AuthParam_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AUTHPARAM2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AuthParam2_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"INPSSYSDATASYNCAGENTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_InPSSysDataSyncAgentId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INPSSYSDATASYNCAGENTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_InPSSysDataSyncAgentName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OUTPSSYSDATASYNCAGENTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OutPSSysDataSyncAgentId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OUTPSSYSDATASYNCAGENTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OutPSSysDataSyncAgentName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OUTPSSYSRESOURCEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OutPSSysResourceId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OUTPSSYSRESOURCENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OutPSSysResourceName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEGroupName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDERGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDERGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDERGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDERGroupName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODULEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModuleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODULENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModuleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSUBSYSSERVICEAPIID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSubSysServiceAPIId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSUBSYSSERVICEAPINAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSubSysServiceAPIName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDYNAMODELID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDynaModelId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDYNAMODELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDynaModelName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSMODELGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysModelGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSMODELGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysModelGroupName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSRESOURCEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysResourceId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSRESOURCENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysResourceName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSFPLUGINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSFPluginId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSFPLUGINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSFPluginName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSUTILDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysUtilDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSUTILDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysUtilDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SERVICEPARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ServiceParam_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SERVICEPARAM2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ServiceParam2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SERVICEPATH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ServicePath_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UNIQUETAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UniqueTag_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"UTILOBJ", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilObj_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILPARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilParam_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILPARAM10", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilParam10_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILPARAM11", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilParam11_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILPARAM12", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilParam12_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILPARAM2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilParam2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILPARAM3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilParam3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILPARAM4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilParam4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILPARAM5", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilParam5_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILPARAM6", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilParam6_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILPARAM7", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilParam7_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILPARAM8", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilParam8_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILPARAM9", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilParam9_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILPSDE10ID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilPSDE10Id_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILPSDE10NAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilPSDE10Name_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILPSDE11ID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilPSDE11Id_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILPSDE11NAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilPSDE11Name_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILPSDE12ID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilPSDE12Id_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILPSDE12NAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilPSDE12Name_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILPSDE13ID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilPSDE13Id_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILPSDE13NAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilPSDE13Name_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILPSDE14ID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilPSDE14Id_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILPSDE14NAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilPSDE14Name_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILPSDE15ID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilPSDE15Id_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILPSDE15NAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilPSDE15Name_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILPSDE16ID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilPSDE16Id_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILPSDE16NAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilPSDE16Name_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILPSDE17ID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilPSDE17Id_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILPSDE17NAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilPSDE17Name_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILPSDE18ID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilPSDE18Id_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILPSDE18NAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilPSDE18Name_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILPSDE19ID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilPSDE19Id_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILPSDE19NAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilPSDE19Name_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILPSDE20ID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilPSDE20Id_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILPSDE20NAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilPSDE20Name_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILPSDE2ID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilPSDE2Id_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILPSDE2NAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilPSDE2Name_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILPSDE3ID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilPSDE3Id_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILPSDE3NAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilPSDE3Name_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILPSDE4ID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilPSDE4Id_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILPSDE4NAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilPSDE4Name_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILPSDE5ID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilPSDE5Id_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILPSDE5NAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilPSDE5Name_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILPSDE6ID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilPSDE6Id_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILPSDE6NAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilPSDE6Name_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILPSDE7ID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilPSDE7Id_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILPSDE7NAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilPSDE7Name_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILPSDE8ID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilPSDE8Id_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILPSDE8NAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilPSDE8Name_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILPSDE9ID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilPSDE9Id_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILPSDE9NAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilPSDE9Name_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILPSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilPSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILPSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilPSDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALIDFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValidFlag_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_AuthAccessTokenUri_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AUTHACCESSTOKENURI", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AuthClientId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AUTHCLIENTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AuthClientSecret_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AUTHCLIENTSECRET", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AuthMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AUTHMODE", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AuthParam_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AUTHPARAM", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AuthParam2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AUTHPARAM2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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
            if (this.checkFieldStringLengthRule("CODENAME", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false) && this.checkFieldRegExRule("CODENAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
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

    protected String onTestValueRule_InPSSysDataSyncAgentId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("INPSSYSDATASYNCAGENTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_InPSSysDataSyncAgentName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("INPSSYSDATASYNCAGENTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_OutPSSysDataSyncAgentId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("OUTPSSYSDATASYNCAGENTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OutPSSysDataSyncAgentName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("OUTPSSYSDATASYNCAGENTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OutPSSysResourceId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("OUTPSSYSRESOURCEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OutPSSysResourceName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("OUTPSSYSRESOURCENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEGroupId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEGROUPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEGroupName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEGROUPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDERGroupId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDERGROUPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDERGroupName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDERGROUPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSModuleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODULEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSModuleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODULENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSubSysServiceAPIId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSUBSYSSERVICEAPIID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSubSysServiceAPIName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSUBSYSSERVICEAPINAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSysModelGroupId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSMODELGROUPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysModelGroupName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSMODELGROUPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysResourceId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSRESOURCEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysResourceName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSRESOURCENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSysUtilDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSUTILDEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysUtilDEName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSUTILDENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ServiceParam_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SERVICEPARAM", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ServiceParam2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SERVICEPARAM2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ServicePath_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SERVICEPATH", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UniqueTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UNIQUETAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
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

    protected String onTestValueRule_UtilObj_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTILOBJ", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UtilParam_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTILPARAM", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UtilParam10_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_UtilParam11_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTILPARAM11", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UtilParam12_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTILPARAM12", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UtilParam2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTILPARAM2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UtilParam3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTILPARAM3", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UtilParam4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTILPARAM4", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UtilParam5_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_UtilParam6_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_UtilParam7_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_UtilParam8_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_UtilParam9_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_UtilParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTILPARAMS", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UtilPSDE10Id_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTILPSDE10ID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UtilPSDE10Name_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTILPSDE10NAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UtilPSDE11Id_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTILPSDE11ID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UtilPSDE11Name_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTILPSDE11NAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UtilPSDE12Id_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTILPSDE12ID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UtilPSDE12Name_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTILPSDE12NAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UtilPSDE13Id_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTILPSDE13ID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UtilPSDE13Name_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTILPSDE13NAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UtilPSDE14Id_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTILPSDE14ID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UtilPSDE14Name_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTILPSDE14NAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UtilPSDE15Id_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTILPSDE15ID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UtilPSDE15Name_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTILPSDE15NAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UtilPSDE16Id_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTILPSDE16ID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UtilPSDE16Name_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTILPSDE16NAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UtilPSDE17Id_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTILPSDE17ID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UtilPSDE17Name_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTILPSDE17NAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UtilPSDE18Id_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTILPSDE18ID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UtilPSDE18Name_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTILPSDE18NAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UtilPSDE19Id_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTILPSDE19ID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UtilPSDE19Name_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTILPSDE19NAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UtilPSDE20Id_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTILPSDE20ID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UtilPSDE20Name_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTILPSDE20NAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UtilPSDE2Id_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTILPSDE2ID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UtilPSDE2Name_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTILPSDE2NAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UtilPSDE3Id_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTILPSDE3ID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UtilPSDE3Name_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTILPSDE3NAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UtilPSDE4Id_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTILPSDE4ID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UtilPSDE4Name_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTILPSDE4NAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UtilPSDE5Id_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTILPSDE5ID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UtilPSDE5Name_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTILPSDE5NAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UtilPSDE6Id_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTILPSDE6ID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UtilPSDE6Name_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTILPSDE6NAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UtilPSDE7Id_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTILPSDE7ID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UtilPSDE7Name_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTILPSDE7NAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UtilPSDE8Id_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTILPSDE8ID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UtilPSDE8Name_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTILPSDE8NAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UtilPSDE9Id_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTILPSDE9ID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UtilPSDE9Name_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTILPSDE9NAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UtilPSDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTILPSDEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UtilPSDEName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTILPSDENAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UtilTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTILTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UtilTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTILTAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UtilType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTILTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
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

    protected boolean onMergeChild(String string, String string2, PSSysUtilDE pSSysUtilDE) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSSysUtilDE)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysUtilDE pSSysUtilDE) throws Exception {
        super.onUpdateParent((IEntity)pSSysUtilDE);
    }

    @Override
    protected void exportCurXmlModel(PSSysUtilDE pSSysUtilDE, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSUTILDE");
        if (!bl) {
            pSSysUtilDE.setCreateDate(null);
            pSSysUtilDE.setCreateMan(null);
            pSSysUtilDE.setPSSysDynaModelName(null);
            pSSysUtilDE.setPSSysUtilDEId(null);
            pSSysUtilDE.setUniqueTag(null);
            pSSysUtilDE.setUpdateDate(null);
            pSSysUtilDE.setUpdateMan(null);
            super.exportCurXmlModel(pSSysUtilDE, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysUtilDE pSSysUtilDE, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysUtilDE, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSMODULEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSMODULE#%1$s", (Object)string);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSMODELGROUPID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSMODELGROUP#%1$s", (Object)string);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSTEM#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSMODULEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSUTILDE_PSMODULE_PSMODULEID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSMODELGROUPID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSUTILDE_PSSYSMODELGROUP_PSSYSMODELGROUPID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSUTILDE_PSSYSTEM_PSSYSTEMID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSMODULEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSMODULENAME", null);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSMODELGROUPID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSMODELGROUPNAME", null);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSMODULE", (boolean)true) == 0) {
            iEntity.set("PSMODULEID", (Object)string2);
            return true;
        }
        if (StringHelper.compare((String)string, (String)"PSSYSMODELGROUP", (boolean)true) == 0) {
            iEntity.set("PSSYSMODELGROUPID", (Object)string2);
            return true;
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEM", (boolean)true) == 0) {
            iEntity.set("PSSYSTEMID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSMODULEID", "PSSYSMODELGROUPID", "PSSYSTEMID"};
    }

    @Override
    public String getModelV2Tag(PSSysUtilDE pSSysUtilDE) {
        if (!StringHelper.isNullOrEmpty((String)pSSysUtilDE.getCodeName())) {
            return pSSysUtilDE.getCodeName();
        }
        return super.getModelV2Tag(pSSysUtilDE);
    }

    @Override
    public boolean setModelV2Tag(PSSysUtilDE pSSysUtilDE, String string) {
        pSSysUtilDE.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("CODENAME", "");
        map.put("PSMODULEID", "");
        map.put("PSSYSMODELGROUPID", "");
        map.put("PSSYSTEMID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysUtilDE pSSysUtilDE, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysUtilDE.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysUtilDE, true);
        pSSysUtilDE.set("CODENAME", string);
        if (this.select(pSSysUtilDE, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysUtilDE, true);
        return super.getModelV2Entity(pSSysUtilDE, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysUtilDE pSSysUtilDE, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSSysUtilDE, objectNode, string, string2, n);
    }

    @Override
    public Object getDataType(PSSysUtilDE pSSysUtilDE) throws Exception {
        return pSSysUtilDE.getUtilType();
    }

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSSysUtilDE pSSysUtilDE, boolean bl) {
        return defaultValueMap;
    }

    static {
        defaultValueMap.put("CODENAME", "SysUtil");
    }
}

