/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.PostConstruct
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.dao.DAOGlobal
 *  net.ibizsys.paas.dao.IDAO
 *  net.ibizsys.paas.db.DBFetchResult
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.EntityError
 *  net.ibizsys.paas.entity.EntityFieldError
 *  net.ibizsys.paas.entity.IEntity
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

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.EntityError;
import net.ibizsys.paas.entity.EntityFieldError;
import net.ibizsys.paas.entity.IEntity;
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
import net.ibizsys.pscore.srv.devcenter.entity.PSDCBDInst;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCBDInstBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCDeployServer;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCDeployServerBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterAS;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterASBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterDBInst;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterDBInstBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterSVN;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterSVNBase;
import net.ibizsys.pscore.srv.sysdesign.dao.PSDevSlnSysResDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSlnSysResDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysRes;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevSlnSysResServiceBase
extends PSCoreSysServiceBase<PSDevSlnSysRes> {
    private static final Log log = LogFactory.getLog(PSDevSlnSysResServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDevSlnSysResDEModel pSDevSlnSysResDEModel;
    private PSDevSlnSysResDAO pSDevSlnSysResDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysResService";
    }

    public PSDevSlnSysResDEModel getPSDevSlnSysResDEModel() {
        if (this.pSDevSlnSysResDEModel == null) {
            try {
                this.pSDevSlnSysResDEModel = (PSDevSlnSysResDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSlnSysResDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSlnSysResDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDevSlnSysResDEModel();
    }

    public PSDevSlnSysResDAO getPSDevSlnSysResDAO() {
        if (this.pSDevSlnSysResDAO == null) {
            try {
                this.pSDevSlnSysResDAO = (PSDevSlnSysResDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSDevSlnSysResDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSlnSysResDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDevSlnSysResDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSDevSlnSysRes pSDevSlnSysRes, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYSRES_PSDCBDINST_HBASEPSDCBDINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCBDInstService", (SessionFactory)this.getSessionFactory());
            PSDCBDInst pSDCBDInst = (PSDCBDInst)iService.getDEModel().createEntity();
            pSDCBDInst.set("PSDCBDINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDCBDInst);
            } else {
                iService.get(pSDCBDInst);
            }
            this.onFillParentInfo_HBasePSDCBDInst(pSDevSlnSysRes, pSDCBDInst);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYSRES_PSDCBDINST_UHBASEPSDCBDINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCBDInstService", (SessionFactory)this.getSessionFactory());
            PSDCBDInst pSDCBDInst = (PSDCBDInst)iService.getDEModel().createEntity();
            pSDCBDInst.set("PSDCBDINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDCBDInst);
            } else {
                iService.get(pSDCBDInst);
            }
            this.onFillParentInfo_UHBasePSDCBDInst(pSDevSlnSysRes, pSDCBDInst);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYSRES_PSDCDEPLOYSERVER_PSDCDEPLOYSERVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCDeployServerService", (SessionFactory)this.getSessionFactory());
            PSDCDeployServer pSDCDeployServer = (PSDCDeployServer)iService.getDEModel().createEntity();
            pSDCDeployServer.set("PSDCDEPLOYSERVERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDCDeployServer);
            } else {
                iService.get(pSDCDeployServer);
            }
            this.onFillParentInfo_PSDCDeployServer(pSDevSlnSysRes, pSDCDeployServer);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYSRES_PSDEVCENTERAS_PSDEVCENTERASID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterASService", (SessionFactory)this.getSessionFactory());
            PSDevCenterAS pSDevCenterAS = (PSDevCenterAS)iService.getDEModel().createEntity();
            pSDevCenterAS.set("PSDEVCENTERASID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenterAS);
            } else {
                iService.get(pSDevCenterAS);
            }
            this.onFillParentInfo_PSDevCenterAS(pSDevSlnSysRes, pSDevCenterAS);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYSRES_PSDEVCENTERAS_PSDEVCENTERASID2", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterASService", (SessionFactory)this.getSessionFactory());
            PSDevCenterAS pSDevCenterAS = (PSDevCenterAS)iService.getDEModel().createEntity();
            pSDevCenterAS.set("PSDEVCENTERASID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenterAS);
            } else {
                iService.get(pSDevCenterAS);
            }
            this.onFillParentInfo_PSDevCenterAS2(pSDevSlnSysRes, pSDevCenterAS);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYSRES_PSDEVCENTERAS_UPSDEVCENTERASID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterASService", (SessionFactory)this.getSessionFactory());
            PSDevCenterAS pSDevCenterAS = (PSDevCenterAS)iService.getDEModel().createEntity();
            pSDevCenterAS.set("PSDEVCENTERASID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenterAS);
            } else {
                iService.get(pSDevCenterAS);
            }
            this.onFillParentInfo_UPSDevCenterAS(pSDevSlnSysRes, pSDevCenterAS);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYSRES_PSDEVCENTERAS_UPSDEVCENTERASID2", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterASService", (SessionFactory)this.getSessionFactory());
            PSDevCenterAS pSDevCenterAS = (PSDevCenterAS)iService.getDEModel().createEntity();
            pSDevCenterAS.set("PSDEVCENTERASID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenterAS);
            } else {
                iService.get(pSDevCenterAS);
            }
            this.onFillParentInfo_UPSDevCenterAS2(pSDevSlnSysRes, pSDevCenterAS);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYSRES_PSDEVCENTERDBINST_DB2PSDCDBINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterDBInstService", (SessionFactory)this.getSessionFactory());
            PSDevCenterDBInst pSDevCenterDBInst = (PSDevCenterDBInst)iService.getDEModel().createEntity();
            pSDevCenterDBInst.set("PSDEVCENTERDBINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenterDBInst);
            } else {
                iService.get(pSDevCenterDBInst);
            }
            this.onFillParentInfo_DB2PSDCDBInst(pSDevSlnSysRes, pSDevCenterDBInst);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYSRES_PSDEVCENTERDBINST_MSSQLPSDCDBINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterDBInstService", (SessionFactory)this.getSessionFactory());
            PSDevCenterDBInst pSDevCenterDBInst = (PSDevCenterDBInst)iService.getDEModel().createEntity();
            pSDevCenterDBInst.set("PSDEVCENTERDBINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenterDBInst);
            } else {
                iService.get(pSDevCenterDBInst);
            }
            this.onFillParentInfo_MSSqlPSDCDBInst(pSDevSlnSysRes, pSDevCenterDBInst);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYSRES_PSDEVCENTERDBINST_MYSQLPSDCDBINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterDBInstService", (SessionFactory)this.getSessionFactory());
            PSDevCenterDBInst pSDevCenterDBInst = (PSDevCenterDBInst)iService.getDEModel().createEntity();
            pSDevCenterDBInst.set("PSDEVCENTERDBINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenterDBInst);
            } else {
                iService.get(pSDevCenterDBInst);
            }
            this.onFillParentInfo_MySQLPSDCDBInst(pSDevSlnSysRes, pSDevCenterDBInst);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYSRES_PSDEVCENTERDBINST_ORAPSDCDBINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterDBInstService", (SessionFactory)this.getSessionFactory());
            PSDevCenterDBInst pSDevCenterDBInst = (PSDevCenterDBInst)iService.getDEModel().createEntity();
            pSDevCenterDBInst.set("PSDEVCENTERDBINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenterDBInst);
            } else {
                iService.get(pSDevCenterDBInst);
            }
            this.onFillParentInfo_OraPSDCDBInst(pSDevSlnSysRes, pSDevCenterDBInst);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYSRES_PSDEVCENTERDBINST_PGSQLPSDCDBINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterDBInstService", (SessionFactory)this.getSessionFactory());
            PSDevCenterDBInst pSDevCenterDBInst = (PSDevCenterDBInst)iService.getDEModel().createEntity();
            pSDevCenterDBInst.set("PSDEVCENTERDBINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenterDBInst);
            } else {
                iService.get(pSDevCenterDBInst);
            }
            this.onFillParentInfo_PGSQLPSDCDBInst(pSDevSlnSysRes, pSDevCenterDBInst);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYSRES_PSDEVCENTERDBINST_PPASPSDCDBINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterDBInstService", (SessionFactory)this.getSessionFactory());
            PSDevCenterDBInst pSDevCenterDBInst = (PSDevCenterDBInst)iService.getDEModel().createEntity();
            pSDevCenterDBInst.set("PSDEVCENTERDBINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenterDBInst);
            } else {
                iService.get(pSDevCenterDBInst);
            }
            this.onFillParentInfo_PPASPSDCDBInst(pSDevSlnSysRes, pSDevCenterDBInst);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYSRES_PSDEVCENTERDBINST_UDB2PSDCDBINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterDBInstService", (SessionFactory)this.getSessionFactory());
            PSDevCenterDBInst pSDevCenterDBInst = (PSDevCenterDBInst)iService.getDEModel().createEntity();
            pSDevCenterDBInst.set("PSDEVCENTERDBINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenterDBInst);
            } else {
                iService.get(pSDevCenterDBInst);
            }
            this.onFillParentInfo_UDB2PSDCDBInst(pSDevSlnSysRes, pSDevCenterDBInst);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYSRES_PSDEVCENTERDBINST_UMSSQLPSDCDBINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterDBInstService", (SessionFactory)this.getSessionFactory());
            PSDevCenterDBInst pSDevCenterDBInst = (PSDevCenterDBInst)iService.getDEModel().createEntity();
            pSDevCenterDBInst.set("PSDEVCENTERDBINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenterDBInst);
            } else {
                iService.get(pSDevCenterDBInst);
            }
            this.onFillParentInfo_UMSSqlPSDCDBInst(pSDevSlnSysRes, pSDevCenterDBInst);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYSRES_PSDEVCENTERDBINST_UMYSQLPSDCDBINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterDBInstService", (SessionFactory)this.getSessionFactory());
            PSDevCenterDBInst pSDevCenterDBInst = (PSDevCenterDBInst)iService.getDEModel().createEntity();
            pSDevCenterDBInst.set("PSDEVCENTERDBINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenterDBInst);
            } else {
                iService.get(pSDevCenterDBInst);
            }
            this.onFillParentInfo_UMySQLPSDCDBInst(pSDevSlnSysRes, pSDevCenterDBInst);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYSRES_PSDEVCENTERDBINST_UORAPSDCDBINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterDBInstService", (SessionFactory)this.getSessionFactory());
            PSDevCenterDBInst pSDevCenterDBInst = (PSDevCenterDBInst)iService.getDEModel().createEntity();
            pSDevCenterDBInst.set("PSDEVCENTERDBINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenterDBInst);
            } else {
                iService.get(pSDevCenterDBInst);
            }
            this.onFillParentInfo_UOraPSDCDBInst(pSDevSlnSysRes, pSDevCenterDBInst);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYSRES_PSDEVCENTERDBINST_UPGSQLPSDCDBINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterDBInstService", (SessionFactory)this.getSessionFactory());
            PSDevCenterDBInst pSDevCenterDBInst = (PSDevCenterDBInst)iService.getDEModel().createEntity();
            pSDevCenterDBInst.set("PSDEVCENTERDBINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenterDBInst);
            } else {
                iService.get(pSDevCenterDBInst);
            }
            this.onFillParentInfo_UPGSQLPSDCDBInst(pSDevSlnSysRes, pSDevCenterDBInst);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYSRES_PSDEVCENTERDBINST_UPPASPSDCDBINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterDBInstService", (SessionFactory)this.getSessionFactory());
            PSDevCenterDBInst pSDevCenterDBInst = (PSDevCenterDBInst)iService.getDEModel().createEntity();
            pSDevCenterDBInst.set("PSDEVCENTERDBINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenterDBInst);
            } else {
                iService.get(pSDevCenterDBInst);
            }
            this.onFillParentInfo_UPPASPSDCDBInst(pSDevSlnSysRes, pSDevCenterDBInst);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYSRES_PSDEVCENTERSVN_PSDEVCENTERSVNID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterSVNService", (SessionFactory)this.getSessionFactory());
            PSDevCenterSVN pSDevCenterSVN = (PSDevCenterSVN)iService.getDEModel().createEntity();
            pSDevCenterSVN.set("PSDEVCENTERSVNID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenterSVN);
            } else {
                iService.get(pSDevCenterSVN);
            }
            this.onFillParentInfo_PSDevCenterSVN(pSDevSlnSysRes, pSDevCenterSVN);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYSRES_PSDEVCENTERSVN_ROPSDEVCENTERSVNID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterSVNService", (SessionFactory)this.getSessionFactory());
            PSDevCenterSVN pSDevCenterSVN = (PSDevCenterSVN)iService.getDEModel().createEntity();
            pSDevCenterSVN.set("PSDEVCENTERSVNID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenterSVN);
            } else {
                iService.get(pSDevCenterSVN);
            }
            this.onFillParentInfo_ROPSDevCenterSVN(pSDevSlnSysRes, pSDevCenterSVN);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYSRES_PSDEVSLN_PSDEVSLNID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService", (SessionFactory)this.getSessionFactory());
            PSDevSln pSDevSln = (PSDevSln)iService.getDEModel().createEntity();
            pSDevSln.set("PSDEVSLNID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevSln);
            } else {
                iService.get(pSDevSln);
            }
            this.onFillParentInfo_PSDevSln(pSDevSlnSysRes, pSDevSln);
            return;
        }
        super.onFillParentInfo(pSDevSlnSysRes, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_HBasePSDCBDInst(PSDevSlnSysRes pSDevSlnSysRes, PSDCBDInst pSDCBDInst) throws Exception {
        pSDevSlnSysRes.setHBasePSDCBDInstId(pSDCBDInst.getPSDCBDInstId());
        pSDevSlnSysRes.setHBasePSDCBDInstName(pSDCBDInst.getPSDCBDInstName());
    }

    protected void onFillParentInfo_UHBasePSDCBDInst(PSDevSlnSysRes pSDevSlnSysRes, PSDCBDInst pSDCBDInst) throws Exception {
        pSDevSlnSysRes.setUHBasePSDCBDInstId(pSDCBDInst.getPSDCBDInstId());
        pSDevSlnSysRes.setUHBasePSDCBDInstName(pSDCBDInst.getPSDCBDInstName());
    }

    protected void onFillParentInfo_PSDCDeployServer(PSDevSlnSysRes pSDevSlnSysRes, PSDCDeployServer pSDCDeployServer) throws Exception {
        pSDevSlnSysRes.setPSDCDeployServerId(pSDCDeployServer.getPSDCDeployServerId());
        pSDevSlnSysRes.setPSDCDeployServerName(pSDCDeployServer.getPSDCDeployServerName());
    }

    protected void onFillParentInfo_PSDevCenterAS(PSDevSlnSysRes pSDevSlnSysRes, PSDevCenterAS pSDevCenterAS) throws Exception {
        pSDevSlnSysRes.setPSDevCenterASId(pSDevCenterAS.getPSDevCenterASId());
        pSDevSlnSysRes.setPSDevCenterASName(pSDevCenterAS.getPSDevCenterASName());
    }

    protected void onFillParentInfo_PSDevCenterAS2(PSDevSlnSysRes pSDevSlnSysRes, PSDevCenterAS pSDevCenterAS) throws Exception {
        pSDevSlnSysRes.setPSDevCenterASId2(pSDevCenterAS.getPSDevCenterASId());
        pSDevSlnSysRes.setPSDevCenterASName2(pSDevCenterAS.getPSDevCenterASName());
    }

    protected void onFillParentInfo_UPSDevCenterAS(PSDevSlnSysRes pSDevSlnSysRes, PSDevCenterAS pSDevCenterAS) throws Exception {
        pSDevSlnSysRes.setUPSDevCenterASId(pSDevCenterAS.getPSDevCenterASId());
        pSDevSlnSysRes.setUPSDevCenterASName(pSDevCenterAS.getPSDevCenterASName());
    }

    protected void onFillParentInfo_UPSDevCenterAS2(PSDevSlnSysRes pSDevSlnSysRes, PSDevCenterAS pSDevCenterAS) throws Exception {
        pSDevSlnSysRes.setUPSDevCenterASId2(pSDevCenterAS.getPSDevCenterASId());
        pSDevSlnSysRes.setUPSDevCenterASName2(pSDevCenterAS.getPSDevCenterASName());
    }

    protected void onFillParentInfo_DB2PSDCDBInst(PSDevSlnSysRes pSDevSlnSysRes, PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        pSDevSlnSysRes.setDB2PSDCDBInstId(pSDevCenterDBInst.getPSDevCenterDBInstId());
        pSDevSlnSysRes.setDB2PSDCDBInstName(pSDevCenterDBInst.getPSDevCenterDBInstName());
    }

    protected void onFillParentInfo_MSSqlPSDCDBInst(PSDevSlnSysRes pSDevSlnSysRes, PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        pSDevSlnSysRes.setMSSQLPSDCDBInstId(pSDevCenterDBInst.getPSDevCenterDBInstId());
        pSDevSlnSysRes.setMSSQLPSDCDBInstName(pSDevCenterDBInst.getPSDevCenterDBInstName());
    }

    protected void onFillParentInfo_MySQLPSDCDBInst(PSDevSlnSysRes pSDevSlnSysRes, PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        pSDevSlnSysRes.setMySQLPSDCDBInstId(pSDevCenterDBInst.getPSDevCenterDBInstId());
        pSDevSlnSysRes.setMySQLPSDCDBInstName(pSDevCenterDBInst.getPSDevCenterDBInstName());
    }

    protected void onFillParentInfo_OraPSDCDBInst(PSDevSlnSysRes pSDevSlnSysRes, PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        pSDevSlnSysRes.setOraPSDCDBInstId(pSDevCenterDBInst.getPSDevCenterDBInstId());
        pSDevSlnSysRes.setOraPSDCDBInstName(pSDevCenterDBInst.getPSDevCenterDBInstName());
    }

    protected void onFillParentInfo_PGSQLPSDCDBInst(PSDevSlnSysRes pSDevSlnSysRes, PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        pSDevSlnSysRes.setPGSQLPSDCDBInstId(pSDevCenterDBInst.getPSDevCenterDBInstId());
        pSDevSlnSysRes.setPGSQLPSDCDBInstName(pSDevCenterDBInst.getPSDevCenterDBInstName());
    }

    protected void onFillParentInfo_PPASPSDCDBInst(PSDevSlnSysRes pSDevSlnSysRes, PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        pSDevSlnSysRes.setPPASPSDCDBInstId(pSDevCenterDBInst.getPSDevCenterDBInstId());
        pSDevSlnSysRes.setPPASPSDCDBInstName(pSDevCenterDBInst.getPSDevCenterDBInstName());
    }

    protected void onFillParentInfo_UDB2PSDCDBInst(PSDevSlnSysRes pSDevSlnSysRes, PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        pSDevSlnSysRes.setUDB2PSDCDBInstId(pSDevCenterDBInst.getPSDevCenterDBInstId());
        pSDevSlnSysRes.setUDB2PSDCDBInstName(pSDevCenterDBInst.getPSDevCenterDBInstName());
    }

    protected void onFillParentInfo_UMSSqlPSDCDBInst(PSDevSlnSysRes pSDevSlnSysRes, PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        pSDevSlnSysRes.setUMSSQLPSDCDBInstId(pSDevCenterDBInst.getPSDevCenterDBInstId());
        pSDevSlnSysRes.setUMSSQLPSDCDBInstName(pSDevCenterDBInst.getPSDevCenterDBInstName());
    }

    protected void onFillParentInfo_UMySQLPSDCDBInst(PSDevSlnSysRes pSDevSlnSysRes, PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        pSDevSlnSysRes.setUMySQLPSDCDBInstId(pSDevCenterDBInst.getPSDevCenterDBInstId());
        pSDevSlnSysRes.setUMySQLPSDCDBInstName(pSDevCenterDBInst.getPSDevCenterDBInstName());
    }

    protected void onFillParentInfo_UOraPSDCDBInst(PSDevSlnSysRes pSDevSlnSysRes, PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        pSDevSlnSysRes.setUOraPSDCDBInstId(pSDevCenterDBInst.getPSDevCenterDBInstId());
        pSDevSlnSysRes.setUOraPSDCDBInstName(pSDevCenterDBInst.getPSDevCenterDBInstName());
    }

    protected void onFillParentInfo_UPGSQLPSDCDBInst(PSDevSlnSysRes pSDevSlnSysRes, PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        pSDevSlnSysRes.setUPGSQLPSDCDBInstId(pSDevCenterDBInst.getPSDevCenterDBInstId());
        pSDevSlnSysRes.setUPGSQLPSDCDBInstName(pSDevCenterDBInst.getPSDevCenterDBInstName());
    }

    protected void onFillParentInfo_UPPASPSDCDBInst(PSDevSlnSysRes pSDevSlnSysRes, PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        pSDevSlnSysRes.setUPPASPSDCDBInstId(pSDevCenterDBInst.getPSDevCenterDBInstId());
        pSDevSlnSysRes.setUPPASPSDCDBInstName(pSDevCenterDBInst.getPSDevCenterDBInstName());
    }

    protected void onFillParentInfo_PSDevCenterSVN(PSDevSlnSysRes pSDevSlnSysRes, PSDevCenterSVN pSDevCenterSVN) throws Exception {
        pSDevSlnSysRes.setPSDevCenterSVNId(pSDevCenterSVN.getPSDevCenterSVNId());
        pSDevSlnSysRes.setPSDevCenterSVNName(pSDevCenterSVN.getPSDevCenterSVNName());
    }

    protected void onFillParentInfo_ROPSDevCenterSVN(PSDevSlnSysRes pSDevSlnSysRes, PSDevCenterSVN pSDevCenterSVN) throws Exception {
        pSDevSlnSysRes.setROPSDevCenterSvnId(pSDevCenterSVN.getPSDevCenterSVNId());
        pSDevSlnSysRes.setROPSDevCenterSvnName(pSDevCenterSVN.getPSDevCenterSVNName());
    }

    protected void onFillParentInfo_PSDevSln(PSDevSlnSysRes pSDevSlnSysRes, PSDevSln pSDevSln) throws Exception {
        pSDevSlnSysRes.setPSDevSlnId(pSDevSln.getPSDevSlnId());
        pSDevSlnSysRes.setPSDevSlnName(pSDevSln.getPSDevSlnName());
    }

    protected void onFillEntityFullInfo(PSDevSlnSysRes pSDevSlnSysRes, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSDevSlnSysRes, bl);
        this.onFillEntityFullInfo_HBasePSDCBDInst(pSDevSlnSysRes, bl);
        this.onFillEntityFullInfo_UHBasePSDCBDInst(pSDevSlnSysRes, bl);
        this.onFillEntityFullInfo_PSDCDeployServer(pSDevSlnSysRes, bl);
        this.onFillEntityFullInfo_PSDevCenterAS(pSDevSlnSysRes, bl);
        this.onFillEntityFullInfo_PSDevCenterAS2(pSDevSlnSysRes, bl);
        this.onFillEntityFullInfo_UPSDevCenterAS(pSDevSlnSysRes, bl);
        this.onFillEntityFullInfo_UPSDevCenterAS2(pSDevSlnSysRes, bl);
        this.onFillEntityFullInfo_DB2PSDCDBInst(pSDevSlnSysRes, bl);
        this.onFillEntityFullInfo_MSSqlPSDCDBInst(pSDevSlnSysRes, bl);
        this.onFillEntityFullInfo_MySQLPSDCDBInst(pSDevSlnSysRes, bl);
        this.onFillEntityFullInfo_OraPSDCDBInst(pSDevSlnSysRes, bl);
        this.onFillEntityFullInfo_PGSQLPSDCDBInst(pSDevSlnSysRes, bl);
        this.onFillEntityFullInfo_PPASPSDCDBInst(pSDevSlnSysRes, bl);
        this.onFillEntityFullInfo_UDB2PSDCDBInst(pSDevSlnSysRes, bl);
        this.onFillEntityFullInfo_UMSSqlPSDCDBInst(pSDevSlnSysRes, bl);
        this.onFillEntityFullInfo_UMySQLPSDCDBInst(pSDevSlnSysRes, bl);
        this.onFillEntityFullInfo_UOraPSDCDBInst(pSDevSlnSysRes, bl);
        this.onFillEntityFullInfo_UPGSQLPSDCDBInst(pSDevSlnSysRes, bl);
        this.onFillEntityFullInfo_UPPASPSDCDBInst(pSDevSlnSysRes, bl);
        this.onFillEntityFullInfo_PSDevCenterSVN(pSDevSlnSysRes, bl);
        this.onFillEntityFullInfo_ROPSDevCenterSVN(pSDevSlnSysRes, bl);
        this.onFillEntityFullInfo_PSDevSln(pSDevSlnSysRes, bl);
    }

    protected void onFillEntityFullInfo_HBasePSDCBDInst(PSDevSlnSysRes pSDevSlnSysRes, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_UHBasePSDCBDInst(PSDevSlnSysRes pSDevSlnSysRes, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDCDeployServer(PSDevSlnSysRes pSDevSlnSysRes, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevCenterAS(PSDevSlnSysRes pSDevSlnSysRes, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevCenterAS2(PSDevSlnSysRes pSDevSlnSysRes, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_UPSDevCenterAS(PSDevSlnSysRes pSDevSlnSysRes, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_UPSDevCenterAS2(PSDevSlnSysRes pSDevSlnSysRes, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_DB2PSDCDBInst(PSDevSlnSysRes pSDevSlnSysRes, boolean bl) throws Exception {
        if (pSDevSlnSysRes.isDB2PSDCDBInstIdDirty()) {
            if (pSDevSlnSysRes.getDB2PSDCDBInstId() != null) {
                if (pSDevSlnSysRes.getDB2PSDCDBInstId() == null || pSDevSlnSysRes.getDB2PSDCDBInstName() == null) {
                    PSDevCenterDBInst pSDevCenterDBInst = pSDevSlnSysRes.getDB2PSDCDBInst();
                    pSDevSlnSysRes.setDB2PSDCDBInstName(pSDevCenterDBInst.getPSDevCenterDBInstName());
                }
            } else {
                pSDevSlnSysRes.setDB2PSDCDBInstName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_MSSqlPSDCDBInst(PSDevSlnSysRes pSDevSlnSysRes, boolean bl) throws Exception {
        if (pSDevSlnSysRes.isMSSQLPSDCDBInstIdDirty()) {
            if (pSDevSlnSysRes.getMSSQLPSDCDBInstId() != null) {
                if (pSDevSlnSysRes.getMSSQLPSDCDBInstId() == null || pSDevSlnSysRes.getMSSQLPSDCDBInstName() == null) {
                    PSDevCenterDBInst pSDevCenterDBInst = pSDevSlnSysRes.getMSSqlPSDCDBInst();
                    pSDevSlnSysRes.setMSSQLPSDCDBInstName(pSDevCenterDBInst.getPSDevCenterDBInstName());
                }
            } else {
                pSDevSlnSysRes.setMSSQLPSDCDBInstName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_MySQLPSDCDBInst(PSDevSlnSysRes pSDevSlnSysRes, boolean bl) throws Exception {
        if (pSDevSlnSysRes.isMySQLPSDCDBInstIdDirty()) {
            if (pSDevSlnSysRes.getMySQLPSDCDBInstId() != null) {
                if (pSDevSlnSysRes.getMySQLPSDCDBInstId() == null || pSDevSlnSysRes.getMySQLPSDCDBInstName() == null) {
                    PSDevCenterDBInst pSDevCenterDBInst = pSDevSlnSysRes.getMySQLPSDCDBInst();
                    pSDevSlnSysRes.setMySQLPSDCDBInstName(pSDevCenterDBInst.getPSDevCenterDBInstName());
                }
            } else {
                pSDevSlnSysRes.setMySQLPSDCDBInstName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_OraPSDCDBInst(PSDevSlnSysRes pSDevSlnSysRes, boolean bl) throws Exception {
        if (pSDevSlnSysRes.isOraPSDCDBInstIdDirty()) {
            if (pSDevSlnSysRes.getOraPSDCDBInstId() != null) {
                if (pSDevSlnSysRes.getOraPSDCDBInstId() == null || pSDevSlnSysRes.getOraPSDCDBInstName() == null) {
                    PSDevCenterDBInst pSDevCenterDBInst = pSDevSlnSysRes.getOraPSDCDBInst();
                    pSDevSlnSysRes.setOraPSDCDBInstName(pSDevCenterDBInst.getPSDevCenterDBInstName());
                }
            } else {
                pSDevSlnSysRes.setOraPSDCDBInstName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PGSQLPSDCDBInst(PSDevSlnSysRes pSDevSlnSysRes, boolean bl) throws Exception {
        if (pSDevSlnSysRes.isPGSQLPSDCDBInstIdDirty()) {
            if (pSDevSlnSysRes.getPGSQLPSDCDBInstId() != null) {
                if (pSDevSlnSysRes.getPGSQLPSDCDBInstId() == null || pSDevSlnSysRes.getPGSQLPSDCDBInstName() == null) {
                    PSDevCenterDBInst pSDevCenterDBInst = pSDevSlnSysRes.getPGSQLPSDCDBInst();
                    pSDevSlnSysRes.setPGSQLPSDCDBInstName(pSDevCenterDBInst.getPSDevCenterDBInstName());
                }
            } else {
                pSDevSlnSysRes.setPGSQLPSDCDBInstName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PPASPSDCDBInst(PSDevSlnSysRes pSDevSlnSysRes, boolean bl) throws Exception {
        if (pSDevSlnSysRes.isPPASPSDCDBInstIdDirty()) {
            if (pSDevSlnSysRes.getPPASPSDCDBInstId() != null) {
                if (pSDevSlnSysRes.getPPASPSDCDBInstId() == null || pSDevSlnSysRes.getPPASPSDCDBInstName() == null) {
                    PSDevCenterDBInst pSDevCenterDBInst = pSDevSlnSysRes.getPPASPSDCDBInst();
                    pSDevSlnSysRes.setPPASPSDCDBInstName(pSDevCenterDBInst.getPSDevCenterDBInstName());
                }
            } else {
                pSDevSlnSysRes.setPPASPSDCDBInstName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_UDB2PSDCDBInst(PSDevSlnSysRes pSDevSlnSysRes, boolean bl) throws Exception {
        if (pSDevSlnSysRes.isUDB2PSDCDBInstIdDirty()) {
            if (pSDevSlnSysRes.getUDB2PSDCDBInstId() != null) {
                if (pSDevSlnSysRes.getUDB2PSDCDBInstId() == null || pSDevSlnSysRes.getUDB2PSDCDBInstName() == null) {
                    PSDevCenterDBInst pSDevCenterDBInst = pSDevSlnSysRes.getUDB2PSDCDBInst();
                    pSDevSlnSysRes.setUDB2PSDCDBInstName(pSDevCenterDBInst.getPSDevCenterDBInstName());
                }
            } else {
                pSDevSlnSysRes.setUDB2PSDCDBInstName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_UMSSqlPSDCDBInst(PSDevSlnSysRes pSDevSlnSysRes, boolean bl) throws Exception {
        if (pSDevSlnSysRes.isUMSSQLPSDCDBInstIdDirty()) {
            if (pSDevSlnSysRes.getUMSSQLPSDCDBInstId() != null) {
                if (pSDevSlnSysRes.getUMSSQLPSDCDBInstId() == null || pSDevSlnSysRes.getUMSSQLPSDCDBInstName() == null) {
                    PSDevCenterDBInst pSDevCenterDBInst = pSDevSlnSysRes.getUMSSqlPSDCDBInst();
                    pSDevSlnSysRes.setUMSSQLPSDCDBInstName(pSDevCenterDBInst.getPSDevCenterDBInstName());
                }
            } else {
                pSDevSlnSysRes.setUMSSQLPSDCDBInstName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_UMySQLPSDCDBInst(PSDevSlnSysRes pSDevSlnSysRes, boolean bl) throws Exception {
        if (pSDevSlnSysRes.isUMySQLPSDCDBInstIdDirty()) {
            if (pSDevSlnSysRes.getUMySQLPSDCDBInstId() != null) {
                if (pSDevSlnSysRes.getUMySQLPSDCDBInstId() == null || pSDevSlnSysRes.getUMySQLPSDCDBInstName() == null) {
                    PSDevCenterDBInst pSDevCenterDBInst = pSDevSlnSysRes.getUMySQLPSDCDBInst();
                    pSDevSlnSysRes.setUMySQLPSDCDBInstName(pSDevCenterDBInst.getPSDevCenterDBInstName());
                }
            } else {
                pSDevSlnSysRes.setUMySQLPSDCDBInstName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_UOraPSDCDBInst(PSDevSlnSysRes pSDevSlnSysRes, boolean bl) throws Exception {
        if (pSDevSlnSysRes.isUOraPSDCDBInstIdDirty()) {
            if (pSDevSlnSysRes.getUOraPSDCDBInstId() != null) {
                if (pSDevSlnSysRes.getUOraPSDCDBInstId() == null || pSDevSlnSysRes.getUOraPSDCDBInstName() == null) {
                    PSDevCenterDBInst pSDevCenterDBInst = pSDevSlnSysRes.getUOraPSDCDBInst();
                    pSDevSlnSysRes.setUOraPSDCDBInstName(pSDevCenterDBInst.getPSDevCenterDBInstName());
                }
            } else {
                pSDevSlnSysRes.setUOraPSDCDBInstName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_UPGSQLPSDCDBInst(PSDevSlnSysRes pSDevSlnSysRes, boolean bl) throws Exception {
        if (pSDevSlnSysRes.isUPGSQLPSDCDBInstIdDirty()) {
            if (pSDevSlnSysRes.getUPGSQLPSDCDBInstId() != null) {
                if (pSDevSlnSysRes.getUPGSQLPSDCDBInstId() == null || pSDevSlnSysRes.getUPGSQLPSDCDBInstName() == null) {
                    PSDevCenterDBInst pSDevCenterDBInst = pSDevSlnSysRes.getUPGSQLPSDCDBInst();
                    pSDevSlnSysRes.setUPGSQLPSDCDBInstName(pSDevCenterDBInst.getPSDevCenterDBInstName());
                }
            } else {
                pSDevSlnSysRes.setUPGSQLPSDCDBInstName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_UPPASPSDCDBInst(PSDevSlnSysRes pSDevSlnSysRes, boolean bl) throws Exception {
        if (pSDevSlnSysRes.isUPPASPSDCDBInstIdDirty()) {
            if (pSDevSlnSysRes.getUPPASPSDCDBInstId() != null) {
                if (pSDevSlnSysRes.getUPPASPSDCDBInstId() == null || pSDevSlnSysRes.getUPPASPSDCDBInstName() == null) {
                    PSDevCenterDBInst pSDevCenterDBInst = pSDevSlnSysRes.getUPPASPSDCDBInst();
                    pSDevSlnSysRes.setUPPASPSDCDBInstName(pSDevCenterDBInst.getPSDevCenterDBInstName());
                }
            } else {
                pSDevSlnSysRes.setUPPASPSDCDBInstName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDevCenterSVN(PSDevSlnSysRes pSDevSlnSysRes, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_ROPSDevCenterSVN(PSDevSlnSysRes pSDevSlnSysRes, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevSln(PSDevSlnSysRes pSDevSlnSysRes, boolean bl) throws Exception {
        if (pSDevSlnSysRes.isPSDevSlnIdDirty()) {
            if (pSDevSlnSysRes.getPSDevSlnId() != null) {
                if (pSDevSlnSysRes.getPSDevSlnId() == null || pSDevSlnSysRes.getPSDevSlnName() == null) {
                    PSDevSln pSDevSln = pSDevSlnSysRes.getPSDevSln();
                    pSDevSlnSysRes.setPSDevSlnName(pSDevSln.getPSDevSlnName());
                }
            } else {
                pSDevSlnSysRes.setPSDevSlnName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDevSlnSysRes pSDevSlnSysRes, boolean bl) throws Exception {
        super.onWriteBackParent(pSDevSlnSysRes, bl);
    }

    public ArrayList<PSDevSlnSysRes> selectByHBasePSDCBDInst(PSDCBDInstBase pSDCBDInstBase) throws Exception {
        return this.selectByHBasePSDCBDInst(pSDCBDInstBase, "", -1);
    }

    public ArrayList<PSDevSlnSysRes> selectByHBasePSDCBDInst(PSDCBDInstBase pSDCBDInstBase, String string) throws Exception {
        return this.selectByHBasePSDCBDInst(pSDCBDInstBase, string, -1);
    }

    public ArrayList<PSDevSlnSysRes> selectByHBasePSDCBDInst(PSDCBDInstBase pSDCBDInstBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("HBASEPSDCBDINSTID", (Object)pSDCBDInstBase.getPSDCBDInstId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByHBasePSDCBDInstCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByHBasePSDCBDInstCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnSysRes> selectByUHBasePSDCBDInst(PSDCBDInstBase pSDCBDInstBase) throws Exception {
        return this.selectByUHBasePSDCBDInst(pSDCBDInstBase, "", -1);
    }

    public ArrayList<PSDevSlnSysRes> selectByUHBasePSDCBDInst(PSDCBDInstBase pSDCBDInstBase, String string) throws Exception {
        return this.selectByUHBasePSDCBDInst(pSDCBDInstBase, string, -1);
    }

    public ArrayList<PSDevSlnSysRes> selectByUHBasePSDCBDInst(PSDCBDInstBase pSDCBDInstBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("UHBASEPSDCBDINSTID", (Object)pSDCBDInstBase.getPSDCBDInstId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByUHBasePSDCBDInstCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByUHBasePSDCBDInstCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnSysRes> selectByPSDCDeployServer(PSDCDeployServerBase pSDCDeployServerBase) throws Exception {
        return this.selectByPSDCDeployServer(pSDCDeployServerBase, "", -1);
    }

    public ArrayList<PSDevSlnSysRes> selectByPSDCDeployServer(PSDCDeployServerBase pSDCDeployServerBase, String string) throws Exception {
        return this.selectByPSDCDeployServer(pSDCDeployServerBase, string, -1);
    }

    public ArrayList<PSDevSlnSysRes> selectByPSDCDeployServer(PSDCDeployServerBase pSDCDeployServerBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDCDEPLOYSERVERID", (Object)pSDCDeployServerBase.getPSDCDeployServerId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDCDeployServerCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDCDeployServerCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnSysRes> selectByPSDevCenterAS(PSDevCenterASBase pSDevCenterASBase) throws Exception {
        return this.selectByPSDevCenterAS(pSDevCenterASBase, "", -1);
    }

    public ArrayList<PSDevSlnSysRes> selectByPSDevCenterAS(PSDevCenterASBase pSDevCenterASBase, String string) throws Exception {
        return this.selectByPSDevCenterAS(pSDevCenterASBase, string, -1);
    }

    public ArrayList<PSDevSlnSysRes> selectByPSDevCenterAS(PSDevCenterASBase pSDevCenterASBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVCENTERASID", (Object)pSDevCenterASBase.getPSDevCenterASId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevCenterASCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevCenterASCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnSysRes> selectByPSDevCenterAS2(PSDevCenterASBase pSDevCenterASBase) throws Exception {
        return this.selectByPSDevCenterAS2(pSDevCenterASBase, "", -1);
    }

    public ArrayList<PSDevSlnSysRes> selectByPSDevCenterAS2(PSDevCenterASBase pSDevCenterASBase, String string) throws Exception {
        return this.selectByPSDevCenterAS2(pSDevCenterASBase, string, -1);
    }

    public ArrayList<PSDevSlnSysRes> selectByPSDevCenterAS2(PSDevCenterASBase pSDevCenterASBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVCENTERASID2", (Object)pSDevCenterASBase.getPSDevCenterASId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevCenterAS2Cond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevCenterAS2Cond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnSysRes> selectByUPSDevCenterAS(PSDevCenterASBase pSDevCenterASBase) throws Exception {
        return this.selectByUPSDevCenterAS(pSDevCenterASBase, "", -1);
    }

    public ArrayList<PSDevSlnSysRes> selectByUPSDevCenterAS(PSDevCenterASBase pSDevCenterASBase, String string) throws Exception {
        return this.selectByUPSDevCenterAS(pSDevCenterASBase, string, -1);
    }

    public ArrayList<PSDevSlnSysRes> selectByUPSDevCenterAS(PSDevCenterASBase pSDevCenterASBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("UPSDEVCENTERASID", (Object)pSDevCenterASBase.getPSDevCenterASId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByUPSDevCenterASCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByUPSDevCenterASCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnSysRes> selectByUPSDevCenterAS2(PSDevCenterASBase pSDevCenterASBase) throws Exception {
        return this.selectByUPSDevCenterAS2(pSDevCenterASBase, "", -1);
    }

    public ArrayList<PSDevSlnSysRes> selectByUPSDevCenterAS2(PSDevCenterASBase pSDevCenterASBase, String string) throws Exception {
        return this.selectByUPSDevCenterAS2(pSDevCenterASBase, string, -1);
    }

    public ArrayList<PSDevSlnSysRes> selectByUPSDevCenterAS2(PSDevCenterASBase pSDevCenterASBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("UPSDEVCENTERASID2", (Object)pSDevCenterASBase.getPSDevCenterASId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByUPSDevCenterAS2Cond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByUPSDevCenterAS2Cond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnSysRes> selectByDB2PSDCDBInst(PSDevCenterDBInstBase pSDevCenterDBInstBase) throws Exception {
        return this.selectByDB2PSDCDBInst(pSDevCenterDBInstBase, "", -1);
    }

    public ArrayList<PSDevSlnSysRes> selectByDB2PSDCDBInst(PSDevCenterDBInstBase pSDevCenterDBInstBase, String string) throws Exception {
        return this.selectByDB2PSDCDBInst(pSDevCenterDBInstBase, string, -1);
    }

    public ArrayList<PSDevSlnSysRes> selectByDB2PSDCDBInst(PSDevCenterDBInstBase pSDevCenterDBInstBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("DB2PSDCDBINSTID", (Object)pSDevCenterDBInstBase.getPSDevCenterDBInstId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByDB2PSDCDBInstCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByDB2PSDCDBInstCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnSysRes> selectByMSSqlPSDCDBInst(PSDevCenterDBInstBase pSDevCenterDBInstBase) throws Exception {
        return this.selectByMSSqlPSDCDBInst(pSDevCenterDBInstBase, "", -1);
    }

    public ArrayList<PSDevSlnSysRes> selectByMSSqlPSDCDBInst(PSDevCenterDBInstBase pSDevCenterDBInstBase, String string) throws Exception {
        return this.selectByMSSqlPSDCDBInst(pSDevCenterDBInstBase, string, -1);
    }

    public ArrayList<PSDevSlnSysRes> selectByMSSqlPSDCDBInst(PSDevCenterDBInstBase pSDevCenterDBInstBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("MSSQLPSDCDBINSTID", (Object)pSDevCenterDBInstBase.getPSDevCenterDBInstId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByMSSqlPSDCDBInstCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByMSSqlPSDCDBInstCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnSysRes> selectByMySQLPSDCDBInst(PSDevCenterDBInstBase pSDevCenterDBInstBase) throws Exception {
        return this.selectByMySQLPSDCDBInst(pSDevCenterDBInstBase, "", -1);
    }

    public ArrayList<PSDevSlnSysRes> selectByMySQLPSDCDBInst(PSDevCenterDBInstBase pSDevCenterDBInstBase, String string) throws Exception {
        return this.selectByMySQLPSDCDBInst(pSDevCenterDBInstBase, string, -1);
    }

    public ArrayList<PSDevSlnSysRes> selectByMySQLPSDCDBInst(PSDevCenterDBInstBase pSDevCenterDBInstBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("MYSQLPSDCDBINSTID", (Object)pSDevCenterDBInstBase.getPSDevCenterDBInstId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByMySQLPSDCDBInstCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByMySQLPSDCDBInstCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnSysRes> selectByOraPSDCDBInst(PSDevCenterDBInstBase pSDevCenterDBInstBase) throws Exception {
        return this.selectByOraPSDCDBInst(pSDevCenterDBInstBase, "", -1);
    }

    public ArrayList<PSDevSlnSysRes> selectByOraPSDCDBInst(PSDevCenterDBInstBase pSDevCenterDBInstBase, String string) throws Exception {
        return this.selectByOraPSDCDBInst(pSDevCenterDBInstBase, string, -1);
    }

    public ArrayList<PSDevSlnSysRes> selectByOraPSDCDBInst(PSDevCenterDBInstBase pSDevCenterDBInstBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("ORAPSDCDBINSTID", (Object)pSDevCenterDBInstBase.getPSDevCenterDBInstId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByOraPSDCDBInstCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByOraPSDCDBInstCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnSysRes> selectByPGSQLPSDCDBInst(PSDevCenterDBInstBase pSDevCenterDBInstBase) throws Exception {
        return this.selectByPGSQLPSDCDBInst(pSDevCenterDBInstBase, "", -1);
    }

    public ArrayList<PSDevSlnSysRes> selectByPGSQLPSDCDBInst(PSDevCenterDBInstBase pSDevCenterDBInstBase, String string) throws Exception {
        return this.selectByPGSQLPSDCDBInst(pSDevCenterDBInstBase, string, -1);
    }

    public ArrayList<PSDevSlnSysRes> selectByPGSQLPSDCDBInst(PSDevCenterDBInstBase pSDevCenterDBInstBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PGSQLPSDCDBINSTID", (Object)pSDevCenterDBInstBase.getPSDevCenterDBInstId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPGSQLPSDCDBInstCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPGSQLPSDCDBInstCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnSysRes> selectByPPASPSDCDBInst(PSDevCenterDBInstBase pSDevCenterDBInstBase) throws Exception {
        return this.selectByPPASPSDCDBInst(pSDevCenterDBInstBase, "", -1);
    }

    public ArrayList<PSDevSlnSysRes> selectByPPASPSDCDBInst(PSDevCenterDBInstBase pSDevCenterDBInstBase, String string) throws Exception {
        return this.selectByPPASPSDCDBInst(pSDevCenterDBInstBase, string, -1);
    }

    public ArrayList<PSDevSlnSysRes> selectByPPASPSDCDBInst(PSDevCenterDBInstBase pSDevCenterDBInstBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PPASPSDCDBINSTID", (Object)pSDevCenterDBInstBase.getPSDevCenterDBInstId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPPASPSDCDBInstCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPPASPSDCDBInstCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnSysRes> selectByUDB2PSDCDBInst(PSDevCenterDBInstBase pSDevCenterDBInstBase) throws Exception {
        return this.selectByUDB2PSDCDBInst(pSDevCenterDBInstBase, "", -1);
    }

    public ArrayList<PSDevSlnSysRes> selectByUDB2PSDCDBInst(PSDevCenterDBInstBase pSDevCenterDBInstBase, String string) throws Exception {
        return this.selectByUDB2PSDCDBInst(pSDevCenterDBInstBase, string, -1);
    }

    public ArrayList<PSDevSlnSysRes> selectByUDB2PSDCDBInst(PSDevCenterDBInstBase pSDevCenterDBInstBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("UDB2PSDCDBINSTID", (Object)pSDevCenterDBInstBase.getPSDevCenterDBInstId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByUDB2PSDCDBInstCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByUDB2PSDCDBInstCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnSysRes> selectByUMSSqlPSDCDBInst(PSDevCenterDBInstBase pSDevCenterDBInstBase) throws Exception {
        return this.selectByUMSSqlPSDCDBInst(pSDevCenterDBInstBase, "", -1);
    }

    public ArrayList<PSDevSlnSysRes> selectByUMSSqlPSDCDBInst(PSDevCenterDBInstBase pSDevCenterDBInstBase, String string) throws Exception {
        return this.selectByUMSSqlPSDCDBInst(pSDevCenterDBInstBase, string, -1);
    }

    public ArrayList<PSDevSlnSysRes> selectByUMSSqlPSDCDBInst(PSDevCenterDBInstBase pSDevCenterDBInstBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("UMSSQLPSDCDBINSTID", (Object)pSDevCenterDBInstBase.getPSDevCenterDBInstId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByUMSSqlPSDCDBInstCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByUMSSqlPSDCDBInstCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnSysRes> selectByUMySQLPSDCDBInst(PSDevCenterDBInstBase pSDevCenterDBInstBase) throws Exception {
        return this.selectByUMySQLPSDCDBInst(pSDevCenterDBInstBase, "", -1);
    }

    public ArrayList<PSDevSlnSysRes> selectByUMySQLPSDCDBInst(PSDevCenterDBInstBase pSDevCenterDBInstBase, String string) throws Exception {
        return this.selectByUMySQLPSDCDBInst(pSDevCenterDBInstBase, string, -1);
    }

    public ArrayList<PSDevSlnSysRes> selectByUMySQLPSDCDBInst(PSDevCenterDBInstBase pSDevCenterDBInstBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("UMYSQLPSDCDBINSTID", (Object)pSDevCenterDBInstBase.getPSDevCenterDBInstId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByUMySQLPSDCDBInstCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByUMySQLPSDCDBInstCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnSysRes> selectByUOraPSDCDBInst(PSDevCenterDBInstBase pSDevCenterDBInstBase) throws Exception {
        return this.selectByUOraPSDCDBInst(pSDevCenterDBInstBase, "", -1);
    }

    public ArrayList<PSDevSlnSysRes> selectByUOraPSDCDBInst(PSDevCenterDBInstBase pSDevCenterDBInstBase, String string) throws Exception {
        return this.selectByUOraPSDCDBInst(pSDevCenterDBInstBase, string, -1);
    }

    public ArrayList<PSDevSlnSysRes> selectByUOraPSDCDBInst(PSDevCenterDBInstBase pSDevCenterDBInstBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("UORAPSDCDBINSTID", (Object)pSDevCenterDBInstBase.getPSDevCenterDBInstId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByUOraPSDCDBInstCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByUOraPSDCDBInstCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnSysRes> selectByUPGSQLPSDCDBInst(PSDevCenterDBInstBase pSDevCenterDBInstBase) throws Exception {
        return this.selectByUPGSQLPSDCDBInst(pSDevCenterDBInstBase, "", -1);
    }

    public ArrayList<PSDevSlnSysRes> selectByUPGSQLPSDCDBInst(PSDevCenterDBInstBase pSDevCenterDBInstBase, String string) throws Exception {
        return this.selectByUPGSQLPSDCDBInst(pSDevCenterDBInstBase, string, -1);
    }

    public ArrayList<PSDevSlnSysRes> selectByUPGSQLPSDCDBInst(PSDevCenterDBInstBase pSDevCenterDBInstBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("UPGSQLPSDCDBINSTID", (Object)pSDevCenterDBInstBase.getPSDevCenterDBInstId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByUPGSQLPSDCDBInstCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByUPGSQLPSDCDBInstCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnSysRes> selectByUPPASPSDCDBInst(PSDevCenterDBInstBase pSDevCenterDBInstBase) throws Exception {
        return this.selectByUPPASPSDCDBInst(pSDevCenterDBInstBase, "", -1);
    }

    public ArrayList<PSDevSlnSysRes> selectByUPPASPSDCDBInst(PSDevCenterDBInstBase pSDevCenterDBInstBase, String string) throws Exception {
        return this.selectByUPPASPSDCDBInst(pSDevCenterDBInstBase, string, -1);
    }

    public ArrayList<PSDevSlnSysRes> selectByUPPASPSDCDBInst(PSDevCenterDBInstBase pSDevCenterDBInstBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("UPPASPSDCDBINSTID", (Object)pSDevCenterDBInstBase.getPSDevCenterDBInstId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByUPPASPSDCDBInstCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByUPPASPSDCDBInstCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnSysRes> selectByPSDevCenterSVN(PSDevCenterSVNBase pSDevCenterSVNBase) throws Exception {
        return this.selectByPSDevCenterSVN(pSDevCenterSVNBase, "", -1);
    }

    public ArrayList<PSDevSlnSysRes> selectByPSDevCenterSVN(PSDevCenterSVNBase pSDevCenterSVNBase, String string) throws Exception {
        return this.selectByPSDevCenterSVN(pSDevCenterSVNBase, string, -1);
    }

    public ArrayList<PSDevSlnSysRes> selectByPSDevCenterSVN(PSDevCenterSVNBase pSDevCenterSVNBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVCENTERSVNID", (Object)pSDevCenterSVNBase.getPSDevCenterSVNId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevCenterSVNCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevCenterSVNCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnSysRes> selectByROPSDevCenterSVN(PSDevCenterSVNBase pSDevCenterSVNBase) throws Exception {
        return this.selectByROPSDevCenterSVN(pSDevCenterSVNBase, "", -1);
    }

    public ArrayList<PSDevSlnSysRes> selectByROPSDevCenterSVN(PSDevCenterSVNBase pSDevCenterSVNBase, String string) throws Exception {
        return this.selectByROPSDevCenterSVN(pSDevCenterSVNBase, string, -1);
    }

    public ArrayList<PSDevSlnSysRes> selectByROPSDevCenterSVN(PSDevCenterSVNBase pSDevCenterSVNBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("ROPSDEVCENTERSVNID", (Object)pSDevCenterSVNBase.getPSDevCenterSVNId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByROPSDevCenterSVNCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByROPSDevCenterSVNCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnSysRes> selectByPSDevSln(PSDevSlnBase pSDevSlnBase) throws Exception {
        return this.selectByPSDevSln(pSDevSlnBase, "", -1);
    }

    public ArrayList<PSDevSlnSysRes> selectByPSDevSln(PSDevSlnBase pSDevSlnBase, String string) throws Exception {
        return this.selectByPSDevSln(pSDevSlnBase, string, -1);
    }

    public ArrayList<PSDevSlnSysRes> selectByPSDevSln(PSDevSlnBase pSDevSlnBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVSLNID", (Object)pSDevSlnBase.getPSDevSlnId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevSlnCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevSlnCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByHBasePSDCBDInst(PSDCBDInst pSDCBDInst) throws Exception {
        ArrayList<PSDevSlnSysRes> arrayList = this.selectByHBasePSDCBDInst(pSDCBDInst, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDCBDINST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDCBDInst);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNSYSRES_PSDCBDINST_HBASEPSDCBDINSTID", "", iDataEntityModel.getName(), "PSDEVSLNSYSRES", iDataEntityModel.getDataInfo(pSDCBDInst), arrayList.get(0)));
        }
    }

    public void resetHBasePSDCBDInst(PSDCBDInst pSDCBDInst) throws Exception {
        ArrayList<PSDevSlnSysRes> arrayList = this.selectByHBasePSDCBDInst(pSDCBDInst);
        for (PSDevSlnSysRes pSDevSlnSysRes : arrayList) {
            PSDevSlnSysRes pSDevSlnSysRes2 = (PSDevSlnSysRes)this.getDEModel().createEntity();
            pSDevSlnSysRes2.setPSDevSlnSysResId(pSDevSlnSysRes.getPSDevSlnSysResId());
            pSDevSlnSysRes2.setHBasePSDCBDInstId(null);
            this.update(pSDevSlnSysRes2);
        }
    }

    public void removeByHBasePSDCBDInst(PSDCBDInst pSDCBDInst) throws Exception {
        final PSDCBDInst pSDCBDInst2 = pSDCBDInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysResServiceBase.this.onBeforeRemoveByHBasePSDCBDInst(pSDCBDInst2);
                PSDevSlnSysResServiceBase.this.internalRemoveByHBasePSDCBDInst(pSDCBDInst2);
                PSDevSlnSysResServiceBase.this.onAfterRemoveByHBasePSDCBDInst(pSDCBDInst2);
            }
        });
    }

    protected void onBeforeRemoveByHBasePSDCBDInst(PSDCBDInst pSDCBDInst) throws Exception {
    }

    protected void internalRemoveByHBasePSDCBDInst(PSDCBDInst pSDCBDInst) throws Exception {
        ArrayList<PSDevSlnSysRes> arrayList = this.selectByHBasePSDCBDInst(pSDCBDInst);
        this.onBeforeRemoveByHBasePSDCBDInst(pSDCBDInst, arrayList);
        for (PSDevSlnSysRes pSDevSlnSysRes : arrayList) {
            this.remove(pSDevSlnSysRes);
        }
        this.onAfterRemoveByHBasePSDCBDInst(pSDCBDInst, arrayList);
    }

    protected void onAfterRemoveByHBasePSDCBDInst(PSDCBDInst pSDCBDInst) throws Exception {
    }

    protected void onBeforeRemoveByHBasePSDCBDInst(PSDCBDInst pSDCBDInst, ArrayList<PSDevSlnSysRes> arrayList) throws Exception {
    }

    protected void onAfterRemoveByHBasePSDCBDInst(PSDCBDInst pSDCBDInst, ArrayList<PSDevSlnSysRes> arrayList) throws Exception {
    }

    public void testRemoveByUHBasePSDCBDInst(PSDCBDInst pSDCBDInst) throws Exception {
        ArrayList<PSDevSlnSysRes> arrayList = this.selectByUHBasePSDCBDInst(pSDCBDInst, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDCBDINST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDCBDInst);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNSYSRES_PSDCBDINST_UHBASEPSDCBDINSTID", "", iDataEntityModel.getName(), "PSDEVSLNSYSRES", iDataEntityModel.getDataInfo(pSDCBDInst), arrayList.get(0)));
        }
    }

    public void resetUHBasePSDCBDInst(PSDCBDInst pSDCBDInst) throws Exception {
        ArrayList<PSDevSlnSysRes> arrayList = this.selectByUHBasePSDCBDInst(pSDCBDInst);
        for (PSDevSlnSysRes pSDevSlnSysRes : arrayList) {
            PSDevSlnSysRes pSDevSlnSysRes2 = (PSDevSlnSysRes)this.getDEModel().createEntity();
            pSDevSlnSysRes2.setPSDevSlnSysResId(pSDevSlnSysRes.getPSDevSlnSysResId());
            pSDevSlnSysRes2.setUHBasePSDCBDInstId(null);
            this.update(pSDevSlnSysRes2);
        }
    }

    public void removeByUHBasePSDCBDInst(PSDCBDInst pSDCBDInst) throws Exception {
        final PSDCBDInst pSDCBDInst2 = pSDCBDInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysResServiceBase.this.onBeforeRemoveByUHBasePSDCBDInst(pSDCBDInst2);
                PSDevSlnSysResServiceBase.this.internalRemoveByUHBasePSDCBDInst(pSDCBDInst2);
                PSDevSlnSysResServiceBase.this.onAfterRemoveByUHBasePSDCBDInst(pSDCBDInst2);
            }
        });
    }

    protected void onBeforeRemoveByUHBasePSDCBDInst(PSDCBDInst pSDCBDInst) throws Exception {
    }

    protected void internalRemoveByUHBasePSDCBDInst(PSDCBDInst pSDCBDInst) throws Exception {
        ArrayList<PSDevSlnSysRes> arrayList = this.selectByUHBasePSDCBDInst(pSDCBDInst);
        this.onBeforeRemoveByUHBasePSDCBDInst(pSDCBDInst, arrayList);
        for (PSDevSlnSysRes pSDevSlnSysRes : arrayList) {
            this.remove(pSDevSlnSysRes);
        }
        this.onAfterRemoveByUHBasePSDCBDInst(pSDCBDInst, arrayList);
    }

    protected void onAfterRemoveByUHBasePSDCBDInst(PSDCBDInst pSDCBDInst) throws Exception {
    }

    protected void onBeforeRemoveByUHBasePSDCBDInst(PSDCBDInst pSDCBDInst, ArrayList<PSDevSlnSysRes> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUHBasePSDCBDInst(PSDCBDInst pSDCBDInst, ArrayList<PSDevSlnSysRes> arrayList) throws Exception {
    }

    public void testRemoveByPSDCDeployServer(PSDCDeployServer pSDCDeployServer) throws Exception {
        ArrayList<PSDevSlnSysRes> arrayList = this.selectByPSDCDeployServer(pSDCDeployServer, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDCDEPLOYSERVER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDCDeployServer);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNSYSRES_PSDCDEPLOYSERVER_PSDCDEPLOYSERVERID", "", iDataEntityModel.getName(), "PSDEVSLNSYSRES", iDataEntityModel.getDataInfo(pSDCDeployServer), arrayList.get(0)));
        }
    }

    public void resetPSDCDeployServer(PSDCDeployServer pSDCDeployServer) throws Exception {
        ArrayList<PSDevSlnSysRes> arrayList = this.selectByPSDCDeployServer(pSDCDeployServer);
        for (PSDevSlnSysRes pSDevSlnSysRes : arrayList) {
            PSDevSlnSysRes pSDevSlnSysRes2 = (PSDevSlnSysRes)this.getDEModel().createEntity();
            pSDevSlnSysRes2.setPSDevSlnSysResId(pSDevSlnSysRes.getPSDevSlnSysResId());
            pSDevSlnSysRes2.setPSDCDeployServerId(null);
            this.update(pSDevSlnSysRes2);
        }
    }

    public void removeByPSDCDeployServer(PSDCDeployServer pSDCDeployServer) throws Exception {
        final PSDCDeployServer pSDCDeployServer2 = pSDCDeployServer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysResServiceBase.this.onBeforeRemoveByPSDCDeployServer(pSDCDeployServer2);
                PSDevSlnSysResServiceBase.this.internalRemoveByPSDCDeployServer(pSDCDeployServer2);
                PSDevSlnSysResServiceBase.this.onAfterRemoveByPSDCDeployServer(pSDCDeployServer2);
            }
        });
    }

    protected void onBeforeRemoveByPSDCDeployServer(PSDCDeployServer pSDCDeployServer) throws Exception {
    }

    protected void internalRemoveByPSDCDeployServer(PSDCDeployServer pSDCDeployServer) throws Exception {
        ArrayList<PSDevSlnSysRes> arrayList = this.selectByPSDCDeployServer(pSDCDeployServer);
        this.onBeforeRemoveByPSDCDeployServer(pSDCDeployServer, arrayList);
        for (PSDevSlnSysRes pSDevSlnSysRes : arrayList) {
            this.remove(pSDevSlnSysRes);
        }
        this.onAfterRemoveByPSDCDeployServer(pSDCDeployServer, arrayList);
    }

    protected void onAfterRemoveByPSDCDeployServer(PSDCDeployServer pSDCDeployServer) throws Exception {
    }

    protected void onBeforeRemoveByPSDCDeployServer(PSDCDeployServer pSDCDeployServer, ArrayList<PSDevSlnSysRes> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDCDeployServer(PSDCDeployServer pSDCDeployServer, ArrayList<PSDevSlnSysRes> arrayList) throws Exception {
    }

    public void testRemoveByPSDevCenterAS(PSDevCenterAS pSDevCenterAS) throws Exception {
        ArrayList<PSDevSlnSysRes> arrayList = this.selectByPSDevCenterAS(pSDevCenterAS, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTERAS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevCenterAS);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNSYSRES_PSDEVCENTERAS_PSDEVCENTERASID", "", iDataEntityModel.getName(), "PSDEVSLNSYSRES", iDataEntityModel.getDataInfo(pSDevCenterAS), arrayList.get(0)));
        }
    }

    public void resetPSDevCenterAS(PSDevCenterAS pSDevCenterAS) throws Exception {
        ArrayList<PSDevSlnSysRes> arrayList = this.selectByPSDevCenterAS(pSDevCenterAS);
        for (PSDevSlnSysRes pSDevSlnSysRes : arrayList) {
            PSDevSlnSysRes pSDevSlnSysRes2 = (PSDevSlnSysRes)this.getDEModel().createEntity();
            pSDevSlnSysRes2.setPSDevSlnSysResId(pSDevSlnSysRes.getPSDevSlnSysResId());
            pSDevSlnSysRes2.setPSDevCenterASId(null);
            this.update(pSDevSlnSysRes2);
        }
    }

    public void removeByPSDevCenterAS(PSDevCenterAS pSDevCenterAS) throws Exception {
        final PSDevCenterAS pSDevCenterAS2 = pSDevCenterAS;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysResServiceBase.this.onBeforeRemoveByPSDevCenterAS(pSDevCenterAS2);
                PSDevSlnSysResServiceBase.this.internalRemoveByPSDevCenterAS(pSDevCenterAS2);
                PSDevSlnSysResServiceBase.this.onAfterRemoveByPSDevCenterAS(pSDevCenterAS2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenterAS(PSDevCenterAS pSDevCenterAS) throws Exception {
    }

    protected void internalRemoveByPSDevCenterAS(PSDevCenterAS pSDevCenterAS) throws Exception {
        ArrayList<PSDevSlnSysRes> arrayList = this.selectByPSDevCenterAS(pSDevCenterAS);
        this.onBeforeRemoveByPSDevCenterAS(pSDevCenterAS, arrayList);
        for (PSDevSlnSysRes pSDevSlnSysRes : arrayList) {
            this.remove(pSDevSlnSysRes);
        }
        this.onAfterRemoveByPSDevCenterAS(pSDevCenterAS, arrayList);
    }

    protected void onAfterRemoveByPSDevCenterAS(PSDevCenterAS pSDevCenterAS) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenterAS(PSDevCenterAS pSDevCenterAS, ArrayList<PSDevSlnSysRes> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenterAS(PSDevCenterAS pSDevCenterAS, ArrayList<PSDevSlnSysRes> arrayList) throws Exception {
    }

    public void testRemoveByPSDevCenterAS2(PSDevCenterAS pSDevCenterAS) throws Exception {
        ArrayList<PSDevSlnSysRes> arrayList = this.selectByPSDevCenterAS2(pSDevCenterAS, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTERAS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevCenterAS);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNSYSRES_PSDEVCENTERAS_PSDEVCENTERASID2", "", iDataEntityModel.getName(), "PSDEVSLNSYSRES", iDataEntityModel.getDataInfo(pSDevCenterAS), arrayList.get(0)));
        }
    }

    public void resetPSDevCenterAS2(PSDevCenterAS pSDevCenterAS) throws Exception {
        ArrayList<PSDevSlnSysRes> arrayList = this.selectByPSDevCenterAS2(pSDevCenterAS);
        for (PSDevSlnSysRes pSDevSlnSysRes : arrayList) {
            PSDevSlnSysRes pSDevSlnSysRes2 = (PSDevSlnSysRes)this.getDEModel().createEntity();
            pSDevSlnSysRes2.setPSDevSlnSysResId(pSDevSlnSysRes.getPSDevSlnSysResId());
            pSDevSlnSysRes2.setPSDevCenterASId2(null);
            this.update(pSDevSlnSysRes2);
        }
    }

    public void removeByPSDevCenterAS2(PSDevCenterAS pSDevCenterAS) throws Exception {
        final PSDevCenterAS pSDevCenterAS2 = pSDevCenterAS;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysResServiceBase.this.onBeforeRemoveByPSDevCenterAS2(pSDevCenterAS2);
                PSDevSlnSysResServiceBase.this.internalRemoveByPSDevCenterAS2(pSDevCenterAS2);
                PSDevSlnSysResServiceBase.this.onAfterRemoveByPSDevCenterAS2(pSDevCenterAS2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenterAS2(PSDevCenterAS pSDevCenterAS) throws Exception {
    }

    protected void internalRemoveByPSDevCenterAS2(PSDevCenterAS pSDevCenterAS) throws Exception {
        ArrayList<PSDevSlnSysRes> arrayList = this.selectByPSDevCenterAS2(pSDevCenterAS);
        this.onBeforeRemoveByPSDevCenterAS2(pSDevCenterAS, arrayList);
        for (PSDevSlnSysRes pSDevSlnSysRes : arrayList) {
            this.remove(pSDevSlnSysRes);
        }
        this.onAfterRemoveByPSDevCenterAS2(pSDevCenterAS, arrayList);
    }

    protected void onAfterRemoveByPSDevCenterAS2(PSDevCenterAS pSDevCenterAS) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenterAS2(PSDevCenterAS pSDevCenterAS, ArrayList<PSDevSlnSysRes> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenterAS2(PSDevCenterAS pSDevCenterAS, ArrayList<PSDevSlnSysRes> arrayList) throws Exception {
    }

    public void testRemoveByUPSDevCenterAS(PSDevCenterAS pSDevCenterAS) throws Exception {
        ArrayList<PSDevSlnSysRes> arrayList = this.selectByUPSDevCenterAS(pSDevCenterAS, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTERAS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevCenterAS);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNSYSRES_PSDEVCENTERAS_UPSDEVCENTERASID", "", iDataEntityModel.getName(), "PSDEVSLNSYSRES", iDataEntityModel.getDataInfo(pSDevCenterAS), arrayList.get(0)));
        }
    }

    public void resetUPSDevCenterAS(PSDevCenterAS pSDevCenterAS) throws Exception {
        ArrayList<PSDevSlnSysRes> arrayList = this.selectByUPSDevCenterAS(pSDevCenterAS);
        for (PSDevSlnSysRes pSDevSlnSysRes : arrayList) {
            PSDevSlnSysRes pSDevSlnSysRes2 = (PSDevSlnSysRes)this.getDEModel().createEntity();
            pSDevSlnSysRes2.setPSDevSlnSysResId(pSDevSlnSysRes.getPSDevSlnSysResId());
            pSDevSlnSysRes2.setUPSDevCenterASId(null);
            this.update(pSDevSlnSysRes2);
        }
    }

    public void removeByUPSDevCenterAS(PSDevCenterAS pSDevCenterAS) throws Exception {
        final PSDevCenterAS pSDevCenterAS2 = pSDevCenterAS;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysResServiceBase.this.onBeforeRemoveByUPSDevCenterAS(pSDevCenterAS2);
                PSDevSlnSysResServiceBase.this.internalRemoveByUPSDevCenterAS(pSDevCenterAS2);
                PSDevSlnSysResServiceBase.this.onAfterRemoveByUPSDevCenterAS(pSDevCenterAS2);
            }
        });
    }

    protected void onBeforeRemoveByUPSDevCenterAS(PSDevCenterAS pSDevCenterAS) throws Exception {
    }

    protected void internalRemoveByUPSDevCenterAS(PSDevCenterAS pSDevCenterAS) throws Exception {
        ArrayList<PSDevSlnSysRes> arrayList = this.selectByUPSDevCenterAS(pSDevCenterAS);
        this.onBeforeRemoveByUPSDevCenterAS(pSDevCenterAS, arrayList);
        for (PSDevSlnSysRes pSDevSlnSysRes : arrayList) {
            this.remove(pSDevSlnSysRes);
        }
        this.onAfterRemoveByUPSDevCenterAS(pSDevCenterAS, arrayList);
    }

    protected void onAfterRemoveByUPSDevCenterAS(PSDevCenterAS pSDevCenterAS) throws Exception {
    }

    protected void onBeforeRemoveByUPSDevCenterAS(PSDevCenterAS pSDevCenterAS, ArrayList<PSDevSlnSysRes> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUPSDevCenterAS(PSDevCenterAS pSDevCenterAS, ArrayList<PSDevSlnSysRes> arrayList) throws Exception {
    }

    public void testRemoveByUPSDevCenterAS2(PSDevCenterAS pSDevCenterAS) throws Exception {
        ArrayList<PSDevSlnSysRes> arrayList = this.selectByUPSDevCenterAS2(pSDevCenterAS, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTERAS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevCenterAS);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNSYSRES_PSDEVCENTERAS_UPSDEVCENTERASID2", "", iDataEntityModel.getName(), "PSDEVSLNSYSRES", iDataEntityModel.getDataInfo(pSDevCenterAS), arrayList.get(0)));
        }
    }

    public void resetUPSDevCenterAS2(PSDevCenterAS pSDevCenterAS) throws Exception {
        ArrayList<PSDevSlnSysRes> arrayList = this.selectByUPSDevCenterAS2(pSDevCenterAS);
        for (PSDevSlnSysRes pSDevSlnSysRes : arrayList) {
            PSDevSlnSysRes pSDevSlnSysRes2 = (PSDevSlnSysRes)this.getDEModel().createEntity();
            pSDevSlnSysRes2.setPSDevSlnSysResId(pSDevSlnSysRes.getPSDevSlnSysResId());
            pSDevSlnSysRes2.setUPSDevCenterASId2(null);
            this.update(pSDevSlnSysRes2);
        }
    }

    public void removeByUPSDevCenterAS2(PSDevCenterAS pSDevCenterAS) throws Exception {
        final PSDevCenterAS pSDevCenterAS2 = pSDevCenterAS;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysResServiceBase.this.onBeforeRemoveByUPSDevCenterAS2(pSDevCenterAS2);
                PSDevSlnSysResServiceBase.this.internalRemoveByUPSDevCenterAS2(pSDevCenterAS2);
                PSDevSlnSysResServiceBase.this.onAfterRemoveByUPSDevCenterAS2(pSDevCenterAS2);
            }
        });
    }

    protected void onBeforeRemoveByUPSDevCenterAS2(PSDevCenterAS pSDevCenterAS) throws Exception {
    }

    protected void internalRemoveByUPSDevCenterAS2(PSDevCenterAS pSDevCenterAS) throws Exception {
        ArrayList<PSDevSlnSysRes> arrayList = this.selectByUPSDevCenterAS2(pSDevCenterAS);
        this.onBeforeRemoveByUPSDevCenterAS2(pSDevCenterAS, arrayList);
        for (PSDevSlnSysRes pSDevSlnSysRes : arrayList) {
            this.remove(pSDevSlnSysRes);
        }
        this.onAfterRemoveByUPSDevCenterAS2(pSDevCenterAS, arrayList);
    }

    protected void onAfterRemoveByUPSDevCenterAS2(PSDevCenterAS pSDevCenterAS) throws Exception {
    }

    protected void onBeforeRemoveByUPSDevCenterAS2(PSDevCenterAS pSDevCenterAS, ArrayList<PSDevSlnSysRes> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUPSDevCenterAS2(PSDevCenterAS pSDevCenterAS, ArrayList<PSDevSlnSysRes> arrayList) throws Exception {
    }

    public void testRemoveByDB2PSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSDevSlnSysRes> arrayList = this.selectByDB2PSDCDBInst(pSDevCenterDBInst, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTERDBINST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevCenterDBInst);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNSYSRES_PSDEVCENTERDBINST_DB2PSDCDBINSTID", "", iDataEntityModel.getName(), "PSDEVSLNSYSRES", iDataEntityModel.getDataInfo(pSDevCenterDBInst), arrayList.get(0)));
        }
    }

    public void resetDB2PSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSDevSlnSysRes> arrayList = this.selectByDB2PSDCDBInst(pSDevCenterDBInst);
        for (PSDevSlnSysRes pSDevSlnSysRes : arrayList) {
            PSDevSlnSysRes pSDevSlnSysRes2 = (PSDevSlnSysRes)this.getDEModel().createEntity();
            pSDevSlnSysRes2.setPSDevSlnSysResId(pSDevSlnSysRes.getPSDevSlnSysResId());
            pSDevSlnSysRes2.setDB2PSDCDBInstId(null);
            this.update(pSDevSlnSysRes2);
        }
    }

    public void removeByDB2PSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        final PSDevCenterDBInst pSDevCenterDBInst2 = pSDevCenterDBInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysResServiceBase.this.onBeforeRemoveByDB2PSDCDBInst(pSDevCenterDBInst2);
                PSDevSlnSysResServiceBase.this.internalRemoveByDB2PSDCDBInst(pSDevCenterDBInst2);
                PSDevSlnSysResServiceBase.this.onAfterRemoveByDB2PSDCDBInst(pSDevCenterDBInst2);
            }
        });
    }

    protected void onBeforeRemoveByDB2PSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
    }

    protected void internalRemoveByDB2PSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSDevSlnSysRes> arrayList = this.selectByDB2PSDCDBInst(pSDevCenterDBInst);
        this.onBeforeRemoveByDB2PSDCDBInst(pSDevCenterDBInst, arrayList);
        for (PSDevSlnSysRes pSDevSlnSysRes : arrayList) {
            this.remove(pSDevSlnSysRes);
        }
        this.onAfterRemoveByDB2PSDCDBInst(pSDevCenterDBInst, arrayList);
    }

    protected void onAfterRemoveByDB2PSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
    }

    protected void onBeforeRemoveByDB2PSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst, ArrayList<PSDevSlnSysRes> arrayList) throws Exception {
    }

    protected void onAfterRemoveByDB2PSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst, ArrayList<PSDevSlnSysRes> arrayList) throws Exception {
    }

    public void testRemoveByMSSqlPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSDevSlnSysRes> arrayList = this.selectByMSSqlPSDCDBInst(pSDevCenterDBInst, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTERDBINST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevCenterDBInst);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNSYSRES_PSDEVCENTERDBINST_MSSQLPSDCDBINSTID", "", iDataEntityModel.getName(), "PSDEVSLNSYSRES", iDataEntityModel.getDataInfo(pSDevCenterDBInst), arrayList.get(0)));
        }
    }

    public void resetMSSqlPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSDevSlnSysRes> arrayList = this.selectByMSSqlPSDCDBInst(pSDevCenterDBInst);
        for (PSDevSlnSysRes pSDevSlnSysRes : arrayList) {
            PSDevSlnSysRes pSDevSlnSysRes2 = (PSDevSlnSysRes)this.getDEModel().createEntity();
            pSDevSlnSysRes2.setPSDevSlnSysResId(pSDevSlnSysRes.getPSDevSlnSysResId());
            pSDevSlnSysRes2.setMSSQLPSDCDBInstId(null);
            this.update(pSDevSlnSysRes2);
        }
    }

    public void removeByMSSqlPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        final PSDevCenterDBInst pSDevCenterDBInst2 = pSDevCenterDBInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysResServiceBase.this.onBeforeRemoveByMSSqlPSDCDBInst(pSDevCenterDBInst2);
                PSDevSlnSysResServiceBase.this.internalRemoveByMSSqlPSDCDBInst(pSDevCenterDBInst2);
                PSDevSlnSysResServiceBase.this.onAfterRemoveByMSSqlPSDCDBInst(pSDevCenterDBInst2);
            }
        });
    }

    protected void onBeforeRemoveByMSSqlPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
    }

    protected void internalRemoveByMSSqlPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSDevSlnSysRes> arrayList = this.selectByMSSqlPSDCDBInst(pSDevCenterDBInst);
        this.onBeforeRemoveByMSSqlPSDCDBInst(pSDevCenterDBInst, arrayList);
        for (PSDevSlnSysRes pSDevSlnSysRes : arrayList) {
            this.remove(pSDevSlnSysRes);
        }
        this.onAfterRemoveByMSSqlPSDCDBInst(pSDevCenterDBInst, arrayList);
    }

    protected void onAfterRemoveByMSSqlPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
    }

    protected void onBeforeRemoveByMSSqlPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst, ArrayList<PSDevSlnSysRes> arrayList) throws Exception {
    }

    protected void onAfterRemoveByMSSqlPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst, ArrayList<PSDevSlnSysRes> arrayList) throws Exception {
    }

    public void testRemoveByMySQLPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSDevSlnSysRes> arrayList = this.selectByMySQLPSDCDBInst(pSDevCenterDBInst, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTERDBINST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevCenterDBInst);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNSYSRES_PSDEVCENTERDBINST_MYSQLPSDCDBINSTID", "", iDataEntityModel.getName(), "PSDEVSLNSYSRES", iDataEntityModel.getDataInfo(pSDevCenterDBInst), arrayList.get(0)));
        }
    }

    public void resetMySQLPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSDevSlnSysRes> arrayList = this.selectByMySQLPSDCDBInst(pSDevCenterDBInst);
        for (PSDevSlnSysRes pSDevSlnSysRes : arrayList) {
            PSDevSlnSysRes pSDevSlnSysRes2 = (PSDevSlnSysRes)this.getDEModel().createEntity();
            pSDevSlnSysRes2.setPSDevSlnSysResId(pSDevSlnSysRes.getPSDevSlnSysResId());
            pSDevSlnSysRes2.setMySQLPSDCDBInstId(null);
            this.update(pSDevSlnSysRes2);
        }
    }

    public void removeByMySQLPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        final PSDevCenterDBInst pSDevCenterDBInst2 = pSDevCenterDBInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysResServiceBase.this.onBeforeRemoveByMySQLPSDCDBInst(pSDevCenterDBInst2);
                PSDevSlnSysResServiceBase.this.internalRemoveByMySQLPSDCDBInst(pSDevCenterDBInst2);
                PSDevSlnSysResServiceBase.this.onAfterRemoveByMySQLPSDCDBInst(pSDevCenterDBInst2);
            }
        });
    }

    protected void onBeforeRemoveByMySQLPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
    }

    protected void internalRemoveByMySQLPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSDevSlnSysRes> arrayList = this.selectByMySQLPSDCDBInst(pSDevCenterDBInst);
        this.onBeforeRemoveByMySQLPSDCDBInst(pSDevCenterDBInst, arrayList);
        for (PSDevSlnSysRes pSDevSlnSysRes : arrayList) {
            this.remove(pSDevSlnSysRes);
        }
        this.onAfterRemoveByMySQLPSDCDBInst(pSDevCenterDBInst, arrayList);
    }

    protected void onAfterRemoveByMySQLPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
    }

    protected void onBeforeRemoveByMySQLPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst, ArrayList<PSDevSlnSysRes> arrayList) throws Exception {
    }

    protected void onAfterRemoveByMySQLPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst, ArrayList<PSDevSlnSysRes> arrayList) throws Exception {
    }

    public void testRemoveByOraPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSDevSlnSysRes> arrayList = this.selectByOraPSDCDBInst(pSDevCenterDBInst, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTERDBINST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevCenterDBInst);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNSYSRES_PSDEVCENTERDBINST_ORAPSDCDBINSTID", "", iDataEntityModel.getName(), "PSDEVSLNSYSRES", iDataEntityModel.getDataInfo(pSDevCenterDBInst), arrayList.get(0)));
        }
    }

    public void resetOraPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSDevSlnSysRes> arrayList = this.selectByOraPSDCDBInst(pSDevCenterDBInst);
        for (PSDevSlnSysRes pSDevSlnSysRes : arrayList) {
            PSDevSlnSysRes pSDevSlnSysRes2 = (PSDevSlnSysRes)this.getDEModel().createEntity();
            pSDevSlnSysRes2.setPSDevSlnSysResId(pSDevSlnSysRes.getPSDevSlnSysResId());
            pSDevSlnSysRes2.setOraPSDCDBInstId(null);
            this.update(pSDevSlnSysRes2);
        }
    }

    public void removeByOraPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        final PSDevCenterDBInst pSDevCenterDBInst2 = pSDevCenterDBInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysResServiceBase.this.onBeforeRemoveByOraPSDCDBInst(pSDevCenterDBInst2);
                PSDevSlnSysResServiceBase.this.internalRemoveByOraPSDCDBInst(pSDevCenterDBInst2);
                PSDevSlnSysResServiceBase.this.onAfterRemoveByOraPSDCDBInst(pSDevCenterDBInst2);
            }
        });
    }

    protected void onBeforeRemoveByOraPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
    }

    protected void internalRemoveByOraPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSDevSlnSysRes> arrayList = this.selectByOraPSDCDBInst(pSDevCenterDBInst);
        this.onBeforeRemoveByOraPSDCDBInst(pSDevCenterDBInst, arrayList);
        for (PSDevSlnSysRes pSDevSlnSysRes : arrayList) {
            this.remove(pSDevSlnSysRes);
        }
        this.onAfterRemoveByOraPSDCDBInst(pSDevCenterDBInst, arrayList);
    }

    protected void onAfterRemoveByOraPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
    }

    protected void onBeforeRemoveByOraPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst, ArrayList<PSDevSlnSysRes> arrayList) throws Exception {
    }

    protected void onAfterRemoveByOraPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst, ArrayList<PSDevSlnSysRes> arrayList) throws Exception {
    }

    public void testRemoveByPGSQLPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSDevSlnSysRes> arrayList = this.selectByPGSQLPSDCDBInst(pSDevCenterDBInst, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTERDBINST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevCenterDBInst);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNSYSRES_PSDEVCENTERDBINST_PGSQLPSDCDBINSTID", "", iDataEntityModel.getName(), "PSDEVSLNSYSRES", iDataEntityModel.getDataInfo(pSDevCenterDBInst), arrayList.get(0)));
        }
    }

    public void resetPGSQLPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSDevSlnSysRes> arrayList = this.selectByPGSQLPSDCDBInst(pSDevCenterDBInst);
        for (PSDevSlnSysRes pSDevSlnSysRes : arrayList) {
            PSDevSlnSysRes pSDevSlnSysRes2 = (PSDevSlnSysRes)this.getDEModel().createEntity();
            pSDevSlnSysRes2.setPSDevSlnSysResId(pSDevSlnSysRes.getPSDevSlnSysResId());
            pSDevSlnSysRes2.setPGSQLPSDCDBInstId(null);
            this.update(pSDevSlnSysRes2);
        }
    }

    public void removeByPGSQLPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        final PSDevCenterDBInst pSDevCenterDBInst2 = pSDevCenterDBInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysResServiceBase.this.onBeforeRemoveByPGSQLPSDCDBInst(pSDevCenterDBInst2);
                PSDevSlnSysResServiceBase.this.internalRemoveByPGSQLPSDCDBInst(pSDevCenterDBInst2);
                PSDevSlnSysResServiceBase.this.onAfterRemoveByPGSQLPSDCDBInst(pSDevCenterDBInst2);
            }
        });
    }

    protected void onBeforeRemoveByPGSQLPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
    }

    protected void internalRemoveByPGSQLPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSDevSlnSysRes> arrayList = this.selectByPGSQLPSDCDBInst(pSDevCenterDBInst);
        this.onBeforeRemoveByPGSQLPSDCDBInst(pSDevCenterDBInst, arrayList);
        for (PSDevSlnSysRes pSDevSlnSysRes : arrayList) {
            this.remove(pSDevSlnSysRes);
        }
        this.onAfterRemoveByPGSQLPSDCDBInst(pSDevCenterDBInst, arrayList);
    }

    protected void onAfterRemoveByPGSQLPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
    }

    protected void onBeforeRemoveByPGSQLPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst, ArrayList<PSDevSlnSysRes> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPGSQLPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst, ArrayList<PSDevSlnSysRes> arrayList) throws Exception {
    }

    public void testRemoveByPPASPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSDevSlnSysRes> arrayList = this.selectByPPASPSDCDBInst(pSDevCenterDBInst, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTERDBINST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevCenterDBInst);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNSYSRES_PSDEVCENTERDBINST_PPASPSDCDBINSTID", "", iDataEntityModel.getName(), "PSDEVSLNSYSRES", iDataEntityModel.getDataInfo(pSDevCenterDBInst), arrayList.get(0)));
        }
    }

    public void resetPPASPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSDevSlnSysRes> arrayList = this.selectByPPASPSDCDBInst(pSDevCenterDBInst);
        for (PSDevSlnSysRes pSDevSlnSysRes : arrayList) {
            PSDevSlnSysRes pSDevSlnSysRes2 = (PSDevSlnSysRes)this.getDEModel().createEntity();
            pSDevSlnSysRes2.setPSDevSlnSysResId(pSDevSlnSysRes.getPSDevSlnSysResId());
            pSDevSlnSysRes2.setPPASPSDCDBInstId(null);
            this.update(pSDevSlnSysRes2);
        }
    }

    public void removeByPPASPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        final PSDevCenterDBInst pSDevCenterDBInst2 = pSDevCenterDBInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysResServiceBase.this.onBeforeRemoveByPPASPSDCDBInst(pSDevCenterDBInst2);
                PSDevSlnSysResServiceBase.this.internalRemoveByPPASPSDCDBInst(pSDevCenterDBInst2);
                PSDevSlnSysResServiceBase.this.onAfterRemoveByPPASPSDCDBInst(pSDevCenterDBInst2);
            }
        });
    }

    protected void onBeforeRemoveByPPASPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
    }

    protected void internalRemoveByPPASPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSDevSlnSysRes> arrayList = this.selectByPPASPSDCDBInst(pSDevCenterDBInst);
        this.onBeforeRemoveByPPASPSDCDBInst(pSDevCenterDBInst, arrayList);
        for (PSDevSlnSysRes pSDevSlnSysRes : arrayList) {
            this.remove(pSDevSlnSysRes);
        }
        this.onAfterRemoveByPPASPSDCDBInst(pSDevCenterDBInst, arrayList);
    }

    protected void onAfterRemoveByPPASPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
    }

    protected void onBeforeRemoveByPPASPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst, ArrayList<PSDevSlnSysRes> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPPASPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst, ArrayList<PSDevSlnSysRes> arrayList) throws Exception {
    }

    public void testRemoveByUDB2PSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSDevSlnSysRes> arrayList = this.selectByUDB2PSDCDBInst(pSDevCenterDBInst, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTERDBINST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevCenterDBInst);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNSYSRES_PSDEVCENTERDBINST_UDB2PSDCDBINSTID", "", iDataEntityModel.getName(), "PSDEVSLNSYSRES", iDataEntityModel.getDataInfo(pSDevCenterDBInst), arrayList.get(0)));
        }
    }

    public void resetUDB2PSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSDevSlnSysRes> arrayList = this.selectByUDB2PSDCDBInst(pSDevCenterDBInst);
        for (PSDevSlnSysRes pSDevSlnSysRes : arrayList) {
            PSDevSlnSysRes pSDevSlnSysRes2 = (PSDevSlnSysRes)this.getDEModel().createEntity();
            pSDevSlnSysRes2.setPSDevSlnSysResId(pSDevSlnSysRes.getPSDevSlnSysResId());
            pSDevSlnSysRes2.setUDB2PSDCDBInstId(null);
            this.update(pSDevSlnSysRes2);
        }
    }

    public void removeByUDB2PSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        final PSDevCenterDBInst pSDevCenterDBInst2 = pSDevCenterDBInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysResServiceBase.this.onBeforeRemoveByUDB2PSDCDBInst(pSDevCenterDBInst2);
                PSDevSlnSysResServiceBase.this.internalRemoveByUDB2PSDCDBInst(pSDevCenterDBInst2);
                PSDevSlnSysResServiceBase.this.onAfterRemoveByUDB2PSDCDBInst(pSDevCenterDBInst2);
            }
        });
    }

    protected void onBeforeRemoveByUDB2PSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
    }

    protected void internalRemoveByUDB2PSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSDevSlnSysRes> arrayList = this.selectByUDB2PSDCDBInst(pSDevCenterDBInst);
        this.onBeforeRemoveByUDB2PSDCDBInst(pSDevCenterDBInst, arrayList);
        for (PSDevSlnSysRes pSDevSlnSysRes : arrayList) {
            this.remove(pSDevSlnSysRes);
        }
        this.onAfterRemoveByUDB2PSDCDBInst(pSDevCenterDBInst, arrayList);
    }

    protected void onAfterRemoveByUDB2PSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
    }

    protected void onBeforeRemoveByUDB2PSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst, ArrayList<PSDevSlnSysRes> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUDB2PSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst, ArrayList<PSDevSlnSysRes> arrayList) throws Exception {
    }

    public void testRemoveByUMSSqlPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSDevSlnSysRes> arrayList = this.selectByUMSSqlPSDCDBInst(pSDevCenterDBInst, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTERDBINST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevCenterDBInst);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNSYSRES_PSDEVCENTERDBINST_UMSSQLPSDCDBINSTID", "", iDataEntityModel.getName(), "PSDEVSLNSYSRES", iDataEntityModel.getDataInfo(pSDevCenterDBInst), arrayList.get(0)));
        }
    }

    public void resetUMSSqlPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSDevSlnSysRes> arrayList = this.selectByUMSSqlPSDCDBInst(pSDevCenterDBInst);
        for (PSDevSlnSysRes pSDevSlnSysRes : arrayList) {
            PSDevSlnSysRes pSDevSlnSysRes2 = (PSDevSlnSysRes)this.getDEModel().createEntity();
            pSDevSlnSysRes2.setPSDevSlnSysResId(pSDevSlnSysRes.getPSDevSlnSysResId());
            pSDevSlnSysRes2.setUMSSQLPSDCDBInstId(null);
            this.update(pSDevSlnSysRes2);
        }
    }

    public void removeByUMSSqlPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        final PSDevCenterDBInst pSDevCenterDBInst2 = pSDevCenterDBInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysResServiceBase.this.onBeforeRemoveByUMSSqlPSDCDBInst(pSDevCenterDBInst2);
                PSDevSlnSysResServiceBase.this.internalRemoveByUMSSqlPSDCDBInst(pSDevCenterDBInst2);
                PSDevSlnSysResServiceBase.this.onAfterRemoveByUMSSqlPSDCDBInst(pSDevCenterDBInst2);
            }
        });
    }

    protected void onBeforeRemoveByUMSSqlPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
    }

    protected void internalRemoveByUMSSqlPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSDevSlnSysRes> arrayList = this.selectByUMSSqlPSDCDBInst(pSDevCenterDBInst);
        this.onBeforeRemoveByUMSSqlPSDCDBInst(pSDevCenterDBInst, arrayList);
        for (PSDevSlnSysRes pSDevSlnSysRes : arrayList) {
            this.remove(pSDevSlnSysRes);
        }
        this.onAfterRemoveByUMSSqlPSDCDBInst(pSDevCenterDBInst, arrayList);
    }

    protected void onAfterRemoveByUMSSqlPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
    }

    protected void onBeforeRemoveByUMSSqlPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst, ArrayList<PSDevSlnSysRes> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUMSSqlPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst, ArrayList<PSDevSlnSysRes> arrayList) throws Exception {
    }

    public void testRemoveByUMySQLPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSDevSlnSysRes> arrayList = this.selectByUMySQLPSDCDBInst(pSDevCenterDBInst, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTERDBINST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevCenterDBInst);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNSYSRES_PSDEVCENTERDBINST_UMYSQLPSDCDBINSTID", "", iDataEntityModel.getName(), "PSDEVSLNSYSRES", iDataEntityModel.getDataInfo(pSDevCenterDBInst), arrayList.get(0)));
        }
    }

    public void resetUMySQLPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSDevSlnSysRes> arrayList = this.selectByUMySQLPSDCDBInst(pSDevCenterDBInst);
        for (PSDevSlnSysRes pSDevSlnSysRes : arrayList) {
            PSDevSlnSysRes pSDevSlnSysRes2 = (PSDevSlnSysRes)this.getDEModel().createEntity();
            pSDevSlnSysRes2.setPSDevSlnSysResId(pSDevSlnSysRes.getPSDevSlnSysResId());
            pSDevSlnSysRes2.setUMySQLPSDCDBInstId(null);
            this.update(pSDevSlnSysRes2);
        }
    }

    public void removeByUMySQLPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        final PSDevCenterDBInst pSDevCenterDBInst2 = pSDevCenterDBInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysResServiceBase.this.onBeforeRemoveByUMySQLPSDCDBInst(pSDevCenterDBInst2);
                PSDevSlnSysResServiceBase.this.internalRemoveByUMySQLPSDCDBInst(pSDevCenterDBInst2);
                PSDevSlnSysResServiceBase.this.onAfterRemoveByUMySQLPSDCDBInst(pSDevCenterDBInst2);
            }
        });
    }

    protected void onBeforeRemoveByUMySQLPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
    }

    protected void internalRemoveByUMySQLPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSDevSlnSysRes> arrayList = this.selectByUMySQLPSDCDBInst(pSDevCenterDBInst);
        this.onBeforeRemoveByUMySQLPSDCDBInst(pSDevCenterDBInst, arrayList);
        for (PSDevSlnSysRes pSDevSlnSysRes : arrayList) {
            this.remove(pSDevSlnSysRes);
        }
        this.onAfterRemoveByUMySQLPSDCDBInst(pSDevCenterDBInst, arrayList);
    }

    protected void onAfterRemoveByUMySQLPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
    }

    protected void onBeforeRemoveByUMySQLPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst, ArrayList<PSDevSlnSysRes> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUMySQLPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst, ArrayList<PSDevSlnSysRes> arrayList) throws Exception {
    }

    public void testRemoveByUOraPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSDevSlnSysRes> arrayList = this.selectByUOraPSDCDBInst(pSDevCenterDBInst, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTERDBINST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevCenterDBInst);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNSYSRES_PSDEVCENTERDBINST_UORAPSDCDBINSTID", "", iDataEntityModel.getName(), "PSDEVSLNSYSRES", iDataEntityModel.getDataInfo(pSDevCenterDBInst), arrayList.get(0)));
        }
    }

    public void resetUOraPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSDevSlnSysRes> arrayList = this.selectByUOraPSDCDBInst(pSDevCenterDBInst);
        for (PSDevSlnSysRes pSDevSlnSysRes : arrayList) {
            PSDevSlnSysRes pSDevSlnSysRes2 = (PSDevSlnSysRes)this.getDEModel().createEntity();
            pSDevSlnSysRes2.setPSDevSlnSysResId(pSDevSlnSysRes.getPSDevSlnSysResId());
            pSDevSlnSysRes2.setUOraPSDCDBInstId(null);
            this.update(pSDevSlnSysRes2);
        }
    }

    public void removeByUOraPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        final PSDevCenterDBInst pSDevCenterDBInst2 = pSDevCenterDBInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysResServiceBase.this.onBeforeRemoveByUOraPSDCDBInst(pSDevCenterDBInst2);
                PSDevSlnSysResServiceBase.this.internalRemoveByUOraPSDCDBInst(pSDevCenterDBInst2);
                PSDevSlnSysResServiceBase.this.onAfterRemoveByUOraPSDCDBInst(pSDevCenterDBInst2);
            }
        });
    }

    protected void onBeforeRemoveByUOraPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
    }

    protected void internalRemoveByUOraPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSDevSlnSysRes> arrayList = this.selectByUOraPSDCDBInst(pSDevCenterDBInst);
        this.onBeforeRemoveByUOraPSDCDBInst(pSDevCenterDBInst, arrayList);
        for (PSDevSlnSysRes pSDevSlnSysRes : arrayList) {
            this.remove(pSDevSlnSysRes);
        }
        this.onAfterRemoveByUOraPSDCDBInst(pSDevCenterDBInst, arrayList);
    }

    protected void onAfterRemoveByUOraPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
    }

    protected void onBeforeRemoveByUOraPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst, ArrayList<PSDevSlnSysRes> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUOraPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst, ArrayList<PSDevSlnSysRes> arrayList) throws Exception {
    }

    public void testRemoveByUPGSQLPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSDevSlnSysRes> arrayList = this.selectByUPGSQLPSDCDBInst(pSDevCenterDBInst, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTERDBINST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevCenterDBInst);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNSYSRES_PSDEVCENTERDBINST_UPGSQLPSDCDBINSTID", "", iDataEntityModel.getName(), "PSDEVSLNSYSRES", iDataEntityModel.getDataInfo(pSDevCenterDBInst), arrayList.get(0)));
        }
    }

    public void resetUPGSQLPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSDevSlnSysRes> arrayList = this.selectByUPGSQLPSDCDBInst(pSDevCenterDBInst);
        for (PSDevSlnSysRes pSDevSlnSysRes : arrayList) {
            PSDevSlnSysRes pSDevSlnSysRes2 = (PSDevSlnSysRes)this.getDEModel().createEntity();
            pSDevSlnSysRes2.setPSDevSlnSysResId(pSDevSlnSysRes.getPSDevSlnSysResId());
            pSDevSlnSysRes2.setUPGSQLPSDCDBInstId(null);
            this.update(pSDevSlnSysRes2);
        }
    }

    public void removeByUPGSQLPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        final PSDevCenterDBInst pSDevCenterDBInst2 = pSDevCenterDBInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysResServiceBase.this.onBeforeRemoveByUPGSQLPSDCDBInst(pSDevCenterDBInst2);
                PSDevSlnSysResServiceBase.this.internalRemoveByUPGSQLPSDCDBInst(pSDevCenterDBInst2);
                PSDevSlnSysResServiceBase.this.onAfterRemoveByUPGSQLPSDCDBInst(pSDevCenterDBInst2);
            }
        });
    }

    protected void onBeforeRemoveByUPGSQLPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
    }

    protected void internalRemoveByUPGSQLPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSDevSlnSysRes> arrayList = this.selectByUPGSQLPSDCDBInst(pSDevCenterDBInst);
        this.onBeforeRemoveByUPGSQLPSDCDBInst(pSDevCenterDBInst, arrayList);
        for (PSDevSlnSysRes pSDevSlnSysRes : arrayList) {
            this.remove(pSDevSlnSysRes);
        }
        this.onAfterRemoveByUPGSQLPSDCDBInst(pSDevCenterDBInst, arrayList);
    }

    protected void onAfterRemoveByUPGSQLPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
    }

    protected void onBeforeRemoveByUPGSQLPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst, ArrayList<PSDevSlnSysRes> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUPGSQLPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst, ArrayList<PSDevSlnSysRes> arrayList) throws Exception {
    }

    public void testRemoveByUPPASPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSDevSlnSysRes> arrayList = this.selectByUPPASPSDCDBInst(pSDevCenterDBInst, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTERDBINST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevCenterDBInst);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNSYSRES_PSDEVCENTERDBINST_UPPASPSDCDBINSTID", "", iDataEntityModel.getName(), "PSDEVSLNSYSRES", iDataEntityModel.getDataInfo(pSDevCenterDBInst), arrayList.get(0)));
        }
    }

    public void resetUPPASPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSDevSlnSysRes> arrayList = this.selectByUPPASPSDCDBInst(pSDevCenterDBInst);
        for (PSDevSlnSysRes pSDevSlnSysRes : arrayList) {
            PSDevSlnSysRes pSDevSlnSysRes2 = (PSDevSlnSysRes)this.getDEModel().createEntity();
            pSDevSlnSysRes2.setPSDevSlnSysResId(pSDevSlnSysRes.getPSDevSlnSysResId());
            pSDevSlnSysRes2.setUPPASPSDCDBInstId(null);
            this.update(pSDevSlnSysRes2);
        }
    }

    public void removeByUPPASPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        final PSDevCenterDBInst pSDevCenterDBInst2 = pSDevCenterDBInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysResServiceBase.this.onBeforeRemoveByUPPASPSDCDBInst(pSDevCenterDBInst2);
                PSDevSlnSysResServiceBase.this.internalRemoveByUPPASPSDCDBInst(pSDevCenterDBInst2);
                PSDevSlnSysResServiceBase.this.onAfterRemoveByUPPASPSDCDBInst(pSDevCenterDBInst2);
            }
        });
    }

    protected void onBeforeRemoveByUPPASPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
    }

    protected void internalRemoveByUPPASPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSDevSlnSysRes> arrayList = this.selectByUPPASPSDCDBInst(pSDevCenterDBInst);
        this.onBeforeRemoveByUPPASPSDCDBInst(pSDevCenterDBInst, arrayList);
        for (PSDevSlnSysRes pSDevSlnSysRes : arrayList) {
            this.remove(pSDevSlnSysRes);
        }
        this.onAfterRemoveByUPPASPSDCDBInst(pSDevCenterDBInst, arrayList);
    }

    protected void onAfterRemoveByUPPASPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
    }

    protected void onBeforeRemoveByUPPASPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst, ArrayList<PSDevSlnSysRes> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUPPASPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst, ArrayList<PSDevSlnSysRes> arrayList) throws Exception {
    }

    public void testRemoveByPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        ArrayList<PSDevSlnSysRes> arrayList = this.selectByPSDevCenterSVN(pSDevCenterSVN, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTERSVN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevCenterSVN);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNSYSRES_PSDEVCENTERSVN_PSDEVCENTERSVNID", "", iDataEntityModel.getName(), "PSDEVSLNSYSRES", iDataEntityModel.getDataInfo(pSDevCenterSVN), arrayList.get(0)));
        }
    }

    public void resetPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        ArrayList<PSDevSlnSysRes> arrayList = this.selectByPSDevCenterSVN(pSDevCenterSVN);
        for (PSDevSlnSysRes pSDevSlnSysRes : arrayList) {
            PSDevSlnSysRes pSDevSlnSysRes2 = (PSDevSlnSysRes)this.getDEModel().createEntity();
            pSDevSlnSysRes2.setPSDevSlnSysResId(pSDevSlnSysRes.getPSDevSlnSysResId());
            pSDevSlnSysRes2.setPSDevCenterSVNId(null);
            this.update(pSDevSlnSysRes2);
        }
    }

    public void removeByPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        final PSDevCenterSVN pSDevCenterSVN2 = pSDevCenterSVN;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysResServiceBase.this.onBeforeRemoveByPSDevCenterSVN(pSDevCenterSVN2);
                PSDevSlnSysResServiceBase.this.internalRemoveByPSDevCenterSVN(pSDevCenterSVN2);
                PSDevSlnSysResServiceBase.this.onAfterRemoveByPSDevCenterSVN(pSDevCenterSVN2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
    }

    protected void internalRemoveByPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        ArrayList<PSDevSlnSysRes> arrayList = this.selectByPSDevCenterSVN(pSDevCenterSVN);
        this.onBeforeRemoveByPSDevCenterSVN(pSDevCenterSVN, arrayList);
        for (PSDevSlnSysRes pSDevSlnSysRes : arrayList) {
            this.remove(pSDevSlnSysRes);
        }
        this.onAfterRemoveByPSDevCenterSVN(pSDevCenterSVN, arrayList);
    }

    protected void onAfterRemoveByPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN, ArrayList<PSDevSlnSysRes> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN, ArrayList<PSDevSlnSysRes> arrayList) throws Exception {
    }

    public void testRemoveByROPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        ArrayList<PSDevSlnSysRes> arrayList = this.selectByROPSDevCenterSVN(pSDevCenterSVN, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTERSVN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevCenterSVN);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNSYSRES_PSDEVCENTERSVN_ROPSDEVCENTERSVNID", "", iDataEntityModel.getName(), "PSDEVSLNSYSRES", iDataEntityModel.getDataInfo(pSDevCenterSVN), arrayList.get(0)));
        }
    }

    public void resetROPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        ArrayList<PSDevSlnSysRes> arrayList = this.selectByROPSDevCenterSVN(pSDevCenterSVN);
        for (PSDevSlnSysRes pSDevSlnSysRes : arrayList) {
            PSDevSlnSysRes pSDevSlnSysRes2 = (PSDevSlnSysRes)this.getDEModel().createEntity();
            pSDevSlnSysRes2.setPSDevSlnSysResId(pSDevSlnSysRes.getPSDevSlnSysResId());
            pSDevSlnSysRes2.setROPSDevCenterSvnId(null);
            this.update(pSDevSlnSysRes2);
        }
    }

    public void removeByROPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        final PSDevCenterSVN pSDevCenterSVN2 = pSDevCenterSVN;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysResServiceBase.this.onBeforeRemoveByROPSDevCenterSVN(pSDevCenterSVN2);
                PSDevSlnSysResServiceBase.this.internalRemoveByROPSDevCenterSVN(pSDevCenterSVN2);
                PSDevSlnSysResServiceBase.this.onAfterRemoveByROPSDevCenterSVN(pSDevCenterSVN2);
            }
        });
    }

    protected void onBeforeRemoveByROPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
    }

    protected void internalRemoveByROPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        ArrayList<PSDevSlnSysRes> arrayList = this.selectByROPSDevCenterSVN(pSDevCenterSVN);
        this.onBeforeRemoveByROPSDevCenterSVN(pSDevCenterSVN, arrayList);
        for (PSDevSlnSysRes pSDevSlnSysRes : arrayList) {
            this.remove(pSDevSlnSysRes);
        }
        this.onAfterRemoveByROPSDevCenterSVN(pSDevCenterSVN, arrayList);
    }

    protected void onAfterRemoveByROPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
    }

    protected void onBeforeRemoveByROPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN, ArrayList<PSDevSlnSysRes> arrayList) throws Exception {
    }

    protected void onAfterRemoveByROPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN, ArrayList<PSDevSlnSysRes> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
    }

    public void resetPSDevSln(PSDevSln pSDevSln) throws Exception {
        ArrayList<PSDevSlnSysRes> arrayList = this.selectByPSDevSln(pSDevSln);
        for (PSDevSlnSysRes pSDevSlnSysRes : arrayList) {
            PSDevSlnSysRes pSDevSlnSysRes2 = (PSDevSlnSysRes)this.getDEModel().createEntity();
            pSDevSlnSysRes2.setPSDevSlnSysResId(pSDevSlnSysRes.getPSDevSlnSysResId());
            pSDevSlnSysRes2.setPSDevSlnId(null);
            this.update(pSDevSlnSysRes2);
        }
    }

    public void removeByPSDevSln(PSDevSln pSDevSln) throws Exception {
        final PSDevSln pSDevSln2 = pSDevSln;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysResServiceBase.this.onBeforeRemoveByPSDevSln(pSDevSln2);
                PSDevSlnSysResServiceBase.this.internalRemoveByPSDevSln(pSDevSln2);
                PSDevSlnSysResServiceBase.this.onAfterRemoveByPSDevSln(pSDevSln2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
    }

    protected void internalRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
        ArrayList<PSDevSlnSysRes> arrayList = this.selectByPSDevSln(pSDevSln);
        this.onBeforeRemoveByPSDevSln(pSDevSln, arrayList);
        for (PSDevSlnSysRes pSDevSlnSysRes : arrayList) {
            this.remove(pSDevSlnSysRes);
        }
        this.onAfterRemoveByPSDevSln(pSDevSln, arrayList);
    }

    protected void onAfterRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSln(PSDevSln pSDevSln, ArrayList<PSDevSlnSysRes> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSln(PSDevSln pSDevSln, ArrayList<PSDevSlnSysRes> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDevSlnSysRes pSDevSlnSysRes) throws Exception {
        PSDevSlnSysService pSDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)this.getSessionFactory());
        pSDevSlnSysService.testRemoveByPSDevSlnSysRes(pSDevSlnSysRes);
        super.onBeforeRemove(pSDevSlnSysRes);
    }

    protected void replaceParentInfo(PSDevSlnSysRes pSDevSlnSysRes, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDevSlnSysRes, cloneSession);
        if (pSDevSlnSysRes.getHBasePSDCBDInstId() != null && (iEntity = cloneSession.getEntity("PSDCBDINST", (Object)pSDevSlnSysRes.getHBasePSDCBDInstId())) != null) {
            this.onFillParentInfo_HBasePSDCBDInst(pSDevSlnSysRes, (PSDCBDInst)iEntity);
        }
        if (pSDevSlnSysRes.getUHBasePSDCBDInstId() != null && (iEntity = cloneSession.getEntity("PSDCBDINST", (Object)pSDevSlnSysRes.getUHBasePSDCBDInstId())) != null) {
            this.onFillParentInfo_UHBasePSDCBDInst(pSDevSlnSysRes, (PSDCBDInst)iEntity);
        }
        if (pSDevSlnSysRes.getPSDCDeployServerId() != null && (iEntity = cloneSession.getEntity("PSDCDEPLOYSERVER", (Object)pSDevSlnSysRes.getPSDCDeployServerId())) != null) {
            this.onFillParentInfo_PSDCDeployServer(pSDevSlnSysRes, (PSDCDeployServer)iEntity);
        }
        if (pSDevSlnSysRes.getPSDevCenterASId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTERAS", (Object)pSDevSlnSysRes.getPSDevCenterASId())) != null) {
            this.onFillParentInfo_PSDevCenterAS(pSDevSlnSysRes, (PSDevCenterAS)iEntity);
        }
        if (pSDevSlnSysRes.getPSDevCenterASId2() != null && (iEntity = cloneSession.getEntity("PSDEVCENTERAS", (Object)pSDevSlnSysRes.getPSDevCenterASId2())) != null) {
            this.onFillParentInfo_PSDevCenterAS2(pSDevSlnSysRes, (PSDevCenterAS)iEntity);
        }
        if (pSDevSlnSysRes.getUPSDevCenterASId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTERAS", (Object)pSDevSlnSysRes.getUPSDevCenterASId())) != null) {
            this.onFillParentInfo_UPSDevCenterAS(pSDevSlnSysRes, (PSDevCenterAS)iEntity);
        }
        if (pSDevSlnSysRes.getUPSDevCenterASId2() != null && (iEntity = cloneSession.getEntity("PSDEVCENTERAS", (Object)pSDevSlnSysRes.getUPSDevCenterASId2())) != null) {
            this.onFillParentInfo_UPSDevCenterAS2(pSDevSlnSysRes, (PSDevCenterAS)iEntity);
        }
        if (pSDevSlnSysRes.getDB2PSDCDBInstId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTERDBINST", (Object)pSDevSlnSysRes.getDB2PSDCDBInstId())) != null) {
            this.onFillParentInfo_DB2PSDCDBInst(pSDevSlnSysRes, (PSDevCenterDBInst)iEntity);
        }
        if (pSDevSlnSysRes.getMSSQLPSDCDBInstId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTERDBINST", (Object)pSDevSlnSysRes.getMSSQLPSDCDBInstId())) != null) {
            this.onFillParentInfo_MSSqlPSDCDBInst(pSDevSlnSysRes, (PSDevCenterDBInst)iEntity);
        }
        if (pSDevSlnSysRes.getMySQLPSDCDBInstId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTERDBINST", (Object)pSDevSlnSysRes.getMySQLPSDCDBInstId())) != null) {
            this.onFillParentInfo_MySQLPSDCDBInst(pSDevSlnSysRes, (PSDevCenterDBInst)iEntity);
        }
        if (pSDevSlnSysRes.getOraPSDCDBInstId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTERDBINST", (Object)pSDevSlnSysRes.getOraPSDCDBInstId())) != null) {
            this.onFillParentInfo_OraPSDCDBInst(pSDevSlnSysRes, (PSDevCenterDBInst)iEntity);
        }
        if (pSDevSlnSysRes.getPGSQLPSDCDBInstId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTERDBINST", (Object)pSDevSlnSysRes.getPGSQLPSDCDBInstId())) != null) {
            this.onFillParentInfo_PGSQLPSDCDBInst(pSDevSlnSysRes, (PSDevCenterDBInst)iEntity);
        }
        if (pSDevSlnSysRes.getPPASPSDCDBInstId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTERDBINST", (Object)pSDevSlnSysRes.getPPASPSDCDBInstId())) != null) {
            this.onFillParentInfo_PPASPSDCDBInst(pSDevSlnSysRes, (PSDevCenterDBInst)iEntity);
        }
        if (pSDevSlnSysRes.getUDB2PSDCDBInstId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTERDBINST", (Object)pSDevSlnSysRes.getUDB2PSDCDBInstId())) != null) {
            this.onFillParentInfo_UDB2PSDCDBInst(pSDevSlnSysRes, (PSDevCenterDBInst)iEntity);
        }
        if (pSDevSlnSysRes.getUMSSQLPSDCDBInstId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTERDBINST", (Object)pSDevSlnSysRes.getUMSSQLPSDCDBInstId())) != null) {
            this.onFillParentInfo_UMSSqlPSDCDBInst(pSDevSlnSysRes, (PSDevCenterDBInst)iEntity);
        }
        if (pSDevSlnSysRes.getUMySQLPSDCDBInstId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTERDBINST", (Object)pSDevSlnSysRes.getUMySQLPSDCDBInstId())) != null) {
            this.onFillParentInfo_UMySQLPSDCDBInst(pSDevSlnSysRes, (PSDevCenterDBInst)iEntity);
        }
        if (pSDevSlnSysRes.getUOraPSDCDBInstId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTERDBINST", (Object)pSDevSlnSysRes.getUOraPSDCDBInstId())) != null) {
            this.onFillParentInfo_UOraPSDCDBInst(pSDevSlnSysRes, (PSDevCenterDBInst)iEntity);
        }
        if (pSDevSlnSysRes.getUPGSQLPSDCDBInstId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTERDBINST", (Object)pSDevSlnSysRes.getUPGSQLPSDCDBInstId())) != null) {
            this.onFillParentInfo_UPGSQLPSDCDBInst(pSDevSlnSysRes, (PSDevCenterDBInst)iEntity);
        }
        if (pSDevSlnSysRes.getUPPASPSDCDBInstId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTERDBINST", (Object)pSDevSlnSysRes.getUPPASPSDCDBInstId())) != null) {
            this.onFillParentInfo_UPPASPSDCDBInst(pSDevSlnSysRes, (PSDevCenterDBInst)iEntity);
        }
        if (pSDevSlnSysRes.getPSDevCenterSVNId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTERSVN", (Object)pSDevSlnSysRes.getPSDevCenterSVNId())) != null) {
            this.onFillParentInfo_PSDevCenterSVN(pSDevSlnSysRes, (PSDevCenterSVN)iEntity);
        }
        if (pSDevSlnSysRes.getROPSDevCenterSvnId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTERSVN", (Object)pSDevSlnSysRes.getROPSDevCenterSvnId())) != null) {
            this.onFillParentInfo_ROPSDevCenterSVN(pSDevSlnSysRes, (PSDevCenterSVN)iEntity);
        }
        if (pSDevSlnSysRes.getPSDevSlnId() != null && (iEntity = cloneSession.getEntity("PSDEVSLN", (Object)pSDevSlnSysRes.getPSDevSlnId())) != null) {
            this.onFillParentInfo_PSDevSln(pSDevSlnSysRes, (PSDevSln)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDevSlnSysRes pSDevSlnSysRes, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDevSlnSysRes, bl);
    }

    protected void onCheckEntity(boolean bl, PSDevSlnSysRes pSDevSlnSysRes, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_DB2PSDCDBInstId(bl, pSDevSlnSysRes, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DB2PSDCDBInstName(bl, pSDevSlnSysRes, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HBasePSDCBDInstId(bl, pSDevSlnSysRes, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDevSlnSysRes, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MSSQLPSDCDBInstId(bl, pSDevSlnSysRes, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MSSQLPSDCDBInstName(bl, pSDevSlnSysRes, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MySQLPSDCDBInstId(bl, pSDevSlnSysRes, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MySQLPSDCDBInstName(bl, pSDevSlnSysRes, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OraPSDCDBInstId(bl, pSDevSlnSysRes, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OraPSDCDBInstName(bl, pSDevSlnSysRes, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PGSQLPSDCDBInstId(bl, pSDevSlnSysRes, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PGSQLPSDCDBInstName(bl, pSDevSlnSysRes, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPASPSDCDBInstId(bl, pSDevSlnSysRes, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPASPSDCDBInstName(bl, pSDevSlnSysRes, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCDeployServerId(bl, pSDevSlnSysRes, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterASId(bl, pSDevSlnSysRes, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterASId2(bl, pSDevSlnSysRes, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterSVNId(bl, pSDevSlnSysRes, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnId(bl, pSDevSlnSysRes, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnName(bl, pSDevSlnSysRes, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysResId(bl, pSDevSlnSysRes, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysResName(bl, pSDevSlnSysRes, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ResInfo(bl, pSDevSlnSysRes, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ResPos(bl, pSDevSlnSysRes, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ROPSDevCenterSvnId(bl, pSDevSlnSysRes, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UDB2PSDCDBInstId(bl, pSDevSlnSysRes, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UDB2PSDCDBInstName(bl, pSDevSlnSysRes, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UHBasePSDCBDInstId(bl, pSDevSlnSysRes, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UMSSQLPSDCDBInstId(bl, pSDevSlnSysRes, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UMSSQLPSDCDBInstName(bl, pSDevSlnSysRes, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UMySQLPSDCDBInstId(bl, pSDevSlnSysRes, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UMySQLPSDCDBInstName(bl, pSDevSlnSysRes, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UOraPSDCDBInstId(bl, pSDevSlnSysRes, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UOraPSDCDBInstName(bl, pSDevSlnSysRes, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UPGSQLPSDCDBInstId(bl, pSDevSlnSysRes, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UPGSQLPSDCDBInstName(bl, pSDevSlnSysRes, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UPPASPSDCDBInstId(bl, pSDevSlnSysRes, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UPPASPSDCDBInstName(bl, pSDevSlnSysRes, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UPSDevCenterASId(bl, pSDevSlnSysRes, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UPSDevCenterASId2(bl, pSDevSlnSysRes, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDevSlnSysRes, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_DB2PSDCDBInstId(boolean bl, PSDevSlnSysRes pSDevSlnSysRes, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysRes.isDB2PSDCDBInstIdDirty() : !pSDevSlnSysRes.isDB2PSDCDBInstIdDirty()) {
            return null;
        }
        String string = pSDevSlnSysRes.getDB2PSDCDBInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DB2PSDCDBInstId_Default(pSDevSlnSysRes, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DB2PSDCDBINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DB2PSDCDBInstName(boolean bl, PSDevSlnSysRes pSDevSlnSysRes, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysRes.isDB2PSDCDBInstNameDirty() : !pSDevSlnSysRes.isDB2PSDCDBInstNameDirty()) {
            return null;
        }
        String string = pSDevSlnSysRes.getDB2PSDCDBInstName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DB2PSDCDBInstName_Default(pSDevSlnSysRes, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DB2PSDCDBINSTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_HBasePSDCBDInstId(boolean bl, PSDevSlnSysRes pSDevSlnSysRes, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysRes.isHBasePSDCBDInstIdDirty() : !pSDevSlnSysRes.isHBasePSDCBDInstIdDirty()) {
            return null;
        }
        String string = pSDevSlnSysRes.getHBasePSDCBDInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_HBasePSDCBDInstId_Default(pSDevSlnSysRes, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HBASEPSDCBDINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDevSlnSysRes pSDevSlnSysRes, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysRes.isMemoDirty() : !pSDevSlnSysRes.isMemoDirty()) {
            return null;
        }
        String string = pSDevSlnSysRes.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDevSlnSysRes, bl2, bl3);
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

    protected EntityFieldError onCheckField_MSSQLPSDCDBInstId(boolean bl, PSDevSlnSysRes pSDevSlnSysRes, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysRes.isMSSQLPSDCDBInstIdDirty() : !pSDevSlnSysRes.isMSSQLPSDCDBInstIdDirty()) {
            return null;
        }
        String string = pSDevSlnSysRes.getMSSQLPSDCDBInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MSSQLPSDCDBInstId_Default(pSDevSlnSysRes, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MSSQLPSDCDBINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MSSQLPSDCDBInstName(boolean bl, PSDevSlnSysRes pSDevSlnSysRes, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysRes.isMSSQLPSDCDBInstNameDirty() : !pSDevSlnSysRes.isMSSQLPSDCDBInstNameDirty()) {
            return null;
        }
        String string = pSDevSlnSysRes.getMSSQLPSDCDBInstName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MSSQLPSDCDBInstName_Default(pSDevSlnSysRes, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MSSQLPSDCDBINSTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MySQLPSDCDBInstId(boolean bl, PSDevSlnSysRes pSDevSlnSysRes, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysRes.isMySQLPSDCDBInstIdDirty() : !pSDevSlnSysRes.isMySQLPSDCDBInstIdDirty()) {
            return null;
        }
        String string = pSDevSlnSysRes.getMySQLPSDCDBInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MySQLPSDCDBInstId_Default(pSDevSlnSysRes, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MYSQLPSDCDBINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MySQLPSDCDBInstName(boolean bl, PSDevSlnSysRes pSDevSlnSysRes, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysRes.isMySQLPSDCDBInstNameDirty() : !pSDevSlnSysRes.isMySQLPSDCDBInstNameDirty()) {
            return null;
        }
        String string = pSDevSlnSysRes.getMySQLPSDCDBInstName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MySQLPSDCDBInstName_Default(pSDevSlnSysRes, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MYSQLPSDCDBINSTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OraPSDCDBInstId(boolean bl, PSDevSlnSysRes pSDevSlnSysRes, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysRes.isOraPSDCDBInstIdDirty() : !pSDevSlnSysRes.isOraPSDCDBInstIdDirty()) {
            return null;
        }
        String string = pSDevSlnSysRes.getOraPSDCDBInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_OraPSDCDBInstId_Default(pSDevSlnSysRes, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ORAPSDCDBINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OraPSDCDBInstName(boolean bl, PSDevSlnSysRes pSDevSlnSysRes, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysRes.isOraPSDCDBInstNameDirty() : !pSDevSlnSysRes.isOraPSDCDBInstNameDirty()) {
            return null;
        }
        String string = pSDevSlnSysRes.getOraPSDCDBInstName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_OraPSDCDBInstName_Default(pSDevSlnSysRes, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ORAPSDCDBINSTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PGSQLPSDCDBInstId(boolean bl, PSDevSlnSysRes pSDevSlnSysRes, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysRes.isPGSQLPSDCDBInstIdDirty() : !pSDevSlnSysRes.isPGSQLPSDCDBInstIdDirty()) {
            return null;
        }
        String string = pSDevSlnSysRes.getPGSQLPSDCDBInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PGSQLPSDCDBInstId_Default(pSDevSlnSysRes, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PGSQLPSDCDBINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PGSQLPSDCDBInstName(boolean bl, PSDevSlnSysRes pSDevSlnSysRes, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysRes.isPGSQLPSDCDBInstNameDirty() : !pSDevSlnSysRes.isPGSQLPSDCDBInstNameDirty()) {
            return null;
        }
        String string = pSDevSlnSysRes.getPGSQLPSDCDBInstName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PGSQLPSDCDBInstName_Default(pSDevSlnSysRes, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PGSQLPSDCDBINSTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PPASPSDCDBInstId(boolean bl, PSDevSlnSysRes pSDevSlnSysRes, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysRes.isPPASPSDCDBInstIdDirty() : !pSDevSlnSysRes.isPPASPSDCDBInstIdDirty()) {
            return null;
        }
        String string = pSDevSlnSysRes.getPPASPSDCDBInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PPASPSDCDBInstId_Default(pSDevSlnSysRes, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPASPSDCDBINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PPASPSDCDBInstName(boolean bl, PSDevSlnSysRes pSDevSlnSysRes, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysRes.isPPASPSDCDBInstNameDirty() : !pSDevSlnSysRes.isPPASPSDCDBInstNameDirty()) {
            return null;
        }
        String string = pSDevSlnSysRes.getPPASPSDCDBInstName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PPASPSDCDBInstName_Default(pSDevSlnSysRes, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPASPSDCDBINSTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCDeployServerId(boolean bl, PSDevSlnSysRes pSDevSlnSysRes, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysRes.isPSDCDeployServerIdDirty() : !pSDevSlnSysRes.isPSDCDeployServerIdDirty()) {
            return null;
        }
        String string = pSDevSlnSysRes.getPSDCDeployServerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCDeployServerId_Default(pSDevSlnSysRes, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCDEPLOYSERVERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterASId(boolean bl, PSDevSlnSysRes pSDevSlnSysRes, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysRes.isPSDevCenterASIdDirty() : !pSDevSlnSysRes.isPSDevCenterASIdDirty()) {
            return null;
        }
        String string = pSDevSlnSysRes.getPSDevCenterASId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterASId_Default(pSDevSlnSysRes, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERASID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterASId2(boolean bl, PSDevSlnSysRes pSDevSlnSysRes, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysRes.isPSDevCenterASId2Dirty() : !pSDevSlnSysRes.isPSDevCenterASId2Dirty()) {
            return null;
        }
        String string = pSDevSlnSysRes.getPSDevCenterASId2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterASId2_Default(pSDevSlnSysRes, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERASID2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterSVNId(boolean bl, PSDevSlnSysRes pSDevSlnSysRes, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysRes.isPSDevCenterSVNIdDirty() : !pSDevSlnSysRes.isPSDevCenterSVNIdDirty()) {
            return null;
        }
        String string = pSDevSlnSysRes.getPSDevCenterSVNId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterSVNId_Default(pSDevSlnSysRes, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERSVNID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnId(boolean bl, PSDevSlnSysRes pSDevSlnSysRes, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysRes.isPSDevSlnIdDirty() : !pSDevSlnSysRes.isPSDevSlnIdDirty()) {
            return null;
        }
        String string = pSDevSlnSysRes.getPSDevSlnId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnId_Default(pSDevSlnSysRes, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnName(boolean bl, PSDevSlnSysRes pSDevSlnSysRes, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysRes.isPSDevSlnNameDirty() : !pSDevSlnSysRes.isPSDevSlnNameDirty()) {
            return null;
        }
        String string = pSDevSlnSysRes.getPSDevSlnName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnName_Default(pSDevSlnSysRes, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnSysResId(boolean bl, PSDevSlnSysRes pSDevSlnSysRes, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysRes.isPSDevSlnSysResIdDirty() && !bl2 : !pSDevSlnSysRes.isPSDevSlnSysResIdDirty()) {
            return null;
        }
        String string = pSDevSlnSysRes.getPSDevSlnSysResId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSRESID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysResId_Default(pSDevSlnSysRes, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSRESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnSysResName(boolean bl, PSDevSlnSysRes pSDevSlnSysRes, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysRes.isPSDevSlnSysResNameDirty() && !bl2 : !pSDevSlnSysRes.isPSDevSlnSysResNameDirty()) {
            return null;
        }
        String string = pSDevSlnSysRes.getPSDevSlnSysResName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSRESNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysResName_Default(pSDevSlnSysRes, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSRESNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ResInfo(boolean bl, PSDevSlnSysRes pSDevSlnSysRes, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysRes.isResInfoDirty() : !pSDevSlnSysRes.isResInfoDirty()) {
            return null;
        }
        String string = pSDevSlnSysRes.getResInfo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ResInfo_Default(pSDevSlnSysRes, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RESINFO");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ResPos(boolean bl, PSDevSlnSysRes pSDevSlnSysRes, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysRes.isResPosDirty() && !bl2 : !pSDevSlnSysRes.isResPosDirty()) {
            return null;
        }
        Integer n = pSDevSlnSysRes.getResPos();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RESPOS");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ResPos_Default(pSDevSlnSysRes, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RESPOS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ROPSDevCenterSvnId(boolean bl, PSDevSlnSysRes pSDevSlnSysRes, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysRes.isROPSDevCenterSvnIdDirty() : !pSDevSlnSysRes.isROPSDevCenterSvnIdDirty()) {
            return null;
        }
        String string = pSDevSlnSysRes.getROPSDevCenterSvnId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ROPSDevCenterSvnId_Default(pSDevSlnSysRes, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ROPSDEVCENTERSVNID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UDB2PSDCDBInstId(boolean bl, PSDevSlnSysRes pSDevSlnSysRes, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysRes.isUDB2PSDCDBInstIdDirty() : !pSDevSlnSysRes.isUDB2PSDCDBInstIdDirty()) {
            return null;
        }
        String string = pSDevSlnSysRes.getUDB2PSDCDBInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UDB2PSDCDBInstId_Default(pSDevSlnSysRes, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UDB2PSDCDBINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UDB2PSDCDBInstName(boolean bl, PSDevSlnSysRes pSDevSlnSysRes, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysRes.isUDB2PSDCDBInstNameDirty() : !pSDevSlnSysRes.isUDB2PSDCDBInstNameDirty()) {
            return null;
        }
        String string = pSDevSlnSysRes.getUDB2PSDCDBInstName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UDB2PSDCDBInstName_Default(pSDevSlnSysRes, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UDB2PSDCDBINSTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UHBasePSDCBDInstId(boolean bl, PSDevSlnSysRes pSDevSlnSysRes, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysRes.isUHBasePSDCBDInstIdDirty() : !pSDevSlnSysRes.isUHBasePSDCBDInstIdDirty()) {
            return null;
        }
        String string = pSDevSlnSysRes.getUHBasePSDCBDInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UHBasePSDCBDInstId_Default(pSDevSlnSysRes, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UHBASEPSDCBDINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UMSSQLPSDCDBInstId(boolean bl, PSDevSlnSysRes pSDevSlnSysRes, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysRes.isUMSSQLPSDCDBInstIdDirty() : !pSDevSlnSysRes.isUMSSQLPSDCDBInstIdDirty()) {
            return null;
        }
        String string = pSDevSlnSysRes.getUMSSQLPSDCDBInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UMSSQLPSDCDBInstId_Default(pSDevSlnSysRes, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UMSSQLPSDCDBINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UMSSQLPSDCDBInstName(boolean bl, PSDevSlnSysRes pSDevSlnSysRes, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysRes.isUMSSQLPSDCDBInstNameDirty() : !pSDevSlnSysRes.isUMSSQLPSDCDBInstNameDirty()) {
            return null;
        }
        String string = pSDevSlnSysRes.getUMSSQLPSDCDBInstName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UMSSQLPSDCDBInstName_Default(pSDevSlnSysRes, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UMSSQLPSDCDBINSTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UMySQLPSDCDBInstId(boolean bl, PSDevSlnSysRes pSDevSlnSysRes, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysRes.isUMySQLPSDCDBInstIdDirty() : !pSDevSlnSysRes.isUMySQLPSDCDBInstIdDirty()) {
            return null;
        }
        String string = pSDevSlnSysRes.getUMySQLPSDCDBInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UMySQLPSDCDBInstId_Default(pSDevSlnSysRes, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UMYSQLPSDCDBINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UMySQLPSDCDBInstName(boolean bl, PSDevSlnSysRes pSDevSlnSysRes, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysRes.isUMySQLPSDCDBInstNameDirty() : !pSDevSlnSysRes.isUMySQLPSDCDBInstNameDirty()) {
            return null;
        }
        String string = pSDevSlnSysRes.getUMySQLPSDCDBInstName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UMySQLPSDCDBInstName_Default(pSDevSlnSysRes, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UMYSQLPSDCDBINSTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UOraPSDCDBInstId(boolean bl, PSDevSlnSysRes pSDevSlnSysRes, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysRes.isUOraPSDCDBInstIdDirty() : !pSDevSlnSysRes.isUOraPSDCDBInstIdDirty()) {
            return null;
        }
        String string = pSDevSlnSysRes.getUOraPSDCDBInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UOraPSDCDBInstId_Default(pSDevSlnSysRes, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UORAPSDCDBINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UOraPSDCDBInstName(boolean bl, PSDevSlnSysRes pSDevSlnSysRes, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysRes.isUOraPSDCDBInstNameDirty() : !pSDevSlnSysRes.isUOraPSDCDBInstNameDirty()) {
            return null;
        }
        String string = pSDevSlnSysRes.getUOraPSDCDBInstName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UOraPSDCDBInstName_Default(pSDevSlnSysRes, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UORAPSDCDBINSTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UPGSQLPSDCDBInstId(boolean bl, PSDevSlnSysRes pSDevSlnSysRes, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysRes.isUPGSQLPSDCDBInstIdDirty() : !pSDevSlnSysRes.isUPGSQLPSDCDBInstIdDirty()) {
            return null;
        }
        String string = pSDevSlnSysRes.getUPGSQLPSDCDBInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UPGSQLPSDCDBInstId_Default(pSDevSlnSysRes, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UPGSQLPSDCDBINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UPGSQLPSDCDBInstName(boolean bl, PSDevSlnSysRes pSDevSlnSysRes, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysRes.isUPGSQLPSDCDBInstNameDirty() : !pSDevSlnSysRes.isUPGSQLPSDCDBInstNameDirty()) {
            return null;
        }
        String string = pSDevSlnSysRes.getUPGSQLPSDCDBInstName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UPGSQLPSDCDBInstName_Default(pSDevSlnSysRes, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UPGSQLPSDCDBINSTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UPPASPSDCDBInstId(boolean bl, PSDevSlnSysRes pSDevSlnSysRes, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysRes.isUPPASPSDCDBInstIdDirty() : !pSDevSlnSysRes.isUPPASPSDCDBInstIdDirty()) {
            return null;
        }
        String string = pSDevSlnSysRes.getUPPASPSDCDBInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UPPASPSDCDBInstId_Default(pSDevSlnSysRes, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UPPASPSDCDBINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UPPASPSDCDBInstName(boolean bl, PSDevSlnSysRes pSDevSlnSysRes, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysRes.isUPPASPSDCDBInstNameDirty() : !pSDevSlnSysRes.isUPPASPSDCDBInstNameDirty()) {
            return null;
        }
        String string = pSDevSlnSysRes.getUPPASPSDCDBInstName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UPPASPSDCDBInstName_Default(pSDevSlnSysRes, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UPPASPSDCDBINSTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UPSDevCenterASId(boolean bl, PSDevSlnSysRes pSDevSlnSysRes, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysRes.isUPSDevCenterASIdDirty() : !pSDevSlnSysRes.isUPSDevCenterASIdDirty()) {
            return null;
        }
        String string = pSDevSlnSysRes.getUPSDevCenterASId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UPSDevCenterASId_Default(pSDevSlnSysRes, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UPSDEVCENTERASID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UPSDevCenterASId2(boolean bl, PSDevSlnSysRes pSDevSlnSysRes, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysRes.isUPSDevCenterASId2Dirty() : !pSDevSlnSysRes.isUPSDevCenterASId2Dirty()) {
            return null;
        }
        String string = pSDevSlnSysRes.getUPSDevCenterASId2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UPSDevCenterASId2_Default(pSDevSlnSysRes, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UPSDEVCENTERASID2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDevSlnSysRes pSDevSlnSysRes, boolean bl) throws Exception {
        super.onSyncEntity(pSDevSlnSysRes, bl);
    }

    protected void onSyncIndexEntities(PSDevSlnSysRes pSDevSlnSysRes, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDevSlnSysRes, bl);
    }

    public Object getDataContextValue(PSDevSlnSysRes pSDevSlnSysRes, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDevSlnSysRes, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDevSlnSysRes pSDevSlnSysRes, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDevSlnSysRes, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DB2PSDCDBINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DB2PSDCDBInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DB2PSDCDBINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DB2PSDCDBInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HBASEPSDCBDINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HBasePSDCBDInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HBASEPSDCBDINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HBasePSDCBDInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MSSQLPSDCDBINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MSSQLPSDCDBInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MSSQLPSDCDBINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MSSQLPSDCDBInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MYSQLPSDCDBINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MySQLPSDCDBInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MYSQLPSDCDBINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MySQLPSDCDBInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORAPSDCDBINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OraPSDCDBInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORAPSDCDBINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OraPSDCDBInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PGSQLPSDCDBINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PGSQLPSDCDBInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PGSQLPSDCDBINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PGSQLPSDCDBInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPASPSDCDBINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPASPSDCDBInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPASPSDCDBINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPASPSDCDBInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCDEPLOYSERVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCDeployServerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCDEPLOYSERVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCDeployServerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERASID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterASId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERASID2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterASId2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERASNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterASName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERASNAME2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterASName2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERSVNID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterSVNId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERSVNNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterSVNName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RESINFO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ResInfo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RESPOS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ResPos_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ROPSDEVCENTERSVNID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ROPSDevCenterSvnId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ROPSDEVCENTERSVNNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ROPSDevCenterSvnName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UDB2PSDCDBINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UDB2PSDCDBInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UDB2PSDCDBINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UDB2PSDCDBInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UHBASEPSDCBDINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UHBasePSDCBDInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UHBASEPSDCBDINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UHBasePSDCBDInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UMSSQLPSDCDBINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UMSSQLPSDCDBInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UMSSQLPSDCDBINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UMSSQLPSDCDBInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UMYSQLPSDCDBINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UMySQLPSDCDBInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UMYSQLPSDCDBINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UMySQLPSDCDBInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UORAPSDCDBINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UOraPSDCDBInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UORAPSDCDBINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UOraPSDCDBInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPGSQLPSDCDBINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UPGSQLPSDCDBInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPGSQLPSDCDBINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UPGSQLPSDCDBInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPPASPSDCDBINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UPPASPSDCDBInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPPASPSDCDBINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UPPASPSDCDBInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPSDEVCENTERASID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UPSDevCenterASId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPSDEVCENTERASID2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UPSDevCenterASId2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPSDEVCENTERASNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UPSDevCenterASName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPSDEVCENTERASNAME2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UPSDevCenterASName2_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
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

    protected String onTestValueRule_DB2PSDCDBInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DB2PSDCDBINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DB2PSDCDBInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DB2PSDCDBINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_HBasePSDCBDInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("HBASEPSDCBDINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_HBasePSDCBDInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("HBASEPSDCBDINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_MSSQLPSDCDBInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MSSQLPSDCDBINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MSSQLPSDCDBInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MSSQLPSDCDBINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MySQLPSDCDBInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MYSQLPSDCDBINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MySQLPSDCDBInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MYSQLPSDCDBINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OraPSDCDBInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ORAPSDCDBINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OraPSDCDBInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ORAPSDCDBINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PGSQLPSDCDBInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PGSQLPSDCDBINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PGSQLPSDCDBInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PGSQLPSDCDBINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPASPSDCDBInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPASPSDCDBINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPASPSDCDBInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPASPSDCDBINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCDeployServerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCDEPLOYSERVERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCDeployServerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCDEPLOYSERVERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevCenterASId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERASID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevCenterASId2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERASID2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevCenterASName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERASNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevCenterASName2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERASNAME2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevCenterSVNId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERSVNID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevCenterSVNName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERSVNNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNNAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnSysResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSRESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnSysResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSRESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ResInfo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RESINFO", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ResPos_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ROPSDevCenterSvnId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ROPSDEVCENTERSVNID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ROPSDevCenterSvnName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ROPSDEVCENTERSVNNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UDB2PSDCDBInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UDB2PSDCDBINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UDB2PSDCDBInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UDB2PSDCDBINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UHBasePSDCBDInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UHBASEPSDCBDINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UHBasePSDCBDInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UHBASEPSDCBDINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UMSSQLPSDCDBInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UMSSQLPSDCDBINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UMSSQLPSDCDBInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UMSSQLPSDCDBINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UMySQLPSDCDBInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UMYSQLPSDCDBINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UMySQLPSDCDBInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UMYSQLPSDCDBINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UOraPSDCDBInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UORAPSDCDBINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UOraPSDCDBInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UORAPSDCDBINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_UPGSQLPSDCDBInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UPGSQLPSDCDBINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UPGSQLPSDCDBInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UPGSQLPSDCDBINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UPPASPSDCDBInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UPPASPSDCDBINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UPPASPSDCDBInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UPPASPSDCDBINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UPSDevCenterASId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UPSDEVCENTERASID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UPSDevCenterASId2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UPSDEVCENTERASID2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UPSDevCenterASName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UPSDEVCENTERASNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UPSDevCenterASName2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UPSDEVCENTERASNAME2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected boolean onMergeChild(String string, String string2, PSDevSlnSysRes pSDevSlnSysRes) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDevSlnSysRes)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDevSlnSysRes pSDevSlnSysRes) throws Exception {
        super.onUpdateParent(pSDevSlnSysRes);
    }

    @Override
    protected void exportCurXmlModel(PSDevSlnSysRes pSDevSlnSysRes, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEVSLNSYSRES");
        if (!bl) {
            pSDevSlnSysRes.setCreateDate(null);
            pSDevSlnSysRes.setCreateMan(null);
            pSDevSlnSysRes.setPSDevSlnSysResId(null);
            pSDevSlnSysRes.setUpdateDate(null);
            pSDevSlnSysRes.setUpdateMan(null);
            super.exportCurXmlModel(pSDevSlnSysRes, xmlNode, bl);
        }
    }
}

