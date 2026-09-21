/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.dao.DAOGlobal
 *  net.ibizsys.paas.dao.IDAO
 *  net.ibizsys.paas.db.DBCallResult
 *  net.ibizsys.paas.db.IDataColumn
 *  net.ibizsys.paas.db.IDataRow
 *  net.ibizsys.paas.db.IDataTable
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.SessionFactoryManager
 *  net.ibizsys.paas.util.ObjectHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.psrt.srv.common.dao.SystemDAO
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.model;

import java.util.Vector;
import net.ibizsys.model.IPSModelQueryHelper;
import net.ibizsys.model.entity.BaseDataEntity;
import net.ibizsys.model.entity.PSACHandler;
import net.ibizsys.model.entity.PSAppFunc;
import net.ibizsys.model.entity.PSAppIndexView;
import net.ibizsys.model.entity.PSAppLan;
import net.ibizsys.model.entity.PSAppMenu;
import net.ibizsys.model.entity.PSAppMenuItem;
import net.ibizsys.model.entity.PSAppMenuItemType;
import net.ibizsys.model.entity.PSAppModule;
import net.ibizsys.model.entity.PSAppPDTView;
import net.ibizsys.model.entity.PSAppPortalView;
import net.ibizsys.model.entity.PSAppPortalViewPart;
import net.ibizsys.model.entity.PSAppUIStyle;
import net.ibizsys.model.entity.PSAppUITheme;
import net.ibizsys.model.entity.PSAppUserMode;
import net.ibizsys.model.entity.PSAppUtilPage;
import net.ibizsys.model.entity.PSAppView;
import net.ibizsys.model.entity.PSAppViewRef;
import net.ibizsys.model.entity.PSCodeItem;
import net.ibizsys.model.entity.PSCodeList;
import net.ibizsys.model.entity.PSControlType;
import net.ibizsys.model.entity.PSCounter;
import net.ibizsys.model.entity.PSCounterType;
import net.ibizsys.model.entity.PSDBType;
import net.ibizsys.model.entity.PSDBValueOP;
import net.ibizsys.model.entity.PSDEACMode;
import net.ibizsys.model.entity.PSDEACModeItem;
import net.ibizsys.model.entity.PSDEAction;
import net.ibizsys.model.entity.PSDEActionLogic;
import net.ibizsys.model.entity.PSDEActionParam;
import net.ibizsys.model.entity.PSDEActionType;
import net.ibizsys.model.entity.PSDEChart;
import net.ibizsys.model.entity.PSDEChartAxes;
import net.ibizsys.model.entity.PSDEChartSeries;
import net.ibizsys.model.entity.PSDEDRDetail;
import net.ibizsys.model.entity.PSDEDRGroup;
import net.ibizsys.model.entity.PSDEDRItem;
import net.ibizsys.model.entity.PSDEDSDQ;
import net.ibizsys.model.entity.PSDEDSGroupParam;
import net.ibizsys.model.entity.PSDEDataQuery;
import net.ibizsys.model.entity.PSDEDataQueryCode;
import net.ibizsys.model.entity.PSDEDataQueryCodeCond;
import net.ibizsys.model.entity.PSDEDataQueryCodeExp;
import net.ibizsys.model.entity.PSDEDataRelation;
import net.ibizsys.model.entity.PSDEDataSet;
import net.ibizsys.model.entity.PSDEFDLogic;
import net.ibizsys.model.entity.PSDEFIUDetail;
import net.ibizsys.model.entity.PSDEFIUpdate;
import net.ibizsys.model.entity.PSDEFSearchMode;
import net.ibizsys.model.entity.PSDEFUIMode;
import net.ibizsys.model.entity.PSDEFValueRule;
import net.ibizsys.model.entity.PSDEFValueRuleCond;
import net.ibizsys.model.entity.PSDEFValueRuleType;
import net.ibizsys.model.entity.PSDEFValueRuleTypeDetail;
import net.ibizsys.model.entity.PSDEField;
import net.ibizsys.model.entity.PSDEFieldType;
import net.ibizsys.model.entity.PSDEForm;
import net.ibizsys.model.entity.PSDEFormDetail;
import net.ibizsys.model.entity.PSDEFormItemVR;
import net.ibizsys.model.entity.PSDEGEIUDetail;
import net.ibizsys.model.entity.PSDEGEIUpdate;
import net.ibizsys.model.entity.PSDEGrid;
import net.ibizsys.model.entity.PSDEGridColumn;
import net.ibizsys.model.entity.PSDEGridColumnType;
import net.ibizsys.model.entity.PSDEList;
import net.ibizsys.model.entity.PSDEListItem;
import net.ibizsys.model.entity.PSDELogic;
import net.ibizsys.model.entity.PSDELogicLink;
import net.ibizsys.model.entity.PSDELogicLinkCond;
import net.ibizsys.model.entity.PSDELogicLinkCondType;
import net.ibizsys.model.entity.PSDELogicLinkType;
import net.ibizsys.model.entity.PSDELogicNode;
import net.ibizsys.model.entity.PSDELogicNodeParam;
import net.ibizsys.model.entity.PSDELogicNodeType;
import net.ibizsys.model.entity.PSDELogicParam;
import net.ibizsys.model.entity.PSDEMainState;
import net.ibizsys.model.entity.PSDEMainStateAction;
import net.ibizsys.model.entity.PSDEMainStateOPPriv;
import net.ibizsys.model.entity.PSDEOPPriv;
import net.ibizsys.model.entity.PSDEPrint;
import net.ibizsys.model.entity.PSDER;
import net.ibizsys.model.entity.PSDERType;
import net.ibizsys.model.entity.PSDEToolbar;
import net.ibizsys.model.entity.PSDEToolbarItem;
import net.ibizsys.model.entity.PSDEUIAction;
import net.ibizsys.model.entity.PSDEUIActionGroup;
import net.ibizsys.model.entity.PSDEUIActionGroupDetail;
import net.ibizsys.model.entity.PSDEUIActionType;
import net.ibizsys.model.entity.PSDEUtil;
import net.ibizsys.model.entity.PSDEViewBase;
import net.ibizsys.model.entity.PSDEViewCtrl;
import net.ibizsys.model.entity.PSDEViewView;
import net.ibizsys.model.entity.PSDRItemType;
import net.ibizsys.model.entity.PSDataEntity;
import net.ibizsys.model.entity.PSDepSlnSys;
import net.ibizsys.model.entity.PSDynaAppView;
import net.ibizsys.model.entity.PSDynaInst;
import net.ibizsys.model.entity.PSEditorType;
import net.ibizsys.model.entity.PSFDLogicType;
import net.ibizsys.model.entity.PSFormDetailType;
import net.ibizsys.model.entity.PSFormType;
import net.ibizsys.model.entity.PSLanguageItem;
import net.ibizsys.model.entity.PSLanguageRes;
import net.ibizsys.model.entity.PSPF;
import net.ibizsys.model.entity.PSPFCtrlTempl;
import net.ibizsys.model.entity.PSPFCtrlTemplDetail;
import net.ibizsys.model.entity.PSPFEditorTempl;
import net.ibizsys.model.entity.PSPFPluginTempl;
import net.ibizsys.model.entity.PSPFPubCode;
import net.ibizsys.model.entity.PSPFStyle;
import net.ibizsys.model.entity.PSPortletType;
import net.ibizsys.model.entity.PSSysCounter;
import net.ibizsys.model.entity.PSSysCss;
import net.ibizsys.model.entity.PSSysDBValueFunc;
import net.ibizsys.model.entity.PSSysDEFType;
import net.ibizsys.model.entity.PSSysDashboard;
import net.ibizsys.model.entity.PSSysDashboardPart;
import net.ibizsys.model.entity.PSSysEditorStyle;
import net.ibizsys.model.entity.PSSysImage;
import net.ibizsys.model.entity.PSSysModelInst;
import net.ibizsys.model.entity.PSSysPDTView;
import net.ibizsys.model.entity.PSSysPFPlugin;
import net.ibizsys.model.entity.PSSysPFPluginTempl;
import net.ibizsys.model.entity.PSSysPortlet;
import net.ibizsys.model.entity.PSSysUniRes;
import net.ibizsys.model.entity.PSSysValueRule;
import net.ibizsys.model.entity.PSSysWFSetting;
import net.ibizsys.model.entity.PSSystem;
import net.ibizsys.model.entity.PSSystemApplication;
import net.ibizsys.model.entity.PSToolbarItemType;
import net.ibizsys.model.entity.PSViewType;
import net.ibizsys.model.entity.PSWFDE;
import net.ibizsys.model.entity.PSWFLink;
import net.ibizsys.model.entity.PSWFLinkCond;
import net.ibizsys.model.entity.PSWFLinkCondType;
import net.ibizsys.model.entity.PSWFLinkType;
import net.ibizsys.model.entity.PSWFProcParam;
import net.ibizsys.model.entity.PSWFProcRole;
import net.ibizsys.model.entity.PSWFProcSubWF;
import net.ibizsys.model.entity.PSWFProcess;
import net.ibizsys.model.entity.PSWFProcessType;
import net.ibizsys.model.entity.PSWFRole;
import net.ibizsys.model.entity.PSWFVersion;
import net.ibizsys.model.entity.PSWorkflow;
import net.ibizsys.model.util.PSSysModelInstGlobal;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.db.DBCallResult;
import net.ibizsys.paas.db.IDataColumn;
import net.ibizsys.paas.db.IDataRow;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.util.ObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psrt.srv.common.dao.SystemDAO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSModelQueryHelperImpl
implements IPSModelQueryHelper {
    public static final String TEMPKEY = "SRFTEMPKEY:";
    private static final Log log = LogFactory.getLog(PSModelQueryHelperImpl.class);
    protected SessionFactory sessionFactory = null;
    protected IDAO iDAO = null;
    public static final Integer MAXMODELINSTVER = 99999999;
    private int nModelInstVer = MAXMODELINSTVER;
    private long nLastActiveTime = 0L;
    private long nLastSessionActiveTime = 0L;
    private boolean bAlwaysActive = false;
    private String strPSSysModelInstId = null;
    private static final String USER_SYSTEM = "SYSTEM";

    public void init(String strPSSysModelInstId, boolean bAlwaysActive) throws Exception {
        this.strPSSysModelInstId = strPSSysModelInstId;
        if (!StringHelper.isNullOrEmpty((String)this.strPSSysModelInstId)) {
            this.bAlwaysActive = bAlwaysActive;
            this.nLastActiveTime = System.currentTimeMillis();
            this.nLastSessionActiveTime = System.currentTimeMillis();
            this.setSessionFactory(PSSysModelInstGlobal.getSessionFactory(this.strPSSysModelInstId));
            if (this.bAlwaysActive) {
                PSSysModelInstGlobal.activeAlways(this.strPSSysModelInstId);
            }
        } else {
            this.bAlwaysActive = true;
        }
        this.onInit();
    }

    public void init(SessionFactory sessionFactory) throws Exception {
        this.setSessionFactory(sessionFactory);
        this.bAlwaysActive = true;
        this.onInit();
    }

    protected void onInit() throws Exception {
    }

    @Override
    public void active() {
        this.nLastActiveTime = System.currentTimeMillis();
        if (this.getSessionFactory() != null && this.nLastSessionActiveTime + 20000L < this.nLastActiveTime) {
            this.nLastSessionActiveTime = this.nLastActiveTime;
            if (!this.isAlwaysActive()) {
                PSSysModelInstGlobal.active(this.strPSSysModelInstId);
            }
        }
    }

    @Override
    public void activeAlways() {
        if (this.isAlwaysActive()) {
            return;
        }
        this.bAlwaysActive = true;
        if (!StringHelper.isNullOrEmpty((String)this.strPSSysModelInstId)) {
            PSSysModelInstGlobal.activeAlways(this.strPSSysModelInstId);
        }
    }

    @Override
    public long getLastActiveTime() {
        if (this.isAlwaysActive()) {
            return System.currentTimeMillis();
        }
        return this.nLastActiveTime;
    }

    @Override
    public boolean isAlwaysActive() {
        return this.bAlwaysActive;
    }

    @Override
    public void setModelInstVer(int nModelInstVer) {
        this.nModelInstVer = nModelInstVer;
    }

    public int getModelInstVer() {
        return this.nModelInstVer;
    }

    public SessionFactory getSessionFactory() {
        return this.sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected synchronized IDAO getDAO() throws Exception {
        if (this.iDAO != null) {
            return this.iDAO;
        }
        SystemDAO systemDAO = (SystemDAO)DAOGlobal.getDAO(SystemDAO.class, (SessionFactory)this.getSessionFactory());
        this.iDAO = systemDAO;
        return this.iDAO;
    }

    @Override
    public void startLoadPSSysApp(String strPSSysAppId, int nLoadLevel) throws Exception {
    }

    @Override
    public void stopLoadPSSysApp() throws Exception {
    }

    @Override
    public void startLoadPSSystem(String strPSSystemId, int nLoadLevel) throws Exception {
    }

    @Override
    public void stopLoadPSSystem() throws Exception {
    }

    @Override
    public CallResult getPSSystem(String strPSSystemId, PSSystem psSystem) {
        return this.selectSingle(this.getSQL_getPSSystem(strPSSystemId), (IEntity)psSystem, USER_SYSTEM);
    }

    protected String getSQL_getPSSystem(String strPSSystemId) {
        return StringHelper.format((String)"select t1.* from T_SRFPSSYSTEM t1 where  t1.PSSYSTEMID='%1$s'", (Object)strPSSystemId);
    }

    @Override
    public CallResult getPSSysModelInst(String strPSSysModelInstId, PSSysModelInst psSysModelInst) {
        return this.selectSingle(this.getSQL_getPSSysModelInst(strPSSysModelInstId), (IEntity)psSysModelInst, USER_SYSTEM);
    }

    protected String getSQL_getPSSysModelInst(String strPSSysModelInstId) {
        return StringHelper.format((String)"select t1.* from T_SRFPSSYSMODELINST t1 where  t1.PSSYSMODELINSTID='%1$s'", (Object)strPSSysModelInstId);
    }

    @Override
    public CallResult getPSDBType(String strPSDBTypeId, PSDBType psDBType) {
        return this.selectSingle(this.getSQL_getPSDBType(strPSDBTypeId), (IEntity)psDBType, USER_SYSTEM);
    }

    protected String getSQL_getPSDBType(String strPSDBTypeId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSDBTYPE t1 where  t1.PSDBTYPEID='%1$s'", (Object)strPSDBTypeId);
    }

    @Override
    public CallResult getPSAppViewRefs(String strPSAppViewId, Vector<PSAppViewRef> psAppViewRefList) {
        return this.selectMulti(this.getSQL_getPSAppViewRefs(strPSAppViewId), psAppViewRefList, PSAppViewRef.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getPSAppViewRefs(String strPSAppViewId) {
        return StringHelper.format((String)"select t1.* from T_SRFPSAPPVIEWREF t1 where  t1.MAJORPSAPPVIEWID = '%1$s' ", (Object)strPSAppViewId);
    }

    @Override
    public CallResult getPSDEViewBase(String strPSDEViewBaseId, PSDEViewBase psDEViewBase) {
        return this.selectSingle(this.getSQL_getPSDEViewBase(strPSDEViewBaseId), (IEntity)psDEViewBase, USER_SYSTEM);
    }

    protected String getSQL_getPSDEViewBase(String strPSDEViewBaseId) {
        return StringHelper.format((String)"select t1.* from T_SRFPSDEVIEWBASE t1 where  t1.PSDEVIEWBASEID='%1$s'", (Object)strPSDEViewBaseId);
    }

    @Override
    public CallResult getPSDEViewViews(String strPSDEViewId, Vector<PSDEViewView> psDEViewViewList) {
        return this.selectMulti(this.getSQL_getPSDEViewViews(strPSDEViewId), psDEViewViewList, PSDEViewView.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getPSDEViewViews(String strPSDEViewId) {
        return StringHelper.format((String)"select t1.* from T_SRFPSDEVIEWRV t1 where  t1.MAJORPSDEVIEWID = '%1$s' ", (Object)strPSDEViewId);
    }

    @Override
    public CallResult getPSDEViewCtrls(String strPSDEViewId, Vector<PSDEViewCtrl> psDEViewCtrlList) {
        return this.selectMulti(this.getSQL_getPSDEViewCtrls(strPSDEViewId), psDEViewCtrlList, PSDEViewCtrl.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getPSDEViewCtrls(String strPSDEViewId) {
        return StringHelper.format((String)"select t1.* from T_SRFPSDEVIEWCTRL t1 where  t1.PSDEVIEWBASEID = '%1$s' ", (Object)strPSDEViewId);
    }

    @Override
    public CallResult getPSApplicationView(String strPSApplicationViewId, PSAppView psApplicationView) {
        return this.selectSingle(this.getSQL_getPSApplicationView(strPSApplicationViewId), (IEntity)psApplicationView, USER_SYSTEM);
    }

    protected String getSQL_getPSApplicationView(String strPSApplicationViewId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSAPPVIEW t1 where  t1.PSAPPVIEWID='%1$s'", (Object)strPSApplicationViewId);
    }

    @Override
    public CallResult getPSAppIndexView(String strPSAppIndexViewId, PSAppIndexView psAppIndexView) {
        return this.selectSingle(this.getSQL_getPSAppIndexView(strPSAppIndexViewId), (IEntity)psAppIndexView, USER_SYSTEM);
    }

    protected String getSQL_getPSAppIndexView(String strPSAppIndexViewId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSAPPINDEXVIEW t1 where  t1.PSAPPINDEXVIEWID='%1$s'", (Object)strPSAppIndexViewId);
    }

    @Override
    public CallResult getPSAppMenuItems(String strPSAppMenuId, Vector<PSAppMenuItem> psAppMenuItemList) {
        return this.selectMulti(this.getSQL_getPSAppMenuItems(strPSAppMenuId), psAppMenuItemList, PSAppMenuItem.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getPSAppMenuItems(String strPSAppMenuId) {
        if (strPSAppMenuId.indexOf(TEMPKEY) == 0) {
            return StringHelper.format((String)"select t1.* from V_PSAPPMENUITEM_TMP t1 where  t1.PSAPPMENUID='%1$s' AND  t1.srfdraftflag = 0 order by ORDERVALUE", (Object)strPSAppMenuId);
        }
        return StringHelper.format((String)"select t1.* from V_SRFPSAPPMENUITEM t1 where  t1.PSAPPMENUID='%1$s' order by ORDERVALUE", (Object)strPSAppMenuId);
    }

    @Override
    public CallResult getPSAppMenu(String strPSAppMenuId, PSAppMenu psAppMenu) {
        return this.selectSingle(this.getSQL_getPSAppMenu(strPSAppMenuId), (IEntity)psAppMenu, USER_SYSTEM);
    }

    protected String getSQL_getPSAppMenu(String strPSAppMenuId) {
        if (strPSAppMenuId.indexOf(TEMPKEY) == 0) {
            return StringHelper.format((String)"select t1.* from V_PSAPPMENU_TMP t1 where  t1.PSAPPMENUID='%1$s' ", (Object)strPSAppMenuId);
        }
        return StringHelper.format((String)"select t1.* from V_SRFPSAPPMENU t1 where  t1.PSAPPMENUID='%1$s'", (Object)strPSAppMenuId);
    }

    @Override
    public CallResult getPSDEGrid(String strPSDEGridId, PSDEGrid psDEGrid) {
        return this.selectSingle(this.getSQL_getPSDEGrid(strPSDEGridId), (IEntity)psDEGrid, USER_SYSTEM);
    }

    protected String getSQL_getPSDEGrid(String strPSDEGridId) {
        if (strPSDEGridId.indexOf(TEMPKEY) == 0) {
            return StringHelper.format((String)"select t1.* from V_PSDEGRID_TMP t1 where  t1.PSDEGRIDID='%1$s'", (Object)strPSDEGridId);
        }
        return StringHelper.format((String)"select t1.* from V_SRFPSDEGRID t1 where  t1.PSDEGRIDID='%1$s'", (Object)strPSDEGridId);
    }

    @Override
    public CallResult getPSDEToolbar(String strPSDEToolbarId, PSDEToolbar psDEToolbar) {
        return this.selectSingle(this.getSQL_getPSDEToolbar(strPSDEToolbarId), (IEntity)psDEToolbar, USER_SYSTEM);
    }

    protected String getSQL_getPSDEToolbar(String strPSDEToolbarId) {
        if (strPSDEToolbarId.indexOf(TEMPKEY) == 0) {
            return StringHelper.format((String)"select t1.* from V_PSDETOOLBAR_TMP t1 where  t1.PSDETOOLBARID='%1$s'", (Object)strPSDEToolbarId);
        }
        return StringHelper.format((String)"select t1.* from V_SRFPSDETOOLBAR t1 where  t1.PSDETOOLBARID='%1$s'", (Object)strPSDEToolbarId);
    }

    @Override
    public CallResult getPSDEFormItemVRs(String strPSDEFormId, Vector<PSDEFormItemVR> psDEFormItemVRList) {
        return this.selectMulti(this.getSQL_getPSDEFormItemVRs(strPSDEFormId), psDEFormItemVRList, PSDEFormItemVR.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getPSDEFormItemVRs(String strPSDEFormId) {
        if (strPSDEFormId.indexOf(TEMPKEY) == 0) {
            return StringHelper.format((String)"select t1.* from V_PSDEFIVR_TMP t1 where  t1.PSDEFORMID='%1$s' AND  t1.srfdraftflag = 0 ORDER BY t1.ORDERVALUE", (Object)strPSDEFormId);
        }
        return StringHelper.format((String)"select t1.* from V_SRFPSDEFIVR t1 where  t1.PSDEFORMID='%1$s' ORDER BY t1.ORDERVALUE", (Object)strPSDEFormId);
    }

    @Override
    public CallResult getPSDEFIUDetails(String strPSDEFormId, Vector<PSDEFIUDetail> psDEFIUDetailList) {
        return this.selectMulti(this.getSQL_getPSDEFIUDetails(strPSDEFormId), psDEFIUDetailList, PSDEFIUDetail.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getPSDEFIUDetails(String strPSDEFormId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSDEFIUDETAIL t1  where t1.PSDEFORMID='%1$s' ", (Object)strPSDEFormId);
    }

    @Override
    public CallResult getPSDEFIUpdates(String strPSDEFormId, Vector<PSDEFIUpdate> psDEFIUpdateList) {
        return this.selectMulti(this.getSQL_getPSDEFIUpdates(strPSDEFormId), psDEFIUpdateList, PSDEFIUpdate.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getPSDEFIUpdates(String strPSDEFormId) {
        if (strPSDEFormId.indexOf(TEMPKEY) == 0) {
            return StringHelper.format((String)"select t1.* from V_PSDEFIUPDATE_TMP t1 where  t1.PSDEFORMID='%1$s' AND  t1.srfdraftflag = 0 ", (Object)strPSDEFormId);
        }
        return StringHelper.format((String)"select t1.* from V_SRFPSDEFIUPDATE t1 where  t1.PSDEFORMID='%1$s' ", (Object)strPSDEFormId);
    }

    @Override
    public CallResult getPSDEFormDetails(String strPSDEFormId, Vector<PSDEFormDetail> psDEFormDetailList) {
        return this.selectMulti(this.getSQL_getPSDEFormDetails(strPSDEFormId), psDEFormDetailList, PSDEFormDetail.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getPSDEFormDetails(String strPSDEFormId) {
        if (strPSDEFormId.indexOf(TEMPKEY) == 0) {
            return StringHelper.format((String)"select t1.* from V_PSDEFORMDETAIL_TMP t1 where  t1.PSDEFORMID='%1$s' AND  t1.srfdraftflag = 0 order by ORDERVALUE", (Object)strPSDEFormId);
        }
        return StringHelper.format((String)"select t1.*,t2.FORMTYPE from T_SRFPSDEFORMDETAIL t1 inner join T_SRFPSDEFORM t2 on t1.PSDEFORMID = t2.PSDEFORMID where  t1.PSDEFORMID='%1$s' order by ORDERVALUE", (Object)strPSDEFormId);
    }

    @Override
    public CallResult getPSDEForm(String strPSDEFormId, PSDEForm psDEForm) {
        return this.selectSingle(this.getSQL_getPSDEForm(strPSDEFormId), (IEntity)psDEForm, USER_SYSTEM);
    }

    protected String getSQL_getPSDEForm(String strPSDEFormId) {
        if (strPSDEFormId.indexOf(TEMPKEY) == 0) {
            return StringHelper.format((String)"select t1.* from V_PSDEFORM_TMP t1 where  t1.PSDEFORMID='%1$s'", (Object)strPSDEFormId);
        }
        return StringHelper.format((String)"select t1.* from V_SRFPSDEFORM t1 where  t1.PSDEFORMID='%1$s'", (Object)strPSDEFormId);
    }

    @Override
    public CallResult getPSDEFDLogics(String strPSDEFormId, Vector<PSDEFDLogic> psDEFDLogicList) {
        return this.selectMulti(this.getSQL_getPSDEFDLogics(strPSDEFormId), psDEFDLogicList, PSDEFDLogic.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getPSDEFDLogics(String strPSDEFormId) {
        if (strPSDEFormId.indexOf(TEMPKEY) == 0) {
            return StringHelper.format((String)"select t1.* from V_PSDEFDLOGIC_TMP t1 inner join t_srfpsdeformdetail_TMP t2 on t1.PSDEFORMDETAILID = t2.PSDEFORMDETAILID where t2.PSDEFORMID='%1$s' AND  t1.srfdraftflag = 0 order by t1.ORDERVALUE", (Object)strPSDEFormId);
        }
        return StringHelper.format((String)"select t1.* from V_SRFPSDEFDLOGIC t1 inner join t_srfpsdeformdetail t2 on t1.PSDEFORMDETAILID = t2.PSDEFORMDETAILID where t2.PSDEFORMID='%1$s' order by t1.ORDERVALUE", (Object)strPSDEFormId);
    }

    @Override
    public CallResult getPSDEGridColumns(String strPSDEGridId, Vector<PSDEGridColumn> psDEGridColumnList) {
        return this.selectMulti(this.getSQL_getPSDEGridColumns(strPSDEGridId), psDEGridColumnList, PSDEGridColumn.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getPSDEGridColumns(String strPSDEGridId) {
        if (strPSDEGridId.indexOf(TEMPKEY) == 0) {
            return StringHelper.format((String)"select t1.* from V_PSDEGRIDCOL_TMP t1 where  t1.PSDEGRIDID='%1$s' AND  t1.srfdraftflag = 0 order by ORDERVALUE", (Object)strPSDEGridId);
        }
        return StringHelper.format((String)"select t1.* from T_SRFPSDEGRIDCOL t1 where  t1.PSDEGRIDID='%1$s' order by ORDERVALUE", (Object)strPSDEGridId);
    }

    @Override
    public CallResult getPSDEGEIUpdates(String strPSDEGridId, Vector<PSDEGEIUpdate> psDEGEIUpdateList) {
        return this.selectMulti(this.getSQL_getPSDEGEIUpdates(strPSDEGridId), psDEGEIUpdateList, PSDEGEIUpdate.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getPSDEGEIUpdates(String strPSDEGridId) {
        if (strPSDEGridId.indexOf(TEMPKEY) == 0) {
            return StringHelper.format((String)"select t1.* from V_PSDEGEIUPDATE_TMP t1 where  t1.PSDEGRIDID='%1$s' AND  t1.srfdraftflag = 0 ", (Object)strPSDEGridId);
        }
        return StringHelper.format((String)"select t1.* from V_SRFPSDEGEIUPDATE t1 where  t1.PSDEGRIDID='%1$s' ", (Object)strPSDEGridId);
    }

    @Override
    public CallResult getPSDEGEIUDetails(String strPSDEGridId, Vector<PSDEGEIUDetail> psDEGEIUDetailList) {
        return this.selectMulti(this.getSQL_getPSDEGEIUDetails(strPSDEGridId), psDEGEIUDetailList, PSDEGEIUDetail.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getPSDEGEIUDetails(String strPSDEGridId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSDEGEIUDETAIL t1  where t1.PSDEGRIDID='%1$s' ", (Object)strPSDEGridId);
    }

    @Override
    public CallResult getPSDEToolbarItems(String strPSDEToolbarId, Vector<PSDEToolbarItem> psDEToolbarItemList) {
        return this.selectMulti(this.getSQL_getPSDEToolbarItems(strPSDEToolbarId), psDEToolbarItemList, PSDEToolbarItem.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getPSDEToolbarItems(String strPSDEToolbarId) {
        if (strPSDEToolbarId.indexOf(TEMPKEY) == 0) {
            return StringHelper.format((String)"select t1.* from V_PSDETBITEM_TMP t1 where  t1.PSDETOOLBARID='%1$s' AND  t1.srfdraftflag = 0 order by ORDERVALUE", (Object)strPSDEToolbarId);
        }
        return StringHelper.format((String)"select t1.* from V_SRFPSDETBITEM t1 where  t1.PSDETOOLBARID='%1$s' order by ORDERVALUE", (Object)strPSDEToolbarId);
    }

    @Override
    public CallResult getPSSysDashboard(String strPSSysDashboardId, PSSysDashboard psSysDashboard) {
        return this.selectSingle(this.getSQL_getPSSysDashboard(strPSSysDashboardId), (IEntity)psSysDashboard, USER_SYSTEM);
    }

    protected String getSQL_getPSSysDashboard(String strPSSysDashboardId) {
        return StringHelper.format((String)"select t1.* from T_SRFPSSYSDASHBOARD t1 where  t1.PSSYSDASHBOARDID='%1$s'", (Object)strPSSysDashboardId);
    }

    @Override
    public CallResult getPSSysDashboardParts(String strPSSysDashboardId, Vector<PSSysDashboardPart> psSysDashboardPartList) {
        return this.selectMulti(this.getSQL_getPSSysDashboardParts(strPSSysDashboardId), psSysDashboardPartList, PSSysDashboardPart.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getPSSysDashboardParts(String strPSSysDashboardId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSSYSDBPART t1 where  t1.PSSYSDASHBOARDID='%1$s' AND t1.VALIDFLAG=1 order by ORDERVALUE", (Object)strPSSysDashboardId);
    }

    @Override
    public CallResult getPSDEList(String strPSDEListId, PSDEList psDEList) {
        return this.selectSingle(this.getSQL_getPSDEList(strPSDEListId), (IEntity)psDEList, USER_SYSTEM);
    }

    protected String getSQL_getPSDEList(String strPSDEListId) {
        if (strPSDEListId.indexOf(TEMPKEY) == 0) {
            return StringHelper.format((String)"select t1.* from V_PSDELIST_TMP t1 where  t1.PSDELISTID='%1$s'", (Object)strPSDEListId);
        }
        return StringHelper.format((String)"select t1.* from V_SRFPSDELIST t1 where  t1.PSDELISTID='%1$s'", (Object)strPSDEListId);
    }

    @Override
    public CallResult getPSDEListItems(String strPSDEListId, Vector<PSDEListItem> psDEListItemList) {
        return this.selectMulti(this.getSQL_getPSDEListItems(strPSDEListId), psDEListItemList, PSDEListItem.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getPSDEListItems(String strPSDEListId) {
        if (strPSDEListId.indexOf(TEMPKEY) == 0) {
            return StringHelper.format((String)"select t1.* from V_PSDELISTITEM_TMP t1 where  t1.PSDELISTID='%1$s' AND  t1.srfdraftflag = 0 order by t1.ORDERVALUE", (Object)strPSDEListId);
        }
        return StringHelper.format((String)"select t1.* from V_SRFPSDELISTITEM t1 where  t1.PSDELISTID='%1$s' order by t1.ORDERVALUE", (Object)strPSDEListId);
    }

    @Override
    public CallResult getPSDEChart(String strPSDEChartId, PSDEChart psDEChart) {
        return this.selectSingle(this.getSQL_getPSDEChart(strPSDEChartId), (IEntity)psDEChart, USER_SYSTEM);
    }

    protected String getSQL_getPSDEChart(String strPSDEChartId) {
        if (strPSDEChartId.indexOf(TEMPKEY) == 0) {
            return StringHelper.format((String)"select t1.* from V_PSDECHART_TMP t1 where  t1.PSDECHARTID='%1$s'", (Object)strPSDEChartId);
        }
        return StringHelper.format((String)"select t1.* from V_SRFPSDECHART t1 where  t1.PSDECHARTID='%1$s'", (Object)strPSDEChartId);
    }

    @Override
    public CallResult getPSDEChartAxeses(String strPSDEChartId, Vector<PSDEChartAxes> psDEChartAxesList) {
        return this.selectMulti(this.getSQL_getPSDEChartAxeses(strPSDEChartId), psDEChartAxesList, PSDEChartAxes.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getPSDEChartAxeses(String strPSDEChartId) {
        if (strPSDEChartId.indexOf(TEMPKEY) == 0) {
            return StringHelper.format((String)"select t1.* from V_PSDECHARTAXES_TMP t1 where  t1.PSDECHARTID='%1$s' AND  t1.srfdraftflag = 0 ", (Object)strPSDEChartId);
        }
        return StringHelper.format((String)"select t1.* from V_SRFPSDECHARTAXES t1 where  t1.PSDECHARTID='%1$s' ", (Object)strPSDEChartId);
    }

    @Override
    public CallResult getPSDEChartSerieses(String strPSDEChartId, Vector<PSDEChartSeries> psDEChartSeriesList) {
        return this.selectMulti(this.getSQL_getPSDEChartSerieses(strPSDEChartId), psDEChartSeriesList, PSDEChartSeries.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getPSDEChartSerieses(String strPSDEChartId) {
        if (strPSDEChartId.indexOf(TEMPKEY) == 0) {
            return StringHelper.format((String)"select t1.* from V_PSDECHARTPARAM_TMP t1 where  t1.PSDECHARTID='%1$s' AND  t1.srfdraftflag = 0 order by ORDERVALUE", (Object)strPSDEChartId);
        }
        return StringHelper.format((String)"select t1.* from V_SRFPSDECHARTPARAM t1 where  t1.PSDECHARTID='%1$s' order by ORDERVALUE", (Object)strPSDEChartId);
    }

    @Override
    public CallResult getPSAppPortalViewParts(String strPSAppPortalViewId, Vector<PSAppPortalViewPart> psAppPortalViewPartList) {
        return this.selectMulti(this.getSQL_getPSAppPortalViewParts(strPSAppPortalViewId), psAppPortalViewPartList, PSAppPortalViewPart.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getPSAppPortalViewParts(String strPSAppPortalViewId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSAPPPVPART t1 where t1.PSAPPPORTALVIEWID='%1$s' ORDER BY ORDERVALUE,PSAPPPVPARTNAME ", (Object)strPSAppPortalViewId);
    }

    @Override
    public CallResult getPSAppPortalView(String strPSAppPortalViewId, PSAppPortalView psAppPortalView) {
        return this.selectSingle(this.getSQL_getPSAppPortalView(strPSAppPortalViewId), (IEntity)psAppPortalView, USER_SYSTEM);
    }

    protected String getSQL_getPSAppPortalView(String strPSAppPortalViewId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSAPPPORTALVIEW t1 where  t1.PSAPPPORTALVIEWID='%1$s'", (Object)strPSAppPortalViewId);
    }

    @Override
    public CallResult getPSDepSlnSys(String strPSDepSlnSysId, PSDepSlnSys psDepSlnSys) {
        return this.selectSingle(this.getSQL_getPSDepSlnSys(strPSDepSlnSysId), (IEntity)psDepSlnSys, USER_SYSTEM);
    }

    protected String getSQL_getPSDepSlnSys(String strPSDepSlnSysId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSDEPSLNSYS t1 where  t1.PSDEPSLNSYSID='%1$s'", (Object)strPSDepSlnSysId);
    }

    @Override
    public CallResult getPSCodeItems(String strPSCodeListId, Vector<PSCodeItem> psCodeItemList) {
        return this.selectMulti(this.getSQL_getPSCodeItems(strPSCodeListId), psCodeItemList, PSCodeItem.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getPSCodeItems(String strPSCodeListId) {
        return StringHelper.format((String)"select t1.* from T_SRFPSCODEITEM t1 where  t1.PSCODELISTID='%1$s' order by ORDERVALUE,PSCODEITEMNAME", (Object)strPSCodeListId);
    }

    @Override
    public CallResult getPSCodeList(String strPSCodeListId, PSCodeList psCodeList) {
        return this.selectSingle(this.getSQL_getPSCodeList(strPSCodeListId), (IEntity)psCodeList, USER_SYSTEM);
    }

    protected String getSQL_getPSCodeList(String strPSCodeListId) {
        return StringHelper.format((String)"select t1.* from T_SRFPSCODELIST t1 where t1.PSCODELISTID='%1$s' AND ( t1.DYNASYSREFMODE IS NULL  OR  t1.DYNASYSREFMODE <> 2 )", (Object)strPSCodeListId);
    }

    @Override
    public CallResult getAllPSSysCsses(String strPSSystemId, Vector<PSSysCss> psSysCssList) {
        return this.selectMulti(this.getSQL_getAllPSSysCsses(strPSSystemId), psSysCssList, PSSysCss.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getAllPSSysCsses(String strPSSystemId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSSYSCSS t1 where t1.PSSYSTEMID='%1$s' ORDER BY PSSYSCSSNAME ", (Object)strPSSystemId);
    }

    @Override
    public CallResult getPSSysCss(String strPSSysCssId, PSSysCss psSysCss) {
        return this.selectSingle(this.getSQL_getPSSysCss(strPSSysCssId), (IEntity)psSysCss, USER_SYSTEM);
    }

    protected String getSQL_getPSSysCss(String strPSSysCssId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSSYSCSS t1 where  t1.PSSYSCSSID='%1$s'", (Object)strPSSysCssId);
    }

    @Override
    public CallResult getAllPSCodeLists(String strPSSystemId, Vector<PSCodeList> psCodeListList) {
        return this.selectMulti(this.getSQL_getAllPSCodeLists(strPSSystemId), psCodeListList, PSCodeList.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getAllPSCodeLists(String strPSSystemId) {
        return StringHelper.format((String)"select t1.* from T_SRFPSCODELIST t1 where t1.PSSYSTEMID='%1$s' AND ( t1.DYNASYSREFMODE IS NULL  OR  t1.DYNASYSREFMODE <> 2 ) ", (Object)strPSSystemId);
    }

    @Override
    public CallResult getAllPSSysImages(String strPSSystemId, Vector<PSSysImage> psSysImageList) {
        return this.selectMulti(this.getSQL_getAllPSSysImages(strPSSystemId), psSysImageList, PSSysImage.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getAllPSSysImages(String strPSSystemId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSSYSIMAGE t1 where t1.PSSYSTEMID='%1$s' ", (Object)strPSSystemId);
    }

    @Override
    public CallResult getPSSysImage(String strPSSysImageId, PSSysImage psSysImage) {
        return this.selectSingle(this.getSQL_getPSSysImage(strPSSysImageId), (IEntity)psSysImage, USER_SYSTEM);
    }

    protected String getSQL_getPSSysImage(String strPSSysImageId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSSYSIMAGE t1 where  t1.PSSYSIMAGEID='%1$s'", (Object)strPSSysImageId);
    }

    @Override
    public CallResult getPSSysWFSetting(String strPSSysWFSettingId, PSSysWFSetting psSysWFSetting) {
        return this.selectSingle(this.getSQL_getPSSysWFSetting(strPSSysWFSettingId), (IEntity)psSysWFSetting, USER_SYSTEM);
    }

    protected String getSQL_getPSSysWFSetting(String strPSSysWFSettingId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSSYSWFSETTING t1 where  t1.PSSYSWFSETTINGID='%1$s'", (Object)strPSSysWFSettingId);
    }

    @Override
    public CallResult getPSDataEntity(String strPSSystemId, String strPSDataEntityName, PSDataEntity psDataEntity) {
        return this.selectSingle(this.getSQL_getPSDataEntity(strPSSystemId, strPSDataEntityName), (IEntity)psDataEntity, USER_SYSTEM);
    }

    protected String getSQL_getPSDataEntity(String strPSSystemId, String strPSDataEntityName) {
        return StringHelper.format((String)"select t1.* from T_SRFPSDATAENTITY t1 where t1.PSSYSTEMID='%1$s' and (t1.PSDATAENTITYID='%2$s' OR t1.PSDATAENTITYNAME='%2$s')", (Object)strPSSystemId, (Object)strPSDataEntityName);
    }

    @Override
    public CallResult getPSDataEntity(String strPSDataEntityId, PSDataEntity psDataEntity) {
        return this.selectSingle(this.getSQL_getPSDataEntity(strPSDataEntityId), (IEntity)psDataEntity, USER_SYSTEM);
    }

    protected String getSQL_getPSDataEntity(String strPSDataEntityId) {
        return StringHelper.format((String)"select t1.PSSYSTEMID,t1.PSDATAENTITYNAME,t1.MODELVER from t_SRFPSDATAENTITY t1 where t1.PSDATAENTITYID='%1$s' and (t1.DYNAMODELFLAG IS NULL OR t1.DYNAMODELFLAG = 0)", (Object)strPSDataEntityId);
    }

    @Override
    public CallResult getPSDER(String strPSDERId, PSDER psDER) {
        return this.selectSingle(this.getSQL_getPSDER(strPSDERId), (IEntity)psDER, USER_SYSTEM);
    }

    protected String getSQL_getPSDER(String strPSDERId) {
        return StringHelper.format((String)"select t1.* from T_SRFPSDER t1 where  t1.PSDERID='%1$s'", (Object)strPSDERId);
    }

    @Override
    public CallResult getPSDEFieldsNoSort(String strPSDataEntityId, Vector<PSDEField> psDEFieldList) {
        return this.selectMulti(this.getSQL_getPSDEFieldsNoSort(strPSDataEntityId), psDEFieldList, PSDEField.class.getName(), USER_SYSTEM, true);
    }

    protected String getSQL_getPSDEFieldsNoSort(String strPSDataEntityId) {
        return StringHelper.format((String)"select t1.* from T_SRFPSDEFIELD t1 where  t1.PSDEID='%1$s' ", (Object)strPSDataEntityId);
    }

    @Override
    public CallResult getPSDEField(String strPSDEFieldId, PSDEField psDEField) {
        return this.selectSingle(this.getSQL_getPSDEField(strPSDEFieldId), (IEntity)psDEField, USER_SYSTEM);
    }

    protected String getSQL_getPSDEField(String strPSDEFieldId) {
        return StringHelper.format((String)"select t1.* from T_SRFPSDEFIELD t1 where  t1.PSDEFIELDID='%1$s' ", (Object)strPSDEFieldId);
    }

    @Override
    public CallResult getPSDEAction(String strPSDEActionId, PSDEAction psDEAction) {
        return this.selectSingle(this.getSQL_getPSDEAction(strPSDEActionId), (IEntity)psDEAction, USER_SYSTEM);
    }

    protected String getSQL_getPSDEAction(String strPSDEActionId) {
        return StringHelper.format((String)"select t1.* from T_SRFPSDEACTION t1 where  t1.PSDEACTIONID='%1$s'", (Object)strPSDEActionId);
    }

    @Override
    public CallResult getPSDELogic(String strPSDELogicId, PSDELogic psDELogic) {
        return this.selectSingle(this.getSQL_getPSDELogic(strPSDELogicId), (IEntity)psDELogic, USER_SYSTEM);
    }

    protected String getSQL_getPSDELogic(String strPSDELogicId) {
        return StringHelper.format((String)"select t1.* from T_SRFPSDELOGIC t1 where  t1.PSDELOGICID='%1$s'", (Object)strPSDELogicId);
    }

    @Override
    public CallResult getPSDEActionLogics(String strPSDEActionId, Vector<PSDEActionLogic> psDEActionLogicList) {
        return this.selectMulti(this.getSQL_getPSDEActionLogics(strPSDEActionId), psDEActionLogicList, PSDEActionLogic.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getPSDEActionLogics(String strPSDEActionId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSDEACTIONLOGIC t1 where  t1.PSDEACTIONID='%1$s' order by t1.ORDERVALUE ", (Object)strPSDEActionId);
    }

    @Override
    public CallResult getPSDEActionParams(String strPSDEActionId, Vector<PSDEActionParam> psDEActionParamList) {
        return this.selectMulti(this.getSQL_getPSDEActionParams(strPSDEActionId), psDEActionParamList, PSDEActionParam.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getPSDEActionParams(String strPSDEActionId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSDEACTIONPARAM t1 where  t1.PSDEACTIONID='%1$s' order by t1.ORDERVALUE ", (Object)strPSDEActionId);
    }

    @Override
    public CallResult getPSDEActions(String strPSDataEntityId, Vector<PSDEAction> psDEActionList) {
        return this.selectMulti(this.getSQL_getPSDEActions(strPSDataEntityId), psDEActionList, PSDEAction.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getPSDEActions(String strPSDataEntityId) {
        return StringHelper.format((String)"select t1.* from T_SRFPSDEACTION t1 where  t1.PSDEID='%1$s' ", (Object)strPSDataEntityId);
    }

    @Override
    public CallResult getPSDEUIActions(String strPSDataEntityId, Vector<PSDEUIAction> psDEUIActionList) {
        return this.selectMulti(this.getSQL_getPSDEUIActions(strPSDataEntityId), psDEUIActionList, PSDEUIAction.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getPSDEUIActions(String strPSDataEntityId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSDEUIACTION t1 where  t1.PSDEID='%1$s' ", (Object)strPSDataEntityId);
    }

    @Override
    public CallResult getPSSysDEUIActions(String strPSSystemId, Vector<PSDEUIAction> psDEUIActionList) {
        return this.selectMulti(this.getSQL_getPSSysDEUIActions(strPSSystemId), psDEUIActionList, PSDEUIAction.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getPSSysDEUIActions(String strPSSystemId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSDEUIACTION t1 where (( t1.PSDEID IS NULL ) OR (t1.GLOBALFLAG IS NOT NULL AND t1.GLOBALFLAG = 1)) AND t1.PSWFID IS NULL  AND t1.PSSYSTEMID='%1$s' ", (Object)strPSSystemId);
    }

    @Override
    public CallResult getPSDEUIAction(String strPSDEUIActionId, PSDEUIAction psDEUIAction) {
        return this.selectSingle(this.getSQL_getPSDEUIAction(strPSDEUIActionId), (IEntity)psDEUIAction, USER_SYSTEM);
    }

    protected String getSQL_getPSDEUIAction(String strPSDEUIActionId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSDEUIACTION t1 where  t1.PSDEUIACTIONID='%1$s'", (Object)strPSDEUIActionId);
    }

    @Override
    public CallResult getPSDEUIActionGroup(String strPSDEUIActionGroupId, PSDEUIActionGroup psDEUIActionGroup) {
        return this.selectSingle(this.getSQL_getPSDEUIActionGroup(strPSDEUIActionGroupId), (IEntity)psDEUIActionGroup, USER_SYSTEM);
    }

    protected String getSQL_getPSDEUIActionGroup(String strPSDEUIActionGroupId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSDEUAGROUP t1 where  t1.PSDEUAGROUPID='%1$s'", (Object)strPSDEUIActionGroupId);
    }

    @Override
    public CallResult getPSDEACMode(String strPSDEACModeId, PSDEACMode psDEACMode) {
        return this.selectSingle(this.getSQL_getPSDEACMode(strPSDEACModeId), (IEntity)psDEACMode, USER_SYSTEM);
    }

    protected String getSQL_getPSDEACMode(String strPSDEACModeId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSDEACMODE t1 where  t1.PSDEACMODEID='%1$s'", (Object)strPSDEACModeId);
    }

    @Override
    public CallResult getPSDEACModes(String strPSDataEntityId, Vector<PSDEACMode> psDEACModeList) {
        return this.selectMulti(this.getSQL_getPSDEACModes(strPSDataEntityId), psDEACModeList, PSDEACMode.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getPSDEACModes(String strPSDataEntityId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSDEACMODE t1 where  t1.PSDEID='%1$s' ", (Object)strPSDataEntityId);
    }

    @Override
    public CallResult getPSDEUIActionGroups(String strPSDataEntityId, Vector<PSDEUIActionGroup> psDEUIActionGroupList) {
        return this.selectMulti(this.getSQL_getPSDEUIActionGroups(strPSDataEntityId), psDEUIActionGroupList, PSDEUIActionGroup.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getPSDEUIActionGroups(String strPSDataEntityId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSDEUAGROUP t1 where  t1.PSDEID='%1$s' ", (Object)strPSDataEntityId);
    }

    @Override
    public CallResult getPSDEUIActionGroupDetails(String strPSDEUIActionGroupId, Vector<PSDEUIActionGroupDetail> psDEUIActionGroupDetailList) {
        return this.selectMulti(this.getSQL_getPSDEUIActionGroupDetails(strPSDEUIActionGroupId), psDEUIActionGroupDetailList, PSDEUIActionGroupDetail.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getPSDEUIActionGroupDetails(String strPSDEUIActionGroupId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSDEUAGRPDETAIL t1 where  t1.PSDEUAGROUPID='%1$s' order by ORDERVALUE", (Object)strPSDEUIActionGroupId);
    }

    @Override
    public CallResult getPSDEUIActionType(String strPSDEUIActionTypeId, PSDEUIActionType psDEUIActionType) {
        return this.selectSingle(this.getSQL_getPSDEUIActionType(strPSDEUIActionTypeId), (IEntity)psDEUIActionType, USER_SYSTEM);
    }

    protected String getSQL_getPSDEUIActionType(String strPSDEUIActionTypeId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSDEUIACTIONTYPE t1 where  t1.PSDEUIACTIONTYPEID='%1$s'", (Object)strPSDEUIActionTypeId);
    }

    @Override
    public CallResult getPSSysDEUIActionGroups(String strPSSystemId, Vector<PSDEUIActionGroup> psDEUIActionGroupList) {
        return this.selectMulti(this.getSQL_getPSSysDEUIActionGroups(strPSSystemId), psDEUIActionGroupList, PSDEUIActionGroup.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getPSSysDEUIActionGroups(String strPSSystemId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSDEUAGROUP t1 where  t1.PSDEID IS NULL AND t1.PSWFID IS NULL AND t1.PSSYSTEMID='%1$s' ", (Object)strPSSystemId);
    }

    @Override
    public CallResult getPSDEViews(String strPSDataEntityId, Vector<PSDEViewBase> psDEViewBaseList) {
        return this.selectMulti(this.getSQL_getPSDEViews(strPSDataEntityId), psDEViewBaseList, PSDEViewBase.class.getName(), USER_SYSTEM, true);
    }

    protected String getSQL_getPSDEViews(String strPSDataEntityId) {
        return StringHelper.format((String)"select t1.* from T_SRFPSDEVIEWBASE t1 where  t1.PSDEID='%1$s' ", (Object)strPSDataEntityId);
    }

    @Override
    public CallResult getPSDEPredefinedViews(String strPSDataEntityId, Vector<PSDEViewBase> psDEViewBaseList) {
        return this.selectMulti(this.getSQL_getPSDEPredefinedViews(strPSDataEntityId), psDEViewBaseList, PSDEViewBase.class.getName(), USER_SYSTEM, true);
    }

    protected String getSQL_getPSDEPredefinedViews(String strPSDataEntityId) {
        return StringHelper.format((String)"select t1.* from T_SRFPSDEVIEWBASE t1 where  t1.PSDEID='%1$s' and t1.PREDEFINEVIEWTYPE IS NOT NULL", (Object)strPSDataEntityId);
    }

    @Override
    public CallResult getPSDEPrints(String strPSDEId, Vector<PSDEPrint> psDEPrintList) {
        return this.selectMulti(this.getSQL_getPSDEPrints(strPSDEId), psDEPrintList, PSDEPrint.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getPSDEPrints(String strPSDEId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSDEPRINT t1 where  t1.PSDEID='%1$s' ", (Object)strPSDEId);
    }

    @Override
    public CallResult getPSDERs(String strPSDataEntityId, Vector<PSDER> psDERList) {
        return this.selectMulti(this.getSQL_getPSDERs(strPSDataEntityId), psDERList, PSDER.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getPSDERs(String strPSDataEntityId) {
        return StringHelper.format((String)"select t1.* from T_SRFPSDER t1 where  t1.MAJORPSDEID='%1$s' ORDER BY t1.PSDERNAME ", (Object)strPSDataEntityId);
    }

    @Override
    public CallResult getPSDEFUIModesByDataEntity(String strPSDEId, Vector<PSDEFUIMode> psDEFUIModeList) {
        return this.selectMulti(this.getSQL_getPSDEFUIModesByDataEntity(strPSDEId), psDEFUIModeList, PSDEFUIMode.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getPSDEFUIModesByDataEntity(String strPSDEId) {
        return StringHelper.format((String)"select t1.* from T_SRFPSDEFFORMITEM t1 LEFT JOIN T_SRFPSDEFIELD t2 on t1.PSDEFID=t2.PSDEFIELDID where  t2.PSDEID='%1$s' ", (Object)strPSDEId);
    }

    @Override
    public CallResult getPSDEFSearchModesByDataEntity(String strPSDEId, Vector<PSDEFSearchMode> psDEFSearchModeList) {
        return this.selectMulti(this.getSQL_getPSDEFSearchModesByDataEntity(strPSDEId), psDEFSearchModeList, PSDEFSearchMode.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getPSDEFSearchModesByDataEntity(String strPSDEId) {
        return StringHelper.format((String)"select t1.* from T_SRFPSDEFSFITEM t1 LEFT JOIN T_SRFPSDEFIELD t2 on t1.PSDEFID=t2.PSDEFIELDID where  t2.PSDEID='%1$s' ORDER BY t1.PSDEFSFITEMNAME ", (Object)strPSDEId);
    }

    @Override
    public CallResult getPSDEFValueRulesByDataEntity(String strPSDEId, Vector<PSDEFValueRule> psDEFValueRuleList) {
        return this.selectMulti(this.getSQL_getPSDEFValueRulesByDataEntity(strPSDEId), psDEFValueRuleList, PSDEFValueRule.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getPSDEFValueRulesByDataEntity(String strPSDEId) {
        return StringHelper.format((String)"select t1.* from T_SRFPSDEFVALUERULE t1 LEFT JOIN T_SRFPSDEFIELD t2 on t1.PSDEFID=t2.PSDEFIELDID where  t2.PSDEID='%1$s' ", (Object)strPSDEId);
    }

    @Override
    public CallResult getPSDEDataQueries(String strPSDataEntityId, Vector<PSDEDataQuery> psDEDataQueryList) {
        return this.selectMulti(this.getSQL_getPSDEDataQueries(strPSDataEntityId), psDEDataQueryList, PSDEDataQuery.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getPSDEDataQueries(String strPSDataEntityId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSDEDATAQUERY t1 where  t1.PSDEID='%1$s' ORDER BY t1.PSDEDATAQUERYNAME ", (Object)strPSDataEntityId);
    }

    @Override
    public CallResult getPSDEDataQueryCodes(String strPSDEDataQueryId, Vector<PSDEDataQueryCode> psDEDataQueryCodeList) {
        return this.selectMulti(this.getSQL_getPSDEDataQueryCodes(strPSDEDataQueryId), psDEDataQueryCodeList, PSDEDataQueryCode.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getPSDEDataQueryCodes(String strPSDEDataQueryId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSDEDQCODE t1 where  t1.PSDEDQID = '%1$s' ORDER BY t1.DBTYPE ", (Object)strPSDEDataQueryId);
    }

    @Override
    public CallResult getPSDEDataQuery(String strPSDEDataQueryId, PSDEDataQuery psDEDataQuery) {
        return this.selectSingle(this.getSQL_getPSDEDataQuery(strPSDEDataQueryId), (IEntity)psDEDataQuery, USER_SYSTEM);
    }

    protected String getSQL_getPSDEDataQuery(String strPSDEDataQueryId) {
        if (strPSDEDataQueryId.indexOf(TEMPKEY) == 0) {
            return StringHelper.format((String)"select t1.* from V_PSDEDATAQUERY_TMP t1 where  t1.PSDEDATAQUERYID='%1$s'", (Object)strPSDEDataQueryId);
        }
        return StringHelper.format((String)"select t1.* from V_SRFPSDEDATAQUERY t1 where t1.PSDEDATAQUERYID='%1$s'", (Object)strPSDEDataQueryId);
    }

    @Override
    public CallResult getPSDEDataQueryCode(String strPSDEDataQueryCodeId, PSDEDataQueryCode psDEDataQueryCode) {
        return this.selectSingle(this.getSQL_getPSDEDataQueryCode(strPSDEDataQueryCodeId), (IEntity)psDEDataQueryCode, USER_SYSTEM);
    }

    protected String getSQL_getPSDEDataQueryCode(String strPSDEDataQueryCodeId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSDEDQCODE t1 where  t1.PSDEDQCODEID='%1$s' ", (Object)strPSDEDataQueryCodeId);
    }

    @Override
    public CallResult getPSDEDataQueryCodeExps(String strPSDEDataQueryCodeId, Vector<PSDEDataQueryCodeExp> psDEDataQueryCodeExpList) {
        return this.selectMulti(this.getSQL_getPSDEDataQueryCodeExps(strPSDEDataQueryCodeId), psDEDataQueryCodeExpList, PSDEDataQueryCodeExp.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getPSDEDataQueryCodeExps(String strPSDEDataQueryCodeId) {
        return StringHelper.format((String)"select t1.* from T_SRFPSDEDQCODEEXP t1 where  t1.PSDEDQCODEID = '%1$s' order by t1.ordervalue,t1.PSDEDQCODEEXPNAME  ", (Object)strPSDEDataQueryCodeId);
    }

    @Override
    public CallResult getPSDEDataQueryCodeConds(String strPSDEDataQueryCodeId, Vector<PSDEDataQueryCodeCond> psDEDataQueryCodeCondList) {
        return this.selectMulti(this.getSQL_getPSDEDataQueryCodeConds(strPSDEDataQueryCodeId), psDEDataQueryCodeCondList, PSDEDataQueryCodeCond.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getPSDEDataQueryCodeConds(String strPSDEDataQueryCodeId) {
        return StringHelper.format((String)"select t1.* from T_SRFPSDEDQCODECOND t1 where  t1.PSDEDQCODEID = '%1$s' order by t1.ordervalue  ", (Object)strPSDEDataQueryCodeId);
    }

    @Override
    public CallResult getPSDEDataSets(String strPSDataEntityId, Vector<PSDEDataSet> psDEDataSetList) {
        return this.selectMulti(this.getSQL_getPSDEDataSets(strPSDataEntityId), psDEDataSetList, PSDEDataSet.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getPSDEDataSets(String strPSDataEntityId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSDEDATASET t1 where  t1.PSDEID='%1$s' ", (Object)strPSDataEntityId);
    }

    @Override
    public CallResult getPSDEDataSet(String strPSDEDataSetId, PSDEDataSet psDEDataSet) {
        return this.selectSingle(this.getSQL_getPSDEDataSet(strPSDEDataSetId), (IEntity)psDEDataSet, USER_SYSTEM);
    }

    protected String getSQL_getPSDEDataSet(String strPSDEDataSetId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSDEDATASET t1 where  t1.PSDEDATASETID='%1$s'", (Object)strPSDEDataSetId);
    }

    @Override
    public CallResult getPSDEDSDQs(String strPSDataSetId, Vector<PSDEDSDQ> psDEDSDQList) {
        return this.selectMulti(this.getSQL_getPSDEDSDQs(strPSDataSetId), psDEDSDQList, PSDEDSDQ.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getPSDEDSDQs(String strPSDataSetId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSDEDSDQ t1 where  t1.PSDEDATASETID='%1$s' order by t1.ordervalue ,t1.psdedqname", (Object)strPSDataSetId);
    }

    @Override
    public CallResult getPSDEDSGroupParams(String strPSDataSetId, Vector<PSDEDSGroupParam> psDEDSGroupParamList) {
        return this.selectMulti(this.getSQL_getPSDEDSGroupParams(strPSDataSetId), psDEDSGroupParamList, PSDEDSGroupParam.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getPSDEDSGroupParams(String strPSDataSetId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSDEDSGRPPARAM t1 where  t1.PSDEDSID='%1$s' order by SORTORDERVALUE ", (Object)strPSDataSetId);
    }

    @Override
    public CallResult getPSAjaxControlHandlers(String strPSDataEntityId, Vector<PSACHandler> psAjaxControlHandlerList) {
        return this.selectMulti(this.getSQL_getPSAjaxControlHandlers(strPSDataEntityId), psAjaxControlHandlerList, PSACHandler.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getPSAjaxControlHandlers(String strPSDataEntityId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSACHANDLER t1 where  t1.PSDEID = '%1$s' ", (Object)strPSDataEntityId);
    }

    @Override
    public CallResult getPSDEActionType(String strPSDEActionTypeId, PSDEActionType psDEActionType) {
        return this.selectSingle(this.getSQL_getPSDEActionType(strPSDEActionTypeId), (IEntity)psDEActionType, USER_SYSTEM);
    }

    protected String getSQL_getPSDEActionType(String strPSDEActionTypeId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSDEACTIONTYPE t1 where  t1.PSDEACTIONTYPEID='%1$s'", (Object)strPSDEActionTypeId);
    }

    @Override
    public CallResult getPSDELogics(String strPSDataEntityId, Vector<PSDELogic> psDELogicList) {
        return this.selectMulti(this.getSQL_getPSDELogics(strPSDataEntityId), psDELogicList, PSDELogic.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getPSDELogics(String strPSDataEntityId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSDELOGIC t1 where  t1.PSDEID='%1$s' ", (Object)strPSDataEntityId);
    }

    @Override
    public CallResult getPSDELogicParams(String strPSDELogicId, Vector<PSDELogicParam> psDELogicParamList) {
        return this.selectMulti(this.getSQL_getPSDELogicParams(strPSDELogicId), psDELogicParamList, PSDELogicParam.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getPSDELogicParams(String strPSDELogicId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSDELOGICPARAM t1 where  t1.PSDELOGICID='%1$s' ", (Object)strPSDELogicId);
    }

    @Override
    public CallResult getPSDELogicNodes(String strPSDELogicId, Vector<PSDELogicNode> psDELogicNodeList) {
        return this.selectMulti(this.getSQL_getPSDELogicNodes(strPSDELogicId), psDELogicNodeList, PSDELogicNode.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getPSDELogicNodes(String strPSDELogicId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSDELOGICNODE t1 where  t1.PSDELOGICID='%1$s' ", (Object)strPSDELogicId);
    }

    @Override
    public CallResult getPSDELogicLinks(String strPSDELogicId, Vector<PSDELogicLink> psDELogicLinkList) {
        return this.selectMulti(this.getSQL_getPSDELogicLinks(strPSDELogicId), psDELogicLinkList, PSDELogicLink.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getPSDELogicLinks(String strPSDELogicId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSDELOGICLINK t1 where  t1.PSDELOGICID='%1$s' ORDER BY t1.ORDERVALUE", (Object)strPSDELogicId);
    }

    @Override
    public CallResult getPSDELogicNodeParams(String strPSDELogicId, Vector<PSDELogicNodeParam> psDELogicNodeParamList) {
        return this.selectMulti(this.getSQL_getPSDELogicNodeParams(strPSDELogicId), psDELogicNodeParamList, PSDELogicNodeParam.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getPSDELogicNodeParams(String strPSDELogicId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSDELNPARAM  t1  inner join T_SRFPSDELOGICNODE  t2 on t1.PSDELOGICNODEID = t2.PSDELOGICNODEID where t2.PSDELOGICID = '%1$s' order by t1.ORDERVALUE,t1.PSDELNPARAMNAME ", (Object)strPSDELogicId);
    }

    @Override
    public CallResult getPSDELogicLinkConds(String strPSDELogicId, Vector<PSDELogicLinkCond> psDELogicLinkCondList) {
        return this.selectMulti(this.getSQL_getPSDELogicLinkConds(strPSDELogicId), psDELogicLinkCondList, PSDELogicLinkCond.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getPSDELogicLinkConds(String strPSDELogicId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSDELLCOND t1  inner join T_SRFPSDELOGICLINK t2 on t1.PSDELOGICLINKID = t2.PSDELOGICLINKID where t2.PSDELOGICID = '%1$s' order by t1.ORDERVALUE ", (Object)strPSDELogicId);
    }

    @Override
    public CallResult getPSDELogicLinkCondType(String strPSDELogicLinkCondTypeId, PSDELogicLinkCondType psDELogicLinkCondType) {
        return this.selectSingle(this.getSQL_getPSDELogicLinkCondType(strPSDELogicLinkCondTypeId), (IEntity)psDELogicLinkCondType, USER_SYSTEM);
    }

    protected String getSQL_getPSDELogicLinkCondType(String strPSDELogicLinkCondTypeId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSDELLCONDTYPE t1 where  t1.PSDELLCONDTYPEID='%1$s'", (Object)strPSDELogicLinkCondTypeId);
    }

    @Override
    public CallResult getPSDELogicNodeType(String strPSDELogicNodeTypeId, PSDELogicNodeType psDELogicNodeType) {
        return this.selectSingle(this.getSQL_getPSDELogicNodeType(strPSDELogicNodeTypeId), (IEntity)psDELogicNodeType, USER_SYSTEM);
    }

    protected String getSQL_getPSDELogicNodeType(String strPSDELogicNodeTypeId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSDELNTYPE t1 where  t1.PSDELNTYPEID='%1$s'", (Object)strPSDELogicNodeTypeId);
    }

    @Override
    public CallResult getPSDELogicLinkType(String strPSDELogicLinkTypeId, PSDELogicLinkType psDELogicLinkType) {
        return this.selectSingle(this.getSQL_getPSDELogicLinkType(strPSDELogicLinkTypeId), (IEntity)psDELogicLinkType, USER_SYSTEM);
    }

    protected String getSQL_getPSDELogicLinkType(String strPSDELogicLinkTypeId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSDELLTYPE t1 where  t1.PSDELLTYPEID='%1$s'", (Object)strPSDELogicLinkTypeId);
    }

    @Override
    public CallResult getPSDEACModeItems(String strPSDEACModeId, Vector<PSDEACModeItem> psDEACModeItemList) {
        return this.selectMulti(this.getSQL_getPSDEACModeItems(strPSDEACModeId), psDEACModeItemList, PSDEACModeItem.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getPSDEACModeItems(String strPSDEACModeId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSDEACMODEITEM t1 where  t1.PSDEACMODEID='%1$s'  ", (Object)strPSDEACModeId);
    }

    @Override
    public CallResult getPSDEDRDetails(String strPSDEDRId, Vector<PSDEDRDetail> psDEDRDetailList) {
        return this.selectMulti(this.getSQL_getPSDEDRDetails(strPSDEDRId), psDEDRDetailList, PSDEDRDetail.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getPSDEDRDetails(String strPSDEDRId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSDEDRDETAIL t1 where  t1.PSDEDRID='%1$s' order by ORDERVALUE", (Object)strPSDEDRId);
    }

    @Override
    public CallResult getPSDEDataRelations(String strPSDEId, Vector<PSDEDataRelation> psDEDataRelationList) {
        return this.selectMulti(this.getSQL_getPSDEDataRelations(strPSDEId), psDEDataRelationList, PSDEDataRelation.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getPSDEDataRelations(String strPSDEId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSDEDATARELATION t1 where  t1.PSDEID='%1$s' ", (Object)strPSDEId);
    }

    @Override
    public CallResult getPSDEDRGroups(String strPSDataEntityId, Vector<PSDEDRGroup> psDEDRGroupList) {
        return this.selectMulti(this.getSQL_getPSDEDRGroups(strPSDataEntityId), psDEDRGroupList, PSDEDRGroup.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getPSDEDRGroups(String strPSDataEntityId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSDEDRGROUP t1 where  t1.PSDEID='%1$s' ", (Object)strPSDataEntityId);
    }

    @Override
    public CallResult getPSDEDRItems(String strPSDEId, Vector<PSDEDRItem> psDEDRItemList) {
        return this.selectMulti(this.getSQL_getPSDEDRItems(strPSDEId), psDEDRItemList, PSDEDRItem.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getPSDEDRItems(String strPSDEId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSDEDRITEM t1 where  t1.PSDEID='%1$s' ", (Object)strPSDEId);
    }

    @Override
    public CallResult getPSDRItemType(String strPSDRItemTypeId, PSDRItemType psDRItemType) {
        return this.selectSingle(this.getSQL_getPSDRItemType(strPSDRItemTypeId), (IEntity)psDRItemType, USER_SYSTEM);
    }

    protected String getSQL_getPSDRItemType(String strPSDRItemTypeId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSDRITEMTYPE t1 where  t1.PSDRITEMTYPEID='%1$s'", (Object)strPSDRItemTypeId);
    }

    @Override
    public CallResult getPSWFDEs(String strPSDataEntityId, Vector<PSWFDE> psWFDEList) {
        return this.selectMulti(this.getSQL_getPSWFDEs(strPSDataEntityId), psWFDEList, PSWFDE.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getPSWFDEs(String strPSDataEntityId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSWFDE t1 where  t1.PSDEID='%1$s' AND t1.ENABLE=1 ", (Object)strPSDataEntityId);
    }

    @Override
    public CallResult getPSDEMainStateOPPrivs(String strPSDEMainStateId, Vector<PSDEMainStateOPPriv> psDEMainStateOPPrivList) {
        return this.selectMulti(this.getSQL_getPSDEMainStateOPPrivs(strPSDEMainStateId), psDEMainStateOPPrivList, PSDEMainStateOPPriv.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getPSDEMainStateOPPrivs(String strPSDEMainStateId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSDEMSOPPRIV t1 where  t1.PSDEMAINSTATEID='%1$s' ", (Object)strPSDEMainStateId);
    }

    @Override
    public CallResult getPSDEMainStateActions(String strPSDEMainStateId, Vector<PSDEMainStateAction> psDEMainStateActionList) {
        return this.selectMulti(this.getSQL_getPSDEMainStateActions(strPSDEMainStateId), psDEMainStateActionList, PSDEMainStateAction.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getPSDEMainStateActions(String strPSDEMainStateId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSDEMSACTION t1 where  t1.PSDEMSID='%1$s' ", (Object)strPSDEMainStateId);
    }

    @Override
    public CallResult getPSDEMainStates(String strPSDEId, Vector<PSDEMainState> psDEMainStateList) {
        return this.selectMulti(this.getSQL_getPSDEMainStates(strPSDEId), psDEMainStateList, PSDEMainState.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getPSDEMainStates(String strPSDEId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSDEMAINSTATE t1 where  t1.PSDEID='%1$s' ", (Object)strPSDEId);
    }

    @Override
    public CallResult getAllPSSysDEFTypes(String strPSSystemId, Vector<PSSysDEFType> psSysDEFTypeList) {
        return this.selectMulti(this.getSQL_getAllPSSysDEFTypes(strPSSystemId), psSysDEFTypeList, PSSysDEFType.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getAllPSSysDEFTypes(String strPSSystemId) {
        return StringHelper.format((String)"select t1.* from T_SRFPSSYSDEFTYPE t1 where t1.PSSYSTEMID='%1$s' AND t1.VALIDFLAG = 1 ORDER BY t1.ORDERVALUE", (Object)strPSSystemId);
    }

    @Override
    public CallResult getPSSysDEFType(String strPSSysDEFTypeId, PSSysDEFType psSysDEFType) {
        return this.selectSingle(this.getSQL_getPSSysDEFType(strPSSysDEFTypeId), (IEntity)psSysDEFType, USER_SYSTEM);
    }

    protected String getSQL_getPSSysDEFType(String strPSSysDEFTypeId) {
        return StringHelper.format((String)"select t1.* from T_SRFPSSYSDEFTYPE t1 where  t1.PSSYSDEFTYPEID='%1$s' AND t1.VALIDFLAG = 1 ORDER BY t1.ORDERVALUE", (Object)strPSSysDEFTypeId);
    }

    @Override
    public CallResult getPSDEFValueRuleConds(String strPSDEFValueRuleId, Vector<PSDEFValueRuleCond> psDEFValueRuleCondList) {
        return this.selectMulti(this.getSQL_getPSDEFValueRuleConds(strPSDEFValueRuleId), psDEFValueRuleCondList, PSDEFValueRuleCond.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getPSDEFValueRuleConds(String strPSDEFValueRuleId) {
        if (strPSDEFValueRuleId.indexOf(TEMPKEY) == 0) {
            return StringHelper.format((String)"select t1.* from V_PSDEFVRCOND_TMP t1 where  t1.PSDEFVRID='%1$s' AND  t1.srfdraftflag = 0 order by ORDERVALUE", (Object)strPSDEFValueRuleId);
        }
        return StringHelper.format((String)"select t1.* from V_SRFPSDEFVRCOND t1 where  t1.PSDEFVRID='%1$s' order by ORDERVALUE", (Object)strPSDEFValueRuleId);
    }

    @Override
    public CallResult getPSDEFValueRuleTypeDetail(String strPSDEFValueRuleTypeDetailId, PSDEFValueRuleTypeDetail psDEFValueRuleTypeDetail) {
        return this.selectSingle(this.getSQL_getPSDEFValueRuleTypeDetail(strPSDEFValueRuleTypeDetailId), (IEntity)psDEFValueRuleTypeDetail, USER_SYSTEM);
    }

    protected String getSQL_getPSDEFValueRuleTypeDetail(String strPSDEFValueRuleTypeDetailId) {
        return StringHelper.format((String)"select t1.* from T_SRFPSDEFVRTYPEDETAIL t1 where  t1.PSDEFVRTYPEDETAILID='%1$s'", (Object)strPSDEFValueRuleTypeDetailId);
    }

    @Override
    public CallResult getPSDEFValueRuleType(String strPSDEFValueRuleTypeId, PSDEFValueRuleType psDEFValueRuleType) {
        return this.selectSingle(this.getSQL_getPSDEFValueRuleType(strPSDEFValueRuleTypeId), (IEntity)psDEFValueRuleType, USER_SYSTEM);
    }

    protected String getSQL_getPSDEFValueRuleType(String strPSDEFValueRuleTypeId) {
        return StringHelper.format((String)"select t1.* from T_SRFPSDEFVRTYPE t1 where  t1.PSDEFVRTYPEID='%1$s'", (Object)strPSDEFValueRuleTypeId);
    }

    @Override
    public CallResult getAllPSDEFieldTypes(Vector<PSDEFieldType> psDEFieldTypes) {
        return this.selectMulti(this.getSQL_getAllPSDEFieldTypes(), psDEFieldTypes, PSDEFieldType.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getAllPSDEFieldTypes() {
        return StringHelper.format((String)"select t1.* from V_SRFPSDEFTYPE t1  order by ORDERVALUE ");
    }

    @Override
    public CallResult getAllPSDERs(String strPSSystemId, Vector<PSDER> psDataEntityList) {
        return this.selectMulti(this.getSQL_getAllPSDERs(strPSSystemId), psDataEntityList, PSDER.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getAllPSDERs(String strPSSystemId) {
        return StringHelper.format((String)"select t1.* from T_SRFPSDER t1 where  t1.PSSYSTEMID='%1$s' ORDER BY t1.PSDERNAME", (Object)strPSSystemId);
    }

    @Override
    public CallResult getPSDERType(String strPSDERTypeId, PSDERType psDERType) {
        return this.selectSingle(this.getSQL_getPSDERType(strPSDERTypeId), (IEntity)psDERType, USER_SYSTEM);
    }

    protected String getSQL_getPSDERType(String strPSDERTypeId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSDERTYPE t1 where  t1.PSDERTYPEID='%1$s'", (Object)strPSDERTypeId);
    }

    @Override
    public CallResult getPSDERsByMinorDEId(String strPSDataEntityId, Vector<PSDER> psDERList) {
        return this.selectMulti(this.getSQL_getPSDERsByMinorDEId(strPSDataEntityId), psDERList, PSDER.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getPSDERsByMinorDEId(String strPSDataEntityId) {
        return StringHelper.format((String)"select t1.* from T_SRFPSDER t1 where  t1.MINORPSDEID='%1$s' ORDER BY t1.PSDERNAME", (Object)strPSDataEntityId);
    }

    @Override
    public CallResult getPSDEUtils(String strPSDEId, Vector<PSDEUtil> psDEUtilList) {
        return this.selectMulti(this.getSQL_getPSDEUtils(strPSDEId), psDEUtilList, PSDEUtil.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getPSDEUtils(String strPSDEId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSDEUTILDE t1 where  t1.PSDEID='%1$s' and t1.VALIDFLAG = 1 ", (Object)strPSDEId);
    }

    @Override
    public CallResult getAllPSSysLans(String strPSSystemId, Vector<PSAppLan> psAppLans) {
        return this.selectMulti(this.getSQL_getAllPSSysLans(strPSSystemId), psAppLans, PSAppLan.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getAllPSSysLans(String strPSSystemId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSAPPLAN t1 INNER JOIN T_SRFPSSYSAPP t2 ON t1.PSSYSAPPID = t2.PSSYSAPPID  where  t2.PSSYSTEMID='%1$s'", (Object)strPSSystemId);
    }

    @Override
    public CallResult getAllPSLanguageItems(String strPSSystemId, Vector<PSLanguageItem> psLanguageItemList) {
        return this.selectMulti(this.getSQL_getAllPSLanguageItems(strPSSystemId), psLanguageItemList, PSLanguageItem.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getAllPSLanguageItems(String strPSSystemId) {
        return StringHelper.format((String)"select t1.* from T_SRFPSLANGUAGEITEM t1 where t1.PSSYSTEMID='%1$s'  ", (Object)strPSSystemId);
    }

    @Override
    public CallResult getAllPSLanguageReses(String strPSSystemId, Vector<PSLanguageRes> psLanguageResList) {
        return this.selectMulti(this.getSQL_getAllPSLanguageReses(strPSSystemId), psLanguageResList, PSLanguageRes.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getAllPSLanguageReses(String strPSSystemId) {
        return StringHelper.format((String)"select t1.* from T_SRFPSLANGUAGERES t1 where t1.PSSYSTEMID='%1$s'  ", (Object)strPSSystemId);
    }

    @Override
    public CallResult getPSSysValueRule(String strPSSysValueRuleId, PSSysValueRule psSysValueRule) {
        return this.selectSingle(this.getSQL_getPSSysValueRule(strPSSysValueRuleId), (IEntity)psSysValueRule, USER_SYSTEM);
    }

    protected String getSQL_getPSSysValueRule(String strPSSysValueRuleId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSSYSVALUERULE t1 where  t1.PSSYSVALUERULEID='%1$s'", (Object)strPSSysValueRuleId);
    }

    @Override
    public CallResult getAllPSSysValueRules(String strPSSystemId, Vector<PSSysValueRule> psSysValueRuleList) {
        return this.selectMulti(this.getSQL_getAllPSSysValueRules(strPSSystemId), psSysValueRuleList, PSSysValueRule.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getAllPSSysValueRules(String strPSSystemId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSSYSVALUERULE t1 where t1.PSSYSTEMID='%1$s' ", (Object)strPSSystemId);
    }

    @Override
    public CallResult getPSSysPortlet(String strPSSysPortletId, PSSysPortlet psSysPortlet) {
        return this.selectSingle(this.getSQL_getPSSysPortlet(strPSSysPortletId), (IEntity)psSysPortlet, USER_SYSTEM);
    }

    protected String getSQL_getPSSysPortlet(String strPSSysPortletId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSSYSPORTLET t1 where  t1.PSSYSPORTLETID='%1$s'", (Object)strPSSysPortletId);
    }

    @Override
    public CallResult getAllPSSysPortlets(String strPSSystemId, Vector<PSSysPortlet> psSysPortletList) {
        return this.selectMulti(this.getSQL_getAllPSSysPortlets(strPSSystemId), psSysPortletList, PSSysPortlet.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getAllPSSysPortlets(String strPSSystemId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSSYSPORTLET t1 where t1.PSSYSTEMID='%1$s' ", (Object)strPSSystemId);
    }

    @Override
    public CallResult getAllPSSysPDTViews(String strPSSystemId, Vector<PSSysPDTView> psSysPDTViewList) {
        return this.selectMulti(this.getSQL_getAllPSSysPDTViews(strPSSystemId), psSysPDTViewList, PSSysPDTView.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getAllPSSysPDTViews(String strPSSystemId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSSYSPDTVIEW t1 where t1.PSSYSTEMID='%1$s' ", (Object)strPSSystemId);
    }

    @Override
    public CallResult getPSSysPDTView(String strPSSysPDTViewId, PSSysPDTView psSysPDTView) {
        return this.selectSingle(this.getSQL_getPSSysPDTView(strPSSysPDTViewId), (IEntity)psSysPDTView, USER_SYSTEM);
    }

    protected String getSQL_getPSSysPDTView(String strPSSysPDTViewId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSSYSPDTVIEW t1 where  t1.PSSYSPDTVIEWID='%1$s'", (Object)strPSSysPDTViewId);
    }

    @Override
    public CallResult getPSSystemApplication(String strPSSystemApplicationId, PSSystemApplication psSystemApplication) {
        return this.selectSingle(this.getSQL_getPSSystemApplication(strPSSystemApplicationId), (IEntity)psSystemApplication, USER_SYSTEM);
    }

    protected String getSQL_getPSSystemApplication(String strPSSystemApplicationId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSSYSAPP t1 where t1.PSSYSAPPID='%1$s' ", (Object)strPSSystemApplicationId);
    }

    @Override
    public CallResult getAllPSSystemApplications(String strPSSystemId, Vector<PSSystemApplication> psSystemApplicationList) {
        return this.selectMulti(this.getSQL_getAllPSSystemApplications(strPSSystemId), psSystemApplicationList, PSSystemApplication.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getAllPSSystemApplications(String strPSSystemId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSSYSAPP t1 where t1.PSSYSTEMID='%1$s' ", (Object)strPSSystemId);
    }

    @Override
    public CallResult getPSViewType(String strPSViewTypeId, PSViewType psViewType) {
        return this.selectSingle(this.getSQL_getPSViewType(strPSViewTypeId), (IEntity)psViewType, USER_SYSTEM);
    }

    protected String getSQL_getPSViewType(String strPSViewTypeId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSVIEWTYPE t1 where  t1.PSVIEWTYPEID='%1$s'", (Object)strPSViewTypeId);
    }

    @Override
    public CallResult getAllPSApplicationViews(String strPSApplicationId, Vector<PSAppView> psApplicationViews) {
        return this.selectMulti(this.getSQL_getAllPSApplicationViews(strPSApplicationId), psApplicationViews, PSAppView.class.getName(), USER_SYSTEM, true);
    }

    protected String getSQL_getAllPSApplicationViews(String strPSApplicationId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSAPPVIEW t1 where  t1.PSSYSAPPID='%1$s'", (Object)strPSApplicationId);
    }

    @Override
    public CallResult getPSAppFunc(String strPSAppFuncId, PSAppFunc psAppFunc) {
        return this.selectSingle(this.getSQL_getPSAppFunc(strPSAppFuncId), (IEntity)psAppFunc, USER_SYSTEM);
    }

    protected String getSQL_getPSAppFunc(String strPSAppFuncId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSAPPFUNC t1 where  t1.PSAPPFUNCID='%1$s'", (Object)strPSAppFuncId);
    }

    @Override
    public CallResult getPSAppUserMode(String strPSAppUserModeId, PSAppUserMode psAppUserMode) {
        return this.selectSingle(this.getSQL_getPSAppUserMode(strPSAppUserModeId), (IEntity)psAppUserMode, USER_SYSTEM);
    }

    protected String getSQL_getPSAppUserMode(String strPSAppUserModeId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSAPPUSERMODE t1 where  t1.PSAPPUSERMODEID='%1$s'", (Object)strPSAppUserModeId);
    }

    @Override
    public CallResult getPSAppUtilPage(String strPSAppUtilPageId, PSAppUtilPage psAppUtilPage) {
        return this.selectSingle(this.getSQL_getPSAppUtilPage(strPSAppUtilPageId), (IEntity)psAppUtilPage, USER_SYSTEM);
    }

    protected String getSQL_getPSAppUtilPage(String strPSAppUtilPageId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSAPPUTILPAGE t1 where  t1.PSAPPUTILPAGEID='%1$s'", (Object)strPSAppUtilPageId);
    }

    @Override
    public CallResult getPSAppUIStyle(String strPSAppUIStyleId, PSAppUIStyle psAppUIStyle) {
        return this.selectSingle(this.getSQL_getPSAppUIStyle(strPSAppUIStyleId), (IEntity)psAppUIStyle, USER_SYSTEM);
    }

    protected String getSQL_getPSAppUIStyle(String strPSAppUIStyleId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSAPPUISTYLE t1 where  t1.PSAPPUISTYLEID='%1$s'", (Object)strPSAppUIStyleId);
    }

    @Override
    public CallResult getPSAppUITheme(String strPSAppUIThemeId, PSAppUITheme psAppUITheme) {
        return this.selectSingle(this.getSQL_getPSAppUITheme(strPSAppUIThemeId), (IEntity)psAppUITheme, USER_SYSTEM);
    }

    protected String getSQL_getPSAppUITheme(String strPSAppUIThemeId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSAPPUITHEME t1 where  t1.PSAPPUITHEMEID='%1$s'", (Object)strPSAppUIThemeId);
    }

    @Override
    public CallResult getAllPSAppMenus(String strPSApplicationId, Vector<PSAppMenu> psAppMenus) {
        return this.selectMulti(this.getSQL_getAllPSAppMenus(strPSApplicationId), psAppMenus, PSAppMenu.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getAllPSAppMenus(String strPSApplicationId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSAPPMENU t1 where  t1.PSSYSAPPID='%1$s'", (Object)strPSApplicationId);
    }

    @Override
    public CallResult getAllPSAppUtilPages(String strPSApplicationId, Vector<PSAppUtilPage> psAppUtilPages) {
        return this.selectMulti(this.getSQL_getAllPSAppUtilPages(strPSApplicationId), psAppUtilPages, PSAppUtilPage.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getAllPSAppUtilPages(String strPSApplicationId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSAPPUTILPAGE t1 where  t1.PSSYSAPPID='%1$s'", (Object)strPSApplicationId);
    }

    @Override
    public CallResult getAllPSAppLans(String strPSApplicationId, Vector<PSAppLan> psAppLans) {
        return this.selectMulti(this.getSQL_getAllPSAppLans(strPSApplicationId), psAppLans, PSAppLan.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getAllPSAppLans(String strPSApplicationId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSAPPLAN t1 where  t1.PSSYSAPPID='%1$s'", (Object)strPSApplicationId);
    }

    @Override
    public CallResult getPSAppLan(String strPSAppLanId, PSAppLan psAppLan) {
        return this.selectSingle(this.getSQL_getPSAppLan(strPSAppLanId), (IEntity)psAppLan, USER_SYSTEM);
    }

    protected String getSQL_getPSAppLan(String strPSAppLanId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSAPPLAN t1 where  t1.PSAPPLANID='%1$s'", (Object)strPSAppLanId);
    }

    @Override
    public CallResult getAllPSAppFuncs(String strPSApplicationId, Vector<PSAppFunc> psAppFuncs) {
        return this.selectMulti(this.getSQL_getAllPSAppFuncs(strPSApplicationId), psAppFuncs, PSAppFunc.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getAllPSAppFuncs(String strPSApplicationId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSAPPFUNC t1 where  t1.PSSYSAPPID='%1$s'", (Object)strPSApplicationId);
    }

    @Override
    public CallResult getPSSysAjaxControlHandlers(String strPSSystemId, Vector<PSACHandler> psAjaxControlHandlerList) {
        return this.selectMulti(this.getSQL_getPSSysAjaxControlHandlers(strPSSystemId), psAjaxControlHandlerList, PSACHandler.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getPSSysAjaxControlHandlers(String strPSSystemId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSACHANDLER t1 where  t1.PSDEID IS NULL AND t1.PSSYSTEMID='%1$s' ", (Object)strPSSystemId);
    }

    @Override
    public CallResult getPSWFDEsByWF(String strPSWFId, Vector<PSWFDE> psWFDEList) {
        return this.selectMulti(this.getSQL_getPSWFDEsByWF(strPSWFId), psWFDEList, PSWFDE.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getPSWFDEsByWF(String strPSWFId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSWFDE t1 where  t1.PSWFID='%1$s' AND t1.ENABLE=1", (Object)strPSWFId);
    }

    @Override
    public CallResult getPSWFLinkCondType(String strPSWFLinkCondTypeId, PSWFLinkCondType psWFLinkCondType) {
        return this.selectSingle(this.getSQL_getPSWFLinkCondType(strPSWFLinkCondTypeId), (IEntity)psWFLinkCondType, USER_SYSTEM);
    }

    protected String getSQL_getPSWFLinkCondType(String strPSWFLinkCondTypeId) {
        return StringHelper.format((String)"select t1.* from T_SRFPSWFLINKCONDTYPE t1 where  t1.PSWFLINKCONDTYPEID='%1$s'", (Object)strPSWFLinkCondTypeId);
    }

    @Override
    public CallResult getPSWFLinkType(String strPSWFLinkTypeId, PSWFLinkType psWFLinkType) {
        return this.selectSingle(this.getSQL_getPSWFLinkType(strPSWFLinkTypeId), (IEntity)psWFLinkType, USER_SYSTEM);
    }

    protected String getSQL_getPSWFLinkType(String strPSWFLinkTypeId) {
        return StringHelper.format((String)"select t1.* from T_SRFPSWFLINKTYPE t1 where  t1.PSWFLINKTYPEID='%1$s'", (Object)strPSWFLinkTypeId);
    }

    @Override
    public CallResult getPSWFProcessType(String strPSWFProcessTypeId, PSWFProcessType psWFProcessType) {
        return this.selectSingle(this.getSQL_getPSWFProcessType(strPSWFProcessTypeId), (IEntity)psWFProcessType, USER_SYSTEM);
    }

    protected String getSQL_getPSWFProcessType(String strPSWFProcessTypeId) {
        return StringHelper.format((String)"select t1.* from T_SRFPSWFPROCESSTYPE t1 where  t1.PSWFPROCESSTYPEID='%1$s'", (Object)strPSWFProcessTypeId);
    }

    @Override
    public CallResult getAllPSWFRoles(String strPSSystemId, Vector<PSWFRole> psWFRoleList) {
        return this.selectMulti(this.getSQL_getAllPSWFRoles(strPSSystemId), psWFRoleList, PSWFRole.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getAllPSWFRoles(String strPSSystemId) {
        return StringHelper.format((String)"select t1.* from T_SRFPSWFROLE t1 where t1.PSSYSTEMID='%1$s' AND t1.ENABLE=1 ", (Object)strPSSystemId);
    }

    @Override
    public CallResult getPSWFUIActions(String strPSWFVersionId, Vector<PSDEUIAction> psDEUIActionList) {
        return this.selectMulti(this.getSQL_getPSWFUIActions(strPSWFVersionId), psDEUIActionList, PSDEUIAction.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getPSWFUIActions(String strPSWFVersionId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSDEUIACTION t1 where  t1.PSWFVERSIONID='%1$s' ", (Object)strPSWFVersionId);
    }

    @Override
    public CallResult getPSWFUIActionGroups(String strPSWFVersionId, Vector<PSDEUIActionGroup> psDEUIActionGroupList) {
        return this.selectMulti(this.getSQL_getPSWFUIActionGroups(strPSWFVersionId), psDEUIActionGroupList, PSDEUIActionGroup.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getPSWFUIActionGroups(String strPSWFVersionId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSDEUAGROUP t1 where  t1.PSWFVERSIONID='%1$s' ", (Object)strPSWFVersionId);
    }

    @Override
    public CallResult getPSWFVersions(String strPSWFId, Vector<PSWFVersion> psVersionList) {
        return this.selectMulti(this.getSQL_getPSVersions(strPSWFId), psVersionList, PSWFVersion.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getPSVersions(String strPSWFId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSWFVERSION t1 where t1.PSWFID='%1$s'  AND t1.ENABLE=1 AND  ( t1.DYNASYSREFMODE IS NULL  OR  t1.DYNASYSREFMODE <> 2 ) ", (Object)strPSWFId);
    }

    @Override
    public CallResult getPSWFProcParams(String strPSWFVersionId, Vector<PSWFProcParam> psWFProcParamList) {
        return this.selectMulti(this.getSQL_getPSWFProcParams(strPSWFVersionId), psWFProcParamList, PSWFProcParam.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getPSWFProcParams(String strPSWFVersionId) {
        return StringHelper.format((String)"select t1.* from T_SRFPSWFPROCPARAM t1  left join T_SRFPSWFPROCESS t2 on t1.PSWFPROCESSID = t2.PSWFPROCESSID   where t2.PSWFVERSIONID = '%1$s' ", (Object)strPSWFVersionId);
    }

    @Override
    public CallResult getPSWFProcSubWFs(String strPSWFVersionId, Vector<PSWFProcSubWF> psWFProcSubWFList) {
        return this.selectMulti(this.getSQL_getPSWFProcSubWFs(strPSWFVersionId), psWFProcSubWFList, PSWFProcSubWF.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getPSWFProcSubWFs(String strPSWFVersionId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSWFPROCSUBWF t1  left join T_SRFPSWFPROCESS t2 on t1.PSWFPROCESSID = t2.PSWFPROCESSID   where t2.PSWFVERSIONID = '%1$s' ", (Object)strPSWFVersionId);
    }

    @Override
    public CallResult getPSWFProcesses(String strPSWFVersionId, Vector<PSWFProcess> psWFProcessList) {
        return this.selectMulti(this.getSQL_getPSWFProcesses(strPSWFVersionId), psWFProcessList, PSWFProcess.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getPSWFProcesses(String strPSWFVersionId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSWFPROCESS t1 where t1.PSWFVERSIONID='%1$s'  AND t1.ENABLE=1 ", (Object)strPSWFVersionId);
    }

    @Override
    public CallResult getPSWFLinks(String strPSWFVersionId, Vector<PSWFLink> psWFLinkList) {
        return this.selectMulti(this.getSQL_getPSWFLinks(strPSWFVersionId), psWFLinkList, PSWFLink.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getPSWFLinks(String strPSWFVersionId) {
        return StringHelper.format((String)"select t1.* from T_SRFPSWFLINK t1 where t1.PSWFVERSIONID='%1$s' AND t1.ENABLE=1 ORDER BY t1.ORDERVALUE ", (Object)strPSWFVersionId);
    }

    @Override
    public CallResult getPSWFLinkConds(String strPSWFVersionId, Vector<PSWFLinkCond> psWFLinkCondList) {
        return this.selectMulti(this.getSQL_getPSWFLinkConds(strPSWFVersionId), psWFLinkCondList, PSWFLinkCond.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getPSWFLinkConds(String strPSWFVersionId) {
        return StringHelper.format((String)"select t1.* from T_SRFPSWFLINKCOND t1 inner join T_SRFPSWFLINK t2 on t1.PSWFLINKID = t2.PSWFLINKID  where t2.PSWFVERSIONID='%1$s' ", (Object)strPSWFVersionId);
    }

    @Override
    public CallResult getPSWFProcRoles(String strPSWFVersionId, Vector<PSWFProcRole> psWFProcRoleList) {
        return this.selectMulti(this.getSQL_getPSProcRoles(strPSWFVersionId), psWFProcRoleList, PSWFProcRole.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getPSProcRoles(String strPSWFVersionId) {
        return StringHelper.format((String)"select t1.* from T_SRFPSWFPROCROLE t1  left join T_SRFPSWFPROCESS t2 on t1.PSWFPROCESSID = t2.PSWFPROCESSID   where t2.PSWFVERSIONID = '%1$s' ", (Object)strPSWFVersionId);
    }

    @Override
    public CallResult getAllPSWorkflows(String strPSSystemId, Vector<PSWorkflow> psWorkflowList) {
        return this.selectMulti(this.getSQL_getAllPSWorkflows(strPSSystemId), psWorkflowList, PSWorkflow.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getAllPSWorkflows(String strPSSystemId) {
        return StringHelper.format((String)"select t1.* from T_SRFPSWORKFLOW t1 where t1.PSSYSTEMID='%1$s' AND t1.ENABLE=1 ", (Object)strPSSystemId);
    }

    @Override
    public CallResult getPSSysCounter(String strPSSysCounterId, PSSysCounter psSysCounter) {
        return this.selectSingle(this.getSQL_getPSSysCounter(strPSSysCounterId), (IEntity)psSysCounter, USER_SYSTEM);
    }

    protected String getSQL_getPSSysCounter(String strPSSysCounterId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSSYSCOUNTER t1 where  t1.PSSYSCOUNTERID='%1$s'", (Object)strPSSysCounterId);
    }

    @Override
    public CallResult getPSCounterType(String strPSCounterTypeId, PSCounterType psCounterType) {
        return this.selectSingle(this.getSQL_getPSCounterType(strPSCounterTypeId), (IEntity)psCounterType, USER_SYSTEM);
    }

    protected String getSQL_getPSCounterType(String strPSCounterTypeId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSCOUNTERTYPE t1 where  t1.PSCOUNTERTYPEID='%1$s'", (Object)strPSCounterTypeId);
    }

    @Override
    public CallResult getAllPSSysCounters(String strPSSystemId, Vector<PSSysCounter> psSysCounterList) {
        return this.selectMulti(this.getSQL_getAllPSSysCounters(strPSSystemId), psSysCounterList, PSSysCounter.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getAllPSSysCounters(String strPSSystemId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSSYSCOUNTER t1 where t1.PSSYSTEMID='%1$s' ", (Object)strPSSystemId);
    }

    @Override
    public CallResult getAllPSSysEditorStyles(String strPSSystemId, Vector<PSSysEditorStyle> psSysEditorStyleList) {
        return this.selectMulti(this.getSQL_getAllPSSysEditorStyles(strPSSystemId), psSysEditorStyleList, PSSysEditorStyle.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getAllPSSysEditorStyles(String strPSSystemId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSSYSEDITORSTYLE t1 where t1.PSSYSTEMID='%1$s' ", (Object)strPSSystemId);
    }

    @Override
    public CallResult getPSSysUniRes(String strPSSysUniResId, PSSysUniRes psSysUniRes) {
        return this.selectSingle(this.getSQL_getPSSysUniRes(strPSSysUniResId), (IEntity)psSysUniRes, USER_SYSTEM);
    }

    protected String getSQL_getPSSysUniRes(String strPSSysUniResId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSSYSUNIRES t1 where  t1.PSSYSUNIRESID='%1$s'", (Object)strPSSysUniResId);
    }

    @Override
    public CallResult getAllPSSysUniReses(String strPSSystemId, Vector<PSSysUniRes> psSysUniResList) {
        return this.selectMulti(this.getSQL_getAllPSSysUniReses(strPSSystemId), psSysUniResList, PSSysUniRes.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getAllPSSysUniReses(String strPSSystemId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSSYSUNIRES t1 where t1.PSSYSTEMID='%1$s' ", (Object)strPSSystemId);
    }

    @Override
    public CallResult getPSSysDBValueFunc(String strPSSysDBValueFuncId, PSSysDBValueFunc psSysDBValueFunc) {
        return this.selectSingle(this.getSQL_getPSSysDBValueFunc(strPSSysDBValueFuncId), (IEntity)psSysDBValueFunc, USER_SYSTEM);
    }

    protected String getSQL_getPSSysDBValueFunc(String strPSSysDBValueFuncId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSSYSDBVF t1 where  t1.PSSYSDBVFID='%1$s'", (Object)strPSSysDBValueFuncId);
    }

    @Override
    public CallResult getPSDEOPPriv(String strPSDEOPPrivId, PSDEOPPriv psDEOPPriv) {
        return this.selectSingle(this.getSQL_getPSDEOPPriv(strPSDEOPPrivId), (IEntity)psDEOPPriv, USER_SYSTEM);
    }

    protected String getSQL_getPSDEOPPriv(String strPSDEOPPrivId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSDEOPPRIV t1 where  t1.PSDEOPPRIVID='%1$s' ", (Object)strPSDEOPPrivId);
    }

    @Override
    public CallResult getPSDEOPPrivsBySystem(String strPSSystemId, Vector<PSDEOPPriv> psDEOPPrivList) {
        return this.selectMulti(this.getSQL_getPSDEOPPrivsBySystem(strPSSystemId), psDEOPPrivList, PSDEOPPriv.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getPSDEOPPrivsBySystem(String strPSSystemId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSDEOPPRIV t1  where  t1.PSSYSTEMID='%1$s' AND  (t1.DEVALIDFLAG IS NULL OR t1.DEVALIDFLAG = 1) AND (t1.DERVALIDFLAG IS NULL OR T1.DERVALIDFLAG = 1) ", (Object)strPSSystemId);
    }

    @Override
    public CallResult getPSEditorType(String strPSEditorTypeId, PSEditorType psEditorType) {
        return this.selectSingle(this.getSQL_getPSEditorType(strPSEditorTypeId), (IEntity)psEditorType, USER_SYSTEM);
    }

    protected String getSQL_getPSEditorType(String strPSEditorTypeId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSEDITORTYPE t1 where  t1.PSEDITORTYPEID='%1$s'", (Object)strPSEditorTypeId);
    }

    @Override
    public CallResult getPSDBValueOP(String strPSDBValueOPId, PSDBValueOP psDBValueOP) {
        return this.selectSingle(this.getSQL_getPSDBValueOP(strPSDBValueOPId), (IEntity)psDBValueOP, USER_SYSTEM);
    }

    protected String getSQL_getPSDBValueOP(String strPSDBValueOPId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSDBVALUEOP t1 where  t1.PSDBVALUEOPID='%1$s'", (Object)strPSDBValueOPId);
    }

    @Override
    public CallResult getPSCounter(String strPSCounterId, PSCounter psCounter) {
        return this.selectSingle(this.getSQL_getPSCounter(strPSCounterId), (IEntity)psCounter, USER_SYSTEM);
    }

    protected String getSQL_getPSCounter(String strPSCounterId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSCOUNTER t1 where  t1.PSCOUNTERID='%1$s'", (Object)strPSCounterId);
    }

    @Override
    public CallResult getPSPortletType(String strPSPortletTypeId, PSPortletType psPortletType) {
        return this.selectSingle(this.getSQL_getPSPortletType(strPSPortletTypeId), (IEntity)psPortletType, USER_SYSTEM);
    }

    protected String getSQL_getPSPortletType(String strPSPortletTypeId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSPORTLETTYPE t1 where  t1.PSPORTLETTYPEID='%1$s'", (Object)strPSPortletTypeId);
    }

    @Override
    public CallResult getPSFormDetailType(String strPSFormDetailTypeId, PSFormDetailType psFormDetailType) {
        return this.selectSingle(this.getSQL_getPSFormDetailType(strPSFormDetailTypeId), (IEntity)psFormDetailType, USER_SYSTEM);
    }

    protected String getSQL_getPSFormDetailType(String strPSFormDetailTypeId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSFORMDETAILTYPE t1 where  t1.PSFORMDETAILTYPEID='%1$s'", (Object)strPSFormDetailTypeId);
    }

    @Override
    public CallResult getPSFormType(String strPSFormTypeId, PSFormType psFormType) {
        return this.selectSingle(this.getSQL_getPSFormType(strPSFormTypeId), (IEntity)psFormType, USER_SYSTEM);
    }

    protected String getSQL_getPSFormType(String strPSFormTypeId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSFORMTYPE t1 where  t1.PSFORMTYPEID='%1$s'", (Object)strPSFormTypeId);
    }

    @Override
    public CallResult getPSFDLogicType(String strPSFDLogicTypeId, PSFDLogicType psFDLogicType) {
        return this.selectSingle(this.getSQL_getPSFDLogicType(strPSFDLogicTypeId), (IEntity)psFDLogicType, USER_SYSTEM);
    }

    protected String getSQL_getPSFDLogicType(String strPSFDLogicTypeId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSFDLOGICTYPE t1 where  t1.PSFDLOGICTYPEID='%1$s'", (Object)strPSFDLogicTypeId);
    }

    @Override
    public CallResult getPSControlType(String strPSControlTypeId, PSControlType psControlType) {
        return this.selectSingle(this.getSQL_getPSControlType(strPSControlTypeId), (IEntity)psControlType, USER_SYSTEM);
    }

    protected String getSQL_getPSControlType(String strPSControlTypeId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSCTRLTYPE t1 where  t1.PSCTRLTYPEID='%1$s'", (Object)strPSControlTypeId);
    }

    @Override
    public CallResult getPSToolbarItemType(String strPSToolbarItemTypeId, PSToolbarItemType psToolbarItemType) {
        return this.selectSingle(this.getSQL_getPSToolbarItemType(strPSToolbarItemTypeId), (IEntity)psToolbarItemType, USER_SYSTEM);
    }

    protected String getSQL_getPSToolbarItemType(String strPSToolbarItemTypeId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSTBITEMTYPE t1 where  t1.PSTBITEMTYPEID='%1$s'", (Object)strPSToolbarItemTypeId);
    }

    @Override
    public CallResult getPSDEGridColumnType(String strPSDEGridColumnTypeId, PSDEGridColumnType psDEGridColumnType) {
        return this.selectSingle(this.getSQL_getPSDEGridColumnType(strPSDEGridColumnTypeId), (IEntity)psDEGridColumnType, USER_SYSTEM);
    }

    protected String getSQL_getPSDEGridColumnType(String strPSDEGridColumnTypeId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSDEGCTYPE t1 where  t1.PSDEGCTYPEID='%1$s'", (Object)strPSDEGridColumnTypeId);
    }

    @Override
    public CallResult getPSAppMenuItemType(String strPSAppMenuItemTypeId, PSAppMenuItemType psAppMenuItemType) {
        return this.selectSingle(this.getSQL_getPSAppMenuItemType(strPSAppMenuItemTypeId), (IEntity)psAppMenuItemType, USER_SYSTEM);
    }

    protected String getSQL_getPSAppMenuItemType(String strPSAppMenuItemTypeId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSAMITEMTYPE t1 where  t1.PSAMITEMTYPEID='%1$s'", (Object)strPSAppMenuItemTypeId);
    }

    @Override
    public CallResult getPSDynaAppView(String strPSDynaAppViewId, PSDynaAppView psDynaAppView) {
        return this.selectSingle(this.getSQL_getPSDynaAppView(strPSDynaAppViewId), (IEntity)psDynaAppView, USER_SYSTEM);
    }

    protected String getSQL_getPSDynaAppView(String strPSDynaAppViewId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSDYNAAPPVIEW t1 where  t1.PSDYNAAPPVIEWID='%1$s'", (Object)strPSDynaAppViewId);
    }

    @Override
    public CallResult getAllPSAppViewLastModifyTimes(String strPSSysAppId, Vector<PSAppView> psPSAppViewList) {
        return this.selectMulti(this.getSQL_getAllPSDynaAppViewLastModifyTimes(strPSSysAppId), psPSAppViewList, PSAppView.class.getName(), USER_SYSTEM, true);
    }

    protected String getSQL_getAllPSAppViewLastModifyTimes(String strPSSysAppId) {
        return StringHelper.format((String)"select t1.PSAPPVIEWID,t1.UPDATEDATE from T_SRFPSAPPVIEW t1 where t1.PSSYSAPPID='%1$s' ", (Object)strPSSysAppId);
    }

    protected String getSQL_getAllPSDynaAppViewLastModifyTimes(String strPSSysAppId) {
        return StringHelper.format((String)"select t1.PSDYNAAPPVIEWID AS PSAPPVIEWID,t1.UPDATEDATE from T_SRFPSDYNAAPPVIEW t1 where t1.PSDYNAAPPID='%1$s' ", (Object)strPSSysAppId);
    }

    @Override
    public CallResult getPSAppModule(String strPSAppModuleId, PSAppModule psAppModule) {
        return this.selectSingle(this.getSQL_getPSAppModule(strPSAppModuleId), (IEntity)psAppModule, USER_SYSTEM);
    }

    protected String getSQL_getPSAppModule(String strPSAppModuleId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSAPPMODULE t1 where  t1.PSAPPMODULEID='%1$s'", (Object)strPSAppModuleId);
    }

    @Override
    public CallResult getAllPSAppModules(String strPSApplicationId, Vector<PSAppModule> psAppModules) {
        return this.selectMulti(this.getSQL_getAllPSAppModules(strPSApplicationId), psAppModules, PSAppModule.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getAllPSAppModules(String strPSApplicationId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSAPPMODULE t1 where  t1.PSSYSAPPID='%1$s'", (Object)strPSApplicationId);
    }

    @Override
    public CallResult getPSPF(String strPSPFId, PSPF psPF) {
        return this.selectSingle(this.getSQL_getPSPF(strPSPFId), (IEntity)psPF, USER_SYSTEM);
    }

    protected String getSQL_getPSPF(String strPSPFId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSPF t1 where  t1.PSPFID='%1$s'", (Object)strPSPFId);
    }

    @Override
    public CallResult getPSPFCtrlTemplDetails(String strPSPFCtrlTemplId, Vector<PSPFCtrlTemplDetail> psPFCtrlTemplDetailList) {
        return this.selectMulti(this.getSQL_getPSPFCtrlTemplDetails(strPSPFCtrlTemplId), psPFCtrlTemplDetailList, PSPFCtrlTemplDetail.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getPSPFCtrlTemplDetails(String strPSPFCtrlTemplId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSPFCTDETAIL t1 where  t1.PSPFCTRLTEMPLID='%1$s'", (Object)strPSPFCtrlTemplId);
    }

    @Override
    public CallResult getPSPFStyle(String strPSPFStyleId, PSPFStyle psPFStyle) {
        return this.selectSingle(this.getSQL_getPSPFStyle(strPSPFStyleId), (IEntity)psPFStyle, USER_SYSTEM);
    }

    protected String getSQL_getPSPFStyle(String strPSPFStyleId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSPFStyle t1 where  t1.PSPFStyleID='%1$s'", (Object)strPSPFStyleId);
    }

    @Override
    public CallResult getPSPFCtrlTemplsByPFStyle(String strPSPFStyleId, Vector<PSPFCtrlTempl> psPFViewTemplList) {
        return this.selectMulti(this.getSQL_getPSPFCtrlTemplsByPFStyle(strPSPFStyleId), psPFViewTemplList, PSPFCtrlTempl.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getPSPFCtrlTemplsByPFStyle(String strPSPFStyleId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSPFCTRLTEMPL t1 where t1.PSPFSTYLEID='%1$s' ", (Object)strPSPFStyleId);
    }

    @Override
    public CallResult getPSPFEditorTemplsByPFStyle(String strPSPFStyleId, Vector<PSPFEditorTempl> psPFViewTemplList) {
        return this.selectMulti(this.getSQL_getPSPFEditorTemplsByPFStyle(strPSPFStyleId), psPFViewTemplList, PSPFEditorTempl.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getPSPFEditorTemplsByPFStyle(String strPSPFStyleId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSPFEDITORTEMPL t1 where t1.PSPFSTYLEID='%1$s' ", (Object)strPSPFStyleId);
    }

    @Override
    public CallResult getPSPFPubCodes(String strPSPFId, Vector<PSPFPubCode> psPFPubCodeList) {
        return this.selectMulti(this.getSQL_getPSPFPubCodes(strPSPFId), psPFPubCodeList, PSPFPubCode.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getPSPFPubCodes(String strPSPFId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSPFPUBCODE t1 where  t1.PSPFID='%1$s' ", (Object)strPSPFId);
    }

    @Override
    public CallResult getPSPFPubCode(String strPSPFPubCodeId, PSPFPubCode psPFPubCode) {
        return this.selectSingle(this.getSQL_getPSPFPubCode(strPSPFPubCodeId), (IEntity)psPFPubCode, USER_SYSTEM);
    }

    protected String getSQL_getPSPFPubCode(String strPSPFPubCodeId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSPFPUBCODE t1 where  t1.PSPFPUBCODEID='%1$s'", (Object)strPSPFPubCodeId);
    }

    @Override
    public CallResult getPSPFEditorTemplsByPF(String strPSPFId, Vector<PSPFEditorTempl> psPFViewTemplList) {
        return this.selectMulti(this.getSQL_getPSPFEditorTemplsByPF(strPSPFId), psPFViewTemplList, PSPFEditorTempl.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getPSPFEditorTemplsByPF(String strPSPFId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSPFEDITORTEMPL t1 where t1.PSPFID='%1$s' and t1.PSPFSTYLEID IS NULL ", (Object)strPSPFId);
    }

    @Override
    public CallResult getPSPFPubCodesByPPSPFPubCode(String strPSPFPubCodeId, Vector<PSPFPubCode> psPFPubCodeList) {
        return this.selectMulti(this.getSQL_getPSPFPubCodesByPPSPFPubCode(strPSPFPubCodeId), psPFPubCodeList, PSPFPubCode.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getPSPFPubCodesByPPSPFPubCode(String strPSPFPubCodeId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSPFPUBCODE t1 where  t1.PPSPFPUBCODEID='%1$s' ", (Object)strPSPFPubCodeId);
    }

    @Override
    public CallResult getPSPFPluginTempl(String strPSPFPluginTemplId, PSPFPluginTempl psPFPluginTempl) {
        return this.selectSingle(this.getSQL_getPSPFPluginTempl(strPSPFPluginTemplId), (IEntity)psPFPluginTempl, USER_SYSTEM);
    }

    protected String getSQL_getPSPFPluginTempl(String strPSPFPluginTemplId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSPFPLUGINTEMPL t1 where  t1.PSPFPLUGINTEMPLID='%1$s'", (Object)strPSPFPluginTemplId);
    }

    @Override
    public CallResult getPSSysPFPlugin(String strPSSysPFPluginId, PSSysPFPlugin psSysPFPlugin) {
        return this.selectSingle(this.getSQL_getPSSysPFPlugin(strPSSysPFPluginId), (IEntity)psSysPFPlugin, USER_SYSTEM);
    }

    protected String getSQL_getPSSysPFPlugin(String strPSSysPFPluginId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSSYSPFPLUGIN t1 where  t1.PSSYSPFPLUGINID='%1$s'", (Object)strPSSysPFPluginId);
    }

    @Override
    public CallResult getPSSysPFPluginTempl(String strPSSysPFPluginTemplId, PSSysPFPluginTempl psSysPFPluginTempl) {
        return this.selectSingle(this.getSQL_getPSSysPFPluginTempl(strPSSysPFPluginTemplId), (IEntity)psSysPFPluginTempl, USER_SYSTEM);
    }

    protected String getSQL_getPSSysPFPluginTempl(String strPSSysPFPluginTemplId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSSYSPFPITEMPL t1 where  t1.PSSYSPFPITEMPLID='%1$s'", (Object)strPSSysPFPluginTemplId);
    }

    @Override
    public CallResult getAllPSSysPFPluginTempls(String strPSSystemId, Vector<PSSysPFPluginTempl> psSysPFPluginTemplList) {
        return this.selectMulti(this.getSQL_getAllPSSysPFPluginTempls(strPSSystemId), psSysPFPluginTemplList, PSSysPFPluginTempl.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getAllPSSysPFPluginTempls(String strPSSystemId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSSYSPFPITEMPL t1   inner join T_SRFPSSYSPFPLUGIN t2 on t1.PSSYSPFPLUGINID = t2.PSSYSPFPLUGINID   where t2.PSSYSTEMID='%1$s'", (Object)strPSSystemId);
    }

    @Override
    public CallResult getPSWorkflow(String strPSWorkflowId, PSWorkflow psWorkflow) {
        return this.selectSingle(this.getSQL_getPSWorkflow(strPSWorkflowId), (IEntity)psWorkflow, USER_SYSTEM);
    }

    protected String getSQL_getPSWorkflow(String strPSWorkflowId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSWORKFLOW t1 where  t1.PSWORKFLOWID='%1$s'", (Object)strPSWorkflowId);
    }

    @Override
    public CallResult getAllPSSysPFPlugins(String strPSSystemId, Vector<PSSysPFPlugin> psSysPFPluginList) {
        return this.selectMulti(this.getSQL_getAllPSSysPFPlugins(strPSSystemId), psSysPFPluginList, PSSysPFPlugin.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getAllPSSysPFPlugins(String strPSSystemId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSSYSPFPLUGIN t1 where t1.PSSYSTEMID='%1$s' ", (Object)strPSSystemId);
    }

    @Override
    public CallResult getPSDynaInst(String strPSDynaInstId, PSDynaInst psDynaInst) {
        return this.selectSingle(this.getSQL_getPSDynaInst(strPSDynaInstId), (IEntity)psDynaInst, USER_SYSTEM);
    }

    protected String getSQL_getPSDynaInst(String strPSDynaInstId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSDYNAINST t1 where  t1.PSDYNAINSTID='%1$s'", (Object)strPSDynaInstId);
    }

    @Override
    public CallResult getAllPSAppPDTViews(String strPSApplicationId, Vector<PSAppPDTView> psAppPDTViews) {
        return this.selectMulti(this.getSQL_getAllPSAppPDTViews(strPSApplicationId), psAppPDTViews, PSAppPDTView.class.getName(), USER_SYSTEM);
    }

    protected String getSQL_getAllPSAppPDTViews(String strPSApplicationId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSAPPPDTVIEW t1 where  t1.PSSYSAPPID='%1$s' AND t1.VALIDFLAG = 1", (Object)strPSApplicationId);
    }

    @Override
    public CallResult getPSAppPDTView(String strPSAppPDTViewId, PSAppPDTView psAppPDTView) {
        return this.selectSingle(this.getSQL_getPSAppPDTView(strPSAppPDTViewId), (IEntity)psAppPDTView, USER_SYSTEM);
    }

    protected String getSQL_getPSAppPDTView(String strPSAppPDTViewId) {
        return StringHelper.format((String)"select t1.* from V_SRFPSAPPPDTVIEW t1 where  t1.PSAPPPDTVIEWID='%1$s' AND t1.VALIDFLAG = 1", (Object)strPSAppPDTViewId);
    }

    @Override
    public CallResult getPSDataEntityTagsByDynaInst(String strDynaInstId, int nStart, int nPageSize, Vector<PSDataEntity> psDataEntities) {
        return this.selectMulti(this.getSQL_getPSDataEntityTagsByDynaInst(strDynaInstId, nStart, nPageSize), psDataEntities, PSDataEntity.class.getName(), USER_SYSTEM, true);
    }

    protected String getSQL_getPSDataEntityTagsByDynaInst(String strDynaInstId, int nStart, int nPageSize) {
        return StringHelper.format((String)"SELECT PSDATAENTITYID,UPDATEDATE FROM T_SRFPSDATAENTITY WHERE PSDYNAINSTID IS NOT NULL AND PSDYNAINSTID='%1$s'", (Object)strDynaInstId);
    }

    @Override
    public CallResult getPSDEFormTagsByDynaInst(String strDynaInstId, int nStart, int nPageSize, Vector<PSDEForm> psForms) {
        return this.selectMulti(this.getSQL_getPSDEFormTagsByDynaInst(strDynaInstId, nStart, nPageSize), psForms, PSDEForm.class.getName(), USER_SYSTEM, true);
    }

    protected String getSQL_getPSDEFormTagsByDynaInst(String strDynaInstId, int nStart, int nPageSize) {
        return StringHelper.format((String)"SELECT PSDEFORMID,UPDATEDATE FROM T_SRFPSDEFORM WHERE PSDYNAINSTID IS NOT NULL AND PSDYNAINSTID='%1$s'", (Object)strDynaInstId);
    }

    @Override
    public CallResult getPSDEViewBaseTagsByDynaInst(String strDynaInstId, int nStart, int nPageSize, Vector<PSDEViewBase> psViewBases) {
        return this.selectMulti(this.getSQL_getPSDEViewBaseTagsByDynaInst(strDynaInstId, nStart, nPageSize), psViewBases, PSDEViewBase.class.getName(), USER_SYSTEM, true);
    }

    protected String getSQL_getPSDEViewBaseTagsByDynaInst(String strDynaInstId, int nStart, int nPageSize) {
        return StringHelper.format((String)"SELECT PSDEVIEWBASEID,UPDATEDATE FROM T_SRFPSDEVIEWBASE WHERE PSDYNAINSTID IS NOT NULL AND PSDYNAINSTID='%1$s'", (Object)strDynaInstId);
    }

    @Override
    public CallResult getPSWFVersionTagsByDynaInst(String strDynaInstId, int nStart, int nPageSize, Vector<PSWFVersion> psWFVersions) {
        return this.selectMulti(this.getSQL_getPSWFVersionTagsByDynaInst(strDynaInstId, nStart, nPageSize), psWFVersions, PSWFVersion.class.getName(), USER_SYSTEM, true);
    }

    protected String getSQL_getPSWFVersionTagsByDynaInst(String strDynaInstId, int nStart, int nPageSize) {
        return StringHelper.format((String)"SELECT PSWFVERSIONID,UPDATEDATE FROM T_SRFPSWFVERSION WHERE PSDYNAINSTID IS NOT NULL AND PSDYNAINSTID='%1$s'", (Object)strDynaInstId);
    }

    protected CallResult selectSingle(String strSQL, IEntity dataEntity, String strOpPersonId) {
        this.active();
        CallResult callResult = new CallResult();
        try {
            long nBeginTime = System.currentTimeMillis();
            strSQL = strSQL.replace(" V_SRFPS", " V_PS");
            SessionFactoryManager.addRef();
            DBCallResult dbCallResult = this.getDAO().executeRawSql(null, strSQL, null);
            if (dbCallResult.getDataSet() == null || dbCallResult.getDataSet().getDataTableCount() == 0) {
                SessionFactoryManager.releaseRef((boolean)false);
                callResult.setRetCode(3);
                return callResult;
            }
            dbCallResult.getDataSet().cacheDataRow();
            IDataTable iDataTable = dbCallResult.getDataSet().getDataTable(0);
            if (iDataTable.getCachedRowCount() == 0) {
                SessionFactoryManager.releaseRef((boolean)false);
                callResult.setRetCode(3);
                return callResult;
            }
            IDataRow iDataRow = iDataTable.getCachedRow(0);
            this.fromDataRow(dataEntity, iDataRow, true);
            callResult.setRetCode(0);
            SessionFactoryManager.releaseRef((boolean)true);
            log.debug((Object)StringHelper.format((String)"\u8017\u65f6[%1$s]ms", (Object)(System.currentTimeMillis() - nBeginTime)));
            return callResult;
        }
        catch (Exception ex) {
            if (this.getSessionFactory() != null) {
                SessionFactoryManager.releaseRef((boolean)false);
            }
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected CallResult selectMulti(String strSQL, Vector list, String strObjectName, String strOpPersonId) {
        return this.selectMulti(strSQL, list, strObjectName, strOpPersonId, false);
    }

    protected CallResult selectMulti(String strSQL, Vector list, String strObjectName, String strOpPersonId, boolean bSystemFields) {
        this.active();
        CallResult callResult = new CallResult();
        try {
            Object objSample = null;
            boolean bEntityMode = false;
            if (!StringHelper.isNullOrEmpty((String)strObjectName) && (objSample = ObjectHelper.create((String)strObjectName)) instanceof IEntity) {
                bEntityMode = true;
            }
            long nBeginTime = System.currentTimeMillis();
            strSQL = strSQL.replace(" V_SRFPS", " V_PS");
            SessionFactoryManager.addRef();
            DBCallResult dbCallResult = this.getDAO().executeRawSql(null, strSQL, null);
            if (dbCallResult.getDataSet() == null || dbCallResult.getDataSet().getDataTableCount() == 0) {
                SessionFactoryManager.releaseRef((boolean)false);
                callResult.setRetCode(3);
                return callResult;
            }
            dbCallResult.getDataSet().cacheDataRow();
            IDataTable iDataTable = dbCallResult.getDataSet().getDataTable(0);
            int i = 0;
            while (i < iDataTable.getCachedRowCount()) {
                Object dataEntity;
                IDataRow iDataRow = iDataTable.getCachedRow(i);
                if (bEntityMode) {
                    dataEntity = (IEntity)objSample.getClass().newInstance();
                    this.fromDataRow((IEntity)dataEntity, iDataRow, bSystemFields);
                    list.add(dataEntity);
                } else {
                    dataEntity = null;
                    if (objSample != null) {
                        dataEntity = (BaseDataEntity)((Object)objSample.getClass().newInstance());
                    } else {
                        Object obj;
                        if (!StringHelper.isNullOrEmpty((String)strObjectName) && (obj = ObjectHelper.create((String)strObjectName)) != null && obj instanceof BaseDataEntity) {
                            dataEntity = (BaseDataEntity)((Object)obj);
                        }
                        if (dataEntity == null) {
                            dataEntity = new BaseDataEntity();
                        }
                    }
                    this.fromDataRow((BaseDataEntity)((Object)dataEntity), iDataRow, bSystemFields);
                    list.add(dataEntity);
                }
                ++i;
            }
            SessionFactoryManager.releaseRef((boolean)true);
            callResult.setRetCode(0);
            log.debug((Object)StringHelper.format((String)"selectSingle \u8017\u65f6[%1$s]ms\r\n%2$s", (Object)(System.currentTimeMillis() - nBeginTime), (Object)strSQL));
            return callResult;
        }
        catch (Exception ex) {
            if (this.getSessionFactory() != null) {
                SessionFactoryManager.releaseRef((boolean)false);
            }
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected final void fromDataRow(BaseDataEntity dataEntity, IDataRow dr, boolean bSystemFields) throws Exception {
        if (dr == null) {
            throw new Exception("\u65e0\u6548\u6570\u636e\u96c6\u5408");
        }
        IDataTable dataTable = dr.getDataTable();
        if (dataTable != null) {
            int nColumnCount = dataTable.getColumnCount();
            int i = 0;
            while (i < nColumnCount) {
                String strColumnName;
                IDataColumn dataColumn = dataTable.getDataColumn(i);
                if (!dr.isDBNull(i) && StringHelper.compare((String)(strColumnName = dataColumn.getName()), (String)"CREATEMAN", (boolean)true) != 0 && StringHelper.compare((String)strColumnName, (String)"UPDATEMAN", (boolean)true) != 0 && (bSystemFields || StringHelper.compare((String)strColumnName, (String)"CREATEDATE", (boolean)true) != 0 && StringHelper.compare((String)strColumnName, (String)"UPDATEDATE", (boolean)true) != 0)) {
                    dataEntity.setParamValue(dataColumn.getName(), dr.get(i));
                }
                ++i;
            }
        }
    }

    protected final void fromDataRow(IEntity dataEntity, IDataRow dr, boolean bSystemFields) throws Exception {
        if (dr == null) {
            throw new Exception("\u65e0\u6548\u6570\u636e\u96c6\u5408");
        }
        IDataTable dataTable = dr.getDataTable();
        if (dataTable != null) {
            int nColumnCount = dataTable.getColumnCount();
            int i = 0;
            while (i < nColumnCount) {
                String strColumnName;
                IDataColumn dataColumn = dataTable.getDataColumn(i);
                if (!dr.isDBNull(i) && StringHelper.compare((String)(strColumnName = dataColumn.getName()), (String)"CREATEMAN", (boolean)true) != 0 && StringHelper.compare((String)strColumnName, (String)"UPDATEMAN", (boolean)true) != 0 && (bSystemFields || StringHelper.compare((String)strColumnName, (String)"CREATEDATE", (boolean)true) != 0 && StringHelper.compare((String)strColumnName, (String)"UPDATEDATE", (boolean)true) != 0)) {
                    dataEntity.set(dataColumn.getName(), dr.get(i));
                }
                ++i;
            }
        }
    }
}

