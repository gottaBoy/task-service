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
import net.ibizsys.pscore.srv.devcenter.entity.PSSaaSSysApp;
import net.ibizsys.pscore.srv.devcenter.entity.PSSaaSSysAppBase;
import net.ibizsys.pscore.srv.sysdeploy.dao.PSDepSysAppDAO;
import net.ibizsys.pscore.srv.sysdeploy.demodel.PSDepSysAppDEModel;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSysApp;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSysVer;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSysVerBase;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysASService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysASServiceBase;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysServiceBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysAppBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDepSysAppServiceBase
extends PSCoreSysServiceBase<PSDepSysApp> {
    private static final Log log = LogFactory.getLog(PSDepSysAppServiceBase.class);
    public static final String DATASET_CURDEPSLNSYS = "CurDepSlnSys";
    public static final String DATASET_CURVER = "CurVer";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDepSysAppDEModel pSDepSysAppDEModel;
    private PSDepSysAppDAO pSDepSysAppDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdeploy.service.PSDepSysAppService";
    }

    public PSDepSysAppDEModel getPSDepSysAppDEModel() {
        if (this.pSDepSysAppDEModel == null) {
            try {
                this.pSDepSysAppDEModel = (PSDepSysAppDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdeploy.demodel.PSDepSysAppDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDepSysAppDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDepSysAppDEModel();
    }

    public PSDepSysAppDAO getPSDepSysAppDAO() {
        if (this.pSDepSysAppDAO == null) {
            try {
                this.pSDepSysAppDAO = (PSDepSysAppDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdeploy.dao.PSDepSysAppDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDepSysAppDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDepSysAppDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURDEPSLNSYS, (boolean)true) == 0) {
            return this.fetchCurDepSlnSys(iDEDataSetFetchContext);
        }
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

    public DBFetchResult fetchCurDepSlnSys(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDEPSLNSYS, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurVer(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURVER, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSDepSysApp pSDepSysApp, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPSYSAPP_PSDEPSYSVER_PSDEPSYSVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSysVerService", (SessionFactory)this.getSessionFactory());
            PSDepSysVer pSDepSysVer = (PSDepSysVer)iService.getDEModel().createEntity();
            pSDepSysVer.set("PSDEPSYSVERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDepSysVer);
            } else {
                iService.get(pSDepSysVer);
            }
            this.onFillParentInfo_PSDepSysVer(pSDepSysApp, pSDepSysVer);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPSYSAPP_PSDEVSLNSYSAPP_PSDEVSLNSYSAPPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysAppService", (SessionFactory)this.getSessionFactory());
            PSDevSlnSysApp pSDevSlnSysApp = (PSDevSlnSysApp)iService.getDEModel().createEntity();
            pSDevSlnSysApp.set("PSDEVSLNSYSAPPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevSlnSysApp);
            } else {
                iService.get(pSDevSlnSysApp);
            }
            this.onFillParentInfo_PSDevSlnSysApp(pSDepSysApp, pSDevSlnSysApp);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPSYSAPP_PSSAASSYSAPP_PSSAASSYSAPPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSSaaSSysAppService", (SessionFactory)this.getSessionFactory());
            PSSaaSSysApp pSSaaSSysApp = (PSSaaSSysApp)iService.getDEModel().createEntity();
            pSSaaSSysApp.set("PSSAASSYSAPPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSaaSSysApp);
            } else {
                iService.get(pSSaaSSysApp);
            }
            this.onFillParentInfo_PSSaaSSysApp(pSDepSysApp, pSSaaSSysApp);
            return;
        }
        super.onFillParentInfo(pSDepSysApp, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDepSysVer(PSDepSysApp pSDepSysApp, PSDepSysVer pSDepSysVer) throws Exception {
        pSDepSysApp.setPSDepSysVerId(pSDepSysVer.getPSDepSysVerId());
        pSDepSysApp.setPSDepSysVerName(pSDepSysVer.getPSDepSysVerName());
    }

    protected void onFillParentInfo_PSDevSlnSysApp(PSDepSysApp pSDepSysApp, PSDevSlnSysApp pSDevSlnSysApp) throws Exception {
        pSDepSysApp.setPSDevSlnSysAppId(pSDevSlnSysApp.getPSDevSlnSysAppId());
        pSDepSysApp.setPSDevSlnSysAppName(pSDevSlnSysApp.getPSDevSlnSysAppName());
    }

    protected void onFillParentInfo_PSSaaSSysApp(PSDepSysApp pSDepSysApp, PSSaaSSysApp pSSaaSSysApp) throws Exception {
        pSDepSysApp.setPSSaaSSysAppId(pSSaaSSysApp.getPSSaaSSysAppId());
        pSDepSysApp.setPSSaaSSysAppName(pSSaaSSysApp.getPSSaaSSysAppName());
    }

    protected void onFillEntityFullInfo(PSDepSysApp pSDepSysApp, boolean bl) throws Exception {
        if (bl && pSDepSysApp.getValidFlag() == null) {
            pSDepSysApp.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo(pSDepSysApp, bl);
        this.onFillEntityFullInfo_PSDepSysVer(pSDepSysApp, bl);
        this.onFillEntityFullInfo_PSDevSlnSysApp(pSDepSysApp, bl);
        this.onFillEntityFullInfo_PSSaaSSysApp(pSDepSysApp, bl);
    }

    protected void onFillEntityFullInfo_PSDepSysVer(PSDepSysApp pSDepSysApp, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevSlnSysApp(PSDepSysApp pSDepSysApp, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSaaSSysApp(PSDepSysApp pSDepSysApp, boolean bl) throws Exception {
        if (pSDepSysApp.isPSSaaSSysAppIdDirty()) {
            if (pSDepSysApp.getPSSaaSSysAppId() != null) {
                if (pSDepSysApp.getPSSaaSSysAppId() == null || pSDepSysApp.getPSSaaSSysAppName() == null) {
                    PSSaaSSysApp pSSaaSSysApp = pSDepSysApp.getPSSaaSSysApp();
                    pSDepSysApp.setPSSaaSSysAppName(pSSaaSSysApp.getPSSaaSSysAppName());
                }
            } else {
                pSDepSysApp.setPSSaaSSysAppName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDepSysApp pSDepSysApp, boolean bl) throws Exception {
        super.onWriteBackParent(pSDepSysApp, bl);
    }

    public ArrayList<PSDepSysApp> selectByPSDepSysVer(PSDepSysVerBase pSDepSysVerBase) throws Exception {
        return this.selectByPSDepSysVer(pSDepSysVerBase, "", -1);
    }

    public ArrayList<PSDepSysApp> selectByPSDepSysVer(PSDepSysVerBase pSDepSysVerBase, String string) throws Exception {
        return this.selectByPSDepSysVer(pSDepSysVerBase, string, -1);
    }

    public ArrayList<PSDepSysApp> selectByPSDepSysVer(PSDepSysVerBase pSDepSysVerBase, String string, int n) throws Exception {
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

    public ArrayList<PSDepSysApp> selectByPSDevSlnSysApp(PSDevSlnSysAppBase pSDevSlnSysAppBase) throws Exception {
        return this.selectByPSDevSlnSysApp(pSDevSlnSysAppBase, "", -1);
    }

    public ArrayList<PSDepSysApp> selectByPSDevSlnSysApp(PSDevSlnSysAppBase pSDevSlnSysAppBase, String string) throws Exception {
        return this.selectByPSDevSlnSysApp(pSDevSlnSysAppBase, string, -1);
    }

    public ArrayList<PSDepSysApp> selectByPSDevSlnSysApp(PSDevSlnSysAppBase pSDevSlnSysAppBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVSLNSYSAPPID", (Object)pSDevSlnSysAppBase.getPSDevSlnSysAppId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevSlnSysAppCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevSlnSysAppCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDepSysApp> selectByPSSaaSSysApp(PSSaaSSysAppBase pSSaaSSysAppBase) throws Exception {
        return this.selectByPSSaaSSysApp(pSSaaSSysAppBase, "", -1);
    }

    public ArrayList<PSDepSysApp> selectByPSSaaSSysApp(PSSaaSSysAppBase pSSaaSSysAppBase, String string) throws Exception {
        return this.selectByPSSaaSSysApp(pSSaaSSysAppBase, string, -1);
    }

    public ArrayList<PSDepSysApp> selectByPSSaaSSysApp(PSSaaSSysAppBase pSSaaSSysAppBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSAASSYSAPPID", (Object)pSSaaSSysAppBase.getPSSaaSSysAppId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSaaSSysAppCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSaaSSysAppCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDepSysVer(PSDepSysVer pSDepSysVer) throws Exception {
        ArrayList<PSDepSysApp> arrayList = this.selectByPSDepSysVer(pSDepSysVer, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEPSYSVER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDepSysVer);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEPSYSAPP_PSDEPSYSVER_PSDEPSYSVERID", "", iDataEntityModel.getName(), "PSDEPSYSAPP", iDataEntityModel.getDataInfo(pSDepSysVer), arrayList.get(0)));
        }
    }

    public void resetPSDepSysVer(PSDepSysVer pSDepSysVer) throws Exception {
        ArrayList<PSDepSysApp> arrayList = this.selectByPSDepSysVer(pSDepSysVer);
        for (PSDepSysApp pSDepSysApp : arrayList) {
            PSDepSysApp pSDepSysApp2 = (PSDepSysApp)this.getDEModel().createEntity();
            pSDepSysApp2.setPSDepSysAppId(pSDepSysApp.getPSDepSysAppId());
            pSDepSysApp2.setPSDepSysVerId(null);
            this.update(pSDepSysApp2);
        }
    }

    public void removeByPSDepSysVer(PSDepSysVer pSDepSysVer) throws Exception {
        final PSDepSysVer pSDepSysVer2 = pSDepSysVer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDepSysAppServiceBase.this.onBeforeRemoveByPSDepSysVer(pSDepSysVer2);
                PSDepSysAppServiceBase.this.internalRemoveByPSDepSysVer(pSDepSysVer2);
                PSDepSysAppServiceBase.this.onAfterRemoveByPSDepSysVer(pSDepSysVer2);
            }
        });
    }

    protected void onBeforeRemoveByPSDepSysVer(PSDepSysVer pSDepSysVer) throws Exception {
    }

    protected void internalRemoveByPSDepSysVer(PSDepSysVer pSDepSysVer) throws Exception {
        ArrayList<PSDepSysApp> arrayList = this.selectByPSDepSysVer(pSDepSysVer);
        this.onBeforeRemoveByPSDepSysVer(pSDepSysVer, arrayList);
        for (PSDepSysApp pSDepSysApp : arrayList) {
            this.remove(pSDepSysApp);
        }
        this.onAfterRemoveByPSDepSysVer(pSDepSysVer, arrayList);
    }

    protected void onAfterRemoveByPSDepSysVer(PSDepSysVer pSDepSysVer) throws Exception {
    }

    protected void onBeforeRemoveByPSDepSysVer(PSDepSysVer pSDepSysVer, ArrayList<PSDepSysApp> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDepSysVer(PSDepSysVer pSDepSysVer, ArrayList<PSDepSysApp> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSlnSysApp(PSDevSlnSysApp pSDevSlnSysApp) throws Exception {
    }

    public void resetPSDevSlnSysApp(PSDevSlnSysApp pSDevSlnSysApp) throws Exception {
        ArrayList<PSDepSysApp> arrayList = this.selectByPSDevSlnSysApp(pSDevSlnSysApp);
        for (PSDepSysApp pSDepSysApp : arrayList) {
            PSDepSysApp pSDepSysApp2 = (PSDepSysApp)this.getDEModel().createEntity();
            pSDepSysApp2.setPSDepSysAppId(pSDepSysApp.getPSDepSysAppId());
            pSDepSysApp2.setPSDevSlnSysAppId(null);
            this.update(pSDepSysApp2);
        }
    }

    public void removeByPSDevSlnSysApp(PSDevSlnSysApp pSDevSlnSysApp) throws Exception {
        final PSDevSlnSysApp pSDevSlnSysApp2 = pSDevSlnSysApp;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDepSysAppServiceBase.this.onBeforeRemoveByPSDevSlnSysApp(pSDevSlnSysApp2);
                PSDepSysAppServiceBase.this.internalRemoveByPSDevSlnSysApp(pSDevSlnSysApp2);
                PSDepSysAppServiceBase.this.onAfterRemoveByPSDevSlnSysApp(pSDevSlnSysApp2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSlnSysApp(PSDevSlnSysApp pSDevSlnSysApp) throws Exception {
    }

    protected void internalRemoveByPSDevSlnSysApp(PSDevSlnSysApp pSDevSlnSysApp) throws Exception {
        ArrayList<PSDepSysApp> arrayList = this.selectByPSDevSlnSysApp(pSDevSlnSysApp);
        this.onBeforeRemoveByPSDevSlnSysApp(pSDevSlnSysApp, arrayList);
        for (PSDepSysApp pSDepSysApp : arrayList) {
            this.remove(pSDepSysApp);
        }
        this.onAfterRemoveByPSDevSlnSysApp(pSDevSlnSysApp, arrayList);
    }

    protected void onAfterRemoveByPSDevSlnSysApp(PSDevSlnSysApp pSDevSlnSysApp) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSlnSysApp(PSDevSlnSysApp pSDevSlnSysApp, ArrayList<PSDepSysApp> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSlnSysApp(PSDevSlnSysApp pSDevSlnSysApp, ArrayList<PSDepSysApp> arrayList) throws Exception {
    }

    public void testRemoveByPSSaaSSysApp(PSSaaSSysApp pSSaaSSysApp) throws Exception {
    }

    public void resetPSSaaSSysApp(PSSaaSSysApp pSSaaSSysApp) throws Exception {
        ArrayList<PSDepSysApp> arrayList = this.selectByPSSaaSSysApp(pSSaaSSysApp);
        for (PSDepSysApp pSDepSysApp : arrayList) {
            PSDepSysApp pSDepSysApp2 = (PSDepSysApp)this.getDEModel().createEntity();
            pSDepSysApp2.setPSDepSysAppId(pSDepSysApp.getPSDepSysAppId());
            pSDepSysApp2.setPSSaaSSysAppId(null);
            this.update(pSDepSysApp2);
        }
    }

    public void removeByPSSaaSSysApp(PSSaaSSysApp pSSaaSSysApp) throws Exception {
        final PSSaaSSysApp pSSaaSSysApp2 = pSSaaSSysApp;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDepSysAppServiceBase.this.onBeforeRemoveByPSSaaSSysApp(pSSaaSSysApp2);
                PSDepSysAppServiceBase.this.internalRemoveByPSSaaSSysApp(pSSaaSSysApp2);
                PSDepSysAppServiceBase.this.onAfterRemoveByPSSaaSSysApp(pSSaaSSysApp2);
            }
        });
    }

    protected void onBeforeRemoveByPSSaaSSysApp(PSSaaSSysApp pSSaaSSysApp) throws Exception {
    }

    protected void internalRemoveByPSSaaSSysApp(PSSaaSSysApp pSSaaSSysApp) throws Exception {
        ArrayList<PSDepSysApp> arrayList = this.selectByPSSaaSSysApp(pSSaaSSysApp);
        this.onBeforeRemoveByPSSaaSSysApp(pSSaaSSysApp, arrayList);
        for (PSDepSysApp pSDepSysApp : arrayList) {
            this.remove(pSDepSysApp);
        }
        this.onAfterRemoveByPSSaaSSysApp(pSSaaSSysApp, arrayList);
    }

    protected void onAfterRemoveByPSSaaSSysApp(PSSaaSSysApp pSSaaSSysApp) throws Exception {
    }

    protected void onBeforeRemoveByPSSaaSSysApp(PSSaaSSysApp pSSaaSSysApp, ArrayList<PSDepSysApp> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSaaSSysApp(PSSaaSSysApp pSSaaSSysApp, ArrayList<PSDepSysApp> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDepSysApp pSDepSysApp) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDepSlnSysASService)ServiceGlobal.getService(PSDepSlnSysASService.class, (SessionFactory)this.getSessionFactory());
        ((PSDepSlnSysASServiceBase)pSCoreSysServiceBase).testRemoveByNo2PSDepSysApp(pSDepSysApp);
        pSCoreSysServiceBase = (PSDepSlnSysASService)ServiceGlobal.getService(PSDepSlnSysASService.class, (SessionFactory)this.getSessionFactory());
        ((PSDepSlnSysASServiceBase)pSCoreSysServiceBase).testRemoveByPSDepSysApp(pSDepSysApp);
        pSCoreSysServiceBase = (PSDepSlnSysService)ServiceGlobal.getService(PSDepSlnSysService.class, (SessionFactory)this.getSessionFactory());
        ((PSDepSlnSysServiceBase)pSCoreSysServiceBase).testRemoveByPSDepSysApp(pSDepSysApp);
        super.onBeforeRemove(pSDepSysApp);
    }

    protected void replaceParentInfo(PSDepSysApp pSDepSysApp, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDepSysApp, cloneSession);
        if (pSDepSysApp.getPSDepSysVerId() != null && (iEntity = cloneSession.getEntity("PSDEPSYSVER", (Object)pSDepSysApp.getPSDepSysVerId())) != null) {
            this.onFillParentInfo_PSDepSysVer(pSDepSysApp, (PSDepSysVer)iEntity);
        }
        if (pSDepSysApp.getPSDevSlnSysAppId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNSYSAPP", (Object)pSDepSysApp.getPSDevSlnSysAppId())) != null) {
            this.onFillParentInfo_PSDevSlnSysApp(pSDepSysApp, (PSDevSlnSysApp)iEntity);
        }
        if (pSDepSysApp.getPSSaaSSysAppId() != null && (iEntity = cloneSession.getEntity("PSSAASSYSAPP", (Object)pSDepSysApp.getPSSaaSSysAppId())) != null) {
            this.onFillParentInfo_PSSaaSSysApp(pSDepSysApp, (PSSaaSSysApp)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDepSysApp pSDepSysApp, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDepSysApp, bl);
    }

    protected void onCheckEntity(boolean bl, PSDepSysApp pSDepSysApp, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bl, pSDepSysApp, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSysAppId(bl, pSDepSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSysAppName(bl, pSDepSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSysAppType(bl, pSDepSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSysVerId(bl, pSDepSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysAppId(bl, pSDepSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSaaSSysAppId(bl, pSDepSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSaaSSysAppName(bl, pSDepSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSDepSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDepSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDepSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDepSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDepSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDepSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDepSysApp, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDepSysApp pSDepSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSysApp.isMemoDirty() : !pSDepSysApp.isMemoDirty()) {
            return null;
        }
        String string = pSDepSysApp.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDepSysApp, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDepSysAppId(boolean bl, PSDepSysApp pSDepSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSysApp.isPSDepSysAppIdDirty() && !bl2 : !pSDepSysApp.isPSDepSysAppIdDirty()) {
            return null;
        }
        String string = pSDepSysApp.getPSDepSysAppId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSYSAPPID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSysAppId_Default(pSDepSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSYSAPPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDepSysAppName(boolean bl, PSDepSysApp pSDepSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSysApp.isPSDepSysAppNameDirty() && !bl2 : !pSDepSysApp.isPSDepSysAppNameDirty()) {
            return null;
        }
        String string = pSDepSysApp.getPSDepSysAppName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSYSAPPNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSysAppName_Default(pSDepSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSYSAPPNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDepSysAppType(boolean bl, PSDepSysApp pSDepSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSysApp.isPSDepSysAppTypeDirty() && !bl2 : !pSDepSysApp.isPSDepSysAppTypeDirty()) {
            return null;
        }
        String string = pSDepSysApp.getPSDepSysAppType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSYSAPPTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSysAppType_Default(pSDepSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSYSAPPTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDepSysVerId(boolean bl, PSDepSysApp pSDepSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSysApp.isPSDepSysVerIdDirty() : !pSDepSysApp.isPSDepSysVerIdDirty()) {
            return null;
        }
        String string = pSDepSysApp.getPSDepSysVerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSysVerId_Default(pSDepSysApp, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevSlnSysAppId(boolean bl, PSDepSysApp pSDepSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSysApp.isPSDevSlnSysAppIdDirty() : !pSDepSysApp.isPSDevSlnSysAppIdDirty()) {
            return null;
        }
        String string = pSDepSysApp.getPSDevSlnSysAppId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysAppId_Default(pSDepSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSAPPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSaaSSysAppId(boolean bl, PSDepSysApp pSDepSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSysApp.isPSSaaSSysAppIdDirty() : !pSDepSysApp.isPSSaaSSysAppIdDirty()) {
            return null;
        }
        String string = pSDepSysApp.getPSSaaSSysAppId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSaaSSysAppId_Default(pSDepSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSAASSYSAPPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSaaSSysAppName(boolean bl, PSDepSysApp pSDepSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSysApp.isPSSaaSSysAppNameDirty() : !pSDepSysApp.isPSSaaSSysAppNameDirty()) {
            return null;
        }
        String string = pSDepSysApp.getPSSaaSSysAppName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSaaSSysAppName_Default(pSDepSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSAASSYSAPPNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSDepSysApp pSDepSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSysApp.isUserCatDirty() : !pSDepSysApp.isUserCatDirty()) {
            return null;
        }
        String string = pSDepSysApp.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSDepSysApp, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDepSysApp pSDepSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSysApp.isUserTagDirty() : !pSDepSysApp.isUserTagDirty()) {
            return null;
        }
        String string = pSDepSysApp.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSDepSysApp, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDepSysApp pSDepSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSysApp.isUserTag2Dirty() : !pSDepSysApp.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDepSysApp.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSDepSysApp, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDepSysApp pSDepSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSysApp.isUserTag3Dirty() : !pSDepSysApp.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDepSysApp.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSDepSysApp, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDepSysApp pSDepSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSysApp.isUserTag4Dirty() : !pSDepSysApp.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDepSysApp.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSDepSysApp, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDepSysApp pSDepSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSysApp.isValidFlagDirty() : !pSDepSysApp.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDepSysApp.getValidFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSDepSysApp, bl2, bl3);
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

    protected void onSyncEntity(PSDepSysApp pSDepSysApp, boolean bl) throws Exception {
        super.onSyncEntity(pSDepSysApp, bl);
    }

    protected void onSyncIndexEntities(PSDepSysApp pSDepSysApp, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDepSysApp, bl);
    }

    public Object getDataContextValue(PSDepSysApp pSDepSysApp, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDepSysApp, string, iDataContextParam)) != null) {
            return object;
        }
        PSDepSysVer pSDepSysVer = pSDepSysApp.getPSDepSysVer();
        if (pSDepSysVer != null && pSDepSysVer.contains(string)) {
            return pSDepSysVer.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDepSysApp pSDepSysApp, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDepSysApp, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"PSDEPSYSAPPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSysAppId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSYSAPPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSysAppName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSYSAPPTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSysAppType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSYSVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSysVerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSYSVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSysVerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSAPPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysAppId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSAPPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysAppName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSAASSYSAPPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSaaSSysAppId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSAASSYSAPPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSaaSSysAppName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSDepSysAppId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSYSAPPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSysAppName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSYSAPPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSysAppType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSYSAPPTYPE", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
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

    protected String onTestValueRule_PSDevSlnSysAppId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSAPPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnSysAppName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSAPPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSaaSSysAppId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSAASSYSAPPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSaaSSysAppName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSAASSYSAPPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSDepSysApp pSDepSysApp) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDepSysApp)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDepSysApp pSDepSysApp) throws Exception {
        super.onUpdateParent(pSDepSysApp);
    }

    @Override
    protected void exportCurXmlModel(PSDepSysApp pSDepSysApp, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEPSYSAPP");
        if (!bl) {
            pSDepSysApp.setCreateDate(null);
            pSDepSysApp.setCreateMan(null);
            pSDepSysApp.setPSDepSysAppId(null);
            pSDepSysApp.setPSDepSysAppType(null);
            pSDepSysApp.setPSDepSysVerName(null);
            pSDepSysApp.setPSDevSlnSysAppName(null);
            pSDepSysApp.setUpdateDate(null);
            pSDepSysApp.setUpdateMan(null);
            super.exportCurXmlModel(pSDepSysApp, xmlNode, bl);
        }
    }

    @Override
    public Object getDataType(PSDepSysApp pSDepSysApp) throws Exception {
        return pSDepSysApp.getPSDepSysAppType();
    }
}

