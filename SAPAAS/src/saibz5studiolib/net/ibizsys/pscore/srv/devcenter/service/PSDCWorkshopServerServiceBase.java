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
import net.ibizsys.pscore.srv.devcenter.dao.PSDCWorkshopServerDAO;
import net.ibizsys.pscore.srv.devcenter.demodel.PSDCWorkshopServerDEModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCWorkshopServer;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSWorkshopServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSWorkshopServerBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysWSGitService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysWSGitServiceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCWorkshopServerServiceBase
extends PSCoreSysServiceBase<PSDCWorkshopServer> {
    private static final Log log = LogFactory.getLog(PSDCWorkshopServerServiceBase.class);
    public static final String DATASET_CURDC = "CurDC";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDCWorkshopServerDEModel pSDCWorkshopServerDEModel;
    private PSDCWorkshopServerDAO pSDCWorkshopServerDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.devcenter.service.PSDCWorkshopServerService";
    }

    public PSDCWorkshopServerDEModel getPSDCWorkshopServerDEModel() {
        if (this.pSDCWorkshopServerDEModel == null) {
            try {
                this.pSDCWorkshopServerDEModel = (PSDCWorkshopServerDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.devcenter.demodel.PSDCWorkshopServerDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCWorkshopServerDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDCWorkshopServerDEModel();
    }

    public PSDCWorkshopServerDAO getPSDCWorkshopServerDAO() {
        if (this.pSDCWorkshopServerDAO == null) {
            try {
                this.pSDCWorkshopServerDAO = (PSDCWorkshopServerDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.devcenter.dao.PSDCWorkshopServerDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCWorkshopServerDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDCWorkshopServerDAO();
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

    protected void onFillParentInfo(PSDCWorkshopServer pSDCWorkshopServer, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCWORKSHOPSERVER_PSDEVCENTER_PSDEVCENTERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService", (SessionFactory)this.getSessionFactory());
            PSDevCenter pSDevCenter = (PSDevCenter)iService.getDEModel().createEntity();
            pSDevCenter.set("PSDEVCENTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenter);
            } else {
                iService.get(pSDevCenter);
            }
            this.onFillParentInfo_PSDevCenter(pSDCWorkshopServer, pSDevCenter);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCWORKSHOPSERVER_PSWORKSHOPSERVER_PSWORKSHOPSERVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSWorkshopServerService", (SessionFactory)this.getSessionFactory());
            PSWorkshopServer pSWorkshopServer = (PSWorkshopServer)iService.getDEModel().createEntity();
            pSWorkshopServer.set("PSWORKSHOPSERVERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSWorkshopServer);
            } else {
                iService.get(pSWorkshopServer);
            }
            this.onFillParentInfo_PSWorkshopServer(pSDCWorkshopServer, pSWorkshopServer);
            return;
        }
        super.onFillParentInfo(pSDCWorkshopServer, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDevCenter(PSDCWorkshopServer pSDCWorkshopServer, PSDevCenter pSDevCenter) throws Exception {
        pSDCWorkshopServer.setPSDevCenterId(pSDevCenter.getPSDevCenterId());
        pSDCWorkshopServer.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
    }

    protected void onFillParentInfo_PSWorkshopServer(PSDCWorkshopServer pSDCWorkshopServer, PSWorkshopServer pSWorkshopServer) throws Exception {
        pSDCWorkshopServer.setPSWorkshopServerId(pSWorkshopServer.getPSWorkshopServerId());
        pSDCWorkshopServer.setPSWorkshopServerName(pSWorkshopServer.getPSWorkshopServerName());
    }

    protected void onFillEntityFullInfo(PSDCWorkshopServer pSDCWorkshopServer, boolean bl) throws Exception {
        if (bl) {
            if (pSDCWorkshopServer.getDefaultFlag() == null) {
                pSDCWorkshopServer.setDefaultFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDCWorkshopServer.getValidFlag() == null) {
                pSDCWorkshopServer.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo(pSDCWorkshopServer, bl);
        this.onFillEntityFullInfo_PSDevCenter(pSDCWorkshopServer, bl);
        this.onFillEntityFullInfo_PSWorkshopServer(pSDCWorkshopServer, bl);
    }

    protected void onFillEntityFullInfo_PSDevCenter(PSDCWorkshopServer pSDCWorkshopServer, boolean bl) throws Exception {
        if (pSDCWorkshopServer.isPSDevCenterIdDirty()) {
            if (pSDCWorkshopServer.getPSDevCenterId() != null) {
                if (pSDCWorkshopServer.getPSDevCenterId() == null || pSDCWorkshopServer.getPSDevCenterName() == null) {
                    PSDevCenter pSDevCenter = pSDCWorkshopServer.getPSDevCenter();
                    pSDCWorkshopServer.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
                }
            } else {
                pSDCWorkshopServer.setPSDevCenterName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSWorkshopServer(PSDCWorkshopServer pSDCWorkshopServer, boolean bl) throws Exception {
        if (pSDCWorkshopServer.isPSWorkshopServerIdDirty()) {
            if (pSDCWorkshopServer.getPSWorkshopServerId() != null) {
                if (pSDCWorkshopServer.getPSWorkshopServerId() == null || pSDCWorkshopServer.getPSWorkshopServerName() == null) {
                    PSWorkshopServer pSWorkshopServer = pSDCWorkshopServer.getPSWorkshopServer();
                    pSDCWorkshopServer.setPSWorkshopServerName(pSWorkshopServer.getPSWorkshopServerName());
                }
            } else {
                pSDCWorkshopServer.setPSWorkshopServerName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDCWorkshopServer pSDCWorkshopServer, boolean bl) throws Exception {
        super.onWriteBackParent(pSDCWorkshopServer, bl);
    }

    public ArrayList<PSDCWorkshopServer> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, "", -1);
    }

    public ArrayList<PSDCWorkshopServer> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, string, -1);
    }

    public ArrayList<PSDCWorkshopServer> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string, int n) throws Exception {
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

    public ArrayList<PSDCWorkshopServer> selectByPSWorkshopServer(PSWorkshopServerBase pSWorkshopServerBase) throws Exception {
        return this.selectByPSWorkshopServer(pSWorkshopServerBase, "", -1);
    }

    public ArrayList<PSDCWorkshopServer> selectByPSWorkshopServer(PSWorkshopServerBase pSWorkshopServerBase, String string) throws Exception {
        return this.selectByPSWorkshopServer(pSWorkshopServerBase, string, -1);
    }

    public ArrayList<PSDCWorkshopServer> selectByPSWorkshopServer(PSWorkshopServerBase pSWorkshopServerBase, String string, int n) throws Exception {
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

    public void testRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDCWorkshopServer> arrayList = this.selectByPSDevCenter(pSDevCenter, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevCenter);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDCWORKSHOPSERVER_PSDEVCENTER_PSDEVCENTERID", "", iDataEntityModel.getName(), "PSDCWORKSHOPSERVER", iDataEntityModel.getDataInfo(pSDevCenter), arrayList.get(0)));
        }
    }

    public void resetPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDCWorkshopServer> arrayList = this.selectByPSDevCenter(pSDevCenter);
        for (PSDCWorkshopServer pSDCWorkshopServer : arrayList) {
            PSDCWorkshopServer pSDCWorkshopServer2 = (PSDCWorkshopServer)this.getDEModel().createEntity();
            pSDCWorkshopServer2.setPSDCWorkshopServerId(pSDCWorkshopServer.getPSDCWorkshopServerId());
            pSDCWorkshopServer2.setPSDevCenterId(null);
            this.update(pSDCWorkshopServer2);
        }
    }

    public void removeByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        final PSDevCenter pSDevCenter2 = pSDevCenter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCWorkshopServerServiceBase.this.onBeforeRemoveByPSDevCenter(pSDevCenter2);
                PSDCWorkshopServerServiceBase.this.internalRemoveByPSDevCenter(pSDevCenter2);
                PSDCWorkshopServerServiceBase.this.onAfterRemoveByPSDevCenter(pSDevCenter2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void internalRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDCWorkshopServer> arrayList = this.selectByPSDevCenter(pSDevCenter);
        this.onBeforeRemoveByPSDevCenter(pSDevCenter, arrayList);
        for (PSDCWorkshopServer pSDCWorkshopServer : arrayList) {
            this.remove(pSDCWorkshopServer);
        }
        this.onAfterRemoveByPSDevCenter(pSDevCenter, arrayList);
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSDCWorkshopServer> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSDCWorkshopServer> arrayList) throws Exception {
    }

    public void testRemoveByPSWorkshopServer(PSWorkshopServer pSWorkshopServer) throws Exception {
        ArrayList<PSDCWorkshopServer> arrayList = this.selectByPSWorkshopServer(pSWorkshopServer, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSWORKSHOPSERVER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSWorkshopServer);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDCWORKSHOPSERVER_PSWORKSHOPSERVER_PSWORKSHOPSERVERID", "", iDataEntityModel.getName(), "PSDCWORKSHOPSERVER", iDataEntityModel.getDataInfo(pSWorkshopServer), arrayList.get(0)));
        }
    }

    public void resetPSWorkshopServer(PSWorkshopServer pSWorkshopServer) throws Exception {
        ArrayList<PSDCWorkshopServer> arrayList = this.selectByPSWorkshopServer(pSWorkshopServer);
        for (PSDCWorkshopServer pSDCWorkshopServer : arrayList) {
            PSDCWorkshopServer pSDCWorkshopServer2 = (PSDCWorkshopServer)this.getDEModel().createEntity();
            pSDCWorkshopServer2.setPSDCWorkshopServerId(pSDCWorkshopServer.getPSDCWorkshopServerId());
            pSDCWorkshopServer2.setPSWorkshopServerId(null);
            this.update(pSDCWorkshopServer2);
        }
    }

    public void removeByPSWorkshopServer(PSWorkshopServer pSWorkshopServer) throws Exception {
        final PSWorkshopServer pSWorkshopServer2 = pSWorkshopServer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCWorkshopServerServiceBase.this.onBeforeRemoveByPSWorkshopServer(pSWorkshopServer2);
                PSDCWorkshopServerServiceBase.this.internalRemoveByPSWorkshopServer(pSWorkshopServer2);
                PSDCWorkshopServerServiceBase.this.onAfterRemoveByPSWorkshopServer(pSWorkshopServer2);
            }
        });
    }

    protected void onBeforeRemoveByPSWorkshopServer(PSWorkshopServer pSWorkshopServer) throws Exception {
    }

    protected void internalRemoveByPSWorkshopServer(PSWorkshopServer pSWorkshopServer) throws Exception {
        ArrayList<PSDCWorkshopServer> arrayList = this.selectByPSWorkshopServer(pSWorkshopServer);
        this.onBeforeRemoveByPSWorkshopServer(pSWorkshopServer, arrayList);
        for (PSDCWorkshopServer pSDCWorkshopServer : arrayList) {
            this.remove(pSDCWorkshopServer);
        }
        this.onAfterRemoveByPSWorkshopServer(pSWorkshopServer, arrayList);
    }

    protected void onAfterRemoveByPSWorkshopServer(PSWorkshopServer pSWorkshopServer) throws Exception {
    }

    protected void onBeforeRemoveByPSWorkshopServer(PSWorkshopServer pSWorkshopServer, ArrayList<PSDCWorkshopServer> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSWorkshopServer(PSWorkshopServer pSWorkshopServer, ArrayList<PSDCWorkshopServer> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDCWorkshopServer pSDCWorkshopServer) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDevSlnSysWSGitService)ServiceGlobal.getService(PSDevSlnSysWSGitService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnSysWSGitServiceBase)pSCoreSysServiceBase).testRemoveByPSDCWorkshopServer(pSDCWorkshopServer);
        pSCoreSysServiceBase = (PSDevSlnService)ServiceGlobal.getService(PSDevSlnService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnServiceBase)pSCoreSysServiceBase).testRemoveByPSDCWorkshopServer(pSDCWorkshopServer);
        super.onBeforeRemove(pSDCWorkshopServer);
    }

    protected void replaceParentInfo(PSDCWorkshopServer pSDCWorkshopServer, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDCWorkshopServer, cloneSession);
        if (pSDCWorkshopServer.getPSDevCenterId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTER", (Object)pSDCWorkshopServer.getPSDevCenterId())) != null) {
            this.onFillParentInfo_PSDevCenter(pSDCWorkshopServer, (PSDevCenter)iEntity);
        }
        if (pSDCWorkshopServer.getPSWorkshopServerId() != null && (iEntity = cloneSession.getEntity("PSWORKSHOPSERVER", (Object)pSDCWorkshopServer.getPSWorkshopServerId())) != null) {
            this.onFillParentInfo_PSWorkshopServer(pSDCWorkshopServer, (PSWorkshopServer)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDCWorkshopServer pSDCWorkshopServer, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDCWorkshopServer, bl);
    }

    protected void onCheckEntity(boolean bl, PSDCWorkshopServer pSDCWorkshopServer, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AdminPasswd(bl, pSDCWorkshopServer, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AdminUserName(bl, pSDCWorkshopServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DefaultFlag(bl, pSDCWorkshopServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ExpriedTime(bl, pSDCWorkshopServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GITPassword(bl, pSDCWorkshopServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GitPath(bl, pSDCWorkshopServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GITUserName(bl, pSDCWorkshopServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IpAddr(bl, pSDCWorkshopServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IpAddr2(bl, pSDCWorkshopServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDCWorkshopServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Passwd(bl, pSDCWorkshopServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Port(bl, pSDCWorkshopServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCWorkshopServerId(bl, pSDCWorkshopServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCWorkshopServerName(bl, pSDCWorkshopServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterId(bl, pSDCWorkshopServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterName(bl, pSDCWorkshopServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWorkshopServerId(bl, pSDCWorkshopServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWorkshopServerName(bl, pSDCWorkshopServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefCount(bl, pSDCWorkshopServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ResPos(bl, pSDCWorkshopServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ResReadyTime(bl, pSDCWorkshopServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ResState(bl, pSDCWorkshopServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ResVer(bl, pSDCWorkshopServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SSHIPAddr(bl, pSDCWorkshopServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SSHPort(bl, pSDCWorkshopServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UploadFileMode(bl, pSDCWorkshopServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UploadPath(bl, pSDCWorkshopServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserName(bl, pSDCWorkshopServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDCWorkshopServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WebConsolePath(bl, pSDCWorkshopServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WorkshopPath(bl, pSDCWorkshopServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDCWorkshopServer, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AdminPasswd(boolean bl, PSDCWorkshopServer pSDCWorkshopServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCWorkshopServer.isAdminPasswdDirty() : !pSDCWorkshopServer.isAdminPasswdDirty()) {
            return null;
        }
        String string = pSDCWorkshopServer.getAdminPasswd();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AdminPasswd_Default(pSDCWorkshopServer, bl2, bl3);
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

    protected EntityFieldError onCheckField_AdminUserName(boolean bl, PSDCWorkshopServer pSDCWorkshopServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCWorkshopServer.isAdminUserNameDirty() : !pSDCWorkshopServer.isAdminUserNameDirty()) {
            return null;
        }
        String string = pSDCWorkshopServer.getAdminUserName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AdminUserName_Default(pSDCWorkshopServer, bl2, bl3);
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

    protected EntityFieldError onCheckField_DefaultFlag(boolean bl, PSDCWorkshopServer pSDCWorkshopServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCWorkshopServer.isDefaultFlagDirty() && !bl2 : !pSDCWorkshopServer.isDefaultFlagDirty()) {
            return null;
        }
        Integer n = pSDCWorkshopServer.getDefaultFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFAULTFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_DefaultFlag_Default(pSDCWorkshopServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFAULTFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            bl4 = DataTypeHelper.compare((int)9, (Object)n, (Object)"1") == 0L;
            if (bl4) {
                String string = "";
                string = "PSDEVCENTERID";
                String string2 = this.checkFieldDupRule(this.getPSDCWorkshopServerDEModel(), "DEFAULTFLAG", string, pSDCWorkshopServer, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string2)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("DEFAULTFLAG");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string2);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ExpriedTime(boolean bl, PSDCWorkshopServer pSDCWorkshopServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCWorkshopServer.isExpriedTimeDirty() : !pSDCWorkshopServer.isExpriedTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSDCWorkshopServer.getExpriedTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ExpriedTime_Default(pSDCWorkshopServer, bl2, bl3);
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

    protected EntityFieldError onCheckField_GITPassword(boolean bl, PSDCWorkshopServer pSDCWorkshopServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCWorkshopServer.isGITPasswordDirty() : !pSDCWorkshopServer.isGITPasswordDirty()) {
            return null;
        }
        String string = pSDCWorkshopServer.getGITPassword();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GITPassword_Default(pSDCWorkshopServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GITPASSWORD");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GitPath(boolean bl, PSDCWorkshopServer pSDCWorkshopServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCWorkshopServer.isGitPathDirty() : !pSDCWorkshopServer.isGitPathDirty()) {
            return null;
        }
        String string = pSDCWorkshopServer.getGitPath();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GitPath_Default(pSDCWorkshopServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GITPATH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GITUserName(boolean bl, PSDCWorkshopServer pSDCWorkshopServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCWorkshopServer.isGITUserNameDirty() : !pSDCWorkshopServer.isGITUserNameDirty()) {
            return null;
        }
        String string = pSDCWorkshopServer.getGITUserName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GITUserName_Default(pSDCWorkshopServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GITUSERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IpAddr(boolean bl, PSDCWorkshopServer pSDCWorkshopServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCWorkshopServer.isIpAddrDirty() : !pSDCWorkshopServer.isIpAddrDirty()) {
            return null;
        }
        String string = pSDCWorkshopServer.getIpAddr();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_IpAddr_Default(pSDCWorkshopServer, bl2, bl3);
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

    protected EntityFieldError onCheckField_IpAddr2(boolean bl, PSDCWorkshopServer pSDCWorkshopServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCWorkshopServer.isIpAddr2Dirty() : !pSDCWorkshopServer.isIpAddr2Dirty()) {
            return null;
        }
        String string = pSDCWorkshopServer.getIpAddr2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_IpAddr2_Default(pSDCWorkshopServer, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDCWorkshopServer pSDCWorkshopServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCWorkshopServer.isMemoDirty() : !pSDCWorkshopServer.isMemoDirty()) {
            return null;
        }
        String string = pSDCWorkshopServer.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDCWorkshopServer, bl2, bl3);
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

    protected EntityFieldError onCheckField_Passwd(boolean bl, PSDCWorkshopServer pSDCWorkshopServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCWorkshopServer.isPasswdDirty() : !pSDCWorkshopServer.isPasswdDirty()) {
            return null;
        }
        String string = pSDCWorkshopServer.getPasswd();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Passwd_Default(pSDCWorkshopServer, bl2, bl3);
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

    protected EntityFieldError onCheckField_Port(boolean bl, PSDCWorkshopServer pSDCWorkshopServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCWorkshopServer.isPortDirty() : !pSDCWorkshopServer.isPortDirty()) {
            return null;
        }
        Integer n = pSDCWorkshopServer.getPort();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Port_Default(pSDCWorkshopServer, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDCWorkshopServerId(boolean bl, PSDCWorkshopServer pSDCWorkshopServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCWorkshopServer.isPSDCWorkshopServerIdDirty() && !bl2 : !pSDCWorkshopServer.isPSDCWorkshopServerIdDirty()) {
            return null;
        }
        String string = pSDCWorkshopServer.getPSDCWorkshopServerId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCWORKSHOPSERVERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCWorkshopServerId_Default(pSDCWorkshopServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCWORKSHOPSERVERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCWorkshopServerName(boolean bl, PSDCWorkshopServer pSDCWorkshopServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCWorkshopServer.isPSDCWorkshopServerNameDirty() && !bl2 : !pSDCWorkshopServer.isPSDCWorkshopServerNameDirty()) {
            return null;
        }
        String string = pSDCWorkshopServer.getPSDCWorkshopServerName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCWORKSHOPSERVERNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCWorkshopServerName_Default(pSDCWorkshopServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCWORKSHOPSERVERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterId(boolean bl, PSDCWorkshopServer pSDCWorkshopServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCWorkshopServer.isPSDevCenterIdDirty() : !pSDCWorkshopServer.isPSDevCenterIdDirty()) {
            return null;
        }
        String string = pSDCWorkshopServer.getPSDevCenterId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterId_Default(pSDCWorkshopServer, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevCenterName(boolean bl, PSDCWorkshopServer pSDCWorkshopServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCWorkshopServer.isPSDevCenterNameDirty() : !pSDCWorkshopServer.isPSDevCenterNameDirty()) {
            return null;
        }
        String string = pSDCWorkshopServer.getPSDevCenterName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterName_Default(pSDCWorkshopServer, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSWorkshopServerId(boolean bl, PSDCWorkshopServer pSDCWorkshopServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCWorkshopServer.isPSWorkshopServerIdDirty() : !pSDCWorkshopServer.isPSWorkshopServerIdDirty()) {
            return null;
        }
        String string = pSDCWorkshopServer.getPSWorkshopServerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWorkshopServerId_Default(pSDCWorkshopServer, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSWorkshopServerName(boolean bl, PSDCWorkshopServer pSDCWorkshopServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCWorkshopServer.isPSWorkshopServerNameDirty() : !pSDCWorkshopServer.isPSWorkshopServerNameDirty()) {
            return null;
        }
        String string = pSDCWorkshopServer.getPSWorkshopServerName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWorkshopServerName_Default(pSDCWorkshopServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWORKSHOPSERVERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefCount(boolean bl, PSDCWorkshopServer pSDCWorkshopServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCWorkshopServer.isRefCountDirty() : !pSDCWorkshopServer.isRefCountDirty()) {
            return null;
        }
        Integer n = pSDCWorkshopServer.getRefCount();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_RefCount_Default(pSDCWorkshopServer, bl2, bl3);
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

    protected EntityFieldError onCheckField_ResPos(boolean bl, PSDCWorkshopServer pSDCWorkshopServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCWorkshopServer.isResPosDirty() : !pSDCWorkshopServer.isResPosDirty()) {
            return null;
        }
        Integer n = pSDCWorkshopServer.getResPos();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ResPos_Default(pSDCWorkshopServer, bl2, bl3);
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

    protected EntityFieldError onCheckField_ResReadyTime(boolean bl, PSDCWorkshopServer pSDCWorkshopServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCWorkshopServer.isResReadyTimeDirty() : !pSDCWorkshopServer.isResReadyTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSDCWorkshopServer.getResReadyTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ResReadyTime_Default(pSDCWorkshopServer, bl2, bl3);
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

    protected EntityFieldError onCheckField_ResState(boolean bl, PSDCWorkshopServer pSDCWorkshopServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCWorkshopServer.isResStateDirty() : !pSDCWorkshopServer.isResStateDirty()) {
            return null;
        }
        Integer n = pSDCWorkshopServer.getResState();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ResState_Default(pSDCWorkshopServer, bl2, bl3);
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

    protected EntityFieldError onCheckField_ResVer(boolean bl, PSDCWorkshopServer pSDCWorkshopServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCWorkshopServer.isResVerDirty() : !pSDCWorkshopServer.isResVerDirty()) {
            return null;
        }
        Integer n = pSDCWorkshopServer.getResVer();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ResVer_Default(pSDCWorkshopServer, bl2, bl3);
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

    protected EntityFieldError onCheckField_SSHIPAddr(boolean bl, PSDCWorkshopServer pSDCWorkshopServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCWorkshopServer.isSSHIPAddrDirty() : !pSDCWorkshopServer.isSSHIPAddrDirty()) {
            return null;
        }
        String string = pSDCWorkshopServer.getSSHIPAddr();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SSHIPAddr_Default(pSDCWorkshopServer, bl2, bl3);
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

    protected EntityFieldError onCheckField_SSHPort(boolean bl, PSDCWorkshopServer pSDCWorkshopServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCWorkshopServer.isSSHPortDirty() : !pSDCWorkshopServer.isSSHPortDirty()) {
            return null;
        }
        Integer n = pSDCWorkshopServer.getSSHPort();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SSHPort_Default(pSDCWorkshopServer, bl2, bl3);
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

    protected EntityFieldError onCheckField_UploadFileMode(boolean bl, PSDCWorkshopServer pSDCWorkshopServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCWorkshopServer.isUploadFileModeDirty() : !pSDCWorkshopServer.isUploadFileModeDirty()) {
            return null;
        }
        String string = pSDCWorkshopServer.getUploadFileMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UploadFileMode_Default(pSDCWorkshopServer, bl2, bl3);
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

    protected EntityFieldError onCheckField_UploadPath(boolean bl, PSDCWorkshopServer pSDCWorkshopServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCWorkshopServer.isUploadPathDirty() : !pSDCWorkshopServer.isUploadPathDirty()) {
            return null;
        }
        String string = pSDCWorkshopServer.getUploadPath();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UploadPath_Default(pSDCWorkshopServer, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserName(boolean bl, PSDCWorkshopServer pSDCWorkshopServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCWorkshopServer.isUserNameDirty() : !pSDCWorkshopServer.isUserNameDirty()) {
            return null;
        }
        String string = pSDCWorkshopServer.getUserName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserName_Default(pSDCWorkshopServer, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDCWorkshopServer pSDCWorkshopServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCWorkshopServer.isValidFlagDirty() && !bl2 : !pSDCWorkshopServer.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDCWorkshopServer.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSDCWorkshopServer, bl2, bl3);
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

    protected EntityFieldError onCheckField_WebConsolePath(boolean bl, PSDCWorkshopServer pSDCWorkshopServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCWorkshopServer.isWebConsolePathDirty() : !pSDCWorkshopServer.isWebConsolePathDirty()) {
            return null;
        }
        String string = pSDCWorkshopServer.getWebConsolePath();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WebConsolePath_Default(pSDCWorkshopServer, bl2, bl3);
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

    protected EntityFieldError onCheckField_WorkshopPath(boolean bl, PSDCWorkshopServer pSDCWorkshopServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCWorkshopServer.isWorkshopPathDirty() : !pSDCWorkshopServer.isWorkshopPathDirty()) {
            return null;
        }
        String string = pSDCWorkshopServer.getWorkshopPath();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WorkshopPath_Default(pSDCWorkshopServer, bl2, bl3);
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

    protected void onSyncEntity(PSDCWorkshopServer pSDCWorkshopServer, boolean bl) throws Exception {
        super.onSyncEntity(pSDCWorkshopServer, bl);
    }

    protected void onSyncIndexEntities(PSDCWorkshopServer pSDCWorkshopServer, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDCWorkshopServer, bl);
    }

    public Object getDataContextValue(PSDCWorkshopServer pSDCWorkshopServer, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDCWorkshopServer, string, iDataContextParam)) != null) {
            return object;
        }
        PSDevCenter pSDevCenter = pSDCWorkshopServer.getPSDevCenter();
        if (pSDevCenter != null && pSDevCenter.contains(string)) {
            return pSDevCenter.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDCWorkshopServer pSDCWorkshopServer, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDCWorkshopServer, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ADMINPASSWD", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AdminPasswd_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ADMINUSERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AdminUserName_Default(iEntity, bl, bl2);
        }
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
        if (StringHelper.compare((String)string, (String)"GITPASSWORD", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GITPassword_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GITPATH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GitPath_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GITUSERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GITUserName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"IPADDR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IpAddr_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"IPADDR2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IpAddr2_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSDCWORKSHOPSERVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCWorkshopServerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCWORKSHOPSERVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCWorkshopServerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWORKSHOPSERVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWorkshopServerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWORKSHOPSERVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWorkshopServerName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"RESVER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ResVer_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"WEBCONSOLEPATH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WebConsolePath_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WORKSHOPPATH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WorkshopPath_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_GITPassword_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GITPASSWORD", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GitPath_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GITPATH", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GITUserName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GITUSERNAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
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

    protected String onTestValueRule_PSDCWorkshopServerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCWORKSHOPSERVERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCWorkshopServerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCWORKSHOPSERVERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_ResVer_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSDCWorkshopServer pSDCWorkshopServer) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDCWorkshopServer)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDCWorkshopServer pSDCWorkshopServer) throws Exception {
        super.onUpdateParent(pSDCWorkshopServer);
    }

    @Override
    protected void exportCurXmlModel(PSDCWorkshopServer pSDCWorkshopServer, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDCWORKSHOPSERVER");
        if (!bl) {
            pSDCWorkshopServer.setCreateDate(null);
            pSDCWorkshopServer.setCreateMan(null);
            pSDCWorkshopServer.setPSDCWorkshopServerId(null);
            pSDCWorkshopServer.setRefCount(null);
            pSDCWorkshopServer.setUpdateDate(null);
            pSDCWorkshopServer.setUpdateMan(null);
            super.exportCurXmlModel(pSDCWorkshopServer, xmlNode, bl);
        }
    }
}

