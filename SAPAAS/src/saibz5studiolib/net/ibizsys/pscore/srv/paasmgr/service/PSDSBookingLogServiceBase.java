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

import java.sql.Timestamp;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.demodel.DEModelGlobal;
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
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterServer;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterServerBase;
import net.ibizsys.pscore.srv.paasmgr.dao.PSDSBookingLogDAO;
import net.ibizsys.pscore.srv.paasmgr.demodel.PSDSBookingLogDEModel;
import net.ibizsys.pscore.srv.paasmgr.entity.PSDSBookingLog;
import net.ibizsys.pscore.srv.paasmgr.entity.PSDevServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSDevServerBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSvrDomain;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSvrDomainBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSTaskServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSTaskServerBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDSBookingLogServiceBase
extends PSCoreSysServiceBase<PSDSBookingLog> {
    private static final Log log = LogFactory.getLog(PSDSBookingLogServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDSBookingLogDEModel pSDSBookingLogDEModel;
    private PSDSBookingLogDAO pSDSBookingLogDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.paasmgr.service.PSDSBookingLogService";
    }

    public PSDSBookingLogDEModel getPSDSBookingLogDEModel() {
        if (this.pSDSBookingLogDEModel == null) {
            try {
                this.pSDSBookingLogDEModel = (PSDSBookingLogDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.paasmgr.demodel.PSDSBookingLogDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDSBookingLogDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDSBookingLogDEModel();
    }

    public PSDSBookingLogDAO getPSDSBookingLogDAO() {
        if (this.pSDSBookingLogDAO == null) {
            try {
                this.pSDSBookingLogDAO = (PSDSBookingLogDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.paasmgr.dao.PSDSBookingLogDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDSBookingLogDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDSBookingLogDAO();
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

    protected void onFillParentInfo(PSDSBookingLog pSDSBookingLog, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDSBOOKINGLOG_PSDEVCENTERSERVER_PSDEVCENTERSERVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterServerService", (SessionFactory)this.getSessionFactory());
            PSDevCenterServer pSDevCenterServer = (PSDevCenterServer)iService.getDEModel().createEntity();
            pSDevCenterServer.set("PSDEVCENTERSERVERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenterServer);
            } else {
                iService.get(pSDevCenterServer);
            }
            this.onFillParentInfo_PSDevCenterServer(pSDSBookingLog, pSDevCenterServer);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDSBOOKINGLOG_PSDEVCENTER_PSDEVCENTERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService", (SessionFactory)this.getSessionFactory());
            PSDevCenter pSDevCenter = (PSDevCenter)iService.getDEModel().createEntity();
            pSDevCenter.set("PSDEVCENTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenter);
            } else {
                iService.get(pSDevCenter);
            }
            this.onFillParentInfo_PSDevCenter(pSDSBookingLog, pSDevCenter);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDSBOOKINGLOG_PSDEVSERVER_PSDEVSERVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSDevServerService", (SessionFactory)this.getSessionFactory());
            PSDevServer pSDevServer = (PSDevServer)iService.getDEModel().createEntity();
            pSDevServer.set("PSDEVSERVERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevServer);
            } else {
                iService.get(pSDevServer);
            }
            this.onFillParentInfo_PSDevServer(pSDSBookingLog, pSDevServer);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDSBOOKINGLOG_PSSVRDOMAIN_PSSVRDOMAINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSSvrDomainService", (SessionFactory)this.getSessionFactory());
            PSSvrDomain pSSvrDomain = (PSSvrDomain)iService.getDEModel().createEntity();
            pSSvrDomain.set("PSSVRDOMAINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSvrDomain);
            } else {
                iService.get(pSSvrDomain);
            }
            this.onFillParentInfo_Pssvrdomain(pSDSBookingLog, pSSvrDomain);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDSBOOKINGLOG_PSTASKSERVER_PSTASKSERVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSTaskServerService", (SessionFactory)this.getSessionFactory());
            PSTaskServer pSTaskServer = (PSTaskServer)iService.getDEModel().createEntity();
            pSTaskServer.set("PSTASKSERVERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSTaskServer);
            } else {
                iService.get(pSTaskServer);
            }
            this.onFillParentInfo_PSTaskServer(pSDSBookingLog, pSTaskServer);
            return;
        }
        super.onFillParentInfo(pSDSBookingLog, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDevCenterServer(PSDSBookingLog pSDSBookingLog, PSDevCenterServer pSDevCenterServer) throws Exception {
        pSDSBookingLog.setPSDevCenterServerId(pSDevCenterServer.getPSDevCenterServerId());
        pSDSBookingLog.setPSDevCenterServerName(pSDevCenterServer.getPSDevCenterServerName());
    }

    protected void onFillParentInfo_PSDevCenter(PSDSBookingLog pSDSBookingLog, PSDevCenter pSDevCenter) throws Exception {
        pSDSBookingLog.setPSDevCenterId(pSDevCenter.getPSDevCenterId());
        pSDSBookingLog.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
    }

    protected void onFillParentInfo_PSDevServer(PSDSBookingLog pSDSBookingLog, PSDevServer pSDevServer) throws Exception {
        pSDSBookingLog.setPSDevServerId(pSDevServer.getPSDevServerId());
        pSDSBookingLog.setPSDevServerName(pSDevServer.getPSDevServerName());
    }

    protected void onFillParentInfo_Pssvrdomain(PSDSBookingLog pSDSBookingLog, PSSvrDomain pSSvrDomain) throws Exception {
        pSDSBookingLog.setPSSvrDomainId(pSSvrDomain.getPSSvrDomainId());
        pSDSBookingLog.setPSSvrDomainName(pSSvrDomain.getPSSvrDomainName());
    }

    protected void onFillParentInfo_PSTaskServer(PSDSBookingLog pSDSBookingLog, PSTaskServer pSTaskServer) throws Exception {
        pSDSBookingLog.setPSTaskServerId(pSTaskServer.getPSTaskServerId());
        pSDSBookingLog.setPSTaskServerName(pSTaskServer.getPSTaskServerName());
    }

    protected void onFillEntityFullInfo(PSDSBookingLog pSDSBookingLog, boolean bl) throws Exception {
        if (bl) {
            if (pSDSBookingLog.getBackupState() == null) {
                pSDSBookingLog.setBackupState((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDSBookingLog.getRestoreState() == null) {
                pSDSBookingLog.setRestoreState((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
        }
        super.onFillEntityFullInfo(pSDSBookingLog, bl);
        this.onFillEntityFullInfo_PSDevCenterServer(pSDSBookingLog, bl);
        this.onFillEntityFullInfo_PSDevCenter(pSDSBookingLog, bl);
        this.onFillEntityFullInfo_PSDevServer(pSDSBookingLog, bl);
        this.onFillEntityFullInfo_Pssvrdomain(pSDSBookingLog, bl);
        this.onFillEntityFullInfo_PSTaskServer(pSDSBookingLog, bl);
    }

    protected void onFillEntityFullInfo_PSDevCenterServer(PSDSBookingLog pSDSBookingLog, boolean bl) throws Exception {
        if (pSDSBookingLog.isPSDevCenterServerIdDirty()) {
            if (pSDSBookingLog.getPSDevCenterServerId() != null) {
                if (pSDSBookingLog.getPSDevCenterServerId() == null || pSDSBookingLog.getPSDevCenterServerName() == null) {
                    PSDevCenterServer pSDevCenterServer = pSDSBookingLog.getPSDevCenterServer();
                    pSDSBookingLog.setPSDevCenterServerName(pSDevCenterServer.getPSDevCenterServerName());
                }
            } else {
                pSDSBookingLog.setPSDevCenterServerName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDevCenter(PSDSBookingLog pSDSBookingLog, boolean bl) throws Exception {
        if (pSDSBookingLog.isPSDevCenterIdDirty()) {
            if (pSDSBookingLog.getPSDevCenterId() != null) {
                if (pSDSBookingLog.getPSDevCenterId() == null || pSDSBookingLog.getPSDevCenterName() == null) {
                    PSDevCenter pSDevCenter = pSDSBookingLog.getPSDevCenter();
                    pSDSBookingLog.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
                }
            } else {
                pSDSBookingLog.setPSDevCenterName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDevServer(PSDSBookingLog pSDSBookingLog, boolean bl) throws Exception {
        if (pSDSBookingLog.isPSDevServerIdDirty()) {
            if (pSDSBookingLog.getPSDevServerId() != null) {
                if (pSDSBookingLog.getPSDevServerId() == null || pSDSBookingLog.getPSDevServerName() == null) {
                    PSDevServer pSDevServer = pSDSBookingLog.getPSDevServer();
                    pSDSBookingLog.setPSDevServerName(pSDevServer.getPSDevServerName());
                }
            } else {
                pSDSBookingLog.setPSDevServerName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_Pssvrdomain(PSDSBookingLog pSDSBookingLog, boolean bl) throws Exception {
        if (pSDSBookingLog.isPSSvrDomainIdDirty()) {
            if (pSDSBookingLog.getPSSvrDomainId() != null) {
                if (pSDSBookingLog.getPSSvrDomainId() == null || pSDSBookingLog.getPSSvrDomainName() == null) {
                    PSSvrDomain pSSvrDomain = pSDSBookingLog.getPssvrdomain();
                    pSDSBookingLog.setPSSvrDomainName(pSSvrDomain.getPSSvrDomainName());
                }
            } else {
                pSDSBookingLog.setPSSvrDomainName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSTaskServer(PSDSBookingLog pSDSBookingLog, boolean bl) throws Exception {
        if (pSDSBookingLog.isPSTaskServerIdDirty()) {
            if (pSDSBookingLog.getPSTaskServerId() != null) {
                if (pSDSBookingLog.getPSTaskServerId() == null || pSDSBookingLog.getPSTaskServerName() == null) {
                    PSTaskServer pSTaskServer = pSDSBookingLog.getPSTaskServer();
                    pSDSBookingLog.setPSTaskServerName(pSTaskServer.getPSTaskServerName());
                }
            } else {
                pSDSBookingLog.setPSTaskServerName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDSBookingLog pSDSBookingLog, boolean bl) throws Exception {
        super.onWriteBackParent(pSDSBookingLog, bl);
    }

    public ArrayList<PSDSBookingLog> selectByPSDevCenterServer(PSDevCenterServerBase pSDevCenterServerBase) throws Exception {
        return this.selectByPSDevCenterServer(pSDevCenterServerBase, "", -1);
    }

    public ArrayList<PSDSBookingLog> selectByPSDevCenterServer(PSDevCenterServerBase pSDevCenterServerBase, String string) throws Exception {
        return this.selectByPSDevCenterServer(pSDevCenterServerBase, string, -1);
    }

    public ArrayList<PSDSBookingLog> selectByPSDevCenterServer(PSDevCenterServerBase pSDevCenterServerBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVCENTERSERVERID", (Object)pSDevCenterServerBase.getPSDevCenterServerId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevCenterServerCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevCenterServerCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDSBookingLog> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, "", -1);
    }

    public ArrayList<PSDSBookingLog> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, string, -1);
    }

    public ArrayList<PSDSBookingLog> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVCENTERID", (Object)pSDevCenterBase.getPSDevCenterId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevCenterCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevCenterCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDSBookingLog> selectByPSDevServer(PSDevServerBase pSDevServerBase) throws Exception {
        return this.selectByPSDevServer(pSDevServerBase, "", -1);
    }

    public ArrayList<PSDSBookingLog> selectByPSDevServer(PSDevServerBase pSDevServerBase, String string) throws Exception {
        return this.selectByPSDevServer(pSDevServerBase, string, -1);
    }

    public ArrayList<PSDSBookingLog> selectByPSDevServer(PSDevServerBase pSDevServerBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVSERVERID", (Object)pSDevServerBase.getPSDevServerId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevServerCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevServerCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDSBookingLog> selectByPssvrdomain(PSSvrDomainBase pSSvrDomainBase) throws Exception {
        return this.selectByPssvrdomain(pSSvrDomainBase, "", -1);
    }

    public ArrayList<PSDSBookingLog> selectByPssvrdomain(PSSvrDomainBase pSSvrDomainBase, String string) throws Exception {
        return this.selectByPssvrdomain(pSSvrDomainBase, string, -1);
    }

    public ArrayList<PSDSBookingLog> selectByPssvrdomain(PSSvrDomainBase pSSvrDomainBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSVRDOMAINID", (Object)pSSvrDomainBase.getPSSvrDomainId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPssvrdomainCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPssvrdomainCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDSBookingLog> selectByPSTaskServer(PSTaskServerBase pSTaskServerBase) throws Exception {
        return this.selectByPSTaskServer(pSTaskServerBase, "", -1);
    }

    public ArrayList<PSDSBookingLog> selectByPSTaskServer(PSTaskServerBase pSTaskServerBase, String string) throws Exception {
        return this.selectByPSTaskServer(pSTaskServerBase, string, -1);
    }

    public ArrayList<PSDSBookingLog> selectByPSTaskServer(PSTaskServerBase pSTaskServerBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSTASKSERVERID", (Object)pSTaskServerBase.getPSTaskServerId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSTaskServerCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSTaskServerCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDevCenterServer(PSDevCenterServer pSDevCenterServer) throws Exception {
    }

    public void resetPSDevCenterServer(PSDevCenterServer pSDevCenterServer) throws Exception {
        ArrayList<PSDSBookingLog> arrayList = this.selectByPSDevCenterServer(pSDevCenterServer);
        for (PSDSBookingLog pSDSBookingLog : arrayList) {
            PSDSBookingLog pSDSBookingLog2 = (PSDSBookingLog)this.getDEModel().createEntity();
            pSDSBookingLog2.setPSDSBookingLogId(pSDSBookingLog.getPSDSBookingLogId());
            pSDSBookingLog2.setPSDevCenterServerId(null);
            this.update(pSDSBookingLog2);
        }
    }

    public void removeByPSDevCenterServer(PSDevCenterServer pSDevCenterServer) throws Exception {
        final PSDevCenterServer pSDevCenterServer2 = pSDevCenterServer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDSBookingLogServiceBase.this.onBeforeRemoveByPSDevCenterServer(pSDevCenterServer2);
                PSDSBookingLogServiceBase.this.internalRemoveByPSDevCenterServer(pSDevCenterServer2);
                PSDSBookingLogServiceBase.this.onAfterRemoveByPSDevCenterServer(pSDevCenterServer2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenterServer(PSDevCenterServer pSDevCenterServer) throws Exception {
    }

    protected void internalRemoveByPSDevCenterServer(PSDevCenterServer pSDevCenterServer) throws Exception {
        ArrayList<PSDSBookingLog> arrayList = this.selectByPSDevCenterServer(pSDevCenterServer);
        this.onBeforeRemoveByPSDevCenterServer(pSDevCenterServer, arrayList);
        for (PSDSBookingLog pSDSBookingLog : arrayList) {
            this.remove(pSDSBookingLog);
        }
        this.onAfterRemoveByPSDevCenterServer(pSDevCenterServer, arrayList);
    }

    protected void onAfterRemoveByPSDevCenterServer(PSDevCenterServer pSDevCenterServer) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenterServer(PSDevCenterServer pSDevCenterServer, ArrayList<PSDSBookingLog> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenterServer(PSDevCenterServer pSDevCenterServer, ArrayList<PSDSBookingLog> arrayList) throws Exception {
    }

    public void testRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    public void resetPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDSBookingLog> arrayList = this.selectByPSDevCenter(pSDevCenter);
        for (PSDSBookingLog pSDSBookingLog : arrayList) {
            PSDSBookingLog pSDSBookingLog2 = (PSDSBookingLog)this.getDEModel().createEntity();
            pSDSBookingLog2.setPSDSBookingLogId(pSDSBookingLog.getPSDSBookingLogId());
            pSDSBookingLog2.setPSDevCenterId(null);
            this.update(pSDSBookingLog2);
        }
    }

    public void removeByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        final PSDevCenter pSDevCenter2 = pSDevCenter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDSBookingLogServiceBase.this.onBeforeRemoveByPSDevCenter(pSDevCenter2);
                PSDSBookingLogServiceBase.this.internalRemoveByPSDevCenter(pSDevCenter2);
                PSDSBookingLogServiceBase.this.onAfterRemoveByPSDevCenter(pSDevCenter2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void internalRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDSBookingLog> arrayList = this.selectByPSDevCenter(pSDevCenter);
        this.onBeforeRemoveByPSDevCenter(pSDevCenter, arrayList);
        for (PSDSBookingLog pSDSBookingLog : arrayList) {
            this.remove(pSDSBookingLog);
        }
        this.onAfterRemoveByPSDevCenter(pSDevCenter, arrayList);
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSDSBookingLog> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSDSBookingLog> arrayList) throws Exception {
    }

    public void testRemoveByPSDevServer(PSDevServer pSDevServer) throws Exception {
    }

    public void resetPSDevServer(PSDevServer pSDevServer) throws Exception {
        ArrayList<PSDSBookingLog> arrayList = this.selectByPSDevServer(pSDevServer);
        for (PSDSBookingLog pSDSBookingLog : arrayList) {
            PSDSBookingLog pSDSBookingLog2 = (PSDSBookingLog)this.getDEModel().createEntity();
            pSDSBookingLog2.setPSDSBookingLogId(pSDSBookingLog.getPSDSBookingLogId());
            pSDSBookingLog2.setPSDevServerId(null);
            this.update(pSDSBookingLog2);
        }
    }

    public void removeByPSDevServer(PSDevServer pSDevServer) throws Exception {
        final PSDevServer pSDevServer2 = pSDevServer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDSBookingLogServiceBase.this.onBeforeRemoveByPSDevServer(pSDevServer2);
                PSDSBookingLogServiceBase.this.internalRemoveByPSDevServer(pSDevServer2);
                PSDSBookingLogServiceBase.this.onAfterRemoveByPSDevServer(pSDevServer2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevServer(PSDevServer pSDevServer) throws Exception {
    }

    protected void internalRemoveByPSDevServer(PSDevServer pSDevServer) throws Exception {
        ArrayList<PSDSBookingLog> arrayList = this.selectByPSDevServer(pSDevServer);
        this.onBeforeRemoveByPSDevServer(pSDevServer, arrayList);
        for (PSDSBookingLog pSDSBookingLog : arrayList) {
            this.remove(pSDSBookingLog);
        }
        this.onAfterRemoveByPSDevServer(pSDevServer, arrayList);
    }

    protected void onAfterRemoveByPSDevServer(PSDevServer pSDevServer) throws Exception {
    }

    protected void onBeforeRemoveByPSDevServer(PSDevServer pSDevServer, ArrayList<PSDSBookingLog> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevServer(PSDevServer pSDevServer, ArrayList<PSDSBookingLog> arrayList) throws Exception {
    }

    public void testRemoveByPssvrdomain(PSSvrDomain pSSvrDomain) throws Exception {
    }

    public void resetPssvrdomain(PSSvrDomain pSSvrDomain) throws Exception {
        ArrayList<PSDSBookingLog> arrayList = this.selectByPssvrdomain(pSSvrDomain);
        for (PSDSBookingLog pSDSBookingLog : arrayList) {
            PSDSBookingLog pSDSBookingLog2 = (PSDSBookingLog)this.getDEModel().createEntity();
            pSDSBookingLog2.setPSDSBookingLogId(pSDSBookingLog.getPSDSBookingLogId());
            pSDSBookingLog2.setPSSvrDomainId(null);
            this.update(pSDSBookingLog2);
        }
    }

    public void removeByPssvrdomain(PSSvrDomain pSSvrDomain) throws Exception {
        final PSSvrDomain pSSvrDomain2 = pSSvrDomain;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDSBookingLogServiceBase.this.onBeforeRemoveByPssvrdomain(pSSvrDomain2);
                PSDSBookingLogServiceBase.this.internalRemoveByPssvrdomain(pSSvrDomain2);
                PSDSBookingLogServiceBase.this.onAfterRemoveByPssvrdomain(pSSvrDomain2);
            }
        });
    }

    protected void onBeforeRemoveByPssvrdomain(PSSvrDomain pSSvrDomain) throws Exception {
    }

    protected void internalRemoveByPssvrdomain(PSSvrDomain pSSvrDomain) throws Exception {
        ArrayList<PSDSBookingLog> arrayList = this.selectByPssvrdomain(pSSvrDomain);
        this.onBeforeRemoveByPssvrdomain(pSSvrDomain, arrayList);
        for (PSDSBookingLog pSDSBookingLog : arrayList) {
            this.remove(pSDSBookingLog);
        }
        this.onAfterRemoveByPssvrdomain(pSSvrDomain, arrayList);
    }

    protected void onAfterRemoveByPssvrdomain(PSSvrDomain pSSvrDomain) throws Exception {
    }

    protected void onBeforeRemoveByPssvrdomain(PSSvrDomain pSSvrDomain, ArrayList<PSDSBookingLog> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPssvrdomain(PSSvrDomain pSSvrDomain, ArrayList<PSDSBookingLog> arrayList) throws Exception {
    }

    public void testRemoveByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
    }

    public void resetPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
        ArrayList<PSDSBookingLog> arrayList = this.selectByPSTaskServer(pSTaskServer);
        for (PSDSBookingLog pSDSBookingLog : arrayList) {
            PSDSBookingLog pSDSBookingLog2 = (PSDSBookingLog)this.getDEModel().createEntity();
            pSDSBookingLog2.setPSDSBookingLogId(pSDSBookingLog.getPSDSBookingLogId());
            pSDSBookingLog2.setPSTaskServerId(null);
            this.update(pSDSBookingLog2);
        }
    }

    public void removeByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
        final PSTaskServer pSTaskServer2 = pSTaskServer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDSBookingLogServiceBase.this.onBeforeRemoveByPSTaskServer(pSTaskServer2);
                PSDSBookingLogServiceBase.this.internalRemoveByPSTaskServer(pSTaskServer2);
                PSDSBookingLogServiceBase.this.onAfterRemoveByPSTaskServer(pSTaskServer2);
            }
        });
    }

    protected void onBeforeRemoveByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
    }

    protected void internalRemoveByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
        ArrayList<PSDSBookingLog> arrayList = this.selectByPSTaskServer(pSTaskServer);
        this.onBeforeRemoveByPSTaskServer(pSTaskServer, arrayList);
        for (PSDSBookingLog pSDSBookingLog : arrayList) {
            this.remove(pSDSBookingLog);
        }
        this.onAfterRemoveByPSTaskServer(pSTaskServer, arrayList);
    }

    protected void onAfterRemoveByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
    }

    protected void onBeforeRemoveByPSTaskServer(PSTaskServer pSTaskServer, ArrayList<PSDSBookingLog> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSTaskServer(PSTaskServer pSTaskServer, ArrayList<PSDSBookingLog> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDSBookingLog pSDSBookingLog) throws Exception {
        super.onBeforeRemove(pSDSBookingLog);
    }

    protected void replaceParentInfo(PSDSBookingLog pSDSBookingLog, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDSBookingLog, cloneSession);
        if (pSDSBookingLog.getPSDevCenterServerId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTERSERVER", (Object)pSDSBookingLog.getPSDevCenterServerId())) != null) {
            this.onFillParentInfo_PSDevCenterServer(pSDSBookingLog, (PSDevCenterServer)iEntity);
        }
        if (pSDSBookingLog.getPSDevCenterId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTER", (Object)pSDSBookingLog.getPSDevCenterId())) != null) {
            this.onFillParentInfo_PSDevCenter(pSDSBookingLog, (PSDevCenter)iEntity);
        }
        if (pSDSBookingLog.getPSDevServerId() != null && (iEntity = cloneSession.getEntity("PSDEVSERVER", (Object)pSDSBookingLog.getPSDevServerId())) != null) {
            this.onFillParentInfo_PSDevServer(pSDSBookingLog, (PSDevServer)iEntity);
        }
        if (pSDSBookingLog.getPSSvrDomainId() != null && (iEntity = cloneSession.getEntity("PSSVRDOMAIN", (Object)pSDSBookingLog.getPSSvrDomainId())) != null) {
            this.onFillParentInfo_Pssvrdomain(pSDSBookingLog, (PSSvrDomain)iEntity);
        }
        if (pSDSBookingLog.getPSTaskServerId() != null && (iEntity = cloneSession.getEntity("PSTASKSERVER", (Object)pSDSBookingLog.getPSTaskServerId())) != null) {
            this.onFillParentInfo_PSTaskServer(pSDSBookingLog, (PSTaskServer)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDSBookingLog pSDSBookingLog, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDSBookingLog, bl);
    }

    protected void onCheckEntity(boolean bl, PSDSBookingLog pSDSBookingLog, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_BackupInfo(bl, pSDSBookingLog, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BackupState(bl, pSDSBookingLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BeginTime(bl, pSDSBookingLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BookingInfo(bl, pSDSBookingLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BookingParam(bl, pSDSBookingLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BookingParam2(bl, pSDSBookingLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BookingParam3(bl, pSDSBookingLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BookingParam4(bl, pSDSBookingLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BookingState(bl, pSDSBookingLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BookingType(bl, pSDSBookingLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Duration(bl, pSDSBookingLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EndTime(bl, pSDSBookingLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Hours(bl, pSDSBookingLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogInfo(bl, pSDSBookingLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDSBookingLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterId(bl, pSDSBookingLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterName(bl, pSDSBookingLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterServerId(bl, pSDSBookingLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterServerName(bl, pSDSBookingLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevServerId(bl, pSDSBookingLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevServerName(bl, pSDSBookingLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDSBookingLogId(bl, pSDSBookingLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDSBookingLogName(bl, pSDSBookingLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSvrDomainId(bl, pSDSBookingLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSvrDomainName(bl, pSDSBookingLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSTaskServerId(bl, pSDSBookingLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSTaskServerName(bl, pSDSBookingLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RestoreInfo(bl, pSDSBookingLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RestoreState(bl, pSDSBookingLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDSBookingLog, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_BackupInfo(boolean bl, PSDSBookingLog pSDSBookingLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDSBookingLog.isBackupInfoDirty() : !pSDSBookingLog.isBackupInfoDirty()) {
            return null;
        }
        String string = pSDSBookingLog.getBackupInfo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BackupInfo_Default(pSDSBookingLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BACKUPINFO");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BackupState(boolean bl, PSDSBookingLog pSDSBookingLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDSBookingLog.isBackupStateDirty() && !bl2 : !pSDSBookingLog.isBackupStateDirty()) {
            return null;
        }
        Integer n = pSDSBookingLog.getBackupState();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BACKUPSTATE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_BackupState_Default(pSDSBookingLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BACKUPSTATE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BeginTime(boolean bl, PSDSBookingLog pSDSBookingLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDSBookingLog.isBeginTimeDirty() && !bl2 : !pSDSBookingLog.isBeginTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSDSBookingLog.getBeginTime();
        if (bl) {
            if (bl2 && timestamp == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BEGINTIME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_BeginTime_Default(pSDSBookingLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BEGINTIME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BookingInfo(boolean bl, PSDSBookingLog pSDSBookingLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDSBookingLog.isBookingInfoDirty() : !pSDSBookingLog.isBookingInfoDirty()) {
            return null;
        }
        String string = pSDSBookingLog.getBookingInfo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BookingInfo_Default(pSDSBookingLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BOOKINGINFO");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BookingParam(boolean bl, PSDSBookingLog pSDSBookingLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDSBookingLog.isBookingParamDirty() : !pSDSBookingLog.isBookingParamDirty()) {
            return null;
        }
        String string = pSDSBookingLog.getBookingParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BookingParam_Default(pSDSBookingLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BOOKINGPARAM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BookingParam2(boolean bl, PSDSBookingLog pSDSBookingLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDSBookingLog.isBookingParam2Dirty() : !pSDSBookingLog.isBookingParam2Dirty()) {
            return null;
        }
        String string = pSDSBookingLog.getBookingParam2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BookingParam2_Default(pSDSBookingLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BOOKINGPARAM2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BookingParam3(boolean bl, PSDSBookingLog pSDSBookingLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDSBookingLog.isBookingParam3Dirty() : !pSDSBookingLog.isBookingParam3Dirty()) {
            return null;
        }
        String string = pSDSBookingLog.getBookingParam3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BookingParam3_Default(pSDSBookingLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BOOKINGPARAM3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BookingParam4(boolean bl, PSDSBookingLog pSDSBookingLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDSBookingLog.isBookingParam4Dirty() : !pSDSBookingLog.isBookingParam4Dirty()) {
            return null;
        }
        String string = pSDSBookingLog.getBookingParam4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BookingParam4_Default(pSDSBookingLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BOOKINGPARAM4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BookingState(boolean bl, PSDSBookingLog pSDSBookingLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDSBookingLog.isBookingStateDirty() && !bl2 : !pSDSBookingLog.isBookingStateDirty()) {
            return null;
        }
        Integer n = pSDSBookingLog.getBookingState();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BOOKINGSTATE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_BookingState_Default(pSDSBookingLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BOOKINGSTATE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BookingType(boolean bl, PSDSBookingLog pSDSBookingLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDSBookingLog.isBookingTypeDirty() && !bl2 : !pSDSBookingLog.isBookingTypeDirty()) {
            return null;
        }
        String string = pSDSBookingLog.getBookingType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BOOKINGTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_BookingType_Default(pSDSBookingLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BOOKINGTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Duration(boolean bl, PSDSBookingLog pSDSBookingLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDSBookingLog.isDurationDirty() : !pSDSBookingLog.isDurationDirty()) {
            return null;
        }
        Integer n = pSDSBookingLog.getDuration();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Duration_Default(pSDSBookingLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DURATION");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EndTime(boolean bl, PSDSBookingLog pSDSBookingLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDSBookingLog.isEndTimeDirty() && !bl2 : !pSDSBookingLog.isEndTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSDSBookingLog.getEndTime();
        if (bl) {
            if (bl2 && timestamp == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENDTIME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_EndTime_Default(pSDSBookingLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENDTIME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Hours(boolean bl, PSDSBookingLog pSDSBookingLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDSBookingLog.isHoursDirty() && !bl2 : !pSDSBookingLog.isHoursDirty()) {
            return null;
        }
        Integer n = pSDSBookingLog.getHours();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HOURS");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_Hours_Default(pSDSBookingLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HOURS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LogInfo(boolean bl, PSDSBookingLog pSDSBookingLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDSBookingLog.isLogInfoDirty() : !pSDSBookingLog.isLogInfoDirty()) {
            return null;
        }
        String string = pSDSBookingLog.getLogInfo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogInfo_Default(pSDSBookingLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOGINFO");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDSBookingLog pSDSBookingLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDSBookingLog.isMemoDirty() : !pSDSBookingLog.isMemoDirty()) {
            return null;
        }
        String string = pSDSBookingLog.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDSBookingLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevCenterId(boolean bl, PSDSBookingLog pSDSBookingLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDSBookingLog.isPSDevCenterIdDirty() : !pSDSBookingLog.isPSDevCenterIdDirty()) {
            return null;
        }
        String string = pSDSBookingLog.getPSDevCenterId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterId_Default(pSDSBookingLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterName(boolean bl, PSDSBookingLog pSDSBookingLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDSBookingLog.isPSDevCenterNameDirty() : !pSDSBookingLog.isPSDevCenterNameDirty()) {
            return null;
        }
        String string = pSDSBookingLog.getPSDevCenterName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterName_Default(pSDSBookingLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterServerId(boolean bl, PSDSBookingLog pSDSBookingLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDSBookingLog.isPSDevCenterServerIdDirty() : !pSDSBookingLog.isPSDevCenterServerIdDirty()) {
            return null;
        }
        String string = pSDSBookingLog.getPSDevCenterServerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterServerId_Default(pSDSBookingLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERSERVERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterServerName(boolean bl, PSDSBookingLog pSDSBookingLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDSBookingLog.isPSDevCenterServerNameDirty() : !pSDSBookingLog.isPSDevCenterServerNameDirty()) {
            return null;
        }
        String string = pSDSBookingLog.getPSDevCenterServerName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterServerName_Default(pSDSBookingLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERSERVERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevServerId(boolean bl, PSDSBookingLog pSDSBookingLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDSBookingLog.isPSDevServerIdDirty() : !pSDSBookingLog.isPSDevServerIdDirty()) {
            return null;
        }
        String string = pSDSBookingLog.getPSDevServerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevServerId_Default(pSDSBookingLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSERVERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevServerName(boolean bl, PSDSBookingLog pSDSBookingLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDSBookingLog.isPSDevServerNameDirty() : !pSDSBookingLog.isPSDevServerNameDirty()) {
            return null;
        }
        String string = pSDSBookingLog.getPSDevServerName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevServerName_Default(pSDSBookingLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSERVERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDSBookingLogId(boolean bl, PSDSBookingLog pSDSBookingLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDSBookingLog.isPSDSBookingLogIdDirty() && !bl2 : !pSDSBookingLog.isPSDSBookingLogIdDirty()) {
            return null;
        }
        String string = pSDSBookingLog.getPSDSBookingLogId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDSBOOKINGLOGID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDSBookingLogId_Default(pSDSBookingLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDSBOOKINGLOGID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDSBookingLogName(boolean bl, PSDSBookingLog pSDSBookingLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDSBookingLog.isPSDSBookingLogNameDirty() && !bl2 : !pSDSBookingLog.isPSDSBookingLogNameDirty()) {
            return null;
        }
        String string = pSDSBookingLog.getPSDSBookingLogName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDSBOOKINGLOGNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDSBookingLogName_Default(pSDSBookingLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDSBOOKINGLOGNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSvrDomainId(boolean bl, PSDSBookingLog pSDSBookingLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDSBookingLog.isPSSvrDomainIdDirty() : !pSDSBookingLog.isPSSvrDomainIdDirty()) {
            return null;
        }
        String string = pSDSBookingLog.getPSSvrDomainId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSvrDomainId_Default(pSDSBookingLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSvrDomainName(boolean bl, PSDSBookingLog pSDSBookingLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDSBookingLog.isPSSvrDomainNameDirty() : !pSDSBookingLog.isPSSvrDomainNameDirty()) {
            return null;
        }
        String string = pSDSBookingLog.getPSSvrDomainName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSvrDomainName_Default(pSDSBookingLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSVRDOMAINNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSTaskServerId(boolean bl, PSDSBookingLog pSDSBookingLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDSBookingLog.isPSTaskServerIdDirty() : !pSDSBookingLog.isPSTaskServerIdDirty()) {
            return null;
        }
        String string = pSDSBookingLog.getPSTaskServerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSTaskServerId_Default(pSDSBookingLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSTaskServerName(boolean bl, PSDSBookingLog pSDSBookingLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDSBookingLog.isPSTaskServerNameDirty() : !pSDSBookingLog.isPSTaskServerNameDirty()) {
            return null;
        }
        String string = pSDSBookingLog.getPSTaskServerName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSTaskServerName_Default(pSDSBookingLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_RestoreInfo(boolean bl, PSDSBookingLog pSDSBookingLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDSBookingLog.isRestoreInfoDirty() : !pSDSBookingLog.isRestoreInfoDirty()) {
            return null;
        }
        String string = pSDSBookingLog.getRestoreInfo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RestoreInfo_Default(pSDSBookingLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RESTOREINFO");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RestoreState(boolean bl, PSDSBookingLog pSDSBookingLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDSBookingLog.isRestoreStateDirty() && !bl2 : !pSDSBookingLog.isRestoreStateDirty()) {
            return null;
        }
        Integer n = pSDSBookingLog.getRestoreState();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RESTORESTATE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_RestoreState_Default(pSDSBookingLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RESTORESTATE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDSBookingLog pSDSBookingLog, boolean bl) throws Exception {
        super.onSyncEntity(pSDSBookingLog, bl);
    }

    protected void onSyncIndexEntities(PSDSBookingLog pSDSBookingLog, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDSBookingLog, bl);
    }

    public Object getDataContextValue(PSDSBookingLog pSDSBookingLog, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDSBookingLog, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDSBookingLog pSDSBookingLog, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDSBookingLog, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"BACKUPINFO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BackupInfo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BACKUPSTATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BackupState_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BEGINTIME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BeginTime_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BOOKINGINFO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BookingInfo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BOOKINGPARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BookingParam_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BOOKINGPARAM2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BookingParam2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BOOKINGPARAM3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BookingParam3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BOOKINGPARAM4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BookingParam4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BOOKINGSTATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BookingState_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BOOKINGTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BookingType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DURATION", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Duration_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENDTIME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EndTime_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HOURS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Hours_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGINFO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogInfo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERSERVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterServerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERSERVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterServerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSERVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevServerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSERVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevServerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDSBOOKINGLOGID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDSBookingLogId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDSBOOKINGLOGNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDSBookingLogName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"RESTOREINFO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RestoreInfo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RESTORESTATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RestoreState_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_BackupInfo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BACKUPINFO", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BackupState_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_BeginTime_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_BookingInfo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BOOKINGINFO", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BookingParam_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BOOKINGPARAM", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BookingParam2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BOOKINGPARAM2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BookingParam3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BOOKINGPARAM3", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BookingParam4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BOOKINGPARAM4", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BookingState_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_BookingType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BOOKINGTYPE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
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

    protected String onTestValueRule_Duration_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EndTime_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Hours_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_LogInfo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LOGINFO", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
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

    protected String onTestValueRule_PSDevCenterId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevCenterName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevCenterServerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERSERVERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevCenterServerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERSERVERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevServerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSERVERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevServerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSERVERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDSBookingLogId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDSBOOKINGLOGID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDSBookingLogName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDSBOOKINGLOGNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_RestoreInfo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RESTOREINFO", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RestoreState_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected boolean onMergeChild(String string, String string2, PSDSBookingLog pSDSBookingLog) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDSBookingLog)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDSBookingLog pSDSBookingLog) throws Exception {
        super.onUpdateParent(pSDSBookingLog);
    }

    @Override
    protected void exportCurXmlModel(PSDSBookingLog pSDSBookingLog, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDSBOOKINGLOG");
        if (!bl) {
            pSDSBookingLog.setCreateDate(null);
            pSDSBookingLog.setCreateMan(null);
            pSDSBookingLog.setPSDSBookingLogId(null);
            pSDSBookingLog.setUpdateDate(null);
            pSDSBookingLog.setUpdateMan(null);
            super.exportCurXmlModel(pSDSBookingLog, xmlNode, bl);
        }
    }
}

