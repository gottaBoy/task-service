/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model;

import java.io.File;
import java.util.HashMap;
import java.util.Vector;
import net.ibizsys.model.IPSModelQueryHelper;
import net.ibizsys.model.IPSModelQueryHelperContainer;
import net.ibizsys.model.PSModelQueryHelperProxyBase;
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
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSModelQueryHelperProxy
extends PSModelQueryHelperProxyBase
implements IPSModelQueryHelper,
IPSModelQueryHelperContainer {
    private static final Log log = LogFactory.getLog(PSModelQueryHelperProxy.class);
    private IPSModelQueryHelper iPSModelQueryHelper = null;
    private String strInstId = null;
    private String strCacheFolder = null;
    private boolean bGlobalMode = false;
    private boolean bDynaInstMode = false;
    private HashMap<String, IPSModelQueryHelper> dynaInstPSModelQueryHelperMap = new HashMap();
    private HashMap<String, String> psDataEntityTagMap = null;
    private HashMap<String, String> psDEViewBaseTagMap = null;
    private HashMap<String, String> psDEFormTagMap = null;
    private HashMap<String, String> psWFVersionTagMap = null;
    private String strPSDynaInstId = null;

    public PSModelQueryHelperProxy(String strInstId, IPSModelQueryHelper iPSModelQueryHelper, String strCacheFolderRoot, String strPSDynaInstId) throws Exception {
        File cacheFolder;
        this.iPSModelQueryHelper = iPSModelQueryHelper;
        this.strInstId = strInstId;
        if (StringHelper.isNullOrEmpty((String)this.strInstId)) {
            this.strInstId = "_GLOBAL_";
            this.bGlobalMode = true;
        } else if (!StringHelper.isNullOrEmpty((String)strPSDynaInstId)) {
            this.bDynaInstMode = true;
            this.strPSDynaInstId = strPSDynaInstId;
        }
        String strCacheFolder = StringHelper.format((String)"%1$s%2$s%3$s", (Object)strCacheFolderRoot, (Object)File.separator, (Object)this.strInstId);
        if (!StringHelper.isNullOrEmpty((String)strPSDynaInstId)) {
            strCacheFolder = StringHelper.format((String)"%1$s%2$s%3$s", (Object)strCacheFolderRoot, (Object)File.separator, (Object)strPSDynaInstId);
        }
        if (!(cacheFolder = new File(strCacheFolder)).exists()) {
            cacheFolder.mkdirs();
        }
        if (!cacheFolder.exists()) {
            throw new Exception(StringHelper.format((String)"\u7f13\u5b58\u76ee\u5f55[%1$s]\u4e0d\u5b58\u5728", (Object)strCacheFolder));
        }
        this.strCacheFolder = strCacheFolder;
    }

    @Override
    protected String getCacheFolder() {
        return this.strCacheFolder;
    }

    protected String getPSDynaInstId() {
        return this.strPSDynaInstId;
    }

    @Override
    public IPSModelQueryHelper getPSModelQueryHelper(String strPSDynaInstId) throws Exception {
        IPSModelQueryHelper iPSModelQueryHelper = this.dynaInstPSModelQueryHelperMap.get(strPSDynaInstId);
        if (iPSModelQueryHelper != null) {
            return iPSModelQueryHelper;
        }
        PSModelQueryHelperProxy psModelQueryHelperProxy = new PSModelQueryHelperProxy(this.strInstId, this.iPSModelQueryHelper, this.getCacheFolder(), strPSDynaInstId);
        this.dynaInstPSModelQueryHelperMap.put(strPSDynaInstId, psModelQueryHelperProxy);
        return psModelQueryHelperProxy;
    }

    @Override
    public void resetPSModelQueryHelper(String strPSDynaInstId) throws Exception {
        this.dynaInstPSModelQueryHelperMap.remove(strPSDynaInstId);
    }

    protected boolean isGlobalMode() {
        return this.bGlobalMode;
    }

    protected boolean isDynaInstMode() {
        return this.bDynaInstMode;
    }

    @Override
    protected IPSModelQueryHelper getHelper() {
        return this.iPSModelQueryHelper;
    }

    @Override
    public void active() {
        this.getHelper().active();
    }

    @Override
    public boolean isAlwaysActive() {
        return this.getHelper().isAlwaysActive();
    }

    @Override
    public void activeAlways() {
        this.getHelper().activeAlways();
    }

    @Override
    public long getLastActiveTime() {
        return this.getHelper().getLastActiveTime();
    }

    @Override
    public void setModelInstVer(int nModelInstVer) {
        this.getHelper().setModelInstVer(nModelInstVer);
    }

    @Override
    public void startLoadPSSysApp(String strPSSysAppId, int nLoadLevel) throws Exception {
        this.getHelper().startLoadPSSysApp(strPSSysAppId, nLoadLevel);
    }

    @Override
    public void stopLoadPSSysApp() throws Exception {
        this.getHelper().stopLoadPSSysApp();
    }

    @Override
    public void startLoadPSSystem(String strPSSystemId, int nLoadLevel) throws Exception {
        this.getHelper().startLoadPSSystem(strPSSystemId, nLoadLevel);
    }

    @Override
    public void stopLoadPSSystem() throws Exception {
        this.getHelper().stopLoadPSSystem();
    }

    @Override
    public CallResult getPSDBType(String strPSDBTypeId, PSDBType psDBType) {
        String strCacheCat = "getPSDBType";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSDBTypeId);
        CallResult callResult = this.readCache(strCacheCat, strCacheTag, psDBType);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSDBType(strPSDBTypeId, psDBType);
        if (callResult.isOk()) {
            this.writeCache(strCacheCat, strCacheTag, psDBType);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSSystem(String strPSSystemId, PSSystem psSystem) {
        String strCacheCat = "getPSSystem";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSSystemId);
        CallResult callResult = this.readCache(strCacheCat, strCacheTag, psSystem);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSSystem(strPSSystemId, psSystem);
        if (callResult.isOk()) {
            this.writeCache(strCacheCat, strCacheTag, psSystem);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSSysModelInst(String strPSSysModelInstId, PSSysModelInst psSysModelInst) {
        return this.getHelper().getPSSysModelInst(strPSSysModelInstId, psSysModelInst);
    }

    @Override
    public CallResult getPSAppViewRefs(String strPSAppViewId, Vector<PSAppViewRef> psAppViewRefList) {
        String strCacheCat = "getPSAppViewRefs";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSAppViewId);
        CallResult callResult = this.readCache2(strCacheCat, strCacheTag, PSAppViewRef.class, psAppViewRefList);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSAppViewRefs(strPSAppViewId, psAppViewRefList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psAppViewRefList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEViewBase(String strPSDEViewBaseId, PSDEViewBase psDEViewBase) {
        CallResult callResult = this.getPSDEViewBaseTag(strPSDEViewBaseId);
        if (callResult.isError()) {
            return callResult;
        }
        String strCacheCat = "getPSDEViewBase";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSDEViewBaseId, (String)((String)callResult.getUserObject()));
        if ((callResult = this.readCache(strCacheCat, strCacheTag, psDEViewBase)) != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSDEViewBase(strPSDEViewBaseId, psDEViewBase);
        if (callResult.isOk()) {
            this.writeCache(strCacheCat, strCacheTag, psDEViewBase);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEViewViews(String strPSDEViewId, Vector<PSDEViewView> psDEViewViewList) {
        CallResult callResult = this.getPSDEViewBaseTag(strPSDEViewId);
        if (callResult.isError()) {
            return callResult;
        }
        String strCacheCat = "getPSDEViewViews";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSDEViewId, (String)((String)callResult.getUserObject()));
        if ((callResult = this.readCache2(strCacheCat, strCacheTag, PSDEViewView.class, psDEViewViewList)) != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSDEViewViews(strPSDEViewId, psDEViewViewList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psDEViewViewList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEViewCtrls(String strPSDEViewId, Vector<PSDEViewCtrl> psDEViewCtrlList) {
        CallResult callResult = this.getPSDEViewBaseTag(strPSDEViewId);
        if (callResult.isError()) {
            return callResult;
        }
        String strCacheCat = "getPSDEViewCtrls";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSDEViewId, (String)((String)callResult.getUserObject()));
        if ((callResult = this.readCache2(strCacheCat, strCacheTag, PSDEViewCtrl.class, psDEViewCtrlList)) != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSDEViewCtrls(strPSDEViewId, psDEViewCtrlList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psDEViewCtrlList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSApplicationView(String strPSApplicationViewId, PSAppView psApplicationView) {
        String strCacheCat = "getPSApplicationView";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSApplicationViewId);
        CallResult callResult = this.readCache(strCacheCat, strCacheTag, psApplicationView);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSApplicationView(strPSApplicationViewId, psApplicationView);
        if (callResult.isOk()) {
            this.writeCache(strCacheCat, strCacheTag, psApplicationView);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSAppIndexView(String strPSAppIndexViewId, PSAppIndexView psAppIndexView) {
        String strCacheCat = "getPSAppIndexView";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSAppIndexViewId);
        CallResult callResult = this.readCache(strCacheCat, strCacheTag, psAppIndexView);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSAppIndexView(strPSAppIndexViewId, psAppIndexView);
        if (callResult.isOk()) {
            this.writeCache(strCacheCat, strCacheTag, psAppIndexView);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSAppPortalView(String strPSAppPortalViewId, PSAppPortalView psAppPortalView) {
        String strCacheCat = "getPSAppPortalView";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSAppPortalViewId);
        CallResult callResult = this.readCache(strCacheCat, strCacheTag, psAppPortalView);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSAppPortalView(strPSAppPortalViewId, psAppPortalView);
        if (callResult.isOk()) {
            this.writeCache(strCacheCat, strCacheTag, psAppPortalView);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSAppMenuItems(String strPSAppMenuId, Vector<PSAppMenuItem> psAppMenuItemList) {
        String strCacheCat = "getPSAppMenuItems";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSAppMenuId);
        CallResult callResult = this.readCache2(strCacheCat, strCacheTag, PSAppMenuItem.class, psAppMenuItemList);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSAppMenuItems(strPSAppMenuId, psAppMenuItemList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psAppMenuItemList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSAppMenu(String strPSAppMenuId, PSAppMenu psAppMenu) {
        String strCacheCat = "getPSAppMenu";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSAppMenuId);
        CallResult callResult = this.readCache(strCacheCat, strCacheTag, psAppMenu);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSAppMenu(strPSAppMenuId, psAppMenu);
        if (callResult.isOk()) {
            this.writeCache(strCacheCat, strCacheTag, psAppMenu);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEGrid(String strPSDEGridId, PSDEGrid psDEGrid) {
        String strCacheCat = "getPSDEGrid";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSDEGridId);
        CallResult callResult = this.readCache(strCacheCat, strCacheTag, psDEGrid);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSDEGrid(strPSDEGridId, psDEGrid);
        if (callResult.isOk()) {
            this.writeCache(strCacheCat, strCacheTag, psDEGrid);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEToolbar(String strPSDEToolbarId, PSDEToolbar psDEToolbar) {
        String strCacheCat = "getPSDEToolbar";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSDEToolbarId);
        CallResult callResult = this.readCache(strCacheCat, strCacheTag, psDEToolbar);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSDEToolbar(strPSDEToolbarId, psDEToolbar);
        if (callResult.isOk()) {
            this.writeCache(strCacheCat, strCacheTag, psDEToolbar);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEFormItemVRs(String strPSDEFormId, Vector<PSDEFormItemVR> psDEFormItemVRList) {
        CallResult callResult = this.getPSDEFormTag(strPSDEFormId);
        if (callResult.isError()) {
            return callResult;
        }
        String strCacheCat = "getPSDEFormItemVRs";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSDEFormId, (String)((String)callResult.getUserObject()));
        if ((callResult = this.readCache2(strCacheCat, strCacheTag, PSDEFormItemVR.class, psDEFormItemVRList)) != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSDEFormItemVRs(strPSDEFormId, psDEFormItemVRList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psDEFormItemVRList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEFIUDetails(String strPSDEFormId, Vector<PSDEFIUDetail> psDEFIUDetailList) {
        CallResult callResult = this.getPSDEFormTag(strPSDEFormId);
        if (callResult.isError()) {
            return callResult;
        }
        String strCacheCat = "getPSDEFIUDetails";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSDEFormId, (String)((String)callResult.getUserObject()));
        if ((callResult = this.readCache2(strCacheCat, strCacheTag, PSDEFIUDetail.class, psDEFIUDetailList)) != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSDEFIUDetails(strPSDEFormId, psDEFIUDetailList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psDEFIUDetailList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEFIUpdates(String strPSDEFormId, Vector<PSDEFIUpdate> psDEFIUpdateList) {
        CallResult callResult = this.getPSDEFormTag(strPSDEFormId);
        if (callResult.isError()) {
            return callResult;
        }
        String strCacheCat = "getPSDEFIUpdates";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSDEFormId, (String)((String)callResult.getUserObject()));
        if ((callResult = this.readCache2(strCacheCat, strCacheTag, PSDEFIUpdate.class, psDEFIUpdateList)) != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSDEFIUpdates(strPSDEFormId, psDEFIUpdateList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psDEFIUpdateList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEFormDetails(String strPSDEFormId, Vector<PSDEFormDetail> psDEFormDetailList) {
        CallResult callResult = this.getPSDEFormTag(strPSDEFormId);
        if (callResult.isError()) {
            return callResult;
        }
        String strCacheCat = "getPSDEFormDetails";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSDEFormId, (String)((String)callResult.getUserObject()));
        if ((callResult = this.readCache2(strCacheCat, strCacheTag, PSDEFormDetail.class, psDEFormDetailList)) != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSDEFormDetails(strPSDEFormId, psDEFormDetailList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psDEFormDetailList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEForm(String strPSDEFormId, PSDEForm psDEForm) {
        CallResult callResult = this.getPSDEFormTag(strPSDEFormId);
        if (callResult.isError()) {
            return callResult;
        }
        String strCacheCat = "getPSDEForm";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSDEFormId, (String)((String)callResult.getUserObject()));
        if ((callResult = this.readCache(strCacheCat, strCacheTag, psDEForm)) != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSDEForm(strPSDEFormId, psDEForm);
        if (callResult.isOk()) {
            this.writeCache(strCacheCat, strCacheTag, psDEForm);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEFDLogics(String strPSDEFormId, Vector<PSDEFDLogic> psDEFDLogicList) {
        CallResult callResult = this.getPSDEFormTag(strPSDEFormId);
        if (callResult.isError()) {
            return callResult;
        }
        String strCacheCat = "getPSDEFDLogics";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSDEFormId, (String)((String)callResult.getUserObject()));
        if ((callResult = this.readCache2(strCacheCat, strCacheTag, PSDEFDLogic.class, psDEFDLogicList)) != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSDEFDLogics(strPSDEFormId, psDEFDLogicList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psDEFDLogicList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEGridColumns(String strPSDEGridId, Vector<PSDEGridColumn> psDEGridColumnList) {
        String strCacheCat = "getPSDEGridColumns";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSDEGridId);
        CallResult callResult = this.readCache2(strCacheCat, strCacheTag, PSDEGridColumn.class, psDEGridColumnList);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSDEGridColumns(strPSDEGridId, psDEGridColumnList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psDEGridColumnList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEGEIUpdates(String strPSDEGridId, Vector<PSDEGEIUpdate> psDEGEIUpdateList) {
        String strCacheCat = "getPSDEGEIUpdates";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSDEGridId);
        CallResult callResult = this.readCache2(strCacheCat, strCacheTag, PSDEGEIUpdate.class, psDEGEIUpdateList);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSDEGEIUpdates(strPSDEGridId, psDEGEIUpdateList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psDEGEIUpdateList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEGEIUDetails(String strPSDEGridId, Vector<PSDEGEIUDetail> psDEGEIUDetailList) {
        String strCacheCat = "getPSDEGEIUDetails";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSDEGridId);
        CallResult callResult = this.readCache2(strCacheCat, strCacheTag, PSDEGEIUDetail.class, psDEGEIUDetailList);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSDEGEIUDetails(strPSDEGridId, psDEGEIUDetailList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psDEGEIUDetailList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEToolbarItems(String strPSDEToolbarId, Vector<PSDEToolbarItem> psDEToolbarItemList) {
        String strCacheCat = "getPSDEToolbarItems";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSDEToolbarId);
        CallResult callResult = this.readCache2(strCacheCat, strCacheTag, PSDEToolbarItem.class, psDEToolbarItemList);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSDEToolbarItems(strPSDEToolbarId, psDEToolbarItemList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psDEToolbarItemList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSSysDashboard(String strPSSysDashboardId, PSSysDashboard psSysDashboard) {
        String strCacheCat = "getPSSysDashboard";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSSysDashboardId);
        CallResult callResult = this.readCache(strCacheCat, strCacheTag, psSysDashboard);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSSysDashboard(strPSSysDashboardId, psSysDashboard);
        if (callResult.isOk()) {
            this.writeCache(strCacheCat, strCacheTag, psSysDashboard);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSSysDashboardParts(String strPSSysDashboardId, Vector<PSSysDashboardPart> psSysDashboardPartList) {
        String strCacheCat = "getPSSysDashboardParts";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSSysDashboardId);
        CallResult callResult = this.readCache2(strCacheCat, strCacheTag, PSSysDashboardPart.class, psSysDashboardPartList);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSSysDashboardParts(strPSSysDashboardId, psSysDashboardPartList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psSysDashboardPartList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEList(String strPSDEListId, PSDEList psDEList) {
        String strCacheCat = "getPSDEList";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSDEListId);
        CallResult callResult = this.readCache(strCacheCat, strCacheTag, psDEList);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSDEList(strPSDEListId, psDEList);
        if (callResult.isOk()) {
            this.writeCache(strCacheCat, strCacheTag, psDEList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEListItems(String strPSDEListId, Vector<PSDEListItem> psDEListItemList) {
        String strCacheCat = "getPSDEListItems";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSDEListId);
        CallResult callResult = this.readCache2(strCacheCat, strCacheTag, PSDEListItem.class, psDEListItemList);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSDEListItems(strPSDEListId, psDEListItemList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psDEListItemList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEChart(String strPSDEChartId, PSDEChart psDEChart) {
        String strCacheCat = "getPSDEChart";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSDEChartId);
        CallResult callResult = this.readCache(strCacheCat, strCacheTag, psDEChart);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSDEChart(strPSDEChartId, psDEChart);
        if (callResult.isOk()) {
            this.writeCache(strCacheCat, strCacheTag, psDEChart);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEChartAxeses(String strPSDEChartId, Vector<PSDEChartAxes> psDEChartAxesList) {
        String strCacheCat = "getPSDEChartAxeses";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSDEChartId);
        CallResult callResult = this.readCache2(strCacheCat, strCacheTag, PSDEChartAxes.class, psDEChartAxesList);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSDEChartAxeses(strPSDEChartId, psDEChartAxesList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psDEChartAxesList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEChartSerieses(String strPSDEChartId, Vector<PSDEChartSeries> psDEChartSeriesList) {
        String strCacheCat = "getPSDEChartSerieses";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSDEChartId);
        CallResult callResult = this.readCache2(strCacheCat, strCacheTag, PSDEChartSeries.class, psDEChartSeriesList);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSDEChartSerieses(strPSDEChartId, psDEChartSeriesList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psDEChartSeriesList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSAppPortalViewParts(String strPSAppPortalViewId, Vector<PSAppPortalViewPart> psAppPortalViewPartList) {
        String strCacheCat = "getPSAppPortalViewParts";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSAppPortalViewId);
        CallResult callResult = this.readCache2(strCacheCat, strCacheTag, PSAppPortalViewPart.class, psAppPortalViewPartList);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSAppPortalViewParts(strPSAppPortalViewId, psAppPortalViewPartList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psAppPortalViewPartList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSDepSlnSys(String strPSDepSlnSysId, PSDepSlnSys psDepSlnSys) {
        return this.getHelper().getPSDepSlnSys(strPSDepSlnSysId, psDepSlnSys);
    }

    @Override
    public CallResult getPSCodeItems(String strPSCodeListId, Vector<PSCodeItem> psCodeItemList) {
        String strCacheCat = "getPSCodeItems";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSCodeListId);
        CallResult callResult = this.readCache2(strCacheCat, strCacheTag, PSCodeItem.class, psCodeItemList);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSCodeItems(strPSCodeListId, psCodeItemList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psCodeItemList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSCodeList(String strPSCodeListId, PSCodeList psCodeList) {
        String strCacheCat = "getPSCodeList";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSCodeListId);
        CallResult callResult = this.readCache(strCacheCat, strCacheTag, psCodeList);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSCodeList(strPSCodeListId, psCodeList);
        if (callResult.isOk()) {
            this.writeCache(strCacheCat, strCacheTag, psCodeList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getAllPSCodeLists(String strPSSystemId, Vector<PSCodeList> psCodeListList) {
        String strCacheCat = "getAllPSCodeLists";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSSystemId);
        CallResult callResult = this.readCache2(strCacheCat, strCacheTag, PSCodeList.class, psCodeListList);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getAllPSCodeLists(strPSSystemId, psCodeListList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psCodeListList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getAllPSSysCsses(String strPSSystemId, Vector<PSSysCss> psSysCssList) {
        String strCacheCat = "getAllPSSysCsses";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSSystemId);
        CallResult callResult = this.readCache2(strCacheCat, strCacheTag, PSSysCss.class, psSysCssList);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getAllPSSysCsses(strPSSystemId, psSysCssList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psSysCssList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSSysCss(String strPSSysCssId, PSSysCss psSysCss) {
        String strCacheCat = "getPSSysCss";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSSysCssId);
        CallResult callResult = this.readCache(strCacheCat, strCacheTag, psSysCss);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSSysCss(strPSSysCssId, psSysCss);
        if (callResult.isOk()) {
            this.writeCache(strCacheCat, strCacheTag, psSysCss);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getAllPSSysImages(String strPSSystemId, Vector<PSSysImage> psSysImageList) {
        String strCacheCat = "getAllPSSysImages";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSSystemId);
        CallResult callResult = this.readCache2(strCacheCat, strCacheTag, PSSysImage.class, psSysImageList);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getAllPSSysImages(strPSSystemId, psSysImageList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psSysImageList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSSysImage(String strPSSysImageId, PSSysImage psSysImage) {
        String strCacheCat = "getPSSysImage";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSSysImageId);
        CallResult callResult = this.readCache(strCacheCat, strCacheTag, psSysImage);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSSysImage(strPSSysImageId, psSysImage);
        if (callResult.isOk()) {
            this.writeCache(strCacheCat, strCacheTag, psSysImage);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSSysWFSetting(String strPSSystemId, PSSysWFSetting psSysWFSetting) {
        String strCacheCat = "getPSSysWFSetting";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSSystemId);
        CallResult callResult = this.readCache(strCacheCat, strCacheTag, psSysWFSetting);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSSysWFSetting(strPSSystemId, psSysWFSetting);
        if (callResult.isOk()) {
            this.writeCache(strCacheCat, strCacheTag, psSysWFSetting);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSDataEntity(String strPSSystemId, String strPSDataEntityName, PSDataEntity psDataEntity) {
        String strCacheCat = "getPSDataEntity";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSSystemId, (String)strPSDataEntityName);
        CallResult callResult = this.readCache(strCacheCat, strCacheTag, psDataEntity);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSDataEntity(strPSSystemId, strPSDataEntityName, psDataEntity);
        if (callResult.isOk()) {
            this.writeCache(strCacheCat, strCacheTag, psDataEntity);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSDataEntity(String strPSDataEntityId, PSDataEntity psDataEntity) {
        CallResult callResult = this.getPSDataEntityTag(strPSDataEntityId);
        if (callResult.isError()) {
            return callResult;
        }
        String strCacheCat = "getPSDataEntity";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSDataEntityId, (String)((String)callResult.getUserObject()));
        if ((callResult = this.readCache(strCacheCat, strCacheTag, psDataEntity)) != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSDataEntity(strPSDataEntityId, psDataEntity);
        if (callResult.isOk()) {
            this.writeCache(strCacheCat, strCacheTag, psDataEntity);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSDER(String strPSDERId, PSDER psDER) {
        String strCacheCat = "getPSDER";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSDERId);
        CallResult callResult = this.readCache(strCacheCat, strCacheTag, psDER);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSDER(strPSDERId, psDER);
        if (callResult.isOk()) {
            this.writeCache(strCacheCat, strCacheTag, psDER);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEField(String strPSDEFieldId, PSDEField psDEField) {
        String strCacheCat = "getPSDEField";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSDEFieldId);
        CallResult callResult = this.readCache(strCacheCat, strCacheTag, psDEField);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSDEField(strPSDEFieldId, psDEField);
        if (callResult.isOk()) {
            this.writeCache(strCacheCat, strCacheTag, psDEField);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEFieldsNoSort(String strPSDataEntityId, Vector<PSDEField> psDEFieldList) {
        CallResult callResult = this.getPSDataEntityTag(strPSDataEntityId);
        if (callResult.isError()) {
            return callResult;
        }
        String strCacheCat = "getPSDEFieldsNoSort";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSDataEntityId, (String)((String)callResult.getUserObject()));
        if ((callResult = this.readCache2(strCacheCat, strCacheTag, PSDEField.class, psDEFieldList)) != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSDEFieldsNoSort(strPSDataEntityId, psDEFieldList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psDEFieldList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEAction(String strPSDEActionId, PSDEAction psDEAction) {
        String strCacheCat = "getPSDEAction";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSDEActionId);
        CallResult callResult = this.readCache(strCacheCat, strCacheTag, psDEAction);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSDEAction(strPSDEActionId, psDEAction);
        if (callResult.isOk()) {
            this.writeCache(strCacheCat, strCacheTag, psDEAction);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEActions(String strPSDataEntityId, Vector<PSDEAction> psDEActionList) {
        CallResult callResult = this.getPSDataEntityTag(strPSDataEntityId);
        if (callResult.isError()) {
            return callResult;
        }
        String strCacheCat = "getPSDEActions";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSDataEntityId, (String)((String)callResult.getUserObject()));
        if ((callResult = this.readCache2(strCacheCat, strCacheTag, PSDEAction.class, psDEActionList)) != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSDEActions(strPSDataEntityId, psDEActionList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psDEActionList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEActionParams(String strPSDEActionId, Vector<PSDEActionParam> psDEActionParamList) {
        String strCacheCat = "getPSDEActionParams";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSDEActionId);
        CallResult callResult = this.readCache2(strCacheCat, strCacheTag, PSDEActionParam.class, psDEActionParamList);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSDEActionParams(strPSDEActionId, psDEActionParamList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psDEActionParamList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEActionLogics(String strPSDEActionId, Vector<PSDEActionLogic> psDEActionLogicList) {
        String strCacheCat = "getPSDEActionLogics";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSDEActionId);
        CallResult callResult = this.readCache2(strCacheCat, strCacheTag, PSDEActionLogic.class, psDEActionLogicList);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSDEActionLogics(strPSDEActionId, psDEActionLogicList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psDEActionLogicList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSDELogic(String strPSDELogicId, PSDELogic psDELogic) {
        String strCacheCat = "getPSDELogic";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSDELogicId);
        CallResult callResult = this.readCache(strCacheCat, strCacheTag, psDELogic);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSDELogic(strPSDELogicId, psDELogic);
        if (callResult.isOk()) {
            this.writeCache(strCacheCat, strCacheTag, psDELogic);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEUIActionGroup(String strPSDEUIActionGroupId, PSDEUIActionGroup psDEUIActionGroup) {
        String strCacheCat = "getPSDEUIActionGroup";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSDEUIActionGroupId);
        CallResult callResult = this.readCache(strCacheCat, strCacheTag, psDEUIActionGroup);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSDEUIActionGroup(strPSDEUIActionGroupId, psDEUIActionGroup);
        if (callResult.isOk()) {
            this.writeCache(strCacheCat, strCacheTag, psDEUIActionGroup);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEUIAction(String strPSDEUIActionId, PSDEUIAction psDEUIAction) {
        String strCacheCat = "getPSDEUIAction";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSDEUIActionId);
        CallResult callResult = this.readCache(strCacheCat, strCacheTag, psDEUIAction);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSDEUIAction(strPSDEUIActionId, psDEUIAction);
        if (callResult.isOk()) {
            this.writeCache(strCacheCat, strCacheTag, psDEUIAction);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSSysDEUIActions(String strPSSystemId, Vector<PSDEUIAction> psDEUIActionList) {
        String strCacheCat = "getPSSysDEUIActions";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSSystemId);
        CallResult callResult = this.readCache2(strCacheCat, strCacheTag, PSDEUIAction.class, psDEUIActionList);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSSysDEUIActions(strPSSystemId, psDEUIActionList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psDEUIActionList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEUIActions(String strPSDataEntityId, Vector<PSDEUIAction> psDEUIActionList) {
        CallResult callResult = this.getPSDataEntityTag(strPSDataEntityId);
        if (callResult.isError()) {
            return callResult;
        }
        String strCacheCat = "getPSDEUIActions";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSDataEntityId, (String)((String)callResult.getUserObject()));
        if ((callResult = this.readCache2(strCacheCat, strCacheTag, PSDEUIAction.class, psDEUIActionList)) != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSDEUIActions(strPSDataEntityId, psDEUIActionList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psDEUIActionList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEACModes(String strPSDataEntityId, Vector<PSDEACMode> psDEACModeList) {
        CallResult callResult = this.getPSDataEntityTag(strPSDataEntityId);
        if (callResult.isError()) {
            return callResult;
        }
        String strCacheCat = "getPSDEACModes";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSDataEntityId, (String)((String)callResult.getUserObject()));
        if ((callResult = this.readCache2(strCacheCat, strCacheTag, PSDEACMode.class, psDEACModeList)) != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSDEACModes(strPSDataEntityId, psDEACModeList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psDEACModeList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEACMode(String strPSDEACModeId, PSDEACMode psDEACMode) {
        String strCacheCat = "getPSDEACMode";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSDEACModeId);
        CallResult callResult = this.readCache(strCacheCat, strCacheTag, psDEACMode);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSDEACMode(strPSDEACModeId, psDEACMode);
        if (callResult.isOk()) {
            this.writeCache(strCacheCat, strCacheTag, psDEACMode);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEUIActionGroups(String strPSDataEntityId, Vector<PSDEUIActionGroup> psDEUIActionGroupList) {
        CallResult callResult = this.getPSDataEntityTag(strPSDataEntityId);
        if (callResult.isError()) {
            return callResult;
        }
        String strCacheCat = "getPSDEUIActionGroups";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSDataEntityId, (String)((String)callResult.getUserObject()));
        if ((callResult = this.readCache2(strCacheCat, strCacheTag, PSDEUIActionGroup.class, psDEUIActionGroupList)) != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSDEUIActionGroups(strPSDataEntityId, psDEUIActionGroupList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psDEUIActionGroupList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEUIActionGroupDetails(String strPSDEUIActionGroupId, Vector<PSDEUIActionGroupDetail> psDEUIActionGroupDetailList) {
        String strCacheCat = "getPSDEUIActionGroupDetails";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSDEUIActionGroupId);
        CallResult callResult = this.readCache2(strCacheCat, strCacheTag, PSDEUIActionGroupDetail.class, psDEUIActionGroupDetailList);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSDEUIActionGroupDetails(strPSDEUIActionGroupId, psDEUIActionGroupDetailList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psDEUIActionGroupDetailList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEUIActionType(String strPSDEUIActionTypeId, PSDEUIActionType psDEUIActionType) {
        String strCacheCat = "getPSDEUIActionType";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSDEUIActionTypeId);
        CallResult callResult = this.readCache(strCacheCat, strCacheTag, psDEUIActionType);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSDEUIActionType(strPSDEUIActionTypeId, psDEUIActionType);
        if (callResult.isOk()) {
            this.writeCache(strCacheCat, strCacheTag, psDEUIActionType);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSSysDEUIActionGroups(String strPSSystemId, Vector<PSDEUIActionGroup> psDEUIActionGroupList) {
        String strCacheCat = "getPSSysDEUIActionGroups";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSSystemId);
        CallResult callResult = this.readCache2(strCacheCat, strCacheTag, PSDEUIActionGroup.class, psDEUIActionGroupList);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSSysDEUIActionGroups(strPSSystemId, psDEUIActionGroupList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psDEUIActionGroupList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEViews(String strPSDataEntityId, Vector<PSDEViewBase> psDEViewBaseList) {
        CallResult callResult = this.getPSDataEntityTag(strPSDataEntityId);
        if (callResult.isError()) {
            return callResult;
        }
        String strCacheCat = "getPSDEViews";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSDataEntityId, (String)((String)callResult.getUserObject()));
        if ((callResult = this.readCache2(strCacheCat, strCacheTag, PSDEViewBase.class, psDEViewBaseList)) != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSDEViews(strPSDataEntityId, psDEViewBaseList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psDEViewBaseList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEPredefinedViews(String strPSDataEntityId, Vector<PSDEViewBase> psDEViewBaseList) {
        CallResult callResult = this.getPSDataEntityTag(strPSDataEntityId);
        if (callResult.isError()) {
            return callResult;
        }
        String strCacheCat = "getPSDEPredefinedViews";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSDataEntityId, (String)((String)callResult.getUserObject()));
        if ((callResult = this.readCache2(strCacheCat, strCacheTag, PSDEViewBase.class, psDEViewBaseList)) != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSDEPredefinedViews(strPSDataEntityId, psDEViewBaseList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psDEViewBaseList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEPrints(String strPSDEId, Vector<PSDEPrint> psDEPrintList) {
        String strCacheCat = "getPSDEPrints";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSDEId);
        CallResult callResult = this.readCache2(strCacheCat, strCacheTag, PSDEPrint.class, psDEPrintList);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSDEPrints(strPSDEId, psDEPrintList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psDEPrintList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSDERs(String strPSDataEntityId, Vector<PSDER> psDERList) {
        CallResult callResult = this.getPSDataEntityTag(strPSDataEntityId);
        if (callResult.isError()) {
            return callResult;
        }
        String strCacheCat = "getPSDERs";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSDataEntityId, (String)((String)callResult.getUserObject()));
        if ((callResult = this.readCache2(strCacheCat, strCacheTag, PSDER.class, psDERList)) != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSDERs(strPSDataEntityId, psDERList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psDERList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEFUIModesByDataEntity(String strPSDEId, Vector<PSDEFUIMode> psDEFUIModeList) {
        String strCacheCat = "getPSDEFUIModesByDataEntity";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSDEId);
        CallResult callResult = this.readCache2(strCacheCat, strCacheTag, PSDEFUIMode.class, psDEFUIModeList);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSDEFUIModesByDataEntity(strPSDEId, psDEFUIModeList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psDEFUIModeList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEFSearchModesByDataEntity(String strPSDEId, Vector<PSDEFSearchMode> psDEFSearchModeList) {
        String strCacheCat = "getPSDEFSearchModesByDataEntity";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSDEId);
        CallResult callResult = this.readCache2(strCacheCat, strCacheTag, PSDEFSearchMode.class, psDEFSearchModeList);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSDEFSearchModesByDataEntity(strPSDEId, psDEFSearchModeList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psDEFSearchModeList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEFValueRulesByDataEntity(String strPSDEId, Vector<PSDEFValueRule> psDEFValueRuleList) {
        String strCacheCat = "getPSDEFValueRulesByDataEntity";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSDEId);
        CallResult callResult = this.readCache2(strCacheCat, strCacheTag, PSDEFValueRule.class, psDEFValueRuleList);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSDEFValueRulesByDataEntity(strPSDEId, psDEFValueRuleList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psDEFValueRuleList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEDataQuery(String strPSDEDataQueryId, PSDEDataQuery psDEDataQuery) {
        String strCacheCat = "getPSDEDataQuery";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSDEDataQueryId);
        CallResult callResult = this.readCache(strCacheCat, strCacheTag, psDEDataQuery);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSDEDataQuery(strPSDEDataQueryId, psDEDataQuery);
        if (callResult.isOk()) {
            this.writeCache(strCacheCat, strCacheTag, psDEDataQuery);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEDataQueries(String strPSDataEntityId, Vector<PSDEDataQuery> psDEDataQueryList) {
        CallResult callResult = this.getPSDataEntityTag(strPSDataEntityId);
        if (callResult.isError()) {
            return callResult;
        }
        String strCacheCat = "getPSDEDataQueries";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSDataEntityId, (String)((String)callResult.getUserObject()));
        if ((callResult = this.readCache2(strCacheCat, strCacheTag, PSDEDataQuery.class, psDEDataQueryList)) != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSDEDataQueries(strPSDataEntityId, psDEDataQueryList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psDEDataQueryList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEDataQueryCodes(String strPSDEDataQueryId, Vector<PSDEDataQueryCode> psDEDataQueryCodeList) {
        String strCacheCat = "getPSDEDataQueryCodes";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSDEDataQueryId);
        CallResult callResult = this.readCache2(strCacheCat, strCacheTag, PSDEDataQueryCode.class, psDEDataQueryCodeList);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSDEDataQueryCodes(strPSDEDataQueryId, psDEDataQueryCodeList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psDEDataQueryCodeList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEDataQueryCode(String strPSDEDataQueryCodeId, PSDEDataQueryCode psDEDataQueryCode) {
        String strCacheCat = "getPSDEDataQueryCode";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSDEDataQueryCodeId);
        CallResult callResult = this.readCache(strCacheCat, strCacheTag, psDEDataQueryCode);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSDEDataQueryCode(strPSDEDataQueryCodeId, psDEDataQueryCode);
        if (callResult.isOk()) {
            this.writeCache(strCacheCat, strCacheTag, psDEDataQueryCode);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEDataQueryCodeExps(String strPSDEDataQueryCodeId, Vector<PSDEDataQueryCodeExp> psDEDataQueryCodeExpList) {
        String strCacheCat = "getPSDEDataQueryCodeExps";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSDEDataQueryCodeId);
        CallResult callResult = this.readCache2(strCacheCat, strCacheTag, PSDEDataQueryCodeExp.class, psDEDataQueryCodeExpList);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSDEDataQueryCodeExps(strPSDEDataQueryCodeId, psDEDataQueryCodeExpList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psDEDataQueryCodeExpList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEDataQueryCodeConds(String strPSDEDataQueryCodeId, Vector<PSDEDataQueryCodeCond> psDEDataQueryCodeCondList) {
        String strCacheCat = "getPSDEDataQueryCodeConds";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSDEDataQueryCodeId);
        CallResult callResult = this.readCache2(strCacheCat, strCacheTag, PSDEDataQueryCodeCond.class, psDEDataQueryCodeCondList);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSDEDataQueryCodeConds(strPSDEDataQueryCodeId, psDEDataQueryCodeCondList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psDEDataQueryCodeCondList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEDataSet(String strPSDEDataSetId, PSDEDataSet psDEDataSet) {
        String strCacheCat = "getPSDEDataSet";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSDEDataSetId);
        CallResult callResult = this.readCache(strCacheCat, strCacheTag, psDEDataSet);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSDEDataSet(strPSDEDataSetId, psDEDataSet);
        if (callResult.isOk()) {
            this.writeCache(strCacheCat, strCacheTag, psDEDataSet);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEDataSets(String strPSDataEntityId, Vector<PSDEDataSet> psDEDataSetList) {
        CallResult callResult = this.getPSDataEntityTag(strPSDataEntityId);
        if (callResult.isError()) {
            return callResult;
        }
        String strCacheCat = "getPSDEDataSets";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSDataEntityId, (String)((String)callResult.getUserObject()));
        if ((callResult = this.readCache2(strCacheCat, strCacheTag, PSDEDataSet.class, psDEDataSetList)) != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSDEDataSets(strPSDataEntityId, psDEDataSetList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psDEDataSetList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEDSDQs(String strPSDataSetId, Vector<PSDEDSDQ> psDEDSDQList) {
        String strCacheCat = "getPSDEDSDQs";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSDataSetId);
        CallResult callResult = this.readCache2(strCacheCat, strCacheTag, PSDEDSDQ.class, psDEDSDQList);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSDEDSDQs(strPSDataSetId, psDEDSDQList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psDEDSDQList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEDSGroupParams(String strPSDataSetId, Vector<PSDEDSGroupParam> psDEDSGroupParamList) {
        String strCacheCat = "getPSDEDSGroupParams";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSDataSetId);
        CallResult callResult = this.readCache2(strCacheCat, strCacheTag, PSDEDSGroupParam.class, psDEDSGroupParamList);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSDEDSGroupParams(strPSDataSetId, psDEDSGroupParamList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psDEDSGroupParamList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSAjaxControlHandlers(String strPSDataEntityId, Vector<PSACHandler> psAjaxControlHandlerList) {
        CallResult callResult = this.getPSDataEntityTag(strPSDataEntityId);
        if (callResult.isError()) {
            return callResult;
        }
        String strCacheCat = "getPSAjaxControlHandlers";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSDataEntityId, (String)((String)callResult.getUserObject()));
        if ((callResult = this.readCache2(strCacheCat, strCacheTag, PSACHandler.class, psAjaxControlHandlerList)) != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSAjaxControlHandlers(strPSDataEntityId, psAjaxControlHandlerList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psAjaxControlHandlerList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEActionType(String strPSDEActionTypeId, PSDEActionType psDEActionType) {
        String strCacheCat = "getPSDEActionType";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSDEActionTypeId);
        CallResult callResult = this.readCache(strCacheCat, strCacheTag, psDEActionType);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSDEActionType(strPSDEActionTypeId, psDEActionType);
        if (callResult.isOk()) {
            this.writeCache(strCacheCat, strCacheTag, psDEActionType);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSDELogics(String strPSDataEntityId, Vector<PSDELogic> psDELogicList) {
        CallResult callResult = this.getPSDataEntityTag(strPSDataEntityId);
        if (callResult.isError()) {
            return callResult;
        }
        String strCacheCat = "getPSDELogics";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSDataEntityId, (String)((String)callResult.getUserObject()));
        if ((callResult = this.readCache2(strCacheCat, strCacheTag, PSDELogic.class, psDELogicList)) != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSDELogics(strPSDataEntityId, psDELogicList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psDELogicList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSDELogicParams(String strPSDELogicId, Vector<PSDELogicParam> psDELogicParamList) {
        String strCacheCat = "getPSDELogicParams";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSDELogicId);
        CallResult callResult = this.readCache2(strCacheCat, strCacheTag, PSDELogicParam.class, psDELogicParamList);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSDELogicParams(strPSDELogicId, psDELogicParamList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psDELogicParamList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSDELogicNodes(String strPSDELogicId, Vector<PSDELogicNode> psDELogicNodeList) {
        String strCacheCat = "getPSDELogicNodes";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSDELogicId);
        CallResult callResult = this.readCache2(strCacheCat, strCacheTag, PSDELogicNode.class, psDELogicNodeList);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSDELogicNodes(strPSDELogicId, psDELogicNodeList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psDELogicNodeList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSDELogicLinks(String strPSDELogicId, Vector<PSDELogicLink> psDELogicLinkList) {
        String strCacheCat = "getPSDELogicLinks";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSDELogicId);
        CallResult callResult = this.readCache2(strCacheCat, strCacheTag, PSDELogicLink.class, psDELogicLinkList);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSDELogicLinks(strPSDELogicId, psDELogicLinkList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psDELogicLinkList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSDELogicNodeParams(String strPSDELogicId, Vector<PSDELogicNodeParam> psDELogicNodeParamList) {
        String strCacheCat = "getPSDELogicNodeParams";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSDELogicId);
        CallResult callResult = this.readCache2(strCacheCat, strCacheTag, PSDELogicNodeParam.class, psDELogicNodeParamList);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSDELogicNodeParams(strPSDELogicId, psDELogicNodeParamList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psDELogicNodeParamList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSDELogicLinkConds(String strPSDELogicId, Vector<PSDELogicLinkCond> psDELogicLinkCondList) {
        String strCacheCat = "getPSDELogicLinkConds";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSDELogicId);
        CallResult callResult = this.readCache2(strCacheCat, strCacheTag, PSDELogicLinkCond.class, psDELogicLinkCondList);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSDELogicLinkConds(strPSDELogicId, psDELogicLinkCondList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psDELogicLinkCondList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSDELogicLinkCondType(String strPSDELogicLinkCondTypeId, PSDELogicLinkCondType psDELogicLinkCondType) {
        String strCacheCat = "getPSDELogicLinkCondType";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSDELogicLinkCondTypeId);
        CallResult callResult = this.readCache(strCacheCat, strCacheTag, psDELogicLinkCondType);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSDELogicLinkCondType(strPSDELogicLinkCondTypeId, psDELogicLinkCondType);
        if (callResult.isOk()) {
            this.writeCache(strCacheCat, strCacheTag, psDELogicLinkCondType);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSDELogicNodeType(String strPSDELogicNodeTypeId, PSDELogicNodeType psDELogicNodeType) {
        String strCacheCat = "getPSDELogicNodeType";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSDELogicNodeTypeId);
        CallResult callResult = this.readCache(strCacheCat, strCacheTag, psDELogicNodeType);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSDELogicNodeType(strPSDELogicNodeTypeId, psDELogicNodeType);
        if (callResult.isOk()) {
            this.writeCache(strCacheCat, strCacheTag, psDELogicNodeType);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSDELogicLinkType(String strPSDELogicLinkTypeId, PSDELogicLinkType psDELogicLinkType) {
        String strCacheCat = "getPSDELogicLinkType";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSDELogicLinkTypeId);
        CallResult callResult = this.readCache(strCacheCat, strCacheTag, psDELogicLinkType);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSDELogicLinkType(strPSDELogicLinkTypeId, psDELogicLinkType);
        if (callResult.isOk()) {
            this.writeCache(strCacheCat, strCacheTag, psDELogicLinkType);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEACModeItems(String strPSDEACModeId, Vector<PSDEACModeItem> psDEACModeItemList) {
        String strCacheCat = "getPSDEACModeItems";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSDEACModeId);
        CallResult callResult = this.readCache2(strCacheCat, strCacheTag, PSDEACModeItem.class, psDEACModeItemList);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSDEACModeItems(strPSDEACModeId, psDEACModeItemList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psDEACModeItemList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEDRDetails(String strPSDEDRId, Vector<PSDEDRDetail> psDEDRDetailList) {
        String strCacheCat = "getPSDEDRDetails";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSDEDRId);
        CallResult callResult = this.readCache2(strCacheCat, strCacheTag, PSDEDRDetail.class, psDEDRDetailList);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSDEDRDetails(strPSDEDRId, psDEDRDetailList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psDEDRDetailList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEDataRelations(String strPSDEId, Vector<PSDEDataRelation> psDEDataRelationList) {
        String strCacheCat = "getPSDEDataRelations";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSDEId);
        CallResult callResult = this.readCache2(strCacheCat, strCacheTag, PSDEDataRelation.class, psDEDataRelationList);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSDEDataRelations(strPSDEId, psDEDataRelationList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psDEDataRelationList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEDRGroups(String strPSDataEntityId, Vector<PSDEDRGroup> psDEDRGroupList) {
        CallResult callResult = this.getPSDataEntityTag(strPSDataEntityId);
        if (callResult.isError()) {
            return callResult;
        }
        String strCacheCat = "getPSDEDRGroups";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSDataEntityId, (String)((String)callResult.getUserObject()));
        if ((callResult = this.readCache2(strCacheCat, strCacheTag, PSDEDRGroup.class, psDEDRGroupList)) != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSDEDRGroups(strPSDataEntityId, psDEDRGroupList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psDEDRGroupList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEDRItems(String strPSDEId, Vector<PSDEDRItem> psDEDRItemList) {
        String strCacheCat = "getPSDEDRItems";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSDEId);
        CallResult callResult = this.readCache2(strCacheCat, strCacheTag, PSDEDRItem.class, psDEDRItemList);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSDEDRItems(strPSDEId, psDEDRItemList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psDEDRItemList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSDRItemType(String strPSDRItemTypeId, PSDRItemType psDRItemType) {
        String strCacheCat = "getPSDRItemType";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSDRItemTypeId);
        CallResult callResult = this.readCache(strCacheCat, strCacheTag, psDRItemType);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSDRItemType(strPSDRItemTypeId, psDRItemType);
        if (callResult.isOk()) {
            this.writeCache(strCacheCat, strCacheTag, psDRItemType);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSWFDEs(String strPSDataEntityId, Vector<PSWFDE> psWFDEList) {
        CallResult callResult = this.getPSDataEntityTag(strPSDataEntityId);
        if (callResult.isError()) {
            return callResult;
        }
        String strCacheCat = "getPSWFDEs";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSDataEntityId, (String)((String)callResult.getUserObject()));
        if ((callResult = this.readCache2(strCacheCat, strCacheTag, PSWFDE.class, psWFDEList)) != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSWFDEs(strPSDataEntityId, psWFDEList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psWFDEList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEMainStateOPPrivs(String strPSDEMainStateId, Vector<PSDEMainStateOPPriv> psDEMainStateOPPrivList) {
        String strCacheCat = "getPSDEMainStateOPPrivs";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSDEMainStateId);
        CallResult callResult = this.readCache2(strCacheCat, strCacheTag, PSDEMainStateOPPriv.class, psDEMainStateOPPrivList);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSDEMainStateOPPrivs(strPSDEMainStateId, psDEMainStateOPPrivList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psDEMainStateOPPrivList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEMainStateActions(String strPSDEMainStateId, Vector<PSDEMainStateAction> psDEMainStateActionList) {
        String strCacheCat = "getPSDEMainStateActions";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSDEMainStateId);
        CallResult callResult = this.readCache2(strCacheCat, strCacheTag, PSDEMainStateAction.class, psDEMainStateActionList);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSDEMainStateActions(strPSDEMainStateId, psDEMainStateActionList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psDEMainStateActionList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEMainStates(String strPSDEId, Vector<PSDEMainState> psDEMainStateList) {
        String strCacheCat = "getPSDEMainStates";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSDEId);
        CallResult callResult = this.readCache2(strCacheCat, strCacheTag, PSDEMainState.class, psDEMainStateList);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSDEMainStates(strPSDEId, psDEMainStateList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psDEMainStateList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getAllPSSysDEFTypes(String strPSSystemId, Vector<PSSysDEFType> psSysDEFTypeList) {
        String strCacheCat = "getAllPSSysDEFTypes";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSSystemId);
        CallResult callResult = this.readCache2(strCacheCat, strCacheTag, PSSysDEFType.class, psSysDEFTypeList);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getAllPSSysDEFTypes(strPSSystemId, psSysDEFTypeList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psSysDEFTypeList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSSysDEFType(String strPSSysDEFTypeId, PSSysDEFType psSysDEFType) {
        String strCacheCat = "getPSSysDEFType";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSSysDEFTypeId);
        CallResult callResult = this.readCache(strCacheCat, strCacheTag, psSysDEFType);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSSysDEFType(strPSSysDEFTypeId, psSysDEFType);
        if (callResult.isOk()) {
            this.writeCache(strCacheCat, strCacheTag, psSysDEFType);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEFValueRuleConds(String strPSDEFValueRuleId, Vector<PSDEFValueRuleCond> psDEFValueRuleCondList) {
        String strCacheCat = "getPSDEFValueRuleConds";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSDEFValueRuleId);
        CallResult callResult = this.readCache2(strCacheCat, strCacheTag, PSDEFValueRuleCond.class, psDEFValueRuleCondList);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSDEFValueRuleConds(strPSDEFValueRuleId, psDEFValueRuleCondList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psDEFValueRuleCondList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEFValueRuleTypeDetail(String strPSDEFValueRuleTypeDetailId, PSDEFValueRuleTypeDetail psDEFValueRuleTypeDetail) {
        String strCacheCat = "getPSDEFValueRuleTypeDetail";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSDEFValueRuleTypeDetailId);
        CallResult callResult = this.readCache(strCacheCat, strCacheTag, psDEFValueRuleTypeDetail);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSDEFValueRuleTypeDetail(strPSDEFValueRuleTypeDetailId, psDEFValueRuleTypeDetail);
        if (callResult.isOk()) {
            this.writeCache(strCacheCat, strCacheTag, psDEFValueRuleTypeDetail);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEFValueRuleType(String strPSDEFValueRuleTypeId, PSDEFValueRuleType psDEFValueRuleType) {
        String strCacheCat = "getPSDEFValueRuleType";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSDEFValueRuleTypeId);
        CallResult callResult = this.readCache(strCacheCat, strCacheTag, psDEFValueRuleType);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSDEFValueRuleType(strPSDEFValueRuleTypeId, psDEFValueRuleType);
        if (callResult.isOk()) {
            this.writeCache(strCacheCat, strCacheTag, psDEFValueRuleType);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getAllPSDEFieldTypes(Vector<PSDEFieldType> psDEFieldTypes) {
        String strCacheCat = "getAllPSDEFieldTypes";
        String strCacheTag = KeyValueHelper.genUniqueId((String)"__ALL__");
        CallResult callResult = this.readCache2(strCacheCat, strCacheTag, PSDEFieldType.class, psDEFieldTypes);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getAllPSDEFieldTypes(psDEFieldTypes);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psDEFieldTypes);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getAllPSDERs(String strPSSystemId, Vector<PSDER> psDataEntityList) {
        String strCacheCat = "getAllPSDERs";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSSystemId);
        CallResult callResult = this.readCache2(strCacheCat, strCacheTag, PSDER.class, psDataEntityList);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getAllPSDERs(strPSSystemId, psDataEntityList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psDataEntityList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSDERType(String strPSDERTypeId, PSDERType psDERType) {
        String strCacheCat = "getPSDERType";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSDERTypeId);
        CallResult callResult = this.readCache(strCacheCat, strCacheTag, psDERType);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSDERType(strPSDERTypeId, psDERType);
        if (callResult.isOk()) {
            this.writeCache(strCacheCat, strCacheTag, psDERType);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSDERsByMinorDEId(String strPSDataEntityId, Vector<PSDER> psDERList) {
        CallResult callResult = this.getPSDataEntityTag(strPSDataEntityId);
        if (callResult.isError()) {
            return callResult;
        }
        String strCacheCat = "getPSDERsByMinorDEId";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSDataEntityId, (String)((String)callResult.getUserObject()));
        if ((callResult = this.readCache2(strCacheCat, strCacheTag, PSDER.class, psDERList)) != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSDERsByMinorDEId(strPSDataEntityId, psDERList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psDERList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEUtils(String strPSDEId, Vector<PSDEUtil> psDEUtilList) {
        String strCacheCat = "getPSDEUtils";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSDEId);
        CallResult callResult = this.readCache2(strCacheCat, strCacheTag, PSDEUtil.class, psDEUtilList);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSDEUtils(strPSDEId, psDEUtilList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psDEUtilList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getAllPSSysLans(String strPSSystemId, Vector<PSAppLan> psAppLans) {
        String strCacheCat = "getAllPSSysLans";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSSystemId);
        CallResult callResult = this.readCache2(strCacheCat, strCacheTag, PSAppLan.class, psAppLans);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getAllPSSysLans(strPSSystemId, psAppLans);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psAppLans);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getAllPSLanguageItems(String strPSSystemId, Vector<PSLanguageItem> psLanguageItemList) {
        String strCacheCat = "getAllPSLanguageItems";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSSystemId);
        CallResult callResult = this.readCache2(strCacheCat, strCacheTag, PSLanguageItem.class, psLanguageItemList);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getAllPSLanguageItems(strPSSystemId, psLanguageItemList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psLanguageItemList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getAllPSLanguageReses(String strPSSystemId, Vector<PSLanguageRes> psLanguageResList) {
        String strCacheCat = "getAllPSLanguageReses";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSSystemId);
        CallResult callResult = this.readCache2(strCacheCat, strCacheTag, PSLanguageRes.class, psLanguageResList);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getAllPSLanguageReses(strPSSystemId, psLanguageResList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psLanguageResList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSSysValueRule(String strPSSysValueRuleId, PSSysValueRule psSysValueRule) {
        String strCacheCat = "getPSSysValueRule";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSSysValueRuleId);
        CallResult callResult = this.readCache(strCacheCat, strCacheTag, psSysValueRule);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSSysValueRule(strPSSysValueRuleId, psSysValueRule);
        if (callResult.isOk()) {
            this.writeCache(strCacheCat, strCacheTag, psSysValueRule);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getAllPSSysValueRules(String strPSSystemId, Vector<PSSysValueRule> psSysValueRuleList) {
        String strCacheCat = "getAllPSSysValueRules";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSSystemId);
        CallResult callResult = this.readCache2(strCacheCat, strCacheTag, PSSysValueRule.class, psSysValueRuleList);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getAllPSSysValueRules(strPSSystemId, psSysValueRuleList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psSysValueRuleList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSSysPortlet(String strPSSysPortletId, PSSysPortlet psSysPortlet) {
        String strCacheCat = "getPSSysPortlet";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSSysPortletId);
        CallResult callResult = this.readCache(strCacheCat, strCacheTag, psSysPortlet);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSSysPortlet(strPSSysPortletId, psSysPortlet);
        if (callResult.isOk()) {
            this.writeCache(strCacheCat, strCacheTag, psSysPortlet);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getAllPSSysPortlets(String strPSSystemId, Vector<PSSysPortlet> psSysPortletList) {
        String strCacheCat = "getAllPSSysPortlets";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSSystemId);
        CallResult callResult = this.readCache2(strCacheCat, strCacheTag, PSSysPortlet.class, psSysPortletList);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getAllPSSysPortlets(strPSSystemId, psSysPortletList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psSysPortletList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getAllPSSysPDTViews(String strPSSystemId, Vector<PSSysPDTView> psSysPDTViewList) {
        String strCacheCat = "getAllPSSysPDTViews";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSSystemId);
        CallResult callResult = this.readCache2(strCacheCat, strCacheTag, PSSysPDTView.class, psSysPDTViewList);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getAllPSSysPDTViews(strPSSystemId, psSysPDTViewList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psSysPDTViewList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSSysPDTView(String strPSSysPDTViewId, PSSysPDTView psSysPDTView) {
        String strCacheCat = "getPSSysPDTView";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSSysPDTViewId);
        CallResult callResult = this.readCache(strCacheCat, strCacheTag, psSysPDTView);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSSysPDTView(strPSSysPDTViewId, psSysPDTView);
        if (callResult.isOk()) {
            this.writeCache(strCacheCat, strCacheTag, psSysPDTView);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSSystemApplication(String strPSSystemApplicationId, PSSystemApplication psSystemApplication) {
        String strCacheCat = "getPSSystemApplication";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSSystemApplicationId);
        CallResult callResult = this.readCache(strCacheCat, strCacheTag, psSystemApplication);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSSystemApplication(strPSSystemApplicationId, psSystemApplication);
        if (callResult.isOk()) {
            this.writeCache(strCacheCat, strCacheTag, psSystemApplication);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getAllPSSystemApplications(String strPSSystemId, Vector<PSSystemApplication> psSystemApplicationList) {
        String strCacheCat = "getAllPSSystemApplications";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSSystemId);
        CallResult callResult = this.readCache2(strCacheCat, strCacheTag, PSSystemApplication.class, psSystemApplicationList);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getAllPSSystemApplications(strPSSystemId, psSystemApplicationList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psSystemApplicationList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSViewType(String strPSViewTypeId, PSViewType psViewType) {
        String strCacheCat = "getPSViewType";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSViewTypeId);
        CallResult callResult = this.readCache(strCacheCat, strCacheTag, psViewType);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSViewType(strPSViewTypeId, psViewType);
        if (callResult.isOk()) {
            this.writeCache(strCacheCat, strCacheTag, psViewType);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getAllPSApplicationViews(String strPSApplicationId, Vector<PSAppView> psApplicationViews) {
        String strCacheCat = "getAllPSApplicationViews";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSApplicationId);
        CallResult callResult = this.readCache2(strCacheCat, strCacheTag, PSAppView.class, psApplicationViews);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getAllPSApplicationViews(strPSApplicationId, psApplicationViews);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psApplicationViews);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSAppFunc(String strPSAppFuncId, PSAppFunc psAppFunc) {
        String strCacheCat = "getPSAppFunc";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSAppFuncId);
        CallResult callResult = this.readCache(strCacheCat, strCacheTag, psAppFunc);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSAppFunc(strPSAppFuncId, psAppFunc);
        if (callResult.isOk()) {
            this.writeCache(strCacheCat, strCacheTag, psAppFunc);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSAppUserMode(String strPSAppUserModeId, PSAppUserMode psAppUserMode) {
        String strCacheCat = "getPSAppUserMode";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSAppUserModeId);
        CallResult callResult = this.readCache(strCacheCat, strCacheTag, psAppUserMode);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSAppUserMode(strPSAppUserModeId, psAppUserMode);
        if (callResult.isOk()) {
            this.writeCache(strCacheCat, strCacheTag, psAppUserMode);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSAppUtilPage(String strPSAppUtilPageId, PSAppUtilPage psAppUtilPage) {
        String strCacheCat = "getPSAppUtilPage";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSAppUtilPageId);
        CallResult callResult = this.readCache(strCacheCat, strCacheTag, psAppUtilPage);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSAppUtilPage(strPSAppUtilPageId, psAppUtilPage);
        if (callResult.isOk()) {
            this.writeCache(strCacheCat, strCacheTag, psAppUtilPage);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSAppUIStyle(String strPSAppUIStyleId, PSAppUIStyle psAppUIStyle) {
        String strCacheCat = "getPSAppUIStyle";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSAppUIStyleId);
        CallResult callResult = this.readCache(strCacheCat, strCacheTag, psAppUIStyle);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSAppUIStyle(strPSAppUIStyleId, psAppUIStyle);
        if (callResult.isOk()) {
            this.writeCache(strCacheCat, strCacheTag, psAppUIStyle);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSAppUITheme(String strPSAppUIThemeId, PSAppUITheme psAppUITheme) {
        String strCacheCat = "getPSAppUITheme";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSAppUIThemeId);
        CallResult callResult = this.readCache(strCacheCat, strCacheTag, psAppUITheme);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSAppUITheme(strPSAppUIThemeId, psAppUITheme);
        if (callResult.isOk()) {
            this.writeCache(strCacheCat, strCacheTag, psAppUITheme);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getAllPSAppMenus(String strPSApplicationId, Vector<PSAppMenu> psAppMenus) {
        String strCacheCat = "getAllPSAppMenus";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSApplicationId);
        CallResult callResult = this.readCache2(strCacheCat, strCacheTag, PSAppMenu.class, psAppMenus);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getAllPSAppMenus(strPSApplicationId, psAppMenus);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psAppMenus);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getAllPSAppUtilPages(String strPSApplicationId, Vector<PSAppUtilPage> psAppUtilPages) {
        String strCacheCat = "getAllPSAppUtilPages";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSApplicationId);
        CallResult callResult = this.readCache2(strCacheCat, strCacheTag, PSAppUtilPage.class, psAppUtilPages);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getAllPSAppUtilPages(strPSApplicationId, psAppUtilPages);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psAppUtilPages);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getAllPSAppLans(String strPSApplicationId, Vector<PSAppLan> psAppLans) {
        String strCacheCat = "getAllPSAppLans";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSApplicationId);
        CallResult callResult = this.readCache2(strCacheCat, strCacheTag, PSAppLan.class, psAppLans);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getAllPSAppLans(strPSApplicationId, psAppLans);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psAppLans);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSAppLan(String strPSAppLanId, PSAppLan psAppLan) {
        String strCacheCat = "getPSAppLan";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSAppLanId);
        CallResult callResult = this.readCache(strCacheCat, strCacheTag, psAppLan);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSAppLan(strPSAppLanId, psAppLan);
        if (callResult.isOk()) {
            this.writeCache(strCacheCat, strCacheTag, psAppLan);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getAllPSAppFuncs(String strPSApplicationId, Vector<PSAppFunc> psAppFuncs) {
        String strCacheCat = "getAllPSAppFuncs";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSApplicationId);
        CallResult callResult = this.readCache2(strCacheCat, strCacheTag, PSAppFunc.class, psAppFuncs);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getAllPSAppFuncs(strPSApplicationId, psAppFuncs);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psAppFuncs);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSSysAjaxControlHandlers(String strPSSystemId, Vector<PSACHandler> psAjaxControlHandlerList) {
        String strCacheCat = "getPSSysAjaxControlHandlers";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSSystemId);
        CallResult callResult = this.readCache2(strCacheCat, strCacheTag, PSACHandler.class, psAjaxControlHandlerList);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSSysAjaxControlHandlers(strPSSystemId, psAjaxControlHandlerList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psAjaxControlHandlerList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSWFDEsByWF(String strPSWFId, Vector<PSWFDE> psWFDEList) {
        String strCacheCat = "getPSWFDEsByWF";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSWFId);
        CallResult callResult = this.readCache2(strCacheCat, strCacheTag, PSWFDE.class, psWFDEList);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSWFDEsByWF(strPSWFId, psWFDEList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psWFDEList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSWFLinkCondType(String strPSWFLinkCondTypeId, PSWFLinkCondType psWFLinkCondType) {
        String strCacheCat = "getPSWFLinkCondType";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSWFLinkCondTypeId);
        CallResult callResult = this.readCache(strCacheCat, strCacheTag, psWFLinkCondType);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSWFLinkCondType(strPSWFLinkCondTypeId, psWFLinkCondType);
        if (callResult.isOk()) {
            this.writeCache(strCacheCat, strCacheTag, psWFLinkCondType);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSWFLinkType(String strPSWFLinkTypeId, PSWFLinkType psWFLinkType) {
        String strCacheCat = "getPSWFLinkType";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSWFLinkTypeId);
        CallResult callResult = this.readCache(strCacheCat, strCacheTag, psWFLinkType);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSWFLinkType(strPSWFLinkTypeId, psWFLinkType);
        if (callResult.isOk()) {
            this.writeCache(strCacheCat, strCacheTag, psWFLinkType);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSWFProcessType(String strPSWFProcessTypeId, PSWFProcessType psWFProcessType) {
        String strCacheCat = "getPSWFProcessType";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSWFProcessTypeId);
        CallResult callResult = this.readCache(strCacheCat, strCacheTag, psWFProcessType);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSWFProcessType(strPSWFProcessTypeId, psWFProcessType);
        if (callResult.isOk()) {
            this.writeCache(strCacheCat, strCacheTag, psWFProcessType);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getAllPSWFRoles(String strPSSystemId, Vector<PSWFRole> psWFRoleList) {
        String strCacheCat = "getAllPSWFRoles";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSSystemId);
        CallResult callResult = this.readCache2(strCacheCat, strCacheTag, PSWFRole.class, psWFRoleList);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getAllPSWFRoles(strPSSystemId, psWFRoleList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psWFRoleList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSWFUIActions(String strPSWFVersionId, Vector<PSDEUIAction> psDEUIActionList) {
        CallResult callResult = this.getPSWFVersionTag(strPSWFVersionId);
        if (callResult.isError()) {
            return callResult;
        }
        String strCacheCat = "getPSWFUIActions";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSWFVersionId, (String)((String)callResult.getUserObject()));
        if ((callResult = this.readCache2(strCacheCat, strCacheTag, PSDEUIAction.class, psDEUIActionList)) != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSWFUIActions(strPSWFVersionId, psDEUIActionList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psDEUIActionList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSWFUIActionGroups(String strPSWFVersionId, Vector<PSDEUIActionGroup> psDEUIActionGroupList) {
        CallResult callResult = this.getPSWFVersionTag(strPSWFVersionId);
        if (callResult.isError()) {
            return callResult;
        }
        String strCacheCat = "getPSWFUIActionGroups";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSWFVersionId, (String)((String)callResult.getUserObject()));
        if ((callResult = this.readCache2(strCacheCat, strCacheTag, PSDEUIActionGroup.class, psDEUIActionGroupList)) != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSWFUIActionGroups(strPSWFVersionId, psDEUIActionGroupList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psDEUIActionGroupList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSWFVersions(String strPSWFId, Vector<PSWFVersion> psVersionList) {
        CallResult callResult = this.getPSWFVersionTag(strPSWFId);
        if (callResult.isError()) {
            return callResult;
        }
        String strCacheCat = "getPSWFVersions";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSWFId, (String)((String)callResult.getUserObject()));
        if ((callResult = this.readCache2(strCacheCat, strCacheTag, PSWFVersion.class, psVersionList)) != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSWFVersions(strPSWFId, psVersionList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psVersionList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSWFProcesses(String strPSWFVersionId, Vector<PSWFProcess> psWFProcessList) {
        CallResult callResult = this.getPSWFVersionTag(strPSWFVersionId);
        if (callResult.isError()) {
            return callResult;
        }
        String strCacheCat = "getPSWFProcesses";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSWFVersionId, (String)((String)callResult.getUserObject()));
        if ((callResult = this.readCache2(strCacheCat, strCacheTag, PSWFProcess.class, psWFProcessList)) != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSWFProcesses(strPSWFVersionId, psWFProcessList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psWFProcessList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSWFLinks(String strPSWFVersionId, Vector<PSWFLink> psWFLinkList) {
        CallResult callResult = this.getPSWFVersionTag(strPSWFVersionId);
        if (callResult.isError()) {
            return callResult;
        }
        String strCacheCat = "getPSWFLinks";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSWFVersionId, (String)((String)callResult.getUserObject()));
        if ((callResult = this.readCache2(strCacheCat, strCacheTag, PSWFLink.class, psWFLinkList)) != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSWFLinks(strPSWFVersionId, psWFLinkList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psWFLinkList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSWFProcParams(String strPSWFVersionId, Vector<PSWFProcParam> psWFProcParamList) {
        CallResult callResult = this.getPSWFVersionTag(strPSWFVersionId);
        if (callResult.isError()) {
            return callResult;
        }
        String strCacheCat = "getPSWFProcParams";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSWFVersionId, (String)((String)callResult.getUserObject()));
        if ((callResult = this.readCache2(strCacheCat, strCacheTag, PSWFProcParam.class, psWFProcParamList)) != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSWFProcParams(strPSWFVersionId, psWFProcParamList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psWFProcParamList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSWFProcSubWFs(String strPSWFVersionId, Vector<PSWFProcSubWF> psWFProcSubWFList) {
        CallResult callResult = this.getPSWFVersionTag(strPSWFVersionId);
        if (callResult.isError()) {
            return callResult;
        }
        String strCacheCat = "getPSWFProcSubWFs";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSWFVersionId, (String)((String)callResult.getUserObject()));
        if ((callResult = this.readCache2(strCacheCat, strCacheTag, PSWFProcSubWF.class, psWFProcSubWFList)) != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSWFProcSubWFs(strPSWFVersionId, psWFProcSubWFList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psWFProcSubWFList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSWFLinkConds(String strPSWFVersionId, Vector<PSWFLinkCond> psWFLinkCondList) {
        CallResult callResult = this.getPSWFVersionTag(strPSWFVersionId);
        if (callResult.isError()) {
            return callResult;
        }
        String strCacheCat = "getPSWFLinkConds";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSWFVersionId, (String)((String)callResult.getUserObject()));
        if ((callResult = this.readCache2(strCacheCat, strCacheTag, PSWFLinkCond.class, psWFLinkCondList)) != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSWFLinkConds(strPSWFVersionId, psWFLinkCondList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psWFLinkCondList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSWFProcRoles(String strPSWFVersionId, Vector<PSWFProcRole> psWFProcRoleList) {
        CallResult callResult = this.getPSWFVersionTag(strPSWFVersionId);
        if (callResult.isError()) {
            return callResult;
        }
        String strCacheCat = "getPSWFProcRoles";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSWFVersionId, (String)((String)callResult.getUserObject()));
        if ((callResult = this.readCache2(strCacheCat, strCacheTag, PSWFProcRole.class, psWFProcRoleList)) != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSWFProcRoles(strPSWFVersionId, psWFProcRoleList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psWFProcRoleList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getAllPSWorkflows(String strPSSystemId, Vector<PSWorkflow> psWorkflowList) {
        String strCacheCat = "getAllPSWorkflows";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSSystemId);
        CallResult callResult = this.readCache2(strCacheCat, strCacheTag, PSWorkflow.class, psWorkflowList);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getAllPSWorkflows(strPSSystemId, psWorkflowList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psWorkflowList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSSysCounter(String strPSSysCounterId, PSSysCounter psSysCounter) {
        String strCacheCat = "getPSSysCounter";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSSysCounterId);
        CallResult callResult = this.readCache(strCacheCat, strCacheTag, psSysCounter);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSSysCounter(strPSSysCounterId, psSysCounter);
        if (callResult.isOk()) {
            this.writeCache(strCacheCat, strCacheTag, psSysCounter);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSCounterType(String strPSCounterTypeId, PSCounterType psCounterType) {
        String strCacheCat = "getPSCounterType";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSCounterTypeId);
        CallResult callResult = this.readCache(strCacheCat, strCacheTag, psCounterType);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSCounterType(strPSCounterTypeId, psCounterType);
        if (callResult.isOk()) {
            this.writeCache(strCacheCat, strCacheTag, psCounterType);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getAllPSSysCounters(String strPSSystemId, Vector<PSSysCounter> psSysCounterList) {
        String strCacheCat = "getAllPSSysCounters";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSSystemId);
        CallResult callResult = this.readCache2(strCacheCat, strCacheTag, PSSysCounter.class, psSysCounterList);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getAllPSSysCounters(strPSSystemId, psSysCounterList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psSysCounterList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getAllPSSysEditorStyles(String strPSSystemId, Vector<PSSysEditorStyle> psSysEditorStyleList) {
        String strCacheCat = "getAllPSSysEditorStyles";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSSystemId);
        CallResult callResult = this.readCache2(strCacheCat, strCacheTag, PSSysEditorStyle.class, psSysEditorStyleList);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getAllPSSysEditorStyles(strPSSystemId, psSysEditorStyleList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psSysEditorStyleList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSSysUniRes(String strPSSysUniResId, PSSysUniRes psSysUniRes) {
        String strCacheCat = "getPSSysUniRes";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSSysUniResId);
        CallResult callResult = this.readCache(strCacheCat, strCacheTag, psSysUniRes);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSSysUniRes(strPSSysUniResId, psSysUniRes);
        if (callResult.isOk()) {
            this.writeCache(strCacheCat, strCacheTag, psSysUniRes);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getAllPSSysUniReses(String strPSSystemId, Vector<PSSysUniRes> psSysUniResList) {
        String strCacheCat = "getAllPSSysUniReses";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSSystemId);
        CallResult callResult = this.readCache2(strCacheCat, strCacheTag, PSSysUniRes.class, psSysUniResList);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getAllPSSysUniReses(strPSSystemId, psSysUniResList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psSysUniResList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSSysDBValueFunc(String strPSSysDBValueFuncId, PSSysDBValueFunc psSysDBValueFunc) {
        String strCacheCat = "getPSSysDBValueFunc";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSSysDBValueFuncId);
        CallResult callResult = this.readCache(strCacheCat, strCacheTag, psSysDBValueFunc);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSSysDBValueFunc(strPSSysDBValueFuncId, psSysDBValueFunc);
        if (callResult.isOk()) {
            this.writeCache(strCacheCat, strCacheTag, psSysDBValueFunc);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEOPPriv(String strPSDEOPPrivId, PSDEOPPriv psDEOPPriv) {
        String strCacheCat = "getPSDEOPPriv";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSDEOPPrivId);
        CallResult callResult = this.readCache(strCacheCat, strCacheTag, psDEOPPriv);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSDEOPPriv(strPSDEOPPrivId, psDEOPPriv);
        if (callResult.isOk()) {
            this.writeCache(strCacheCat, strCacheTag, psDEOPPriv);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEOPPrivsBySystem(String strPSSystemId, Vector<PSDEOPPriv> psDEOPPrivList) {
        String strCacheCat = "getPSDEOPPrivsBySystem";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSSystemId);
        CallResult callResult = this.readCache2(strCacheCat, strCacheTag, PSDEOPPriv.class, psDEOPPrivList);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSDEOPPrivsBySystem(strPSSystemId, psDEOPPrivList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psDEOPPrivList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSEditorType(String strPSEditorTypeId, PSEditorType psEditorType) {
        String strCacheCat = "getPSEditorType";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSEditorTypeId);
        CallResult callResult = this.readCache(strCacheCat, strCacheTag, psEditorType);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSEditorType(strPSEditorTypeId, psEditorType);
        if (callResult.isOk()) {
            this.writeCache(strCacheCat, strCacheTag, psEditorType);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSDBValueOP(String strPSDBValueOPId, PSDBValueOP psDBValueOP) {
        String strCacheCat = "getPSDBValueOP";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSDBValueOPId);
        CallResult callResult = this.readCache(strCacheCat, strCacheTag, psDBValueOP);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSDBValueOP(strPSDBValueOPId, psDBValueOP);
        if (callResult.isOk()) {
            this.writeCache(strCacheCat, strCacheTag, psDBValueOP);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSCounter(String strPSCounterId, PSCounter psCounter) {
        String strCacheCat = "getPSCounter";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSCounterId);
        CallResult callResult = this.readCache(strCacheCat, strCacheTag, psCounter);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSCounter(strPSCounterId, psCounter);
        if (callResult.isOk()) {
            this.writeCache(strCacheCat, strCacheTag, psCounter);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSPortletType(String strPSPortletTypeId, PSPortletType psPortletType) {
        String strCacheCat = "getPSPortletType";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSPortletTypeId);
        CallResult callResult = this.readCache(strCacheCat, strCacheTag, psPortletType);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSPortletType(strPSPortletTypeId, psPortletType);
        if (callResult.isOk()) {
            this.writeCache(strCacheCat, strCacheTag, psPortletType);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSFormDetailType(String strPSFormDetailTypeId, PSFormDetailType psFormDetailType) {
        String strCacheCat = "getPSFormDetailType";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSFormDetailTypeId);
        CallResult callResult = this.readCache(strCacheCat, strCacheTag, psFormDetailType);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSFormDetailType(strPSFormDetailTypeId, psFormDetailType);
        if (callResult.isOk()) {
            this.writeCache(strCacheCat, strCacheTag, psFormDetailType);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSFormType(String strPSFormTypeId, PSFormType psFormType) {
        String strCacheCat = "getPSFormType";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSFormTypeId);
        CallResult callResult = this.readCache(strCacheCat, strCacheTag, psFormType);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSFormType(strPSFormTypeId, psFormType);
        if (callResult.isOk()) {
            this.writeCache(strCacheCat, strCacheTag, psFormType);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSFDLogicType(String strPSFDLogicTypeId, PSFDLogicType psFDLogicType) {
        String strCacheCat = "getPSFDLogicType";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSFDLogicTypeId);
        CallResult callResult = this.readCache(strCacheCat, strCacheTag, psFDLogicType);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSFDLogicType(strPSFDLogicTypeId, psFDLogicType);
        if (callResult.isOk()) {
            this.writeCache(strCacheCat, strCacheTag, psFDLogicType);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSControlType(String strPSControlTypeId, PSControlType psControlType) {
        String strCacheCat = "getPSControlType";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSControlTypeId);
        CallResult callResult = this.readCache(strCacheCat, strCacheTag, psControlType);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSControlType(strPSControlTypeId, psControlType);
        if (callResult.isOk()) {
            this.writeCache(strCacheCat, strCacheTag, psControlType);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSToolbarItemType(String strPSToolbarItemTypeId, PSToolbarItemType psToolbarItemType) {
        String strCacheCat = "getPSToolbarItemType";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSToolbarItemTypeId);
        CallResult callResult = this.readCache(strCacheCat, strCacheTag, psToolbarItemType);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSToolbarItemType(strPSToolbarItemTypeId, psToolbarItemType);
        if (callResult.isOk()) {
            this.writeCache(strCacheCat, strCacheTag, psToolbarItemType);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEGridColumnType(String strPSDEGridColumnTypeId, PSDEGridColumnType psDEGridColumnType) {
        String strCacheCat = "getPSDEGridColumnType";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSDEGridColumnTypeId);
        CallResult callResult = this.readCache(strCacheCat, strCacheTag, psDEGridColumnType);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSDEGridColumnType(strPSDEGridColumnTypeId, psDEGridColumnType);
        if (callResult.isOk()) {
            this.writeCache(strCacheCat, strCacheTag, psDEGridColumnType);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSAppMenuItemType(String strPSAppMenuItemTypeId, PSAppMenuItemType psAppMenuItemType) {
        String strCacheCat = "getPSAppMenuItemType";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSAppMenuItemTypeId);
        CallResult callResult = this.readCache(strCacheCat, strCacheTag, psAppMenuItemType);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSAppMenuItemType(strPSAppMenuItemTypeId, psAppMenuItemType);
        if (callResult.isOk()) {
            this.writeCache(strCacheCat, strCacheTag, psAppMenuItemType);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSDynaAppView(String strPSDynaAppViewId, PSDynaAppView psDynaAppView) {
        String strCacheCat = "getPSDynaAppView";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSDynaAppViewId);
        CallResult callResult = this.readCache(strCacheCat, strCacheTag, psDynaAppView);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSDynaAppView(strPSDynaAppViewId, psDynaAppView);
        if (callResult.isOk()) {
            this.writeCache(strCacheCat, strCacheTag, psDynaAppView);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getAllPSAppViewLastModifyTimes(String strPSSysAppId, Vector<PSAppView> psAppViewList) {
        return this.getHelper().getAllPSAppViewLastModifyTimes(strPSSysAppId, psAppViewList);
    }

    @Override
    public CallResult getPSAppModule(String strPSAppModuleId, PSAppModule psAppModule) {
        String strCacheCat = "getPSAppModule";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSAppModuleId);
        CallResult callResult = this.readCache(strCacheCat, strCacheTag, psAppModule);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSAppModule(strPSAppModuleId, psAppModule);
        if (callResult.isOk()) {
            this.writeCache(strCacheCat, strCacheTag, psAppModule);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getAllPSAppModules(String strPSApplicationId, Vector<PSAppModule> psAppModules) {
        String strCacheCat = "getAllPSAppModules";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSApplicationId);
        CallResult callResult = this.readCache2(strCacheCat, strCacheTag, PSAppModule.class, psAppModules);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getAllPSAppModules(strPSApplicationId, psAppModules);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psAppModules);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSPF(String strPSPFId, PSPF psPF) {
        String strCacheCat = "getPSPF";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSPFId);
        CallResult callResult = this.readCache(strCacheCat, strCacheTag, psPF);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSPF(strPSPFId, psPF);
        if (callResult.isOk()) {
            this.writeCache(strCacheCat, strCacheTag, psPF);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSPFCtrlTemplDetails(String strPSPFCtrlTemplId, Vector<PSPFCtrlTemplDetail> psPFCtrlTemplDetailList) {
        String strCacheCat = "getPSPFCtrlTemplDetails";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSPFCtrlTemplId);
        CallResult callResult = this.readCache2(strCacheCat, strCacheTag, PSPFCtrlTemplDetail.class, psPFCtrlTemplDetailList);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSPFCtrlTemplDetails(strPSPFCtrlTemplId, psPFCtrlTemplDetailList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psPFCtrlTemplDetailList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSPFStyle(String strPSPFStyleId, PSPFStyle psPFStyle) {
        String strCacheCat = "getPSPFStyle";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSPFStyleId);
        CallResult callResult = this.readCache(strCacheCat, strCacheTag, psPFStyle);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSPFStyle(strPSPFStyleId, psPFStyle);
        if (callResult.isOk()) {
            this.writeCache(strCacheCat, strCacheTag, psPFStyle);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSPFCtrlTemplsByPFStyle(String strPSPFStyleId, Vector<PSPFCtrlTempl> psPFViewTemplList) {
        String strCacheCat = "getPSPFCtrlTemplsByPFStyle";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSPFStyleId);
        CallResult callResult = this.readCache2(strCacheCat, strCacheTag, PSPFCtrlTempl.class, psPFViewTemplList);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSPFCtrlTemplsByPFStyle(strPSPFStyleId, psPFViewTemplList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psPFViewTemplList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSPFEditorTemplsByPFStyle(String strPSPFStyleId, Vector<PSPFEditorTempl> psPFViewTemplList) {
        String strCacheCat = "getPSPFEditorTemplsByPFStyle";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSPFStyleId);
        CallResult callResult = this.readCache2(strCacheCat, strCacheTag, PSPFEditorTempl.class, psPFViewTemplList);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSPFEditorTemplsByPFStyle(strPSPFStyleId, psPFViewTemplList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psPFViewTemplList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSPFPubCodes(String strPSPFId, Vector<PSPFPubCode> psPFPubCodeList) {
        String strCacheCat = "getPSPFPubCodes";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSPFId);
        CallResult callResult = this.readCache2(strCacheCat, strCacheTag, PSPFPubCode.class, psPFPubCodeList);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSPFPubCodes(strPSPFId, psPFPubCodeList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psPFPubCodeList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSPFPubCode(String strPSPFPubCodeId, PSPFPubCode psPFPubCode) {
        String strCacheCat = "getPSPFPubCode";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSPFPubCodeId);
        CallResult callResult = this.readCache(strCacheCat, strCacheTag, psPFPubCode);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSPFPubCode(strPSPFPubCodeId, psPFPubCode);
        if (callResult.isOk()) {
            this.writeCache(strCacheCat, strCacheTag, psPFPubCode);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSPFEditorTemplsByPF(String strPSPFId, Vector<PSPFEditorTempl> psPFViewTemplList) {
        String strCacheCat = "getPSPFEditorTemplsByPF";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSPFId);
        CallResult callResult = this.readCache2(strCacheCat, strCacheTag, PSPFEditorTempl.class, psPFViewTemplList);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSPFEditorTemplsByPF(strPSPFId, psPFViewTemplList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psPFViewTemplList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSPFPubCodesByPPSPFPubCode(String strPSPFPubCodeId, Vector<PSPFPubCode> psPFPubCodeList) {
        String strCacheCat = "getPSPFPubCodesByPPSPFPubCode";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSPFPubCodeId);
        CallResult callResult = this.readCache2(strCacheCat, strCacheTag, PSPFPubCode.class, psPFPubCodeList);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSPFPubCodesByPPSPFPubCode(strPSPFPubCodeId, psPFPubCodeList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psPFPubCodeList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSPFPluginTempl(String strPSPFPluginTemplId, PSPFPluginTempl psPFPluginTempl) {
        String strCacheCat = "getPSPFPluginTempl";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSPFPluginTemplId);
        CallResult callResult = this.readCache(strCacheCat, strCacheTag, psPFPluginTempl);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSPFPluginTempl(strPSPFPluginTemplId, psPFPluginTempl);
        if (callResult.isOk()) {
            this.writeCache(strCacheCat, strCacheTag, psPFPluginTempl);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSSysPFPlugin(String strPSSysPFPluginId, PSSysPFPlugin psSysPFPlugin) {
        String strCacheCat = "getPSSysPFPlugin";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSSysPFPluginId);
        CallResult callResult = this.readCache(strCacheCat, strCacheTag, psSysPFPlugin);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSSysPFPlugin(strPSSysPFPluginId, psSysPFPlugin);
        if (callResult.isOk()) {
            this.writeCache(strCacheCat, strCacheTag, psSysPFPlugin);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSSysPFPluginTempl(String strPSSysPFPluginTemplId, PSSysPFPluginTempl psSysPFPluginTempl) {
        String strCacheCat = "getPSSysPFPluginTempl";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSSysPFPluginTemplId);
        CallResult callResult = this.readCache(strCacheCat, strCacheTag, psSysPFPluginTempl);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSSysPFPluginTempl(strPSSysPFPluginTemplId, psSysPFPluginTempl);
        if (callResult.isOk()) {
            this.writeCache(strCacheCat, strCacheTag, psSysPFPluginTempl);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getAllPSSysPFPluginTempls(String strPSSystemId, Vector<PSSysPFPluginTempl> psSysPFPluginTemplList) {
        String strCacheCat = "getAllPSSysPFPluginTempls";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSSystemId);
        CallResult callResult = this.readCache2(strCacheCat, strCacheTag, PSSysPFPluginTempl.class, psSysPFPluginTemplList);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getAllPSSysPFPluginTempls(strPSSystemId, psSysPFPluginTemplList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psSysPFPluginTemplList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getAllPSSysPFPlugins(String strPSSystemId, Vector<PSSysPFPlugin> psSysPFPluginList) {
        String strCacheCat = "getAllPSSysPFPlugins";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSSystemId);
        CallResult callResult = this.readCache2(strCacheCat, strCacheTag, PSSysPFPlugin.class, psSysPFPluginList);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getAllPSSysPFPlugins(strPSSystemId, psSysPFPluginList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psSysPFPluginList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSWorkflow(String strPSWorkflowId, PSWorkflow psWorkflow) {
        CallResult callResult = this.getPSWFVersionTag(strPSWorkflowId);
        if (callResult.isError()) {
            return callResult;
        }
        String strCacheCat = "getPSWorkflow";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSWorkflowId, (String)((String)callResult.getUserObject()));
        if ((callResult = this.readCache(strCacheCat, strCacheTag, psWorkflow)) != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSWorkflow(strPSWorkflowId, psWorkflow);
        if (callResult.isOk()) {
            this.writeCache(strCacheCat, strCacheTag, psWorkflow);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSDynaInst(String strPSDynaInstId, PSDynaInst psDynaInst) {
        return this.getHelper().getPSDynaInst(strPSDynaInstId, psDynaInst);
    }

    @Override
    public CallResult getPSAppPDTView(String strPSAppPDTViewId, PSAppPDTView psAppPDTView) {
        String strCacheCat = "getPSAppPDTView";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSAppPDTViewId);
        CallResult callResult = this.readCache(strCacheCat, strCacheTag, psAppPDTView);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getPSAppPDTView(strPSAppPDTViewId, psAppPDTView);
        if (callResult.isOk()) {
            this.writeCache(strCacheCat, strCacheTag, psAppPDTView);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getAllPSAppPDTViews(String strPSApplicationId, Vector<PSAppPDTView> psAppPDTViewList) {
        String strCacheCat = "getAllPSAppPDTViews";
        String strCacheTag = KeyValueHelper.genUniqueId((String)strPSApplicationId);
        CallResult callResult = this.readCache2(strCacheCat, strCacheTag, PSAppPDTView.class, psAppPDTViewList);
        if (callResult != null) {
            return callResult;
        }
        callResult = this.getHelper().getAllPSAppPDTViews(strPSApplicationId, psAppPDTViewList);
        if (callResult.isOk()) {
            this.writeCache2(strCacheCat, strCacheTag, psAppPDTViewList);
        } else if (callResult.getRetCode() == 3) {
            this.writeCache2(strCacheCat, strCacheTag, null);
        }
        return callResult;
    }

    @Override
    public CallResult getPSDataEntityTagsByDynaInst(String strDynaInstId, int nStart, int nPageSize, Vector<PSDataEntity> psDataEntities) {
        return this.getHelper().getPSDataEntityTagsByDynaInst(strDynaInstId, nStart, nPageSize, psDataEntities);
    }

    @Override
    public CallResult getPSWFVersionTagsByDynaInst(String strDynaInstId, int nStart, int nPageSize, Vector<PSWFVersion> psWFVersions) {
        return this.getHelper().getPSWFVersionTagsByDynaInst(strDynaInstId, nStart, nPageSize, psWFVersions);
    }

    @Override
    public CallResult getPSDEViewBaseTagsByDynaInst(String strDynaInstId, int nStart, int nPageSize, Vector<PSDEViewBase> psDEViewBases) {
        return this.getHelper().getPSDEViewBaseTagsByDynaInst(strDynaInstId, nStart, nPageSize, psDEViewBases);
    }

    @Override
    public CallResult getPSDEFormTagsByDynaInst(String strDynaInstId, int nStart, int nPageSize, Vector<PSDEForm> psDEForms) {
        return this.getHelper().getPSDEFormTagsByDynaInst(strDynaInstId, nStart, nPageSize, psDEForms);
    }

    protected CallResult getPSDataEntityTag(String strPSDataEntityId) {
        String strTag = null;
        if (!StringHelper.isNullOrEmpty((String)this.getPSDynaInstId())) {
            if (this.psDataEntityTagMap == null) {
                Vector<PSDataEntity> psDataEntities = new Vector<PSDataEntity>();
                CallResult callResult = this.getPSDataEntityTagsByDynaInst(this.getPSDynaInstId(), 0, 1000, psDataEntities);
                if (callResult.isError()) {
                    log.error((Object)StringHelper.format((String)"\u83b7\u53d6\u52a8\u6001\u5b9e\u4f8b[%1$s]\u5168\u90e8\u5b9e\u4f53\u6807\u8bb0\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)this.getPSDynaInstId(), (Object)callResult.getErrorInfo()));
                    return callResult;
                }
                HashMap<String, String> psDataEntityTagMap = new HashMap<String, String>();
                for (PSDataEntity psDataEntity : psDataEntities) {
                    String strPSDataEntityId2 = psDataEntity.getPSDATAENTITYID();
                    if (psDataEntity.getUPDATEDATE() == null) continue;
                    String strTag2 = StringHelper.format((String)"%1$s", (Object)psDataEntity.getUPDATEDATE().getTime());
                    psDataEntityTagMap.put(strPSDataEntityId2, strTag2);
                }
                this.psDataEntityTagMap = psDataEntityTagMap;
            }
            strTag = this.psDataEntityTagMap.get(strPSDataEntityId);
        }
        CallResult callResult = new CallResult();
        if (strTag != null) {
            callResult.setUserObject((Object)strTag);
        } else {
            callResult.setUserObject((Object)"");
        }
        return callResult;
    }

    protected CallResult getPSDEFormTag(String strPSDEFormId) {
        String strTag = null;
        if (!StringHelper.isNullOrEmpty((String)this.getPSDynaInstId())) {
            if (this.psDEFormTagMap == null) {
                Vector<PSDEForm> psDEForms = new Vector<PSDEForm>();
                CallResult callResult = this.getPSDEFormTagsByDynaInst(this.getPSDynaInstId(), 0, 1000, psDEForms);
                if (callResult.isError()) {
                    log.error((Object)StringHelper.format((String)"\u83b7\u53d6\u52a8\u6001\u5b9e\u4f8b[%1$s]\u5168\u90e8\u5b9e\u4f53\u8868\u5355\u6807\u8bb0\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)this.getPSDynaInstId(), (Object)callResult.getErrorInfo()));
                    return callResult;
                }
                HashMap<String, String> psDEFormTagMap = new HashMap<String, String>();
                for (PSDEForm psDEForm : psDEForms) {
                    String strPSDEFormId2 = psDEForm.getPSDEFORMID();
                    if (psDEForm.getUPDATEDATE() == null) continue;
                    String strTag2 = StringHelper.format((String)"%1$s", (Object)psDEForm.getUPDATEDATE().getTime());
                    psDEFormTagMap.put(strPSDEFormId2, strTag2);
                }
                this.psDEFormTagMap = psDEFormTagMap;
            }
            strTag = this.psDEFormTagMap.get(strPSDEFormId);
        }
        CallResult callResult = new CallResult();
        if (strTag != null) {
            callResult.setUserObject((Object)strTag);
        } else {
            callResult.setUserObject((Object)"");
        }
        return callResult;
    }

    protected CallResult getPSDEViewBaseTag(String strPSDEViewBaseId) {
        String strTag = null;
        if (!StringHelper.isNullOrEmpty((String)this.getPSDynaInstId())) {
            if (this.psDEViewBaseTagMap == null) {
                Vector<PSDEViewBase> psDEViewBases = new Vector<PSDEViewBase>();
                CallResult callResult = this.getPSDEViewBaseTagsByDynaInst(this.getPSDynaInstId(), 0, 1000, psDEViewBases);
                if (callResult.isError()) {
                    log.error((Object)StringHelper.format((String)"\u83b7\u53d6\u52a8\u6001\u5b9e\u4f8b[%1$s]\u5168\u90e8\u5b9e\u4f53\u89c6\u56fe\u6807\u8bb0\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)this.getPSDynaInstId(), (Object)callResult.getErrorInfo()));
                    return callResult;
                }
                HashMap<String, String> psDEViewBaseTagMap = new HashMap<String, String>();
                for (PSDEViewBase psDEViewBase : psDEViewBases) {
                    String strPSDEViewBaseId2 = psDEViewBase.getPSDEVIEWBASEID();
                    if (psDEViewBase.getUPDATEDATE() == null) continue;
                    String strTag2 = StringHelper.format((String)"%1$s", (Object)psDEViewBase.getUPDATEDATE().getTime());
                    psDEViewBaseTagMap.put(strPSDEViewBaseId2, strTag2);
                }
                this.psDEViewBaseTagMap = psDEViewBaseTagMap;
            }
            strTag = this.psDEViewBaseTagMap.get(strPSDEViewBaseId);
        }
        CallResult callResult = new CallResult();
        if (strTag != null) {
            callResult.setUserObject((Object)strTag);
        } else {
            callResult.setUserObject((Object)"");
        }
        return callResult;
    }

    protected CallResult getPSWFVersionTag(String strPSWFVersionId) {
        String strTag = null;
        if (!StringHelper.isNullOrEmpty((String)this.getPSDynaInstId())) {
            if (this.psWFVersionTagMap == null) {
                Vector<PSWFVersion> psWFVersions = new Vector<PSWFVersion>();
                CallResult callResult = this.getPSWFVersionTagsByDynaInst(this.getPSDynaInstId(), 0, 1000, psWFVersions);
                if (callResult.isError()) {
                    log.error((Object)StringHelper.format((String)"\u83b7\u53d6\u52a8\u6001\u5b9e\u4f8b[%1$s]\u5168\u90e8\u5de5\u4f5c\u6d41\u6807\u8bb0\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)this.getPSDynaInstId(), (Object)callResult.getErrorInfo()));
                    return callResult;
                }
                HashMap<String, String> psWFVersionTagMap = new HashMap<String, String>();
                for (PSWFVersion psWFVersion : psWFVersions) {
                    String strPSWFVersionId2 = psWFVersion.getPSWFVERSIONID();
                    if (psWFVersion.getUPDATEDATE() == null) continue;
                    String strTag2 = StringHelper.format((String)"%1$s", (Object)psWFVersion.getUPDATEDATE().getTime());
                    psWFVersionTagMap.put(strPSWFVersionId2, strTag2);
                }
                this.psWFVersionTagMap = psWFVersionTagMap;
            }
            strTag = this.psWFVersionTagMap.get(strPSWFVersionId);
        }
        CallResult callResult = new CallResult();
        if (strTag != null) {
            callResult.setUserObject((Object)strTag);
        } else {
            callResult.setUserObject((Object)"");
        }
        return callResult;
    }
}

