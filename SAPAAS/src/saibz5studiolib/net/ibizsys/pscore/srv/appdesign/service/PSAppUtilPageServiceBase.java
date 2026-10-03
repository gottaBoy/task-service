/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
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
 *  net.ibizsys.paas.entity.SimpleEntity
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
package net.ibizsys.pscore.srv.appdesign.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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
import net.ibizsys.paas.entity.SimpleEntity;
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
import net.ibizsys.pscore.srv.appdesign.dao.PSAppUtilPageDAO;
import net.ibizsys.pscore.srv.appdesign.demodel.PSAppUtilPageDEModel;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppUtilPage;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppView;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppViewBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysAppBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanelBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSAppUtilPageServiceBase
extends PSCoreSysServiceBase<PSAppUtilPage> {
    private static final Log log = LogFactory.getLog(PSAppUtilPageServiceBase.class);
    public static final String DATASET_CURAPP = "CurApp";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private static Map<String, String> defaultValueMap = new HashMap<String, String>();
    private PSAppUtilPageDEModel pSAppUtilPageDEModel;
    private PSAppUtilPageDAO pSAppUtilPageDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.appdesign.service.PSAppUtilPageService";
    }

    public PSAppUtilPageDEModel getPSAppUtilPageDEModel() {
        if (this.pSAppUtilPageDEModel == null) {
            try {
                this.pSAppUtilPageDEModel = (PSAppUtilPageDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.appdesign.demodel.PSAppUtilPageDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSAppUtilPageDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSAppUtilPageDEModel();
    }

    public PSAppUtilPageDAO getPSAppUtilPageDAO() {
        if (this.pSAppUtilPageDAO == null) {
            try {
                this.pSAppUtilPageDAO = (PSAppUtilPageDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.appdesign.dao.PSAppUtilPageDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSAppUtilPageDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSAppUtilPageDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURAPP, (boolean)true) == 0) {
            return this.fetchCurApp(iDEDataSetFetchContext);
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

    public DBFetchResult fetchCurApp(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURAPP, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSAppUtilPage pSAppUtilPage, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPUTILPAGE_PSAPPVIEW_PSAPPVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppViewService", (SessionFactory)this.getSessionFactory());
            PSAppView pSAppView = (PSAppView)iService.getDEModel().createEntity();
            pSAppView.set("PSAPPVIEWID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSAppView);
            } else {
                iService.get(pSAppView);
            }
            this.onFillParentInfo_PSAppView(pSAppUtilPage, pSAppView);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPUTILPAGE_PSSYSAPP_PSSYSAPPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService", (SessionFactory)this.getSessionFactory());
            PSSysApp pSSysApp = (PSSysApp)iService.getDEModel().createEntity();
            pSSysApp.set("PSSYSAPPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysApp);
            } else {
                iService.get(pSSysApp);
            }
            this.onFillParentInfo_PSSysApp(pSAppUtilPage, pSSysApp);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPUTILPAGE_PSSYSVIEWPANEL_PSSYSVIEWPANELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelService", (SessionFactory)this.getSessionFactory());
            PSSysViewPanel pSSysViewPanel = (PSSysViewPanel)iService.getDEModel().createEntity();
            pSSysViewPanel.set("PSSYSVIEWPANELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysViewPanel);
            } else {
                iService.get(pSSysViewPanel);
            }
            this.onFillParentInfo_PSSysViewPanel(pSAppUtilPage, pSSysViewPanel);
            return;
        }
        super.onFillParentInfo(pSAppUtilPage, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSAppView(PSAppUtilPage pSAppUtilPage, PSAppView pSAppView) throws Exception {
        pSAppUtilPage.setPSAppViewId(pSAppView.getPSAppViewId());
        pSAppUtilPage.setPSAppViewName(pSAppView.getPSAppViewName());
    }

    protected void onFillParentInfo_PSSysApp(PSAppUtilPage pSAppUtilPage, PSSysApp pSSysApp) throws Exception {
        pSAppUtilPage.setPSSysAppId(pSSysApp.getPSSysAppId());
        pSAppUtilPage.setPSSysAppName(pSSysApp.getPSSysAppName());
    }

    protected void onFillParentInfo_PSSysViewPanel(PSAppUtilPage pSAppUtilPage, PSSysViewPanel pSSysViewPanel) throws Exception {
        pSAppUtilPage.setPSSysViewPanelId(pSSysViewPanel.getPSSysViewPanelId());
        pSAppUtilPage.setPSSysViewPanelName(pSSysViewPanel.getPSSysViewPanelName());
    }

    protected void onFillEntityFullInfo(PSAppUtilPage pSAppUtilPage, boolean bl) throws Exception {
        if (bl && pSAppUtilPage.getCodeName() == null) {
            pSAppUtilPage.setCodeName((String)this.getDefaultValue(this.getWebContext(), "USER", "AppUtilPage", 25));
        }
        super.onFillEntityFullInfo(pSAppUtilPage, bl);
        this.onFillEntityFullInfo_PSAppView(pSAppUtilPage, bl);
        this.onFillEntityFullInfo_PSSysApp(pSAppUtilPage, bl);
        this.onFillEntityFullInfo_PSSysViewPanel(pSAppUtilPage, bl);
    }

    protected void onFillEntityFullInfo_PSAppView(PSAppUtilPage pSAppUtilPage, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysApp(PSAppUtilPage pSAppUtilPage, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysViewPanel(PSAppUtilPage pSAppUtilPage, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSAppUtilPage pSAppUtilPage, boolean bl) throws Exception {
        super.onWriteBackParent(pSAppUtilPage, bl);
    }

    public ArrayList<PSAppUtilPage> selectByPSAppView(PSAppViewBase pSAppViewBase) throws Exception {
        return this.selectByPSAppView(pSAppViewBase, "", -1);
    }

    public ArrayList<PSAppUtilPage> selectByPSAppView(PSAppViewBase pSAppViewBase, String string) throws Exception {
        return this.selectByPSAppView(pSAppViewBase, string, -1);
    }

    public ArrayList<PSAppUtilPage> selectByPSAppView(PSAppViewBase pSAppViewBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSAPPVIEWID", (Object)pSAppViewBase.getPSAppViewId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSAppViewCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSAppViewCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSAppUtilPage> selectByPSSysApp(PSSysAppBase pSSysAppBase) throws Exception {
        return this.selectByPSSysApp(pSSysAppBase, "", -1);
    }

    public ArrayList<PSAppUtilPage> selectByPSSysApp(PSSysAppBase pSSysAppBase, String string) throws Exception {
        return this.selectByPSSysApp(pSSysAppBase, string, -1);
    }

    public ArrayList<PSAppUtilPage> selectByPSSysApp(PSSysAppBase pSSysAppBase, String string, int n) throws Exception {
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

    public ArrayList<PSAppUtilPage> selectByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase) throws Exception {
        return this.selectByPSSysViewPanel(pSSysViewPanelBase, "", -1);
    }

    public ArrayList<PSAppUtilPage> selectByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase, String string) throws Exception {
        return this.selectByPSSysViewPanel(pSSysViewPanelBase, string, -1);
    }

    public ArrayList<PSAppUtilPage> selectByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSVIEWPANELID", (Object)pSSysViewPanelBase.getPSSysViewPanelId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysViewPanelCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysViewPanelCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSAppView(PSAppView pSAppView) throws Exception {
        ArrayList<PSAppUtilPage> arrayList = this.selectByPSAppView(pSAppView, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSAPPVIEW");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSAppView);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPUTILPAGE_PSAPPVIEW_PSAPPVIEWID", "", iDataEntityModel.getName(), "PSAPPUTILPAGE", iDataEntityModel.getDataInfo(pSAppView), arrayList.get(0)));
        }
    }

    public void resetPSAppView(PSAppView pSAppView) throws Exception {
        ArrayList<PSAppUtilPage> arrayList = this.selectByPSAppView(pSAppView);
        for (PSAppUtilPage pSAppUtilPage : arrayList) {
            PSAppUtilPage pSAppUtilPage2 = (PSAppUtilPage)this.getDEModel().createEntity();
            pSAppUtilPage2.setPSAppUtilPageId(pSAppUtilPage.getPSAppUtilPageId());
            pSAppUtilPage2.setPSAppViewId(null);
            this.update(pSAppUtilPage2);
        }
    }

    public void removeByPSAppView(PSAppView pSAppView) throws Exception {
        final PSAppView pSAppView2 = pSAppView;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppUtilPageServiceBase.this.onBeforeRemoveByPSAppView(pSAppView2);
                PSAppUtilPageServiceBase.this.internalRemoveByPSAppView(pSAppView2);
                PSAppUtilPageServiceBase.this.onAfterRemoveByPSAppView(pSAppView2);
            }
        });
    }

    protected void onBeforeRemoveByPSAppView(PSAppView pSAppView) throws Exception {
    }

    protected void internalRemoveByPSAppView(PSAppView pSAppView) throws Exception {
        ArrayList<PSAppUtilPage> arrayList = this.selectByPSAppView(pSAppView);
        this.onBeforeRemoveByPSAppView(pSAppView, arrayList);
        for (PSAppUtilPage pSAppUtilPage : arrayList) {
            this.remove(pSAppUtilPage);
        }
        this.onAfterRemoveByPSAppView(pSAppView, arrayList);
    }

    protected void onAfterRemoveByPSAppView(PSAppView pSAppView) throws Exception {
    }

    protected void onBeforeRemoveByPSAppView(PSAppView pSAppView, ArrayList<PSAppUtilPage> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSAppView(PSAppView pSAppView, ArrayList<PSAppUtilPage> arrayList) throws Exception {
    }

    public void testRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    public void resetPSSysApp(PSSysApp pSSysApp) throws Exception {
        ArrayList<PSAppUtilPage> arrayList = this.selectByPSSysApp(pSSysApp);
        for (PSAppUtilPage pSAppUtilPage : arrayList) {
            PSAppUtilPage pSAppUtilPage2 = (PSAppUtilPage)this.getDEModel().createEntity();
            pSAppUtilPage2.setPSAppUtilPageId(pSAppUtilPage.getPSAppUtilPageId());
            pSAppUtilPage2.setPSSysAppId(null);
            this.update(pSAppUtilPage2);
        }
    }

    public void removeByPSSysApp(PSSysApp pSSysApp) throws Exception {
        final PSSysApp pSSysApp2 = pSSysApp;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppUtilPageServiceBase.this.onBeforeRemoveByPSSysApp(pSSysApp2);
                PSAppUtilPageServiceBase.this.internalRemoveByPSSysApp(pSSysApp2);
                PSAppUtilPageServiceBase.this.onAfterRemoveByPSSysApp(pSSysApp2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    protected void internalRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
        ArrayList<PSAppUtilPage> arrayList = this.selectByPSSysApp(pSSysApp);
        this.onBeforeRemoveByPSSysApp(pSSysApp, arrayList);
        for (PSAppUtilPage pSAppUtilPage : arrayList) {
            this.remove(pSAppUtilPage);
        }
        this.onAfterRemoveByPSSysApp(pSSysApp, arrayList);
    }

    protected void onAfterRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    protected void onBeforeRemoveByPSSysApp(PSSysApp pSSysApp, ArrayList<PSAppUtilPage> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysApp(PSSysApp pSSysApp, ArrayList<PSAppUtilPage> arrayList) throws Exception {
    }

    public void testRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSAppUtilPage> arrayList = this.selectByPSSysViewPanel(pSSysViewPanel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSVIEWPANEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysViewPanel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPUTILPAGE_PSSYSVIEWPANEL_PSSYSVIEWPANELID", "", iDataEntityModel.getName(), "PSAPPUTILPAGE", iDataEntityModel.getDataInfo(pSSysViewPanel), arrayList.get(0)));
        }
    }

    public void resetPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSAppUtilPage> arrayList = this.selectByPSSysViewPanel(pSSysViewPanel);
        for (PSAppUtilPage pSAppUtilPage : arrayList) {
            PSAppUtilPage pSAppUtilPage2 = (PSAppUtilPage)this.getDEModel().createEntity();
            pSAppUtilPage2.setPSAppUtilPageId(pSAppUtilPage.getPSAppUtilPageId());
            pSAppUtilPage2.setPSSysViewPanelId(null);
            this.update(pSAppUtilPage2);
        }
    }

    public void removeByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        final PSSysViewPanel pSSysViewPanel2 = pSSysViewPanel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppUtilPageServiceBase.this.onBeforeRemoveByPSSysViewPanel(pSSysViewPanel2);
                PSAppUtilPageServiceBase.this.internalRemoveByPSSysViewPanel(pSSysViewPanel2);
                PSAppUtilPageServiceBase.this.onAfterRemoveByPSSysViewPanel(pSSysViewPanel2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
    }

    protected void internalRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSAppUtilPage> arrayList = this.selectByPSSysViewPanel(pSSysViewPanel);
        this.onBeforeRemoveByPSSysViewPanel(pSSysViewPanel, arrayList);
        for (PSAppUtilPage pSAppUtilPage : arrayList) {
            this.remove(pSAppUtilPage);
        }
        this.onAfterRemoveByPSSysViewPanel(pSSysViewPanel, arrayList);
    }

    protected void onAfterRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
    }

    protected void onBeforeRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel, ArrayList<PSAppUtilPage> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel, ArrayList<PSAppUtilPage> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSAppUtilPage pSAppUtilPage) throws Exception {
        super.onBeforeRemove(pSAppUtilPage);
    }

    protected void replaceParentInfo(PSAppUtilPage pSAppUtilPage, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSAppUtilPage, cloneSession);
        if (pSAppUtilPage.getPSAppViewId() != null && (iEntity = cloneSession.getEntity("PSAPPVIEW", (Object)pSAppUtilPage.getPSAppViewId())) != null) {
            this.onFillParentInfo_PSAppView(pSAppUtilPage, (PSAppView)iEntity);
        }
        if (pSAppUtilPage.getPSSysAppId() != null && (iEntity = cloneSession.getEntity("PSSYSAPP", (Object)pSAppUtilPage.getPSSysAppId())) != null) {
            this.onFillParentInfo_PSSysApp(pSAppUtilPage, (PSSysApp)iEntity);
        }
        if (pSAppUtilPage.getPSSysViewPanelId() != null && (iEntity = cloneSession.getEntity("PSSYSVIEWPANEL", (Object)pSAppUtilPage.getPSSysViewPanelId())) != null) {
            this.onFillParentInfo_PSSysViewPanel(pSAppUtilPage, (PSSysViewPanel)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSAppUtilPage pSAppUtilPage, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSAppUtilPage, bl);
    }

    protected void onCheckEntity(boolean bl, PSAppUtilPage pSAppUtilPage, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CodeName(bl, pSAppUtilPage, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSAppUtilPage, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PageUrl(bl, pSAppUtilPage, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppUtilPageId(bl, pSAppUtilPage, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppUtilPageName(bl, pSAppUtilPage, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppViewId(bl, pSAppUtilPage, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysAppId(bl, pSAppUtilPage, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysViewPanelId(bl, pSAppUtilPage, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TargetType(bl, pSAppUtilPage, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSAppUtilPage, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSAppUtilPage, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSAppUtilPage, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSAppUtilPage, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSAppUtilPage, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilParams(bl, pSAppUtilPage, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilTag(bl, pSAppUtilPage, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilType(bl, pSAppUtilPage, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSAppUtilPage, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSAppUtilPage pSAppUtilPage, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppUtilPage.isCodeNameDirty() : !pSAppUtilPage.isCodeNameDirty()) {
            return null;
        }
        String string = pSAppUtilPage.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSAppUtilPage, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (string == null) {
                bl4 = false;
            }
            if (bl4) {
                String string3 = "";
                string3 = "PSSYSAPPID";
                String string4 = this.checkFieldDupRule(this.getPSAppUtilPageDEModel(), "CODENAME", string3, pSAppUtilPage, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("CODENAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSAppUtilPage pSAppUtilPage, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppUtilPage.isMemoDirty() : !pSAppUtilPage.isMemoDirty()) {
            return null;
        }
        String string = pSAppUtilPage.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSAppUtilPage, bl2, bl3);
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

    protected EntityFieldError onCheckField_PageUrl(boolean bl, PSAppUtilPage pSAppUtilPage, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppUtilPage.isPageUrlDirty() : !pSAppUtilPage.isPageUrlDirty()) {
            return null;
        }
        String string = pSAppUtilPage.getPageUrl();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PageUrl_Default(pSAppUtilPage, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PAGEURL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSAppUtilPageId(boolean bl, PSAppUtilPage pSAppUtilPage, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppUtilPage.isPSAppUtilPageIdDirty() && !bl2 : !pSAppUtilPage.isPSAppUtilPageIdDirty()) {
            return null;
        }
        String string = pSAppUtilPage.getPSAppUtilPageId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPUTILPAGEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppUtilPageId_Default(pSAppUtilPage, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPUTILPAGEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSAppUtilPageName(boolean bl, PSAppUtilPage pSAppUtilPage, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppUtilPage.isPSAppUtilPageNameDirty() && !bl2 : !pSAppUtilPage.isPSAppUtilPageNameDirty()) {
            return null;
        }
        String string = pSAppUtilPage.getPSAppUtilPageName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPUTILPAGENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppUtilPageName_Default(pSAppUtilPage, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPUTILPAGENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (string == null) {
                bl4 = false;
            }
            if (bl4) {
                String string3 = "";
                string3 = "PSSYSAPPID";
                String string4 = this.checkFieldDupRule(this.getPSAppUtilPageDEModel(), "PSAPPUTILPAGENAME", string3, pSAppUtilPage, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSAPPUTILPAGENAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSAppViewId(boolean bl, PSAppUtilPage pSAppUtilPage, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppUtilPage.isPSAppViewIdDirty() : !pSAppUtilPage.isPSAppViewIdDirty()) {
            return null;
        }
        String string = pSAppUtilPage.getPSAppViewId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppViewId_Default(pSAppUtilPage, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPVIEWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysAppId(boolean bl, PSAppUtilPage pSAppUtilPage, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppUtilPage.isPSSysAppIdDirty() && !bl2 : !pSAppUtilPage.isPSSysAppIdDirty()) {
            return null;
        }
        String string = pSAppUtilPage.getPSSysAppId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSAPPID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysAppId_Default(pSAppUtilPage, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysViewPanelId(boolean bl, PSAppUtilPage pSAppUtilPage, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppUtilPage.isPSSysViewPanelIdDirty() : !pSAppUtilPage.isPSSysViewPanelIdDirty()) {
            return null;
        }
        String string = pSAppUtilPage.getPSSysViewPanelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysViewPanelId_Default(pSAppUtilPage, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSVIEWPANELID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TargetType(boolean bl, PSAppUtilPage pSAppUtilPage, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppUtilPage.isTargetTypeDirty() : !pSAppUtilPage.isTargetTypeDirty()) {
            return null;
        }
        String string = pSAppUtilPage.getTargetType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TargetType_Default(pSAppUtilPage, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TARGETTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSAppUtilPage pSAppUtilPage, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppUtilPage.isUserCatDirty() : !pSAppUtilPage.isUserCatDirty()) {
            return null;
        }
        String string = pSAppUtilPage.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSAppUtilPage, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSAppUtilPage pSAppUtilPage, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppUtilPage.isUserTagDirty() : !pSAppUtilPage.isUserTagDirty()) {
            return null;
        }
        String string = pSAppUtilPage.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSAppUtilPage, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSAppUtilPage pSAppUtilPage, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppUtilPage.isUserTag2Dirty() : !pSAppUtilPage.isUserTag2Dirty()) {
            return null;
        }
        String string = pSAppUtilPage.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSAppUtilPage, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSAppUtilPage pSAppUtilPage, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppUtilPage.isUserTag3Dirty() : !pSAppUtilPage.isUserTag3Dirty()) {
            return null;
        }
        String string = pSAppUtilPage.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSAppUtilPage, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSAppUtilPage pSAppUtilPage, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppUtilPage.isUserTag4Dirty() : !pSAppUtilPage.isUserTag4Dirty()) {
            return null;
        }
        String string = pSAppUtilPage.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSAppUtilPage, bl2, bl3);
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

    protected EntityFieldError onCheckField_UtilParams(boolean bl, PSAppUtilPage pSAppUtilPage, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppUtilPage.isUtilParamsDirty() : !pSAppUtilPage.isUtilParamsDirty()) {
            return null;
        }
        String string = pSAppUtilPage.getUtilParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilParams_Default(pSAppUtilPage, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilTag(boolean bl, PSAppUtilPage pSAppUtilPage, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppUtilPage.isUtilTagDirty() : !pSAppUtilPage.isUtilTagDirty()) {
            return null;
        }
        String string = pSAppUtilPage.getUtilTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilTag_Default(pSAppUtilPage, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (string == null) {
                bl4 = false;
            }
            if (bl4) {
                String string3 = "";
                string3 = "PSSYSAPPID";
                string3 = string3 + ";";
                string3 = string3 + "UTILTYPE";
                String string4 = this.checkFieldDupRule(this.getPSAppUtilPageDEModel(), "UTILTAG", string3, pSAppUtilPage, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("UTILTAG");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilType(boolean bl, PSAppUtilPage pSAppUtilPage, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppUtilPage.isUtilTypeDirty() : !pSAppUtilPage.isUtilTypeDirty()) {
            return null;
        }
        String string = pSAppUtilPage.getUtilType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilType_Default(pSAppUtilPage, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            bl4 = DataTypeHelper.compare((int)25, (Object)string, (Object)"DOWNLOADTMPFILE") == 0L || DataTypeHelper.compare((int)25, (Object)string, (Object)"LOGIN") == 0L || DataTypeHelper.compare((int)25, (Object)string, (Object)"LOGOUT") == 0L || DataTypeHelper.compare((int)25, (Object)string, (Object)"START") == 0L;
            if (bl4) {
                String string3 = "";
                string3 = "PSSYSAPPID";
                String string4 = this.checkFieldDupRule(this.getPSAppUtilPageDEModel(), "UTILTYPE", string3, pSAppUtilPage, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("UTILTYPE");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected void onSyncEntity(PSAppUtilPage pSAppUtilPage, boolean bl) throws Exception {
        super.onSyncEntity(pSAppUtilPage, bl);
    }

    protected void onSyncIndexEntities(PSAppUtilPage pSAppUtilPage, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSAppUtilPage, bl);
    }

    public Object getDataContextValue(PSAppUtilPage pSAppUtilPage, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSAppUtilPage, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSAppUtilPage pSAppUtilPage, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSAppUtilPage, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PAGEURL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PageUrl_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPUTILPAGEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppUtilPageId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPUTILPAGENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppUtilPageName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppViewName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAPPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAppId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAPPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAppName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSVIEWPANELID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysViewPanelId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSVIEWPANELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysViewPanelName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TARGETTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TargetType_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"UTILPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilType_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_CodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODENAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
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

    protected String onTestValueRule_PageUrl_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PAGEURL", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSAppUtilPageId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPUTILPAGEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSAppUtilPageName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPUTILPAGENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSAppViewId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPVIEWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSAppViewName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPVIEWNAME", iEntity, bl2, null, false, 80, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[80]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[80]";
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

    protected String onTestValueRule_PSSysViewPanelId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSVIEWPANELID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysViewPanelName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSVIEWPANELNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TargetType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TARGETTYPE", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
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
            if (this.checkFieldStringLengthRule("USERTAG", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_UtilParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTILPARAMS", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UtilTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTILTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UtilType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTILTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSAppUtilPage pSAppUtilPage) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSAppUtilPage)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSAppUtilPage pSAppUtilPage) throws Exception {
        Object object = pSAppUtilPage.get("PSSYSAPPID");
        if (object != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSAPPUTILPAGE_PSSYSAPP_PSSYSAPPID", object);
        }
        super.onUpdateParent(pSAppUtilPage);
    }

    protected boolean isNeedUpdateParent() {
        return true;
    }

    @Override
    protected void exportCurXmlModel(PSAppUtilPage pSAppUtilPage, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSAPPUTILPAGE");
        if (!bl) {
            super.exportCurXmlModel(pSAppUtilPage, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSAppUtilPage pSAppUtilPage, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSAppUtilPage, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSAPPID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSAPP#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSAPPID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSAPPUTILPAGE_PSSYSAPP_PSSYSAPPID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSAPPID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSAPPNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSSYSAPP", (boolean)true) == 0) {
            iEntity.set("PSSYSAPPID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSSYSAPPID"};
    }

    @Override
    public String getModelV2Tag(PSAppUtilPage pSAppUtilPage) {
        if (!StringHelper.isNullOrEmpty((String)pSAppUtilPage.getPSAppUtilPageName())) {
            return pSAppUtilPage.getPSAppUtilPageName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSAppUtilPage.getCodeName())) {
            return pSAppUtilPage.getCodeName();
        }
        return super.getModelV2Tag(pSAppUtilPage);
    }

    @Override
    public boolean setModelV2Tag(PSAppUtilPage pSAppUtilPage, String string) {
        pSAppUtilPage.setPSAppUtilPageName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSAPPUTILPAGENAME", "");
        map.put("CODENAME", "");
        map.put("CODENAME", "");
        map.put("PSAPPUTILPAGENAME", "");
        map.put("UTILTAG", "");
        map.put("UTILTYPE", "");
        map.put("PSSYSAPPID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSAppUtilPage pSAppUtilPage, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSAppUtilPage.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSAppUtilPage, true);
        pSAppUtilPage.set("PSAPPUTILPAGENAME", string);
        if (this.select(pSAppUtilPage, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSAppUtilPage, true);
        return super.getModelV2Entity(pSAppUtilPage, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSAppUtilPage pSAppUtilPage, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return false;
        }
        return super.testCompileCurModelV2(pSAppUtilPage, objectNode, string, string2, n);
    }

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSAppUtilPage pSAppUtilPage, boolean bl) {
        return defaultValueMap;
    }

    static {
        defaultValueMap.put("CODENAME", "AppUtilPage");
    }
}

