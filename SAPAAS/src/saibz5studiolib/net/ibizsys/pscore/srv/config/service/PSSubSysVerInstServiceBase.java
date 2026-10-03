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
package net.ibizsys.pscore.srv.config.service;

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
import net.ibizsys.pscore.srv.config.dao.PSSubSysVerInstDAO;
import net.ibizsys.pscore.srv.config.demodel.PSSubSysVerInstDEModel;
import net.ibizsys.pscore.srv.config.entity.PSSubSysVer;
import net.ibizsys.pscore.srv.config.entity.PSSubSysVerBase;
import net.ibizsys.pscore.srv.config.entity.PSSubSysVerInst;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSvrDomain;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSvrDomainBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSysModelInst;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSysModelInstBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSubSysVerInstServiceBase
extends PSCoreSysServiceBase<PSSubSysVerInst> {
    private static final Log log = LogFactory.getLog(PSSubSysVerInstServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSubSysVerInstDEModel pSSubSysVerInstDEModel;
    private PSSubSysVerInstDAO pSSubSysVerInstDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSSubSysVerInstService";
    }

    public PSSubSysVerInstDEModel getPSSubSysVerInstDEModel() {
        if (this.pSSubSysVerInstDEModel == null) {
            try {
                this.pSSubSysVerInstDEModel = (PSSubSysVerInstDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSSubSysVerInstDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSubSysVerInstDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSubSysVerInstDEModel();
    }

    public PSSubSysVerInstDAO getPSSubSysVerInstDAO() {
        if (this.pSSubSysVerInstDAO == null) {
            try {
                this.pSSubSysVerInstDAO = (PSSubSysVerInstDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSSubSysVerInstDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSubSysVerInstDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSubSysVerInstDAO();
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

    protected void onFillParentInfo(PSSubSysVerInst pSSubSysVerInst, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSUBSYSVERINST_PSSUBSYSVER_PSSUBSYSVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSubSysVerService", (SessionFactory)this.getSessionFactory());
            PSSubSysVer pSSubSysVer = (PSSubSysVer)iService.getDEModel().createEntity();
            pSSubSysVer.set("PSSUBSYSVERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSubSysVer);
            } else {
                iService.get(pSSubSysVer);
            }
            this.onFillParentInfo_PSSubSysVer(pSSubSysVerInst, pSSubSysVer);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSUBSYSVERINST_PSSVRDOMAIN_PSSVRDOMAINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSSvrDomainService", (SessionFactory)this.getSessionFactory());
            PSSvrDomain pSSvrDomain = (PSSvrDomain)iService.getDEModel().createEntity();
            pSSvrDomain.set("PSSVRDOMAINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSvrDomain);
            } else {
                iService.get(pSSvrDomain);
            }
            this.onFillParentInfo_Pssvrdomain(pSSubSysVerInst, pSSvrDomain);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSUBSYSVERINST_PSSYSMODELINST_PSSYSMODELINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSSysModelInstService", (SessionFactory)this.getSessionFactory());
            PSSysModelInst pSSysModelInst = (PSSysModelInst)iService.getDEModel().createEntity();
            pSSysModelInst.set("PSSYSMODELINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysModelInst);
            } else {
                iService.get(pSSysModelInst);
            }
            this.onFillParentInfo_Pssysmodelinst(pSSubSysVerInst, pSSysModelInst);
            return;
        }
        super.onFillParentInfo(pSSubSysVerInst, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSSubSysVer(PSSubSysVerInst pSSubSysVerInst, PSSubSysVer pSSubSysVer) throws Exception {
        pSSubSysVerInst.setPSSubSysId(pSSubSysVer.getPSSubSysId());
        pSSubSysVerInst.setPSSubSysVerId(pSSubSysVer.getPSSubSysVerId());
        pSSubSysVerInst.setPSSubSysVerName(pSSubSysVer.getPSSubSysVerName());
    }

    protected void onFillParentInfo_Pssvrdomain(PSSubSysVerInst pSSubSysVerInst, PSSvrDomain pSSvrDomain) throws Exception {
        pSSubSysVerInst.setPSSvrDomainId(pSSvrDomain.getPSSvrDomainId());
        pSSubSysVerInst.setPSSvrDomainName(pSSvrDomain.getPSSvrDomainName());
    }

    protected void onFillParentInfo_Pssysmodelinst(PSSubSysVerInst pSSubSysVerInst, PSSysModelInst pSSysModelInst) throws Exception {
        pSSubSysVerInst.setPSSysModelInstId(pSSysModelInst.getPSSysModelInstId());
        pSSubSysVerInst.setPSSysModelInstName(pSSysModelInst.getPSSysModelInstName());
    }

    protected void onFillEntityFullInfo(PSSubSysVerInst pSSubSysVerInst, boolean bl) throws Exception {
        if (bl && pSSubSysVerInst.getValidFlag() == null) {
            pSSubSysVerInst.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo(pSSubSysVerInst, bl);
        this.onFillEntityFullInfo_PSSubSysVer(pSSubSysVerInst, bl);
        this.onFillEntityFullInfo_Pssvrdomain(pSSubSysVerInst, bl);
        this.onFillEntityFullInfo_Pssysmodelinst(pSSubSysVerInst, bl);
    }

    protected void onFillEntityFullInfo_PSSubSysVer(PSSubSysVerInst pSSubSysVerInst, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_Pssvrdomain(PSSubSysVerInst pSSubSysVerInst, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_Pssysmodelinst(PSSubSysVerInst pSSubSysVerInst, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSubSysVerInst pSSubSysVerInst, boolean bl) throws Exception {
        super.onWriteBackParent(pSSubSysVerInst, bl);
    }

    public ArrayList<PSSubSysVerInst> selectByPSSubSysVer(PSSubSysVerBase pSSubSysVerBase) throws Exception {
        return this.selectByPSSubSysVer(pSSubSysVerBase, "", -1);
    }

    public ArrayList<PSSubSysVerInst> selectByPSSubSysVer(PSSubSysVerBase pSSubSysVerBase, String string) throws Exception {
        return this.selectByPSSubSysVer(pSSubSysVerBase, string, -1);
    }

    public ArrayList<PSSubSysVerInst> selectByPSSubSysVer(PSSubSysVerBase pSSubSysVerBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSUBSYSVERID", (Object)pSSubSysVerBase.getPSSubSysVerId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSubSysVerCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSubSysVerCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSubSysVerInst> selectByPssvrdomain(PSSvrDomainBase pSSvrDomainBase) throws Exception {
        return this.selectByPssvrdomain(pSSvrDomainBase, "", -1);
    }

    public ArrayList<PSSubSysVerInst> selectByPssvrdomain(PSSvrDomainBase pSSvrDomainBase, String string) throws Exception {
        return this.selectByPssvrdomain(pSSvrDomainBase, string, -1);
    }

    public ArrayList<PSSubSysVerInst> selectByPssvrdomain(PSSvrDomainBase pSSvrDomainBase, String string, int n) throws Exception {
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

    public ArrayList<PSSubSysVerInst> selectByPssysmodelinst(PSSysModelInstBase pSSysModelInstBase) throws Exception {
        return this.selectByPssysmodelinst(pSSysModelInstBase, "", -1);
    }

    public ArrayList<PSSubSysVerInst> selectByPssysmodelinst(PSSysModelInstBase pSSysModelInstBase, String string) throws Exception {
        return this.selectByPssysmodelinst(pSSysModelInstBase, string, -1);
    }

    public ArrayList<PSSubSysVerInst> selectByPssysmodelinst(PSSysModelInstBase pSSysModelInstBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSMODELINSTID", (Object)pSSysModelInstBase.getPSSysModelInstId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPssysmodelinstCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPssysmodelinstCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSSubSysVer(PSSubSysVer pSSubSysVer) throws Exception {
        ArrayList<PSSubSysVerInst> arrayList = this.selectByPSSubSysVer(pSSubSysVer, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSUBSYSVER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSubSysVer);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSUBSYSVERINST_PSSUBSYSVER_PSSUBSYSVERID", "", iDataEntityModel.getName(), "PSSUBSYSVERINST", iDataEntityModel.getDataInfo(pSSubSysVer), arrayList.get(0)));
        }
    }

    public void resetPSSubSysVer(PSSubSysVer pSSubSysVer) throws Exception {
        ArrayList<PSSubSysVerInst> arrayList = this.selectByPSSubSysVer(pSSubSysVer);
        for (PSSubSysVerInst pSSubSysVerInst : arrayList) {
            PSSubSysVerInst pSSubSysVerInst2 = (PSSubSysVerInst)this.getDEModel().createEntity();
            pSSubSysVerInst2.setPSSubSysVerInstId(pSSubSysVerInst.getPSSubSysVerInstId());
            pSSubSysVerInst2.setPSSubSysVerId(null);
            this.update(pSSubSysVerInst2);
        }
    }

    public void removeByPSSubSysVer(PSSubSysVer pSSubSysVer) throws Exception {
        final PSSubSysVer pSSubSysVer2 = pSSubSysVer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSubSysVerInstServiceBase.this.onBeforeRemoveByPSSubSysVer(pSSubSysVer2);
                PSSubSysVerInstServiceBase.this.internalRemoveByPSSubSysVer(pSSubSysVer2);
                PSSubSysVerInstServiceBase.this.onAfterRemoveByPSSubSysVer(pSSubSysVer2);
            }
        });
    }

    protected void onBeforeRemoveByPSSubSysVer(PSSubSysVer pSSubSysVer) throws Exception {
    }

    protected void internalRemoveByPSSubSysVer(PSSubSysVer pSSubSysVer) throws Exception {
        ArrayList<PSSubSysVerInst> arrayList = this.selectByPSSubSysVer(pSSubSysVer);
        this.onBeforeRemoveByPSSubSysVer(pSSubSysVer, arrayList);
        for (PSSubSysVerInst pSSubSysVerInst : arrayList) {
            this.remove(pSSubSysVerInst);
        }
        this.onAfterRemoveByPSSubSysVer(pSSubSysVer, arrayList);
    }

    protected void onAfterRemoveByPSSubSysVer(PSSubSysVer pSSubSysVer) throws Exception {
    }

    protected void onBeforeRemoveByPSSubSysVer(PSSubSysVer pSSubSysVer, ArrayList<PSSubSysVerInst> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSubSysVer(PSSubSysVer pSSubSysVer, ArrayList<PSSubSysVerInst> arrayList) throws Exception {
    }

    public void testRemoveByPssvrdomain(PSSvrDomain pSSvrDomain) throws Exception {
        ArrayList<PSSubSysVerInst> arrayList = this.selectByPssvrdomain(pSSvrDomain, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSVRDOMAIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSvrDomain);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSUBSYSVERINST_PSSVRDOMAIN_PSSVRDOMAINID", "", iDataEntityModel.getName(), "PSSUBSYSVERINST", iDataEntityModel.getDataInfo(pSSvrDomain), arrayList.get(0)));
        }
    }

    public void resetPssvrdomain(PSSvrDomain pSSvrDomain) throws Exception {
        ArrayList<PSSubSysVerInst> arrayList = this.selectByPssvrdomain(pSSvrDomain);
        for (PSSubSysVerInst pSSubSysVerInst : arrayList) {
            PSSubSysVerInst pSSubSysVerInst2 = (PSSubSysVerInst)this.getDEModel().createEntity();
            pSSubSysVerInst2.setPSSubSysVerInstId(pSSubSysVerInst.getPSSubSysVerInstId());
            pSSubSysVerInst2.setPSSvrDomainId(null);
            this.update(pSSubSysVerInst2);
        }
    }

    public void removeByPssvrdomain(PSSvrDomain pSSvrDomain) throws Exception {
        final PSSvrDomain pSSvrDomain2 = pSSvrDomain;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSubSysVerInstServiceBase.this.onBeforeRemoveByPssvrdomain(pSSvrDomain2);
                PSSubSysVerInstServiceBase.this.internalRemoveByPssvrdomain(pSSvrDomain2);
                PSSubSysVerInstServiceBase.this.onAfterRemoveByPssvrdomain(pSSvrDomain2);
            }
        });
    }

    protected void onBeforeRemoveByPssvrdomain(PSSvrDomain pSSvrDomain) throws Exception {
    }

    protected void internalRemoveByPssvrdomain(PSSvrDomain pSSvrDomain) throws Exception {
        ArrayList<PSSubSysVerInst> arrayList = this.selectByPssvrdomain(pSSvrDomain);
        this.onBeforeRemoveByPssvrdomain(pSSvrDomain, arrayList);
        for (PSSubSysVerInst pSSubSysVerInst : arrayList) {
            this.remove(pSSubSysVerInst);
        }
        this.onAfterRemoveByPssvrdomain(pSSvrDomain, arrayList);
    }

    protected void onAfterRemoveByPssvrdomain(PSSvrDomain pSSvrDomain) throws Exception {
    }

    protected void onBeforeRemoveByPssvrdomain(PSSvrDomain pSSvrDomain, ArrayList<PSSubSysVerInst> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPssvrdomain(PSSvrDomain pSSvrDomain, ArrayList<PSSubSysVerInst> arrayList) throws Exception {
    }

    public void testRemoveByPssysmodelinst(PSSysModelInst pSSysModelInst) throws Exception {
        ArrayList<PSSubSysVerInst> arrayList = this.selectByPssysmodelinst(pSSysModelInst, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSMODELINST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysModelInst);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSUBSYSVERINST_PSSYSMODELINST_PSSYSMODELINSTID", "", iDataEntityModel.getName(), "PSSUBSYSVERINST", iDataEntityModel.getDataInfo(pSSysModelInst), arrayList.get(0)));
        }
    }

    public void resetPssysmodelinst(PSSysModelInst pSSysModelInst) throws Exception {
        ArrayList<PSSubSysVerInst> arrayList = this.selectByPssysmodelinst(pSSysModelInst);
        for (PSSubSysVerInst pSSubSysVerInst : arrayList) {
            PSSubSysVerInst pSSubSysVerInst2 = (PSSubSysVerInst)this.getDEModel().createEntity();
            pSSubSysVerInst2.setPSSubSysVerInstId(pSSubSysVerInst.getPSSubSysVerInstId());
            pSSubSysVerInst2.setPSSysModelInstId(null);
            this.update(pSSubSysVerInst2);
        }
    }

    public void removeByPssysmodelinst(PSSysModelInst pSSysModelInst) throws Exception {
        final PSSysModelInst pSSysModelInst2 = pSSysModelInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSubSysVerInstServiceBase.this.onBeforeRemoveByPssysmodelinst(pSSysModelInst2);
                PSSubSysVerInstServiceBase.this.internalRemoveByPssysmodelinst(pSSysModelInst2);
                PSSubSysVerInstServiceBase.this.onAfterRemoveByPssysmodelinst(pSSysModelInst2);
            }
        });
    }

    protected void onBeforeRemoveByPssysmodelinst(PSSysModelInst pSSysModelInst) throws Exception {
    }

    protected void internalRemoveByPssysmodelinst(PSSysModelInst pSSysModelInst) throws Exception {
        ArrayList<PSSubSysVerInst> arrayList = this.selectByPssysmodelinst(pSSysModelInst);
        this.onBeforeRemoveByPssysmodelinst(pSSysModelInst, arrayList);
        for (PSSubSysVerInst pSSubSysVerInst : arrayList) {
            this.remove(pSSubSysVerInst);
        }
        this.onAfterRemoveByPssysmodelinst(pSSysModelInst, arrayList);
    }

    protected void onAfterRemoveByPssysmodelinst(PSSysModelInst pSSysModelInst) throws Exception {
    }

    protected void onBeforeRemoveByPssysmodelinst(PSSysModelInst pSSysModelInst, ArrayList<PSSubSysVerInst> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPssysmodelinst(PSSysModelInst pSSysModelInst, ArrayList<PSSubSysVerInst> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSubSysVerInst pSSubSysVerInst) throws Exception {
        super.onBeforeRemove(pSSubSysVerInst);
    }

    protected void replaceParentInfo(PSSubSysVerInst pSSubSysVerInst, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSubSysVerInst, cloneSession);
        if (pSSubSysVerInst.getPSSubSysVerId() != null && (iEntity = cloneSession.getEntity("PSSUBSYSVER", (Object)pSSubSysVerInst.getPSSubSysVerId())) != null) {
            this.onFillParentInfo_PSSubSysVer(pSSubSysVerInst, (PSSubSysVer)iEntity);
        }
        if (pSSubSysVerInst.getPSSvrDomainId() != null && (iEntity = cloneSession.getEntity("PSSVRDOMAIN", (Object)pSSubSysVerInst.getPSSvrDomainId())) != null) {
            this.onFillParentInfo_Pssvrdomain(pSSubSysVerInst, (PSSvrDomain)iEntity);
        }
        if (pSSubSysVerInst.getPSSysModelInstId() != null && (iEntity = cloneSession.getEntity("PSSYSMODELINST", (Object)pSSubSysVerInst.getPSSysModelInstId())) != null) {
            this.onFillParentInfo_Pssysmodelinst(pSSubSysVerInst, (PSSysModelInst)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSubSysVerInst pSSubSysVerInst, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSubSysVerInst, bl);
    }

    protected void onCheckEntity(boolean bl, PSSubSysVerInst pSSubSysVerInst, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bl, pSSubSysVerInst, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSubSysVerId(bl, pSSubSysVerInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSubSysVerInstId(bl, pSSubSysVerInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSubSysVerInstName(bl, pSSubSysVerInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSvrDomainId(bl, pSSubSysVerInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysModelInstId(bl, pSSubSysVerInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSSubSysVerInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSubSysVerInst, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSubSysVerInst pSSubSysVerInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysVerInst.isMemoDirty() : !pSSubSysVerInst.isMemoDirty()) {
            return null;
        }
        String string = pSSubSysVerInst.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSubSysVerInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSubSysVerId(boolean bl, PSSubSysVerInst pSSubSysVerInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysVerInst.isPSSubSysVerIdDirty() : !pSSubSysVerInst.isPSSubSysVerIdDirty()) {
            return null;
        }
        String string = pSSubSysVerInst.getPSSubSysVerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSubSysVerId_Default(pSSubSysVerInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSUBSYSVERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSubSysVerInstId(boolean bl, PSSubSysVerInst pSSubSysVerInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysVerInst.isPSSubSysVerInstIdDirty() && !bl2 : !pSSubSysVerInst.isPSSubSysVerInstIdDirty()) {
            return null;
        }
        String string = pSSubSysVerInst.getPSSubSysVerInstId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSUBSYSVERINSTID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSubSysVerInstId_Default(pSSubSysVerInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSUBSYSVERINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSubSysVerInstName(boolean bl, PSSubSysVerInst pSSubSysVerInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysVerInst.isPSSubSysVerInstNameDirty() && !bl2 : !pSSubSysVerInst.isPSSubSysVerInstNameDirty()) {
            return null;
        }
        String string = pSSubSysVerInst.getPSSubSysVerInstName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSUBSYSVERINSTNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSubSysVerInstName_Default(pSSubSysVerInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSUBSYSVERINSTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSvrDomainId(boolean bl, PSSubSysVerInst pSSubSysVerInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysVerInst.isPSSvrDomainIdDirty() && !bl2 : !pSSubSysVerInst.isPSSvrDomainIdDirty()) {
            return null;
        }
        String string = pSSubSysVerInst.getPSSvrDomainId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSVRDOMAINID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSvrDomainId_Default(pSSubSysVerInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysModelInstId(boolean bl, PSSubSysVerInst pSSubSysVerInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysVerInst.isPSSysModelInstIdDirty() && !bl2 : !pSSubSysVerInst.isPSSysModelInstIdDirty()) {
            return null;
        }
        String string = pSSubSysVerInst.getPSSysModelInstId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSMODELINSTID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysModelInstId_Default(pSSubSysVerInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSMODELINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSSubSysVerInst pSSubSysVerInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysVerInst.isValidFlagDirty() && !bl2 : !pSSubSysVerInst.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSSubSysVerInst.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSSubSysVerInst, bl2, bl3);
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

    protected void onSyncEntity(PSSubSysVerInst pSSubSysVerInst, boolean bl) throws Exception {
        super.onSyncEntity(pSSubSysVerInst, bl);
    }

    protected void onSyncIndexEntities(PSSubSysVerInst pSSubSysVerInst, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSubSysVerInst, bl);
    }

    public Object getDataContextValue(PSSubSysVerInst pSSubSysVerInst, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSubSysVerInst, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSSubSysVerInst pSSubSysVerInst, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSubSysVerInst, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSUBSYSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSubSysId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSUBSYSVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSubSysVerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSUBSYSVERINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSubSysVerInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSUBSYSVERINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSubSysVerInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSUBSYSVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSubSysVerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSVRDOMAINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSvrDomainId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSVRDOMAINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSvrDomainName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSMODELINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysModelInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSMODELINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysModelInstName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSSubSysId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSUBSYSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSubSysVerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSUBSYSVERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSubSysVerInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSUBSYSVERINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSubSysVerInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSUBSYSVERINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSubSysVerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSUBSYSVERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSysModelInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSMODELINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysModelInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSMODELINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected boolean onMergeChild(String string, String string2, PSSubSysVerInst pSSubSysVerInst) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSubSysVerInst)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSubSysVerInst pSSubSysVerInst) throws Exception {
        super.onUpdateParent(pSSubSysVerInst);
    }

    @Override
    protected void exportCurXmlModel(PSSubSysVerInst pSSubSysVerInst, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSUBSYSVERINST");
        if (!bl) {
            pSSubSysVerInst.setCreateDate(null);
            pSSubSysVerInst.setCreateMan(null);
            pSSubSysVerInst.setPSSubSysVerInstId(null);
            pSSubSysVerInst.setUpdateDate(null);
            pSSubSysVerInst.setUpdateMan(null);
            super.exportCurXmlModel(pSSubSysVerInst, xmlNode, bl);
        }
    }
}

