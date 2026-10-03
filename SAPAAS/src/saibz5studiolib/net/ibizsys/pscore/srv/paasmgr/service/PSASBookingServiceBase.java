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
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterAS;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterASBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterBase;
import net.ibizsys.pscore.srv.paasmgr.dao.PSASBookingDAO;
import net.ibizsys.pscore.srv.paasmgr.demodel.PSASBookingDEModel;
import net.ibizsys.pscore.srv.paasmgr.entity.PSASBooking;
import net.ibizsys.pscore.srv.paasmgr.entity.PSAppServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSAppServerBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSvrDomain;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSvrDomainBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSASBookingServiceBase
extends PSCoreSysServiceBase<PSASBooking> {
    private static final Log log = LogFactory.getLog(PSASBookingServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSASBookingDEModel pSASBookingDEModel;
    private PSASBookingDAO pSASBookingDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.paasmgr.service.PSASBookingService";
    }

    public PSASBookingDEModel getPSASBookingDEModel() {
        if (this.pSASBookingDEModel == null) {
            try {
                this.pSASBookingDEModel = (PSASBookingDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.paasmgr.demodel.PSASBookingDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSASBookingDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSASBookingDEModel();
    }

    public PSASBookingDAO getPSASBookingDAO() {
        if (this.pSASBookingDAO == null) {
            try {
                this.pSASBookingDAO = (PSASBookingDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.paasmgr.dao.PSASBookingDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSASBookingDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSASBookingDAO();
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

    protected void onFillParentInfo(PSASBooking pSASBooking, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSASBOOKING_PSAPPSERVER_PSAPPSERVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSAppServerService", (SessionFactory)this.getSessionFactory());
            PSAppServer pSAppServer = (PSAppServer)iService.getDEModel().createEntity();
            pSAppServer.set("PSAPPSERVERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSAppServer);
            } else {
                iService.get(pSAppServer);
            }
            this.onFillParentInfo_PSAppServer(pSASBooking, pSAppServer);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSASBOOKING_PSDEVCENTERAS_PSDEVCENTERASID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterASService", (SessionFactory)this.getSessionFactory());
            PSDevCenterAS pSDevCenterAS = (PSDevCenterAS)iService.getDEModel().createEntity();
            pSDevCenterAS.set("PSDEVCENTERASID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenterAS);
            } else {
                iService.get(pSDevCenterAS);
            }
            this.onFillParentInfo_PSDevCenterAS(pSASBooking, pSDevCenterAS);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSASBOOKING_PSDEVCENTER_PSDEVCENTERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService", (SessionFactory)this.getSessionFactory());
            PSDevCenter pSDevCenter = (PSDevCenter)iService.getDEModel().createEntity();
            pSDevCenter.set("PSDEVCENTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenter);
            } else {
                iService.get(pSDevCenter);
            }
            this.onFillParentInfo_PSDevCenter(pSASBooking, pSDevCenter);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSASBOOKING_PSSVRDOMAIN_PSSVRDOMAINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSSvrDomainService", (SessionFactory)this.getSessionFactory());
            PSSvrDomain pSSvrDomain = (PSSvrDomain)iService.getDEModel().createEntity();
            pSSvrDomain.set("PSSVRDOMAINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSvrDomain);
            } else {
                iService.get(pSSvrDomain);
            }
            this.onFillParentInfo_PSSvrDomain(pSASBooking, pSSvrDomain);
            return;
        }
        super.onFillParentInfo(pSASBooking, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSAppServer(PSASBooking pSASBooking, PSAppServer pSAppServer) throws Exception {
        pSASBooking.setPSAppServerId(pSAppServer.getPSAppServerId());
        pSASBooking.setPSAppServerName(pSAppServer.getPSAppServerName());
    }

    protected void onFillParentInfo_PSDevCenterAS(PSASBooking pSASBooking, PSDevCenterAS pSDevCenterAS) throws Exception {
        pSASBooking.setPSDevCenterASId(pSDevCenterAS.getPSDevCenterASId());
        pSASBooking.setPSDevCenterASName(pSDevCenterAS.getPSDevCenterASName());
    }

    protected void onFillParentInfo_PSDevCenter(PSASBooking pSASBooking, PSDevCenter pSDevCenter) throws Exception {
        pSASBooking.setPSDevCenterId(pSDevCenter.getPSDevCenterId());
        pSASBooking.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
    }

    protected void onFillParentInfo_PSSvrDomain(PSASBooking pSASBooking, PSSvrDomain pSSvrDomain) throws Exception {
        pSASBooking.setPSSvrDomainId(pSSvrDomain.getPSSvrDomainId());
        pSASBooking.setPSSvrDomainName(pSSvrDomain.getPSSvrDomainName());
    }

    protected void onFillEntityFullInfo(PSASBooking pSASBooking, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSASBooking, bl);
        this.onFillEntityFullInfo_PSAppServer(pSASBooking, bl);
        this.onFillEntityFullInfo_PSDevCenterAS(pSASBooking, bl);
        this.onFillEntityFullInfo_PSDevCenter(pSASBooking, bl);
        this.onFillEntityFullInfo_PSSvrDomain(pSASBooking, bl);
    }

    protected void onFillEntityFullInfo_PSAppServer(PSASBooking pSASBooking, boolean bl) throws Exception {
        if (pSASBooking.isPSAppServerIdDirty()) {
            if (pSASBooking.getPSAppServerId() != null) {
                if (pSASBooking.getPSAppServerId() == null || pSASBooking.getPSAppServerName() == null) {
                    PSAppServer pSAppServer = pSASBooking.getPSAppServer();
                    pSASBooking.setPSAppServerName(pSAppServer.getPSAppServerName());
                }
            } else {
                pSASBooking.setPSAppServerName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDevCenterAS(PSASBooking pSASBooking, boolean bl) throws Exception {
        if (pSASBooking.isPSDevCenterASIdDirty()) {
            if (pSASBooking.getPSDevCenterASId() != null) {
                if (pSASBooking.getPSDevCenterASId() == null || pSASBooking.getPSDevCenterASName() == null) {
                    PSDevCenterAS pSDevCenterAS = pSASBooking.getPSDevCenterAS();
                    pSASBooking.setPSDevCenterASName(pSDevCenterAS.getPSDevCenterASName());
                }
            } else {
                pSASBooking.setPSDevCenterASName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDevCenter(PSASBooking pSASBooking, boolean bl) throws Exception {
        if (pSASBooking.isPSDevCenterIdDirty()) {
            if (pSASBooking.getPSDevCenterId() != null) {
                if (pSASBooking.getPSDevCenterId() == null || pSASBooking.getPSDevCenterName() == null) {
                    PSDevCenter pSDevCenter = pSASBooking.getPSDevCenter();
                    pSASBooking.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
                }
            } else {
                pSASBooking.setPSDevCenterName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSvrDomain(PSASBooking pSASBooking, boolean bl) throws Exception {
        if (pSASBooking.isPSSvrDomainIdDirty()) {
            if (pSASBooking.getPSSvrDomainId() != null) {
                if (pSASBooking.getPSSvrDomainId() == null || pSASBooking.getPSSvrDomainName() == null) {
                    PSSvrDomain pSSvrDomain = pSASBooking.getPSSvrDomain();
                    pSASBooking.setPSSvrDomainName(pSSvrDomain.getPSSvrDomainName());
                }
            } else {
                pSASBooking.setPSSvrDomainName(null);
            }
        }
    }

    protected void onWriteBackParent(PSASBooking pSASBooking, boolean bl) throws Exception {
        super.onWriteBackParent(pSASBooking, bl);
    }

    public ArrayList<PSASBooking> selectByPSAppServer(PSAppServerBase pSAppServerBase) throws Exception {
        return this.selectByPSAppServer(pSAppServerBase, "", -1);
    }

    public ArrayList<PSASBooking> selectByPSAppServer(PSAppServerBase pSAppServerBase, String string) throws Exception {
        return this.selectByPSAppServer(pSAppServerBase, string, -1);
    }

    public ArrayList<PSASBooking> selectByPSAppServer(PSAppServerBase pSAppServerBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSAPPSERVERID", (Object)pSAppServerBase.getPSAppServerId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSAppServerCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSAppServerCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSASBooking> selectByPSDevCenterAS(PSDevCenterASBase pSDevCenterASBase) throws Exception {
        return this.selectByPSDevCenterAS(pSDevCenterASBase, "", -1);
    }

    public ArrayList<PSASBooking> selectByPSDevCenterAS(PSDevCenterASBase pSDevCenterASBase, String string) throws Exception {
        return this.selectByPSDevCenterAS(pSDevCenterASBase, string, -1);
    }

    public ArrayList<PSASBooking> selectByPSDevCenterAS(PSDevCenterASBase pSDevCenterASBase, String string, int n) throws Exception {
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

    public ArrayList<PSASBooking> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, "", -1);
    }

    public ArrayList<PSASBooking> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, string, -1);
    }

    public ArrayList<PSASBooking> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string, int n) throws Exception {
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

    public ArrayList<PSASBooking> selectByPSSvrDomain(PSSvrDomainBase pSSvrDomainBase) throws Exception {
        return this.selectByPSSvrDomain(pSSvrDomainBase, "", -1);
    }

    public ArrayList<PSASBooking> selectByPSSvrDomain(PSSvrDomainBase pSSvrDomainBase, String string) throws Exception {
        return this.selectByPSSvrDomain(pSSvrDomainBase, string, -1);
    }

    public ArrayList<PSASBooking> selectByPSSvrDomain(PSSvrDomainBase pSSvrDomainBase, String string, int n) throws Exception {
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

    public void testRemoveByPSAppServer(PSAppServer pSAppServer) throws Exception {
        ArrayList<PSASBooking> arrayList = this.selectByPSAppServer(pSAppServer, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSAPPSERVER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSAppServer);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSASBOOKING_PSAPPSERVER_PSAPPSERVERID", "", iDataEntityModel.getName(), "PSASBOOKING", iDataEntityModel.getDataInfo(pSAppServer), arrayList.get(0)));
        }
    }

    public void resetPSAppServer(PSAppServer pSAppServer) throws Exception {
        ArrayList<PSASBooking> arrayList = this.selectByPSAppServer(pSAppServer);
        for (PSASBooking pSASBooking : arrayList) {
            PSASBooking pSASBooking2 = (PSASBooking)this.getDEModel().createEntity();
            pSASBooking2.setPSASBookingId(pSASBooking.getPSASBookingId());
            pSASBooking2.setPSAppServerId(null);
            this.update(pSASBooking2);
        }
    }

    public void removeByPSAppServer(PSAppServer pSAppServer) throws Exception {
        final PSAppServer pSAppServer2 = pSAppServer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSASBookingServiceBase.this.onBeforeRemoveByPSAppServer(pSAppServer2);
                PSASBookingServiceBase.this.internalRemoveByPSAppServer(pSAppServer2);
                PSASBookingServiceBase.this.onAfterRemoveByPSAppServer(pSAppServer2);
            }
        });
    }

    protected void onBeforeRemoveByPSAppServer(PSAppServer pSAppServer) throws Exception {
    }

    protected void internalRemoveByPSAppServer(PSAppServer pSAppServer) throws Exception {
        ArrayList<PSASBooking> arrayList = this.selectByPSAppServer(pSAppServer);
        this.onBeforeRemoveByPSAppServer(pSAppServer, arrayList);
        for (PSASBooking pSASBooking : arrayList) {
            this.remove(pSASBooking);
        }
        this.onAfterRemoveByPSAppServer(pSAppServer, arrayList);
    }

    protected void onAfterRemoveByPSAppServer(PSAppServer pSAppServer) throws Exception {
    }

    protected void onBeforeRemoveByPSAppServer(PSAppServer pSAppServer, ArrayList<PSASBooking> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSAppServer(PSAppServer pSAppServer, ArrayList<PSASBooking> arrayList) throws Exception {
    }

    public void testRemoveByPSDevCenterAS(PSDevCenterAS pSDevCenterAS) throws Exception {
        ArrayList<PSASBooking> arrayList = this.selectByPSDevCenterAS(pSDevCenterAS, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTERAS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevCenterAS);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSASBOOKING_PSDEVCENTERAS_PSDEVCENTERASID", "", iDataEntityModel.getName(), "PSASBOOKING", iDataEntityModel.getDataInfo(pSDevCenterAS), arrayList.get(0)));
        }
    }

    public void resetPSDevCenterAS(PSDevCenterAS pSDevCenterAS) throws Exception {
        ArrayList<PSASBooking> arrayList = this.selectByPSDevCenterAS(pSDevCenterAS);
        for (PSASBooking pSASBooking : arrayList) {
            PSASBooking pSASBooking2 = (PSASBooking)this.getDEModel().createEntity();
            pSASBooking2.setPSASBookingId(pSASBooking.getPSASBookingId());
            pSASBooking2.setPSDevCenterASId(null);
            this.update(pSASBooking2);
        }
    }

    public void removeByPSDevCenterAS(PSDevCenterAS pSDevCenterAS) throws Exception {
        final PSDevCenterAS pSDevCenterAS2 = pSDevCenterAS;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSASBookingServiceBase.this.onBeforeRemoveByPSDevCenterAS(pSDevCenterAS2);
                PSASBookingServiceBase.this.internalRemoveByPSDevCenterAS(pSDevCenterAS2);
                PSASBookingServiceBase.this.onAfterRemoveByPSDevCenterAS(pSDevCenterAS2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenterAS(PSDevCenterAS pSDevCenterAS) throws Exception {
    }

    protected void internalRemoveByPSDevCenterAS(PSDevCenterAS pSDevCenterAS) throws Exception {
        ArrayList<PSASBooking> arrayList = this.selectByPSDevCenterAS(pSDevCenterAS);
        this.onBeforeRemoveByPSDevCenterAS(pSDevCenterAS, arrayList);
        for (PSASBooking pSASBooking : arrayList) {
            this.remove(pSASBooking);
        }
        this.onAfterRemoveByPSDevCenterAS(pSDevCenterAS, arrayList);
    }

    protected void onAfterRemoveByPSDevCenterAS(PSDevCenterAS pSDevCenterAS) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenterAS(PSDevCenterAS pSDevCenterAS, ArrayList<PSASBooking> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenterAS(PSDevCenterAS pSDevCenterAS, ArrayList<PSASBooking> arrayList) throws Exception {
    }

    public void testRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSASBooking> arrayList = this.selectByPSDevCenter(pSDevCenter, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevCenter);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSASBOOKING_PSDEVCENTER_PSDEVCENTERID", "", iDataEntityModel.getName(), "PSASBOOKING", iDataEntityModel.getDataInfo(pSDevCenter), arrayList.get(0)));
        }
    }

    public void resetPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSASBooking> arrayList = this.selectByPSDevCenter(pSDevCenter);
        for (PSASBooking pSASBooking : arrayList) {
            PSASBooking pSASBooking2 = (PSASBooking)this.getDEModel().createEntity();
            pSASBooking2.setPSASBookingId(pSASBooking.getPSASBookingId());
            pSASBooking2.setPSDevCenterId(null);
            this.update(pSASBooking2);
        }
    }

    public void removeByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        final PSDevCenter pSDevCenter2 = pSDevCenter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSASBookingServiceBase.this.onBeforeRemoveByPSDevCenter(pSDevCenter2);
                PSASBookingServiceBase.this.internalRemoveByPSDevCenter(pSDevCenter2);
                PSASBookingServiceBase.this.onAfterRemoveByPSDevCenter(pSDevCenter2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void internalRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSASBooking> arrayList = this.selectByPSDevCenter(pSDevCenter);
        this.onBeforeRemoveByPSDevCenter(pSDevCenter, arrayList);
        for (PSASBooking pSASBooking : arrayList) {
            this.remove(pSASBooking);
        }
        this.onAfterRemoveByPSDevCenter(pSDevCenter, arrayList);
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSASBooking> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSASBooking> arrayList) throws Exception {
    }

    public void testRemoveByPSSvrDomain(PSSvrDomain pSSvrDomain) throws Exception {
    }

    public void resetPSSvrDomain(PSSvrDomain pSSvrDomain) throws Exception {
        ArrayList<PSASBooking> arrayList = this.selectByPSSvrDomain(pSSvrDomain);
        for (PSASBooking pSASBooking : arrayList) {
            PSASBooking pSASBooking2 = (PSASBooking)this.getDEModel().createEntity();
            pSASBooking2.setPSASBookingId(pSASBooking.getPSASBookingId());
            pSASBooking2.setPSSvrDomainId(null);
            this.update(pSASBooking2);
        }
    }

    public void removeByPSSvrDomain(PSSvrDomain pSSvrDomain) throws Exception {
        final PSSvrDomain pSSvrDomain2 = pSSvrDomain;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSASBookingServiceBase.this.onBeforeRemoveByPSSvrDomain(pSSvrDomain2);
                PSASBookingServiceBase.this.internalRemoveByPSSvrDomain(pSSvrDomain2);
                PSASBookingServiceBase.this.onAfterRemoveByPSSvrDomain(pSSvrDomain2);
            }
        });
    }

    protected void onBeforeRemoveByPSSvrDomain(PSSvrDomain pSSvrDomain) throws Exception {
    }

    protected void internalRemoveByPSSvrDomain(PSSvrDomain pSSvrDomain) throws Exception {
        ArrayList<PSASBooking> arrayList = this.selectByPSSvrDomain(pSSvrDomain);
        this.onBeforeRemoveByPSSvrDomain(pSSvrDomain, arrayList);
        for (PSASBooking pSASBooking : arrayList) {
            this.remove(pSASBooking);
        }
        this.onAfterRemoveByPSSvrDomain(pSSvrDomain, arrayList);
    }

    protected void onAfterRemoveByPSSvrDomain(PSSvrDomain pSSvrDomain) throws Exception {
    }

    protected void onBeforeRemoveByPSSvrDomain(PSSvrDomain pSSvrDomain, ArrayList<PSASBooking> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSvrDomain(PSSvrDomain pSSvrDomain, ArrayList<PSASBooking> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSASBooking pSASBooking) throws Exception {
        super.onBeforeRemove(pSASBooking);
    }

    protected void replaceParentInfo(PSASBooking pSASBooking, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSASBooking, cloneSession);
        if (pSASBooking.getPSAppServerId() != null && (iEntity = cloneSession.getEntity("PSAPPSERVER", (Object)pSASBooking.getPSAppServerId())) != null) {
            this.onFillParentInfo_PSAppServer(pSASBooking, (PSAppServer)iEntity);
        }
        if (pSASBooking.getPSDevCenterASId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTERAS", (Object)pSASBooking.getPSDevCenterASId())) != null) {
            this.onFillParentInfo_PSDevCenterAS(pSASBooking, (PSDevCenterAS)iEntity);
        }
        if (pSASBooking.getPSDevCenterId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTER", (Object)pSASBooking.getPSDevCenterId())) != null) {
            this.onFillParentInfo_PSDevCenter(pSASBooking, (PSDevCenter)iEntity);
        }
        if (pSASBooking.getPSSvrDomainId() != null && (iEntity = cloneSession.getEntity("PSSVRDOMAIN", (Object)pSASBooking.getPSSvrDomainId())) != null) {
            this.onFillParentInfo_PSSvrDomain(pSASBooking, (PSSvrDomain)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSASBooking pSASBooking, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSASBooking, bl);
    }

    protected void onCheckEntity(boolean bl, PSASBooking pSASBooking, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_BeginTime(bl, pSASBooking, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BookingInfo(bl, pSASBooking, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BookingParam(bl, pSASBooking, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BookingParam2(bl, pSASBooking, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BookingParam3(bl, pSASBooking, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BookingParam4(bl, pSASBooking, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BookingState(bl, pSASBooking, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BookingType(bl, pSASBooking, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Duration(bl, pSASBooking, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EndTime(bl, pSASBooking, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Hours(bl, pSASBooking, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSASBooking, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppServerId(bl, pSASBooking, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppServerName(bl, pSASBooking, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSASBookingId(bl, pSASBooking, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSASBookingName(bl, pSASBooking, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterASId(bl, pSASBooking, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterASName(bl, pSASBooking, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterId(bl, pSASBooking, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterName(bl, pSASBooking, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSvrDomainId(bl, pSASBooking, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSvrDomainName(bl, pSASBooking, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSASBooking, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_BeginTime(boolean bl, PSASBooking pSASBooking, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSASBooking.isBeginTimeDirty() && !bl2 : !pSASBooking.isBeginTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSASBooking.getBeginTime();
        if (bl) {
            if (bl2 && timestamp == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BEGINTIME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_BeginTime_Default(pSASBooking, bl2, bl3);
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

    protected EntityFieldError onCheckField_BookingInfo(boolean bl, PSASBooking pSASBooking, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSASBooking.isBookingInfoDirty() : !pSASBooking.isBookingInfoDirty()) {
            return null;
        }
        String string = pSASBooking.getBookingInfo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BookingInfo_Default(pSASBooking, bl2, bl3);
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

    protected EntityFieldError onCheckField_BookingParam(boolean bl, PSASBooking pSASBooking, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSASBooking.isBookingParamDirty() : !pSASBooking.isBookingParamDirty()) {
            return null;
        }
        String string = pSASBooking.getBookingParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BookingParam_Default(pSASBooking, bl2, bl3);
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

    protected EntityFieldError onCheckField_BookingParam2(boolean bl, PSASBooking pSASBooking, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSASBooking.isBookingParam2Dirty() : !pSASBooking.isBookingParam2Dirty()) {
            return null;
        }
        String string = pSASBooking.getBookingParam2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BookingParam2_Default(pSASBooking, bl2, bl3);
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

    protected EntityFieldError onCheckField_BookingParam3(boolean bl, PSASBooking pSASBooking, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSASBooking.isBookingParam3Dirty() : !pSASBooking.isBookingParam3Dirty()) {
            return null;
        }
        String string = pSASBooking.getBookingParam3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BookingParam3_Default(pSASBooking, bl2, bl3);
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

    protected EntityFieldError onCheckField_BookingParam4(boolean bl, PSASBooking pSASBooking, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSASBooking.isBookingParam4Dirty() : !pSASBooking.isBookingParam4Dirty()) {
            return null;
        }
        String string = pSASBooking.getBookingParam4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BookingParam4_Default(pSASBooking, bl2, bl3);
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

    protected EntityFieldError onCheckField_BookingState(boolean bl, PSASBooking pSASBooking, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSASBooking.isBookingStateDirty() && !bl2 : !pSASBooking.isBookingStateDirty()) {
            return null;
        }
        Integer n = pSASBooking.getBookingState();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BOOKINGSTATE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_BookingState_Default(pSASBooking, bl2, bl3);
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

    protected EntityFieldError onCheckField_BookingType(boolean bl, PSASBooking pSASBooking, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSASBooking.isBookingTypeDirty() && !bl2 : !pSASBooking.isBookingTypeDirty()) {
            return null;
        }
        String string = pSASBooking.getBookingType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BOOKINGTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_BookingType_Default(pSASBooking, bl2, bl3);
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

    protected EntityFieldError onCheckField_Duration(boolean bl, PSASBooking pSASBooking, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSASBooking.isDurationDirty() : !pSASBooking.isDurationDirty()) {
            return null;
        }
        Integer n = pSASBooking.getDuration();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Duration_Default(pSASBooking, bl2, bl3);
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

    protected EntityFieldError onCheckField_EndTime(boolean bl, PSASBooking pSASBooking, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSASBooking.isEndTimeDirty() && !bl2 : !pSASBooking.isEndTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSASBooking.getEndTime();
        if (bl) {
            if (bl2 && timestamp == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENDTIME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_EndTime_Default(pSASBooking, bl2, bl3);
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

    protected EntityFieldError onCheckField_Hours(boolean bl, PSASBooking pSASBooking, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSASBooking.isHoursDirty() && !bl2 : !pSASBooking.isHoursDirty()) {
            return null;
        }
        Integer n = pSASBooking.getHours();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HOURS");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_Hours_Default(pSASBooking, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSASBooking pSASBooking, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSASBooking.isMemoDirty() : !pSASBooking.isMemoDirty()) {
            return null;
        }
        String string = pSASBooking.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSASBooking, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSAppServerId(boolean bl, PSASBooking pSASBooking, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSASBooking.isPSAppServerIdDirty() : !pSASBooking.isPSAppServerIdDirty()) {
            return null;
        }
        String string = pSASBooking.getPSAppServerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppServerId_Default(pSASBooking, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSAppServerName(boolean bl, PSASBooking pSASBooking, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSASBooking.isPSAppServerNameDirty() : !pSASBooking.isPSAppServerNameDirty()) {
            return null;
        }
        String string = pSASBooking.getPSAppServerName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppServerName_Default(pSASBooking, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSASBookingId(boolean bl, PSASBooking pSASBooking, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSASBooking.isPSASBookingIdDirty() && !bl2 : !pSASBooking.isPSASBookingIdDirty()) {
            return null;
        }
        String string = pSASBooking.getPSASBookingId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSASBOOKINGID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSASBookingId_Default(pSASBooking, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSASBOOKINGID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSASBookingName(boolean bl, PSASBooking pSASBooking, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSASBooking.isPSASBookingNameDirty() && !bl2 : !pSASBooking.isPSASBookingNameDirty()) {
            return null;
        }
        String string = pSASBooking.getPSASBookingName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSASBOOKINGNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSASBookingName_Default(pSASBooking, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSASBOOKINGNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterASId(boolean bl, PSASBooking pSASBooking, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSASBooking.isPSDevCenterASIdDirty() : !pSASBooking.isPSDevCenterASIdDirty()) {
            return null;
        }
        String string = pSASBooking.getPSDevCenterASId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterASId_Default(pSASBooking, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevCenterASName(boolean bl, PSASBooking pSASBooking, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSASBooking.isPSDevCenterASNameDirty() : !pSASBooking.isPSDevCenterASNameDirty()) {
            return null;
        }
        String string = pSASBooking.getPSDevCenterASName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterASName_Default(pSASBooking, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERASNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterId(boolean bl, PSASBooking pSASBooking, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSASBooking.isPSDevCenterIdDirty() : !pSASBooking.isPSDevCenterIdDirty()) {
            return null;
        }
        String string = pSASBooking.getPSDevCenterId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterId_Default(pSASBooking, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevCenterName(boolean bl, PSASBooking pSASBooking, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSASBooking.isPSDevCenterNameDirty() : !pSASBooking.isPSDevCenterNameDirty()) {
            return null;
        }
        String string = pSASBooking.getPSDevCenterName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterName_Default(pSASBooking, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSvrDomainId(boolean bl, PSASBooking pSASBooking, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSASBooking.isPSSvrDomainIdDirty() : !pSASBooking.isPSSvrDomainIdDirty()) {
            return null;
        }
        String string = pSASBooking.getPSSvrDomainId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSvrDomainId_Default(pSASBooking, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSvrDomainName(boolean bl, PSASBooking pSASBooking, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSASBooking.isPSSvrDomainNameDirty() : !pSASBooking.isPSSvrDomainNameDirty()) {
            return null;
        }
        String string = pSASBooking.getPSSvrDomainName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSvrDomainName_Default(pSASBooking, bl2, bl3);
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

    protected void onSyncEntity(PSASBooking pSASBooking, boolean bl) throws Exception {
        super.onSyncEntity(pSASBooking, bl);
    }

    protected void onSyncIndexEntities(PSASBooking pSASBooking, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSASBooking, bl);
    }

    public Object getDataContextValue(PSASBooking pSASBooking, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSASBooking, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSASBooking pSASBooking, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSASBooking, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"PSAPPSERVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppServerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPSERVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppServerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSASBOOKINGID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSASBookingId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSASBOOKINGNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSASBookingName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERASID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterASId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERASNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterASName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSASBookingId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSASBOOKINGID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSASBookingName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSASBOOKINGNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSASBooking pSASBooking) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSASBooking)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSASBooking pSASBooking) throws Exception {
        super.onUpdateParent(pSASBooking);
    }

    @Override
    protected void exportCurXmlModel(PSASBooking pSASBooking, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSASBOOKING");
        if (!bl) {
            pSASBooking.setCreateDate(null);
            pSASBooking.setCreateMan(null);
            pSASBooking.setPSASBookingId(null);
            pSASBooking.setUpdateDate(null);
            pSASBooking.setUpdateMan(null);
            super.exportCurXmlModel(pSASBooking, xmlNode, bl);
        }
    }
}

