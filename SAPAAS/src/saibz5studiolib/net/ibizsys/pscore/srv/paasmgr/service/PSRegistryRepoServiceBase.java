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
import net.ibizsys.pscore.srv.devcenter.service.PSDCRegistryRepoService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCRegistryRepoServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSSaaSSysVerService;
import net.ibizsys.pscore.srv.devcenter.service.PSSaaSSysVerServiceBase;
import net.ibizsys.pscore.srv.paasmgr.dao.PSRegistryRepoDAO;
import net.ibizsys.pscore.srv.paasmgr.demodel.PSRegistryRepoDEModel;
import net.ibizsys.pscore.srv.paasmgr.entity.PSRegistryRepo;
import net.ibizsys.pscore.srv.paasmgr.entity.PSRegistryServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSRegistryServerBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSvrDomain;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSvrDomainBase;
import net.ibizsys.pscore.srv.paasmgr.service.PSDeployCenterService;
import net.ibizsys.pscore.srv.paasmgr.service.PSDeployCenterServiceBase;
import net.ibizsys.pscore.srv.paasmgr.service.PSRegistryItemService;
import net.ibizsys.pscore.srv.paasmgr.service.PSRegistryItemServiceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSRegistryRepoServiceBase
extends PSCoreSysServiceBase<PSRegistryRepo> {
    private static final Log log = LogFactory.getLog(PSRegistryRepoServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSRegistryRepoDEModel pSRegistryRepoDEModel;
    private PSRegistryRepoDAO pSRegistryRepoDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.paasmgr.service.PSRegistryRepoService";
    }

    public PSRegistryRepoDEModel getPSRegistryRepoDEModel() {
        if (this.pSRegistryRepoDEModel == null) {
            try {
                this.pSRegistryRepoDEModel = (PSRegistryRepoDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.paasmgr.demodel.PSRegistryRepoDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSRegistryRepoDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSRegistryRepoDEModel();
    }

    public PSRegistryRepoDAO getPSRegistryRepoDAO() {
        if (this.pSRegistryRepoDAO == null) {
            try {
                this.pSRegistryRepoDAO = (PSRegistryRepoDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.paasmgr.dao.PSRegistryRepoDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSRegistryRepoDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSRegistryRepoDAO();
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

    protected void onFillParentInfo(PSRegistryRepo pSRegistryRepo, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSREGISTRYREPO_PSDEVCENTER_PSDEVCENTERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService", (SessionFactory)this.getSessionFactory());
            PSDevCenter pSDevCenter = (PSDevCenter)iService.getDEModel().createEntity();
            pSDevCenter.set("PSDEVCENTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenter);
            } else {
                iService.get(pSDevCenter);
            }
            this.onFillParentInfo_PSDevCenter(pSRegistryRepo, pSDevCenter);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSREGISTRYREPO_PSREGISTRYSERVER_PSREGISTRYSERVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSRegistryServerService", (SessionFactory)this.getSessionFactory());
            PSRegistryServer pSRegistryServer = (PSRegistryServer)iService.getDEModel().createEntity();
            pSRegistryServer.set("PSREGISTRYSERVERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSRegistryServer);
            } else {
                iService.get(pSRegistryServer);
            }
            this.onFillParentInfo_Psregistryserver(pSRegistryRepo, pSRegistryServer);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSREGISTRYREPO_PSSVRDOMAIN_PSSVRDOMAINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSSvrDomainService", (SessionFactory)this.getSessionFactory());
            PSSvrDomain pSSvrDomain = (PSSvrDomain)iService.getDEModel().createEntity();
            pSSvrDomain.set("PSSVRDOMAINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSvrDomain);
            } else {
                iService.get(pSSvrDomain);
            }
            this.onFillParentInfo_Pssvrdomain(pSRegistryRepo, pSSvrDomain);
            return;
        }
        super.onFillParentInfo(pSRegistryRepo, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDevCenter(PSRegistryRepo pSRegistryRepo, PSDevCenter pSDevCenter) throws Exception {
        pSRegistryRepo.setPSDevCenterId(pSDevCenter.getPSDevCenterId());
        pSRegistryRepo.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
    }

    protected void onFillParentInfo_Psregistryserver(PSRegistryRepo pSRegistryRepo, PSRegistryServer pSRegistryServer) throws Exception {
        pSRegistryRepo.setPSRegistryServerId(pSRegistryServer.getPSRegistryServerId());
        pSRegistryRepo.setPSRegistryServerName(pSRegistryServer.getPSRegistryServerName());
    }

    protected void onFillParentInfo_Pssvrdomain(PSRegistryRepo pSRegistryRepo, PSSvrDomain pSSvrDomain) throws Exception {
        pSRegistryRepo.setPSSvrDomainId(pSSvrDomain.getPSSvrDomainId());
        pSRegistryRepo.setPSSvrDomainName(pSSvrDomain.getPSSvrDomainName());
    }

    protected void onFillEntityFullInfo(PSRegistryRepo pSRegistryRepo, boolean bl) throws Exception {
        if (bl && pSRegistryRepo.getValidFlag() == null) {
            pSRegistryRepo.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo(pSRegistryRepo, bl);
        this.onFillEntityFullInfo_PSDevCenter(pSRegistryRepo, bl);
        this.onFillEntityFullInfo_Psregistryserver(pSRegistryRepo, bl);
        this.onFillEntityFullInfo_Pssvrdomain(pSRegistryRepo, bl);
    }

    protected void onFillEntityFullInfo_PSDevCenter(PSRegistryRepo pSRegistryRepo, boolean bl) throws Exception {
        if (pSRegistryRepo.isPSDevCenterIdDirty()) {
            if (pSRegistryRepo.getPSDevCenterId() != null) {
                if (pSRegistryRepo.getPSDevCenterId() == null || pSRegistryRepo.getPSDevCenterName() == null) {
                    PSDevCenter pSDevCenter = pSRegistryRepo.getPSDevCenter();
                    pSRegistryRepo.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
                }
            } else {
                pSRegistryRepo.setPSDevCenterName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_Psregistryserver(PSRegistryRepo pSRegistryRepo, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_Pssvrdomain(PSRegistryRepo pSRegistryRepo, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSRegistryRepo pSRegistryRepo, boolean bl) throws Exception {
        super.onWriteBackParent(pSRegistryRepo, bl);
    }

    public ArrayList<PSRegistryRepo> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, "", -1);
    }

    public ArrayList<PSRegistryRepo> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, string, -1);
    }

    public ArrayList<PSRegistryRepo> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string, int n) throws Exception {
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

    public ArrayList<PSRegistryRepo> selectByPsregistryserver(PSRegistryServerBase pSRegistryServerBase) throws Exception {
        return this.selectByPsregistryserver(pSRegistryServerBase, "", -1);
    }

    public ArrayList<PSRegistryRepo> selectByPsregistryserver(PSRegistryServerBase pSRegistryServerBase, String string) throws Exception {
        return this.selectByPsregistryserver(pSRegistryServerBase, string, -1);
    }

    public ArrayList<PSRegistryRepo> selectByPsregistryserver(PSRegistryServerBase pSRegistryServerBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSREGISTRYSERVERID", (Object)pSRegistryServerBase.getPSRegistryServerId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPsregistryserverCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPsregistryserverCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSRegistryRepo> selectByPssvrdomain(PSSvrDomainBase pSSvrDomainBase) throws Exception {
        return this.selectByPssvrdomain(pSSvrDomainBase, "", -1);
    }

    public ArrayList<PSRegistryRepo> selectByPssvrdomain(PSSvrDomainBase pSSvrDomainBase, String string) throws Exception {
        return this.selectByPssvrdomain(pSSvrDomainBase, string, -1);
    }

    public ArrayList<PSRegistryRepo> selectByPssvrdomain(PSSvrDomainBase pSSvrDomainBase, String string, int n) throws Exception {
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

    public void testRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    public void resetPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSRegistryRepo> arrayList = this.selectByPSDevCenter(pSDevCenter);
        for (PSRegistryRepo pSRegistryRepo : arrayList) {
            PSRegistryRepo pSRegistryRepo2 = (PSRegistryRepo)this.getDEModel().createEntity();
            pSRegistryRepo2.setPSRegistryRepoId(pSRegistryRepo.getPSRegistryRepoId());
            pSRegistryRepo2.setPSDevCenterId(null);
            this.update(pSRegistryRepo2);
        }
    }

    public void removeByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        final PSDevCenter pSDevCenter2 = pSDevCenter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSRegistryRepoServiceBase.this.onBeforeRemoveByPSDevCenter(pSDevCenter2);
                PSRegistryRepoServiceBase.this.internalRemoveByPSDevCenter(pSDevCenter2);
                PSRegistryRepoServiceBase.this.onAfterRemoveByPSDevCenter(pSDevCenter2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void internalRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSRegistryRepo> arrayList = this.selectByPSDevCenter(pSDevCenter);
        this.onBeforeRemoveByPSDevCenter(pSDevCenter, arrayList);
        for (PSRegistryRepo pSRegistryRepo : arrayList) {
            this.remove(pSRegistryRepo);
        }
        this.onAfterRemoveByPSDevCenter(pSDevCenter, arrayList);
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSRegistryRepo> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSRegistryRepo> arrayList) throws Exception {
    }

    public void testRemoveByPsregistryserver(PSRegistryServer pSRegistryServer) throws Exception {
        ArrayList<PSRegistryRepo> arrayList = this.selectByPsregistryserver(pSRegistryServer, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSREGISTRYSERVER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSRegistryServer);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSREGISTRYREPO_PSREGISTRYSERVER_PSREGISTRYSERVERID", "", iDataEntityModel.getName(), "PSREGISTRYREPO", iDataEntityModel.getDataInfo(pSRegistryServer), arrayList.get(0)));
        }
    }

    public void resetPsregistryserver(PSRegistryServer pSRegistryServer) throws Exception {
        ArrayList<PSRegistryRepo> arrayList = this.selectByPsregistryserver(pSRegistryServer);
        for (PSRegistryRepo pSRegistryRepo : arrayList) {
            PSRegistryRepo pSRegistryRepo2 = (PSRegistryRepo)this.getDEModel().createEntity();
            pSRegistryRepo2.setPSRegistryRepoId(pSRegistryRepo.getPSRegistryRepoId());
            pSRegistryRepo2.setPSRegistryServerId(null);
            this.update(pSRegistryRepo2);
        }
    }

    public void removeByPsregistryserver(PSRegistryServer pSRegistryServer) throws Exception {
        final PSRegistryServer pSRegistryServer2 = pSRegistryServer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSRegistryRepoServiceBase.this.onBeforeRemoveByPsregistryserver(pSRegistryServer2);
                PSRegistryRepoServiceBase.this.internalRemoveByPsregistryserver(pSRegistryServer2);
                PSRegistryRepoServiceBase.this.onAfterRemoveByPsregistryserver(pSRegistryServer2);
            }
        });
    }

    protected void onBeforeRemoveByPsregistryserver(PSRegistryServer pSRegistryServer) throws Exception {
    }

    protected void internalRemoveByPsregistryserver(PSRegistryServer pSRegistryServer) throws Exception {
        ArrayList<PSRegistryRepo> arrayList = this.selectByPsregistryserver(pSRegistryServer);
        this.onBeforeRemoveByPsregistryserver(pSRegistryServer, arrayList);
        for (PSRegistryRepo pSRegistryRepo : arrayList) {
            this.remove(pSRegistryRepo);
        }
        this.onAfterRemoveByPsregistryserver(pSRegistryServer, arrayList);
    }

    protected void onAfterRemoveByPsregistryserver(PSRegistryServer pSRegistryServer) throws Exception {
    }

    protected void onBeforeRemoveByPsregistryserver(PSRegistryServer pSRegistryServer, ArrayList<PSRegistryRepo> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPsregistryserver(PSRegistryServer pSRegistryServer, ArrayList<PSRegistryRepo> arrayList) throws Exception {
    }

    public void testRemoveByPssvrdomain(PSSvrDomain pSSvrDomain) throws Exception {
        ArrayList<PSRegistryRepo> arrayList = this.selectByPssvrdomain(pSSvrDomain, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSVRDOMAIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSvrDomain);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSREGISTRYREPO_PSSVRDOMAIN_PSSVRDOMAINID", "", iDataEntityModel.getName(), "PSREGISTRYREPO", iDataEntityModel.getDataInfo(pSSvrDomain), arrayList.get(0)));
        }
    }

    public void resetPssvrdomain(PSSvrDomain pSSvrDomain) throws Exception {
        ArrayList<PSRegistryRepo> arrayList = this.selectByPssvrdomain(pSSvrDomain);
        for (PSRegistryRepo pSRegistryRepo : arrayList) {
            PSRegistryRepo pSRegistryRepo2 = (PSRegistryRepo)this.getDEModel().createEntity();
            pSRegistryRepo2.setPSRegistryRepoId(pSRegistryRepo.getPSRegistryRepoId());
            pSRegistryRepo2.setPSSvrDomainId(null);
            this.update(pSRegistryRepo2);
        }
    }

    public void removeByPssvrdomain(PSSvrDomain pSSvrDomain) throws Exception {
        final PSSvrDomain pSSvrDomain2 = pSSvrDomain;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSRegistryRepoServiceBase.this.onBeforeRemoveByPssvrdomain(pSSvrDomain2);
                PSRegistryRepoServiceBase.this.internalRemoveByPssvrdomain(pSSvrDomain2);
                PSRegistryRepoServiceBase.this.onAfterRemoveByPssvrdomain(pSSvrDomain2);
            }
        });
    }

    protected void onBeforeRemoveByPssvrdomain(PSSvrDomain pSSvrDomain) throws Exception {
    }

    protected void internalRemoveByPssvrdomain(PSSvrDomain pSSvrDomain) throws Exception {
        ArrayList<PSRegistryRepo> arrayList = this.selectByPssvrdomain(pSSvrDomain);
        this.onBeforeRemoveByPssvrdomain(pSSvrDomain, arrayList);
        for (PSRegistryRepo pSRegistryRepo : arrayList) {
            this.remove(pSRegistryRepo);
        }
        this.onAfterRemoveByPssvrdomain(pSSvrDomain, arrayList);
    }

    protected void onAfterRemoveByPssvrdomain(PSSvrDomain pSSvrDomain) throws Exception {
    }

    protected void onBeforeRemoveByPssvrdomain(PSSvrDomain pSSvrDomain, ArrayList<PSRegistryRepo> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPssvrdomain(PSSvrDomain pSSvrDomain, ArrayList<PSRegistryRepo> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSRegistryRepo pSRegistryRepo) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDCRegistryRepoService)ServiceGlobal.getService(PSDCRegistryRepoService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCRegistryRepoServiceBase)pSCoreSysServiceBase).testRemoveByPSRegistryRepo(pSRegistryRepo);
        pSCoreSysServiceBase = (PSDeployCenterService)ServiceGlobal.getService(PSDeployCenterService.class, (SessionFactory)this.getSessionFactory());
        ((PSDeployCenterServiceBase)pSCoreSysServiceBase).testRemoveByPSRegistryRepo(pSRegistryRepo);
        pSCoreSysServiceBase = (PSRegistryItemService)ServiceGlobal.getService(PSRegistryItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSRegistryItemServiceBase)pSCoreSysServiceBase).testRemoveByPsregistryrepo(pSRegistryRepo);
        pSCoreSysServiceBase = (PSSaaSSysVerService)ServiceGlobal.getService(PSSaaSSysVerService.class, (SessionFactory)this.getSessionFactory());
        ((PSSaaSSysVerServiceBase)pSCoreSysServiceBase).testRemoveByPSRegistryRepo(pSRegistryRepo);
        super.onBeforeRemove(pSRegistryRepo);
    }

    protected void replaceParentInfo(PSRegistryRepo pSRegistryRepo, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSRegistryRepo, cloneSession);
        if (pSRegistryRepo.getPSDevCenterId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTER", (Object)pSRegistryRepo.getPSDevCenterId())) != null) {
            this.onFillParentInfo_PSDevCenter(pSRegistryRepo, (PSDevCenter)iEntity);
        }
        if (pSRegistryRepo.getPSRegistryServerId() != null && (iEntity = cloneSession.getEntity("PSREGISTRYSERVER", (Object)pSRegistryRepo.getPSRegistryServerId())) != null) {
            this.onFillParentInfo_Psregistryserver(pSRegistryRepo, (PSRegistryServer)iEntity);
        }
        if (pSRegistryRepo.getPSSvrDomainId() != null && (iEntity = cloneSession.getEntity("PSSVRDOMAIN", (Object)pSRegistryRepo.getPSSvrDomainId())) != null) {
            this.onFillParentInfo_Pssvrdomain(pSRegistryRepo, (PSSvrDomain)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSRegistryRepo pSRegistryRepo, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSRegistryRepo, bl);
    }

    protected void onCheckEntity(boolean bl, PSRegistryRepo pSRegistryRepo, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_ConnStr(bl, pSRegistryRepo, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LocalRes(bl, pSRegistryRepo, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogicName(bl, pSRegistryRepo, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSRegistryRepo, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Param(bl, pSRegistryRepo, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Param2(bl, pSRegistryRepo, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Param3(bl, pSRegistryRepo, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Param4(bl, pSRegistryRepo, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Param5(bl, pSRegistryRepo, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Param6(bl, pSRegistryRepo, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Param7(bl, pSRegistryRepo, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Param8(bl, pSRegistryRepo, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterId(bl, pSRegistryRepo, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterName(bl, pSRegistryRepo, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSObjId(bl, pSRegistryRepo, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSObjName(bl, pSRegistryRepo, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSObjType(bl, pSRegistryRepo, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSRegistryRepoId(bl, pSRegistryRepo, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSRegistryRepoName(bl, pSRegistryRepo, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSRegistryServerId(bl, pSRegistryRepo, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSvrDomainId(bl, pSRegistryRepo, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ReadOnlyMode(bl, pSRegistryRepo, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefInfo(bl, pSRegistryRepo, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RegistryPasswd(bl, pSRegistryRepo, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RegistryType(bl, pSRegistryRepo, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RegistryUserName(bl, pSRegistryRepo, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RepoState(bl, pSRegistryRepo, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ROPasswd(bl, pSRegistryRepo, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ROUserName(bl, pSRegistryRepo, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSRegistryRepo, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSRegistryRepo, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_ConnStr(boolean bl, PSRegistryRepo pSRegistryRepo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSRegistryRepo.isConnStrDirty() : !pSRegistryRepo.isConnStrDirty()) {
            return null;
        }
        String string = pSRegistryRepo.getConnStr();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ConnStr_Default(pSRegistryRepo, bl2, bl3);
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

    protected EntityFieldError onCheckField_LocalRes(boolean bl, PSRegistryRepo pSRegistryRepo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSRegistryRepo.isLocalResDirty() : !pSRegistryRepo.isLocalResDirty()) {
            return null;
        }
        Integer n = pSRegistryRepo.getLocalRes();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LocalRes_Default(pSRegistryRepo, bl2, bl3);
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

    protected EntityFieldError onCheckField_LogicName(boolean bl, PSRegistryRepo pSRegistryRepo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSRegistryRepo.isLogicNameDirty() && !bl2 : !pSRegistryRepo.isLogicNameDirty()) {
            return null;
        }
        String string = pSRegistryRepo.getLogicName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOGICNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogicName_Default(pSRegistryRepo, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOGICNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSRegistryRepo pSRegistryRepo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSRegistryRepo.isMemoDirty() : !pSRegistryRepo.isMemoDirty()) {
            return null;
        }
        String string = pSRegistryRepo.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSRegistryRepo, bl2, bl3);
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

    protected EntityFieldError onCheckField_Param(boolean bl, PSRegistryRepo pSRegistryRepo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSRegistryRepo.isParamDirty() : !pSRegistryRepo.isParamDirty()) {
            return null;
        }
        String string = pSRegistryRepo.getParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Param_Default(pSRegistryRepo, bl2, bl3);
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

    protected EntityFieldError onCheckField_Param2(boolean bl, PSRegistryRepo pSRegistryRepo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSRegistryRepo.isParam2Dirty() : !pSRegistryRepo.isParam2Dirty()) {
            return null;
        }
        String string = pSRegistryRepo.getParam2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Param2_Default(pSRegistryRepo, bl2, bl3);
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

    protected EntityFieldError onCheckField_Param3(boolean bl, PSRegistryRepo pSRegistryRepo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSRegistryRepo.isParam3Dirty() : !pSRegistryRepo.isParam3Dirty()) {
            return null;
        }
        String string = pSRegistryRepo.getParam3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Param3_Default(pSRegistryRepo, bl2, bl3);
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

    protected EntityFieldError onCheckField_Param4(boolean bl, PSRegistryRepo pSRegistryRepo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSRegistryRepo.isParam4Dirty() : !pSRegistryRepo.isParam4Dirty()) {
            return null;
        }
        String string = pSRegistryRepo.getParam4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Param4_Default(pSRegistryRepo, bl2, bl3);
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

    protected EntityFieldError onCheckField_Param5(boolean bl, PSRegistryRepo pSRegistryRepo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSRegistryRepo.isParam5Dirty() : !pSRegistryRepo.isParam5Dirty()) {
            return null;
        }
        Integer n = pSRegistryRepo.getParam5();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Param5_Default(pSRegistryRepo, bl2, bl3);
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

    protected EntityFieldError onCheckField_Param6(boolean bl, PSRegistryRepo pSRegistryRepo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSRegistryRepo.isParam6Dirty() : !pSRegistryRepo.isParam6Dirty()) {
            return null;
        }
        Integer n = pSRegistryRepo.getParam6();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Param6_Default(pSRegistryRepo, bl2, bl3);
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

    protected EntityFieldError onCheckField_Param7(boolean bl, PSRegistryRepo pSRegistryRepo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSRegistryRepo.isParam7Dirty() : !pSRegistryRepo.isParam7Dirty()) {
            return null;
        }
        Integer n = pSRegistryRepo.getParam7();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Param7_Default(pSRegistryRepo, bl2, bl3);
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

    protected EntityFieldError onCheckField_Param8(boolean bl, PSRegistryRepo pSRegistryRepo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSRegistryRepo.isParam8Dirty() : !pSRegistryRepo.isParam8Dirty()) {
            return null;
        }
        Integer n = pSRegistryRepo.getParam8();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Param8_Default(pSRegistryRepo, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevCenterId(boolean bl, PSRegistryRepo pSRegistryRepo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSRegistryRepo.isPSDevCenterIdDirty() : !pSRegistryRepo.isPSDevCenterIdDirty()) {
            return null;
        }
        String string = pSRegistryRepo.getPSDevCenterId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterId_Default(pSRegistryRepo, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevCenterName(boolean bl, PSRegistryRepo pSRegistryRepo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSRegistryRepo.isPSDevCenterNameDirty() : !pSRegistryRepo.isPSDevCenterNameDirty()) {
            return null;
        }
        String string = pSRegistryRepo.getPSDevCenterName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterName_Default(pSRegistryRepo, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSObjId(boolean bl, PSRegistryRepo pSRegistryRepo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSRegistryRepo.isPSObjIdDirty() : !pSRegistryRepo.isPSObjIdDirty()) {
            return null;
        }
        String string = pSRegistryRepo.getPSObjId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSObjId_Default(pSRegistryRepo, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSOBJID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSObjName(boolean bl, PSRegistryRepo pSRegistryRepo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSRegistryRepo.isPSObjNameDirty() : !pSRegistryRepo.isPSObjNameDirty()) {
            return null;
        }
        String string = pSRegistryRepo.getPSObjName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSObjName_Default(pSRegistryRepo, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSOBJNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSObjType(boolean bl, PSRegistryRepo pSRegistryRepo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSRegistryRepo.isPSObjTypeDirty() : !pSRegistryRepo.isPSObjTypeDirty()) {
            return null;
        }
        String string = pSRegistryRepo.getPSObjType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSObjType_Default(pSRegistryRepo, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSOBJTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSRegistryRepoId(boolean bl, PSRegistryRepo pSRegistryRepo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSRegistryRepo.isPSRegistryRepoIdDirty() && !bl2 : !pSRegistryRepo.isPSRegistryRepoIdDirty()) {
            return null;
        }
        String string = pSRegistryRepo.getPSRegistryRepoId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSREGISTRYREPOID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSRegistryRepoId_Default(pSRegistryRepo, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSREGISTRYREPOID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSRegistryRepoName(boolean bl, PSRegistryRepo pSRegistryRepo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSRegistryRepo.isPSRegistryRepoNameDirty() && !bl2 : !pSRegistryRepo.isPSRegistryRepoNameDirty()) {
            return null;
        }
        String string = pSRegistryRepo.getPSRegistryRepoName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSREGISTRYREPONAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSRegistryRepoName_Default(pSRegistryRepo, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSREGISTRYREPONAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSRegistryServerId(boolean bl, PSRegistryRepo pSRegistryRepo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSRegistryRepo.isPSRegistryServerIdDirty() : !pSRegistryRepo.isPSRegistryServerIdDirty()) {
            return null;
        }
        String string = pSRegistryRepo.getPSRegistryServerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSRegistryServerId_Default(pSRegistryRepo, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSREGISTRYSERVERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSvrDomainId(boolean bl, PSRegistryRepo pSRegistryRepo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSRegistryRepo.isPSSvrDomainIdDirty() : !pSRegistryRepo.isPSSvrDomainIdDirty()) {
            return null;
        }
        String string = pSRegistryRepo.getPSSvrDomainId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSvrDomainId_Default(pSRegistryRepo, bl2, bl3);
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

    protected EntityFieldError onCheckField_ReadOnlyMode(boolean bl, PSRegistryRepo pSRegistryRepo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSRegistryRepo.isReadOnlyModeDirty() : !pSRegistryRepo.isReadOnlyModeDirty()) {
            return null;
        }
        Integer n = pSRegistryRepo.getReadOnlyMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ReadOnlyMode_Default(pSRegistryRepo, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("READONLYMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefInfo(boolean bl, PSRegistryRepo pSRegistryRepo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSRegistryRepo.isRefInfoDirty() : !pSRegistryRepo.isRefInfoDirty()) {
            return null;
        }
        String string = pSRegistryRepo.getRefInfo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefInfo_Default(pSRegistryRepo, bl2, bl3);
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

    protected EntityFieldError onCheckField_RegistryPasswd(boolean bl, PSRegistryRepo pSRegistryRepo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSRegistryRepo.isRegistryPasswdDirty() : !pSRegistryRepo.isRegistryPasswdDirty()) {
            return null;
        }
        String string = pSRegistryRepo.getRegistryPasswd();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RegistryPasswd_Default(pSRegistryRepo, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REGISTRYPASSWD");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RegistryType(boolean bl, PSRegistryRepo pSRegistryRepo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSRegistryRepo.isRegistryTypeDirty() && !bl2 : !pSRegistryRepo.isRegistryTypeDirty()) {
            return null;
        }
        String string = pSRegistryRepo.getRegistryType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REGISTRYTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_RegistryType_Default(pSRegistryRepo, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REGISTRYTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RegistryUserName(boolean bl, PSRegistryRepo pSRegistryRepo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSRegistryRepo.isRegistryUserNameDirty() : !pSRegistryRepo.isRegistryUserNameDirty()) {
            return null;
        }
        String string = pSRegistryRepo.getRegistryUserName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RegistryUserName_Default(pSRegistryRepo, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REGISTRYUSERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RepoState(boolean bl, PSRegistryRepo pSRegistryRepo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSRegistryRepo.isRepoStateDirty() && !bl2 : !pSRegistryRepo.isRepoStateDirty()) {
            return null;
        }
        Integer n = pSRegistryRepo.getRepoState();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REPOSTATE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_RepoState_Default(pSRegistryRepo, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REPOSTATE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ROPasswd(boolean bl, PSRegistryRepo pSRegistryRepo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSRegistryRepo.isROPasswdDirty() : !pSRegistryRepo.isROPasswdDirty()) {
            return null;
        }
        String string = pSRegistryRepo.getROPasswd();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ROPasswd_Default(pSRegistryRepo, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ROPASSWD");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ROUserName(boolean bl, PSRegistryRepo pSRegistryRepo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSRegistryRepo.isROUserNameDirty() : !pSRegistryRepo.isROUserNameDirty()) {
            return null;
        }
        String string = pSRegistryRepo.getROUserName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ROUserName_Default(pSRegistryRepo, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ROUSERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSRegistryRepo pSRegistryRepo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSRegistryRepo.isValidFlagDirty() && !bl2 : !pSRegistryRepo.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSRegistryRepo.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSRegistryRepo, bl2, bl3);
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

    protected void onSyncEntity(PSRegistryRepo pSRegistryRepo, boolean bl) throws Exception {
        super.onSyncEntity(pSRegistryRepo, bl);
    }

    protected void onSyncIndexEntities(PSRegistryRepo pSRegistryRepo, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSRegistryRepo, bl);
    }

    public Object getDataContextValue(PSRegistryRepo pSRegistryRepo, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSRegistryRepo, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSRegistryRepo pSRegistryRepo, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSRegistryRepo, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CONNSTR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ConnStr_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOCALRES", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LocalRes_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogicName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSOBJID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSObjId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSOBJNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSObjName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSOBJTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSObjType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSREGISTRYREPOID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSRegistryRepoId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSREGISTRYREPONAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSRegistryRepoName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSREGISTRYSERVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSRegistryServerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSREGISTRYSERVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSRegistryServerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSVRDOMAINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSvrDomainId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSVRDOMAINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSvrDomainName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"READONLYMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ReadOnlyMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFINFO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefInfo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REGISTRYPASSWD", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RegistryPasswd_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REGISTRYTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RegistryType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REGISTRYUSERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RegistryUserName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REPOSTATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RepoState_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ROPASSWD", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ROPasswd_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ROUSERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ROUserName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_ConnStr_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONNSTR", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
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

    protected String onTestValueRule_LocalRes_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_LogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LOGICNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_PSObjId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSOBJID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSObjName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSOBJNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSObjType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSOBJTYPE", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSRegistryRepoId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSREGISTRYREPOID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSRegistryRepoName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSREGISTRYREPONAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSRegistryServerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSREGISTRYSERVERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSRegistryServerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSREGISTRYSERVERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_ReadOnlyMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_RegistryPasswd_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REGISTRYPASSWD", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RegistryType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REGISTRYTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RegistryUserName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REGISTRYUSERNAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RepoState_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ROPasswd_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ROPASSWD", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ROUserName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ROUSERNAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
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

    protected boolean onMergeChild(String string, String string2, PSRegistryRepo pSRegistryRepo) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSRegistryRepo)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSRegistryRepo pSRegistryRepo) throws Exception {
        super.onUpdateParent(pSRegistryRepo);
    }

    @Override
    protected void exportCurXmlModel(PSRegistryRepo pSRegistryRepo, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSREGISTRYREPO");
        if (!bl) {
            pSRegistryRepo.setCreateDate(null);
            pSRegistryRepo.setCreateMan(null);
            pSRegistryRepo.setPSRegistryRepoId(null);
            pSRegistryRepo.setPSRegistryServerName(null);
            pSRegistryRepo.setPSSvrDomainName(null);
            pSRegistryRepo.setRefInfo(null);
            pSRegistryRepo.setUpdateDate(null);
            pSRegistryRepo.setUpdateMan(null);
            super.exportCurXmlModel(pSRegistryRepo, xmlNode, bl);
        }
    }
}

