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
import net.ibizsys.pscore.srv.paasmgr.dao.PSStudioServerDAO;
import net.ibizsys.pscore.srv.paasmgr.demodel.PSStudioServerDEModel;
import net.ibizsys.pscore.srv.paasmgr.entity.PSCorePrd;
import net.ibizsys.pscore.srv.paasmgr.entity.PSCorePrdBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSCorePrdVer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSCorePrdVerBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSStudioServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSStudioServerGrp;
import net.ibizsys.pscore.srv.paasmgr.entity.PSStudioServerGrpBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSvrDomain;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSvrDomainBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSStudioServerServiceBase
extends PSCoreSysServiceBase<PSStudioServer> {
    private static final Log log = LogFactory.getLog(PSStudioServerServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSStudioServerDEModel pSStudioServerDEModel;
    private PSStudioServerDAO pSStudioServerDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.paasmgr.service.PSStudioServerService";
    }

    public PSStudioServerDEModel getPSStudioServerDEModel() {
        if (this.pSStudioServerDEModel == null) {
            try {
                this.pSStudioServerDEModel = (PSStudioServerDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.paasmgr.demodel.PSStudioServerDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSStudioServerDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSStudioServerDEModel();
    }

    public PSStudioServerDAO getPSStudioServerDAO() {
        if (this.pSStudioServerDAO == null) {
            try {
                this.pSStudioServerDAO = (PSStudioServerDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.paasmgr.dao.PSStudioServerDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSStudioServerDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSStudioServerDAO();
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

    protected void onFillParentInfo(PSStudioServer pSStudioServer, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSTUDIOSERVER_PSCOREPRDVER_PSCOREPRDVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSCorePrdVerService", (SessionFactory)this.getSessionFactory());
            PSCorePrdVer pSCorePrdVer = (PSCorePrdVer)iService.getDEModel().createEntity();
            pSCorePrdVer.set("PSCOREPRDVERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSCorePrdVer);
            } else {
                iService.get((IEntity)pSCorePrdVer);
            }
            this.onFillParentInfo_PSCorePrdVer(pSStudioServer, pSCorePrdVer);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSTUDIOSERVER_PSCOREPRD_PSCOREPRDID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSCorePrdService", (SessionFactory)this.getSessionFactory());
            PSCorePrd pSCorePrd = (PSCorePrd)iService.getDEModel().createEntity();
            pSCorePrd.set("PSCOREPRDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSCorePrd);
            } else {
                iService.get((IEntity)pSCorePrd);
            }
            this.onFillParentInfo_PSCorePrd(pSStudioServer, pSCorePrd);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSTUDIOSERVER_PSSTUDIOSERVERGRP_PSSTUDIOSERVERGRPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSStudioServerGrpService", (SessionFactory)this.getSessionFactory());
            PSStudioServerGrp pSStudioServerGrp = (PSStudioServerGrp)iService.getDEModel().createEntity();
            pSStudioServerGrp.set("PSSTUDIOSERVERGRPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSStudioServerGrp);
            } else {
                iService.get((IEntity)pSStudioServerGrp);
            }
            this.onFillParentInfo_PSStudioServerGrp(pSStudioServer, pSStudioServerGrp);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSTUDIOSERVER_PSSVRDOMAIN_PSSVRDOMAINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSSvrDomainService", (SessionFactory)this.getSessionFactory());
            PSSvrDomain pSSvrDomain = (PSSvrDomain)iService.getDEModel().createEntity();
            pSSvrDomain.set("PSSVRDOMAINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSvrDomain);
            } else {
                iService.get((IEntity)pSSvrDomain);
            }
            this.onFillParentInfo_PSSvrDomain(pSStudioServer, pSSvrDomain);
            return;
        }
        super.onFillParentInfo((IEntity)pSStudioServer, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSCorePrdVer(PSStudioServer pSStudioServer, PSCorePrdVer pSCorePrdVer) throws Exception {
        pSStudioServer.setPSCorePrdVerId(pSCorePrdVer.getPSCorePrdVerId());
        pSStudioServer.setPSCorePrdVerName(pSCorePrdVer.getPSCorePrdVerName());
    }

    protected void onFillParentInfo_PSCorePrd(PSStudioServer pSStudioServer, PSCorePrd pSCorePrd) throws Exception {
        pSStudioServer.setPSCorePrdId(pSCorePrd.getPSCorePrdId());
        pSStudioServer.setPSCorePrdName(pSCorePrd.getPSCorePrdName());
    }

    protected void onFillParentInfo_PSStudioServerGrp(PSStudioServer pSStudioServer, PSStudioServerGrp pSStudioServerGrp) throws Exception {
        pSStudioServer.setPSStudioServerGrpId(pSStudioServerGrp.getPSStudioServerGrpId());
        pSStudioServer.setPSStudioServerGrpName(pSStudioServerGrp.getPSStudioServerGrpName());
    }

    protected void onFillParentInfo_PSSvrDomain(PSStudioServer pSStudioServer, PSSvrDomain pSSvrDomain) throws Exception {
        pSStudioServer.setDomainParams(pSSvrDomain.getDomainParams());
        pSStudioServer.setPSSvrDomainId(pSSvrDomain.getPSSvrDomainId());
        pSStudioServer.setPSSvrDomainName(pSSvrDomain.getPSSvrDomainName());
    }

    protected void onFillEntityFullInfo(PSStudioServer pSStudioServer, boolean bl) throws Exception {
        if (bl && pSStudioServer.getValidFlag() == null) {
            pSStudioServer.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo((IEntity)pSStudioServer, bl);
        this.onFillEntityFullInfo_PSCorePrdVer(pSStudioServer, bl);
        this.onFillEntityFullInfo_PSCorePrd(pSStudioServer, bl);
        this.onFillEntityFullInfo_PSStudioServerGrp(pSStudioServer, bl);
        this.onFillEntityFullInfo_PSSvrDomain(pSStudioServer, bl);
    }

    protected void onFillEntityFullInfo_PSCorePrdVer(PSStudioServer pSStudioServer, boolean bl) throws Exception {
        if (pSStudioServer.isPSCorePrdVerIdDirty()) {
            if (pSStudioServer.getPSCorePrdVerId() != null) {
                if (pSStudioServer.getPSCorePrdVerId() == null || pSStudioServer.getPSCorePrdVerName() == null) {
                    PSCorePrdVer pSCorePrdVer = pSStudioServer.getPSCorePrdVer();
                    pSStudioServer.setPSCorePrdVerName(pSCorePrdVer.getPSCorePrdVerName());
                }
            } else {
                pSStudioServer.setPSCorePrdVerName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSCorePrd(PSStudioServer pSStudioServer, boolean bl) throws Exception {
        if (pSStudioServer.isPSCorePrdIdDirty()) {
            if (pSStudioServer.getPSCorePrdId() != null) {
                if (pSStudioServer.getPSCorePrdId() == null || pSStudioServer.getPSCorePrdName() == null) {
                    PSCorePrd pSCorePrd = pSStudioServer.getPSCorePrd();
                    pSStudioServer.setPSCorePrdName(pSCorePrd.getPSCorePrdName());
                }
            } else {
                pSStudioServer.setPSCorePrdName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSStudioServerGrp(PSStudioServer pSStudioServer, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSvrDomain(PSStudioServer pSStudioServer, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSStudioServer pSStudioServer, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSStudioServer, bl);
    }

    public ArrayList<PSStudioServer> selectByPSCorePrdVer(PSCorePrdVerBase pSCorePrdVerBase) throws Exception {
        return this.selectByPSCorePrdVer(pSCorePrdVerBase, "", -1);
    }

    public ArrayList<PSStudioServer> selectByPSCorePrdVer(PSCorePrdVerBase pSCorePrdVerBase, String string) throws Exception {
        return this.selectByPSCorePrdVer(pSCorePrdVerBase, string, -1);
    }

    public ArrayList<PSStudioServer> selectByPSCorePrdVer(PSCorePrdVerBase pSCorePrdVerBase, String string, int n) throws Exception {
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

    public ArrayList<PSStudioServer> selectByPSCorePrd(PSCorePrdBase pSCorePrdBase) throws Exception {
        return this.selectByPSCorePrd(pSCorePrdBase, "", -1);
    }

    public ArrayList<PSStudioServer> selectByPSCorePrd(PSCorePrdBase pSCorePrdBase, String string) throws Exception {
        return this.selectByPSCorePrd(pSCorePrdBase, string, -1);
    }

    public ArrayList<PSStudioServer> selectByPSCorePrd(PSCorePrdBase pSCorePrdBase, String string, int n) throws Exception {
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

    public ArrayList<PSStudioServer> selectByPSStudioServerGrp(PSStudioServerGrpBase pSStudioServerGrpBase) throws Exception {
        return this.selectByPSStudioServerGrp(pSStudioServerGrpBase, "", -1);
    }

    public ArrayList<PSStudioServer> selectByPSStudioServerGrp(PSStudioServerGrpBase pSStudioServerGrpBase, String string) throws Exception {
        return this.selectByPSStudioServerGrp(pSStudioServerGrpBase, string, -1);
    }

    public ArrayList<PSStudioServer> selectByPSStudioServerGrp(PSStudioServerGrpBase pSStudioServerGrpBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSTUDIOSERVERGRPID", (Object)pSStudioServerGrpBase.getPSStudioServerGrpId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSStudioServerGrpCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSStudioServerGrpCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSStudioServer> selectByPSSvrDomain(PSSvrDomainBase pSSvrDomainBase) throws Exception {
        return this.selectByPSSvrDomain(pSSvrDomainBase, "", -1);
    }

    public ArrayList<PSStudioServer> selectByPSSvrDomain(PSSvrDomainBase pSSvrDomainBase, String string) throws Exception {
        return this.selectByPSSvrDomain(pSSvrDomainBase, string, -1);
    }

    public ArrayList<PSStudioServer> selectByPSSvrDomain(PSSvrDomainBase pSSvrDomainBase, String string, int n) throws Exception {
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

    public void testRemoveByPSCorePrdVer(PSCorePrdVer pSCorePrdVer) throws Exception {
    }

    public void resetPSCorePrdVer(PSCorePrdVer pSCorePrdVer) throws Exception {
        ArrayList<PSStudioServer> arrayList = this.selectByPSCorePrdVer(pSCorePrdVer);
        for (PSStudioServer pSStudioServer : arrayList) {
            PSStudioServer pSStudioServer2 = (PSStudioServer)this.getDEModel().createEntity();
            pSStudioServer2.setPSStudioServerId(pSStudioServer.getPSStudioServerId());
            pSStudioServer2.setPSCorePrdVerId(null);
            this.update(pSStudioServer2);
        }
    }

    public void removeByPSCorePrdVer(PSCorePrdVer pSCorePrdVer) throws Exception {
        final PSCorePrdVer pSCorePrdVer2 = pSCorePrdVer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSStudioServerServiceBase.this.onBeforeRemoveByPSCorePrdVer(pSCorePrdVer2);
                PSStudioServerServiceBase.this.internalRemoveByPSCorePrdVer(pSCorePrdVer2);
                PSStudioServerServiceBase.this.onAfterRemoveByPSCorePrdVer(pSCorePrdVer2);
            }
        });
    }

    protected void onBeforeRemoveByPSCorePrdVer(PSCorePrdVer pSCorePrdVer) throws Exception {
    }

    protected void internalRemoveByPSCorePrdVer(PSCorePrdVer pSCorePrdVer) throws Exception {
        ArrayList<PSStudioServer> arrayList = this.selectByPSCorePrdVer(pSCorePrdVer);
        this.onBeforeRemoveByPSCorePrdVer(pSCorePrdVer, arrayList);
        for (PSStudioServer pSStudioServer : arrayList) {
            this.remove((IEntity)pSStudioServer);
        }
        this.onAfterRemoveByPSCorePrdVer(pSCorePrdVer, arrayList);
    }

    protected void onAfterRemoveByPSCorePrdVer(PSCorePrdVer pSCorePrdVer) throws Exception {
    }

    protected void onBeforeRemoveByPSCorePrdVer(PSCorePrdVer pSCorePrdVer, ArrayList<PSStudioServer> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSCorePrdVer(PSCorePrdVer pSCorePrdVer, ArrayList<PSStudioServer> arrayList) throws Exception {
    }

    public void testRemoveByPSCorePrd(PSCorePrd pSCorePrd) throws Exception {
    }

    public void resetPSCorePrd(PSCorePrd pSCorePrd) throws Exception {
        ArrayList<PSStudioServer> arrayList = this.selectByPSCorePrd(pSCorePrd);
        for (PSStudioServer pSStudioServer : arrayList) {
            PSStudioServer pSStudioServer2 = (PSStudioServer)this.getDEModel().createEntity();
            pSStudioServer2.setPSStudioServerId(pSStudioServer.getPSStudioServerId());
            pSStudioServer2.setPSCorePrdId(null);
            this.update(pSStudioServer2);
        }
    }

    public void removeByPSCorePrd(PSCorePrd pSCorePrd) throws Exception {
        final PSCorePrd pSCorePrd2 = pSCorePrd;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSStudioServerServiceBase.this.onBeforeRemoveByPSCorePrd(pSCorePrd2);
                PSStudioServerServiceBase.this.internalRemoveByPSCorePrd(pSCorePrd2);
                PSStudioServerServiceBase.this.onAfterRemoveByPSCorePrd(pSCorePrd2);
            }
        });
    }

    protected void onBeforeRemoveByPSCorePrd(PSCorePrd pSCorePrd) throws Exception {
    }

    protected void internalRemoveByPSCorePrd(PSCorePrd pSCorePrd) throws Exception {
        ArrayList<PSStudioServer> arrayList = this.selectByPSCorePrd(pSCorePrd);
        this.onBeforeRemoveByPSCorePrd(pSCorePrd, arrayList);
        for (PSStudioServer pSStudioServer : arrayList) {
            this.remove((IEntity)pSStudioServer);
        }
        this.onAfterRemoveByPSCorePrd(pSCorePrd, arrayList);
    }

    protected void onAfterRemoveByPSCorePrd(PSCorePrd pSCorePrd) throws Exception {
    }

    protected void onBeforeRemoveByPSCorePrd(PSCorePrd pSCorePrd, ArrayList<PSStudioServer> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSCorePrd(PSCorePrd pSCorePrd, ArrayList<PSStudioServer> arrayList) throws Exception {
    }

    public void testRemoveByPSStudioServerGrp(PSStudioServerGrp pSStudioServerGrp) throws Exception {
        ArrayList<PSStudioServer> arrayList = this.selectByPSStudioServerGrp(pSStudioServerGrp, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSTUDIOSERVERGRP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSStudioServerGrp);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSTUDIOSERVER_PSSTUDIOSERVERGRP_PSSTUDIOSERVERGRPID", "", iDataEntityModel.getName(), "PSSTUDIOSERVER", iDataEntityModel.getDataInfo((IEntity)pSStudioServerGrp), arrayList.get(0)));
        }
    }

    public void resetPSStudioServerGrp(PSStudioServerGrp pSStudioServerGrp) throws Exception {
        ArrayList<PSStudioServer> arrayList = this.selectByPSStudioServerGrp(pSStudioServerGrp);
        for (PSStudioServer pSStudioServer : arrayList) {
            PSStudioServer pSStudioServer2 = (PSStudioServer)this.getDEModel().createEntity();
            pSStudioServer2.setPSStudioServerId(pSStudioServer.getPSStudioServerId());
            pSStudioServer2.setPSStudioServerGrpId(null);
            this.update(pSStudioServer2);
        }
    }

    public void removeByPSStudioServerGrp(PSStudioServerGrp pSStudioServerGrp) throws Exception {
        final PSStudioServerGrp pSStudioServerGrp2 = pSStudioServerGrp;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSStudioServerServiceBase.this.onBeforeRemoveByPSStudioServerGrp(pSStudioServerGrp2);
                PSStudioServerServiceBase.this.internalRemoveByPSStudioServerGrp(pSStudioServerGrp2);
                PSStudioServerServiceBase.this.onAfterRemoveByPSStudioServerGrp(pSStudioServerGrp2);
            }
        });
    }

    protected void onBeforeRemoveByPSStudioServerGrp(PSStudioServerGrp pSStudioServerGrp) throws Exception {
    }

    protected void internalRemoveByPSStudioServerGrp(PSStudioServerGrp pSStudioServerGrp) throws Exception {
        ArrayList<PSStudioServer> arrayList = this.selectByPSStudioServerGrp(pSStudioServerGrp);
        this.onBeforeRemoveByPSStudioServerGrp(pSStudioServerGrp, arrayList);
        for (PSStudioServer pSStudioServer : arrayList) {
            this.remove((IEntity)pSStudioServer);
        }
        this.onAfterRemoveByPSStudioServerGrp(pSStudioServerGrp, arrayList);
    }

    protected void onAfterRemoveByPSStudioServerGrp(PSStudioServerGrp pSStudioServerGrp) throws Exception {
    }

    protected void onBeforeRemoveByPSStudioServerGrp(PSStudioServerGrp pSStudioServerGrp, ArrayList<PSStudioServer> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSStudioServerGrp(PSStudioServerGrp pSStudioServerGrp, ArrayList<PSStudioServer> arrayList) throws Exception {
    }

    public void testRemoveByPSSvrDomain(PSSvrDomain pSSvrDomain) throws Exception {
        ArrayList<PSStudioServer> arrayList = this.selectByPSSvrDomain(pSSvrDomain, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSVRDOMAIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSvrDomain);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSTUDIOSERVER_PSSVRDOMAIN_PSSVRDOMAINID", "", iDataEntityModel.getName(), "PSSTUDIOSERVER", iDataEntityModel.getDataInfo((IEntity)pSSvrDomain), arrayList.get(0)));
        }
    }

    public void resetPSSvrDomain(PSSvrDomain pSSvrDomain) throws Exception {
        ArrayList<PSStudioServer> arrayList = this.selectByPSSvrDomain(pSSvrDomain);
        for (PSStudioServer pSStudioServer : arrayList) {
            PSStudioServer pSStudioServer2 = (PSStudioServer)this.getDEModel().createEntity();
            pSStudioServer2.setPSStudioServerId(pSStudioServer.getPSStudioServerId());
            pSStudioServer2.setPSSvrDomainId(null);
            this.update(pSStudioServer2);
        }
    }

    public void removeByPSSvrDomain(PSSvrDomain pSSvrDomain) throws Exception {
        final PSSvrDomain pSSvrDomain2 = pSSvrDomain;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSStudioServerServiceBase.this.onBeforeRemoveByPSSvrDomain(pSSvrDomain2);
                PSStudioServerServiceBase.this.internalRemoveByPSSvrDomain(pSSvrDomain2);
                PSStudioServerServiceBase.this.onAfterRemoveByPSSvrDomain(pSSvrDomain2);
            }
        });
    }

    protected void onBeforeRemoveByPSSvrDomain(PSSvrDomain pSSvrDomain) throws Exception {
    }

    protected void internalRemoveByPSSvrDomain(PSSvrDomain pSSvrDomain) throws Exception {
        ArrayList<PSStudioServer> arrayList = this.selectByPSSvrDomain(pSSvrDomain);
        this.onBeforeRemoveByPSSvrDomain(pSSvrDomain, arrayList);
        for (PSStudioServer pSStudioServer : arrayList) {
            this.remove((IEntity)pSStudioServer);
        }
        this.onAfterRemoveByPSSvrDomain(pSSvrDomain, arrayList);
    }

    protected void onAfterRemoveByPSSvrDomain(PSSvrDomain pSSvrDomain) throws Exception {
    }

    protected void onBeforeRemoveByPSSvrDomain(PSSvrDomain pSSvrDomain, ArrayList<PSStudioServer> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSvrDomain(PSSvrDomain pSSvrDomain, ArrayList<PSStudioServer> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSStudioServer pSStudioServer) throws Exception {
        super.onBeforeRemove(pSStudioServer);
    }

    protected void replaceParentInfo(PSStudioServer pSStudioServer, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSStudioServer, cloneSession);
        if (pSStudioServer.getPSCorePrdVerId() != null && (iEntity = cloneSession.getEntity("PSCOREPRDVER", (Object)pSStudioServer.getPSCorePrdVerId())) != null) {
            this.onFillParentInfo_PSCorePrdVer(pSStudioServer, (PSCorePrdVer)iEntity);
        }
        if (pSStudioServer.getPSCorePrdId() != null && (iEntity = cloneSession.getEntity("PSCOREPRD", (Object)pSStudioServer.getPSCorePrdId())) != null) {
            this.onFillParentInfo_PSCorePrd(pSStudioServer, (PSCorePrd)iEntity);
        }
        if (pSStudioServer.getPSStudioServerGrpId() != null && (iEntity = cloneSession.getEntity("PSSTUDIOSERVERGRP", (Object)pSStudioServer.getPSStudioServerGrpId())) != null) {
            this.onFillParentInfo_PSStudioServerGrp(pSStudioServer, (PSStudioServerGrp)iEntity);
        }
        if (pSStudioServer.getPSSvrDomainId() != null && (iEntity = cloneSession.getEntity("PSSVRDOMAIN", (Object)pSStudioServer.getPSSvrDomainId())) != null) {
            this.onFillParentInfo_PSSvrDomain(pSStudioServer, (PSSvrDomain)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSStudioServer pSStudioServer, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSStudioServer, bl);
    }

    protected void onCheckEntity(boolean bl, PSStudioServer pSStudioServer, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_IPAddr(bl, pSStudioServer, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IPAddr2(bl, pSStudioServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSStudioServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCorePrdId(bl, pSStudioServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCorePrdName(bl, pSStudioServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCorePrdVerId(bl, pSStudioServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCorePrdVerName(bl, pSStudioServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSStudioServerGrpId(bl, pSStudioServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSStudioServerId(bl, pSStudioServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSStudioServerName(bl, pSStudioServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSvrDomainId(bl, pSStudioServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ServerParams(bl, pSStudioServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ServerUrl(bl, pSStudioServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ServerUrl2(bl, pSStudioServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSStudioServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSStudioServer, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_IPAddr(boolean bl, PSStudioServer pSStudioServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSStudioServer.isIPAddrDirty() : !pSStudioServer.isIPAddrDirty()) {
            return null;
        }
        String string = pSStudioServer.getIPAddr();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_IPAddr_Default((IEntity)pSStudioServer, bl2, bl3);
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

    protected EntityFieldError onCheckField_IPAddr2(boolean bl, PSStudioServer pSStudioServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSStudioServer.isIPAddr2Dirty() : !pSStudioServer.isIPAddr2Dirty()) {
            return null;
        }
        String string = pSStudioServer.getIPAddr2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_IPAddr2_Default((IEntity)pSStudioServer, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSStudioServer pSStudioServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSStudioServer.isMemoDirty() : !pSStudioServer.isMemoDirty()) {
            return null;
        }
        String string = pSStudioServer.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSStudioServer, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSCorePrdId(boolean bl, PSStudioServer pSStudioServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSStudioServer.isPSCorePrdIdDirty() : !pSStudioServer.isPSCorePrdIdDirty()) {
            return null;
        }
        String string = pSStudioServer.getPSCorePrdId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCorePrdId_Default((IEntity)pSStudioServer, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSCorePrdName(boolean bl, PSStudioServer pSStudioServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSStudioServer.isPSCorePrdNameDirty() : !pSStudioServer.isPSCorePrdNameDirty()) {
            return null;
        }
        String string = pSStudioServer.getPSCorePrdName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCorePrdName_Default((IEntity)pSStudioServer, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSCorePrdVerId(boolean bl, PSStudioServer pSStudioServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSStudioServer.isPSCorePrdVerIdDirty() : !pSStudioServer.isPSCorePrdVerIdDirty()) {
            return null;
        }
        String string = pSStudioServer.getPSCorePrdVerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCorePrdVerId_Default((IEntity)pSStudioServer, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSCorePrdVerName(boolean bl, PSStudioServer pSStudioServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSStudioServer.isPSCorePrdVerNameDirty() : !pSStudioServer.isPSCorePrdVerNameDirty()) {
            return null;
        }
        String string = pSStudioServer.getPSCorePrdVerName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCorePrdVerName_Default((IEntity)pSStudioServer, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSStudioServerGrpId(boolean bl, PSStudioServer pSStudioServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSStudioServer.isPSStudioServerGrpIdDirty() : !pSStudioServer.isPSStudioServerGrpIdDirty()) {
            return null;
        }
        String string = pSStudioServer.getPSStudioServerGrpId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSStudioServerGrpId_Default((IEntity)pSStudioServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSTUDIOSERVERGRPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSStudioServerId(boolean bl, PSStudioServer pSStudioServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSStudioServer.isPSStudioServerIdDirty() && !bl2 : !pSStudioServer.isPSStudioServerIdDirty()) {
            return null;
        }
        String string = pSStudioServer.getPSStudioServerId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSTUDIOSERVERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSStudioServerId_Default((IEntity)pSStudioServer, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSStudioServerName(boolean bl, PSStudioServer pSStudioServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSStudioServer.isPSStudioServerNameDirty() && !bl2 : !pSStudioServer.isPSStudioServerNameDirty()) {
            return null;
        }
        String string = pSStudioServer.getPSStudioServerName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSTUDIOSERVERNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSStudioServerName_Default((IEntity)pSStudioServer, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSvrDomainId(boolean bl, PSStudioServer pSStudioServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSStudioServer.isPSSvrDomainIdDirty() : !pSStudioServer.isPSSvrDomainIdDirty()) {
            return null;
        }
        String string = pSStudioServer.getPSSvrDomainId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSvrDomainId_Default((IEntity)pSStudioServer, bl2, bl3);
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

    protected EntityFieldError onCheckField_ServerParams(boolean bl, PSStudioServer pSStudioServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSStudioServer.isServerParamsDirty() : !pSStudioServer.isServerParamsDirty()) {
            return null;
        }
        String string = pSStudioServer.getServerParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ServerParams_Default((IEntity)pSStudioServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SERVERPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ServerUrl(boolean bl, PSStudioServer pSStudioServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSStudioServer.isServerUrlDirty() && !bl2 : !pSStudioServer.isServerUrlDirty()) {
            return null;
        }
        String string = pSStudioServer.getServerUrl();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SERVERURL");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_ServerUrl_Default((IEntity)pSStudioServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SERVERURL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ServerUrl2(boolean bl, PSStudioServer pSStudioServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSStudioServer.isServerUrl2Dirty() : !pSStudioServer.isServerUrl2Dirty()) {
            return null;
        }
        String string = pSStudioServer.getServerUrl2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ServerUrl2_Default((IEntity)pSStudioServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SERVERURL2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSStudioServer pSStudioServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSStudioServer.isValidFlagDirty() && !bl2 : !pSStudioServer.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSStudioServer.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSStudioServer, bl2, bl3);
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

    protected void onSyncEntity(PSStudioServer pSStudioServer, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSStudioServer, bl);
    }

    protected void onSyncIndexEntities(PSStudioServer pSStudioServer, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSStudioServer, bl);
    }

    public Object getDataContextValue(PSStudioServer pSStudioServer, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSStudioServer, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSStudioServer pSStudioServer, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSStudioServer, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DOMAINPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DomainParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"IPADDR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IPAddr_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"IPADDR2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IPAddr2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCOREPRDID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCorePrdId_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSSTUDIOSERVERGRPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSStudioServerGrpId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSTUDIOSERVERGRPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSStudioServerGrpName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSTUDIOSERVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSStudioServerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSTUDIOSERVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSStudioServerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSVRDOMAINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSvrDomainId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSVRDOMAINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSvrDomainName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SERVERPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ServerParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SERVERURL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ServerUrl_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SERVERURL2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ServerUrl2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALIDFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValidFlag_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_DomainParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DOMAINPARAMS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_IPAddr_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_IPAddr2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_PSStudioServerGrpId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSTUDIOSERVERGRPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSStudioServerGrpName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSTUDIOSERVERGRPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_ServerParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SERVERPARAMS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ServerUrl_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SERVERURL", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ServerUrl2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SERVERURL2", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
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

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected boolean onMergeChild(String string, String string2, PSStudioServer pSStudioServer) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSStudioServer)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSStudioServer pSStudioServer) throws Exception {
        super.onUpdateParent((IEntity)pSStudioServer);
    }

    @Override
    protected void exportCurXmlModel(PSStudioServer pSStudioServer, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSTUDIOSERVER");
        if (!bl) {
            pSStudioServer.setCreateDate(null);
            pSStudioServer.setCreateMan(null);
            pSStudioServer.setPSStudioServerId(null);
            pSStudioServer.setPSSvrDomainName(null);
            pSStudioServer.setUpdateDate(null);
            pSStudioServer.setUpdateMan(null);
            super.exportCurXmlModel(pSStudioServer, xmlNode, bl);
        }
    }
}

