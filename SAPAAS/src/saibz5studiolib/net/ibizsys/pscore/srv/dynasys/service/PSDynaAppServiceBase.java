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
package net.ibizsys.pscore.srv.dynasys.service;

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
import net.ibizsys.pscore.srv.appdesign.service.PSAppFuncService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppFuncServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppMenuService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppMenuServiceBase;
import net.ibizsys.pscore.srv.config.entity.PSAppType;
import net.ibizsys.pscore.srv.config.entity.PSAppTypeBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dynasys.dao.PSDynaAppDAO;
import net.ibizsys.pscore.srv.dynasys.demodel.PSDynaAppDEModel;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaApp;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaSys;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaSysBase;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaAppViewInstService;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaAppViewInstServiceBase;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaAppViewService;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaAppViewServiceBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysAppBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDynaAppServiceBase
extends PSCoreSysServiceBase<PSDynaApp> {
    private static final Log log = LogFactory.getLog(PSDynaAppServiceBase.class);
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDynaAppDEModel pSDynaAppDEModel;
    private PSDynaAppDAO pSDynaAppDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dynasys.service.PSDynaAppService";
    }

    public PSDynaAppDEModel getPSDynaAppDEModel() {
        if (this.pSDynaAppDEModel == null) {
            try {
                this.pSDynaAppDEModel = (PSDynaAppDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dynasys.demodel.PSDynaAppDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDynaAppDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDynaAppDEModel();
    }

    public PSDynaAppDAO getPSDynaAppDAO() {
        if (this.pSDynaAppDAO == null) {
            try {
                this.pSDynaAppDAO = (PSDynaAppDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dynasys.dao.PSDynaAppDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDynaAppDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDynaAppDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURSYS, (boolean)true) == 0) {
            return this.fetchCurSys(iDEDataSetFetchContext);
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

    public DBFetchResult fetchCurSys(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYS, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSDynaApp pSDynaApp, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDYNAAPP_PSAPPTYPE_PSAPPTYPEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSAppTypeService", (SessionFactory)this.getSessionFactory());
            PSAppType pSAppType = (PSAppType)iService.getDEModel().createEntity();
            pSAppType.set("PSAPPTYPEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSAppType);
            } else {
                iService.get(pSAppType);
            }
            this.onFillParentInfo_PSAppType(pSDynaApp, pSAppType);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDYNAAPP_PSDYNASYS_PSDYNASYSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dynasys.service.PSDynaSysService", (SessionFactory)this.getSessionFactory());
            PSDynaSys pSDynaSys = (PSDynaSys)iService.getDEModel().createEntity();
            pSDynaSys.set("PSDYNASYSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDynaSys);
            } else {
                iService.get(pSDynaSys);
            }
            this.onFillParentInfo_PSDynaSys(pSDynaApp, pSDynaSys);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDYNAAPP_PSSYSAPP_PSSYSAPPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService", (SessionFactory)this.getSessionFactory());
            PSSysApp pSSysApp = (PSSysApp)iService.getDEModel().createEntity();
            pSSysApp.set("PSSYSAPPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysApp);
            } else {
                iService.get(pSSysApp);
            }
            this.onFillParentInfo_PSSysApp(pSDynaApp, pSSysApp);
            return;
        }
        super.onFillParentInfo(pSDynaApp, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSAppType(PSDynaApp pSDynaApp, PSAppType pSAppType) throws Exception {
        pSDynaApp.setPSAppTypeId(pSAppType.getPSAppTypeId());
        pSDynaApp.setPSAppTypeName(pSAppType.getPSAppTypeName());
    }

    protected void onFillParentInfo_PSDynaSys(PSDynaApp pSDynaApp, PSDynaSys pSDynaSys) throws Exception {
        pSDynaApp.setPSDynaSysId(pSDynaSys.getPSDynaSysId());
        pSDynaApp.setPSDynaSysName(pSDynaSys.getPSDynaSysName());
    }

    protected void onFillParentInfo_PSSysApp(PSDynaApp pSDynaApp, PSSysApp pSSysApp) throws Exception {
        pSDynaApp.setPSSysAppId(pSSysApp.getPSSysAppId());
        pSDynaApp.setPSSysAppName(pSSysApp.getPSSysAppName());
    }

    protected void onFillEntityFullInfo(PSDynaApp pSDynaApp, boolean bl) throws Exception {
        if (bl && pSDynaApp.getValidFlag() == null) {
            pSDynaApp.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo(pSDynaApp, bl);
        this.onFillEntityFullInfo_PSAppType(pSDynaApp, bl);
        this.onFillEntityFullInfo_PSDynaSys(pSDynaApp, bl);
        this.onFillEntityFullInfo_PSSysApp(pSDynaApp, bl);
    }

    protected void onFillEntityFullInfo_PSAppType(PSDynaApp pSDynaApp, boolean bl) throws Exception {
        if (pSDynaApp.isPSAppTypeIdDirty()) {
            if (pSDynaApp.getPSAppTypeId() != null) {
                if (pSDynaApp.getPSAppTypeId() == null || pSDynaApp.getPSAppTypeName() == null) {
                    PSAppType pSAppType = pSDynaApp.getPSAppType();
                    pSDynaApp.setPSAppTypeName(pSAppType.getPSAppTypeName());
                }
            } else {
                pSDynaApp.setPSAppTypeName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDynaSys(PSDynaApp pSDynaApp, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysApp(PSDynaApp pSDynaApp, boolean bl) throws Exception {
        if (pSDynaApp.isPSSysAppIdDirty()) {
            if (pSDynaApp.getPSSysAppId() != null) {
                if (pSDynaApp.getPSSysAppId() == null || pSDynaApp.getPSSysAppName() == null) {
                    PSSysApp pSSysApp = pSDynaApp.getPSSysApp();
                    pSDynaApp.setPSSysAppName(pSSysApp.getPSSysAppName());
                }
            } else {
                pSDynaApp.setPSSysAppName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDynaApp pSDynaApp, boolean bl) throws Exception {
        super.onWriteBackParent(pSDynaApp, bl);
    }

    public ArrayList<PSDynaApp> selectByPSAppType(PSAppTypeBase pSAppTypeBase) throws Exception {
        return this.selectByPSAppType(pSAppTypeBase, "", -1);
    }

    public ArrayList<PSDynaApp> selectByPSAppType(PSAppTypeBase pSAppTypeBase, String string) throws Exception {
        return this.selectByPSAppType(pSAppTypeBase, string, -1);
    }

    public ArrayList<PSDynaApp> selectByPSAppType(PSAppTypeBase pSAppTypeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSAPPTYPEID", (Object)pSAppTypeBase.getPSAppTypeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSAppTypeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSAppTypeCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDynaApp> selectByPSDynaSys(PSDynaSysBase pSDynaSysBase) throws Exception {
        return this.selectByPSDynaSys(pSDynaSysBase, "", -1);
    }

    public ArrayList<PSDynaApp> selectByPSDynaSys(PSDynaSysBase pSDynaSysBase, String string) throws Exception {
        return this.selectByPSDynaSys(pSDynaSysBase, string, -1);
    }

    public ArrayList<PSDynaApp> selectByPSDynaSys(PSDynaSysBase pSDynaSysBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDYNASYSID", (Object)pSDynaSysBase.getPSDynaSysId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDynaSysCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDynaSysCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDynaApp> selectByPSSysApp(PSSysAppBase pSSysAppBase) throws Exception {
        return this.selectByPSSysApp(pSSysAppBase, "", -1);
    }

    public ArrayList<PSDynaApp> selectByPSSysApp(PSSysAppBase pSSysAppBase, String string) throws Exception {
        return this.selectByPSSysApp(pSSysAppBase, string, -1);
    }

    public ArrayList<PSDynaApp> selectByPSSysApp(PSSysAppBase pSSysAppBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSAPPID", (Object)pSSysAppBase.getPSSysAppId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysAppCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysAppCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSAppType(PSAppType pSAppType) throws Exception {
    }

    public void resetPSAppType(PSAppType pSAppType) throws Exception {
        ArrayList<PSDynaApp> arrayList = this.selectByPSAppType(pSAppType);
        for (PSDynaApp pSDynaApp : arrayList) {
            PSDynaApp pSDynaApp2 = (PSDynaApp)this.getDEModel().createEntity();
            pSDynaApp2.setPSDynaAppId(pSDynaApp.getPSDynaAppId());
            pSDynaApp2.setPSAppTypeId(null);
            this.update(pSDynaApp2);
        }
    }

    public void removeByPSAppType(PSAppType pSAppType) throws Exception {
        final PSAppType pSAppType2 = pSAppType;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDynaAppServiceBase.this.onBeforeRemoveByPSAppType(pSAppType2);
                PSDynaAppServiceBase.this.internalRemoveByPSAppType(pSAppType2);
                PSDynaAppServiceBase.this.onAfterRemoveByPSAppType(pSAppType2);
            }
        });
    }

    protected void onBeforeRemoveByPSAppType(PSAppType pSAppType) throws Exception {
    }

    protected void internalRemoveByPSAppType(PSAppType pSAppType) throws Exception {
        ArrayList<PSDynaApp> arrayList = this.selectByPSAppType(pSAppType);
        this.onBeforeRemoveByPSAppType(pSAppType, arrayList);
        for (PSDynaApp pSDynaApp : arrayList) {
            this.remove(pSDynaApp);
        }
        this.onAfterRemoveByPSAppType(pSAppType, arrayList);
    }

    protected void onAfterRemoveByPSAppType(PSAppType pSAppType) throws Exception {
    }

    protected void onBeforeRemoveByPSAppType(PSAppType pSAppType, ArrayList<PSDynaApp> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSAppType(PSAppType pSAppType, ArrayList<PSDynaApp> arrayList) throws Exception {
    }

    public void testRemoveByPSDynaSys(PSDynaSys pSDynaSys) throws Exception {
        ArrayList<PSDynaApp> arrayList = this.selectByPSDynaSys(pSDynaSys, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDYNASYS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDynaSys);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDYNAAPP_PSDYNASYS_PSDYNASYSID", "", iDataEntityModel.getName(), "PSDYNAAPP", iDataEntityModel.getDataInfo(pSDynaSys), arrayList.get(0)));
        }
    }

    public void resetPSDynaSys(PSDynaSys pSDynaSys) throws Exception {
        ArrayList<PSDynaApp> arrayList = this.selectByPSDynaSys(pSDynaSys);
        for (PSDynaApp pSDynaApp : arrayList) {
            PSDynaApp pSDynaApp2 = (PSDynaApp)this.getDEModel().createEntity();
            pSDynaApp2.setPSDynaAppId(pSDynaApp.getPSDynaAppId());
            pSDynaApp2.setPSDynaSysId(null);
            this.update(pSDynaApp2);
        }
    }

    public void removeByPSDynaSys(PSDynaSys pSDynaSys) throws Exception {
        final PSDynaSys pSDynaSys2 = pSDynaSys;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDynaAppServiceBase.this.onBeforeRemoveByPSDynaSys(pSDynaSys2);
                PSDynaAppServiceBase.this.internalRemoveByPSDynaSys(pSDynaSys2);
                PSDynaAppServiceBase.this.onAfterRemoveByPSDynaSys(pSDynaSys2);
            }
        });
    }

    protected void onBeforeRemoveByPSDynaSys(PSDynaSys pSDynaSys) throws Exception {
    }

    protected void internalRemoveByPSDynaSys(PSDynaSys pSDynaSys) throws Exception {
        ArrayList<PSDynaApp> arrayList = this.selectByPSDynaSys(pSDynaSys);
        this.onBeforeRemoveByPSDynaSys(pSDynaSys, arrayList);
        for (PSDynaApp pSDynaApp : arrayList) {
            this.remove(pSDynaApp);
        }
        this.onAfterRemoveByPSDynaSys(pSDynaSys, arrayList);
    }

    protected void onAfterRemoveByPSDynaSys(PSDynaSys pSDynaSys) throws Exception {
    }

    protected void onBeforeRemoveByPSDynaSys(PSDynaSys pSDynaSys, ArrayList<PSDynaApp> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDynaSys(PSDynaSys pSDynaSys, ArrayList<PSDynaApp> arrayList) throws Exception {
    }

    public void testRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    public void resetPSSysApp(PSSysApp pSSysApp) throws Exception {
        ArrayList<PSDynaApp> arrayList = this.selectByPSSysApp(pSSysApp);
        for (PSDynaApp pSDynaApp : arrayList) {
            PSDynaApp pSDynaApp2 = (PSDynaApp)this.getDEModel().createEntity();
            pSDynaApp2.setPSDynaAppId(pSDynaApp.getPSDynaAppId());
            pSDynaApp2.setPSSysAppId(null);
            this.update(pSDynaApp2);
        }
    }

    public void removeByPSSysApp(PSSysApp pSSysApp) throws Exception {
        final PSSysApp pSSysApp2 = pSSysApp;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDynaAppServiceBase.this.onBeforeRemoveByPSSysApp(pSSysApp2);
                PSDynaAppServiceBase.this.internalRemoveByPSSysApp(pSSysApp2);
                PSDynaAppServiceBase.this.onAfterRemoveByPSSysApp(pSSysApp2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    protected void internalRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
        ArrayList<PSDynaApp> arrayList = this.selectByPSSysApp(pSSysApp);
        this.onBeforeRemoveByPSSysApp(pSSysApp, arrayList);
        for (PSDynaApp pSDynaApp : arrayList) {
            this.remove(pSDynaApp);
        }
        this.onAfterRemoveByPSSysApp(pSSysApp, arrayList);
    }

    protected void onAfterRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    protected void onBeforeRemoveByPSSysApp(PSSysApp pSSysApp, ArrayList<PSDynaApp> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysApp(PSSysApp pSSysApp, ArrayList<PSDynaApp> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDynaApp pSDynaApp) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSAppFuncService)ServiceGlobal.getService(PSAppFuncService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppFuncServiceBase)pSCoreSysServiceBase).testRemoveByPSDynaApp(pSDynaApp);
        pSCoreSysServiceBase = (PSAppMenuService)ServiceGlobal.getService(PSAppMenuService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppMenuServiceBase)pSCoreSysServiceBase).testRemoveByPSDynaApp(pSDynaApp);
        pSCoreSysServiceBase = (PSDynaAppViewInstService)ServiceGlobal.getService(PSDynaAppViewInstService.class, (SessionFactory)this.getSessionFactory());
        ((PSDynaAppViewInstServiceBase)pSCoreSysServiceBase).testRemoveByPSDynaApp(pSDynaApp);
        ((PSDynaAppViewInstServiceBase)pSCoreSysServiceBase).removeByPSDynaApp(pSDynaApp);
        pSCoreSysServiceBase = (PSDynaAppViewService)ServiceGlobal.getService(PSDynaAppViewService.class, (SessionFactory)this.getSessionFactory());
        ((PSDynaAppViewServiceBase)pSCoreSysServiceBase).testRemoveByPSDynaApp(pSDynaApp);
        ((PSDynaAppViewServiceBase)pSCoreSysServiceBase).removeByPSDynaApp(pSDynaApp);
        super.onBeforeRemove(pSDynaApp);
    }

    protected void replaceParentInfo(PSDynaApp pSDynaApp, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDynaApp, cloneSession);
        if (pSDynaApp.getPSAppTypeId() != null && (iEntity = cloneSession.getEntity("PSAPPTYPE", (Object)pSDynaApp.getPSAppTypeId())) != null) {
            this.onFillParentInfo_PSAppType(pSDynaApp, (PSAppType)iEntity);
        }
        if (pSDynaApp.getPSDynaSysId() != null && (iEntity = cloneSession.getEntity("PSDYNASYS", (Object)pSDynaApp.getPSDynaSysId())) != null) {
            this.onFillParentInfo_PSDynaSys(pSDynaApp, (PSDynaSys)iEntity);
        }
        if (pSDynaApp.getPSSysAppId() != null && (iEntity = cloneSession.getEntity("PSSYSAPP", (Object)pSDynaApp.getPSSysAppId())) != null) {
            this.onFillParentInfo_PSSysApp(pSDynaApp, (PSSysApp)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDynaApp pSDynaApp, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDynaApp, bl);
    }

    protected void onCheckEntity(boolean bl, PSDynaApp pSDynaApp, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_LogicName(bl, pSDynaApp, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDynaApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppTypeId(bl, pSDynaApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppTypeName(bl, pSDynaApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaAppId(bl, pSDynaApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaAppName(bl, pSDynaApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaSysId(bl, pSDynaApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysAppId(bl, pSDynaApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysAppName(bl, pSDynaApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDynaApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDynaApp, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_LogicName(boolean bl, PSDynaApp pSDynaApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaApp.isLogicNameDirty() : !pSDynaApp.isLogicNameDirty()) {
            return null;
        }
        String string = pSDynaApp.getLogicName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogicName_Default(pSDynaApp, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDynaApp pSDynaApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaApp.isMemoDirty() : !pSDynaApp.isMemoDirty()) {
            return null;
        }
        String string = pSDynaApp.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDynaApp, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSAppTypeId(boolean bl, PSDynaApp pSDynaApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaApp.isPSAppTypeIdDirty() : !pSDynaApp.isPSAppTypeIdDirty()) {
            return null;
        }
        String string = pSDynaApp.getPSAppTypeId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppTypeId_Default(pSDynaApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPTYPEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSAppTypeName(boolean bl, PSDynaApp pSDynaApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaApp.isPSAppTypeNameDirty() : !pSDynaApp.isPSAppTypeNameDirty()) {
            return null;
        }
        String string = pSDynaApp.getPSAppTypeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppTypeName_Default(pSDynaApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPTYPENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDynaAppId(boolean bl, PSDynaApp pSDynaApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaApp.isPSDynaAppIdDirty() && !bl2 : !pSDynaApp.isPSDynaAppIdDirty()) {
            return null;
        }
        String string = pSDynaApp.getPSDynaAppId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNAAPPID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaAppId_Default(pSDynaApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNAAPPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDynaAppName(boolean bl, PSDynaApp pSDynaApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaApp.isPSDynaAppNameDirty() && !bl2 : !pSDynaApp.isPSDynaAppNameDirty()) {
            return null;
        }
        String string = pSDynaApp.getPSDynaAppName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNAAPPNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaAppName_Default(pSDynaApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNAAPPNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDynaSysId(boolean bl, PSDynaApp pSDynaApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaApp.isPSDynaSysIdDirty() && !bl2 : !pSDynaApp.isPSDynaSysIdDirty()) {
            return null;
        }
        String string = pSDynaApp.getPSDynaSysId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNASYSID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaSysId_Default(pSDynaApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNASYSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysAppId(boolean bl, PSDynaApp pSDynaApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaApp.isPSSysAppIdDirty() : !pSDynaApp.isPSSysAppIdDirty()) {
            return null;
        }
        String string = pSDynaApp.getPSSysAppId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysAppId_Default(pSDynaApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSAPPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysAppName(boolean bl, PSDynaApp pSDynaApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaApp.isPSSysAppNameDirty() : !pSDynaApp.isPSSysAppNameDirty()) {
            return null;
        }
        String string = pSDynaApp.getPSSysAppName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysAppName_Default(pSDynaApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSAPPNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDynaApp pSDynaApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaApp.isValidFlagDirty() : !pSDynaApp.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDynaApp.getValidFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSDynaApp, bl2, bl3);
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

    protected void onSyncEntity(PSDynaApp pSDynaApp, boolean bl) throws Exception {
        super.onSyncEntity(pSDynaApp, bl);
    }

    protected void onSyncIndexEntities(PSDynaApp pSDynaApp, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDynaApp, bl);
    }

    public Object getDataContextValue(PSDynaApp pSDynaApp, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDynaApp, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDynaApp pSDynaApp, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDynaApp, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPTYPEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppTypeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPTYPENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppTypeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAAPPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaAppId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAAPPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaAppName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNASYSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaSysId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNASYSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaSysName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAPPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAppId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAPPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAppName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSAppTypeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPTYPEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSAppTypeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPTYPENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDynaAppId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNAAPPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDynaAppName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNAAPPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDynaSysId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNASYSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDynaSysName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNASYSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysAppId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSAPPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysAppName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSAPPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSDynaApp pSDynaApp) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDynaApp)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDynaApp pSDynaApp) throws Exception {
        super.onUpdateParent(pSDynaApp);
    }

    @Override
    protected void exportCurXmlModel(PSDynaApp pSDynaApp, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDYNAAPP");
        if (!bl) {
            pSDynaApp.setCreateDate(null);
            pSDynaApp.setCreateMan(null);
            pSDynaApp.setPSDynaAppId(null);
            pSDynaApp.setPSDynaSysId(null);
            pSDynaApp.setPSDynaSysName(null);
            pSDynaApp.setUpdateDate(null);
            pSDynaApp.setUpdateMan(null);
            super.exportCurXmlModel(pSDynaApp, xmlNode, bl);
        }
    }
}

