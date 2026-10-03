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
import net.ibizsys.pscore.srv.devcenter.dao.PSDCDeployServerDAO;
import net.ibizsys.pscore.srv.devcenter.demodel.PSDCDeployServerDEModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCDeployCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCDeployCenterBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCDeployServer;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSDeployServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSDeployServerBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysResService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCDeployServerServiceBase
extends PSCoreSysServiceBase<PSDCDeployServer> {
    private static final Log log = LogFactory.getLog(PSDCDeployServerServiceBase.class);
    public static final String DATASET_CURDC = "CurDC";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDCDeployServerDEModel pSDCDeployServerDEModel;
    private PSDCDeployServerDAO pSDCDeployServerDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.devcenter.service.PSDCDeployServerService";
    }

    public PSDCDeployServerDEModel getPSDCDeployServerDEModel() {
        if (this.pSDCDeployServerDEModel == null) {
            try {
                this.pSDCDeployServerDEModel = (PSDCDeployServerDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.devcenter.demodel.PSDCDeployServerDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCDeployServerDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDCDeployServerDEModel();
    }

    public PSDCDeployServerDAO getPSDCDeployServerDAO() {
        if (this.pSDCDeployServerDAO == null) {
            try {
                this.pSDCDeployServerDAO = (PSDCDeployServerDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.devcenter.dao.PSDCDeployServerDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCDeployServerDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDCDeployServerDAO();
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

    protected void onFillParentInfo(PSDCDeployServer pSDCDeployServer, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCDEPLOYSERVER_PSDCDEPLOYCENTER_PSDCDEPLOYCENTERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCDeployCenterService", (SessionFactory)this.getSessionFactory());
            PSDCDeployCenter pSDCDeployCenter = (PSDCDeployCenter)iService.getDEModel().createEntity();
            pSDCDeployCenter.set("PSDCDEPLOYCENTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDCDeployCenter);
            } else {
                iService.get(pSDCDeployCenter);
            }
            this.onFillParentInfo_PSDCDeployCenter(pSDCDeployServer, pSDCDeployCenter);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCDEPLOYSERVER_PSDEPLOYSERVER_PSDEPLOYSERVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSDeployServerService", (SessionFactory)this.getSessionFactory());
            PSDeployServer pSDeployServer = (PSDeployServer)iService.getDEModel().createEntity();
            pSDeployServer.set("PSDEPLOYSERVERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDeployServer);
            } else {
                iService.get(pSDeployServer);
            }
            this.onFillParentInfo_PSDeployServer(pSDCDeployServer, pSDeployServer);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCDEPLOYSERVER_PSDEVCENTER_PSDEVCENTERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService", (SessionFactory)this.getSessionFactory());
            PSDevCenter pSDevCenter = (PSDevCenter)iService.getDEModel().createEntity();
            pSDevCenter.set("PSDEVCENTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenter);
            } else {
                iService.get(pSDevCenter);
            }
            this.onFillParentInfo_PSDevCenter(pSDCDeployServer, pSDevCenter);
            return;
        }
        super.onFillParentInfo(pSDCDeployServer, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDCDeployCenter(PSDCDeployServer pSDCDeployServer, PSDCDeployCenter pSDCDeployCenter) throws Exception {
        pSDCDeployServer.setPSDCDeployCenterId(pSDCDeployCenter.getPSDCDeployCenterId());
        pSDCDeployServer.setPSDCDeployCenterName(pSDCDeployCenter.getPSDCDeployCenterName());
    }

    protected void onFillParentInfo_PSDeployServer(PSDCDeployServer pSDCDeployServer, PSDeployServer pSDeployServer) throws Exception {
        pSDCDeployServer.setPSDeployServerId(pSDeployServer.getPSDeployServerId());
        pSDCDeployServer.setPSDeployServerName(pSDeployServer.getPSDeployServerName());
    }

    protected void onFillParentInfo_PSDevCenter(PSDCDeployServer pSDCDeployServer, PSDevCenter pSDevCenter) throws Exception {
        pSDCDeployServer.setPSDevCenterId(pSDevCenter.getPSDevCenterId());
        pSDCDeployServer.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
    }

    protected void onFillEntityFullInfo(PSDCDeployServer pSDCDeployServer, boolean bl) throws Exception {
        if (bl && pSDCDeployServer.getValidFlag() == null) {
            pSDCDeployServer.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo(pSDCDeployServer, bl);
        this.onFillEntityFullInfo_PSDCDeployCenter(pSDCDeployServer, bl);
        this.onFillEntityFullInfo_PSDeployServer(pSDCDeployServer, bl);
        this.onFillEntityFullInfo_PSDevCenter(pSDCDeployServer, bl);
    }

    protected void onFillEntityFullInfo_PSDCDeployCenter(PSDCDeployServer pSDCDeployServer, boolean bl) throws Exception {
        if (pSDCDeployServer.isPSDCDeployCenterIdDirty()) {
            if (pSDCDeployServer.getPSDCDeployCenterId() != null) {
                if (pSDCDeployServer.getPSDCDeployCenterId() == null || pSDCDeployServer.getPSDCDeployCenterName() == null) {
                    PSDCDeployCenter pSDCDeployCenter = pSDCDeployServer.getPSDCDeployCenter();
                    pSDCDeployServer.setPSDCDeployCenterName(pSDCDeployCenter.getPSDCDeployCenterName());
                }
            } else {
                pSDCDeployServer.setPSDCDeployCenterName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDeployServer(PSDCDeployServer pSDCDeployServer, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevCenter(PSDCDeployServer pSDCDeployServer, boolean bl) throws Exception {
        if (pSDCDeployServer.isPSDevCenterIdDirty()) {
            if (pSDCDeployServer.getPSDevCenterId() != null) {
                if (pSDCDeployServer.getPSDevCenterId() == null || pSDCDeployServer.getPSDevCenterName() == null) {
                    PSDevCenter pSDevCenter = pSDCDeployServer.getPSDevCenter();
                    pSDCDeployServer.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
                }
            } else {
                pSDCDeployServer.setPSDevCenterName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDCDeployServer pSDCDeployServer, boolean bl) throws Exception {
        super.onWriteBackParent(pSDCDeployServer, bl);
    }

    public ArrayList<PSDCDeployServer> selectByPSDCDeployCenter(PSDCDeployCenterBase pSDCDeployCenterBase) throws Exception {
        return this.selectByPSDCDeployCenter(pSDCDeployCenterBase, "", -1);
    }

    public ArrayList<PSDCDeployServer> selectByPSDCDeployCenter(PSDCDeployCenterBase pSDCDeployCenterBase, String string) throws Exception {
        return this.selectByPSDCDeployCenter(pSDCDeployCenterBase, string, -1);
    }

    public ArrayList<PSDCDeployServer> selectByPSDCDeployCenter(PSDCDeployCenterBase pSDCDeployCenterBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDCDEPLOYCENTERID", (Object)pSDCDeployCenterBase.getPSDCDeployCenterId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDCDeployCenterCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDCDeployCenterCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDCDeployServer> selectByPSDeployServer(PSDeployServerBase pSDeployServerBase) throws Exception {
        return this.selectByPSDeployServer(pSDeployServerBase, "", -1);
    }

    public ArrayList<PSDCDeployServer> selectByPSDeployServer(PSDeployServerBase pSDeployServerBase, String string) throws Exception {
        return this.selectByPSDeployServer(pSDeployServerBase, string, -1);
    }

    public ArrayList<PSDCDeployServer> selectByPSDeployServer(PSDeployServerBase pSDeployServerBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEPLOYSERVERID", (Object)pSDeployServerBase.getPSDeployServerId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDeployServerCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDeployServerCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDCDeployServer> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, "", -1);
    }

    public ArrayList<PSDCDeployServer> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, string, -1);
    }

    public ArrayList<PSDCDeployServer> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string, int n) throws Exception {
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

    public void testRemoveByPSDCDeployCenter(PSDCDeployCenter pSDCDeployCenter) throws Exception {
        ArrayList<PSDCDeployServer> arrayList = this.selectByPSDCDeployCenter(pSDCDeployCenter, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDCDEPLOYCENTER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDCDeployCenter);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDCDEPLOYSERVER_PSDCDEPLOYCENTER_PSDCDEPLOYCENTERID", "", iDataEntityModel.getName(), "PSDCDEPLOYSERVER", iDataEntityModel.getDataInfo(pSDCDeployCenter), arrayList.get(0)));
        }
    }

    public void resetPSDCDeployCenter(PSDCDeployCenter pSDCDeployCenter) throws Exception {
        ArrayList<PSDCDeployServer> arrayList = this.selectByPSDCDeployCenter(pSDCDeployCenter);
        for (PSDCDeployServer pSDCDeployServer : arrayList) {
            PSDCDeployServer pSDCDeployServer2 = (PSDCDeployServer)this.getDEModel().createEntity();
            pSDCDeployServer2.setPSDCDeployServerId(pSDCDeployServer.getPSDCDeployServerId());
            pSDCDeployServer2.setPSDCDeployCenterId(null);
            this.update(pSDCDeployServer2);
        }
    }

    public void removeByPSDCDeployCenter(PSDCDeployCenter pSDCDeployCenter) throws Exception {
        final PSDCDeployCenter pSDCDeployCenter2 = pSDCDeployCenter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCDeployServerServiceBase.this.onBeforeRemoveByPSDCDeployCenter(pSDCDeployCenter2);
                PSDCDeployServerServiceBase.this.internalRemoveByPSDCDeployCenter(pSDCDeployCenter2);
                PSDCDeployServerServiceBase.this.onAfterRemoveByPSDCDeployCenter(pSDCDeployCenter2);
            }
        });
    }

    protected void onBeforeRemoveByPSDCDeployCenter(PSDCDeployCenter pSDCDeployCenter) throws Exception {
    }

    protected void internalRemoveByPSDCDeployCenter(PSDCDeployCenter pSDCDeployCenter) throws Exception {
        ArrayList<PSDCDeployServer> arrayList = this.selectByPSDCDeployCenter(pSDCDeployCenter);
        this.onBeforeRemoveByPSDCDeployCenter(pSDCDeployCenter, arrayList);
        for (PSDCDeployServer pSDCDeployServer : arrayList) {
            this.remove(pSDCDeployServer);
        }
        this.onAfterRemoveByPSDCDeployCenter(pSDCDeployCenter, arrayList);
    }

    protected void onAfterRemoveByPSDCDeployCenter(PSDCDeployCenter pSDCDeployCenter) throws Exception {
    }

    protected void onBeforeRemoveByPSDCDeployCenter(PSDCDeployCenter pSDCDeployCenter, ArrayList<PSDCDeployServer> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDCDeployCenter(PSDCDeployCenter pSDCDeployCenter, ArrayList<PSDCDeployServer> arrayList) throws Exception {
    }

    public void testRemoveByPSDeployServer(PSDeployServer pSDeployServer) throws Exception {
        ArrayList<PSDCDeployServer> arrayList = this.selectByPSDeployServer(pSDeployServer, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEPLOYSERVER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDeployServer);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDCDEPLOYSERVER_PSDEPLOYSERVER_PSDEPLOYSERVERID", "", iDataEntityModel.getName(), "PSDCDEPLOYSERVER", iDataEntityModel.getDataInfo(pSDeployServer), arrayList.get(0)));
        }
    }

    public void resetPSDeployServer(PSDeployServer pSDeployServer) throws Exception {
        ArrayList<PSDCDeployServer> arrayList = this.selectByPSDeployServer(pSDeployServer);
        for (PSDCDeployServer pSDCDeployServer : arrayList) {
            PSDCDeployServer pSDCDeployServer2 = (PSDCDeployServer)this.getDEModel().createEntity();
            pSDCDeployServer2.setPSDCDeployServerId(pSDCDeployServer.getPSDCDeployServerId());
            pSDCDeployServer2.setPSDeployServerId(null);
            this.update(pSDCDeployServer2);
        }
    }

    public void removeByPSDeployServer(PSDeployServer pSDeployServer) throws Exception {
        final PSDeployServer pSDeployServer2 = pSDeployServer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCDeployServerServiceBase.this.onBeforeRemoveByPSDeployServer(pSDeployServer2);
                PSDCDeployServerServiceBase.this.internalRemoveByPSDeployServer(pSDeployServer2);
                PSDCDeployServerServiceBase.this.onAfterRemoveByPSDeployServer(pSDeployServer2);
            }
        });
    }

    protected void onBeforeRemoveByPSDeployServer(PSDeployServer pSDeployServer) throws Exception {
    }

    protected void internalRemoveByPSDeployServer(PSDeployServer pSDeployServer) throws Exception {
        ArrayList<PSDCDeployServer> arrayList = this.selectByPSDeployServer(pSDeployServer);
        this.onBeforeRemoveByPSDeployServer(pSDeployServer, arrayList);
        for (PSDCDeployServer pSDCDeployServer : arrayList) {
            this.remove(pSDCDeployServer);
        }
        this.onAfterRemoveByPSDeployServer(pSDeployServer, arrayList);
    }

    protected void onAfterRemoveByPSDeployServer(PSDeployServer pSDeployServer) throws Exception {
    }

    protected void onBeforeRemoveByPSDeployServer(PSDeployServer pSDeployServer, ArrayList<PSDCDeployServer> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDeployServer(PSDeployServer pSDeployServer, ArrayList<PSDCDeployServer> arrayList) throws Exception {
    }

    public void testRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDCDeployServer> arrayList = this.selectByPSDevCenter(pSDevCenter, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevCenter);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDCDEPLOYSERVER_PSDEVCENTER_PSDEVCENTERID", "", iDataEntityModel.getName(), "PSDCDEPLOYSERVER", iDataEntityModel.getDataInfo(pSDevCenter), arrayList.get(0)));
        }
    }

    public void resetPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDCDeployServer> arrayList = this.selectByPSDevCenter(pSDevCenter);
        for (PSDCDeployServer pSDCDeployServer : arrayList) {
            PSDCDeployServer pSDCDeployServer2 = (PSDCDeployServer)this.getDEModel().createEntity();
            pSDCDeployServer2.setPSDCDeployServerId(pSDCDeployServer.getPSDCDeployServerId());
            pSDCDeployServer2.setPSDevCenterId(null);
            this.update(pSDCDeployServer2);
        }
    }

    public void removeByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        final PSDevCenter pSDevCenter2 = pSDevCenter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCDeployServerServiceBase.this.onBeforeRemoveByPSDevCenter(pSDevCenter2);
                PSDCDeployServerServiceBase.this.internalRemoveByPSDevCenter(pSDevCenter2);
                PSDCDeployServerServiceBase.this.onAfterRemoveByPSDevCenter(pSDevCenter2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void internalRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDCDeployServer> arrayList = this.selectByPSDevCenter(pSDevCenter);
        this.onBeforeRemoveByPSDevCenter(pSDevCenter, arrayList);
        for (PSDCDeployServer pSDCDeployServer : arrayList) {
            this.remove(pSDCDeployServer);
        }
        this.onAfterRemoveByPSDevCenter(pSDevCenter, arrayList);
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSDCDeployServer> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSDCDeployServer> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDCDeployServer pSDCDeployServer) throws Exception {
        PSDevSlnSysResService pSDevSlnSysResService = (PSDevSlnSysResService)ServiceGlobal.getService(PSDevSlnSysResService.class, (SessionFactory)this.getSessionFactory());
        pSDevSlnSysResService.testRemoveByPSDCDeployServer(pSDCDeployServer);
        super.onBeforeRemove(pSDCDeployServer);
    }

    protected void replaceParentInfo(PSDCDeployServer pSDCDeployServer, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDCDeployServer, cloneSession);
        if (pSDCDeployServer.getPSDCDeployCenterId() != null && (iEntity = cloneSession.getEntity("PSDCDEPLOYCENTER", (Object)pSDCDeployServer.getPSDCDeployCenterId())) != null) {
            this.onFillParentInfo_PSDCDeployCenter(pSDCDeployServer, (PSDCDeployCenter)iEntity);
        }
        if (pSDCDeployServer.getPSDeployServerId() != null && (iEntity = cloneSession.getEntity("PSDEPLOYSERVER", (Object)pSDCDeployServer.getPSDeployServerId())) != null) {
            this.onFillParentInfo_PSDeployServer(pSDCDeployServer, (PSDeployServer)iEntity);
        }
        if (pSDCDeployServer.getPSDevCenterId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTER", (Object)pSDCDeployServer.getPSDevCenterId())) != null) {
            this.onFillParentInfo_PSDevCenter(pSDCDeployServer, (PSDevCenter)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDCDeployServer pSDCDeployServer, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDCDeployServer, bl);
    }

    protected void onCheckEntity(boolean bl, PSDCDeployServer pSDCDeployServer, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_DefaultFlag(bl, pSDCDeployServer, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ExpriedTime(bl, pSDCDeployServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IpAddr(bl, pSDCDeployServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDCDeployServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Passwd(bl, pSDCDeployServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Port(bl, pSDCDeployServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCDeployCenterId(bl, pSDCDeployServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCDeployCenterName(bl, pSDCDeployServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCDeployServerId(bl, pSDCDeployServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCDeployServerName(bl, pSDCDeployServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDeployServerId(bl, pSDCDeployServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterId(bl, pSDCDeployServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterName(bl, pSDCDeployServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefCount(bl, pSDCDeployServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ResPos(bl, pSDCDeployServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ResReadyTime(bl, pSDCDeployServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ResState(bl, pSDCDeployServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SSHIPAddr(bl, pSDCDeployServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SSHPort(bl, pSDCDeployServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UploadFileMode(bl, pSDCDeployServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UploadPath(bl, pSDCDeployServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserName(bl, pSDCDeployServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDCDeployServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WorkshopPath(bl, pSDCDeployServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDCDeployServer, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_DefaultFlag(boolean bl, PSDCDeployServer pSDCDeployServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDeployServer.isDefaultFlagDirty() && !bl2 : !pSDCDeployServer.isDefaultFlagDirty()) {
            return null;
        }
        Integer n = pSDCDeployServer.getDefaultFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFAULTFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_DefaultFlag_Default(pSDCDeployServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFAULTFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ExpriedTime(boolean bl, PSDCDeployServer pSDCDeployServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDeployServer.isExpriedTimeDirty() : !pSDCDeployServer.isExpriedTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSDCDeployServer.getExpriedTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ExpriedTime_Default(pSDCDeployServer, bl2, bl3);
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

    protected EntityFieldError onCheckField_IpAddr(boolean bl, PSDCDeployServer pSDCDeployServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDeployServer.isIpAddrDirty() : !pSDCDeployServer.isIpAddrDirty()) {
            return null;
        }
        String string = pSDCDeployServer.getIpAddr();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_IpAddr_Default(pSDCDeployServer, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDCDeployServer pSDCDeployServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDeployServer.isMemoDirty() : !pSDCDeployServer.isMemoDirty()) {
            return null;
        }
        String string = pSDCDeployServer.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDCDeployServer, bl2, bl3);
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

    protected EntityFieldError onCheckField_Passwd(boolean bl, PSDCDeployServer pSDCDeployServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDeployServer.isPasswdDirty() : !pSDCDeployServer.isPasswdDirty()) {
            return null;
        }
        String string = pSDCDeployServer.getPasswd();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Passwd_Default(pSDCDeployServer, bl2, bl3);
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

    protected EntityFieldError onCheckField_Port(boolean bl, PSDCDeployServer pSDCDeployServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDeployServer.isPortDirty() : !pSDCDeployServer.isPortDirty()) {
            return null;
        }
        Integer n = pSDCDeployServer.getPort();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Port_Default(pSDCDeployServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PORT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCDeployCenterId(boolean bl, PSDCDeployServer pSDCDeployServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDeployServer.isPSDCDeployCenterIdDirty() : !pSDCDeployServer.isPSDCDeployCenterIdDirty()) {
            return null;
        }
        String string = pSDCDeployServer.getPSDCDeployCenterId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCDeployCenterId_Default(pSDCDeployServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCDEPLOYCENTERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCDeployCenterName(boolean bl, PSDCDeployServer pSDCDeployServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDeployServer.isPSDCDeployCenterNameDirty() : !pSDCDeployServer.isPSDCDeployCenterNameDirty()) {
            return null;
        }
        String string = pSDCDeployServer.getPSDCDeployCenterName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCDeployCenterName_Default(pSDCDeployServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCDEPLOYCENTERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCDeployServerId(boolean bl, PSDCDeployServer pSDCDeployServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDeployServer.isPSDCDeployServerIdDirty() && !bl2 : !pSDCDeployServer.isPSDCDeployServerIdDirty()) {
            return null;
        }
        String string = pSDCDeployServer.getPSDCDeployServerId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCDEPLOYSERVERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCDeployServerId_Default(pSDCDeployServer, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDCDeployServerName(boolean bl, PSDCDeployServer pSDCDeployServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDeployServer.isPSDCDeployServerNameDirty() && !bl2 : !pSDCDeployServer.isPSDCDeployServerNameDirty()) {
            return null;
        }
        String string = pSDCDeployServer.getPSDCDeployServerName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCDEPLOYSERVERNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCDeployServerName_Default(pSDCDeployServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCDEPLOYSERVERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDeployServerId(boolean bl, PSDCDeployServer pSDCDeployServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDeployServer.isPSDeployServerIdDirty() : !pSDCDeployServer.isPSDeployServerIdDirty()) {
            return null;
        }
        String string = pSDCDeployServer.getPSDeployServerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDeployServerId_Default(pSDCDeployServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPLOYSERVERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterId(boolean bl, PSDCDeployServer pSDCDeployServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDeployServer.isPSDevCenterIdDirty() && !bl2 : !pSDCDeployServer.isPSDevCenterIdDirty()) {
            return null;
        }
        String string = pSDCDeployServer.getPSDevCenterId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterId_Default(pSDCDeployServer, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevCenterName(boolean bl, PSDCDeployServer pSDCDeployServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDeployServer.isPSDevCenterNameDirty() && !bl2 : !pSDCDeployServer.isPSDevCenterNameDirty()) {
            return null;
        }
        String string = pSDCDeployServer.getPSDevCenterName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterName_Default(pSDCDeployServer, bl2, bl3);
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

    protected EntityFieldError onCheckField_RefCount(boolean bl, PSDCDeployServer pSDCDeployServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDeployServer.isRefCountDirty() : !pSDCDeployServer.isRefCountDirty()) {
            return null;
        }
        Integer n = pSDCDeployServer.getRefCount();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_RefCount_Default(pSDCDeployServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFCOUNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ResPos(boolean bl, PSDCDeployServer pSDCDeployServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDeployServer.isResPosDirty() : !pSDCDeployServer.isResPosDirty()) {
            return null;
        }
        Integer n = pSDCDeployServer.getResPos();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ResPos_Default(pSDCDeployServer, bl2, bl3);
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

    protected EntityFieldError onCheckField_ResReadyTime(boolean bl, PSDCDeployServer pSDCDeployServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDeployServer.isResReadyTimeDirty() : !pSDCDeployServer.isResReadyTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSDCDeployServer.getResReadyTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ResReadyTime_Default(pSDCDeployServer, bl2, bl3);
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

    protected EntityFieldError onCheckField_ResState(boolean bl, PSDCDeployServer pSDCDeployServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDeployServer.isResStateDirty() : !pSDCDeployServer.isResStateDirty()) {
            return null;
        }
        Integer n = pSDCDeployServer.getResState();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ResState_Default(pSDCDeployServer, bl2, bl3);
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

    protected EntityFieldError onCheckField_SSHIPAddr(boolean bl, PSDCDeployServer pSDCDeployServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDeployServer.isSSHIPAddrDirty() : !pSDCDeployServer.isSSHIPAddrDirty()) {
            return null;
        }
        String string = pSDCDeployServer.getSSHIPAddr();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SSHIPAddr_Default(pSDCDeployServer, bl2, bl3);
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

    protected EntityFieldError onCheckField_SSHPort(boolean bl, PSDCDeployServer pSDCDeployServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDeployServer.isSSHPortDirty() : !pSDCDeployServer.isSSHPortDirty()) {
            return null;
        }
        Integer n = pSDCDeployServer.getSSHPort();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SSHPort_Default(pSDCDeployServer, bl2, bl3);
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

    protected EntityFieldError onCheckField_UploadFileMode(boolean bl, PSDCDeployServer pSDCDeployServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDeployServer.isUploadFileModeDirty() : !pSDCDeployServer.isUploadFileModeDirty()) {
            return null;
        }
        String string = pSDCDeployServer.getUploadFileMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UploadFileMode_Default(pSDCDeployServer, bl2, bl3);
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

    protected EntityFieldError onCheckField_UploadPath(boolean bl, PSDCDeployServer pSDCDeployServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDeployServer.isUploadPathDirty() : !pSDCDeployServer.isUploadPathDirty()) {
            return null;
        }
        String string = pSDCDeployServer.getUploadPath();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UploadPath_Default(pSDCDeployServer, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserName(boolean bl, PSDCDeployServer pSDCDeployServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDeployServer.isUserNameDirty() : !pSDCDeployServer.isUserNameDirty()) {
            return null;
        }
        String string = pSDCDeployServer.getUserName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserName_Default(pSDCDeployServer, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDCDeployServer pSDCDeployServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDeployServer.isValidFlagDirty() && !bl2 : !pSDCDeployServer.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDCDeployServer.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSDCDeployServer, bl2, bl3);
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

    protected EntityFieldError onCheckField_WorkshopPath(boolean bl, PSDCDeployServer pSDCDeployServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDeployServer.isWorkshopPathDirty() : !pSDCDeployServer.isWorkshopPathDirty()) {
            return null;
        }
        String string = pSDCDeployServer.getWorkshopPath();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WorkshopPath_Default(pSDCDeployServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WORKSHOPPATH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDCDeployServer pSDCDeployServer, boolean bl) throws Exception {
        super.onSyncEntity(pSDCDeployServer, bl);
    }

    protected void onSyncIndexEntities(PSDCDeployServer pSDCDeployServer, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDCDeployServer, bl);
    }

    public Object getDataContextValue(PSDCDeployServer pSDCDeployServer, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDCDeployServer, string, iDataContextParam)) != null) {
            return object;
        }
        PSDCDeployCenter pSDCDeployCenter = pSDCDeployServer.getPSDCDeployCenter();
        if (pSDCDeployCenter != null && pSDCDeployCenter.contains(string)) {
            return pSDCDeployCenter.get(string);
        }
        PSDevCenter pSDevCenter = pSDCDeployServer.getPSDevCenter();
        if (pSDevCenter != null && pSDevCenter.contains(string)) {
            return pSDevCenter.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDCDeployServer pSDCDeployServer, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDCDeployServer, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEFAULTFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DefaultFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXPRIEDTIME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ExpriedTime_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"IPADDR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IpAddr_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PASSWD", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Passwd_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PORT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Port_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCDEPLOYCENTERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCDeployCenterId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCDEPLOYCENTERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCDeployCenterName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCDEPLOYSERVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCDeployServerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCDEPLOYSERVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCDeployServerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPLOYSERVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDeployServerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPLOYSERVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDeployServerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFCOUNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefCount_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"SSHIPADDR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SSHIPAddr_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SSHPORT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SSHPort_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"USERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALIDFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValidFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WORKSHOPPATH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WorkshopPath_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_DefaultFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ExpriedTime_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_Port_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSDCDeployCenterId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCDEPLOYCENTERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCDeployCenterName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCDEPLOYCENTERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSDeployServerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPLOYSERVERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDeployServerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPLOYSERVERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_RefCount_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_WorkshopPath_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WORKSHOPPATH", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected boolean onMergeChild(String string, String string2, PSDCDeployServer pSDCDeployServer) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDCDeployServer)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDCDeployServer pSDCDeployServer) throws Exception {
        super.onUpdateParent(pSDCDeployServer);
    }

    @Override
    protected void exportCurXmlModel(PSDCDeployServer pSDCDeployServer, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDCDEPLOYSERVER");
        if (!bl) {
            pSDCDeployServer.setCreateDate(null);
            pSDCDeployServer.setCreateMan(null);
            pSDCDeployServer.setPSDCDeployServerId(null);
            pSDCDeployServer.setPSDeployServerName(null);
            pSDCDeployServer.setRefCount(null);
            pSDCDeployServer.setUpdateDate(null);
            pSDCDeployServer.setUpdateMan(null);
            super.exportCurXmlModel(pSDCDeployServer, xmlNode, bl);
        }
    }
}

