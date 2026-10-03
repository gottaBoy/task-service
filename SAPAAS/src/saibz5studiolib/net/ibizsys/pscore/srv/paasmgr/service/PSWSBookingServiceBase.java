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
 *  net.ibizsys.paas.service.IServicePlugin
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
import net.ibizsys.paas.service.IServicePlugin;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCWorkspace;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCWorkspaceBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterBase;
import net.ibizsys.pscore.srv.paasmgr.dao.PSWSBookingDAO;
import net.ibizsys.pscore.srv.paasmgr.demodel.PSWSBookingDEModel;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSvrDomain;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSvrDomainBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSTaskServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSTaskServerBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSWSBooking;
import net.ibizsys.pscore.srv.paasmgr.entity.PSWorkspace;
import net.ibizsys.pscore.srv.paasmgr.entity.PSWorkspaceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSWSBookingServiceBase
extends PSCoreSysServiceBase<PSWSBooking> {
    private static final Log log = LogFactory.getLog(PSWSBookingServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_AUTOCREATE = "AutoCreate";
    private PSWSBookingDEModel pSWSBookingDEModel;
    private PSWSBookingDAO pSWSBookingDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.paasmgr.service.PSWSBookingService";
    }

    public PSWSBookingDEModel getPSWSBookingDEModel() {
        if (this.pSWSBookingDEModel == null) {
            try {
                this.pSWSBookingDEModel = (PSWSBookingDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.paasmgr.demodel.PSWSBookingDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSWSBookingDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSWSBookingDEModel();
    }

    public PSWSBookingDAO getPSWSBookingDAO() {
        if (this.pSWSBookingDAO == null) {
            try {
                this.pSWSBookingDAO = (PSWSBookingDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.paasmgr.dao.PSWSBookingDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSWSBookingDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSWSBookingDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_AUTOCREATE, (boolean)true) == 0) {
            this.autoCreate((PSWSBooking)iEntity);
            return;
        }
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public void autoCreate(PSWSBooking pSWSBooking) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_AUTOCREATE, 0, pSWSBooking, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSWSBooking, ACTION_AUTOCREATE);
        final PSWSBooking pSWSBooking2 = pSWSBooking;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSWSBookingServiceBase.this.getService(), PSWSBookingServiceBase.ACTION_AUTOCREATE, 40, pSWSBooking2, null).getResult() != 1) {
                    PSWSBookingServiceBase.this.onAutoCreate(pSWSBooking2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_AUTOCREATE, 99, pSWSBooking, null);
        }
    }

    protected void onAutoCreate(PSWSBooking pSWSBooking) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[AutoCreate]");
    }

    protected void onFillParentInfo(PSWSBooking pSWSBooking, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWSBOOKING_PSDCWORKSPACE_PSDCWORKSPACEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCWorkspaceService", (SessionFactory)this.getSessionFactory());
            PSDCWorkspace pSDCWorkspace = (PSDCWorkspace)iService.getDEModel().createEntity();
            pSDCWorkspace.set("PSDCWORKSPACEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDCWorkspace);
            } else {
                iService.get(pSDCWorkspace);
            }
            this.onFillParentInfo_PSDCWorkspace(pSWSBooking, pSDCWorkspace);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWSBOOKING_PSDEVCENTER_PSDEVCENTERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService", (SessionFactory)this.getSessionFactory());
            PSDevCenter pSDevCenter = (PSDevCenter)iService.getDEModel().createEntity();
            pSDevCenter.set("PSDEVCENTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenter);
            } else {
                iService.get(pSDevCenter);
            }
            this.onFillParentInfo_PSDevCenter(pSWSBooking, pSDevCenter);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWSBOOKING_PSSVRDOMAIN_PSSVRDOMAINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSSvrDomainService", (SessionFactory)this.getSessionFactory());
            PSSvrDomain pSSvrDomain = (PSSvrDomain)iService.getDEModel().createEntity();
            pSSvrDomain.set("PSSVRDOMAINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSvrDomain);
            } else {
                iService.get(pSSvrDomain);
            }
            this.onFillParentInfo_PSSvrDomain(pSWSBooking, pSSvrDomain);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWSBOOKING_PSTASKSERVER_PSTASKSERVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSTaskServerService", (SessionFactory)this.getSessionFactory());
            PSTaskServer pSTaskServer = (PSTaskServer)iService.getDEModel().createEntity();
            pSTaskServer.set("PSTASKSERVERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSTaskServer);
            } else {
                iService.get(pSTaskServer);
            }
            this.onFillParentInfo_PSTaskServer(pSWSBooking, pSTaskServer);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWSBOOKING_PSWORKSPACE_PSWORKSPACEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSWorkspaceService", (SessionFactory)this.getSessionFactory());
            PSWorkspace pSWorkspace = (PSWorkspace)iService.getDEModel().createEntity();
            pSWorkspace.set("PSWORKSPACEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSWorkspace);
            } else {
                iService.get(pSWorkspace);
            }
            this.onFillParentInfo_PSWorkspace(pSWSBooking, pSWorkspace);
            return;
        }
        super.onFillParentInfo(pSWSBooking, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDCWorkspace(PSWSBooking pSWSBooking, PSDCWorkspace pSDCWorkspace) throws Exception {
        pSWSBooking.setPSDCWorkspaceId(pSDCWorkspace.getPSDCWorkspaceId());
        pSWSBooking.setPSDCWorkspaceName(pSDCWorkspace.getPSDCWorkspaceName());
    }

    protected void onFillParentInfo_PSDevCenter(PSWSBooking pSWSBooking, PSDevCenter pSDevCenter) throws Exception {
        pSWSBooking.setPSDevCenterId(pSDevCenter.getPSDevCenterId());
        pSWSBooking.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
    }

    protected void onFillParentInfo_PSSvrDomain(PSWSBooking pSWSBooking, PSSvrDomain pSSvrDomain) throws Exception {
        pSWSBooking.setPSSvrDomainId(pSSvrDomain.getPSSvrDomainId());
        pSWSBooking.setPSSvrDomainName(pSSvrDomain.getPSSvrDomainName());
    }

    protected void onFillParentInfo_PSTaskServer(PSWSBooking pSWSBooking, PSTaskServer pSTaskServer) throws Exception {
        pSWSBooking.setPSTaskServerId(pSTaskServer.getPSTaskServerId());
        pSWSBooking.setPSTaskServerName(pSTaskServer.getPSTaskServerName());
    }

    protected void onFillParentInfo_PSWorkspace(PSWSBooking pSWSBooking, PSWorkspace pSWorkspace) throws Exception {
        pSWSBooking.setPSWorkspaceId(pSWorkspace.getPSWorkspaceId());
        pSWSBooking.setPSWorkspaceName(pSWorkspace.getPSWorkspaceName());
    }

    protected void onFillEntityFullInfo(PSWSBooking pSWSBooking, boolean bl) throws Exception {
        if (bl) {
            if (pSWSBooking.getBookingState() == null) {
                pSWSBooking.setBookingState((Integer)this.getDefaultValue(this.getWebContext(), "", "10", 9));
            }
            if (pSWSBooking.getBookingType() == null) {
                pSWSBooking.setBookingType((String)this.getDefaultValue(this.getWebContext(), "", "DCRES", 25));
            }
        }
        super.onFillEntityFullInfo(pSWSBooking, bl);
        this.onFillEntityFullInfo_PSDCWorkspace(pSWSBooking, bl);
        this.onFillEntityFullInfo_PSDevCenter(pSWSBooking, bl);
        this.onFillEntityFullInfo_PSSvrDomain(pSWSBooking, bl);
        this.onFillEntityFullInfo_PSTaskServer(pSWSBooking, bl);
        this.onFillEntityFullInfo_PSWorkspace(pSWSBooking, bl);
    }

    protected void onFillEntityFullInfo_PSDCWorkspace(PSWSBooking pSWSBooking, boolean bl) throws Exception {
        if (pSWSBooking.isPSDCWorkspaceIdDirty()) {
            if (pSWSBooking.getPSDCWorkspaceId() != null) {
                if (pSWSBooking.getPSDCWorkspaceId() == null || pSWSBooking.getPSDCWorkspaceName() == null) {
                    PSDCWorkspace pSDCWorkspace = pSWSBooking.getPSDCWorkspace();
                    pSWSBooking.setPSDCWorkspaceName(pSDCWorkspace.getPSDCWorkspaceName());
                }
            } else {
                pSWSBooking.setPSDCWorkspaceName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDevCenter(PSWSBooking pSWSBooking, boolean bl) throws Exception {
        if (pSWSBooking.isPSDevCenterIdDirty()) {
            if (pSWSBooking.getPSDevCenterId() != null) {
                if (pSWSBooking.getPSDevCenterId() == null || pSWSBooking.getPSDevCenterName() == null) {
                    PSDevCenter pSDevCenter = pSWSBooking.getPSDevCenter();
                    pSWSBooking.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
                }
            } else {
                pSWSBooking.setPSDevCenterName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSvrDomain(PSWSBooking pSWSBooking, boolean bl) throws Exception {
        if (pSWSBooking.isPSSvrDomainIdDirty()) {
            if (pSWSBooking.getPSSvrDomainId() != null) {
                if (pSWSBooking.getPSSvrDomainId() == null || pSWSBooking.getPSSvrDomainName() == null) {
                    PSSvrDomain pSSvrDomain = pSWSBooking.getPSSvrDomain();
                    pSWSBooking.setPSSvrDomainName(pSSvrDomain.getPSSvrDomainName());
                }
            } else {
                pSWSBooking.setPSSvrDomainName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSTaskServer(PSWSBooking pSWSBooking, boolean bl) throws Exception {
        if (pSWSBooking.isPSTaskServerIdDirty()) {
            if (pSWSBooking.getPSTaskServerId() != null) {
                if (pSWSBooking.getPSTaskServerId() == null || pSWSBooking.getPSTaskServerName() == null) {
                    PSTaskServer pSTaskServer = pSWSBooking.getPSTaskServer();
                    pSWSBooking.setPSTaskServerName(pSTaskServer.getPSTaskServerName());
                }
            } else {
                pSWSBooking.setPSTaskServerName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSWorkspace(PSWSBooking pSWSBooking, boolean bl) throws Exception {
        if (pSWSBooking.isPSWorkspaceIdDirty()) {
            if (pSWSBooking.getPSWorkspaceId() != null) {
                if (pSWSBooking.getPSWorkspaceId() == null || pSWSBooking.getPSWorkspaceName() == null) {
                    PSWorkspace pSWorkspace = pSWSBooking.getPSWorkspace();
                    pSWSBooking.setPSWorkspaceName(pSWorkspace.getPSWorkspaceName());
                }
            } else {
                pSWSBooking.setPSWorkspaceName(null);
            }
        }
    }

    protected void onWriteBackParent(PSWSBooking pSWSBooking, boolean bl) throws Exception {
        super.onWriteBackParent(pSWSBooking, bl);
    }

    public ArrayList<PSWSBooking> selectByPSDCWorkspace(PSDCWorkspaceBase pSDCWorkspaceBase) throws Exception {
        return this.selectByPSDCWorkspace(pSDCWorkspaceBase, "", -1);
    }

    public ArrayList<PSWSBooking> selectByPSDCWorkspace(PSDCWorkspaceBase pSDCWorkspaceBase, String string) throws Exception {
        return this.selectByPSDCWorkspace(pSDCWorkspaceBase, string, -1);
    }

    public ArrayList<PSWSBooking> selectByPSDCWorkspace(PSDCWorkspaceBase pSDCWorkspaceBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDCWORKSPACEID", (Object)pSDCWorkspaceBase.getPSDCWorkspaceId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDCWorkspaceCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDCWorkspaceCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWSBooking> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, "", -1);
    }

    public ArrayList<PSWSBooking> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, string, -1);
    }

    public ArrayList<PSWSBooking> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string, int n) throws Exception {
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

    public ArrayList<PSWSBooking> selectByPSSvrDomain(PSSvrDomainBase pSSvrDomainBase) throws Exception {
        return this.selectByPSSvrDomain(pSSvrDomainBase, "", -1);
    }

    public ArrayList<PSWSBooking> selectByPSSvrDomain(PSSvrDomainBase pSSvrDomainBase, String string) throws Exception {
        return this.selectByPSSvrDomain(pSSvrDomainBase, string, -1);
    }

    public ArrayList<PSWSBooking> selectByPSSvrDomain(PSSvrDomainBase pSSvrDomainBase, String string, int n) throws Exception {
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

    public ArrayList<PSWSBooking> selectByPSTaskServer(PSTaskServerBase pSTaskServerBase) throws Exception {
        return this.selectByPSTaskServer(pSTaskServerBase, "", -1);
    }

    public ArrayList<PSWSBooking> selectByPSTaskServer(PSTaskServerBase pSTaskServerBase, String string) throws Exception {
        return this.selectByPSTaskServer(pSTaskServerBase, string, -1);
    }

    public ArrayList<PSWSBooking> selectByPSTaskServer(PSTaskServerBase pSTaskServerBase, String string, int n) throws Exception {
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

    public ArrayList<PSWSBooking> selectByPSWorkspace(PSWorkspaceBase pSWorkspaceBase) throws Exception {
        return this.selectByPSWorkspace(pSWorkspaceBase, "", -1);
    }

    public ArrayList<PSWSBooking> selectByPSWorkspace(PSWorkspaceBase pSWorkspaceBase, String string) throws Exception {
        return this.selectByPSWorkspace(pSWorkspaceBase, string, -1);
    }

    public ArrayList<PSWSBooking> selectByPSWorkspace(PSWorkspaceBase pSWorkspaceBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSWORKSPACEID", (Object)pSWorkspaceBase.getPSWorkspaceId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSWorkspaceCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSWorkspaceCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDCWorkspace(PSDCWorkspace pSDCWorkspace) throws Exception {
    }

    public void resetPSDCWorkspace(PSDCWorkspace pSDCWorkspace) throws Exception {
        ArrayList<PSWSBooking> arrayList = this.selectByPSDCWorkspace(pSDCWorkspace);
        for (PSWSBooking pSWSBooking : arrayList) {
            PSWSBooking pSWSBooking2 = (PSWSBooking)this.getDEModel().createEntity();
            pSWSBooking2.setPSWSBookingId(pSWSBooking.getPSWSBookingId());
            pSWSBooking2.setPSDCWorkspaceId(null);
            this.update(pSWSBooking2);
        }
    }

    public void removeByPSDCWorkspace(PSDCWorkspace pSDCWorkspace) throws Exception {
        final PSDCWorkspace pSDCWorkspace2 = pSDCWorkspace;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWSBookingServiceBase.this.onBeforeRemoveByPSDCWorkspace(pSDCWorkspace2);
                PSWSBookingServiceBase.this.internalRemoveByPSDCWorkspace(pSDCWorkspace2);
                PSWSBookingServiceBase.this.onAfterRemoveByPSDCWorkspace(pSDCWorkspace2);
            }
        });
    }

    protected void onBeforeRemoveByPSDCWorkspace(PSDCWorkspace pSDCWorkspace) throws Exception {
    }

    protected void internalRemoveByPSDCWorkspace(PSDCWorkspace pSDCWorkspace) throws Exception {
        ArrayList<PSWSBooking> arrayList = this.selectByPSDCWorkspace(pSDCWorkspace);
        this.onBeforeRemoveByPSDCWorkspace(pSDCWorkspace, arrayList);
        for (PSWSBooking pSWSBooking : arrayList) {
            this.remove(pSWSBooking);
        }
        this.onAfterRemoveByPSDCWorkspace(pSDCWorkspace, arrayList);
    }

    protected void onAfterRemoveByPSDCWorkspace(PSDCWorkspace pSDCWorkspace) throws Exception {
    }

    protected void onBeforeRemoveByPSDCWorkspace(PSDCWorkspace pSDCWorkspace, ArrayList<PSWSBooking> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDCWorkspace(PSDCWorkspace pSDCWorkspace, ArrayList<PSWSBooking> arrayList) throws Exception {
    }

    public void testRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    public void resetPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSWSBooking> arrayList = this.selectByPSDevCenter(pSDevCenter);
        for (PSWSBooking pSWSBooking : arrayList) {
            PSWSBooking pSWSBooking2 = (PSWSBooking)this.getDEModel().createEntity();
            pSWSBooking2.setPSWSBookingId(pSWSBooking.getPSWSBookingId());
            pSWSBooking2.setPSDevCenterId(null);
            this.update(pSWSBooking2);
        }
    }

    public void removeByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        final PSDevCenter pSDevCenter2 = pSDevCenter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWSBookingServiceBase.this.onBeforeRemoveByPSDevCenter(pSDevCenter2);
                PSWSBookingServiceBase.this.internalRemoveByPSDevCenter(pSDevCenter2);
                PSWSBookingServiceBase.this.onAfterRemoveByPSDevCenter(pSDevCenter2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void internalRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSWSBooking> arrayList = this.selectByPSDevCenter(pSDevCenter);
        this.onBeforeRemoveByPSDevCenter(pSDevCenter, arrayList);
        for (PSWSBooking pSWSBooking : arrayList) {
            this.remove(pSWSBooking);
        }
        this.onAfterRemoveByPSDevCenter(pSDevCenter, arrayList);
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSWSBooking> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSWSBooking> arrayList) throws Exception {
    }

    public void testRemoveByPSSvrDomain(PSSvrDomain pSSvrDomain) throws Exception {
    }

    public void resetPSSvrDomain(PSSvrDomain pSSvrDomain) throws Exception {
        ArrayList<PSWSBooking> arrayList = this.selectByPSSvrDomain(pSSvrDomain);
        for (PSWSBooking pSWSBooking : arrayList) {
            PSWSBooking pSWSBooking2 = (PSWSBooking)this.getDEModel().createEntity();
            pSWSBooking2.setPSWSBookingId(pSWSBooking.getPSWSBookingId());
            pSWSBooking2.setPSSvrDomainId(null);
            this.update(pSWSBooking2);
        }
    }

    public void removeByPSSvrDomain(PSSvrDomain pSSvrDomain) throws Exception {
        final PSSvrDomain pSSvrDomain2 = pSSvrDomain;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWSBookingServiceBase.this.onBeforeRemoveByPSSvrDomain(pSSvrDomain2);
                PSWSBookingServiceBase.this.internalRemoveByPSSvrDomain(pSSvrDomain2);
                PSWSBookingServiceBase.this.onAfterRemoveByPSSvrDomain(pSSvrDomain2);
            }
        });
    }

    protected void onBeforeRemoveByPSSvrDomain(PSSvrDomain pSSvrDomain) throws Exception {
    }

    protected void internalRemoveByPSSvrDomain(PSSvrDomain pSSvrDomain) throws Exception {
        ArrayList<PSWSBooking> arrayList = this.selectByPSSvrDomain(pSSvrDomain);
        this.onBeforeRemoveByPSSvrDomain(pSSvrDomain, arrayList);
        for (PSWSBooking pSWSBooking : arrayList) {
            this.remove(pSWSBooking);
        }
        this.onAfterRemoveByPSSvrDomain(pSSvrDomain, arrayList);
    }

    protected void onAfterRemoveByPSSvrDomain(PSSvrDomain pSSvrDomain) throws Exception {
    }

    protected void onBeforeRemoveByPSSvrDomain(PSSvrDomain pSSvrDomain, ArrayList<PSWSBooking> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSvrDomain(PSSvrDomain pSSvrDomain, ArrayList<PSWSBooking> arrayList) throws Exception {
    }

    public void testRemoveByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
    }

    public void resetPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
        ArrayList<PSWSBooking> arrayList = this.selectByPSTaskServer(pSTaskServer);
        for (PSWSBooking pSWSBooking : arrayList) {
            PSWSBooking pSWSBooking2 = (PSWSBooking)this.getDEModel().createEntity();
            pSWSBooking2.setPSWSBookingId(pSWSBooking.getPSWSBookingId());
            pSWSBooking2.setPSTaskServerId(null);
            this.update(pSWSBooking2);
        }
    }

    public void removeByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
        final PSTaskServer pSTaskServer2 = pSTaskServer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWSBookingServiceBase.this.onBeforeRemoveByPSTaskServer(pSTaskServer2);
                PSWSBookingServiceBase.this.internalRemoveByPSTaskServer(pSTaskServer2);
                PSWSBookingServiceBase.this.onAfterRemoveByPSTaskServer(pSTaskServer2);
            }
        });
    }

    protected void onBeforeRemoveByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
    }

    protected void internalRemoveByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
        ArrayList<PSWSBooking> arrayList = this.selectByPSTaskServer(pSTaskServer);
        this.onBeforeRemoveByPSTaskServer(pSTaskServer, arrayList);
        for (PSWSBooking pSWSBooking : arrayList) {
            this.remove(pSWSBooking);
        }
        this.onAfterRemoveByPSTaskServer(pSTaskServer, arrayList);
    }

    protected void onAfterRemoveByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
    }

    protected void onBeforeRemoveByPSTaskServer(PSTaskServer pSTaskServer, ArrayList<PSWSBooking> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSTaskServer(PSTaskServer pSTaskServer, ArrayList<PSWSBooking> arrayList) throws Exception {
    }

    public void testRemoveByPSWorkspace(PSWorkspace pSWorkspace) throws Exception {
    }

    public void resetPSWorkspace(PSWorkspace pSWorkspace) throws Exception {
        ArrayList<PSWSBooking> arrayList = this.selectByPSWorkspace(pSWorkspace);
        for (PSWSBooking pSWSBooking : arrayList) {
            PSWSBooking pSWSBooking2 = (PSWSBooking)this.getDEModel().createEntity();
            pSWSBooking2.setPSWSBookingId(pSWSBooking.getPSWSBookingId());
            pSWSBooking2.setPSWorkspaceId(null);
            this.update(pSWSBooking2);
        }
    }

    public void removeByPSWorkspace(PSWorkspace pSWorkspace) throws Exception {
        final PSWorkspace pSWorkspace2 = pSWorkspace;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWSBookingServiceBase.this.onBeforeRemoveByPSWorkspace(pSWorkspace2);
                PSWSBookingServiceBase.this.internalRemoveByPSWorkspace(pSWorkspace2);
                PSWSBookingServiceBase.this.onAfterRemoveByPSWorkspace(pSWorkspace2);
            }
        });
    }

    protected void onBeforeRemoveByPSWorkspace(PSWorkspace pSWorkspace) throws Exception {
    }

    protected void internalRemoveByPSWorkspace(PSWorkspace pSWorkspace) throws Exception {
        ArrayList<PSWSBooking> arrayList = this.selectByPSWorkspace(pSWorkspace);
        this.onBeforeRemoveByPSWorkspace(pSWorkspace, arrayList);
        for (PSWSBooking pSWSBooking : arrayList) {
            this.remove(pSWSBooking);
        }
        this.onAfterRemoveByPSWorkspace(pSWorkspace, arrayList);
    }

    protected void onAfterRemoveByPSWorkspace(PSWorkspace pSWorkspace) throws Exception {
    }

    protected void onBeforeRemoveByPSWorkspace(PSWorkspace pSWorkspace, ArrayList<PSWSBooking> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSWorkspace(PSWorkspace pSWorkspace, ArrayList<PSWSBooking> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSWSBooking pSWSBooking) throws Exception {
        super.onBeforeRemove(pSWSBooking);
    }

    protected void replaceParentInfo(PSWSBooking pSWSBooking, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSWSBooking, cloneSession);
        if (pSWSBooking.getPSDCWorkspaceId() != null && (iEntity = cloneSession.getEntity("PSDCWORKSPACE", (Object)pSWSBooking.getPSDCWorkspaceId())) != null) {
            this.onFillParentInfo_PSDCWorkspace(pSWSBooking, (PSDCWorkspace)iEntity);
        }
        if (pSWSBooking.getPSDevCenterId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTER", (Object)pSWSBooking.getPSDevCenterId())) != null) {
            this.onFillParentInfo_PSDevCenter(pSWSBooking, (PSDevCenter)iEntity);
        }
        if (pSWSBooking.getPSSvrDomainId() != null && (iEntity = cloneSession.getEntity("PSSVRDOMAIN", (Object)pSWSBooking.getPSSvrDomainId())) != null) {
            this.onFillParentInfo_PSSvrDomain(pSWSBooking, (PSSvrDomain)iEntity);
        }
        if (pSWSBooking.getPSTaskServerId() != null && (iEntity = cloneSession.getEntity("PSTASKSERVER", (Object)pSWSBooking.getPSTaskServerId())) != null) {
            this.onFillParentInfo_PSTaskServer(pSWSBooking, (PSTaskServer)iEntity);
        }
        if (pSWSBooking.getPSWorkspaceId() != null && (iEntity = cloneSession.getEntity("PSWORKSPACE", (Object)pSWSBooking.getPSWorkspaceId())) != null) {
            this.onFillParentInfo_PSWorkspace(pSWSBooking, (PSWorkspace)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSWSBooking pSWSBooking, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSWSBooking, bl);
    }

    protected void onCheckEntity(boolean bl, PSWSBooking pSWSBooking, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_BeginTime(bl, pSWSBooking, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BookingInfo(bl, pSWSBooking, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BookingParam(bl, pSWSBooking, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BookingParam2(bl, pSWSBooking, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BookingParam3(bl, pSWSBooking, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BookingParam4(bl, pSWSBooking, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BookingState(bl, pSWSBooking, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BookingType(bl, pSWSBooking, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Duration(bl, pSWSBooking, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EndTime(bl, pSWSBooking, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Hours(bl, pSWSBooking, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSWSBooking, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCWorkspaceId(bl, pSWSBooking, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCWorkspaceName(bl, pSWSBooking, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterId(bl, pSWSBooking, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterName(bl, pSWSBooking, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSvrDomainId(bl, pSWSBooking, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSvrDomainName(bl, pSWSBooking, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSTaskServerId(bl, pSWSBooking, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSTaskServerName(bl, pSWSBooking, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWorkspaceId(bl, pSWSBooking, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWorkspaceName(bl, pSWSBooking, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWSBookingId(bl, pSWSBooking, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWSBookingName(bl, pSWSBooking, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSWSBooking, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_BeginTime(boolean bl, PSWSBooking pSWSBooking, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWSBooking.isBeginTimeDirty() && !bl2 : !pSWSBooking.isBeginTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSWSBooking.getBeginTime();
        if (bl) {
            if (bl2 && timestamp == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BEGINTIME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_BeginTime_Default(pSWSBooking, bl2, bl3);
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

    protected EntityFieldError onCheckField_BookingInfo(boolean bl, PSWSBooking pSWSBooking, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWSBooking.isBookingInfoDirty() : !pSWSBooking.isBookingInfoDirty()) {
            return null;
        }
        String string = pSWSBooking.getBookingInfo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BookingInfo_Default(pSWSBooking, bl2, bl3);
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

    protected EntityFieldError onCheckField_BookingParam(boolean bl, PSWSBooking pSWSBooking, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWSBooking.isBookingParamDirty() : !pSWSBooking.isBookingParamDirty()) {
            return null;
        }
        String string = pSWSBooking.getBookingParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BookingParam_Default(pSWSBooking, bl2, bl3);
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

    protected EntityFieldError onCheckField_BookingParam2(boolean bl, PSWSBooking pSWSBooking, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWSBooking.isBookingParam2Dirty() : !pSWSBooking.isBookingParam2Dirty()) {
            return null;
        }
        String string = pSWSBooking.getBookingParam2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BookingParam2_Default(pSWSBooking, bl2, bl3);
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

    protected EntityFieldError onCheckField_BookingParam3(boolean bl, PSWSBooking pSWSBooking, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWSBooking.isBookingParam3Dirty() : !pSWSBooking.isBookingParam3Dirty()) {
            return null;
        }
        String string = pSWSBooking.getBookingParam3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BookingParam3_Default(pSWSBooking, bl2, bl3);
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

    protected EntityFieldError onCheckField_BookingParam4(boolean bl, PSWSBooking pSWSBooking, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWSBooking.isBookingParam4Dirty() : !pSWSBooking.isBookingParam4Dirty()) {
            return null;
        }
        String string = pSWSBooking.getBookingParam4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BookingParam4_Default(pSWSBooking, bl2, bl3);
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

    protected EntityFieldError onCheckField_BookingState(boolean bl, PSWSBooking pSWSBooking, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWSBooking.isBookingStateDirty() && !bl2 : !pSWSBooking.isBookingStateDirty()) {
            return null;
        }
        Integer n = pSWSBooking.getBookingState();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BOOKINGSTATE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_BookingState_Default(pSWSBooking, bl2, bl3);
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

    protected EntityFieldError onCheckField_BookingType(boolean bl, PSWSBooking pSWSBooking, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWSBooking.isBookingTypeDirty() && !bl2 : !pSWSBooking.isBookingTypeDirty()) {
            return null;
        }
        String string = pSWSBooking.getBookingType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BOOKINGTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_BookingType_Default(pSWSBooking, bl2, bl3);
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

    protected EntityFieldError onCheckField_Duration(boolean bl, PSWSBooking pSWSBooking, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWSBooking.isDurationDirty() && !bl2 : !pSWSBooking.isDurationDirty()) {
            return null;
        }
        Integer n = pSWSBooking.getDuration();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DURATION");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_Duration_Default(pSWSBooking, bl2, bl3);
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

    protected EntityFieldError onCheckField_EndTime(boolean bl, PSWSBooking pSWSBooking, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWSBooking.isEndTimeDirty() && !bl2 : !pSWSBooking.isEndTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSWSBooking.getEndTime();
        if (bl) {
            if (bl2 && timestamp == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENDTIME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_EndTime_Default(pSWSBooking, bl2, bl3);
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

    protected EntityFieldError onCheckField_Hours(boolean bl, PSWSBooking pSWSBooking, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWSBooking.isHoursDirty() : !pSWSBooking.isHoursDirty()) {
            return null;
        }
        Integer n = pSWSBooking.getHours();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Hours_Default(pSWSBooking, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSWSBooking pSWSBooking, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWSBooking.isMemoDirty() : !pSWSBooking.isMemoDirty()) {
            return null;
        }
        String string = pSWSBooking.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSWSBooking, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDCWorkspaceId(boolean bl, PSWSBooking pSWSBooking, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWSBooking.isPSDCWorkspaceIdDirty() : !pSWSBooking.isPSDCWorkspaceIdDirty()) {
            return null;
        }
        String string = pSWSBooking.getPSDCWorkspaceId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCWorkspaceId_Default(pSWSBooking, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCWORKSPACEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCWorkspaceName(boolean bl, PSWSBooking pSWSBooking, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWSBooking.isPSDCWorkspaceNameDirty() : !pSWSBooking.isPSDCWorkspaceNameDirty()) {
            return null;
        }
        String string = pSWSBooking.getPSDCWorkspaceName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCWorkspaceName_Default(pSWSBooking, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCWORKSPACENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterId(boolean bl, PSWSBooking pSWSBooking, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWSBooking.isPSDevCenterIdDirty() : !pSWSBooking.isPSDevCenterIdDirty()) {
            return null;
        }
        String string = pSWSBooking.getPSDevCenterId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterId_Default(pSWSBooking, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevCenterName(boolean bl, PSWSBooking pSWSBooking, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWSBooking.isPSDevCenterNameDirty() : !pSWSBooking.isPSDevCenterNameDirty()) {
            return null;
        }
        String string = pSWSBooking.getPSDevCenterName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterName_Default(pSWSBooking, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSvrDomainId(boolean bl, PSWSBooking pSWSBooking, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWSBooking.isPSSvrDomainIdDirty() : !pSWSBooking.isPSSvrDomainIdDirty()) {
            return null;
        }
        String string = pSWSBooking.getPSSvrDomainId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSvrDomainId_Default(pSWSBooking, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSvrDomainName(boolean bl, PSWSBooking pSWSBooking, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWSBooking.isPSSvrDomainNameDirty() : !pSWSBooking.isPSSvrDomainNameDirty()) {
            return null;
        }
        String string = pSWSBooking.getPSSvrDomainName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSvrDomainName_Default(pSWSBooking, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSTaskServerId(boolean bl, PSWSBooking pSWSBooking, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWSBooking.isPSTaskServerIdDirty() : !pSWSBooking.isPSTaskServerIdDirty()) {
            return null;
        }
        String string = pSWSBooking.getPSTaskServerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSTaskServerId_Default(pSWSBooking, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSTaskServerName(boolean bl, PSWSBooking pSWSBooking, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWSBooking.isPSTaskServerNameDirty() : !pSWSBooking.isPSTaskServerNameDirty()) {
            return null;
        }
        String string = pSWSBooking.getPSTaskServerName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSTaskServerName_Default(pSWSBooking, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSWorkspaceId(boolean bl, PSWSBooking pSWSBooking, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWSBooking.isPSWorkspaceIdDirty() : !pSWSBooking.isPSWorkspaceIdDirty()) {
            return null;
        }
        String string = pSWSBooking.getPSWorkspaceId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWorkspaceId_Default(pSWSBooking, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWORKSPACEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWorkspaceName(boolean bl, PSWSBooking pSWSBooking, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWSBooking.isPSWorkspaceNameDirty() : !pSWSBooking.isPSWorkspaceNameDirty()) {
            return null;
        }
        String string = pSWSBooking.getPSWorkspaceName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWorkspaceName_Default(pSWSBooking, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWORKSPACENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWSBookingId(boolean bl, PSWSBooking pSWSBooking, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWSBooking.isPSWSBookingIdDirty() && !bl2 : !pSWSBooking.isPSWSBookingIdDirty()) {
            return null;
        }
        String string = pSWSBooking.getPSWSBookingId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWSBOOKINGID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWSBookingId_Default(pSWSBooking, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWSBOOKINGID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWSBookingName(boolean bl, PSWSBooking pSWSBooking, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWSBooking.isPSWSBookingNameDirty() && !bl2 : !pSWSBooking.isPSWSBookingNameDirty()) {
            return null;
        }
        String string = pSWSBooking.getPSWSBookingName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWSBOOKINGNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWSBookingName_Default(pSWSBooking, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWSBOOKINGNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSWSBooking pSWSBooking, boolean bl) throws Exception {
        super.onSyncEntity(pSWSBooking, bl);
    }

    protected void onSyncIndexEntities(PSWSBooking pSWSBooking, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSWSBooking, bl);
    }

    public Object getDataContextValue(PSWSBooking pSWSBooking, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSWSBooking, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSWSBooking pSWSBooking, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSWSBooking, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"PSDCWORKSPACEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCWorkspaceId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCWORKSPACENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCWorkspaceName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSTASKSERVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSTaskServerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSTASKSERVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSTaskServerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWORKSPACEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWorkspaceId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWORKSPACENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWorkspaceName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWSBOOKINGID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWSBookingId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWSBOOKINGNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWSBookingName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSDCWorkspaceId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCWORKSPACEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCWorkspaceName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCWORKSPACENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSWorkspaceId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWORKSPACEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWorkspaceName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWORKSPACENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWSBookingId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWSBOOKINGID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWSBookingName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWSBOOKINGNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSWSBooking pSWSBooking) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSWSBooking)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSWSBooking pSWSBooking) throws Exception {
        super.onUpdateParent(pSWSBooking);
    }

    @Override
    protected void exportCurXmlModel(PSWSBooking pSWSBooking, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSWSBOOKING");
        if (!bl) {
            pSWSBooking.setCreateDate(null);
            pSWSBooking.setCreateMan(null);
            pSWSBooking.setPSWSBookingId(null);
            pSWSBooking.setUpdateDate(null);
            pSWSBooking.setUpdateMan(null);
            super.exportCurXmlModel(pSWSBooking, xmlNode, bl);
        }
    }
}

