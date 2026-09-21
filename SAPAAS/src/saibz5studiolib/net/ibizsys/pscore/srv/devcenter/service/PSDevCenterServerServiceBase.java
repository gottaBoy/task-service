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
package net.ibizsys.pscore.srv.devcenter.service;

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
import net.ibizsys.pscore.srv.devcenter.dao.PSDevCenterServerDAO;
import net.ibizsys.pscore.srv.devcenter.demodel.PSDevCenterServerDEModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCCluster;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCClusterBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCContainerSpec;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCContainerSpecBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCFile;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCFileBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterServer;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterASService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterASServiceBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSDevServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSDevServerBase;
import net.ibizsys.pscore.srv.paasmgr.service.PSDSBookingService;
import net.ibizsys.pscore.srv.paasmgr.service.PSDSBookingServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnCodeServerService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnCodeServerServiceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevCenterServerServiceBase
extends PSCoreSysServiceBase<PSDevCenterServer> {
    private static final Log log = LogFactory.getLog(PSDevCenterServerServiceBase.class);
    public static final String DATASET_CURDC = "CurDC";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDevCenterServerDEModel pSDevCenterServerDEModel;
    private PSDevCenterServerDAO pSDevCenterServerDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.devcenter.service.PSDevCenterServerService";
    }

    public PSDevCenterServerDEModel getPSDevCenterServerDEModel() {
        if (this.pSDevCenterServerDEModel == null) {
            try {
                this.pSDevCenterServerDEModel = (PSDevCenterServerDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.devcenter.demodel.PSDevCenterServerDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevCenterServerDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDevCenterServerDEModel();
    }

    public PSDevCenterServerDAO getPSDevCenterServerDAO() {
        if (this.pSDevCenterServerDAO == null) {
            try {
                this.pSDevCenterServerDAO = (PSDevCenterServerDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.devcenter.dao.PSDevCenterServerDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevCenterServerDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDevCenterServerDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURDC, (boolean)true) == 0) {
            return this.fetchCurDC(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurDC(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDC, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSDevCenterServer pSDevCenterServer, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVCENTERSERVER_PSDCCLUSTER_PSDCCLUSTERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCClusterService", (SessionFactory)this.getSessionFactory());
            PSDCCluster pSDCCluster = (PSDCCluster)iService.getDEModel().createEntity();
            pSDCCluster.set("PSDCCLUSTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDCCluster);
            } else {
                iService.get((IEntity)pSDCCluster);
            }
            this.onFillParentInfo_PSDCCluster(pSDevCenterServer, pSDCCluster);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVCENTERSERVER_PSDCCONTAINERSPEC_PSDCCONTAINERSPECID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCContainerSpecService", (SessionFactory)this.getSessionFactory());
            PSDCContainerSpec pSDCContainerSpec = (PSDCContainerSpec)iService.getDEModel().createEntity();
            pSDCContainerSpec.set("PSDCCONTAINERSPECID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDCContainerSpec);
            } else {
                iService.get((IEntity)pSDCContainerSpec);
            }
            this.onFillParentInfo_PSDCContainerSpec(pSDevCenterServer, pSDCContainerSpec);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVCENTERSERVER_PSDCFILE_PSDCFILEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCFileService", (SessionFactory)this.getSessionFactory());
            PSDCFile pSDCFile = (PSDCFile)iService.getDEModel().createEntity();
            pSDCFile.set("PSDCFILEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDCFile);
            } else {
                iService.get((IEntity)pSDCFile);
            }
            this.onFillParentInfo_PSDCFile(pSDevCenterServer, pSDCFile);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVCENTERSERVER_PSDEVCENTER_PSDEVCENTERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService", (SessionFactory)this.getSessionFactory());
            PSDevCenter pSDevCenter = (PSDevCenter)iService.getDEModel().createEntity();
            pSDevCenter.set("PSDEVCENTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevCenter);
            } else {
                iService.get((IEntity)pSDevCenter);
            }
            this.onFillParentInfo_PSDevCenter(pSDevCenterServer, pSDevCenter);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVCENTERSERVER_PSDEVSERVER_PSDEVSERVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSDevServerService", (SessionFactory)this.getSessionFactory());
            PSDevServer pSDevServer = (PSDevServer)iService.getDEModel().createEntity();
            pSDevServer.set("PSDEVSERVERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevServer);
            } else {
                iService.get((IEntity)pSDevServer);
            }
            this.onFillParentInfo_PSDevServer(pSDevCenterServer, pSDevServer);
            return;
        }
        super.onFillParentInfo((IEntity)pSDevCenterServer, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDCCluster(PSDevCenterServer pSDevCenterServer, PSDCCluster pSDCCluster) throws Exception {
        pSDevCenterServer.setPSDCClusterId(pSDCCluster.getPSDCClusterId());
        pSDevCenterServer.setPSDCClusterName(pSDCCluster.getPSDCClusterName());
    }

    protected void onFillParentInfo_PSDCContainerSpec(PSDevCenterServer pSDevCenterServer, PSDCContainerSpec pSDCContainerSpec) throws Exception {
        pSDevCenterServer.setPSDCContainerSpecId(pSDCContainerSpec.getPSDCContainerSpecId());
        pSDevCenterServer.setPSDCContainerSpecName(pSDCContainerSpec.getPSDCContainerSpecName());
    }

    protected void onFillParentInfo_PSDCFile(PSDevCenterServer pSDevCenterServer, PSDCFile pSDCFile) throws Exception {
        pSDevCenterServer.setPSDCFileId(pSDCFile.getPSDCFileId());
        pSDevCenterServer.setPSDCFileName(pSDCFile.getPSDCFileName());
    }

    protected void onFillParentInfo_PSDevCenter(PSDevCenterServer pSDevCenterServer, PSDevCenter pSDevCenter) throws Exception {
        pSDevCenterServer.setPSDevCenterId(pSDevCenter.getPSDevCenterId());
        pSDevCenterServer.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
    }

    protected void onFillParentInfo_PSDevServer(PSDevCenterServer pSDevCenterServer, PSDevServer pSDevServer) throws Exception {
        pSDevCenterServer.setPSDevServerId(pSDevServer.getPSDevServerId());
        pSDevCenterServer.setPSDevServerName(pSDevServer.getPSDevServerName());
    }

    protected void onFillEntityFullInfo(PSDevCenterServer pSDevCenterServer, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSDevCenterServer, bl);
        this.onFillEntityFullInfo_PSDCCluster(pSDevCenterServer, bl);
        this.onFillEntityFullInfo_PSDCContainerSpec(pSDevCenterServer, bl);
        this.onFillEntityFullInfo_PSDCFile(pSDevCenterServer, bl);
        this.onFillEntityFullInfo_PSDevCenter(pSDevCenterServer, bl);
        this.onFillEntityFullInfo_PSDevServer(pSDevCenterServer, bl);
    }

    protected void onFillEntityFullInfo_PSDCCluster(PSDevCenterServer pSDevCenterServer, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDCContainerSpec(PSDevCenterServer pSDevCenterServer, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDCFile(PSDevCenterServer pSDevCenterServer, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevCenter(PSDevCenterServer pSDevCenterServer, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevServer(PSDevCenterServer pSDevCenterServer, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDevCenterServer pSDevCenterServer, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDevCenterServer, bl);
    }

    public ArrayList<PSDevCenterServer> selectByPSDCCluster(PSDCClusterBase pSDCClusterBase) throws Exception {
        return this.selectByPSDCCluster(pSDCClusterBase, "", -1);
    }

    public ArrayList<PSDevCenterServer> selectByPSDCCluster(PSDCClusterBase pSDCClusterBase, String string) throws Exception {
        return this.selectByPSDCCluster(pSDCClusterBase, string, -1);
    }

    public ArrayList<PSDevCenterServer> selectByPSDCCluster(PSDCClusterBase pSDCClusterBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDCCLUSTERID", (Object)pSDCClusterBase.getPSDCClusterId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDCClusterCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDCClusterCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevCenterServer> selectByPSDCContainerSpec(PSDCContainerSpecBase pSDCContainerSpecBase) throws Exception {
        return this.selectByPSDCContainerSpec(pSDCContainerSpecBase, "", -1);
    }

    public ArrayList<PSDevCenterServer> selectByPSDCContainerSpec(PSDCContainerSpecBase pSDCContainerSpecBase, String string) throws Exception {
        return this.selectByPSDCContainerSpec(pSDCContainerSpecBase, string, -1);
    }

    public ArrayList<PSDevCenterServer> selectByPSDCContainerSpec(PSDCContainerSpecBase pSDCContainerSpecBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDCCONTAINERSPECID", (Object)pSDCContainerSpecBase.getPSDCContainerSpecId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDCContainerSpecCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDCContainerSpecCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevCenterServer> selectByPSDCFile(PSDCFileBase pSDCFileBase) throws Exception {
        return this.selectByPSDCFile(pSDCFileBase, "", -1);
    }

    public ArrayList<PSDevCenterServer> selectByPSDCFile(PSDCFileBase pSDCFileBase, String string) throws Exception {
        return this.selectByPSDCFile(pSDCFileBase, string, -1);
    }

    public ArrayList<PSDevCenterServer> selectByPSDCFile(PSDCFileBase pSDCFileBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDCFILEID", (Object)pSDCFileBase.getPSDCFileId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDCFileCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDCFileCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevCenterServer> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, "", -1);
    }

    public ArrayList<PSDevCenterServer> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, string, -1);
    }

    public ArrayList<PSDevCenterServer> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string, int n) throws Exception {
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

    public ArrayList<PSDevCenterServer> selectByPSDevServer(PSDevServerBase pSDevServerBase) throws Exception {
        return this.selectByPSDevServer(pSDevServerBase, "", -1);
    }

    public ArrayList<PSDevCenterServer> selectByPSDevServer(PSDevServerBase pSDevServerBase, String string) throws Exception {
        return this.selectByPSDevServer(pSDevServerBase, string, -1);
    }

    public ArrayList<PSDevCenterServer> selectByPSDevServer(PSDevServerBase pSDevServerBase, String string, int n) throws Exception {
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

    public void testRemoveByPSDCCluster(PSDCCluster pSDCCluster) throws Exception {
        ArrayList<PSDevCenterServer> arrayList = this.selectByPSDCCluster(pSDCCluster, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDCCLUSTER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDCCluster);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVCENTERSERVER_PSDCCLUSTER_PSDCCLUSTERID", "", iDataEntityModel.getName(), "PSDEVCENTERSERVER", iDataEntityModel.getDataInfo((IEntity)pSDCCluster), arrayList.get(0)));
        }
    }

    public void resetPSDCCluster(PSDCCluster pSDCCluster) throws Exception {
        ArrayList<PSDevCenterServer> arrayList = this.selectByPSDCCluster(pSDCCluster);
        for (PSDevCenterServer pSDevCenterServer : arrayList) {
            PSDevCenterServer pSDevCenterServer2 = (PSDevCenterServer)this.getDEModel().createEntity();
            pSDevCenterServer2.setPSDevCenterServerId(pSDevCenterServer.getPSDevCenterServerId());
            pSDevCenterServer2.setPSDCClusterId(null);
            this.update(pSDevCenterServer2);
        }
    }

    public void removeByPSDCCluster(PSDCCluster pSDCCluster) throws Exception {
        final PSDCCluster pSDCCluster2 = pSDCCluster;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevCenterServerServiceBase.this.onBeforeRemoveByPSDCCluster(pSDCCluster2);
                PSDevCenterServerServiceBase.this.internalRemoveByPSDCCluster(pSDCCluster2);
                PSDevCenterServerServiceBase.this.onAfterRemoveByPSDCCluster(pSDCCluster2);
            }
        });
    }

    protected void onBeforeRemoveByPSDCCluster(PSDCCluster pSDCCluster) throws Exception {
    }

    protected void internalRemoveByPSDCCluster(PSDCCluster pSDCCluster) throws Exception {
        ArrayList<PSDevCenterServer> arrayList = this.selectByPSDCCluster(pSDCCluster);
        this.onBeforeRemoveByPSDCCluster(pSDCCluster, arrayList);
        for (PSDevCenterServer pSDevCenterServer : arrayList) {
            this.remove((IEntity)pSDevCenterServer);
        }
        this.onAfterRemoveByPSDCCluster(pSDCCluster, arrayList);
    }

    protected void onAfterRemoveByPSDCCluster(PSDCCluster pSDCCluster) throws Exception {
    }

    protected void onBeforeRemoveByPSDCCluster(PSDCCluster pSDCCluster, ArrayList<PSDevCenterServer> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDCCluster(PSDCCluster pSDCCluster, ArrayList<PSDevCenterServer> arrayList) throws Exception {
    }

    public void testRemoveByPSDCContainerSpec(PSDCContainerSpec pSDCContainerSpec) throws Exception {
        ArrayList<PSDevCenterServer> arrayList = this.selectByPSDCContainerSpec(pSDCContainerSpec, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDCCONTAINERSPEC");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDCContainerSpec);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVCENTERSERVER_PSDCCONTAINERSPEC_PSDCCONTAINERSPECID", "", iDataEntityModel.getName(), "PSDEVCENTERSERVER", iDataEntityModel.getDataInfo((IEntity)pSDCContainerSpec), arrayList.get(0)));
        }
    }

    public void resetPSDCContainerSpec(PSDCContainerSpec pSDCContainerSpec) throws Exception {
        ArrayList<PSDevCenterServer> arrayList = this.selectByPSDCContainerSpec(pSDCContainerSpec);
        for (PSDevCenterServer pSDevCenterServer : arrayList) {
            PSDevCenterServer pSDevCenterServer2 = (PSDevCenterServer)this.getDEModel().createEntity();
            pSDevCenterServer2.setPSDevCenterServerId(pSDevCenterServer.getPSDevCenterServerId());
            pSDevCenterServer2.setPSDCContainerSpecId(null);
            this.update(pSDevCenterServer2);
        }
    }

    public void removeByPSDCContainerSpec(PSDCContainerSpec pSDCContainerSpec) throws Exception {
        final PSDCContainerSpec pSDCContainerSpec2 = pSDCContainerSpec;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevCenterServerServiceBase.this.onBeforeRemoveByPSDCContainerSpec(pSDCContainerSpec2);
                PSDevCenterServerServiceBase.this.internalRemoveByPSDCContainerSpec(pSDCContainerSpec2);
                PSDevCenterServerServiceBase.this.onAfterRemoveByPSDCContainerSpec(pSDCContainerSpec2);
            }
        });
    }

    protected void onBeforeRemoveByPSDCContainerSpec(PSDCContainerSpec pSDCContainerSpec) throws Exception {
    }

    protected void internalRemoveByPSDCContainerSpec(PSDCContainerSpec pSDCContainerSpec) throws Exception {
        ArrayList<PSDevCenterServer> arrayList = this.selectByPSDCContainerSpec(pSDCContainerSpec);
        this.onBeforeRemoveByPSDCContainerSpec(pSDCContainerSpec, arrayList);
        for (PSDevCenterServer pSDevCenterServer : arrayList) {
            this.remove((IEntity)pSDevCenterServer);
        }
        this.onAfterRemoveByPSDCContainerSpec(pSDCContainerSpec, arrayList);
    }

    protected void onAfterRemoveByPSDCContainerSpec(PSDCContainerSpec pSDCContainerSpec) throws Exception {
    }

    protected void onBeforeRemoveByPSDCContainerSpec(PSDCContainerSpec pSDCContainerSpec, ArrayList<PSDevCenterServer> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDCContainerSpec(PSDCContainerSpec pSDCContainerSpec, ArrayList<PSDevCenterServer> arrayList) throws Exception {
    }

    public void testRemoveByPSDCFile(PSDCFile pSDCFile) throws Exception {
        ArrayList<PSDevCenterServer> arrayList = this.selectByPSDCFile(pSDCFile, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDCFILE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDCFile);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVCENTERSERVER_PSDCFILE_PSDCFILEID", "", iDataEntityModel.getName(), "PSDEVCENTERSERVER", iDataEntityModel.getDataInfo((IEntity)pSDCFile), arrayList.get(0)));
        }
    }

    public void resetPSDCFile(PSDCFile pSDCFile) throws Exception {
        ArrayList<PSDevCenterServer> arrayList = this.selectByPSDCFile(pSDCFile);
        for (PSDevCenterServer pSDevCenterServer : arrayList) {
            PSDevCenterServer pSDevCenterServer2 = (PSDevCenterServer)this.getDEModel().createEntity();
            pSDevCenterServer2.setPSDevCenterServerId(pSDevCenterServer.getPSDevCenterServerId());
            pSDevCenterServer2.setPSDCFileId(null);
            this.update(pSDevCenterServer2);
        }
    }

    public void removeByPSDCFile(PSDCFile pSDCFile) throws Exception {
        final PSDCFile pSDCFile2 = pSDCFile;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevCenterServerServiceBase.this.onBeforeRemoveByPSDCFile(pSDCFile2);
                PSDevCenterServerServiceBase.this.internalRemoveByPSDCFile(pSDCFile2);
                PSDevCenterServerServiceBase.this.onAfterRemoveByPSDCFile(pSDCFile2);
            }
        });
    }

    protected void onBeforeRemoveByPSDCFile(PSDCFile pSDCFile) throws Exception {
    }

    protected void internalRemoveByPSDCFile(PSDCFile pSDCFile) throws Exception {
        ArrayList<PSDevCenterServer> arrayList = this.selectByPSDCFile(pSDCFile);
        this.onBeforeRemoveByPSDCFile(pSDCFile, arrayList);
        for (PSDevCenterServer pSDevCenterServer : arrayList) {
            this.remove((IEntity)pSDevCenterServer);
        }
        this.onAfterRemoveByPSDCFile(pSDCFile, arrayList);
    }

    protected void onAfterRemoveByPSDCFile(PSDCFile pSDCFile) throws Exception {
    }

    protected void onBeforeRemoveByPSDCFile(PSDCFile pSDCFile, ArrayList<PSDevCenterServer> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDCFile(PSDCFile pSDCFile, ArrayList<PSDevCenterServer> arrayList) throws Exception {
    }

    public void testRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    public void resetPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDevCenterServer> arrayList = this.selectByPSDevCenter(pSDevCenter);
        for (PSDevCenterServer pSDevCenterServer : arrayList) {
            PSDevCenterServer pSDevCenterServer2 = (PSDevCenterServer)this.getDEModel().createEntity();
            pSDevCenterServer2.setPSDevCenterServerId(pSDevCenterServer.getPSDevCenterServerId());
            pSDevCenterServer2.setPSDevCenterId(null);
            this.update(pSDevCenterServer2);
        }
    }

    public void removeByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        final PSDevCenter pSDevCenter2 = pSDevCenter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevCenterServerServiceBase.this.onBeforeRemoveByPSDevCenter(pSDevCenter2);
                PSDevCenterServerServiceBase.this.internalRemoveByPSDevCenter(pSDevCenter2);
                PSDevCenterServerServiceBase.this.onAfterRemoveByPSDevCenter(pSDevCenter2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void internalRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDevCenterServer> arrayList = this.selectByPSDevCenter(pSDevCenter);
        this.onBeforeRemoveByPSDevCenter(pSDevCenter, arrayList);
        for (PSDevCenterServer pSDevCenterServer : arrayList) {
            this.remove((IEntity)pSDevCenterServer);
        }
        this.onAfterRemoveByPSDevCenter(pSDevCenter, arrayList);
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSDevCenterServer> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSDevCenterServer> arrayList) throws Exception {
    }

    public void testRemoveByPSDevServer(PSDevServer pSDevServer) throws Exception {
        ArrayList<PSDevCenterServer> arrayList = this.selectByPSDevServer(pSDevServer, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVSERVER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDevServer);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVCENTERSERVER_PSDEVSERVER_PSDEVSERVERID", "", iDataEntityModel.getName(), "PSDEVCENTERSERVER", iDataEntityModel.getDataInfo((IEntity)pSDevServer), arrayList.get(0)));
        }
    }

    public void resetPSDevServer(PSDevServer pSDevServer) throws Exception {
        ArrayList<PSDevCenterServer> arrayList = this.selectByPSDevServer(pSDevServer);
        for (PSDevCenterServer pSDevCenterServer : arrayList) {
            PSDevCenterServer pSDevCenterServer2 = (PSDevCenterServer)this.getDEModel().createEntity();
            pSDevCenterServer2.setPSDevCenterServerId(pSDevCenterServer.getPSDevCenterServerId());
            pSDevCenterServer2.setPSDevServerId(null);
            this.update(pSDevCenterServer2);
        }
    }

    public void removeByPSDevServer(PSDevServer pSDevServer) throws Exception {
        final PSDevServer pSDevServer2 = pSDevServer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevCenterServerServiceBase.this.onBeforeRemoveByPSDevServer(pSDevServer2);
                PSDevCenterServerServiceBase.this.internalRemoveByPSDevServer(pSDevServer2);
                PSDevCenterServerServiceBase.this.onAfterRemoveByPSDevServer(pSDevServer2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevServer(PSDevServer pSDevServer) throws Exception {
    }

    protected void internalRemoveByPSDevServer(PSDevServer pSDevServer) throws Exception {
        ArrayList<PSDevCenterServer> arrayList = this.selectByPSDevServer(pSDevServer);
        this.onBeforeRemoveByPSDevServer(pSDevServer, arrayList);
        for (PSDevCenterServer pSDevCenterServer : arrayList) {
            this.remove((IEntity)pSDevCenterServer);
        }
        this.onAfterRemoveByPSDevServer(pSDevServer, arrayList);
    }

    protected void onAfterRemoveByPSDevServer(PSDevServer pSDevServer) throws Exception {
    }

    protected void onBeforeRemoveByPSDevServer(PSDevServer pSDevServer, ArrayList<PSDevCenterServer> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevServer(PSDevServer pSDevServer, ArrayList<PSDevCenterServer> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDevCenterServer pSDevCenterServer) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDevCenterASService)ServiceGlobal.getService(PSDevCenterASService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevCenterASServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenterServer(pSDevCenterServer);
        pSCoreSysServiceBase = (PSDevSlnCodeServerService)ServiceGlobal.getService(PSDevSlnCodeServerService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnCodeServerServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenterServer(pSDevCenterServer);
        pSCoreSysServiceBase = (PSDSBookingService)ServiceGlobal.getService(PSDSBookingService.class, (SessionFactory)this.getSessionFactory());
        ((PSDSBookingServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenterServer(pSDevCenterServer);
        super.onBeforeRemove(pSDevCenterServer);
    }

    protected void replaceParentInfo(PSDevCenterServer pSDevCenterServer, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDevCenterServer, cloneSession);
        if (pSDevCenterServer.getPSDCClusterId() != null && (iEntity = cloneSession.getEntity("PSDCCLUSTER", (Object)pSDevCenterServer.getPSDCClusterId())) != null) {
            this.onFillParentInfo_PSDCCluster(pSDevCenterServer, (PSDCCluster)iEntity);
        }
        if (pSDevCenterServer.getPSDCContainerSpecId() != null && (iEntity = cloneSession.getEntity("PSDCCONTAINERSPEC", (Object)pSDevCenterServer.getPSDCContainerSpecId())) != null) {
            this.onFillParentInfo_PSDCContainerSpec(pSDevCenterServer, (PSDCContainerSpec)iEntity);
        }
        if (pSDevCenterServer.getPSDCFileId() != null && (iEntity = cloneSession.getEntity("PSDCFILE", (Object)pSDevCenterServer.getPSDCFileId())) != null) {
            this.onFillParentInfo_PSDCFile(pSDevCenterServer, (PSDCFile)iEntity);
        }
        if (pSDevCenterServer.getPSDevCenterId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTER", (Object)pSDevCenterServer.getPSDevCenterId())) != null) {
            this.onFillParentInfo_PSDevCenter(pSDevCenterServer, (PSDevCenter)iEntity);
        }
        if (pSDevCenterServer.getPSDevServerId() != null && (iEntity = cloneSession.getEntity("PSDEVSERVER", (Object)pSDevCenterServer.getPSDevServerId())) != null) {
            this.onFillParentInfo_PSDevServer(pSDevCenterServer, (PSDevServer)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDevCenterServer pSDevCenterServer, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDevCenterServer, bl);
    }

    protected void onCheckEntity(boolean bl, PSDevCenterServer pSDevCenterServer, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_DSType(bl, pSDevCenterServer, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ExpriedTime(bl, pSDevCenterServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HostAddress(bl, pSDevCenterServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HostPasswd(bl, pSDevCenterServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HostUserName(bl, pSDevCenterServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDevCenterServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCClusterId(bl, pSDevCenterServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCContainerSpecId(bl, pSDevCenterServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCFileId(bl, pSDevCenterServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterId(bl, pSDevCenterServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterServerId(bl, pSDevCenterServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterServerName(bl, pSDevCenterServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevServerId(bl, pSDevCenterServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDSBKLists(bl, pSDevCenterServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ResPos(bl, pSDevCenterServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ResReadyTime(bl, pSDevCenterServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ResState(bl, pSDevCenterServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ResVer(bl, pSDevCenterServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDevCenterServer, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_DSType(boolean bl, PSDevCenterServer pSDevCenterServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenterServer.isDSTypeDirty() && !bl2 : !pSDevCenterServer.isDSTypeDirty()) {
            return null;
        }
        String string = pSDevCenterServer.getDSType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_DSType_Default((IEntity)pSDevCenterServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ExpriedTime(boolean bl, PSDevCenterServer pSDevCenterServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenterServer.isExpriedTimeDirty() : !pSDevCenterServer.isExpriedTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSDevCenterServer.getExpriedTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ExpriedTime_Default((IEntity)pSDevCenterServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXPRIEDTIME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_HostAddress(boolean bl, PSDevCenterServer pSDevCenterServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenterServer.isHostAddressDirty() : !pSDevCenterServer.isHostAddressDirty()) {
            return null;
        }
        String string = pSDevCenterServer.getHostAddress();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_HostAddress_Default((IEntity)pSDevCenterServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HOSTADDRESS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_HostPasswd(boolean bl, PSDevCenterServer pSDevCenterServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenterServer.isHostPasswdDirty() : !pSDevCenterServer.isHostPasswdDirty()) {
            return null;
        }
        String string = pSDevCenterServer.getHostPasswd();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_HostPasswd_Default((IEntity)pSDevCenterServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HOSTPASSWD");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_HostUserName(boolean bl, PSDevCenterServer pSDevCenterServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenterServer.isHostUserNameDirty() : !pSDevCenterServer.isHostUserNameDirty()) {
            return null;
        }
        String string = pSDevCenterServer.getHostUserName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_HostUserName_Default((IEntity)pSDevCenterServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HOSTUSERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDevCenterServer pSDevCenterServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenterServer.isMemoDirty() : !pSDevCenterServer.isMemoDirty()) {
            return null;
        }
        String string = pSDevCenterServer.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDevCenterServer, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDCClusterId(boolean bl, PSDevCenterServer pSDevCenterServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenterServer.isPSDCClusterIdDirty() : !pSDevCenterServer.isPSDCClusterIdDirty()) {
            return null;
        }
        String string = pSDevCenterServer.getPSDCClusterId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCClusterId_Default((IEntity)pSDevCenterServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCCLUSTERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCContainerSpecId(boolean bl, PSDevCenterServer pSDevCenterServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenterServer.isPSDCContainerSpecIdDirty() : !pSDevCenterServer.isPSDCContainerSpecIdDirty()) {
            return null;
        }
        String string = pSDevCenterServer.getPSDCContainerSpecId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCContainerSpecId_Default((IEntity)pSDevCenterServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCCONTAINERSPECID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCFileId(boolean bl, PSDevCenterServer pSDevCenterServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenterServer.isPSDCFileIdDirty() : !pSDevCenterServer.isPSDCFileIdDirty()) {
            return null;
        }
        String string = pSDevCenterServer.getPSDCFileId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCFileId_Default((IEntity)pSDevCenterServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCFILEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterId(boolean bl, PSDevCenterServer pSDevCenterServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenterServer.isPSDevCenterIdDirty() : !pSDevCenterServer.isPSDevCenterIdDirty()) {
            return null;
        }
        String string = pSDevCenterServer.getPSDevCenterId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterId_Default((IEntity)pSDevCenterServer, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevCenterServerId(boolean bl, PSDevCenterServer pSDevCenterServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenterServer.isPSDevCenterServerIdDirty() && !bl2 : !pSDevCenterServer.isPSDevCenterServerIdDirty()) {
            return null;
        }
        String string = pSDevCenterServer.getPSDevCenterServerId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERSERVERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterServerId_Default((IEntity)pSDevCenterServer, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevCenterServerName(boolean bl, PSDevCenterServer pSDevCenterServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenterServer.isPSDevCenterServerNameDirty() && !bl2 : !pSDevCenterServer.isPSDevCenterServerNameDirty()) {
            return null;
        }
        String string = pSDevCenterServer.getPSDevCenterServerName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERSERVERNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterServerName_Default((IEntity)pSDevCenterServer, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevServerId(boolean bl, PSDevCenterServer pSDevCenterServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenterServer.isPSDevServerIdDirty() : !pSDevCenterServer.isPSDevServerIdDirty()) {
            return null;
        }
        String string = pSDevCenterServer.getPSDevServerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevServerId_Default((IEntity)pSDevCenterServer, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDSBKLists(boolean bl, PSDevCenterServer pSDevCenterServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenterServer.isPSDSBKListsDirty() : !pSDevCenterServer.isPSDSBKListsDirty()) {
            return null;
        }
        String string = pSDevCenterServer.getPSDSBKLists();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDSBKLists_Default((IEntity)pSDevCenterServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDSBKLISTS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ResPos(boolean bl, PSDevCenterServer pSDevCenterServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenterServer.isResPosDirty() : !pSDevCenterServer.isResPosDirty()) {
            return null;
        }
        Integer n = pSDevCenterServer.getResPos();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ResPos_Default((IEntity)pSDevCenterServer, bl2, bl3);
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

    protected EntityFieldError onCheckField_ResReadyTime(boolean bl, PSDevCenterServer pSDevCenterServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenterServer.isResReadyTimeDirty() : !pSDevCenterServer.isResReadyTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSDevCenterServer.getResReadyTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ResReadyTime_Default((IEntity)pSDevCenterServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RESREADYTIME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ResState(boolean bl, PSDevCenterServer pSDevCenterServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenterServer.isResStateDirty() : !pSDevCenterServer.isResStateDirty()) {
            return null;
        }
        Integer n = pSDevCenterServer.getResState();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ResState_Default((IEntity)pSDevCenterServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RESSTATE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ResVer(boolean bl, PSDevCenterServer pSDevCenterServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenterServer.isResVerDirty() : !pSDevCenterServer.isResVerDirty()) {
            return null;
        }
        Integer n = pSDevCenterServer.getResVer();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ResVer_Default((IEntity)pSDevCenterServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RESVER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDevCenterServer pSDevCenterServer, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDevCenterServer, bl);
    }

    protected void onSyncIndexEntities(PSDevCenterServer pSDevCenterServer, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDevCenterServer, bl);
    }

    public Object getDataContextValue(PSDevCenterServer pSDevCenterServer, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDevCenterServer, string, iDataContextParam)) != null) {
            return object;
        }
        PSDevCenter pSDevCenter = pSDevCenterServer.getPSDevCenter();
        if (pSDevCenter != null && pSDevCenter.contains(string)) {
            return pSDevCenter.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDevCenterServer pSDevCenterServer, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDevCenterServer, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DSType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXPRIEDTIME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ExpriedTime_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HOSTADDRESS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HostAddress_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HOSTPASSWD", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HostPasswd_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HOSTUSERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HostUserName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCCLUSTERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCClusterId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCCLUSTERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCClusterName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCCONTAINERSPECID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCContainerSpecId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCCONTAINERSPECNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCContainerSpecName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCFILEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCFileId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCFILENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCFileName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSDSBKLISTS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDSBKLists_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RESPOS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ResPos_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RESREADYTIME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ResReadyTime_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RESSTATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ResState_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RESVER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ResVer_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_DSType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTYPE", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ExpriedTime_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_HostAddress_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("HOSTADDRESS", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_HostPasswd_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("HOSTPASSWD", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_HostUserName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("HOSTUSERNAME", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
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

    protected String onTestValueRule_PSDCClusterId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCCLUSTERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCClusterName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCCLUSTERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCContainerSpecId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCCONTAINERSPECID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCContainerSpecName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCCONTAINERSPECNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCFileId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCFILEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCFileName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCFILENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSDSBKLists_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDSBKLISTS", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ResPos_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ResReadyTime_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ResState_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ResVer_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected boolean onMergeChild(String string, String string2, PSDevCenterServer pSDevCenterServer) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDevCenterServer)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDevCenterServer pSDevCenterServer) throws Exception {
        super.onUpdateParent((IEntity)pSDevCenterServer);
    }

    @Override
    protected void exportCurXmlModel(PSDevCenterServer pSDevCenterServer, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEVCENTERSERVER");
        if (!bl) {
            pSDevCenterServer.setPSDCClusterName(null);
            pSDevCenterServer.setPSDCContainerSpecName(null);
            pSDevCenterServer.setPSDCFileName(null);
            super.exportCurXmlModel(pSDevCenterServer, xmlNode, bl);
        }
    }
}

