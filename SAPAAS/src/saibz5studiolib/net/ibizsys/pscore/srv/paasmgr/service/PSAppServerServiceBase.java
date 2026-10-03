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
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterASService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterASServiceBase;
import net.ibizsys.pscore.srv.paasmgr.dao.PSAppServerDAO;
import net.ibizsys.pscore.srv.paasmgr.demodel.PSAppServerDEModel;
import net.ibizsys.pscore.srv.paasmgr.entity.PSAppServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSROSServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSROSServerBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSvrDomain;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSvrDomainBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSvrServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSvrServerBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSTaskServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSTaskServerBase;
import net.ibizsys.pscore.srv.paasmgr.service.PSASBookingService;
import net.ibizsys.pscore.srv.paasmgr.service.PSASBookingServiceBase;
import net.ibizsys.pscore.srv.paasmgr.service.PSDBServerService;
import net.ibizsys.pscore.srv.paasmgr.service.PSDBServerServiceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSAppServerServiceBase
extends PSCoreSysServiceBase<PSAppServer> {
    private static final Log log = LogFactory.getLog(PSAppServerServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSAppServerDEModel pSAppServerDEModel;
    private PSAppServerDAO pSAppServerDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.paasmgr.service.PSAppServerService";
    }

    public PSAppServerDEModel getPSAppServerDEModel() {
        if (this.pSAppServerDEModel == null) {
            try {
                this.pSAppServerDEModel = (PSAppServerDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.paasmgr.demodel.PSAppServerDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSAppServerDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSAppServerDEModel();
    }

    public PSAppServerDAO getPSAppServerDAO() {
        if (this.pSAppServerDAO == null) {
            try {
                this.pSAppServerDAO = (PSAppServerDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.paasmgr.dao.PSAppServerDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSAppServerDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSAppServerDAO();
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

    protected void onFillParentInfo(PSAppServer pSAppServer, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPSERVER_PSROSSERVER_PSROSSERVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSROSServerService", (SessionFactory)this.getSessionFactory());
            PSROSServer pSROSServer = (PSROSServer)iService.getDEModel().createEntity();
            pSROSServer.set("PSROSSERVERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSROSServer);
            } else {
                iService.get(pSROSServer);
            }
            this.onFillParentInfo_PSROSServer(pSAppServer, pSROSServer);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPSERVER_PSSVRDOMAIN_PSSVRDOMAINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSSvrDomainService", (SessionFactory)this.getSessionFactory());
            PSSvrDomain pSSvrDomain = (PSSvrDomain)iService.getDEModel().createEntity();
            pSSvrDomain.set("PSSVRDOMAINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSvrDomain);
            } else {
                iService.get(pSSvrDomain);
            }
            this.onFillParentInfo_PSSvrDomain(pSAppServer, pSSvrDomain);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPSERVER_PSSVRSERVER_PSSVRSERVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSSvrServerService", (SessionFactory)this.getSessionFactory());
            PSSvrServer pSSvrServer = (PSSvrServer)iService.getDEModel().createEntity();
            pSSvrServer.set("PSSVRSERVERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSvrServer);
            } else {
                iService.get(pSSvrServer);
            }
            this.onFillParentInfo_PSSvrServer(pSAppServer, pSSvrServer);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPSERVER_PSTASKSERVER_PSTASKSERVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSTaskServerService", (SessionFactory)this.getSessionFactory());
            PSTaskServer pSTaskServer = (PSTaskServer)iService.getDEModel().createEntity();
            pSTaskServer.set("PSTASKSERVERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSTaskServer);
            } else {
                iService.get(pSTaskServer);
            }
            this.onFillParentInfo_PSTaskServer(pSAppServer, pSTaskServer);
            return;
        }
        super.onFillParentInfo(pSAppServer, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSROSServer(PSAppServer pSAppServer, PSROSServer pSROSServer) throws Exception {
        pSAppServer.setPSROSServerId(pSROSServer.getPSROSServerId());
        pSAppServer.setPSROSServerName(pSROSServer.getPSROSServerName());
    }

    protected void onFillParentInfo_PSSvrDomain(PSAppServer pSAppServer, PSSvrDomain pSSvrDomain) throws Exception {
        pSAppServer.setPSSvrDomainId(pSSvrDomain.getPSSvrDomainId());
        pSAppServer.setPSSvrDomainName(pSSvrDomain.getPSSvrDomainName());
    }

    protected void onFillParentInfo_PSSvrServer(PSAppServer pSAppServer, PSSvrServer pSSvrServer) throws Exception {
        pSAppServer.setPSSvrServerId(pSSvrServer.getPSSvrServerId());
        pSAppServer.setPSSvrServerName(pSSvrServer.getPSSvrServerName());
    }

    protected void onFillParentInfo_PSTaskServer(PSAppServer pSAppServer, PSTaskServer pSTaskServer) throws Exception {
        pSAppServer.setPSTaskServerId(pSTaskServer.getPSTaskServerId());
        pSAppServer.setPSTaskServerName(pSTaskServer.getPSTaskServerName());
    }

    protected void onFillEntityFullInfo(PSAppServer pSAppServer, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSAppServer, bl);
        this.onFillEntityFullInfo_PSROSServer(pSAppServer, bl);
        this.onFillEntityFullInfo_PSSvrDomain(pSAppServer, bl);
        this.onFillEntityFullInfo_PSSvrServer(pSAppServer, bl);
        this.onFillEntityFullInfo_PSTaskServer(pSAppServer, bl);
    }

    protected void onFillEntityFullInfo_PSROSServer(PSAppServer pSAppServer, boolean bl) throws Exception {
        if (pSAppServer.isPSROSServerIdDirty()) {
            if (pSAppServer.getPSROSServerId() != null) {
                if (pSAppServer.getPSROSServerId() == null || pSAppServer.getPSROSServerName() == null) {
                    PSROSServer pSROSServer = pSAppServer.getPSROSServer();
                    pSAppServer.setPSROSServerName(pSROSServer.getPSROSServerName());
                }
            } else {
                pSAppServer.setPSROSServerName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSvrDomain(PSAppServer pSAppServer, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSvrServer(PSAppServer pSAppServer, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSTaskServer(PSAppServer pSAppServer, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSAppServer pSAppServer, boolean bl) throws Exception {
        super.onWriteBackParent(pSAppServer, bl);
    }

    public ArrayList<PSAppServer> selectByPSROSServer(PSROSServerBase pSROSServerBase) throws Exception {
        return this.selectByPSROSServer(pSROSServerBase, "", -1);
    }

    public ArrayList<PSAppServer> selectByPSROSServer(PSROSServerBase pSROSServerBase, String string) throws Exception {
        return this.selectByPSROSServer(pSROSServerBase, string, -1);
    }

    public ArrayList<PSAppServer> selectByPSROSServer(PSROSServerBase pSROSServerBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSROSSERVERID", (Object)pSROSServerBase.getPSROSServerId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSROSServerCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSROSServerCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSAppServer> selectByPSSvrDomain(PSSvrDomainBase pSSvrDomainBase) throws Exception {
        return this.selectByPSSvrDomain(pSSvrDomainBase, "", -1);
    }

    public ArrayList<PSAppServer> selectByPSSvrDomain(PSSvrDomainBase pSSvrDomainBase, String string) throws Exception {
        return this.selectByPSSvrDomain(pSSvrDomainBase, string, -1);
    }

    public ArrayList<PSAppServer> selectByPSSvrDomain(PSSvrDomainBase pSSvrDomainBase, String string, int n) throws Exception {
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

    public ArrayList<PSAppServer> selectByPSSvrServer(PSSvrServerBase pSSvrServerBase) throws Exception {
        return this.selectByPSSvrServer(pSSvrServerBase, "", -1);
    }

    public ArrayList<PSAppServer> selectByPSSvrServer(PSSvrServerBase pSSvrServerBase, String string) throws Exception {
        return this.selectByPSSvrServer(pSSvrServerBase, string, -1);
    }

    public ArrayList<PSAppServer> selectByPSSvrServer(PSSvrServerBase pSSvrServerBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSVRSERVERID", (Object)pSSvrServerBase.getPSSvrServerId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSvrServerCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSvrServerCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSAppServer> selectByPSTaskServer(PSTaskServerBase pSTaskServerBase) throws Exception {
        return this.selectByPSTaskServer(pSTaskServerBase, "", -1);
    }

    public ArrayList<PSAppServer> selectByPSTaskServer(PSTaskServerBase pSTaskServerBase, String string) throws Exception {
        return this.selectByPSTaskServer(pSTaskServerBase, string, -1);
    }

    public ArrayList<PSAppServer> selectByPSTaskServer(PSTaskServerBase pSTaskServerBase, String string, int n) throws Exception {
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

    public void testRemoveByPSROSServer(PSROSServer pSROSServer) throws Exception {
        ArrayList<PSAppServer> arrayList = this.selectByPSROSServer(pSROSServer, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSROSSERVER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSROSServer);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPSERVER_PSROSSERVER_PSROSSERVERID", "", iDataEntityModel.getName(), "PSAPPSERVER", iDataEntityModel.getDataInfo(pSROSServer), arrayList.get(0)));
        }
    }

    public void resetPSROSServer(PSROSServer pSROSServer) throws Exception {
        ArrayList<PSAppServer> arrayList = this.selectByPSROSServer(pSROSServer);
        for (PSAppServer pSAppServer : arrayList) {
            PSAppServer pSAppServer2 = (PSAppServer)this.getDEModel().createEntity();
            pSAppServer2.setPSAppServerId(pSAppServer.getPSAppServerId());
            pSAppServer2.setPSROSServerId(null);
            this.update(pSAppServer2);
        }
    }

    public void removeByPSROSServer(PSROSServer pSROSServer) throws Exception {
        final PSROSServer pSROSServer2 = pSROSServer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppServerServiceBase.this.onBeforeRemoveByPSROSServer(pSROSServer2);
                PSAppServerServiceBase.this.internalRemoveByPSROSServer(pSROSServer2);
                PSAppServerServiceBase.this.onAfterRemoveByPSROSServer(pSROSServer2);
            }
        });
    }

    protected void onBeforeRemoveByPSROSServer(PSROSServer pSROSServer) throws Exception {
    }

    protected void internalRemoveByPSROSServer(PSROSServer pSROSServer) throws Exception {
        ArrayList<PSAppServer> arrayList = this.selectByPSROSServer(pSROSServer);
        this.onBeforeRemoveByPSROSServer(pSROSServer, arrayList);
        for (PSAppServer pSAppServer : arrayList) {
            this.remove(pSAppServer);
        }
        this.onAfterRemoveByPSROSServer(pSROSServer, arrayList);
    }

    protected void onAfterRemoveByPSROSServer(PSROSServer pSROSServer) throws Exception {
    }

    protected void onBeforeRemoveByPSROSServer(PSROSServer pSROSServer, ArrayList<PSAppServer> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSROSServer(PSROSServer pSROSServer, ArrayList<PSAppServer> arrayList) throws Exception {
    }

    public void testRemoveByPSSvrDomain(PSSvrDomain pSSvrDomain) throws Exception {
        ArrayList<PSAppServer> arrayList = this.selectByPSSvrDomain(pSSvrDomain, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSVRDOMAIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSvrDomain);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPSERVER_PSSVRDOMAIN_PSSVRDOMAINID", "", iDataEntityModel.getName(), "PSAPPSERVER", iDataEntityModel.getDataInfo(pSSvrDomain), arrayList.get(0)));
        }
    }

    public void resetPSSvrDomain(PSSvrDomain pSSvrDomain) throws Exception {
        ArrayList<PSAppServer> arrayList = this.selectByPSSvrDomain(pSSvrDomain);
        for (PSAppServer pSAppServer : arrayList) {
            PSAppServer pSAppServer2 = (PSAppServer)this.getDEModel().createEntity();
            pSAppServer2.setPSAppServerId(pSAppServer.getPSAppServerId());
            pSAppServer2.setPSSvrDomainId(null);
            this.update(pSAppServer2);
        }
    }

    public void removeByPSSvrDomain(PSSvrDomain pSSvrDomain) throws Exception {
        final PSSvrDomain pSSvrDomain2 = pSSvrDomain;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppServerServiceBase.this.onBeforeRemoveByPSSvrDomain(pSSvrDomain2);
                PSAppServerServiceBase.this.internalRemoveByPSSvrDomain(pSSvrDomain2);
                PSAppServerServiceBase.this.onAfterRemoveByPSSvrDomain(pSSvrDomain2);
            }
        });
    }

    protected void onBeforeRemoveByPSSvrDomain(PSSvrDomain pSSvrDomain) throws Exception {
    }

    protected void internalRemoveByPSSvrDomain(PSSvrDomain pSSvrDomain) throws Exception {
        ArrayList<PSAppServer> arrayList = this.selectByPSSvrDomain(pSSvrDomain);
        this.onBeforeRemoveByPSSvrDomain(pSSvrDomain, arrayList);
        for (PSAppServer pSAppServer : arrayList) {
            this.remove(pSAppServer);
        }
        this.onAfterRemoveByPSSvrDomain(pSSvrDomain, arrayList);
    }

    protected void onAfterRemoveByPSSvrDomain(PSSvrDomain pSSvrDomain) throws Exception {
    }

    protected void onBeforeRemoveByPSSvrDomain(PSSvrDomain pSSvrDomain, ArrayList<PSAppServer> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSvrDomain(PSSvrDomain pSSvrDomain, ArrayList<PSAppServer> arrayList) throws Exception {
    }

    public void testRemoveByPSSvrServer(PSSvrServer pSSvrServer) throws Exception {
        ArrayList<PSAppServer> arrayList = this.selectByPSSvrServer(pSSvrServer, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSVRSERVER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSvrServer);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPSERVER_PSSVRSERVER_PSSVRSERVERID", "", iDataEntityModel.getName(), "PSAPPSERVER", iDataEntityModel.getDataInfo(pSSvrServer), arrayList.get(0)));
        }
    }

    public void resetPSSvrServer(PSSvrServer pSSvrServer) throws Exception {
        ArrayList<PSAppServer> arrayList = this.selectByPSSvrServer(pSSvrServer);
        for (PSAppServer pSAppServer : arrayList) {
            PSAppServer pSAppServer2 = (PSAppServer)this.getDEModel().createEntity();
            pSAppServer2.setPSAppServerId(pSAppServer.getPSAppServerId());
            pSAppServer2.setPSSvrServerId(null);
            this.update(pSAppServer2);
        }
    }

    public void removeByPSSvrServer(PSSvrServer pSSvrServer) throws Exception {
        final PSSvrServer pSSvrServer2 = pSSvrServer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppServerServiceBase.this.onBeforeRemoveByPSSvrServer(pSSvrServer2);
                PSAppServerServiceBase.this.internalRemoveByPSSvrServer(pSSvrServer2);
                PSAppServerServiceBase.this.onAfterRemoveByPSSvrServer(pSSvrServer2);
            }
        });
    }

    protected void onBeforeRemoveByPSSvrServer(PSSvrServer pSSvrServer) throws Exception {
    }

    protected void internalRemoveByPSSvrServer(PSSvrServer pSSvrServer) throws Exception {
        ArrayList<PSAppServer> arrayList = this.selectByPSSvrServer(pSSvrServer);
        this.onBeforeRemoveByPSSvrServer(pSSvrServer, arrayList);
        for (PSAppServer pSAppServer : arrayList) {
            this.remove(pSAppServer);
        }
        this.onAfterRemoveByPSSvrServer(pSSvrServer, arrayList);
    }

    protected void onAfterRemoveByPSSvrServer(PSSvrServer pSSvrServer) throws Exception {
    }

    protected void onBeforeRemoveByPSSvrServer(PSSvrServer pSSvrServer, ArrayList<PSAppServer> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSvrServer(PSSvrServer pSSvrServer, ArrayList<PSAppServer> arrayList) throws Exception {
    }

    public void testRemoveByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
        ArrayList<PSAppServer> arrayList = this.selectByPSTaskServer(pSTaskServer, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSTASKSERVER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSTaskServer);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPSERVER_PSTASKSERVER_PSTASKSERVERID", "", iDataEntityModel.getName(), "PSAPPSERVER", iDataEntityModel.getDataInfo(pSTaskServer), arrayList.get(0)));
        }
    }

    public void resetPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
        ArrayList<PSAppServer> arrayList = this.selectByPSTaskServer(pSTaskServer);
        for (PSAppServer pSAppServer : arrayList) {
            PSAppServer pSAppServer2 = (PSAppServer)this.getDEModel().createEntity();
            pSAppServer2.setPSAppServerId(pSAppServer.getPSAppServerId());
            pSAppServer2.setPSTaskServerId(null);
            this.update(pSAppServer2);
        }
    }

    public void removeByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
        final PSTaskServer pSTaskServer2 = pSTaskServer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppServerServiceBase.this.onBeforeRemoveByPSTaskServer(pSTaskServer2);
                PSAppServerServiceBase.this.internalRemoveByPSTaskServer(pSTaskServer2);
                PSAppServerServiceBase.this.onAfterRemoveByPSTaskServer(pSTaskServer2);
            }
        });
    }

    protected void onBeforeRemoveByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
    }

    protected void internalRemoveByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
        ArrayList<PSAppServer> arrayList = this.selectByPSTaskServer(pSTaskServer);
        this.onBeforeRemoveByPSTaskServer(pSTaskServer, arrayList);
        for (PSAppServer pSAppServer : arrayList) {
            this.remove(pSAppServer);
        }
        this.onAfterRemoveByPSTaskServer(pSTaskServer, arrayList);
    }

    protected void onAfterRemoveByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
    }

    protected void onBeforeRemoveByPSTaskServer(PSTaskServer pSTaskServer, ArrayList<PSAppServer> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSTaskServer(PSTaskServer pSTaskServer, ArrayList<PSAppServer> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSAppServer pSAppServer) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSASBookingService)ServiceGlobal.getService(PSASBookingService.class, (SessionFactory)this.getSessionFactory());
        ((PSASBookingServiceBase)pSCoreSysServiceBase).testRemoveByPSAppServer(pSAppServer);
        pSCoreSysServiceBase = (PSDBServerService)ServiceGlobal.getService(PSDBServerService.class, (SessionFactory)this.getSessionFactory());
        ((PSDBServerServiceBase)pSCoreSysServiceBase).testRemoveByPSAppServer(pSAppServer);
        pSCoreSysServiceBase = (PSDevCenterASService)ServiceGlobal.getService(PSDevCenterASService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevCenterASServiceBase)pSCoreSysServiceBase).testRemoveByPSAppServer(pSAppServer);
        super.onBeforeRemove(pSAppServer);
    }

    protected void replaceParentInfo(PSAppServer pSAppServer, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSAppServer, cloneSession);
        if (pSAppServer.getPSROSServerId() != null && (iEntity = cloneSession.getEntity("PSROSSERVER", (Object)pSAppServer.getPSROSServerId())) != null) {
            this.onFillParentInfo_PSROSServer(pSAppServer, (PSROSServer)iEntity);
        }
        if (pSAppServer.getPSSvrDomainId() != null && (iEntity = cloneSession.getEntity("PSSVRDOMAIN", (Object)pSAppServer.getPSSvrDomainId())) != null) {
            this.onFillParentInfo_PSSvrDomain(pSAppServer, (PSSvrDomain)iEntity);
        }
        if (pSAppServer.getPSSvrServerId() != null && (iEntity = cloneSession.getEntity("PSSVRSERVER", (Object)pSAppServer.getPSSvrServerId())) != null) {
            this.onFillParentInfo_PSSvrServer(pSAppServer, (PSSvrServer)iEntity);
        }
        if (pSAppServer.getPSTaskServerId() != null && (iEntity = cloneSession.getEntity("PSTASKSERVER", (Object)pSAppServer.getPSTaskServerId())) != null) {
            this.onFillParentInfo_PSTaskServer(pSAppServer, (PSTaskServer)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSAppServer pSAppServer, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSAppServer, bl);
    }

    protected void onCheckEntity(boolean bl, PSAppServer pSAppServer, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AdminPasswd(bl, pSAppServer, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AdminUserName(bl, pSAppServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AppFolder(bl, pSAppServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ASState(bl, pSAppServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ASType(bl, pSAppServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BeginPort(bl, pSAppServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CfgFolder(bl, pSAppServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EndPort(bl, pSAppServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HttpAddress(bl, pSAppServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HttpPort(bl, pSAppServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HttpsPort(bl, pSAppServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IpAddr(bl, pSAppServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LocalRes(bl, pSAppServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSAppServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Param(bl, pSAppServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Param2(bl, pSAppServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Param3(bl, pSAppServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Param4(bl, pSAppServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Param5(bl, pSAppServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Param6(bl, pSAppServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Param7(bl, pSAppServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Param8(bl, pSAppServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Passwd(bl, pSAppServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppServerId(bl, pSAppServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppServerName(bl, pSAppServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSROSServerId(bl, pSAppServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSROSServerName(bl, pSAppServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSvrDomainId(bl, pSAppServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSvrServerId(bl, pSAppServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSTaskServerId(bl, pSAppServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefInfo(bl, pSAppServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SSHIPAddr(bl, pSAppServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SSHPort(bl, pSAppServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_StartCmd(bl, pSAppServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_StopCmd(bl, pSAppServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TimeShareMode(bl, pSAppServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TimeShareResSpec(bl, pSAppServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TimeShareResType(bl, pSAppServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UploadFileMode(bl, pSAppServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UploadPath(bl, pSAppServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UsageMode(bl, pSAppServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserName(bl, pSAppServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WebConsolePath(bl, pSAppServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSAppServer, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AdminPasswd(boolean bl, PSAppServer pSAppServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppServer.isAdminPasswdDirty() : !pSAppServer.isAdminPasswdDirty()) {
            return null;
        }
        String string = pSAppServer.getAdminPasswd();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AdminPasswd_Default(pSAppServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ADMINPASSWD");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AdminUserName(boolean bl, PSAppServer pSAppServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppServer.isAdminUserNameDirty() : !pSAppServer.isAdminUserNameDirty()) {
            return null;
        }
        String string = pSAppServer.getAdminUserName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AdminUserName_Default(pSAppServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ADMINUSERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AppFolder(boolean bl, PSAppServer pSAppServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppServer.isAppFolderDirty() && !bl2 : !pSAppServer.isAppFolderDirty()) {
            return null;
        }
        String string = pSAppServer.getAppFolder();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("APPFOLDER");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_AppFolder_Default(pSAppServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("APPFOLDER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ASState(boolean bl, PSAppServer pSAppServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppServer.isASStateDirty() && !bl2 : !pSAppServer.isASStateDirty()) {
            return null;
        }
        Integer n = pSAppServer.getASState();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ASSTATE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ASState_Default(pSAppServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ASSTATE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ASType(boolean bl, PSAppServer pSAppServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppServer.isASTypeDirty() && !bl2 : !pSAppServer.isASTypeDirty()) {
            return null;
        }
        String string = pSAppServer.getASType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ASTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_ASType_Default(pSAppServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ASTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BeginPort(boolean bl, PSAppServer pSAppServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppServer.isBeginPortDirty() : !pSAppServer.isBeginPortDirty()) {
            return null;
        }
        Integer n = pSAppServer.getBeginPort();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_BeginPort_Default(pSAppServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BEGINPORT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CfgFolder(boolean bl, PSAppServer pSAppServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppServer.isCfgFolderDirty() : !pSAppServer.isCfgFolderDirty()) {
            return null;
        }
        String string = pSAppServer.getCfgFolder();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CfgFolder_Default(pSAppServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CFGFOLDER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EndPort(boolean bl, PSAppServer pSAppServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppServer.isEndPortDirty() : !pSAppServer.isEndPortDirty()) {
            return null;
        }
        Integer n = pSAppServer.getEndPort();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EndPort_Default(pSAppServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENDPORT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_HttpAddress(boolean bl, PSAppServer pSAppServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppServer.isHttpAddressDirty() : !pSAppServer.isHttpAddressDirty()) {
            return null;
        }
        String string = pSAppServer.getHttpAddress();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_HttpAddress_Default(pSAppServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HTTPADDRESS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_HttpPort(boolean bl, PSAppServer pSAppServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppServer.isHttpPortDirty() && !bl2 : !pSAppServer.isHttpPortDirty()) {
            return null;
        }
        Integer n = pSAppServer.getHttpPort();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HTTPPORT");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_HttpPort_Default(pSAppServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HTTPPORT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_HttpsPort(boolean bl, PSAppServer pSAppServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppServer.isHttpsPortDirty() : !pSAppServer.isHttpsPortDirty()) {
            return null;
        }
        Integer n = pSAppServer.getHttpsPort();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_HttpsPort_Default(pSAppServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HTTPSPORT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IpAddr(boolean bl, PSAppServer pSAppServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppServer.isIpAddrDirty() && !bl2 : !pSAppServer.isIpAddrDirty()) {
            return null;
        }
        String string = pSAppServer.getIpAddr();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("IPADDR");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_IpAddr_Default(pSAppServer, bl2, bl3);
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

    protected EntityFieldError onCheckField_LocalRes(boolean bl, PSAppServer pSAppServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppServer.isLocalResDirty() : !pSAppServer.isLocalResDirty()) {
            return null;
        }
        Integer n = pSAppServer.getLocalRes();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LocalRes_Default(pSAppServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOCALRES");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSAppServer pSAppServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppServer.isMemoDirty() : !pSAppServer.isMemoDirty()) {
            return null;
        }
        String string = pSAppServer.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSAppServer, bl2, bl3);
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

    protected EntityFieldError onCheckField_Param(boolean bl, PSAppServer pSAppServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppServer.isParamDirty() : !pSAppServer.isParamDirty()) {
            return null;
        }
        String string = pSAppServer.getParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Param_Default(pSAppServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Param2(boolean bl, PSAppServer pSAppServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppServer.isParam2Dirty() : !pSAppServer.isParam2Dirty()) {
            return null;
        }
        String string = pSAppServer.getParam2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Param2_Default(pSAppServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAM2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Param3(boolean bl, PSAppServer pSAppServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppServer.isParam3Dirty() : !pSAppServer.isParam3Dirty()) {
            return null;
        }
        String string = pSAppServer.getParam3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Param3_Default(pSAppServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAM3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Param4(boolean bl, PSAppServer pSAppServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppServer.isParam4Dirty() : !pSAppServer.isParam4Dirty()) {
            return null;
        }
        String string = pSAppServer.getParam4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Param4_Default(pSAppServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAM4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Param5(boolean bl, PSAppServer pSAppServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppServer.isParam5Dirty() : !pSAppServer.isParam5Dirty()) {
            return null;
        }
        Integer n = pSAppServer.getParam5();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Param5_Default(pSAppServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAM5");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Param6(boolean bl, PSAppServer pSAppServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppServer.isParam6Dirty() : !pSAppServer.isParam6Dirty()) {
            return null;
        }
        Integer n = pSAppServer.getParam6();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Param6_Default(pSAppServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAM6");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Param7(boolean bl, PSAppServer pSAppServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppServer.isParam7Dirty() : !pSAppServer.isParam7Dirty()) {
            return null;
        }
        Integer n = pSAppServer.getParam7();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Param7_Default(pSAppServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAM7");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Param8(boolean bl, PSAppServer pSAppServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppServer.isParam8Dirty() : !pSAppServer.isParam8Dirty()) {
            return null;
        }
        Integer n = pSAppServer.getParam8();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Param8_Default(pSAppServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAM8");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Passwd(boolean bl, PSAppServer pSAppServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppServer.isPasswdDirty() : !pSAppServer.isPasswdDirty()) {
            return null;
        }
        String string = pSAppServer.getPasswd();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Passwd_Default(pSAppServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PASSWD");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSAppServerId(boolean bl, PSAppServer pSAppServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppServer.isPSAppServerIdDirty() && !bl2 : !pSAppServer.isPSAppServerIdDirty()) {
            return null;
        }
        String string = pSAppServer.getPSAppServerId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPSERVERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppServerId_Default(pSAppServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPSERVERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSAppServerName(boolean bl, PSAppServer pSAppServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppServer.isPSAppServerNameDirty() && !bl2 : !pSAppServer.isPSAppServerNameDirty()) {
            return null;
        }
        String string = pSAppServer.getPSAppServerName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPSERVERNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppServerName_Default(pSAppServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPSERVERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSROSServerId(boolean bl, PSAppServer pSAppServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppServer.isPSROSServerIdDirty() : !pSAppServer.isPSROSServerIdDirty()) {
            return null;
        }
        String string = pSAppServer.getPSROSServerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSROSServerId_Default(pSAppServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSROSSERVERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSROSServerName(boolean bl, PSAppServer pSAppServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppServer.isPSROSServerNameDirty() : !pSAppServer.isPSROSServerNameDirty()) {
            return null;
        }
        String string = pSAppServer.getPSROSServerName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSROSServerName_Default(pSAppServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSROSSERVERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSvrDomainId(boolean bl, PSAppServer pSAppServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppServer.isPSSvrDomainIdDirty() : !pSAppServer.isPSSvrDomainIdDirty()) {
            return null;
        }
        String string = pSAppServer.getPSSvrDomainId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSvrDomainId_Default(pSAppServer, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSvrServerId(boolean bl, PSAppServer pSAppServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppServer.isPSSvrServerIdDirty() : !pSAppServer.isPSSvrServerIdDirty()) {
            return null;
        }
        String string = pSAppServer.getPSSvrServerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSvrServerId_Default(pSAppServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSVRSERVERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSTaskServerId(boolean bl, PSAppServer pSAppServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppServer.isPSTaskServerIdDirty() : !pSAppServer.isPSTaskServerIdDirty()) {
            return null;
        }
        String string = pSAppServer.getPSTaskServerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSTaskServerId_Default(pSAppServer, bl2, bl3);
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

    protected EntityFieldError onCheckField_RefInfo(boolean bl, PSAppServer pSAppServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppServer.isRefInfoDirty() : !pSAppServer.isRefInfoDirty()) {
            return null;
        }
        String string = pSAppServer.getRefInfo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefInfo_Default(pSAppServer, bl2, bl3);
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

    protected EntityFieldError onCheckField_SSHIPAddr(boolean bl, PSAppServer pSAppServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppServer.isSSHIPAddrDirty() : !pSAppServer.isSSHIPAddrDirty()) {
            return null;
        }
        String string = pSAppServer.getSSHIPAddr();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SSHIPAddr_Default(pSAppServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SSHIPADDR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SSHPort(boolean bl, PSAppServer pSAppServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppServer.isSSHPortDirty() : !pSAppServer.isSSHPortDirty()) {
            return null;
        }
        Integer n = pSAppServer.getSSHPort();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SSHPort_Default(pSAppServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SSHPORT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_StartCmd(boolean bl, PSAppServer pSAppServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppServer.isStartCmdDirty() && !bl2 : !pSAppServer.isStartCmdDirty()) {
            return null;
        }
        String string = pSAppServer.getStartCmd();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STARTCMD");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_StartCmd_Default(pSAppServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STARTCMD");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_StopCmd(boolean bl, PSAppServer pSAppServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppServer.isStopCmdDirty() && !bl2 : !pSAppServer.isStopCmdDirty()) {
            return null;
        }
        String string = pSAppServer.getStopCmd();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STOPCMD");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_StopCmd_Default(pSAppServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STOPCMD");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TimeShareMode(boolean bl, PSAppServer pSAppServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppServer.isTimeShareModeDirty() : !pSAppServer.isTimeShareModeDirty()) {
            return null;
        }
        Integer n = pSAppServer.getTimeShareMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_TimeShareMode_Default(pSAppServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TIMESHAREMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TimeShareResSpec(boolean bl, PSAppServer pSAppServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppServer.isTimeShareResSpecDirty() : !pSAppServer.isTimeShareResSpecDirty()) {
            return null;
        }
        String string = pSAppServer.getTimeShareResSpec();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TimeShareResSpec_Default(pSAppServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TIMESHARERESSPEC");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TimeShareResType(boolean bl, PSAppServer pSAppServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppServer.isTimeShareResTypeDirty() : !pSAppServer.isTimeShareResTypeDirty()) {
            return null;
        }
        String string = pSAppServer.getTimeShareResType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TimeShareResType_Default(pSAppServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TIMESHARERESTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UploadFileMode(boolean bl, PSAppServer pSAppServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppServer.isUploadFileModeDirty() : !pSAppServer.isUploadFileModeDirty()) {
            return null;
        }
        String string = pSAppServer.getUploadFileMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UploadFileMode_Default(pSAppServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UPLOADFILEMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UploadPath(boolean bl, PSAppServer pSAppServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppServer.isUploadPathDirty() : !pSAppServer.isUploadPathDirty()) {
            return null;
        }
        String string = pSAppServer.getUploadPath();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UploadPath_Default(pSAppServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UPLOADPATH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UsageMode(boolean bl, PSAppServer pSAppServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppServer.isUsageModeDirty() : !pSAppServer.isUsageModeDirty()) {
            return null;
        }
        String string = pSAppServer.getUsageMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UsageMode_Default(pSAppServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USAGEMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserName(boolean bl, PSAppServer pSAppServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppServer.isUserNameDirty() : !pSAppServer.isUserNameDirty()) {
            return null;
        }
        String string = pSAppServer.getUserName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserName_Default(pSAppServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WebConsolePath(boolean bl, PSAppServer pSAppServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppServer.isWebConsolePathDirty() : !pSAppServer.isWebConsolePathDirty()) {
            return null;
        }
        String string = pSAppServer.getWebConsolePath();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WebConsolePath_Default(pSAppServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WEBCONSOLEPATH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSAppServer pSAppServer, boolean bl) throws Exception {
        super.onSyncEntity(pSAppServer, bl);
    }

    protected void onSyncIndexEntities(PSAppServer pSAppServer, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSAppServer, bl);
    }

    public Object getDataContextValue(PSAppServer pSAppServer, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSAppServer, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSAppServer pSAppServer, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSAppServer, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ADMINPASSWD", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AdminPasswd_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ADMINUSERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AdminUserName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"APPFOLDER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AppFolder_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ASSTATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ASState_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ASTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ASType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BEGINPORT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BeginPort_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CFGFOLDER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CfgFolder_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENDPORT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EndPort_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HTTPADDRESS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HttpAddress_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HTTPPORT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HttpPort_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HTTPSPORT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HttpsPort_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"IPADDR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IpAddr_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOCALRES", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LocalRes_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Param_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARAM2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Param2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARAM3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Param3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARAM4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Param4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARAM5", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Param5_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARAM6", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Param6_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARAM7", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Param7_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARAM8", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Param8_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PASSWD", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Passwd_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPSERVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppServerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPSERVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppServerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSROSSERVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSROSServerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSROSSERVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSROSServerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSVRDOMAINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSvrDomainId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSVRDOMAINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSvrDomainName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSVRSERVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSvrServerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSVRSERVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSvrServerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSTASKSERVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSTaskServerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSTASKSERVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSTaskServerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFINFO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefInfo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SSHIPADDR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SSHIPAddr_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SSHPORT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SSHPort_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STARTCMD", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_StartCmd_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STOPCMD", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_StopCmd_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TIMESHAREMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TimeShareMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TIMESHARERESSPEC", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TimeShareResSpec_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TIMESHARERESTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TimeShareResType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPLOADFILEMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UploadFileMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPLOADPATH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UploadPath_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USAGEMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UsageMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WEBCONSOLEPATH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WebConsolePath_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_AdminPasswd_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ADMINPASSWD", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AdminUserName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ADMINUSERNAME", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AppFolder_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("APPFOLDER", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ASState_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ASType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ASTYPE", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BeginPort_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CfgFolder_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CFGFOLDER", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
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

    protected String onTestValueRule_EndPort_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_HttpAddress_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("HTTPADDRESS", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_HttpPort_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_HttpsPort_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_IpAddr_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("IPADDR", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LocalRes_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_Param_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PARAM", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Param2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PARAM2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Param3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PARAM3", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Param4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PARAM4", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Param5_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Param6_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Param7_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Param8_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Passwd_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PASSWD", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSAppServerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPSERVERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSAppServerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPSERVERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSROSServerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSROSSERVERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSROSServerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSROSSERVERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSvrServerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSVRSERVERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSvrServerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSVRSERVERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_SSHIPAddr_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SSHIPADDR", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SSHPort_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_StartCmd_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("STARTCMD", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_StopCmd_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("STOPCMD", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TimeShareMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_TimeShareResSpec_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TIMESHARERESSPEC", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TimeShareResType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TIMESHARERESTYPE", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
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

    protected String onTestValueRule_UploadFileMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UPLOADFILEMODE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UploadPath_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UPLOADPATH", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UsageMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USAGEMODE", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERNAME", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_WebConsolePath_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WEBCONSOLEPATH", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected boolean onMergeChild(String string, String string2, PSAppServer pSAppServer) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSAppServer)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSAppServer pSAppServer) throws Exception {
        super.onUpdateParent(pSAppServer);
    }

    @Override
    protected void exportCurXmlModel(PSAppServer pSAppServer, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSAPPSERVER");
        if (!bl) {
            pSAppServer.setPSSvrServerName(null);
            pSAppServer.setRefInfo(null);
            super.exportCurXmlModel(pSAppServer, xmlNode, bl);
        }
    }
}

