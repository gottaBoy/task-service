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
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFieldBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDENotifyService;
import net.ibizsys.pscore.srv.sysdesign.dao.PSSysMsgQueueDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysMsgQueueDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModuleBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysMsgQueue;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPluginBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUtilDE;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUtilDEBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysMsgQueueServiceBase
extends PSCoreSysServiceBase<PSSysMsgQueue> {
    private static final Log log = LogFactory.getLog(PSSysMsgQueueServiceBase.class);
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private static Map<String, String> defaultValueMap = new HashMap<String, String>();
    private PSSysMsgQueueDEModel pSSysMsgQueueDEModel;
    private PSSysMsgQueueDAO pSSysMsgQueueDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSSysMsgQueueService";
    }

    public PSSysMsgQueueDEModel getPSSysMsgQueueDEModel() {
        if (this.pSSysMsgQueueDEModel == null) {
            try {
                this.pSSysMsgQueueDEModel = (PSSysMsgQueueDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysMsgQueueDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysMsgQueueDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysMsgQueueDEModel();
    }

    public PSSysMsgQueueDAO getPSSysMsgQueueDAO() {
        if (this.pSSysMsgQueueDAO == null) {
            try {
                this.pSSysMsgQueueDAO = (PSSysMsgQueueDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSSysMsgQueueDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysMsgQueueDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysMsgQueueDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURSYS, (boolean)true) == 0) {
            return this.fetchCurSys(iDEDataSetFetchContext);
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

    public DBFetchResult fetchCurSys(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYS, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSSysMsgQueue pSSysMsgQueue, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMSGQUEUE_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSSysMsgQueue, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMSGQUEUE_PSDEFIELD_CONTENTPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_ContentPSDEF(pSSysMsgQueue, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMSGQUEUE_PSDEFIELD_CONTENTTYPEPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_ContentTypePSDEF(pSSysMsgQueue, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMSGQUEUE_PSDEFIELD_DDCONTENTPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_DDContentPSDEF(pSSysMsgQueue, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMSGQUEUE_PSDEFIELD_FILEPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_FilePSDEF(pSSysMsgQueue, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMSGQUEUE_PSDEFIELD_IMCONTENTPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_IMContentPSDEF(pSSysMsgQueue, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMSGQUEUE_PSDEFIELD_MOBTASKURLPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_MobTaskUrlPSDEF(pSSysMsgQueue, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMSGQUEUE_PSDEFIELD_MSGTYPEPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_MsgTypePSDEF(pSSysMsgQueue, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMSGQUEUE_PSDEFIELD_SENDTIMEPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_SendTimePSDEF(pSSysMsgQueue, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMSGQUEUE_PSDEFIELD_SMSCONTENTPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_SMSContentPSDEF(pSSysMsgQueue, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMSGQUEUE_PSDEFIELD_STATEPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_StatePSDEF(pSSysMsgQueue, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMSGQUEUE_PSDEFIELD_TAG2PSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_TagPSDEF(pSSysMsgQueue, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMSGQUEUE_PSDEFIELD_TAGPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_Tag2PSDEF(pSSysMsgQueue, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMSGQUEUE_PSDEFIELD_TARGETPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_TargetPSDEF(pSSysMsgQueue, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMSGQUEUE_PSDEFIELD_TARGETTYPEPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_TargetTypePSDEF(pSSysMsgQueue, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMSGQUEUE_PSDEFIELD_TASKURLPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_TaskUrlPSDEF(pSSysMsgQueue, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMSGQUEUE_PSDEFIELD_TITLEPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_TitlePSDEF(pSSysMsgQueue, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMSGQUEUE_PSDEFIELD_USER2PSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_User2PSDEF(pSSysMsgQueue, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMSGQUEUE_PSDEFIELD_USERPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_UserPSDEF(pSSysMsgQueue, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMSGQUEUE_PSDEFIELD_WXCONTENTPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_WXContentPSDEF(pSSysMsgQueue, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMSGQUEUE_PSMODULE_PSMODULEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSModuleService", (SessionFactory)this.getSessionFactory());
            PSModule pSModule = (PSModule)iService.getDEModel().createEntity();
            pSModule.set("PSMODULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSModule);
            } else {
                iService.get((IEntity)pSModule);
            }
            this.onFillParentInfo_PSModule(pSSysMsgQueue, pSModule);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMSGQUEUE_PSSYSDYNAMODEL_PSSYSDYNAMODELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService", (SessionFactory)this.getSessionFactory());
            PSSysDynaModel pSSysDynaModel = (PSSysDynaModel)iService.getDEModel().createEntity();
            pSSysDynaModel.set("PSSYSDYNAMODELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysDynaModel);
            } else {
                iService.get((IEntity)pSSysDynaModel);
            }
            this.onFillParentInfo_PSSysDynaModel(pSSysMsgQueue, pSSysDynaModel);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMSGQUEUE_PSSYSSFPLUGIN_PSSYSSFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysSFPlugin pSSysSFPlugin = (PSSysSFPlugin)iService.getDEModel().createEntity();
            pSSysSFPlugin.set("PSSYSSFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysSFPlugin);
            } else {
                iService.get((IEntity)pSSysSFPlugin);
            }
            this.onFillParentInfo_PSSysSFPlugin(pSSysMsgQueue, pSSysSFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMSGQUEUE_PSSYSTEM_PSSYSTEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemService", (SessionFactory)this.getSessionFactory());
            PSSystem pSSystem = (PSSystem)iService.getDEModel().createEntity();
            pSSystem.set("PSSYSTEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSystem);
            } else {
                iService.get((IEntity)pSSystem);
            }
            this.onFillParentInfo_PSSystem(pSSysMsgQueue, pSSystem);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMSGQUEUE_PSSYSUTILDE_PSSYSUTILDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysUtilDEService", (SessionFactory)this.getSessionFactory());
            PSSysUtilDE pSSysUtilDE = (PSSysUtilDE)iService.getDEModel().createEntity();
            pSSysUtilDE.set("PSSYSUTILDEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysUtilDE);
            } else {
                iService.get((IEntity)pSSysUtilDE);
            }
            this.onFillParentInfo_PSSysUtilDE(pSSysMsgQueue, pSSysUtilDE);
            return;
        }
        super.onFillParentInfo((IEntity)pSSysMsgQueue, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDE(PSSysMsgQueue pSSysMsgQueue, PSDataEntity pSDataEntity) throws Exception {
        pSSysMsgQueue.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSSysMsgQueue.setPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_ContentPSDEF(PSSysMsgQueue pSSysMsgQueue, PSDEField pSDEField) throws Exception {
        pSSysMsgQueue.setContentPSDEFId(pSDEField.getPSDEFieldId());
        pSSysMsgQueue.setContentPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_ContentTypePSDEF(PSSysMsgQueue pSSysMsgQueue, PSDEField pSDEField) throws Exception {
        pSSysMsgQueue.setContentTypePSDEFId(pSDEField.getPSDEFieldId());
        pSSysMsgQueue.setContentTypePSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_DDContentPSDEF(PSSysMsgQueue pSSysMsgQueue, PSDEField pSDEField) throws Exception {
        pSSysMsgQueue.setDDContentPSDEFId(pSDEField.getPSDEFieldId());
        pSSysMsgQueue.setDDContentPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_FilePSDEF(PSSysMsgQueue pSSysMsgQueue, PSDEField pSDEField) throws Exception {
        pSSysMsgQueue.setFilePSDEFId(pSDEField.getPSDEFieldId());
        pSSysMsgQueue.setFilePSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_IMContentPSDEF(PSSysMsgQueue pSSysMsgQueue, PSDEField pSDEField) throws Exception {
        pSSysMsgQueue.setIMContentPSDEFId(pSDEField.getPSDEFieldId());
        pSSysMsgQueue.setIMContentPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_MobTaskUrlPSDEF(PSSysMsgQueue pSSysMsgQueue, PSDEField pSDEField) throws Exception {
        pSSysMsgQueue.setMobTaskUrlPSDEFId(pSDEField.getPSDEFieldId());
        pSSysMsgQueue.setMobTaskUrlPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_MsgTypePSDEF(PSSysMsgQueue pSSysMsgQueue, PSDEField pSDEField) throws Exception {
        pSSysMsgQueue.setMsgTypePSDEFId(pSDEField.getPSDEFieldId());
        pSSysMsgQueue.setMsgTypePSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_SendTimePSDEF(PSSysMsgQueue pSSysMsgQueue, PSDEField pSDEField) throws Exception {
        pSSysMsgQueue.setSendTimePSDEFId(pSDEField.getPSDEFieldId());
        pSSysMsgQueue.setSendTimePSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_SMSContentPSDEF(PSSysMsgQueue pSSysMsgQueue, PSDEField pSDEField) throws Exception {
        pSSysMsgQueue.setSMSContentPSDEFId(pSDEField.getPSDEFieldId());
        pSSysMsgQueue.setSMSContentPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_StatePSDEF(PSSysMsgQueue pSSysMsgQueue, PSDEField pSDEField) throws Exception {
        pSSysMsgQueue.setStatePSDEFId(pSDEField.getPSDEFieldId());
        pSSysMsgQueue.setStatePSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_TagPSDEF(PSSysMsgQueue pSSysMsgQueue, PSDEField pSDEField) throws Exception {
        pSSysMsgQueue.setTag2PSDEFId(pSDEField.getPSDEFieldId());
        pSSysMsgQueue.setTag2PSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_Tag2PSDEF(PSSysMsgQueue pSSysMsgQueue, PSDEField pSDEField) throws Exception {
        pSSysMsgQueue.setTagPSDEFId(pSDEField.getPSDEFieldId());
        pSSysMsgQueue.setTagPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_TargetPSDEF(PSSysMsgQueue pSSysMsgQueue, PSDEField pSDEField) throws Exception {
        pSSysMsgQueue.setTargetPSDEFId(pSDEField.getPSDEFieldId());
        pSSysMsgQueue.setTargetPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_TargetTypePSDEF(PSSysMsgQueue pSSysMsgQueue, PSDEField pSDEField) throws Exception {
        pSSysMsgQueue.setTargetTypePSDEFId(pSDEField.getPSDEFieldId());
        pSSysMsgQueue.setTargetTypePSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_TaskUrlPSDEF(PSSysMsgQueue pSSysMsgQueue, PSDEField pSDEField) throws Exception {
        pSSysMsgQueue.setTaskUrlPSDEFId(pSDEField.getPSDEFieldId());
        pSSysMsgQueue.setTaskUrlPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_TitlePSDEF(PSSysMsgQueue pSSysMsgQueue, PSDEField pSDEField) throws Exception {
        pSSysMsgQueue.setTitlePSDEFId(pSDEField.getPSDEFieldId());
        pSSysMsgQueue.setTitlePSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_User2PSDEF(PSSysMsgQueue pSSysMsgQueue, PSDEField pSDEField) throws Exception {
        pSSysMsgQueue.setUser2PSDEFId(pSDEField.getPSDEFieldId());
        pSSysMsgQueue.setUser2PSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_UserPSDEF(PSSysMsgQueue pSSysMsgQueue, PSDEField pSDEField) throws Exception {
        pSSysMsgQueue.setUserPSDEFId(pSDEField.getPSDEFieldId());
        pSSysMsgQueue.setUserPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_WXContentPSDEF(PSSysMsgQueue pSSysMsgQueue, PSDEField pSDEField) throws Exception {
        pSSysMsgQueue.setWXContentPSDEFId(pSDEField.getPSDEFieldId());
        pSSysMsgQueue.setWXContentPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_PSModule(PSSysMsgQueue pSSysMsgQueue, PSModule pSModule) throws Exception {
        pSSysMsgQueue.setPSModuleId(pSModule.getPSModuleId());
        pSSysMsgQueue.setPSModuleName(pSModule.getPSModuleName());
    }

    protected void onFillParentInfo_PSSysDynaModel(PSSysMsgQueue pSSysMsgQueue, PSSysDynaModel pSSysDynaModel) throws Exception {
        pSSysMsgQueue.setPSSysDynaModelId(pSSysDynaModel.getPSSysDynaModelId());
        pSSysMsgQueue.setPSSysDynaModelName(pSSysDynaModel.getPSSysDynaModelName());
    }

    protected void onFillParentInfo_PSSysSFPlugin(PSSysMsgQueue pSSysMsgQueue, PSSysSFPlugin pSSysSFPlugin) throws Exception {
        pSSysMsgQueue.setPSSysSFPluginId(pSSysSFPlugin.getPSSysSFPluginId());
        pSSysMsgQueue.setPSSysSFPluginName(pSSysSFPlugin.getPSSysSFPluginName());
    }

    protected void onFillParentInfo_PSSystem(PSSysMsgQueue pSSysMsgQueue, PSSystem pSSystem) throws Exception {
        pSSysMsgQueue.setPSSystemId(pSSystem.getPSSystemId());
        pSSysMsgQueue.setPSSystemName(pSSystem.getPSSystemName());
    }

    protected void onFillParentInfo_PSSysUtilDE(PSSysMsgQueue pSSysMsgQueue, PSSysUtilDE pSSysUtilDE) throws Exception {
        pSSysMsgQueue.setPSSysUtilDEId(pSSysUtilDE.getPSSysUtilDEId());
        pSSysMsgQueue.setPSSysUtilDEName(pSSysUtilDE.getPSSysUtilDEName());
    }

    protected void onFillEntityFullInfo(PSSysMsgQueue pSSysMsgQueue, boolean bl) throws Exception {
        if (bl) {
            if (pSSysMsgQueue.getCodeName() == null) {
                pSSysMsgQueue.setCodeName((String)this.getDefaultValue(this.getWebContext(), "USER", "MsgQueue", 25));
            }
            if (pSSysMsgQueue.getMsgQueueType() == null) {
                pSSysMsgQueue.setMsgQueueType((String)this.getDefaultValue(this.getWebContext(), "", "RUNTIME", 25));
            }
            if (pSSysMsgQueue.getPSSysMsgQueueName() == null) {
                pSSysMsgQueue.setPSSysMsgQueueName((String)this.getDefaultValue(this.getWebContext(), "USER", "\u6d88\u606f\u961f\u5217", 25));
            }
            if (pSSysMsgQueue.getValidFlag() == null) {
                pSSysMsgQueue.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo((IEntity)pSSysMsgQueue, bl);
        this.onFillEntityFullInfo_PSDE(pSSysMsgQueue, bl);
        this.onFillEntityFullInfo_ContentPSDEF(pSSysMsgQueue, bl);
        this.onFillEntityFullInfo_ContentTypePSDEF(pSSysMsgQueue, bl);
        this.onFillEntityFullInfo_DDContentPSDEF(pSSysMsgQueue, bl);
        this.onFillEntityFullInfo_FilePSDEF(pSSysMsgQueue, bl);
        this.onFillEntityFullInfo_IMContentPSDEF(pSSysMsgQueue, bl);
        this.onFillEntityFullInfo_MobTaskUrlPSDEF(pSSysMsgQueue, bl);
        this.onFillEntityFullInfo_MsgTypePSDEF(pSSysMsgQueue, bl);
        this.onFillEntityFullInfo_SendTimePSDEF(pSSysMsgQueue, bl);
        this.onFillEntityFullInfo_SMSContentPSDEF(pSSysMsgQueue, bl);
        this.onFillEntityFullInfo_StatePSDEF(pSSysMsgQueue, bl);
        this.onFillEntityFullInfo_TagPSDEF(pSSysMsgQueue, bl);
        this.onFillEntityFullInfo_Tag2PSDEF(pSSysMsgQueue, bl);
        this.onFillEntityFullInfo_TargetPSDEF(pSSysMsgQueue, bl);
        this.onFillEntityFullInfo_TargetTypePSDEF(pSSysMsgQueue, bl);
        this.onFillEntityFullInfo_TaskUrlPSDEF(pSSysMsgQueue, bl);
        this.onFillEntityFullInfo_TitlePSDEF(pSSysMsgQueue, bl);
        this.onFillEntityFullInfo_User2PSDEF(pSSysMsgQueue, bl);
        this.onFillEntityFullInfo_UserPSDEF(pSSysMsgQueue, bl);
        this.onFillEntityFullInfo_WXContentPSDEF(pSSysMsgQueue, bl);
        this.onFillEntityFullInfo_PSModule(pSSysMsgQueue, bl);
        this.onFillEntityFullInfo_PSSysDynaModel(pSSysMsgQueue, bl);
        this.onFillEntityFullInfo_PSSysSFPlugin(pSSysMsgQueue, bl);
        this.onFillEntityFullInfo_PSSystem(pSSysMsgQueue, bl);
        this.onFillEntityFullInfo_PSSysUtilDE(pSSysMsgQueue, bl);
    }

    protected void onFillEntityFullInfo_PSDE(PSSysMsgQueue pSSysMsgQueue, boolean bl) throws Exception {
        if (pSSysMsgQueue.isPSDEIdDirty()) {
            if (pSSysMsgQueue.getPSDEId() != null) {
                if (pSSysMsgQueue.getPSDEId() == null || pSSysMsgQueue.getPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSSysMsgQueue.getPSDE();
                    pSSysMsgQueue.setPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSSysMsgQueue.setPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_ContentPSDEF(PSSysMsgQueue pSSysMsgQueue, boolean bl) throws Exception {
        if (pSSysMsgQueue.isContentPSDEFIdDirty()) {
            if (pSSysMsgQueue.getContentPSDEFId() != null) {
                if (pSSysMsgQueue.getContentPSDEFId() == null || pSSysMsgQueue.getContentPSDEFName() == null) {
                    PSDEField pSDEField = pSSysMsgQueue.getContentPSDEF();
                    pSSysMsgQueue.setContentPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysMsgQueue.setContentPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_ContentTypePSDEF(PSSysMsgQueue pSSysMsgQueue, boolean bl) throws Exception {
        if (pSSysMsgQueue.isContentTypePSDEFIdDirty()) {
            if (pSSysMsgQueue.getContentTypePSDEFId() != null) {
                if (pSSysMsgQueue.getContentTypePSDEFId() == null || pSSysMsgQueue.getContentTypePSDEFName() == null) {
                    PSDEField pSDEField = pSSysMsgQueue.getContentTypePSDEF();
                    pSSysMsgQueue.setContentTypePSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysMsgQueue.setContentTypePSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_DDContentPSDEF(PSSysMsgQueue pSSysMsgQueue, boolean bl) throws Exception {
        if (pSSysMsgQueue.isDDContentPSDEFIdDirty()) {
            if (pSSysMsgQueue.getDDContentPSDEFId() != null) {
                if (pSSysMsgQueue.getDDContentPSDEFId() == null || pSSysMsgQueue.getDDContentPSDEFName() == null) {
                    PSDEField pSDEField = pSSysMsgQueue.getDDContentPSDEF();
                    pSSysMsgQueue.setDDContentPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysMsgQueue.setDDContentPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_FilePSDEF(PSSysMsgQueue pSSysMsgQueue, boolean bl) throws Exception {
        if (pSSysMsgQueue.isFilePSDEFIdDirty()) {
            if (pSSysMsgQueue.getFilePSDEFId() != null) {
                if (pSSysMsgQueue.getFilePSDEFId() == null || pSSysMsgQueue.getFilePSDEFName() == null) {
                    PSDEField pSDEField = pSSysMsgQueue.getFilePSDEF();
                    pSSysMsgQueue.setFilePSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysMsgQueue.setFilePSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_IMContentPSDEF(PSSysMsgQueue pSSysMsgQueue, boolean bl) throws Exception {
        if (pSSysMsgQueue.isIMContentPSDEFIdDirty()) {
            if (pSSysMsgQueue.getIMContentPSDEFId() != null) {
                if (pSSysMsgQueue.getIMContentPSDEFId() == null || pSSysMsgQueue.getIMContentPSDEFName() == null) {
                    PSDEField pSDEField = pSSysMsgQueue.getIMContentPSDEF();
                    pSSysMsgQueue.setIMContentPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysMsgQueue.setIMContentPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_MobTaskUrlPSDEF(PSSysMsgQueue pSSysMsgQueue, boolean bl) throws Exception {
        if (pSSysMsgQueue.isMobTaskUrlPSDEFIdDirty()) {
            if (pSSysMsgQueue.getMobTaskUrlPSDEFId() != null) {
                if (pSSysMsgQueue.getMobTaskUrlPSDEFId() == null || pSSysMsgQueue.getMobTaskUrlPSDEFName() == null) {
                    PSDEField pSDEField = pSSysMsgQueue.getMobTaskUrlPSDEF();
                    pSSysMsgQueue.setMobTaskUrlPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysMsgQueue.setMobTaskUrlPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_MsgTypePSDEF(PSSysMsgQueue pSSysMsgQueue, boolean bl) throws Exception {
        if (pSSysMsgQueue.isMsgTypePSDEFIdDirty()) {
            if (pSSysMsgQueue.getMsgTypePSDEFId() != null) {
                if (pSSysMsgQueue.getMsgTypePSDEFId() == null || pSSysMsgQueue.getMsgTypePSDEFName() == null) {
                    PSDEField pSDEField = pSSysMsgQueue.getMsgTypePSDEF();
                    pSSysMsgQueue.setMsgTypePSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysMsgQueue.setMsgTypePSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_SendTimePSDEF(PSSysMsgQueue pSSysMsgQueue, boolean bl) throws Exception {
        if (pSSysMsgQueue.isSendTimePSDEFIdDirty()) {
            if (pSSysMsgQueue.getSendTimePSDEFId() != null) {
                if (pSSysMsgQueue.getSendTimePSDEFId() == null || pSSysMsgQueue.getSendTimePSDEFName() == null) {
                    PSDEField pSDEField = pSSysMsgQueue.getSendTimePSDEF();
                    pSSysMsgQueue.setSendTimePSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysMsgQueue.setSendTimePSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_SMSContentPSDEF(PSSysMsgQueue pSSysMsgQueue, boolean bl) throws Exception {
        if (pSSysMsgQueue.isSMSContentPSDEFIdDirty()) {
            if (pSSysMsgQueue.getSMSContentPSDEFId() != null) {
                if (pSSysMsgQueue.getSMSContentPSDEFId() == null || pSSysMsgQueue.getSMSContentPSDEFName() == null) {
                    PSDEField pSDEField = pSSysMsgQueue.getSMSContentPSDEF();
                    pSSysMsgQueue.setSMSContentPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysMsgQueue.setSMSContentPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_StatePSDEF(PSSysMsgQueue pSSysMsgQueue, boolean bl) throws Exception {
        if (pSSysMsgQueue.isStatePSDEFIdDirty()) {
            if (pSSysMsgQueue.getStatePSDEFId() != null) {
                if (pSSysMsgQueue.getStatePSDEFId() == null || pSSysMsgQueue.getStatePSDEFName() == null) {
                    PSDEField pSDEField = pSSysMsgQueue.getStatePSDEF();
                    pSSysMsgQueue.setStatePSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysMsgQueue.setStatePSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_TagPSDEF(PSSysMsgQueue pSSysMsgQueue, boolean bl) throws Exception {
        if (pSSysMsgQueue.isTag2PSDEFIdDirty()) {
            if (pSSysMsgQueue.getTag2PSDEFId() != null) {
                if (pSSysMsgQueue.getTag2PSDEFId() == null || pSSysMsgQueue.getTag2PSDEFName() == null) {
                    PSDEField pSDEField = pSSysMsgQueue.getTagPSDEF();
                    pSSysMsgQueue.setTag2PSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysMsgQueue.setTag2PSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_Tag2PSDEF(PSSysMsgQueue pSSysMsgQueue, boolean bl) throws Exception {
        if (pSSysMsgQueue.isTagPSDEFIdDirty()) {
            if (pSSysMsgQueue.getTagPSDEFId() != null) {
                if (pSSysMsgQueue.getTagPSDEFId() == null || pSSysMsgQueue.getTagPSDEFName() == null) {
                    PSDEField pSDEField = pSSysMsgQueue.getTag2PSDEF();
                    pSSysMsgQueue.setTagPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysMsgQueue.setTagPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_TargetPSDEF(PSSysMsgQueue pSSysMsgQueue, boolean bl) throws Exception {
        if (pSSysMsgQueue.isTargetPSDEFIdDirty()) {
            if (pSSysMsgQueue.getTargetPSDEFId() != null) {
                if (pSSysMsgQueue.getTargetPSDEFId() == null || pSSysMsgQueue.getTargetPSDEFName() == null) {
                    PSDEField pSDEField = pSSysMsgQueue.getTargetPSDEF();
                    pSSysMsgQueue.setTargetPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysMsgQueue.setTargetPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_TargetTypePSDEF(PSSysMsgQueue pSSysMsgQueue, boolean bl) throws Exception {
        if (pSSysMsgQueue.isTargetTypePSDEFIdDirty()) {
            if (pSSysMsgQueue.getTargetTypePSDEFId() != null) {
                if (pSSysMsgQueue.getTargetTypePSDEFId() == null || pSSysMsgQueue.getTargetTypePSDEFName() == null) {
                    PSDEField pSDEField = pSSysMsgQueue.getTargetTypePSDEF();
                    pSSysMsgQueue.setTargetTypePSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysMsgQueue.setTargetTypePSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_TaskUrlPSDEF(PSSysMsgQueue pSSysMsgQueue, boolean bl) throws Exception {
        if (pSSysMsgQueue.isTaskUrlPSDEFIdDirty()) {
            if (pSSysMsgQueue.getTaskUrlPSDEFId() != null) {
                if (pSSysMsgQueue.getTaskUrlPSDEFId() == null || pSSysMsgQueue.getTaskUrlPSDEFName() == null) {
                    PSDEField pSDEField = pSSysMsgQueue.getTaskUrlPSDEF();
                    pSSysMsgQueue.setTaskUrlPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysMsgQueue.setTaskUrlPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_TitlePSDEF(PSSysMsgQueue pSSysMsgQueue, boolean bl) throws Exception {
        if (pSSysMsgQueue.isTitlePSDEFIdDirty()) {
            if (pSSysMsgQueue.getTitlePSDEFId() != null) {
                if (pSSysMsgQueue.getTitlePSDEFId() == null || pSSysMsgQueue.getTitlePSDEFName() == null) {
                    PSDEField pSDEField = pSSysMsgQueue.getTitlePSDEF();
                    pSSysMsgQueue.setTitlePSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysMsgQueue.setTitlePSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_User2PSDEF(PSSysMsgQueue pSSysMsgQueue, boolean bl) throws Exception {
        if (pSSysMsgQueue.isUser2PSDEFIdDirty()) {
            if (pSSysMsgQueue.getUser2PSDEFId() != null) {
                if (pSSysMsgQueue.getUser2PSDEFId() == null || pSSysMsgQueue.getUser2PSDEFName() == null) {
                    PSDEField pSDEField = pSSysMsgQueue.getUser2PSDEF();
                    pSSysMsgQueue.setUser2PSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysMsgQueue.setUser2PSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_UserPSDEF(PSSysMsgQueue pSSysMsgQueue, boolean bl) throws Exception {
        if (pSSysMsgQueue.isUserPSDEFIdDirty()) {
            if (pSSysMsgQueue.getUserPSDEFId() != null) {
                if (pSSysMsgQueue.getUserPSDEFId() == null || pSSysMsgQueue.getUserPSDEFName() == null) {
                    PSDEField pSDEField = pSSysMsgQueue.getUserPSDEF();
                    pSSysMsgQueue.setUserPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysMsgQueue.setUserPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_WXContentPSDEF(PSSysMsgQueue pSSysMsgQueue, boolean bl) throws Exception {
        if (pSSysMsgQueue.isWXContentPSDEFIdDirty()) {
            if (pSSysMsgQueue.getWXContentPSDEFId() != null) {
                if (pSSysMsgQueue.getWXContentPSDEFId() == null || pSSysMsgQueue.getWXContentPSDEFName() == null) {
                    PSDEField pSDEField = pSSysMsgQueue.getWXContentPSDEF();
                    pSSysMsgQueue.setWXContentPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysMsgQueue.setWXContentPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSModule(PSSysMsgQueue pSSysMsgQueue, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysDynaModel(PSSysMsgQueue pSSysMsgQueue, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysSFPlugin(PSSysMsgQueue pSSysMsgQueue, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSystem(PSSysMsgQueue pSSysMsgQueue, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysUtilDE(PSSysMsgQueue pSSysMsgQueue, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSysMsgQueue pSSysMsgQueue, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSSysMsgQueue, bl);
    }

    public ArrayList<PSSysMsgQueue> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSSysMsgQueue> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSSysMsgQueue> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysMsgQueue> selectByContentPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByContentPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysMsgQueue> selectByContentPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByContentPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysMsgQueue> selectByContentPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("CONTENTPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByContentPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByContentPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysMsgQueue> selectByContentTypePSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByContentTypePSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysMsgQueue> selectByContentTypePSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByContentTypePSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysMsgQueue> selectByContentTypePSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("CONTENTTYPEPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByContentTypePSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByContentTypePSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysMsgQueue> selectByDDContentPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByDDContentPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysMsgQueue> selectByDDContentPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByDDContentPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysMsgQueue> selectByDDContentPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("DDCONTENTPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByDDContentPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByDDContentPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysMsgQueue> selectByFilePSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByFilePSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysMsgQueue> selectByFilePSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByFilePSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysMsgQueue> selectByFilePSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("FILEPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByFilePSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByFilePSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysMsgQueue> selectByIMContentPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByIMContentPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysMsgQueue> selectByIMContentPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByIMContentPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysMsgQueue> selectByIMContentPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("IMCONTENTPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByIMContentPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByIMContentPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysMsgQueue> selectByMobTaskUrlPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByMobTaskUrlPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysMsgQueue> selectByMobTaskUrlPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByMobTaskUrlPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysMsgQueue> selectByMobTaskUrlPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("MOBTASKURLPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByMobTaskUrlPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByMobTaskUrlPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysMsgQueue> selectByMsgTypePSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByMsgTypePSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysMsgQueue> selectByMsgTypePSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByMsgTypePSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysMsgQueue> selectByMsgTypePSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("MSGTYPEPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByMsgTypePSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByMsgTypePSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysMsgQueue> selectBySendTimePSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectBySendTimePSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysMsgQueue> selectBySendTimePSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectBySendTimePSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysMsgQueue> selectBySendTimePSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("SENDTIMEPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectBySendTimePSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectBySendTimePSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysMsgQueue> selectBySMSContentPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectBySMSContentPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysMsgQueue> selectBySMSContentPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectBySMSContentPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysMsgQueue> selectBySMSContentPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("SMSCONTENTPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectBySMSContentPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectBySMSContentPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysMsgQueue> selectByStatePSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByStatePSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysMsgQueue> selectByStatePSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByStatePSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysMsgQueue> selectByStatePSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("STATEPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByStatePSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByStatePSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysMsgQueue> selectByTagPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByTagPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysMsgQueue> selectByTagPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByTagPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysMsgQueue> selectByTagPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("TAG2PSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByTagPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByTagPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysMsgQueue> selectByTag2PSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByTag2PSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysMsgQueue> selectByTag2PSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByTag2PSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysMsgQueue> selectByTag2PSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("TAGPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByTag2PSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByTag2PSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysMsgQueue> selectByTargetPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByTargetPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysMsgQueue> selectByTargetPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByTargetPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysMsgQueue> selectByTargetPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("TARGETPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByTargetPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByTargetPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysMsgQueue> selectByTargetTypePSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByTargetTypePSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysMsgQueue> selectByTargetTypePSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByTargetTypePSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysMsgQueue> selectByTargetTypePSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("TARGETTYPEPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByTargetTypePSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByTargetTypePSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysMsgQueue> selectByTaskUrlPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByTaskUrlPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysMsgQueue> selectByTaskUrlPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByTaskUrlPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysMsgQueue> selectByTaskUrlPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("TASKURLPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByTaskUrlPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByTaskUrlPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysMsgQueue> selectByTitlePSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByTitlePSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysMsgQueue> selectByTitlePSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByTitlePSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysMsgQueue> selectByTitlePSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("TITLEPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByTitlePSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByTitlePSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysMsgQueue> selectByUser2PSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByUser2PSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysMsgQueue> selectByUser2PSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByUser2PSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysMsgQueue> selectByUser2PSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("USER2PSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByUser2PSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByUser2PSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysMsgQueue> selectByUserPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByUserPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysMsgQueue> selectByUserPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByUserPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysMsgQueue> selectByUserPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("USERPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByUserPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByUserPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysMsgQueue> selectByWXContentPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByWXContentPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysMsgQueue> selectByWXContentPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByWXContentPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysMsgQueue> selectByWXContentPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("WXCONTENTPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByWXContentPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByWXContentPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysMsgQueue> selectByPSModule(PSModuleBase pSModuleBase) throws Exception {
        return this.selectByPSModule(pSModuleBase, "", -1);
    }

    public ArrayList<PSSysMsgQueue> selectByPSModule(PSModuleBase pSModuleBase, String string) throws Exception {
        return this.selectByPSModule(pSModuleBase, string, -1);
    }

    public ArrayList<PSSysMsgQueue> selectByPSModule(PSModuleBase pSModuleBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysMsgQueue> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, "", -1);
    }

    public ArrayList<PSSysMsgQueue> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, string, -1);
    }

    public ArrayList<PSSysMsgQueue> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysMsgQueue> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, "", -1);
    }

    public ArrayList<PSSysMsgQueue> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, string, -1);
    }

    public ArrayList<PSSysMsgQueue> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysMsgQueue> selectByPSSystem(PSSystemBase pSSystemBase) throws Exception {
        return this.selectByPSSystem(pSSystemBase, "", -1);
    }

    public ArrayList<PSSysMsgQueue> selectByPSSystem(PSSystemBase pSSystemBase, String string) throws Exception {
        return this.selectByPSSystem(pSSystemBase, string, -1);
    }

    public ArrayList<PSSysMsgQueue> selectByPSSystem(PSSystemBase pSSystemBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysMsgQueue> selectByPSSysUtilDE(PSSysUtilDEBase pSSysUtilDEBase) throws Exception {
        return this.selectByPSSysUtilDE(pSSysUtilDEBase, "", -1);
    }

    public ArrayList<PSSysMsgQueue> selectByPSSysUtilDE(PSSysUtilDEBase pSSysUtilDEBase, String string) throws Exception {
        return this.selectByPSSysUtilDE(pSSysUtilDEBase, string, -1);
    }

    public ArrayList<PSSysMsgQueue> selectByPSSysUtilDE(PSSysUtilDEBase pSSysUtilDEBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSUTILDEID", (Object)pSSysUtilDEBase.getPSSysUtilDEId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysUtilDECond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysUtilDECond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysMsgQueue> arrayList = this.selectByPSDE(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMSGQUEUE_PSDATAENTITY_PSDEID", "", iDataEntityModel.getName(), "PSSYSMSGQUEUE", iDataEntityModel.getDataInfo((IEntity)pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysMsgQueue> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSSysMsgQueue pSSysMsgQueue : arrayList) {
            PSSysMsgQueue pSSysMsgQueue2 = (PSSysMsgQueue)this.getDEModel().createEntity();
            pSSysMsgQueue2.setPSSysMsgQueueId(pSSysMsgQueue.getPSSysMsgQueueId());
            pSSysMsgQueue2.setPSDEId(null);
            this.update(pSSysMsgQueue2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMsgQueueServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSSysMsgQueueServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSSysMsgQueueServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysMsgQueue> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSSysMsgQueue pSSysMsgQueue : arrayList) {
            this.remove((IEntity)pSSysMsgQueue);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSSysMsgQueue> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSSysMsgQueue> arrayList) throws Exception {
    }

    public void testRemoveByContentPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgQueue> arrayList = this.selectByContentPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMSGQUEUE_PSDEFIELD_CONTENTPSDEFID", "", iDataEntityModel.getName(), "PSSYSMSGQUEUE", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetContentPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgQueue> arrayList = this.selectByContentPSDEF(pSDEField);
        for (PSSysMsgQueue pSSysMsgQueue : arrayList) {
            PSSysMsgQueue pSSysMsgQueue2 = (PSSysMsgQueue)this.getDEModel().createEntity();
            pSSysMsgQueue2.setPSSysMsgQueueId(pSSysMsgQueue.getPSSysMsgQueueId());
            pSSysMsgQueue2.setContentPSDEFId(null);
            this.update(pSSysMsgQueue2);
        }
    }

    public void removeByContentPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMsgQueueServiceBase.this.onBeforeRemoveByContentPSDEF(pSDEField2);
                PSSysMsgQueueServiceBase.this.internalRemoveByContentPSDEF(pSDEField2);
                PSSysMsgQueueServiceBase.this.onAfterRemoveByContentPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByContentPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByContentPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgQueue> arrayList = this.selectByContentPSDEF(pSDEField);
        this.onBeforeRemoveByContentPSDEF(pSDEField, arrayList);
        for (PSSysMsgQueue pSSysMsgQueue : arrayList) {
            this.remove((IEntity)pSSysMsgQueue);
        }
        this.onAfterRemoveByContentPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByContentPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByContentPSDEF(PSDEField pSDEField, ArrayList<PSSysMsgQueue> arrayList) throws Exception {
    }

    protected void onAfterRemoveByContentPSDEF(PSDEField pSDEField, ArrayList<PSSysMsgQueue> arrayList) throws Exception {
    }

    public void testRemoveByContentTypePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgQueue> arrayList = this.selectByContentTypePSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMSGQUEUE_PSDEFIELD_CONTENTTYPEPSDEFID", "", iDataEntityModel.getName(), "PSSYSMSGQUEUE", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetContentTypePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgQueue> arrayList = this.selectByContentTypePSDEF(pSDEField);
        for (PSSysMsgQueue pSSysMsgQueue : arrayList) {
            PSSysMsgQueue pSSysMsgQueue2 = (PSSysMsgQueue)this.getDEModel().createEntity();
            pSSysMsgQueue2.setPSSysMsgQueueId(pSSysMsgQueue.getPSSysMsgQueueId());
            pSSysMsgQueue2.setContentTypePSDEFId(null);
            this.update(pSSysMsgQueue2);
        }
    }

    public void removeByContentTypePSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMsgQueueServiceBase.this.onBeforeRemoveByContentTypePSDEF(pSDEField2);
                PSSysMsgQueueServiceBase.this.internalRemoveByContentTypePSDEF(pSDEField2);
                PSSysMsgQueueServiceBase.this.onAfterRemoveByContentTypePSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByContentTypePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByContentTypePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgQueue> arrayList = this.selectByContentTypePSDEF(pSDEField);
        this.onBeforeRemoveByContentTypePSDEF(pSDEField, arrayList);
        for (PSSysMsgQueue pSSysMsgQueue : arrayList) {
            this.remove((IEntity)pSSysMsgQueue);
        }
        this.onAfterRemoveByContentTypePSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByContentTypePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByContentTypePSDEF(PSDEField pSDEField, ArrayList<PSSysMsgQueue> arrayList) throws Exception {
    }

    protected void onAfterRemoveByContentTypePSDEF(PSDEField pSDEField, ArrayList<PSSysMsgQueue> arrayList) throws Exception {
    }

    public void testRemoveByDDContentPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgQueue> arrayList = this.selectByDDContentPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMSGQUEUE_PSDEFIELD_DDCONTENTPSDEFID", "", iDataEntityModel.getName(), "PSSYSMSGQUEUE", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetDDContentPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgQueue> arrayList = this.selectByDDContentPSDEF(pSDEField);
        for (PSSysMsgQueue pSSysMsgQueue : arrayList) {
            PSSysMsgQueue pSSysMsgQueue2 = (PSSysMsgQueue)this.getDEModel().createEntity();
            pSSysMsgQueue2.setPSSysMsgQueueId(pSSysMsgQueue.getPSSysMsgQueueId());
            pSSysMsgQueue2.setDDContentPSDEFId(null);
            this.update(pSSysMsgQueue2);
        }
    }

    public void removeByDDContentPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMsgQueueServiceBase.this.onBeforeRemoveByDDContentPSDEF(pSDEField2);
                PSSysMsgQueueServiceBase.this.internalRemoveByDDContentPSDEF(pSDEField2);
                PSSysMsgQueueServiceBase.this.onAfterRemoveByDDContentPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByDDContentPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByDDContentPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgQueue> arrayList = this.selectByDDContentPSDEF(pSDEField);
        this.onBeforeRemoveByDDContentPSDEF(pSDEField, arrayList);
        for (PSSysMsgQueue pSSysMsgQueue : arrayList) {
            this.remove((IEntity)pSSysMsgQueue);
        }
        this.onAfterRemoveByDDContentPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByDDContentPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByDDContentPSDEF(PSDEField pSDEField, ArrayList<PSSysMsgQueue> arrayList) throws Exception {
    }

    protected void onAfterRemoveByDDContentPSDEF(PSDEField pSDEField, ArrayList<PSSysMsgQueue> arrayList) throws Exception {
    }

    public void testRemoveByFilePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgQueue> arrayList = this.selectByFilePSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMSGQUEUE_PSDEFIELD_FILEPSDEFID", "", iDataEntityModel.getName(), "PSSYSMSGQUEUE", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetFilePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgQueue> arrayList = this.selectByFilePSDEF(pSDEField);
        for (PSSysMsgQueue pSSysMsgQueue : arrayList) {
            PSSysMsgQueue pSSysMsgQueue2 = (PSSysMsgQueue)this.getDEModel().createEntity();
            pSSysMsgQueue2.setPSSysMsgQueueId(pSSysMsgQueue.getPSSysMsgQueueId());
            pSSysMsgQueue2.setFilePSDEFId(null);
            this.update(pSSysMsgQueue2);
        }
    }

    public void removeByFilePSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMsgQueueServiceBase.this.onBeforeRemoveByFilePSDEF(pSDEField2);
                PSSysMsgQueueServiceBase.this.internalRemoveByFilePSDEF(pSDEField2);
                PSSysMsgQueueServiceBase.this.onAfterRemoveByFilePSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByFilePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByFilePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgQueue> arrayList = this.selectByFilePSDEF(pSDEField);
        this.onBeforeRemoveByFilePSDEF(pSDEField, arrayList);
        for (PSSysMsgQueue pSSysMsgQueue : arrayList) {
            this.remove((IEntity)pSSysMsgQueue);
        }
        this.onAfterRemoveByFilePSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByFilePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByFilePSDEF(PSDEField pSDEField, ArrayList<PSSysMsgQueue> arrayList) throws Exception {
    }

    protected void onAfterRemoveByFilePSDEF(PSDEField pSDEField, ArrayList<PSSysMsgQueue> arrayList) throws Exception {
    }

    public void testRemoveByIMContentPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgQueue> arrayList = this.selectByIMContentPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMSGQUEUE_PSDEFIELD_IMCONTENTPSDEFID", "", iDataEntityModel.getName(), "PSSYSMSGQUEUE", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetIMContentPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgQueue> arrayList = this.selectByIMContentPSDEF(pSDEField);
        for (PSSysMsgQueue pSSysMsgQueue : arrayList) {
            PSSysMsgQueue pSSysMsgQueue2 = (PSSysMsgQueue)this.getDEModel().createEntity();
            pSSysMsgQueue2.setPSSysMsgQueueId(pSSysMsgQueue.getPSSysMsgQueueId());
            pSSysMsgQueue2.setIMContentPSDEFId(null);
            this.update(pSSysMsgQueue2);
        }
    }

    public void removeByIMContentPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMsgQueueServiceBase.this.onBeforeRemoveByIMContentPSDEF(pSDEField2);
                PSSysMsgQueueServiceBase.this.internalRemoveByIMContentPSDEF(pSDEField2);
                PSSysMsgQueueServiceBase.this.onAfterRemoveByIMContentPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByIMContentPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByIMContentPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgQueue> arrayList = this.selectByIMContentPSDEF(pSDEField);
        this.onBeforeRemoveByIMContentPSDEF(pSDEField, arrayList);
        for (PSSysMsgQueue pSSysMsgQueue : arrayList) {
            this.remove((IEntity)pSSysMsgQueue);
        }
        this.onAfterRemoveByIMContentPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByIMContentPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByIMContentPSDEF(PSDEField pSDEField, ArrayList<PSSysMsgQueue> arrayList) throws Exception {
    }

    protected void onAfterRemoveByIMContentPSDEF(PSDEField pSDEField, ArrayList<PSSysMsgQueue> arrayList) throws Exception {
    }

    public void testRemoveByMobTaskUrlPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgQueue> arrayList = this.selectByMobTaskUrlPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMSGQUEUE_PSDEFIELD_MOBTASKURLPSDEFID", "", iDataEntityModel.getName(), "PSSYSMSGQUEUE", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetMobTaskUrlPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgQueue> arrayList = this.selectByMobTaskUrlPSDEF(pSDEField);
        for (PSSysMsgQueue pSSysMsgQueue : arrayList) {
            PSSysMsgQueue pSSysMsgQueue2 = (PSSysMsgQueue)this.getDEModel().createEntity();
            pSSysMsgQueue2.setPSSysMsgQueueId(pSSysMsgQueue.getPSSysMsgQueueId());
            pSSysMsgQueue2.setMobTaskUrlPSDEFId(null);
            this.update(pSSysMsgQueue2);
        }
    }

    public void removeByMobTaskUrlPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMsgQueueServiceBase.this.onBeforeRemoveByMobTaskUrlPSDEF(pSDEField2);
                PSSysMsgQueueServiceBase.this.internalRemoveByMobTaskUrlPSDEF(pSDEField2);
                PSSysMsgQueueServiceBase.this.onAfterRemoveByMobTaskUrlPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByMobTaskUrlPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByMobTaskUrlPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgQueue> arrayList = this.selectByMobTaskUrlPSDEF(pSDEField);
        this.onBeforeRemoveByMobTaskUrlPSDEF(pSDEField, arrayList);
        for (PSSysMsgQueue pSSysMsgQueue : arrayList) {
            this.remove((IEntity)pSSysMsgQueue);
        }
        this.onAfterRemoveByMobTaskUrlPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByMobTaskUrlPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByMobTaskUrlPSDEF(PSDEField pSDEField, ArrayList<PSSysMsgQueue> arrayList) throws Exception {
    }

    protected void onAfterRemoveByMobTaskUrlPSDEF(PSDEField pSDEField, ArrayList<PSSysMsgQueue> arrayList) throws Exception {
    }

    public void testRemoveByMsgTypePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgQueue> arrayList = this.selectByMsgTypePSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMSGQUEUE_PSDEFIELD_MSGTYPEPSDEFID", "", iDataEntityModel.getName(), "PSSYSMSGQUEUE", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetMsgTypePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgQueue> arrayList = this.selectByMsgTypePSDEF(pSDEField);
        for (PSSysMsgQueue pSSysMsgQueue : arrayList) {
            PSSysMsgQueue pSSysMsgQueue2 = (PSSysMsgQueue)this.getDEModel().createEntity();
            pSSysMsgQueue2.setPSSysMsgQueueId(pSSysMsgQueue.getPSSysMsgQueueId());
            pSSysMsgQueue2.setMsgTypePSDEFId(null);
            this.update(pSSysMsgQueue2);
        }
    }

    public void removeByMsgTypePSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMsgQueueServiceBase.this.onBeforeRemoveByMsgTypePSDEF(pSDEField2);
                PSSysMsgQueueServiceBase.this.internalRemoveByMsgTypePSDEF(pSDEField2);
                PSSysMsgQueueServiceBase.this.onAfterRemoveByMsgTypePSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByMsgTypePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByMsgTypePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgQueue> arrayList = this.selectByMsgTypePSDEF(pSDEField);
        this.onBeforeRemoveByMsgTypePSDEF(pSDEField, arrayList);
        for (PSSysMsgQueue pSSysMsgQueue : arrayList) {
            this.remove((IEntity)pSSysMsgQueue);
        }
        this.onAfterRemoveByMsgTypePSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByMsgTypePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByMsgTypePSDEF(PSDEField pSDEField, ArrayList<PSSysMsgQueue> arrayList) throws Exception {
    }

    protected void onAfterRemoveByMsgTypePSDEF(PSDEField pSDEField, ArrayList<PSSysMsgQueue> arrayList) throws Exception {
    }

    public void testRemoveBySendTimePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgQueue> arrayList = this.selectBySendTimePSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMSGQUEUE_PSDEFIELD_SENDTIMEPSDEFID", "", iDataEntityModel.getName(), "PSSYSMSGQUEUE", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetSendTimePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgQueue> arrayList = this.selectBySendTimePSDEF(pSDEField);
        for (PSSysMsgQueue pSSysMsgQueue : arrayList) {
            PSSysMsgQueue pSSysMsgQueue2 = (PSSysMsgQueue)this.getDEModel().createEntity();
            pSSysMsgQueue2.setPSSysMsgQueueId(pSSysMsgQueue.getPSSysMsgQueueId());
            pSSysMsgQueue2.setSendTimePSDEFId(null);
            this.update(pSSysMsgQueue2);
        }
    }

    public void removeBySendTimePSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMsgQueueServiceBase.this.onBeforeRemoveBySendTimePSDEF(pSDEField2);
                PSSysMsgQueueServiceBase.this.internalRemoveBySendTimePSDEF(pSDEField2);
                PSSysMsgQueueServiceBase.this.onAfterRemoveBySendTimePSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveBySendTimePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveBySendTimePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgQueue> arrayList = this.selectBySendTimePSDEF(pSDEField);
        this.onBeforeRemoveBySendTimePSDEF(pSDEField, arrayList);
        for (PSSysMsgQueue pSSysMsgQueue : arrayList) {
            this.remove((IEntity)pSSysMsgQueue);
        }
        this.onAfterRemoveBySendTimePSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveBySendTimePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveBySendTimePSDEF(PSDEField pSDEField, ArrayList<PSSysMsgQueue> arrayList) throws Exception {
    }

    protected void onAfterRemoveBySendTimePSDEF(PSDEField pSDEField, ArrayList<PSSysMsgQueue> arrayList) throws Exception {
    }

    public void testRemoveBySMSContentPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgQueue> arrayList = this.selectBySMSContentPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMSGQUEUE_PSDEFIELD_SMSCONTENTPSDEFID", "", iDataEntityModel.getName(), "PSSYSMSGQUEUE", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetSMSContentPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgQueue> arrayList = this.selectBySMSContentPSDEF(pSDEField);
        for (PSSysMsgQueue pSSysMsgQueue : arrayList) {
            PSSysMsgQueue pSSysMsgQueue2 = (PSSysMsgQueue)this.getDEModel().createEntity();
            pSSysMsgQueue2.setPSSysMsgQueueId(pSSysMsgQueue.getPSSysMsgQueueId());
            pSSysMsgQueue2.setSMSContentPSDEFId(null);
            this.update(pSSysMsgQueue2);
        }
    }

    public void removeBySMSContentPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMsgQueueServiceBase.this.onBeforeRemoveBySMSContentPSDEF(pSDEField2);
                PSSysMsgQueueServiceBase.this.internalRemoveBySMSContentPSDEF(pSDEField2);
                PSSysMsgQueueServiceBase.this.onAfterRemoveBySMSContentPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveBySMSContentPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveBySMSContentPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgQueue> arrayList = this.selectBySMSContentPSDEF(pSDEField);
        this.onBeforeRemoveBySMSContentPSDEF(pSDEField, arrayList);
        for (PSSysMsgQueue pSSysMsgQueue : arrayList) {
            this.remove((IEntity)pSSysMsgQueue);
        }
        this.onAfterRemoveBySMSContentPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveBySMSContentPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveBySMSContentPSDEF(PSDEField pSDEField, ArrayList<PSSysMsgQueue> arrayList) throws Exception {
    }

    protected void onAfterRemoveBySMSContentPSDEF(PSDEField pSDEField, ArrayList<PSSysMsgQueue> arrayList) throws Exception {
    }

    public void testRemoveByStatePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgQueue> arrayList = this.selectByStatePSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMSGQUEUE_PSDEFIELD_STATEPSDEFID", "", iDataEntityModel.getName(), "PSSYSMSGQUEUE", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetStatePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgQueue> arrayList = this.selectByStatePSDEF(pSDEField);
        for (PSSysMsgQueue pSSysMsgQueue : arrayList) {
            PSSysMsgQueue pSSysMsgQueue2 = (PSSysMsgQueue)this.getDEModel().createEntity();
            pSSysMsgQueue2.setPSSysMsgQueueId(pSSysMsgQueue.getPSSysMsgQueueId());
            pSSysMsgQueue2.setStatePSDEFId(null);
            this.update(pSSysMsgQueue2);
        }
    }

    public void removeByStatePSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMsgQueueServiceBase.this.onBeforeRemoveByStatePSDEF(pSDEField2);
                PSSysMsgQueueServiceBase.this.internalRemoveByStatePSDEF(pSDEField2);
                PSSysMsgQueueServiceBase.this.onAfterRemoveByStatePSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByStatePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByStatePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgQueue> arrayList = this.selectByStatePSDEF(pSDEField);
        this.onBeforeRemoveByStatePSDEF(pSDEField, arrayList);
        for (PSSysMsgQueue pSSysMsgQueue : arrayList) {
            this.remove((IEntity)pSSysMsgQueue);
        }
        this.onAfterRemoveByStatePSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByStatePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByStatePSDEF(PSDEField pSDEField, ArrayList<PSSysMsgQueue> arrayList) throws Exception {
    }

    protected void onAfterRemoveByStatePSDEF(PSDEField pSDEField, ArrayList<PSSysMsgQueue> arrayList) throws Exception {
    }

    public void testRemoveByTagPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgQueue> arrayList = this.selectByTagPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMSGQUEUE_PSDEFIELD_TAG2PSDEFID", "", iDataEntityModel.getName(), "PSSYSMSGQUEUE", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetTagPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgQueue> arrayList = this.selectByTagPSDEF(pSDEField);
        for (PSSysMsgQueue pSSysMsgQueue : arrayList) {
            PSSysMsgQueue pSSysMsgQueue2 = (PSSysMsgQueue)this.getDEModel().createEntity();
            pSSysMsgQueue2.setPSSysMsgQueueId(pSSysMsgQueue.getPSSysMsgQueueId());
            pSSysMsgQueue2.setTag2PSDEFId(null);
            this.update(pSSysMsgQueue2);
        }
    }

    public void removeByTagPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMsgQueueServiceBase.this.onBeforeRemoveByTagPSDEF(pSDEField2);
                PSSysMsgQueueServiceBase.this.internalRemoveByTagPSDEF(pSDEField2);
                PSSysMsgQueueServiceBase.this.onAfterRemoveByTagPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByTagPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByTagPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgQueue> arrayList = this.selectByTagPSDEF(pSDEField);
        this.onBeforeRemoveByTagPSDEF(pSDEField, arrayList);
        for (PSSysMsgQueue pSSysMsgQueue : arrayList) {
            this.remove((IEntity)pSSysMsgQueue);
        }
        this.onAfterRemoveByTagPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByTagPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByTagPSDEF(PSDEField pSDEField, ArrayList<PSSysMsgQueue> arrayList) throws Exception {
    }

    protected void onAfterRemoveByTagPSDEF(PSDEField pSDEField, ArrayList<PSSysMsgQueue> arrayList) throws Exception {
    }

    public void testRemoveByTag2PSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgQueue> arrayList = this.selectByTag2PSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMSGQUEUE_PSDEFIELD_TAGPSDEFID", "", iDataEntityModel.getName(), "PSSYSMSGQUEUE", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetTag2PSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgQueue> arrayList = this.selectByTag2PSDEF(pSDEField);
        for (PSSysMsgQueue pSSysMsgQueue : arrayList) {
            PSSysMsgQueue pSSysMsgQueue2 = (PSSysMsgQueue)this.getDEModel().createEntity();
            pSSysMsgQueue2.setPSSysMsgQueueId(pSSysMsgQueue.getPSSysMsgQueueId());
            pSSysMsgQueue2.setTagPSDEFId(null);
            this.update(pSSysMsgQueue2);
        }
    }

    public void removeByTag2PSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMsgQueueServiceBase.this.onBeforeRemoveByTag2PSDEF(pSDEField2);
                PSSysMsgQueueServiceBase.this.internalRemoveByTag2PSDEF(pSDEField2);
                PSSysMsgQueueServiceBase.this.onAfterRemoveByTag2PSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByTag2PSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByTag2PSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgQueue> arrayList = this.selectByTag2PSDEF(pSDEField);
        this.onBeforeRemoveByTag2PSDEF(pSDEField, arrayList);
        for (PSSysMsgQueue pSSysMsgQueue : arrayList) {
            this.remove((IEntity)pSSysMsgQueue);
        }
        this.onAfterRemoveByTag2PSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByTag2PSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByTag2PSDEF(PSDEField pSDEField, ArrayList<PSSysMsgQueue> arrayList) throws Exception {
    }

    protected void onAfterRemoveByTag2PSDEF(PSDEField pSDEField, ArrayList<PSSysMsgQueue> arrayList) throws Exception {
    }

    public void testRemoveByTargetPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgQueue> arrayList = this.selectByTargetPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMSGQUEUE_PSDEFIELD_TARGETPSDEFID", "", iDataEntityModel.getName(), "PSSYSMSGQUEUE", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetTargetPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgQueue> arrayList = this.selectByTargetPSDEF(pSDEField);
        for (PSSysMsgQueue pSSysMsgQueue : arrayList) {
            PSSysMsgQueue pSSysMsgQueue2 = (PSSysMsgQueue)this.getDEModel().createEntity();
            pSSysMsgQueue2.setPSSysMsgQueueId(pSSysMsgQueue.getPSSysMsgQueueId());
            pSSysMsgQueue2.setTargetPSDEFId(null);
            this.update(pSSysMsgQueue2);
        }
    }

    public void removeByTargetPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMsgQueueServiceBase.this.onBeforeRemoveByTargetPSDEF(pSDEField2);
                PSSysMsgQueueServiceBase.this.internalRemoveByTargetPSDEF(pSDEField2);
                PSSysMsgQueueServiceBase.this.onAfterRemoveByTargetPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByTargetPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByTargetPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgQueue> arrayList = this.selectByTargetPSDEF(pSDEField);
        this.onBeforeRemoveByTargetPSDEF(pSDEField, arrayList);
        for (PSSysMsgQueue pSSysMsgQueue : arrayList) {
            this.remove((IEntity)pSSysMsgQueue);
        }
        this.onAfterRemoveByTargetPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByTargetPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByTargetPSDEF(PSDEField pSDEField, ArrayList<PSSysMsgQueue> arrayList) throws Exception {
    }

    protected void onAfterRemoveByTargetPSDEF(PSDEField pSDEField, ArrayList<PSSysMsgQueue> arrayList) throws Exception {
    }

    public void testRemoveByTargetTypePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgQueue> arrayList = this.selectByTargetTypePSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMSGQUEUE_PSDEFIELD_TARGETTYPEPSDEFID", "", iDataEntityModel.getName(), "PSSYSMSGQUEUE", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetTargetTypePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgQueue> arrayList = this.selectByTargetTypePSDEF(pSDEField);
        for (PSSysMsgQueue pSSysMsgQueue : arrayList) {
            PSSysMsgQueue pSSysMsgQueue2 = (PSSysMsgQueue)this.getDEModel().createEntity();
            pSSysMsgQueue2.setPSSysMsgQueueId(pSSysMsgQueue.getPSSysMsgQueueId());
            pSSysMsgQueue2.setTargetTypePSDEFId(null);
            this.update(pSSysMsgQueue2);
        }
    }

    public void removeByTargetTypePSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMsgQueueServiceBase.this.onBeforeRemoveByTargetTypePSDEF(pSDEField2);
                PSSysMsgQueueServiceBase.this.internalRemoveByTargetTypePSDEF(pSDEField2);
                PSSysMsgQueueServiceBase.this.onAfterRemoveByTargetTypePSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByTargetTypePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByTargetTypePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgQueue> arrayList = this.selectByTargetTypePSDEF(pSDEField);
        this.onBeforeRemoveByTargetTypePSDEF(pSDEField, arrayList);
        for (PSSysMsgQueue pSSysMsgQueue : arrayList) {
            this.remove((IEntity)pSSysMsgQueue);
        }
        this.onAfterRemoveByTargetTypePSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByTargetTypePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByTargetTypePSDEF(PSDEField pSDEField, ArrayList<PSSysMsgQueue> arrayList) throws Exception {
    }

    protected void onAfterRemoveByTargetTypePSDEF(PSDEField pSDEField, ArrayList<PSSysMsgQueue> arrayList) throws Exception {
    }

    public void testRemoveByTaskUrlPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgQueue> arrayList = this.selectByTaskUrlPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMSGQUEUE_PSDEFIELD_TASKURLPSDEFID", "", iDataEntityModel.getName(), "PSSYSMSGQUEUE", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetTaskUrlPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgQueue> arrayList = this.selectByTaskUrlPSDEF(pSDEField);
        for (PSSysMsgQueue pSSysMsgQueue : arrayList) {
            PSSysMsgQueue pSSysMsgQueue2 = (PSSysMsgQueue)this.getDEModel().createEntity();
            pSSysMsgQueue2.setPSSysMsgQueueId(pSSysMsgQueue.getPSSysMsgQueueId());
            pSSysMsgQueue2.setTaskUrlPSDEFId(null);
            this.update(pSSysMsgQueue2);
        }
    }

    public void removeByTaskUrlPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMsgQueueServiceBase.this.onBeforeRemoveByTaskUrlPSDEF(pSDEField2);
                PSSysMsgQueueServiceBase.this.internalRemoveByTaskUrlPSDEF(pSDEField2);
                PSSysMsgQueueServiceBase.this.onAfterRemoveByTaskUrlPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByTaskUrlPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByTaskUrlPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgQueue> arrayList = this.selectByTaskUrlPSDEF(pSDEField);
        this.onBeforeRemoveByTaskUrlPSDEF(pSDEField, arrayList);
        for (PSSysMsgQueue pSSysMsgQueue : arrayList) {
            this.remove((IEntity)pSSysMsgQueue);
        }
        this.onAfterRemoveByTaskUrlPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByTaskUrlPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByTaskUrlPSDEF(PSDEField pSDEField, ArrayList<PSSysMsgQueue> arrayList) throws Exception {
    }

    protected void onAfterRemoveByTaskUrlPSDEF(PSDEField pSDEField, ArrayList<PSSysMsgQueue> arrayList) throws Exception {
    }

    public void testRemoveByTitlePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgQueue> arrayList = this.selectByTitlePSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMSGQUEUE_PSDEFIELD_TITLEPSDEFID", "", iDataEntityModel.getName(), "PSSYSMSGQUEUE", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetTitlePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgQueue> arrayList = this.selectByTitlePSDEF(pSDEField);
        for (PSSysMsgQueue pSSysMsgQueue : arrayList) {
            PSSysMsgQueue pSSysMsgQueue2 = (PSSysMsgQueue)this.getDEModel().createEntity();
            pSSysMsgQueue2.setPSSysMsgQueueId(pSSysMsgQueue.getPSSysMsgQueueId());
            pSSysMsgQueue2.setTitlePSDEFId(null);
            this.update(pSSysMsgQueue2);
        }
    }

    public void removeByTitlePSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMsgQueueServiceBase.this.onBeforeRemoveByTitlePSDEF(pSDEField2);
                PSSysMsgQueueServiceBase.this.internalRemoveByTitlePSDEF(pSDEField2);
                PSSysMsgQueueServiceBase.this.onAfterRemoveByTitlePSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByTitlePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByTitlePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgQueue> arrayList = this.selectByTitlePSDEF(pSDEField);
        this.onBeforeRemoveByTitlePSDEF(pSDEField, arrayList);
        for (PSSysMsgQueue pSSysMsgQueue : arrayList) {
            this.remove((IEntity)pSSysMsgQueue);
        }
        this.onAfterRemoveByTitlePSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByTitlePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByTitlePSDEF(PSDEField pSDEField, ArrayList<PSSysMsgQueue> arrayList) throws Exception {
    }

    protected void onAfterRemoveByTitlePSDEF(PSDEField pSDEField, ArrayList<PSSysMsgQueue> arrayList) throws Exception {
    }

    public void testRemoveByUser2PSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgQueue> arrayList = this.selectByUser2PSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMSGQUEUE_PSDEFIELD_USER2PSDEFID", "", iDataEntityModel.getName(), "PSSYSMSGQUEUE", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetUser2PSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgQueue> arrayList = this.selectByUser2PSDEF(pSDEField);
        for (PSSysMsgQueue pSSysMsgQueue : arrayList) {
            PSSysMsgQueue pSSysMsgQueue2 = (PSSysMsgQueue)this.getDEModel().createEntity();
            pSSysMsgQueue2.setPSSysMsgQueueId(pSSysMsgQueue.getPSSysMsgQueueId());
            pSSysMsgQueue2.setUser2PSDEFId(null);
            this.update(pSSysMsgQueue2);
        }
    }

    public void removeByUser2PSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMsgQueueServiceBase.this.onBeforeRemoveByUser2PSDEF(pSDEField2);
                PSSysMsgQueueServiceBase.this.internalRemoveByUser2PSDEF(pSDEField2);
                PSSysMsgQueueServiceBase.this.onAfterRemoveByUser2PSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByUser2PSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByUser2PSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgQueue> arrayList = this.selectByUser2PSDEF(pSDEField);
        this.onBeforeRemoveByUser2PSDEF(pSDEField, arrayList);
        for (PSSysMsgQueue pSSysMsgQueue : arrayList) {
            this.remove((IEntity)pSSysMsgQueue);
        }
        this.onAfterRemoveByUser2PSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByUser2PSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByUser2PSDEF(PSDEField pSDEField, ArrayList<PSSysMsgQueue> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUser2PSDEF(PSDEField pSDEField, ArrayList<PSSysMsgQueue> arrayList) throws Exception {
    }

    public void testRemoveByUserPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgQueue> arrayList = this.selectByUserPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMSGQUEUE_PSDEFIELD_USERPSDEFID", "", iDataEntityModel.getName(), "PSSYSMSGQUEUE", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetUserPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgQueue> arrayList = this.selectByUserPSDEF(pSDEField);
        for (PSSysMsgQueue pSSysMsgQueue : arrayList) {
            PSSysMsgQueue pSSysMsgQueue2 = (PSSysMsgQueue)this.getDEModel().createEntity();
            pSSysMsgQueue2.setPSSysMsgQueueId(pSSysMsgQueue.getPSSysMsgQueueId());
            pSSysMsgQueue2.setUserPSDEFId(null);
            this.update(pSSysMsgQueue2);
        }
    }

    public void removeByUserPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMsgQueueServiceBase.this.onBeforeRemoveByUserPSDEF(pSDEField2);
                PSSysMsgQueueServiceBase.this.internalRemoveByUserPSDEF(pSDEField2);
                PSSysMsgQueueServiceBase.this.onAfterRemoveByUserPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByUserPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByUserPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgQueue> arrayList = this.selectByUserPSDEF(pSDEField);
        this.onBeforeRemoveByUserPSDEF(pSDEField, arrayList);
        for (PSSysMsgQueue pSSysMsgQueue : arrayList) {
            this.remove((IEntity)pSSysMsgQueue);
        }
        this.onAfterRemoveByUserPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByUserPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByUserPSDEF(PSDEField pSDEField, ArrayList<PSSysMsgQueue> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUserPSDEF(PSDEField pSDEField, ArrayList<PSSysMsgQueue> arrayList) throws Exception {
    }

    public void testRemoveByWXContentPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgQueue> arrayList = this.selectByWXContentPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMSGQUEUE_PSDEFIELD_WXCONTENTPSDEFID", "", iDataEntityModel.getName(), "PSSYSMSGQUEUE", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetWXContentPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgQueue> arrayList = this.selectByWXContentPSDEF(pSDEField);
        for (PSSysMsgQueue pSSysMsgQueue : arrayList) {
            PSSysMsgQueue pSSysMsgQueue2 = (PSSysMsgQueue)this.getDEModel().createEntity();
            pSSysMsgQueue2.setPSSysMsgQueueId(pSSysMsgQueue.getPSSysMsgQueueId());
            pSSysMsgQueue2.setWXContentPSDEFId(null);
            this.update(pSSysMsgQueue2);
        }
    }

    public void removeByWXContentPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMsgQueueServiceBase.this.onBeforeRemoveByWXContentPSDEF(pSDEField2);
                PSSysMsgQueueServiceBase.this.internalRemoveByWXContentPSDEF(pSDEField2);
                PSSysMsgQueueServiceBase.this.onAfterRemoveByWXContentPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByWXContentPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByWXContentPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgQueue> arrayList = this.selectByWXContentPSDEF(pSDEField);
        this.onBeforeRemoveByWXContentPSDEF(pSDEField, arrayList);
        for (PSSysMsgQueue pSSysMsgQueue : arrayList) {
            this.remove((IEntity)pSSysMsgQueue);
        }
        this.onAfterRemoveByWXContentPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByWXContentPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByWXContentPSDEF(PSDEField pSDEField, ArrayList<PSSysMsgQueue> arrayList) throws Exception {
    }

    protected void onAfterRemoveByWXContentPSDEF(PSDEField pSDEField, ArrayList<PSSysMsgQueue> arrayList) throws Exception {
    }

    public void testRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSysMsgQueue> arrayList = this.selectByPSModule(pSModule, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSMODULE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSModule);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMSGQUEUE_PSMODULE_PSMODULEID", "", iDataEntityModel.getName(), "PSSYSMSGQUEUE", iDataEntityModel.getDataInfo((IEntity)pSModule), arrayList.get(0)));
        }
    }

    public void resetPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSysMsgQueue> arrayList = this.selectByPSModule(pSModule);
        for (PSSysMsgQueue pSSysMsgQueue : arrayList) {
            PSSysMsgQueue pSSysMsgQueue2 = (PSSysMsgQueue)this.getDEModel().createEntity();
            pSSysMsgQueue2.setPSSysMsgQueueId(pSSysMsgQueue.getPSSysMsgQueueId());
            pSSysMsgQueue2.setPSModuleId(null);
            this.update(pSSysMsgQueue2);
        }
    }

    public void removeByPSModule(PSModule pSModule) throws Exception {
        final PSModule pSModule2 = pSModule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMsgQueueServiceBase.this.onBeforeRemoveByPSModule(pSModule2);
                PSSysMsgQueueServiceBase.this.internalRemoveByPSModule(pSModule2);
                PSSysMsgQueueServiceBase.this.onAfterRemoveByPSModule(pSModule2);
            }
        });
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void internalRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSysMsgQueue> arrayList = this.selectByPSModule(pSModule);
        this.onBeforeRemoveByPSModule(pSModule, arrayList);
        for (PSSysMsgQueue pSSysMsgQueue : arrayList) {
            this.remove((IEntity)pSSysMsgQueue);
        }
        this.onAfterRemoveByPSModule(pSModule, arrayList);
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule, ArrayList<PSSysMsgQueue> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule, ArrayList<PSSysMsgQueue> arrayList) throws Exception {
    }

    public void testRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSSysMsgQueue> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSDYNAMODEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysDynaModel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMSGQUEUE_PSSYSDYNAMODEL_PSSYSDYNAMODELID", "", iDataEntityModel.getName(), "PSSYSMSGQUEUE", iDataEntityModel.getDataInfo((IEntity)pSSysDynaModel), arrayList.get(0)));
        }
    }

    public void resetPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSSysMsgQueue> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        for (PSSysMsgQueue pSSysMsgQueue : arrayList) {
            PSSysMsgQueue pSSysMsgQueue2 = (PSSysMsgQueue)this.getDEModel().createEntity();
            pSSysMsgQueue2.setPSSysMsgQueueId(pSSysMsgQueue.getPSSysMsgQueueId());
            pSSysMsgQueue2.setPSSysDynaModelId(null);
            this.update(pSSysMsgQueue2);
        }
    }

    public void removeByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        final PSSysDynaModel pSSysDynaModel2 = pSSysDynaModel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMsgQueueServiceBase.this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSSysMsgQueueServiceBase.this.internalRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSSysMsgQueueServiceBase.this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void internalRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSSysMsgQueue> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
        for (PSSysMsgQueue pSSysMsgQueue : arrayList) {
            this.remove((IEntity)pSSysMsgQueue);
        }
        this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSSysMsgQueue> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSSysMsgQueue> arrayList) throws Exception {
    }

    public void testRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSSysMsgQueue> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSSFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysSFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMSGQUEUE_PSSYSSFPLUGIN_PSSYSSFPLUGINID", "", iDataEntityModel.getName(), "PSSYSMSGQUEUE", iDataEntityModel.getDataInfo((IEntity)pSSysSFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSSysMsgQueue> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        for (PSSysMsgQueue pSSysMsgQueue : arrayList) {
            PSSysMsgQueue pSSysMsgQueue2 = (PSSysMsgQueue)this.getDEModel().createEntity();
            pSSysMsgQueue2.setPSSysMsgQueueId(pSSysMsgQueue.getPSSysMsgQueueId());
            pSSysMsgQueue2.setPSSysSFPluginId(null);
            this.update(pSSysMsgQueue2);
        }
    }

    public void removeByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        final PSSysSFPlugin pSSysSFPlugin2 = pSSysSFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMsgQueueServiceBase.this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSSysMsgQueueServiceBase.this.internalRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSSysMsgQueueServiceBase.this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSSysMsgQueue> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
        for (PSSysMsgQueue pSSysMsgQueue : arrayList) {
            this.remove((IEntity)pSSysMsgQueue);
        }
        this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSSysMsgQueue> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSSysMsgQueue> arrayList) throws Exception {
    }

    public void testRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    public void resetPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysMsgQueue> arrayList = this.selectByPSSystem(pSSystem);
        for (PSSysMsgQueue pSSysMsgQueue : arrayList) {
            PSSysMsgQueue pSSysMsgQueue2 = (PSSysMsgQueue)this.getDEModel().createEntity();
            pSSysMsgQueue2.setPSSysMsgQueueId(pSSysMsgQueue.getPSSysMsgQueueId());
            pSSysMsgQueue2.setPSSystemId(null);
            this.update(pSSysMsgQueue2);
        }
    }

    public void removeByPSSystem(PSSystem pSSystem) throws Exception {
        final PSSystem pSSystem2 = pSSystem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMsgQueueServiceBase.this.onBeforeRemoveByPSSystem(pSSystem2);
                PSSysMsgQueueServiceBase.this.internalRemoveByPSSystem(pSSystem2);
                PSSysMsgQueueServiceBase.this.onAfterRemoveByPSSystem(pSSystem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void internalRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysMsgQueue> arrayList = this.selectByPSSystem(pSSystem);
        this.onBeforeRemoveByPSSystem(pSSystem, arrayList);
        for (PSSysMsgQueue pSSysMsgQueue : arrayList) {
            this.remove((IEntity)pSSysMsgQueue);
        }
        this.onAfterRemoveByPSSystem(pSSystem, arrayList);
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSysMsgQueue> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSysMsgQueue> arrayList) throws Exception {
    }

    public void testRemoveByPSSysUtilDE(PSSysUtilDE pSSysUtilDE) throws Exception {
        ArrayList<PSSysMsgQueue> arrayList = this.selectByPSSysUtilDE(pSSysUtilDE, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSUTILDE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysUtilDE);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMSGQUEUE_PSSYSUTILDE_PSSYSUTILDEID", "", iDataEntityModel.getName(), "PSSYSMSGQUEUE", iDataEntityModel.getDataInfo((IEntity)pSSysUtilDE), arrayList.get(0)));
        }
    }

    public void resetPSSysUtilDE(PSSysUtilDE pSSysUtilDE) throws Exception {
        ArrayList<PSSysMsgQueue> arrayList = this.selectByPSSysUtilDE(pSSysUtilDE);
        for (PSSysMsgQueue pSSysMsgQueue : arrayList) {
            PSSysMsgQueue pSSysMsgQueue2 = (PSSysMsgQueue)this.getDEModel().createEntity();
            pSSysMsgQueue2.setPSSysMsgQueueId(pSSysMsgQueue.getPSSysMsgQueueId());
            pSSysMsgQueue2.setPSSysUtilDEId(null);
            this.update(pSSysMsgQueue2);
        }
    }

    public void removeByPSSysUtilDE(PSSysUtilDE pSSysUtilDE) throws Exception {
        final PSSysUtilDE pSSysUtilDE2 = pSSysUtilDE;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMsgQueueServiceBase.this.onBeforeRemoveByPSSysUtilDE(pSSysUtilDE2);
                PSSysMsgQueueServiceBase.this.internalRemoveByPSSysUtilDE(pSSysUtilDE2);
                PSSysMsgQueueServiceBase.this.onAfterRemoveByPSSysUtilDE(pSSysUtilDE2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysUtilDE(PSSysUtilDE pSSysUtilDE) throws Exception {
    }

    protected void internalRemoveByPSSysUtilDE(PSSysUtilDE pSSysUtilDE) throws Exception {
        ArrayList<PSSysMsgQueue> arrayList = this.selectByPSSysUtilDE(pSSysUtilDE);
        this.onBeforeRemoveByPSSysUtilDE(pSSysUtilDE, arrayList);
        for (PSSysMsgQueue pSSysMsgQueue : arrayList) {
            this.remove((IEntity)pSSysMsgQueue);
        }
        this.onAfterRemoveByPSSysUtilDE(pSSysUtilDE, arrayList);
    }

    protected void onAfterRemoveByPSSysUtilDE(PSSysUtilDE pSSysUtilDE) throws Exception {
    }

    protected void onBeforeRemoveByPSSysUtilDE(PSSysUtilDE pSSysUtilDE, ArrayList<PSSysMsgQueue> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysUtilDE(PSSysUtilDE pSSysUtilDE, ArrayList<PSSysMsgQueue> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysMsgQueue pSSysMsgQueue) throws Exception {
        PSDENotifyService pSDENotifyService = (PSDENotifyService)ServiceGlobal.getService(PSDENotifyService.class, (SessionFactory)this.getSessionFactory());
        pSDENotifyService.testRemoveByPSSysMsgQueue(pSSysMsgQueue);
        super.onBeforeRemove(pSSysMsgQueue);
    }

    protected void replaceParentInfo(PSSysMsgQueue pSSysMsgQueue, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSSysMsgQueue, cloneSession);
        if (pSSysMsgQueue.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSSysMsgQueue.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSSysMsgQueue, (PSDataEntity)iEntity);
        }
        if (pSSysMsgQueue.getContentPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysMsgQueue.getContentPSDEFId())) != null) {
            this.onFillParentInfo_ContentPSDEF(pSSysMsgQueue, (PSDEField)iEntity);
        }
        if (pSSysMsgQueue.getContentTypePSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysMsgQueue.getContentTypePSDEFId())) != null) {
            this.onFillParentInfo_ContentTypePSDEF(pSSysMsgQueue, (PSDEField)iEntity);
        }
        if (pSSysMsgQueue.getDDContentPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysMsgQueue.getDDContentPSDEFId())) != null) {
            this.onFillParentInfo_DDContentPSDEF(pSSysMsgQueue, (PSDEField)iEntity);
        }
        if (pSSysMsgQueue.getFilePSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysMsgQueue.getFilePSDEFId())) != null) {
            this.onFillParentInfo_FilePSDEF(pSSysMsgQueue, (PSDEField)iEntity);
        }
        if (pSSysMsgQueue.getIMContentPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysMsgQueue.getIMContentPSDEFId())) != null) {
            this.onFillParentInfo_IMContentPSDEF(pSSysMsgQueue, (PSDEField)iEntity);
        }
        if (pSSysMsgQueue.getMobTaskUrlPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysMsgQueue.getMobTaskUrlPSDEFId())) != null) {
            this.onFillParentInfo_MobTaskUrlPSDEF(pSSysMsgQueue, (PSDEField)iEntity);
        }
        if (pSSysMsgQueue.getMsgTypePSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysMsgQueue.getMsgTypePSDEFId())) != null) {
            this.onFillParentInfo_MsgTypePSDEF(pSSysMsgQueue, (PSDEField)iEntity);
        }
        if (pSSysMsgQueue.getSendTimePSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysMsgQueue.getSendTimePSDEFId())) != null) {
            this.onFillParentInfo_SendTimePSDEF(pSSysMsgQueue, (PSDEField)iEntity);
        }
        if (pSSysMsgQueue.getSMSContentPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysMsgQueue.getSMSContentPSDEFId())) != null) {
            this.onFillParentInfo_SMSContentPSDEF(pSSysMsgQueue, (PSDEField)iEntity);
        }
        if (pSSysMsgQueue.getStatePSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysMsgQueue.getStatePSDEFId())) != null) {
            this.onFillParentInfo_StatePSDEF(pSSysMsgQueue, (PSDEField)iEntity);
        }
        if (pSSysMsgQueue.getTag2PSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysMsgQueue.getTag2PSDEFId())) != null) {
            this.onFillParentInfo_TagPSDEF(pSSysMsgQueue, (PSDEField)iEntity);
        }
        if (pSSysMsgQueue.getTagPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysMsgQueue.getTagPSDEFId())) != null) {
            this.onFillParentInfo_Tag2PSDEF(pSSysMsgQueue, (PSDEField)iEntity);
        }
        if (pSSysMsgQueue.getTargetPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysMsgQueue.getTargetPSDEFId())) != null) {
            this.onFillParentInfo_TargetPSDEF(pSSysMsgQueue, (PSDEField)iEntity);
        }
        if (pSSysMsgQueue.getTargetTypePSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysMsgQueue.getTargetTypePSDEFId())) != null) {
            this.onFillParentInfo_TargetTypePSDEF(pSSysMsgQueue, (PSDEField)iEntity);
        }
        if (pSSysMsgQueue.getTaskUrlPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysMsgQueue.getTaskUrlPSDEFId())) != null) {
            this.onFillParentInfo_TaskUrlPSDEF(pSSysMsgQueue, (PSDEField)iEntity);
        }
        if (pSSysMsgQueue.getTitlePSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysMsgQueue.getTitlePSDEFId())) != null) {
            this.onFillParentInfo_TitlePSDEF(pSSysMsgQueue, (PSDEField)iEntity);
        }
        if (pSSysMsgQueue.getUser2PSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysMsgQueue.getUser2PSDEFId())) != null) {
            this.onFillParentInfo_User2PSDEF(pSSysMsgQueue, (PSDEField)iEntity);
        }
        if (pSSysMsgQueue.getUserPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysMsgQueue.getUserPSDEFId())) != null) {
            this.onFillParentInfo_UserPSDEF(pSSysMsgQueue, (PSDEField)iEntity);
        }
        if (pSSysMsgQueue.getWXContentPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysMsgQueue.getWXContentPSDEFId())) != null) {
            this.onFillParentInfo_WXContentPSDEF(pSSysMsgQueue, (PSDEField)iEntity);
        }
        if (pSSysMsgQueue.getPSModuleId() != null && (iEntity = cloneSession.getEntity("PSMODULE", (Object)pSSysMsgQueue.getPSModuleId())) != null) {
            this.onFillParentInfo_PSModule(pSSysMsgQueue, (PSModule)iEntity);
        }
        if (pSSysMsgQueue.getPSSysDynaModelId() != null && (iEntity = cloneSession.getEntity("PSSYSDYNAMODEL", (Object)pSSysMsgQueue.getPSSysDynaModelId())) != null) {
            this.onFillParentInfo_PSSysDynaModel(pSSysMsgQueue, (PSSysDynaModel)iEntity);
        }
        if (pSSysMsgQueue.getPSSysSFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSSFPLUGIN", (Object)pSSysMsgQueue.getPSSysSFPluginId())) != null) {
            this.onFillParentInfo_PSSysSFPlugin(pSSysMsgQueue, (PSSysSFPlugin)iEntity);
        }
        if (pSSysMsgQueue.getPSSystemId() != null && (iEntity = cloneSession.getEntity("PSSYSTEM", (Object)pSSysMsgQueue.getPSSystemId())) != null) {
            this.onFillParentInfo_PSSystem(pSSysMsgQueue, (PSSystem)iEntity);
        }
        if (pSSysMsgQueue.getPSSysUtilDEId() != null && (iEntity = cloneSession.getEntity("PSSYSUTILDE", (Object)pSSysMsgQueue.getPSSysUtilDEId())) != null) {
            this.onFillParentInfo_PSSysUtilDE(pSSysMsgQueue, (PSSysUtilDE)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysMsgQueue pSSysMsgQueue, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSSysMsgQueue, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysMsgQueue pSSysMsgQueue, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CodeName(bl, pSSysMsgQueue, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ContentPSDEFId(bl, pSSysMsgQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ContentPSDEFName(bl, pSSysMsgQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ContentTypePSDEFId(bl, pSSysMsgQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ContentTypePSDEFName(bl, pSSysMsgQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomCode(bl, pSSysMsgQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomMode(bl, pSSysMsgQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DDContentPSDEFId(bl, pSSysMsgQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DDContentPSDEFName(bl, pSSysMsgQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FilePSDEFId(bl, pSSysMsgQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FilePSDEFName(bl, pSSysMsgQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IMContentPSDEFId(bl, pSSysMsgQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IMContentPSDEFName(bl, pSSysMsgQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysMsgQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MobTaskUrlPSDEFId(bl, pSSysMsgQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MobTaskUrlPSDEFName(bl, pSSysMsgQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MsgQueueParams(bl, pSSysMsgQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MsgQueueTag(bl, pSSysMsgQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MsgQueueTag2(bl, pSSysMsgQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MsgQueueType(bl, pSSysMsgQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MsgTypePSDEFId(bl, pSSysMsgQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MsgTypePSDEFName(bl, pSSysMsgQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSSysMsgQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSSysMsgQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModuleId(bl, pSSysMsgQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDynaModelId(bl, pSSysMsgQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysMsgQueueId(bl, pSSysMsgQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysMsgQueueName(bl, pSSysMsgQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSFPluginId(bl, pSSysMsgQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSSysMsgQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysUtilDEId(bl, pSSysMsgQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_QueueParams(bl, pSSysMsgQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SendTimePSDEFId(bl, pSSysMsgQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SendTimePSDEFName(bl, pSSysMsgQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SMSContentPSDEFId(bl, pSSysMsgQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SMSContentPSDEFName(bl, pSSysMsgQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_StatePSDEFId(bl, pSSysMsgQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_StatePSDEFName(bl, pSSysMsgQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Tag2PSDEFId(bl, pSSysMsgQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Tag2PSDEFName(bl, pSSysMsgQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TagPSDEFId(bl, pSSysMsgQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TagPSDEFName(bl, pSSysMsgQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TargetPSDEFId(bl, pSSysMsgQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TargetPSDEFName(bl, pSSysMsgQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TargetTypePSDEFId(bl, pSSysMsgQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TargetTypePSDEFName(bl, pSSysMsgQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TaskUrlPSDEFId(bl, pSSysMsgQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TaskUrlPSDEFName(bl, pSSysMsgQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TitlePSDEFId(bl, pSSysMsgQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TitlePSDEFName(bl, pSSysMsgQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_User2PSDEFId(bl, pSSysMsgQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_User2PSDEFName(bl, pSSysMsgQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSysMsgQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserPSDEFId(bl, pSSysMsgQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserPSDEFName(bl, pSSysMsgQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysMsgQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysMsgQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSysMsgQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSysMsgQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSSysMsgQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WXContentPSDEFId(bl, pSSysMsgQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WXContentPSDEFName(bl, pSSysMsgQueue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSSysMsgQueue, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSSysMsgQueue pSSysMsgQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgQueue.isCodeNameDirty() && !bl2 : !pSSysMsgQueue.isCodeNameDirty()) {
            return null;
        }
        String string = pSSysMsgQueue.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default((IEntity)pSSysMsgQueue, bl2, bl3);
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
                String string4 = this.checkFieldDupRule(this.getPSSysMsgQueueDEModel(), "CODENAME", string3, pSSysMsgQueue, bl2, bl3);
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

    protected EntityFieldError onCheckField_ContentPSDEFId(boolean bl, PSSysMsgQueue pSSysMsgQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgQueue.isContentPSDEFIdDirty() : !pSSysMsgQueue.isContentPSDEFIdDirty()) {
            return null;
        }
        String string = pSSysMsgQueue.getContentPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ContentPSDEFId_Default((IEntity)pSSysMsgQueue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONTENTPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ContentPSDEFName(boolean bl, PSSysMsgQueue pSSysMsgQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgQueue.isContentPSDEFNameDirty() : !pSSysMsgQueue.isContentPSDEFNameDirty()) {
            return null;
        }
        String string = pSSysMsgQueue.getContentPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ContentPSDEFName_Default((IEntity)pSSysMsgQueue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONTENTPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ContentTypePSDEFId(boolean bl, PSSysMsgQueue pSSysMsgQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgQueue.isContentTypePSDEFIdDirty() : !pSSysMsgQueue.isContentTypePSDEFIdDirty()) {
            return null;
        }
        String string = pSSysMsgQueue.getContentTypePSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ContentTypePSDEFId_Default((IEntity)pSSysMsgQueue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONTENTTYPEPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ContentTypePSDEFName(boolean bl, PSSysMsgQueue pSSysMsgQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgQueue.isContentTypePSDEFNameDirty() : !pSSysMsgQueue.isContentTypePSDEFNameDirty()) {
            return null;
        }
        String string = pSSysMsgQueue.getContentTypePSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ContentTypePSDEFName_Default((IEntity)pSSysMsgQueue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONTENTTYPEPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CustomCode(boolean bl, PSSysMsgQueue pSSysMsgQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgQueue.isCustomCodeDirty() : !pSSysMsgQueue.isCustomCodeDirty()) {
            return null;
        }
        String string = pSSysMsgQueue.getCustomCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomCode_Default((IEntity)pSSysMsgQueue, bl2, bl3);
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

    protected EntityFieldError onCheckField_CustomMode(boolean bl, PSSysMsgQueue pSSysMsgQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgQueue.isCustomModeDirty() : !pSSysMsgQueue.isCustomModeDirty()) {
            return null;
        }
        Integer n = pSSysMsgQueue.getCustomMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CustomMode_Default((IEntity)pSSysMsgQueue, bl2, bl3);
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

    protected EntityFieldError onCheckField_DDContentPSDEFId(boolean bl, PSSysMsgQueue pSSysMsgQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgQueue.isDDContentPSDEFIdDirty() : !pSSysMsgQueue.isDDContentPSDEFIdDirty()) {
            return null;
        }
        String string = pSSysMsgQueue.getDDContentPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DDContentPSDEFId_Default((IEntity)pSSysMsgQueue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DDCONTENTPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DDContentPSDEFName(boolean bl, PSSysMsgQueue pSSysMsgQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgQueue.isDDContentPSDEFNameDirty() : !pSSysMsgQueue.isDDContentPSDEFNameDirty()) {
            return null;
        }
        String string = pSSysMsgQueue.getDDContentPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DDContentPSDEFName_Default((IEntity)pSSysMsgQueue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DDCONTENTPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FilePSDEFId(boolean bl, PSSysMsgQueue pSSysMsgQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgQueue.isFilePSDEFIdDirty() : !pSSysMsgQueue.isFilePSDEFIdDirty()) {
            return null;
        }
        String string = pSSysMsgQueue.getFilePSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FilePSDEFId_Default((IEntity)pSSysMsgQueue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FILEPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FilePSDEFName(boolean bl, PSSysMsgQueue pSSysMsgQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgQueue.isFilePSDEFNameDirty() : !pSSysMsgQueue.isFilePSDEFNameDirty()) {
            return null;
        }
        String string = pSSysMsgQueue.getFilePSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FilePSDEFName_Default((IEntity)pSSysMsgQueue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FILEPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IMContentPSDEFId(boolean bl, PSSysMsgQueue pSSysMsgQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgQueue.isIMContentPSDEFIdDirty() : !pSSysMsgQueue.isIMContentPSDEFIdDirty()) {
            return null;
        }
        String string = pSSysMsgQueue.getIMContentPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_IMContentPSDEFId_Default((IEntity)pSSysMsgQueue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("IMCONTENTPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IMContentPSDEFName(boolean bl, PSSysMsgQueue pSSysMsgQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgQueue.isIMContentPSDEFNameDirty() : !pSSysMsgQueue.isIMContentPSDEFNameDirty()) {
            return null;
        }
        String string = pSSysMsgQueue.getIMContentPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_IMContentPSDEFName_Default((IEntity)pSSysMsgQueue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("IMCONTENTPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysMsgQueue pSSysMsgQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgQueue.isMemoDirty() : !pSSysMsgQueue.isMemoDirty()) {
            return null;
        }
        String string = pSSysMsgQueue.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSSysMsgQueue, bl2, bl3);
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

    protected EntityFieldError onCheckField_MobTaskUrlPSDEFId(boolean bl, PSSysMsgQueue pSSysMsgQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgQueue.isMobTaskUrlPSDEFIdDirty() : !pSSysMsgQueue.isMobTaskUrlPSDEFIdDirty()) {
            return null;
        }
        String string = pSSysMsgQueue.getMobTaskUrlPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MobTaskUrlPSDEFId_Default((IEntity)pSSysMsgQueue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MOBTASKURLPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MobTaskUrlPSDEFName(boolean bl, PSSysMsgQueue pSSysMsgQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgQueue.isMobTaskUrlPSDEFNameDirty() : !pSSysMsgQueue.isMobTaskUrlPSDEFNameDirty()) {
            return null;
        }
        String string = pSSysMsgQueue.getMobTaskUrlPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MobTaskUrlPSDEFName_Default((IEntity)pSSysMsgQueue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MOBTASKURLPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MsgQueueParams(boolean bl, PSSysMsgQueue pSSysMsgQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgQueue.isMsgQueueParamsDirty() : !pSSysMsgQueue.isMsgQueueParamsDirty()) {
            return null;
        }
        String string = pSSysMsgQueue.getMsgQueueParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MsgQueueParams_Default((IEntity)pSSysMsgQueue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MSGQUEUEPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MsgQueueTag(boolean bl, PSSysMsgQueue pSSysMsgQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgQueue.isMsgQueueTagDirty() : !pSSysMsgQueue.isMsgQueueTagDirty()) {
            return null;
        }
        String string = pSSysMsgQueue.getMsgQueueTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MsgQueueTag_Default((IEntity)pSSysMsgQueue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MSGQUEUETAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MsgQueueTag2(boolean bl, PSSysMsgQueue pSSysMsgQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgQueue.isMsgQueueTag2Dirty() : !pSSysMsgQueue.isMsgQueueTag2Dirty()) {
            return null;
        }
        String string = pSSysMsgQueue.getMsgQueueTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MsgQueueTag2_Default((IEntity)pSSysMsgQueue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MSGQUEUETAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MsgQueueType(boolean bl, PSSysMsgQueue pSSysMsgQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgQueue.isMsgQueueTypeDirty() && !bl2 : !pSSysMsgQueue.isMsgQueueTypeDirty()) {
            return null;
        }
        String string = pSSysMsgQueue.getMsgQueueType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MSGQUEUETYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_MsgQueueType_Default((IEntity)pSSysMsgQueue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MSGQUEUETYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MsgTypePSDEFId(boolean bl, PSSysMsgQueue pSSysMsgQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgQueue.isMsgTypePSDEFIdDirty() : !pSSysMsgQueue.isMsgTypePSDEFIdDirty()) {
            return null;
        }
        String string = pSSysMsgQueue.getMsgTypePSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MsgTypePSDEFId_Default((IEntity)pSSysMsgQueue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MSGTYPEPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MsgTypePSDEFName(boolean bl, PSSysMsgQueue pSSysMsgQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgQueue.isMsgTypePSDEFNameDirty() : !pSSysMsgQueue.isMsgTypePSDEFNameDirty()) {
            return null;
        }
        String string = pSSysMsgQueue.getMsgTypePSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MsgTypePSDEFName_Default((IEntity)pSSysMsgQueue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MSGTYPEPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSSysMsgQueue pSSysMsgQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgQueue.isPSDEIdDirty() : !pSSysMsgQueue.isPSDEIdDirty()) {
            return null;
        }
        String string = pSSysMsgQueue.getPSDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default((IEntity)pSSysMsgQueue, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSSysMsgQueue pSSysMsgQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgQueue.isPSDENameDirty() : !pSSysMsgQueue.isPSDENameDirty()) {
            return null;
        }
        String string = pSSysMsgQueue.getPSDEName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default((IEntity)pSSysMsgQueue, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSModuleId(boolean bl, PSSysMsgQueue pSSysMsgQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgQueue.isPSModuleIdDirty() : !pSSysMsgQueue.isPSModuleIdDirty()) {
            return null;
        }
        String string = pSSysMsgQueue.getPSModuleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModuleId_Default((IEntity)pSSysMsgQueue, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysDynaModelId(boolean bl, PSSysMsgQueue pSSysMsgQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgQueue.isPSSysDynaModelIdDirty() : !pSSysMsgQueue.isPSSysDynaModelIdDirty()) {
            return null;
        }
        String string = pSSysMsgQueue.getPSSysDynaModelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDynaModelId_Default((IEntity)pSSysMsgQueue, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysMsgQueueId(boolean bl, PSSysMsgQueue pSSysMsgQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgQueue.isPSSysMsgQueueIdDirty() && !bl2 : !pSSysMsgQueue.isPSSysMsgQueueIdDirty()) {
            return null;
        }
        String string = pSSysMsgQueue.getPSSysMsgQueueId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSMSGQUEUEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysMsgQueueId_Default((IEntity)pSSysMsgQueue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSMSGQUEUEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysMsgQueueName(boolean bl, PSSysMsgQueue pSSysMsgQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgQueue.isPSSysMsgQueueNameDirty() && !bl2 : !pSSysMsgQueue.isPSSysMsgQueueNameDirty()) {
            return null;
        }
        String string = pSSysMsgQueue.getPSSysMsgQueueName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSMSGQUEUENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysMsgQueueName_Default((IEntity)pSSysMsgQueue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSMSGQUEUENAME");
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
                String string4 = this.checkFieldDupRule(this.getPSSysMsgQueueDEModel(), "PSSYSMSGQUEUENAME", string3, pSSysMsgQueue, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSSYSMSGQUEUENAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysSFPluginId(boolean bl, PSSysMsgQueue pSSysMsgQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgQueue.isPSSysSFPluginIdDirty() : !pSSysMsgQueue.isPSSysSFPluginIdDirty()) {
            return null;
        }
        String string = pSSysMsgQueue.getPSSysSFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSFPluginId_Default((IEntity)pSSysMsgQueue, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSSysMsgQueue pSSysMsgQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgQueue.isPSSystemIdDirty() : !pSSysMsgQueue.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSSysMsgQueue.getPSSystemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default((IEntity)pSSysMsgQueue, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysUtilDEId(boolean bl, PSSysMsgQueue pSSysMsgQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgQueue.isPSSysUtilDEIdDirty() : !pSSysMsgQueue.isPSSysUtilDEIdDirty()) {
            return null;
        }
        String string = pSSysMsgQueue.getPSSysUtilDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysUtilDEId_Default((IEntity)pSSysMsgQueue, bl2, bl3);
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

    protected EntityFieldError onCheckField_QueueParams(boolean bl, PSSysMsgQueue pSSysMsgQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgQueue.isQueueParamsDirty() : !pSSysMsgQueue.isQueueParamsDirty()) {
            return null;
        }
        String string = pSSysMsgQueue.getQueueParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_QueueParams_Default((IEntity)pSSysMsgQueue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("QUEUEPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SendTimePSDEFId(boolean bl, PSSysMsgQueue pSSysMsgQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgQueue.isSendTimePSDEFIdDirty() : !pSSysMsgQueue.isSendTimePSDEFIdDirty()) {
            return null;
        }
        String string = pSSysMsgQueue.getSendTimePSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SendTimePSDEFId_Default((IEntity)pSSysMsgQueue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SENDTIMEPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SendTimePSDEFName(boolean bl, PSSysMsgQueue pSSysMsgQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgQueue.isSendTimePSDEFNameDirty() : !pSSysMsgQueue.isSendTimePSDEFNameDirty()) {
            return null;
        }
        String string = pSSysMsgQueue.getSendTimePSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SendTimePSDEFName_Default((IEntity)pSSysMsgQueue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SENDTIMEPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SMSContentPSDEFId(boolean bl, PSSysMsgQueue pSSysMsgQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgQueue.isSMSContentPSDEFIdDirty() : !pSSysMsgQueue.isSMSContentPSDEFIdDirty()) {
            return null;
        }
        String string = pSSysMsgQueue.getSMSContentPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SMSContentPSDEFId_Default((IEntity)pSSysMsgQueue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SMSCONTENTPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SMSContentPSDEFName(boolean bl, PSSysMsgQueue pSSysMsgQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgQueue.isSMSContentPSDEFNameDirty() : !pSSysMsgQueue.isSMSContentPSDEFNameDirty()) {
            return null;
        }
        String string = pSSysMsgQueue.getSMSContentPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SMSContentPSDEFName_Default((IEntity)pSSysMsgQueue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SMSCONTENTPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_StatePSDEFId(boolean bl, PSSysMsgQueue pSSysMsgQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgQueue.isStatePSDEFIdDirty() : !pSSysMsgQueue.isStatePSDEFIdDirty()) {
            return null;
        }
        String string = pSSysMsgQueue.getStatePSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_StatePSDEFId_Default((IEntity)pSSysMsgQueue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STATEPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_StatePSDEFName(boolean bl, PSSysMsgQueue pSSysMsgQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgQueue.isStatePSDEFNameDirty() : !pSSysMsgQueue.isStatePSDEFNameDirty()) {
            return null;
        }
        String string = pSSysMsgQueue.getStatePSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_StatePSDEFName_Default((IEntity)pSSysMsgQueue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STATEPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Tag2PSDEFId(boolean bl, PSSysMsgQueue pSSysMsgQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgQueue.isTag2PSDEFIdDirty() : !pSSysMsgQueue.isTag2PSDEFIdDirty()) {
            return null;
        }
        String string = pSSysMsgQueue.getTag2PSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Tag2PSDEFId_Default((IEntity)pSSysMsgQueue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TAG2PSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Tag2PSDEFName(boolean bl, PSSysMsgQueue pSSysMsgQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgQueue.isTag2PSDEFNameDirty() : !pSSysMsgQueue.isTag2PSDEFNameDirty()) {
            return null;
        }
        String string = pSSysMsgQueue.getTag2PSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Tag2PSDEFName_Default((IEntity)pSSysMsgQueue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TAG2PSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TagPSDEFId(boolean bl, PSSysMsgQueue pSSysMsgQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgQueue.isTagPSDEFIdDirty() : !pSSysMsgQueue.isTagPSDEFIdDirty()) {
            return null;
        }
        String string = pSSysMsgQueue.getTagPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TagPSDEFId_Default((IEntity)pSSysMsgQueue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TAGPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TagPSDEFName(boolean bl, PSSysMsgQueue pSSysMsgQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgQueue.isTagPSDEFNameDirty() : !pSSysMsgQueue.isTagPSDEFNameDirty()) {
            return null;
        }
        String string = pSSysMsgQueue.getTagPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TagPSDEFName_Default((IEntity)pSSysMsgQueue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TAGPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TargetPSDEFId(boolean bl, PSSysMsgQueue pSSysMsgQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgQueue.isTargetPSDEFIdDirty() : !pSSysMsgQueue.isTargetPSDEFIdDirty()) {
            return null;
        }
        String string = pSSysMsgQueue.getTargetPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TargetPSDEFId_Default((IEntity)pSSysMsgQueue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TARGETPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TargetPSDEFName(boolean bl, PSSysMsgQueue pSSysMsgQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgQueue.isTargetPSDEFNameDirty() : !pSSysMsgQueue.isTargetPSDEFNameDirty()) {
            return null;
        }
        String string = pSSysMsgQueue.getTargetPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TargetPSDEFName_Default((IEntity)pSSysMsgQueue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TARGETPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TargetTypePSDEFId(boolean bl, PSSysMsgQueue pSSysMsgQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgQueue.isTargetTypePSDEFIdDirty() : !pSSysMsgQueue.isTargetTypePSDEFIdDirty()) {
            return null;
        }
        String string = pSSysMsgQueue.getTargetTypePSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TargetTypePSDEFId_Default((IEntity)pSSysMsgQueue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TARGETTYPEPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TargetTypePSDEFName(boolean bl, PSSysMsgQueue pSSysMsgQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgQueue.isTargetTypePSDEFNameDirty() : !pSSysMsgQueue.isTargetTypePSDEFNameDirty()) {
            return null;
        }
        String string = pSSysMsgQueue.getTargetTypePSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TargetTypePSDEFName_Default((IEntity)pSSysMsgQueue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TARGETTYPEPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TaskUrlPSDEFId(boolean bl, PSSysMsgQueue pSSysMsgQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgQueue.isTaskUrlPSDEFIdDirty() : !pSSysMsgQueue.isTaskUrlPSDEFIdDirty()) {
            return null;
        }
        String string = pSSysMsgQueue.getTaskUrlPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TaskUrlPSDEFId_Default((IEntity)pSSysMsgQueue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TASKURLPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TaskUrlPSDEFName(boolean bl, PSSysMsgQueue pSSysMsgQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgQueue.isTaskUrlPSDEFNameDirty() : !pSSysMsgQueue.isTaskUrlPSDEFNameDirty()) {
            return null;
        }
        String string = pSSysMsgQueue.getTaskUrlPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TaskUrlPSDEFName_Default((IEntity)pSSysMsgQueue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TASKURLPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TitlePSDEFId(boolean bl, PSSysMsgQueue pSSysMsgQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgQueue.isTitlePSDEFIdDirty() : !pSSysMsgQueue.isTitlePSDEFIdDirty()) {
            return null;
        }
        String string = pSSysMsgQueue.getTitlePSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TitlePSDEFId_Default((IEntity)pSSysMsgQueue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TITLEPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TitlePSDEFName(boolean bl, PSSysMsgQueue pSSysMsgQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgQueue.isTitlePSDEFNameDirty() : !pSSysMsgQueue.isTitlePSDEFNameDirty()) {
            return null;
        }
        String string = pSSysMsgQueue.getTitlePSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TitlePSDEFName_Default((IEntity)pSSysMsgQueue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TITLEPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_User2PSDEFId(boolean bl, PSSysMsgQueue pSSysMsgQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgQueue.isUser2PSDEFIdDirty() : !pSSysMsgQueue.isUser2PSDEFIdDirty()) {
            return null;
        }
        String string = pSSysMsgQueue.getUser2PSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_User2PSDEFId_Default((IEntity)pSSysMsgQueue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USER2PSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_User2PSDEFName(boolean bl, PSSysMsgQueue pSSysMsgQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgQueue.isUser2PSDEFNameDirty() : !pSSysMsgQueue.isUser2PSDEFNameDirty()) {
            return null;
        }
        String string = pSSysMsgQueue.getUser2PSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_User2PSDEFName_Default((IEntity)pSSysMsgQueue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USER2PSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSysMsgQueue pSSysMsgQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgQueue.isUserCatDirty() : !pSSysMsgQueue.isUserCatDirty()) {
            return null;
        }
        String string = pSSysMsgQueue.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default((IEntity)pSSysMsgQueue, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserPSDEFId(boolean bl, PSSysMsgQueue pSSysMsgQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgQueue.isUserPSDEFIdDirty() : !pSSysMsgQueue.isUserPSDEFIdDirty()) {
            return null;
        }
        String string = pSSysMsgQueue.getUserPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserPSDEFId_Default((IEntity)pSSysMsgQueue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserPSDEFName(boolean bl, PSSysMsgQueue pSSysMsgQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgQueue.isUserPSDEFNameDirty() : !pSSysMsgQueue.isUserPSDEFNameDirty()) {
            return null;
        }
        String string = pSSysMsgQueue.getUserPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserPSDEFName_Default((IEntity)pSSysMsgQueue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysMsgQueue pSSysMsgQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgQueue.isUserTagDirty() : !pSSysMsgQueue.isUserTagDirty()) {
            return null;
        }
        String string = pSSysMsgQueue.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSSysMsgQueue, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysMsgQueue pSSysMsgQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgQueue.isUserTag2Dirty() : !pSSysMsgQueue.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysMsgQueue.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSSysMsgQueue, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSysMsgQueue pSSysMsgQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgQueue.isUserTag3Dirty() : !pSSysMsgQueue.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSysMsgQueue.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default((IEntity)pSSysMsgQueue, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSysMsgQueue pSSysMsgQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgQueue.isUserTag4Dirty() : !pSSysMsgQueue.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSysMsgQueue.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default((IEntity)pSSysMsgQueue, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSSysMsgQueue pSSysMsgQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgQueue.isValidFlagDirty() && !bl2 : !pSSysMsgQueue.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSSysMsgQueue.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSSysMsgQueue, bl2, bl3);
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

    protected EntityFieldError onCheckField_WXContentPSDEFId(boolean bl, PSSysMsgQueue pSSysMsgQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgQueue.isWXContentPSDEFIdDirty() : !pSSysMsgQueue.isWXContentPSDEFIdDirty()) {
            return null;
        }
        String string = pSSysMsgQueue.getWXContentPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WXContentPSDEFId_Default((IEntity)pSSysMsgQueue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WXCONTENTPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WXContentPSDEFName(boolean bl, PSSysMsgQueue pSSysMsgQueue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgQueue.isWXContentPSDEFNameDirty() : !pSSysMsgQueue.isWXContentPSDEFNameDirty()) {
            return null;
        }
        String string = pSSysMsgQueue.getWXContentPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WXContentPSDEFName_Default((IEntity)pSSysMsgQueue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WXCONTENTPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSSysMsgQueue pSSysMsgQueue, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSSysMsgQueue, bl);
    }

    protected void onSyncIndexEntities(PSSysMsgQueue pSSysMsgQueue, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSSysMsgQueue, bl);
    }

    public Object getDataContextValue(PSSysMsgQueue pSSysMsgQueue, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSSysMsgQueue, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSSysMsgQueue pSSysMsgQueue, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSSysMsgQueue, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CONTENTPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ContentPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CONTENTPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ContentPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CONTENTTYPEPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ContentTypePSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CONTENTTYPEPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ContentTypePSDEFName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"DDCONTENTPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DDContentPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DDCONTENTPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DDContentPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FILEPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FilePSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FILEPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FilePSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"IMCONTENTPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IMContentPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"IMCONTENTPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IMContentPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MOBTASKURLPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MobTaskUrlPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MOBTASKURLPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MobTaskUrlPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MSGQUEUEPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MsgQueueParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MSGQUEUETAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MsgQueueTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MSGQUEUETAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MsgQueueTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MSGQUEUETYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MsgQueueType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MSGTYPEPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MsgTypePSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MSGTYPEPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MsgTypePSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODULEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModuleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODULENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModuleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDYNAMODELID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDynaModelId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDYNAMODELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDynaModelName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSMSGQUEUEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysMsgQueueId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSMSGQUEUENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysMsgQueueName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"QUEUEPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_QueueParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SENDTIMEPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SendTimePSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SENDTIMEPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SendTimePSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SMSCONTENTPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SMSContentPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SMSCONTENTPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SMSContentPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STATEPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_StatePSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STATEPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_StatePSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TAG2PSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Tag2PSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TAG2PSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Tag2PSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TAGPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TagPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TAGPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TagPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TARGETPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TargetPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TARGETPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TargetPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TARGETTYPEPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TargetTypePSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TARGETTYPEPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TargetTypePSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TASKURLPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TaskUrlPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TASKURLPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TaskUrlPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TITLEPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TitlePSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TITLEPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TitlePSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USER2PSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_User2PSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USER2PSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_User2PSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERCAT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserCat_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserPSDEFName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"WXCONTENTPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WXContentPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WXCONTENTPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WXContentPSDEFName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_ContentPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONTENTPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ContentPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONTENTPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ContentTypePSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONTENTTYPEPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ContentTypePSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONTENTTYPEPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_DDContentPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DDCONTENTPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DDContentPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DDCONTENTPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FilePSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FILEPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FilePSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FILEPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_IMContentPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("IMCONTENTPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_IMContentPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("IMCONTENTPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
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

    protected String onTestValueRule_MobTaskUrlPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MOBTASKURLPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MobTaskUrlPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MOBTASKURLPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MsgQueueParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MSGQUEUEPARAMS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MsgQueueTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MSGQUEUETAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MsgQueueTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MSGQUEUETAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MsgQueueType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MSGQUEUETYPE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MsgTypePSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MSGTYPEPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MsgTypePSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MSGTYPEPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_PSSysMsgQueueId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSMSGQUEUEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysMsgQueueName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSMSGQUEUENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_QueueParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("QUEUEPARAMS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SendTimePSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SENDTIMEPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SendTimePSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SENDTIMEPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SMSContentPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SMSCONTENTPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SMSContentPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SMSCONTENTPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_StatePSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("STATEPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_StatePSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("STATEPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Tag2PSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TAG2PSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Tag2PSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TAG2PSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TagPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TAGPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TagPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TAGPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TargetPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TARGETPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TargetPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TARGETPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TargetTypePSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TARGETTYPEPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TargetTypePSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TARGETTYPEPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TaskUrlPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TASKURLPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TaskUrlPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TASKURLPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TitlePSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TITLEPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TitlePSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TITLEPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
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

    protected String onTestValueRule_User2PSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USER2PSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_User2PSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USER2PSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_UserPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_WXContentPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WXCONTENTPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_WXContentPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WXCONTENTPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSSysMsgQueue pSSysMsgQueue) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSSysMsgQueue)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysMsgQueue pSSysMsgQueue) throws Exception {
        super.onUpdateParent((IEntity)pSSysMsgQueue);
    }

    @Override
    protected void exportCurXmlModel(PSSysMsgQueue pSSysMsgQueue, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSMSGQUEUE");
        if (!bl) {
            pSSysMsgQueue.setCreateDate(null);
            pSSysMsgQueue.setCreateMan(null);
            pSSysMsgQueue.setPSSysMsgQueueId(null);
            pSSysMsgQueue.setPSSystemName(null);
            pSSysMsgQueue.setUpdateDate(null);
            pSSysMsgQueue.setUpdateMan(null);
            super.exportCurXmlModel(pSSysMsgQueue, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysMsgQueue pSSysMsgQueue, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysMsgQueue, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSMODULEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSMODULE#%1$s", (Object)string);
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
            return "DER1N_PSSYSMSGQUEUE_PSMODULE_PSMODULEID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSMSGQUEUE_PSSYSTEM_PSSYSTEMID";
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
        if (StringHelper.compare((String)string, (String)"PSSYSTEM", (boolean)true) == 0) {
            iEntity.set("PSSYSTEMID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSMODULEID", "PSSYSTEMID"};
    }

    @Override
    public String getModelV2Tag(PSSysMsgQueue pSSysMsgQueue) {
        if (!StringHelper.isNullOrEmpty((String)pSSysMsgQueue.getCodeName())) {
            return pSSysMsgQueue.getCodeName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysMsgQueue.getPSSysMsgQueueName())) {
            return pSSysMsgQueue.getPSSysMsgQueueName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysMsgQueue.getCodeName())) {
            return pSSysMsgQueue.getCodeName();
        }
        return super.getModelV2Tag(pSSysMsgQueue);
    }

    @Override
    public boolean setModelV2Tag(PSSysMsgQueue pSSysMsgQueue, String string) {
        pSSysMsgQueue.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("PSSYSMSGQUEUENAME", "");
        map.put("CODENAME", "");
        map.put("CODENAME", "");
        map.put("PSSYSMSGQUEUENAME", "");
        map.put("PSMODULEID", "");
        map.put("PSSYSTEMID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysMsgQueue pSSysMsgQueue, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysMsgQueue.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysMsgQueue, true);
        pSSysMsgQueue.set("CODENAME", string);
        if (this.select(pSSysMsgQueue, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysMsgQueue, true);
        return super.getModelV2Entity(pSSysMsgQueue, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysMsgQueue pSSysMsgQueue, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSSysMsgQueue, objectNode, string, string2, n);
    }

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSSysMsgQueue pSSysMsgQueue, boolean bl) {
        return defaultValueMap;
    }

    static {
        defaultValueMap.put("CODENAME", "MsgQueue");
        defaultValueMap.put("PSSYSMSGQUEUENAME", "\u6d88\u606f\u961f\u5217");
    }
}

