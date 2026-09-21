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
package net.ibizsys.pscore.srv.sysdeploy.service;

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
import net.ibizsys.pscore.srv.devcenter.entity.PSSaaSSysAPI;
import net.ibizsys.pscore.srv.devcenter.entity.PSSaaSSysAPIBase;
import net.ibizsys.pscore.srv.sysdeploy.dao.PSDepSysAPIDAO;
import net.ibizsys.pscore.srv.sysdeploy.demodel.PSDepSysAPIDEModel;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSysAPI;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSysVer;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSysVerBase;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysAPI;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysAPIBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDepSysAPIServiceBase
extends PSCoreSysServiceBase<PSDepSysAPI> {
    private static final Log log = LogFactory.getLog(PSDepSysAPIServiceBase.class);
    public static final String DATASET_CURVER = "CurVer";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDepSysAPIDEModel pSDepSysAPIDEModel;
    private PSDepSysAPIDAO pSDepSysAPIDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdeploy.service.PSDepSysAPIService";
    }

    public PSDepSysAPIDEModel getPSDepSysAPIDEModel() {
        if (this.pSDepSysAPIDEModel == null) {
            try {
                this.pSDepSysAPIDEModel = (PSDepSysAPIDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdeploy.demodel.PSDepSysAPIDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDepSysAPIDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDepSysAPIDEModel();
    }

    public PSDepSysAPIDAO getPSDepSysAPIDAO() {
        if (this.pSDepSysAPIDAO == null) {
            try {
                this.pSDepSysAPIDAO = (PSDepSysAPIDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdeploy.dao.PSDepSysAPIDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDepSysAPIDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDepSysAPIDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURVER, (boolean)true) == 0) {
            return this.fetchCurVer(iDEDataSetFetchContext);
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

    public DBFetchResult fetchCurVer(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURVER, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSDepSysAPI pSDepSysAPI, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPSYSAPI_PSDEPSYSVER_PSDEPSYSVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSysVerService", (SessionFactory)this.getSessionFactory());
            PSDepSysVer pSDepSysVer = (PSDepSysVer)iService.getDEModel().createEntity();
            pSDepSysVer.set("PSDEPSYSVERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDepSysVer);
            } else {
                iService.get((IEntity)pSDepSysVer);
            }
            this.onFillParentInfo_PSDepSysVer(pSDepSysAPI, pSDepSysVer);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPSYSAPI_PSDEVSLNSYSAPI_PSDEVSLNSYSAPIID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysAPIService", (SessionFactory)this.getSessionFactory());
            PSDevSlnSysAPI pSDevSlnSysAPI = (PSDevSlnSysAPI)iService.getDEModel().createEntity();
            pSDevSlnSysAPI.set("PSDEVSLNSYSAPIID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevSlnSysAPI);
            } else {
                iService.get((IEntity)pSDevSlnSysAPI);
            }
            this.onFillParentInfo_PSDevSlnSysAPI(pSDepSysAPI, pSDevSlnSysAPI);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPSYSAPI_PSSAASSYSAPI_PSSAASSYSAPIID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSSaaSSysAPIService", (SessionFactory)this.getSessionFactory());
            PSSaaSSysAPI pSSaaSSysAPI = (PSSaaSSysAPI)iService.getDEModel().createEntity();
            pSSaaSSysAPI.set("PSSAASSYSAPIID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSaaSSysAPI);
            } else {
                iService.get((IEntity)pSSaaSSysAPI);
            }
            this.onFillParentInfo_PSSaaSSysAPI(pSDepSysAPI, pSSaaSSysAPI);
            return;
        }
        super.onFillParentInfo((IEntity)pSDepSysAPI, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDepSysVer(PSDepSysAPI pSDepSysAPI, PSDepSysVer pSDepSysVer) throws Exception {
        pSDepSysAPI.setPSDepSysVerId(pSDepSysVer.getPSDepSysVerId());
        pSDepSysAPI.setPSDepSysVerName(pSDepSysVer.getPSDepSysVerName());
    }

    protected void onFillParentInfo_PSDevSlnSysAPI(PSDepSysAPI pSDepSysAPI, PSDevSlnSysAPI pSDevSlnSysAPI) throws Exception {
        pSDepSysAPI.setPSDevSlnSysAPIId(pSDevSlnSysAPI.getPSDevSlnSysAPIId());
        pSDepSysAPI.setPSDevSlnSysAPIName(pSDevSlnSysAPI.getPSDevSlnSysAPIName());
    }

    protected void onFillParentInfo_PSSaaSSysAPI(PSDepSysAPI pSDepSysAPI, PSSaaSSysAPI pSSaaSSysAPI) throws Exception {
        pSDepSysAPI.setPSSaaSSysAPIId(pSSaaSSysAPI.getPSSaaSSysAPIId());
        pSDepSysAPI.setPSSaaSSysAPIName(pSSaaSSysAPI.getPSSaaSSysAPIName());
    }

    protected void onFillEntityFullInfo(PSDepSysAPI pSDepSysAPI, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSDepSysAPI, bl);
        this.onFillEntityFullInfo_PSDepSysVer(pSDepSysAPI, bl);
        this.onFillEntityFullInfo_PSDevSlnSysAPI(pSDepSysAPI, bl);
        this.onFillEntityFullInfo_PSSaaSSysAPI(pSDepSysAPI, bl);
    }

    protected void onFillEntityFullInfo_PSDepSysVer(PSDepSysAPI pSDepSysAPI, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevSlnSysAPI(PSDepSysAPI pSDepSysAPI, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSaaSSysAPI(PSDepSysAPI pSDepSysAPI, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDepSysAPI pSDepSysAPI, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDepSysAPI, bl);
    }

    public ArrayList<PSDepSysAPI> selectByPSDepSysVer(PSDepSysVerBase pSDepSysVerBase) throws Exception {
        return this.selectByPSDepSysVer(pSDepSysVerBase, "", -1);
    }

    public ArrayList<PSDepSysAPI> selectByPSDepSysVer(PSDepSysVerBase pSDepSysVerBase, String string) throws Exception {
        return this.selectByPSDepSysVer(pSDepSysVerBase, string, -1);
    }

    public ArrayList<PSDepSysAPI> selectByPSDepSysVer(PSDepSysVerBase pSDepSysVerBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEPSYSVERID", (Object)pSDepSysVerBase.getPSDepSysVerId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDepSysVerCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDepSysVerCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDepSysAPI> selectByPSDevSlnSysAPI(PSDevSlnSysAPIBase pSDevSlnSysAPIBase) throws Exception {
        return this.selectByPSDevSlnSysAPI(pSDevSlnSysAPIBase, "", -1);
    }

    public ArrayList<PSDepSysAPI> selectByPSDevSlnSysAPI(PSDevSlnSysAPIBase pSDevSlnSysAPIBase, String string) throws Exception {
        return this.selectByPSDevSlnSysAPI(pSDevSlnSysAPIBase, string, -1);
    }

    public ArrayList<PSDepSysAPI> selectByPSDevSlnSysAPI(PSDevSlnSysAPIBase pSDevSlnSysAPIBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVSLNSYSAPIID", (Object)pSDevSlnSysAPIBase.getPSDevSlnSysAPIId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevSlnSysAPICond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevSlnSysAPICond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDepSysAPI> selectByPSSaaSSysAPI(PSSaaSSysAPIBase pSSaaSSysAPIBase) throws Exception {
        return this.selectByPSSaaSSysAPI(pSSaaSSysAPIBase, "", -1);
    }

    public ArrayList<PSDepSysAPI> selectByPSSaaSSysAPI(PSSaaSSysAPIBase pSSaaSSysAPIBase, String string) throws Exception {
        return this.selectByPSSaaSSysAPI(pSSaaSSysAPIBase, string, -1);
    }

    public ArrayList<PSDepSysAPI> selectByPSSaaSSysAPI(PSSaaSSysAPIBase pSSaaSSysAPIBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSAASSYSAPIID", (Object)pSSaaSSysAPIBase.getPSSaaSSysAPIId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSaaSSysAPICond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSaaSSysAPICond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDepSysVer(PSDepSysVer pSDepSysVer) throws Exception {
        ArrayList<PSDepSysAPI> arrayList = this.selectByPSDepSysVer(pSDepSysVer, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEPSYSVER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDepSysVer);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEPSYSAPI_PSDEPSYSVER_PSDEPSYSVERID", "", iDataEntityModel.getName(), "PSDEPSYSAPI", iDataEntityModel.getDataInfo((IEntity)pSDepSysVer), arrayList.get(0)));
        }
    }

    public void resetPSDepSysVer(PSDepSysVer pSDepSysVer) throws Exception {
        ArrayList<PSDepSysAPI> arrayList = this.selectByPSDepSysVer(pSDepSysVer);
        for (PSDepSysAPI pSDepSysAPI : arrayList) {
            PSDepSysAPI pSDepSysAPI2 = (PSDepSysAPI)this.getDEModel().createEntity();
            pSDepSysAPI2.setPSDepSysAPIId(pSDepSysAPI.getPSDepSysAPIId());
            pSDepSysAPI2.setPSDepSysVerId(null);
            this.update(pSDepSysAPI2);
        }
    }

    public void removeByPSDepSysVer(PSDepSysVer pSDepSysVer) throws Exception {
        final PSDepSysVer pSDepSysVer2 = pSDepSysVer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDepSysAPIServiceBase.this.onBeforeRemoveByPSDepSysVer(pSDepSysVer2);
                PSDepSysAPIServiceBase.this.internalRemoveByPSDepSysVer(pSDepSysVer2);
                PSDepSysAPIServiceBase.this.onAfterRemoveByPSDepSysVer(pSDepSysVer2);
            }
        });
    }

    protected void onBeforeRemoveByPSDepSysVer(PSDepSysVer pSDepSysVer) throws Exception {
    }

    protected void internalRemoveByPSDepSysVer(PSDepSysVer pSDepSysVer) throws Exception {
        ArrayList<PSDepSysAPI> arrayList = this.selectByPSDepSysVer(pSDepSysVer);
        this.onBeforeRemoveByPSDepSysVer(pSDepSysVer, arrayList);
        for (PSDepSysAPI pSDepSysAPI : arrayList) {
            this.remove((IEntity)pSDepSysAPI);
        }
        this.onAfterRemoveByPSDepSysVer(pSDepSysVer, arrayList);
    }

    protected void onAfterRemoveByPSDepSysVer(PSDepSysVer pSDepSysVer) throws Exception {
    }

    protected void onBeforeRemoveByPSDepSysVer(PSDepSysVer pSDepSysVer, ArrayList<PSDepSysAPI> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDepSysVer(PSDepSysVer pSDepSysVer, ArrayList<PSDepSysAPI> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSlnSysAPI(PSDevSlnSysAPI pSDevSlnSysAPI) throws Exception {
    }

    public void resetPSDevSlnSysAPI(PSDevSlnSysAPI pSDevSlnSysAPI) throws Exception {
        ArrayList<PSDepSysAPI> arrayList = this.selectByPSDevSlnSysAPI(pSDevSlnSysAPI);
        for (PSDepSysAPI pSDepSysAPI : arrayList) {
            PSDepSysAPI pSDepSysAPI2 = (PSDepSysAPI)this.getDEModel().createEntity();
            pSDepSysAPI2.setPSDepSysAPIId(pSDepSysAPI.getPSDepSysAPIId());
            pSDepSysAPI2.setPSDevSlnSysAPIId(null);
            this.update(pSDepSysAPI2);
        }
    }

    public void removeByPSDevSlnSysAPI(PSDevSlnSysAPI pSDevSlnSysAPI) throws Exception {
        final PSDevSlnSysAPI pSDevSlnSysAPI2 = pSDevSlnSysAPI;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDepSysAPIServiceBase.this.onBeforeRemoveByPSDevSlnSysAPI(pSDevSlnSysAPI2);
                PSDepSysAPIServiceBase.this.internalRemoveByPSDevSlnSysAPI(pSDevSlnSysAPI2);
                PSDepSysAPIServiceBase.this.onAfterRemoveByPSDevSlnSysAPI(pSDevSlnSysAPI2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSlnSysAPI(PSDevSlnSysAPI pSDevSlnSysAPI) throws Exception {
    }

    protected void internalRemoveByPSDevSlnSysAPI(PSDevSlnSysAPI pSDevSlnSysAPI) throws Exception {
        ArrayList<PSDepSysAPI> arrayList = this.selectByPSDevSlnSysAPI(pSDevSlnSysAPI);
        this.onBeforeRemoveByPSDevSlnSysAPI(pSDevSlnSysAPI, arrayList);
        for (PSDepSysAPI pSDepSysAPI : arrayList) {
            this.remove((IEntity)pSDepSysAPI);
        }
        this.onAfterRemoveByPSDevSlnSysAPI(pSDevSlnSysAPI, arrayList);
    }

    protected void onAfterRemoveByPSDevSlnSysAPI(PSDevSlnSysAPI pSDevSlnSysAPI) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSlnSysAPI(PSDevSlnSysAPI pSDevSlnSysAPI, ArrayList<PSDepSysAPI> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSlnSysAPI(PSDevSlnSysAPI pSDevSlnSysAPI, ArrayList<PSDepSysAPI> arrayList) throws Exception {
    }

    public void testRemoveByPSSaaSSysAPI(PSSaaSSysAPI pSSaaSSysAPI) throws Exception {
    }

    public void resetPSSaaSSysAPI(PSSaaSSysAPI pSSaaSSysAPI) throws Exception {
        ArrayList<PSDepSysAPI> arrayList = this.selectByPSSaaSSysAPI(pSSaaSSysAPI);
        for (PSDepSysAPI pSDepSysAPI : arrayList) {
            PSDepSysAPI pSDepSysAPI2 = (PSDepSysAPI)this.getDEModel().createEntity();
            pSDepSysAPI2.setPSDepSysAPIId(pSDepSysAPI.getPSDepSysAPIId());
            pSDepSysAPI2.setPSSaaSSysAPIId(null);
            this.update(pSDepSysAPI2);
        }
    }

    public void removeByPSSaaSSysAPI(PSSaaSSysAPI pSSaaSSysAPI) throws Exception {
        final PSSaaSSysAPI pSSaaSSysAPI2 = pSSaaSSysAPI;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDepSysAPIServiceBase.this.onBeforeRemoveByPSSaaSSysAPI(pSSaaSSysAPI2);
                PSDepSysAPIServiceBase.this.internalRemoveByPSSaaSSysAPI(pSSaaSSysAPI2);
                PSDepSysAPIServiceBase.this.onAfterRemoveByPSSaaSSysAPI(pSSaaSSysAPI2);
            }
        });
    }

    protected void onBeforeRemoveByPSSaaSSysAPI(PSSaaSSysAPI pSSaaSSysAPI) throws Exception {
    }

    protected void internalRemoveByPSSaaSSysAPI(PSSaaSSysAPI pSSaaSSysAPI) throws Exception {
        ArrayList<PSDepSysAPI> arrayList = this.selectByPSSaaSSysAPI(pSSaaSSysAPI);
        this.onBeforeRemoveByPSSaaSSysAPI(pSSaaSSysAPI, arrayList);
        for (PSDepSysAPI pSDepSysAPI : arrayList) {
            this.remove((IEntity)pSDepSysAPI);
        }
        this.onAfterRemoveByPSSaaSSysAPI(pSSaaSSysAPI, arrayList);
    }

    protected void onAfterRemoveByPSSaaSSysAPI(PSSaaSSysAPI pSSaaSSysAPI) throws Exception {
    }

    protected void onBeforeRemoveByPSSaaSSysAPI(PSSaaSSysAPI pSSaaSSysAPI, ArrayList<PSDepSysAPI> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSaaSSysAPI(PSSaaSSysAPI pSSaaSSysAPI, ArrayList<PSDepSysAPI> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDepSysAPI pSDepSysAPI) throws Exception {
        PSDepSlnSysService pSDepSlnSysService = (PSDepSlnSysService)ServiceGlobal.getService(PSDepSlnSysService.class, (SessionFactory)this.getSessionFactory());
        pSDepSlnSysService.testRemoveByPSDepSysAPI(pSDepSysAPI);
        super.onBeforeRemove(pSDepSysAPI);
    }

    protected void replaceParentInfo(PSDepSysAPI pSDepSysAPI, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDepSysAPI, cloneSession);
        if (pSDepSysAPI.getPSDepSysVerId() != null && (iEntity = cloneSession.getEntity("PSDEPSYSVER", (Object)pSDepSysAPI.getPSDepSysVerId())) != null) {
            this.onFillParentInfo_PSDepSysVer(pSDepSysAPI, (PSDepSysVer)iEntity);
        }
        if (pSDepSysAPI.getPSDevSlnSysAPIId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNSYSAPI", (Object)pSDepSysAPI.getPSDevSlnSysAPIId())) != null) {
            this.onFillParentInfo_PSDevSlnSysAPI(pSDepSysAPI, (PSDevSlnSysAPI)iEntity);
        }
        if (pSDepSysAPI.getPSSaaSSysAPIId() != null && (iEntity = cloneSession.getEntity("PSSAASSYSAPI", (Object)pSDepSysAPI.getPSSaaSSysAPIId())) != null) {
            this.onFillParentInfo_PSSaaSSysAPI(pSDepSysAPI, (PSSaaSSysAPI)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDepSysAPI pSDepSysAPI, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDepSysAPI, bl);
    }

    protected void onCheckEntity(boolean bl, PSDepSysAPI pSDepSysAPI, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bl, pSDepSysAPI, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSysAPIId(bl, pSDepSysAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSysAPIName(bl, pSDepSysAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSysAPIType(bl, pSDepSysAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSysVerId(bl, pSDepSysAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysAPIId(bl, pSDepSysAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSaaSSysAPIId(bl, pSDepSysAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSDepSysAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDepSysAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDepSysAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDepSysAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDepSysAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDepSysAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDepSysAPI, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDepSysAPI pSDepSysAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSysAPI.isMemoDirty() : !pSDepSysAPI.isMemoDirty()) {
            return null;
        }
        String string = pSDepSysAPI.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDepSysAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDepSysAPIId(boolean bl, PSDepSysAPI pSDepSysAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSysAPI.isPSDepSysAPIIdDirty() && !bl2 : !pSDepSysAPI.isPSDepSysAPIIdDirty()) {
            return null;
        }
        String string = pSDepSysAPI.getPSDepSysAPIId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSYSAPIID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSysAPIId_Default((IEntity)pSDepSysAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSYSAPIID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDepSysAPIName(boolean bl, PSDepSysAPI pSDepSysAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSysAPI.isPSDepSysAPINameDirty() && !bl2 : !pSDepSysAPI.isPSDepSysAPINameDirty()) {
            return null;
        }
        String string = pSDepSysAPI.getPSDepSysAPIName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSYSAPINAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSysAPIName_Default((IEntity)pSDepSysAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSYSAPINAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDepSysAPIType(boolean bl, PSDepSysAPI pSDepSysAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSysAPI.isPSDepSysAPITypeDirty() && !bl2 : !pSDepSysAPI.isPSDepSysAPITypeDirty()) {
            return null;
        }
        String string = pSDepSysAPI.getPSDepSysAPIType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSYSAPITYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSysAPIType_Default((IEntity)pSDepSysAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSYSAPITYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDepSysVerId(boolean bl, PSDepSysAPI pSDepSysAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSysAPI.isPSDepSysVerIdDirty() : !pSDepSysAPI.isPSDepSysVerIdDirty()) {
            return null;
        }
        String string = pSDepSysAPI.getPSDepSysVerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSysVerId_Default((IEntity)pSDepSysAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSYSVERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnSysAPIId(boolean bl, PSDepSysAPI pSDepSysAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSysAPI.isPSDevSlnSysAPIIdDirty() : !pSDepSysAPI.isPSDevSlnSysAPIIdDirty()) {
            return null;
        }
        String string = pSDepSysAPI.getPSDevSlnSysAPIId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysAPIId_Default((IEntity)pSDepSysAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSAPIID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSaaSSysAPIId(boolean bl, PSDepSysAPI pSDepSysAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSysAPI.isPSSaaSSysAPIIdDirty() : !pSDepSysAPI.isPSSaaSSysAPIIdDirty()) {
            return null;
        }
        String string = pSDepSysAPI.getPSSaaSSysAPIId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSaaSSysAPIId_Default((IEntity)pSDepSysAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSAASSYSAPIID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSDepSysAPI pSDepSysAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSysAPI.isUserCatDirty() : !pSDepSysAPI.isUserCatDirty()) {
            return null;
        }
        String string = pSDepSysAPI.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default((IEntity)pSDepSysAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERCAT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDepSysAPI pSDepSysAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSysAPI.isUserTagDirty() : !pSDepSysAPI.isUserTagDirty()) {
            return null;
        }
        String string = pSDepSysAPI.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSDepSysAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDepSysAPI pSDepSysAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSysAPI.isUserTag2Dirty() : !pSDepSysAPI.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDepSysAPI.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSDepSysAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDepSysAPI pSDepSysAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSysAPI.isUserTag3Dirty() : !pSDepSysAPI.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDepSysAPI.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default((IEntity)pSDepSysAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERTAG3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDepSysAPI pSDepSysAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSysAPI.isUserTag4Dirty() : !pSDepSysAPI.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDepSysAPI.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default((IEntity)pSDepSysAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERTAG4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDepSysAPI pSDepSysAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSysAPI.isValidFlagDirty() : !pSDepSysAPI.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDepSysAPI.getValidFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSDepSysAPI, bl2, bl3);
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

    protected void onSyncEntity(PSDepSysAPI pSDepSysAPI, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDepSysAPI, bl);
    }

    protected void onSyncIndexEntities(PSDepSysAPI pSDepSysAPI, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDepSysAPI, bl);
    }

    public Object getDataContextValue(PSDepSysAPI pSDepSysAPI, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDepSysAPI, string, iDataContextParam)) != null) {
            return object;
        }
        PSDepSysVer pSDepSysVer = pSDepSysAPI.getPSDepSysVer();
        if (pSDepSysVer != null && pSDepSysVer.contains(string)) {
            return pSDepSysVer.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDepSysAPI pSDepSysAPI, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDepSysAPI, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"PSDEPSYSAPIID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSysAPIId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSYSAPINAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSysAPIName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSYSAPITYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSysAPIType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSYSVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSysVerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSYSVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSysVerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSAPIID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysAPIId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSAPINAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysAPIName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSAASSYSAPIID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSaaSSysAPIId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSAASSYSAPINAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSaaSSysAPIName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERCAT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserCat_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag4_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSDepSysAPIId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSYSAPIID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSysAPIName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSYSAPINAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSysAPIType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSYSAPITYPE", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSysVerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSYSVERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSysVerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSYSVERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnSysAPIId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSAPIID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnSysAPIName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSAPINAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSaaSSysAPIId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSAASSYSAPIID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSaaSSysAPIName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSAASSYSAPINAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_UserCat_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERCAT", iEntity, bl2, null, false, 10, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG3", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG4", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected boolean onMergeChild(String string, String string2, PSDepSysAPI pSDepSysAPI) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDepSysAPI)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDepSysAPI pSDepSysAPI) throws Exception {
        super.onUpdateParent((IEntity)pSDepSysAPI);
    }

    @Override
    protected void exportCurXmlModel(PSDepSysAPI pSDepSysAPI, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEPSYSAPI");
        if (!bl) {
            pSDepSysAPI.setCreateDate(null);
            pSDepSysAPI.setCreateMan(null);
            pSDepSysAPI.setPSDepSysAPIId(null);
            pSDepSysAPI.setPSDepSysAPIType(null);
            pSDepSysAPI.setPSDepSysVerName(null);
            pSDepSysAPI.setPSDevSlnSysAPIName(null);
            pSDepSysAPI.setPSSaaSSysAPIName(null);
            pSDepSysAPI.setUpdateDate(null);
            pSDepSysAPI.setUpdateMan(null);
            super.exportCurXmlModel(pSDepSysAPI, xmlNode, bl);
        }
    }
}

