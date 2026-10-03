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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSetBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFieldBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEACModeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEACModeServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDELNParamService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELNParamServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicNodeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicNodeServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDENotifyService;
import net.ibizsys.pscore.srv.dedesign.service.PSDENotifyServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewCtrlService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewCtrlServiceBase;
import net.ibizsys.pscore.srv.sysdesign.dao.PSSysMsgTemplDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysMsgTemplDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageResBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModuleBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysMsgTempl;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPluginBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSViewMsgService;
import net.ibizsys.pscore.srv.sysdesign.service.PSViewMsgServiceBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.wfdesign.service.PSSysWFSettingService;
import net.ibizsys.pscore.srv.wfdesign.service.PSSysWFSettingServiceBase;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFLinkRoleService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFLinkRoleServiceBase;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFProcRoleService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFProcRoleServiceBase;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFProcessService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFProcessServiceBase;
import net.ibizsys.pscore.srv.wfdesign.service.PSWorkflowService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWorkflowServiceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysMsgTemplServiceBase
extends PSCoreSysServiceBase<PSSysMsgTempl> {
    private static final Log log = LogFactory.getLog(PSSysMsgTemplServiceBase.class);
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSysMsgTemplDEModel pSSysMsgTemplDEModel;
    private PSSysMsgTemplDAO pSSysMsgTemplDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSSysMsgTemplService";
    }

    public PSSysMsgTemplDEModel getPSSysMsgTemplDEModel() {
        if (this.pSSysMsgTemplDEModel == null) {
            try {
                this.pSSysMsgTemplDEModel = (PSSysMsgTemplDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysMsgTemplDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysMsgTemplDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysMsgTemplDEModel();
    }

    public PSSysMsgTemplDAO getPSSysMsgTemplDAO() {
        if (this.pSSysMsgTemplDAO == null) {
            try {
                this.pSSysMsgTemplDAO = (PSSysMsgTemplDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSSysMsgTemplDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysMsgTemplDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysMsgTemplDAO();
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

    protected void onFillParentInfo(PSSysMsgTempl pSSysMsgTempl, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMSGTEMPL_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDataEntity);
            } else {
                iService.get(pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSSysMsgTempl, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMSGTEMPL_PSDEDATASET_PSDEDSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService", (SessionFactory)this.getSessionFactory());
            PSDEDataSet pSDEDataSet = (PSDEDataSet)iService.getDEModel().createEntity();
            pSDEDataSet.set("PSDEDATASETID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEDataSet);
            } else {
                iService.get(pSDEDataSet);
            }
            this.onFillParentInfo_PSDEDS(pSSysMsgTempl, pSDEDataSet);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMSGTEMPL_PSDEFIELD_CONTENTPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_ContentPSDEF(pSSysMsgTempl, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMSGTEMPL_PSDEFIELD_CONTENTTYPEPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_ContentTypePSDEF(pSSysMsgTempl, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMSGTEMPL_PSDEFIELD_DDCONTENTPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_DDContentPSDEF(pSSysMsgTempl, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMSGTEMPL_PSDEFIELD_IMCONTENTPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_IMContentPSDEF(pSSysMsgTempl, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMSGTEMPL_PSDEFIELD_LANPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_LanPSDEF(pSSysMsgTempl, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMSGTEMPL_PSDEFIELD_MOBTASKURLPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_MobTaskUrlPSDEF(pSSysMsgTempl, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMSGTEMPL_PSDEFIELD_SMSCONTENTPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_SMSContentPSDEF(pSSysMsgTempl, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMSGTEMPL_PSDEFIELD_SUBJECTPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_SubjectPSDEF(pSSysMsgTempl, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMSGTEMPL_PSDEFIELD_TASKURLPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_TaskUrlPSDEF(pSSysMsgTempl, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMSGTEMPL_PSDEFIELD_TEMPLTAGPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_TemplTagPSDEF(pSSysMsgTempl, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMSGTEMPL_PSDEFIELD_USER2PSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_User2PSDEF(pSSysMsgTempl, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMSGTEMPL_PSDEFIELD_USERPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_UserPSDEF(pSSysMsgTempl, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMSGTEMPL_PSDEFIELD_WCCONTENTPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_WCContentPSDEF(pSSysMsgTempl, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMSGTEMPL_PSLANGUAGERES_CONTENTPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSLanguageRes);
            } else {
                iService.get(pSLanguageRes);
            }
            this.onFillParentInfo_ContentPSLanRes(pSSysMsgTempl, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMSGTEMPL_PSLANGUAGERES_DDPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSLanguageRes);
            } else {
                iService.get(pSLanguageRes);
            }
            this.onFillParentInfo_DDPSLanRes(pSSysMsgTempl, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMSGTEMPL_PSLANGUAGERES_IMPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSLanguageRes);
            } else {
                iService.get(pSLanguageRes);
            }
            this.onFillParentInfo_IMPSLanRes(pSSysMsgTempl, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMSGTEMPL_PSLANGUAGERES_SMSPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSLanguageRes);
            } else {
                iService.get(pSLanguageRes);
            }
            this.onFillParentInfo_SMSPSLanRes(pSSysMsgTempl, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMSGTEMPL_PSLANGUAGERES_SUBPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSLanguageRes);
            } else {
                iService.get(pSLanguageRes);
            }
            this.onFillParentInfo_SubPSLanRes(pSSysMsgTempl, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMSGTEMPL_PSLANGUAGERES_WXPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSLanguageRes);
            } else {
                iService.get(pSLanguageRes);
            }
            this.onFillParentInfo_WXPSLanRes(pSSysMsgTempl, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMSGTEMPL_PSMODULE_PSMODULEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSModuleService", (SessionFactory)this.getSessionFactory());
            PSModule pSModule = (PSModule)iService.getDEModel().createEntity();
            pSModule.set("PSMODULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSModule);
            } else {
                iService.get(pSModule);
            }
            this.onFillParentInfo_PSModule(pSSysMsgTempl, pSModule);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMSGTEMPL_PSSYSDYNAMODEL_PSSYSDYNAMODELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService", (SessionFactory)this.getSessionFactory());
            PSSysDynaModel pSSysDynaModel = (PSSysDynaModel)iService.getDEModel().createEntity();
            pSSysDynaModel.set("PSSYSDYNAMODELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysDynaModel);
            } else {
                iService.get(pSSysDynaModel);
            }
            this.onFillParentInfo_PSSysDynaModel(pSSysMsgTempl, pSSysDynaModel);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMSGTEMPL_PSSYSSFPLUGIN_PSSYSSFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysSFPlugin pSSysSFPlugin = (PSSysSFPlugin)iService.getDEModel().createEntity();
            pSSysSFPlugin.set("PSSYSSFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysSFPlugin);
            } else {
                iService.get(pSSysSFPlugin);
            }
            this.onFillParentInfo_PSSysSFPlugin(pSSysMsgTempl, pSSysSFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMSGTEMPL_PSSYSTEM_PSSYSTEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemService", (SessionFactory)this.getSessionFactory());
            PSSystem pSSystem = (PSSystem)iService.getDEModel().createEntity();
            pSSystem.set("PSSYSTEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSystem);
            } else {
                iService.get(pSSystem);
            }
            this.onFillParentInfo_PSSystem(pSSysMsgTempl, pSSystem);
            return;
        }
        super.onFillParentInfo(pSSysMsgTempl, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDE(PSSysMsgTempl pSSysMsgTempl, PSDataEntity pSDataEntity) throws Exception {
        pSSysMsgTempl.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSSysMsgTempl.setPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_PSDEDS(PSSysMsgTempl pSSysMsgTempl, PSDEDataSet pSDEDataSet) throws Exception {
        pSSysMsgTempl.setPSDEDSId(pSDEDataSet.getPSDEDataSetId());
        pSSysMsgTempl.setPSDEDSName(pSDEDataSet.getPSDEDataSetName());
    }

    protected void onFillParentInfo_ContentPSDEF(PSSysMsgTempl pSSysMsgTempl, PSDEField pSDEField) throws Exception {
        pSSysMsgTempl.setContentPSDEFId(pSDEField.getPSDEFieldId());
        pSSysMsgTempl.setContentPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_ContentTypePSDEF(PSSysMsgTempl pSSysMsgTempl, PSDEField pSDEField) throws Exception {
        pSSysMsgTempl.setContentTypePSDEFId(pSDEField.getPSDEFieldId());
        pSSysMsgTempl.setContentTypePSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_DDContentPSDEF(PSSysMsgTempl pSSysMsgTempl, PSDEField pSDEField) throws Exception {
        pSSysMsgTempl.setDDContentPSDEFId(pSDEField.getPSDEFieldId());
        pSSysMsgTempl.setDDContentPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_IMContentPSDEF(PSSysMsgTempl pSSysMsgTempl, PSDEField pSDEField) throws Exception {
        pSSysMsgTempl.setIMContentPSDEFId(pSDEField.getPSDEFieldId());
        pSSysMsgTempl.setIMContentPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_LanPSDEF(PSSysMsgTempl pSSysMsgTempl, PSDEField pSDEField) throws Exception {
        pSSysMsgTempl.setLanPSDEFId(pSDEField.getPSDEFieldId());
        pSSysMsgTempl.setLanPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_MobTaskUrlPSDEF(PSSysMsgTempl pSSysMsgTempl, PSDEField pSDEField) throws Exception {
        pSSysMsgTempl.setMobTaskUrlPSDEFId(pSDEField.getPSDEFieldId());
        pSSysMsgTempl.setMobTaskUrlPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_SMSContentPSDEF(PSSysMsgTempl pSSysMsgTempl, PSDEField pSDEField) throws Exception {
        pSSysMsgTempl.setSMSContentPSDEFId(pSDEField.getPSDEFieldId());
        pSSysMsgTempl.setSMSContentPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_SubjectPSDEF(PSSysMsgTempl pSSysMsgTempl, PSDEField pSDEField) throws Exception {
        pSSysMsgTempl.setSubjectPSDEFId(pSDEField.getPSDEFieldId());
        pSSysMsgTempl.setSubjectPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_TaskUrlPSDEF(PSSysMsgTempl pSSysMsgTempl, PSDEField pSDEField) throws Exception {
        pSSysMsgTempl.setTaskUrlPSDEFId(pSDEField.getPSDEFieldId());
        pSSysMsgTempl.setTaskUrlPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_TemplTagPSDEF(PSSysMsgTempl pSSysMsgTempl, PSDEField pSDEField) throws Exception {
        pSSysMsgTempl.setTemplTagPSDEFId(pSDEField.getPSDEFieldId());
        pSSysMsgTempl.setTemplTagPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_User2PSDEF(PSSysMsgTempl pSSysMsgTempl, PSDEField pSDEField) throws Exception {
        pSSysMsgTempl.setUser2PSDEFId(pSDEField.getPSDEFieldId());
        pSSysMsgTempl.setUser2PSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_UserPSDEF(PSSysMsgTempl pSSysMsgTempl, PSDEField pSDEField) throws Exception {
        pSSysMsgTempl.setUserPSDEFId(pSDEField.getPSDEFieldId());
        pSSysMsgTempl.setUserPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_WCContentPSDEF(PSSysMsgTempl pSSysMsgTempl, PSDEField pSDEField) throws Exception {
        pSSysMsgTempl.setWCContentPSDEFId(pSDEField.getPSDEFieldId());
        pSSysMsgTempl.setWCContentPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_ContentPSLanRes(PSSysMsgTempl pSSysMsgTempl, PSLanguageRes pSLanguageRes) throws Exception {
        pSSysMsgTempl.setContentPSLanResId(pSLanguageRes.getPSLanguageResId());
        pSSysMsgTempl.setContentPSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_DDPSLanRes(PSSysMsgTempl pSSysMsgTempl, PSLanguageRes pSLanguageRes) throws Exception {
        pSSysMsgTempl.setDDPSLanResId(pSLanguageRes.getPSLanguageResId());
        pSSysMsgTempl.setDDPSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_IMPSLanRes(PSSysMsgTempl pSSysMsgTempl, PSLanguageRes pSLanguageRes) throws Exception {
        pSSysMsgTempl.setIMPSLanResId(pSLanguageRes.getPSLanguageResId());
        pSSysMsgTempl.setIMPSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_SMSPSLanRes(PSSysMsgTempl pSSysMsgTempl, PSLanguageRes pSLanguageRes) throws Exception {
        pSSysMsgTempl.setSMSPSLanResId(pSLanguageRes.getPSLanguageResId());
        pSSysMsgTempl.setSMSPSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_SubPSLanRes(PSSysMsgTempl pSSysMsgTempl, PSLanguageRes pSLanguageRes) throws Exception {
        pSSysMsgTempl.setSubPSLanResId(pSLanguageRes.getPSLanguageResId());
        pSSysMsgTempl.setSubPSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_WXPSLanRes(PSSysMsgTempl pSSysMsgTempl, PSLanguageRes pSLanguageRes) throws Exception {
        pSSysMsgTempl.setWXPSLanResId(pSLanguageRes.getPSLanguageResId());
        pSSysMsgTempl.setWXPSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_PSModule(PSSysMsgTempl pSSysMsgTempl, PSModule pSModule) throws Exception {
        pSSysMsgTempl.setPSModuleId(pSModule.getPSModuleId());
        pSSysMsgTempl.setPSModuleName(pSModule.getPSModuleName());
    }

    protected void onFillParentInfo_PSSysDynaModel(PSSysMsgTempl pSSysMsgTempl, PSSysDynaModel pSSysDynaModel) throws Exception {
        pSSysMsgTempl.setPSSysDynaModelId(pSSysDynaModel.getPSSysDynaModelId());
        pSSysMsgTempl.setPSSysDynaModelName(pSSysDynaModel.getPSSysDynaModelName());
    }

    protected void onFillParentInfo_PSSysSFPlugin(PSSysMsgTempl pSSysMsgTempl, PSSysSFPlugin pSSysSFPlugin) throws Exception {
        pSSysMsgTempl.setPSSysSFPluginId(pSSysSFPlugin.getPSSysSFPluginId());
        pSSysMsgTempl.setPSSysSFPluginName(pSSysSFPlugin.getPSSysSFPluginName());
    }

    protected void onFillParentInfo_PSSystem(PSSysMsgTempl pSSysMsgTempl, PSSystem pSSystem) throws Exception {
        pSSysMsgTempl.setPSSystemId(pSSystem.getPSSystemId());
        pSSysMsgTempl.setPSSystemName(pSSystem.getPSSystemName());
    }

    protected void onFillEntityFullInfo(PSSysMsgTempl pSSysMsgTempl, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSSysMsgTempl, bl);
        this.onFillEntityFullInfo_PSDE(pSSysMsgTempl, bl);
        this.onFillEntityFullInfo_PSDEDS(pSSysMsgTempl, bl);
        this.onFillEntityFullInfo_ContentPSDEF(pSSysMsgTempl, bl);
        this.onFillEntityFullInfo_ContentTypePSDEF(pSSysMsgTempl, bl);
        this.onFillEntityFullInfo_DDContentPSDEF(pSSysMsgTempl, bl);
        this.onFillEntityFullInfo_IMContentPSDEF(pSSysMsgTempl, bl);
        this.onFillEntityFullInfo_LanPSDEF(pSSysMsgTempl, bl);
        this.onFillEntityFullInfo_MobTaskUrlPSDEF(pSSysMsgTempl, bl);
        this.onFillEntityFullInfo_SMSContentPSDEF(pSSysMsgTempl, bl);
        this.onFillEntityFullInfo_SubjectPSDEF(pSSysMsgTempl, bl);
        this.onFillEntityFullInfo_TaskUrlPSDEF(pSSysMsgTempl, bl);
        this.onFillEntityFullInfo_TemplTagPSDEF(pSSysMsgTempl, bl);
        this.onFillEntityFullInfo_User2PSDEF(pSSysMsgTempl, bl);
        this.onFillEntityFullInfo_UserPSDEF(pSSysMsgTempl, bl);
        this.onFillEntityFullInfo_WCContentPSDEF(pSSysMsgTempl, bl);
        this.onFillEntityFullInfo_ContentPSLanRes(pSSysMsgTempl, bl);
        this.onFillEntityFullInfo_DDPSLanRes(pSSysMsgTempl, bl);
        this.onFillEntityFullInfo_IMPSLanRes(pSSysMsgTempl, bl);
        this.onFillEntityFullInfo_SMSPSLanRes(pSSysMsgTempl, bl);
        this.onFillEntityFullInfo_SubPSLanRes(pSSysMsgTempl, bl);
        this.onFillEntityFullInfo_WXPSLanRes(pSSysMsgTempl, bl);
        this.onFillEntityFullInfo_PSModule(pSSysMsgTempl, bl);
        this.onFillEntityFullInfo_PSSysDynaModel(pSSysMsgTempl, bl);
        this.onFillEntityFullInfo_PSSysSFPlugin(pSSysMsgTempl, bl);
        this.onFillEntityFullInfo_PSSystem(pSSysMsgTempl, bl);
    }

    protected void onFillEntityFullInfo_PSDE(PSSysMsgTempl pSSysMsgTempl, boolean bl) throws Exception {
        if (pSSysMsgTempl.isPSDEIdDirty()) {
            if (pSSysMsgTempl.getPSDEId() != null) {
                if (pSSysMsgTempl.getPSDEId() == null || pSSysMsgTempl.getPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSSysMsgTempl.getPSDE();
                    pSSysMsgTempl.setPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSSysMsgTempl.setPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDEDS(PSSysMsgTempl pSSysMsgTempl, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_ContentPSDEF(PSSysMsgTempl pSSysMsgTempl, boolean bl) throws Exception {
        if (pSSysMsgTempl.isContentPSDEFIdDirty()) {
            if (pSSysMsgTempl.getContentPSDEFId() != null) {
                if (pSSysMsgTempl.getContentPSDEFId() == null || pSSysMsgTempl.getContentPSDEFName() == null) {
                    PSDEField pSDEField = pSSysMsgTempl.getContentPSDEF();
                    pSSysMsgTempl.setContentPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysMsgTempl.setContentPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_ContentTypePSDEF(PSSysMsgTempl pSSysMsgTempl, boolean bl) throws Exception {
        if (pSSysMsgTempl.isContentTypePSDEFIdDirty()) {
            if (pSSysMsgTempl.getContentTypePSDEFId() != null) {
                if (pSSysMsgTempl.getContentTypePSDEFId() == null || pSSysMsgTempl.getContentTypePSDEFName() == null) {
                    PSDEField pSDEField = pSSysMsgTempl.getContentTypePSDEF();
                    pSSysMsgTempl.setContentTypePSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysMsgTempl.setContentTypePSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_DDContentPSDEF(PSSysMsgTempl pSSysMsgTempl, boolean bl) throws Exception {
        if (pSSysMsgTempl.isDDContentPSDEFIdDirty()) {
            if (pSSysMsgTempl.getDDContentPSDEFId() != null) {
                if (pSSysMsgTempl.getDDContentPSDEFId() == null || pSSysMsgTempl.getDDContentPSDEFName() == null) {
                    PSDEField pSDEField = pSSysMsgTempl.getDDContentPSDEF();
                    pSSysMsgTempl.setDDContentPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysMsgTempl.setDDContentPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_IMContentPSDEF(PSSysMsgTempl pSSysMsgTempl, boolean bl) throws Exception {
        if (pSSysMsgTempl.isIMContentPSDEFIdDirty()) {
            if (pSSysMsgTempl.getIMContentPSDEFId() != null) {
                if (pSSysMsgTempl.getIMContentPSDEFId() == null || pSSysMsgTempl.getIMContentPSDEFName() == null) {
                    PSDEField pSDEField = pSSysMsgTempl.getIMContentPSDEF();
                    pSSysMsgTempl.setIMContentPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysMsgTempl.setIMContentPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_LanPSDEF(PSSysMsgTempl pSSysMsgTempl, boolean bl) throws Exception {
        if (pSSysMsgTempl.isLanPSDEFIdDirty()) {
            if (pSSysMsgTempl.getLanPSDEFId() != null) {
                if (pSSysMsgTempl.getLanPSDEFId() == null || pSSysMsgTempl.getLanPSDEFName() == null) {
                    PSDEField pSDEField = pSSysMsgTempl.getLanPSDEF();
                    pSSysMsgTempl.setLanPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysMsgTempl.setLanPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_MobTaskUrlPSDEF(PSSysMsgTempl pSSysMsgTempl, boolean bl) throws Exception {
        if (pSSysMsgTempl.isMobTaskUrlPSDEFIdDirty()) {
            if (pSSysMsgTempl.getMobTaskUrlPSDEFId() != null) {
                if (pSSysMsgTempl.getMobTaskUrlPSDEFId() == null || pSSysMsgTempl.getMobTaskUrlPSDEFName() == null) {
                    PSDEField pSDEField = pSSysMsgTempl.getMobTaskUrlPSDEF();
                    pSSysMsgTempl.setMobTaskUrlPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysMsgTempl.setMobTaskUrlPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_SMSContentPSDEF(PSSysMsgTempl pSSysMsgTempl, boolean bl) throws Exception {
        if (pSSysMsgTempl.isSMSContentPSDEFIdDirty()) {
            if (pSSysMsgTempl.getSMSContentPSDEFId() != null) {
                if (pSSysMsgTempl.getSMSContentPSDEFId() == null || pSSysMsgTempl.getSMSContentPSDEFName() == null) {
                    PSDEField pSDEField = pSSysMsgTempl.getSMSContentPSDEF();
                    pSSysMsgTempl.setSMSContentPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysMsgTempl.setSMSContentPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_SubjectPSDEF(PSSysMsgTempl pSSysMsgTempl, boolean bl) throws Exception {
        if (pSSysMsgTempl.isSubjectPSDEFIdDirty()) {
            if (pSSysMsgTempl.getSubjectPSDEFId() != null) {
                if (pSSysMsgTempl.getSubjectPSDEFId() == null || pSSysMsgTempl.getSubjectPSDEFName() == null) {
                    PSDEField pSDEField = pSSysMsgTempl.getSubjectPSDEF();
                    pSSysMsgTempl.setSubjectPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysMsgTempl.setSubjectPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_TaskUrlPSDEF(PSSysMsgTempl pSSysMsgTempl, boolean bl) throws Exception {
        if (pSSysMsgTempl.isTaskUrlPSDEFIdDirty()) {
            if (pSSysMsgTempl.getTaskUrlPSDEFId() != null) {
                if (pSSysMsgTempl.getTaskUrlPSDEFId() == null || pSSysMsgTempl.getTaskUrlPSDEFName() == null) {
                    PSDEField pSDEField = pSSysMsgTempl.getTaskUrlPSDEF();
                    pSSysMsgTempl.setTaskUrlPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysMsgTempl.setTaskUrlPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_TemplTagPSDEF(PSSysMsgTempl pSSysMsgTempl, boolean bl) throws Exception {
        if (pSSysMsgTempl.isTemplTagPSDEFIdDirty()) {
            if (pSSysMsgTempl.getTemplTagPSDEFId() != null) {
                if (pSSysMsgTempl.getTemplTagPSDEFId() == null || pSSysMsgTempl.getTemplTagPSDEFName() == null) {
                    PSDEField pSDEField = pSSysMsgTempl.getTemplTagPSDEF();
                    pSSysMsgTempl.setTemplTagPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysMsgTempl.setTemplTagPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_User2PSDEF(PSSysMsgTempl pSSysMsgTempl, boolean bl) throws Exception {
        if (pSSysMsgTempl.isUser2PSDEFIdDirty()) {
            if (pSSysMsgTempl.getUser2PSDEFId() != null) {
                if (pSSysMsgTempl.getUser2PSDEFId() == null || pSSysMsgTempl.getUser2PSDEFName() == null) {
                    PSDEField pSDEField = pSSysMsgTempl.getUser2PSDEF();
                    pSSysMsgTempl.setUser2PSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysMsgTempl.setUser2PSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_UserPSDEF(PSSysMsgTempl pSSysMsgTempl, boolean bl) throws Exception {
        if (pSSysMsgTempl.isUserPSDEFIdDirty()) {
            if (pSSysMsgTempl.getUserPSDEFId() != null) {
                if (pSSysMsgTempl.getUserPSDEFId() == null || pSSysMsgTempl.getUserPSDEFName() == null) {
                    PSDEField pSDEField = pSSysMsgTempl.getUserPSDEF();
                    pSSysMsgTempl.setUserPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysMsgTempl.setUserPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_WCContentPSDEF(PSSysMsgTempl pSSysMsgTempl, boolean bl) throws Exception {
        if (pSSysMsgTempl.isWCContentPSDEFIdDirty()) {
            if (pSSysMsgTempl.getWCContentPSDEFId() != null) {
                if (pSSysMsgTempl.getWCContentPSDEFId() == null || pSSysMsgTempl.getWCContentPSDEFName() == null) {
                    PSDEField pSDEField = pSSysMsgTempl.getWCContentPSDEF();
                    pSSysMsgTempl.setWCContentPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysMsgTempl.setWCContentPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_ContentPSLanRes(PSSysMsgTempl pSSysMsgTempl, boolean bl) throws Exception {
        if (pSSysMsgTempl.isContentPSLanResIdDirty()) {
            if (pSSysMsgTempl.getContentPSLanResId() != null) {
                if (pSSysMsgTempl.getContentPSLanResId() == null || pSSysMsgTempl.getContentPSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSSysMsgTempl.getContentPSLanRes();
                    pSSysMsgTempl.setContentPSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSSysMsgTempl.setContentPSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_DDPSLanRes(PSSysMsgTempl pSSysMsgTempl, boolean bl) throws Exception {
        if (pSSysMsgTempl.isDDPSLanResIdDirty()) {
            if (pSSysMsgTempl.getDDPSLanResId() != null) {
                if (pSSysMsgTempl.getDDPSLanResId() == null || pSSysMsgTempl.getDDPSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSSysMsgTempl.getDDPSLanRes();
                    pSSysMsgTempl.setDDPSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSSysMsgTempl.setDDPSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_IMPSLanRes(PSSysMsgTempl pSSysMsgTempl, boolean bl) throws Exception {
        if (pSSysMsgTempl.isIMPSLanResIdDirty()) {
            if (pSSysMsgTempl.getIMPSLanResId() != null) {
                if (pSSysMsgTempl.getIMPSLanResId() == null || pSSysMsgTempl.getIMPSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSSysMsgTempl.getIMPSLanRes();
                    pSSysMsgTempl.setIMPSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSSysMsgTempl.setIMPSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_SMSPSLanRes(PSSysMsgTempl pSSysMsgTempl, boolean bl) throws Exception {
        if (pSSysMsgTempl.isSMSPSLanResIdDirty()) {
            if (pSSysMsgTempl.getSMSPSLanResId() != null) {
                if (pSSysMsgTempl.getSMSPSLanResId() == null || pSSysMsgTempl.getSMSPSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSSysMsgTempl.getSMSPSLanRes();
                    pSSysMsgTempl.setSMSPSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSSysMsgTempl.setSMSPSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_SubPSLanRes(PSSysMsgTempl pSSysMsgTempl, boolean bl) throws Exception {
        if (pSSysMsgTempl.isSubPSLanResIdDirty()) {
            if (pSSysMsgTempl.getSubPSLanResId() != null) {
                if (pSSysMsgTempl.getSubPSLanResId() == null || pSSysMsgTempl.getSubPSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSSysMsgTempl.getSubPSLanRes();
                    pSSysMsgTempl.setSubPSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSSysMsgTempl.setSubPSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_WXPSLanRes(PSSysMsgTempl pSSysMsgTempl, boolean bl) throws Exception {
        if (pSSysMsgTempl.isWXPSLanResIdDirty()) {
            if (pSSysMsgTempl.getWXPSLanResId() != null) {
                if (pSSysMsgTempl.getWXPSLanResId() == null || pSSysMsgTempl.getWXPSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSSysMsgTempl.getWXPSLanRes();
                    pSSysMsgTempl.setWXPSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSSysMsgTempl.setWXPSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSModule(PSSysMsgTempl pSSysMsgTempl, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysDynaModel(PSSysMsgTempl pSSysMsgTempl, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysSFPlugin(PSSysMsgTempl pSSysMsgTempl, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSystem(PSSysMsgTempl pSSysMsgTempl, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSysMsgTempl pSSysMsgTempl, boolean bl) throws Exception {
        super.onWriteBackParent(pSSysMsgTempl, bl);
    }

    public ArrayList<PSSysMsgTempl> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSSysMsgTempl> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSSysMsgTempl> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysMsgTempl> selectByPSDEDS(PSDEDataSetBase pSDEDataSetBase) throws Exception {
        return this.selectByPSDEDS(pSDEDataSetBase, "", -1);
    }

    public ArrayList<PSSysMsgTempl> selectByPSDEDS(PSDEDataSetBase pSDEDataSetBase, String string) throws Exception {
        return this.selectByPSDEDS(pSDEDataSetBase, string, -1);
    }

    public ArrayList<PSSysMsgTempl> selectByPSDEDS(PSDEDataSetBase pSDEDataSetBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysMsgTempl> selectByContentPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByContentPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysMsgTempl> selectByContentPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByContentPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysMsgTempl> selectByContentPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysMsgTempl> selectByContentTypePSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByContentTypePSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysMsgTempl> selectByContentTypePSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByContentTypePSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysMsgTempl> selectByContentTypePSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysMsgTempl> selectByDDContentPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByDDContentPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysMsgTempl> selectByDDContentPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByDDContentPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysMsgTempl> selectByDDContentPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysMsgTempl> selectByIMContentPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByIMContentPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysMsgTempl> selectByIMContentPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByIMContentPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysMsgTempl> selectByIMContentPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysMsgTempl> selectByLanPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByLanPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysMsgTempl> selectByLanPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByLanPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysMsgTempl> selectByLanPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("LANPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByLanPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByLanPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysMsgTempl> selectByMobTaskUrlPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByMobTaskUrlPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysMsgTempl> selectByMobTaskUrlPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByMobTaskUrlPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysMsgTempl> selectByMobTaskUrlPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysMsgTempl> selectBySMSContentPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectBySMSContentPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysMsgTempl> selectBySMSContentPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectBySMSContentPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysMsgTempl> selectBySMSContentPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysMsgTempl> selectBySubjectPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectBySubjectPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysMsgTempl> selectBySubjectPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectBySubjectPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysMsgTempl> selectBySubjectPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("SUBJECTPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectBySubjectPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectBySubjectPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysMsgTempl> selectByTaskUrlPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByTaskUrlPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysMsgTempl> selectByTaskUrlPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByTaskUrlPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysMsgTempl> selectByTaskUrlPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysMsgTempl> selectByTemplTagPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByTemplTagPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysMsgTempl> selectByTemplTagPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByTemplTagPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysMsgTempl> selectByTemplTagPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("TEMPLTAGPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByTemplTagPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByTemplTagPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysMsgTempl> selectByUser2PSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByUser2PSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysMsgTempl> selectByUser2PSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByUser2PSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysMsgTempl> selectByUser2PSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysMsgTempl> selectByUserPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByUserPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysMsgTempl> selectByUserPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByUserPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysMsgTempl> selectByUserPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysMsgTempl> selectByWCContentPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByWCContentPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysMsgTempl> selectByWCContentPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByWCContentPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysMsgTempl> selectByWCContentPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("WCCONTENTPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByWCContentPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByWCContentPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysMsgTempl> selectByContentPSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByContentPSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSSysMsgTempl> selectByContentPSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByContentPSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSSysMsgTempl> selectByContentPSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("CONTENTPSLANRESID", (Object)pSLanguageResBase.getPSLanguageResId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByContentPSLanResCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByContentPSLanResCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysMsgTempl> selectByDDPSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByDDPSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSSysMsgTempl> selectByDDPSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByDDPSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSSysMsgTempl> selectByDDPSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("DDPSLANRESID", (Object)pSLanguageResBase.getPSLanguageResId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByDDPSLanResCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByDDPSLanResCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysMsgTempl> selectByIMPSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByIMPSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSSysMsgTempl> selectByIMPSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByIMPSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSSysMsgTempl> selectByIMPSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("IMPSLANRESID", (Object)pSLanguageResBase.getPSLanguageResId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByIMPSLanResCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByIMPSLanResCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysMsgTempl> selectBySMSPSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectBySMSPSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSSysMsgTempl> selectBySMSPSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectBySMSPSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSSysMsgTempl> selectBySMSPSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("SMSPSLANRESID", (Object)pSLanguageResBase.getPSLanguageResId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectBySMSPSLanResCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectBySMSPSLanResCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysMsgTempl> selectBySubPSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectBySubPSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSSysMsgTempl> selectBySubPSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectBySubPSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSSysMsgTempl> selectBySubPSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("SUBPSLANRESID", (Object)pSLanguageResBase.getPSLanguageResId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectBySubPSLanResCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectBySubPSLanResCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysMsgTempl> selectByWXPSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByWXPSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSSysMsgTempl> selectByWXPSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByWXPSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSSysMsgTempl> selectByWXPSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("WXPSLANRESID", (Object)pSLanguageResBase.getPSLanguageResId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByWXPSLanResCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByWXPSLanResCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysMsgTempl> selectByPSModule(PSModuleBase pSModuleBase) throws Exception {
        return this.selectByPSModule(pSModuleBase, "", -1);
    }

    public ArrayList<PSSysMsgTempl> selectByPSModule(PSModuleBase pSModuleBase, String string) throws Exception {
        return this.selectByPSModule(pSModuleBase, string, -1);
    }

    public ArrayList<PSSysMsgTempl> selectByPSModule(PSModuleBase pSModuleBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysMsgTempl> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, "", -1);
    }

    public ArrayList<PSSysMsgTempl> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, string, -1);
    }

    public ArrayList<PSSysMsgTempl> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysMsgTempl> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, "", -1);
    }

    public ArrayList<PSSysMsgTempl> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, string, -1);
    }

    public ArrayList<PSSysMsgTempl> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysMsgTempl> selectByPSSystem(PSSystemBase pSSystemBase) throws Exception {
        return this.selectByPSSystem(pSSystemBase, "", -1);
    }

    public ArrayList<PSSysMsgTempl> selectByPSSystem(PSSystemBase pSSystemBase, String string) throws Exception {
        return this.selectByPSSystem(pSSystemBase, string, -1);
    }

    public ArrayList<PSSysMsgTempl> selectByPSSystem(PSSystemBase pSSystemBase, String string, int n) throws Exception {
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

    public void testRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysMsgTempl> arrayList = this.selectByPSDE(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMSGTEMPL_PSDATAENTITY_PSDEID", "", iDataEntityModel.getName(), "PSSYSMSGTEMPL", iDataEntityModel.getDataInfo(pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysMsgTempl> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSSysMsgTempl pSSysMsgTempl : arrayList) {
            PSSysMsgTempl pSSysMsgTempl2 = (PSSysMsgTempl)this.getDEModel().createEntity();
            pSSysMsgTempl2.setPSSysMsgTemplId(pSSysMsgTempl.getPSSysMsgTemplId());
            pSSysMsgTempl2.setPSDEId(null);
            this.update(pSSysMsgTempl2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMsgTemplServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSSysMsgTemplServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSSysMsgTemplServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysMsgTempl> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSSysMsgTempl pSSysMsgTempl : arrayList) {
            this.remove(pSSysMsgTempl);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSSysMsgTempl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSSysMsgTempl> arrayList) throws Exception {
    }

    public void testRemoveByPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSSysMsgTempl> arrayList = this.selectByPSDEDS(pSDEDataSet, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEDATASET");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEDataSet);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMSGTEMPL_PSDEDATASET_PSDEDSID", "", iDataEntityModel.getName(), "PSSYSMSGTEMPL", iDataEntityModel.getDataInfo(pSDEDataSet), arrayList.get(0)));
        }
    }

    public void resetPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSSysMsgTempl> arrayList = this.selectByPSDEDS(pSDEDataSet);
        for (PSSysMsgTempl pSSysMsgTempl : arrayList) {
            PSSysMsgTempl pSSysMsgTempl2 = (PSSysMsgTempl)this.getDEModel().createEntity();
            pSSysMsgTempl2.setPSSysMsgTemplId(pSSysMsgTempl.getPSSysMsgTemplId());
            pSSysMsgTempl2.setPSDEDSId(null);
            this.update(pSSysMsgTempl2);
        }
    }

    public void removeByPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        final PSDEDataSet pSDEDataSet2 = pSDEDataSet;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMsgTemplServiceBase.this.onBeforeRemoveByPSDEDS(pSDEDataSet2);
                PSSysMsgTemplServiceBase.this.internalRemoveByPSDEDS(pSDEDataSet2);
                PSSysMsgTemplServiceBase.this.onAfterRemoveByPSDEDS(pSDEDataSet2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void internalRemoveByPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSSysMsgTempl> arrayList = this.selectByPSDEDS(pSDEDataSet);
        this.onBeforeRemoveByPSDEDS(pSDEDataSet, arrayList);
        for (PSSysMsgTempl pSSysMsgTempl : arrayList) {
            this.remove(pSSysMsgTempl);
        }
        this.onAfterRemoveByPSDEDS(pSDEDataSet, arrayList);
    }

    protected void onAfterRemoveByPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void onBeforeRemoveByPSDEDS(PSDEDataSet pSDEDataSet, ArrayList<PSSysMsgTempl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEDS(PSDEDataSet pSDEDataSet, ArrayList<PSSysMsgTempl> arrayList) throws Exception {
    }

    public void testRemoveByContentPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgTempl> arrayList = this.selectByContentPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMSGTEMPL_PSDEFIELD_CONTENTPSDEFID", "", iDataEntityModel.getName(), "PSSYSMSGTEMPL", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetContentPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgTempl> arrayList = this.selectByContentPSDEF(pSDEField);
        for (PSSysMsgTempl pSSysMsgTempl : arrayList) {
            PSSysMsgTempl pSSysMsgTempl2 = (PSSysMsgTempl)this.getDEModel().createEntity();
            pSSysMsgTempl2.setPSSysMsgTemplId(pSSysMsgTempl.getPSSysMsgTemplId());
            pSSysMsgTempl2.setContentPSDEFId(null);
            this.update(pSSysMsgTempl2);
        }
    }

    public void removeByContentPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMsgTemplServiceBase.this.onBeforeRemoveByContentPSDEF(pSDEField2);
                PSSysMsgTemplServiceBase.this.internalRemoveByContentPSDEF(pSDEField2);
                PSSysMsgTemplServiceBase.this.onAfterRemoveByContentPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByContentPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByContentPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgTempl> arrayList = this.selectByContentPSDEF(pSDEField);
        this.onBeforeRemoveByContentPSDEF(pSDEField, arrayList);
        for (PSSysMsgTempl pSSysMsgTempl : arrayList) {
            this.remove(pSSysMsgTempl);
        }
        this.onAfterRemoveByContentPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByContentPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByContentPSDEF(PSDEField pSDEField, ArrayList<PSSysMsgTempl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByContentPSDEF(PSDEField pSDEField, ArrayList<PSSysMsgTempl> arrayList) throws Exception {
    }

    public void testRemoveByContentTypePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgTempl> arrayList = this.selectByContentTypePSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMSGTEMPL_PSDEFIELD_CONTENTTYPEPSDEFID", "", iDataEntityModel.getName(), "PSSYSMSGTEMPL", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetContentTypePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgTempl> arrayList = this.selectByContentTypePSDEF(pSDEField);
        for (PSSysMsgTempl pSSysMsgTempl : arrayList) {
            PSSysMsgTempl pSSysMsgTempl2 = (PSSysMsgTempl)this.getDEModel().createEntity();
            pSSysMsgTempl2.setPSSysMsgTemplId(pSSysMsgTempl.getPSSysMsgTemplId());
            pSSysMsgTempl2.setContentTypePSDEFId(null);
            this.update(pSSysMsgTempl2);
        }
    }

    public void removeByContentTypePSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMsgTemplServiceBase.this.onBeforeRemoveByContentTypePSDEF(pSDEField2);
                PSSysMsgTemplServiceBase.this.internalRemoveByContentTypePSDEF(pSDEField2);
                PSSysMsgTemplServiceBase.this.onAfterRemoveByContentTypePSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByContentTypePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByContentTypePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgTempl> arrayList = this.selectByContentTypePSDEF(pSDEField);
        this.onBeforeRemoveByContentTypePSDEF(pSDEField, arrayList);
        for (PSSysMsgTempl pSSysMsgTempl : arrayList) {
            this.remove(pSSysMsgTempl);
        }
        this.onAfterRemoveByContentTypePSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByContentTypePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByContentTypePSDEF(PSDEField pSDEField, ArrayList<PSSysMsgTempl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByContentTypePSDEF(PSDEField pSDEField, ArrayList<PSSysMsgTempl> arrayList) throws Exception {
    }

    public void testRemoveByDDContentPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgTempl> arrayList = this.selectByDDContentPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMSGTEMPL_PSDEFIELD_DDCONTENTPSDEFID", "", iDataEntityModel.getName(), "PSSYSMSGTEMPL", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetDDContentPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgTempl> arrayList = this.selectByDDContentPSDEF(pSDEField);
        for (PSSysMsgTempl pSSysMsgTempl : arrayList) {
            PSSysMsgTempl pSSysMsgTempl2 = (PSSysMsgTempl)this.getDEModel().createEntity();
            pSSysMsgTempl2.setPSSysMsgTemplId(pSSysMsgTempl.getPSSysMsgTemplId());
            pSSysMsgTempl2.setDDContentPSDEFId(null);
            this.update(pSSysMsgTempl2);
        }
    }

    public void removeByDDContentPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMsgTemplServiceBase.this.onBeforeRemoveByDDContentPSDEF(pSDEField2);
                PSSysMsgTemplServiceBase.this.internalRemoveByDDContentPSDEF(pSDEField2);
                PSSysMsgTemplServiceBase.this.onAfterRemoveByDDContentPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByDDContentPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByDDContentPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgTempl> arrayList = this.selectByDDContentPSDEF(pSDEField);
        this.onBeforeRemoveByDDContentPSDEF(pSDEField, arrayList);
        for (PSSysMsgTempl pSSysMsgTempl : arrayList) {
            this.remove(pSSysMsgTempl);
        }
        this.onAfterRemoveByDDContentPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByDDContentPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByDDContentPSDEF(PSDEField pSDEField, ArrayList<PSSysMsgTempl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByDDContentPSDEF(PSDEField pSDEField, ArrayList<PSSysMsgTempl> arrayList) throws Exception {
    }

    public void testRemoveByIMContentPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgTempl> arrayList = this.selectByIMContentPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMSGTEMPL_PSDEFIELD_IMCONTENTPSDEFID", "", iDataEntityModel.getName(), "PSSYSMSGTEMPL", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetIMContentPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgTempl> arrayList = this.selectByIMContentPSDEF(pSDEField);
        for (PSSysMsgTempl pSSysMsgTempl : arrayList) {
            PSSysMsgTempl pSSysMsgTempl2 = (PSSysMsgTempl)this.getDEModel().createEntity();
            pSSysMsgTempl2.setPSSysMsgTemplId(pSSysMsgTempl.getPSSysMsgTemplId());
            pSSysMsgTempl2.setIMContentPSDEFId(null);
            this.update(pSSysMsgTempl2);
        }
    }

    public void removeByIMContentPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMsgTemplServiceBase.this.onBeforeRemoveByIMContentPSDEF(pSDEField2);
                PSSysMsgTemplServiceBase.this.internalRemoveByIMContentPSDEF(pSDEField2);
                PSSysMsgTemplServiceBase.this.onAfterRemoveByIMContentPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByIMContentPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByIMContentPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgTempl> arrayList = this.selectByIMContentPSDEF(pSDEField);
        this.onBeforeRemoveByIMContentPSDEF(pSDEField, arrayList);
        for (PSSysMsgTempl pSSysMsgTempl : arrayList) {
            this.remove(pSSysMsgTempl);
        }
        this.onAfterRemoveByIMContentPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByIMContentPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByIMContentPSDEF(PSDEField pSDEField, ArrayList<PSSysMsgTempl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByIMContentPSDEF(PSDEField pSDEField, ArrayList<PSSysMsgTempl> arrayList) throws Exception {
    }

    public void testRemoveByLanPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgTempl> arrayList = this.selectByLanPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMSGTEMPL_PSDEFIELD_LANPSDEFID", "", iDataEntityModel.getName(), "PSSYSMSGTEMPL", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetLanPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgTempl> arrayList = this.selectByLanPSDEF(pSDEField);
        for (PSSysMsgTempl pSSysMsgTempl : arrayList) {
            PSSysMsgTempl pSSysMsgTempl2 = (PSSysMsgTempl)this.getDEModel().createEntity();
            pSSysMsgTempl2.setPSSysMsgTemplId(pSSysMsgTempl.getPSSysMsgTemplId());
            pSSysMsgTempl2.setLanPSDEFId(null);
            this.update(pSSysMsgTempl2);
        }
    }

    public void removeByLanPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMsgTemplServiceBase.this.onBeforeRemoveByLanPSDEF(pSDEField2);
                PSSysMsgTemplServiceBase.this.internalRemoveByLanPSDEF(pSDEField2);
                PSSysMsgTemplServiceBase.this.onAfterRemoveByLanPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByLanPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByLanPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgTempl> arrayList = this.selectByLanPSDEF(pSDEField);
        this.onBeforeRemoveByLanPSDEF(pSDEField, arrayList);
        for (PSSysMsgTempl pSSysMsgTempl : arrayList) {
            this.remove(pSSysMsgTempl);
        }
        this.onAfterRemoveByLanPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByLanPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByLanPSDEF(PSDEField pSDEField, ArrayList<PSSysMsgTempl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByLanPSDEF(PSDEField pSDEField, ArrayList<PSSysMsgTempl> arrayList) throws Exception {
    }

    public void testRemoveByMobTaskUrlPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgTempl> arrayList = this.selectByMobTaskUrlPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMSGTEMPL_PSDEFIELD_MOBTASKURLPSDEFID", "", iDataEntityModel.getName(), "PSSYSMSGTEMPL", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetMobTaskUrlPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgTempl> arrayList = this.selectByMobTaskUrlPSDEF(pSDEField);
        for (PSSysMsgTempl pSSysMsgTempl : arrayList) {
            PSSysMsgTempl pSSysMsgTempl2 = (PSSysMsgTempl)this.getDEModel().createEntity();
            pSSysMsgTempl2.setPSSysMsgTemplId(pSSysMsgTempl.getPSSysMsgTemplId());
            pSSysMsgTempl2.setMobTaskUrlPSDEFId(null);
            this.update(pSSysMsgTempl2);
        }
    }

    public void removeByMobTaskUrlPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMsgTemplServiceBase.this.onBeforeRemoveByMobTaskUrlPSDEF(pSDEField2);
                PSSysMsgTemplServiceBase.this.internalRemoveByMobTaskUrlPSDEF(pSDEField2);
                PSSysMsgTemplServiceBase.this.onAfterRemoveByMobTaskUrlPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByMobTaskUrlPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByMobTaskUrlPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgTempl> arrayList = this.selectByMobTaskUrlPSDEF(pSDEField);
        this.onBeforeRemoveByMobTaskUrlPSDEF(pSDEField, arrayList);
        for (PSSysMsgTempl pSSysMsgTempl : arrayList) {
            this.remove(pSSysMsgTempl);
        }
        this.onAfterRemoveByMobTaskUrlPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByMobTaskUrlPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByMobTaskUrlPSDEF(PSDEField pSDEField, ArrayList<PSSysMsgTempl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByMobTaskUrlPSDEF(PSDEField pSDEField, ArrayList<PSSysMsgTempl> arrayList) throws Exception {
    }

    public void testRemoveBySMSContentPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgTempl> arrayList = this.selectBySMSContentPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMSGTEMPL_PSDEFIELD_SMSCONTENTPSDEFID", "", iDataEntityModel.getName(), "PSSYSMSGTEMPL", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetSMSContentPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgTempl> arrayList = this.selectBySMSContentPSDEF(pSDEField);
        for (PSSysMsgTempl pSSysMsgTempl : arrayList) {
            PSSysMsgTempl pSSysMsgTempl2 = (PSSysMsgTempl)this.getDEModel().createEntity();
            pSSysMsgTempl2.setPSSysMsgTemplId(pSSysMsgTempl.getPSSysMsgTemplId());
            pSSysMsgTempl2.setSMSContentPSDEFId(null);
            this.update(pSSysMsgTempl2);
        }
    }

    public void removeBySMSContentPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMsgTemplServiceBase.this.onBeforeRemoveBySMSContentPSDEF(pSDEField2);
                PSSysMsgTemplServiceBase.this.internalRemoveBySMSContentPSDEF(pSDEField2);
                PSSysMsgTemplServiceBase.this.onAfterRemoveBySMSContentPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveBySMSContentPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveBySMSContentPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgTempl> arrayList = this.selectBySMSContentPSDEF(pSDEField);
        this.onBeforeRemoveBySMSContentPSDEF(pSDEField, arrayList);
        for (PSSysMsgTempl pSSysMsgTempl : arrayList) {
            this.remove(pSSysMsgTempl);
        }
        this.onAfterRemoveBySMSContentPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveBySMSContentPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveBySMSContentPSDEF(PSDEField pSDEField, ArrayList<PSSysMsgTempl> arrayList) throws Exception {
    }

    protected void onAfterRemoveBySMSContentPSDEF(PSDEField pSDEField, ArrayList<PSSysMsgTempl> arrayList) throws Exception {
    }

    public void testRemoveBySubjectPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgTempl> arrayList = this.selectBySubjectPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMSGTEMPL_PSDEFIELD_SUBJECTPSDEFID", "", iDataEntityModel.getName(), "PSSYSMSGTEMPL", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetSubjectPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgTempl> arrayList = this.selectBySubjectPSDEF(pSDEField);
        for (PSSysMsgTempl pSSysMsgTempl : arrayList) {
            PSSysMsgTempl pSSysMsgTempl2 = (PSSysMsgTempl)this.getDEModel().createEntity();
            pSSysMsgTempl2.setPSSysMsgTemplId(pSSysMsgTempl.getPSSysMsgTemplId());
            pSSysMsgTempl2.setSubjectPSDEFId(null);
            this.update(pSSysMsgTempl2);
        }
    }

    public void removeBySubjectPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMsgTemplServiceBase.this.onBeforeRemoveBySubjectPSDEF(pSDEField2);
                PSSysMsgTemplServiceBase.this.internalRemoveBySubjectPSDEF(pSDEField2);
                PSSysMsgTemplServiceBase.this.onAfterRemoveBySubjectPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveBySubjectPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveBySubjectPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgTempl> arrayList = this.selectBySubjectPSDEF(pSDEField);
        this.onBeforeRemoveBySubjectPSDEF(pSDEField, arrayList);
        for (PSSysMsgTempl pSSysMsgTempl : arrayList) {
            this.remove(pSSysMsgTempl);
        }
        this.onAfterRemoveBySubjectPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveBySubjectPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveBySubjectPSDEF(PSDEField pSDEField, ArrayList<PSSysMsgTempl> arrayList) throws Exception {
    }

    protected void onAfterRemoveBySubjectPSDEF(PSDEField pSDEField, ArrayList<PSSysMsgTempl> arrayList) throws Exception {
    }

    public void testRemoveByTaskUrlPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgTempl> arrayList = this.selectByTaskUrlPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMSGTEMPL_PSDEFIELD_TASKURLPSDEFID", "", iDataEntityModel.getName(), "PSSYSMSGTEMPL", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetTaskUrlPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgTempl> arrayList = this.selectByTaskUrlPSDEF(pSDEField);
        for (PSSysMsgTempl pSSysMsgTempl : arrayList) {
            PSSysMsgTempl pSSysMsgTempl2 = (PSSysMsgTempl)this.getDEModel().createEntity();
            pSSysMsgTempl2.setPSSysMsgTemplId(pSSysMsgTempl.getPSSysMsgTemplId());
            pSSysMsgTempl2.setTaskUrlPSDEFId(null);
            this.update(pSSysMsgTempl2);
        }
    }

    public void removeByTaskUrlPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMsgTemplServiceBase.this.onBeforeRemoveByTaskUrlPSDEF(pSDEField2);
                PSSysMsgTemplServiceBase.this.internalRemoveByTaskUrlPSDEF(pSDEField2);
                PSSysMsgTemplServiceBase.this.onAfterRemoveByTaskUrlPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByTaskUrlPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByTaskUrlPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgTempl> arrayList = this.selectByTaskUrlPSDEF(pSDEField);
        this.onBeforeRemoveByTaskUrlPSDEF(pSDEField, arrayList);
        for (PSSysMsgTempl pSSysMsgTempl : arrayList) {
            this.remove(pSSysMsgTempl);
        }
        this.onAfterRemoveByTaskUrlPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByTaskUrlPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByTaskUrlPSDEF(PSDEField pSDEField, ArrayList<PSSysMsgTempl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByTaskUrlPSDEF(PSDEField pSDEField, ArrayList<PSSysMsgTempl> arrayList) throws Exception {
    }

    public void testRemoveByTemplTagPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgTempl> arrayList = this.selectByTemplTagPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMSGTEMPL_PSDEFIELD_TEMPLTAGPSDEFID", "", iDataEntityModel.getName(), "PSSYSMSGTEMPL", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetTemplTagPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgTempl> arrayList = this.selectByTemplTagPSDEF(pSDEField);
        for (PSSysMsgTempl pSSysMsgTempl : arrayList) {
            PSSysMsgTempl pSSysMsgTempl2 = (PSSysMsgTempl)this.getDEModel().createEntity();
            pSSysMsgTempl2.setPSSysMsgTemplId(pSSysMsgTempl.getPSSysMsgTemplId());
            pSSysMsgTempl2.setTemplTagPSDEFId(null);
            this.update(pSSysMsgTempl2);
        }
    }

    public void removeByTemplTagPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMsgTemplServiceBase.this.onBeforeRemoveByTemplTagPSDEF(pSDEField2);
                PSSysMsgTemplServiceBase.this.internalRemoveByTemplTagPSDEF(pSDEField2);
                PSSysMsgTemplServiceBase.this.onAfterRemoveByTemplTagPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByTemplTagPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByTemplTagPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgTempl> arrayList = this.selectByTemplTagPSDEF(pSDEField);
        this.onBeforeRemoveByTemplTagPSDEF(pSDEField, arrayList);
        for (PSSysMsgTempl pSSysMsgTempl : arrayList) {
            this.remove(pSSysMsgTempl);
        }
        this.onAfterRemoveByTemplTagPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByTemplTagPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByTemplTagPSDEF(PSDEField pSDEField, ArrayList<PSSysMsgTempl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByTemplTagPSDEF(PSDEField pSDEField, ArrayList<PSSysMsgTempl> arrayList) throws Exception {
    }

    public void testRemoveByUser2PSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgTempl> arrayList = this.selectByUser2PSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMSGTEMPL_PSDEFIELD_USER2PSDEFID", "", iDataEntityModel.getName(), "PSSYSMSGTEMPL", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetUser2PSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgTempl> arrayList = this.selectByUser2PSDEF(pSDEField);
        for (PSSysMsgTempl pSSysMsgTempl : arrayList) {
            PSSysMsgTempl pSSysMsgTempl2 = (PSSysMsgTempl)this.getDEModel().createEntity();
            pSSysMsgTempl2.setPSSysMsgTemplId(pSSysMsgTempl.getPSSysMsgTemplId());
            pSSysMsgTempl2.setUser2PSDEFId(null);
            this.update(pSSysMsgTempl2);
        }
    }

    public void removeByUser2PSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMsgTemplServiceBase.this.onBeforeRemoveByUser2PSDEF(pSDEField2);
                PSSysMsgTemplServiceBase.this.internalRemoveByUser2PSDEF(pSDEField2);
                PSSysMsgTemplServiceBase.this.onAfterRemoveByUser2PSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByUser2PSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByUser2PSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgTempl> arrayList = this.selectByUser2PSDEF(pSDEField);
        this.onBeforeRemoveByUser2PSDEF(pSDEField, arrayList);
        for (PSSysMsgTempl pSSysMsgTempl : arrayList) {
            this.remove(pSSysMsgTempl);
        }
        this.onAfterRemoveByUser2PSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByUser2PSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByUser2PSDEF(PSDEField pSDEField, ArrayList<PSSysMsgTempl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUser2PSDEF(PSDEField pSDEField, ArrayList<PSSysMsgTempl> arrayList) throws Exception {
    }

    public void testRemoveByUserPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgTempl> arrayList = this.selectByUserPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMSGTEMPL_PSDEFIELD_USERPSDEFID", "", iDataEntityModel.getName(), "PSSYSMSGTEMPL", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetUserPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgTempl> arrayList = this.selectByUserPSDEF(pSDEField);
        for (PSSysMsgTempl pSSysMsgTempl : arrayList) {
            PSSysMsgTempl pSSysMsgTempl2 = (PSSysMsgTempl)this.getDEModel().createEntity();
            pSSysMsgTempl2.setPSSysMsgTemplId(pSSysMsgTempl.getPSSysMsgTemplId());
            pSSysMsgTempl2.setUserPSDEFId(null);
            this.update(pSSysMsgTempl2);
        }
    }

    public void removeByUserPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMsgTemplServiceBase.this.onBeforeRemoveByUserPSDEF(pSDEField2);
                PSSysMsgTemplServiceBase.this.internalRemoveByUserPSDEF(pSDEField2);
                PSSysMsgTemplServiceBase.this.onAfterRemoveByUserPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByUserPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByUserPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgTempl> arrayList = this.selectByUserPSDEF(pSDEField);
        this.onBeforeRemoveByUserPSDEF(pSDEField, arrayList);
        for (PSSysMsgTempl pSSysMsgTempl : arrayList) {
            this.remove(pSSysMsgTempl);
        }
        this.onAfterRemoveByUserPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByUserPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByUserPSDEF(PSDEField pSDEField, ArrayList<PSSysMsgTempl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUserPSDEF(PSDEField pSDEField, ArrayList<PSSysMsgTempl> arrayList) throws Exception {
    }

    public void testRemoveByWCContentPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgTempl> arrayList = this.selectByWCContentPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMSGTEMPL_PSDEFIELD_WCCONTENTPSDEFID", "", iDataEntityModel.getName(), "PSSYSMSGTEMPL", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetWCContentPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgTempl> arrayList = this.selectByWCContentPSDEF(pSDEField);
        for (PSSysMsgTempl pSSysMsgTempl : arrayList) {
            PSSysMsgTempl pSSysMsgTempl2 = (PSSysMsgTempl)this.getDEModel().createEntity();
            pSSysMsgTempl2.setPSSysMsgTemplId(pSSysMsgTempl.getPSSysMsgTemplId());
            pSSysMsgTempl2.setWCContentPSDEFId(null);
            this.update(pSSysMsgTempl2);
        }
    }

    public void removeByWCContentPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMsgTemplServiceBase.this.onBeforeRemoveByWCContentPSDEF(pSDEField2);
                PSSysMsgTemplServiceBase.this.internalRemoveByWCContentPSDEF(pSDEField2);
                PSSysMsgTemplServiceBase.this.onAfterRemoveByWCContentPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByWCContentPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByWCContentPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgTempl> arrayList = this.selectByWCContentPSDEF(pSDEField);
        this.onBeforeRemoveByWCContentPSDEF(pSDEField, arrayList);
        for (PSSysMsgTempl pSSysMsgTempl : arrayList) {
            this.remove(pSSysMsgTempl);
        }
        this.onAfterRemoveByWCContentPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByWCContentPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByWCContentPSDEF(PSDEField pSDEField, ArrayList<PSSysMsgTempl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByWCContentPSDEF(PSDEField pSDEField, ArrayList<PSSysMsgTempl> arrayList) throws Exception {
    }

    public void testRemoveByContentPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSSysMsgTempl> arrayList = this.selectByContentPSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMSGTEMPL_PSLANGUAGERES_CONTENTPSLANRESID", "", iDataEntityModel.getName(), "PSSYSMSGTEMPL", iDataEntityModel.getDataInfo(pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetContentPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSSysMsgTempl> arrayList = this.selectByContentPSLanRes(pSLanguageRes);
        for (PSSysMsgTempl pSSysMsgTempl : arrayList) {
            PSSysMsgTempl pSSysMsgTempl2 = (PSSysMsgTempl)this.getDEModel().createEntity();
            pSSysMsgTempl2.setPSSysMsgTemplId(pSSysMsgTempl.getPSSysMsgTemplId());
            pSSysMsgTempl2.setContentPSLanResId(null);
            this.update(pSSysMsgTempl2);
        }
    }

    public void removeByContentPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMsgTemplServiceBase.this.onBeforeRemoveByContentPSLanRes(pSLanguageRes2);
                PSSysMsgTemplServiceBase.this.internalRemoveByContentPSLanRes(pSLanguageRes2);
                PSSysMsgTemplServiceBase.this.onAfterRemoveByContentPSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByContentPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByContentPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSSysMsgTempl> arrayList = this.selectByContentPSLanRes(pSLanguageRes);
        this.onBeforeRemoveByContentPSLanRes(pSLanguageRes, arrayList);
        for (PSSysMsgTempl pSSysMsgTempl : arrayList) {
            this.remove(pSSysMsgTempl);
        }
        this.onAfterRemoveByContentPSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByContentPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByContentPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSSysMsgTempl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByContentPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSSysMsgTempl> arrayList) throws Exception {
    }

    public void testRemoveByDDPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSSysMsgTempl> arrayList = this.selectByDDPSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMSGTEMPL_PSLANGUAGERES_DDPSLANRESID", "", iDataEntityModel.getName(), "PSSYSMSGTEMPL", iDataEntityModel.getDataInfo(pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetDDPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSSysMsgTempl> arrayList = this.selectByDDPSLanRes(pSLanguageRes);
        for (PSSysMsgTempl pSSysMsgTempl : arrayList) {
            PSSysMsgTempl pSSysMsgTempl2 = (PSSysMsgTempl)this.getDEModel().createEntity();
            pSSysMsgTempl2.setPSSysMsgTemplId(pSSysMsgTempl.getPSSysMsgTemplId());
            pSSysMsgTempl2.setDDPSLanResId(null);
            this.update(pSSysMsgTempl2);
        }
    }

    public void removeByDDPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMsgTemplServiceBase.this.onBeforeRemoveByDDPSLanRes(pSLanguageRes2);
                PSSysMsgTemplServiceBase.this.internalRemoveByDDPSLanRes(pSLanguageRes2);
                PSSysMsgTemplServiceBase.this.onAfterRemoveByDDPSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByDDPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByDDPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSSysMsgTempl> arrayList = this.selectByDDPSLanRes(pSLanguageRes);
        this.onBeforeRemoveByDDPSLanRes(pSLanguageRes, arrayList);
        for (PSSysMsgTempl pSSysMsgTempl : arrayList) {
            this.remove(pSSysMsgTempl);
        }
        this.onAfterRemoveByDDPSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByDDPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByDDPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSSysMsgTempl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByDDPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSSysMsgTempl> arrayList) throws Exception {
    }

    public void testRemoveByIMPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSSysMsgTempl> arrayList = this.selectByIMPSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMSGTEMPL_PSLANGUAGERES_IMPSLANRESID", "", iDataEntityModel.getName(), "PSSYSMSGTEMPL", iDataEntityModel.getDataInfo(pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetIMPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSSysMsgTempl> arrayList = this.selectByIMPSLanRes(pSLanguageRes);
        for (PSSysMsgTempl pSSysMsgTempl : arrayList) {
            PSSysMsgTempl pSSysMsgTempl2 = (PSSysMsgTempl)this.getDEModel().createEntity();
            pSSysMsgTempl2.setPSSysMsgTemplId(pSSysMsgTempl.getPSSysMsgTemplId());
            pSSysMsgTempl2.setIMPSLanResId(null);
            this.update(pSSysMsgTempl2);
        }
    }

    public void removeByIMPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMsgTemplServiceBase.this.onBeforeRemoveByIMPSLanRes(pSLanguageRes2);
                PSSysMsgTemplServiceBase.this.internalRemoveByIMPSLanRes(pSLanguageRes2);
                PSSysMsgTemplServiceBase.this.onAfterRemoveByIMPSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByIMPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByIMPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSSysMsgTempl> arrayList = this.selectByIMPSLanRes(pSLanguageRes);
        this.onBeforeRemoveByIMPSLanRes(pSLanguageRes, arrayList);
        for (PSSysMsgTempl pSSysMsgTempl : arrayList) {
            this.remove(pSSysMsgTempl);
        }
        this.onAfterRemoveByIMPSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByIMPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByIMPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSSysMsgTempl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByIMPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSSysMsgTempl> arrayList) throws Exception {
    }

    public void testRemoveBySMSPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSSysMsgTempl> arrayList = this.selectBySMSPSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMSGTEMPL_PSLANGUAGERES_SMSPSLANRESID", "", iDataEntityModel.getName(), "PSSYSMSGTEMPL", iDataEntityModel.getDataInfo(pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetSMSPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSSysMsgTempl> arrayList = this.selectBySMSPSLanRes(pSLanguageRes);
        for (PSSysMsgTempl pSSysMsgTempl : arrayList) {
            PSSysMsgTempl pSSysMsgTempl2 = (PSSysMsgTempl)this.getDEModel().createEntity();
            pSSysMsgTempl2.setPSSysMsgTemplId(pSSysMsgTempl.getPSSysMsgTemplId());
            pSSysMsgTempl2.setSMSPSLanResId(null);
            this.update(pSSysMsgTempl2);
        }
    }

    public void removeBySMSPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMsgTemplServiceBase.this.onBeforeRemoveBySMSPSLanRes(pSLanguageRes2);
                PSSysMsgTemplServiceBase.this.internalRemoveBySMSPSLanRes(pSLanguageRes2);
                PSSysMsgTemplServiceBase.this.onAfterRemoveBySMSPSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveBySMSPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveBySMSPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSSysMsgTempl> arrayList = this.selectBySMSPSLanRes(pSLanguageRes);
        this.onBeforeRemoveBySMSPSLanRes(pSLanguageRes, arrayList);
        for (PSSysMsgTempl pSSysMsgTempl : arrayList) {
            this.remove(pSSysMsgTempl);
        }
        this.onAfterRemoveBySMSPSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveBySMSPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveBySMSPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSSysMsgTempl> arrayList) throws Exception {
    }

    protected void onAfterRemoveBySMSPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSSysMsgTempl> arrayList) throws Exception {
    }

    public void testRemoveBySubPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSSysMsgTempl> arrayList = this.selectBySubPSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMSGTEMPL_PSLANGUAGERES_SUBPSLANRESID", "", iDataEntityModel.getName(), "PSSYSMSGTEMPL", iDataEntityModel.getDataInfo(pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetSubPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSSysMsgTempl> arrayList = this.selectBySubPSLanRes(pSLanguageRes);
        for (PSSysMsgTempl pSSysMsgTempl : arrayList) {
            PSSysMsgTempl pSSysMsgTempl2 = (PSSysMsgTempl)this.getDEModel().createEntity();
            pSSysMsgTempl2.setPSSysMsgTemplId(pSSysMsgTempl.getPSSysMsgTemplId());
            pSSysMsgTempl2.setSubPSLanResId(null);
            this.update(pSSysMsgTempl2);
        }
    }

    public void removeBySubPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMsgTemplServiceBase.this.onBeforeRemoveBySubPSLanRes(pSLanguageRes2);
                PSSysMsgTemplServiceBase.this.internalRemoveBySubPSLanRes(pSLanguageRes2);
                PSSysMsgTemplServiceBase.this.onAfterRemoveBySubPSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveBySubPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveBySubPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSSysMsgTempl> arrayList = this.selectBySubPSLanRes(pSLanguageRes);
        this.onBeforeRemoveBySubPSLanRes(pSLanguageRes, arrayList);
        for (PSSysMsgTempl pSSysMsgTempl : arrayList) {
            this.remove(pSSysMsgTempl);
        }
        this.onAfterRemoveBySubPSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveBySubPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveBySubPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSSysMsgTempl> arrayList) throws Exception {
    }

    protected void onAfterRemoveBySubPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSSysMsgTempl> arrayList) throws Exception {
    }

    public void testRemoveByWXPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSSysMsgTempl> arrayList = this.selectByWXPSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMSGTEMPL_PSLANGUAGERES_WXPSLANRESID", "", iDataEntityModel.getName(), "PSSYSMSGTEMPL", iDataEntityModel.getDataInfo(pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetWXPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSSysMsgTempl> arrayList = this.selectByWXPSLanRes(pSLanguageRes);
        for (PSSysMsgTempl pSSysMsgTempl : arrayList) {
            PSSysMsgTempl pSSysMsgTempl2 = (PSSysMsgTempl)this.getDEModel().createEntity();
            pSSysMsgTempl2.setPSSysMsgTemplId(pSSysMsgTempl.getPSSysMsgTemplId());
            pSSysMsgTempl2.setWXPSLanResId(null);
            this.update(pSSysMsgTempl2);
        }
    }

    public void removeByWXPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMsgTemplServiceBase.this.onBeforeRemoveByWXPSLanRes(pSLanguageRes2);
                PSSysMsgTemplServiceBase.this.internalRemoveByWXPSLanRes(pSLanguageRes2);
                PSSysMsgTemplServiceBase.this.onAfterRemoveByWXPSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByWXPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByWXPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSSysMsgTempl> arrayList = this.selectByWXPSLanRes(pSLanguageRes);
        this.onBeforeRemoveByWXPSLanRes(pSLanguageRes, arrayList);
        for (PSSysMsgTempl pSSysMsgTempl : arrayList) {
            this.remove(pSSysMsgTempl);
        }
        this.onAfterRemoveByWXPSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByWXPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByWXPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSSysMsgTempl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByWXPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSSysMsgTempl> arrayList) throws Exception {
    }

    public void testRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSysMsgTempl> arrayList = this.selectByPSModule(pSModule, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSMODULE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSModule);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMSGTEMPL_PSMODULE_PSMODULEID", "", iDataEntityModel.getName(), "PSSYSMSGTEMPL", iDataEntityModel.getDataInfo(pSModule), arrayList.get(0)));
        }
    }

    public void resetPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSysMsgTempl> arrayList = this.selectByPSModule(pSModule);
        for (PSSysMsgTempl pSSysMsgTempl : arrayList) {
            PSSysMsgTempl pSSysMsgTempl2 = (PSSysMsgTempl)this.getDEModel().createEntity();
            pSSysMsgTempl2.setPSSysMsgTemplId(pSSysMsgTempl.getPSSysMsgTemplId());
            pSSysMsgTempl2.setPSModuleId(null);
            this.update(pSSysMsgTempl2);
        }
    }

    public void removeByPSModule(PSModule pSModule) throws Exception {
        final PSModule pSModule2 = pSModule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMsgTemplServiceBase.this.onBeforeRemoveByPSModule(pSModule2);
                PSSysMsgTemplServiceBase.this.internalRemoveByPSModule(pSModule2);
                PSSysMsgTemplServiceBase.this.onAfterRemoveByPSModule(pSModule2);
            }
        });
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void internalRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSysMsgTempl> arrayList = this.selectByPSModule(pSModule);
        this.onBeforeRemoveByPSModule(pSModule, arrayList);
        for (PSSysMsgTempl pSSysMsgTempl : arrayList) {
            this.remove(pSSysMsgTempl);
        }
        this.onAfterRemoveByPSModule(pSModule, arrayList);
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule, ArrayList<PSSysMsgTempl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule, ArrayList<PSSysMsgTempl> arrayList) throws Exception {
    }

    public void testRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSSysMsgTempl> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSDYNAMODEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysDynaModel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMSGTEMPL_PSSYSDYNAMODEL_PSSYSDYNAMODELID", "", iDataEntityModel.getName(), "PSSYSMSGTEMPL", iDataEntityModel.getDataInfo(pSSysDynaModel), arrayList.get(0)));
        }
    }

    public void resetPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSSysMsgTempl> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        for (PSSysMsgTempl pSSysMsgTempl : arrayList) {
            PSSysMsgTempl pSSysMsgTempl2 = (PSSysMsgTempl)this.getDEModel().createEntity();
            pSSysMsgTempl2.setPSSysMsgTemplId(pSSysMsgTempl.getPSSysMsgTemplId());
            pSSysMsgTempl2.setPSSysDynaModelId(null);
            this.update(pSSysMsgTempl2);
        }
    }

    public void removeByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        final PSSysDynaModel pSSysDynaModel2 = pSSysDynaModel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMsgTemplServiceBase.this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSSysMsgTemplServiceBase.this.internalRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSSysMsgTemplServiceBase.this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void internalRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSSysMsgTempl> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
        for (PSSysMsgTempl pSSysMsgTempl : arrayList) {
            this.remove(pSSysMsgTempl);
        }
        this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSSysMsgTempl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSSysMsgTempl> arrayList) throws Exception {
    }

    public void testRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSSysMsgTempl> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSSFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysSFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMSGTEMPL_PSSYSSFPLUGIN_PSSYSSFPLUGINID", "", iDataEntityModel.getName(), "PSSYSMSGTEMPL", iDataEntityModel.getDataInfo(pSSysSFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSSysMsgTempl> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        for (PSSysMsgTempl pSSysMsgTempl : arrayList) {
            PSSysMsgTempl pSSysMsgTempl2 = (PSSysMsgTempl)this.getDEModel().createEntity();
            pSSysMsgTempl2.setPSSysMsgTemplId(pSSysMsgTempl.getPSSysMsgTemplId());
            pSSysMsgTempl2.setPSSysSFPluginId(null);
            this.update(pSSysMsgTempl2);
        }
    }

    public void removeByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        final PSSysSFPlugin pSSysSFPlugin2 = pSSysSFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMsgTemplServiceBase.this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSSysMsgTemplServiceBase.this.internalRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSSysMsgTemplServiceBase.this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSSysMsgTempl> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
        for (PSSysMsgTempl pSSysMsgTempl : arrayList) {
            this.remove(pSSysMsgTempl);
        }
        this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSSysMsgTempl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSSysMsgTempl> arrayList) throws Exception {
    }

    public void testRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    public void resetPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysMsgTempl> arrayList = this.selectByPSSystem(pSSystem);
        for (PSSysMsgTempl pSSysMsgTempl : arrayList) {
            PSSysMsgTempl pSSysMsgTempl2 = (PSSysMsgTempl)this.getDEModel().createEntity();
            pSSysMsgTempl2.setPSSysMsgTemplId(pSSysMsgTempl.getPSSysMsgTemplId());
            pSSysMsgTempl2.setPSSystemId(null);
            this.update(pSSysMsgTempl2);
        }
    }

    public void removeByPSSystem(PSSystem pSSystem) throws Exception {
        final PSSystem pSSystem2 = pSSystem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMsgTemplServiceBase.this.onBeforeRemoveByPSSystem(pSSystem2);
                PSSysMsgTemplServiceBase.this.internalRemoveByPSSystem(pSSystem2);
                PSSysMsgTemplServiceBase.this.onAfterRemoveByPSSystem(pSSystem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void internalRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysMsgTempl> arrayList = this.selectByPSSystem(pSSystem);
        this.onBeforeRemoveByPSSystem(pSSystem, arrayList);
        for (PSSysMsgTempl pSSysMsgTempl : arrayList) {
            this.remove(pSSysMsgTempl);
        }
        this.onAfterRemoveByPSSystem(pSSystem, arrayList);
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSysMsgTempl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSysMsgTempl> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysMsgTempl pSSysMsgTempl) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEACModeService)ServiceGlobal.getService(PSDEACModeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEACModeServiceBase)pSCoreSysServiceBase).testRemoveByHistoryPSSysMsgTempl(pSSysMsgTempl);
        pSCoreSysServiceBase = (PSDELNParamService)ServiceGlobal.getService(PSDELNParamService.class, (SessionFactory)this.getSessionFactory());
        ((PSDELNParamServiceBase)pSCoreSysServiceBase).testRemoveByPSSysMsgTempl(pSSysMsgTempl);
        pSCoreSysServiceBase = (PSDELogicNodeService)ServiceGlobal.getService(PSDELogicNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDELogicNodeServiceBase)pSCoreSysServiceBase).testRemoveByPSSysMsgTempl(pSSysMsgTempl);
        pSCoreSysServiceBase = (PSDENotifyService)ServiceGlobal.getService(PSDENotifyService.class, (SessionFactory)this.getSessionFactory());
        ((PSDENotifyServiceBase)pSCoreSysServiceBase).testRemoveByPSSysMsgTempl(pSSysMsgTempl);
        pSCoreSysServiceBase = (PSDEViewCtrlService)ServiceGlobal.getService(PSDEViewCtrlService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEViewCtrlServiceBase)pSCoreSysServiceBase).testRemoveByPSSysMsgTempl(pSSysMsgTempl);
        pSCoreSysServiceBase = (PSSysWFSettingService)ServiceGlobal.getService(PSSysWFSettingService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysWFSettingServiceBase)pSCoreSysServiceBase).testRemoveByPSSysMsgTempl(pSSysMsgTempl);
        pSCoreSysServiceBase = (PSViewMsgService)ServiceGlobal.getService(PSViewMsgService.class, (SessionFactory)this.getSessionFactory());
        ((PSViewMsgServiceBase)pSCoreSysServiceBase).testRemoveByPSSysMsgTempl(pSSysMsgTempl);
        pSCoreSysServiceBase = (PSWFLinkRoleService)ServiceGlobal.getService(PSWFLinkRoleService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFLinkRoleServiceBase)pSCoreSysServiceBase).testRemoveByPSSysMsgTempl(pSSysMsgTempl);
        pSCoreSysServiceBase = (PSWFProcessService)ServiceGlobal.getService(PSWFProcessService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFProcessServiceBase)pSCoreSysServiceBase).testRemoveByPSSysMsgTempl(pSSysMsgTempl);
        pSCoreSysServiceBase = (PSWFProcRoleService)ServiceGlobal.getService(PSWFProcRoleService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFProcRoleServiceBase)pSCoreSysServiceBase).testRemoveByPSSysMsgTempl(pSSysMsgTempl);
        pSCoreSysServiceBase = (PSWorkflowService)ServiceGlobal.getService(PSWorkflowService.class, (SessionFactory)this.getSessionFactory());
        ((PSWorkflowServiceBase)pSCoreSysServiceBase).testRemoveByRemindPSSysMsgTempl(pSSysMsgTempl);
        super.onBeforeRemove(pSSysMsgTempl);
    }

    protected void replaceParentInfo(PSSysMsgTempl pSSysMsgTempl, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSysMsgTempl, cloneSession);
        if (pSSysMsgTempl.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSSysMsgTempl.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSSysMsgTempl, (PSDataEntity)iEntity);
        }
        if (pSSysMsgTempl.getPSDEDSId() != null && (iEntity = cloneSession.getEntity("PSDEDATASET", (Object)pSSysMsgTempl.getPSDEDSId())) != null) {
            this.onFillParentInfo_PSDEDS(pSSysMsgTempl, (PSDEDataSet)iEntity);
        }
        if (pSSysMsgTempl.getContentPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysMsgTempl.getContentPSDEFId())) != null) {
            this.onFillParentInfo_ContentPSDEF(pSSysMsgTempl, (PSDEField)iEntity);
        }
        if (pSSysMsgTempl.getContentTypePSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysMsgTempl.getContentTypePSDEFId())) != null) {
            this.onFillParentInfo_ContentTypePSDEF(pSSysMsgTempl, (PSDEField)iEntity);
        }
        if (pSSysMsgTempl.getDDContentPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysMsgTempl.getDDContentPSDEFId())) != null) {
            this.onFillParentInfo_DDContentPSDEF(pSSysMsgTempl, (PSDEField)iEntity);
        }
        if (pSSysMsgTempl.getIMContentPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysMsgTempl.getIMContentPSDEFId())) != null) {
            this.onFillParentInfo_IMContentPSDEF(pSSysMsgTempl, (PSDEField)iEntity);
        }
        if (pSSysMsgTempl.getLanPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysMsgTempl.getLanPSDEFId())) != null) {
            this.onFillParentInfo_LanPSDEF(pSSysMsgTempl, (PSDEField)iEntity);
        }
        if (pSSysMsgTempl.getMobTaskUrlPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysMsgTempl.getMobTaskUrlPSDEFId())) != null) {
            this.onFillParentInfo_MobTaskUrlPSDEF(pSSysMsgTempl, (PSDEField)iEntity);
        }
        if (pSSysMsgTempl.getSMSContentPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysMsgTempl.getSMSContentPSDEFId())) != null) {
            this.onFillParentInfo_SMSContentPSDEF(pSSysMsgTempl, (PSDEField)iEntity);
        }
        if (pSSysMsgTempl.getSubjectPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysMsgTempl.getSubjectPSDEFId())) != null) {
            this.onFillParentInfo_SubjectPSDEF(pSSysMsgTempl, (PSDEField)iEntity);
        }
        if (pSSysMsgTempl.getTaskUrlPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysMsgTempl.getTaskUrlPSDEFId())) != null) {
            this.onFillParentInfo_TaskUrlPSDEF(pSSysMsgTempl, (PSDEField)iEntity);
        }
        if (pSSysMsgTempl.getTemplTagPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysMsgTempl.getTemplTagPSDEFId())) != null) {
            this.onFillParentInfo_TemplTagPSDEF(pSSysMsgTempl, (PSDEField)iEntity);
        }
        if (pSSysMsgTempl.getUser2PSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysMsgTempl.getUser2PSDEFId())) != null) {
            this.onFillParentInfo_User2PSDEF(pSSysMsgTempl, (PSDEField)iEntity);
        }
        if (pSSysMsgTempl.getUserPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysMsgTempl.getUserPSDEFId())) != null) {
            this.onFillParentInfo_UserPSDEF(pSSysMsgTempl, (PSDEField)iEntity);
        }
        if (pSSysMsgTempl.getWCContentPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysMsgTempl.getWCContentPSDEFId())) != null) {
            this.onFillParentInfo_WCContentPSDEF(pSSysMsgTempl, (PSDEField)iEntity);
        }
        if (pSSysMsgTempl.getContentPSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSSysMsgTempl.getContentPSLanResId())) != null) {
            this.onFillParentInfo_ContentPSLanRes(pSSysMsgTempl, (PSLanguageRes)iEntity);
        }
        if (pSSysMsgTempl.getDDPSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSSysMsgTempl.getDDPSLanResId())) != null) {
            this.onFillParentInfo_DDPSLanRes(pSSysMsgTempl, (PSLanguageRes)iEntity);
        }
        if (pSSysMsgTempl.getIMPSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSSysMsgTempl.getIMPSLanResId())) != null) {
            this.onFillParentInfo_IMPSLanRes(pSSysMsgTempl, (PSLanguageRes)iEntity);
        }
        if (pSSysMsgTempl.getSMSPSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSSysMsgTempl.getSMSPSLanResId())) != null) {
            this.onFillParentInfo_SMSPSLanRes(pSSysMsgTempl, (PSLanguageRes)iEntity);
        }
        if (pSSysMsgTempl.getSubPSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSSysMsgTempl.getSubPSLanResId())) != null) {
            this.onFillParentInfo_SubPSLanRes(pSSysMsgTempl, (PSLanguageRes)iEntity);
        }
        if (pSSysMsgTempl.getWXPSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSSysMsgTempl.getWXPSLanResId())) != null) {
            this.onFillParentInfo_WXPSLanRes(pSSysMsgTempl, (PSLanguageRes)iEntity);
        }
        if (pSSysMsgTempl.getPSModuleId() != null && (iEntity = cloneSession.getEntity("PSMODULE", (Object)pSSysMsgTempl.getPSModuleId())) != null) {
            this.onFillParentInfo_PSModule(pSSysMsgTempl, (PSModule)iEntity);
        }
        if (pSSysMsgTempl.getPSSysDynaModelId() != null && (iEntity = cloneSession.getEntity("PSSYSDYNAMODEL", (Object)pSSysMsgTempl.getPSSysDynaModelId())) != null) {
            this.onFillParentInfo_PSSysDynaModel(pSSysMsgTempl, (PSSysDynaModel)iEntity);
        }
        if (pSSysMsgTempl.getPSSysSFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSSFPLUGIN", (Object)pSSysMsgTempl.getPSSysSFPluginId())) != null) {
            this.onFillParentInfo_PSSysSFPlugin(pSSysMsgTempl, (PSSysSFPlugin)iEntity);
        }
        if (pSSysMsgTempl.getPSSystemId() != null && (iEntity = cloneSession.getEntity("PSSYSTEM", (Object)pSSysMsgTempl.getPSSystemId())) != null) {
            this.onFillParentInfo_PSSystem(pSSysMsgTempl, (PSSystem)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysMsgTempl pSSysMsgTempl, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSysMsgTempl, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysMsgTempl pSSysMsgTempl, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CodeName(bl, pSSysMsgTempl, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Content(bl, pSSysMsgTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ContentPSDEFId(bl, pSSysMsgTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ContentPSDEFName(bl, pSSysMsgTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ContentPSLanResId(bl, pSSysMsgTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ContentPSLanResName(bl, pSSysMsgTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ContentType(bl, pSSysMsgTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ContentTypePSDEFId(bl, pSSysMsgTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ContentTypePSDEFName(bl, pSSysMsgTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomCode(bl, pSSysMsgTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomMode(bl, pSSysMsgTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DDContent(bl, pSSysMsgTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DDContentPSDEFId(bl, pSSysMsgTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DDContentPSDEFName(bl, pSSysMsgTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DDPSLanResId(bl, pSSysMsgTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DDPSLanResName(bl, pSSysMsgTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IMContent(bl, pSSysMsgTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IMContentPSDEFId(bl, pSSysMsgTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IMContentPSDEFName(bl, pSSysMsgTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IMPSLanResId(bl, pSSysMsgTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IMPSLanResName(bl, pSSysMsgTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LanPSDEFId(bl, pSSysMsgTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LanPSDEFName(bl, pSSysMsgTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LockFlag(bl, pSSysMsgTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MailGroupSend(bl, pSSysMsgTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysMsgTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MobTaskUrl(bl, pSSysMsgTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MobTaskUrlPSDEFId(bl, pSSysMsgTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MobTaskUrlPSDEFName(bl, pSSysMsgTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MsgTemplParams(bl, pSSysMsgTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MsgTemplTag(bl, pSSysMsgTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MsgTemplTag2(bl, pSSysMsgTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MsgTemplType(bl, pSSysMsgTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDSId(bl, pSSysMsgTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSSysMsgTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSSysMsgTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModuleId(bl, pSSysMsgTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDynaModelId(bl, pSSysMsgTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysMsgTemplId(bl, pSSysMsgTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysMsgTemplName(bl, pSSysMsgTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSFPluginId(bl, pSSysMsgTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSSysMsgTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SMSContent(bl, pSSysMsgTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SMSContentPSDEFId(bl, pSSysMsgTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SMSContentPSDEFName(bl, pSSysMsgTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SMSPSLanResId(bl, pSSysMsgTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SMSPSLanResName(bl, pSSysMsgTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Subject(bl, pSSysMsgTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SubjectPSDEFId(bl, pSSysMsgTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SubjectPSDEFName(bl, pSSysMsgTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SubPSLanResId(bl, pSSysMsgTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SubPSLanResName(bl, pSSysMsgTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TaskUrl(bl, pSSysMsgTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TaskUrlPSDEFId(bl, pSSysMsgTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TaskUrlPSDEFName(bl, pSSysMsgTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TemplEngine(bl, pSSysMsgTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TemplTagPSDEFId(bl, pSSysMsgTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TemplTagPSDEFName(bl, pSSysMsgTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_User2PSDEFId(bl, pSSysMsgTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_User2PSDEFName(bl, pSSysMsgTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSysMsgTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserPSDEFId(bl, pSSysMsgTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserPSDEFName(bl, pSSysMsgTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysMsgTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysMsgTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSysMsgTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSysMsgTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WCContent(bl, pSSysMsgTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WCContentPSDEFId(bl, pSSysMsgTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WCContentPSDEFName(bl, pSSysMsgTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WXPSLanResId(bl, pSSysMsgTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WXPSLanResName(bl, pSSysMsgTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSysMsgTempl, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSSysMsgTempl pSSysMsgTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTempl.isCodeNameDirty() : !pSSysMsgTempl.isCodeNameDirty()) {
            return null;
        }
        String string = pSSysMsgTempl.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSSysMsgTempl, bl2, bl3);
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
                string3 = "PSMODULEID";
                string3 = string3 + ";";
                string3 = string3 + "PSSYSTEMID";
                String string4 = this.checkFieldDupRule(this.getPSSysMsgTemplDEModel(), "CODENAME", string3, pSSysMsgTempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_Content(boolean bl, PSSysMsgTempl pSSysMsgTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTempl.isContentDirty() && !bl2 : !pSSysMsgTempl.isContentDirty()) {
            return null;
        }
        String string = pSSysMsgTempl.getContent();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONTENT");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_Content_Default(pSSysMsgTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONTENT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ContentPSDEFId(boolean bl, PSSysMsgTempl pSSysMsgTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTempl.isContentPSDEFIdDirty() : !pSSysMsgTempl.isContentPSDEFIdDirty()) {
            return null;
        }
        String string = pSSysMsgTempl.getContentPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ContentPSDEFId_Default(pSSysMsgTempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_ContentPSDEFName(boolean bl, PSSysMsgTempl pSSysMsgTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTempl.isContentPSDEFNameDirty() : !pSSysMsgTempl.isContentPSDEFNameDirty()) {
            return null;
        }
        String string = pSSysMsgTempl.getContentPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ContentPSDEFName_Default(pSSysMsgTempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_ContentPSLanResId(boolean bl, PSSysMsgTempl pSSysMsgTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTempl.isContentPSLanResIdDirty() : !pSSysMsgTempl.isContentPSLanResIdDirty()) {
            return null;
        }
        String string = pSSysMsgTempl.getContentPSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ContentPSLanResId_Default(pSSysMsgTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONTENTPSLANRESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ContentPSLanResName(boolean bl, PSSysMsgTempl pSSysMsgTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTempl.isContentPSLanResNameDirty() : !pSSysMsgTempl.isContentPSLanResNameDirty()) {
            return null;
        }
        String string = pSSysMsgTempl.getContentPSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ContentPSLanResName_Default(pSSysMsgTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONTENTPSLANRESNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ContentType(boolean bl, PSSysMsgTempl pSSysMsgTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTempl.isContentTypeDirty() && !bl2 : !pSSysMsgTempl.isContentTypeDirty()) {
            return null;
        }
        String string = pSSysMsgTempl.getContentType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONTENTTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_ContentType_Default(pSSysMsgTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONTENTTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ContentTypePSDEFId(boolean bl, PSSysMsgTempl pSSysMsgTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTempl.isContentTypePSDEFIdDirty() : !pSSysMsgTempl.isContentTypePSDEFIdDirty()) {
            return null;
        }
        String string = pSSysMsgTempl.getContentTypePSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ContentTypePSDEFId_Default(pSSysMsgTempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_ContentTypePSDEFName(boolean bl, PSSysMsgTempl pSSysMsgTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTempl.isContentTypePSDEFNameDirty() : !pSSysMsgTempl.isContentTypePSDEFNameDirty()) {
            return null;
        }
        String string = pSSysMsgTempl.getContentTypePSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ContentTypePSDEFName_Default(pSSysMsgTempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_CustomCode(boolean bl, PSSysMsgTempl pSSysMsgTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTempl.isCustomCodeDirty() : !pSSysMsgTempl.isCustomCodeDirty()) {
            return null;
        }
        String string = pSSysMsgTempl.getCustomCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomCode_Default(pSSysMsgTempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_CustomMode(boolean bl, PSSysMsgTempl pSSysMsgTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTempl.isCustomModeDirty() : !pSSysMsgTempl.isCustomModeDirty()) {
            return null;
        }
        Integer n = pSSysMsgTempl.getCustomMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CustomMode_Default(pSSysMsgTempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_DDContent(boolean bl, PSSysMsgTempl pSSysMsgTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTempl.isDDContentDirty() : !pSSysMsgTempl.isDDContentDirty()) {
            return null;
        }
        String string = pSSysMsgTempl.getDDContent();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DDContent_Default(pSSysMsgTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DDCONTENT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DDContentPSDEFId(boolean bl, PSSysMsgTempl pSSysMsgTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTempl.isDDContentPSDEFIdDirty() : !pSSysMsgTempl.isDDContentPSDEFIdDirty()) {
            return null;
        }
        String string = pSSysMsgTempl.getDDContentPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DDContentPSDEFId_Default(pSSysMsgTempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_DDContentPSDEFName(boolean bl, PSSysMsgTempl pSSysMsgTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTempl.isDDContentPSDEFNameDirty() : !pSSysMsgTempl.isDDContentPSDEFNameDirty()) {
            return null;
        }
        String string = pSSysMsgTempl.getDDContentPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DDContentPSDEFName_Default(pSSysMsgTempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_DDPSLanResId(boolean bl, PSSysMsgTempl pSSysMsgTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTempl.isDDPSLanResIdDirty() : !pSSysMsgTempl.isDDPSLanResIdDirty()) {
            return null;
        }
        String string = pSSysMsgTempl.getDDPSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DDPSLanResId_Default(pSSysMsgTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DDPSLANRESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DDPSLanResName(boolean bl, PSSysMsgTempl pSSysMsgTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTempl.isDDPSLanResNameDirty() : !pSSysMsgTempl.isDDPSLanResNameDirty()) {
            return null;
        }
        String string = pSSysMsgTempl.getDDPSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DDPSLanResName_Default(pSSysMsgTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DDPSLANRESNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IMContent(boolean bl, PSSysMsgTempl pSSysMsgTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTempl.isIMContentDirty() : !pSSysMsgTempl.isIMContentDirty()) {
            return null;
        }
        String string = pSSysMsgTempl.getIMContent();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_IMContent_Default(pSSysMsgTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("IMCONTENT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IMContentPSDEFId(boolean bl, PSSysMsgTempl pSSysMsgTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTempl.isIMContentPSDEFIdDirty() : !pSSysMsgTempl.isIMContentPSDEFIdDirty()) {
            return null;
        }
        String string = pSSysMsgTempl.getIMContentPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_IMContentPSDEFId_Default(pSSysMsgTempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_IMContentPSDEFName(boolean bl, PSSysMsgTempl pSSysMsgTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTempl.isIMContentPSDEFNameDirty() : !pSSysMsgTempl.isIMContentPSDEFNameDirty()) {
            return null;
        }
        String string = pSSysMsgTempl.getIMContentPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_IMContentPSDEFName_Default(pSSysMsgTempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_IMPSLanResId(boolean bl, PSSysMsgTempl pSSysMsgTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTempl.isIMPSLanResIdDirty() : !pSSysMsgTempl.isIMPSLanResIdDirty()) {
            return null;
        }
        String string = pSSysMsgTempl.getIMPSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_IMPSLanResId_Default(pSSysMsgTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("IMPSLANRESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IMPSLanResName(boolean bl, PSSysMsgTempl pSSysMsgTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTempl.isIMPSLanResNameDirty() : !pSSysMsgTempl.isIMPSLanResNameDirty()) {
            return null;
        }
        String string = pSSysMsgTempl.getIMPSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_IMPSLanResName_Default(pSSysMsgTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("IMPSLANRESNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LanPSDEFId(boolean bl, PSSysMsgTempl pSSysMsgTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTempl.isLanPSDEFIdDirty() : !pSSysMsgTempl.isLanPSDEFIdDirty()) {
            return null;
        }
        String string = pSSysMsgTempl.getLanPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LanPSDEFId_Default(pSSysMsgTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LANPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LanPSDEFName(boolean bl, PSSysMsgTempl pSSysMsgTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTempl.isLanPSDEFNameDirty() : !pSSysMsgTempl.isLanPSDEFNameDirty()) {
            return null;
        }
        String string = pSSysMsgTempl.getLanPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LanPSDEFName_Default(pSSysMsgTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LANPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LockFlag(boolean bl, PSSysMsgTempl pSSysMsgTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTempl.isLockFlagDirty() : !pSSysMsgTempl.isLockFlagDirty()) {
            return null;
        }
        Integer n = pSSysMsgTempl.getLockFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LockFlag_Default(pSSysMsgTempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_MailGroupSend(boolean bl, PSSysMsgTempl pSSysMsgTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTempl.isMailGroupSendDirty() : !pSSysMsgTempl.isMailGroupSendDirty()) {
            return null;
        }
        Integer n = pSSysMsgTempl.getMailGroupSend();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_MailGroupSend_Default(pSSysMsgTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAILGROUPSEND");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysMsgTempl pSSysMsgTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTempl.isMemoDirty() : !pSSysMsgTempl.isMemoDirty()) {
            return null;
        }
        String string = pSSysMsgTempl.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSysMsgTempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_MobTaskUrl(boolean bl, PSSysMsgTempl pSSysMsgTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTempl.isMobTaskUrlDirty() : !pSSysMsgTempl.isMobTaskUrlDirty()) {
            return null;
        }
        String string = pSSysMsgTempl.getMobTaskUrl();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MobTaskUrl_Default(pSSysMsgTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MOBTASKURL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MobTaskUrlPSDEFId(boolean bl, PSSysMsgTempl pSSysMsgTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTempl.isMobTaskUrlPSDEFIdDirty() : !pSSysMsgTempl.isMobTaskUrlPSDEFIdDirty()) {
            return null;
        }
        String string = pSSysMsgTempl.getMobTaskUrlPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MobTaskUrlPSDEFId_Default(pSSysMsgTempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_MobTaskUrlPSDEFName(boolean bl, PSSysMsgTempl pSSysMsgTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTempl.isMobTaskUrlPSDEFNameDirty() : !pSSysMsgTempl.isMobTaskUrlPSDEFNameDirty()) {
            return null;
        }
        String string = pSSysMsgTempl.getMobTaskUrlPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MobTaskUrlPSDEFName_Default(pSSysMsgTempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_MsgTemplParams(boolean bl, PSSysMsgTempl pSSysMsgTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTempl.isMsgTemplParamsDirty() : !pSSysMsgTempl.isMsgTemplParamsDirty()) {
            return null;
        }
        String string = pSSysMsgTempl.getMsgTemplParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MsgTemplParams_Default(pSSysMsgTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MSGTEMPLPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MsgTemplTag(boolean bl, PSSysMsgTempl pSSysMsgTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTempl.isMsgTemplTagDirty() : !pSSysMsgTempl.isMsgTemplTagDirty()) {
            return null;
        }
        String string = pSSysMsgTempl.getMsgTemplTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MsgTemplTag_Default(pSSysMsgTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MSGTEMPLTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MsgTemplTag2(boolean bl, PSSysMsgTempl pSSysMsgTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTempl.isMsgTemplTag2Dirty() : !pSSysMsgTempl.isMsgTemplTag2Dirty()) {
            return null;
        }
        String string = pSSysMsgTempl.getMsgTemplTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MsgTemplTag2_Default(pSSysMsgTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MSGTEMPLTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MsgTemplType(boolean bl, PSSysMsgTempl pSSysMsgTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTempl.isMsgTemplTypeDirty() : !pSSysMsgTempl.isMsgTemplTypeDirty()) {
            return null;
        }
        String string = pSSysMsgTempl.getMsgTemplType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MsgTemplType_Default(pSSysMsgTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MSGTEMPLTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEDSId(boolean bl, PSSysMsgTempl pSSysMsgTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTempl.isPSDEDSIdDirty() : !pSSysMsgTempl.isPSDEDSIdDirty()) {
            return null;
        }
        String string = pSSysMsgTempl.getPSDEDSId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDSId_Default(pSSysMsgTempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSSysMsgTempl pSSysMsgTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTempl.isPSDEIdDirty() : !pSSysMsgTempl.isPSDEIdDirty()) {
            return null;
        }
        String string = pSSysMsgTempl.getPSDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default(pSSysMsgTempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSSysMsgTempl pSSysMsgTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTempl.isPSDENameDirty() : !pSSysMsgTempl.isPSDENameDirty()) {
            return null;
        }
        String string = pSSysMsgTempl.getPSDEName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default(pSSysMsgTempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSModuleId(boolean bl, PSSysMsgTempl pSSysMsgTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTempl.isPSModuleIdDirty() : !pSSysMsgTempl.isPSModuleIdDirty()) {
            return null;
        }
        String string = pSSysMsgTempl.getPSModuleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModuleId_Default(pSSysMsgTempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysDynaModelId(boolean bl, PSSysMsgTempl pSSysMsgTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTempl.isPSSysDynaModelIdDirty() : !pSSysMsgTempl.isPSSysDynaModelIdDirty()) {
            return null;
        }
        String string = pSSysMsgTempl.getPSSysDynaModelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDynaModelId_Default(pSSysMsgTempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysMsgTemplId(boolean bl, PSSysMsgTempl pSSysMsgTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTempl.isPSSysMsgTemplIdDirty() && !bl2 : !pSSysMsgTempl.isPSSysMsgTemplIdDirty()) {
            return null;
        }
        String string = pSSysMsgTempl.getPSSysMsgTemplId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSMSGTEMPLID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysMsgTemplId_Default(pSSysMsgTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSMSGTEMPLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysMsgTemplName(boolean bl, PSSysMsgTempl pSSysMsgTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTempl.isPSSysMsgTemplNameDirty() && !bl2 : !pSSysMsgTempl.isPSSysMsgTemplNameDirty()) {
            return null;
        }
        String string = pSSysMsgTempl.getPSSysMsgTemplName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSMSGTEMPLNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysMsgTemplName_Default(pSSysMsgTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSMSGTEMPLNAME");
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
                String string4 = this.checkFieldDupRule(this.getPSSysMsgTemplDEModel(), "PSSYSMSGTEMPLNAME", string3, pSSysMsgTempl, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSSYSMSGTEMPLNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysSFPluginId(boolean bl, PSSysMsgTempl pSSysMsgTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTempl.isPSSysSFPluginIdDirty() : !pSSysMsgTempl.isPSSysSFPluginIdDirty()) {
            return null;
        }
        String string = pSSysMsgTempl.getPSSysSFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSFPluginId_Default(pSSysMsgTempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSSysMsgTempl pSSysMsgTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTempl.isPSSystemIdDirty() && !bl2 : !pSSysMsgTempl.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSSysMsgTempl.getPSSystemId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default(pSSysMsgTempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_SMSContent(boolean bl, PSSysMsgTempl pSSysMsgTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTempl.isSMSContentDirty() : !pSSysMsgTempl.isSMSContentDirty()) {
            return null;
        }
        String string = pSSysMsgTempl.getSMSContent();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SMSContent_Default(pSSysMsgTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SMSCONTENT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SMSContentPSDEFId(boolean bl, PSSysMsgTempl pSSysMsgTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTempl.isSMSContentPSDEFIdDirty() : !pSSysMsgTempl.isSMSContentPSDEFIdDirty()) {
            return null;
        }
        String string = pSSysMsgTempl.getSMSContentPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SMSContentPSDEFId_Default(pSSysMsgTempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_SMSContentPSDEFName(boolean bl, PSSysMsgTempl pSSysMsgTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTempl.isSMSContentPSDEFNameDirty() : !pSSysMsgTempl.isSMSContentPSDEFNameDirty()) {
            return null;
        }
        String string = pSSysMsgTempl.getSMSContentPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SMSContentPSDEFName_Default(pSSysMsgTempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_SMSPSLanResId(boolean bl, PSSysMsgTempl pSSysMsgTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTempl.isSMSPSLanResIdDirty() : !pSSysMsgTempl.isSMSPSLanResIdDirty()) {
            return null;
        }
        String string = pSSysMsgTempl.getSMSPSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SMSPSLanResId_Default(pSSysMsgTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SMSPSLANRESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SMSPSLanResName(boolean bl, PSSysMsgTempl pSSysMsgTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTempl.isSMSPSLanResNameDirty() : !pSSysMsgTempl.isSMSPSLanResNameDirty()) {
            return null;
        }
        String string = pSSysMsgTempl.getSMSPSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SMSPSLanResName_Default(pSSysMsgTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SMSPSLANRESNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Subject(boolean bl, PSSysMsgTempl pSSysMsgTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTempl.isSubjectDirty() : !pSSysMsgTempl.isSubjectDirty()) {
            return null;
        }
        String string = pSSysMsgTempl.getSubject();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Subject_Default(pSSysMsgTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SUBJECT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SubjectPSDEFId(boolean bl, PSSysMsgTempl pSSysMsgTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTempl.isSubjectPSDEFIdDirty() : !pSSysMsgTempl.isSubjectPSDEFIdDirty()) {
            return null;
        }
        String string = pSSysMsgTempl.getSubjectPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SubjectPSDEFId_Default(pSSysMsgTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SUBJECTPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SubjectPSDEFName(boolean bl, PSSysMsgTempl pSSysMsgTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTempl.isSubjectPSDEFNameDirty() : !pSSysMsgTempl.isSubjectPSDEFNameDirty()) {
            return null;
        }
        String string = pSSysMsgTempl.getSubjectPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SubjectPSDEFName_Default(pSSysMsgTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SUBJECTPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SubPSLanResId(boolean bl, PSSysMsgTempl pSSysMsgTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTempl.isSubPSLanResIdDirty() : !pSSysMsgTempl.isSubPSLanResIdDirty()) {
            return null;
        }
        String string = pSSysMsgTempl.getSubPSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SubPSLanResId_Default(pSSysMsgTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SUBPSLANRESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SubPSLanResName(boolean bl, PSSysMsgTempl pSSysMsgTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTempl.isSubPSLanResNameDirty() : !pSSysMsgTempl.isSubPSLanResNameDirty()) {
            return null;
        }
        String string = pSSysMsgTempl.getSubPSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SubPSLanResName_Default(pSSysMsgTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SUBPSLANRESNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TaskUrl(boolean bl, PSSysMsgTempl pSSysMsgTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTempl.isTaskUrlDirty() : !pSSysMsgTempl.isTaskUrlDirty()) {
            return null;
        }
        String string = pSSysMsgTempl.getTaskUrl();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TaskUrl_Default(pSSysMsgTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TASKURL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TaskUrlPSDEFId(boolean bl, PSSysMsgTempl pSSysMsgTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTempl.isTaskUrlPSDEFIdDirty() : !pSSysMsgTempl.isTaskUrlPSDEFIdDirty()) {
            return null;
        }
        String string = pSSysMsgTempl.getTaskUrlPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TaskUrlPSDEFId_Default(pSSysMsgTempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_TaskUrlPSDEFName(boolean bl, PSSysMsgTempl pSSysMsgTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTempl.isTaskUrlPSDEFNameDirty() : !pSSysMsgTempl.isTaskUrlPSDEFNameDirty()) {
            return null;
        }
        String string = pSSysMsgTempl.getTaskUrlPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TaskUrlPSDEFName_Default(pSSysMsgTempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_TemplEngine(boolean bl, PSSysMsgTempl pSSysMsgTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTempl.isTemplEngineDirty() : !pSSysMsgTempl.isTemplEngineDirty()) {
            return null;
        }
        String string = pSSysMsgTempl.getTemplEngine();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TemplEngine_Default(pSSysMsgTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TEMPLENGINE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TemplTagPSDEFId(boolean bl, PSSysMsgTempl pSSysMsgTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTempl.isTemplTagPSDEFIdDirty() : !pSSysMsgTempl.isTemplTagPSDEFIdDirty()) {
            return null;
        }
        String string = pSSysMsgTempl.getTemplTagPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TemplTagPSDEFId_Default(pSSysMsgTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TEMPLTAGPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TemplTagPSDEFName(boolean bl, PSSysMsgTempl pSSysMsgTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTempl.isTemplTagPSDEFNameDirty() : !pSSysMsgTempl.isTemplTagPSDEFNameDirty()) {
            return null;
        }
        String string = pSSysMsgTempl.getTemplTagPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TemplTagPSDEFName_Default(pSSysMsgTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TEMPLTAGPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_User2PSDEFId(boolean bl, PSSysMsgTempl pSSysMsgTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTempl.isUser2PSDEFIdDirty() : !pSSysMsgTempl.isUser2PSDEFIdDirty()) {
            return null;
        }
        String string = pSSysMsgTempl.getUser2PSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_User2PSDEFId_Default(pSSysMsgTempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_User2PSDEFName(boolean bl, PSSysMsgTempl pSSysMsgTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTempl.isUser2PSDEFNameDirty() : !pSSysMsgTempl.isUser2PSDEFNameDirty()) {
            return null;
        }
        String string = pSSysMsgTempl.getUser2PSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_User2PSDEFName_Default(pSSysMsgTempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSysMsgTempl pSSysMsgTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTempl.isUserCatDirty() : !pSSysMsgTempl.isUserCatDirty()) {
            return null;
        }
        String string = pSSysMsgTempl.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSSysMsgTempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserPSDEFId(boolean bl, PSSysMsgTempl pSSysMsgTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTempl.isUserPSDEFIdDirty() : !pSSysMsgTempl.isUserPSDEFIdDirty()) {
            return null;
        }
        String string = pSSysMsgTempl.getUserPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserPSDEFId_Default(pSSysMsgTempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserPSDEFName(boolean bl, PSSysMsgTempl pSSysMsgTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTempl.isUserPSDEFNameDirty() : !pSSysMsgTempl.isUserPSDEFNameDirty()) {
            return null;
        }
        String string = pSSysMsgTempl.getUserPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserPSDEFName_Default(pSSysMsgTempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysMsgTempl pSSysMsgTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTempl.isUserTagDirty() : !pSSysMsgTempl.isUserTagDirty()) {
            return null;
        }
        String string = pSSysMsgTempl.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSSysMsgTempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysMsgTempl pSSysMsgTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTempl.isUserTag2Dirty() : !pSSysMsgTempl.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysMsgTempl.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSSysMsgTempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSysMsgTempl pSSysMsgTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTempl.isUserTag3Dirty() : !pSSysMsgTempl.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSysMsgTempl.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSSysMsgTempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSysMsgTempl pSSysMsgTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTempl.isUserTag4Dirty() : !pSSysMsgTempl.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSysMsgTempl.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSSysMsgTempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_WCContent(boolean bl, PSSysMsgTempl pSSysMsgTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTempl.isWCContentDirty() : !pSSysMsgTempl.isWCContentDirty()) {
            return null;
        }
        String string = pSSysMsgTempl.getWCContent();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WCContent_Default(pSSysMsgTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WCCONTENT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WCContentPSDEFId(boolean bl, PSSysMsgTempl pSSysMsgTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTempl.isWCContentPSDEFIdDirty() : !pSSysMsgTempl.isWCContentPSDEFIdDirty()) {
            return null;
        }
        String string = pSSysMsgTempl.getWCContentPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WCContentPSDEFId_Default(pSSysMsgTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WCCONTENTPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WCContentPSDEFName(boolean bl, PSSysMsgTempl pSSysMsgTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTempl.isWCContentPSDEFNameDirty() : !pSSysMsgTempl.isWCContentPSDEFNameDirty()) {
            return null;
        }
        String string = pSSysMsgTempl.getWCContentPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WCContentPSDEFName_Default(pSSysMsgTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WCCONTENTPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WXPSLanResId(boolean bl, PSSysMsgTempl pSSysMsgTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTempl.isWXPSLanResIdDirty() : !pSSysMsgTempl.isWXPSLanResIdDirty()) {
            return null;
        }
        String string = pSSysMsgTempl.getWXPSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WXPSLanResId_Default(pSSysMsgTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WXPSLANRESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WXPSLanResName(boolean bl, PSSysMsgTempl pSSysMsgTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTempl.isWXPSLanResNameDirty() : !pSSysMsgTempl.isWXPSLanResNameDirty()) {
            return null;
        }
        String string = pSSysMsgTempl.getWXPSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WXPSLanResName_Default(pSSysMsgTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WXPSLANRESNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSSysMsgTempl pSSysMsgTempl, boolean bl) throws Exception {
        super.onSyncEntity(pSSysMsgTempl, bl);
    }

    protected void onSyncIndexEntities(PSSysMsgTempl pSSysMsgTempl, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSysMsgTempl, bl);
    }

    public Object getDataContextValue(PSSysMsgTempl pSSysMsgTempl, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSysMsgTempl, string, iDataContextParam)) != null) {
            return object;
        }
        PSSystem pSSystem = pSSysMsgTempl.getPSSystem();
        if (pSSystem != null && pSSystem.contains(string)) {
            return pSSystem.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSysMsgTempl pSSysMsgTempl, ArrayList<JSONObject> arrayList, int n) throws Exception {
        this.onExportMajorModel_ContentPSLanRes(pSSysMsgTempl, arrayList, n);
        this.onExportMajorModel_IMPSLanRes(pSSysMsgTempl, arrayList, n);
        this.onExportMajorModel_SMSPSLanRes(pSSysMsgTempl, arrayList, n);
        this.onExportMajorModel_SubPSLanRes(pSSysMsgTempl, arrayList, n);
        this.onExportMajorModel_WXPSLanRes(pSSysMsgTempl, arrayList, n);
        super.onExportMajorModel(pSSysMsgTempl, arrayList, n);
    }

    protected void onExportMajorModel_ContentPSLanRes(PSSysMsgTempl pSSysMsgTempl, ArrayList<JSONObject> arrayList, int n) throws Exception {
        if (pSSysMsgTempl.getContentPSLanRes() != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            iService.exportModel(pSSysMsgTempl.getContentPSLanRes(), arrayList, n);
        }
    }

    protected void onExportMajorModel_IMPSLanRes(PSSysMsgTempl pSSysMsgTempl, ArrayList<JSONObject> arrayList, int n) throws Exception {
        if (pSSysMsgTempl.getIMPSLanRes() != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            iService.exportModel(pSSysMsgTempl.getIMPSLanRes(), arrayList, n);
        }
    }

    protected void onExportMajorModel_SMSPSLanRes(PSSysMsgTempl pSSysMsgTempl, ArrayList<JSONObject> arrayList, int n) throws Exception {
        if (pSSysMsgTempl.getSMSPSLanRes() != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            iService.exportModel(pSSysMsgTempl.getSMSPSLanRes(), arrayList, n);
        }
    }

    protected void onExportMajorModel_SubPSLanRes(PSSysMsgTempl pSSysMsgTempl, ArrayList<JSONObject> arrayList, int n) throws Exception {
        if (pSSysMsgTempl.getSubPSLanRes() != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            iService.exportModel(pSSysMsgTempl.getSubPSLanRes(), arrayList, n);
        }
    }

    protected void onExportMajorModel_WXPSLanRes(PSSysMsgTempl pSSysMsgTempl, ArrayList<JSONObject> arrayList, int n) throws Exception {
        if (pSSysMsgTempl.getWXPSLanRes() != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            iService.exportModel(pSSysMsgTempl.getWXPSLanRes(), arrayList, n);
        }
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CONTENT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Content_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CONTENTPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ContentPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CONTENTPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ContentPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CONTENTPSLANRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ContentPSLanResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CONTENTPSLANRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ContentPSLanResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CONTENTTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ContentType_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"DDCONTENT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DDContent_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DDCONTENTPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DDContentPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DDCONTENTPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DDContentPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DDPSLANRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DDPSLanResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DDPSLANRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DDPSLanResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"IMCONTENT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IMContent_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"IMCONTENTPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IMContentPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"IMCONTENTPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IMContentPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"IMPSLANRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IMPSLanResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"IMPSLANRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IMPSLanResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LANPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LanPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LANPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LanPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOCKFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LockFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAILGROUPSEND", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MailGroupSend_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MOBTASKURL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MobTaskUrl_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MOBTASKURLPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MobTaskUrlPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MOBTASKURLPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MobTaskUrlPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MSGTEMPLPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MsgTemplParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MSGTEMPLTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MsgTemplTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MSGTEMPLTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MsgTemplTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MSGTEMPLTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MsgTemplType_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSSYSMSGTEMPLID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysMsgTemplId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSMSGTEMPLNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysMsgTemplName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"SMSCONTENT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SMSContent_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SMSCONTENTPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SMSContentPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SMSCONTENTPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SMSContentPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SMSPSLANRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SMSPSLanResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SMSPSLANRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SMSPSLanResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SUBJECT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Subject_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SUBJECTPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SubjectPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SUBJECTPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SubjectPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SUBPSLANRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SubPSLanResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SUBPSLANRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SubPSLanResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TASKURL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TaskUrl_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TASKURLPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TaskUrlPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TASKURLPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TaskUrlPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEMPLENGINE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TemplEngine_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEMPLTAGPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TemplTagPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEMPLTAGPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TemplTagPSDEFName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"WCCONTENT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WCContent_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WCCONTENTPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WCContentPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WCCONTENTPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WCContentPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WXPSLANRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WXPSLanResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WXPSLANRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WXPSLanResName_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
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

    protected String onTestValueRule_Content_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONTENT", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
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

    protected String onTestValueRule_ContentPSLanResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONTENTPSLANRESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ContentPSLanResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONTENTPSLANRESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ContentType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONTENTTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
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

    protected String onTestValueRule_DDContent_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DDCONTENT", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected String onTestValueRule_DDPSLanResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DDPSLANRESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DDPSLanResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DDPSLANRESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_IMContent_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("IMCONTENT", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
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

    protected String onTestValueRule_IMPSLanResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("IMPSLANRESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_IMPSLanResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("IMPSLANRESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LanPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LANPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LanPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LANPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LockFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_MailGroupSend_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_MobTaskUrl_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MOBTASKURL", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
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

    protected String onTestValueRule_MsgTemplParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MSGTEMPLPARAMS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MsgTemplTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MSGTEMPLTAG", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MsgTemplTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MSGTEMPLTAG2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MsgTemplType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MSGTEMPLTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
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

    protected String onTestValueRule_PSSysMsgTemplId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSMSGTEMPLID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysMsgTemplName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSMSGTEMPLNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_SMSContent_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SMSCONTENT", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
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

    protected String onTestValueRule_SMSPSLanResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SMSPSLANRESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SMSPSLanResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SMSPSLANRESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Subject_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SUBJECT", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SubjectPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SUBJECTPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SubjectPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SUBJECTPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SubPSLanResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SUBPSLANRESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SubPSLanResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SUBPSLANRESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TaskUrl_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TASKURL", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
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

    protected String onTestValueRule_TemplEngine_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TEMPLENGINE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TemplTagPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TEMPLTAGPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TemplTagPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TEMPLTAGPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
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

    protected String onTestValueRule_WCContent_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WCCONTENT", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_WCContentPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WCCONTENTPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_WCContentPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WCCONTENTPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_WXPSLanResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WXPSLANRESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_WXPSLanResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WXPSLANRESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSSysMsgTempl pSSysMsgTempl) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSysMsgTempl)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysMsgTempl pSSysMsgTempl) throws Exception {
        super.onUpdateParent(pSSysMsgTempl);
    }

    @Override
    protected void exportCurXmlModel(PSSysMsgTempl pSSysMsgTempl, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSMSGTEMPL");
        if (!bl) {
            pSSysMsgTempl.setCreateDate(null);
            pSSysMsgTempl.setCreateMan(null);
            pSSysMsgTempl.setPSSysMsgTemplId(null);
            pSSysMsgTempl.setUpdateDate(null);
            pSSysMsgTempl.setUpdateMan(null);
            super.exportCurXmlModel(pSSysMsgTempl, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysMsgTempl pSSysMsgTempl, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysMsgTempl, string);
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
            return "DER1N_PSSYSMSGTEMPL_PSMODULE_PSMODULEID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSMSGTEMPL_PSSYSTEM_PSSYSTEMID";
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
    public String getModelV2Tag(PSSysMsgTempl pSSysMsgTempl) {
        if (!StringHelper.isNullOrEmpty((String)pSSysMsgTempl.getCodeName())) {
            return pSSysMsgTempl.getCodeName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysMsgTempl.getPSSysMsgTemplName())) {
            return pSSysMsgTempl.getPSSysMsgTemplName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysMsgTempl.getCodeName())) {
            return pSSysMsgTempl.getCodeName();
        }
        return super.getModelV2Tag(pSSysMsgTempl);
    }

    @Override
    public boolean setModelV2Tag(PSSysMsgTempl pSSysMsgTempl, String string) {
        pSSysMsgTempl.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("PSSYSMSGTEMPLNAME", "");
        map.put("CODENAME", "");
        map.put("PSSYSMSGTEMPLNAME", "");
        map.put("PSMODULEID", "");
        map.put("PSSYSTEMID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysMsgTempl pSSysMsgTempl, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysMsgTempl.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysMsgTempl, true);
        pSSysMsgTempl.set("CODENAME", string);
        if (this.select(pSSysMsgTempl, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysMsgTempl, true);
        return super.getModelV2Entity(pSSysMsgTempl, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysMsgTempl pSSysMsgTempl, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSSysMsgTempl, objectNode, string, string2, n);
    }
}

