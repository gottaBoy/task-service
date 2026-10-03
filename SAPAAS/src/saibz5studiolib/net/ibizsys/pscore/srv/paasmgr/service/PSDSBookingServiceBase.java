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
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterServer;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterServerBase;
import net.ibizsys.pscore.srv.paasmgr.dao.PSDSBookingDAO;
import net.ibizsys.pscore.srv.paasmgr.demodel.PSDSBookingDEModel;
import net.ibizsys.pscore.srv.paasmgr.entity.PSDSBooking;
import net.ibizsys.pscore.srv.paasmgr.entity.PSDevServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSDevServerBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSvrDomain;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSvrDomainBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDSBookingServiceBase
extends PSCoreSysServiceBase<PSDSBooking> {
    private static final Log log = LogFactory.getLog(PSDSBookingServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDSBookingDEModel pSDSBookingDEModel;
    private PSDSBookingDAO pSDSBookingDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.paasmgr.service.PSDSBookingService";
    }

    public PSDSBookingDEModel getPSDSBookingDEModel() {
        if (this.pSDSBookingDEModel == null) {
            try {
                this.pSDSBookingDEModel = (PSDSBookingDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.paasmgr.demodel.PSDSBookingDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDSBookingDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDSBookingDEModel();
    }

    public PSDSBookingDAO getPSDSBookingDAO() {
        if (this.pSDSBookingDAO == null) {
            try {
                this.pSDSBookingDAO = (PSDSBookingDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.paasmgr.dao.PSDSBookingDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDSBookingDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDSBookingDAO();
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

    protected void onFillParentInfo(PSDSBooking pSDSBooking, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDSBOOKING_PSDEVCENTERSERVER_PSDEVCENTERSERVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterServerService", (SessionFactory)this.getSessionFactory());
            PSDevCenterServer pSDevCenterServer = (PSDevCenterServer)iService.getDEModel().createEntity();
            pSDevCenterServer.set("PSDEVCENTERSERVERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenterServer);
            } else {
                iService.get(pSDevCenterServer);
            }
            this.onFillParentInfo_PSDevCenterServer(pSDSBooking, pSDevCenterServer);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDSBOOKING_PSDEVCENTER_PSDEVCENTERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService", (SessionFactory)this.getSessionFactory());
            PSDevCenter pSDevCenter = (PSDevCenter)iService.getDEModel().createEntity();
            pSDevCenter.set("PSDEVCENTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenter);
            } else {
                iService.get(pSDevCenter);
            }
            this.onFillParentInfo_PSDevCenter(pSDSBooking, pSDevCenter);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDSBOOKING_PSDEVSERVER_PSDEVSERVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSDevServerService", (SessionFactory)this.getSessionFactory());
            PSDevServer pSDevServer = (PSDevServer)iService.getDEModel().createEntity();
            pSDevServer.set("PSDEVSERVERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevServer);
            } else {
                iService.get(pSDevServer);
            }
            this.onFillParentInfo_PSDevServer(pSDSBooking, pSDevServer);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDSBOOKING_PSSVRDOMAIN_PSSVRDOMAINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSSvrDomainService", (SessionFactory)this.getSessionFactory());
            PSSvrDomain pSSvrDomain = (PSSvrDomain)iService.getDEModel().createEntity();
            pSSvrDomain.set("PSSVRDOMAINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSvrDomain);
            } else {
                iService.get(pSSvrDomain);
            }
            this.onFillParentInfo_Pssvrdomain(pSDSBooking, pSSvrDomain);
            return;
        }
        super.onFillParentInfo(pSDSBooking, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDevCenterServer(PSDSBooking pSDSBooking, PSDevCenterServer pSDevCenterServer) throws Exception {
        pSDSBooking.setPSDevCenterServerId(pSDevCenterServer.getPSDevCenterServerId());
        pSDSBooking.setPSDevCenterServerName(pSDevCenterServer.getPSDevCenterServerName());
    }

    protected void onFillParentInfo_PSDevCenter(PSDSBooking pSDSBooking, PSDevCenter pSDevCenter) throws Exception {
        pSDSBooking.setPSDevCenterId(pSDevCenter.getPSDevCenterId());
        pSDSBooking.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
    }

    protected void onFillParentInfo_PSDevServer(PSDSBooking pSDSBooking, PSDevServer pSDevServer) throws Exception {
        pSDSBooking.setPSDevServerId(pSDevServer.getPSDevServerId());
        pSDSBooking.setPSDevServerName(pSDevServer.getPSDevServerName());
    }

    protected void onFillParentInfo_Pssvrdomain(PSDSBooking pSDSBooking, PSSvrDomain pSSvrDomain) throws Exception {
        pSDSBooking.setPSSvrDomainId(pSSvrDomain.getPSSvrDomainId());
        pSDSBooking.setPSSvrDomainName(pSSvrDomain.getPSSvrDomainName());
    }

    protected void onFillEntityFullInfo(PSDSBooking pSDSBooking, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSDSBooking, bl);
        this.onFillEntityFullInfo_PSDevCenterServer(pSDSBooking, bl);
        this.onFillEntityFullInfo_PSDevCenter(pSDSBooking, bl);
        this.onFillEntityFullInfo_PSDevServer(pSDSBooking, bl);
        this.onFillEntityFullInfo_Pssvrdomain(pSDSBooking, bl);
    }

    protected void onFillEntityFullInfo_PSDevCenterServer(PSDSBooking pSDSBooking, boolean bl) throws Exception {
        if (pSDSBooking.isPSDevCenterServerIdDirty()) {
            if (pSDSBooking.getPSDevCenterServerId() != null) {
                if (pSDSBooking.getPSDevCenterServerId() == null || pSDSBooking.getPSDevCenterServerName() == null) {
                    PSDevCenterServer pSDevCenterServer = pSDSBooking.getPSDevCenterServer();
                    pSDSBooking.setPSDevCenterServerName(pSDevCenterServer.getPSDevCenterServerName());
                }
            } else {
                pSDSBooking.setPSDevCenterServerName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDevCenter(PSDSBooking pSDSBooking, boolean bl) throws Exception {
        if (pSDSBooking.isPSDevCenterIdDirty()) {
            if (pSDSBooking.getPSDevCenterId() != null) {
                if (pSDSBooking.getPSDevCenterId() == null || pSDSBooking.getPSDevCenterName() == null) {
                    PSDevCenter pSDevCenter = pSDSBooking.getPSDevCenter();
                    pSDSBooking.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
                }
            } else {
                pSDSBooking.setPSDevCenterName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDevServer(PSDSBooking pSDSBooking, boolean bl) throws Exception {
        if (pSDSBooking.isPSDevServerIdDirty()) {
            if (pSDSBooking.getPSDevServerId() != null) {
                if (pSDSBooking.getPSDevServerId() == null || pSDSBooking.getPSDevServerName() == null) {
                    PSDevServer pSDevServer = pSDSBooking.getPSDevServer();
                    pSDSBooking.setPSDevServerName(pSDevServer.getPSDevServerName());
                }
            } else {
                pSDSBooking.setPSDevServerName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_Pssvrdomain(PSDSBooking pSDSBooking, boolean bl) throws Exception {
        if (pSDSBooking.isPSSvrDomainIdDirty()) {
            if (pSDSBooking.getPSSvrDomainId() != null) {
                if (pSDSBooking.getPSSvrDomainId() == null || pSDSBooking.getPSSvrDomainName() == null) {
                    PSSvrDomain pSSvrDomain = pSDSBooking.getPssvrdomain();
                    pSDSBooking.setPSSvrDomainName(pSSvrDomain.getPSSvrDomainName());
                }
            } else {
                pSDSBooking.setPSSvrDomainName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDSBooking pSDSBooking, boolean bl) throws Exception {
        super.onWriteBackParent(pSDSBooking, bl);
    }

    public ArrayList<PSDSBooking> selectByPSDevCenterServer(PSDevCenterServerBase pSDevCenterServerBase) throws Exception {
        return this.selectByPSDevCenterServer(pSDevCenterServerBase, "", -1);
    }

    public ArrayList<PSDSBooking> selectByPSDevCenterServer(PSDevCenterServerBase pSDevCenterServerBase, String string) throws Exception {
        return this.selectByPSDevCenterServer(pSDevCenterServerBase, string, -1);
    }

    public ArrayList<PSDSBooking> selectByPSDevCenterServer(PSDevCenterServerBase pSDevCenterServerBase, String string, int n) throws Exception {
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

    public ArrayList<PSDSBooking> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, "", -1);
    }

    public ArrayList<PSDSBooking> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, string, -1);
    }

    public ArrayList<PSDSBooking> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string, int n) throws Exception {
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

    public ArrayList<PSDSBooking> selectByPSDevServer(PSDevServerBase pSDevServerBase) throws Exception {
        return this.selectByPSDevServer(pSDevServerBase, "", -1);
    }

    public ArrayList<PSDSBooking> selectByPSDevServer(PSDevServerBase pSDevServerBase, String string) throws Exception {
        return this.selectByPSDevServer(pSDevServerBase, string, -1);
    }

    public ArrayList<PSDSBooking> selectByPSDevServer(PSDevServerBase pSDevServerBase, String string, int n) throws Exception {
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

    public ArrayList<PSDSBooking> selectByPssvrdomain(PSSvrDomainBase pSSvrDomainBase) throws Exception {
        return this.selectByPssvrdomain(pSSvrDomainBase, "", -1);
    }

    public ArrayList<PSDSBooking> selectByPssvrdomain(PSSvrDomainBase pSSvrDomainBase, String string) throws Exception {
        return this.selectByPssvrdomain(pSSvrDomainBase, string, -1);
    }

    public ArrayList<PSDSBooking> selectByPssvrdomain(PSSvrDomainBase pSSvrDomainBase, String string, int n) throws Exception {
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

    public void testRemoveByPSDevCenterServer(PSDevCenterServer pSDevCenterServer) throws Exception {
        ArrayList<PSDSBooking> arrayList = this.selectByPSDevCenterServer(pSDevCenterServer, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTERSERVER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevCenterServer);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDSBOOKING_PSDEVCENTERSERVER_PSDEVCENTERSERVERID", "", iDataEntityModel.getName(), "PSDSBOOKING", iDataEntityModel.getDataInfo(pSDevCenterServer), arrayList.get(0)));
        }
    }

    public void resetPSDevCenterServer(PSDevCenterServer pSDevCenterServer) throws Exception {
        ArrayList<PSDSBooking> arrayList = this.selectByPSDevCenterServer(pSDevCenterServer);
        for (PSDSBooking pSDSBooking : arrayList) {
            PSDSBooking pSDSBooking2 = (PSDSBooking)this.getDEModel().createEntity();
            pSDSBooking2.setPSDSBookingId(pSDSBooking.getPSDSBookingId());
            pSDSBooking2.setPSDevCenterServerId(null);
            this.update(pSDSBooking2);
        }
    }

    public void removeByPSDevCenterServer(PSDevCenterServer pSDevCenterServer) throws Exception {
        final PSDevCenterServer pSDevCenterServer2 = pSDevCenterServer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDSBookingServiceBase.this.onBeforeRemoveByPSDevCenterServer(pSDevCenterServer2);
                PSDSBookingServiceBase.this.internalRemoveByPSDevCenterServer(pSDevCenterServer2);
                PSDSBookingServiceBase.this.onAfterRemoveByPSDevCenterServer(pSDevCenterServer2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenterServer(PSDevCenterServer pSDevCenterServer) throws Exception {
    }

    protected void internalRemoveByPSDevCenterServer(PSDevCenterServer pSDevCenterServer) throws Exception {
        ArrayList<PSDSBooking> arrayList = this.selectByPSDevCenterServer(pSDevCenterServer);
        this.onBeforeRemoveByPSDevCenterServer(pSDevCenterServer, arrayList);
        for (PSDSBooking pSDSBooking : arrayList) {
            this.remove(pSDSBooking);
        }
        this.onAfterRemoveByPSDevCenterServer(pSDevCenterServer, arrayList);
    }

    protected void onAfterRemoveByPSDevCenterServer(PSDevCenterServer pSDevCenterServer) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenterServer(PSDevCenterServer pSDevCenterServer, ArrayList<PSDSBooking> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenterServer(PSDevCenterServer pSDevCenterServer, ArrayList<PSDSBooking> arrayList) throws Exception {
    }

    public void testRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDSBooking> arrayList = this.selectByPSDevCenter(pSDevCenter, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevCenter);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDSBOOKING_PSDEVCENTER_PSDEVCENTERID", "", iDataEntityModel.getName(), "PSDSBOOKING", iDataEntityModel.getDataInfo(pSDevCenter), arrayList.get(0)));
        }
    }

    public void resetPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDSBooking> arrayList = this.selectByPSDevCenter(pSDevCenter);
        for (PSDSBooking pSDSBooking : arrayList) {
            PSDSBooking pSDSBooking2 = (PSDSBooking)this.getDEModel().createEntity();
            pSDSBooking2.setPSDSBookingId(pSDSBooking.getPSDSBookingId());
            pSDSBooking2.setPSDevCenterId(null);
            this.update(pSDSBooking2);
        }
    }

    public void removeByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        final PSDevCenter pSDevCenter2 = pSDevCenter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDSBookingServiceBase.this.onBeforeRemoveByPSDevCenter(pSDevCenter2);
                PSDSBookingServiceBase.this.internalRemoveByPSDevCenter(pSDevCenter2);
                PSDSBookingServiceBase.this.onAfterRemoveByPSDevCenter(pSDevCenter2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void internalRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDSBooking> arrayList = this.selectByPSDevCenter(pSDevCenter);
        this.onBeforeRemoveByPSDevCenter(pSDevCenter, arrayList);
        for (PSDSBooking pSDSBooking : arrayList) {
            this.remove(pSDSBooking);
        }
        this.onAfterRemoveByPSDevCenter(pSDevCenter, arrayList);
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSDSBooking> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSDSBooking> arrayList) throws Exception {
    }

    public void testRemoveByPSDevServer(PSDevServer pSDevServer) throws Exception {
        ArrayList<PSDSBooking> arrayList = this.selectByPSDevServer(pSDevServer, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVSERVER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevServer);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDSBOOKING_PSDEVSERVER_PSDEVSERVERID", "", iDataEntityModel.getName(), "PSDSBOOKING", iDataEntityModel.getDataInfo(pSDevServer), arrayList.get(0)));
        }
    }

    public void resetPSDevServer(PSDevServer pSDevServer) throws Exception {
        ArrayList<PSDSBooking> arrayList = this.selectByPSDevServer(pSDevServer);
        for (PSDSBooking pSDSBooking : arrayList) {
            PSDSBooking pSDSBooking2 = (PSDSBooking)this.getDEModel().createEntity();
            pSDSBooking2.setPSDSBookingId(pSDSBooking.getPSDSBookingId());
            pSDSBooking2.setPSDevServerId(null);
            this.update(pSDSBooking2);
        }
    }

    public void removeByPSDevServer(PSDevServer pSDevServer) throws Exception {
        final PSDevServer pSDevServer2 = pSDevServer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDSBookingServiceBase.this.onBeforeRemoveByPSDevServer(pSDevServer2);
                PSDSBookingServiceBase.this.internalRemoveByPSDevServer(pSDevServer2);
                PSDSBookingServiceBase.this.onAfterRemoveByPSDevServer(pSDevServer2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevServer(PSDevServer pSDevServer) throws Exception {
    }

    protected void internalRemoveByPSDevServer(PSDevServer pSDevServer) throws Exception {
        ArrayList<PSDSBooking> arrayList = this.selectByPSDevServer(pSDevServer);
        this.onBeforeRemoveByPSDevServer(pSDevServer, arrayList);
        for (PSDSBooking pSDSBooking : arrayList) {
            this.remove(pSDSBooking);
        }
        this.onAfterRemoveByPSDevServer(pSDevServer, arrayList);
    }

    protected void onAfterRemoveByPSDevServer(PSDevServer pSDevServer) throws Exception {
    }

    protected void onBeforeRemoveByPSDevServer(PSDevServer pSDevServer, ArrayList<PSDSBooking> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevServer(PSDevServer pSDevServer, ArrayList<PSDSBooking> arrayList) throws Exception {
    }

    public void testRemoveByPssvrdomain(PSSvrDomain pSSvrDomain) throws Exception {
    }

    public void resetPssvrdomain(PSSvrDomain pSSvrDomain) throws Exception {
        ArrayList<PSDSBooking> arrayList = this.selectByPssvrdomain(pSSvrDomain);
        for (PSDSBooking pSDSBooking : arrayList) {
            PSDSBooking pSDSBooking2 = (PSDSBooking)this.getDEModel().createEntity();
            pSDSBooking2.setPSDSBookingId(pSDSBooking.getPSDSBookingId());
            pSDSBooking2.setPSSvrDomainId(null);
            this.update(pSDSBooking2);
        }
    }

    public void removeByPssvrdomain(PSSvrDomain pSSvrDomain) throws Exception {
        final PSSvrDomain pSSvrDomain2 = pSSvrDomain;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDSBookingServiceBase.this.onBeforeRemoveByPssvrdomain(pSSvrDomain2);
                PSDSBookingServiceBase.this.internalRemoveByPssvrdomain(pSSvrDomain2);
                PSDSBookingServiceBase.this.onAfterRemoveByPssvrdomain(pSSvrDomain2);
            }
        });
    }

    protected void onBeforeRemoveByPssvrdomain(PSSvrDomain pSSvrDomain) throws Exception {
    }

    protected void internalRemoveByPssvrdomain(PSSvrDomain pSSvrDomain) throws Exception {
        ArrayList<PSDSBooking> arrayList = this.selectByPssvrdomain(pSSvrDomain);
        this.onBeforeRemoveByPssvrdomain(pSSvrDomain, arrayList);
        for (PSDSBooking pSDSBooking : arrayList) {
            this.remove(pSDSBooking);
        }
        this.onAfterRemoveByPssvrdomain(pSSvrDomain, arrayList);
    }

    protected void onAfterRemoveByPssvrdomain(PSSvrDomain pSSvrDomain) throws Exception {
    }

    protected void onBeforeRemoveByPssvrdomain(PSSvrDomain pSSvrDomain, ArrayList<PSDSBooking> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPssvrdomain(PSSvrDomain pSSvrDomain, ArrayList<PSDSBooking> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDSBooking pSDSBooking) throws Exception {
        super.onBeforeRemove(pSDSBooking);
    }

    protected void replaceParentInfo(PSDSBooking pSDSBooking, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDSBooking, cloneSession);
        if (pSDSBooking.getPSDevCenterServerId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTERSERVER", (Object)pSDSBooking.getPSDevCenterServerId())) != null) {
            this.onFillParentInfo_PSDevCenterServer(pSDSBooking, (PSDevCenterServer)iEntity);
        }
        if (pSDSBooking.getPSDevCenterId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTER", (Object)pSDSBooking.getPSDevCenterId())) != null) {
            this.onFillParentInfo_PSDevCenter(pSDSBooking, (PSDevCenter)iEntity);
        }
        if (pSDSBooking.getPSDevServerId() != null && (iEntity = cloneSession.getEntity("PSDEVSERVER", (Object)pSDSBooking.getPSDevServerId())) != null) {
            this.onFillParentInfo_PSDevServer(pSDSBooking, (PSDevServer)iEntity);
        }
        if (pSDSBooking.getPSSvrDomainId() != null && (iEntity = cloneSession.getEntity("PSSVRDOMAIN", (Object)pSDSBooking.getPSSvrDomainId())) != null) {
            this.onFillParentInfo_Pssvrdomain(pSDSBooking, (PSSvrDomain)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDSBooking pSDSBooking, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDSBooking, bl);
    }

    protected void onCheckEntity(boolean bl, PSDSBooking pSDSBooking, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_BeginTime(bl, pSDSBooking, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BookingInfo(bl, pSDSBooking, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BookingParam(bl, pSDSBooking, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BookingParam2(bl, pSDSBooking, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BookingParam3(bl, pSDSBooking, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BookingParam4(bl, pSDSBooking, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BookingState(bl, pSDSBooking, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BookingType(bl, pSDSBooking, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Duration(bl, pSDSBooking, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EndTime(bl, pSDSBooking, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Hours(bl, pSDSBooking, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDSBooking, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterId(bl, pSDSBooking, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterName(bl, pSDSBooking, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterServerId(bl, pSDSBooking, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterServerName(bl, pSDSBooking, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevServerId(bl, pSDSBooking, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevServerName(bl, pSDSBooking, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDSBookingId(bl, pSDSBooking, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDSBookingName(bl, pSDSBooking, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSvrDomainId(bl, pSDSBooking, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSvrDomainName(bl, pSDSBooking, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDSBooking, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_BeginTime(boolean bl, PSDSBooking pSDSBooking, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDSBooking.isBeginTimeDirty() && !bl2 : !pSDSBooking.isBeginTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSDSBooking.getBeginTime();
        if (bl) {
            if (bl2 && timestamp == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BEGINTIME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_BeginTime_Default(pSDSBooking, bl2, bl3);
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

    protected EntityFieldError onCheckField_BookingInfo(boolean bl, PSDSBooking pSDSBooking, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDSBooking.isBookingInfoDirty() : !pSDSBooking.isBookingInfoDirty()) {
            return null;
        }
        String string = pSDSBooking.getBookingInfo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BookingInfo_Default(pSDSBooking, bl2, bl3);
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

    protected EntityFieldError onCheckField_BookingParam(boolean bl, PSDSBooking pSDSBooking, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDSBooking.isBookingParamDirty() : !pSDSBooking.isBookingParamDirty()) {
            return null;
        }
        String string = pSDSBooking.getBookingParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BookingParam_Default(pSDSBooking, bl2, bl3);
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

    protected EntityFieldError onCheckField_BookingParam2(boolean bl, PSDSBooking pSDSBooking, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDSBooking.isBookingParam2Dirty() : !pSDSBooking.isBookingParam2Dirty()) {
            return null;
        }
        String string = pSDSBooking.getBookingParam2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BookingParam2_Default(pSDSBooking, bl2, bl3);
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

    protected EntityFieldError onCheckField_BookingParam3(boolean bl, PSDSBooking pSDSBooking, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDSBooking.isBookingParam3Dirty() : !pSDSBooking.isBookingParam3Dirty()) {
            return null;
        }
        String string = pSDSBooking.getBookingParam3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BookingParam3_Default(pSDSBooking, bl2, bl3);
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

    protected EntityFieldError onCheckField_BookingParam4(boolean bl, PSDSBooking pSDSBooking, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDSBooking.isBookingParam4Dirty() : !pSDSBooking.isBookingParam4Dirty()) {
            return null;
        }
        String string = pSDSBooking.getBookingParam4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BookingParam4_Default(pSDSBooking, bl2, bl3);
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

    protected EntityFieldError onCheckField_BookingState(boolean bl, PSDSBooking pSDSBooking, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDSBooking.isBookingStateDirty() && !bl2 : !pSDSBooking.isBookingStateDirty()) {
            return null;
        }
        Integer n = pSDSBooking.getBookingState();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BOOKINGSTATE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_BookingState_Default(pSDSBooking, bl2, bl3);
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

    protected EntityFieldError onCheckField_BookingType(boolean bl, PSDSBooking pSDSBooking, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDSBooking.isBookingTypeDirty() && !bl2 : !pSDSBooking.isBookingTypeDirty()) {
            return null;
        }
        String string = pSDSBooking.getBookingType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BOOKINGTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_BookingType_Default(pSDSBooking, bl2, bl3);
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

    protected EntityFieldError onCheckField_Duration(boolean bl, PSDSBooking pSDSBooking, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDSBooking.isDurationDirty() : !pSDSBooking.isDurationDirty()) {
            return null;
        }
        Integer n = pSDSBooking.getDuration();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Duration_Default(pSDSBooking, bl2, bl3);
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

    protected EntityFieldError onCheckField_EndTime(boolean bl, PSDSBooking pSDSBooking, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDSBooking.isEndTimeDirty() && !bl2 : !pSDSBooking.isEndTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSDSBooking.getEndTime();
        if (bl) {
            if (bl2 && timestamp == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENDTIME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_EndTime_Default(pSDSBooking, bl2, bl3);
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

    protected EntityFieldError onCheckField_Hours(boolean bl, PSDSBooking pSDSBooking, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDSBooking.isHoursDirty() && !bl2 : !pSDSBooking.isHoursDirty()) {
            return null;
        }
        Integer n = pSDSBooking.getHours();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HOURS");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_Hours_Default(pSDSBooking, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDSBooking pSDSBooking, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDSBooking.isMemoDirty() : !pSDSBooking.isMemoDirty()) {
            return null;
        }
        String string = pSDSBooking.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDSBooking, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevCenterId(boolean bl, PSDSBooking pSDSBooking, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDSBooking.isPSDevCenterIdDirty() : !pSDSBooking.isPSDevCenterIdDirty()) {
            return null;
        }
        String string = pSDSBooking.getPSDevCenterId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterId_Default(pSDSBooking, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevCenterName(boolean bl, PSDSBooking pSDSBooking, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDSBooking.isPSDevCenterNameDirty() : !pSDSBooking.isPSDevCenterNameDirty()) {
            return null;
        }
        String string = pSDSBooking.getPSDevCenterName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterName_Default(pSDSBooking, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevCenterServerId(boolean bl, PSDSBooking pSDSBooking, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDSBooking.isPSDevCenterServerIdDirty() : !pSDSBooking.isPSDevCenterServerIdDirty()) {
            return null;
        }
        String string = pSDSBooking.getPSDevCenterServerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterServerId_Default(pSDSBooking, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevCenterServerName(boolean bl, PSDSBooking pSDSBooking, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDSBooking.isPSDevCenterServerNameDirty() : !pSDSBooking.isPSDevCenterServerNameDirty()) {
            return null;
        }
        String string = pSDSBooking.getPSDevCenterServerName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterServerName_Default(pSDSBooking, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevServerId(boolean bl, PSDSBooking pSDSBooking, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDSBooking.isPSDevServerIdDirty() : !pSDSBooking.isPSDevServerIdDirty()) {
            return null;
        }
        String string = pSDSBooking.getPSDevServerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevServerId_Default(pSDSBooking, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevServerName(boolean bl, PSDSBooking pSDSBooking, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDSBooking.isPSDevServerNameDirty() : !pSDSBooking.isPSDevServerNameDirty()) {
            return null;
        }
        String string = pSDSBooking.getPSDevServerName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevServerName_Default(pSDSBooking, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDSBookingId(boolean bl, PSDSBooking pSDSBooking, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDSBooking.isPSDSBookingIdDirty() && !bl2 : !pSDSBooking.isPSDSBookingIdDirty()) {
            return null;
        }
        String string = pSDSBooking.getPSDSBookingId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDSBOOKINGID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDSBookingId_Default(pSDSBooking, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDSBOOKINGID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDSBookingName(boolean bl, PSDSBooking pSDSBooking, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDSBooking.isPSDSBookingNameDirty() && !bl2 : !pSDSBooking.isPSDSBookingNameDirty()) {
            return null;
        }
        String string = pSDSBooking.getPSDSBookingName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDSBOOKINGNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDSBookingName_Default(pSDSBooking, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDSBOOKINGNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSvrDomainId(boolean bl, PSDSBooking pSDSBooking, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDSBooking.isPSSvrDomainIdDirty() : !pSDSBooking.isPSSvrDomainIdDirty()) {
            return null;
        }
        String string = pSDSBooking.getPSSvrDomainId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSvrDomainId_Default(pSDSBooking, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSvrDomainName(boolean bl, PSDSBooking pSDSBooking, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDSBooking.isPSSvrDomainNameDirty() : !pSDSBooking.isPSSvrDomainNameDirty()) {
            return null;
        }
        String string = pSDSBooking.getPSSvrDomainName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSvrDomainName_Default(pSDSBooking, bl2, bl3);
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

    protected void onSyncEntity(PSDSBooking pSDSBooking, boolean bl) throws Exception {
        super.onSyncEntity(pSDSBooking, bl);
    }

    protected void onSyncIndexEntities(PSDSBooking pSDSBooking, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDSBooking, bl);
    }

    public Object getDataContextValue(PSDSBooking pSDSBooking, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDSBooking, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDSBooking pSDSBooking, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDSBooking, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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
        if (StringHelper.compare((String)string, (String)"PSDSBOOKINGID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDSBookingId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDSBOOKINGNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDSBookingName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSVRDOMAINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSvrDomainId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSVRDOMAINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSvrDomainName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSDSBookingId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDSBOOKINGID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDSBookingName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDSBOOKINGNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSDSBooking pSDSBooking) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDSBooking)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDSBooking pSDSBooking) throws Exception {
        super.onUpdateParent(pSDSBooking);
    }

    @Override
    protected void exportCurXmlModel(PSDSBooking pSDSBooking, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDSBOOKING");
        if (!bl) {
            pSDSBooking.setCreateDate(null);
            pSDSBooking.setCreateMan(null);
            pSDSBooking.setPSDSBookingId(null);
            pSDSBooking.setUpdateDate(null);
            pSDSBooking.setUpdateMan(null);
            super.exportCurXmlModel(pSDSBooking, xmlNode, bl);
        }
    }
}

