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
import net.ibizsys.pscore.srv.devcenter.entity.PSDCWorkspace;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCWorkspaceBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterBase;
import net.ibizsys.pscore.srv.paasmgr.dao.PSWSBookingLogDAO;
import net.ibizsys.pscore.srv.paasmgr.demodel.PSWSBookingLogDEModel;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSvrDomain;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSvrDomainBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSTaskServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSTaskServerBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSWSBookingLog;
import net.ibizsys.pscore.srv.paasmgr.entity.PSWorkspace;
import net.ibizsys.pscore.srv.paasmgr.entity.PSWorkspaceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSWSBookingLogServiceBase
extends PSCoreSysServiceBase<PSWSBookingLog> {
    private static final Log log = LogFactory.getLog(PSWSBookingLogServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSWSBookingLogDEModel pSWSBookingLogDEModel;
    private PSWSBookingLogDAO pSWSBookingLogDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.paasmgr.service.PSWSBookingLogService";
    }

    public PSWSBookingLogDEModel getPSWSBookingLogDEModel() {
        if (this.pSWSBookingLogDEModel == null) {
            try {
                this.pSWSBookingLogDEModel = (PSWSBookingLogDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.paasmgr.demodel.PSWSBookingLogDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSWSBookingLogDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSWSBookingLogDEModel();
    }

    public PSWSBookingLogDAO getPSWSBookingLogDAO() {
        if (this.pSWSBookingLogDAO == null) {
            try {
                this.pSWSBookingLogDAO = (PSWSBookingLogDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.paasmgr.dao.PSWSBookingLogDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSWSBookingLogDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSWSBookingLogDAO();
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

    protected void onFillParentInfo(PSWSBookingLog pSWSBookingLog, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWSBOOKINGLOG_PSDCWORKSPACE_PSDCWORKSPACEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCWorkspaceService", (SessionFactory)this.getSessionFactory());
            PSDCWorkspace pSDCWorkspace = (PSDCWorkspace)iService.getDEModel().createEntity();
            pSDCWorkspace.set("PSDCWORKSPACEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDCWorkspace);
            } else {
                iService.get(pSDCWorkspace);
            }
            this.onFillParentInfo_PSDCWorkspace(pSWSBookingLog, pSDCWorkspace);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWSBOOKINGLOG_PSDEVCENTER_PSDEVCENTERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService", (SessionFactory)this.getSessionFactory());
            PSDevCenter pSDevCenter = (PSDevCenter)iService.getDEModel().createEntity();
            pSDevCenter.set("PSDEVCENTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenter);
            } else {
                iService.get(pSDevCenter);
            }
            this.onFillParentInfo_PSDevCenter(pSWSBookingLog, pSDevCenter);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWSBOOKINGLOG_PSSVRDOMAIN_PSSVRDOMAINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSSvrDomainService", (SessionFactory)this.getSessionFactory());
            PSSvrDomain pSSvrDomain = (PSSvrDomain)iService.getDEModel().createEntity();
            pSSvrDomain.set("PSSVRDOMAINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSvrDomain);
            } else {
                iService.get(pSSvrDomain);
            }
            this.onFillParentInfo_PSSvrDomain(pSWSBookingLog, pSSvrDomain);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWSBOOKINGLOG_PSTASKSERVER_PSTASKSERVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSTaskServerService", (SessionFactory)this.getSessionFactory());
            PSTaskServer pSTaskServer = (PSTaskServer)iService.getDEModel().createEntity();
            pSTaskServer.set("PSTASKSERVERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSTaskServer);
            } else {
                iService.get(pSTaskServer);
            }
            this.onFillParentInfo_PSTaskServer(pSWSBookingLog, pSTaskServer);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWSBOOKINGLOG_PSWORKSPACE_PSWORKSPACEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSWorkspaceService", (SessionFactory)this.getSessionFactory());
            PSWorkspace pSWorkspace = (PSWorkspace)iService.getDEModel().createEntity();
            pSWorkspace.set("PSWORKSPACEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSWorkspace);
            } else {
                iService.get(pSWorkspace);
            }
            this.onFillParentInfo_PSWorkspace(pSWSBookingLog, pSWorkspace);
            return;
        }
        super.onFillParentInfo(pSWSBookingLog, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDCWorkspace(PSWSBookingLog pSWSBookingLog, PSDCWorkspace pSDCWorkspace) throws Exception {
        pSWSBookingLog.setPSDCWorkspaceId(pSDCWorkspace.getPSDCWorkspaceId());
        pSWSBookingLog.setPSDCWorkspaceName(pSDCWorkspace.getPSDCWorkspaceName());
    }

    protected void onFillParentInfo_PSDevCenter(PSWSBookingLog pSWSBookingLog, PSDevCenter pSDevCenter) throws Exception {
        pSWSBookingLog.setPSDevCenterId(pSDevCenter.getPSDevCenterId());
        pSWSBookingLog.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
    }

    protected void onFillParentInfo_PSSvrDomain(PSWSBookingLog pSWSBookingLog, PSSvrDomain pSSvrDomain) throws Exception {
        pSWSBookingLog.setPSSvrDomainId(pSSvrDomain.getPSSvrDomainId());
        pSWSBookingLog.setPSSvrDomainName(pSSvrDomain.getPSSvrDomainName());
    }

    protected void onFillParentInfo_PSTaskServer(PSWSBookingLog pSWSBookingLog, PSTaskServer pSTaskServer) throws Exception {
        pSWSBookingLog.setPSTaskServerId(pSTaskServer.getPSTaskServerId());
        pSWSBookingLog.setPSTaskServerName(pSTaskServer.getPSTaskServerName());
    }

    protected void onFillParentInfo_PSWorkspace(PSWSBookingLog pSWSBookingLog, PSWorkspace pSWorkspace) throws Exception {
        pSWSBookingLog.setPSWorkspaceId(pSWorkspace.getPSWorkspaceId());
        pSWSBookingLog.setPSWorkspaceName(pSWorkspace.getPSWorkspaceName());
    }

    protected void onFillEntityFullInfo(PSWSBookingLog pSWSBookingLog, boolean bl) throws Exception {
        if (bl) {
            if (pSWSBookingLog.getBackupState() == null) {
                pSWSBookingLog.setBackupState((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSWSBookingLog.getRestoreState() == null) {
                pSWSBookingLog.setRestoreState((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
        }
        super.onFillEntityFullInfo(pSWSBookingLog, bl);
        this.onFillEntityFullInfo_PSDCWorkspace(pSWSBookingLog, bl);
        this.onFillEntityFullInfo_PSDevCenter(pSWSBookingLog, bl);
        this.onFillEntityFullInfo_PSSvrDomain(pSWSBookingLog, bl);
        this.onFillEntityFullInfo_PSTaskServer(pSWSBookingLog, bl);
        this.onFillEntityFullInfo_PSWorkspace(pSWSBookingLog, bl);
    }

    protected void onFillEntityFullInfo_PSDCWorkspace(PSWSBookingLog pSWSBookingLog, boolean bl) throws Exception {
        if (pSWSBookingLog.isPSDCWorkspaceIdDirty()) {
            if (pSWSBookingLog.getPSDCWorkspaceId() != null) {
                if (pSWSBookingLog.getPSDCWorkspaceId() == null || pSWSBookingLog.getPSDCWorkspaceName() == null) {
                    PSDCWorkspace pSDCWorkspace = pSWSBookingLog.getPSDCWorkspace();
                    pSWSBookingLog.setPSDCWorkspaceName(pSDCWorkspace.getPSDCWorkspaceName());
                }
            } else {
                pSWSBookingLog.setPSDCWorkspaceName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDevCenter(PSWSBookingLog pSWSBookingLog, boolean bl) throws Exception {
        if (pSWSBookingLog.isPSDevCenterIdDirty()) {
            if (pSWSBookingLog.getPSDevCenterId() != null) {
                if (pSWSBookingLog.getPSDevCenterId() == null || pSWSBookingLog.getPSDevCenterName() == null) {
                    PSDevCenter pSDevCenter = pSWSBookingLog.getPSDevCenter();
                    pSWSBookingLog.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
                }
            } else {
                pSWSBookingLog.setPSDevCenterName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSvrDomain(PSWSBookingLog pSWSBookingLog, boolean bl) throws Exception {
        if (pSWSBookingLog.isPSSvrDomainIdDirty()) {
            if (pSWSBookingLog.getPSSvrDomainId() != null) {
                if (pSWSBookingLog.getPSSvrDomainId() == null || pSWSBookingLog.getPSSvrDomainName() == null) {
                    PSSvrDomain pSSvrDomain = pSWSBookingLog.getPSSvrDomain();
                    pSWSBookingLog.setPSSvrDomainName(pSSvrDomain.getPSSvrDomainName());
                }
            } else {
                pSWSBookingLog.setPSSvrDomainName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSTaskServer(PSWSBookingLog pSWSBookingLog, boolean bl) throws Exception {
        if (pSWSBookingLog.isPSTaskServerIdDirty()) {
            if (pSWSBookingLog.getPSTaskServerId() != null) {
                if (pSWSBookingLog.getPSTaskServerId() == null || pSWSBookingLog.getPSTaskServerName() == null) {
                    PSTaskServer pSTaskServer = pSWSBookingLog.getPSTaskServer();
                    pSWSBookingLog.setPSTaskServerName(pSTaskServer.getPSTaskServerName());
                }
            } else {
                pSWSBookingLog.setPSTaskServerName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSWorkspace(PSWSBookingLog pSWSBookingLog, boolean bl) throws Exception {
        if (pSWSBookingLog.isPSWorkspaceIdDirty()) {
            if (pSWSBookingLog.getPSWorkspaceId() != null) {
                if (pSWSBookingLog.getPSWorkspaceId() == null || pSWSBookingLog.getPSWorkspaceName() == null) {
                    PSWorkspace pSWorkspace = pSWSBookingLog.getPSWorkspace();
                    pSWSBookingLog.setPSWorkspaceName(pSWorkspace.getPSWorkspaceName());
                }
            } else {
                pSWSBookingLog.setPSWorkspaceName(null);
            }
        }
    }

    protected void onWriteBackParent(PSWSBookingLog pSWSBookingLog, boolean bl) throws Exception {
        super.onWriteBackParent(pSWSBookingLog, bl);
    }

    public ArrayList<PSWSBookingLog> selectByPSDCWorkspace(PSDCWorkspaceBase pSDCWorkspaceBase) throws Exception {
        return this.selectByPSDCWorkspace(pSDCWorkspaceBase, "", -1);
    }

    public ArrayList<PSWSBookingLog> selectByPSDCWorkspace(PSDCWorkspaceBase pSDCWorkspaceBase, String string) throws Exception {
        return this.selectByPSDCWorkspace(pSDCWorkspaceBase, string, -1);
    }

    public ArrayList<PSWSBookingLog> selectByPSDCWorkspace(PSDCWorkspaceBase pSDCWorkspaceBase, String string, int n) throws Exception {
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

    public ArrayList<PSWSBookingLog> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, "", -1);
    }

    public ArrayList<PSWSBookingLog> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, string, -1);
    }

    public ArrayList<PSWSBookingLog> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string, int n) throws Exception {
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

    public ArrayList<PSWSBookingLog> selectByPSSvrDomain(PSSvrDomainBase pSSvrDomainBase) throws Exception {
        return this.selectByPSSvrDomain(pSSvrDomainBase, "", -1);
    }

    public ArrayList<PSWSBookingLog> selectByPSSvrDomain(PSSvrDomainBase pSSvrDomainBase, String string) throws Exception {
        return this.selectByPSSvrDomain(pSSvrDomainBase, string, -1);
    }

    public ArrayList<PSWSBookingLog> selectByPSSvrDomain(PSSvrDomainBase pSSvrDomainBase, String string, int n) throws Exception {
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

    public ArrayList<PSWSBookingLog> selectByPSTaskServer(PSTaskServerBase pSTaskServerBase) throws Exception {
        return this.selectByPSTaskServer(pSTaskServerBase, "", -1);
    }

    public ArrayList<PSWSBookingLog> selectByPSTaskServer(PSTaskServerBase pSTaskServerBase, String string) throws Exception {
        return this.selectByPSTaskServer(pSTaskServerBase, string, -1);
    }

    public ArrayList<PSWSBookingLog> selectByPSTaskServer(PSTaskServerBase pSTaskServerBase, String string, int n) throws Exception {
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

    public ArrayList<PSWSBookingLog> selectByPSWorkspace(PSWorkspaceBase pSWorkspaceBase) throws Exception {
        return this.selectByPSWorkspace(pSWorkspaceBase, "", -1);
    }

    public ArrayList<PSWSBookingLog> selectByPSWorkspace(PSWorkspaceBase pSWorkspaceBase, String string) throws Exception {
        return this.selectByPSWorkspace(pSWorkspaceBase, string, -1);
    }

    public ArrayList<PSWSBookingLog> selectByPSWorkspace(PSWorkspaceBase pSWorkspaceBase, String string, int n) throws Exception {
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
        ArrayList<PSWSBookingLog> arrayList = this.selectByPSDCWorkspace(pSDCWorkspace);
        for (PSWSBookingLog pSWSBookingLog : arrayList) {
            PSWSBookingLog pSWSBookingLog2 = (PSWSBookingLog)this.getDEModel().createEntity();
            pSWSBookingLog2.setPSWSBookingLogId(pSWSBookingLog.getPSWSBookingLogId());
            pSWSBookingLog2.setPSDCWorkspaceId(null);
            this.update(pSWSBookingLog2);
        }
    }

    public void removeByPSDCWorkspace(PSDCWorkspace pSDCWorkspace) throws Exception {
        final PSDCWorkspace pSDCWorkspace2 = pSDCWorkspace;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWSBookingLogServiceBase.this.onBeforeRemoveByPSDCWorkspace(pSDCWorkspace2);
                PSWSBookingLogServiceBase.this.internalRemoveByPSDCWorkspace(pSDCWorkspace2);
                PSWSBookingLogServiceBase.this.onAfterRemoveByPSDCWorkspace(pSDCWorkspace2);
            }
        });
    }

    protected void onBeforeRemoveByPSDCWorkspace(PSDCWorkspace pSDCWorkspace) throws Exception {
    }

    protected void internalRemoveByPSDCWorkspace(PSDCWorkspace pSDCWorkspace) throws Exception {
        ArrayList<PSWSBookingLog> arrayList = this.selectByPSDCWorkspace(pSDCWorkspace);
        this.onBeforeRemoveByPSDCWorkspace(pSDCWorkspace, arrayList);
        for (PSWSBookingLog pSWSBookingLog : arrayList) {
            this.remove(pSWSBookingLog);
        }
        this.onAfterRemoveByPSDCWorkspace(pSDCWorkspace, arrayList);
    }

    protected void onAfterRemoveByPSDCWorkspace(PSDCWorkspace pSDCWorkspace) throws Exception {
    }

    protected void onBeforeRemoveByPSDCWorkspace(PSDCWorkspace pSDCWorkspace, ArrayList<PSWSBookingLog> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDCWorkspace(PSDCWorkspace pSDCWorkspace, ArrayList<PSWSBookingLog> arrayList) throws Exception {
    }

    public void testRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    public void resetPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSWSBookingLog> arrayList = this.selectByPSDevCenter(pSDevCenter);
        for (PSWSBookingLog pSWSBookingLog : arrayList) {
            PSWSBookingLog pSWSBookingLog2 = (PSWSBookingLog)this.getDEModel().createEntity();
            pSWSBookingLog2.setPSWSBookingLogId(pSWSBookingLog.getPSWSBookingLogId());
            pSWSBookingLog2.setPSDevCenterId(null);
            this.update(pSWSBookingLog2);
        }
    }

    public void removeByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        final PSDevCenter pSDevCenter2 = pSDevCenter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWSBookingLogServiceBase.this.onBeforeRemoveByPSDevCenter(pSDevCenter2);
                PSWSBookingLogServiceBase.this.internalRemoveByPSDevCenter(pSDevCenter2);
                PSWSBookingLogServiceBase.this.onAfterRemoveByPSDevCenter(pSDevCenter2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void internalRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSWSBookingLog> arrayList = this.selectByPSDevCenter(pSDevCenter);
        this.onBeforeRemoveByPSDevCenter(pSDevCenter, arrayList);
        for (PSWSBookingLog pSWSBookingLog : arrayList) {
            this.remove(pSWSBookingLog);
        }
        this.onAfterRemoveByPSDevCenter(pSDevCenter, arrayList);
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSWSBookingLog> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSWSBookingLog> arrayList) throws Exception {
    }

    public void testRemoveByPSSvrDomain(PSSvrDomain pSSvrDomain) throws Exception {
    }

    public void resetPSSvrDomain(PSSvrDomain pSSvrDomain) throws Exception {
        ArrayList<PSWSBookingLog> arrayList = this.selectByPSSvrDomain(pSSvrDomain);
        for (PSWSBookingLog pSWSBookingLog : arrayList) {
            PSWSBookingLog pSWSBookingLog2 = (PSWSBookingLog)this.getDEModel().createEntity();
            pSWSBookingLog2.setPSWSBookingLogId(pSWSBookingLog.getPSWSBookingLogId());
            pSWSBookingLog2.setPSSvrDomainId(null);
            this.update(pSWSBookingLog2);
        }
    }

    public void removeByPSSvrDomain(PSSvrDomain pSSvrDomain) throws Exception {
        final PSSvrDomain pSSvrDomain2 = pSSvrDomain;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWSBookingLogServiceBase.this.onBeforeRemoveByPSSvrDomain(pSSvrDomain2);
                PSWSBookingLogServiceBase.this.internalRemoveByPSSvrDomain(pSSvrDomain2);
                PSWSBookingLogServiceBase.this.onAfterRemoveByPSSvrDomain(pSSvrDomain2);
            }
        });
    }

    protected void onBeforeRemoveByPSSvrDomain(PSSvrDomain pSSvrDomain) throws Exception {
    }

    protected void internalRemoveByPSSvrDomain(PSSvrDomain pSSvrDomain) throws Exception {
        ArrayList<PSWSBookingLog> arrayList = this.selectByPSSvrDomain(pSSvrDomain);
        this.onBeforeRemoveByPSSvrDomain(pSSvrDomain, arrayList);
        for (PSWSBookingLog pSWSBookingLog : arrayList) {
            this.remove(pSWSBookingLog);
        }
        this.onAfterRemoveByPSSvrDomain(pSSvrDomain, arrayList);
    }

    protected void onAfterRemoveByPSSvrDomain(PSSvrDomain pSSvrDomain) throws Exception {
    }

    protected void onBeforeRemoveByPSSvrDomain(PSSvrDomain pSSvrDomain, ArrayList<PSWSBookingLog> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSvrDomain(PSSvrDomain pSSvrDomain, ArrayList<PSWSBookingLog> arrayList) throws Exception {
    }

    public void testRemoveByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
    }

    public void resetPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
        ArrayList<PSWSBookingLog> arrayList = this.selectByPSTaskServer(pSTaskServer);
        for (PSWSBookingLog pSWSBookingLog : arrayList) {
            PSWSBookingLog pSWSBookingLog2 = (PSWSBookingLog)this.getDEModel().createEntity();
            pSWSBookingLog2.setPSWSBookingLogId(pSWSBookingLog.getPSWSBookingLogId());
            pSWSBookingLog2.setPSTaskServerId(null);
            this.update(pSWSBookingLog2);
        }
    }

    public void removeByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
        final PSTaskServer pSTaskServer2 = pSTaskServer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWSBookingLogServiceBase.this.onBeforeRemoveByPSTaskServer(pSTaskServer2);
                PSWSBookingLogServiceBase.this.internalRemoveByPSTaskServer(pSTaskServer2);
                PSWSBookingLogServiceBase.this.onAfterRemoveByPSTaskServer(pSTaskServer2);
            }
        });
    }

    protected void onBeforeRemoveByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
    }

    protected void internalRemoveByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
        ArrayList<PSWSBookingLog> arrayList = this.selectByPSTaskServer(pSTaskServer);
        this.onBeforeRemoveByPSTaskServer(pSTaskServer, arrayList);
        for (PSWSBookingLog pSWSBookingLog : arrayList) {
            this.remove(pSWSBookingLog);
        }
        this.onAfterRemoveByPSTaskServer(pSTaskServer, arrayList);
    }

    protected void onAfterRemoveByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
    }

    protected void onBeforeRemoveByPSTaskServer(PSTaskServer pSTaskServer, ArrayList<PSWSBookingLog> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSTaskServer(PSTaskServer pSTaskServer, ArrayList<PSWSBookingLog> arrayList) throws Exception {
    }

    public void testRemoveByPSWorkspace(PSWorkspace pSWorkspace) throws Exception {
    }

    public void resetPSWorkspace(PSWorkspace pSWorkspace) throws Exception {
        ArrayList<PSWSBookingLog> arrayList = this.selectByPSWorkspace(pSWorkspace);
        for (PSWSBookingLog pSWSBookingLog : arrayList) {
            PSWSBookingLog pSWSBookingLog2 = (PSWSBookingLog)this.getDEModel().createEntity();
            pSWSBookingLog2.setPSWSBookingLogId(pSWSBookingLog.getPSWSBookingLogId());
            pSWSBookingLog2.setPSWorkspaceId(null);
            this.update(pSWSBookingLog2);
        }
    }

    public void removeByPSWorkspace(PSWorkspace pSWorkspace) throws Exception {
        final PSWorkspace pSWorkspace2 = pSWorkspace;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWSBookingLogServiceBase.this.onBeforeRemoveByPSWorkspace(pSWorkspace2);
                PSWSBookingLogServiceBase.this.internalRemoveByPSWorkspace(pSWorkspace2);
                PSWSBookingLogServiceBase.this.onAfterRemoveByPSWorkspace(pSWorkspace2);
            }
        });
    }

    protected void onBeforeRemoveByPSWorkspace(PSWorkspace pSWorkspace) throws Exception {
    }

    protected void internalRemoveByPSWorkspace(PSWorkspace pSWorkspace) throws Exception {
        ArrayList<PSWSBookingLog> arrayList = this.selectByPSWorkspace(pSWorkspace);
        this.onBeforeRemoveByPSWorkspace(pSWorkspace, arrayList);
        for (PSWSBookingLog pSWSBookingLog : arrayList) {
            this.remove(pSWSBookingLog);
        }
        this.onAfterRemoveByPSWorkspace(pSWorkspace, arrayList);
    }

    protected void onAfterRemoveByPSWorkspace(PSWorkspace pSWorkspace) throws Exception {
    }

    protected void onBeforeRemoveByPSWorkspace(PSWorkspace pSWorkspace, ArrayList<PSWSBookingLog> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSWorkspace(PSWorkspace pSWorkspace, ArrayList<PSWSBookingLog> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSWSBookingLog pSWSBookingLog) throws Exception {
        super.onBeforeRemove(pSWSBookingLog);
    }

    protected void replaceParentInfo(PSWSBookingLog pSWSBookingLog, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSWSBookingLog, cloneSession);
        if (pSWSBookingLog.getPSDCWorkspaceId() != null && (iEntity = cloneSession.getEntity("PSDCWORKSPACE", (Object)pSWSBookingLog.getPSDCWorkspaceId())) != null) {
            this.onFillParentInfo_PSDCWorkspace(pSWSBookingLog, (PSDCWorkspace)iEntity);
        }
        if (pSWSBookingLog.getPSDevCenterId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTER", (Object)pSWSBookingLog.getPSDevCenterId())) != null) {
            this.onFillParentInfo_PSDevCenter(pSWSBookingLog, (PSDevCenter)iEntity);
        }
        if (pSWSBookingLog.getPSSvrDomainId() != null && (iEntity = cloneSession.getEntity("PSSVRDOMAIN", (Object)pSWSBookingLog.getPSSvrDomainId())) != null) {
            this.onFillParentInfo_PSSvrDomain(pSWSBookingLog, (PSSvrDomain)iEntity);
        }
        if (pSWSBookingLog.getPSTaskServerId() != null && (iEntity = cloneSession.getEntity("PSTASKSERVER", (Object)pSWSBookingLog.getPSTaskServerId())) != null) {
            this.onFillParentInfo_PSTaskServer(pSWSBookingLog, (PSTaskServer)iEntity);
        }
        if (pSWSBookingLog.getPSWorkspaceId() != null && (iEntity = cloneSession.getEntity("PSWORKSPACE", (Object)pSWSBookingLog.getPSWorkspaceId())) != null) {
            this.onFillParentInfo_PSWorkspace(pSWSBookingLog, (PSWorkspace)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSWSBookingLog pSWSBookingLog, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSWSBookingLog, bl);
    }

    protected void onCheckEntity(boolean bl, PSWSBookingLog pSWSBookingLog, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_BackupInfo(bl, pSWSBookingLog, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BackupState(bl, pSWSBookingLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BeginTime(bl, pSWSBookingLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BookingInfo(bl, pSWSBookingLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BookingParam(bl, pSWSBookingLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BookingParam2(bl, pSWSBookingLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BookingParam3(bl, pSWSBookingLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BookingParam4(bl, pSWSBookingLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BookingState(bl, pSWSBookingLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BookingType(bl, pSWSBookingLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Duration(bl, pSWSBookingLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EndTime(bl, pSWSBookingLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Hours(bl, pSWSBookingLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogInfo(bl, pSWSBookingLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSWSBookingLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCWorkspaceId(bl, pSWSBookingLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCWorkspaceName(bl, pSWSBookingLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterId(bl, pSWSBookingLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterName(bl, pSWSBookingLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSvrDomainId(bl, pSWSBookingLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSvrDomainName(bl, pSWSBookingLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSTaskServerId(bl, pSWSBookingLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSTaskServerName(bl, pSWSBookingLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWorkspaceId(bl, pSWSBookingLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWorkspaceName(bl, pSWSBookingLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWSBookingLogId(bl, pSWSBookingLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWSBookingLogName(bl, pSWSBookingLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RestoreInfo(bl, pSWSBookingLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RestoreState(bl, pSWSBookingLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSWSBookingLog, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_BackupInfo(boolean bl, PSWSBookingLog pSWSBookingLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWSBookingLog.isBackupInfoDirty() : !pSWSBookingLog.isBackupInfoDirty()) {
            return null;
        }
        String string = pSWSBookingLog.getBackupInfo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BackupInfo_Default(pSWSBookingLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_BackupState(boolean bl, PSWSBookingLog pSWSBookingLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWSBookingLog.isBackupStateDirty() && !bl2 : !pSWSBookingLog.isBackupStateDirty()) {
            return null;
        }
        Integer n = pSWSBookingLog.getBackupState();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BACKUPSTATE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_BackupState_Default(pSWSBookingLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_BeginTime(boolean bl, PSWSBookingLog pSWSBookingLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWSBookingLog.isBeginTimeDirty() && !bl2 : !pSWSBookingLog.isBeginTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSWSBookingLog.getBeginTime();
        if (bl) {
            if (bl2 && timestamp == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BEGINTIME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_BeginTime_Default(pSWSBookingLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_BookingInfo(boolean bl, PSWSBookingLog pSWSBookingLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWSBookingLog.isBookingInfoDirty() : !pSWSBookingLog.isBookingInfoDirty()) {
            return null;
        }
        String string = pSWSBookingLog.getBookingInfo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BookingInfo_Default(pSWSBookingLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_BookingParam(boolean bl, PSWSBookingLog pSWSBookingLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWSBookingLog.isBookingParamDirty() : !pSWSBookingLog.isBookingParamDirty()) {
            return null;
        }
        String string = pSWSBookingLog.getBookingParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BookingParam_Default(pSWSBookingLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_BookingParam2(boolean bl, PSWSBookingLog pSWSBookingLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWSBookingLog.isBookingParam2Dirty() : !pSWSBookingLog.isBookingParam2Dirty()) {
            return null;
        }
        String string = pSWSBookingLog.getBookingParam2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BookingParam2_Default(pSWSBookingLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_BookingParam3(boolean bl, PSWSBookingLog pSWSBookingLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWSBookingLog.isBookingParam3Dirty() : !pSWSBookingLog.isBookingParam3Dirty()) {
            return null;
        }
        String string = pSWSBookingLog.getBookingParam3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BookingParam3_Default(pSWSBookingLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_BookingParam4(boolean bl, PSWSBookingLog pSWSBookingLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWSBookingLog.isBookingParam4Dirty() : !pSWSBookingLog.isBookingParam4Dirty()) {
            return null;
        }
        String string = pSWSBookingLog.getBookingParam4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BookingParam4_Default(pSWSBookingLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_BookingState(boolean bl, PSWSBookingLog pSWSBookingLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWSBookingLog.isBookingStateDirty() && !bl2 : !pSWSBookingLog.isBookingStateDirty()) {
            return null;
        }
        Integer n = pSWSBookingLog.getBookingState();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BOOKINGSTATE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_BookingState_Default(pSWSBookingLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_BookingType(boolean bl, PSWSBookingLog pSWSBookingLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWSBookingLog.isBookingTypeDirty() && !bl2 : !pSWSBookingLog.isBookingTypeDirty()) {
            return null;
        }
        String string = pSWSBookingLog.getBookingType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BOOKINGTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_BookingType_Default(pSWSBookingLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_Duration(boolean bl, PSWSBookingLog pSWSBookingLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWSBookingLog.isDurationDirty() : !pSWSBookingLog.isDurationDirty()) {
            return null;
        }
        Integer n = pSWSBookingLog.getDuration();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Duration_Default(pSWSBookingLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_EndTime(boolean bl, PSWSBookingLog pSWSBookingLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWSBookingLog.isEndTimeDirty() && !bl2 : !pSWSBookingLog.isEndTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSWSBookingLog.getEndTime();
        if (bl) {
            if (bl2 && timestamp == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENDTIME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_EndTime_Default(pSWSBookingLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_Hours(boolean bl, PSWSBookingLog pSWSBookingLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWSBookingLog.isHoursDirty() : !pSWSBookingLog.isHoursDirty()) {
            return null;
        }
        Integer n = pSWSBookingLog.getHours();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Hours_Default(pSWSBookingLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_LogInfo(boolean bl, PSWSBookingLog pSWSBookingLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWSBookingLog.isLogInfoDirty() : !pSWSBookingLog.isLogInfoDirty()) {
            return null;
        }
        String string = pSWSBookingLog.getLogInfo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogInfo_Default(pSWSBookingLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSWSBookingLog pSWSBookingLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWSBookingLog.isMemoDirty() : !pSWSBookingLog.isMemoDirty()) {
            return null;
        }
        String string = pSWSBookingLog.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSWSBookingLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDCWorkspaceId(boolean bl, PSWSBookingLog pSWSBookingLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWSBookingLog.isPSDCWorkspaceIdDirty() : !pSWSBookingLog.isPSDCWorkspaceIdDirty()) {
            return null;
        }
        String string = pSWSBookingLog.getPSDCWorkspaceId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCWorkspaceId_Default(pSWSBookingLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDCWorkspaceName(boolean bl, PSWSBookingLog pSWSBookingLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWSBookingLog.isPSDCWorkspaceNameDirty() : !pSWSBookingLog.isPSDCWorkspaceNameDirty()) {
            return null;
        }
        String string = pSWSBookingLog.getPSDCWorkspaceName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCWorkspaceName_Default(pSWSBookingLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevCenterId(boolean bl, PSWSBookingLog pSWSBookingLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWSBookingLog.isPSDevCenterIdDirty() : !pSWSBookingLog.isPSDevCenterIdDirty()) {
            return null;
        }
        String string = pSWSBookingLog.getPSDevCenterId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterId_Default(pSWSBookingLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevCenterName(boolean bl, PSWSBookingLog pSWSBookingLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWSBookingLog.isPSDevCenterNameDirty() : !pSWSBookingLog.isPSDevCenterNameDirty()) {
            return null;
        }
        String string = pSWSBookingLog.getPSDevCenterName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterName_Default(pSWSBookingLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSvrDomainId(boolean bl, PSWSBookingLog pSWSBookingLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWSBookingLog.isPSSvrDomainIdDirty() : !pSWSBookingLog.isPSSvrDomainIdDirty()) {
            return null;
        }
        String string = pSWSBookingLog.getPSSvrDomainId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSvrDomainId_Default(pSWSBookingLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSvrDomainName(boolean bl, PSWSBookingLog pSWSBookingLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWSBookingLog.isPSSvrDomainNameDirty() : !pSWSBookingLog.isPSSvrDomainNameDirty()) {
            return null;
        }
        String string = pSWSBookingLog.getPSSvrDomainName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSvrDomainName_Default(pSWSBookingLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSTaskServerId(boolean bl, PSWSBookingLog pSWSBookingLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWSBookingLog.isPSTaskServerIdDirty() : !pSWSBookingLog.isPSTaskServerIdDirty()) {
            return null;
        }
        String string = pSWSBookingLog.getPSTaskServerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSTaskServerId_Default(pSWSBookingLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSTaskServerName(boolean bl, PSWSBookingLog pSWSBookingLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWSBookingLog.isPSTaskServerNameDirty() : !pSWSBookingLog.isPSTaskServerNameDirty()) {
            return null;
        }
        String string = pSWSBookingLog.getPSTaskServerName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSTaskServerName_Default(pSWSBookingLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSWorkspaceId(boolean bl, PSWSBookingLog pSWSBookingLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWSBookingLog.isPSWorkspaceIdDirty() : !pSWSBookingLog.isPSWorkspaceIdDirty()) {
            return null;
        }
        String string = pSWSBookingLog.getPSWorkspaceId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWorkspaceId_Default(pSWSBookingLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSWorkspaceName(boolean bl, PSWSBookingLog pSWSBookingLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWSBookingLog.isPSWorkspaceNameDirty() : !pSWSBookingLog.isPSWorkspaceNameDirty()) {
            return null;
        }
        String string = pSWSBookingLog.getPSWorkspaceName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWorkspaceName_Default(pSWSBookingLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSWSBookingLogId(boolean bl, PSWSBookingLog pSWSBookingLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWSBookingLog.isPSWSBookingLogIdDirty() && !bl2 : !pSWSBookingLog.isPSWSBookingLogIdDirty()) {
            return null;
        }
        String string = pSWSBookingLog.getPSWSBookingLogId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWSBOOKINGLOGID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWSBookingLogId_Default(pSWSBookingLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWSBOOKINGLOGID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWSBookingLogName(boolean bl, PSWSBookingLog pSWSBookingLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWSBookingLog.isPSWSBookingLogNameDirty() && !bl2 : !pSWSBookingLog.isPSWSBookingLogNameDirty()) {
            return null;
        }
        String string = pSWSBookingLog.getPSWSBookingLogName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWSBOOKINGLOGNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWSBookingLogName_Default(pSWSBookingLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWSBOOKINGLOGNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RestoreInfo(boolean bl, PSWSBookingLog pSWSBookingLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWSBookingLog.isRestoreInfoDirty() : !pSWSBookingLog.isRestoreInfoDirty()) {
            return null;
        }
        String string = pSWSBookingLog.getRestoreInfo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RestoreInfo_Default(pSWSBookingLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_RestoreState(boolean bl, PSWSBookingLog pSWSBookingLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWSBookingLog.isRestoreStateDirty() && !bl2 : !pSWSBookingLog.isRestoreStateDirty()) {
            return null;
        }
        Integer n = pSWSBookingLog.getRestoreState();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RESTORESTATE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_RestoreState_Default(pSWSBookingLog, bl2, bl3);
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

    protected void onSyncEntity(PSWSBookingLog pSWSBookingLog, boolean bl) throws Exception {
        super.onSyncEntity(pSWSBookingLog, bl);
    }

    protected void onSyncIndexEntities(PSWSBookingLog pSWSBookingLog, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSWSBookingLog, bl);
    }

    public Object getDataContextValue(PSWSBookingLog pSWSBookingLog, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSWSBookingLog, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSWSBookingLog pSWSBookingLog, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSWSBookingLog, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"PSWSBOOKINGLOGID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWSBookingLogId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWSBOOKINGLOGNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWSBookingLogName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSWSBookingLogId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWSBOOKINGLOGID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWSBookingLogName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWSBOOKINGLOGNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSWSBookingLog pSWSBookingLog) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSWSBookingLog)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSWSBookingLog pSWSBookingLog) throws Exception {
        super.onUpdateParent(pSWSBookingLog);
    }

    @Override
    protected void exportCurXmlModel(PSWSBookingLog pSWSBookingLog, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSWSBOOKINGLOG");
        if (!bl) {
            pSWSBookingLog.setCreateDate(null);
            pSWSBookingLog.setCreateMan(null);
            pSWSBookingLog.setPSWSBookingLogId(null);
            pSWSBookingLog.setUpdateDate(null);
            pSWSBookingLog.setUpdateMan(null);
            super.exportCurXmlModel(pSWSBookingLog, xmlNode, bl);
        }
    }
}

