/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.Helper
 *  net.ibizsys.paas.control.tree.ITreeNode
 *  net.ibizsys.paas.control.tree.ITreeNodeDataItem
 *  net.ibizsys.paas.ctrlhandler.ITreeNodeFetchContext
 *  net.ibizsys.paas.ctrlmodel.ITreeModel
 *  net.ibizsys.paas.ctrlmodel.ITreeNodeRSModel
 *  net.ibizsys.paas.db.IDataTable
 *  net.ibizsys.paas.security.AccessUserModes
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.util.PropertiesHelper
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.Tree;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.Logic.BuiltinPSAppUINewDataLogicImpl;
import SA.SRFDA.PS.Core.App.Logic.BuiltinPSAppUIOpenDataLogicImpl;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.IPSAppViewRef;
import SA.SRFDA.PS.Core.App.View.IPSAppViewUIAction;
import SA.SRFDA.PS.Core.App.View.PSAppViewLogicImpl;
import SA.SRFDA.PS.Core.App.View.PSAppViewRefImpl;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridColumnType;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSControlXDataContainer;
import SA.SRFDA.PS.Core.Control.IPSNavigateContext;
import SA.SRFDA.PS.Core.Control.IPSNavigateParam;
import SA.SRFDA.PS.Core.Control.PSControlItemImpl;
import SA.SRFDA.PS.Core.Control.PSNavigateContextImpl;
import SA.SRFDA.PS.Core.Control.PSNavigateParamImpl;
import SA.SRFDA.PS.Core.Control.Toolbar.IPSDECMUIActionItem;
import SA.SRFDA.PS.Core.Control.Toolbar.IPSDEContextMenu;
import SA.SRFDA.PS.Core.Control.Toolbar.IPSDEContextMenuItem;
import SA.SRFDA.PS.Core.Control.Toolbar.PSDEContextMenuParamImpl;
import SA.SRFDA.PS.Core.Control.Tree.HiddenPSDETreeNodeEditItemImpl;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETree;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeColumn;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNode;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNodeColumn;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNodeDataItem;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNodeEditItem;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNodeEditItemUpdate;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNodeRS;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNodeRV;
import SA.SRFDA.PS.Core.Control.Tree.PSDETreeNodeDataItemImpl;
import SA.SRFDA.PS.Core.Control.Tree.PSDETreeNodeRVImpl;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERBase;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDQCondition;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Print.IPSDEPrint;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysCss;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.Security.IPSSysUniRes;
import SA.SRFDA.PS.Data.PSAppViewLogic;
import SA.SRFDA.PS.Data.PSAppViewRef;
import SA.SRFDA.PS.Data.PSDETreeNode;
import SA.SRFDA.PS.Data.PSDETreeNodeColumn;
import SA.SRFDA.PS.Data.PSDETreeNodeRV;
import SA.SRFDA.PS.Data.PSDEViewCtrl;
import SA.SRFDA.PS.Data.PSSysViewLogic;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.Helper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;
import net.ibizsys.paas.control.tree.ITreeNode;
import net.ibizsys.paas.control.tree.ITreeNodeDataItem;
import net.ibizsys.paas.ctrlhandler.ITreeNodeFetchContext;
import net.ibizsys.paas.ctrlmodel.ITreeModel;
import net.ibizsys.paas.ctrlmodel.ITreeNodeRSModel;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.security.AccessUserModes;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.PropertiesHelper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDETreeNodeImplBase
extends PSControlItemImpl
implements IPSDETreeNode,
IPSControlXDataContainer {
    private static final Log log = LogFactory.getLog(PSDETreeNodeImplBase.class);
    private IPSDETree iPSDETree = null;
    protected PSDETreeNode psDETreeNode = null;
    private IPSSysPFPlugin iPSSysPFPlugin = null;
    private IPSAppView navPSAppView = null;
    private String strEmbedViewId = "";
    private Properties navViewParams = null;
    private JSONObject joNavViewParams = new JSONObject();
    private IPSSysImage iPSSysImage = null;
    private IPSSysCss iPSSysCss = null;
    private IPSDEContextMenu iPSDEContextMenu = null;
    private boolean bEnableViewActions = true;
    private long nViewActions = 0L;
    private boolean bEnableNewDataDefault = true;
    private boolean bEnableEditDataDefault = false;
    private boolean bEnableRemoveDataDefault = false;
    private boolean bEnablePrintDefault = false;
    private IPSDEPrint iPSDEPrint = null;
    private IPSDataEntity iPSDataEntity = null;
    protected String strNewDataMode = "";
    protected String strEditDataMode = "";
    private boolean bLoadDefault = false;
    private boolean bEnableBatchAdd = false;
    private boolean bBatchAddOnly = false;
    private boolean bEnableQuickSearch = false;
    private ArrayList<IPSDETreeNodeRV> psDETreeNodeRVList = new ArrayList();
    protected String strRemovePSDEActionName = "";
    protected String strRemovePSDEOPPrivName = "";
    private IPSLanguageRes namePSLanguageRes = null;
    private IPSDERBase navPSDERBase = null;
    private String strNavPSDERId = null;
    private String strNavPSDEViewBaseId = null;
    private String strNavFilter = null;
    private int nCounterMode = 0;
    private String strCounterId = null;
    private String strNodeDataType = null;
    private Map<String, IPSDETreeNodeColumn> psDETreeNodeColumnMap = null;
    private Map<String, IPSDETreeNodeDataItem> psDETreeNodeDataItemMap = null;
    private Map<String, IPSDETreeNodeEditItem> psDETreeNodeEditItemMap = null;
    private ArrayList<IPSDETreeNodeRS> iPSDETreeNodeRSList = null;
    protected Map<String, IPSAppViewRef> psAppViewRefMap = null;
    private IPSAppViewUIAction defaultPSUIAction = null;
    private boolean bSelected = false;
    private boolean bSelectFirstOnly = false;
    private boolean bExpandFirstOnly = false;
    private boolean bExpanded = false;
    private IPSAppDataEntity iPSAppDataEntity = null;
    private Map<String, IPSNavigateContext> psNavigateContextMap = null;
    private Map<String, IPSNavigateParam> psNavigateParamMap = null;
    private int nEditMode = 0;
    private IPSSysUniRes iPSSysUniRes = null;
    private IPSSysCss shapePSSysCss = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDETree iPSDETree, PSDETreeNode psDETreeNode) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSDETree(iPSDETree);
            this.psDETreeNode = psDETreeNode;
            this.setId(this.psDETreeNode.getPSDETREENODEID());
            this.setName(this.psDETreeNode.getPSDETREENODENAME());
            this.setPSObjectData(psDETreeNode);
            if (!StringHelper.isNullOrEmpty((String)this.psDETreeNode.getPSDEID())) {
                this.iPSDataEntity = this.getPSDETree().getPSAppView().getPSSystem().getPSDataEntity2(this.psDETreeNode.getPSDEID());
                if (this.iPSDataEntity != null) {
                    this.iPSAppDataEntity = this.getPSDETree().getPSAppView().getPSApplication().getPSAppDataEntity(this.getNodeType(), true);
                    if (this.iPSAppDataEntity != null && StringHelper.compare((String)this.iPSAppDataEntity.getPSDataEntity().getId(), (String)this.iPSDataEntity.getId(), (boolean)false) != 0) {
                        this.iPSAppDataEntity = null;
                    }
                    if (this.iPSAppDataEntity == null) {
                        this.iPSAppDataEntity = this.getPSDETree().getPSAppView().getPSApplication().getPSAppDataEntityByDEId(this.iPSDataEntity.getId(), true);
                    }
                }
            }
            if (!psDETreeNode.isENABLEVIEWACTIONSNull()) {
                this.bEnableViewActions = psDETreeNode.getENABLEVIEWACTIONS();
            }
            if (this.bEnableViewActions) {
                this.nViewActions = psDETreeNode.getVIEWACTIONS();
            }
            this.strNewDataMode = this.psDETreeNode.getNEWDATAMODE();
            this.strEditDataMode = this.psDETreeNode.getEDITDATAMODE();
            this.navViewParams = PropertiesHelper.load((String)this.psDETreeNode.getNAVVIEWPARAM());
            if (!StringHelper.isNullOrEmpty((String)this.psDETreeNode.getPSSYSIMAGEID())) {
                this.iPSSysImage = this.getPSDETree().getPSAppView().getPSSystem().getPSSysImage(this.psDETreeNode.getPSSYSIMAGEID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDETreeNode.getPSSYSCSSID())) {
                this.iPSSysCss = this.getPSDETree().getPSAppView().getPSSystem().getPSSysCss(this.psDETreeNode.getPSSYSCSSID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDETreeNode.getSHAPEPSSYSCSSID())) {
                this.shapePSSysCss = this.getPSDETree().getPSAppView().getPSSystem().getPSSysCss(this.psDETreeNode.getSHAPEPSSYSCSSID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDETreeNode.getREMOVEPSDEACTIONNAME())) {
                this.bEnableRemoveDataDefault = true;
                this.strRemovePSDEActionName = this.psDETreeNode.getREMOVEPSDEACTIONNAME();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDETreeNode.getREMOVEPSDEOPPRIVNAME())) {
                this.bEnableRemoveDataDefault = true;
                this.strRemovePSDEOPPrivName = this.psDETreeNode.getREMOVEPSDEOPPRIVNAME();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDETreeNode.getNAMEPSLANRESID())) {
                this.namePSLanguageRes = this.getPSDETree().getPSAppView().getPSApplication().getPSLanguageRes(this.psDETreeNode.getNAMEPSLANRESID());
            }
            this.strNavPSDEViewBaseId = this.psDETreeNode.getPSDEVIEWBASEID();
            if (!StringHelper.isNullOrEmpty((String)this.strNavPSDEViewBaseId)) {
                this.strNavPSDERId = this.psDETreeNode.getPSDERID();
                if (!StringHelper.isNullOrEmpty((String)this.psDETreeNode.getNAVVIEWFILTER())) {
                    this.strNavFilter = this.psDETreeNode.getNAVVIEWFILTER();
                }
            }
            if (!this.psDETreeNode.isCOUNTERMODENull()) {
                this.nCounterMode = this.psDETreeNode.getCOUNTERMODE();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDETreeNode.getCOUNTERID())) {
                this.strCounterId = this.psDETreeNode.getCOUNTERID();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDETreeNode.getNODEDATATYPE())) {
                this.strNodeDataType = this.psDETreeNode.getNODEDATATYPE();
            }
            this.bEnableQuickSearch = !this.psDETreeNode.isENABLEQUICKSEARCHNull() ? this.psDETreeNode.getENABLEQUICKSEARCH() : this.getPSDETree().isEnableSearchDefault();
            if (!this.psDETreeNode.isEXPANDNull()) {
                this.bExpanded = this.psDETreeNode.getEXPAND() > 0;
                boolean bl = this.bExpandFirstOnly = this.psDETreeNode.getEXPAND() == 2;
            }
            if (!this.psDETreeNode.isSELECTEDNull()) {
                this.bSelected = this.psDETreeNode.getSELECTED() > 0;
                boolean bl = this.bSelectFirstOnly = this.psDETreeNode.getSELECTED() == 2;
            }
            if (!this.psDETreeNode.isEDITMODENull()) {
                this.nEditMode = this.psDETreeNode.getEDITMODE();
            }
            this.onInit();
        }
        catch (Exception ex) {
            this.throwCriticalInitException(ex);
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            if (this.getPSSystemUtil() != null) {
                this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
            }
            this.throwInitException(ex);
        }
    }

    @Override
    protected void onInit() throws Exception {
        block17: {
            ArrayList<PSDETreeNodeRV> psDETreeNodeRVList;
            this.onPreparePSDETreeNodeDataItems();
            if (this.getPSDETree().getPSAppView().getPSApplication().isEnableUIModelEx()) {
                this.onPreparePSDETreeNodeColumns();
                this.onPreparePSDETreeNodeEditItems();
            }
            this.onPreparePSNavViewParams();
            if (!StringHelper.isNullOrEmpty((String)this.psDETreeNode.getPSSYSPFPLUGINID())) {
                this.iPSSysPFPlugin = this.getPSDETree().getPSAppView().getPSApplication() != null ? this.getPSDETree().getPSAppView().getPSApplication().getPSSysPFPlugin(this.psDETreeNode.getPSSYSPFPLUGINID(), "CONTROLITEM", this.getPSDETree().getControlType(), this.getTreeNodeType()) : this.getPSDETree().getPSAppView().getPSSystem().getPSSysPFPlugin(this.psDETreeNode.getPSSYSPFPLUGINID());
                this.getPSDETree().getPSAppView().registerPSSysPFPlugin(this.iPSSysPFPlugin);
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDETreeNode.getPSSYSUNIRESID())) {
                this.iPSSysUniRes = this.getPSDETree().getPSAppView().getPSApplication().getPSSysUniRes(this.psDETreeNode.getPSSYSUNIRESID());
            }
            if ((psDETreeNodeRVList = this.psDETreeNode.getPSDETreeNodeRVs(false)) != null) {
                for (PSDETreeNodeRV psDETreeNodeRV : psDETreeNodeRVList) {
                    PSDETreeNodeRVImpl iPSDETreeNodeRV = new PSDETreeNodeRVImpl();
                    iPSDETreeNodeRV.init(this.getDAGlobalHelper(), this, psDETreeNodeRV);
                    this.psDETreeNodeRVList.add(iPSDETreeNodeRV);
                }
                for (IPSDETreeNodeRV iPSDETreeNodeRV : this.psDETreeNodeRVList) {
                    String strViewRefMode = iPSDETreeNodeRV.getName();
                    IPSAppViewRef iPSAppViewRef = this.getPSAppViewRef(strViewRefMode, true);
                    if (iPSAppViewRef != null) continue;
                    String strPSAppDEViewId = Helper.GenUniqueId((String)this.getPSDETree().getPSAppView().getPSApplication().getId(), (String)iPSDETreeNodeRV.getPSDEViewBaseId());
                    PSAppViewRef psAppViewRef = new PSAppViewRef();
                    psAppViewRef.setPSAPPVIEWREFNAME(strViewRefMode);
                    psAppViewRef.setMINORPSAPPVIEWID(strPSAppDEViewId);
                    psAppViewRef.setParamValue("MINORPSDEVIEWBASEID", iPSDETreeNodeRV.getPSDEViewBaseId());
                    psAppViewRef.setParamValue("TRYMODE", true);
                    psAppViewRef.setVIEWPARAMS(iPSDETreeNodeRV.getViewParam());
                    this.registerPSAppViewRef(psAppViewRef);
                }
            }
            if (!StringHelper.isNullOrEmpty((String)this.getNavPSDEViewId())) {
                String strApplicationViewId = Helper.GenUniqueId((String)this.getPSDETree().getPSAppView().getPSApplication().getId(), (String)this.getNavPSDEViewId());
                this.navPSAppView = this.getPSDETree().getPSAppView().getPSApplication().getPSAppView(strApplicationViewId, this.getNavPSDEViewId(), this.getPSDETree().getPSAppView());
                this.strEmbedViewId = this.getPSDETree().getPSAppView().generateViewUniId();
                if (!StringHelper.isNullOrEmpty((String)this.getNavPSDERId())) {
                    this.navPSDERBase = this.getPSDETree().getPSAppView().getPSApplication().getPSSystem().getPSDER(this.getNavPSDERId());
                }
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDETreeNode.getPSDETOOLBARID())) {
                if (this.getPSDataEntity() != null && this.isEnablePrint() && this.getPSDataEntity().hasPSDEPrint()) {
                    this.iPSDEPrint = this.getPSDataEntity().getDefaultPSDEPrint();
                }
                try {
                    String strContextMenuTag = StringHelper.format((String)"%1$s_%2$s", (Object)this.getNodeType(), (Object)"cm").toLowerCase();
                    PSDEViewCtrl psDEViewCtrl = new PSDEViewCtrl();
                    psDEViewCtrl.setPSDEVIEWCTRLNAME(strContextMenuTag);
                    psDEViewCtrl.setPSDEVIEWCTRLTYPE("CONTEXTMENU");
                    psDEViewCtrl.setPSDETOOLBARID(this.psDETreeNode.getPSDETOOLBARID());
                    psDEViewCtrl.setPSDETOOLBARNAME(this.psDETreeNode.getPSDETOOLBARNAME());
                    psDEViewCtrl.setPSDEUAGROUPID(this.psDETreeNode.getPSDEUAGROUPID());
                    psDEViewCtrl.setNO2PSDEUAGROUPID(this.psDETreeNode.getNO2PSDEUAGROUPID());
                    PSDEContextMenuParamImpl psDEContextMenuParamImpl = new PSDEContextMenuParamImpl();
                    psDEContextMenuParamImpl.setOwner(this);
                    psDEContextMenuParamImpl.init(this.getDAGlobalHelper(), null, psDEViewCtrl);
                    this.iPSDEContextMenu = (IPSDEContextMenu)this.getPSDETree().registerPSControl(strContextMenuTag, "CONTEXTMENU", psDEContextMenuParamImpl);
                    Iterator<IPSDEContextMenuItem> psDEContextMenuItems = this.iPSDEContextMenu.getPSDEContextMenuItems();
                    if (psDEContextMenuItems == null) break block17;
                    while (psDEContextMenuItems.hasNext()) {
                        IPSDEContextMenuItem iPSDEContextMenuItem = psDEContextMenuItems.next();
                        if (!(iPSDEContextMenuItem instanceof IPSDECMUIActionItem) || ((IPSDECMUIActionItem)iPSDEContextMenuItem).getActionLevel() != 200) continue;
                        this.defaultPSUIAction = ((IPSDECMUIActionItem)iPSDEContextMenuItem).getPSAppViewUIAction();
                        if (this.defaultPSUIAction == null) {
                            continue;
                        }
                        break;
                    }
                }
                catch (Exception ex) {
                    throw new Exception(StringHelper.format((String)"\u6ce8\u518c\u4e0a\u4e0b\u6587\u83dc\u5355\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), ex);
                }
            }
        }
        if (this.isPrepareDefaultPSAppViewLogics() && this.getPSAppViewRefs() != null) {
            PSAppViewLogicImpl psAppViewLogicImpl;
            PSAppViewLogic psAppViewLogic;
            PSSysViewLogic psSysViewLogic;
            String strNewDataTag = StringHelper.format((String)"%1$s_%2$s", (Object)this.getNodeType(), (Object)"newdata").toLowerCase();
            String strEditDataTag = StringHelper.format((String)"%1$s_%2$s", (Object)this.getNodeType(), (Object)"opendata").toLowerCase();
            if (this.isEnableNewData() && this.getPSDETree().getPSAppViewLogic(strNewDataTag, true) == null) {
                BuiltinPSAppUINewDataLogicImpl defaultPSAppViewNewDataLogicImpl = new BuiltinPSAppUINewDataLogicImpl();
                psSysViewLogic = new PSSysViewLogic();
                psSysViewLogic.setPSSYSVIEWLOGICID("APP_NEWDATA");
                psSysViewLogic.setPSSYSVIEWLOGICNAME("\u65b0\u5efa\u6570\u636e");
                defaultPSAppViewNewDataLogicImpl.init(this.getDAGlobalHelper(), this, psSysViewLogic);
                psAppViewLogic = new PSAppViewLogic();
                psAppViewLogic.setPSAPPVIEWLOGICID(strNewDataTag);
                psAppViewLogic.setPSAPPVIEWLOGICNAME(strNewDataTag);
                psAppViewLogic.setPSAPPVIEWLOGICTYPE("CUSTOM");
                psAppViewLogicImpl = new PSAppViewLogicImpl();
                psAppViewLogicImpl.init(this.getDAGlobalHelper(), (Object)this.getPSDETree(), psAppViewLogic, defaultPSAppViewNewDataLogicImpl);
                this.getPSDETree().registerPSAppViewLogic(psAppViewLogicImpl);
            }
            if ((this.isEnableEditData() || this.isEnableViewData()) && this.getPSDETree().getPSAppViewLogic(strEditDataTag, true) == null) {
                BuiltinPSAppUIOpenDataLogicImpl defaultPSAppViewOpenDataLogicImpl = new BuiltinPSAppUIOpenDataLogicImpl();
                psSysViewLogic = new PSSysViewLogic();
                psSysViewLogic.setPSSYSVIEWLOGICID("APP_OPENDATA");
                psSysViewLogic.setPSSYSVIEWLOGICNAME("\u6253\u5f00\u6570\u636e");
                defaultPSAppViewOpenDataLogicImpl.init(this.getDAGlobalHelper(), this, psSysViewLogic);
                psAppViewLogic = new PSAppViewLogic();
                psAppViewLogic.setPSAPPVIEWLOGICID(strEditDataTag);
                psAppViewLogic.setPSAPPVIEWLOGICNAME(strEditDataTag);
                psAppViewLogic.setPSAPPVIEWLOGICTYPE("CUSTOM");
                psAppViewLogicImpl = new PSAppViewLogicImpl();
                psAppViewLogicImpl.init(this.getDAGlobalHelper(), (Object)this.getPSDETree(), psAppViewLogic, defaultPSAppViewOpenDataLogicImpl);
                this.getPSDETree().registerPSAppViewLogic(psAppViewLogicImpl);
            }
        }
        super.onInit();
    }

    protected void onPreparePSNavViewParams() throws Exception {
        if (this.navViewParams != null) {
            for (Object objKey : this.navViewParams.keySet()) {
                PSNavigateParamImpl PSNavigateParamImpl2;
                boolean bRawValue;
                String strKey = objKey.toString();
                String strValue = PropertiesHelper.getProperty((Properties)this.navViewParams, (String)strKey);
                String strTag = strKey.toUpperCase();
                if (strTag.indexOf("SRFNAVCTX.") == 0) {
                    bRawValue = true;
                    strTag = strKey.substring("SRFNAVCTX.".length()).toUpperCase();
                    if (!StringHelper.isNullOrEmpty((String)strValue) && strValue.charAt(0) == '%' && strValue.charAt(strValue.length() - 1) == '%') {
                        strValue = strValue.replace("%", "");
                        bRawValue = false;
                    }
                    PSNavigateContextImpl PSNavigateContextImpl2 = new PSNavigateContextImpl();
                    PSNavigateContextImpl2.init(this.getDAGlobalHelper(), this, strTag, strValue, null, bRawValue);
                    if (this.psNavigateContextMap == null) {
                        this.psNavigateContextMap = new LinkedHashMap<String, IPSNavigateContext>();
                    }
                    this.psNavigateContextMap.put(strTag, PSNavigateContextImpl2);
                    continue;
                }
                if (strTag.indexOf("SRFNAVPARAM.") == 0) {
                    bRawValue = true;
                    strTag = strKey.substring("SRFNAVPARAM.".length()).toLowerCase();
                    if (!StringHelper.isNullOrEmpty((String)strValue) && strValue.charAt(0) == '%' && strValue.charAt(strValue.length() - 1) == '%') {
                        strValue = strValue.replace("%", "");
                        bRawValue = false;
                    }
                    PSNavigateParamImpl2 = new PSNavigateParamImpl();
                    PSNavigateParamImpl2.init(this.getDAGlobalHelper(), this, strTag, strValue, null, bRawValue);
                    if (this.psNavigateParamMap == null) {
                        this.psNavigateParamMap = new LinkedHashMap<String, IPSNavigateParam>();
                    }
                    this.psNavigateParamMap.put(strTag, PSNavigateParamImpl2);
                    continue;
                }
                bRawValue = true;
                strTag = strKey.toLowerCase();
                if (!StringHelper.isNullOrEmpty((String)strValue) && strValue.charAt(0) == '%' && strValue.charAt(strValue.length() - 1) == '%') {
                    strValue = strValue.replace("%", "");
                    bRawValue = false;
                }
                PSNavigateParamImpl2 = new PSNavigateParamImpl();
                PSNavigateParamImpl2.init(this.getDAGlobalHelper(), this, strTag, strValue, null, bRawValue);
                if (this.psNavigateParamMap == null) {
                    this.psNavigateParamMap = new LinkedHashMap<String, IPSNavigateParam>();
                }
                this.psNavigateParamMap.put(strTag, PSNavigateParamImpl2);
                this.joNavViewParams.put(strKey.toLowerCase(), (Object)PropertiesHelper.getProperty((Properties)this.navViewParams, (String)strKey));
            }
        }
    }

    @Override
    @PSModelRTMeta(description="\u6811\u89c6\u56fe\u90e8\u4ef6")
    public IPSDETree getPSDETree() {
        return this.iPSDETree;
    }

    protected void setPSDETree(IPSDETree iPSDETree) {
        this.iPSDETree = iPSDETree;
    }

    @Override
    public String getRemovePSDEActionName() {
        return this.strRemovePSDEActionName;
    }

    public void setRemovePSDEActionName(String strRemovePSDEActionName) {
        this.strRemovePSDEActionName = strRemovePSDEActionName;
    }

    @Override
    public String getRemovePSDEOPPrivName() {
        return this.strRemovePSDEOPPrivName;
    }

    public void setRemovePSDEOPPrivName(String strRemovePSDEOPPrivName) {
        this.strRemovePSDEOPPrivName = strRemovePSDEOPPrivName;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5bf9\u8c61", hideempty2=true)
    public IPSDataEntity getPSDataEntity() {
        return this.iPSDataEntity;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u5bf9\u8c61", hideempty2=true, dumpref=true, fields={"PSDEID"})
    public IPSAppDataEntity getPSAppDataEntity() {
        return this.iPSAppDataEntity;
    }

    protected boolean isEnableViewActions() {
        return this.bEnableViewActions;
    }

    protected long getViewActions() {
        return this.nViewActions;
    }

    @Override
    @PSModelRTMeta(description="\u8282\u70b9\u7c7b\u578b", codelist="DETreeNodeType", fields={"TREENODETYPE"})
    public String getTreeNodeType() {
        return this.psDETreeNode.getTREENODETYPE();
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSDETree.getPSSysModelInstId();
    }

    public Iterator<ITreeNodeRSModel> getTreeNodeRSModels() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u9644\u52a0\u7236\u8282\u70b9\u6807\u8bc6", fields={"APPENDPNODEID"})
    public boolean isAppendPNodeId() {
        return this.psDETreeNode.getAPPENDPNODEID();
    }

    @Override
    public String getIconCls() {
        if (this.getPSSysImage() != null) {
            return this.getPSSysImage().getCssClass();
        }
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u5c55\u5f00", fields={"EXPAND"})
    public boolean isExpanded() {
        return this.bExpanded;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u9009\u4e2d", fields={"ENABLECHECK"})
    public boolean isEnableCheck() {
        return this.psDETreeNode.getENABLECHECK();
    }

    @Override
    @PSModelRTMeta(description="\u8282\u70b9\u6807\u8bc6", fields={"NODETYPE"})
    public String getNodeType() {
        return this.psDETreeNode.getNODETYPE();
    }

    @Override
    public boolean isChecked() {
        return this.psDETreeNode.getCHECKED();
    }

    @Override
    @PSModelRTMeta(description="\u6839\u8282\u70b9", fields={"ROOTNODE"})
    public boolean isRootNode() {
        return this.psDETreeNode.getROOTNODE();
    }

    @Override
    public String getNavPSDEViewId() {
        return this.strNavPSDEViewBaseId;
    }

    @Override
    @PSModelRTMeta(description="\u5bfc\u822a\u89c6\u56fe\u5bf9\u8c61", hideempty=true, dumpref=true, fields={"PSDEVIEWBASEID"})
    public IPSAppView getNavPSAppView() {
        return this.navPSAppView;
    }

    @Override
    public String getEmbedViewId() {
        return this.strEmbedViewId;
    }

    public void fillFetchResult(ITreeNodeFetchContext iTreeNodeFetchContext, ArrayList<ITreeNode> treeNodeList) throws Exception {
    }

    public void fillFetchResult(ITreeNodeFetchContext iTreeNodeFetchContext, ArrayList<ITreeNode> treeNodeList, IDataTable dt) throws Exception {
    }

    @Override
    public boolean hasTreeNodeRSModel() {
        return false;
    }

    @Override
    public JSONObject getNavViewParam() {
        return this.joNavViewParams;
    }

    @Override
    @PSModelRTMeta(description="\u8282\u70b9\u56fe\u6807\u5bf9\u8c61", fields={"PSSYSIMAGEID"})
    public IPSSysImage getPSSysImage() {
        return this.iPSSysImage;
    }

    @Override
    @PSModelRTMeta(description="\u8282\u70b9\u754c\u9762\u6837\u5f0f\u8868", fields={"PSSYSCSSID"})
    public IPSSysCss getPSSysCss() {
        return this.iPSSysCss;
    }

    @Override
    @PSModelRTMeta(description="\u4e0a\u4e0b\u6587\u83dc\u5355\u5bf9\u8c61", modelcls="SA.SRFDA.PS.Core.Control.Toolbar.IPSDEContextMenu", modeltype="PSDECONTEXTMENU", child=true, fields={"PSDETOOLBARID"})
    public IPSDEContextMenu getPSDEContextMenu() {
        return this.iPSDEContextMenu;
    }

    @Override
    public void fillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception {
        if (this.getPSDEContextMenu() != null) {
            this.getPSDEContextMenu().fillRelatedPSAppViews(relatedAppViewList);
        }
    }

    @Override
    public boolean isReadOnly() {
        return true;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u65b0\u5efa\u6570\u636e")
    public boolean isEnableNewData() {
        if (this.isEnableViewActions()) {
            return (this.getViewActions() & 1L) > 0L;
        }
        return this.isEnableNewDataDefault();
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u7f16\u8f91\u6570\u636e")
    public boolean isEnableEditData() {
        if (this.isEnableViewActions()) {
            return (this.getViewActions() & 2L) > 0L;
        }
        return this.isEnableEditDataDefault();
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u5220\u9664\u6570\u636e")
    public boolean isEnableRemoveData() {
        if (this.isEnableViewActions()) {
            return (this.getViewActions() & 8L) > 0L;
        }
        return this.isEnableRemoveDataDefault();
    }

    @Override
    public boolean isEnablePrint() {
        if (this.isEnableViewActions()) {
            return (this.getViewActions() & 0x80L) > 0L;
        }
        return this.isEnablePrintDefault();
    }

    @Override
    public boolean isEnableCopy() {
        if (this.isEnableViewActions()) {
            return (this.getViewActions() & 0x10L) > 0L;
        }
        return this.isEnableNewData();
    }

    protected boolean isEnableEditDataDefault() {
        return this.bEnableEditDataDefault;
    }

    protected void setEnableEditDataDefault(boolean bEnableEditDataDefault) {
        this.bEnableEditDataDefault = bEnableEditDataDefault;
    }

    protected boolean isEnableNewDataDefault() {
        return this.bEnableNewDataDefault;
    }

    protected void setEnableNewDataDefault(boolean bEnableNewDataDefault) {
        this.bEnableNewDataDefault = bEnableNewDataDefault;
    }

    protected boolean isEnableRemoveDataDefault() {
        return this.bEnableRemoveDataDefault;
    }

    protected void setEnableRemoveDataDefault(boolean bEnableRemoveDataDefault) {
        this.bEnableRemoveDataDefault = bEnableRemoveDataDefault;
    }

    @Override
    public boolean isEnableStartWF() {
        if (this.isEnableViewActions()) {
            return (this.getViewActions() & 0x800L) > 0L;
        }
        return this.isEnableStartWFDefault();
    }

    protected boolean isEnableStartWFDefault() {
        return false;
    }

    protected boolean isEnablePrintDefault() {
        return this.bEnablePrintDefault;
    }

    protected void setEnablePrintDefault(boolean bEnablePrintDefault) {
        this.bEnablePrintDefault = bEnablePrintDefault;
    }

    @Override
    public IPSDEPrint getPSDEPrint() {
        return this.iPSDEPrint;
    }

    @Override
    public boolean isPickupMode() {
        return false;
    }

    @Override
    public String getNewDataMode() {
        return this.strNewDataMode;
    }

    @Override
    public String getEditDataMode() {
        return this.strEditDataMode;
    }

    @Override
    public boolean isLoadDefault() {
        return this.bLoadDefault;
    }

    @Override
    public boolean isEnableBatchAdd() {
        if (!this.isEnableNewData()) {
            return false;
        }
        return this.bEnableBatchAdd;
    }

    @Override
    public boolean isBatchAddOnly() {
        return this.bBatchAddOnly;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u67e5\u770b\u6570\u636e")
    public boolean isEnableViewData() {
        if (this.isEnableViewActions()) {
            return (this.getViewActions() & 4L) > 0L;
        }
        return !this.isEnableEditData();
    }

    @Override
    public boolean isEnableImport() {
        if (this.isEnableViewActions()) {
            return (this.getViewActions() & 0x400L) > 0L;
        }
        return false;
    }

    @Override
    public boolean isEnableExport() {
        if (this.isEnableViewActions()) {
            return (this.getViewActions() & 0x40L) > 0L;
        }
        return false;
    }

    @Override
    public boolean isEnableFilter() {
        if (this.isEnableViewActions()) {
            return (this.getViewActions() & 0x100L) > 0L;
        }
        return this.isEnableSearch();
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u5feb\u901f\u641c\u7d22")
    public boolean isEnableQuickSearch() {
        return this.bEnableQuickSearch;
    }

    @Override
    public boolean isEnableSearch() {
        return this.isEnableQuickSearch();
    }

    @Override
    @PSModelRTMeta(description="\u6811\u8282\u70b9\u5f15\u7528\u89c6\u56fe\u96c6\u5408", hideempty=true, child=true)
    public Iterator<IPSDETreeNodeRV> getPSDETreeNodeRVs() {
        return this.psDETreeNodeRVList.iterator();
    }

    public String getDEName() {
        if (this.getPSDataEntity() == null) {
            return null;
        }
        return this.getPSDataEntity().getName();
    }

    @Override
    @PSModelRTMeta(description="\u540d\u79f0\u8bed\u8a00\u8d44\u6e90", fields={"NAMEPSLANRESID"})
    public IPSLanguageRes getNamePSLanguageRes() {
        return this.namePSLanguageRes;
    }

    @Override
    @PSModelRTMeta(description="\u5bfc\u822a\u5173\u7cfb", child=true)
    public IPSDERBase getNavPSDER() {
        return this.navPSDERBase;
    }

    @Override
    public String getNavPSDERId() {
        return this.strNavPSDERId;
    }

    @Override
    public String getIconPath() {
        if (this.getPSSysImage() != null) {
            return this.getPSSysImage().getImagePath();
        }
        return "";
    }

    public ITreeModel getTreeModel() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u8ba1\u6570\u5668\u6807\u8bc6", fields={"COUNTERID"})
    public String getCounterId() {
        return this.strCounterId;
    }

    @Override
    @PSModelRTMeta(description="\u8ba1\u6570\u5668\u6a21\u5f0f", codelist="DETreeNodeCounterMode", fields={"COUNTERMODE"})
    public int getCounterMode() {
        return this.nCounterMode;
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u5feb\u901f\u5efa\u7acb")
    public boolean isEnableQuickCreate() {
        return StringHelper.compare((String)this.getNewDataMode(), (String)"WIZARD", (boolean)true) == 0;
    }

    @Override
    public String getNodeDataType() {
        return this.strNodeDataType;
    }

    protected void onPreparePSDETreeNodeColumns() throws Exception {
        ArrayList<PSDETreeNodeColumn> psDETreeNodeColumnList;
        if (!this.getPSDETree().isEnableTreeGrid()) {
            return;
        }
        if (this.psDETreeNodeColumnMap != null) {
            this.psDETreeNodeColumnMap.clear();
        }
        if ((psDETreeNodeColumnList = this.psDETreeNode.getPSDETreeNodeColumns(false)) == null) {
            return;
        }
        if (this.psDETreeNodeColumnMap == null) {
            this.psDETreeNodeColumnMap = new TreeMap<String, IPSDETreeNodeColumn>();
        }
        for (PSDETreeNodeColumn psDETreeNodeColumn : psDETreeNodeColumnList) {
            if (StringHelper.isNullOrEmpty((String)psDETreeNodeColumn.getPSDETREECOLID())) continue;
            if (StringHelper.isNullOrEmpty((String)psDETreeNodeColumn.getGRIDCOLTYPE())) {
                IPSDETreeColumn iPSDETreeNode = this.getPSDETree().getPSDETreeColumn(psDETreeNodeColumn.getPSDETREECOLID());
                psDETreeNodeColumn.setGRIDCOLTYPE(iPSDETreeNode.getColumnType());
            }
            IPSDEGridColumnType iPSDEGridColumnType = this.getPSModelStorage().getPSDEGridColumnType(psDETreeNodeColumn.getGRIDCOLTYPE());
            IPSDETreeNodeColumn iPSDETreeNodeColumn = iPSDEGridColumnType.createPSDETreeNodeColumn(psDETreeNodeColumn);
            iPSDETreeNodeColumn.init(this.getDAGlobalHelper(), this, psDETreeNodeColumn);
            this.psDETreeNodeColumnMap.put(iPSDETreeNodeColumn.getName(), iPSDETreeNodeColumn);
        }
    }

    protected void onPreparePSDETreeNodeDataItems() throws Exception {
        ArrayList<PSDETreeNodeColumn> psDETreeNodeColumnList;
        if (this.psDETreeNodeDataItemMap != null) {
            this.psDETreeNodeDataItemMap.clear();
        }
        if ((psDETreeNodeColumnList = this.psDETreeNode.getPSDETreeNodeColumns(false)) == null) {
            return;
        }
        if (this.psDETreeNodeDataItemMap == null) {
            this.psDETreeNodeDataItemMap = new TreeMap<String, IPSDETreeNodeDataItem>();
        }
        for (PSDETreeNodeColumn psDETreeNodeColumn : psDETreeNodeColumnList) {
            PSDETreeNodeDataItemImpl iPSDETreeNodeDataItem = new PSDETreeNodeDataItemImpl();
            iPSDETreeNodeDataItem.init(this.getDAGlobalHelper(), this, psDETreeNodeColumn);
            this.psDETreeNodeDataItemMap.put(iPSDETreeNodeDataItem.getName(), iPSDETreeNodeDataItem);
        }
    }

    protected void onPreparePSDETreeNodeEditItems() throws Exception {
        Iterator<IPSDETreeNodeColumn> psDETreeNodeColumns;
        if (!this.getPSDETree().isEnableTreeGrid()) {
            return;
        }
        if (this.psDETreeNodeEditItemMap != null) {
            this.psDETreeNodeEditItemMap.clear();
        }
        if (this.psDETreeNodeEditItemMap == null) {
            this.psDETreeNodeEditItemMap = new TreeMap<String, IPSDETreeNodeEditItem>();
        }
        boolean bUseDTO = false;
        if (this.getPSDETree().getPSAppView().getPSApplication() != null) {
            bUseDTO = this.getPSDETree().getPSAppView().getPSApplication().isUseServiceApi();
        }
        if ((psDETreeNodeColumns = this.getPSDETreeNodeColumns()) != null) {
            while (psDETreeNodeColumns.hasNext()) {
                IPSDETreeNodeColumn iPSTreeNodeColumn = psDETreeNodeColumns.next();
                IPSDETreeNodeEditItem iPSDETreeNodeEditItem = iPSTreeNodeColumn.getPSDETreeNodeEditItem();
                if (iPSDETreeNodeEditItem == null) continue;
                this.psDETreeNodeEditItemMap.put(iPSDETreeNodeEditItem.getName(), iPSDETreeNodeEditItem);
            }
        }
        ArrayList<String> valueItemList = new ArrayList<String>();
        for (IPSDETreeNodeEditItem iPSDETreeNodeEditItem : this.psDETreeNodeEditItemMap.values()) {
            String[] valueItemNames = iPSDETreeNodeEditItem.getValueItemNames();
            if (valueItemNames == null) continue;
            String[] stringArray = valueItemNames;
            int n = valueItemNames.length;
            int n2 = 0;
            while (n2 < n) {
                String strValueItemName = stringArray[n2];
                if (!StringHelper.isNullOrEmpty((String)strValueItemName) && !valueItemList.contains(strValueItemName.toLowerCase())) {
                    valueItemList.add(strValueItemName.toLowerCase());
                }
                ++n2;
            }
        }
        for (String strValueItem : valueItemList) {
            if (this.psDETreeNodeEditItemMap.containsKey(strValueItem)) continue;
            IPSDEField iPSDEField = this.getPSDataEntity().getPSDEField(strValueItem);
            HiddenPSDETreeNodeEditItemImpl hiddenPSDETreeNodeEditItemImpl = new HiddenPSDETreeNodeEditItemImpl();
            hiddenPSDETreeNodeEditItemImpl.init(this.getDAGlobalHelper(), (IPSDETreeNode)this, iPSDEField);
            this.psDETreeNodeEditItemMap.put(hiddenPSDETreeNodeEditItemImpl.getName(), hiddenPSDETreeNodeEditItemImpl);
        }
    }

    @Override
    @PSModelRTMeta(description="\u6811\u8282\u70b9\u8868\u683c\u5217\u96c6\u5408", hideempty=true, child=true, modeltype="PSDETREENODECOL")
    public Iterator<IPSDETreeNodeColumn> getPSDETreeNodeColumns() {
        if (this.psDETreeNodeColumnMap == null || this.psDETreeNodeColumnMap.size() == 0) {
            return null;
        }
        return this.psDETreeNodeColumnMap.values().iterator();
    }

    @Override
    @PSModelRTMeta(description="\u6811\u8282\u70b9\u6570\u636e\u9879\u96c6\u5408", hideempty=true, child=true)
    public Iterator<IPSDETreeNodeDataItem> getPSDETreeNodeDataItems() {
        if (this.psDETreeNodeDataItemMap == null || this.psDETreeNodeDataItemMap.size() == 0) {
            return null;
        }
        return this.psDETreeNodeDataItemMap.values().iterator();
    }

    @Override
    public IPSDETreeNodeDataItem getPSDETreeNodeDataItem(String strPSDETreeNodeDataItemName, boolean bTryMode) throws Exception {
        IPSDETreeNodeDataItem iPSDETreeNodeDataItem;
        IPSDETreeNodeDataItem iPSDETreeNodeDataItem2 = iPSDETreeNodeDataItem = this.psDETreeNodeDataItemMap != null ? this.psDETreeNodeDataItemMap.get(strPSDETreeNodeDataItemName.toLowerCase()) : null;
        if (iPSDETreeNodeDataItem != null || bTryMode) {
            return iPSDETreeNodeDataItem;
        }
        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6811\u8282\u70b9\u6570\u636e\u9879[%1$s]", (Object)strPSDETreeNodeDataItemName));
    }

    @Override
    public IPSDETreeNodeDataItem getPSDETreeNodeDataItem(IPSDEField iPSDEField, boolean bTryMode) throws Exception {
        IPSDETreeNodeDataItem iPSDETreeNodeDataItem;
        String strDataItemName = iPSDEField.getName().toLowerCase();
        IPSDETreeNodeDataItem iPSDETreeNodeDataItem2 = iPSDETreeNodeDataItem = this.psDETreeNodeDataItemMap != null ? this.psDETreeNodeDataItemMap.get(strDataItemName) : null;
        if (iPSDETreeNodeDataItem != null) {
            return iPSDETreeNodeDataItem;
        }
        if (this.psDETreeNodeDataItemMap == null) {
            this.psDETreeNodeDataItemMap = new LinkedHashMap<String, IPSDETreeNodeDataItem>();
        }
        PSDETreeNodeColumn psDETreeNodeColumn = new PSDETreeNodeColumn();
        psDETreeNodeColumn.setPSDETREENODEID(this.getId());
        psDETreeNodeColumn.setPSDETREENODENAME(this.getName());
        psDETreeNodeColumn.setPSDETREENODECOLID(KeyValueHelper.genUniqueId((String)this.getId(), (String)strDataItemName));
        psDETreeNodeColumn.setPSDETREENODECOLNAME(strDataItemName);
        psDETreeNodeColumn.setPSDEFID(iPSDEField.getId());
        psDETreeNodeColumn.setPSDEFNAME(iPSDEField.getName());
        iPSDETreeNodeDataItem = new PSDETreeNodeDataItemImpl();
        iPSDETreeNodeDataItem.init(this.getDAGlobalHelper(), this, psDETreeNodeColumn);
        this.psDETreeNodeDataItemMap.put(iPSDETreeNodeDataItem.getName(), iPSDETreeNodeDataItem);
        return iPSDETreeNodeDataItem;
    }

    public ITreeNodeDataItem getTreeNodeDataItem(String strName) throws Exception {
        return null;
    }

    public Iterator<ITreeNodeDataItem> getTreeNodeDataItems() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u6811\u8282\u70b9\u7f16\u8f91\u9879\u96c6\u5408", hideempty=true, child=true, modeltype="PSDETREENODEEDITITEM")
    public Iterator<IPSDETreeNodeEditItem> getPSDETreeNodeEditItems() {
        if (this.psDETreeNodeEditItemMap == null || this.psDETreeNodeEditItemMap.size() == 0) {
            return null;
        }
        return this.psDETreeNodeEditItemMap.values().iterator();
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6a21\u578b\u5bf9\u8c61", fields={"MODELOBJ"})
    public String getModelObj() {
        return this.psDETreeNode.getMODELOBJ();
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSDETree().getPSAppView().getPSSystem());
    }

    @Override
    public String getModelType() {
        return "PSDETREENODE";
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSDETree().getModelId(), (Object)super.getModelId());
    }

    @Override
    public String getActionAfterNewDataWizard() {
        return "DEFAULT";
    }

    @Override
    @PSModelRTMeta(description="\u5b50\u8282\u70b9\u5173\u7cfb\u96c6\u5408")
    public Iterator<IPSDETreeNodeRS> getPSDETreeNodeRSs() {
        if (this.iPSDETreeNodeRSList == null) {
            ArrayList<IPSDETreeNodeRS> iPSDETreeNodeRSList = new ArrayList<IPSDETreeNodeRS>();
            Iterator<IPSDETreeNodeRS> psDETreeNodeRSs = this.getPSDETree().getPSDETreeNodeRSs();
            if (psDETreeNodeRSs != null) {
                while (psDETreeNodeRSs.hasNext()) {
                    IPSDETreeNodeRS iPSDETreeNodeRS = psDETreeNodeRSs.next();
                    if (StringHelper.compare((String)iPSDETreeNodeRS.getParentTreeNodeId(), (String)this.getId(), (boolean)false) != 0) continue;
                    iPSDETreeNodeRSList.add(iPSDETreeNodeRS);
                }
            }
            this.iPSDETreeNodeRSList = iPSDETreeNodeRSList;
        }
        if (this.iPSDETreeNodeRSList.size() == 0) {
            return null;
        }
        return this.iPSDETreeNodeRSList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u662f\u5426\u6709\u5b50\u8282\u70b9", doc="\u8ba1\u7b97\u662f\u5426\u5b58\u5728\u7236\u8282\u70b9\u5173\u7cfb")
    public boolean hasPSDETreeNodeRSs() {
        return this.getPSDETreeNodeRSs() != null;
    }

    public IPSAppViewRef registerPSAppViewRef(PSAppViewRef psAppViewRef) throws Exception {
        if (this.psAppViewRefMap == null) {
            this.psAppViewRefMap = new LinkedHashMap<String, IPSAppViewRef>();
        }
        PSAppViewRefImpl iPSAppViewRef = new PSAppViewRefImpl();
        iPSAppViewRef.init(this.getDAGlobalHelper(), this, psAppViewRef);
        this.psAppViewRefMap.put(psAppViewRef.getPSAPPVIEWREFNAME().toUpperCase(), iPSAppViewRef);
        return iPSAppViewRef;
    }

    @Override
    public IPSAppViewRef getPSAppViewRef(String strRefMode, boolean bTry) throws Exception {
        IPSAppViewRef iPSAppViewRef = null;
        if (this.psAppViewRefMap != null) {
            iPSAppViewRef = this.psAppViewRefMap.get(strRefMode.toUpperCase());
        }
        if (iPSAppViewRef == null) {
            if (bTry) {
                return null;
            }
            throw new Exception(StringHelper.format((String)"\u6811\u8282\u70b9[%1$s]\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5f15\u7528\u89c6\u56fe[%2$s]", (Object)this.getName(), (Object)strRefMode));
        }
        return iPSAppViewRef;
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u5bf9\u8c61\u5f15\u7528")
    public Iterator<IPSAppViewRef> getPSAppViewRefs() {
        if (this.psAppViewRefMap == null) {
            return null;
        }
        return this.psAppViewRefMap.values().iterator();
    }

    @Override
    public Iterator<IPSAppViewRef> getPSAppViewRefs(String strRefMode) throws Exception {
        if (this.psAppViewRefMap == null) {
            return null;
        }
        strRefMode = strRefMode.toUpperCase();
        ArrayList<IPSAppViewRef> psAppViewRefList = new ArrayList<IPSAppViewRef>();
        for (String strKey : this.psAppViewRefMap.keySet()) {
            IPSAppViewRef iPSAppViewRef;
            if (strKey.indexOf(strRefMode) != 0 || (iPSAppViewRef = this.psAppViewRefMap.get(strKey)) == null || iPSAppViewRef.getRefPSAppView() == null) continue;
            psAppViewRefList.add(iPSAppViewRef);
        }
        if (psAppViewRefList.size() == 0) {
            return null;
        }
        return psAppViewRefList.iterator();
    }

    @Override
    public IPSControl getOwnedPSControl() {
        return this.getPSDETree();
    }

    protected boolean isPrepareDefaultPSAppViewLogics() {
        return this.getPSDETree().isPrepareDefaultPSAppViewLogics();
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7aef\u7ed8\u5236\u63d2\u4ef6")
    public IPSSysPFPlugin getPSSysPFPlugin() {
        return this.iPSSysPFPlugin;
    }

    @Override
    @PSModelRTMeta(description="\u5bfc\u822a\u89c6\u56fe\u8fc7\u6ee4\u9879", fields={"NAVVIEWFILTER"})
    public String getNavFilter() {
        return this.strNavFilter;
    }

    @Override
    @PSModelRTMeta(description="\u7981\u6b62\u9009\u62e9", fields={"DISABLESELECT"})
    public boolean isDisableSelect() {
        return this.psDETreeNode.getDISABLESELECT();
    }

    @Override
    @PSModelRTMeta(description="\u8282\u70b9\u9ed8\u8ba4\u884c\u4e3a")
    public IPSAppViewUIAction getDefaultPSUIAction() {
        return this.defaultPSUIAction;
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u9009\u62e9", fields={"SELECTED"})
    public boolean isSelected() {
        return this.bSelected;
    }

    @Override
    @PSModelRTMeta(description="\u4ec5\u9009\u62e9\u9996\u8282\u70b9", fields={"SELECTED"})
    public boolean isSelectFirstOnly() {
        return this.bSelectFirstOnly;
    }

    @Override
    @PSModelRTMeta(description="\u4ec5\u5c55\u5f00\u9996\u8282\u70b9", fields={"SELECTED"})
    public boolean isExpandFirstOnly() {
        return this.bExpandFirstOnly;
    }

    @Override
    @PSModelRTMeta(description="\u5bfc\u822a\u53c2\u6570\u96c6\u5408", child=true, group="\u903b\u8f91", order=216)
    public Iterator<? extends IPSNavigateParam> getPSNavigateParams() throws Exception {
        if (this.psNavigateParamMap == null || this.psNavigateParamMap.size() == 0) {
            return null;
        }
        return this.psNavigateParamMap.values().iterator();
    }

    @Override
    @PSModelRTMeta(description="\u5bfc\u822a\u4e0a\u4e0b\u6587\u96c6\u5408", child=true, group="\u903b\u8f91", order=215)
    public Iterator<? extends IPSNavigateContext> getPSNavigateContexts() throws Exception {
        if (this.psNavigateContextMap == null || this.psNavigateContextMap.size() == 0) {
            return null;
        }
        return this.psNavigateContextMap.values().iterator();
    }

    @Override
    public String getNavDataType() {
        return this.getNodeType();
    }

    @Override
    @PSModelRTMeta(description="\u5bfc\u822a\u89c6\u56fe\u53c2\u6570", hideempty=true, fields={"NAVVIEWPARAM"})
    public JSONObject getNavViewParamJO() {
        return this.getNavViewParam();
    }

    @Override
    public String getNavEmbeddedViewId() {
        return this.getEmbedViewId();
    }

    @Override
    public String getLogicName() {
        return this.getName();
    }

    @Override
    public String getFullModelName() {
        if (this.getOwnedPSControl() != null) {
            return StringHelper.format((String)"%1$s|%2$s", (Object)this.getOwnedPSControl().getFullModelName(), (Object)this.getModelName());
        }
        return super.getFullModelName();
    }

    @Override
    public String getModelRefId() {
        return this.getNodeType();
    }

    @Override
    public Iterator<IPSDEDQCondition> getADPSDEDQConditions() throws Exception {
        return null;
    }

    @Override
    public int getEditMode() {
        return this.nEditMode;
    }

    @Override
    @PSModelRTMeta(description="\u5141\u8bb8\u7f16\u8f91\u8282\u70b9\u6587\u672c", ignoredumpvalues="false", fields={"EDITMODE"})
    public boolean isAllowEditText() {
        return (this.getEditMode() & 1) == 1;
    }

    @Override
    @PSModelRTMeta(description="\u5141\u8bb8\u62d6\u5230\u8282\u70b9", ignoredumpvalues="false", fields={"EDITMODE"})
    public boolean isAllowDrag() {
        return (this.getEditMode() & 2) == 2;
    }

    @Override
    @PSModelRTMeta(description="\u5141\u8bb8\u62d6\u5165\u8282\u70b9", ignoredumpvalues="false", fields={"EDITMODE"})
    public boolean isAllowDrop() {
        return (this.getEditMode() & 4) == 4;
    }

    @Override
    @PSModelRTMeta(description="\u5141\u8bb8\u8282\u70b9\u6392\u5e8f", ignoredumpvalues="false", fields={"EDITMODE"})
    public boolean isAllowOrder() {
        return (this.getEditMode() & 8) == 8;
    }

    @Override
    public boolean isDesignMode() {
        return false;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u884c\u7f16\u8f91", ignoredumpvalues="false")
    public boolean isEnableRowEdit() {
        return (this.getEditMode() & 0x10) == 16;
    }

    @Override
    @PSModelRTMeta(description="\u884c\u7f16\u8f91\u4ec5\u63d0\u4ea4\u53d8\u5316\u503c", ignoredumpvalues="false")
    public boolean isEnableRowEditChangedOnly() {
        return (this.getEditMode() & 0x800) == 2048;
    }

    @Override
    @PSModelRTMeta(description="\u6811\u8282\u70b9\u7f16\u8f91\u9879\u66f4\u65b0\u96c6\u5408", hideempty=true, child=true)
    public Iterator<IPSDETreeNodeEditItemUpdate> getPSDETreeNodeEditItemUpdates() {
        return null;
    }

    @Override
    public IPSDETreeNodeEditItemUpdate getPSDETreeNodeEditItemUpdate(String strPSDETreeNodeEditItemUpdateId) throws Exception {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u6837\u5f0f\u8868", fields={"DYNACLASS"})
    public String getDynaClass() {
        return this.psDETreeNode.getDYNACLASS();
    }

    @Override
    @PSModelRTMeta(description="\u8bbf\u95ee\u7528\u6237\u6a21\u5f0f", ignoredumpvalues="0", codelist="ViewAccessUsers")
    public int getAccUserMode() {
        if (this.iPSSysUniRes != null) {
            return AccessUserModes.LOGINUSERWITHKEY;
        }
        return AccessUserModes.UNKNOWN;
    }

    @Override
    @PSModelRTMeta(description="\u8bbf\u95ee\u6807\u8bc6")
    public String getAccessKey() {
        if (this.iPSSysUniRes != null) {
            return this.iPSSysUniRes.getResCode();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u56fe\u5f62\u754c\u9762\u6837\u5f0f\u8868", fields={"SHAPEPSSYSCSSID"})
    public IPSSysCss getShapePSSysCss() {
        return this.shapePSSysCss;
    }

    @Override
    @PSModelRTMeta(description="\u56fe\u5f62\u52a8\u6001\u6837\u5f0f\u8868", fields={"SHAPEDYNACLASS"})
    public String getShapeDynaClass() {
        return this.psDETreeNode.getSHAPEDYNACLASS();
    }
}

