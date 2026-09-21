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
import net.ibizsys.pscore.srv.paasmgr.dao.PSCorePrdInstLogDAO;
import net.ibizsys.pscore.srv.paasmgr.demodel.PSCorePrdInstLogDEModel;
import net.ibizsys.pscore.srv.paasmgr.entity.PSCorePrd;
import net.ibizsys.pscore.srv.paasmgr.entity.PSCorePrdBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSCorePrdInstLog;
import net.ibizsys.pscore.srv.paasmgr.entity.PSCorePrdVer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSCorePrdVerBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSStudioServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSStudioServerBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSTaskServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSTaskServerBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSCorePrdInstLogServiceBase
extends PSCoreSysServiceBase<PSCorePrdInstLog> {
    private static final Log log = LogFactory.getLog(PSCorePrdInstLogServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSCorePrdInstLogDEModel pSCorePrdInstLogDEModel;
    private PSCorePrdInstLogDAO pSCorePrdInstLogDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.paasmgr.service.PSCorePrdInstLogService";
    }

    public PSCorePrdInstLogDEModel getPSCorePrdInstLogDEModel() {
        if (this.pSCorePrdInstLogDEModel == null) {
            try {
                this.pSCorePrdInstLogDEModel = (PSCorePrdInstLogDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.paasmgr.demodel.PSCorePrdInstLogDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSCorePrdInstLogDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSCorePrdInstLogDEModel();
    }

    public PSCorePrdInstLogDAO getPSCorePrdInstLogDAO() {
        if (this.pSCorePrdInstLogDAO == null) {
            try {
                this.pSCorePrdInstLogDAO = (PSCorePrdInstLogDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.paasmgr.dao.PSCorePrdInstLogDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSCorePrdInstLogDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSCorePrdInstLogDAO();
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

    protected void onFillParentInfo(PSCorePrdInstLog pSCorePrdInstLog, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSCOREPRDINSTLOG_PSCOREPRDVER_PSCOREPRDVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSCorePrdVerService", (SessionFactory)this.getSessionFactory());
            PSCorePrdVer pSCorePrdVer = (PSCorePrdVer)iService.getDEModel().createEntity();
            pSCorePrdVer.set("PSCOREPRDVERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSCorePrdVer);
            } else {
                iService.get((IEntity)pSCorePrdVer);
            }
            this.onFillParentInfo_PSCorePrdVer(pSCorePrdInstLog, pSCorePrdVer);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSCOREPRDINSTLOG_PSCOREPRD_PSCOREPRDID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSCorePrdService", (SessionFactory)this.getSessionFactory());
            PSCorePrd pSCorePrd = (PSCorePrd)iService.getDEModel().createEntity();
            pSCorePrd.set("PSCOREPRDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSCorePrd);
            } else {
                iService.get((IEntity)pSCorePrd);
            }
            this.onFillParentInfo_PSCorePrd(pSCorePrdInstLog, pSCorePrd);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSCOREPRDINSTLOG_PSSTUDIOSERVER_PSSTUDIOSERVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSStudioServerService", (SessionFactory)this.getSessionFactory());
            PSStudioServer pSStudioServer = (PSStudioServer)iService.getDEModel().createEntity();
            pSStudioServer.set("PSSTUDIOSERVERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSStudioServer);
            } else {
                iService.get((IEntity)pSStudioServer);
            }
            this.onFillParentInfo_PSStudioServer(pSCorePrdInstLog, pSStudioServer);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSCOREPRDINSTLOG_PSTASKSERVER_PSTASKSERVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSTaskServerService", (SessionFactory)this.getSessionFactory());
            PSTaskServer pSTaskServer = (PSTaskServer)iService.getDEModel().createEntity();
            pSTaskServer.set("PSTASKSERVERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSTaskServer);
            } else {
                iService.get((IEntity)pSTaskServer);
            }
            this.onFillParentInfo_PSTaskServer(pSCorePrdInstLog, pSTaskServer);
            return;
        }
        super.onFillParentInfo((IEntity)pSCorePrdInstLog, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSCorePrdVer(PSCorePrdInstLog pSCorePrdInstLog, PSCorePrdVer pSCorePrdVer) throws Exception {
        pSCorePrdInstLog.setPSCorePrdVerId(pSCorePrdVer.getPSCorePrdVerId());
        pSCorePrdInstLog.setPSCorePrdVerName(pSCorePrdVer.getPSCorePrdVerName());
    }

    protected void onFillParentInfo_PSCorePrd(PSCorePrdInstLog pSCorePrdInstLog, PSCorePrd pSCorePrd) throws Exception {
        pSCorePrdInstLog.setPSCorePrdId(pSCorePrd.getPSCorePrdId());
        pSCorePrdInstLog.setPSCorePrdName(pSCorePrd.getPSCorePrdName());
    }

    protected void onFillParentInfo_PSStudioServer(PSCorePrdInstLog pSCorePrdInstLog, PSStudioServer pSStudioServer) throws Exception {
        pSCorePrdInstLog.setPSStudioServerId(pSStudioServer.getPSStudioServerId());
        pSCorePrdInstLog.setPSStudioServerName(pSStudioServer.getPSStudioServerName());
    }

    protected void onFillParentInfo_PSTaskServer(PSCorePrdInstLog pSCorePrdInstLog, PSTaskServer pSTaskServer) throws Exception {
        pSCorePrdInstLog.setPSTaskServerId(pSTaskServer.getPSTaskServerId());
        pSCorePrdInstLog.setPSTaskServerName(pSTaskServer.getPSTaskServerName());
    }

    protected void onFillEntityFullInfo(PSCorePrdInstLog pSCorePrdInstLog, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSCorePrdInstLog, bl);
        this.onFillEntityFullInfo_PSCorePrdVer(pSCorePrdInstLog, bl);
        this.onFillEntityFullInfo_PSCorePrd(pSCorePrdInstLog, bl);
        this.onFillEntityFullInfo_PSStudioServer(pSCorePrdInstLog, bl);
        this.onFillEntityFullInfo_PSTaskServer(pSCorePrdInstLog, bl);
    }

    protected void onFillEntityFullInfo_PSCorePrdVer(PSCorePrdInstLog pSCorePrdInstLog, boolean bl) throws Exception {
        if (pSCorePrdInstLog.isPSCorePrdVerIdDirty()) {
            if (pSCorePrdInstLog.getPSCorePrdVerId() != null) {
                if (pSCorePrdInstLog.getPSCorePrdVerId() == null || pSCorePrdInstLog.getPSCorePrdVerName() == null) {
                    PSCorePrdVer pSCorePrdVer = pSCorePrdInstLog.getPSCorePrdVer();
                    pSCorePrdInstLog.setPSCorePrdVerName(pSCorePrdVer.getPSCorePrdVerName());
                }
            } else {
                pSCorePrdInstLog.setPSCorePrdVerName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSCorePrd(PSCorePrdInstLog pSCorePrdInstLog, boolean bl) throws Exception {
        if (pSCorePrdInstLog.isPSCorePrdIdDirty()) {
            if (pSCorePrdInstLog.getPSCorePrdId() != null) {
                if (pSCorePrdInstLog.getPSCorePrdId() == null || pSCorePrdInstLog.getPSCorePrdName() == null) {
                    PSCorePrd pSCorePrd = pSCorePrdInstLog.getPSCorePrd();
                    pSCorePrdInstLog.setPSCorePrdName(pSCorePrd.getPSCorePrdName());
                }
            } else {
                pSCorePrdInstLog.setPSCorePrdName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSStudioServer(PSCorePrdInstLog pSCorePrdInstLog, boolean bl) throws Exception {
        if (pSCorePrdInstLog.isPSStudioServerIdDirty()) {
            if (pSCorePrdInstLog.getPSStudioServerId() != null) {
                if (pSCorePrdInstLog.getPSStudioServerId() == null || pSCorePrdInstLog.getPSStudioServerName() == null) {
                    PSStudioServer pSStudioServer = pSCorePrdInstLog.getPSStudioServer();
                    pSCorePrdInstLog.setPSStudioServerName(pSStudioServer.getPSStudioServerName());
                }
            } else {
                pSCorePrdInstLog.setPSStudioServerName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSTaskServer(PSCorePrdInstLog pSCorePrdInstLog, boolean bl) throws Exception {
        if (pSCorePrdInstLog.isPSTaskServerIdDirty()) {
            if (pSCorePrdInstLog.getPSTaskServerId() != null) {
                if (pSCorePrdInstLog.getPSTaskServerId() == null || pSCorePrdInstLog.getPSTaskServerName() == null) {
                    PSTaskServer pSTaskServer = pSCorePrdInstLog.getPSTaskServer();
                    pSCorePrdInstLog.setPSTaskServerName(pSTaskServer.getPSTaskServerName());
                }
            } else {
                pSCorePrdInstLog.setPSTaskServerName(null);
            }
        }
    }

    protected void onWriteBackParent(PSCorePrdInstLog pSCorePrdInstLog, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSCorePrdInstLog, bl);
    }

    public ArrayList<PSCorePrdInstLog> selectByPSCorePrdVer(PSCorePrdVerBase pSCorePrdVerBase) throws Exception {
        return this.selectByPSCorePrdVer(pSCorePrdVerBase, "", -1);
    }

    public ArrayList<PSCorePrdInstLog> selectByPSCorePrdVer(PSCorePrdVerBase pSCorePrdVerBase, String string) throws Exception {
        return this.selectByPSCorePrdVer(pSCorePrdVerBase, string, -1);
    }

    public ArrayList<PSCorePrdInstLog> selectByPSCorePrdVer(PSCorePrdVerBase pSCorePrdVerBase, String string, int n) throws Exception {
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

    public ArrayList<PSCorePrdInstLog> selectByPSCorePrd(PSCorePrdBase pSCorePrdBase) throws Exception {
        return this.selectByPSCorePrd(pSCorePrdBase, "", -1);
    }

    public ArrayList<PSCorePrdInstLog> selectByPSCorePrd(PSCorePrdBase pSCorePrdBase, String string) throws Exception {
        return this.selectByPSCorePrd(pSCorePrdBase, string, -1);
    }

    public ArrayList<PSCorePrdInstLog> selectByPSCorePrd(PSCorePrdBase pSCorePrdBase, String string, int n) throws Exception {
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

    public ArrayList<PSCorePrdInstLog> selectByPSStudioServer(PSStudioServerBase pSStudioServerBase) throws Exception {
        return this.selectByPSStudioServer(pSStudioServerBase, "", -1);
    }

    public ArrayList<PSCorePrdInstLog> selectByPSStudioServer(PSStudioServerBase pSStudioServerBase, String string) throws Exception {
        return this.selectByPSStudioServer(pSStudioServerBase, string, -1);
    }

    public ArrayList<PSCorePrdInstLog> selectByPSStudioServer(PSStudioServerBase pSStudioServerBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSTUDIOSERVERID", (Object)pSStudioServerBase.getPSStudioServerId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSStudioServerCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSStudioServerCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSCorePrdInstLog> selectByPSTaskServer(PSTaskServerBase pSTaskServerBase) throws Exception {
        return this.selectByPSTaskServer(pSTaskServerBase, "", -1);
    }

    public ArrayList<PSCorePrdInstLog> selectByPSTaskServer(PSTaskServerBase pSTaskServerBase, String string) throws Exception {
        return this.selectByPSTaskServer(pSTaskServerBase, string, -1);
    }

    public ArrayList<PSCorePrdInstLog> selectByPSTaskServer(PSTaskServerBase pSTaskServerBase, String string, int n) throws Exception {
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

    public void testRemoveByPSCorePrdVer(PSCorePrdVer pSCorePrdVer) throws Exception {
    }

    public void resetPSCorePrdVer(PSCorePrdVer pSCorePrdVer) throws Exception {
        ArrayList<PSCorePrdInstLog> arrayList = this.selectByPSCorePrdVer(pSCorePrdVer);
        for (PSCorePrdInstLog pSCorePrdInstLog : arrayList) {
            PSCorePrdInstLog pSCorePrdInstLog2 = (PSCorePrdInstLog)this.getDEModel().createEntity();
            pSCorePrdInstLog2.setPSCorePrdInstLogId(pSCorePrdInstLog.getPSCorePrdInstLogId());
            pSCorePrdInstLog2.setPSCorePrdVerId(null);
            this.update(pSCorePrdInstLog2);
        }
    }

    public void removeByPSCorePrdVer(PSCorePrdVer pSCorePrdVer) throws Exception {
        final PSCorePrdVer pSCorePrdVer2 = pSCorePrdVer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSCorePrdInstLogServiceBase.this.onBeforeRemoveByPSCorePrdVer(pSCorePrdVer2);
                PSCorePrdInstLogServiceBase.this.internalRemoveByPSCorePrdVer(pSCorePrdVer2);
                PSCorePrdInstLogServiceBase.this.onAfterRemoveByPSCorePrdVer(pSCorePrdVer2);
            }
        });
    }

    protected void onBeforeRemoveByPSCorePrdVer(PSCorePrdVer pSCorePrdVer) throws Exception {
    }

    protected void internalRemoveByPSCorePrdVer(PSCorePrdVer pSCorePrdVer) throws Exception {
        ArrayList<PSCorePrdInstLog> arrayList = this.selectByPSCorePrdVer(pSCorePrdVer);
        this.onBeforeRemoveByPSCorePrdVer(pSCorePrdVer, arrayList);
        for (PSCorePrdInstLog pSCorePrdInstLog : arrayList) {
            this.remove((IEntity)pSCorePrdInstLog);
        }
        this.onAfterRemoveByPSCorePrdVer(pSCorePrdVer, arrayList);
    }

    protected void onAfterRemoveByPSCorePrdVer(PSCorePrdVer pSCorePrdVer) throws Exception {
    }

    protected void onBeforeRemoveByPSCorePrdVer(PSCorePrdVer pSCorePrdVer, ArrayList<PSCorePrdInstLog> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSCorePrdVer(PSCorePrdVer pSCorePrdVer, ArrayList<PSCorePrdInstLog> arrayList) throws Exception {
    }

    public void testRemoveByPSCorePrd(PSCorePrd pSCorePrd) throws Exception {
    }

    public void resetPSCorePrd(PSCorePrd pSCorePrd) throws Exception {
        ArrayList<PSCorePrdInstLog> arrayList = this.selectByPSCorePrd(pSCorePrd);
        for (PSCorePrdInstLog pSCorePrdInstLog : arrayList) {
            PSCorePrdInstLog pSCorePrdInstLog2 = (PSCorePrdInstLog)this.getDEModel().createEntity();
            pSCorePrdInstLog2.setPSCorePrdInstLogId(pSCorePrdInstLog.getPSCorePrdInstLogId());
            pSCorePrdInstLog2.setPSCorePrdId(null);
            this.update(pSCorePrdInstLog2);
        }
    }

    public void removeByPSCorePrd(PSCorePrd pSCorePrd) throws Exception {
        final PSCorePrd pSCorePrd2 = pSCorePrd;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSCorePrdInstLogServiceBase.this.onBeforeRemoveByPSCorePrd(pSCorePrd2);
                PSCorePrdInstLogServiceBase.this.internalRemoveByPSCorePrd(pSCorePrd2);
                PSCorePrdInstLogServiceBase.this.onAfterRemoveByPSCorePrd(pSCorePrd2);
            }
        });
    }

    protected void onBeforeRemoveByPSCorePrd(PSCorePrd pSCorePrd) throws Exception {
    }

    protected void internalRemoveByPSCorePrd(PSCorePrd pSCorePrd) throws Exception {
        ArrayList<PSCorePrdInstLog> arrayList = this.selectByPSCorePrd(pSCorePrd);
        this.onBeforeRemoveByPSCorePrd(pSCorePrd, arrayList);
        for (PSCorePrdInstLog pSCorePrdInstLog : arrayList) {
            this.remove((IEntity)pSCorePrdInstLog);
        }
        this.onAfterRemoveByPSCorePrd(pSCorePrd, arrayList);
    }

    protected void onAfterRemoveByPSCorePrd(PSCorePrd pSCorePrd) throws Exception {
    }

    protected void onBeforeRemoveByPSCorePrd(PSCorePrd pSCorePrd, ArrayList<PSCorePrdInstLog> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSCorePrd(PSCorePrd pSCorePrd, ArrayList<PSCorePrdInstLog> arrayList) throws Exception {
    }

    public void testRemoveByPSStudioServer(PSStudioServer pSStudioServer) throws Exception {
    }

    public void resetPSStudioServer(PSStudioServer pSStudioServer) throws Exception {
        ArrayList<PSCorePrdInstLog> arrayList = this.selectByPSStudioServer(pSStudioServer);
        for (PSCorePrdInstLog pSCorePrdInstLog : arrayList) {
            PSCorePrdInstLog pSCorePrdInstLog2 = (PSCorePrdInstLog)this.getDEModel().createEntity();
            pSCorePrdInstLog2.setPSCorePrdInstLogId(pSCorePrdInstLog.getPSCorePrdInstLogId());
            pSCorePrdInstLog2.setPSStudioServerId(null);
            this.update(pSCorePrdInstLog2);
        }
    }

    public void removeByPSStudioServer(PSStudioServer pSStudioServer) throws Exception {
        final PSStudioServer pSStudioServer2 = pSStudioServer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSCorePrdInstLogServiceBase.this.onBeforeRemoveByPSStudioServer(pSStudioServer2);
                PSCorePrdInstLogServiceBase.this.internalRemoveByPSStudioServer(pSStudioServer2);
                PSCorePrdInstLogServiceBase.this.onAfterRemoveByPSStudioServer(pSStudioServer2);
            }
        });
    }

    protected void onBeforeRemoveByPSStudioServer(PSStudioServer pSStudioServer) throws Exception {
    }

    protected void internalRemoveByPSStudioServer(PSStudioServer pSStudioServer) throws Exception {
        ArrayList<PSCorePrdInstLog> arrayList = this.selectByPSStudioServer(pSStudioServer);
        this.onBeforeRemoveByPSStudioServer(pSStudioServer, arrayList);
        for (PSCorePrdInstLog pSCorePrdInstLog : arrayList) {
            this.remove((IEntity)pSCorePrdInstLog);
        }
        this.onAfterRemoveByPSStudioServer(pSStudioServer, arrayList);
    }

    protected void onAfterRemoveByPSStudioServer(PSStudioServer pSStudioServer) throws Exception {
    }

    protected void onBeforeRemoveByPSStudioServer(PSStudioServer pSStudioServer, ArrayList<PSCorePrdInstLog> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSStudioServer(PSStudioServer pSStudioServer, ArrayList<PSCorePrdInstLog> arrayList) throws Exception {
    }

    public void testRemoveByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
    }

    public void resetPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
        ArrayList<PSCorePrdInstLog> arrayList = this.selectByPSTaskServer(pSTaskServer);
        for (PSCorePrdInstLog pSCorePrdInstLog : arrayList) {
            PSCorePrdInstLog pSCorePrdInstLog2 = (PSCorePrdInstLog)this.getDEModel().createEntity();
            pSCorePrdInstLog2.setPSCorePrdInstLogId(pSCorePrdInstLog.getPSCorePrdInstLogId());
            pSCorePrdInstLog2.setPSTaskServerId(null);
            this.update(pSCorePrdInstLog2);
        }
    }

    public void removeByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
        final PSTaskServer pSTaskServer2 = pSTaskServer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSCorePrdInstLogServiceBase.this.onBeforeRemoveByPSTaskServer(pSTaskServer2);
                PSCorePrdInstLogServiceBase.this.internalRemoveByPSTaskServer(pSTaskServer2);
                PSCorePrdInstLogServiceBase.this.onAfterRemoveByPSTaskServer(pSTaskServer2);
            }
        });
    }

    protected void onBeforeRemoveByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
    }

    protected void internalRemoveByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
        ArrayList<PSCorePrdInstLog> arrayList = this.selectByPSTaskServer(pSTaskServer);
        this.onBeforeRemoveByPSTaskServer(pSTaskServer, arrayList);
        for (PSCorePrdInstLog pSCorePrdInstLog : arrayList) {
            this.remove((IEntity)pSCorePrdInstLog);
        }
        this.onAfterRemoveByPSTaskServer(pSTaskServer, arrayList);
    }

    protected void onAfterRemoveByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
    }

    protected void onBeforeRemoveByPSTaskServer(PSTaskServer pSTaskServer, ArrayList<PSCorePrdInstLog> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSTaskServer(PSTaskServer pSTaskServer, ArrayList<PSCorePrdInstLog> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSCorePrdInstLog pSCorePrdInstLog) throws Exception {
        super.onBeforeRemove(pSCorePrdInstLog);
    }

    protected void replaceParentInfo(PSCorePrdInstLog pSCorePrdInstLog, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSCorePrdInstLog, cloneSession);
        if (pSCorePrdInstLog.getPSCorePrdVerId() != null && (iEntity = cloneSession.getEntity("PSCOREPRDVER", (Object)pSCorePrdInstLog.getPSCorePrdVerId())) != null) {
            this.onFillParentInfo_PSCorePrdVer(pSCorePrdInstLog, (PSCorePrdVer)iEntity);
        }
        if (pSCorePrdInstLog.getPSCorePrdId() != null && (iEntity = cloneSession.getEntity("PSCOREPRD", (Object)pSCorePrdInstLog.getPSCorePrdId())) != null) {
            this.onFillParentInfo_PSCorePrd(pSCorePrdInstLog, (PSCorePrd)iEntity);
        }
        if (pSCorePrdInstLog.getPSStudioServerId() != null && (iEntity = cloneSession.getEntity("PSSTUDIOSERVER", (Object)pSCorePrdInstLog.getPSStudioServerId())) != null) {
            this.onFillParentInfo_PSStudioServer(pSCorePrdInstLog, (PSStudioServer)iEntity);
        }
        if (pSCorePrdInstLog.getPSTaskServerId() != null && (iEntity = cloneSession.getEntity("PSTASKSERVER", (Object)pSCorePrdInstLog.getPSTaskServerId())) != null) {
            this.onFillParentInfo_PSTaskServer(pSCorePrdInstLog, (PSTaskServer)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSCorePrdInstLog pSCorePrdInstLog, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSCorePrdInstLog, bl);
    }

    protected void onCheckEntity(boolean bl, PSCorePrdInstLog pSCorePrdInstLog, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_BeginTime(bl, pSCorePrdInstLog, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EndTime(bl, pSCorePrdInstLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_InstState(bl, pSCorePrdInstLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCorePrdId(bl, pSCorePrdInstLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCorePrdInstLogId(bl, pSCorePrdInstLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCorePrdInstLogName(bl, pSCorePrdInstLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCorePrdName(bl, pSCorePrdInstLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCorePrdVerId(bl, pSCorePrdInstLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCorePrdVerName(bl, pSCorePrdInstLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSStudioServerId(bl, pSCorePrdInstLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSStudioServerName(bl, pSCorePrdInstLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSTaskServerId(bl, pSCorePrdInstLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSTaskServerName(bl, pSCorePrdInstLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ResultInfo(bl, pSCorePrdInstLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ResultInfo2(bl, pSCorePrdInstLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ResultInfo3(bl, pSCorePrdInstLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ResultInfo4(bl, pSCorePrdInstLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSCorePrdInstLog, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_BeginTime(boolean bl, PSCorePrdInstLog pSCorePrdInstLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrdInstLog.isBeginTimeDirty() : !pSCorePrdInstLog.isBeginTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSCorePrdInstLog.getBeginTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_BeginTime_Default((IEntity)pSCorePrdInstLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_EndTime(boolean bl, PSCorePrdInstLog pSCorePrdInstLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrdInstLog.isEndTimeDirty() : !pSCorePrdInstLog.isEndTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSCorePrdInstLog.getEndTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EndTime_Default((IEntity)pSCorePrdInstLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_InstState(boolean bl, PSCorePrdInstLog pSCorePrdInstLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrdInstLog.isInstStateDirty() && !bl2 : !pSCorePrdInstLog.isInstStateDirty()) {
            return null;
        }
        Integer n = pSCorePrdInstLog.getInstState();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INSTSTATE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_InstState_Default((IEntity)pSCorePrdInstLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INSTSTATE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCorePrdId(boolean bl, PSCorePrdInstLog pSCorePrdInstLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrdInstLog.isPSCorePrdIdDirty() : !pSCorePrdInstLog.isPSCorePrdIdDirty()) {
            return null;
        }
        String string = pSCorePrdInstLog.getPSCorePrdId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCorePrdId_Default((IEntity)pSCorePrdInstLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSCorePrdInstLogId(boolean bl, PSCorePrdInstLog pSCorePrdInstLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrdInstLog.isPSCorePrdInstLogIdDirty() && !bl2 : !pSCorePrdInstLog.isPSCorePrdInstLogIdDirty()) {
            return null;
        }
        String string = pSCorePrdInstLog.getPSCorePrdInstLogId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCOREPRDINSTLOGID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCorePrdInstLogId_Default((IEntity)pSCorePrdInstLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCOREPRDINSTLOGID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCorePrdInstLogName(boolean bl, PSCorePrdInstLog pSCorePrdInstLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrdInstLog.isPSCorePrdInstLogNameDirty() && !bl2 : !pSCorePrdInstLog.isPSCorePrdInstLogNameDirty()) {
            return null;
        }
        String string = pSCorePrdInstLog.getPSCorePrdInstLogName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCOREPRDINSTLOGNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCorePrdInstLogName_Default((IEntity)pSCorePrdInstLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCOREPRDINSTLOGNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCorePrdName(boolean bl, PSCorePrdInstLog pSCorePrdInstLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrdInstLog.isPSCorePrdNameDirty() : !pSCorePrdInstLog.isPSCorePrdNameDirty()) {
            return null;
        }
        String string = pSCorePrdInstLog.getPSCorePrdName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCorePrdName_Default((IEntity)pSCorePrdInstLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSCorePrdVerId(boolean bl, PSCorePrdInstLog pSCorePrdInstLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrdInstLog.isPSCorePrdVerIdDirty() : !pSCorePrdInstLog.isPSCorePrdVerIdDirty()) {
            return null;
        }
        String string = pSCorePrdInstLog.getPSCorePrdVerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCorePrdVerId_Default((IEntity)pSCorePrdInstLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSCorePrdVerName(boolean bl, PSCorePrdInstLog pSCorePrdInstLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrdInstLog.isPSCorePrdVerNameDirty() : !pSCorePrdInstLog.isPSCorePrdVerNameDirty()) {
            return null;
        }
        String string = pSCorePrdInstLog.getPSCorePrdVerName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCorePrdVerName_Default((IEntity)pSCorePrdInstLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSStudioServerId(boolean bl, PSCorePrdInstLog pSCorePrdInstLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrdInstLog.isPSStudioServerIdDirty() : !pSCorePrdInstLog.isPSStudioServerIdDirty()) {
            return null;
        }
        String string = pSCorePrdInstLog.getPSStudioServerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSStudioServerId_Default((IEntity)pSCorePrdInstLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSTUDIOSERVERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSStudioServerName(boolean bl, PSCorePrdInstLog pSCorePrdInstLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrdInstLog.isPSStudioServerNameDirty() : !pSCorePrdInstLog.isPSStudioServerNameDirty()) {
            return null;
        }
        String string = pSCorePrdInstLog.getPSStudioServerName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSStudioServerName_Default((IEntity)pSCorePrdInstLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSTUDIOSERVERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSTaskServerId(boolean bl, PSCorePrdInstLog pSCorePrdInstLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrdInstLog.isPSTaskServerIdDirty() : !pSCorePrdInstLog.isPSTaskServerIdDirty()) {
            return null;
        }
        String string = pSCorePrdInstLog.getPSTaskServerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSTaskServerId_Default((IEntity)pSCorePrdInstLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSTaskServerName(boolean bl, PSCorePrdInstLog pSCorePrdInstLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrdInstLog.isPSTaskServerNameDirty() : !pSCorePrdInstLog.isPSTaskServerNameDirty()) {
            return null;
        }
        String string = pSCorePrdInstLog.getPSTaskServerName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSTaskServerName_Default((IEntity)pSCorePrdInstLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_ResultInfo(boolean bl, PSCorePrdInstLog pSCorePrdInstLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrdInstLog.isResultInfoDirty() : !pSCorePrdInstLog.isResultInfoDirty()) {
            return null;
        }
        String string = pSCorePrdInstLog.getResultInfo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ResultInfo_Default((IEntity)pSCorePrdInstLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RESULTINFO");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ResultInfo2(boolean bl, PSCorePrdInstLog pSCorePrdInstLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrdInstLog.isResultInfo2Dirty() : !pSCorePrdInstLog.isResultInfo2Dirty()) {
            return null;
        }
        String string = pSCorePrdInstLog.getResultInfo2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ResultInfo2_Default((IEntity)pSCorePrdInstLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RESULTINFO2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ResultInfo3(boolean bl, PSCorePrdInstLog pSCorePrdInstLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrdInstLog.isResultInfo3Dirty() : !pSCorePrdInstLog.isResultInfo3Dirty()) {
            return null;
        }
        String string = pSCorePrdInstLog.getResultInfo3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ResultInfo3_Default((IEntity)pSCorePrdInstLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RESULTINFO3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ResultInfo4(boolean bl, PSCorePrdInstLog pSCorePrdInstLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrdInstLog.isResultInfo4Dirty() : !pSCorePrdInstLog.isResultInfo4Dirty()) {
            return null;
        }
        String string = pSCorePrdInstLog.getResultInfo4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ResultInfo4_Default((IEntity)pSCorePrdInstLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RESULTINFO4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSCorePrdInstLog pSCorePrdInstLog, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSCorePrdInstLog, bl);
    }

    protected void onSyncIndexEntities(PSCorePrdInstLog pSCorePrdInstLog, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSCorePrdInstLog, bl);
    }

    public Object getDataContextValue(PSCorePrdInstLog pSCorePrdInstLog, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSCorePrdInstLog, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSCorePrdInstLog pSCorePrdInstLog, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSCorePrdInstLog, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"BEGINTIME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BeginTime_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENDTIME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EndTime_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INSTSTATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_InstState_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCOREPRDID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCorePrdId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCOREPRDINSTLOGID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCorePrdInstLogId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCOREPRDINSTLOGNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCorePrdInstLogName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSSTUDIOSERVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSStudioServerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSTUDIOSERVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSStudioServerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSTASKSERVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSTaskServerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSTASKSERVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSTaskServerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RESULTINFO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ResultInfo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RESULTINFO2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ResultInfo2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RESULTINFO3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ResultInfo3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RESULTINFO4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ResultInfo4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_BeginTime_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_EndTime_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_InstState_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_PSCorePrdInstLogId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCOREPRDINSTLOGID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCorePrdInstLogName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCOREPRDINSTLOGNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_PSStudioServerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSTUDIOSERVERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSStudioServerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSTUDIOSERVERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_ResultInfo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RESULTINFO", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ResultInfo2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RESULTINFO2", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ResultInfo3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RESULTINFO3", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ResultInfo4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RESULTINFO4", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
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

    protected boolean onMergeChild(String string, String string2, PSCorePrdInstLog pSCorePrdInstLog) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSCorePrdInstLog)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSCorePrdInstLog pSCorePrdInstLog) throws Exception {
        super.onUpdateParent((IEntity)pSCorePrdInstLog);
    }

    @Override
    protected void exportCurXmlModel(PSCorePrdInstLog pSCorePrdInstLog, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSCOREPRDINSTLOG");
        if (!bl) {
            pSCorePrdInstLog.setCreateDate(null);
            pSCorePrdInstLog.setCreateMan(null);
            pSCorePrdInstLog.setPSCorePrdInstLogId(null);
            pSCorePrdInstLog.setUpdateDate(null);
            pSCorePrdInstLog.setUpdateMan(null);
            super.exportCurXmlModel(pSCorePrdInstLog, xmlNode, bl);
        }
    }
}

