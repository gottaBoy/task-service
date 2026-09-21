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
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringBuilderEx
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
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.dao.PSDEUtilDEDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEUtilDEDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUtilDE;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicNodeService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysServiceAPI;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysServiceAPIBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPluginBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEUtilDEServiceBase
extends PSCoreSysServiceBase<PSDEUtilDE> {
    private static final Log log = LogFactory.getLog(PSDEUtilDEServiceBase.class);
    public static final String DATASET_CURDE = "CurDE";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String DATASET_FORMTYPE = "FormType";
    private PSDEUtilDEDEModel pSDEUtilDEDEModel;
    private PSDEUtilDEDAO pSDEUtilDEDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEUtilDEService";
    }

    public PSDEUtilDEDEModel getPSDEUtilDEDEModel() {
        if (this.pSDEUtilDEDEModel == null) {
            try {
                this.pSDEUtilDEDEModel = (PSDEUtilDEDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEUtilDEDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEUtilDEDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEUtilDEDEModel();
    }

    public PSDEUtilDEDAO getPSDEUtilDEDAO() {
        if (this.pSDEUtilDEDAO == null) {
            try {
                this.pSDEUtilDEDAO = (PSDEUtilDEDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDEUtilDEDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEUtilDEDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEUtilDEDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURDE, (boolean)true) == 0) {
            return this.fetchCurDE(iDEDataSetFetchContext);
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

    public DBFetchResult fetchCurDE(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDE, false);
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

    protected void onFillParentInfo(PSDEUtilDE pSDEUtilDE, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEUTILDE_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSDEUtilDE, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEUTILDE_PSDATAENTITY_UTILPSDE10ID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_UtilPSDE10(pSDEUtilDE, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEUTILDE_PSDATAENTITY_UTILPSDE11ID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_UtilPSDE11(pSDEUtilDE, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEUTILDE_PSDATAENTITY_UTILPSDE12ID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_UtilPSDE12(pSDEUtilDE, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEUTILDE_PSDATAENTITY_UTILPSDE13ID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_UtilPSDE13(pSDEUtilDE, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEUTILDE_PSDATAENTITY_UTILPSDE14ID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_UtilPSDE14(pSDEUtilDE, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEUTILDE_PSDATAENTITY_UTILPSDE15ID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_UtilPSDE15(pSDEUtilDE, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEUTILDE_PSDATAENTITY_UTILPSDE16ID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_UtilPSDE16(pSDEUtilDE, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEUTILDE_PSDATAENTITY_UTILPSDE17ID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_UtilPSDE17(pSDEUtilDE, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEUTILDE_PSDATAENTITY_UTILPSDE18ID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_UtilPSDE18(pSDEUtilDE, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEUTILDE_PSDATAENTITY_UTILPSDE19ID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_UtilPSDE19(pSDEUtilDE, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEUTILDE_PSDATAENTITY_UTILPSDE20ID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_UtilPSDE20(pSDEUtilDE, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEUTILDE_PSDATAENTITY_UTILPSDE2ID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_UtilPSDE2(pSDEUtilDE, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEUTILDE_PSDATAENTITY_UTILPSDE3ID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_UtilPSDE3(pSDEUtilDE, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEUTILDE_PSDATAENTITY_UTILPSDE4ID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_UtilPSDE4(pSDEUtilDE, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEUTILDE_PSDATAENTITY_UTILPSDE5ID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_UtilPSDE5(pSDEUtilDE, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEUTILDE_PSDATAENTITY_UTILPSDE6ID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_UtilPSDE6(pSDEUtilDE, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEUTILDE_PSDATAENTITY_UTILPSDE7ID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_UtilPSDE7(pSDEUtilDE, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEUTILDE_PSDATAENTITY_UTILPSDE8ID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_UtilPSDE8(pSDEUtilDE, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEUTILDE_PSDATAENTITY_UTILPSDE9ID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_UtilPSDE9(pSDEUtilDE, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEUTILDE_PSDATAENTITY_UTILPSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_UtilPSDE(pSDEUtilDE, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEUTILDE_PSSUBSYSSERVICEAPI_PSSUBSYSSERVICEAPIID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSubSysServiceAPIService", (SessionFactory)this.getSessionFactory());
            PSSubSysServiceAPI pSSubSysServiceAPI = (PSSubSysServiceAPI)iService.getDEModel().createEntity();
            pSSubSysServiceAPI.set("PSSUBSYSSERVICEAPIID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSubSysServiceAPI);
            } else {
                iService.get((IEntity)pSSubSysServiceAPI);
            }
            this.onFillParentInfo_PSSubSysServiceAPI(pSDEUtilDE, pSSubSysServiceAPI);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEUTILDE_PSSYSDYNAMODEL_PSSYSDYNAMODELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService", (SessionFactory)this.getSessionFactory());
            PSSysDynaModel pSSysDynaModel = (PSSysDynaModel)iService.getDEModel().createEntity();
            pSSysDynaModel.set("PSSYSDYNAMODELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysDynaModel);
            } else {
                iService.get((IEntity)pSSysDynaModel);
            }
            this.onFillParentInfo_PSSysDynaModel(pSDEUtilDE, pSSysDynaModel);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEUTILDE_PSSYSSFPLUGIN_PSSYSSFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysSFPlugin pSSysSFPlugin = (PSSysSFPlugin)iService.getDEModel().createEntity();
            pSSysSFPlugin.set("PSSYSSFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysSFPlugin);
            } else {
                iService.get((IEntity)pSSysSFPlugin);
            }
            this.onFillParentInfo_PSSysSFPlugin(pSDEUtilDE, pSSysSFPlugin);
            return;
        }
        super.onFillParentInfo((IEntity)pSDEUtilDE, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDE(PSDEUtilDE pSDEUtilDE, PSDataEntity pSDataEntity) throws Exception {
        pSDEUtilDE.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSDEUtilDE.setPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_UtilPSDE10(PSDEUtilDE pSDEUtilDE, PSDataEntity pSDataEntity) throws Exception {
        pSDEUtilDE.setUtilPSDE10Id(pSDataEntity.getPSDataEntityId());
        pSDEUtilDE.setUtilPSDE10Name(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_UtilPSDE11(PSDEUtilDE pSDEUtilDE, PSDataEntity pSDataEntity) throws Exception {
        pSDEUtilDE.setUtilPSDE11Id(pSDataEntity.getPSDataEntityId());
        pSDEUtilDE.setUtilPSDE11Name(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_UtilPSDE12(PSDEUtilDE pSDEUtilDE, PSDataEntity pSDataEntity) throws Exception {
        pSDEUtilDE.setUtilPSDE12Id(pSDataEntity.getPSDataEntityId());
        pSDEUtilDE.setUtilPSDE12Name(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_UtilPSDE13(PSDEUtilDE pSDEUtilDE, PSDataEntity pSDataEntity) throws Exception {
        pSDEUtilDE.setUtilPSDE13Id(pSDataEntity.getPSDataEntityId());
        pSDEUtilDE.setUtilPSDE13Name(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_UtilPSDE14(PSDEUtilDE pSDEUtilDE, PSDataEntity pSDataEntity) throws Exception {
        pSDEUtilDE.setUtilPSDE14Id(pSDataEntity.getPSDataEntityId());
        pSDEUtilDE.setUtilPSDE14Name(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_UtilPSDE15(PSDEUtilDE pSDEUtilDE, PSDataEntity pSDataEntity) throws Exception {
        pSDEUtilDE.setUtilPSDE15Id(pSDataEntity.getPSDataEntityId());
        pSDEUtilDE.setUtilPSDE15Name(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_UtilPSDE16(PSDEUtilDE pSDEUtilDE, PSDataEntity pSDataEntity) throws Exception {
        pSDEUtilDE.setUtilPSDE16Id(pSDataEntity.getPSDataEntityId());
        pSDEUtilDE.setUtilPSDE16Name(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_UtilPSDE17(PSDEUtilDE pSDEUtilDE, PSDataEntity pSDataEntity) throws Exception {
        pSDEUtilDE.setUtilPSDE17Id(pSDataEntity.getPSDataEntityId());
        pSDEUtilDE.setUtilPSDE17Name(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_UtilPSDE18(PSDEUtilDE pSDEUtilDE, PSDataEntity pSDataEntity) throws Exception {
        pSDEUtilDE.setUtilPSDE18Id(pSDataEntity.getPSDataEntityId());
        pSDEUtilDE.setUtilPSDE18Name(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_UtilPSDE19(PSDEUtilDE pSDEUtilDE, PSDataEntity pSDataEntity) throws Exception {
        pSDEUtilDE.setUtilPSDE19Id(pSDataEntity.getPSDataEntityId());
        pSDEUtilDE.setUtilPSDE19Name(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_UtilPSDE20(PSDEUtilDE pSDEUtilDE, PSDataEntity pSDataEntity) throws Exception {
        pSDEUtilDE.setUtilPSDE20Id(pSDataEntity.getPSDataEntityId());
        pSDEUtilDE.setUtilPSDE20Name(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_UtilPSDE2(PSDEUtilDE pSDEUtilDE, PSDataEntity pSDataEntity) throws Exception {
        pSDEUtilDE.setUtilPSDE2Id(pSDataEntity.getPSDataEntityId());
        pSDEUtilDE.setUtilPSDE2Name(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_UtilPSDE3(PSDEUtilDE pSDEUtilDE, PSDataEntity pSDataEntity) throws Exception {
        pSDEUtilDE.setUtilPSDE3Id(pSDataEntity.getPSDataEntityId());
        pSDEUtilDE.setUtilPSDE3Name(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_UtilPSDE4(PSDEUtilDE pSDEUtilDE, PSDataEntity pSDataEntity) throws Exception {
        pSDEUtilDE.setUtilPSDE4Id(pSDataEntity.getPSDataEntityId());
        pSDEUtilDE.setUtilPSDE4Name(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_UtilPSDE5(PSDEUtilDE pSDEUtilDE, PSDataEntity pSDataEntity) throws Exception {
        pSDEUtilDE.setUtilPSDE5Id(pSDataEntity.getPSDataEntityId());
        pSDEUtilDE.setUtilPSDE5Name(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_UtilPSDE6(PSDEUtilDE pSDEUtilDE, PSDataEntity pSDataEntity) throws Exception {
        pSDEUtilDE.setUtilPSDE6Id(pSDataEntity.getPSDataEntityId());
        pSDEUtilDE.setUtilPSDE6Name(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_UtilPSDE7(PSDEUtilDE pSDEUtilDE, PSDataEntity pSDataEntity) throws Exception {
        pSDEUtilDE.setUtilPSDE7Id(pSDataEntity.getPSDataEntityId());
        pSDEUtilDE.setUtilPSDE7Name(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_UtilPSDE8(PSDEUtilDE pSDEUtilDE, PSDataEntity pSDataEntity) throws Exception {
        pSDEUtilDE.setUtilPSDE8Id(pSDataEntity.getPSDataEntityId());
        pSDEUtilDE.setUtilPSDE8Name(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_UtilPSDE9(PSDEUtilDE pSDEUtilDE, PSDataEntity pSDataEntity) throws Exception {
        pSDEUtilDE.setUtilPSDE9Id(pSDataEntity.getPSDataEntityId());
        pSDEUtilDE.setUtilPSDE9Name(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_UtilPSDE(PSDEUtilDE pSDEUtilDE, PSDataEntity pSDataEntity) throws Exception {
        pSDEUtilDE.setUtilPSDEId(pSDataEntity.getPSDataEntityId());
        pSDEUtilDE.setUtilPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_PSSubSysServiceAPI(PSDEUtilDE pSDEUtilDE, PSSubSysServiceAPI pSSubSysServiceAPI) throws Exception {
        pSDEUtilDE.setPSSubSysServiceAPIId(pSSubSysServiceAPI.getPSSubSysServiceAPIId());
        pSDEUtilDE.setPSSubSysServiceAPIName(pSSubSysServiceAPI.getPSSubSysServiceAPIName());
    }

    protected void onFillParentInfo_PSSysDynaModel(PSDEUtilDE pSDEUtilDE, PSSysDynaModel pSSysDynaModel) throws Exception {
        pSDEUtilDE.setPSSysDynaModelId(pSSysDynaModel.getPSSysDynaModelId());
        pSDEUtilDE.setPSSysDynaModelName(pSSysDynaModel.getPSSysDynaModelName());
    }

    protected void onFillParentInfo_PSSysSFPlugin(PSDEUtilDE pSDEUtilDE, PSSysSFPlugin pSSysSFPlugin) throws Exception {
        pSDEUtilDE.setPSSysSFPluginId(pSSysSFPlugin.getPSSysSFPluginId());
        pSDEUtilDE.setPSSysSFPluginName(pSSysSFPlugin.getPSSysSFPluginName());
    }

    protected boolean onFillEntityKeyValue(PSDEUtilDE pSDEUtilDE, boolean bl) throws Exception {
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        Object object = pSDEUtilDE.get("PSDEID");
        if (object == null) {
            object = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object);
        stringBuilderEx.append("||");
        Object object2 = pSDEUtilDE.get("UTILTYPE");
        if (object2 == null) {
            object2 = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object2);
        stringBuilderEx.append("||");
        Object object3 = pSDEUtilDE.get("UTILTAG");
        if (object3 == null) {
            object3 = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object3);
        String string = stringBuilderEx.toString();
        pSDEUtilDE.set(this.getPSDEUtilDEDEModel().getKeyDEField().getName(), KeyValueHelper.genUniqueId((String)string));
        return true;
    }

    protected void onFillEntityFullInfo(PSDEUtilDE pSDEUtilDE, boolean bl) throws Exception {
        if (bl && pSDEUtilDE.getValidFlag() == null) {
            pSDEUtilDE.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo((IEntity)pSDEUtilDE, bl);
        this.onFillEntityFullInfo_PSDE(pSDEUtilDE, bl);
        this.onFillEntityFullInfo_UtilPSDE10(pSDEUtilDE, bl);
        this.onFillEntityFullInfo_UtilPSDE11(pSDEUtilDE, bl);
        this.onFillEntityFullInfo_UtilPSDE12(pSDEUtilDE, bl);
        this.onFillEntityFullInfo_UtilPSDE13(pSDEUtilDE, bl);
        this.onFillEntityFullInfo_UtilPSDE14(pSDEUtilDE, bl);
        this.onFillEntityFullInfo_UtilPSDE15(pSDEUtilDE, bl);
        this.onFillEntityFullInfo_UtilPSDE16(pSDEUtilDE, bl);
        this.onFillEntityFullInfo_UtilPSDE17(pSDEUtilDE, bl);
        this.onFillEntityFullInfo_UtilPSDE18(pSDEUtilDE, bl);
        this.onFillEntityFullInfo_UtilPSDE19(pSDEUtilDE, bl);
        this.onFillEntityFullInfo_UtilPSDE20(pSDEUtilDE, bl);
        this.onFillEntityFullInfo_UtilPSDE2(pSDEUtilDE, bl);
        this.onFillEntityFullInfo_UtilPSDE3(pSDEUtilDE, bl);
        this.onFillEntityFullInfo_UtilPSDE4(pSDEUtilDE, bl);
        this.onFillEntityFullInfo_UtilPSDE5(pSDEUtilDE, bl);
        this.onFillEntityFullInfo_UtilPSDE6(pSDEUtilDE, bl);
        this.onFillEntityFullInfo_UtilPSDE7(pSDEUtilDE, bl);
        this.onFillEntityFullInfo_UtilPSDE8(pSDEUtilDE, bl);
        this.onFillEntityFullInfo_UtilPSDE9(pSDEUtilDE, bl);
        this.onFillEntityFullInfo_UtilPSDE(pSDEUtilDE, bl);
        this.onFillEntityFullInfo_PSSubSysServiceAPI(pSDEUtilDE, bl);
        this.onFillEntityFullInfo_PSSysDynaModel(pSDEUtilDE, bl);
        this.onFillEntityFullInfo_PSSysSFPlugin(pSDEUtilDE, bl);
    }

    protected void onFillEntityFullInfo_PSDE(PSDEUtilDE pSDEUtilDE, boolean bl) throws Exception {
        if (pSDEUtilDE.isPSDEIdDirty()) {
            if (pSDEUtilDE.getPSDEId() != null) {
                if (pSDEUtilDE.getPSDEId() == null || pSDEUtilDE.getPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSDEUtilDE.getPSDE();
                    pSDEUtilDE.setPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSDEUtilDE.setPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_UtilPSDE10(PSDEUtilDE pSDEUtilDE, boolean bl) throws Exception {
        if (pSDEUtilDE.isUtilPSDE10IdDirty()) {
            if (pSDEUtilDE.getUtilPSDE10Id() != null) {
                if (pSDEUtilDE.getUtilPSDE10Id() == null || pSDEUtilDE.getUtilPSDE10Name() == null) {
                    PSDataEntity pSDataEntity = pSDEUtilDE.getUtilPSDE10();
                    pSDEUtilDE.setUtilPSDE10Name(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSDEUtilDE.setUtilPSDE10Name(null);
            }
        }
    }

    protected void onFillEntityFullInfo_UtilPSDE11(PSDEUtilDE pSDEUtilDE, boolean bl) throws Exception {
        if (pSDEUtilDE.isUtilPSDE11IdDirty()) {
            if (pSDEUtilDE.getUtilPSDE11Id() != null) {
                if (pSDEUtilDE.getUtilPSDE11Id() == null || pSDEUtilDE.getUtilPSDE11Name() == null) {
                    PSDataEntity pSDataEntity = pSDEUtilDE.getUtilPSDE11();
                    pSDEUtilDE.setUtilPSDE11Name(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSDEUtilDE.setUtilPSDE11Name(null);
            }
        }
    }

    protected void onFillEntityFullInfo_UtilPSDE12(PSDEUtilDE pSDEUtilDE, boolean bl) throws Exception {
        if (pSDEUtilDE.isUtilPSDE12IdDirty()) {
            if (pSDEUtilDE.getUtilPSDE12Id() != null) {
                if (pSDEUtilDE.getUtilPSDE12Id() == null || pSDEUtilDE.getUtilPSDE12Name() == null) {
                    PSDataEntity pSDataEntity = pSDEUtilDE.getUtilPSDE12();
                    pSDEUtilDE.setUtilPSDE12Name(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSDEUtilDE.setUtilPSDE12Name(null);
            }
        }
    }

    protected void onFillEntityFullInfo_UtilPSDE13(PSDEUtilDE pSDEUtilDE, boolean bl) throws Exception {
        if (pSDEUtilDE.isUtilPSDE13IdDirty()) {
            if (pSDEUtilDE.getUtilPSDE13Id() != null) {
                if (pSDEUtilDE.getUtilPSDE13Id() == null || pSDEUtilDE.getUtilPSDE13Name() == null) {
                    PSDataEntity pSDataEntity = pSDEUtilDE.getUtilPSDE13();
                    pSDEUtilDE.setUtilPSDE13Name(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSDEUtilDE.setUtilPSDE13Name(null);
            }
        }
    }

    protected void onFillEntityFullInfo_UtilPSDE14(PSDEUtilDE pSDEUtilDE, boolean bl) throws Exception {
        if (pSDEUtilDE.isUtilPSDE14IdDirty()) {
            if (pSDEUtilDE.getUtilPSDE14Id() != null) {
                if (pSDEUtilDE.getUtilPSDE14Id() == null || pSDEUtilDE.getUtilPSDE14Name() == null) {
                    PSDataEntity pSDataEntity = pSDEUtilDE.getUtilPSDE14();
                    pSDEUtilDE.setUtilPSDE14Name(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSDEUtilDE.setUtilPSDE14Name(null);
            }
        }
    }

    protected void onFillEntityFullInfo_UtilPSDE15(PSDEUtilDE pSDEUtilDE, boolean bl) throws Exception {
        if (pSDEUtilDE.isUtilPSDE15IdDirty()) {
            if (pSDEUtilDE.getUtilPSDE15Id() != null) {
                if (pSDEUtilDE.getUtilPSDE15Id() == null || pSDEUtilDE.getUtilPSDE15Name() == null) {
                    PSDataEntity pSDataEntity = pSDEUtilDE.getUtilPSDE15();
                    pSDEUtilDE.setUtilPSDE15Name(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSDEUtilDE.setUtilPSDE15Name(null);
            }
        }
    }

    protected void onFillEntityFullInfo_UtilPSDE16(PSDEUtilDE pSDEUtilDE, boolean bl) throws Exception {
        if (pSDEUtilDE.isUtilPSDE16IdDirty()) {
            if (pSDEUtilDE.getUtilPSDE16Id() != null) {
                if (pSDEUtilDE.getUtilPSDE16Id() == null || pSDEUtilDE.getUtilPSDE16Name() == null) {
                    PSDataEntity pSDataEntity = pSDEUtilDE.getUtilPSDE16();
                    pSDEUtilDE.setUtilPSDE16Name(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSDEUtilDE.setUtilPSDE16Name(null);
            }
        }
    }

    protected void onFillEntityFullInfo_UtilPSDE17(PSDEUtilDE pSDEUtilDE, boolean bl) throws Exception {
        if (pSDEUtilDE.isUtilPSDE17IdDirty()) {
            if (pSDEUtilDE.getUtilPSDE17Id() != null) {
                if (pSDEUtilDE.getUtilPSDE17Id() == null || pSDEUtilDE.getUtilPSDE17Name() == null) {
                    PSDataEntity pSDataEntity = pSDEUtilDE.getUtilPSDE17();
                    pSDEUtilDE.setUtilPSDE17Name(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSDEUtilDE.setUtilPSDE17Name(null);
            }
        }
    }

    protected void onFillEntityFullInfo_UtilPSDE18(PSDEUtilDE pSDEUtilDE, boolean bl) throws Exception {
        if (pSDEUtilDE.isUtilPSDE18IdDirty()) {
            if (pSDEUtilDE.getUtilPSDE18Id() != null) {
                if (pSDEUtilDE.getUtilPSDE18Id() == null || pSDEUtilDE.getUtilPSDE18Name() == null) {
                    PSDataEntity pSDataEntity = pSDEUtilDE.getUtilPSDE18();
                    pSDEUtilDE.setUtilPSDE18Name(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSDEUtilDE.setUtilPSDE18Name(null);
            }
        }
    }

    protected void onFillEntityFullInfo_UtilPSDE19(PSDEUtilDE pSDEUtilDE, boolean bl) throws Exception {
        if (pSDEUtilDE.isUtilPSDE19IdDirty()) {
            if (pSDEUtilDE.getUtilPSDE19Id() != null) {
                if (pSDEUtilDE.getUtilPSDE19Id() == null || pSDEUtilDE.getUtilPSDE19Name() == null) {
                    PSDataEntity pSDataEntity = pSDEUtilDE.getUtilPSDE19();
                    pSDEUtilDE.setUtilPSDE19Name(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSDEUtilDE.setUtilPSDE19Name(null);
            }
        }
    }

    protected void onFillEntityFullInfo_UtilPSDE20(PSDEUtilDE pSDEUtilDE, boolean bl) throws Exception {
        if (pSDEUtilDE.isUtilPSDE20IdDirty()) {
            if (pSDEUtilDE.getUtilPSDE20Id() != null) {
                if (pSDEUtilDE.getUtilPSDE20Id() == null || pSDEUtilDE.getUtilPSDE20Name() == null) {
                    PSDataEntity pSDataEntity = pSDEUtilDE.getUtilPSDE20();
                    pSDEUtilDE.setUtilPSDE20Name(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSDEUtilDE.setUtilPSDE20Name(null);
            }
        }
    }

    protected void onFillEntityFullInfo_UtilPSDE2(PSDEUtilDE pSDEUtilDE, boolean bl) throws Exception {
        if (pSDEUtilDE.isUtilPSDE2IdDirty()) {
            if (pSDEUtilDE.getUtilPSDE2Id() != null) {
                if (pSDEUtilDE.getUtilPSDE2Id() == null || pSDEUtilDE.getUtilPSDE2Name() == null) {
                    PSDataEntity pSDataEntity = pSDEUtilDE.getUtilPSDE2();
                    pSDEUtilDE.setUtilPSDE2Name(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSDEUtilDE.setUtilPSDE2Name(null);
            }
        }
    }

    protected void onFillEntityFullInfo_UtilPSDE3(PSDEUtilDE pSDEUtilDE, boolean bl) throws Exception {
        if (pSDEUtilDE.isUtilPSDE3IdDirty()) {
            if (pSDEUtilDE.getUtilPSDE3Id() != null) {
                if (pSDEUtilDE.getUtilPSDE3Id() == null || pSDEUtilDE.getUtilPSDE3Name() == null) {
                    PSDataEntity pSDataEntity = pSDEUtilDE.getUtilPSDE3();
                    pSDEUtilDE.setUtilPSDE3Name(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSDEUtilDE.setUtilPSDE3Name(null);
            }
        }
    }

    protected void onFillEntityFullInfo_UtilPSDE4(PSDEUtilDE pSDEUtilDE, boolean bl) throws Exception {
        if (pSDEUtilDE.isUtilPSDE4IdDirty()) {
            if (pSDEUtilDE.getUtilPSDE4Id() != null) {
                if (pSDEUtilDE.getUtilPSDE4Id() == null || pSDEUtilDE.getUtilPSDE4Name() == null) {
                    PSDataEntity pSDataEntity = pSDEUtilDE.getUtilPSDE4();
                    pSDEUtilDE.setUtilPSDE4Name(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSDEUtilDE.setUtilPSDE4Name(null);
            }
        }
    }

    protected void onFillEntityFullInfo_UtilPSDE5(PSDEUtilDE pSDEUtilDE, boolean bl) throws Exception {
        if (pSDEUtilDE.isUtilPSDE5IdDirty()) {
            if (pSDEUtilDE.getUtilPSDE5Id() != null) {
                if (pSDEUtilDE.getUtilPSDE5Id() == null || pSDEUtilDE.getUtilPSDE5Name() == null) {
                    PSDataEntity pSDataEntity = pSDEUtilDE.getUtilPSDE5();
                    pSDEUtilDE.setUtilPSDE5Name(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSDEUtilDE.setUtilPSDE5Name(null);
            }
        }
    }

    protected void onFillEntityFullInfo_UtilPSDE6(PSDEUtilDE pSDEUtilDE, boolean bl) throws Exception {
        if (pSDEUtilDE.isUtilPSDE6IdDirty()) {
            if (pSDEUtilDE.getUtilPSDE6Id() != null) {
                if (pSDEUtilDE.getUtilPSDE6Id() == null || pSDEUtilDE.getUtilPSDE6Name() == null) {
                    PSDataEntity pSDataEntity = pSDEUtilDE.getUtilPSDE6();
                    pSDEUtilDE.setUtilPSDE6Name(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSDEUtilDE.setUtilPSDE6Name(null);
            }
        }
    }

    protected void onFillEntityFullInfo_UtilPSDE7(PSDEUtilDE pSDEUtilDE, boolean bl) throws Exception {
        if (pSDEUtilDE.isUtilPSDE7IdDirty()) {
            if (pSDEUtilDE.getUtilPSDE7Id() != null) {
                if (pSDEUtilDE.getUtilPSDE7Id() == null || pSDEUtilDE.getUtilPSDE7Name() == null) {
                    PSDataEntity pSDataEntity = pSDEUtilDE.getUtilPSDE7();
                    pSDEUtilDE.setUtilPSDE7Name(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSDEUtilDE.setUtilPSDE7Name(null);
            }
        }
    }

    protected void onFillEntityFullInfo_UtilPSDE8(PSDEUtilDE pSDEUtilDE, boolean bl) throws Exception {
        if (pSDEUtilDE.isUtilPSDE8IdDirty()) {
            if (pSDEUtilDE.getUtilPSDE8Id() != null) {
                if (pSDEUtilDE.getUtilPSDE8Id() == null || pSDEUtilDE.getUtilPSDE8Name() == null) {
                    PSDataEntity pSDataEntity = pSDEUtilDE.getUtilPSDE8();
                    pSDEUtilDE.setUtilPSDE8Name(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSDEUtilDE.setUtilPSDE8Name(null);
            }
        }
    }

    protected void onFillEntityFullInfo_UtilPSDE9(PSDEUtilDE pSDEUtilDE, boolean bl) throws Exception {
        if (pSDEUtilDE.isUtilPSDE9IdDirty()) {
            if (pSDEUtilDE.getUtilPSDE9Id() != null) {
                if (pSDEUtilDE.getUtilPSDE9Id() == null || pSDEUtilDE.getUtilPSDE9Name() == null) {
                    PSDataEntity pSDataEntity = pSDEUtilDE.getUtilPSDE9();
                    pSDEUtilDE.setUtilPSDE9Name(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSDEUtilDE.setUtilPSDE9Name(null);
            }
        }
    }

    protected void onFillEntityFullInfo_UtilPSDE(PSDEUtilDE pSDEUtilDE, boolean bl) throws Exception {
        if (pSDEUtilDE.isUtilPSDEIdDirty()) {
            if (pSDEUtilDE.getUtilPSDEId() != null) {
                if (pSDEUtilDE.getUtilPSDEId() == null || pSDEUtilDE.getUtilPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSDEUtilDE.getUtilPSDE();
                    pSDEUtilDE.setUtilPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSDEUtilDE.setUtilPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSubSysServiceAPI(PSDEUtilDE pSDEUtilDE, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysDynaModel(PSDEUtilDE pSDEUtilDE, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysSFPlugin(PSDEUtilDE pSDEUtilDE, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDEUtilDE pSDEUtilDE, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDEUtilDE, bl);
    }

    public ArrayList<PSDEUtilDE> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSDEUtilDE> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSDEUtilDE> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEUtilDE> selectByUtilPSDE10(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByUtilPSDE10(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSDEUtilDE> selectByUtilPSDE10(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByUtilPSDE10(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSDEUtilDE> selectByUtilPSDE10(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEUtilDE> selectByUtilPSDE11(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByUtilPSDE11(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSDEUtilDE> selectByUtilPSDE11(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByUtilPSDE11(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSDEUtilDE> selectByUtilPSDE11(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEUtilDE> selectByUtilPSDE12(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByUtilPSDE12(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSDEUtilDE> selectByUtilPSDE12(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByUtilPSDE12(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSDEUtilDE> selectByUtilPSDE12(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEUtilDE> selectByUtilPSDE13(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByUtilPSDE13(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSDEUtilDE> selectByUtilPSDE13(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByUtilPSDE13(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSDEUtilDE> selectByUtilPSDE13(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEUtilDE> selectByUtilPSDE14(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByUtilPSDE14(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSDEUtilDE> selectByUtilPSDE14(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByUtilPSDE14(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSDEUtilDE> selectByUtilPSDE14(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEUtilDE> selectByUtilPSDE15(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByUtilPSDE15(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSDEUtilDE> selectByUtilPSDE15(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByUtilPSDE15(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSDEUtilDE> selectByUtilPSDE15(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEUtilDE> selectByUtilPSDE16(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByUtilPSDE16(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSDEUtilDE> selectByUtilPSDE16(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByUtilPSDE16(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSDEUtilDE> selectByUtilPSDE16(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEUtilDE> selectByUtilPSDE17(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByUtilPSDE17(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSDEUtilDE> selectByUtilPSDE17(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByUtilPSDE17(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSDEUtilDE> selectByUtilPSDE17(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEUtilDE> selectByUtilPSDE18(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByUtilPSDE18(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSDEUtilDE> selectByUtilPSDE18(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByUtilPSDE18(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSDEUtilDE> selectByUtilPSDE18(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEUtilDE> selectByUtilPSDE19(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByUtilPSDE19(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSDEUtilDE> selectByUtilPSDE19(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByUtilPSDE19(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSDEUtilDE> selectByUtilPSDE19(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEUtilDE> selectByUtilPSDE20(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByUtilPSDE20(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSDEUtilDE> selectByUtilPSDE20(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByUtilPSDE20(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSDEUtilDE> selectByUtilPSDE20(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEUtilDE> selectByUtilPSDE2(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByUtilPSDE2(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSDEUtilDE> selectByUtilPSDE2(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByUtilPSDE2(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSDEUtilDE> selectByUtilPSDE2(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEUtilDE> selectByUtilPSDE3(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByUtilPSDE3(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSDEUtilDE> selectByUtilPSDE3(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByUtilPSDE3(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSDEUtilDE> selectByUtilPSDE3(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEUtilDE> selectByUtilPSDE4(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByUtilPSDE4(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSDEUtilDE> selectByUtilPSDE4(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByUtilPSDE4(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSDEUtilDE> selectByUtilPSDE4(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEUtilDE> selectByUtilPSDE5(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByUtilPSDE5(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSDEUtilDE> selectByUtilPSDE5(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByUtilPSDE5(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSDEUtilDE> selectByUtilPSDE5(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEUtilDE> selectByUtilPSDE6(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByUtilPSDE6(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSDEUtilDE> selectByUtilPSDE6(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByUtilPSDE6(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSDEUtilDE> selectByUtilPSDE6(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEUtilDE> selectByUtilPSDE7(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByUtilPSDE7(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSDEUtilDE> selectByUtilPSDE7(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByUtilPSDE7(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSDEUtilDE> selectByUtilPSDE7(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEUtilDE> selectByUtilPSDE8(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByUtilPSDE8(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSDEUtilDE> selectByUtilPSDE8(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByUtilPSDE8(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSDEUtilDE> selectByUtilPSDE8(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEUtilDE> selectByUtilPSDE9(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByUtilPSDE9(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSDEUtilDE> selectByUtilPSDE9(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByUtilPSDE9(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSDEUtilDE> selectByUtilPSDE9(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEUtilDE> selectByUtilPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByUtilPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSDEUtilDE> selectByUtilPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByUtilPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSDEUtilDE> selectByUtilPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEUtilDE> selectByPSSubSysServiceAPI(PSSubSysServiceAPIBase pSSubSysServiceAPIBase) throws Exception {
        return this.selectByPSSubSysServiceAPI(pSSubSysServiceAPIBase, "", -1);
    }

    public ArrayList<PSDEUtilDE> selectByPSSubSysServiceAPI(PSSubSysServiceAPIBase pSSubSysServiceAPIBase, String string) throws Exception {
        return this.selectByPSSubSysServiceAPI(pSSubSysServiceAPIBase, string, -1);
    }

    public ArrayList<PSDEUtilDE> selectByPSSubSysServiceAPI(PSSubSysServiceAPIBase pSSubSysServiceAPIBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEUtilDE> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, "", -1);
    }

    public ArrayList<PSDEUtilDE> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, string, -1);
    }

    public ArrayList<PSDEUtilDE> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEUtilDE> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, "", -1);
    }

    public ArrayList<PSDEUtilDE> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, string, -1);
    }

    public ArrayList<PSDEUtilDE> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string, int n) throws Exception {
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
        ArrayList<PSDEUtilDE> arrayList = this.selectByPSDE(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEUTILDE_PSDATAENTITY_PSDEID", "", iDataEntityModel.getName(), "PSDEUTILDE", iDataEntityModel.getDataInfo((IEntity)pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEUtilDE> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSDEUtilDE pSDEUtilDE : arrayList) {
            PSDEUtilDE pSDEUtilDE2 = (PSDEUtilDE)this.getDEModel().createEntity();
            pSDEUtilDE2.setPSDEUtilDEId(pSDEUtilDE.getPSDEUtilDEId());
            pSDEUtilDE2.setPSDEId(null);
            this.update(pSDEUtilDE2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEUtilDEServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSDEUtilDEServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSDEUtilDEServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEUtilDE> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSDEUtilDE pSDEUtilDE : arrayList) {
            this.remove((IEntity)pSDEUtilDE);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEUtilDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEUtilDE> arrayList) throws Exception {
    }

    public void testRemoveByUtilPSDE10(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEUtilDE> arrayList = this.selectByUtilPSDE10(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEUTILDE_PSDATAENTITY_UTILPSDE10ID", "", iDataEntityModel.getName(), "PSDEUTILDE", iDataEntityModel.getDataInfo((IEntity)pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetUtilPSDE10(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEUtilDE> arrayList = this.selectByUtilPSDE10(pSDataEntity);
        for (PSDEUtilDE pSDEUtilDE : arrayList) {
            PSDEUtilDE pSDEUtilDE2 = (PSDEUtilDE)this.getDEModel().createEntity();
            pSDEUtilDE2.setPSDEUtilDEId(pSDEUtilDE.getPSDEUtilDEId());
            pSDEUtilDE2.setUtilPSDE10Id(null);
            this.update(pSDEUtilDE2);
        }
    }

    public void removeByUtilPSDE10(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEUtilDEServiceBase.this.onBeforeRemoveByUtilPSDE10(pSDataEntity2);
                PSDEUtilDEServiceBase.this.internalRemoveByUtilPSDE10(pSDataEntity2);
                PSDEUtilDEServiceBase.this.onAfterRemoveByUtilPSDE10(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByUtilPSDE10(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByUtilPSDE10(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEUtilDE> arrayList = this.selectByUtilPSDE10(pSDataEntity);
        this.onBeforeRemoveByUtilPSDE10(pSDataEntity, arrayList);
        for (PSDEUtilDE pSDEUtilDE : arrayList) {
            this.remove((IEntity)pSDEUtilDE);
        }
        this.onAfterRemoveByUtilPSDE10(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByUtilPSDE10(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByUtilPSDE10(PSDataEntity pSDataEntity, ArrayList<PSDEUtilDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUtilPSDE10(PSDataEntity pSDataEntity, ArrayList<PSDEUtilDE> arrayList) throws Exception {
    }

    public void testRemoveByUtilPSDE11(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEUtilDE> arrayList = this.selectByUtilPSDE11(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEUTILDE_PSDATAENTITY_UTILPSDE11ID", "", iDataEntityModel.getName(), "PSDEUTILDE", iDataEntityModel.getDataInfo((IEntity)pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetUtilPSDE11(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEUtilDE> arrayList = this.selectByUtilPSDE11(pSDataEntity);
        for (PSDEUtilDE pSDEUtilDE : arrayList) {
            PSDEUtilDE pSDEUtilDE2 = (PSDEUtilDE)this.getDEModel().createEntity();
            pSDEUtilDE2.setPSDEUtilDEId(pSDEUtilDE.getPSDEUtilDEId());
            pSDEUtilDE2.setUtilPSDE11Id(null);
            this.update(pSDEUtilDE2);
        }
    }

    public void removeByUtilPSDE11(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEUtilDEServiceBase.this.onBeforeRemoveByUtilPSDE11(pSDataEntity2);
                PSDEUtilDEServiceBase.this.internalRemoveByUtilPSDE11(pSDataEntity2);
                PSDEUtilDEServiceBase.this.onAfterRemoveByUtilPSDE11(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByUtilPSDE11(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByUtilPSDE11(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEUtilDE> arrayList = this.selectByUtilPSDE11(pSDataEntity);
        this.onBeforeRemoveByUtilPSDE11(pSDataEntity, arrayList);
        for (PSDEUtilDE pSDEUtilDE : arrayList) {
            this.remove((IEntity)pSDEUtilDE);
        }
        this.onAfterRemoveByUtilPSDE11(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByUtilPSDE11(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByUtilPSDE11(PSDataEntity pSDataEntity, ArrayList<PSDEUtilDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUtilPSDE11(PSDataEntity pSDataEntity, ArrayList<PSDEUtilDE> arrayList) throws Exception {
    }

    public void testRemoveByUtilPSDE12(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEUtilDE> arrayList = this.selectByUtilPSDE12(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEUTILDE_PSDATAENTITY_UTILPSDE12ID", "", iDataEntityModel.getName(), "PSDEUTILDE", iDataEntityModel.getDataInfo((IEntity)pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetUtilPSDE12(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEUtilDE> arrayList = this.selectByUtilPSDE12(pSDataEntity);
        for (PSDEUtilDE pSDEUtilDE : arrayList) {
            PSDEUtilDE pSDEUtilDE2 = (PSDEUtilDE)this.getDEModel().createEntity();
            pSDEUtilDE2.setPSDEUtilDEId(pSDEUtilDE.getPSDEUtilDEId());
            pSDEUtilDE2.setUtilPSDE12Id(null);
            this.update(pSDEUtilDE2);
        }
    }

    public void removeByUtilPSDE12(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEUtilDEServiceBase.this.onBeforeRemoveByUtilPSDE12(pSDataEntity2);
                PSDEUtilDEServiceBase.this.internalRemoveByUtilPSDE12(pSDataEntity2);
                PSDEUtilDEServiceBase.this.onAfterRemoveByUtilPSDE12(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByUtilPSDE12(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByUtilPSDE12(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEUtilDE> arrayList = this.selectByUtilPSDE12(pSDataEntity);
        this.onBeforeRemoveByUtilPSDE12(pSDataEntity, arrayList);
        for (PSDEUtilDE pSDEUtilDE : arrayList) {
            this.remove((IEntity)pSDEUtilDE);
        }
        this.onAfterRemoveByUtilPSDE12(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByUtilPSDE12(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByUtilPSDE12(PSDataEntity pSDataEntity, ArrayList<PSDEUtilDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUtilPSDE12(PSDataEntity pSDataEntity, ArrayList<PSDEUtilDE> arrayList) throws Exception {
    }

    public void testRemoveByUtilPSDE13(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEUtilDE> arrayList = this.selectByUtilPSDE13(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEUTILDE_PSDATAENTITY_UTILPSDE13ID", "", iDataEntityModel.getName(), "PSDEUTILDE", iDataEntityModel.getDataInfo((IEntity)pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetUtilPSDE13(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEUtilDE> arrayList = this.selectByUtilPSDE13(pSDataEntity);
        for (PSDEUtilDE pSDEUtilDE : arrayList) {
            PSDEUtilDE pSDEUtilDE2 = (PSDEUtilDE)this.getDEModel().createEntity();
            pSDEUtilDE2.setPSDEUtilDEId(pSDEUtilDE.getPSDEUtilDEId());
            pSDEUtilDE2.setUtilPSDE13Id(null);
            this.update(pSDEUtilDE2);
        }
    }

    public void removeByUtilPSDE13(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEUtilDEServiceBase.this.onBeforeRemoveByUtilPSDE13(pSDataEntity2);
                PSDEUtilDEServiceBase.this.internalRemoveByUtilPSDE13(pSDataEntity2);
                PSDEUtilDEServiceBase.this.onAfterRemoveByUtilPSDE13(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByUtilPSDE13(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByUtilPSDE13(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEUtilDE> arrayList = this.selectByUtilPSDE13(pSDataEntity);
        this.onBeforeRemoveByUtilPSDE13(pSDataEntity, arrayList);
        for (PSDEUtilDE pSDEUtilDE : arrayList) {
            this.remove((IEntity)pSDEUtilDE);
        }
        this.onAfterRemoveByUtilPSDE13(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByUtilPSDE13(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByUtilPSDE13(PSDataEntity pSDataEntity, ArrayList<PSDEUtilDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUtilPSDE13(PSDataEntity pSDataEntity, ArrayList<PSDEUtilDE> arrayList) throws Exception {
    }

    public void testRemoveByUtilPSDE14(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEUtilDE> arrayList = this.selectByUtilPSDE14(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEUTILDE_PSDATAENTITY_UTILPSDE14ID", "", iDataEntityModel.getName(), "PSDEUTILDE", iDataEntityModel.getDataInfo((IEntity)pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetUtilPSDE14(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEUtilDE> arrayList = this.selectByUtilPSDE14(pSDataEntity);
        for (PSDEUtilDE pSDEUtilDE : arrayList) {
            PSDEUtilDE pSDEUtilDE2 = (PSDEUtilDE)this.getDEModel().createEntity();
            pSDEUtilDE2.setPSDEUtilDEId(pSDEUtilDE.getPSDEUtilDEId());
            pSDEUtilDE2.setUtilPSDE14Id(null);
            this.update(pSDEUtilDE2);
        }
    }

    public void removeByUtilPSDE14(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEUtilDEServiceBase.this.onBeforeRemoveByUtilPSDE14(pSDataEntity2);
                PSDEUtilDEServiceBase.this.internalRemoveByUtilPSDE14(pSDataEntity2);
                PSDEUtilDEServiceBase.this.onAfterRemoveByUtilPSDE14(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByUtilPSDE14(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByUtilPSDE14(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEUtilDE> arrayList = this.selectByUtilPSDE14(pSDataEntity);
        this.onBeforeRemoveByUtilPSDE14(pSDataEntity, arrayList);
        for (PSDEUtilDE pSDEUtilDE : arrayList) {
            this.remove((IEntity)pSDEUtilDE);
        }
        this.onAfterRemoveByUtilPSDE14(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByUtilPSDE14(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByUtilPSDE14(PSDataEntity pSDataEntity, ArrayList<PSDEUtilDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUtilPSDE14(PSDataEntity pSDataEntity, ArrayList<PSDEUtilDE> arrayList) throws Exception {
    }

    public void testRemoveByUtilPSDE15(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEUtilDE> arrayList = this.selectByUtilPSDE15(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEUTILDE_PSDATAENTITY_UTILPSDE15ID", "", iDataEntityModel.getName(), "PSDEUTILDE", iDataEntityModel.getDataInfo((IEntity)pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetUtilPSDE15(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEUtilDE> arrayList = this.selectByUtilPSDE15(pSDataEntity);
        for (PSDEUtilDE pSDEUtilDE : arrayList) {
            PSDEUtilDE pSDEUtilDE2 = (PSDEUtilDE)this.getDEModel().createEntity();
            pSDEUtilDE2.setPSDEUtilDEId(pSDEUtilDE.getPSDEUtilDEId());
            pSDEUtilDE2.setUtilPSDE15Id(null);
            this.update(pSDEUtilDE2);
        }
    }

    public void removeByUtilPSDE15(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEUtilDEServiceBase.this.onBeforeRemoveByUtilPSDE15(pSDataEntity2);
                PSDEUtilDEServiceBase.this.internalRemoveByUtilPSDE15(pSDataEntity2);
                PSDEUtilDEServiceBase.this.onAfterRemoveByUtilPSDE15(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByUtilPSDE15(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByUtilPSDE15(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEUtilDE> arrayList = this.selectByUtilPSDE15(pSDataEntity);
        this.onBeforeRemoveByUtilPSDE15(pSDataEntity, arrayList);
        for (PSDEUtilDE pSDEUtilDE : arrayList) {
            this.remove((IEntity)pSDEUtilDE);
        }
        this.onAfterRemoveByUtilPSDE15(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByUtilPSDE15(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByUtilPSDE15(PSDataEntity pSDataEntity, ArrayList<PSDEUtilDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUtilPSDE15(PSDataEntity pSDataEntity, ArrayList<PSDEUtilDE> arrayList) throws Exception {
    }

    public void testRemoveByUtilPSDE16(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEUtilDE> arrayList = this.selectByUtilPSDE16(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEUTILDE_PSDATAENTITY_UTILPSDE16ID", "", iDataEntityModel.getName(), "PSDEUTILDE", iDataEntityModel.getDataInfo((IEntity)pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetUtilPSDE16(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEUtilDE> arrayList = this.selectByUtilPSDE16(pSDataEntity);
        for (PSDEUtilDE pSDEUtilDE : arrayList) {
            PSDEUtilDE pSDEUtilDE2 = (PSDEUtilDE)this.getDEModel().createEntity();
            pSDEUtilDE2.setPSDEUtilDEId(pSDEUtilDE.getPSDEUtilDEId());
            pSDEUtilDE2.setUtilPSDE16Id(null);
            this.update(pSDEUtilDE2);
        }
    }

    public void removeByUtilPSDE16(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEUtilDEServiceBase.this.onBeforeRemoveByUtilPSDE16(pSDataEntity2);
                PSDEUtilDEServiceBase.this.internalRemoveByUtilPSDE16(pSDataEntity2);
                PSDEUtilDEServiceBase.this.onAfterRemoveByUtilPSDE16(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByUtilPSDE16(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByUtilPSDE16(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEUtilDE> arrayList = this.selectByUtilPSDE16(pSDataEntity);
        this.onBeforeRemoveByUtilPSDE16(pSDataEntity, arrayList);
        for (PSDEUtilDE pSDEUtilDE : arrayList) {
            this.remove((IEntity)pSDEUtilDE);
        }
        this.onAfterRemoveByUtilPSDE16(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByUtilPSDE16(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByUtilPSDE16(PSDataEntity pSDataEntity, ArrayList<PSDEUtilDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUtilPSDE16(PSDataEntity pSDataEntity, ArrayList<PSDEUtilDE> arrayList) throws Exception {
    }

    public void testRemoveByUtilPSDE17(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEUtilDE> arrayList = this.selectByUtilPSDE17(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEUTILDE_PSDATAENTITY_UTILPSDE17ID", "", iDataEntityModel.getName(), "PSDEUTILDE", iDataEntityModel.getDataInfo((IEntity)pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetUtilPSDE17(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEUtilDE> arrayList = this.selectByUtilPSDE17(pSDataEntity);
        for (PSDEUtilDE pSDEUtilDE : arrayList) {
            PSDEUtilDE pSDEUtilDE2 = (PSDEUtilDE)this.getDEModel().createEntity();
            pSDEUtilDE2.setPSDEUtilDEId(pSDEUtilDE.getPSDEUtilDEId());
            pSDEUtilDE2.setUtilPSDE17Id(null);
            this.update(pSDEUtilDE2);
        }
    }

    public void removeByUtilPSDE17(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEUtilDEServiceBase.this.onBeforeRemoveByUtilPSDE17(pSDataEntity2);
                PSDEUtilDEServiceBase.this.internalRemoveByUtilPSDE17(pSDataEntity2);
                PSDEUtilDEServiceBase.this.onAfterRemoveByUtilPSDE17(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByUtilPSDE17(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByUtilPSDE17(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEUtilDE> arrayList = this.selectByUtilPSDE17(pSDataEntity);
        this.onBeforeRemoveByUtilPSDE17(pSDataEntity, arrayList);
        for (PSDEUtilDE pSDEUtilDE : arrayList) {
            this.remove((IEntity)pSDEUtilDE);
        }
        this.onAfterRemoveByUtilPSDE17(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByUtilPSDE17(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByUtilPSDE17(PSDataEntity pSDataEntity, ArrayList<PSDEUtilDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUtilPSDE17(PSDataEntity pSDataEntity, ArrayList<PSDEUtilDE> arrayList) throws Exception {
    }

    public void testRemoveByUtilPSDE18(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEUtilDE> arrayList = this.selectByUtilPSDE18(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEUTILDE_PSDATAENTITY_UTILPSDE18ID", "", iDataEntityModel.getName(), "PSDEUTILDE", iDataEntityModel.getDataInfo((IEntity)pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetUtilPSDE18(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEUtilDE> arrayList = this.selectByUtilPSDE18(pSDataEntity);
        for (PSDEUtilDE pSDEUtilDE : arrayList) {
            PSDEUtilDE pSDEUtilDE2 = (PSDEUtilDE)this.getDEModel().createEntity();
            pSDEUtilDE2.setPSDEUtilDEId(pSDEUtilDE.getPSDEUtilDEId());
            pSDEUtilDE2.setUtilPSDE18Id(null);
            this.update(pSDEUtilDE2);
        }
    }

    public void removeByUtilPSDE18(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEUtilDEServiceBase.this.onBeforeRemoveByUtilPSDE18(pSDataEntity2);
                PSDEUtilDEServiceBase.this.internalRemoveByUtilPSDE18(pSDataEntity2);
                PSDEUtilDEServiceBase.this.onAfterRemoveByUtilPSDE18(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByUtilPSDE18(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByUtilPSDE18(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEUtilDE> arrayList = this.selectByUtilPSDE18(pSDataEntity);
        this.onBeforeRemoveByUtilPSDE18(pSDataEntity, arrayList);
        for (PSDEUtilDE pSDEUtilDE : arrayList) {
            this.remove((IEntity)pSDEUtilDE);
        }
        this.onAfterRemoveByUtilPSDE18(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByUtilPSDE18(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByUtilPSDE18(PSDataEntity pSDataEntity, ArrayList<PSDEUtilDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUtilPSDE18(PSDataEntity pSDataEntity, ArrayList<PSDEUtilDE> arrayList) throws Exception {
    }

    public void testRemoveByUtilPSDE19(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEUtilDE> arrayList = this.selectByUtilPSDE19(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEUTILDE_PSDATAENTITY_UTILPSDE19ID", "", iDataEntityModel.getName(), "PSDEUTILDE", iDataEntityModel.getDataInfo((IEntity)pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetUtilPSDE19(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEUtilDE> arrayList = this.selectByUtilPSDE19(pSDataEntity);
        for (PSDEUtilDE pSDEUtilDE : arrayList) {
            PSDEUtilDE pSDEUtilDE2 = (PSDEUtilDE)this.getDEModel().createEntity();
            pSDEUtilDE2.setPSDEUtilDEId(pSDEUtilDE.getPSDEUtilDEId());
            pSDEUtilDE2.setUtilPSDE19Id(null);
            this.update(pSDEUtilDE2);
        }
    }

    public void removeByUtilPSDE19(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEUtilDEServiceBase.this.onBeforeRemoveByUtilPSDE19(pSDataEntity2);
                PSDEUtilDEServiceBase.this.internalRemoveByUtilPSDE19(pSDataEntity2);
                PSDEUtilDEServiceBase.this.onAfterRemoveByUtilPSDE19(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByUtilPSDE19(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByUtilPSDE19(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEUtilDE> arrayList = this.selectByUtilPSDE19(pSDataEntity);
        this.onBeforeRemoveByUtilPSDE19(pSDataEntity, arrayList);
        for (PSDEUtilDE pSDEUtilDE : arrayList) {
            this.remove((IEntity)pSDEUtilDE);
        }
        this.onAfterRemoveByUtilPSDE19(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByUtilPSDE19(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByUtilPSDE19(PSDataEntity pSDataEntity, ArrayList<PSDEUtilDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUtilPSDE19(PSDataEntity pSDataEntity, ArrayList<PSDEUtilDE> arrayList) throws Exception {
    }

    public void testRemoveByUtilPSDE20(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEUtilDE> arrayList = this.selectByUtilPSDE20(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEUTILDE_PSDATAENTITY_UTILPSDE20ID", "", iDataEntityModel.getName(), "PSDEUTILDE", iDataEntityModel.getDataInfo((IEntity)pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetUtilPSDE20(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEUtilDE> arrayList = this.selectByUtilPSDE20(pSDataEntity);
        for (PSDEUtilDE pSDEUtilDE : arrayList) {
            PSDEUtilDE pSDEUtilDE2 = (PSDEUtilDE)this.getDEModel().createEntity();
            pSDEUtilDE2.setPSDEUtilDEId(pSDEUtilDE.getPSDEUtilDEId());
            pSDEUtilDE2.setUtilPSDE20Id(null);
            this.update(pSDEUtilDE2);
        }
    }

    public void removeByUtilPSDE20(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEUtilDEServiceBase.this.onBeforeRemoveByUtilPSDE20(pSDataEntity2);
                PSDEUtilDEServiceBase.this.internalRemoveByUtilPSDE20(pSDataEntity2);
                PSDEUtilDEServiceBase.this.onAfterRemoveByUtilPSDE20(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByUtilPSDE20(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByUtilPSDE20(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEUtilDE> arrayList = this.selectByUtilPSDE20(pSDataEntity);
        this.onBeforeRemoveByUtilPSDE20(pSDataEntity, arrayList);
        for (PSDEUtilDE pSDEUtilDE : arrayList) {
            this.remove((IEntity)pSDEUtilDE);
        }
        this.onAfterRemoveByUtilPSDE20(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByUtilPSDE20(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByUtilPSDE20(PSDataEntity pSDataEntity, ArrayList<PSDEUtilDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUtilPSDE20(PSDataEntity pSDataEntity, ArrayList<PSDEUtilDE> arrayList) throws Exception {
    }

    public void testRemoveByUtilPSDE2(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEUtilDE> arrayList = this.selectByUtilPSDE2(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEUTILDE_PSDATAENTITY_UTILPSDE2ID", "", iDataEntityModel.getName(), "PSDEUTILDE", iDataEntityModel.getDataInfo((IEntity)pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetUtilPSDE2(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEUtilDE> arrayList = this.selectByUtilPSDE2(pSDataEntity);
        for (PSDEUtilDE pSDEUtilDE : arrayList) {
            PSDEUtilDE pSDEUtilDE2 = (PSDEUtilDE)this.getDEModel().createEntity();
            pSDEUtilDE2.setPSDEUtilDEId(pSDEUtilDE.getPSDEUtilDEId());
            pSDEUtilDE2.setUtilPSDE2Id(null);
            this.update(pSDEUtilDE2);
        }
    }

    public void removeByUtilPSDE2(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEUtilDEServiceBase.this.onBeforeRemoveByUtilPSDE2(pSDataEntity2);
                PSDEUtilDEServiceBase.this.internalRemoveByUtilPSDE2(pSDataEntity2);
                PSDEUtilDEServiceBase.this.onAfterRemoveByUtilPSDE2(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByUtilPSDE2(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByUtilPSDE2(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEUtilDE> arrayList = this.selectByUtilPSDE2(pSDataEntity);
        this.onBeforeRemoveByUtilPSDE2(pSDataEntity, arrayList);
        for (PSDEUtilDE pSDEUtilDE : arrayList) {
            this.remove((IEntity)pSDEUtilDE);
        }
        this.onAfterRemoveByUtilPSDE2(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByUtilPSDE2(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByUtilPSDE2(PSDataEntity pSDataEntity, ArrayList<PSDEUtilDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUtilPSDE2(PSDataEntity pSDataEntity, ArrayList<PSDEUtilDE> arrayList) throws Exception {
    }

    public void testRemoveByUtilPSDE3(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEUtilDE> arrayList = this.selectByUtilPSDE3(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEUTILDE_PSDATAENTITY_UTILPSDE3ID", "", iDataEntityModel.getName(), "PSDEUTILDE", iDataEntityModel.getDataInfo((IEntity)pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetUtilPSDE3(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEUtilDE> arrayList = this.selectByUtilPSDE3(pSDataEntity);
        for (PSDEUtilDE pSDEUtilDE : arrayList) {
            PSDEUtilDE pSDEUtilDE2 = (PSDEUtilDE)this.getDEModel().createEntity();
            pSDEUtilDE2.setPSDEUtilDEId(pSDEUtilDE.getPSDEUtilDEId());
            pSDEUtilDE2.setUtilPSDE3Id(null);
            this.update(pSDEUtilDE2);
        }
    }

    public void removeByUtilPSDE3(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEUtilDEServiceBase.this.onBeforeRemoveByUtilPSDE3(pSDataEntity2);
                PSDEUtilDEServiceBase.this.internalRemoveByUtilPSDE3(pSDataEntity2);
                PSDEUtilDEServiceBase.this.onAfterRemoveByUtilPSDE3(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByUtilPSDE3(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByUtilPSDE3(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEUtilDE> arrayList = this.selectByUtilPSDE3(pSDataEntity);
        this.onBeforeRemoveByUtilPSDE3(pSDataEntity, arrayList);
        for (PSDEUtilDE pSDEUtilDE : arrayList) {
            this.remove((IEntity)pSDEUtilDE);
        }
        this.onAfterRemoveByUtilPSDE3(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByUtilPSDE3(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByUtilPSDE3(PSDataEntity pSDataEntity, ArrayList<PSDEUtilDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUtilPSDE3(PSDataEntity pSDataEntity, ArrayList<PSDEUtilDE> arrayList) throws Exception {
    }

    public void testRemoveByUtilPSDE4(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEUtilDE> arrayList = this.selectByUtilPSDE4(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEUTILDE_PSDATAENTITY_UTILPSDE4ID", "", iDataEntityModel.getName(), "PSDEUTILDE", iDataEntityModel.getDataInfo((IEntity)pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetUtilPSDE4(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEUtilDE> arrayList = this.selectByUtilPSDE4(pSDataEntity);
        for (PSDEUtilDE pSDEUtilDE : arrayList) {
            PSDEUtilDE pSDEUtilDE2 = (PSDEUtilDE)this.getDEModel().createEntity();
            pSDEUtilDE2.setPSDEUtilDEId(pSDEUtilDE.getPSDEUtilDEId());
            pSDEUtilDE2.setUtilPSDE4Id(null);
            this.update(pSDEUtilDE2);
        }
    }

    public void removeByUtilPSDE4(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEUtilDEServiceBase.this.onBeforeRemoveByUtilPSDE4(pSDataEntity2);
                PSDEUtilDEServiceBase.this.internalRemoveByUtilPSDE4(pSDataEntity2);
                PSDEUtilDEServiceBase.this.onAfterRemoveByUtilPSDE4(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByUtilPSDE4(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByUtilPSDE4(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEUtilDE> arrayList = this.selectByUtilPSDE4(pSDataEntity);
        this.onBeforeRemoveByUtilPSDE4(pSDataEntity, arrayList);
        for (PSDEUtilDE pSDEUtilDE : arrayList) {
            this.remove((IEntity)pSDEUtilDE);
        }
        this.onAfterRemoveByUtilPSDE4(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByUtilPSDE4(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByUtilPSDE4(PSDataEntity pSDataEntity, ArrayList<PSDEUtilDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUtilPSDE4(PSDataEntity pSDataEntity, ArrayList<PSDEUtilDE> arrayList) throws Exception {
    }

    public void testRemoveByUtilPSDE5(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEUtilDE> arrayList = this.selectByUtilPSDE5(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEUTILDE_PSDATAENTITY_UTILPSDE5ID", "", iDataEntityModel.getName(), "PSDEUTILDE", iDataEntityModel.getDataInfo((IEntity)pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetUtilPSDE5(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEUtilDE> arrayList = this.selectByUtilPSDE5(pSDataEntity);
        for (PSDEUtilDE pSDEUtilDE : arrayList) {
            PSDEUtilDE pSDEUtilDE2 = (PSDEUtilDE)this.getDEModel().createEntity();
            pSDEUtilDE2.setPSDEUtilDEId(pSDEUtilDE.getPSDEUtilDEId());
            pSDEUtilDE2.setUtilPSDE5Id(null);
            this.update(pSDEUtilDE2);
        }
    }

    public void removeByUtilPSDE5(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEUtilDEServiceBase.this.onBeforeRemoveByUtilPSDE5(pSDataEntity2);
                PSDEUtilDEServiceBase.this.internalRemoveByUtilPSDE5(pSDataEntity2);
                PSDEUtilDEServiceBase.this.onAfterRemoveByUtilPSDE5(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByUtilPSDE5(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByUtilPSDE5(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEUtilDE> arrayList = this.selectByUtilPSDE5(pSDataEntity);
        this.onBeforeRemoveByUtilPSDE5(pSDataEntity, arrayList);
        for (PSDEUtilDE pSDEUtilDE : arrayList) {
            this.remove((IEntity)pSDEUtilDE);
        }
        this.onAfterRemoveByUtilPSDE5(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByUtilPSDE5(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByUtilPSDE5(PSDataEntity pSDataEntity, ArrayList<PSDEUtilDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUtilPSDE5(PSDataEntity pSDataEntity, ArrayList<PSDEUtilDE> arrayList) throws Exception {
    }

    public void testRemoveByUtilPSDE6(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEUtilDE> arrayList = this.selectByUtilPSDE6(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEUTILDE_PSDATAENTITY_UTILPSDE6ID", "", iDataEntityModel.getName(), "PSDEUTILDE", iDataEntityModel.getDataInfo((IEntity)pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetUtilPSDE6(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEUtilDE> arrayList = this.selectByUtilPSDE6(pSDataEntity);
        for (PSDEUtilDE pSDEUtilDE : arrayList) {
            PSDEUtilDE pSDEUtilDE2 = (PSDEUtilDE)this.getDEModel().createEntity();
            pSDEUtilDE2.setPSDEUtilDEId(pSDEUtilDE.getPSDEUtilDEId());
            pSDEUtilDE2.setUtilPSDE6Id(null);
            this.update(pSDEUtilDE2);
        }
    }

    public void removeByUtilPSDE6(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEUtilDEServiceBase.this.onBeforeRemoveByUtilPSDE6(pSDataEntity2);
                PSDEUtilDEServiceBase.this.internalRemoveByUtilPSDE6(pSDataEntity2);
                PSDEUtilDEServiceBase.this.onAfterRemoveByUtilPSDE6(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByUtilPSDE6(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByUtilPSDE6(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEUtilDE> arrayList = this.selectByUtilPSDE6(pSDataEntity);
        this.onBeforeRemoveByUtilPSDE6(pSDataEntity, arrayList);
        for (PSDEUtilDE pSDEUtilDE : arrayList) {
            this.remove((IEntity)pSDEUtilDE);
        }
        this.onAfterRemoveByUtilPSDE6(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByUtilPSDE6(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByUtilPSDE6(PSDataEntity pSDataEntity, ArrayList<PSDEUtilDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUtilPSDE6(PSDataEntity pSDataEntity, ArrayList<PSDEUtilDE> arrayList) throws Exception {
    }

    public void testRemoveByUtilPSDE7(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEUtilDE> arrayList = this.selectByUtilPSDE7(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEUTILDE_PSDATAENTITY_UTILPSDE7ID", "", iDataEntityModel.getName(), "PSDEUTILDE", iDataEntityModel.getDataInfo((IEntity)pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetUtilPSDE7(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEUtilDE> arrayList = this.selectByUtilPSDE7(pSDataEntity);
        for (PSDEUtilDE pSDEUtilDE : arrayList) {
            PSDEUtilDE pSDEUtilDE2 = (PSDEUtilDE)this.getDEModel().createEntity();
            pSDEUtilDE2.setPSDEUtilDEId(pSDEUtilDE.getPSDEUtilDEId());
            pSDEUtilDE2.setUtilPSDE7Id(null);
            this.update(pSDEUtilDE2);
        }
    }

    public void removeByUtilPSDE7(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEUtilDEServiceBase.this.onBeforeRemoveByUtilPSDE7(pSDataEntity2);
                PSDEUtilDEServiceBase.this.internalRemoveByUtilPSDE7(pSDataEntity2);
                PSDEUtilDEServiceBase.this.onAfterRemoveByUtilPSDE7(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByUtilPSDE7(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByUtilPSDE7(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEUtilDE> arrayList = this.selectByUtilPSDE7(pSDataEntity);
        this.onBeforeRemoveByUtilPSDE7(pSDataEntity, arrayList);
        for (PSDEUtilDE pSDEUtilDE : arrayList) {
            this.remove((IEntity)pSDEUtilDE);
        }
        this.onAfterRemoveByUtilPSDE7(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByUtilPSDE7(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByUtilPSDE7(PSDataEntity pSDataEntity, ArrayList<PSDEUtilDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUtilPSDE7(PSDataEntity pSDataEntity, ArrayList<PSDEUtilDE> arrayList) throws Exception {
    }

    public void testRemoveByUtilPSDE8(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEUtilDE> arrayList = this.selectByUtilPSDE8(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEUTILDE_PSDATAENTITY_UTILPSDE8ID", "", iDataEntityModel.getName(), "PSDEUTILDE", iDataEntityModel.getDataInfo((IEntity)pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetUtilPSDE8(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEUtilDE> arrayList = this.selectByUtilPSDE8(pSDataEntity);
        for (PSDEUtilDE pSDEUtilDE : arrayList) {
            PSDEUtilDE pSDEUtilDE2 = (PSDEUtilDE)this.getDEModel().createEntity();
            pSDEUtilDE2.setPSDEUtilDEId(pSDEUtilDE.getPSDEUtilDEId());
            pSDEUtilDE2.setUtilPSDE8Id(null);
            this.update(pSDEUtilDE2);
        }
    }

    public void removeByUtilPSDE8(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEUtilDEServiceBase.this.onBeforeRemoveByUtilPSDE8(pSDataEntity2);
                PSDEUtilDEServiceBase.this.internalRemoveByUtilPSDE8(pSDataEntity2);
                PSDEUtilDEServiceBase.this.onAfterRemoveByUtilPSDE8(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByUtilPSDE8(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByUtilPSDE8(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEUtilDE> arrayList = this.selectByUtilPSDE8(pSDataEntity);
        this.onBeforeRemoveByUtilPSDE8(pSDataEntity, arrayList);
        for (PSDEUtilDE pSDEUtilDE : arrayList) {
            this.remove((IEntity)pSDEUtilDE);
        }
        this.onAfterRemoveByUtilPSDE8(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByUtilPSDE8(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByUtilPSDE8(PSDataEntity pSDataEntity, ArrayList<PSDEUtilDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUtilPSDE8(PSDataEntity pSDataEntity, ArrayList<PSDEUtilDE> arrayList) throws Exception {
    }

    public void testRemoveByUtilPSDE9(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEUtilDE> arrayList = this.selectByUtilPSDE9(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEUTILDE_PSDATAENTITY_UTILPSDE9ID", "", iDataEntityModel.getName(), "PSDEUTILDE", iDataEntityModel.getDataInfo((IEntity)pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetUtilPSDE9(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEUtilDE> arrayList = this.selectByUtilPSDE9(pSDataEntity);
        for (PSDEUtilDE pSDEUtilDE : arrayList) {
            PSDEUtilDE pSDEUtilDE2 = (PSDEUtilDE)this.getDEModel().createEntity();
            pSDEUtilDE2.setPSDEUtilDEId(pSDEUtilDE.getPSDEUtilDEId());
            pSDEUtilDE2.setUtilPSDE9Id(null);
            this.update(pSDEUtilDE2);
        }
    }

    public void removeByUtilPSDE9(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEUtilDEServiceBase.this.onBeforeRemoveByUtilPSDE9(pSDataEntity2);
                PSDEUtilDEServiceBase.this.internalRemoveByUtilPSDE9(pSDataEntity2);
                PSDEUtilDEServiceBase.this.onAfterRemoveByUtilPSDE9(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByUtilPSDE9(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByUtilPSDE9(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEUtilDE> arrayList = this.selectByUtilPSDE9(pSDataEntity);
        this.onBeforeRemoveByUtilPSDE9(pSDataEntity, arrayList);
        for (PSDEUtilDE pSDEUtilDE : arrayList) {
            this.remove((IEntity)pSDEUtilDE);
        }
        this.onAfterRemoveByUtilPSDE9(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByUtilPSDE9(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByUtilPSDE9(PSDataEntity pSDataEntity, ArrayList<PSDEUtilDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUtilPSDE9(PSDataEntity pSDataEntity, ArrayList<PSDEUtilDE> arrayList) throws Exception {
    }

    public void testRemoveByUtilPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEUtilDE> arrayList = this.selectByUtilPSDE(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEUTILDE_PSDATAENTITY_UTILPSDEID", "", iDataEntityModel.getName(), "PSDEUTILDE", iDataEntityModel.getDataInfo((IEntity)pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetUtilPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEUtilDE> arrayList = this.selectByUtilPSDE(pSDataEntity);
        for (PSDEUtilDE pSDEUtilDE : arrayList) {
            PSDEUtilDE pSDEUtilDE2 = (PSDEUtilDE)this.getDEModel().createEntity();
            pSDEUtilDE2.setPSDEUtilDEId(pSDEUtilDE.getPSDEUtilDEId());
            pSDEUtilDE2.setUtilPSDEId(null);
            this.update(pSDEUtilDE2);
        }
    }

    public void removeByUtilPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEUtilDEServiceBase.this.onBeforeRemoveByUtilPSDE(pSDataEntity2);
                PSDEUtilDEServiceBase.this.internalRemoveByUtilPSDE(pSDataEntity2);
                PSDEUtilDEServiceBase.this.onAfterRemoveByUtilPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByUtilPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByUtilPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEUtilDE> arrayList = this.selectByUtilPSDE(pSDataEntity);
        this.onBeforeRemoveByUtilPSDE(pSDataEntity, arrayList);
        for (PSDEUtilDE pSDEUtilDE : arrayList) {
            this.remove((IEntity)pSDEUtilDE);
        }
        this.onAfterRemoveByUtilPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByUtilPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByUtilPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEUtilDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUtilPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEUtilDE> arrayList) throws Exception {
    }

    public void testRemoveByPSSubSysServiceAPI(PSSubSysServiceAPI pSSubSysServiceAPI) throws Exception {
        ArrayList<PSDEUtilDE> arrayList = this.selectByPSSubSysServiceAPI(pSSubSysServiceAPI, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSUBSYSSERVICEAPI");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSubSysServiceAPI);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEUTILDE_PSSUBSYSSERVICEAPI_PSSUBSYSSERVICEAPIID", "", iDataEntityModel.getName(), "PSDEUTILDE", iDataEntityModel.getDataInfo((IEntity)pSSubSysServiceAPI), arrayList.get(0)));
        }
    }

    public void resetPSSubSysServiceAPI(PSSubSysServiceAPI pSSubSysServiceAPI) throws Exception {
        ArrayList<PSDEUtilDE> arrayList = this.selectByPSSubSysServiceAPI(pSSubSysServiceAPI);
        for (PSDEUtilDE pSDEUtilDE : arrayList) {
            PSDEUtilDE pSDEUtilDE2 = (PSDEUtilDE)this.getDEModel().createEntity();
            pSDEUtilDE2.setPSDEUtilDEId(pSDEUtilDE.getPSDEUtilDEId());
            pSDEUtilDE2.setPSSubSysServiceAPIId(null);
            this.update(pSDEUtilDE2);
        }
    }

    public void removeByPSSubSysServiceAPI(PSSubSysServiceAPI pSSubSysServiceAPI) throws Exception {
        final PSSubSysServiceAPI pSSubSysServiceAPI2 = pSSubSysServiceAPI;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEUtilDEServiceBase.this.onBeforeRemoveByPSSubSysServiceAPI(pSSubSysServiceAPI2);
                PSDEUtilDEServiceBase.this.internalRemoveByPSSubSysServiceAPI(pSSubSysServiceAPI2);
                PSDEUtilDEServiceBase.this.onAfterRemoveByPSSubSysServiceAPI(pSSubSysServiceAPI2);
            }
        });
    }

    protected void onBeforeRemoveByPSSubSysServiceAPI(PSSubSysServiceAPI pSSubSysServiceAPI) throws Exception {
    }

    protected void internalRemoveByPSSubSysServiceAPI(PSSubSysServiceAPI pSSubSysServiceAPI) throws Exception {
        ArrayList<PSDEUtilDE> arrayList = this.selectByPSSubSysServiceAPI(pSSubSysServiceAPI);
        this.onBeforeRemoveByPSSubSysServiceAPI(pSSubSysServiceAPI, arrayList);
        for (PSDEUtilDE pSDEUtilDE : arrayList) {
            this.remove((IEntity)pSDEUtilDE);
        }
        this.onAfterRemoveByPSSubSysServiceAPI(pSSubSysServiceAPI, arrayList);
    }

    protected void onAfterRemoveByPSSubSysServiceAPI(PSSubSysServiceAPI pSSubSysServiceAPI) throws Exception {
    }

    protected void onBeforeRemoveByPSSubSysServiceAPI(PSSubSysServiceAPI pSSubSysServiceAPI, ArrayList<PSDEUtilDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSubSysServiceAPI(PSSubSysServiceAPI pSSubSysServiceAPI, ArrayList<PSDEUtilDE> arrayList) throws Exception {
    }

    public void testRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSDEUtilDE> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSDYNAMODEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysDynaModel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEUTILDE_PSSYSDYNAMODEL_PSSYSDYNAMODELID", "", iDataEntityModel.getName(), "PSDEUTILDE", iDataEntityModel.getDataInfo((IEntity)pSSysDynaModel), arrayList.get(0)));
        }
    }

    public void resetPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSDEUtilDE> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        for (PSDEUtilDE pSDEUtilDE : arrayList) {
            PSDEUtilDE pSDEUtilDE2 = (PSDEUtilDE)this.getDEModel().createEntity();
            pSDEUtilDE2.setPSDEUtilDEId(pSDEUtilDE.getPSDEUtilDEId());
            pSDEUtilDE2.setPSSysDynaModelId(null);
            this.update(pSDEUtilDE2);
        }
    }

    public void removeByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        final PSSysDynaModel pSSysDynaModel2 = pSSysDynaModel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEUtilDEServiceBase.this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSDEUtilDEServiceBase.this.internalRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSDEUtilDEServiceBase.this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void internalRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSDEUtilDE> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
        for (PSDEUtilDE pSDEUtilDE : arrayList) {
            this.remove((IEntity)pSDEUtilDE);
        }
        this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSDEUtilDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSDEUtilDE> arrayList) throws Exception {
    }

    public void testRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSDEUtilDE> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSSFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysSFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEUTILDE_PSSYSSFPLUGIN_PSSYSSFPLUGINID", "", iDataEntityModel.getName(), "PSDEUTILDE", iDataEntityModel.getDataInfo((IEntity)pSSysSFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSDEUtilDE> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        for (PSDEUtilDE pSDEUtilDE : arrayList) {
            PSDEUtilDE pSDEUtilDE2 = (PSDEUtilDE)this.getDEModel().createEntity();
            pSDEUtilDE2.setPSDEUtilDEId(pSDEUtilDE.getPSDEUtilDEId());
            pSDEUtilDE2.setPSSysSFPluginId(null);
            this.update(pSDEUtilDE2);
        }
    }

    public void removeByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        final PSSysSFPlugin pSSysSFPlugin2 = pSSysSFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEUtilDEServiceBase.this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSDEUtilDEServiceBase.this.internalRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSDEUtilDEServiceBase.this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSDEUtilDE> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
        for (PSDEUtilDE pSDEUtilDE : arrayList) {
            this.remove((IEntity)pSDEUtilDE);
        }
        this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSDEUtilDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSDEUtilDE> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDEUtilDE pSDEUtilDE) throws Exception {
        PSDELogicNodeService pSDELogicNodeService = (PSDELogicNodeService)ServiceGlobal.getService(PSDELogicNodeService.class, (SessionFactory)this.getSessionFactory());
        pSDELogicNodeService.testRemoveByDstPSDEUtilDE(pSDEUtilDE);
        super.onBeforeRemove(pSDEUtilDE);
    }

    protected void replaceParentInfo(PSDEUtilDE pSDEUtilDE, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDEUtilDE, cloneSession);
        if (pSDEUtilDE.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSDEUtilDE.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSDEUtilDE, (PSDataEntity)iEntity);
        }
        if (pSDEUtilDE.getUtilPSDE10Id() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSDEUtilDE.getUtilPSDE10Id())) != null) {
            this.onFillParentInfo_UtilPSDE10(pSDEUtilDE, (PSDataEntity)iEntity);
        }
        if (pSDEUtilDE.getUtilPSDE11Id() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSDEUtilDE.getUtilPSDE11Id())) != null) {
            this.onFillParentInfo_UtilPSDE11(pSDEUtilDE, (PSDataEntity)iEntity);
        }
        if (pSDEUtilDE.getUtilPSDE12Id() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSDEUtilDE.getUtilPSDE12Id())) != null) {
            this.onFillParentInfo_UtilPSDE12(pSDEUtilDE, (PSDataEntity)iEntity);
        }
        if (pSDEUtilDE.getUtilPSDE13Id() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSDEUtilDE.getUtilPSDE13Id())) != null) {
            this.onFillParentInfo_UtilPSDE13(pSDEUtilDE, (PSDataEntity)iEntity);
        }
        if (pSDEUtilDE.getUtilPSDE14Id() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSDEUtilDE.getUtilPSDE14Id())) != null) {
            this.onFillParentInfo_UtilPSDE14(pSDEUtilDE, (PSDataEntity)iEntity);
        }
        if (pSDEUtilDE.getUtilPSDE15Id() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSDEUtilDE.getUtilPSDE15Id())) != null) {
            this.onFillParentInfo_UtilPSDE15(pSDEUtilDE, (PSDataEntity)iEntity);
        }
        if (pSDEUtilDE.getUtilPSDE16Id() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSDEUtilDE.getUtilPSDE16Id())) != null) {
            this.onFillParentInfo_UtilPSDE16(pSDEUtilDE, (PSDataEntity)iEntity);
        }
        if (pSDEUtilDE.getUtilPSDE17Id() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSDEUtilDE.getUtilPSDE17Id())) != null) {
            this.onFillParentInfo_UtilPSDE17(pSDEUtilDE, (PSDataEntity)iEntity);
        }
        if (pSDEUtilDE.getUtilPSDE18Id() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSDEUtilDE.getUtilPSDE18Id())) != null) {
            this.onFillParentInfo_UtilPSDE18(pSDEUtilDE, (PSDataEntity)iEntity);
        }
        if (pSDEUtilDE.getUtilPSDE19Id() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSDEUtilDE.getUtilPSDE19Id())) != null) {
            this.onFillParentInfo_UtilPSDE19(pSDEUtilDE, (PSDataEntity)iEntity);
        }
        if (pSDEUtilDE.getUtilPSDE20Id() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSDEUtilDE.getUtilPSDE20Id())) != null) {
            this.onFillParentInfo_UtilPSDE20(pSDEUtilDE, (PSDataEntity)iEntity);
        }
        if (pSDEUtilDE.getUtilPSDE2Id() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSDEUtilDE.getUtilPSDE2Id())) != null) {
            this.onFillParentInfo_UtilPSDE2(pSDEUtilDE, (PSDataEntity)iEntity);
        }
        if (pSDEUtilDE.getUtilPSDE3Id() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSDEUtilDE.getUtilPSDE3Id())) != null) {
            this.onFillParentInfo_UtilPSDE3(pSDEUtilDE, (PSDataEntity)iEntity);
        }
        if (pSDEUtilDE.getUtilPSDE4Id() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSDEUtilDE.getUtilPSDE4Id())) != null) {
            this.onFillParentInfo_UtilPSDE4(pSDEUtilDE, (PSDataEntity)iEntity);
        }
        if (pSDEUtilDE.getUtilPSDE5Id() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSDEUtilDE.getUtilPSDE5Id())) != null) {
            this.onFillParentInfo_UtilPSDE5(pSDEUtilDE, (PSDataEntity)iEntity);
        }
        if (pSDEUtilDE.getUtilPSDE6Id() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSDEUtilDE.getUtilPSDE6Id())) != null) {
            this.onFillParentInfo_UtilPSDE6(pSDEUtilDE, (PSDataEntity)iEntity);
        }
        if (pSDEUtilDE.getUtilPSDE7Id() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSDEUtilDE.getUtilPSDE7Id())) != null) {
            this.onFillParentInfo_UtilPSDE7(pSDEUtilDE, (PSDataEntity)iEntity);
        }
        if (pSDEUtilDE.getUtilPSDE8Id() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSDEUtilDE.getUtilPSDE8Id())) != null) {
            this.onFillParentInfo_UtilPSDE8(pSDEUtilDE, (PSDataEntity)iEntity);
        }
        if (pSDEUtilDE.getUtilPSDE9Id() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSDEUtilDE.getUtilPSDE9Id())) != null) {
            this.onFillParentInfo_UtilPSDE9(pSDEUtilDE, (PSDataEntity)iEntity);
        }
        if (pSDEUtilDE.getUtilPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSDEUtilDE.getUtilPSDEId())) != null) {
            this.onFillParentInfo_UtilPSDE(pSDEUtilDE, (PSDataEntity)iEntity);
        }
        if (pSDEUtilDE.getPSSubSysServiceAPIId() != null && (iEntity = cloneSession.getEntity("PSSUBSYSSERVICEAPI", (Object)pSDEUtilDE.getPSSubSysServiceAPIId())) != null) {
            this.onFillParentInfo_PSSubSysServiceAPI(pSDEUtilDE, (PSSubSysServiceAPI)iEntity);
        }
        if (pSDEUtilDE.getPSSysDynaModelId() != null && (iEntity = cloneSession.getEntity("PSSYSDYNAMODEL", (Object)pSDEUtilDE.getPSSysDynaModelId())) != null) {
            this.onFillParentInfo_PSSysDynaModel(pSDEUtilDE, (PSSysDynaModel)iEntity);
        }
        if (pSDEUtilDE.getPSSysSFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSSFPLUGIN", (Object)pSDEUtilDE.getPSSysSFPluginId())) != null) {
            this.onFillParentInfo_PSSysSFPlugin(pSDEUtilDE, (PSSysSFPlugin)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDEUtilDE pSDEUtilDE, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDEUtilDE, bl);
    }

    protected void onCheckEntity(boolean bl, PSDEUtilDE pSDEUtilDE, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CodeName(bl, pSDEUtilDE, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ExtendMode(bl, pSDEUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LockFlag(bl, pSDEUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDEUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSDEUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSDEUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEUtilDEId(bl, pSDEUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEUtilDEName(bl, pSDEUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSubSysServiceAPIId(bl, pSDEUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDynaModelId(bl, pSDEUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSFPluginId(bl, pSDEUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UniqueTag(bl, pSDEUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSDEUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDEUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDEUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDEUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDEUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilObj(bl, pSDEUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilParam(bl, pSDEUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilParam10(bl, pSDEUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilParam11(bl, pSDEUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilParam12(bl, pSDEUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilParam2(bl, pSDEUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilParam3(bl, pSDEUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilParam4(bl, pSDEUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilParam5(bl, pSDEUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilParam6(bl, pSDEUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilParam7(bl, pSDEUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilParam8(bl, pSDEUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilParam9(bl, pSDEUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilParams(bl, pSDEUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDE10Id(bl, pSDEUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDE10Name(bl, pSDEUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDE11Id(bl, pSDEUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDE11Name(bl, pSDEUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDE12Id(bl, pSDEUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDE12Name(bl, pSDEUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDE13Id(bl, pSDEUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDE13Name(bl, pSDEUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDE14Id(bl, pSDEUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDE14Name(bl, pSDEUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDE15Id(bl, pSDEUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDE15Name(bl, pSDEUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDE16Id(bl, pSDEUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDE16Name(bl, pSDEUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDE17Id(bl, pSDEUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDE17Name(bl, pSDEUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDE18Id(bl, pSDEUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDE18Name(bl, pSDEUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDE19Id(bl, pSDEUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDE19Name(bl, pSDEUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDE20Id(bl, pSDEUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDE20Name(bl, pSDEUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDE2Id(bl, pSDEUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDE2Name(bl, pSDEUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDE3Id(bl, pSDEUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDE3Name(bl, pSDEUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDE4Id(bl, pSDEUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDE4Name(bl, pSDEUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDE5Id(bl, pSDEUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDE5Name(bl, pSDEUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDE6Id(bl, pSDEUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDE6Name(bl, pSDEUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDE7Id(bl, pSDEUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDE7Name(bl, pSDEUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDE8Id(bl, pSDEUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDE8Name(bl, pSDEUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDE9Id(bl, pSDEUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDE9Name(bl, pSDEUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDEId(bl, pSDEUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDEName(bl, pSDEUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilTag(bl, pSDEUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilTag2(bl, pSDEUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilType(bl, pSDEUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDEUtilDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDEUtilDE, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSDEUtilDE pSDEUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUtilDE.isCodeNameDirty() : !pSDEUtilDE.isCodeNameDirty()) {
            return null;
        }
        String string = pSDEUtilDE.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default((IEntity)pSDEUtilDE, bl2, bl3);
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
                String string4 = this.checkFieldDupRule(this.getPSDEUtilDEDEModel(), "CODENAME", string3, pSDEUtilDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_ExtendMode(boolean bl, PSDEUtilDE pSDEUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUtilDE.isExtendModeDirty() : !pSDEUtilDE.isExtendModeDirty()) {
            return null;
        }
        Integer n = pSDEUtilDE.getExtendMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ExtendMode_Default((IEntity)pSDEUtilDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXTENDMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LockFlag(boolean bl, PSDEUtilDE pSDEUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUtilDE.isLockFlagDirty() : !pSDEUtilDE.isLockFlagDirty()) {
            return null;
        }
        Integer n = pSDEUtilDE.getLockFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LockFlag_Default((IEntity)pSDEUtilDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDEUtilDE pSDEUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUtilDE.isMemoDirty() : !pSDEUtilDE.isMemoDirty()) {
            return null;
        }
        String string = pSDEUtilDE.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDEUtilDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSDEUtilDE pSDEUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUtilDE.isPSDEIdDirty() && !bl2 : !pSDEUtilDE.isPSDEIdDirty()) {
            return null;
        }
        String string = pSDEUtilDE.getPSDEId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default((IEntity)pSDEUtilDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSDEUtilDE pSDEUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUtilDE.isPSDENameDirty() && !bl2 : !pSDEUtilDE.isPSDENameDirty()) {
            return null;
        }
        String string = pSDEUtilDE.getPSDEName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default((IEntity)pSDEUtilDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEUtilDEId(boolean bl, PSDEUtilDE pSDEUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUtilDE.isPSDEUtilDEIdDirty() && !bl2 : !pSDEUtilDE.isPSDEUtilDEIdDirty()) {
            return null;
        }
        String string = pSDEUtilDE.getPSDEUtilDEId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEUTILDEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEUtilDEId_Default((IEntity)pSDEUtilDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEUTILDEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEUtilDEName(boolean bl, PSDEUtilDE pSDEUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUtilDE.isPSDEUtilDENameDirty() && !bl2 : !pSDEUtilDE.isPSDEUtilDENameDirty()) {
            return null;
        }
        String string = pSDEUtilDE.getPSDEUtilDEName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEUTILDENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEUtilDEName_Default((IEntity)pSDEUtilDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEUTILDENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSubSysServiceAPIId(boolean bl, PSDEUtilDE pSDEUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUtilDE.isPSSubSysServiceAPIIdDirty() : !pSDEUtilDE.isPSSubSysServiceAPIIdDirty()) {
            return null;
        }
        String string = pSDEUtilDE.getPSSubSysServiceAPIId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSubSysServiceAPIId_Default((IEntity)pSDEUtilDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysDynaModelId(boolean bl, PSDEUtilDE pSDEUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUtilDE.isPSSysDynaModelIdDirty() : !pSDEUtilDE.isPSSysDynaModelIdDirty()) {
            return null;
        }
        String string = pSDEUtilDE.getPSSysDynaModelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDynaModelId_Default((IEntity)pSDEUtilDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysSFPluginId(boolean bl, PSDEUtilDE pSDEUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUtilDE.isPSSysSFPluginIdDirty() : !pSDEUtilDE.isPSSysSFPluginIdDirty()) {
            return null;
        }
        String string = pSDEUtilDE.getPSSysSFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSFPluginId_Default((IEntity)pSDEUtilDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_UniqueTag(boolean bl, PSDEUtilDE pSDEUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUtilDE.isUniqueTagDirty() : !pSDEUtilDE.isUniqueTagDirty()) {
            return null;
        }
        String string = pSDEUtilDE.getUniqueTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UniqueTag_Default((IEntity)pSDEUtilDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSDEUtilDE pSDEUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUtilDE.isUserCatDirty() : !pSDEUtilDE.isUserCatDirty()) {
            return null;
        }
        String string = pSDEUtilDE.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default((IEntity)pSDEUtilDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDEUtilDE pSDEUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUtilDE.isUserTagDirty() : !pSDEUtilDE.isUserTagDirty()) {
            return null;
        }
        String string = pSDEUtilDE.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSDEUtilDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDEUtilDE pSDEUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUtilDE.isUserTag2Dirty() : !pSDEUtilDE.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDEUtilDE.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSDEUtilDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDEUtilDE pSDEUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUtilDE.isUserTag3Dirty() : !pSDEUtilDE.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDEUtilDE.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default((IEntity)pSDEUtilDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDEUtilDE pSDEUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUtilDE.isUserTag4Dirty() : !pSDEUtilDE.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDEUtilDE.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default((IEntity)pSDEUtilDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_UtilObj(boolean bl, PSDEUtilDE pSDEUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUtilDE.isUtilObjDirty() : !pSDEUtilDE.isUtilObjDirty()) {
            return null;
        }
        String string = pSDEUtilDE.getUtilObj();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilObj_Default((IEntity)pSDEUtilDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_UtilParam(boolean bl, PSDEUtilDE pSDEUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUtilDE.isUtilParamDirty() : !pSDEUtilDE.isUtilParamDirty()) {
            return null;
        }
        String string = pSDEUtilDE.getUtilParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilParam_Default((IEntity)pSDEUtilDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_UtilParam10(boolean bl, PSDEUtilDE pSDEUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUtilDE.isUtilParam10Dirty() : !pSDEUtilDE.isUtilParam10Dirty()) {
            return null;
        }
        Integer n = pSDEUtilDE.getUtilParam10();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_UtilParam10_Default((IEntity)pSDEUtilDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_UtilParam11(boolean bl, PSDEUtilDE pSDEUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUtilDE.isUtilParam11Dirty() : !pSDEUtilDE.isUtilParam11Dirty()) {
            return null;
        }
        String string = pSDEUtilDE.getUtilParam11();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilParam11_Default((IEntity)pSDEUtilDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_UtilParam12(boolean bl, PSDEUtilDE pSDEUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUtilDE.isUtilParam12Dirty() : !pSDEUtilDE.isUtilParam12Dirty()) {
            return null;
        }
        String string = pSDEUtilDE.getUtilParam12();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilParam12_Default((IEntity)pSDEUtilDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_UtilParam2(boolean bl, PSDEUtilDE pSDEUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUtilDE.isUtilParam2Dirty() : !pSDEUtilDE.isUtilParam2Dirty()) {
            return null;
        }
        String string = pSDEUtilDE.getUtilParam2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilParam2_Default((IEntity)pSDEUtilDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_UtilParam3(boolean bl, PSDEUtilDE pSDEUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUtilDE.isUtilParam3Dirty() : !pSDEUtilDE.isUtilParam3Dirty()) {
            return null;
        }
        String string = pSDEUtilDE.getUtilParam3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilParam3_Default((IEntity)pSDEUtilDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_UtilParam4(boolean bl, PSDEUtilDE pSDEUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUtilDE.isUtilParam4Dirty() : !pSDEUtilDE.isUtilParam4Dirty()) {
            return null;
        }
        String string = pSDEUtilDE.getUtilParam4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilParam4_Default((IEntity)pSDEUtilDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_UtilParam5(boolean bl, PSDEUtilDE pSDEUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUtilDE.isUtilParam5Dirty() : !pSDEUtilDE.isUtilParam5Dirty()) {
            return null;
        }
        Integer n = pSDEUtilDE.getUtilParam5();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_UtilParam5_Default((IEntity)pSDEUtilDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_UtilParam6(boolean bl, PSDEUtilDE pSDEUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUtilDE.isUtilParam6Dirty() : !pSDEUtilDE.isUtilParam6Dirty()) {
            return null;
        }
        Integer n = pSDEUtilDE.getUtilParam6();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_UtilParam6_Default((IEntity)pSDEUtilDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_UtilParam7(boolean bl, PSDEUtilDE pSDEUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUtilDE.isUtilParam7Dirty() : !pSDEUtilDE.isUtilParam7Dirty()) {
            return null;
        }
        Integer n = pSDEUtilDE.getUtilParam7();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_UtilParam7_Default((IEntity)pSDEUtilDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_UtilParam8(boolean bl, PSDEUtilDE pSDEUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUtilDE.isUtilParam8Dirty() : !pSDEUtilDE.isUtilParam8Dirty()) {
            return null;
        }
        Integer n = pSDEUtilDE.getUtilParam8();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_UtilParam8_Default((IEntity)pSDEUtilDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_UtilParam9(boolean bl, PSDEUtilDE pSDEUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUtilDE.isUtilParam9Dirty() : !pSDEUtilDE.isUtilParam9Dirty()) {
            return null;
        }
        Integer n = pSDEUtilDE.getUtilParam9();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_UtilParam9_Default((IEntity)pSDEUtilDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_UtilParams(boolean bl, PSDEUtilDE pSDEUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUtilDE.isUtilParamsDirty() : !pSDEUtilDE.isUtilParamsDirty()) {
            return null;
        }
        String string = pSDEUtilDE.getUtilParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilParams_Default((IEntity)pSDEUtilDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_UtilPSDE10Id(boolean bl, PSDEUtilDE pSDEUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUtilDE.isUtilPSDE10IdDirty() : !pSDEUtilDE.isUtilPSDE10IdDirty()) {
            return null;
        }
        String string = pSDEUtilDE.getUtilPSDE10Id();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDE10Id_Default((IEntity)pSDEUtilDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_UtilPSDE10Name(boolean bl, PSDEUtilDE pSDEUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUtilDE.isUtilPSDE10NameDirty() : !pSDEUtilDE.isUtilPSDE10NameDirty()) {
            return null;
        }
        String string = pSDEUtilDE.getUtilPSDE10Name();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDE10Name_Default((IEntity)pSDEUtilDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_UtilPSDE11Id(boolean bl, PSDEUtilDE pSDEUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUtilDE.isUtilPSDE11IdDirty() : !pSDEUtilDE.isUtilPSDE11IdDirty()) {
            return null;
        }
        String string = pSDEUtilDE.getUtilPSDE11Id();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDE11Id_Default((IEntity)pSDEUtilDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_UtilPSDE11Name(boolean bl, PSDEUtilDE pSDEUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUtilDE.isUtilPSDE11NameDirty() : !pSDEUtilDE.isUtilPSDE11NameDirty()) {
            return null;
        }
        String string = pSDEUtilDE.getUtilPSDE11Name();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDE11Name_Default((IEntity)pSDEUtilDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_UtilPSDE12Id(boolean bl, PSDEUtilDE pSDEUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUtilDE.isUtilPSDE12IdDirty() : !pSDEUtilDE.isUtilPSDE12IdDirty()) {
            return null;
        }
        String string = pSDEUtilDE.getUtilPSDE12Id();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDE12Id_Default((IEntity)pSDEUtilDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_UtilPSDE12Name(boolean bl, PSDEUtilDE pSDEUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUtilDE.isUtilPSDE12NameDirty() : !pSDEUtilDE.isUtilPSDE12NameDirty()) {
            return null;
        }
        String string = pSDEUtilDE.getUtilPSDE12Name();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDE12Name_Default((IEntity)pSDEUtilDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_UtilPSDE13Id(boolean bl, PSDEUtilDE pSDEUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUtilDE.isUtilPSDE13IdDirty() : !pSDEUtilDE.isUtilPSDE13IdDirty()) {
            return null;
        }
        String string = pSDEUtilDE.getUtilPSDE13Id();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDE13Id_Default((IEntity)pSDEUtilDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_UtilPSDE13Name(boolean bl, PSDEUtilDE pSDEUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUtilDE.isUtilPSDE13NameDirty() : !pSDEUtilDE.isUtilPSDE13NameDirty()) {
            return null;
        }
        String string = pSDEUtilDE.getUtilPSDE13Name();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDE13Name_Default((IEntity)pSDEUtilDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_UtilPSDE14Id(boolean bl, PSDEUtilDE pSDEUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUtilDE.isUtilPSDE14IdDirty() : !pSDEUtilDE.isUtilPSDE14IdDirty()) {
            return null;
        }
        String string = pSDEUtilDE.getUtilPSDE14Id();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDE14Id_Default((IEntity)pSDEUtilDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_UtilPSDE14Name(boolean bl, PSDEUtilDE pSDEUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUtilDE.isUtilPSDE14NameDirty() : !pSDEUtilDE.isUtilPSDE14NameDirty()) {
            return null;
        }
        String string = pSDEUtilDE.getUtilPSDE14Name();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDE14Name_Default((IEntity)pSDEUtilDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_UtilPSDE15Id(boolean bl, PSDEUtilDE pSDEUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUtilDE.isUtilPSDE15IdDirty() : !pSDEUtilDE.isUtilPSDE15IdDirty()) {
            return null;
        }
        String string = pSDEUtilDE.getUtilPSDE15Id();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDE15Id_Default((IEntity)pSDEUtilDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_UtilPSDE15Name(boolean bl, PSDEUtilDE pSDEUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUtilDE.isUtilPSDE15NameDirty() : !pSDEUtilDE.isUtilPSDE15NameDirty()) {
            return null;
        }
        String string = pSDEUtilDE.getUtilPSDE15Name();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDE15Name_Default((IEntity)pSDEUtilDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_UtilPSDE16Id(boolean bl, PSDEUtilDE pSDEUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUtilDE.isUtilPSDE16IdDirty() : !pSDEUtilDE.isUtilPSDE16IdDirty()) {
            return null;
        }
        String string = pSDEUtilDE.getUtilPSDE16Id();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDE16Id_Default((IEntity)pSDEUtilDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_UtilPSDE16Name(boolean bl, PSDEUtilDE pSDEUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUtilDE.isUtilPSDE16NameDirty() : !pSDEUtilDE.isUtilPSDE16NameDirty()) {
            return null;
        }
        String string = pSDEUtilDE.getUtilPSDE16Name();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDE16Name_Default((IEntity)pSDEUtilDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_UtilPSDE17Id(boolean bl, PSDEUtilDE pSDEUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUtilDE.isUtilPSDE17IdDirty() : !pSDEUtilDE.isUtilPSDE17IdDirty()) {
            return null;
        }
        String string = pSDEUtilDE.getUtilPSDE17Id();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDE17Id_Default((IEntity)pSDEUtilDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_UtilPSDE17Name(boolean bl, PSDEUtilDE pSDEUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUtilDE.isUtilPSDE17NameDirty() : !pSDEUtilDE.isUtilPSDE17NameDirty()) {
            return null;
        }
        String string = pSDEUtilDE.getUtilPSDE17Name();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDE17Name_Default((IEntity)pSDEUtilDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_UtilPSDE18Id(boolean bl, PSDEUtilDE pSDEUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUtilDE.isUtilPSDE18IdDirty() : !pSDEUtilDE.isUtilPSDE18IdDirty()) {
            return null;
        }
        String string = pSDEUtilDE.getUtilPSDE18Id();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDE18Id_Default((IEntity)pSDEUtilDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_UtilPSDE18Name(boolean bl, PSDEUtilDE pSDEUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUtilDE.isUtilPSDE18NameDirty() : !pSDEUtilDE.isUtilPSDE18NameDirty()) {
            return null;
        }
        String string = pSDEUtilDE.getUtilPSDE18Name();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDE18Name_Default((IEntity)pSDEUtilDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_UtilPSDE19Id(boolean bl, PSDEUtilDE pSDEUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUtilDE.isUtilPSDE19IdDirty() : !pSDEUtilDE.isUtilPSDE19IdDirty()) {
            return null;
        }
        String string = pSDEUtilDE.getUtilPSDE19Id();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDE19Id_Default((IEntity)pSDEUtilDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_UtilPSDE19Name(boolean bl, PSDEUtilDE pSDEUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUtilDE.isUtilPSDE19NameDirty() : !pSDEUtilDE.isUtilPSDE19NameDirty()) {
            return null;
        }
        String string = pSDEUtilDE.getUtilPSDE19Name();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDE19Name_Default((IEntity)pSDEUtilDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_UtilPSDE20Id(boolean bl, PSDEUtilDE pSDEUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUtilDE.isUtilPSDE20IdDirty() : !pSDEUtilDE.isUtilPSDE20IdDirty()) {
            return null;
        }
        String string = pSDEUtilDE.getUtilPSDE20Id();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDE20Id_Default((IEntity)pSDEUtilDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_UtilPSDE20Name(boolean bl, PSDEUtilDE pSDEUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUtilDE.isUtilPSDE20NameDirty() : !pSDEUtilDE.isUtilPSDE20NameDirty()) {
            return null;
        }
        String string = pSDEUtilDE.getUtilPSDE20Name();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDE20Name_Default((IEntity)pSDEUtilDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_UtilPSDE2Id(boolean bl, PSDEUtilDE pSDEUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUtilDE.isUtilPSDE2IdDirty() : !pSDEUtilDE.isUtilPSDE2IdDirty()) {
            return null;
        }
        String string = pSDEUtilDE.getUtilPSDE2Id();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDE2Id_Default((IEntity)pSDEUtilDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_UtilPSDE2Name(boolean bl, PSDEUtilDE pSDEUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUtilDE.isUtilPSDE2NameDirty() : !pSDEUtilDE.isUtilPSDE2NameDirty()) {
            return null;
        }
        String string = pSDEUtilDE.getUtilPSDE2Name();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDE2Name_Default((IEntity)pSDEUtilDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_UtilPSDE3Id(boolean bl, PSDEUtilDE pSDEUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUtilDE.isUtilPSDE3IdDirty() : !pSDEUtilDE.isUtilPSDE3IdDirty()) {
            return null;
        }
        String string = pSDEUtilDE.getUtilPSDE3Id();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDE3Id_Default((IEntity)pSDEUtilDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_UtilPSDE3Name(boolean bl, PSDEUtilDE pSDEUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUtilDE.isUtilPSDE3NameDirty() : !pSDEUtilDE.isUtilPSDE3NameDirty()) {
            return null;
        }
        String string = pSDEUtilDE.getUtilPSDE3Name();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDE3Name_Default((IEntity)pSDEUtilDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_UtilPSDE4Id(boolean bl, PSDEUtilDE pSDEUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUtilDE.isUtilPSDE4IdDirty() : !pSDEUtilDE.isUtilPSDE4IdDirty()) {
            return null;
        }
        String string = pSDEUtilDE.getUtilPSDE4Id();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDE4Id_Default((IEntity)pSDEUtilDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_UtilPSDE4Name(boolean bl, PSDEUtilDE pSDEUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUtilDE.isUtilPSDE4NameDirty() : !pSDEUtilDE.isUtilPSDE4NameDirty()) {
            return null;
        }
        String string = pSDEUtilDE.getUtilPSDE4Name();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDE4Name_Default((IEntity)pSDEUtilDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_UtilPSDE5Id(boolean bl, PSDEUtilDE pSDEUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUtilDE.isUtilPSDE5IdDirty() : !pSDEUtilDE.isUtilPSDE5IdDirty()) {
            return null;
        }
        String string = pSDEUtilDE.getUtilPSDE5Id();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDE5Id_Default((IEntity)pSDEUtilDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_UtilPSDE5Name(boolean bl, PSDEUtilDE pSDEUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUtilDE.isUtilPSDE5NameDirty() : !pSDEUtilDE.isUtilPSDE5NameDirty()) {
            return null;
        }
        String string = pSDEUtilDE.getUtilPSDE5Name();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDE5Name_Default((IEntity)pSDEUtilDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_UtilPSDE6Id(boolean bl, PSDEUtilDE pSDEUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUtilDE.isUtilPSDE6IdDirty() : !pSDEUtilDE.isUtilPSDE6IdDirty()) {
            return null;
        }
        String string = pSDEUtilDE.getUtilPSDE6Id();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDE6Id_Default((IEntity)pSDEUtilDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_UtilPSDE6Name(boolean bl, PSDEUtilDE pSDEUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUtilDE.isUtilPSDE6NameDirty() : !pSDEUtilDE.isUtilPSDE6NameDirty()) {
            return null;
        }
        String string = pSDEUtilDE.getUtilPSDE6Name();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDE6Name_Default((IEntity)pSDEUtilDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_UtilPSDE7Id(boolean bl, PSDEUtilDE pSDEUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUtilDE.isUtilPSDE7IdDirty() : !pSDEUtilDE.isUtilPSDE7IdDirty()) {
            return null;
        }
        String string = pSDEUtilDE.getUtilPSDE7Id();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDE7Id_Default((IEntity)pSDEUtilDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_UtilPSDE7Name(boolean bl, PSDEUtilDE pSDEUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUtilDE.isUtilPSDE7NameDirty() : !pSDEUtilDE.isUtilPSDE7NameDirty()) {
            return null;
        }
        String string = pSDEUtilDE.getUtilPSDE7Name();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDE7Name_Default((IEntity)pSDEUtilDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_UtilPSDE8Id(boolean bl, PSDEUtilDE pSDEUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUtilDE.isUtilPSDE8IdDirty() : !pSDEUtilDE.isUtilPSDE8IdDirty()) {
            return null;
        }
        String string = pSDEUtilDE.getUtilPSDE8Id();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDE8Id_Default((IEntity)pSDEUtilDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_UtilPSDE8Name(boolean bl, PSDEUtilDE pSDEUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUtilDE.isUtilPSDE8NameDirty() : !pSDEUtilDE.isUtilPSDE8NameDirty()) {
            return null;
        }
        String string = pSDEUtilDE.getUtilPSDE8Name();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDE8Name_Default((IEntity)pSDEUtilDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_UtilPSDE9Id(boolean bl, PSDEUtilDE pSDEUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUtilDE.isUtilPSDE9IdDirty() : !pSDEUtilDE.isUtilPSDE9IdDirty()) {
            return null;
        }
        String string = pSDEUtilDE.getUtilPSDE9Id();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDE9Id_Default((IEntity)pSDEUtilDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_UtilPSDE9Name(boolean bl, PSDEUtilDE pSDEUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUtilDE.isUtilPSDE9NameDirty() : !pSDEUtilDE.isUtilPSDE9NameDirty()) {
            return null;
        }
        String string = pSDEUtilDE.getUtilPSDE9Name();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDE9Name_Default((IEntity)pSDEUtilDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_UtilPSDEId(boolean bl, PSDEUtilDE pSDEUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUtilDE.isUtilPSDEIdDirty() : !pSDEUtilDE.isUtilPSDEIdDirty()) {
            return null;
        }
        String string = pSDEUtilDE.getUtilPSDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDEId_Default((IEntity)pSDEUtilDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_UtilPSDEName(boolean bl, PSDEUtilDE pSDEUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUtilDE.isUtilPSDENameDirty() : !pSDEUtilDE.isUtilPSDENameDirty()) {
            return null;
        }
        String string = pSDEUtilDE.getUtilPSDEName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDEName_Default((IEntity)pSDEUtilDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_UtilTag(boolean bl, PSDEUtilDE pSDEUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUtilDE.isUtilTagDirty() : !pSDEUtilDE.isUtilTagDirty()) {
            return null;
        }
        String string = pSDEUtilDE.getUtilTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilTag_Default((IEntity)pSDEUtilDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_UtilTag2(boolean bl, PSDEUtilDE pSDEUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUtilDE.isUtilTag2Dirty() : !pSDEUtilDE.isUtilTag2Dirty()) {
            return null;
        }
        String string = pSDEUtilDE.getUtilTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilTag2_Default((IEntity)pSDEUtilDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_UtilType(boolean bl, PSDEUtilDE pSDEUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUtilDE.isUtilTypeDirty() && !bl2 : !pSDEUtilDE.isUtilTypeDirty()) {
            return null;
        }
        String string = pSDEUtilDE.getUtilType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilType_Default((IEntity)pSDEUtilDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDEUtilDE pSDEUtilDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUtilDE.isValidFlagDirty() && !bl2 : !pSDEUtilDE.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDEUtilDE.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSDEUtilDE, bl2, bl3);
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

    protected void onSyncEntity(PSDEUtilDE pSDEUtilDE, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDEUtilDE, bl);
    }

    protected void onSyncIndexEntities(PSDEUtilDE pSDEUtilDE, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDEUtilDE, bl);
    }

    public Object getDataContextValue(PSDEUtilDE pSDEUtilDE, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDEUtilDE, string, iDataContextParam)) != null) {
            return object;
        }
        PSDataEntity pSDataEntity = pSDEUtilDE.getPSDE();
        if (pSDataEntity != null && pSDataEntity.contains(string)) {
            return pSDataEntity.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDEUtilDE pSDEUtilDE, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDEUtilDE, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"EXTENDMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ExtendMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOCKFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LockFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEUTILDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEUtilDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEUTILDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEUtilDEName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSSYSSFPLUGINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSFPluginId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSFPLUGINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSFPluginName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_ExtendMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_PSDEUtilDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEUTILDEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEUtilDEName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEUTILDENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSDEUtilDE pSDEUtilDE) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDEUtilDE)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDEUtilDE pSDEUtilDE) throws Exception {
        super.onUpdateParent((IEntity)pSDEUtilDE);
    }

    @Override
    protected void exportCurXmlModel(PSDEUtilDE pSDEUtilDE, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEUTILDE");
        if (!bl) {
            pSDEUtilDE.setCreateDate(null);
            pSDEUtilDE.setCreateMan(null);
            pSDEUtilDE.setPSDEUtilDEId(null);
            pSDEUtilDE.setUniqueTag(null);
            pSDEUtilDE.setUpdateDate(null);
            pSDEUtilDE.setUpdateMan(null);
            super.exportCurXmlModel(pSDEUtilDE, xmlNode, bl);
        }
    }

    @Override
    protected String getEntityFolderKeyValue(PSDEUtilDE pSDEUtilDE, PSSystem pSSystem) throws Exception {
        PSDEUtilDE pSDEUtilDE2 = new PSDEUtilDE();
        pSDEUtilDE2.setPSDEId(pSDEUtilDE.getPSDEId());
        pSDEUtilDE2.setUtilType(pSDEUtilDE.getUtilType());
        pSDEUtilDE2.setUtilTag(pSDEUtilDE.getUtilTag());
        if (this.selectOne((IEntity)pSDEUtilDE2, true)) {
            return pSDEUtilDE2.getPSDEUtilDEId();
        }
        return super.getEntityFolderKeyValue(pSDEUtilDE, pSSystem);
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDEUtilDE pSDEUtilDE, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDEUtilDE, string);
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
            return "DER1N_PSDEUTILDE_PSDATAENTITY_PSDEID";
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
    public String getModelV2Tag(PSDEUtilDE pSDEUtilDE) {
        if (!StringHelper.isNullOrEmpty((String)pSDEUtilDE.getCodeName())) {
            return pSDEUtilDE.getCodeName();
        }
        return super.getModelV2Tag(pSDEUtilDE);
    }

    @Override
    public boolean setModelV2Tag(PSDEUtilDE pSDEUtilDE, String string) {
        pSDEUtilDE.setCodeName(string);
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
    public boolean getModelV2Entity(PSDEUtilDE pSDEUtilDE, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDEUtilDE.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDEUtilDE, true);
        pSDEUtilDE.set("CODENAME", string);
        if (this.select(pSDEUtilDE, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSDEUtilDE, true);
        return super.getModelV2Entity(pSDEUtilDE, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDEUtilDE pSDEUtilDE, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSDEUtilDE, objectNode, string, string2, n);
    }

    @Override
    public Object getDataType(PSDEUtilDE pSDEUtilDE) throws Exception {
        return pSDEUtilDE.getUtilType();
    }
}

