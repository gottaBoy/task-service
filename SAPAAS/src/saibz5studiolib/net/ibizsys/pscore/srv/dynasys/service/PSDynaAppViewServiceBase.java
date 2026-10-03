/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.PostConstruct
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.dao.DAOGlobal
 *  net.ibizsys.paas.dao.IDAO
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
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
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
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
import net.ibizsys.pscore.srv.appdesign.entity.PSAppMenu;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppMenuBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dynasys.dao.PSDynaAppViewDAO;
import net.ibizsys.pscore.srv.dynasys.demodel.PSDynaAppViewDEModel;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaApp;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaAppBase;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaAppView;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaAppViewCtrl;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaDE;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaDEBase;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaAppViewCtrlService;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaAppViewCtrlServiceBase;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaAppViewInstService;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaAppViewInstServiceBase;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFDE;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFDEBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDynaAppViewServiceBase
extends PSCoreSysServiceBase<PSDynaAppView> {
    private static final Log log = LogFactory.getLog(PSDynaAppViewServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDynaAppViewDEModel pSDynaAppViewDEModel;
    private PSDynaAppViewDAO pSDynaAppViewDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dynasys.service.PSDynaAppViewService";
    }

    public PSDynaAppViewDEModel getPSDynaAppViewDEModel() {
        if (this.pSDynaAppViewDEModel == null) {
            try {
                this.pSDynaAppViewDEModel = (PSDynaAppViewDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dynasys.demodel.PSDynaAppViewDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDynaAppViewDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDynaAppViewDEModel();
    }

    public PSDynaAppViewDAO getPSDynaAppViewDAO() {
        if (this.pSDynaAppViewDAO == null) {
            try {
                this.pSDynaAppViewDAO = (PSDynaAppViewDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dynasys.dao.PSDynaAppViewDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDynaAppViewDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDynaAppViewDAO();
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

    protected void onFillParentInfo(PSDynaAppView pSDynaAppView, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDYNAAPPVIEW_PSAPPMENU_PSAPPMENUID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppMenuService", (SessionFactory)this.getSessionFactory());
            PSAppMenu pSAppMenu = (PSAppMenu)iService.getDEModel().createEntity();
            pSAppMenu.set("PSAPPMENUID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSAppMenu);
            } else {
                iService.get(pSAppMenu);
            }
            this.onFillParentInfo_PSAppMenu(pSDynaAppView, pSAppMenu);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDYNAAPPVIEW_PSDYNAAPP_PSDYNAAPPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dynasys.service.PSDynaAppService", (SessionFactory)this.getSessionFactory());
            PSDynaApp pSDynaApp = (PSDynaApp)iService.getDEModel().createEntity();
            pSDynaApp.set("PSDYNAAPPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDynaApp);
            } else {
                iService.get(pSDynaApp);
            }
            this.onFillParentInfo_PSDynaApp(pSDynaAppView, pSDynaApp);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDYNAAPPVIEW_PSDYNADE_PSDYNADEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dynasys.service.PSDynaDEService", (SessionFactory)this.getSessionFactory());
            PSDynaDE pSDynaDE = (PSDynaDE)iService.getDEModel().createEntity();
            pSDynaDE.set("PSDYNADEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDynaDE);
            } else {
                iService.get(pSDynaDE);
            }
            this.onFillParentInfo_PSDynaDE(pSDynaAppView, pSDynaDE);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDYNAAPPVIEW_PSWFDE_PSWFDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfdesign.service.PSWFDEService", (SessionFactory)this.getSessionFactory());
            PSWFDE pSWFDE = (PSWFDE)iService.getDEModel().createEntity();
            pSWFDE.set("PSWFDEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSWFDE);
            } else {
                iService.get(pSWFDE);
            }
            this.onFillParentInfo_PSWFDE(pSDynaAppView, pSWFDE);
            return;
        }
        super.onFillParentInfo(pSDynaAppView, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSAppMenu(PSDynaAppView pSDynaAppView, PSAppMenu pSAppMenu) throws Exception {
        pSDynaAppView.setPSAppMenuId(pSAppMenu.getPSAppMenuId());
        pSDynaAppView.setPSAppMenuName(pSAppMenu.getPSAppMenuName());
    }

    protected void onFillParentInfo_PSDynaApp(PSDynaAppView pSDynaAppView, PSDynaApp pSDynaApp) throws Exception {
        pSDynaAppView.setPSDynaAppId(pSDynaApp.getPSDynaAppId());
        pSDynaAppView.setPSDynaAppName(pSDynaApp.getPSDynaAppName());
    }

    protected void onFillParentInfo_PSDynaDE(PSDynaAppView pSDynaAppView, PSDynaDE pSDynaDE) throws Exception {
        pSDynaAppView.setPSDynaDEId(pSDynaDE.getPSDynaDEId());
        pSDynaAppView.setPSDynaDEName(pSDynaDE.getPSDynaDEName());
    }

    protected void onFillParentInfo_PSWFDE(PSDynaAppView pSDynaAppView, PSWFDE pSWFDE) throws Exception {
        pSDynaAppView.setPSWFDEId(pSWFDE.getPSWFDEId());
        pSDynaAppView.setPSWFDEName(pSWFDE.getPSWFDEName());
    }

    protected void onFillEntityFullInfo(PSDynaAppView pSDynaAppView, boolean bl) throws Exception {
        if (bl) {
            if (pSDynaAppView.getMobViewFlag() == null) {
                pSDynaAppView.setMobViewFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDynaAppView.getValidFlag() == null) {
                pSDynaAppView.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo(pSDynaAppView, bl);
        this.onFillEntityFullInfo_PSAppMenu(pSDynaAppView, bl);
        this.onFillEntityFullInfo_PSDynaApp(pSDynaAppView, bl);
        this.onFillEntityFullInfo_PSDynaDE(pSDynaAppView, bl);
        this.onFillEntityFullInfo_PSWFDE(pSDynaAppView, bl);
    }

    protected void onFillEntityFullInfo_PSAppMenu(PSDynaAppView pSDynaAppView, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDynaApp(PSDynaAppView pSDynaAppView, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDynaDE(PSDynaAppView pSDynaAppView, boolean bl) throws Exception {
        if (pSDynaAppView.isPSDynaDEIdDirty()) {
            if (pSDynaAppView.getPSDynaDEId() != null) {
                if (pSDynaAppView.getPSDynaDEId() == null || pSDynaAppView.getPSDynaDEName() == null) {
                    PSDynaDE pSDynaDE = pSDynaAppView.getPSDynaDE();
                    pSDynaAppView.setPSDynaDEName(pSDynaDE.getPSDynaDEName());
                }
            } else {
                pSDynaAppView.setPSDynaDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSWFDE(PSDynaAppView pSDynaAppView, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDynaAppView pSDynaAppView, boolean bl) throws Exception {
        super.onWriteBackParent(pSDynaAppView, bl);
    }

    public ArrayList<PSDynaAppView> selectByPSAppMenu(PSAppMenuBase pSAppMenuBase) throws Exception {
        return this.selectByPSAppMenu(pSAppMenuBase, "", -1);
    }

    public ArrayList<PSDynaAppView> selectByPSAppMenu(PSAppMenuBase pSAppMenuBase, String string) throws Exception {
        return this.selectByPSAppMenu(pSAppMenuBase, string, -1);
    }

    public ArrayList<PSDynaAppView> selectByPSAppMenu(PSAppMenuBase pSAppMenuBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSAPPMENUID", (Object)pSAppMenuBase.getPSAppMenuId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSAppMenuCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSAppMenuCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDynaAppView> selectByPSDynaApp(PSDynaAppBase pSDynaAppBase) throws Exception {
        return this.selectByPSDynaApp(pSDynaAppBase, "", -1);
    }

    public ArrayList<PSDynaAppView> selectByPSDynaApp(PSDynaAppBase pSDynaAppBase, String string) throws Exception {
        return this.selectByPSDynaApp(pSDynaAppBase, string, -1);
    }

    public ArrayList<PSDynaAppView> selectByPSDynaApp(PSDynaAppBase pSDynaAppBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDYNAAPPID", (Object)pSDynaAppBase.getPSDynaAppId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDynaAppCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDynaAppCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDynaAppView> selectByPSDynaDE(PSDynaDEBase pSDynaDEBase) throws Exception {
        return this.selectByPSDynaDE(pSDynaDEBase, "", -1);
    }

    public ArrayList<PSDynaAppView> selectByPSDynaDE(PSDynaDEBase pSDynaDEBase, String string) throws Exception {
        return this.selectByPSDynaDE(pSDynaDEBase, string, -1);
    }

    public ArrayList<PSDynaAppView> selectByPSDynaDE(PSDynaDEBase pSDynaDEBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDYNADEID", (Object)pSDynaDEBase.getPSDynaDEId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDynaDECond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDynaDECond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDynaAppView> selectByPSWFDE(PSWFDEBase pSWFDEBase) throws Exception {
        return this.selectByPSWFDE(pSWFDEBase, "", -1);
    }

    public ArrayList<PSDynaAppView> selectByPSWFDE(PSWFDEBase pSWFDEBase, String string) throws Exception {
        return this.selectByPSWFDE(pSWFDEBase, string, -1);
    }

    public ArrayList<PSDynaAppView> selectByPSWFDE(PSWFDEBase pSWFDEBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSWFDEID", (Object)pSWFDEBase.getPSWFDEId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSWFDECond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSWFDECond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSAppMenu(PSAppMenu pSAppMenu) throws Exception {
        ArrayList<PSDynaAppView> arrayList = this.selectByPSAppMenu(pSAppMenu, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSAPPMENU");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSAppMenu);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDYNAAPPVIEW_PSAPPMENU_PSAPPMENUID", "", iDataEntityModel.getName(), "PSDYNAAPPVIEW", iDataEntityModel.getDataInfo(pSAppMenu), arrayList.get(0)));
        }
    }

    public void resetPSAppMenu(PSAppMenu pSAppMenu) throws Exception {
        ArrayList<PSDynaAppView> arrayList = this.selectByPSAppMenu(pSAppMenu);
        for (PSDynaAppView pSDynaAppView : arrayList) {
            PSDynaAppView pSDynaAppView2 = (PSDynaAppView)this.getDEModel().createEntity();
            pSDynaAppView2.setPSDynaAppViewId(pSDynaAppView.getPSDynaAppViewId());
            pSDynaAppView2.setPSAppMenuId(null);
            this.update(pSDynaAppView2);
        }
    }

    public void removeByPSAppMenu(PSAppMenu pSAppMenu) throws Exception {
        final PSAppMenu pSAppMenu2 = pSAppMenu;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDynaAppViewServiceBase.this.onBeforeRemoveByPSAppMenu(pSAppMenu2);
                PSDynaAppViewServiceBase.this.internalRemoveByPSAppMenu(pSAppMenu2);
                PSDynaAppViewServiceBase.this.onAfterRemoveByPSAppMenu(pSAppMenu2);
            }
        });
    }

    protected void onBeforeRemoveByPSAppMenu(PSAppMenu pSAppMenu) throws Exception {
    }

    protected void internalRemoveByPSAppMenu(PSAppMenu pSAppMenu) throws Exception {
        ArrayList<PSDynaAppView> arrayList = this.selectByPSAppMenu(pSAppMenu);
        this.onBeforeRemoveByPSAppMenu(pSAppMenu, arrayList);
        for (PSDynaAppView pSDynaAppView : arrayList) {
            this.remove(pSDynaAppView);
        }
        this.onAfterRemoveByPSAppMenu(pSAppMenu, arrayList);
    }

    protected void onAfterRemoveByPSAppMenu(PSAppMenu pSAppMenu) throws Exception {
    }

    protected void onBeforeRemoveByPSAppMenu(PSAppMenu pSAppMenu, ArrayList<PSDynaAppView> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSAppMenu(PSAppMenu pSAppMenu, ArrayList<PSDynaAppView> arrayList) throws Exception {
    }

    public void testRemoveByPSDynaApp(PSDynaApp pSDynaApp) throws Exception {
    }

    public void resetPSDynaApp(PSDynaApp pSDynaApp) throws Exception {
        ArrayList<PSDynaAppView> arrayList = this.selectByPSDynaApp(pSDynaApp);
        for (PSDynaAppView pSDynaAppView : arrayList) {
            PSDynaAppView pSDynaAppView2 = (PSDynaAppView)this.getDEModel().createEntity();
            pSDynaAppView2.setPSDynaAppViewId(pSDynaAppView.getPSDynaAppViewId());
            pSDynaAppView2.setPSDynaAppId(null);
            this.update(pSDynaAppView2);
        }
    }

    public void removeByPSDynaApp(PSDynaApp pSDynaApp) throws Exception {
        final PSDynaApp pSDynaApp2 = pSDynaApp;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDynaAppViewServiceBase.this.onBeforeRemoveByPSDynaApp(pSDynaApp2);
                PSDynaAppViewServiceBase.this.internalRemoveByPSDynaApp(pSDynaApp2);
                PSDynaAppViewServiceBase.this.onAfterRemoveByPSDynaApp(pSDynaApp2);
            }
        });
    }

    protected void onBeforeRemoveByPSDynaApp(PSDynaApp pSDynaApp) throws Exception {
    }

    protected void internalRemoveByPSDynaApp(PSDynaApp pSDynaApp) throws Exception {
        ArrayList<PSDynaAppView> arrayList = this.selectByPSDynaApp(pSDynaApp);
        this.onBeforeRemoveByPSDynaApp(pSDynaApp, arrayList);
        for (PSDynaAppView pSDynaAppView : arrayList) {
            this.remove(pSDynaAppView);
        }
        this.onAfterRemoveByPSDynaApp(pSDynaApp, arrayList);
    }

    protected void onAfterRemoveByPSDynaApp(PSDynaApp pSDynaApp) throws Exception {
    }

    protected void onBeforeRemoveByPSDynaApp(PSDynaApp pSDynaApp, ArrayList<PSDynaAppView> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDynaApp(PSDynaApp pSDynaApp, ArrayList<PSDynaAppView> arrayList) throws Exception {
    }

    public void testRemoveByPSDynaDE(PSDynaDE pSDynaDE) throws Exception {
        ArrayList<PSDynaAppView> arrayList = this.selectByPSDynaDE(pSDynaDE, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDYNADE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDynaDE);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDYNAAPPVIEW_PSDYNADE_PSDYNADEID", "", iDataEntityModel.getName(), "PSDYNAAPPVIEW", iDataEntityModel.getDataInfo(pSDynaDE), arrayList.get(0)));
        }
    }

    public void resetPSDynaDE(PSDynaDE pSDynaDE) throws Exception {
        ArrayList<PSDynaAppView> arrayList = this.selectByPSDynaDE(pSDynaDE);
        for (PSDynaAppView pSDynaAppView : arrayList) {
            PSDynaAppView pSDynaAppView2 = (PSDynaAppView)this.getDEModel().createEntity();
            pSDynaAppView2.setPSDynaAppViewId(pSDynaAppView.getPSDynaAppViewId());
            pSDynaAppView2.setPSDynaDEId(null);
            this.update(pSDynaAppView2);
        }
    }

    public void removeByPSDynaDE(PSDynaDE pSDynaDE) throws Exception {
        final PSDynaDE pSDynaDE2 = pSDynaDE;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDynaAppViewServiceBase.this.onBeforeRemoveByPSDynaDE(pSDynaDE2);
                PSDynaAppViewServiceBase.this.internalRemoveByPSDynaDE(pSDynaDE2);
                PSDynaAppViewServiceBase.this.onAfterRemoveByPSDynaDE(pSDynaDE2);
            }
        });
    }

    protected void onBeforeRemoveByPSDynaDE(PSDynaDE pSDynaDE) throws Exception {
    }

    protected void internalRemoveByPSDynaDE(PSDynaDE pSDynaDE) throws Exception {
        ArrayList<PSDynaAppView> arrayList = this.selectByPSDynaDE(pSDynaDE);
        this.onBeforeRemoveByPSDynaDE(pSDynaDE, arrayList);
        for (PSDynaAppView pSDynaAppView : arrayList) {
            this.remove(pSDynaAppView);
        }
        this.onAfterRemoveByPSDynaDE(pSDynaDE, arrayList);
    }

    protected void onAfterRemoveByPSDynaDE(PSDynaDE pSDynaDE) throws Exception {
    }

    protected void onBeforeRemoveByPSDynaDE(PSDynaDE pSDynaDE, ArrayList<PSDynaAppView> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDynaDE(PSDynaDE pSDynaDE, ArrayList<PSDynaAppView> arrayList) throws Exception {
    }

    public void testRemoveByPSWFDE(PSWFDE pSWFDE) throws Exception {
        ArrayList<PSDynaAppView> arrayList = this.selectByPSWFDE(pSWFDE, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSWFDE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSWFDE);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDYNAAPPVIEW_PSWFDE_PSWFDEID", "", iDataEntityModel.getName(), "PSDYNAAPPVIEW", iDataEntityModel.getDataInfo(pSWFDE), arrayList.get(0)));
        }
    }

    public void resetPSWFDE(PSWFDE pSWFDE) throws Exception {
        ArrayList<PSDynaAppView> arrayList = this.selectByPSWFDE(pSWFDE);
        for (PSDynaAppView pSDynaAppView : arrayList) {
            PSDynaAppView pSDynaAppView2 = (PSDynaAppView)this.getDEModel().createEntity();
            pSDynaAppView2.setPSDynaAppViewId(pSDynaAppView.getPSDynaAppViewId());
            pSDynaAppView2.setPSWFDEId(null);
            this.update(pSDynaAppView2);
        }
    }

    public void removeByPSWFDE(PSWFDE pSWFDE) throws Exception {
        final PSWFDE pSWFDE2 = pSWFDE;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDynaAppViewServiceBase.this.onBeforeRemoveByPSWFDE(pSWFDE2);
                PSDynaAppViewServiceBase.this.internalRemoveByPSWFDE(pSWFDE2);
                PSDynaAppViewServiceBase.this.onAfterRemoveByPSWFDE(pSWFDE2);
            }
        });
    }

    protected void onBeforeRemoveByPSWFDE(PSWFDE pSWFDE) throws Exception {
    }

    protected void internalRemoveByPSWFDE(PSWFDE pSWFDE) throws Exception {
        ArrayList<PSDynaAppView> arrayList = this.selectByPSWFDE(pSWFDE);
        this.onBeforeRemoveByPSWFDE(pSWFDE, arrayList);
        for (PSDynaAppView pSDynaAppView : arrayList) {
            this.remove(pSDynaAppView);
        }
        this.onAfterRemoveByPSWFDE(pSWFDE, arrayList);
    }

    protected void onAfterRemoveByPSWFDE(PSWFDE pSWFDE) throws Exception {
    }

    protected void onBeforeRemoveByPSWFDE(PSWFDE pSWFDE, ArrayList<PSDynaAppView> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSWFDE(PSWFDE pSWFDE, ArrayList<PSDynaAppView> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDynaAppView pSDynaAppView) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDynaAppViewCtrlService)ServiceGlobal.getService(PSDynaAppViewCtrlService.class, (SessionFactory)this.getSessionFactory());
        ((PSDynaAppViewCtrlServiceBase)pSCoreSysServiceBase).testRemoveByPSDynaAppView(pSDynaAppView);
        ((PSDynaAppViewCtrlServiceBase)pSCoreSysServiceBase).removeByPSDynaAppView(pSDynaAppView);
        pSCoreSysServiceBase = (PSDynaAppViewInstService)ServiceGlobal.getService(PSDynaAppViewInstService.class, (SessionFactory)this.getSessionFactory());
        ((PSDynaAppViewInstServiceBase)pSCoreSysServiceBase).testRemoveByPSDynaAppView(pSDynaAppView);
        super.onBeforeRemove(pSDynaAppView);
    }

    protected void replaceParentInfo(PSDynaAppView pSDynaAppView, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDynaAppView, cloneSession);
        if (pSDynaAppView.getPSAppMenuId() != null && (iEntity = cloneSession.getEntity("PSAPPMENU", (Object)pSDynaAppView.getPSAppMenuId())) != null) {
            this.onFillParentInfo_PSAppMenu(pSDynaAppView, (PSAppMenu)iEntity);
        }
        if (pSDynaAppView.getPSDynaAppId() != null && (iEntity = cloneSession.getEntity("PSDYNAAPP", (Object)pSDynaAppView.getPSDynaAppId())) != null) {
            this.onFillParentInfo_PSDynaApp(pSDynaAppView, (PSDynaApp)iEntity);
        }
        if (pSDynaAppView.getPSDynaDEId() != null && (iEntity = cloneSession.getEntity("PSDYNADE", (Object)pSDynaAppView.getPSDynaDEId())) != null) {
            this.onFillParentInfo_PSDynaDE(pSDynaAppView, (PSDynaDE)iEntity);
        }
        if (pSDynaAppView.getPSWFDEId() != null && (iEntity = cloneSession.getEntity("PSWFDE", (Object)pSDynaAppView.getPSWFDEId())) != null) {
            this.onFillParentInfo_PSWFDE(pSDynaAppView, (PSWFDE)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDynaAppView pSDynaAppView, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDynaAppView, bl);
    }

    protected void onCheckEntity(boolean bl, PSDynaAppView pSDynaAppView, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Caption(bl, pSDynaAppView, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableViewActions(bl, pSDynaAppView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDynaAppView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MobViewFlag(bl, pSDynaAppView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PDVTParam(bl, pSDynaAppView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PredefinedViewType(bl, pSDynaAppView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppMenuId(bl, pSDynaAppView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaAppId(bl, pSDynaAppView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaAppViewId(bl, pSDynaAppView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaAppViewName(bl, pSDynaAppView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaDEId(bl, pSDynaAppView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaDEName(bl, pSDynaAppView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWFDEId(bl, pSDynaAppView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Title(bl, pSDynaAppView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDynaAppView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ViewActions(bl, pSDynaAppView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ViewType(bl, pSDynaAppView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDynaAppView, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Caption(boolean bl, PSDynaAppView pSDynaAppView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaAppView.isCaptionDirty() : !pSDynaAppView.isCaptionDirty()) {
            return null;
        }
        String string = pSDynaAppView.getCaption();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Caption_Default(pSDynaAppView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CAPTION");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableViewActions(boolean bl, PSDynaAppView pSDynaAppView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaAppView.isEnableViewActionsDirty() : !pSDynaAppView.isEnableViewActionsDirty()) {
            return null;
        }
        Integer n = pSDynaAppView.getEnableViewActions();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableViewActions_Default(pSDynaAppView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEVIEWACTIONS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDynaAppView pSDynaAppView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaAppView.isMemoDirty() : !pSDynaAppView.isMemoDirty()) {
            return null;
        }
        String string = pSDynaAppView.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDynaAppView, bl2, bl3);
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

    protected EntityFieldError onCheckField_MobViewFlag(boolean bl, PSDynaAppView pSDynaAppView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaAppView.isMobViewFlagDirty() : !pSDynaAppView.isMobViewFlagDirty()) {
            return null;
        }
        Integer n = pSDynaAppView.getMobViewFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_MobViewFlag_Default(pSDynaAppView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MOBVIEWFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PDVTParam(boolean bl, PSDynaAppView pSDynaAppView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaAppView.isPDVTParamDirty() : !pSDynaAppView.isPDVTParamDirty()) {
            return null;
        }
        String string = pSDynaAppView.getPDVTParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PDVTParam_Default(pSDynaAppView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PDVTPARAM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PredefinedViewType(boolean bl, PSDynaAppView pSDynaAppView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaAppView.isPredefinedViewTypeDirty() : !pSDynaAppView.isPredefinedViewTypeDirty()) {
            return null;
        }
        String string = pSDynaAppView.getPredefinedViewType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PredefinedViewType_Default(pSDynaAppView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PREDEFINEDVIEWTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSAppMenuId(boolean bl, PSDynaAppView pSDynaAppView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaAppView.isPSAppMenuIdDirty() : !pSDynaAppView.isPSAppMenuIdDirty()) {
            return null;
        }
        String string = pSDynaAppView.getPSAppMenuId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppMenuId_Default(pSDynaAppView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPMENUID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDynaAppId(boolean bl, PSDynaAppView pSDynaAppView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaAppView.isPSDynaAppIdDirty() && !bl2 : !pSDynaAppView.isPSDynaAppIdDirty()) {
            return null;
        }
        String string = pSDynaAppView.getPSDynaAppId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNAAPPID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaAppId_Default(pSDynaAppView, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDynaAppViewId(boolean bl, PSDynaAppView pSDynaAppView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaAppView.isPSDynaAppViewIdDirty() && !bl2 : !pSDynaAppView.isPSDynaAppViewIdDirty()) {
            return null;
        }
        String string = pSDynaAppView.getPSDynaAppViewId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNAAPPVIEWID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaAppViewId_Default(pSDynaAppView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNAAPPVIEWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDynaAppViewName(boolean bl, PSDynaAppView pSDynaAppView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaAppView.isPSDynaAppViewNameDirty() && !bl2 : !pSDynaAppView.isPSDynaAppViewNameDirty()) {
            return null;
        }
        String string = pSDynaAppView.getPSDynaAppViewName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNAAPPVIEWNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaAppViewName_Default(pSDynaAppView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNAAPPVIEWNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDynaDEId(boolean bl, PSDynaAppView pSDynaAppView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaAppView.isPSDynaDEIdDirty() : !pSDynaAppView.isPSDynaDEIdDirty()) {
            return null;
        }
        String string = pSDynaAppView.getPSDynaDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaDEId_Default(pSDynaAppView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNADEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDynaDEName(boolean bl, PSDynaAppView pSDynaAppView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaAppView.isPSDynaDENameDirty() : !pSDynaAppView.isPSDynaDENameDirty()) {
            return null;
        }
        String string = pSDynaAppView.getPSDynaDEName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaDEName_Default(pSDynaAppView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNADENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWFDEId(boolean bl, PSDynaAppView pSDynaAppView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaAppView.isPSWFDEIdDirty() : !pSDynaAppView.isPSWFDEIdDirty()) {
            return null;
        }
        String string = pSDynaAppView.getPSWFDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWFDEId_Default(pSDynaAppView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWFDEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Title(boolean bl, PSDynaAppView pSDynaAppView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaAppView.isTitleDirty() : !pSDynaAppView.isTitleDirty()) {
            return null;
        }
        String string = pSDynaAppView.getTitle();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Title_Default(pSDynaAppView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TITLE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDynaAppView pSDynaAppView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaAppView.isValidFlagDirty() && !bl2 : !pSDynaAppView.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDynaAppView.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSDynaAppView, bl2, bl3);
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

    protected EntityFieldError onCheckField_ViewActions(boolean bl, PSDynaAppView pSDynaAppView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaAppView.isViewActionsDirty() : !pSDynaAppView.isViewActionsDirty()) {
            return null;
        }
        Integer n = pSDynaAppView.getViewActions();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ViewActions_Default(pSDynaAppView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VIEWACTIONS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ViewType(boolean bl, PSDynaAppView pSDynaAppView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaAppView.isViewTypeDirty() && !bl2 : !pSDynaAppView.isViewTypeDirty()) {
            return null;
        }
        String string = pSDynaAppView.getViewType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VIEWTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_ViewType_Default(pSDynaAppView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VIEWTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDynaAppView pSDynaAppView, boolean bl) throws Exception {
        super.onSyncEntity(pSDynaAppView, bl);
    }

    protected void onSyncIndexEntities(PSDynaAppView pSDynaAppView, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDynaAppView, bl);
    }

    public Object getDataContextValue(PSDynaAppView pSDynaAppView, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDynaAppView, string, iDataContextParam)) != null) {
            return object;
        }
        PSDynaApp pSDynaApp = pSDynaAppView.getPSDynaApp();
        if (pSDynaApp != null && pSDynaApp.contains(string)) {
            return pSDynaApp.get(string);
        }
        return null;
    }

    protected void onExportRelatedModel(PSDynaAppView pSDynaAppView, ArrayList<JSONObject> arrayList, int n) throws Exception {
        this.onExportRelatedModel_PSDynaAppViewCtrl_PSDynaAppView(pSDynaAppView, arrayList, n);
        super.onExportRelatedModel(pSDynaAppView, arrayList, n);
    }

    protected void onExportRelatedModel_PSDynaAppViewCtrl_PSDynaAppView(PSDynaAppView pSDynaAppView, ArrayList<JSONObject> arrayList, int n) throws Exception {
        PSDynaAppViewCtrlService pSDynaAppViewCtrlService = (PSDynaAppViewCtrlService)ServiceGlobal.getService(PSDynaAppViewCtrlService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDynaAppViewCtrl> arrayList2 = pSDynaAppViewCtrlService.selectByPSDynaAppView(pSDynaAppView);
        for (PSDynaAppViewCtrl pSDynaAppViewCtrl : arrayList2) {
            if (DataObject.getIntegerValue((IDataObject)pSDynaAppViewCtrl, (String)"srfsyspub", (int)1) == 0) continue;
            pSDynaAppViewCtrlService.exportModel(pSDynaAppViewCtrl, arrayList, n);
        }
    }

    protected void onExportMajorModel(PSDynaAppView pSDynaAppView, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDynaAppView, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CAPTION", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Caption_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEVIEWACTIONS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableViewActions_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MOBVIEWFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MobViewFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PDVTPARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PDVTParam_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PREDEFINEDVIEWTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PredefinedViewType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPMENUID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppMenuId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPMENUNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppMenuName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAAPPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaAppId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAAPPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaAppName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAAPPVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaAppViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAAPPVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaAppViewName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNADEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNADENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWFDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWFDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TITLE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Title_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"VIEWACTIONS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ViewActions_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VIEWTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ViewType_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_Caption_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CAPTION", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_EnableViewActions_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_MobViewFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PDVTParam_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PDVTPARAM", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PredefinedViewType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PREDEFINEDVIEWTYPE", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSAppMenuId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPMENUID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSAppMenuName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPMENUNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSDynaAppViewId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNAAPPVIEWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDynaAppViewName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNAAPPVIEWNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDynaDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNADEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDynaDEName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNADENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWFDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWFDEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWFDEName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWFDENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Title_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TITLE", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_ViewActions_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ViewType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VIEWTYPE", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected boolean onMergeChild(String string, String string2, PSDynaAppView pSDynaAppView) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDynaAppView)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDynaAppView pSDynaAppView) throws Exception {
        super.onUpdateParent(pSDynaAppView);
    }

    @Override
    protected void exportCurXmlModel(PSDynaAppView pSDynaAppView, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDYNAAPPVIEW");
        if (!bl) {
            pSDynaAppView.setCreateDate(null);
            pSDynaAppView.setCreateMan(null);
            pSDynaAppView.setPSDynaAppId(null);
            pSDynaAppView.setPSDynaAppName(null);
            pSDynaAppView.setPSDynaAppViewId(null);
            pSDynaAppView.setPSDynaDEId(null);
            pSDynaAppView.setPSDynaDEName(null);
            pSDynaAppView.setUpdateDate(null);
            pSDynaAppView.setUpdateMan(null);
            pSDynaAppView.setViewType(null);
            super.exportCurXmlModel(pSDynaAppView, xmlNode, bl);
        }
    }

    @Override
    public Object getDataType(PSDynaAppView pSDynaAppView) throws Exception {
        return pSDynaAppView.getViewType();
    }
}

