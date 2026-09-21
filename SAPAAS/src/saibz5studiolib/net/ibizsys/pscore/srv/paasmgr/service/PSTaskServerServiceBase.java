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
package net.ibizsys.pscore.srv.paasmgr.service;

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
import net.ibizsys.pscore.srv.devcenter.service.PSDCRobotService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCRobotServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterTSService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterTSServiceBase;
import net.ibizsys.pscore.srv.paasmgr.dao.PSTaskServerDAO;
import net.ibizsys.pscore.srv.paasmgr.demodel.PSTaskServerDEModel;
import net.ibizsys.pscore.srv.paasmgr.entity.PSCorePrd;
import net.ibizsys.pscore.srv.paasmgr.entity.PSCorePrdBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSCorePrdVer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSCorePrdVerBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSDeployCenter;
import net.ibizsys.pscore.srv.paasmgr.entity.PSDeployCenterBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSMobAppPackServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSMobAppPackServerBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSvrDomain;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSvrDomainBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSTaskServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSWorkshopServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSWorkshopServerBase;
import net.ibizsys.pscore.srv.paasmgr.service.PSAppServerService;
import net.ibizsys.pscore.srv.paasmgr.service.PSAppServerServiceBase;
import net.ibizsys.pscore.srv.paasmgr.service.PSRobotService;
import net.ibizsys.pscore.srv.paasmgr.service.PSRobotServiceBase;
import net.ibizsys.pscore.srv.paasmgr.service.PSTSCmdService;
import net.ibizsys.pscore.srv.paasmgr.service.PSTSCmdServiceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSTaskServerServiceBase
extends PSCoreSysServiceBase<PSTaskServer> {
    private static final Log log = LogFactory.getLog(PSTaskServerServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSTaskServerDEModel pSTaskServerDEModel;
    private PSTaskServerDAO pSTaskServerDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.paasmgr.service.PSTaskServerService";
    }

    public PSTaskServerDEModel getPSTaskServerDEModel() {
        if (this.pSTaskServerDEModel == null) {
            try {
                this.pSTaskServerDEModel = (PSTaskServerDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.paasmgr.demodel.PSTaskServerDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSTaskServerDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSTaskServerDEModel();
    }

    public PSTaskServerDAO getPSTaskServerDAO() {
        if (this.pSTaskServerDAO == null) {
            try {
                this.pSTaskServerDAO = (PSTaskServerDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.paasmgr.dao.PSTaskServerDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSTaskServerDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSTaskServerDAO();
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

    protected void onFillParentInfo(PSTaskServer pSTaskServer, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSTASKSERVER_PSCOREPRDVER_PSCOREPRDVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSCorePrdVerService", (SessionFactory)this.getSessionFactory());
            PSCorePrdVer pSCorePrdVer = (PSCorePrdVer)iService.getDEModel().createEntity();
            pSCorePrdVer.set("PSCOREPRDVERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSCorePrdVer);
            } else {
                iService.get((IEntity)pSCorePrdVer);
            }
            this.onFillParentInfo_PSCorePrdVer(pSTaskServer, pSCorePrdVer);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSTASKSERVER_PSCOREPRD_PSCOREPRDID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSCorePrdService", (SessionFactory)this.getSessionFactory());
            PSCorePrd pSCorePrd = (PSCorePrd)iService.getDEModel().createEntity();
            pSCorePrd.set("PSCOREPRDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSCorePrd);
            } else {
                iService.get((IEntity)pSCorePrd);
            }
            this.onFillParentInfo_PSCorePrd(pSTaskServer, pSCorePrd);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSTASKSERVER_PSDEPLOYCENTER_PSDEPLOYCENTERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSDeployCenterService", (SessionFactory)this.getSessionFactory());
            PSDeployCenter pSDeployCenter = (PSDeployCenter)iService.getDEModel().createEntity();
            pSDeployCenter.set("PSDEPLOYCENTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDeployCenter);
            } else {
                iService.get((IEntity)pSDeployCenter);
            }
            this.onFillParentInfo_PSDeployCenter(pSTaskServer, pSDeployCenter);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSTASKSERVER_PSMOBAPPPACKSERVER_NO2PSMOBAPPPSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSMobAppPackServerService", (SessionFactory)this.getSessionFactory());
            PSMobAppPackServer pSMobAppPackServer = (PSMobAppPackServer)iService.getDEModel().createEntity();
            pSMobAppPackServer.set("PSMOBAPPPACKSERVERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSMobAppPackServer);
            } else {
                iService.get((IEntity)pSMobAppPackServer);
            }
            this.onFillParentInfo_No2PSMobAppPS(pSTaskServer, pSMobAppPackServer);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSTASKSERVER_PSMOBAPPPACKSERVER_PSMOBAPPPACKSERVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSMobAppPackServerService", (SessionFactory)this.getSessionFactory());
            PSMobAppPackServer pSMobAppPackServer = (PSMobAppPackServer)iService.getDEModel().createEntity();
            pSMobAppPackServer.set("PSMOBAPPPACKSERVERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSMobAppPackServer);
            } else {
                iService.get((IEntity)pSMobAppPackServer);
            }
            this.onFillParentInfo_PSMobAppPackServer(pSTaskServer, pSMobAppPackServer);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSTASKSERVER_PSSVRDOMAIN_PSSVRDOMAINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSSvrDomainService", (SessionFactory)this.getSessionFactory());
            PSSvrDomain pSSvrDomain = (PSSvrDomain)iService.getDEModel().createEntity();
            pSSvrDomain.set("PSSVRDOMAINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSvrDomain);
            } else {
                iService.get((IEntity)pSSvrDomain);
            }
            this.onFillParentInfo_PSSvrDomain(pSTaskServer, pSSvrDomain);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSTASKSERVER_PSWORKSHOPSERVER_PSWORKSHOPSERVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSWorkshopServerService", (SessionFactory)this.getSessionFactory());
            PSWorkshopServer pSWorkshopServer = (PSWorkshopServer)iService.getDEModel().createEntity();
            pSWorkshopServer.set("PSWORKSHOPSERVERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSWorkshopServer);
            } else {
                iService.get((IEntity)pSWorkshopServer);
            }
            this.onFillParentInfo_PSWorkshopServer(pSTaskServer, pSWorkshopServer);
            return;
        }
        super.onFillParentInfo((IEntity)pSTaskServer, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSCorePrdVer(PSTaskServer pSTaskServer, PSCorePrdVer pSCorePrdVer) throws Exception {
        pSTaskServer.setPSCorePrdVerId(pSCorePrdVer.getPSCorePrdVerId());
        pSTaskServer.setPSCorePrdVerName(pSCorePrdVer.getPSCorePrdVerName());
    }

    protected void onFillParentInfo_PSCorePrd(PSTaskServer pSTaskServer, PSCorePrd pSCorePrd) throws Exception {
        pSTaskServer.setPSCorePrdId(pSCorePrd.getPSCorePrdId());
        pSTaskServer.setPSCorePrdName(pSCorePrd.getPSCorePrdName());
    }

    protected void onFillParentInfo_PSDeployCenter(PSTaskServer pSTaskServer, PSDeployCenter pSDeployCenter) throws Exception {
        pSTaskServer.setPSDeployCenterId(pSDeployCenter.getPSDeployCenterId());
        pSTaskServer.setPSDeployCenterName(pSDeployCenter.getPSDeployCenterName());
    }

    protected void onFillParentInfo_No2PSMobAppPS(PSTaskServer pSTaskServer, PSMobAppPackServer pSMobAppPackServer) throws Exception {
        pSTaskServer.setNo2PSMobAppPSId(pSMobAppPackServer.getPSMobAppPackServerId());
        pSTaskServer.setNo2PSMobAppPSName(pSMobAppPackServer.getPSMobAppPackServerName());
    }

    protected void onFillParentInfo_PSMobAppPackServer(PSTaskServer pSTaskServer, PSMobAppPackServer pSMobAppPackServer) throws Exception {
        pSTaskServer.setPSMobAppPackServerId(pSMobAppPackServer.getPSMobAppPackServerId());
        pSTaskServer.setPSMobAppPackServerName(pSMobAppPackServer.getPSMobAppPackServerName());
    }

    protected void onFillParentInfo_PSSvrDomain(PSTaskServer pSTaskServer, PSSvrDomain pSSvrDomain) throws Exception {
        pSTaskServer.setDomainParams(pSSvrDomain.getDomainParams());
        pSTaskServer.setPSSvrDomainId(pSSvrDomain.getPSSvrDomainId());
        pSTaskServer.setPSSvrDomainName(pSSvrDomain.getPSSvrDomainName());
    }

    protected void onFillParentInfo_PSWorkshopServer(PSTaskServer pSTaskServer, PSWorkshopServer pSWorkshopServer) throws Exception {
        pSTaskServer.setPSWorkshopServerId(pSWorkshopServer.getPSWorkshopServerId());
        pSTaskServer.setPSWorkshopServerName(pSWorkshopServer.getPSWorkshopServerName());
    }

    protected void onFillEntityFullInfo(PSTaskServer pSTaskServer, boolean bl) throws Exception {
        if (bl && pSTaskServer.getValidFlag() == null) {
            pSTaskServer.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo((IEntity)pSTaskServer, bl);
        this.onFillEntityFullInfo_PSCorePrdVer(pSTaskServer, bl);
        this.onFillEntityFullInfo_PSCorePrd(pSTaskServer, bl);
        this.onFillEntityFullInfo_PSDeployCenter(pSTaskServer, bl);
        this.onFillEntityFullInfo_No2PSMobAppPS(pSTaskServer, bl);
        this.onFillEntityFullInfo_PSMobAppPackServer(pSTaskServer, bl);
        this.onFillEntityFullInfo_PSSvrDomain(pSTaskServer, bl);
        this.onFillEntityFullInfo_PSWorkshopServer(pSTaskServer, bl);
    }

    protected void onFillEntityFullInfo_PSCorePrdVer(PSTaskServer pSTaskServer, boolean bl) throws Exception {
        if (pSTaskServer.isPSCorePrdVerIdDirty()) {
            if (pSTaskServer.getPSCorePrdVerId() != null) {
                if (pSTaskServer.getPSCorePrdVerId() == null || pSTaskServer.getPSCorePrdVerName() == null) {
                    PSCorePrdVer pSCorePrdVer = pSTaskServer.getPSCorePrdVer();
                    pSTaskServer.setPSCorePrdVerName(pSCorePrdVer.getPSCorePrdVerName());
                }
            } else {
                pSTaskServer.setPSCorePrdVerName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSCorePrd(PSTaskServer pSTaskServer, boolean bl) throws Exception {
        if (pSTaskServer.isPSCorePrdIdDirty()) {
            if (pSTaskServer.getPSCorePrdId() != null) {
                if (pSTaskServer.getPSCorePrdId() == null || pSTaskServer.getPSCorePrdName() == null) {
                    PSCorePrd pSCorePrd = pSTaskServer.getPSCorePrd();
                    pSTaskServer.setPSCorePrdName(pSCorePrd.getPSCorePrdName());
                }
            } else {
                pSTaskServer.setPSCorePrdName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDeployCenter(PSTaskServer pSTaskServer, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_No2PSMobAppPS(PSTaskServer pSTaskServer, boolean bl) throws Exception {
        if (pSTaskServer.isNo2PSMobAppPSIdDirty()) {
            if (pSTaskServer.getNo2PSMobAppPSId() != null) {
                if (pSTaskServer.getNo2PSMobAppPSId() == null || pSTaskServer.getNo2PSMobAppPSName() == null) {
                    PSMobAppPackServer pSMobAppPackServer = pSTaskServer.getNo2PSMobAppPS();
                    pSTaskServer.setNo2PSMobAppPSName(pSMobAppPackServer.getPSMobAppPackServerName());
                }
            } else {
                pSTaskServer.setNo2PSMobAppPSName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSMobAppPackServer(PSTaskServer pSTaskServer, boolean bl) throws Exception {
        if (pSTaskServer.isPSMobAppPackServerIdDirty()) {
            if (pSTaskServer.getPSMobAppPackServerId() != null) {
                if (pSTaskServer.getPSMobAppPackServerId() == null || pSTaskServer.getPSMobAppPackServerName() == null) {
                    PSMobAppPackServer pSMobAppPackServer = pSTaskServer.getPSMobAppPackServer();
                    pSTaskServer.setPSMobAppPackServerName(pSMobAppPackServer.getPSMobAppPackServerName());
                }
            } else {
                pSTaskServer.setPSMobAppPackServerName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSvrDomain(PSTaskServer pSTaskServer, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSWorkshopServer(PSTaskServer pSTaskServer, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSTaskServer pSTaskServer, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSTaskServer, bl);
    }

    public ArrayList<PSTaskServer> selectByPSCorePrdVer(PSCorePrdVerBase pSCorePrdVerBase) throws Exception {
        return this.selectByPSCorePrdVer(pSCorePrdVerBase, "", -1);
    }

    public ArrayList<PSTaskServer> selectByPSCorePrdVer(PSCorePrdVerBase pSCorePrdVerBase, String string) throws Exception {
        return this.selectByPSCorePrdVer(pSCorePrdVerBase, string, -1);
    }

    public ArrayList<PSTaskServer> selectByPSCorePrdVer(PSCorePrdVerBase pSCorePrdVerBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSCOREPRDVERID", (Object)pSCorePrdVerBase.getPSCorePrdVerId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSCorePrdVerCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSCorePrdVerCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSTaskServer> selectByPSCorePrd(PSCorePrdBase pSCorePrdBase) throws Exception {
        return this.selectByPSCorePrd(pSCorePrdBase, "", -1);
    }

    public ArrayList<PSTaskServer> selectByPSCorePrd(PSCorePrdBase pSCorePrdBase, String string) throws Exception {
        return this.selectByPSCorePrd(pSCorePrdBase, string, -1);
    }

    public ArrayList<PSTaskServer> selectByPSCorePrd(PSCorePrdBase pSCorePrdBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSCOREPRDID", (Object)pSCorePrdBase.getPSCorePrdId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSCorePrdCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSCorePrdCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSTaskServer> selectByPSDeployCenter(PSDeployCenterBase pSDeployCenterBase) throws Exception {
        return this.selectByPSDeployCenter(pSDeployCenterBase, "", -1);
    }

    public ArrayList<PSTaskServer> selectByPSDeployCenter(PSDeployCenterBase pSDeployCenterBase, String string) throws Exception {
        return this.selectByPSDeployCenter(pSDeployCenterBase, string, -1);
    }

    public ArrayList<PSTaskServer> selectByPSDeployCenter(PSDeployCenterBase pSDeployCenterBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEPLOYCENTERID", (Object)pSDeployCenterBase.getPSDeployCenterId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDeployCenterCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDeployCenterCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSTaskServer> selectByNo2PSMobAppPS(PSMobAppPackServerBase pSMobAppPackServerBase) throws Exception {
        return this.selectByNo2PSMobAppPS(pSMobAppPackServerBase, "", -1);
    }

    public ArrayList<PSTaskServer> selectByNo2PSMobAppPS(PSMobAppPackServerBase pSMobAppPackServerBase, String string) throws Exception {
        return this.selectByNo2PSMobAppPS(pSMobAppPackServerBase, string, -1);
    }

    public ArrayList<PSTaskServer> selectByNo2PSMobAppPS(PSMobAppPackServerBase pSMobAppPackServerBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("NO2PSMOBAPPPSID", (Object)pSMobAppPackServerBase.getPSMobAppPackServerId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByNo2PSMobAppPSCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByNo2PSMobAppPSCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSTaskServer> selectByPSMobAppPackServer(PSMobAppPackServerBase pSMobAppPackServerBase) throws Exception {
        return this.selectByPSMobAppPackServer(pSMobAppPackServerBase, "", -1);
    }

    public ArrayList<PSTaskServer> selectByPSMobAppPackServer(PSMobAppPackServerBase pSMobAppPackServerBase, String string) throws Exception {
        return this.selectByPSMobAppPackServer(pSMobAppPackServerBase, string, -1);
    }

    public ArrayList<PSTaskServer> selectByPSMobAppPackServer(PSMobAppPackServerBase pSMobAppPackServerBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSMOBAPPPACKSERVERID", (Object)pSMobAppPackServerBase.getPSMobAppPackServerId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSMobAppPackServerCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSMobAppPackServerCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSTaskServer> selectByPSSvrDomain(PSSvrDomainBase pSSvrDomainBase) throws Exception {
        return this.selectByPSSvrDomain(pSSvrDomainBase, "", -1);
    }

    public ArrayList<PSTaskServer> selectByPSSvrDomain(PSSvrDomainBase pSSvrDomainBase, String string) throws Exception {
        return this.selectByPSSvrDomain(pSSvrDomainBase, string, -1);
    }

    public ArrayList<PSTaskServer> selectByPSSvrDomain(PSSvrDomainBase pSSvrDomainBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSVRDOMAINID", (Object)pSSvrDomainBase.getPSSvrDomainId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSvrDomainCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSvrDomainCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSTaskServer> selectByPSWorkshopServer(PSWorkshopServerBase pSWorkshopServerBase) throws Exception {
        return this.selectByPSWorkshopServer(pSWorkshopServerBase, "", -1);
    }

    public ArrayList<PSTaskServer> selectByPSWorkshopServer(PSWorkshopServerBase pSWorkshopServerBase, String string) throws Exception {
        return this.selectByPSWorkshopServer(pSWorkshopServerBase, string, -1);
    }

    public ArrayList<PSTaskServer> selectByPSWorkshopServer(PSWorkshopServerBase pSWorkshopServerBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSWORKSHOPSERVERID", (Object)pSWorkshopServerBase.getPSWorkshopServerId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSWorkshopServerCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSWorkshopServerCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSCorePrdVer(PSCorePrdVer pSCorePrdVer) throws Exception {
    }

    public void resetPSCorePrdVer(PSCorePrdVer pSCorePrdVer) throws Exception {
        ArrayList<PSTaskServer> arrayList = this.selectByPSCorePrdVer(pSCorePrdVer);
        for (PSTaskServer pSTaskServer : arrayList) {
            PSTaskServer pSTaskServer2 = (PSTaskServer)this.getDEModel().createEntity();
            pSTaskServer2.setPSTaskServerId(pSTaskServer.getPSTaskServerId());
            pSTaskServer2.setPSCorePrdVerId(null);
            this.update(pSTaskServer2);
        }
    }

    public void removeByPSCorePrdVer(PSCorePrdVer pSCorePrdVer) throws Exception {
        final PSCorePrdVer pSCorePrdVer2 = pSCorePrdVer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSTaskServerServiceBase.this.onBeforeRemoveByPSCorePrdVer(pSCorePrdVer2);
                PSTaskServerServiceBase.this.internalRemoveByPSCorePrdVer(pSCorePrdVer2);
                PSTaskServerServiceBase.this.onAfterRemoveByPSCorePrdVer(pSCorePrdVer2);
            }
        });
    }

    protected void onBeforeRemoveByPSCorePrdVer(PSCorePrdVer pSCorePrdVer) throws Exception {
    }

    protected void internalRemoveByPSCorePrdVer(PSCorePrdVer pSCorePrdVer) throws Exception {
        ArrayList<PSTaskServer> arrayList = this.selectByPSCorePrdVer(pSCorePrdVer);
        this.onBeforeRemoveByPSCorePrdVer(pSCorePrdVer, arrayList);
        for (PSTaskServer pSTaskServer : arrayList) {
            this.remove((IEntity)pSTaskServer);
        }
        this.onAfterRemoveByPSCorePrdVer(pSCorePrdVer, arrayList);
    }

    protected void onAfterRemoveByPSCorePrdVer(PSCorePrdVer pSCorePrdVer) throws Exception {
    }

    protected void onBeforeRemoveByPSCorePrdVer(PSCorePrdVer pSCorePrdVer, ArrayList<PSTaskServer> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSCorePrdVer(PSCorePrdVer pSCorePrdVer, ArrayList<PSTaskServer> arrayList) throws Exception {
    }

    public void testRemoveByPSCorePrd(PSCorePrd pSCorePrd) throws Exception {
    }

    public void resetPSCorePrd(PSCorePrd pSCorePrd) throws Exception {
        ArrayList<PSTaskServer> arrayList = this.selectByPSCorePrd(pSCorePrd);
        for (PSTaskServer pSTaskServer : arrayList) {
            PSTaskServer pSTaskServer2 = (PSTaskServer)this.getDEModel().createEntity();
            pSTaskServer2.setPSTaskServerId(pSTaskServer.getPSTaskServerId());
            pSTaskServer2.setPSCorePrdId(null);
            this.update(pSTaskServer2);
        }
    }

    public void removeByPSCorePrd(PSCorePrd pSCorePrd) throws Exception {
        final PSCorePrd pSCorePrd2 = pSCorePrd;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSTaskServerServiceBase.this.onBeforeRemoveByPSCorePrd(pSCorePrd2);
                PSTaskServerServiceBase.this.internalRemoveByPSCorePrd(pSCorePrd2);
                PSTaskServerServiceBase.this.onAfterRemoveByPSCorePrd(pSCorePrd2);
            }
        });
    }

    protected void onBeforeRemoveByPSCorePrd(PSCorePrd pSCorePrd) throws Exception {
    }

    protected void internalRemoveByPSCorePrd(PSCorePrd pSCorePrd) throws Exception {
        ArrayList<PSTaskServer> arrayList = this.selectByPSCorePrd(pSCorePrd);
        this.onBeforeRemoveByPSCorePrd(pSCorePrd, arrayList);
        for (PSTaskServer pSTaskServer : arrayList) {
            this.remove((IEntity)pSTaskServer);
        }
        this.onAfterRemoveByPSCorePrd(pSCorePrd, arrayList);
    }

    protected void onAfterRemoveByPSCorePrd(PSCorePrd pSCorePrd) throws Exception {
    }

    protected void onBeforeRemoveByPSCorePrd(PSCorePrd pSCorePrd, ArrayList<PSTaskServer> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSCorePrd(PSCorePrd pSCorePrd, ArrayList<PSTaskServer> arrayList) throws Exception {
    }

    public void testRemoveByPSDeployCenter(PSDeployCenter pSDeployCenter) throws Exception {
        ArrayList<PSTaskServer> arrayList = this.selectByPSDeployCenter(pSDeployCenter, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEPLOYCENTER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDeployCenter);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSTASKSERVER_PSDEPLOYCENTER_PSDEPLOYCENTERID", "", iDataEntityModel.getName(), "PSTASKSERVER", iDataEntityModel.getDataInfo((IEntity)pSDeployCenter), arrayList.get(0)));
        }
    }

    public void resetPSDeployCenter(PSDeployCenter pSDeployCenter) throws Exception {
        ArrayList<PSTaskServer> arrayList = this.selectByPSDeployCenter(pSDeployCenter);
        for (PSTaskServer pSTaskServer : arrayList) {
            PSTaskServer pSTaskServer2 = (PSTaskServer)this.getDEModel().createEntity();
            pSTaskServer2.setPSTaskServerId(pSTaskServer.getPSTaskServerId());
            pSTaskServer2.setPSDeployCenterId(null);
            this.update(pSTaskServer2);
        }
    }

    public void removeByPSDeployCenter(PSDeployCenter pSDeployCenter) throws Exception {
        final PSDeployCenter pSDeployCenter2 = pSDeployCenter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSTaskServerServiceBase.this.onBeforeRemoveByPSDeployCenter(pSDeployCenter2);
                PSTaskServerServiceBase.this.internalRemoveByPSDeployCenter(pSDeployCenter2);
                PSTaskServerServiceBase.this.onAfterRemoveByPSDeployCenter(pSDeployCenter2);
            }
        });
    }

    protected void onBeforeRemoveByPSDeployCenter(PSDeployCenter pSDeployCenter) throws Exception {
    }

    protected void internalRemoveByPSDeployCenter(PSDeployCenter pSDeployCenter) throws Exception {
        ArrayList<PSTaskServer> arrayList = this.selectByPSDeployCenter(pSDeployCenter);
        this.onBeforeRemoveByPSDeployCenter(pSDeployCenter, arrayList);
        for (PSTaskServer pSTaskServer : arrayList) {
            this.remove((IEntity)pSTaskServer);
        }
        this.onAfterRemoveByPSDeployCenter(pSDeployCenter, arrayList);
    }

    protected void onAfterRemoveByPSDeployCenter(PSDeployCenter pSDeployCenter) throws Exception {
    }

    protected void onBeforeRemoveByPSDeployCenter(PSDeployCenter pSDeployCenter, ArrayList<PSTaskServer> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDeployCenter(PSDeployCenter pSDeployCenter, ArrayList<PSTaskServer> arrayList) throws Exception {
    }

    public void testRemoveByNo2PSMobAppPS(PSMobAppPackServer pSMobAppPackServer) throws Exception {
    }

    public void resetNo2PSMobAppPS(PSMobAppPackServer pSMobAppPackServer) throws Exception {
        ArrayList<PSTaskServer> arrayList = this.selectByNo2PSMobAppPS(pSMobAppPackServer);
        for (PSTaskServer pSTaskServer : arrayList) {
            PSTaskServer pSTaskServer2 = (PSTaskServer)this.getDEModel().createEntity();
            pSTaskServer2.setPSTaskServerId(pSTaskServer.getPSTaskServerId());
            pSTaskServer2.setNo2PSMobAppPSId(null);
            this.update(pSTaskServer2);
        }
    }

    public void removeByNo2PSMobAppPS(PSMobAppPackServer pSMobAppPackServer) throws Exception {
        final PSMobAppPackServer pSMobAppPackServer2 = pSMobAppPackServer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSTaskServerServiceBase.this.onBeforeRemoveByNo2PSMobAppPS(pSMobAppPackServer2);
                PSTaskServerServiceBase.this.internalRemoveByNo2PSMobAppPS(pSMobAppPackServer2);
                PSTaskServerServiceBase.this.onAfterRemoveByNo2PSMobAppPS(pSMobAppPackServer2);
            }
        });
    }

    protected void onBeforeRemoveByNo2PSMobAppPS(PSMobAppPackServer pSMobAppPackServer) throws Exception {
    }

    protected void internalRemoveByNo2PSMobAppPS(PSMobAppPackServer pSMobAppPackServer) throws Exception {
        ArrayList<PSTaskServer> arrayList = this.selectByNo2PSMobAppPS(pSMobAppPackServer);
        this.onBeforeRemoveByNo2PSMobAppPS(pSMobAppPackServer, arrayList);
        for (PSTaskServer pSTaskServer : arrayList) {
            this.remove((IEntity)pSTaskServer);
        }
        this.onAfterRemoveByNo2PSMobAppPS(pSMobAppPackServer, arrayList);
    }

    protected void onAfterRemoveByNo2PSMobAppPS(PSMobAppPackServer pSMobAppPackServer) throws Exception {
    }

    protected void onBeforeRemoveByNo2PSMobAppPS(PSMobAppPackServer pSMobAppPackServer, ArrayList<PSTaskServer> arrayList) throws Exception {
    }

    protected void onAfterRemoveByNo2PSMobAppPS(PSMobAppPackServer pSMobAppPackServer, ArrayList<PSTaskServer> arrayList) throws Exception {
    }

    public void testRemoveByPSMobAppPackServer(PSMobAppPackServer pSMobAppPackServer) throws Exception {
    }

    public void resetPSMobAppPackServer(PSMobAppPackServer pSMobAppPackServer) throws Exception {
        ArrayList<PSTaskServer> arrayList = this.selectByPSMobAppPackServer(pSMobAppPackServer);
        for (PSTaskServer pSTaskServer : arrayList) {
            PSTaskServer pSTaskServer2 = (PSTaskServer)this.getDEModel().createEntity();
            pSTaskServer2.setPSTaskServerId(pSTaskServer.getPSTaskServerId());
            pSTaskServer2.setPSMobAppPackServerId(null);
            this.update(pSTaskServer2);
        }
    }

    public void removeByPSMobAppPackServer(PSMobAppPackServer pSMobAppPackServer) throws Exception {
        final PSMobAppPackServer pSMobAppPackServer2 = pSMobAppPackServer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSTaskServerServiceBase.this.onBeforeRemoveByPSMobAppPackServer(pSMobAppPackServer2);
                PSTaskServerServiceBase.this.internalRemoveByPSMobAppPackServer(pSMobAppPackServer2);
                PSTaskServerServiceBase.this.onAfterRemoveByPSMobAppPackServer(pSMobAppPackServer2);
            }
        });
    }

    protected void onBeforeRemoveByPSMobAppPackServer(PSMobAppPackServer pSMobAppPackServer) throws Exception {
    }

    protected void internalRemoveByPSMobAppPackServer(PSMobAppPackServer pSMobAppPackServer) throws Exception {
        ArrayList<PSTaskServer> arrayList = this.selectByPSMobAppPackServer(pSMobAppPackServer);
        this.onBeforeRemoveByPSMobAppPackServer(pSMobAppPackServer, arrayList);
        for (PSTaskServer pSTaskServer : arrayList) {
            this.remove((IEntity)pSTaskServer);
        }
        this.onAfterRemoveByPSMobAppPackServer(pSMobAppPackServer, arrayList);
    }

    protected void onAfterRemoveByPSMobAppPackServer(PSMobAppPackServer pSMobAppPackServer) throws Exception {
    }

    protected void onBeforeRemoveByPSMobAppPackServer(PSMobAppPackServer pSMobAppPackServer, ArrayList<PSTaskServer> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSMobAppPackServer(PSMobAppPackServer pSMobAppPackServer, ArrayList<PSTaskServer> arrayList) throws Exception {
    }

    public void testRemoveByPSSvrDomain(PSSvrDomain pSSvrDomain) throws Exception {
        ArrayList<PSTaskServer> arrayList = this.selectByPSSvrDomain(pSSvrDomain, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSVRDOMAIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSvrDomain);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSTASKSERVER_PSSVRDOMAIN_PSSVRDOMAINID", "", iDataEntityModel.getName(), "PSTASKSERVER", iDataEntityModel.getDataInfo((IEntity)pSSvrDomain), arrayList.get(0)));
        }
    }

    public void resetPSSvrDomain(PSSvrDomain pSSvrDomain) throws Exception {
        ArrayList<PSTaskServer> arrayList = this.selectByPSSvrDomain(pSSvrDomain);
        for (PSTaskServer pSTaskServer : arrayList) {
            PSTaskServer pSTaskServer2 = (PSTaskServer)this.getDEModel().createEntity();
            pSTaskServer2.setPSTaskServerId(pSTaskServer.getPSTaskServerId());
            pSTaskServer2.setPSSvrDomainId(null);
            this.update(pSTaskServer2);
        }
    }

    public void removeByPSSvrDomain(PSSvrDomain pSSvrDomain) throws Exception {
        final PSSvrDomain pSSvrDomain2 = pSSvrDomain;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSTaskServerServiceBase.this.onBeforeRemoveByPSSvrDomain(pSSvrDomain2);
                PSTaskServerServiceBase.this.internalRemoveByPSSvrDomain(pSSvrDomain2);
                PSTaskServerServiceBase.this.onAfterRemoveByPSSvrDomain(pSSvrDomain2);
            }
        });
    }

    protected void onBeforeRemoveByPSSvrDomain(PSSvrDomain pSSvrDomain) throws Exception {
    }

    protected void internalRemoveByPSSvrDomain(PSSvrDomain pSSvrDomain) throws Exception {
        ArrayList<PSTaskServer> arrayList = this.selectByPSSvrDomain(pSSvrDomain);
        this.onBeforeRemoveByPSSvrDomain(pSSvrDomain, arrayList);
        for (PSTaskServer pSTaskServer : arrayList) {
            this.remove((IEntity)pSTaskServer);
        }
        this.onAfterRemoveByPSSvrDomain(pSSvrDomain, arrayList);
    }

    protected void onAfterRemoveByPSSvrDomain(PSSvrDomain pSSvrDomain) throws Exception {
    }

    protected void onBeforeRemoveByPSSvrDomain(PSSvrDomain pSSvrDomain, ArrayList<PSTaskServer> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSvrDomain(PSSvrDomain pSSvrDomain, ArrayList<PSTaskServer> arrayList) throws Exception {
    }

    public void testRemoveByPSWorkshopServer(PSWorkshopServer pSWorkshopServer) throws Exception {
        ArrayList<PSTaskServer> arrayList = this.selectByPSWorkshopServer(pSWorkshopServer, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSWORKSHOPSERVER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSWorkshopServer);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSTASKSERVER_PSWORKSHOPSERVER_PSWORKSHOPSERVERID", "", iDataEntityModel.getName(), "PSTASKSERVER", iDataEntityModel.getDataInfo((IEntity)pSWorkshopServer), arrayList.get(0)));
        }
    }

    public void resetPSWorkshopServer(PSWorkshopServer pSWorkshopServer) throws Exception {
        ArrayList<PSTaskServer> arrayList = this.selectByPSWorkshopServer(pSWorkshopServer);
        for (PSTaskServer pSTaskServer : arrayList) {
            PSTaskServer pSTaskServer2 = (PSTaskServer)this.getDEModel().createEntity();
            pSTaskServer2.setPSTaskServerId(pSTaskServer.getPSTaskServerId());
            pSTaskServer2.setPSWorkshopServerId(null);
            this.update(pSTaskServer2);
        }
    }

    public void removeByPSWorkshopServer(PSWorkshopServer pSWorkshopServer) throws Exception {
        final PSWorkshopServer pSWorkshopServer2 = pSWorkshopServer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSTaskServerServiceBase.this.onBeforeRemoveByPSWorkshopServer(pSWorkshopServer2);
                PSTaskServerServiceBase.this.internalRemoveByPSWorkshopServer(pSWorkshopServer2);
                PSTaskServerServiceBase.this.onAfterRemoveByPSWorkshopServer(pSWorkshopServer2);
            }
        });
    }

    protected void onBeforeRemoveByPSWorkshopServer(PSWorkshopServer pSWorkshopServer) throws Exception {
    }

    protected void internalRemoveByPSWorkshopServer(PSWorkshopServer pSWorkshopServer) throws Exception {
        ArrayList<PSTaskServer> arrayList = this.selectByPSWorkshopServer(pSWorkshopServer);
        this.onBeforeRemoveByPSWorkshopServer(pSWorkshopServer, arrayList);
        for (PSTaskServer pSTaskServer : arrayList) {
            this.remove((IEntity)pSTaskServer);
        }
        this.onAfterRemoveByPSWorkshopServer(pSWorkshopServer, arrayList);
    }

    protected void onAfterRemoveByPSWorkshopServer(PSWorkshopServer pSWorkshopServer) throws Exception {
    }

    protected void onBeforeRemoveByPSWorkshopServer(PSWorkshopServer pSWorkshopServer, ArrayList<PSTaskServer> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSWorkshopServer(PSWorkshopServer pSWorkshopServer, ArrayList<PSTaskServer> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSTaskServer pSTaskServer) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSAppServerService)ServiceGlobal.getService(PSAppServerService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppServerServiceBase)pSCoreSysServiceBase).testRemoveByPSTaskServer(pSTaskServer);
        pSCoreSysServiceBase = (PSDCRobotService)ServiceGlobal.getService(PSDCRobotService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCRobotServiceBase)pSCoreSysServiceBase).testRemoveByPSTaskServer(pSTaskServer);
        pSCoreSysServiceBase = (PSDevCenterTSService)ServiceGlobal.getService(PSDevCenterTSService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevCenterTSServiceBase)pSCoreSysServiceBase).testRemoveByJITPSTaskServer(pSTaskServer);
        pSCoreSysServiceBase = (PSDevCenterTSService)ServiceGlobal.getService(PSDevCenterTSService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevCenterTSServiceBase)pSCoreSysServiceBase).testRemoveByPSTaskServer(pSTaskServer);
        pSCoreSysServiceBase = (PSRobotService)ServiceGlobal.getService(PSRobotService.class, (SessionFactory)this.getSessionFactory());
        ((PSRobotServiceBase)pSCoreSysServiceBase).testRemoveByPSTaskServer(pSTaskServer);
        pSCoreSysServiceBase = (PSTSCmdService)ServiceGlobal.getService(PSTSCmdService.class, (SessionFactory)this.getSessionFactory());
        ((PSTSCmdServiceBase)pSCoreSysServiceBase).testRemoveByPSTaskServer(pSTaskServer);
        ((PSTSCmdServiceBase)pSCoreSysServiceBase).removeByPSTaskServer(pSTaskServer);
        super.onBeforeRemove(pSTaskServer);
    }

    protected void replaceParentInfo(PSTaskServer pSTaskServer, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSTaskServer, cloneSession);
        if (pSTaskServer.getPSCorePrdVerId() != null && (iEntity = cloneSession.getEntity("PSCOREPRDVER", (Object)pSTaskServer.getPSCorePrdVerId())) != null) {
            this.onFillParentInfo_PSCorePrdVer(pSTaskServer, (PSCorePrdVer)iEntity);
        }
        if (pSTaskServer.getPSCorePrdId() != null && (iEntity = cloneSession.getEntity("PSCOREPRD", (Object)pSTaskServer.getPSCorePrdId())) != null) {
            this.onFillParentInfo_PSCorePrd(pSTaskServer, (PSCorePrd)iEntity);
        }
        if (pSTaskServer.getPSDeployCenterId() != null && (iEntity = cloneSession.getEntity("PSDEPLOYCENTER", (Object)pSTaskServer.getPSDeployCenterId())) != null) {
            this.onFillParentInfo_PSDeployCenter(pSTaskServer, (PSDeployCenter)iEntity);
        }
        if (pSTaskServer.getNo2PSMobAppPSId() != null && (iEntity = cloneSession.getEntity("PSMOBAPPPACKSERVER", (Object)pSTaskServer.getNo2PSMobAppPSId())) != null) {
            this.onFillParentInfo_No2PSMobAppPS(pSTaskServer, (PSMobAppPackServer)iEntity);
        }
        if (pSTaskServer.getPSMobAppPackServerId() != null && (iEntity = cloneSession.getEntity("PSMOBAPPPACKSERVER", (Object)pSTaskServer.getPSMobAppPackServerId())) != null) {
            this.onFillParentInfo_PSMobAppPackServer(pSTaskServer, (PSMobAppPackServer)iEntity);
        }
        if (pSTaskServer.getPSSvrDomainId() != null && (iEntity = cloneSession.getEntity("PSSVRDOMAIN", (Object)pSTaskServer.getPSSvrDomainId())) != null) {
            this.onFillParentInfo_PSSvrDomain(pSTaskServer, (PSSvrDomain)iEntity);
        }
        if (pSTaskServer.getPSWorkshopServerId() != null && (iEntity = cloneSession.getEntity("PSWORKSHOPSERVER", (Object)pSTaskServer.getPSWorkshopServerId())) != null) {
            this.onFillParentInfo_PSWorkshopServer(pSTaskServer, (PSWorkshopServer)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSTaskServer pSTaskServer, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSTaskServer, bl);
    }

    protected void onCheckEntity(boolean bl, PSTaskServer pSTaskServer, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_DevSysDeployMode(bl, pSTaskServer, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IpAddr(bl, pSTaskServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IpAddr2(bl, pSTaskServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LicInfo(bl, pSTaskServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LicKey(bl, pSTaskServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSTaskServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_No2PSMobAppPSId(bl, pSTaskServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_No2PSMobAppPSName(bl, pSTaskServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCorePrdId(bl, pSTaskServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCorePrdName(bl, pSTaskServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCorePrdVerId(bl, pSTaskServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCorePrdVerName(bl, pSTaskServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDeployCenterId(bl, pSTaskServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSMobAppPackServerId(bl, pSTaskServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSMobAppPackServerName(bl, pSTaskServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSvrDomainId(bl, pSTaskServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSTaskServerId(bl, pSTaskServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSTaskServerName(bl, pSTaskServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWorkshopServerId(bl, pSTaskServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefInfo(bl, pSTaskServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ServerUrl(bl, pSTaskServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ServerUrl2(bl, pSTaskServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ServerUsage(bl, pSTaskServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SysVer(bl, pSTaskServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TSParams(bl, pSTaskServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSTaskServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSTaskServer, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_DevSysDeployMode(boolean bl, PSTaskServer pSTaskServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSTaskServer.isDevSysDeployModeDirty() : !pSTaskServer.isDevSysDeployModeDirty()) {
            return null;
        }
        Integer n = pSTaskServer.getDevSysDeployMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DevSysDeployMode_Default((IEntity)pSTaskServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEVSYSDEPLOYMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IpAddr(boolean bl, PSTaskServer pSTaskServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSTaskServer.isIpAddrDirty() : !pSTaskServer.isIpAddrDirty()) {
            return null;
        }
        String string = pSTaskServer.getIpAddr();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_IpAddr_Default((IEntity)pSTaskServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("IPADDR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IpAddr2(boolean bl, PSTaskServer pSTaskServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSTaskServer.isIpAddr2Dirty() : !pSTaskServer.isIpAddr2Dirty()) {
            return null;
        }
        String string = pSTaskServer.getIpAddr2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_IpAddr2_Default((IEntity)pSTaskServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("IPADDR2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LicInfo(boolean bl, PSTaskServer pSTaskServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSTaskServer.isLicInfoDirty() : !pSTaskServer.isLicInfoDirty()) {
            return null;
        }
        String string = pSTaskServer.getLicInfo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LicInfo_Default((IEntity)pSTaskServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LICINFO");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LicKey(boolean bl, PSTaskServer pSTaskServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSTaskServer.isLicKeyDirty() : !pSTaskServer.isLicKeyDirty()) {
            return null;
        }
        String string = pSTaskServer.getLicKey();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LicKey_Default((IEntity)pSTaskServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LICKEY");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSTaskServer pSTaskServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSTaskServer.isMemoDirty() : !pSTaskServer.isMemoDirty()) {
            return null;
        }
        String string = pSTaskServer.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSTaskServer, bl2, bl3);
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

    protected EntityFieldError onCheckField_No2PSMobAppPSId(boolean bl, PSTaskServer pSTaskServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSTaskServer.isNo2PSMobAppPSIdDirty() : !pSTaskServer.isNo2PSMobAppPSIdDirty()) {
            return null;
        }
        String string = pSTaskServer.getNo2PSMobAppPSId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_No2PSMobAppPSId_Default((IEntity)pSTaskServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NO2PSMOBAPPPSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_No2PSMobAppPSName(boolean bl, PSTaskServer pSTaskServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSTaskServer.isNo2PSMobAppPSNameDirty() : !pSTaskServer.isNo2PSMobAppPSNameDirty()) {
            return null;
        }
        String string = pSTaskServer.getNo2PSMobAppPSName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_No2PSMobAppPSName_Default((IEntity)pSTaskServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NO2PSMOBAPPPSNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCorePrdId(boolean bl, PSTaskServer pSTaskServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSTaskServer.isPSCorePrdIdDirty() : !pSTaskServer.isPSCorePrdIdDirty()) {
            return null;
        }
        String string = pSTaskServer.getPSCorePrdId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCorePrdId_Default((IEntity)pSTaskServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCOREPRDID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCorePrdName(boolean bl, PSTaskServer pSTaskServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSTaskServer.isPSCorePrdNameDirty() : !pSTaskServer.isPSCorePrdNameDirty()) {
            return null;
        }
        String string = pSTaskServer.getPSCorePrdName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCorePrdName_Default((IEntity)pSTaskServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCOREPRDNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCorePrdVerId(boolean bl, PSTaskServer pSTaskServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSTaskServer.isPSCorePrdVerIdDirty() : !pSTaskServer.isPSCorePrdVerIdDirty()) {
            return null;
        }
        String string = pSTaskServer.getPSCorePrdVerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCorePrdVerId_Default((IEntity)pSTaskServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCOREPRDVERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCorePrdVerName(boolean bl, PSTaskServer pSTaskServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSTaskServer.isPSCorePrdVerNameDirty() : !pSTaskServer.isPSCorePrdVerNameDirty()) {
            return null;
        }
        String string = pSTaskServer.getPSCorePrdVerName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCorePrdVerName_Default((IEntity)pSTaskServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCOREPRDVERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDeployCenterId(boolean bl, PSTaskServer pSTaskServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSTaskServer.isPSDeployCenterIdDirty() : !pSTaskServer.isPSDeployCenterIdDirty()) {
            return null;
        }
        String string = pSTaskServer.getPSDeployCenterId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDeployCenterId_Default((IEntity)pSTaskServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPLOYCENTERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSMobAppPackServerId(boolean bl, PSTaskServer pSTaskServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSTaskServer.isPSMobAppPackServerIdDirty() : !pSTaskServer.isPSMobAppPackServerIdDirty()) {
            return null;
        }
        String string = pSTaskServer.getPSMobAppPackServerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSMobAppPackServerId_Default((IEntity)pSTaskServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMOBAPPPACKSERVERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSMobAppPackServerName(boolean bl, PSTaskServer pSTaskServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSTaskServer.isPSMobAppPackServerNameDirty() : !pSTaskServer.isPSMobAppPackServerNameDirty()) {
            return null;
        }
        String string = pSTaskServer.getPSMobAppPackServerName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSMobAppPackServerName_Default((IEntity)pSTaskServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMOBAPPPACKSERVERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSvrDomainId(boolean bl, PSTaskServer pSTaskServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSTaskServer.isPSSvrDomainIdDirty() : !pSTaskServer.isPSSvrDomainIdDirty()) {
            return null;
        }
        String string = pSTaskServer.getPSSvrDomainId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSvrDomainId_Default((IEntity)pSTaskServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSVRDOMAINID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSTaskServerId(boolean bl, PSTaskServer pSTaskServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSTaskServer.isPSTaskServerIdDirty() && !bl2 : !pSTaskServer.isPSTaskServerIdDirty()) {
            return null;
        }
        String string = pSTaskServer.getPSTaskServerId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSTASKSERVERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSTaskServerId_Default((IEntity)pSTaskServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSTASKSERVERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSTaskServerName(boolean bl, PSTaskServer pSTaskServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSTaskServer.isPSTaskServerNameDirty() && !bl2 : !pSTaskServer.isPSTaskServerNameDirty()) {
            return null;
        }
        String string = pSTaskServer.getPSTaskServerName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSTASKSERVERNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSTaskServerName_Default((IEntity)pSTaskServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSTASKSERVERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWorkshopServerId(boolean bl, PSTaskServer pSTaskServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSTaskServer.isPSWorkshopServerIdDirty() : !pSTaskServer.isPSWorkshopServerIdDirty()) {
            return null;
        }
        String string = pSTaskServer.getPSWorkshopServerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWorkshopServerId_Default((IEntity)pSTaskServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWORKSHOPSERVERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefInfo(boolean bl, PSTaskServer pSTaskServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSTaskServer.isRefInfoDirty() : !pSTaskServer.isRefInfoDirty()) {
            return null;
        }
        String string = pSTaskServer.getRefInfo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefInfo_Default((IEntity)pSTaskServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFINFO");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ServerUrl(boolean bl, PSTaskServer pSTaskServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSTaskServer.isServerUrlDirty() && !bl2 : !pSTaskServer.isServerUrlDirty()) {
            return null;
        }
        String string = pSTaskServer.getServerUrl();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SERVERURL");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_ServerUrl_Default((IEntity)pSTaskServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SERVERURL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ServerUrl2(boolean bl, PSTaskServer pSTaskServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSTaskServer.isServerUrl2Dirty() : !pSTaskServer.isServerUrl2Dirty()) {
            return null;
        }
        String string = pSTaskServer.getServerUrl2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ServerUrl2_Default((IEntity)pSTaskServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SERVERURL2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ServerUsage(boolean bl, PSTaskServer pSTaskServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSTaskServer.isServerUsageDirty() : !pSTaskServer.isServerUsageDirty()) {
            return null;
        }
        String string = pSTaskServer.getServerUsage();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ServerUsage_Default((IEntity)pSTaskServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SERVERUSAGE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SysVer(boolean bl, PSTaskServer pSTaskServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSTaskServer.isSysVerDirty() : !pSTaskServer.isSysVerDirty()) {
            return null;
        }
        String string = pSTaskServer.getSysVer();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SysVer_Default((IEntity)pSTaskServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SYSVER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TSParams(boolean bl, PSTaskServer pSTaskServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSTaskServer.isTSParamsDirty() : !pSTaskServer.isTSParamsDirty()) {
            return null;
        }
        String string = pSTaskServer.getTSParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TSParams_Default((IEntity)pSTaskServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TSPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSTaskServer pSTaskServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSTaskServer.isValidFlagDirty() && !bl2 : !pSTaskServer.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSTaskServer.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSTaskServer, bl2, bl3);
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

    protected void onSyncEntity(PSTaskServer pSTaskServer, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSTaskServer, bl);
    }

    protected void onSyncIndexEntities(PSTaskServer pSTaskServer, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSTaskServer, bl);
    }

    public Object getDataContextValue(PSTaskServer pSTaskServer, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSTaskServer, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSTaskServer pSTaskServer, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSTaskServer, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEVSYSDEPLOYMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DevSysDeployMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DOMAINPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DomainParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"IPADDR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IpAddr_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"IPADDR2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IpAddr2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LICINFO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LicInfo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LICKEY", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LicKey_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO2PSMOBAPPPSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_No2PSMobAppPSId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO2PSMOBAPPPSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_No2PSMobAppPSName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCOREPRDID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCorePrdId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCOREPRDNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCorePrdName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCOREPRDVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCorePrdVerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCOREPRDVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCorePrdVerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPLOYCENTERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDeployCenterId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPLOYCENTERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDeployCenterName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMOBAPPPACKSERVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSMobAppPackServerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMOBAPPPACKSERVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSMobAppPackServerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSVRDOMAINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSvrDomainId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSVRDOMAINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSvrDomainName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSTASKSERVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSTaskServerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSTASKSERVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSTaskServerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWORKSHOPSERVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWorkshopServerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWORKSHOPSERVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWorkshopServerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFINFO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefInfo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SERVERURL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ServerUrl_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SERVERURL2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ServerUrl2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SERVERUSAGE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ServerUsage_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SYSVER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SysVer_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TSPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TSParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALIDFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValidFlag_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_DevSysDeployMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DomainParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DOMAINPARAMS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_IpAddr_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("IPADDR", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_IpAddr2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("IPADDR2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LicInfo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LICINFO", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LicKey_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LICKEY", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected String onTestValueRule_No2PSMobAppPSId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NO2PSMOBAPPPSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_No2PSMobAppPSName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NO2PSMOBAPPPSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCorePrdId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCOREPRDID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCorePrdName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCOREPRDNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCorePrdVerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCOREPRDVERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCorePrdVerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCOREPRDVERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDeployCenterId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPLOYCENTERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDeployCenterName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPLOYCENTERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSMobAppPackServerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMOBAPPPACKSERVERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSMobAppPackServerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMOBAPPPACKSERVERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSvrDomainId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSVRDOMAINID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSvrDomainName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSVRDOMAINNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSTaskServerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSTASKSERVERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSTaskServerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSTASKSERVERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWorkshopServerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWORKSHOPSERVERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWorkshopServerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWORKSHOPSERVERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefInfo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFINFO", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ServerUrl_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SERVERURL", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ServerUrl2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SERVERURL2", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ServerUsage_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SERVERUSAGE", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SysVer_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SYSVER", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TSParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TSPARAMS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
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

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected boolean onMergeChild(String string, String string2, PSTaskServer pSTaskServer) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSTaskServer)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSTaskServer pSTaskServer) throws Exception {
        super.onUpdateParent((IEntity)pSTaskServer);
    }

    @Override
    protected void exportCurXmlModel(PSTaskServer pSTaskServer, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSTASKSERVER");
        if (!bl) {
            pSTaskServer.setLicInfo(null);
            pSTaskServer.setRefInfo(null);
            super.exportCurXmlModel(pSTaskServer, xmlNode, bl);
        }
    }
}

