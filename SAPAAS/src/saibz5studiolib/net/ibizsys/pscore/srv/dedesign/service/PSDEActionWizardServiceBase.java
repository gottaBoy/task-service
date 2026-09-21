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
import net.ibizsys.pscore.srv.dedesign.dao.PSDEActionWizardDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEActionWizardDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAWItem;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEActionWizard;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSetBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFieldBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBaseBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEAWGrpDetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEAWGrpDetailServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEAWItemService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEAWItemServiceBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEActionWizardServiceBase
extends PSCoreSysServiceBase<PSDEActionWizard> {
    private static final Log log = LogFactory.getLog(PSDEActionWizardServiceBase.class);
    public static final String DATASET_CURDE = "CurDE";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDEActionWizardDEModel pSDEActionWizardDEModel;
    private PSDEActionWizardDAO pSDEActionWizardDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEActionWizardService";
    }

    public PSDEActionWizardDEModel getPSDEActionWizardDEModel() {
        if (this.pSDEActionWizardDEModel == null) {
            try {
                this.pSDEActionWizardDEModel = (PSDEActionWizardDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEActionWizardDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEActionWizardDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEActionWizardDEModel();
    }

    public PSDEActionWizardDAO getPSDEActionWizardDAO() {
        if (this.pSDEActionWizardDAO == null) {
            try {
                this.pSDEActionWizardDAO = (PSDEActionWizardDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDEActionWizardDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEActionWizardDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEActionWizardDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURDE, (boolean)true) == 0) {
            return this.fetchCurDE(iDEDataSetFetchContext);
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
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchTempDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSetTemp(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
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

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, true);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSDEActionWizard pSDEActionWizard, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEACTIONWIZARD_PSDATAENTITY_AWIPSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_AWIPSDE(pSDEActionWizard, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEACTIONWIZARD_PSDATAENTITY_AWPSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_AWPSDE(pSDEActionWizard, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEACTIONWIZARD_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSDEActionWizard, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEACTIONWIZARD_PSDEDATASET_AWIPSDEDSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService", (SessionFactory)this.getSessionFactory());
            PSDEDataSet pSDEDataSet = (PSDEDataSet)iService.getDEModel().createEntity();
            pSDEDataSet.set("PSDEDATASETID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEDataSet);
            } else {
                iService.get((IEntity)pSDEDataSet);
            }
            this.onFillParentInfo_AWIPSDEDS(pSDEActionWizard, pSDEDataSet);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEACTIONWIZARD_PSDEDATASET_AWPSDEDSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService", (SessionFactory)this.getSessionFactory());
            PSDEDataSet pSDEDataSet = (PSDEDataSet)iService.getDEModel().createEntity();
            pSDEDataSet.set("PSDEDATASETID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEDataSet);
            } else {
                iService.get((IEntity)pSDEDataSet);
            }
            this.onFillParentInfo_AWPSDEDS(pSDEActionWizard, pSDEDataSet);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEACTIONWIZARD_PSDEFIELD_AWICONTENTPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_AWIContentPSDEF(pSDEActionWizard, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEACTIONWIZARD_PSDEFIELD_AWIFKEYPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_AWIFKeyPSDEF(pSDEActionWizard, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEACTIONWIZARD_PSDEFIELD_AWINAMEPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_AWINamePSDEF(pSDEActionWizard, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEACTIONWIZARD_PSDEFIELD_AWISORTPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_AWISortPSDEF(pSDEActionWizard, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEACTIONWIZARD_PSDEFIELD_AWIURLPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_AWIUrlPSDEF(pSDEActionWizard, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEACTIONWIZARD_PSDEFIELD_AWIVALUEPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_AWIValuePSDEF(pSDEActionWizard, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEACTIONWIZARD_PSDEFIELD_AWKWPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_AWKWPSDEF(pSDEActionWizard, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEACTIONWIZARD_PSDEFIELD_AWNAMEPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_AWNamePSDEF(pSDEActionWizard, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEACTIONWIZARD_PSDEFIELD_AWSORTPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_AWSortPSDEF(pSDEActionWizard, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEACTIONWIZARD_PSDEVIEWBASE_PSDEVIEWBASEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService", (SessionFactory)this.getSessionFactory());
            PSDEViewBase pSDEViewBase = (PSDEViewBase)iService.getDEModel().createEntity();
            pSDEViewBase.set("PSDEVIEWBASEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEViewBase);
            } else {
                iService.get((IEntity)pSDEViewBase);
            }
            this.onFillParentInfo_PSDEViewBase(pSDEActionWizard, pSDEViewBase);
            return;
        }
        super.onFillParentInfo((IEntity)pSDEActionWizard, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_AWIPSDE(PSDEActionWizard pSDEActionWizard, PSDataEntity pSDataEntity) throws Exception {
        pSDEActionWizard.setAWIPSDEId(pSDataEntity.getPSDataEntityId());
        pSDEActionWizard.setAWIPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_AWPSDE(PSDEActionWizard pSDEActionWizard, PSDataEntity pSDataEntity) throws Exception {
        pSDEActionWizard.setAWPSDEId(pSDataEntity.getPSDataEntityId());
        pSDEActionWizard.setAWPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_PSDE(PSDEActionWizard pSDEActionWizard, PSDataEntity pSDataEntity) throws Exception {
        pSDEActionWizard.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSDEActionWizard.setPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_AWIPSDEDS(PSDEActionWizard pSDEActionWizard, PSDEDataSet pSDEDataSet) throws Exception {
        pSDEActionWizard.setAWIPSDEDSId(pSDEDataSet.getPSDEDataSetId());
        pSDEActionWizard.setAWIPSDEDSName(pSDEDataSet.getPSDEDataSetName());
    }

    protected void onFillParentInfo_AWPSDEDS(PSDEActionWizard pSDEActionWizard, PSDEDataSet pSDEDataSet) throws Exception {
        pSDEActionWizard.setAWPSDEDSId(pSDEDataSet.getPSDEDataSetId());
        pSDEActionWizard.setAWPSDEDSName(pSDEDataSet.getPSDEDataSetName());
    }

    protected void onFillParentInfo_AWIContentPSDEF(PSDEActionWizard pSDEActionWizard, PSDEField pSDEField) throws Exception {
        pSDEActionWizard.setAWIContentPSDEFId(pSDEField.getPSDEFieldId());
        pSDEActionWizard.setAWIContentPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_AWIFKeyPSDEF(PSDEActionWizard pSDEActionWizard, PSDEField pSDEField) throws Exception {
        pSDEActionWizard.setAWIFKeyPSDEFId(pSDEField.getPSDEFieldId());
        pSDEActionWizard.setAWIFKeyPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_AWINamePSDEF(PSDEActionWizard pSDEActionWizard, PSDEField pSDEField) throws Exception {
        pSDEActionWizard.setAWINamePSDEFId(pSDEField.getPSDEFieldId());
        pSDEActionWizard.setAWINamePSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_AWISortPSDEF(PSDEActionWizard pSDEActionWizard, PSDEField pSDEField) throws Exception {
        pSDEActionWizard.setAWISortPSDEFId(pSDEField.getPSDEFieldId());
        pSDEActionWizard.setAWISortPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_AWIUrlPSDEF(PSDEActionWizard pSDEActionWizard, PSDEField pSDEField) throws Exception {
        pSDEActionWizard.setAWIUrlPSDEFId(pSDEField.getPSDEFieldId());
        pSDEActionWizard.setAWIUrlPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_AWIValuePSDEF(PSDEActionWizard pSDEActionWizard, PSDEField pSDEField) throws Exception {
        pSDEActionWizard.setAWIValuePSDEFId(pSDEField.getPSDEFieldId());
        pSDEActionWizard.setAWIValuePSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_AWKWPSDEF(PSDEActionWizard pSDEActionWizard, PSDEField pSDEField) throws Exception {
        pSDEActionWizard.setAWKWPSDEFId(pSDEField.getPSDEFieldId());
        pSDEActionWizard.setAWKWPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_AWNamePSDEF(PSDEActionWizard pSDEActionWizard, PSDEField pSDEField) throws Exception {
        pSDEActionWizard.setAWNamePSDEFId(pSDEField.getPSDEFieldId());
        pSDEActionWizard.setAWNamePSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_AWSortPSDEF(PSDEActionWizard pSDEActionWizard, PSDEField pSDEField) throws Exception {
        pSDEActionWizard.setAWSortPSDEFId(pSDEField.getPSDEFieldId());
        pSDEActionWizard.setAWSortPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_PSDEViewBase(PSDEActionWizard pSDEActionWizard, PSDEViewBase pSDEViewBase) throws Exception {
        pSDEActionWizard.setPSDEViewBaseId(pSDEViewBase.getPSDEViewBaseId());
        pSDEActionWizard.setPSDEViewBaseName(pSDEViewBase.getPSDEViewBaseName());
    }

    protected void onFillEntityFullInfo(PSDEActionWizard pSDEActionWizard, boolean bl) throws Exception {
        if (bl && pSDEActionWizard.getDynamicMode() == null) {
            pSDEActionWizard.setDynamicMode((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
        }
        super.onFillEntityFullInfo((IEntity)pSDEActionWizard, bl);
        this.onFillEntityFullInfo_AWIPSDE(pSDEActionWizard, bl);
        this.onFillEntityFullInfo_AWPSDE(pSDEActionWizard, bl);
        this.onFillEntityFullInfo_PSDE(pSDEActionWizard, bl);
        this.onFillEntityFullInfo_AWIPSDEDS(pSDEActionWizard, bl);
        this.onFillEntityFullInfo_AWPSDEDS(pSDEActionWizard, bl);
        this.onFillEntityFullInfo_AWIContentPSDEF(pSDEActionWizard, bl);
        this.onFillEntityFullInfo_AWIFKeyPSDEF(pSDEActionWizard, bl);
        this.onFillEntityFullInfo_AWINamePSDEF(pSDEActionWizard, bl);
        this.onFillEntityFullInfo_AWISortPSDEF(pSDEActionWizard, bl);
        this.onFillEntityFullInfo_AWIUrlPSDEF(pSDEActionWizard, bl);
        this.onFillEntityFullInfo_AWIValuePSDEF(pSDEActionWizard, bl);
        this.onFillEntityFullInfo_AWKWPSDEF(pSDEActionWizard, bl);
        this.onFillEntityFullInfo_AWNamePSDEF(pSDEActionWizard, bl);
        this.onFillEntityFullInfo_AWSortPSDEF(pSDEActionWizard, bl);
        this.onFillEntityFullInfo_PSDEViewBase(pSDEActionWizard, bl);
    }

    protected void onFillEntityFullInfo_AWIPSDE(PSDEActionWizard pSDEActionWizard, boolean bl) throws Exception {
        if (pSDEActionWizard.isAWIPSDEIdDirty()) {
            if (pSDEActionWizard.getAWIPSDEId() != null) {
                if (pSDEActionWizard.getAWIPSDEId() == null || pSDEActionWizard.getAWIPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSDEActionWizard.getAWIPSDE();
                    pSDEActionWizard.setAWIPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSDEActionWizard.setAWIPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_AWPSDE(PSDEActionWizard pSDEActionWizard, boolean bl) throws Exception {
        if (pSDEActionWizard.isAWPSDEIdDirty()) {
            if (pSDEActionWizard.getAWPSDEId() != null) {
                if (pSDEActionWizard.getAWPSDEId() == null || pSDEActionWizard.getAWPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSDEActionWizard.getAWPSDE();
                    pSDEActionWizard.setAWPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSDEActionWizard.setAWPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDE(PSDEActionWizard pSDEActionWizard, boolean bl) throws Exception {
        if (pSDEActionWizard.isPSDEIdDirty()) {
            if (pSDEActionWizard.getPSDEId() != null) {
                if (pSDEActionWizard.getPSDEId() == null || pSDEActionWizard.getPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSDEActionWizard.getPSDE();
                    pSDEActionWizard.setPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSDEActionWizard.setPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_AWIPSDEDS(PSDEActionWizard pSDEActionWizard, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_AWPSDEDS(PSDEActionWizard pSDEActionWizard, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_AWIContentPSDEF(PSDEActionWizard pSDEActionWizard, boolean bl) throws Exception {
        if (pSDEActionWizard.isAWIContentPSDEFIdDirty()) {
            if (pSDEActionWizard.getAWIContentPSDEFId() != null) {
                if (pSDEActionWizard.getAWIContentPSDEFId() == null || pSDEActionWizard.getAWIContentPSDEFName() == null) {
                    PSDEField pSDEField = pSDEActionWizard.getAWIContentPSDEF();
                    pSDEActionWizard.setAWIContentPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSDEActionWizard.setAWIContentPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_AWIFKeyPSDEF(PSDEActionWizard pSDEActionWizard, boolean bl) throws Exception {
        if (pSDEActionWizard.isAWIFKeyPSDEFIdDirty()) {
            if (pSDEActionWizard.getAWIFKeyPSDEFId() != null) {
                if (pSDEActionWizard.getAWIFKeyPSDEFId() == null || pSDEActionWizard.getAWIFKeyPSDEFName() == null) {
                    PSDEField pSDEField = pSDEActionWizard.getAWIFKeyPSDEF();
                    pSDEActionWizard.setAWIFKeyPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSDEActionWizard.setAWIFKeyPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_AWINamePSDEF(PSDEActionWizard pSDEActionWizard, boolean bl) throws Exception {
        if (pSDEActionWizard.isAWINamePSDEFIdDirty()) {
            if (pSDEActionWizard.getAWINamePSDEFId() != null) {
                if (pSDEActionWizard.getAWINamePSDEFId() == null || pSDEActionWizard.getAWINamePSDEFName() == null) {
                    PSDEField pSDEField = pSDEActionWizard.getAWINamePSDEF();
                    pSDEActionWizard.setAWINamePSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSDEActionWizard.setAWINamePSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_AWISortPSDEF(PSDEActionWizard pSDEActionWizard, boolean bl) throws Exception {
        if (pSDEActionWizard.isAWISortPSDEFIdDirty()) {
            if (pSDEActionWizard.getAWISortPSDEFId() != null) {
                if (pSDEActionWizard.getAWISortPSDEFId() == null || pSDEActionWizard.getAWISortPSDEFName() == null) {
                    PSDEField pSDEField = pSDEActionWizard.getAWISortPSDEF();
                    pSDEActionWizard.setAWISortPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSDEActionWizard.setAWISortPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_AWIUrlPSDEF(PSDEActionWizard pSDEActionWizard, boolean bl) throws Exception {
        if (pSDEActionWizard.isAWIUrlPSDEFIdDirty()) {
            if (pSDEActionWizard.getAWIUrlPSDEFId() != null) {
                if (pSDEActionWizard.getAWIUrlPSDEFId() == null || pSDEActionWizard.getAWIUrlPSDEFName() == null) {
                    PSDEField pSDEField = pSDEActionWizard.getAWIUrlPSDEF();
                    pSDEActionWizard.setAWIUrlPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSDEActionWizard.setAWIUrlPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_AWIValuePSDEF(PSDEActionWizard pSDEActionWizard, boolean bl) throws Exception {
        if (pSDEActionWizard.isAWIValuePSDEFIdDirty()) {
            if (pSDEActionWizard.getAWIValuePSDEFId() != null) {
                if (pSDEActionWizard.getAWIValuePSDEFId() == null || pSDEActionWizard.getAWIValuePSDEFName() == null) {
                    PSDEField pSDEField = pSDEActionWizard.getAWIValuePSDEF();
                    pSDEActionWizard.setAWIValuePSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSDEActionWizard.setAWIValuePSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_AWKWPSDEF(PSDEActionWizard pSDEActionWizard, boolean bl) throws Exception {
        if (pSDEActionWizard.isAWKWPSDEFIdDirty()) {
            if (pSDEActionWizard.getAWKWPSDEFId() != null) {
                if (pSDEActionWizard.getAWKWPSDEFId() == null || pSDEActionWizard.getAWKWPSDEFName() == null) {
                    PSDEField pSDEField = pSDEActionWizard.getAWKWPSDEF();
                    pSDEActionWizard.setAWKWPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSDEActionWizard.setAWKWPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_AWNamePSDEF(PSDEActionWizard pSDEActionWizard, boolean bl) throws Exception {
        if (pSDEActionWizard.isAWNamePSDEFIdDirty()) {
            if (pSDEActionWizard.getAWNamePSDEFId() != null) {
                if (pSDEActionWizard.getAWNamePSDEFId() == null || pSDEActionWizard.getAWNamePSDEFName() == null) {
                    PSDEField pSDEField = pSDEActionWizard.getAWNamePSDEF();
                    pSDEActionWizard.setAWNamePSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSDEActionWizard.setAWNamePSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_AWSortPSDEF(PSDEActionWizard pSDEActionWizard, boolean bl) throws Exception {
        if (pSDEActionWizard.isAWSortPSDEFIdDirty()) {
            if (pSDEActionWizard.getAWSortPSDEFId() != null) {
                if (pSDEActionWizard.getAWSortPSDEFId() == null || pSDEActionWizard.getAWSortPSDEFName() == null) {
                    PSDEField pSDEField = pSDEActionWizard.getAWSortPSDEF();
                    pSDEActionWizard.setAWSortPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSDEActionWizard.setAWSortPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDEViewBase(PSDEActionWizard pSDEActionWizard, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDEActionWizard pSDEActionWizard, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDEActionWizard, bl);
    }

    public ArrayList<PSDEActionWizard> selectByAWIPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByAWIPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSDEActionWizard> selectByAWIPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByAWIPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSDEActionWizard> selectByAWIPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("AWIPSDEID", (Object)pSDataEntityBase.getPSDataEntityId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByAWIPSDECond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByAWIPSDECond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEActionWizard> selectByAWPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByAWPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSDEActionWizard> selectByAWPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByAWPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSDEActionWizard> selectByAWPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("AWPSDEID", (Object)pSDataEntityBase.getPSDataEntityId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByAWPSDECond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByAWPSDECond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEActionWizard> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSDEActionWizard> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSDEActionWizard> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEActionWizard> selectByAWIPSDEDS(PSDEDataSetBase pSDEDataSetBase) throws Exception {
        return this.selectByAWIPSDEDS(pSDEDataSetBase, "", -1);
    }

    public ArrayList<PSDEActionWizard> selectByAWIPSDEDS(PSDEDataSetBase pSDEDataSetBase, String string) throws Exception {
        return this.selectByAWIPSDEDS(pSDEDataSetBase, string, -1);
    }

    public ArrayList<PSDEActionWizard> selectByAWIPSDEDS(PSDEDataSetBase pSDEDataSetBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("AWIPSDEDSID", (Object)pSDEDataSetBase.getPSDEDataSetId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByAWIPSDEDSCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByAWIPSDEDSCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEActionWizard> selectByAWPSDEDS(PSDEDataSetBase pSDEDataSetBase) throws Exception {
        return this.selectByAWPSDEDS(pSDEDataSetBase, "", -1);
    }

    public ArrayList<PSDEActionWizard> selectByAWPSDEDS(PSDEDataSetBase pSDEDataSetBase, String string) throws Exception {
        return this.selectByAWPSDEDS(pSDEDataSetBase, string, -1);
    }

    public ArrayList<PSDEActionWizard> selectByAWPSDEDS(PSDEDataSetBase pSDEDataSetBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("AWPSDEDSID", (Object)pSDEDataSetBase.getPSDEDataSetId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByAWPSDEDSCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByAWPSDEDSCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEActionWizard> selectByAWIContentPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByAWIContentPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSDEActionWizard> selectByAWIContentPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByAWIContentPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSDEActionWizard> selectByAWIContentPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("AWICONTENTPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByAWIContentPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByAWIContentPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEActionWizard> selectByAWIFKeyPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByAWIFKeyPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSDEActionWizard> selectByAWIFKeyPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByAWIFKeyPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSDEActionWizard> selectByAWIFKeyPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("AWIFKEYPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByAWIFKeyPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByAWIFKeyPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEActionWizard> selectByAWINamePSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByAWINamePSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSDEActionWizard> selectByAWINamePSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByAWINamePSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSDEActionWizard> selectByAWINamePSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("AWINAMEPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByAWINamePSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByAWINamePSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEActionWizard> selectByAWISortPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByAWISortPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSDEActionWizard> selectByAWISortPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByAWISortPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSDEActionWizard> selectByAWISortPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("AWISORTPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByAWISortPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByAWISortPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEActionWizard> selectByAWIUrlPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByAWIUrlPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSDEActionWizard> selectByAWIUrlPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByAWIUrlPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSDEActionWizard> selectByAWIUrlPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("AWIURLPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByAWIUrlPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByAWIUrlPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEActionWizard> selectByAWIValuePSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByAWIValuePSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSDEActionWizard> selectByAWIValuePSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByAWIValuePSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSDEActionWizard> selectByAWIValuePSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("AWIVALUEPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByAWIValuePSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByAWIValuePSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEActionWizard> selectByAWKWPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByAWKWPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSDEActionWizard> selectByAWKWPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByAWKWPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSDEActionWizard> selectByAWKWPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("AWKWPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByAWKWPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByAWKWPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEActionWizard> selectByAWNamePSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByAWNamePSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSDEActionWizard> selectByAWNamePSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByAWNamePSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSDEActionWizard> selectByAWNamePSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("AWNAMEPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByAWNamePSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByAWNamePSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEActionWizard> selectByAWSortPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByAWSortPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSDEActionWizard> selectByAWSortPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByAWSortPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSDEActionWizard> selectByAWSortPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("AWSORTPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByAWSortPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByAWSortPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEActionWizard> selectByPSDEViewBase(PSDEViewBaseBase pSDEViewBaseBase) throws Exception {
        return this.selectByPSDEViewBase(pSDEViewBaseBase, "", -1);
    }

    public ArrayList<PSDEActionWizard> selectByPSDEViewBase(PSDEViewBaseBase pSDEViewBaseBase, String string) throws Exception {
        return this.selectByPSDEViewBase(pSDEViewBaseBase, string, -1);
    }

    public ArrayList<PSDEActionWizard> selectByPSDEViewBase(PSDEViewBaseBase pSDEViewBaseBase, String string, int n) throws Exception {
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

    public void testRemoveByAWIPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEActionWizard> arrayList = this.selectByAWIPSDE(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEACTIONWIZARD_PSDATAENTITY_AWIPSDEID", "", iDataEntityModel.getName(), "PSDEACTIONWIZARD", iDataEntityModel.getDataInfo((IEntity)pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetAWIPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEActionWizard> arrayList = this.selectByAWIPSDE(pSDataEntity);
        for (PSDEActionWizard pSDEActionWizard : arrayList) {
            PSDEActionWizard pSDEActionWizard2 = (PSDEActionWizard)this.getDEModel().createEntity();
            pSDEActionWizard2.setPSDEActionWizardId(pSDEActionWizard.getPSDEActionWizardId());
            pSDEActionWizard2.setAWIPSDEId(null);
            this.update(pSDEActionWizard2);
        }
    }

    public void removeByAWIPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEActionWizardServiceBase.this.onBeforeRemoveByAWIPSDE(pSDataEntity2);
                PSDEActionWizardServiceBase.this.internalRemoveByAWIPSDE(pSDataEntity2);
                PSDEActionWizardServiceBase.this.onAfterRemoveByAWIPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByAWIPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByAWIPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEActionWizard> arrayList = this.selectByAWIPSDE(pSDataEntity);
        this.onBeforeRemoveByAWIPSDE(pSDataEntity, arrayList);
        for (PSDEActionWizard pSDEActionWizard : arrayList) {
            this.remove((IEntity)pSDEActionWizard);
        }
        this.onAfterRemoveByAWIPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByAWIPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByAWIPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEActionWizard> arrayList) throws Exception {
    }

    protected void onAfterRemoveByAWIPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEActionWizard> arrayList) throws Exception {
    }

    public void testRemoveByAWPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEActionWizard> arrayList = this.selectByAWPSDE(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEACTIONWIZARD_PSDATAENTITY_AWPSDEID", "", iDataEntityModel.getName(), "PSDEACTIONWIZARD", iDataEntityModel.getDataInfo((IEntity)pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetAWPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEActionWizard> arrayList = this.selectByAWPSDE(pSDataEntity);
        for (PSDEActionWizard pSDEActionWizard : arrayList) {
            PSDEActionWizard pSDEActionWizard2 = (PSDEActionWizard)this.getDEModel().createEntity();
            pSDEActionWizard2.setPSDEActionWizardId(pSDEActionWizard.getPSDEActionWizardId());
            pSDEActionWizard2.setAWPSDEId(null);
            this.update(pSDEActionWizard2);
        }
    }

    public void removeByAWPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEActionWizardServiceBase.this.onBeforeRemoveByAWPSDE(pSDataEntity2);
                PSDEActionWizardServiceBase.this.internalRemoveByAWPSDE(pSDataEntity2);
                PSDEActionWizardServiceBase.this.onAfterRemoveByAWPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByAWPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByAWPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEActionWizard> arrayList = this.selectByAWPSDE(pSDataEntity);
        this.onBeforeRemoveByAWPSDE(pSDataEntity, arrayList);
        for (PSDEActionWizard pSDEActionWizard : arrayList) {
            this.remove((IEntity)pSDEActionWizard);
        }
        this.onAfterRemoveByAWPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByAWPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByAWPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEActionWizard> arrayList) throws Exception {
    }

    protected void onAfterRemoveByAWPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEActionWizard> arrayList) throws Exception {
    }

    public void testRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEActionWizard> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSDEActionWizard pSDEActionWizard : arrayList) {
            PSDEActionWizard pSDEActionWizard2 = (PSDEActionWizard)this.getDEModel().createEntity();
            pSDEActionWizard2.setPSDEActionWizardId(pSDEActionWizard.getPSDEActionWizardId());
            pSDEActionWizard2.setPSDEId(null);
            this.update(pSDEActionWizard2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEActionWizardServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSDEActionWizardServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSDEActionWizardServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEActionWizard> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSDEActionWizard pSDEActionWizard : arrayList) {
            this.remove((IEntity)pSDEActionWizard);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEActionWizard> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEActionWizard> arrayList) throws Exception {
    }

    public void testRemoveByAWIPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDEActionWizard> arrayList = this.selectByAWIPSDEDS(pSDEDataSet, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEDATASET");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEDataSet);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEACTIONWIZARD_PSDEDATASET_AWIPSDEDSID", "", iDataEntityModel.getName(), "PSDEACTIONWIZARD", iDataEntityModel.getDataInfo((IEntity)pSDEDataSet), arrayList.get(0)));
        }
    }

    public void resetAWIPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDEActionWizard> arrayList = this.selectByAWIPSDEDS(pSDEDataSet);
        for (PSDEActionWizard pSDEActionWizard : arrayList) {
            PSDEActionWizard pSDEActionWizard2 = (PSDEActionWizard)this.getDEModel().createEntity();
            pSDEActionWizard2.setPSDEActionWizardId(pSDEActionWizard.getPSDEActionWizardId());
            pSDEActionWizard2.setAWIPSDEDSId(null);
            this.update(pSDEActionWizard2);
        }
    }

    public void removeByAWIPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        final PSDEDataSet pSDEDataSet2 = pSDEDataSet;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEActionWizardServiceBase.this.onBeforeRemoveByAWIPSDEDS(pSDEDataSet2);
                PSDEActionWizardServiceBase.this.internalRemoveByAWIPSDEDS(pSDEDataSet2);
                PSDEActionWizardServiceBase.this.onAfterRemoveByAWIPSDEDS(pSDEDataSet2);
            }
        });
    }

    protected void onBeforeRemoveByAWIPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void internalRemoveByAWIPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDEActionWizard> arrayList = this.selectByAWIPSDEDS(pSDEDataSet);
        this.onBeforeRemoveByAWIPSDEDS(pSDEDataSet, arrayList);
        for (PSDEActionWizard pSDEActionWizard : arrayList) {
            this.remove((IEntity)pSDEActionWizard);
        }
        this.onAfterRemoveByAWIPSDEDS(pSDEDataSet, arrayList);
    }

    protected void onAfterRemoveByAWIPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void onBeforeRemoveByAWIPSDEDS(PSDEDataSet pSDEDataSet, ArrayList<PSDEActionWizard> arrayList) throws Exception {
    }

    protected void onAfterRemoveByAWIPSDEDS(PSDEDataSet pSDEDataSet, ArrayList<PSDEActionWizard> arrayList) throws Exception {
    }

    public void testRemoveByAWPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDEActionWizard> arrayList = this.selectByAWPSDEDS(pSDEDataSet, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEDATASET");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEDataSet);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEACTIONWIZARD_PSDEDATASET_AWPSDEDSID", "", iDataEntityModel.getName(), "PSDEACTIONWIZARD", iDataEntityModel.getDataInfo((IEntity)pSDEDataSet), arrayList.get(0)));
        }
    }

    public void resetAWPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDEActionWizard> arrayList = this.selectByAWPSDEDS(pSDEDataSet);
        for (PSDEActionWizard pSDEActionWizard : arrayList) {
            PSDEActionWizard pSDEActionWizard2 = (PSDEActionWizard)this.getDEModel().createEntity();
            pSDEActionWizard2.setPSDEActionWizardId(pSDEActionWizard.getPSDEActionWizardId());
            pSDEActionWizard2.setAWPSDEDSId(null);
            this.update(pSDEActionWizard2);
        }
    }

    public void removeByAWPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        final PSDEDataSet pSDEDataSet2 = pSDEDataSet;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEActionWizardServiceBase.this.onBeforeRemoveByAWPSDEDS(pSDEDataSet2);
                PSDEActionWizardServiceBase.this.internalRemoveByAWPSDEDS(pSDEDataSet2);
                PSDEActionWizardServiceBase.this.onAfterRemoveByAWPSDEDS(pSDEDataSet2);
            }
        });
    }

    protected void onBeforeRemoveByAWPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void internalRemoveByAWPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDEActionWizard> arrayList = this.selectByAWPSDEDS(pSDEDataSet);
        this.onBeforeRemoveByAWPSDEDS(pSDEDataSet, arrayList);
        for (PSDEActionWizard pSDEActionWizard : arrayList) {
            this.remove((IEntity)pSDEActionWizard);
        }
        this.onAfterRemoveByAWPSDEDS(pSDEDataSet, arrayList);
    }

    protected void onAfterRemoveByAWPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void onBeforeRemoveByAWPSDEDS(PSDEDataSet pSDEDataSet, ArrayList<PSDEActionWizard> arrayList) throws Exception {
    }

    protected void onAfterRemoveByAWPSDEDS(PSDEDataSet pSDEDataSet, ArrayList<PSDEActionWizard> arrayList) throws Exception {
    }

    public void testRemoveByAWIContentPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEActionWizard> arrayList = this.selectByAWIContentPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEACTIONWIZARD_PSDEFIELD_AWICONTENTPSDEFID", "", iDataEntityModel.getName(), "PSDEACTIONWIZARD", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetAWIContentPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEActionWizard> arrayList = this.selectByAWIContentPSDEF(pSDEField);
        for (PSDEActionWizard pSDEActionWizard : arrayList) {
            PSDEActionWizard pSDEActionWizard2 = (PSDEActionWizard)this.getDEModel().createEntity();
            pSDEActionWizard2.setPSDEActionWizardId(pSDEActionWizard.getPSDEActionWizardId());
            pSDEActionWizard2.setAWIContentPSDEFId(null);
            this.update(pSDEActionWizard2);
        }
    }

    public void removeByAWIContentPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEActionWizardServiceBase.this.onBeforeRemoveByAWIContentPSDEF(pSDEField2);
                PSDEActionWizardServiceBase.this.internalRemoveByAWIContentPSDEF(pSDEField2);
                PSDEActionWizardServiceBase.this.onAfterRemoveByAWIContentPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByAWIContentPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByAWIContentPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEActionWizard> arrayList = this.selectByAWIContentPSDEF(pSDEField);
        this.onBeforeRemoveByAWIContentPSDEF(pSDEField, arrayList);
        for (PSDEActionWizard pSDEActionWizard : arrayList) {
            this.remove((IEntity)pSDEActionWizard);
        }
        this.onAfterRemoveByAWIContentPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByAWIContentPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByAWIContentPSDEF(PSDEField pSDEField, ArrayList<PSDEActionWizard> arrayList) throws Exception {
    }

    protected void onAfterRemoveByAWIContentPSDEF(PSDEField pSDEField, ArrayList<PSDEActionWizard> arrayList) throws Exception {
    }

    public void testRemoveByAWIFKeyPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEActionWizard> arrayList = this.selectByAWIFKeyPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEACTIONWIZARD_PSDEFIELD_AWIFKEYPSDEFID", "", iDataEntityModel.getName(), "PSDEACTIONWIZARD", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetAWIFKeyPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEActionWizard> arrayList = this.selectByAWIFKeyPSDEF(pSDEField);
        for (PSDEActionWizard pSDEActionWizard : arrayList) {
            PSDEActionWizard pSDEActionWizard2 = (PSDEActionWizard)this.getDEModel().createEntity();
            pSDEActionWizard2.setPSDEActionWizardId(pSDEActionWizard.getPSDEActionWizardId());
            pSDEActionWizard2.setAWIFKeyPSDEFId(null);
            this.update(pSDEActionWizard2);
        }
    }

    public void removeByAWIFKeyPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEActionWizardServiceBase.this.onBeforeRemoveByAWIFKeyPSDEF(pSDEField2);
                PSDEActionWizardServiceBase.this.internalRemoveByAWIFKeyPSDEF(pSDEField2);
                PSDEActionWizardServiceBase.this.onAfterRemoveByAWIFKeyPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByAWIFKeyPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByAWIFKeyPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEActionWizard> arrayList = this.selectByAWIFKeyPSDEF(pSDEField);
        this.onBeforeRemoveByAWIFKeyPSDEF(pSDEField, arrayList);
        for (PSDEActionWizard pSDEActionWizard : arrayList) {
            this.remove((IEntity)pSDEActionWizard);
        }
        this.onAfterRemoveByAWIFKeyPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByAWIFKeyPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByAWIFKeyPSDEF(PSDEField pSDEField, ArrayList<PSDEActionWizard> arrayList) throws Exception {
    }

    protected void onAfterRemoveByAWIFKeyPSDEF(PSDEField pSDEField, ArrayList<PSDEActionWizard> arrayList) throws Exception {
    }

    public void testRemoveByAWINamePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEActionWizard> arrayList = this.selectByAWINamePSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEACTIONWIZARD_PSDEFIELD_AWINAMEPSDEFID", "", iDataEntityModel.getName(), "PSDEACTIONWIZARD", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetAWINamePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEActionWizard> arrayList = this.selectByAWINamePSDEF(pSDEField);
        for (PSDEActionWizard pSDEActionWizard : arrayList) {
            PSDEActionWizard pSDEActionWizard2 = (PSDEActionWizard)this.getDEModel().createEntity();
            pSDEActionWizard2.setPSDEActionWizardId(pSDEActionWizard.getPSDEActionWizardId());
            pSDEActionWizard2.setAWINamePSDEFId(null);
            this.update(pSDEActionWizard2);
        }
    }

    public void removeByAWINamePSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEActionWizardServiceBase.this.onBeforeRemoveByAWINamePSDEF(pSDEField2);
                PSDEActionWizardServiceBase.this.internalRemoveByAWINamePSDEF(pSDEField2);
                PSDEActionWizardServiceBase.this.onAfterRemoveByAWINamePSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByAWINamePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByAWINamePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEActionWizard> arrayList = this.selectByAWINamePSDEF(pSDEField);
        this.onBeforeRemoveByAWINamePSDEF(pSDEField, arrayList);
        for (PSDEActionWizard pSDEActionWizard : arrayList) {
            this.remove((IEntity)pSDEActionWizard);
        }
        this.onAfterRemoveByAWINamePSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByAWINamePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByAWINamePSDEF(PSDEField pSDEField, ArrayList<PSDEActionWizard> arrayList) throws Exception {
    }

    protected void onAfterRemoveByAWINamePSDEF(PSDEField pSDEField, ArrayList<PSDEActionWizard> arrayList) throws Exception {
    }

    public void testRemoveByAWISortPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEActionWizard> arrayList = this.selectByAWISortPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEACTIONWIZARD_PSDEFIELD_AWISORTPSDEFID", "", iDataEntityModel.getName(), "PSDEACTIONWIZARD", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetAWISortPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEActionWizard> arrayList = this.selectByAWISortPSDEF(pSDEField);
        for (PSDEActionWizard pSDEActionWizard : arrayList) {
            PSDEActionWizard pSDEActionWizard2 = (PSDEActionWizard)this.getDEModel().createEntity();
            pSDEActionWizard2.setPSDEActionWizardId(pSDEActionWizard.getPSDEActionWizardId());
            pSDEActionWizard2.setAWISortPSDEFId(null);
            this.update(pSDEActionWizard2);
        }
    }

    public void removeByAWISortPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEActionWizardServiceBase.this.onBeforeRemoveByAWISortPSDEF(pSDEField2);
                PSDEActionWizardServiceBase.this.internalRemoveByAWISortPSDEF(pSDEField2);
                PSDEActionWizardServiceBase.this.onAfterRemoveByAWISortPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByAWISortPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByAWISortPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEActionWizard> arrayList = this.selectByAWISortPSDEF(pSDEField);
        this.onBeforeRemoveByAWISortPSDEF(pSDEField, arrayList);
        for (PSDEActionWizard pSDEActionWizard : arrayList) {
            this.remove((IEntity)pSDEActionWizard);
        }
        this.onAfterRemoveByAWISortPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByAWISortPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByAWISortPSDEF(PSDEField pSDEField, ArrayList<PSDEActionWizard> arrayList) throws Exception {
    }

    protected void onAfterRemoveByAWISortPSDEF(PSDEField pSDEField, ArrayList<PSDEActionWizard> arrayList) throws Exception {
    }

    public void testRemoveByAWIUrlPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEActionWizard> arrayList = this.selectByAWIUrlPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEACTIONWIZARD_PSDEFIELD_AWIURLPSDEFID", "", iDataEntityModel.getName(), "PSDEACTIONWIZARD", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetAWIUrlPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEActionWizard> arrayList = this.selectByAWIUrlPSDEF(pSDEField);
        for (PSDEActionWizard pSDEActionWizard : arrayList) {
            PSDEActionWizard pSDEActionWizard2 = (PSDEActionWizard)this.getDEModel().createEntity();
            pSDEActionWizard2.setPSDEActionWizardId(pSDEActionWizard.getPSDEActionWizardId());
            pSDEActionWizard2.setAWIUrlPSDEFId(null);
            this.update(pSDEActionWizard2);
        }
    }

    public void removeByAWIUrlPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEActionWizardServiceBase.this.onBeforeRemoveByAWIUrlPSDEF(pSDEField2);
                PSDEActionWizardServiceBase.this.internalRemoveByAWIUrlPSDEF(pSDEField2);
                PSDEActionWizardServiceBase.this.onAfterRemoveByAWIUrlPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByAWIUrlPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByAWIUrlPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEActionWizard> arrayList = this.selectByAWIUrlPSDEF(pSDEField);
        this.onBeforeRemoveByAWIUrlPSDEF(pSDEField, arrayList);
        for (PSDEActionWizard pSDEActionWizard : arrayList) {
            this.remove((IEntity)pSDEActionWizard);
        }
        this.onAfterRemoveByAWIUrlPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByAWIUrlPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByAWIUrlPSDEF(PSDEField pSDEField, ArrayList<PSDEActionWizard> arrayList) throws Exception {
    }

    protected void onAfterRemoveByAWIUrlPSDEF(PSDEField pSDEField, ArrayList<PSDEActionWizard> arrayList) throws Exception {
    }

    public void testRemoveByAWIValuePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEActionWizard> arrayList = this.selectByAWIValuePSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEACTIONWIZARD_PSDEFIELD_AWIVALUEPSDEFID", "", iDataEntityModel.getName(), "PSDEACTIONWIZARD", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetAWIValuePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEActionWizard> arrayList = this.selectByAWIValuePSDEF(pSDEField);
        for (PSDEActionWizard pSDEActionWizard : arrayList) {
            PSDEActionWizard pSDEActionWizard2 = (PSDEActionWizard)this.getDEModel().createEntity();
            pSDEActionWizard2.setPSDEActionWizardId(pSDEActionWizard.getPSDEActionWizardId());
            pSDEActionWizard2.setAWIValuePSDEFId(null);
            this.update(pSDEActionWizard2);
        }
    }

    public void removeByAWIValuePSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEActionWizardServiceBase.this.onBeforeRemoveByAWIValuePSDEF(pSDEField2);
                PSDEActionWizardServiceBase.this.internalRemoveByAWIValuePSDEF(pSDEField2);
                PSDEActionWizardServiceBase.this.onAfterRemoveByAWIValuePSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByAWIValuePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByAWIValuePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEActionWizard> arrayList = this.selectByAWIValuePSDEF(pSDEField);
        this.onBeforeRemoveByAWIValuePSDEF(pSDEField, arrayList);
        for (PSDEActionWizard pSDEActionWizard : arrayList) {
            this.remove((IEntity)pSDEActionWizard);
        }
        this.onAfterRemoveByAWIValuePSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByAWIValuePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByAWIValuePSDEF(PSDEField pSDEField, ArrayList<PSDEActionWizard> arrayList) throws Exception {
    }

    protected void onAfterRemoveByAWIValuePSDEF(PSDEField pSDEField, ArrayList<PSDEActionWizard> arrayList) throws Exception {
    }

    public void testRemoveByAWKWPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEActionWizard> arrayList = this.selectByAWKWPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEACTIONWIZARD_PSDEFIELD_AWKWPSDEFID", "", iDataEntityModel.getName(), "PSDEACTIONWIZARD", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetAWKWPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEActionWizard> arrayList = this.selectByAWKWPSDEF(pSDEField);
        for (PSDEActionWizard pSDEActionWizard : arrayList) {
            PSDEActionWizard pSDEActionWizard2 = (PSDEActionWizard)this.getDEModel().createEntity();
            pSDEActionWizard2.setPSDEActionWizardId(pSDEActionWizard.getPSDEActionWizardId());
            pSDEActionWizard2.setAWKWPSDEFId(null);
            this.update(pSDEActionWizard2);
        }
    }

    public void removeByAWKWPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEActionWizardServiceBase.this.onBeforeRemoveByAWKWPSDEF(pSDEField2);
                PSDEActionWizardServiceBase.this.internalRemoveByAWKWPSDEF(pSDEField2);
                PSDEActionWizardServiceBase.this.onAfterRemoveByAWKWPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByAWKWPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByAWKWPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEActionWizard> arrayList = this.selectByAWKWPSDEF(pSDEField);
        this.onBeforeRemoveByAWKWPSDEF(pSDEField, arrayList);
        for (PSDEActionWizard pSDEActionWizard : arrayList) {
            this.remove((IEntity)pSDEActionWizard);
        }
        this.onAfterRemoveByAWKWPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByAWKWPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByAWKWPSDEF(PSDEField pSDEField, ArrayList<PSDEActionWizard> arrayList) throws Exception {
    }

    protected void onAfterRemoveByAWKWPSDEF(PSDEField pSDEField, ArrayList<PSDEActionWizard> arrayList) throws Exception {
    }

    public void testRemoveByAWNamePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEActionWizard> arrayList = this.selectByAWNamePSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEACTIONWIZARD_PSDEFIELD_AWNAMEPSDEFID", "", iDataEntityModel.getName(), "PSDEACTIONWIZARD", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetAWNamePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEActionWizard> arrayList = this.selectByAWNamePSDEF(pSDEField);
        for (PSDEActionWizard pSDEActionWizard : arrayList) {
            PSDEActionWizard pSDEActionWizard2 = (PSDEActionWizard)this.getDEModel().createEntity();
            pSDEActionWizard2.setPSDEActionWizardId(pSDEActionWizard.getPSDEActionWizardId());
            pSDEActionWizard2.setAWNamePSDEFId(null);
            this.update(pSDEActionWizard2);
        }
    }

    public void removeByAWNamePSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEActionWizardServiceBase.this.onBeforeRemoveByAWNamePSDEF(pSDEField2);
                PSDEActionWizardServiceBase.this.internalRemoveByAWNamePSDEF(pSDEField2);
                PSDEActionWizardServiceBase.this.onAfterRemoveByAWNamePSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByAWNamePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByAWNamePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEActionWizard> arrayList = this.selectByAWNamePSDEF(pSDEField);
        this.onBeforeRemoveByAWNamePSDEF(pSDEField, arrayList);
        for (PSDEActionWizard pSDEActionWizard : arrayList) {
            this.remove((IEntity)pSDEActionWizard);
        }
        this.onAfterRemoveByAWNamePSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByAWNamePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByAWNamePSDEF(PSDEField pSDEField, ArrayList<PSDEActionWizard> arrayList) throws Exception {
    }

    protected void onAfterRemoveByAWNamePSDEF(PSDEField pSDEField, ArrayList<PSDEActionWizard> arrayList) throws Exception {
    }

    public void testRemoveByAWSortPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEActionWizard> arrayList = this.selectByAWSortPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEACTIONWIZARD_PSDEFIELD_AWSORTPSDEFID", "", iDataEntityModel.getName(), "PSDEACTIONWIZARD", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetAWSortPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEActionWizard> arrayList = this.selectByAWSortPSDEF(pSDEField);
        for (PSDEActionWizard pSDEActionWizard : arrayList) {
            PSDEActionWizard pSDEActionWizard2 = (PSDEActionWizard)this.getDEModel().createEntity();
            pSDEActionWizard2.setPSDEActionWizardId(pSDEActionWizard.getPSDEActionWizardId());
            pSDEActionWizard2.setAWSortPSDEFId(null);
            this.update(pSDEActionWizard2);
        }
    }

    public void removeByAWSortPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEActionWizardServiceBase.this.onBeforeRemoveByAWSortPSDEF(pSDEField2);
                PSDEActionWizardServiceBase.this.internalRemoveByAWSortPSDEF(pSDEField2);
                PSDEActionWizardServiceBase.this.onAfterRemoveByAWSortPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByAWSortPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByAWSortPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEActionWizard> arrayList = this.selectByAWSortPSDEF(pSDEField);
        this.onBeforeRemoveByAWSortPSDEF(pSDEField, arrayList);
        for (PSDEActionWizard pSDEActionWizard : arrayList) {
            this.remove((IEntity)pSDEActionWizard);
        }
        this.onAfterRemoveByAWSortPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByAWSortPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByAWSortPSDEF(PSDEField pSDEField, ArrayList<PSDEActionWizard> arrayList) throws Exception {
    }

    protected void onAfterRemoveByAWSortPSDEF(PSDEField pSDEField, ArrayList<PSDEActionWizard> arrayList) throws Exception {
    }

    public void testRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEActionWizard> arrayList = this.selectByPSDEViewBase(pSDEViewBase, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVIEWBASE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEViewBase);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEACTIONWIZARD_PSDEVIEWBASE_PSDEVIEWBASEID", "", iDataEntityModel.getName(), "PSDEACTIONWIZARD", iDataEntityModel.getDataInfo((IEntity)pSDEViewBase), arrayList.get(0)));
        }
    }

    public void resetPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEActionWizard> arrayList = this.selectByPSDEViewBase(pSDEViewBase);
        for (PSDEActionWizard pSDEActionWizard : arrayList) {
            PSDEActionWizard pSDEActionWizard2 = (PSDEActionWizard)this.getDEModel().createEntity();
            pSDEActionWizard2.setPSDEActionWizardId(pSDEActionWizard.getPSDEActionWizardId());
            pSDEActionWizard2.setPSDEViewBaseId(null);
            this.update(pSDEActionWizard2);
        }
    }

    public void removeByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
        final PSDEViewBase pSDEViewBase2 = pSDEViewBase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEActionWizardServiceBase.this.onBeforeRemoveByPSDEViewBase(pSDEViewBase2);
                PSDEActionWizardServiceBase.this.internalRemoveByPSDEViewBase(pSDEViewBase2);
                PSDEActionWizardServiceBase.this.onAfterRemoveByPSDEViewBase(pSDEViewBase2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void internalRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEActionWizard> arrayList = this.selectByPSDEViewBase(pSDEViewBase);
        this.onBeforeRemoveByPSDEViewBase(pSDEViewBase, arrayList);
        for (PSDEActionWizard pSDEActionWizard : arrayList) {
            this.remove((IEntity)pSDEActionWizard);
        }
        this.onAfterRemoveByPSDEViewBase(pSDEViewBase, arrayList);
    }

    protected void onAfterRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void onBeforeRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase, ArrayList<PSDEActionWizard> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase, ArrayList<PSDEActionWizard> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDEActionWizard pSDEActionWizard) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEAWGrpDetailService)ServiceGlobal.getService(PSDEAWGrpDetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEAWGrpDetailServiceBase)pSCoreSysServiceBase).testRemoveByPSDEActionWizard(pSDEActionWizard);
        pSCoreSysServiceBase = (PSDEAWItemService)ServiceGlobal.getService(PSDEAWItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEAWItemServiceBase)pSCoreSysServiceBase).testRemoveByPSDEActionWizard(pSDEActionWizard);
        ((PSDEAWItemServiceBase)pSCoreSysServiceBase).removeByPSDEActionWizard(pSDEActionWizard);
        super.onBeforeRemove(pSDEActionWizard);
    }

    protected void onBeforeRemoveTemp(PSDEActionWizard pSDEActionWizard) throws Exception {
        PSDEAWItemService pSDEAWItemService = (PSDEAWItemService)ServiceGlobal.getService(PSDEAWItemService.class, (SessionFactory)this.getSessionFactory());
        pSDEAWItemService.removeTempByPSDEActionWizard(pSDEActionWizard);
        super.onBeforeRemoveTemp((IEntity)pSDEActionWizard);
    }

    protected void getRelatedDataTempMajor(PSDEActionWizard pSDEActionWizard) throws Exception {
        this.getRelatedDataTempMajor_PSDEAWItem(pSDEActionWizard);
        super.getRelatedDataTempMajor((IEntity)pSDEActionWizard);
    }

    protected void getRelatedDataTempMajor_PSDEAWItem(PSDEActionWizard pSDEActionWizard) throws Exception {
        PSDEAWItemService pSDEAWItemService = (PSDEAWItemService)ServiceGlobal.getService(PSDEAWItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEAWItem> arrayList = null;
        String string = pSDEActionWizard.getPSDEActionWizardId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEAWItemService.selectByPSDEActionWizard(pSDEActionWizard) : pSDEAWItemService.selectTempByPSDEActionWizard(pSDEActionWizard);
        for (PSDEAWItem pSDEAWItem : arrayList) {
            pSDEAWItemService.getTempMajor(pSDEAWItem);
        }
    }

    protected void updateRelatedDataTempMajor(PSDEActionWizard pSDEActionWizard, PSDEActionWizard pSDEActionWizard2) throws Exception {
        ArrayList<PSDEAWItem> arrayList = this.updateRelatedDataTempMajor_removePSDEAWItem(pSDEActionWizard, pSDEActionWizard2);
        this.updateRelatedDataTempMajor_updatePSDEAWItem(pSDEActionWizard, pSDEActionWizard2, arrayList);
        super.updateRelatedDataTempMajor((IEntity)pSDEActionWizard, (IEntity)pSDEActionWizard2);
    }

    protected ArrayList<PSDEAWItem> updateRelatedDataTempMajor_removePSDEAWItem(PSDEActionWizard pSDEActionWizard, PSDEActionWizard pSDEActionWizard2) throws Exception {
        PSDEAWItemService pSDEAWItemService = (PSDEAWItemService)ServiceGlobal.getService(PSDEAWItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEAWItem> arrayList = pSDEAWItemService.selectTempByPSDEActionWizard(pSDEActionWizard);
        ArrayList<PSDEAWItem> arrayList2 = pSDEAWItemService.selectByPSDEActionWizard(pSDEActionWizard2);
        HashMap<String, PSDEAWItem> hashMap = new HashMap<String, PSDEAWItem>();
        for (PSDEAWItem pSDEAWItem : arrayList2) {
            hashMap.put(pSDEAWItem.getPSDEAWItemId(), pSDEAWItem);
        }
        for (PSDEAWItem pSDEAWItem : arrayList) {
            Object object = pSDEAWItem.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSDEAWItem pSDEAWItem : hashMap.values()) {
            pSDEAWItemService.remove((IEntity)pSDEAWItem);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSDEAWItem(PSDEActionWizard pSDEActionWizard, PSDEActionWizard pSDEActionWizard2, ArrayList<PSDEAWItem> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSDEAWItemService pSDEAWItemService = (PSDEAWItemService)ServiceGlobal.getService(PSDEAWItemService.class, (SessionFactory)this.getSessionFactory());
        for (PSDEAWItem pSDEAWItem : arrayList) {
            pSDEAWItemService.updateTempMajor(pSDEAWItem);
        }
    }

    protected void replaceParentInfo(PSDEActionWizard pSDEActionWizard, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDEActionWizard, cloneSession);
        if (pSDEActionWizard.getAWIPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSDEActionWizard.getAWIPSDEId())) != null) {
            this.onFillParentInfo_AWIPSDE(pSDEActionWizard, (PSDataEntity)iEntity);
        }
        if (pSDEActionWizard.getAWPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSDEActionWizard.getAWPSDEId())) != null) {
            this.onFillParentInfo_AWPSDE(pSDEActionWizard, (PSDataEntity)iEntity);
        }
        if (pSDEActionWizard.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSDEActionWizard.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSDEActionWizard, (PSDataEntity)iEntity);
        }
        if (pSDEActionWizard.getAWIPSDEDSId() != null && (iEntity = cloneSession.getEntity("PSDEDATASET", (Object)pSDEActionWizard.getAWIPSDEDSId())) != null) {
            this.onFillParentInfo_AWIPSDEDS(pSDEActionWizard, (PSDEDataSet)iEntity);
        }
        if (pSDEActionWizard.getAWPSDEDSId() != null && (iEntity = cloneSession.getEntity("PSDEDATASET", (Object)pSDEActionWizard.getAWPSDEDSId())) != null) {
            this.onFillParentInfo_AWPSDEDS(pSDEActionWizard, (PSDEDataSet)iEntity);
        }
        if (pSDEActionWizard.getAWIContentPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSDEActionWizard.getAWIContentPSDEFId())) != null) {
            this.onFillParentInfo_AWIContentPSDEF(pSDEActionWizard, (PSDEField)iEntity);
        }
        if (pSDEActionWizard.getAWIFKeyPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSDEActionWizard.getAWIFKeyPSDEFId())) != null) {
            this.onFillParentInfo_AWIFKeyPSDEF(pSDEActionWizard, (PSDEField)iEntity);
        }
        if (pSDEActionWizard.getAWINamePSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSDEActionWizard.getAWINamePSDEFId())) != null) {
            this.onFillParentInfo_AWINamePSDEF(pSDEActionWizard, (PSDEField)iEntity);
        }
        if (pSDEActionWizard.getAWISortPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSDEActionWizard.getAWISortPSDEFId())) != null) {
            this.onFillParentInfo_AWISortPSDEF(pSDEActionWizard, (PSDEField)iEntity);
        }
        if (pSDEActionWizard.getAWIUrlPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSDEActionWizard.getAWIUrlPSDEFId())) != null) {
            this.onFillParentInfo_AWIUrlPSDEF(pSDEActionWizard, (PSDEField)iEntity);
        }
        if (pSDEActionWizard.getAWIValuePSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSDEActionWizard.getAWIValuePSDEFId())) != null) {
            this.onFillParentInfo_AWIValuePSDEF(pSDEActionWizard, (PSDEField)iEntity);
        }
        if (pSDEActionWizard.getAWKWPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSDEActionWizard.getAWKWPSDEFId())) != null) {
            this.onFillParentInfo_AWKWPSDEF(pSDEActionWizard, (PSDEField)iEntity);
        }
        if (pSDEActionWizard.getAWNamePSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSDEActionWizard.getAWNamePSDEFId())) != null) {
            this.onFillParentInfo_AWNamePSDEF(pSDEActionWizard, (PSDEField)iEntity);
        }
        if (pSDEActionWizard.getAWSortPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSDEActionWizard.getAWSortPSDEFId())) != null) {
            this.onFillParentInfo_AWSortPSDEF(pSDEActionWizard, (PSDEField)iEntity);
        }
        if (pSDEActionWizard.getPSDEViewBaseId() != null && (iEntity = cloneSession.getEntity("PSDEVIEWBASE", (Object)pSDEActionWizard.getPSDEViewBaseId())) != null) {
            this.onFillParentInfo_PSDEViewBase(pSDEActionWizard, (PSDEViewBase)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDEActionWizard pSDEActionWizard, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDEActionWizard, bl);
    }

    protected void onCheckEntity(boolean bl, PSDEActionWizard pSDEActionWizard, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AWIContentPSDEFId(bl, pSDEActionWizard, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AWIContentPSDEFName(bl, pSDEActionWizard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AWIFKeyPSDEFId(bl, pSDEActionWizard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AWIFKeyPSDEFName(bl, pSDEActionWizard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AWINamePSDEFId(bl, pSDEActionWizard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AWINamePSDEFName(bl, pSDEActionWizard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AWIPSDEDSId(bl, pSDEActionWizard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AWIPSDEId(bl, pSDEActionWizard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AWIPSDEName(bl, pSDEActionWizard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AWISortPSDEFId(bl, pSDEActionWizard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AWISortPSDEFName(bl, pSDEActionWizard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AWIUrlPSDEFId(bl, pSDEActionWizard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AWIUrlPSDEFName(bl, pSDEActionWizard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AWIValuePSDEFId(bl, pSDEActionWizard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AWIValuePSDEFName(bl, pSDEActionWizard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AWKWPSDEFId(bl, pSDEActionWizard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AWKWPSDEFName(bl, pSDEActionWizard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AWNamePSDEFId(bl, pSDEActionWizard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AWNamePSDEFName(bl, pSDEActionWizard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AWPSDEDSId(bl, pSDEActionWizard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AWPSDEId(bl, pSDEActionWizard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AWPSDEName(bl, pSDEActionWizard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AWSortPSDEFId(bl, pSDEActionWizard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AWSortPSDEFName(bl, pSDEActionWizard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSDEActionWizard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynamicMode(bl, pSDEActionWizard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Keywords(bl, pSDEActionWizard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LockFlag(bl, pSDEActionWizard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDEActionWizard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEActionWizardId(bl, pSDEActionWizard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEActionWizardName(bl, pSDEActionWizard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSDEActionWizard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSDEActionWizard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEViewBaseId(bl, pSDEActionWizard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSDEActionWizard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDEActionWizard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDEActionWizard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDEActionWizard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDEActionWizard, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDEActionWizard, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AWIContentPSDEFId(boolean bl, PSDEActionWizard pSDEActionWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionWizard.isAWIContentPSDEFIdDirty() : !pSDEActionWizard.isAWIContentPSDEFIdDirty()) {
            return null;
        }
        String string = pSDEActionWizard.getAWIContentPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AWIContentPSDEFId_Default((IEntity)pSDEActionWizard, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AWICONTENTPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AWIContentPSDEFName(boolean bl, PSDEActionWizard pSDEActionWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionWizard.isAWIContentPSDEFNameDirty() : !pSDEActionWizard.isAWIContentPSDEFNameDirty()) {
            return null;
        }
        String string = pSDEActionWizard.getAWIContentPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AWIContentPSDEFName_Default((IEntity)pSDEActionWizard, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AWICONTENTPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AWIFKeyPSDEFId(boolean bl, PSDEActionWizard pSDEActionWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionWizard.isAWIFKeyPSDEFIdDirty() : !pSDEActionWizard.isAWIFKeyPSDEFIdDirty()) {
            return null;
        }
        String string = pSDEActionWizard.getAWIFKeyPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AWIFKeyPSDEFId_Default((IEntity)pSDEActionWizard, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AWIFKEYPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AWIFKeyPSDEFName(boolean bl, PSDEActionWizard pSDEActionWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionWizard.isAWIFKeyPSDEFNameDirty() : !pSDEActionWizard.isAWIFKeyPSDEFNameDirty()) {
            return null;
        }
        String string = pSDEActionWizard.getAWIFKeyPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AWIFKeyPSDEFName_Default((IEntity)pSDEActionWizard, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AWIFKEYPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AWINamePSDEFId(boolean bl, PSDEActionWizard pSDEActionWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionWizard.isAWINamePSDEFIdDirty() : !pSDEActionWizard.isAWINamePSDEFIdDirty()) {
            return null;
        }
        String string = pSDEActionWizard.getAWINamePSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AWINamePSDEFId_Default((IEntity)pSDEActionWizard, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AWINAMEPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AWINamePSDEFName(boolean bl, PSDEActionWizard pSDEActionWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionWizard.isAWINamePSDEFNameDirty() : !pSDEActionWizard.isAWINamePSDEFNameDirty()) {
            return null;
        }
        String string = pSDEActionWizard.getAWINamePSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AWINamePSDEFName_Default((IEntity)pSDEActionWizard, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AWINAMEPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AWIPSDEDSId(boolean bl, PSDEActionWizard pSDEActionWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionWizard.isAWIPSDEDSIdDirty() : !pSDEActionWizard.isAWIPSDEDSIdDirty()) {
            return null;
        }
        String string = pSDEActionWizard.getAWIPSDEDSId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AWIPSDEDSId_Default((IEntity)pSDEActionWizard, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AWIPSDEDSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AWIPSDEId(boolean bl, PSDEActionWizard pSDEActionWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionWizard.isAWIPSDEIdDirty() : !pSDEActionWizard.isAWIPSDEIdDirty()) {
            return null;
        }
        String string = pSDEActionWizard.getAWIPSDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AWIPSDEId_Default((IEntity)pSDEActionWizard, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AWIPSDEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AWIPSDEName(boolean bl, PSDEActionWizard pSDEActionWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionWizard.isAWIPSDENameDirty() : !pSDEActionWizard.isAWIPSDENameDirty()) {
            return null;
        }
        String string = pSDEActionWizard.getAWIPSDEName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AWIPSDEName_Default((IEntity)pSDEActionWizard, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AWIPSDENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AWISortPSDEFId(boolean bl, PSDEActionWizard pSDEActionWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionWizard.isAWISortPSDEFIdDirty() : !pSDEActionWizard.isAWISortPSDEFIdDirty()) {
            return null;
        }
        String string = pSDEActionWizard.getAWISortPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AWISortPSDEFId_Default((IEntity)pSDEActionWizard, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AWISORTPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AWISortPSDEFName(boolean bl, PSDEActionWizard pSDEActionWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionWizard.isAWISortPSDEFNameDirty() : !pSDEActionWizard.isAWISortPSDEFNameDirty()) {
            return null;
        }
        String string = pSDEActionWizard.getAWISortPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AWISortPSDEFName_Default((IEntity)pSDEActionWizard, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AWISORTPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AWIUrlPSDEFId(boolean bl, PSDEActionWizard pSDEActionWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionWizard.isAWIUrlPSDEFIdDirty() : !pSDEActionWizard.isAWIUrlPSDEFIdDirty()) {
            return null;
        }
        String string = pSDEActionWizard.getAWIUrlPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AWIUrlPSDEFId_Default((IEntity)pSDEActionWizard, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AWIURLPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AWIUrlPSDEFName(boolean bl, PSDEActionWizard pSDEActionWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionWizard.isAWIUrlPSDEFNameDirty() : !pSDEActionWizard.isAWIUrlPSDEFNameDirty()) {
            return null;
        }
        String string = pSDEActionWizard.getAWIUrlPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AWIUrlPSDEFName_Default((IEntity)pSDEActionWizard, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AWIURLPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AWIValuePSDEFId(boolean bl, PSDEActionWizard pSDEActionWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionWizard.isAWIValuePSDEFIdDirty() : !pSDEActionWizard.isAWIValuePSDEFIdDirty()) {
            return null;
        }
        String string = pSDEActionWizard.getAWIValuePSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AWIValuePSDEFId_Default((IEntity)pSDEActionWizard, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AWIVALUEPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AWIValuePSDEFName(boolean bl, PSDEActionWizard pSDEActionWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionWizard.isAWIValuePSDEFNameDirty() : !pSDEActionWizard.isAWIValuePSDEFNameDirty()) {
            return null;
        }
        String string = pSDEActionWizard.getAWIValuePSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AWIValuePSDEFName_Default((IEntity)pSDEActionWizard, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AWIVALUEPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AWKWPSDEFId(boolean bl, PSDEActionWizard pSDEActionWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionWizard.isAWKWPSDEFIdDirty() : !pSDEActionWizard.isAWKWPSDEFIdDirty()) {
            return null;
        }
        String string = pSDEActionWizard.getAWKWPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AWKWPSDEFId_Default((IEntity)pSDEActionWizard, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AWKWPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AWKWPSDEFName(boolean bl, PSDEActionWizard pSDEActionWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionWizard.isAWKWPSDEFNameDirty() : !pSDEActionWizard.isAWKWPSDEFNameDirty()) {
            return null;
        }
        String string = pSDEActionWizard.getAWKWPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AWKWPSDEFName_Default((IEntity)pSDEActionWizard, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AWKWPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AWNamePSDEFId(boolean bl, PSDEActionWizard pSDEActionWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionWizard.isAWNamePSDEFIdDirty() : !pSDEActionWizard.isAWNamePSDEFIdDirty()) {
            return null;
        }
        String string = pSDEActionWizard.getAWNamePSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AWNamePSDEFId_Default((IEntity)pSDEActionWizard, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AWNAMEPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AWNamePSDEFName(boolean bl, PSDEActionWizard pSDEActionWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionWizard.isAWNamePSDEFNameDirty() : !pSDEActionWizard.isAWNamePSDEFNameDirty()) {
            return null;
        }
        String string = pSDEActionWizard.getAWNamePSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AWNamePSDEFName_Default((IEntity)pSDEActionWizard, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AWNAMEPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AWPSDEDSId(boolean bl, PSDEActionWizard pSDEActionWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionWizard.isAWPSDEDSIdDirty() : !pSDEActionWizard.isAWPSDEDSIdDirty()) {
            return null;
        }
        String string = pSDEActionWizard.getAWPSDEDSId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AWPSDEDSId_Default((IEntity)pSDEActionWizard, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AWPSDEDSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AWPSDEId(boolean bl, PSDEActionWizard pSDEActionWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionWizard.isAWPSDEIdDirty() : !pSDEActionWizard.isAWPSDEIdDirty()) {
            return null;
        }
        String string = pSDEActionWizard.getAWPSDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AWPSDEId_Default((IEntity)pSDEActionWizard, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AWPSDEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AWPSDEName(boolean bl, PSDEActionWizard pSDEActionWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionWizard.isAWPSDENameDirty() : !pSDEActionWizard.isAWPSDENameDirty()) {
            return null;
        }
        String string = pSDEActionWizard.getAWPSDEName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AWPSDEName_Default((IEntity)pSDEActionWizard, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AWPSDENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AWSortPSDEFId(boolean bl, PSDEActionWizard pSDEActionWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionWizard.isAWSortPSDEFIdDirty() : !pSDEActionWizard.isAWSortPSDEFIdDirty()) {
            return null;
        }
        String string = pSDEActionWizard.getAWSortPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AWSortPSDEFId_Default((IEntity)pSDEActionWizard, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AWSORTPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AWSortPSDEFName(boolean bl, PSDEActionWizard pSDEActionWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionWizard.isAWSortPSDEFNameDirty() : !pSDEActionWizard.isAWSortPSDEFNameDirty()) {
            return null;
        }
        String string = pSDEActionWizard.getAWSortPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AWSortPSDEFName_Default((IEntity)pSDEActionWizard, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AWSORTPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSDEActionWizard pSDEActionWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionWizard.isCodeNameDirty() : !pSDEActionWizard.isCodeNameDirty()) {
            return null;
        }
        String string = pSDEActionWizard.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default((IEntity)pSDEActionWizard, bl2, bl3);
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
                String string4 = this.checkFieldDupRule(this.getPSDEActionWizardDEModel(), "CODENAME", string3, pSDEActionWizard, bl2, bl3);
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

    protected EntityFieldError onCheckField_DynamicMode(boolean bl, PSDEActionWizard pSDEActionWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionWizard.isDynamicModeDirty() && !bl2 : !pSDEActionWizard.isDynamicModeDirty()) {
            return null;
        }
        Integer n = pSDEActionWizard.getDynamicMode();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DYNAMICMODE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_DynamicMode_Default((IEntity)pSDEActionWizard, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DYNAMICMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Keywords(boolean bl, PSDEActionWizard pSDEActionWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionWizard.isKeywordsDirty() : !pSDEActionWizard.isKeywordsDirty()) {
            return null;
        }
        String string = pSDEActionWizard.getKeywords();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Keywords_Default((IEntity)pSDEActionWizard, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("KEYWORDS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LockFlag(boolean bl, PSDEActionWizard pSDEActionWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionWizard.isLockFlagDirty() : !pSDEActionWizard.isLockFlagDirty()) {
            return null;
        }
        Integer n = pSDEActionWizard.getLockFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LockFlag_Default((IEntity)pSDEActionWizard, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDEActionWizard pSDEActionWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionWizard.isMemoDirty() : !pSDEActionWizard.isMemoDirty()) {
            return null;
        }
        String string = pSDEActionWizard.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDEActionWizard, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEActionWizardId(boolean bl, PSDEActionWizard pSDEActionWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionWizard.isPSDEActionWizardIdDirty() && !bl2 : !pSDEActionWizard.isPSDEActionWizardIdDirty()) {
            return null;
        }
        String string = pSDEActionWizard.getPSDEActionWizardId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEACTIONWIZARDID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEActionWizardId_Default((IEntity)pSDEActionWizard, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEACTIONWIZARDID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEActionWizardName(boolean bl, PSDEActionWizard pSDEActionWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionWizard.isPSDEActionWizardNameDirty() && !bl2 : !pSDEActionWizard.isPSDEActionWizardNameDirty()) {
            return null;
        }
        String string = pSDEActionWizard.getPSDEActionWizardName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEACTIONWIZARDNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEActionWizardName_Default((IEntity)pSDEActionWizard, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEACTIONWIZARDNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSDEActionWizard pSDEActionWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionWizard.isPSDEIdDirty() && !bl2 : !pSDEActionWizard.isPSDEIdDirty()) {
            return null;
        }
        String string = pSDEActionWizard.getPSDEId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default((IEntity)pSDEActionWizard, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSDEActionWizard pSDEActionWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionWizard.isPSDENameDirty() && !bl2 : !pSDEActionWizard.isPSDENameDirty()) {
            return null;
        }
        String string = pSDEActionWizard.getPSDEName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default((IEntity)pSDEActionWizard, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEViewBaseId(boolean bl, PSDEActionWizard pSDEActionWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionWizard.isPSDEViewBaseIdDirty() : !pSDEActionWizard.isPSDEViewBaseIdDirty()) {
            return null;
        }
        String string = pSDEActionWizard.getPSDEViewBaseId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEViewBaseId_Default((IEntity)pSDEActionWizard, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSDEActionWizard pSDEActionWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionWizard.isUserCatDirty() : !pSDEActionWizard.isUserCatDirty()) {
            return null;
        }
        String string = pSDEActionWizard.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default((IEntity)pSDEActionWizard, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDEActionWizard pSDEActionWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionWizard.isUserTagDirty() : !pSDEActionWizard.isUserTagDirty()) {
            return null;
        }
        String string = pSDEActionWizard.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSDEActionWizard, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDEActionWizard pSDEActionWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionWizard.isUserTag2Dirty() : !pSDEActionWizard.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDEActionWizard.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSDEActionWizard, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDEActionWizard pSDEActionWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionWizard.isUserTag3Dirty() : !pSDEActionWizard.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDEActionWizard.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default((IEntity)pSDEActionWizard, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDEActionWizard pSDEActionWizard, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEActionWizard.isUserTag4Dirty() : !pSDEActionWizard.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDEActionWizard.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default((IEntity)pSDEActionWizard, bl2, bl3);
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

    protected void onSyncEntity(PSDEActionWizard pSDEActionWizard, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDEActionWizard, bl);
    }

    protected void onSyncIndexEntities(PSDEActionWizard pSDEActionWizard, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDEActionWizard, bl);
    }

    public Object getDataContextValue(PSDEActionWizard pSDEActionWizard, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDEDATASET", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"AWIPSDEDSID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"AWIPSDEDSNAME", (boolean)true) == 0) && (object = super.getDataContextValue((IEntity)pSDEActionWizard, "awipsdeid", iDataContextParam)) != null) {
                return object;
            }
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDEDATASET", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"AWPSDEDSID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"AWPSDEDSNAME", (boolean)true) == 0) && (object = super.getDataContextValue((IEntity)pSDEActionWizard, "awpsdeid", iDataContextParam)) != null) {
                return object;
            }
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDEFIELD", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"AWICONTENTPSDEFID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"AWICONTENTPSDEFNAME", (boolean)true) == 0) && (object = super.getDataContextValue((IEntity)pSDEActionWizard, "awipsdeid", iDataContextParam)) != null) {
                return object;
            }
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDEFIELD", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"AWIFKEYPSDEFID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"AWIFKEYPSDEFNAME", (boolean)true) == 0) && (object = super.getDataContextValue((IEntity)pSDEActionWizard, "awipsdeid", iDataContextParam)) != null) {
                return object;
            }
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDEFIELD", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"AWINAMEPSDEFID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"AWINAMEPSDEFNAME", (boolean)true) == 0) && (object = super.getDataContextValue((IEntity)pSDEActionWizard, "awipsdeid", iDataContextParam)) != null) {
                return object;
            }
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDEFIELD", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"AWISORTPSDEFID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"AWISORTPSDEFNAME", (boolean)true) == 0) && (object = super.getDataContextValue((IEntity)pSDEActionWizard, "awipsdeid", iDataContextParam)) != null) {
                return object;
            }
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDEFIELD", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"AWIURLPSDEFID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"AWIURLPSDEFNAME", (boolean)true) == 0) && (object = super.getDataContextValue((IEntity)pSDEActionWizard, "awipsdeid", iDataContextParam)) != null) {
                return object;
            }
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDEFIELD", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"AWIVALUEPSDEFID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"AWIVALUEPSDEFNAME", (boolean)true) == 0) && (object = super.getDataContextValue((IEntity)pSDEActionWizard, "awipsdeid", iDataContextParam)) != null) {
                return object;
            }
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDEFIELD", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"AWKWPSDEFID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"AWKWPSDEFNAME", (boolean)true) == 0) && (object = super.getDataContextValue((IEntity)pSDEActionWizard, "awpsdeid", iDataContextParam)) != null) {
                return object;
            }
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDEFIELD", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"AWNAMEPSDEFID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"AWNAMEPSDEFNAME", (boolean)true) == 0) && (object = super.getDataContextValue((IEntity)pSDEActionWizard, "awpsdeid", iDataContextParam)) != null) {
                return object;
            }
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDEFIELD", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"AWSORTPSDEFID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"AWSORTPSDEFNAME", (boolean)true) == 0) && (object = super.getDataContextValue((IEntity)pSDEActionWizard, "awpsdeid", iDataContextParam)) != null) {
                return object;
            }
        }
        if ((object = super.getDataContextValue((IEntity)pSDEActionWizard, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDEActionWizard pSDEActionWizard, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDEActionWizard, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"AWICONTENTPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AWIContentPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AWICONTENTPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AWIContentPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AWIFKEYPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AWIFKeyPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AWIFKEYPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AWIFKeyPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AWINAMEPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AWINamePSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AWINAMEPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AWINamePSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AWIPSDEDSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AWIPSDEDSId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AWIPSDEDSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AWIPSDEDSName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AWIPSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AWIPSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AWIPSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AWIPSDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AWISORTPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AWISortPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AWISORTPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AWISortPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AWIURLPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AWIUrlPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AWIURLPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AWIUrlPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AWIVALUEPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AWIValuePSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AWIVALUEPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AWIValuePSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AWKWPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AWKWPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AWKWPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AWKWPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AWNAMEPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AWNamePSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AWNAMEPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AWNamePSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AWPSDEDSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AWPSDEDSId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AWPSDEDSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AWPSDEDSName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AWPSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AWPSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AWPSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AWPSDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AWSORTPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AWSortPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AWSORTPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AWSortPSDEFName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"DYNAMICMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynamicMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"KEYWORDS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Keywords_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOCKFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LockFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEACTIONWIZARDID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEActionWizardId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEACTIONWIZARDNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEActionWizardName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVIEWBASEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEViewBaseId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVIEWBASENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEViewBaseName_Default(iEntity, bl, bl2);
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
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_AWIContentPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AWICONTENTPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AWIContentPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AWICONTENTPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AWIFKeyPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AWIFKEYPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AWIFKeyPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AWIFKEYPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AWINamePSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AWINAMEPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AWINamePSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AWINAMEPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AWIPSDEDSId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AWIPSDEDSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AWIPSDEDSName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AWIPSDEDSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AWIPSDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AWIPSDEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AWIPSDEName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AWIPSDENAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AWISortPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AWISORTPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AWISortPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AWISORTPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AWIUrlPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AWIURLPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AWIUrlPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AWIURLPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AWIValuePSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AWIVALUEPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AWIValuePSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AWIVALUEPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AWKWPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AWKWPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AWKWPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AWKWPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AWNamePSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AWNAMEPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AWNamePSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AWNAMEPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AWPSDEDSId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AWPSDEDSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AWPSDEDSName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AWPSDEDSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AWPSDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AWPSDEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AWPSDEName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AWPSDENAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AWSortPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AWSORTPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AWSortPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AWSORTPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
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

    protected String onTestValueRule_DynamicMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Keywords_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("KEYWORDS", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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
            if (this.checkFieldStringLengthRule("MEMO", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEActionWizardId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEACTIONWIZARDID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEActionWizardName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEACTIONWIZARDNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSDEActionWizard pSDEActionWizard) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDEActionWizard)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDEActionWizard pSDEActionWizard) throws Exception {
        Object object = pSDEActionWizard.get("PSDEID");
        if (object != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSDEACTIONWIZARD_PSDATAENTITY_PSDEID", object);
        }
        super.onUpdateParent((IEntity)pSDEActionWizard);
    }

    protected boolean isNeedUpdateParent() {
        return true;
    }

    protected void onCopyDetails(PSDEActionWizard pSDEActionWizard, Object object) throws Exception {
        PSDEActionWizard pSDEActionWizard2 = new PSDEActionWizard();
        pSDEActionWizard2.set("PSDEACTIONWIZARDID", object);
        String string = DataObject.getStringValue((Object)pSDEActionWizard.get("PSDEACTIONWIZARDID"));
        super.onCopyDetails((IEntity)pSDEActionWizard, object);
    }

    @Override
    protected void exportCurXmlModel(PSDEActionWizard pSDEActionWizard, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEACTIONWIZARD");
        if (!bl) {
            pSDEActionWizard.setCreateDate(null);
            pSDEActionWizard.setCreateMan(null);
            pSDEActionWizard.setPSDEActionWizardId(null);
            pSDEActionWizard.setUpdateDate(null);
            pSDEActionWizard.setUpdateMan(null);
            super.exportCurXmlModel(pSDEActionWizard, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSDEActionWizard pSDEActionWizard, XmlNode xmlNode) throws Exception {
        this.exportRelatedXmlModel_PSDEAWItem(pSDEActionWizard, xmlNode);
        super.onExportRelatedXmlModel(pSDEActionWizard, xmlNode);
    }

    protected void exportRelatedXmlModel_PSDEAWItem(PSDEActionWizard pSDEActionWizard, XmlNode xmlNode) throws Exception {
        PSDEAWItemService pSDEAWItemService = (PSDEAWItemService)ServiceGlobal.getService(PSDEAWItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEAWItem> arrayList = null;
        String string = pSDEActionWizard.getPSDEActionWizardId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEAWItemService.selectByPSDEActionWizard(pSDEActionWizard, "ORDER BY ORDERVALUE ASC") : pSDEAWItemService.selectTempByPSDEActionWizard(pSDEActionWizard, "ORDER BY ORDERVALUE ASC");
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSDEAWITEMS");
            xmlNode.addNode(xmlNode2);
            for (PSDEAWItem pSDEAWItem : arrayList) {
                pSDEAWItem.set("ORDERVALUE", null);
                pSDEAWItemService.exportXmlModel(pSDEAWItem, xmlNode2);
            }
        }
    }

    @Override
    protected void onImportRelatedXmlModel(PSDEActionWizard pSDEActionWizard, XmlNode xmlNode) throws Exception {
        XmlNode xmlNode2 = xmlNode.getChildNodeByNodeName("PSDEAWITEMS");
        this.importRelatedXmlModel_PSDEAWItem(pSDEActionWizard, xmlNode2);
        super.onImportRelatedXmlModel(pSDEActionWizard, xmlNode);
    }

    protected void importRelatedXmlModel_PSDEAWItem(PSDEActionWizard pSDEActionWizard, XmlNode xmlNode) throws Exception {
        int n = 100;
        PSDEAWItemService pSDEAWItemService = (PSDEAWItemService)ServiceGlobal.getService(PSDEAWItemService.class, (SessionFactory)this.getSessionFactory());
        String string = pSDEActionWizard.getPSDEActionWizardId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSDEAWItemService.removeByPSDEActionWizard(pSDEActionWizard);
        } else {
            pSDEAWItemService.removeTempByPSDEActionWizard(pSDEActionWizard);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSDEAWItem pSDEAWItem = new PSDEAWItem();
                pSDEAWItem.setOrderValue(n);
                n += 100;
                pSDEAWItemService.fillParentInfo((IEntity)pSDEAWItem, "DER1N", "DER1N_PSDEAWITEM_PSDEACTIONWIZARD_PSDEACTIONWIZARDID", pSDEActionWizard.getPSDEActionWizardId());
                pSDEAWItemService.importXmlModel(pSDEAWItem, xmlNode2);
            }
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDEActionWizard pSDEActionWizard, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDEActionWizard, string);
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
            return "DER1N_PSDEACTIONWIZARD_PSDATAENTITY_PSDEID";
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
    public String getModelV2Tag(PSDEActionWizard pSDEActionWizard) {
        if (!StringHelper.isNullOrEmpty((String)pSDEActionWizard.getCodeName())) {
            return pSDEActionWizard.getCodeName();
        }
        return super.getModelV2Tag(pSDEActionWizard);
    }

    @Override
    public boolean setModelV2Tag(PSDEActionWizard pSDEActionWizard, String string) {
        return super.setModelV2Tag(pSDEActionWizard, string);
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
    public boolean getModelV2Entity(PSDEActionWizard pSDEActionWizard, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDEActionWizard.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDEActionWizard, true);
        pSDEActionWizard.set("CODENAME", string);
        if (this.select(pSDEActionWizard, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSDEActionWizard, true);
        return super.getModelV2Entity(pSDEActionWizard, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDEActionWizard pSDEActionWizard, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSDEActionWizard, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        return StringHelper.compare((String)"DER1N_PSDEAWITEM_PSDEACTIONWIZARD_PSDEACTIONWIZARDID", (String)string, (boolean)true) != 0;
    }

    @Override
    protected void onExportRelatedModelV2(PSDEActionWizard pSDEActionWizard, String string, String string2) throws Exception {
        Object var4_4 = null;
        super.onExportRelatedModelV2(pSDEActionWizard, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSDEActionWizard pSDEActionWizard, ObjectNode objectNode, String string, boolean bl) throws Exception {
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDEAWITEM_PSDEACTIONWIZARD_PSDEACTIONWIZARDID")) {
            Object object;
            PSDEAWItem pSDEAWItem2;
            Object object2;
            Object object3;
            Object object4;
            PSDEAWItemService pSDEAWItemService = (PSDEAWItemService)ServiceGlobal.getService(PSDEAWItemService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<PSDEAWItem> arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDEACTIONWIZARD#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDEAWITEM", (Object)pSDEActionWizard.getPSDEActionWizardId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty((String)object2)) continue;
                        pSDEAWItem2 = (ObjectNode)JsonNodeHelper.fromString((String)object2);
                        arrayList.add(pSDEAWItem2);
                    }
                }
            } else {
                arrayList = new ArrayList<PSDEAWItem>();
                object4 = pSDEAWItemService.selectByPSDEActionWizard(pSDEActionWizard);
                object3 = StringHelper.format((String)"PSDEACTIONWIZARD#%1$s", (Object)pSDEActionWizard.getPSDEActionWizardId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    pSDEAWItem2 = object2.next();
                    object = pSDEAWItemService.getModelV2ResScope((IEntity)pSDEAWItem2);
                    if (StringHelper.compare((String)object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSDEAWItem)PSModelV2Helper.toJSONObject((IEntity)pSDEAWItem2, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                object4 = pSDEAWItemService.getModelV2Name(false);
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
                        if (objectNode.has("psdeawitemname")) {
                            string = objectNode.get("psdeawitemname").asText();
                        }
                        if (objectNode2.has("psdeawitemname")) {
                            string2 = objectNode2.get("psdeawitemname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (PSDEAWItem pSDEAWItem2 : arrayList) {
                    object = new PSDEAWItem();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)pSDEAWItem2, false);
                    object3.add((JsonNode)pSDEAWItemService.exportModelV2(object, string));
                }
            }
        }
        super.onExportCurModelV2(pSDEActionWizard, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSDEActionWizard pSDEActionWizard) throws Exception {
        PSDEAWItemService pSDEAWItemService = (PSDEAWItemService)ServiceGlobal.getService(PSDEAWItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEAWItem> arrayList = pSDEAWItemService.selectByPSDEActionWizard(pSDEActionWizard);
        String string = StringHelper.format((String)"PSDEACTIONWIZARD#%1$s", (Object)pSDEActionWizard.getPSDEActionWizardId());
        for (PSDEAWItem pSDEAWItem : arrayList) {
            String string2 = pSDEAWItemService.getModelV2ResScope((IEntity)pSDEAWItem);
            if (StringHelper.compare((String)string, (String)string2, (boolean)false) != 0) continue;
            pSDEAWItemService.emptyModelV2(pSDEAWItem);
        }
        SqlParamList sqlParamList = new SqlParamList();
        sqlParamList.addString(pSDEActionWizard.getPSDEActionWizardId());
        pSDEAWItemService.getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        pSDEAWItemService.getDAO().executeRawSql(null, "DELETE FROM T_SRFPSDEAWITEM WHERE PSDEACTIONWIZARDID = ?", sqlParamList);
        super.onEmptyModelV2(pSDEActionWizard);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSDEAWItemService pSDEAWItemService = (PSDEAWItemService)ServiceGlobal.getService(PSDEAWItemService.class, (SessionFactory)this.getSessionFactory());
        if (pSDEAWItemService.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSDEActionWizard pSDEActionWizard, String string, String string2) throws Exception {
        IEntity iEntity = null;
        PSDEAWItem pSDEAWItem = new PSDEAWItem();
        pSDEAWItem.set("PSDEACTIONWIZARDID", pSDEActionWizard.getPSDEActionWizardId());
        PSDEAWItemService pSDEAWItemService = (PSDEAWItemService)ServiceGlobal.getService(PSDEAWItemService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSDEAWItemService.getModelV2Entity(pSDEAWItem, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSDEActionWizard, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSDEActionWizard pSDEActionWizard, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        PSDEAWItemService pSDEAWItemService = (PSDEAWItemService)ServiceGlobal.getService(PSDEAWItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayNode arrayNode = null;
        String string3 = pSDEAWItemService.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                ObjectNode objectNode2 = (ObjectNode)arrayNode.get(i);
                PSDEAWItem pSDEAWItem = new PSDEAWItem();
                pSDEAWItem.setPSDEActionWizardId(pSDEActionWizard.getPSDEActionWizardId());
                pSDEAWItem.setPSDEActionWizardName(pSDEActionWizard.getPSDEActionWizardName());
                pSDEAWItemService.compileModelV2(pSDEAWItem, objectNode2, string, null, n);
            }
        } else {
            String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            File file = new File(string4);
            if (file.exists()) {
                File[] fileArray;
                for (File file2 : fileArray = file.listFiles()) {
                    if (!file2.isDirectory()) continue;
                    PSDEAWItem pSDEAWItem = new PSDEAWItem();
                    pSDEAWItem.setPSDEActionWizardId(pSDEActionWizard.getPSDEActionWizardId());
                    pSDEAWItem.setPSDEActionWizardName(pSDEActionWizard.getPSDEActionWizardName());
                    pSDEAWItemService.compileModelV2(pSDEAWItem, null, string, file2.getCanonicalPath(), n);
                }
            }
        }
        super.onCompileRelatedModelV2(pSDEActionWizard, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSDEActionWizard pSDEActionWizard, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSDEAWITEM_PSDEACTIONWIZARD_PSDEACTIONWIZARDID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSDEAWItems(pSDEActionWizard, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSDEActionWizard, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSDEAWItems(PSDEActionWizard pSDEActionWizard, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDEAWITEM", true), (boolean)false) == 0) {
            PSDEAWItemService pSDEAWItemService = (PSDEAWItemService)ServiceGlobal.getService(PSDEAWItemService.class, (SessionFactory)this.getSessionFactory());
            PSDEAWItem pSDEAWItem = new PSDEAWItem();
            pSDEAWItem.setPSDEAWItemId(pSMOSFile.getPSModelId());
            if (!pSDEAWItemService.get((IEntity)pSDEAWItem, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSDEAWItem.getPSDEActionWizardId(), (String)pSDEActionWizard.getPSDEActionWizardId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSDEAWItemService.exportModelV2(pSDEAWItem);
            pSDEAWItem.reset();
            if (!pSDEAWItemService.setModelV2ResScope((IEntity)pSDEAWItem, "PSDEACTIONWIZARD", pSDEActionWizard.getPSDEActionWizardId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSDEAWItemService.importModelV2(pSDEAWItem, objectNode);
            SessionFactoryManager.commit();
            return pSDEAWItemService.getFile((IEntity)pSDEAWItem);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSDEActionWizard pSDEActionWizard, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSDEAWItems(pSDEActionWizard, list);
        super.onFillPasteHelps(pSDEActionWizard, list);
    }

    protected void onFillPasteHelps_PSDEAWItems(PSDEActionWizard pSDEActionWizard, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDEAWITEM");
        pSHelpSection.setSectionParam2("DER1N_PSDEAWITEM_PSDEACTIONWIZARD_PSDEACTIONWIZARDID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5b9e\u4f53\u64cd\u4f5c\u5411\u5bfc]\u7684[\u5b9e\u4f53\u64cd\u4f5c\u5411\u5bfc\u9879]");
        list.add(pSHelpSection);
    }
}

