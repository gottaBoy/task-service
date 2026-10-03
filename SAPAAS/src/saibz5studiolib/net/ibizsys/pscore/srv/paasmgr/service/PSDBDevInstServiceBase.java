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
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterDBInstService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterDBInstServiceBase;
import net.ibizsys.pscore.srv.paasmgr.dao.PSDBDevInstDAO;
import net.ibizsys.pscore.srv.paasmgr.demodel.PSDBDevInstDEModel;
import net.ibizsys.pscore.srv.paasmgr.entity.PSAppServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSAppServerBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSDBDevInst;
import net.ibizsys.pscore.srv.paasmgr.entity.PSDBServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSDBServerBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSvrDomain;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSvrDomainBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemDBCfgService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemDBCfgServiceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDBDevInstServiceBase
extends PSCoreSysServiceBase<PSDBDevInst> {
    private static final Log log = LogFactory.getLog(PSDBDevInstServiceBase.class);
    public static final String DATASET_CURDC2 = "CurDC2";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDBDevInstDEModel pSDBDevInstDEModel;
    private PSDBDevInstDAO pSDBDevInstDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.paasmgr.service.PSDBDevInstService";
    }

    public PSDBDevInstDEModel getPSDBDevInstDEModel() {
        if (this.pSDBDevInstDEModel == null) {
            try {
                this.pSDBDevInstDEModel = (PSDBDevInstDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.paasmgr.demodel.PSDBDevInstDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDBDevInstDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDBDevInstDEModel();
    }

    public PSDBDevInstDAO getPSDBDevInstDAO() {
        if (this.pSDBDevInstDAO == null) {
            try {
                this.pSDBDevInstDAO = (PSDBDevInstDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.paasmgr.dao.PSDBDevInstDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDBDevInstDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDBDevInstDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURDC2, (boolean)true) == 0) {
            return this.fetchCurDC2(iDEDataSetFetchContext);
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

    public DBFetchResult fetchCurDC2(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDC2, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSDBDevInst pSDBDevInst, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDBDEVINST_PSAPPSERVER_PSAPPSERVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSAppServerService", (SessionFactory)this.getSessionFactory());
            PSAppServer pSAppServer = (PSAppServer)iService.getDEModel().createEntity();
            pSAppServer.set("PSAPPSERVERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSAppServer);
            } else {
                iService.get(pSAppServer);
            }
            this.onFillParentInfo_PSAppServer(pSDBDevInst, pSAppServer);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDBDEVINST_PSDBSERVER_PSDBSERVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSDBServerService", (SessionFactory)this.getSessionFactory());
            PSDBServer pSDBServer = (PSDBServer)iService.getDEModel().createEntity();
            pSDBServer.set("PSDBSERVERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDBServer);
            } else {
                iService.get(pSDBServer);
            }
            this.onFillParentInfo_PSDBServer(pSDBDevInst, pSDBServer);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDBDEVINST_PSDEVCENTER_PSDEVCENTERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService", (SessionFactory)this.getSessionFactory());
            PSDevCenter pSDevCenter = (PSDevCenter)iService.getDEModel().createEntity();
            pSDevCenter.set("PSDEVCENTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenter);
            } else {
                iService.get(pSDevCenter);
            }
            this.onFillParentInfo_PSDevCenter(pSDBDevInst, pSDevCenter);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDBDEVINST_PSSVRDOMAIN_PSSVRDOMAINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSSvrDomainService", (SessionFactory)this.getSessionFactory());
            PSSvrDomain pSSvrDomain = (PSSvrDomain)iService.getDEModel().createEntity();
            pSSvrDomain.set("PSSVRDOMAINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSvrDomain);
            } else {
                iService.get(pSSvrDomain);
            }
            this.onFillParentInfo_PSSvrDomain(pSDBDevInst, pSSvrDomain);
            return;
        }
        super.onFillParentInfo(pSDBDevInst, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSAppServer(PSDBDevInst pSDBDevInst, PSAppServer pSAppServer) throws Exception {
        pSDBDevInst.setPSAppServerId(pSAppServer.getPSAppServerId());
        pSDBDevInst.setPSAppServerName(pSAppServer.getPSAppServerName());
    }

    protected void onFillParentInfo_PSDBServer(PSDBDevInst pSDBDevInst, PSDBServer pSDBServer) throws Exception {
        pSDBDevInst.setPSDBServerId(pSDBServer.getPSDBServerId());
        pSDBDevInst.setPSDBServerName(pSDBServer.getPSDBServerName());
    }

    protected void onFillParentInfo_PSDevCenter(PSDBDevInst pSDBDevInst, PSDevCenter pSDevCenter) throws Exception {
        pSDBDevInst.setPSDevCenterId(pSDevCenter.getPSDevCenterId());
        pSDBDevInst.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
    }

    protected void onFillParentInfo_PSSvrDomain(PSDBDevInst pSDBDevInst, PSSvrDomain pSSvrDomain) throws Exception {
        pSDBDevInst.setPSSvrDomainId(pSSvrDomain.getPSSvrDomainId());
        pSDBDevInst.setPSSvrDomainName(pSSvrDomain.getPSSvrDomainName());
    }

    protected void onFillEntityFullInfo(PSDBDevInst pSDBDevInst, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSDBDevInst, bl);
        this.onFillEntityFullInfo_PSAppServer(pSDBDevInst, bl);
        this.onFillEntityFullInfo_PSDBServer(pSDBDevInst, bl);
        this.onFillEntityFullInfo_PSDevCenter(pSDBDevInst, bl);
        this.onFillEntityFullInfo_PSSvrDomain(pSDBDevInst, bl);
    }

    protected void onFillEntityFullInfo_PSAppServer(PSDBDevInst pSDBDevInst, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDBServer(PSDBDevInst pSDBDevInst, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevCenter(PSDBDevInst pSDBDevInst, boolean bl) throws Exception {
        if (pSDBDevInst.isPSDevCenterIdDirty()) {
            if (pSDBDevInst.getPSDevCenterId() != null) {
                if (pSDBDevInst.getPSDevCenterId() == null || pSDBDevInst.getPSDevCenterName() == null) {
                    PSDevCenter pSDevCenter = pSDBDevInst.getPSDevCenter();
                    pSDBDevInst.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
                }
            } else {
                pSDBDevInst.setPSDevCenterName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSvrDomain(PSDBDevInst pSDBDevInst, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDBDevInst pSDBDevInst, boolean bl) throws Exception {
        super.onWriteBackParent(pSDBDevInst, bl);
    }

    public ArrayList<PSDBDevInst> selectByPSAppServer(PSAppServerBase pSAppServerBase) throws Exception {
        return this.selectByPSAppServer(pSAppServerBase, "", -1);
    }

    public ArrayList<PSDBDevInst> selectByPSAppServer(PSAppServerBase pSAppServerBase, String string) throws Exception {
        return this.selectByPSAppServer(pSAppServerBase, string, -1);
    }

    public ArrayList<PSDBDevInst> selectByPSAppServer(PSAppServerBase pSAppServerBase, String string, int n) throws Exception {
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

    public ArrayList<PSDBDevInst> selectByPSDBServer(PSDBServerBase pSDBServerBase) throws Exception {
        return this.selectByPSDBServer(pSDBServerBase, "", -1);
    }

    public ArrayList<PSDBDevInst> selectByPSDBServer(PSDBServerBase pSDBServerBase, String string) throws Exception {
        return this.selectByPSDBServer(pSDBServerBase, string, -1);
    }

    public ArrayList<PSDBDevInst> selectByPSDBServer(PSDBServerBase pSDBServerBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDBSERVERID", (Object)pSDBServerBase.getPSDBServerId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDBServerCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDBServerCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDBDevInst> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, "", -1);
    }

    public ArrayList<PSDBDevInst> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, string, -1);
    }

    public ArrayList<PSDBDevInst> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string, int n) throws Exception {
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

    public ArrayList<PSDBDevInst> selectByPSSvrDomain(PSSvrDomainBase pSSvrDomainBase) throws Exception {
        return this.selectByPSSvrDomain(pSSvrDomainBase, "", -1);
    }

    public ArrayList<PSDBDevInst> selectByPSSvrDomain(PSSvrDomainBase pSSvrDomainBase, String string) throws Exception {
        return this.selectByPSSvrDomain(pSSvrDomainBase, string, -1);
    }

    public ArrayList<PSDBDevInst> selectByPSSvrDomain(PSSvrDomainBase pSSvrDomainBase, String string, int n) throws Exception {
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
    }

    public void resetPSAppServer(PSAppServer pSAppServer) throws Exception {
        ArrayList<PSDBDevInst> arrayList = this.selectByPSAppServer(pSAppServer);
        for (PSDBDevInst pSDBDevInst : arrayList) {
            PSDBDevInst pSDBDevInst2 = (PSDBDevInst)this.getDEModel().createEntity();
            pSDBDevInst2.setPSDBDevInstId(pSDBDevInst.getPSDBDevInstId());
            pSDBDevInst2.setPSAppServerId(null);
            this.update(pSDBDevInst2);
        }
    }

    public void removeByPSAppServer(PSAppServer pSAppServer) throws Exception {
        final PSAppServer pSAppServer2 = pSAppServer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDBDevInstServiceBase.this.onBeforeRemoveByPSAppServer(pSAppServer2);
                PSDBDevInstServiceBase.this.internalRemoveByPSAppServer(pSAppServer2);
                PSDBDevInstServiceBase.this.onAfterRemoveByPSAppServer(pSAppServer2);
            }
        });
    }

    protected void onBeforeRemoveByPSAppServer(PSAppServer pSAppServer) throws Exception {
    }

    protected void internalRemoveByPSAppServer(PSAppServer pSAppServer) throws Exception {
        ArrayList<PSDBDevInst> arrayList = this.selectByPSAppServer(pSAppServer);
        this.onBeforeRemoveByPSAppServer(pSAppServer, arrayList);
        for (PSDBDevInst pSDBDevInst : arrayList) {
            this.remove(pSDBDevInst);
        }
        this.onAfterRemoveByPSAppServer(pSAppServer, arrayList);
    }

    protected void onAfterRemoveByPSAppServer(PSAppServer pSAppServer) throws Exception {
    }

    protected void onBeforeRemoveByPSAppServer(PSAppServer pSAppServer, ArrayList<PSDBDevInst> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSAppServer(PSAppServer pSAppServer, ArrayList<PSDBDevInst> arrayList) throws Exception {
    }

    public void testRemoveByPSDBServer(PSDBServer pSDBServer) throws Exception {
        ArrayList<PSDBDevInst> arrayList = this.selectByPSDBServer(pSDBServer, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDBSERVER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDBServer);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDBDEVINST_PSDBSERVER_PSDBSERVERID", "", iDataEntityModel.getName(), "PSDBDEVINST", iDataEntityModel.getDataInfo(pSDBServer), arrayList.get(0)));
        }
    }

    public void resetPSDBServer(PSDBServer pSDBServer) throws Exception {
        ArrayList<PSDBDevInst> arrayList = this.selectByPSDBServer(pSDBServer);
        for (PSDBDevInst pSDBDevInst : arrayList) {
            PSDBDevInst pSDBDevInst2 = (PSDBDevInst)this.getDEModel().createEntity();
            pSDBDevInst2.setPSDBDevInstId(pSDBDevInst.getPSDBDevInstId());
            pSDBDevInst2.setPSDBServerId(null);
            this.update(pSDBDevInst2);
        }
    }

    public void removeByPSDBServer(PSDBServer pSDBServer) throws Exception {
        final PSDBServer pSDBServer2 = pSDBServer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDBDevInstServiceBase.this.onBeforeRemoveByPSDBServer(pSDBServer2);
                PSDBDevInstServiceBase.this.internalRemoveByPSDBServer(pSDBServer2);
                PSDBDevInstServiceBase.this.onAfterRemoveByPSDBServer(pSDBServer2);
            }
        });
    }

    protected void onBeforeRemoveByPSDBServer(PSDBServer pSDBServer) throws Exception {
    }

    protected void internalRemoveByPSDBServer(PSDBServer pSDBServer) throws Exception {
        ArrayList<PSDBDevInst> arrayList = this.selectByPSDBServer(pSDBServer);
        this.onBeforeRemoveByPSDBServer(pSDBServer, arrayList);
        for (PSDBDevInst pSDBDevInst : arrayList) {
            this.remove(pSDBDevInst);
        }
        this.onAfterRemoveByPSDBServer(pSDBServer, arrayList);
    }

    protected void onAfterRemoveByPSDBServer(PSDBServer pSDBServer) throws Exception {
    }

    protected void onBeforeRemoveByPSDBServer(PSDBServer pSDBServer, ArrayList<PSDBDevInst> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDBServer(PSDBServer pSDBServer, ArrayList<PSDBDevInst> arrayList) throws Exception {
    }

    public void testRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    public void resetPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDBDevInst> arrayList = this.selectByPSDevCenter(pSDevCenter);
        for (PSDBDevInst pSDBDevInst : arrayList) {
            PSDBDevInst pSDBDevInst2 = (PSDBDevInst)this.getDEModel().createEntity();
            pSDBDevInst2.setPSDBDevInstId(pSDBDevInst.getPSDBDevInstId());
            pSDBDevInst2.setPSDevCenterId(null);
            this.update(pSDBDevInst2);
        }
    }

    public void removeByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        final PSDevCenter pSDevCenter2 = pSDevCenter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDBDevInstServiceBase.this.onBeforeRemoveByPSDevCenter(pSDevCenter2);
                PSDBDevInstServiceBase.this.internalRemoveByPSDevCenter(pSDevCenter2);
                PSDBDevInstServiceBase.this.onAfterRemoveByPSDevCenter(pSDevCenter2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void internalRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDBDevInst> arrayList = this.selectByPSDevCenter(pSDevCenter);
        this.onBeforeRemoveByPSDevCenter(pSDevCenter, arrayList);
        for (PSDBDevInst pSDBDevInst : arrayList) {
            this.remove(pSDBDevInst);
        }
        this.onAfterRemoveByPSDevCenter(pSDevCenter, arrayList);
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSDBDevInst> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSDBDevInst> arrayList) throws Exception {
    }

    public void testRemoveByPSSvrDomain(PSSvrDomain pSSvrDomain) throws Exception {
        ArrayList<PSDBDevInst> arrayList = this.selectByPSSvrDomain(pSSvrDomain, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSVRDOMAIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSvrDomain);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDBDEVINST_PSSVRDOMAIN_PSSVRDOMAINID", "", iDataEntityModel.getName(), "PSDBDEVINST", iDataEntityModel.getDataInfo(pSSvrDomain), arrayList.get(0)));
        }
    }

    public void resetPSSvrDomain(PSSvrDomain pSSvrDomain) throws Exception {
        ArrayList<PSDBDevInst> arrayList = this.selectByPSSvrDomain(pSSvrDomain);
        for (PSDBDevInst pSDBDevInst : arrayList) {
            PSDBDevInst pSDBDevInst2 = (PSDBDevInst)this.getDEModel().createEntity();
            pSDBDevInst2.setPSDBDevInstId(pSDBDevInst.getPSDBDevInstId());
            pSDBDevInst2.setPSSvrDomainId(null);
            this.update(pSDBDevInst2);
        }
    }

    public void removeByPSSvrDomain(PSSvrDomain pSSvrDomain) throws Exception {
        final PSSvrDomain pSSvrDomain2 = pSSvrDomain;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDBDevInstServiceBase.this.onBeforeRemoveByPSSvrDomain(pSSvrDomain2);
                PSDBDevInstServiceBase.this.internalRemoveByPSSvrDomain(pSSvrDomain2);
                PSDBDevInstServiceBase.this.onAfterRemoveByPSSvrDomain(pSSvrDomain2);
            }
        });
    }

    protected void onBeforeRemoveByPSSvrDomain(PSSvrDomain pSSvrDomain) throws Exception {
    }

    protected void internalRemoveByPSSvrDomain(PSSvrDomain pSSvrDomain) throws Exception {
        ArrayList<PSDBDevInst> arrayList = this.selectByPSSvrDomain(pSSvrDomain);
        this.onBeforeRemoveByPSSvrDomain(pSSvrDomain, arrayList);
        for (PSDBDevInst pSDBDevInst : arrayList) {
            this.remove(pSDBDevInst);
        }
        this.onAfterRemoveByPSSvrDomain(pSSvrDomain, arrayList);
    }

    protected void onAfterRemoveByPSSvrDomain(PSSvrDomain pSSvrDomain) throws Exception {
    }

    protected void onBeforeRemoveByPSSvrDomain(PSSvrDomain pSSvrDomain, ArrayList<PSDBDevInst> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSvrDomain(PSSvrDomain pSSvrDomain, ArrayList<PSDBDevInst> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDBDevInst pSDBDevInst) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDevCenterDBInstService)ServiceGlobal.getService(PSDevCenterDBInstService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevCenterDBInstServiceBase)pSCoreSysServiceBase).testRemoveByPSDBDevInst(pSDBDevInst);
        pSCoreSysServiceBase = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnSysServiceBase)pSCoreSysServiceBase).testRemoveByJitPSDBDevInst(pSDBDevInst);
        pSCoreSysServiceBase = (PSSystemDBCfgService)ServiceGlobal.getService(PSSystemDBCfgService.class, (SessionFactory)this.getSessionFactory());
        ((PSSystemDBCfgServiceBase)pSCoreSysServiceBase).testRemoveByNo2PSDBDevInst(pSDBDevInst);
        pSCoreSysServiceBase = (PSSystemDBCfgService)ServiceGlobal.getService(PSSystemDBCfgService.class, (SessionFactory)this.getSessionFactory());
        ((PSSystemDBCfgServiceBase)pSCoreSysServiceBase).testRemoveByPSDBDevInst(pSDBDevInst);
        super.onBeforeRemove(pSDBDevInst);
    }

    protected void replaceParentInfo(PSDBDevInst pSDBDevInst, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDBDevInst, cloneSession);
        if (pSDBDevInst.getPSAppServerId() != null && (iEntity = cloneSession.getEntity("PSAPPSERVER", (Object)pSDBDevInst.getPSAppServerId())) != null) {
            this.onFillParentInfo_PSAppServer(pSDBDevInst, (PSAppServer)iEntity);
        }
        if (pSDBDevInst.getPSDBServerId() != null && (iEntity = cloneSession.getEntity("PSDBSERVER", (Object)pSDBDevInst.getPSDBServerId())) != null) {
            this.onFillParentInfo_PSDBServer(pSDBDevInst, (PSDBServer)iEntity);
        }
        if (pSDBDevInst.getPSDevCenterId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTER", (Object)pSDBDevInst.getPSDevCenterId())) != null) {
            this.onFillParentInfo_PSDevCenter(pSDBDevInst, (PSDevCenter)iEntity);
        }
        if (pSDBDevInst.getPSSvrDomainId() != null && (iEntity = cloneSession.getEntity("PSSVRDOMAIN", (Object)pSDBDevInst.getPSSvrDomainId())) != null) {
            this.onFillParentInfo_PSSvrDomain(pSDBDevInst, (PSSvrDomain)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDBDevInst pSDBDevInst, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDBDevInst, bl);
    }

    protected void onCheckEntity(boolean bl, PSDBDevInst pSDBDevInst, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AllocSize(bl, pSDBDevInst, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ConnStr(bl, pSDBDevInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ConnStrFmt(bl, pSDBDevInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CurDBAction(bl, pSDBDevInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DBName(bl, pSDBDevInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DBSchema(bl, pSDBDevInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DBType(bl, pSDBDevInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DMPassWD(bl, pSDBDevInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DMUserName(bl, pSDBDevInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_InstState(bl, pSDBDevInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LocalRes(bl, pSDBDevInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDBDevInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Param(bl, pSDBDevInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Param2(bl, pSDBDevInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Param3(bl, pSDBDevInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Param4(bl, pSDBDevInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Param5(bl, pSDBDevInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Param6(bl, pSDBDevInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Param7(bl, pSDBDevInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Param8(bl, pSDBDevInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Passwd(bl, pSDBDevInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppServerId(bl, pSDBDevInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDBDevInstId(bl, pSDBDevInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDBDevInstName(bl, pSDBDevInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDBServerId(bl, pSDBDevInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterId(bl, pSDBDevInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterName(bl, pSDBDevInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSvrDomainId(bl, pSDBDevInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefInfo(bl, pSDBDevInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefObjId(bl, pSDBDevInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TimeShareMode(bl, pSDBDevInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UsageMode(bl, pSDBDevInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UsedSize(bl, pSDBDevInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserName(bl, pSDBDevInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WebConsolePath(bl, pSDBDevInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDBDevInst, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AllocSize(boolean bl, PSDBDevInst pSDBDevInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBDevInst.isAllocSizeDirty() : !pSDBDevInst.isAllocSizeDirty()) {
            return null;
        }
        Integer n = pSDBDevInst.getAllocSize();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_AllocSize_Default(pSDBDevInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ALLOCSIZE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ConnStr(boolean bl, PSDBDevInst pSDBDevInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBDevInst.isConnStrDirty() && !bl2 : !pSDBDevInst.isConnStrDirty()) {
            return null;
        }
        String string = pSDBDevInst.getConnStr();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONNSTR");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_ConnStr_Default(pSDBDevInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONNSTR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ConnStrFmt(boolean bl, PSDBDevInst pSDBDevInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBDevInst.isConnStrFmtDirty() : !pSDBDevInst.isConnStrFmtDirty()) {
            return null;
        }
        String string = pSDBDevInst.getConnStrFmt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ConnStrFmt_Default(pSDBDevInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONNSTRFMT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CurDBAction(boolean bl, PSDBDevInst pSDBDevInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBDevInst.isCurDBActionDirty() : !pSDBDevInst.isCurDBActionDirty()) {
            return null;
        }
        String string = pSDBDevInst.getCurDBAction();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CurDBAction_Default(pSDBDevInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CURDBACTION");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DBName(boolean bl, PSDBDevInst pSDBDevInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBDevInst.isDBNameDirty() && !bl2 : !pSDBDevInst.isDBNameDirty()) {
            return null;
        }
        String string = pSDBDevInst.getDBName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DBNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_DBName_Default(pSDBDevInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DBNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DBSchema(boolean bl, PSDBDevInst pSDBDevInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBDevInst.isDBSchemaDirty() : !pSDBDevInst.isDBSchemaDirty()) {
            return null;
        }
        String string = pSDBDevInst.getDBSchema();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DBSchema_Default(pSDBDevInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DBSCHEMA");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DBType(boolean bl, PSDBDevInst pSDBDevInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBDevInst.isDBTypeDirty() && !bl2 : !pSDBDevInst.isDBTypeDirty()) {
            return null;
        }
        String string = pSDBDevInst.getDBType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DBTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_DBType_Default(pSDBDevInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DBTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DMPassWD(boolean bl, PSDBDevInst pSDBDevInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBDevInst.isDMPassWDDirty() : !pSDBDevInst.isDMPassWDDirty()) {
            return null;
        }
        String string = pSDBDevInst.getDMPassWD();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DMPassWD_Default(pSDBDevInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DMPASSWD");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DMUserName(boolean bl, PSDBDevInst pSDBDevInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBDevInst.isDMUserNameDirty() : !pSDBDevInst.isDMUserNameDirty()) {
            return null;
        }
        String string = pSDBDevInst.getDMUserName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DMUserName_Default(pSDBDevInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DMUSERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_InstState(boolean bl, PSDBDevInst pSDBDevInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBDevInst.isInstStateDirty() && !bl2 : !pSDBDevInst.isInstStateDirty()) {
            return null;
        }
        Integer n = pSDBDevInst.getInstState();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INSTSTATE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_InstState_Default(pSDBDevInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_LocalRes(boolean bl, PSDBDevInst pSDBDevInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBDevInst.isLocalResDirty() : !pSDBDevInst.isLocalResDirty()) {
            return null;
        }
        Integer n = pSDBDevInst.getLocalRes();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LocalRes_Default(pSDBDevInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDBDevInst pSDBDevInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBDevInst.isMemoDirty() : !pSDBDevInst.isMemoDirty()) {
            return null;
        }
        String string = pSDBDevInst.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDBDevInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_Param(boolean bl, PSDBDevInst pSDBDevInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBDevInst.isParamDirty() : !pSDBDevInst.isParamDirty()) {
            return null;
        }
        String string = pSDBDevInst.getParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Param_Default(pSDBDevInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_Param2(boolean bl, PSDBDevInst pSDBDevInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBDevInst.isParam2Dirty() : !pSDBDevInst.isParam2Dirty()) {
            return null;
        }
        String string = pSDBDevInst.getParam2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Param2_Default(pSDBDevInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_Param3(boolean bl, PSDBDevInst pSDBDevInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBDevInst.isParam3Dirty() : !pSDBDevInst.isParam3Dirty()) {
            return null;
        }
        String string = pSDBDevInst.getParam3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Param3_Default(pSDBDevInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_Param4(boolean bl, PSDBDevInst pSDBDevInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBDevInst.isParam4Dirty() : !pSDBDevInst.isParam4Dirty()) {
            return null;
        }
        String string = pSDBDevInst.getParam4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Param4_Default(pSDBDevInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_Param5(boolean bl, PSDBDevInst pSDBDevInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBDevInst.isParam5Dirty() : !pSDBDevInst.isParam5Dirty()) {
            return null;
        }
        Integer n = pSDBDevInst.getParam5();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Param5_Default(pSDBDevInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_Param6(boolean bl, PSDBDevInst pSDBDevInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBDevInst.isParam6Dirty() : !pSDBDevInst.isParam6Dirty()) {
            return null;
        }
        Integer n = pSDBDevInst.getParam6();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Param6_Default(pSDBDevInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_Param7(boolean bl, PSDBDevInst pSDBDevInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBDevInst.isParam7Dirty() : !pSDBDevInst.isParam7Dirty()) {
            return null;
        }
        Integer n = pSDBDevInst.getParam7();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Param7_Default(pSDBDevInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_Param8(boolean bl, PSDBDevInst pSDBDevInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBDevInst.isParam8Dirty() : !pSDBDevInst.isParam8Dirty()) {
            return null;
        }
        Integer n = pSDBDevInst.getParam8();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Param8_Default(pSDBDevInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_Passwd(boolean bl, PSDBDevInst pSDBDevInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBDevInst.isPasswdDirty() && !bl2 : !pSDBDevInst.isPasswdDirty()) {
            return null;
        }
        String string = pSDBDevInst.getPasswd();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PASSWD");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_Passwd_Default(pSDBDevInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSAppServerId(boolean bl, PSDBDevInst pSDBDevInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBDevInst.isPSAppServerIdDirty() : !pSDBDevInst.isPSAppServerIdDirty()) {
            return null;
        }
        String string = pSDBDevInst.getPSAppServerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppServerId_Default(pSDBDevInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDBDevInstId(boolean bl, PSDBDevInst pSDBDevInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBDevInst.isPSDBDevInstIdDirty() && !bl2 : !pSDBDevInst.isPSDBDevInstIdDirty()) {
            return null;
        }
        String string = pSDBDevInst.getPSDBDevInstId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDBDEVINSTID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDBDevInstId_Default(pSDBDevInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDBDEVINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDBDevInstName(boolean bl, PSDBDevInst pSDBDevInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBDevInst.isPSDBDevInstNameDirty() && !bl2 : !pSDBDevInst.isPSDBDevInstNameDirty()) {
            return null;
        }
        String string = pSDBDevInst.getPSDBDevInstName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDBDEVINSTNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDBDevInstName_Default(pSDBDevInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDBDEVINSTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDBServerId(boolean bl, PSDBDevInst pSDBDevInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBDevInst.isPSDBServerIdDirty() : !pSDBDevInst.isPSDBServerIdDirty()) {
            return null;
        }
        String string = pSDBDevInst.getPSDBServerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDBServerId_Default(pSDBDevInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDBSERVERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterId(boolean bl, PSDBDevInst pSDBDevInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBDevInst.isPSDevCenterIdDirty() : !pSDBDevInst.isPSDevCenterIdDirty()) {
            return null;
        }
        String string = pSDBDevInst.getPSDevCenterId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterId_Default(pSDBDevInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevCenterName(boolean bl, PSDBDevInst pSDBDevInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBDevInst.isPSDevCenterNameDirty() : !pSDBDevInst.isPSDevCenterNameDirty()) {
            return null;
        }
        String string = pSDBDevInst.getPSDevCenterName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterName_Default(pSDBDevInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSvrDomainId(boolean bl, PSDBDevInst pSDBDevInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBDevInst.isPSSvrDomainIdDirty() : !pSDBDevInst.isPSSvrDomainIdDirty()) {
            return null;
        }
        String string = pSDBDevInst.getPSSvrDomainId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSvrDomainId_Default(pSDBDevInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_RefInfo(boolean bl, PSDBDevInst pSDBDevInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBDevInst.isRefInfoDirty() : !pSDBDevInst.isRefInfoDirty()) {
            return null;
        }
        String string = pSDBDevInst.getRefInfo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefInfo_Default(pSDBDevInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_RefObjId(boolean bl, PSDBDevInst pSDBDevInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBDevInst.isRefObjIdDirty() : !pSDBDevInst.isRefObjIdDirty()) {
            return null;
        }
        String string = pSDBDevInst.getRefObjId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefObjId_Default(pSDBDevInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFOBJID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TimeShareMode(boolean bl, PSDBDevInst pSDBDevInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBDevInst.isTimeShareModeDirty() : !pSDBDevInst.isTimeShareModeDirty()) {
            return null;
        }
        Integer n = pSDBDevInst.getTimeShareMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_TimeShareMode_Default(pSDBDevInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_UsageMode(boolean bl, PSDBDevInst pSDBDevInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBDevInst.isUsageModeDirty() : !pSDBDevInst.isUsageModeDirty()) {
            return null;
        }
        String string = pSDBDevInst.getUsageMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UsageMode_Default(pSDBDevInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_UsedSize(boolean bl, PSDBDevInst pSDBDevInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBDevInst.isUsedSizeDirty() : !pSDBDevInst.isUsedSizeDirty()) {
            return null;
        }
        Integer n = pSDBDevInst.getUsedSize();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_UsedSize_Default(pSDBDevInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USEDSIZE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserName(boolean bl, PSDBDevInst pSDBDevInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBDevInst.isUserNameDirty() && !bl2 : !pSDBDevInst.isUserNameDirty()) {
            return null;
        }
        String string = pSDBDevInst.getUserName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserName_Default(pSDBDevInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_WebConsolePath(boolean bl, PSDBDevInst pSDBDevInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBDevInst.isWebConsolePathDirty() : !pSDBDevInst.isWebConsolePathDirty()) {
            return null;
        }
        String string = pSDBDevInst.getWebConsolePath();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WebConsolePath_Default(pSDBDevInst, bl2, bl3);
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

    protected void onSyncEntity(PSDBDevInst pSDBDevInst, boolean bl) throws Exception {
        super.onSyncEntity(pSDBDevInst, bl);
    }

    protected void onSyncIndexEntities(PSDBDevInst pSDBDevInst, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDBDevInst, bl);
    }

    public Object getDataContextValue(PSDBDevInst pSDBDevInst, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDBDevInst, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDBDevInst pSDBDevInst, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDBDevInst, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ALLOCSIZE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AllocSize_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CONNSTR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ConnStr_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CONNSTRFMT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ConnStrFmt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CURDBACTION", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CurDBAction_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DBNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DBName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DBSCHEMA", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DBSchema_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DBTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DBType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DMPASSWD", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DMPassWD_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DMUSERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DMUserName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INSTSTATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_InstState_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSDBDEVINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDBDevInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDBDEVINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDBDevInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDBSERVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDBServerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDBSERVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDBServerName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"REFINFO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefInfo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFOBJID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefObjId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TIMESHAREMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TimeShareMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USAGEMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UsageMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USEDSIZE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UsedSize_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WEBCONSOLEPATH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WebConsolePath_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_AllocSize_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ConnStr_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONNSTR", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ConnStrFmt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONNSTRFMT", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
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

    protected String onTestValueRule_CurDBAction_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CURDBACTION", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DBName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DBNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DBSchema_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DBSCHEMA", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DBType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DBTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DMPassWD_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DMPASSWD", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DMUserName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DMUSERNAME", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_InstState_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_LocalRes_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_PSDBDevInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDBDEVINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDBDevInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDBDEVINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDBServerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDBSERVERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDBServerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDBSERVERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_RefObjId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFOBJID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TimeShareMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_UsedSize_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected boolean onMergeChild(String string, String string2, PSDBDevInst pSDBDevInst) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDBDevInst)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDBDevInst pSDBDevInst) throws Exception {
        super.onUpdateParent(pSDBDevInst);
    }

    @Override
    protected void exportCurXmlModel(PSDBDevInst pSDBDevInst, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDBDEVINST");
        if (!bl) {
            pSDBDevInst.setCreateDate(null);
            pSDBDevInst.setCreateMan(null);
            pSDBDevInst.setPSAppServerName(null);
            pSDBDevInst.setPSDBDevInstId(null);
            pSDBDevInst.setPSDBServerName(null);
            pSDBDevInst.setRefInfo(null);
            pSDBDevInst.setUpdateDate(null);
            pSDBDevInst.setUpdateMan(null);
            super.exportCurXmlModel(pSDBDevInst, xmlNode, bl);
        }
    }
}

