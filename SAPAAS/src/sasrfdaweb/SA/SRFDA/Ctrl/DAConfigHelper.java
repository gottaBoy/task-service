/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDAConfigHelper
 *  SA.SRFDA.Ctrl.ConfigPathHelper
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFFormCtrl
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.DEFHelper.ILinkDEFHelper
 *  SA.SRFDA.Ctrl.DEFHelper.IPickupDEFHelper
 *  SA.SRFDA.Ctrl.DEFHelper.LinkDEFHelper
 *  SA.SRFDA.Ctrl.Data.ConfigPublisher
 *  SA.SRFDA.Ctrl.Data.DEBehavior
 *  SA.SRFDA.Ctrl.Data.DEFGroupDetail
 *  SA.SRFDA.Ctrl.Data.DER11
 *  SA.SRFDA.Ctrl.Data.DER1N
 *  SA.SRFDA.Ctrl.Data.DERGroupDetail
 *  SA.SRFDA.Ctrl.Data.DERGroupFolder
 *  SA.SRFDA.Ctrl.Data.DERINDEX
 *  SA.SRFDA.Ctrl.Data.DERType
 *  SA.SRFDA.Ctrl.Data.DEWizard
 *  SA.SRFDA.Ctrl.Data.DGMode
 *  SA.SRFDA.Ctrl.Data.DGModeDetail
 *  SA.SRFDA.Ctrl.Data.DataGrid
 *  SA.SRFDA.Ctrl.Data.DataGridEx
 *  SA.SRFDA.Ctrl.Data.DevStyle
 *  SA.SRFDA.Ctrl.Data.Form
 *  SA.SRFDA.Ctrl.Data.FormPart
 *  SA.SRFDA.Ctrl.Data.Func
 *  SA.SRFDA.Ctrl.Data.MainMenu
 *  SA.SRFDA.Ctrl.Data.PP.PPDataGrid
 *  SA.SRFDA.Ctrl.Data.PP.PPEVTabView
 *  SA.SRFDA.Ctrl.Data.PP.PPGridView
 *  SA.SRFDA.Ctrl.Data.Page
 *  SA.SRFDA.Ctrl.Data.RawFIStyle
 *  SA.SRFDA.Ctrl.Data.SearchForm
 *  SA.SRFDA.Ctrl.Data.SummaryPage
 *  SA.SRFDA.Ctrl.Data.TBTempl
 *  SA.SRFDA.Ctrl.Data.Toolbar
 *  SA.SRFDA.Ctrl.IDAConfigHelper
 *  SA.SRFDA.Ctrl.IDAConfigHelperContext
 *  SA.SRFDA.Ctrl.IDAConfigHelperPlugin
 *  SA.SRFDA.Ctrl.IDAConfigPublishContext
 *  SA.SRFDA.Ctrl.IDAConfigPublisher
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Ctrl.IDERGroupDetailHelper
 *  SA.SRFDA.Ctrl.IDERGroupHelper
 *  SA.SRFDA.Ctrl.IPageHelper
 *  SA.SRFDA.Ctrl.ToolbarWriter.IToolbarItemWriter
 *  SA.SRFDA.Ctrl.ToolbarWriter.IToolbarItemWriterContext
 *  SA.SRFDA.Ctrl.ToolbarWriter.TBItemConfig
 *  SA.SRFDA.Ctrl.ToolbarWriter.ToolbarConfig
 *  SA.SRFDA.Ctrl.ToolbarWriter.ToolbarItemWriterConfig
 *  SA.SRFDA.Localization.SRFDALocalizationHelper
 *  SA.SRFDA.Model.DGColRenderConfig
 *  SA.SRFDA.Model.DGModelColumnConfig
 *  SA.SRFDA.Model.DataGridModelConfig
 *  SA.SRFDA.Model.SearchItemConfig
 *  SA.SRFDA.Model.SearchModelConfig
 *  SA.SRFDA.Model.ValueRuleConfig
 *  SA.SRFDA.Security.UniResHelper
 *  SA.SRFDA.Web.Form.DefaultFormItemLogicHelper
 *  SA.SRFDA.Web.Form.Model.FormItemLogicConfig
 *  SA.SRFDA.Web.Form.Model.FormItemRuleConfig
 *  SA.SRFDA.Web.IDACustomMenuBuilder
 *  SA.SRFDA.Web.ISRFDAPage
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.SRFDAWebContext
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.CodeList.CodeListConfig
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 *  SA.SRFramework.WebEx.DGEx.UI.DGExConfig
 *  SA.SRFramework.WebEx.DP.UI.DPConfig
 *  SA.SRFramework.WebEx.SP.UI.SPExConfig
 *  SA.SRFramework.WebEx.SRFExWebContext
 *  SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig
 *  SA.SRFramework.WebEx.ToolBar.UI.ToolbarItemsConfig
 *  SA.SRFramework.WebEx.ToolBar.UI.ToolbarSeperatorConfig
 *  SA.SRFramework.WebEx.ToolBar.UI.ToolbarSplitButtonConfig
 *  SA.SRFramework.WebEx.Utility.URLHelper
 *  SA.SRFramework.XML.SimpleXMLWriter
 *  SA.SRFramework.XML.XMLNode
 *  SRFWF.Client.WFGetIAActionsResult
 *  SRFWF.Model.WFInteractiveActionConfig
 *  SRFWF.Model.WFUserActionConfig
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.apache.xerces.parsers.DOMParser
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.BaseDAConfigHelper;
import SA.SRFDA.Ctrl.ConfigPathHelper;
import SA.SRFDA.Ctrl.DEFHelper.IDEFFormCtrl;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.DEFHelper.ILinkDEFHelper;
import SA.SRFDA.Ctrl.DEFHelper.IPickupDEFHelper;
import SA.SRFDA.Ctrl.DEFHelper.LinkDEFHelper;
import SA.SRFDA.Ctrl.Data.ConfigPublisher;
import SA.SRFDA.Ctrl.Data.DEBehavior;
import SA.SRFDA.Ctrl.Data.DEFGroupDetail;
import SA.SRFDA.Ctrl.Data.DER11;
import SA.SRFDA.Ctrl.Data.DER1N;
import SA.SRFDA.Ctrl.Data.DERGroupDetail;
import SA.SRFDA.Ctrl.Data.DERGroupFolder;
import SA.SRFDA.Ctrl.Data.DERINDEX;
import SA.SRFDA.Ctrl.Data.DERType;
import SA.SRFDA.Ctrl.Data.DEWizard;
import SA.SRFDA.Ctrl.Data.DGMode;
import SA.SRFDA.Ctrl.Data.DGModeDetail;
import SA.SRFDA.Ctrl.Data.DataGrid;
import SA.SRFDA.Ctrl.Data.DataGridEx;
import SA.SRFDA.Ctrl.Data.DevStyle;
import SA.SRFDA.Ctrl.Data.Form;
import SA.SRFDA.Ctrl.Data.FormPart;
import SA.SRFDA.Ctrl.Data.Func;
import SA.SRFDA.Ctrl.Data.MainMenu;
import SA.SRFDA.Ctrl.Data.PP.PPDataGrid;
import SA.SRFDA.Ctrl.Data.PP.PPEVTabView;
import SA.SRFDA.Ctrl.Data.PP.PPGridView;
import SA.SRFDA.Ctrl.Data.Page;
import SA.SRFDA.Ctrl.Data.RawFIStyle;
import SA.SRFDA.Ctrl.Data.SearchForm;
import SA.SRFDA.Ctrl.Data.SummaryPage;
import SA.SRFDA.Ctrl.Data.TBTempl;
import SA.SRFDA.Ctrl.Data.Toolbar;
import SA.SRFDA.Ctrl.DataGrid.RowBodyDataGridRowClassHelper;
import SA.SRFDA.Ctrl.IDAConfigHelper;
import SA.SRFDA.Ctrl.IDAConfigHelperContext;
import SA.SRFDA.Ctrl.IDAConfigHelperPlugin;
import SA.SRFDA.Ctrl.IDAConfigPublishContext;
import SA.SRFDA.Ctrl.IDAConfigPublisher;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Ctrl.IDERGroupDetailHelper;
import SA.SRFDA.Ctrl.IDERGroupHelper;
import SA.SRFDA.Ctrl.IPageHelper;
import SA.SRFDA.Ctrl.ToolbarWriter.DEBehaviorWriter;
import SA.SRFDA.Ctrl.ToolbarWriter.DefaultToolbarWriterContext;
import SA.SRFDA.Ctrl.ToolbarWriter.IToolbarItemWriter;
import SA.SRFDA.Ctrl.ToolbarWriter.IToolbarItemWriterContext;
import SA.SRFDA.Ctrl.ToolbarWriter.SeparatorTBItemWriter;
import SA.SRFDA.Ctrl.ToolbarWriter.SplitTBItemWriter;
import SA.SRFDA.Ctrl.ToolbarWriter.TBItemConfig;
import SA.SRFDA.Ctrl.ToolbarWriter.ToolbarConfig;
import SA.SRFDA.Ctrl.ToolbarWriter.ToolbarItemWriterConfig;
import SA.SRFDA.Localization.SRFDALocalizationHelper;
import SA.SRFDA.Model.DGColRenderConfig;
import SA.SRFDA.Model.DGModelColumnConfig;
import SA.SRFDA.Model.DataGridModelConfig;
import SA.SRFDA.Model.SearchItemConfig;
import SA.SRFDA.Model.SearchModelConfig;
import SA.SRFDA.Model.ValueRuleConfig;
import SA.SRFDA.Security.UniResHelper;
import SA.SRFDA.Web.Default.DefaultPageHelper;
import SA.SRFDA.Web.Form.DefaultFormItemLogicHelper;
import SA.SRFDA.Web.Form.Model.FormItemLogicConfig;
import SA.SRFDA.Web.Form.Model.FormItemRuleConfig;
import SA.SRFDA.Web.IDACustomMenuBuilder;
import SA.SRFDA.Web.ISRFDAPage;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.SRFDAWebContext;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.CodeList.CodeListConfig;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import SA.SRFramework.WebEx.DGEx.UI.DGExConfig;
import SA.SRFramework.WebEx.DP.UI.DPConfig;
import SA.SRFramework.WebEx.SP.UI.SPExConfig;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarItemsConfig;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarSeperatorConfig;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarSplitButtonConfig;
import SA.SRFramework.WebEx.Utility.URLHelper;
import SA.SRFramework.XML.SimpleXMLWriter;
import SA.SRFramework.XML.XMLNode;
import SRFWF.Client.WFGetIAActionsResult;
import SRFWF.Model.WFInteractiveActionConfig;
import SRFWF.Model.WFUserActionConfig;
import java.io.File;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Properties;
import java.util.TreeMap;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

public class DAConfigHelper
extends BaseDAConfigHelper
implements IDAConfigHelper,
IDAConfigHelperContext {
    private static final Log log = LogFactory.getLog(DAConfigHelper.class);
    public static final String CONFIGTYPE_TABVIEW = "TABVIEW";
    public static final String CONFIGTYPE_DATAFILTER = "DATAFILTER";
    public static final String CONFIGTYPE_TOOLBAR = "TOOLBAR";
    public static final String TAG_NEWACTION = "NEWACTION";
    public static final String TAG_SAVEACTION = "SAVEACTION";
    public static final String TAG_CLOSEACTION = "CLOSEACTION";
    public static final String TAG_SAVEANDEXITACTION = "SAVEANDEXITACTION";
    public static final String TAG_REMOVEANDEXITACTION = "REMOVEANDEXITACTION";
    public static final String TAG_SAVEANDSTARTWFACTION = "SAVEANDSTARTWFACTION";
    public static final String TAG_VIEWWFSTEPACTOR = "VIEWWFSTEPACTOR";
    public static final String TAG_VIEWWFSTEPDATA = "VIEWWFSTEPDATA";
    public static final String TAG_COPYACTION = "COPYACTION";
    public static final String TAG_OTHERACTION = "OTHERACTION";
    public static final String TAG_PRINTACTION = "PRINTACTION";
    public static final String TAG_MULTIPRINT = "MULTIPRINT";
    public static final String TAG_CANCELACTION = "CANCELACTION";
    public static final String TAG_SYSDEFACTION = "SYSDEFACTION";
    public static final String TAG_RESTARTACTION = "RESTARTACTION";
    public static final String TAG_IAGOTOACTION = "IAGOTOACTION";
    public static final String TAG_SAVEANDNEWACTION = "SAVEANDNEWACTION";
    public static final String TAG_SRFREPLACEDEFAULT = "SRFREPLACEDEFAULT";
    public static final String TAG_NEWROWACTION = "NEWROWACTION";
    public static final String TAG_EDITROWACTION = "EDITROWACTION";
    public static final String TAG_EDITACTION = "EDITACTION";
    public static final String TAG_VIEWACTION = "VIEWACTION";
    public static final String TAG_REMOVEACTION = "REMOVEACTION";
    public static final String TAG_EXPORTACTION = "EXPORTACTION";
    public static final String TAG_SEARCHBARACTION = "SEARCHBARACTION";
    public static final String TAG_EXPORTXMLACTION = "EXPORTXMLACTION";
    public static final String TAG_IMPORTEXCELACTION = "IMPORTEXCELACTION";
    public static final String TAG_HELPACTION = "HELPACTION";
    public static final String TAG_POS = "POS";
    public static final String TAG_OBJECTNAME = "OBJECTNAME";
    public static final String TAG_SRFDAMAJORTEXT = "SRFDAMAJORTEXT";
    public static final String TAG_DATANAVBAR = "DATANAVBAR";
    public static final String TAG_INFOMODE = "INFOMODE";
    public static final String TAG_TBB_FILTER = "TBB_FILTER";
    public static final String WFACTION_RESUBMIT = "SRFWFRESUBMIT";
    public static final String WFACTION_REASSIGN = "SRFWFREASSIGN";
    public static final int TOOLBARPOS_FIRST = 1;
    public static final int TOOLBARPOS_AFTERSYSTEM = 2;
    public static final int TOOLBARPOS_AFTERUSER = 3;
    public static final int TOOLBARPOS_AFTEROTHER = 4;
    public static final int TOOLBARPOS_LAST = 5;
    public static final String TBCOND_ROWACTIONBAR = "ROWACTIONBAR";
    protected SeparatorTBItemWriter separatorTBItemWriter = new SeparatorTBItemWriter();
    protected SplitTBItemWriter splitTBItemWriter = new SplitTBItemWriter();
    protected DEBehaviorWriter deBehaviorTBItemWriter = new DEBehaviorWriter();
    protected Hashtable<String, IDAConfigPublisher> daConfigPublisherMap = new Hashtable();
    protected Hashtable<String, String> daConfigPublisherObjectMap = new Hashtable();
    private ThreadLocal<ISRFDAPage> curPage = new ThreadLocal();
    public static final int RELATEDINFOPLACEMENT_DEFAULT = 0;
    public static final int RELATEDINFOPLACEMENT_TOOLBAR = 1;
    public static final int RELATEDINFOPLACEMENT_OTHER = 2;
    protected int nWFStepActorPlacement = 0;
    protected int nWFStepDataPlacement = 0;

    public void setCurPage(ISRFDAPage iPage) {
        this.curPage.set(iPage);
    }

    public ISRFDAPage getCurPage() {
        return this.curPage.get();
    }

    public boolean Init(ISRFDAGlobalHelper globalHelperEx, String strLanguage, String strPageModel) {
        if (!super.Init(globalHelperEx, strLanguage, strPageModel)) {
            return false;
        }
        this.separatorTBItemWriter.Init(new ToolbarItemWriterConfig(), this.globalHelperEx);
        this.splitTBItemWriter.Init(new ToolbarItemWriterConfig(), this.globalHelperEx);
        this.deBehaviorTBItemWriter.Init(new ToolbarItemWriterConfig(), this.globalHelperEx);
        this.nWFStepActorPlacement = this.OnGetWFStepActorPlacement();
        this.nWFStepDataPlacement = this.OnGetWFStepDataPlacement();
        try {
            this.PrepareDAConfigPublishers();
        }
        catch (Exception e) {
            log.error((Object)StringHelper.Format((String)" \u51c6\u5907\u914d\u7f6e\u53d1\u5e03\u5668\u5bf9\u8c61\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)e.getMessage()), (Throwable)e);
            return false;
        }
        return true;
    }

    public String GetGridViewToolbarConfigId(IDEHelper iDEHelper, Page page, DataGrid dataGrid, boolean bMini) {
        return this.GetGridViewToolbarConfigId(iDEHelper, page, dataGrid, false, bMini, false, false, false, null);
    }

    public String GetDPDataGridToolbarConfigId(IDEHelper majorDEHelper, IDEHelper iDEHelper, TreeMap<String, String> abilityMap) {
        XMLNode tbItemNode;
        String strToolbarConfigId = "";
        strToolbarConfigId = StringHelper.Format((String)"DE%1$s.TB_DPDG_%2$s_%3$s", (Object)iDEHelper.getId(), (Object)iDEHelper.getVersion(), (Object)majorDEHelper.getId());
        for (String strKey : abilityMap.keySet()) {
            strToolbarConfigId = String.valueOf(strToolbarConfigId) + "__";
            strToolbarConfigId = String.valueOf(strToolbarConfigId) + strKey;
        }
        if (!StringHelper.IsNullOrEmpty((String)this.strLanguage)) {
            strToolbarConfigId = String.valueOf(strToolbarConfigId) + StringHelper.Format((String)"_%1$s", (Object)this.strLanguage);
        }
        strToolbarConfigId = strToolbarConfigId.toUpperCase();
        String strTBFilePath = ConfigPathHelper.GetRuntimeToolbarConfigPath((String)this.globalHelperEx.GetAppRootPath(), (String)strToolbarConfigId);
        File file = new File(strTBFilePath);
        if (file.exists()) {
            return strToolbarConfigId;
        }
        XMLNode rootNode = new XMLNode();
        rootNode.setNodeName("SRFEXTOOLBAR");
        XMLNode tbItemsNode = new XMLNode();
        tbItemsNode.setNodeName(ToolbarItemsConfig.TAG_TOOLBARITEMS);
        rootNode.AddNode(tbItemsNode);
        boolean bNewButton = abilityMap.containsKey("INSERT");
        boolean bEditButton = abilityMap.containsKey("UPDATE");
        boolean bViewButton = !bEditButton;
        boolean bRemoveButton = abilityMap.containsKey("DELETE");
        boolean bEnableRowEdit = abilityMap.containsKey("ROWEDIT");
        DefaultToolbarWriterContext tbWriterContext = this.CreateTBWriterContext();
        tbWriterContext.setDEHelper(iDEHelper);
        tbWriterContext.setViewStyle("GRIDVIEW");
        tbWriterContext.RegisterGlobal(TBCOND_ROWACTIONBAR, bEnableRowEdit);
        String strObjectName = iDEHelper.getLogicName(this.strLanguage);
        if (bNewButton) {
            tbItemNode = new XMLNode();
            tbItemNode.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
            tbItemsNode.AddNode(tbItemNode);
            if (StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
                tbItemNode.SetValue("ICONCSSCLASS", "sx-tb-new");
            } else if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) == 0) {
                tbItemNode.SetValue("IMAGE", "../sasrfex/images/default/icon_new.png");
            }
            String strNewFormat = this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"GRIDVIEW", (String)"NEW"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"NEW"), "\u65b0\u5efa%1$s");
            String strNewTipFormat = this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"GRIDVIEW", (String)"NEW"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"NEW"), "\u65b0\u5efa%1$s");
            tbItemNode.SetValue(ToolbarButtonConfig.TAG_TEXT, StringHelper.Format((String)strNewFormat, (Object)""));
            tbItemNode.SetValue("TIPS", StringHelper.Format((String)strNewTipFormat, (Object)strObjectName));
            tbItemNode.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.GridNewHandler"));
            tbItemNode.SetValue("RESOURCEID", UniResHelper.GetDEDataResId((String)iDEHelper.getId(), (String)"CREATE"));
            if (!StringHelper.IsNullOrEmpty((String)this.getPageModel())) {
                this.RebuildGridViewNewAction(tbItemsNode, tbItemNode, iDEHelper);
            }
        }
        if (bEditButton) {
            tbItemNode = new XMLNode();
            tbItemNode.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
            tbItemsNode.AddNode(tbItemNode);
            if (StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
                tbItemNode.SetValue("ICONCSSCLASS", "sx-tb-edit");
            }
            if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) == 0) {
                tbItemNode.SetValue("IMAGE", "../sasrfex/images/default/icon_edit.png");
            }
            String strEditFormat = this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"GRIDVIEW", (String)"EDIT"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"EDIT"), "\u7f16\u8f91");
            String strEditTipFormat = this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"GRIDVIEW", (String)"EDIT"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"EDIT"), "\u7f16\u8f91%1$s");
            tbItemNode.SetValue(ToolbarButtonConfig.TAG_TEXT, strEditFormat);
            tbItemNode.SetValue("TIPS", StringHelper.Format((String)strEditTipFormat, (Object)strObjectName));
            tbItemNode.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.GridEditHandler"));
            if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) == 0) {
                tbItemNode.SetValue("HANDLERTYPE", "GRIDVIEW_EDITACTION");
            }
        } else if (bViewButton) {
            tbItemNode = new XMLNode();
            tbItemNode.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
            tbItemsNode.AddNode(tbItemNode);
            if (StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
                tbItemNode.SetValue("ICONCSSCLASS", "sx-tb-edit");
            }
            if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) == 0) {
                tbItemNode.SetValue("IMAGE", "../sasrfex/images/default/icon_edit.png");
            }
            String strViewFormat = this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"GRIDVIEW", (String)"VIEW"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"VIEW"), "\u67e5\u770b");
            String strViewTipFormat = this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"GRIDVIEW", (String)"VIEW"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"VIEW"), "\u67e5\u770b%1$s");
            tbItemNode.SetValue(ToolbarButtonConfig.TAG_TEXT, strViewFormat);
            tbItemNode.SetValue("TIPS", StringHelper.Format((String)strViewTipFormat, (Object)strObjectName));
            tbItemNode.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.GridEditHandler"));
            if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) == 0) {
                tbItemNode.SetValue("HANDLERTYPE", "GRIDVIEW_EDITACTION");
            }
        }
        if (bNewButton || bEditButton || bViewButton) {
            DAConfigHelper.AddToolbarSeperator(tbItemsNode);
        }
        if (bEnableRowEdit) {
            tbItemNode = new XMLNode();
            tbItemNode.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
            tbItemsNode.AddNode(tbItemNode);
            if (StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
                tbItemNode.SetValue("ICONCSSCLASS", "sx-tb-editrow");
            }
            if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) == 0) {
                tbItemNode.SetValue("IMAGE", "../sasrfex/images/default/icon_rowedit.png");
            }
            tbItemNode.SetValue(ToolbarButtonConfig.TAG_TEXT, this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"GRIDVIEW", (String)"EDITROW"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"EDITROW"), "\u884c\u7f16\u8f91"));
            tbItemNode.SetValue("TIPS", this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"GRIDVIEW", (String)"EDITROW"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"EDITROW"), "\u542f\u7528\u884c\u7f16\u8f91\u80fd\u529b"));
            tbItemNode.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.GridRowEditableHandler"));
            tbItemNode.SetValue("ENABLETOGGLE", "TRUE");
            tbItemNode.SetValue("RESOURCEID", UniResHelper.GetDEDataResId((String)iDEHelper.getId(), (String)"UPDATE"));
            tbItemNode = new XMLNode();
            tbItemNode.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
            tbItemsNode.AddNode(tbItemNode);
            if (StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
                tbItemNode.SetValue("ICONCSSCLASS", "sx-tb-addrow");
            }
            if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) == 0) {
                tbItemNode.SetValue("IMAGE", "../sasrfex/images/default/icon_addrow.png");
            }
            tbItemNode.SetValue("TIPS", this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"GRIDVIEW", (String)"NEWROW"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"NEWROW"), "\u65b0\u52a0\u884c"));
            tbItemNode.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.GridNewRowHandler"));
            tbItemNode.SetValue("RESOURCEID", UniResHelper.GetDEDataResId((String)iDEHelper.getId(), (String)"CREATE"));
            if (StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
                tbItemNode = new XMLNode();
                tbItemNode.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
                tbItemsNode.AddNode(tbItemNode);
                if (StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
                    tbItemNode.SetValue("ICONCSSCLASS", "sx-tb-saverow");
                }
                if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) == 0) {
                    tbItemNode.SetValue("IMAGE", "../sasrfex/images/default/icon_rowsave.png");
                }
                tbItemNode.SetValue("TIPS", this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"GRIDVIEW", (String)"SAVEROW"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"SAVEROW"), "\u4fdd\u5b58\u884c"));
                if (StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
                    tbItemNode.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.GridSaveRowHandler"));
                }
                if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) == 0) {
                    tbItemNode.SetValue("HANDLERTYPE", "GRIDVIEW_SAVEROW");
                }
                tbItemNode.SetValue("RESOURCEID", UniResHelper.GetDEDataResId((String)iDEHelper.getId(), (String)"UPDATE"));
            }
            DAConfigHelper.AddToolbarSeperator(tbItemsNode);
        }
        if (bRemoveButton) {
            tbItemNode = new XMLNode();
            tbItemNode.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
            tbItemsNode.AddNode(tbItemNode);
            if (StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
                tbItemNode.SetValue("ICONCSSCLASS", "sx-tb-delete");
            }
            if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) == 0) {
                tbItemNode.SetValue("IMAGE", "../sasrfex/images/default/icon_delete.png");
            }
            String strRemoveTooltip = this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"GRIDVIEW", (String)"REMOVE"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"REMOVE"), "\u5220\u9664%1$s");
            tbItemNode.SetValue("TIPS", StringHelper.Format((String)strRemoveTooltip, (Object)strObjectName));
            if (StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
                tbItemNode.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.GridRemoveHandler"));
            }
            if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) == 0) {
                tbItemNode.SetValue("HANDLERTYPE", "GRIDVIEW_DELETE");
            }
            tbItemNode.SetValue("RESOURCEID", UniResHelper.GetDEDataResId((String)iDEHelper.getId(), (String)"DELETE"));
            DAConfigHelper.AddToolbarSeperator(tbItemsNode);
        }
        DAConfigHelper.EraseToolbarUnnecessarySeperator(rootNode);
        if (!DAConfigHelper.ExportConfigFile((XMLNode)rootNode, (String)strTBFilePath)) {
            return "";
        }
        return strToolbarConfigId;
    }

    public String GetDPDataGridConfigId(IDEHelper iDEHelper, DataGrid dataGrid, TreeMap<String, String> abilityMap) {
        String strDataGridConfigId = StringHelper.Format((String)"DE%1$s.DPDG_%2$s_%3$s%4$s", (Object)iDEHelper.getId(), (Object)iDEHelper.getVersion(), (Object)dataGrid.getDATAGRIDID(), (Object)dataGrid.getDGVERSION());
        for (String strKey : abilityMap.keySet()) {
            strDataGridConfigId = String.valueOf(strDataGridConfigId) + "__";
            strDataGridConfigId = String.valueOf(strDataGridConfigId) + strKey;
        }
        if (!StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
            strDataGridConfigId = String.valueOf(strDataGridConfigId) + StringHelper.Format((String)"_PM_%1$s", (Object)this.strPageModel);
        }
        if (!StringHelper.IsNullOrEmpty((String)this.strLanguage)) {
            strDataGridConfigId = String.valueOf(strDataGridConfigId) + StringHelper.Format((String)"_%1$s", (Object)this.strLanguage);
        }
        strDataGridConfigId = strDataGridConfigId.toUpperCase();
        String strDGFilePath = ConfigPathHelper.GetRuntimeDGConfigPath((String)this.globalHelperEx.GetAppRootPath(), (String)strDataGridConfigId);
        File file = new File(strDGFilePath);
        if (file.exists()) {
            return strDataGridConfigId;
        }
        TreeMap<String, Object> params = new TreeMap<String, Object>();
        this.OnPrepareDGConfigParams(iDEHelper, null, dataGrid, params);
        XMLNode rootNode = this.GetDGConfig(iDEHelper, dataGrid, params);
        if (!this.OnAfterPrepareDPDataGridConfig(rootNode, iDEHelper, dataGrid)) {
            return "";
        }
        if (!DAConfigHelper.ExportConfigFile((XMLNode)rootNode, (String)strDGFilePath)) {
            return "";
        }
        return strDataGridConfigId;
    }

    protected boolean OnAfterPrepareDPDataGridConfig(XMLNode rootNode, IDEHelper iDEHelper, DataGrid dataGrid) {
        return true;
    }

    protected void OnAppendGridViewToolbar(int nStep, XMLNode root, XMLNode tbItemsNode, IDEHelper iDEHelper, Page page, DataGrid dataGrid, boolean bPickupMode, boolean bMini, boolean bEnableRowEdit, boolean bInfoMode, boolean bEmbedMode, TreeMap<String, Boolean> buttonStateMap) {
    }

    public String GetGridViewExToolbarConfigId(IDEHelper iDEHelper, Page page, DataGridEx dataGridEx, TreeMap<String, Boolean> buttonStateMap) {
        XMLNode tbItemNode;
        String strToolbarConfigId = "";
        strToolbarConfigId = page == null ? StringHelper.Format((String)"DE%1$s.TB_GRIDEX_%2$s_%3$s", (Object)iDEHelper.getId(), (Object)iDEHelper.getVersion(), (Object)dataGridEx.getVERSION()) : StringHelper.Format((String)"DE%1$s.TB_PAGE_%4$s_%5$s_GRIDEX_%2$s_%3$s", (Object)iDEHelper.getId(), (Object)iDEHelper.getVersion(), (Object)dataGridEx.getVERSION(), (Object)page.getPAGEID(), (Object)page.getVERSION());
        if (!StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
            strToolbarConfigId = String.valueOf(strToolbarConfigId) + StringHelper.Format((String)"_PM_%1$s", (Object)this.strPageModel);
        }
        if (!StringHelper.IsNullOrEmpty((String)this.strLanguage)) {
            strToolbarConfigId = String.valueOf(strToolbarConfigId) + StringHelper.Format((String)"_%1$s", (Object)this.strLanguage);
        }
        strToolbarConfigId = strToolbarConfigId.toUpperCase();
        String strTBFilePath = ConfigPathHelper.GetRuntimeToolbarConfigPath((String)this.globalHelperEx.GetAppRootPath(), (String)strToolbarConfigId);
        File file = new File(strTBFilePath);
        if (file.exists()) {
            return strToolbarConfigId;
        }
        DefaultToolbarWriterContext tbWriterContext = this.CreateTBWriterContext();
        tbWriterContext.setPage(page);
        tbWriterContext.setDEHelper(iDEHelper);
        XMLNode rootNode = new XMLNode();
        rootNode.setNodeName("SRFEXTOOLBAR");
        XMLNode tbItemsNode = new XMLNode();
        tbItemsNode.setNodeName(ToolbarItemsConfig.TAG_TOOLBARITEMS);
        rootNode.AddNode(tbItemsNode);
        XMLNode userToolbar = null;
        String strToolbarXML = "";
        userToolbar = DAConfigHelper.LoadToolbarConfig(strToolbarXML, page);
        boolean bExportButton = true;
        boolean bOtherAction = true;
        boolean bPrintAction = iDEHelper.IsEnablePrint();
        boolean bSearchBar = true;
        boolean bReplaceDefault = false;
        boolean bNewRowAction = iDEHelper.IsEnableUserCreate();
        boolean bEditRowAction = iDEHelper.IsEnableUserUpdate();
        boolean bHelpAction = iDEHelper.IsEnableHelp();
        boolean bImportExcel = iDEHelper.IsEnableImport();
        String strObjectName = iDEHelper.getLogicName(this.strLanguage);
        if (buttonStateMap != null) {
            bExportButton = DAConfigHelper.GetButtonState(buttonStateMap, TAG_EXPORTACTION, bExportButton);
            bOtherAction = DAConfigHelper.GetButtonState(buttonStateMap, TAG_OTHERACTION, bOtherAction);
            bPrintAction = DAConfigHelper.GetButtonState(buttonStateMap, TAG_PRINTACTION, bPrintAction);
            bSearchBar = DAConfigHelper.GetButtonState(buttonStateMap, TAG_SEARCHBARACTION, bSearchBar);
            bNewRowAction = DAConfigHelper.GetButtonState(buttonStateMap, TAG_NEWROWACTION, bNewRowAction);
            bEditRowAction = DAConfigHelper.GetButtonState(buttonStateMap, TAG_EDITROWACTION, bEditRowAction);
            bHelpAction = DAConfigHelper.GetButtonState(buttonStateMap, TAG_HELPACTION, bHelpAction);
            bImportExcel = DAConfigHelper.GetButtonState(buttonStateMap, TAG_IMPORTEXCELACTION, bImportExcel);
        }
        if (userToolbar != null) {
            if (bReplaceDefault = userToolbar.GetExtValue(TAG_SRFREPLACEDEFAULT, bReplaceDefault)) {
                userToolbar.setNodeName("SRFEXTOOLBAR");
                if (!DAConfigHelper.ExportConfigFile((XMLNode)userToolbar, (String)strTBFilePath)) {
                    return "";
                }
                return strToolbarConfigId;
            }
            bExportButton = userToolbar.GetExtValue(TAG_EXPORTACTION, bExportButton);
            bOtherAction = userToolbar.GetExtValue(TAG_OTHERACTION, bOtherAction);
            bPrintAction = userToolbar.GetExtValue(TAG_PRINTACTION, bPrintAction);
            bSearchBar = userToolbar.GetExtValue(TAG_SEARCHBARACTION, bSearchBar);
            bNewRowAction = userToolbar.GetExtValue(TAG_NEWROWACTION, bNewRowAction);
            bEditRowAction = userToolbar.GetExtValue(TAG_EDITROWACTION, bEditRowAction);
            strObjectName = userToolbar.GetExtValue(TAG_OBJECTNAME, strObjectName);
            bHelpAction = userToolbar.GetExtValue(TAG_HELPACTION, bHelpAction);
            bImportExcel = userToolbar.GetExtValue(TAG_IMPORTEXCELACTION, bImportExcel);
        }
        bPrintAction = false;
        this.OnAppendGridViewExToolbar(1, rootNode, tbItemsNode, iDEHelper, page, dataGridEx, buttonStateMap);
        if (bExportButton) {
            XMLNode tbItemNode2 = new XMLNode();
            tbItemNode2.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
            tbItemsNode.AddNode(tbItemNode2);
            if (StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
                tbItemNode2.SetValue("ICONCSSCLASS", "sx-tb-export");
            }
            if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) == 0) {
                tbItemNode2.SetValue("IMAGE", "../sasrfex/images/default/icon_export.png");
            }
            tbItemNode2.SetValue(ToolbarButtonConfig.TAG_TEXT, this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"GRIDVIEW", (String)"EXPORT"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"EXPORT"), "\u5bfc\u51fa"));
            String strExportTooltip = this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"GRIDVIEW", (String)"EXPORT"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"EXPORT"), "\u5bfc\u51fa%1$s\u5230Excel\u6587\u4ef6");
            tbItemNode2.SetValue("TIPS", StringHelper.Format((String)strExportTooltip, (Object)strObjectName));
            if (StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
                tbItemNode2.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.DGExExportExcelHandler"));
            }
            if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) == 0) {
                tbItemNode2.SetValue("HANDLERTYPE", "GRIDVIEW_EXPORT");
            }
            String strMaxRow = iDEHelper.GetProperty("MAXDOWNLOADROW", this.globalHelperEx.getWebExConfig().GetValue("SRFDA", "MAXDOWNLOADROW", "1000"));
            tbItemNode2.SetValue("MAXROW", strMaxRow);
        }
        if (bExportButton || bPrintAction) {
            DAConfigHelper.AddToolbarSeperator(tbItemsNode);
        }
        this.OnAppendGridViewExToolbar(2, rootNode, tbItemsNode, iDEHelper, page, dataGridEx, buttonStateMap);
        XMLNode userOtherAction = null;
        if (userToolbar != null && userToolbar.getChildNodes() != null) {
            boolean bAppendSeperator = false;
            for (XMLNode child : userToolbar.getChildNodes()) {
                String strID = child.getID();
                if (StringHelper.Compare((String)strID, (String)TAG_OTHERACTION, (boolean)true) != 0) {
                    if (StringHelper.Compare((String)child.getNodeName(), (String)"SRFDATBITEM", (boolean)true) == 0) {
                        this.ExportTBItem(rootNode, tbItemsNode, child, false, tbWriterContext, false);
                        continue;
                    }
                    int nPos = child.GetExtValue(TAG_POS, -1);
                    if (nPos == -1) {
                        tbItemsNode.AddNode(child);
                        bAppendSeperator = true;
                        continue;
                    }
                    tbItemsNode.AddNode(nPos, child);
                    continue;
                }
                userOtherAction = child;
            }
            if (bAppendSeperator) {
                DAConfigHelper.AddToolbarSeperator(tbItemsNode);
            }
        }
        this.OnAppendGridViewExToolbar(3, rootNode, tbItemsNode, iDEHelper, page, dataGridEx, buttonStateMap);
        if (bOtherAction) {
            tbItemNode = new XMLNode();
            tbItemNode.setNodeName(ToolbarSplitButtonConfig.TAG_TOOLBARSPLITBUTTON);
            tbItemNode.SetValue(ToolbarButtonConfig.TAG_TEXT, this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"GRIDVIEW", (String)"OTHER"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"OTHER"), "\u5176\u5b83"));
            tbItemNode.SetValue("ICONCSSCLASS", "sx-tb-other");
            tbItemsNode.AddNode(tbItemNode);
            XMLNode tbMenusNode = new XMLNode();
            tbMenusNode.setNodeName("SRFEXMAINMENUEX");
            tbItemNode.AddNode(tbMenusNode);
            if (userOtherAction != null && userOtherAction.getChildNodes() != null) {
                for (XMLNode child : userOtherAction.getChildNodes()) {
                    if (StringHelper.Compare((String)child.getNodeName(), (String)"SRFDATBITEM", (boolean)true) == 0) {
                        this.ExportTBItem(rootNode, tbMenusNode, child, false, tbWriterContext, true);
                        continue;
                    }
                    tbMenusNode.AddNode(child);
                }
            }
            if (tbMenusNode.getChildNodes() == null || tbMenusNode.getChildNodes().size() == 0) {
                tbItemsNode.RemoveNode(tbItemNode);
            } else {
                DAConfigHelper.AddToolbarSeperator(tbItemsNode);
            }
        }
        this.OnAppendGridViewExToolbar(4, rootNode, tbItemsNode, iDEHelper, page, dataGridEx, buttonStateMap);
        if (bSearchBar && StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
            tbItemNode = new XMLNode();
            tbItemNode.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
            tbItemNode.setID(TAG_TBB_FILTER);
            tbItemsNode.AddNode(tbItemNode);
            tbItemNode.SetValue("ICONCSSCLASS", "sx-tb-filter");
            tbItemNode.SetValue(ToolbarButtonConfig.TAG_TEXT, this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"GRIDVIEW", (String)"FILTER"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"FILTER"), "\u8fc7\u6ee4"));
            tbItemNode.SetValue("TIPS", this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"GRIDVIEW", (String)"FILTER"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"FILTER"), "\u8fdb\u4e00\u6b65\u641c\u7d22\u6570\u636e"));
            tbItemNode.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.SPShowHideHandler"));
            DAConfigHelper.AddToolbarSeperator(tbItemsNode);
        }
        if (bHelpAction) {
            tbItemNode = new XMLNode();
            tbItemNode.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
            tbItemsNode.AddNode(tbItemNode);
            if (StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
                tbItemNode.SetValue("ICONCSSCLASS", "sx-tb-help");
            }
            if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) == 0) {
                tbItemNode.SetValue("IMAGE", "../sasrfex/images/default/icon_help16.png");
            }
            tbItemNode.SetValue(ToolbarButtonConfig.TAG_TEXT, this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"GRIDVIEW", (String)"HELP"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"HELP"), "\u5e2e\u52a9"));
            tbItemNode.SetValue("TIPS", this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"GRIDVIEW", (String)"HELP"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"HELP"), "\u5e2e\u52a9"));
            tbItemNode.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.HelpHandler"));
            tbItemNode.SetValue("PAGETYPE", "GRIDVIEW");
        }
        this.OnAppendGridViewExToolbar(5, rootNode, tbItemsNode, iDEHelper, page, dataGridEx, buttonStateMap);
        if (!DAConfigHelper.ExportConfigFile((XMLNode)rootNode, (String)strTBFilePath)) {
            return "";
        }
        return strToolbarConfigId;
    }

    protected void OnAppendGridViewExToolbar(int nStep, XMLNode root, XMLNode tbItemsNode, IDEHelper iDEHelper, Page page, DataGridEx dataGridEx, TreeMap<String, Boolean> buttonStateMap) {
    }

    public String GetRIAGridViewToolbarConfigPath(IDEHelper iDEHelper, Page page, DataGrid dataGrid, boolean bPickupMode, boolean bMini, boolean bEnableRowEdit, boolean bInfoMode, TreeMap<String, Boolean> buttonStateMap) {
        XMLNode tbItemNode;
        String strExportList;
        String strToolbarConfigId = "";
        strToolbarConfigId = page == null ? StringHelper.Format((String)"DE%1$s.TB_RIA_GRID_%5$s_%4$s_%2$s_%3$s", (Object)iDEHelper.getId(), (Object)iDEHelper.getVersion(), (Object)dataGrid.getDGVERSION(), (Object)(bMini ? "MINI" : ""), (Object)(bEnableRowEdit ? "1" : "0")) : StringHelper.Format((String)"DE%1$s.TB_RIA_PAGE_%5$s_%6$s_GRID_%4$s_%7$s_%2$s_%3$s", (Object)iDEHelper.getId(), (Object)iDEHelper.getVersion(), (Object)dataGrid.getDGVERSION(), (Object)(bMini ? "MINI" : ""), (Object)page.getPAGEID(), (Object)page.getVERSION(), (Object)(bEnableRowEdit ? "1" : "0"));
        if (bInfoMode) {
            strToolbarConfigId = String.valueOf(strToolbarConfigId) + "_I";
        }
        if (bPickupMode) {
            strToolbarConfigId = String.valueOf(strToolbarConfigId) + "_P";
        }
        strToolbarConfigId = strToolbarConfigId.toUpperCase();
        String strTBFilePath = ConfigPathHelper.GetRuntimeToolbarConfigPath((String)this.globalHelperEx.GetAppRootPath(), (String)strToolbarConfigId);
        File file = new File(strTBFilePath);
        if (file.exists()) {
            return strTBFilePath;
        }
        DefaultToolbarWriterContext tbWriterContext = this.CreateTBWriterContext();
        tbWriterContext.setPage(page);
        tbWriterContext.setDEHelper(iDEHelper);
        tbWriterContext.setViewStyle("GRIDVIEW");
        tbWriterContext.RegisterGlobal(TBCOND_ROWACTIONBAR, bEnableRowEdit);
        tbWriterContext.setAttribute(TAG_INFOMODE, bInfoMode);
        XMLNode rootNode = new XMLNode();
        rootNode.setNodeName("SRFEXTOOLBAR");
        XMLNode tbItemsNode = new XMLNode();
        tbItemsNode.setNodeName(ToolbarItemsConfig.TAG_TOOLBARITEMS);
        rootNode.AddNode(tbItemsNode);
        XMLNode userToolbar = null;
        String strToolbarXML = dataGrid.getDGTOOLBAR();
        userToolbar = DAConfigHelper.LoadToolbarConfig(strToolbarXML, page);
        boolean bNewButton = true;
        boolean bEditButton = true;
        boolean bRemoveButton = true;
        boolean bCopyButton = true;
        boolean bExportButton = true;
        boolean bOtherAction = true;
        boolean bPrintAction = iDEHelper.IsEnablePrint();
        boolean bMultiPrint = false;
        boolean bSearchBar = true;
        boolean bExportXMLButton = true;
        boolean bReplaceDefault = false;
        boolean bNewRowAction = true;
        boolean bEditRowAction = true;
        boolean bHelpAction = iDEHelper.IsEnableHelp();
        String strObjectName = iDEHelper.getLogicName(this.strLanguage);
        bMultiPrint = this.globalHelperEx.getWebExConfig().GetValue("SRFDA", TAG_MULTIPRINT, "FALSE").equalsIgnoreCase("TRUE");
        switch (iDEHelper.getDataEntity().GetParamIntValue("ISMULTIPRINT", -1)) {
            case 0: {
                bMultiPrint = false;
                break;
            }
            case 1: {
                bMultiPrint = true;
                break;
            }
        }
        if (buttonStateMap != null) {
            bNewButton = DAConfigHelper.GetButtonState(buttonStateMap, TAG_NEWACTION, bNewButton);
            bEditButton = DAConfigHelper.GetButtonState(buttonStateMap, TAG_EDITACTION, bEditButton);
            bRemoveButton = DAConfigHelper.GetButtonState(buttonStateMap, TAG_REMOVEACTION, bRemoveButton);
            bCopyButton = DAConfigHelper.GetButtonState(buttonStateMap, TAG_COPYACTION, bCopyButton);
            bExportButton = DAConfigHelper.GetButtonState(buttonStateMap, TAG_EXPORTACTION, bExportButton);
            bOtherAction = DAConfigHelper.GetButtonState(buttonStateMap, TAG_OTHERACTION, bOtherAction);
            bPrintAction = DAConfigHelper.GetButtonState(buttonStateMap, TAG_PRINTACTION, bPrintAction);
            bSearchBar = DAConfigHelper.GetButtonState(buttonStateMap, TAG_SEARCHBARACTION, bSearchBar);
            bExportXMLButton = DAConfigHelper.GetButtonState(buttonStateMap, TAG_EXPORTXMLACTION, bExportXMLButton);
            bNewRowAction = DAConfigHelper.GetButtonState(buttonStateMap, TAG_NEWROWACTION, bNewRowAction);
            bEditRowAction = DAConfigHelper.GetButtonState(buttonStateMap, TAG_EDITROWACTION, bEditRowAction);
            bHelpAction = DAConfigHelper.GetButtonState(buttonStateMap, TAG_HELPACTION, bHelpAction);
        }
        if (bPickupMode) {
            bExportButton = false;
        }
        if (bExportXMLButton && !StringHelper.IsNullOrEmpty((String)(strExportList = this.globalHelperEx.getWebExConfig().GetValue("SRFDA", "EXPORTMODEL", "")))) {
            bExportXMLButton = false;
            String[] list = strExportList.split("[|]");
            int i = 0;
            while (i < list.length) {
                if (StringHelper.Compare((String)list[i], (String)iDEHelper.getDataEntity().getDEGROUP(), (boolean)true) == 0) {
                    bExportXMLButton = true;
                    break;
                }
                if (StringHelper.Compare((String)list[i], (String)iDEHelper.getId(), (boolean)true) == 0) {
                    bExportXMLButton = true;
                    break;
                }
                ++i;
            }
        }
        if (userToolbar != null) {
            if (bReplaceDefault = userToolbar.GetExtValue(TAG_SRFREPLACEDEFAULT, bReplaceDefault)) {
                userToolbar.setNodeName("SRFEXTOOLBAR");
                if (!DAConfigHelper.ExportConfigFile((XMLNode)userToolbar, (String)strTBFilePath)) {
                    return "";
                }
                return strTBFilePath;
            }
            bNewButton = userToolbar.GetExtValue(TAG_NEWACTION, bNewButton);
            bEditButton = userToolbar.GetExtValue(TAG_EDITACTION, bEditButton);
            bRemoveButton = userToolbar.GetExtValue(TAG_REMOVEACTION, bRemoveButton);
            bCopyButton = userToolbar.GetExtValue(TAG_COPYACTION, bCopyButton);
            bExportButton = userToolbar.GetExtValue(TAG_EXPORTACTION, bExportButton);
            bOtherAction = userToolbar.GetExtValue(TAG_OTHERACTION, bOtherAction);
            bPrintAction = userToolbar.GetExtValue(TAG_PRINTACTION, bPrintAction);
            bSearchBar = userToolbar.GetExtValue(TAG_SEARCHBARACTION, bSearchBar);
            bExportXMLButton = userToolbar.GetExtValue(TAG_EXPORTXMLACTION, bExportXMLButton);
            bNewRowAction = userToolbar.GetExtValue(TAG_NEWROWACTION, bNewRowAction);
            bEditRowAction = userToolbar.GetExtValue(TAG_EDITROWACTION, bEditRowAction);
            strObjectName = userToolbar.GetExtValue(TAG_OBJECTNAME, strObjectName);
            bHelpAction = userToolbar.GetExtValue(TAG_HELPACTION, bHelpAction);
        }
        if (!bInfoMode) {
            if (bNewButton) {
                tbItemNode = new XMLNode();
                tbItemNode.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
                tbItemsNode.AddNode(tbItemNode);
                tbItemNode.SetValue("ICON", "/sasrfex/images/default/icon_new.png");
                if (bMini) {
                    tbItemNode.SetValue(ToolbarButtonConfig.TAG_TEXT, "\u65b0\u5efa");
                } else {
                    tbItemNode.SetValue(ToolbarButtonConfig.TAG_TEXT, "\u65b0\u5efa" + strObjectName);
                }
                tbItemNode.SetValue("TIPS", "\u65b0\u5efa" + strObjectName);
                tbItemNode.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.GridNewHandler"));
                tbItemNode.SetValue("RESOURCEID", UniResHelper.GetDEDataResId((String)iDEHelper.getId(), (String)"CREATE"));
                if (!StringHelper.IsNullOrEmpty((String)this.getPageModel())) {
                    this.RebuildGridViewNewAction(tbItemsNode, tbItemNode, iDEHelper);
                }
            }
            if (bEditButton) {
                tbItemNode = new XMLNode();
                tbItemNode.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
                tbItemsNode.AddNode(tbItemNode);
                tbItemNode.SetValue("ICON", "/sasrfex/images/default/icon_edit.png");
                tbItemNode.SetValue(ToolbarButtonConfig.TAG_TEXT, "\u7f16\u8f91");
                tbItemNode.SetValue("TIPS", "\u7f16\u8f91" + strObjectName);
                tbItemNode.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.GridEditHandler"));
            }
            if (bCopyButton) {
                tbItemNode = new XMLNode();
                tbItemNode.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
                tbItemsNode.AddNode(tbItemNode);
                tbItemNode.SetValue("ICON", "/sasrfex/images/default/icon_copy.png");
                if (!bMini) {
                    tbItemNode.SetValue(ToolbarButtonConfig.TAG_TEXT, "\u62f7\u8d1d");
                }
                tbItemNode.SetValue("TIPS", "\u62f7\u8d1d" + strObjectName);
                tbItemNode.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.GridCopyHandler"));
                tbItemNode.SetValue("RESOURCEID", UniResHelper.GetDEDataResId((String)iDEHelper.getId(), (String)"CREATE"));
            }
            if (bNewButton || bEditButton || bCopyButton) {
                DAConfigHelper.AddToolbarSeperator(tbItemsNode);
            }
            if (bEnableRowEdit) {
                if (bEditRowAction) {
                    tbItemNode = new XMLNode();
                    tbItemNode.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
                    tbItemsNode.AddNode(tbItemNode);
                    tbItemNode.SetValue("ICON", "/sasrfex/images/default/icon_rowedit.png");
                    tbItemNode.SetValue(ToolbarButtonConfig.TAG_TEXT, "\u884c\u7f16\u8f91");
                    tbItemNode.SetValue("TIPS", "\u542f\u7528\u884c\u7f16\u8f91\u80fd\u529b");
                    tbItemNode.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.GridRowEditableHandler"));
                    tbItemNode.SetValue("ENABLETOGGLE", "TRUE");
                    tbItemNode.SetValue("RESOURCEID", UniResHelper.GetDEDataResId((String)iDEHelper.getId(), (String)"UPDATE"));
                }
                if (bNewRowAction) {
                    tbItemNode = new XMLNode();
                    tbItemNode.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
                    tbItemsNode.AddNode(tbItemNode);
                    tbItemNode.SetValue("ICON", "/sasrfex/images/default/icon_addrow.png");
                    tbItemNode.SetValue("TIPS", "\u65b0\u52a0\u884c");
                    tbItemNode.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.GridNewRowHandler"));
                    tbItemNode.SetValue("RESOURCEID", UniResHelper.GetDEDataResId((String)iDEHelper.getId(), (String)"CREATE"));
                }
                if (bNewRowAction || bEditRowAction) {
                    tbItemNode = new XMLNode();
                    tbItemNode.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
                    tbItemsNode.AddNode(tbItemNode);
                    tbItemNode.SetValue("ICON", "/sasrfex/images/default/icon_rowsave.png");
                    tbItemNode.SetValue("TIPS", "\u4fdd\u5b58\u884c");
                    tbItemNode.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.GridSaveRowHandler"));
                    tbItemNode.SetValue("RESOURCEID", UniResHelper.GetDEDataResId((String)iDEHelper.getId(), (String)"UPDATE"));
                }
                DAConfigHelper.AddToolbarSeperator(tbItemsNode);
            }
            if (bRemoveButton) {
                tbItemNode = new XMLNode();
                tbItemNode.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
                tbItemsNode.AddNode(tbItemNode);
                tbItemNode.SetValue("ICON", "/sasrfex/images/default/icon_delete.png");
                if (!bMini) {
                    tbItemNode.SetValue(ToolbarButtonConfig.TAG_TEXT, "\u5220\u9664");
                }
                tbItemNode.SetValue("TIPS", "\u5220\u9664" + iDEHelper.getLogicName(this.strLanguage));
                tbItemNode.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.GridRemoveHandler"));
                tbItemNode.SetValue("RESOURCEID", UniResHelper.GetDEDataResId((String)iDEHelper.getId(), (String)"DELETE"));
                DAConfigHelper.AddToolbarSeperator(tbItemsNode);
            }
        } else {
            if (bEditButton) {
                tbItemNode = new XMLNode();
                tbItemNode.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
                tbItemsNode.AddNode(tbItemNode);
                tbItemNode.SetValue("ICON", "/sasrfex/images/default/icon_edit.png");
                tbItemNode.SetValue(ToolbarButtonConfig.TAG_TEXT, "\u67e5\u770b");
                tbItemNode.SetValue("TIPS", "\u67e5\u770b" + strObjectName);
                tbItemNode.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.GridEditHandler"));
            }
            if (bEditButton) {
                DAConfigHelper.AddToolbarSeperator(tbItemsNode);
            }
        }
        if (bExportButton) {
            tbItemNode = new XMLNode();
            tbItemNode.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
            tbItemsNode.AddNode(tbItemNode);
            tbItemNode.SetValue("ICON", "/sasrfex/images/default/icon_export.png");
            if (!bMini) {
                tbItemNode.SetValue(ToolbarButtonConfig.TAG_TEXT, "\u5bfc\u51fa");
            }
            tbItemNode.SetValue("TIPS", "\u5bfc\u51fa" + iDEHelper.getLogicName(this.strLanguage) + "\u5230Excel\u6587\u4ef6");
            tbItemNode.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.GridExportExcelHandler"));
            String strMaxRow = iDEHelper.GetProperty("MAXDOWNLOADROW", this.globalHelperEx.getWebExConfig().GetValue("SRFDA", "MAXDOWNLOADROW", "1000"));
            tbItemNode.SetValue("MAXROW", strMaxRow);
        }
        if (bPrintAction) {
            tbItemNode = new XMLNode();
            tbItemNode.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
            tbItemsNode.AddNode(tbItemNode);
            tbItemNode.SetValue("ICON", "/sasrfex/images/default/icon_print.png");
            if (!bMini) {
                tbItemNode.SetValue(ToolbarButtonConfig.TAG_TEXT, this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"GRIDVIEW", (String)"PRINT"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"PRINT"), "\u6253\u5370"));
            }
            tbItemNode.SetValue("TIPS", this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"GRIDVIEW", (String)"PRINT"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"PRINT"), "\u6253\u5370\u5f53\u524d\u6570\u636e"));
            tbItemNode.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.GridPrintHandler"));
            if (bMultiPrint) {
                tbItemNode.SetValue("ICON", "/sasrfex/images/default/icon_mprint.png");
            }
            tbItemNode.SetValue(TAG_MULTIPRINT, String.valueOf(bMultiPrint).toUpperCase());
        }
        if (bExportButton || bPrintAction) {
            DAConfigHelper.AddToolbarSeperator(tbItemsNode);
        }
        XMLNode userOtherAction = null;
        if (userToolbar != null && userToolbar.getChildNodes() != null) {
            boolean bAppendSeperator = false;
            for (XMLNode child : userToolbar.getChildNodes()) {
                String strID = child.getID();
                if (StringHelper.Compare((String)strID, (String)TAG_OTHERACTION, (boolean)true) != 0) {
                    if (StringHelper.Compare((String)child.getNodeName(), (String)"SRFDATBITEM", (boolean)true) == 0) {
                        bAppendSeperator = true;
                        this.ExportTBItem(rootNode, tbItemsNode, child, false, tbWriterContext, false);
                        continue;
                    }
                    int nPos = child.GetExtValue(TAG_POS, -1);
                    if (nPos == -1) {
                        tbItemsNode.AddNode(child);
                        bAppendSeperator = true;
                        continue;
                    }
                    tbItemsNode.AddNode(nPos, child);
                    continue;
                }
                userOtherAction = child;
            }
            if (bAppendSeperator) {
                DAConfigHelper.AddToolbarSeperator(tbItemsNode);
            }
        }
        if (bOtherAction) {
            XMLNode tbItemNode2 = new XMLNode();
            tbItemNode2.setNodeName(ToolbarSplitButtonConfig.TAG_TOOLBARSPLITBUTTON);
            if (!bMini) {
                tbItemNode2.SetValue(ToolbarButtonConfig.TAG_TEXT, "\u5176\u5b83");
            } else {
                tbItemNode2.SetValue(ToolbarButtonConfig.TAG_TEXT, "\u5176\u5b83");
            }
            tbItemNode2.SetValue("ICON", "/sasrfex/images/default/icon_picklist.gif");
            tbItemsNode.AddNode(tbItemNode2);
            XMLNode tbMenusNode = new XMLNode();
            tbMenusNode.setNodeName("SRFEXMAINMENUEX");
            tbItemNode2.AddNode(tbMenusNode);
            if (userOtherAction != null && userOtherAction.getChildNodes() != null) {
                for (XMLNode child : userOtherAction.getChildNodes()) {
                    if (StringHelper.Compare((String)child.getNodeName(), (String)"SRFDATBITEM", (boolean)true) == 0) {
                        this.ExportTBItem(rootNode, tbMenusNode, child, false, tbWriterContext, true);
                        continue;
                    }
                    tbMenusNode.AddNode(child);
                }
            }
            if (bExportXMLButton) {
                XMLNode tbMenuItemNode = new XMLNode();
                tbMenusNode.AddNode(tbMenuItemNode);
                tbMenuItemNode.setNodeName("SRFEXMENUITEMEX");
                tbMenuItemNode.SetValue("CAPTION", "\u5bfc\u51fa\u6570\u636e\u6a21\u578b");
                tbMenuItemNode.SetValue("HANDLER", "SA.SRFDA.Ctrl.Toolbar.GridCustomCallHandler");
                tbMenuItemNode.SetValue("CALLID", "SRFDAEXPORTXML");
                tbMenuItemNode.SetValue("CALLNAME", "\u5bfc\u51faXML\u6a21\u578b");
                tbMenuItemNode.SetValue("CALLJSCODE", "if(confirm($P.msg['10100'])){_P.frameonly=true;}");
                tbMenuItemNode.SetValue("CONFIRM", "FALSE");
            }
            if (tbMenusNode.getChildNodes() == null || tbMenusNode.getChildNodes().size() == 0) {
                tbItemsNode.RemoveNode(tbItemNode2);
            } else {
                DAConfigHelper.AddToolbarSeperator(tbItemsNode);
            }
        }
        if (bSearchBar) {
            XMLNode tbItemNode3 = new XMLNode();
            tbItemNode3.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
            tbItemNode3.setID(TAG_TBB_FILTER);
            tbItemsNode.AddNode(tbItemNode3);
            tbItemNode3.SetValue("ICON", "/sasrfex/images/default/icon_filter.png");
            if (!bMini) {
                tbItemNode3.SetValue(ToolbarButtonConfig.TAG_TEXT, "\u8fc7\u6ee4");
            }
            tbItemNode3.SetValue("TIPS", "\u8fdb\u4e00\u6b65\u641c\u7d22\u6570\u636e");
            tbItemNode3.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.SPShowHideHandler"));
            DAConfigHelper.AddToolbarSeperator(tbItemsNode);
        }
        if (bHelpAction) {
            XMLNode tbItemNode4 = new XMLNode();
            tbItemNode4.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
            tbItemsNode.AddNode(tbItemNode4);
            tbItemNode4.SetValue("ICON", "/sasrfex/images/default/icon_help16.png");
            if (!bMini) {
                tbItemNode4.SetValue(ToolbarButtonConfig.TAG_TEXT, "\u5e2e\u52a9");
            }
            tbItemNode4.SetValue("TIPS", "\u5e2e\u52a9");
            tbItemNode4.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.HelpHandler"));
        }
        if (!DAConfigHelper.ExportConfigFile((XMLNode)rootNode, (String)strTBFilePath)) {
            return "";
        }
        return strTBFilePath;
    }

    private static boolean GetButtonState(TreeMap<String, Boolean> bsMap, String strButtonId, boolean bDefault) {
        if (bsMap == null) {
            return bDefault;
        }
        if (bsMap.containsKey(strButtonId = strButtonId.toUpperCase())) {
            return bsMap.get(strButtonId);
        }
        return bDefault;
    }

    public String GetWFGridViewToolbarConfigId(IDEHelper iDEHelper, Page page, DataGrid dataGrid, String strWFStateValue, boolean bWFProcess, String strWFStep, boolean bWFState, boolean bEditable, boolean bEnableRowEdit, WFGetIAActionsResult wfGetIAActionsResult) {
        XMLNode tbItemNode;
        XMLNode tbItemNode2;
        strWFStateValue = strWFStateValue.replace("|", "_");
        String strToolbarConfigId = "";
        strToolbarConfigId = page == null ? StringHelper.Format((String)"DE%1$s.TB_GRID_%4$s_%5$s_%6$s_%7$s_%2$s_%3$s", (Object)iDEHelper.getId(), (Object)iDEHelper.getVersion(), (Object)dataGrid.getDGVERSION(), (Object)"WF", (Object)(String.valueOf(strWFStateValue) + (bWFProcess ? "_WFWORK" : "")), (Object)strWFStep, (Object)(wfGetIAActionsResult != null ? wfGetIAActionsResult.getVersion() : 0)) : StringHelper.Format((String)"DE%1$s.TB_%8$s_%9$s_GRID_%4$s_%5$s_%6$s_%7$s_%2$s_%3$s", (Object)iDEHelper.getId(), (Object)iDEHelper.getVersion(), (Object)dataGrid.getDGVERSION(), (Object)"WF", (Object)(String.valueOf(strWFStateValue) + (bWFProcess ? "_WFWORK" : "")), (Object)strWFStep, (Object)(wfGetIAActionsResult != null ? wfGetIAActionsResult.getVersion() : 0), (Object)page.getPAGEID(), (Object)page.getVERSION());
        if (wfGetIAActionsResult != null && !StringHelper.IsNullOrEmpty((String)wfGetIAActionsResult.getUserTag())) {
            strToolbarConfigId = String.valueOf(strToolbarConfigId) + StringHelper.Format((String)"_%1$s", (Object)wfGetIAActionsResult.getUserTag());
        }
        if (bEnableRowEdit) {
            strToolbarConfigId = String.valueOf(strToolbarConfigId) + "_R";
        }
        if (!StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
            strToolbarConfigId = String.valueOf(strToolbarConfigId) + StringHelper.Format((String)"_PM_%1$s", (Object)this.strPageModel);
        }
        if (!StringHelper.IsNullOrEmpty((String)this.strLanguage)) {
            strToolbarConfigId = String.valueOf(strToolbarConfigId) + StringHelper.Format((String)"_%1$s", (Object)this.strLanguage);
        }
        strToolbarConfigId = strToolbarConfigId.replace(":", "__");
        strToolbarConfigId = strToolbarConfigId.toUpperCase();
        String strTBFilePath = ConfigPathHelper.GetRuntimeToolbarConfigPath((String)this.globalHelperEx.GetAppRootPath(), (String)strToolbarConfigId);
        File file = new File(strTBFilePath);
        if (file.exists()) {
            return strToolbarConfigId;
        }
        DefaultToolbarWriterContext tbWriterContext = this.CreateTBWriterContext();
        tbWriterContext.setPage(page);
        tbWriterContext.setDEHelper(iDEHelper);
        tbWriterContext.setViewStyle("GRIDVIEW");
        tbWriterContext.RegisterGlobal(TBCOND_ROWACTIONBAR, bEnableRowEdit);
        tbWriterContext.setWFGetIAActionsResult(wfGetIAActionsResult);
        XMLNode rootNode = new XMLNode();
        rootNode.setNodeName("SRFEXTOOLBAR");
        XMLNode tbItemsNode = new XMLNode();
        tbItemsNode.setNodeName(ToolbarItemsConfig.TAG_TOOLBARITEMS);
        rootNode.AddNode(tbItemsNode);
        Toolbar toolbar = null;
        if (page != null) {
            String strToolbarId = page.getTOOLBARID();
            if (!StringHelper.IsNullOrEmpty((String)strToolbarId) && (toolbar = this.globalHelperEx.getDAModelStorage().FindToolbar(strToolbarId)) == null) {
                log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5de5\u5177\u680f[%1$s]\u914d\u7f6e", (Object)strToolbarId));
                return "";
            }
            String strTBTEMPLID = "";
            if (toolbar != null) {
                strTBTEMPLID = toolbar.getTBTEMPLID();
            }
            if (StringHelper.IsNullOrEmpty((String)strTBTEMPLID)) {
                strTBTEMPLID = page.GetParamStringValue("TBTEMPLID", "");
            }
            ToolbarConfig tbConfig = null;
            if (StringHelper.IsNullOrEmpty((String)strTBTEMPLID)) {
                if (toolbar != null && toolbar.getNODEFAULT()) {
                    tbConfig = toolbar.getToolbarConfig();
                }
            } else {
                TBTempl tbTempl = this.globalHelperEx.getDAModelStorage().FindTBTempl(strTBTEMPLID);
                if (tbTempl == null) {
                    log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5de5\u5177\u680f\u6a21\u677f[%1$s]\u914d\u7f6e", (Object)strTBTEMPLID));
                    return "";
                }
                tbConfig = tbTempl.getToolbarConfig();
            }
            if (tbConfig != null) {
                tbWriterContext.setToolbar(toolbar);
                CallResult callResult = this.ExportToolbar(rootNode, tbItemsNode, tbConfig, tbWriterContext);
                if (callResult.IsError()) {
                    log.error((Object)StringHelper.Format((String)"\u5bfc\u51fa\u5de5\u5177\u680f\u53d1\u751f\u9519\u8bef,%1$s", (Object)callResult.getErrorInfo()));
                    return "";
                }
                if (!DAConfigHelper.ExportConfigFile((XMLNode)rootNode, (String)strTBFilePath)) {
                    return "";
                }
                return strToolbarConfigId;
            }
        }
        XMLNode userToolbar = null;
        String strToolbarXML = dataGrid.getDGTOOLBAR();
        userToolbar = DAConfigHelper.LoadToolbarConfig(strToolbarXML, page);
        String strObjectName = iDEHelper.getLogicName(this.strLanguage);
        boolean bNewButton = true;
        boolean bEditButton = true;
        boolean bRemoveButton = true;
        boolean bCopyButton = true;
        boolean bExportButton = true;
        boolean bOtherAction = true;
        boolean bPrintAction = iDEHelper.IsEnablePrint();
        boolean bSearchBar = true;
        boolean bCancelAction = true;
        boolean bRestartAction = true;
        boolean bNewRowAction = false;
        boolean bEditRowAction = false;
        boolean bHelpAction = iDEHelper.IsEnableHelp();
        if (bWFProcess) {
            bCancelAction = false;
            bRestartAction = false;
        }
        if (toolbar != null) {
            tbWriterContext.setToolbar(toolbar);
            if (!toolbar.isNEWACTIONNull()) {
                bNewButton = toolbar.getNEWACTION();
            }
            if (!toolbar.isEDITACTIONNull()) {
                bEditButton = toolbar.getEDITACTION();
            }
            if (!toolbar.isREMOVEACTIONNull()) {
                bRemoveButton = toolbar.getREMOVEACTION();
            }
            if (!toolbar.isCOPYACTIONNull()) {
                bCopyButton = toolbar.getCOPYACTION();
            }
            if (!toolbar.isOTHERACTIONNull()) {
                bOtherAction = toolbar.getOTHERACTION();
            }
            if (!toolbar.isPRINTACTIONNull()) {
                bPrintAction = toolbar.getPRINTACTION();
            }
            if (!toolbar.isEXPORTACTIONNull()) {
                bExportButton = toolbar.getEXPORTACTION();
            }
            if (!toolbar.isSEARCHBARACTIONNull()) {
                bSearchBar = toolbar.getSEARCHBARACTION();
            }
            if (!toolbar.isNEWROWACTIONNull()) {
                bNewRowAction = toolbar.getNEWROWACTION();
            }
            if (!toolbar.isEDITROWACTIONNull()) {
                bEditRowAction = toolbar.getEDITROWACTION();
            }
            if (!toolbar.isHELPACTIONNull()) {
                bHelpAction = toolbar.getHELPACTION();
            }
        } else {
            toolbar = new Toolbar();
            tbWriterContext.setToolbar(toolbar);
        }
        if (userToolbar != null) {
            bNewButton = userToolbar.GetExtValue(TAG_NEWACTION, bNewButton);
            bEditButton = userToolbar.GetExtValue(TAG_EDITACTION, bEditButton);
            bRemoveButton = userToolbar.GetExtValue(TAG_REMOVEACTION, bRemoveButton);
            bCopyButton = userToolbar.GetExtValue(TAG_COPYACTION, bCopyButton);
            bExportButton = userToolbar.GetExtValue(TAG_EXPORTACTION, bExportButton);
            bOtherAction = userToolbar.GetExtValue(TAG_OTHERACTION, bOtherAction);
            bPrintAction = userToolbar.GetExtValue(TAG_PRINTACTION, bPrintAction);
            bSearchBar = userToolbar.GetExtValue(TAG_SEARCHBARACTION, bSearchBar);
            bCancelAction = userToolbar.GetExtValue(TAG_CANCELACTION, bCancelAction);
            bRestartAction = userToolbar.GetExtValue(TAG_RESTARTACTION, bRestartAction);
            bNewRowAction = userToolbar.GetExtValue(TAG_NEWROWACTION, bNewRowAction);
            bEditRowAction = userToolbar.GetExtValue(TAG_EDITROWACTION, bEditRowAction);
            bHelpAction = userToolbar.GetExtValue(TAG_HELPACTION, bHelpAction);
        }
        if (!bWFProcess) {
            if (bNewButton) {
                tbItemNode2 = new XMLNode();
                tbItemNode2.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
                tbItemsNode.AddNode(tbItemNode2);
                if (StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
                    tbItemNode2.SetValue("ICONCSSCLASS", "sx-tb-new");
                } else if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) == 0) {
                    tbItemNode2.SetValue("IMAGE", "../sasrfex/images/default/icon_new.png");
                }
                String strNewFormat = this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"GRIDVIEW", (String)"NEW"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"NEW"), "\u65b0\u5efa%1$s");
                String strNewTipFormat = this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"GRIDVIEW", (String)"NEW"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"NEW"), "\u65b0\u5efa%1$s");
                tbItemNode2.SetValue(ToolbarButtonConfig.TAG_TEXT, StringHelper.Format((String)strNewFormat, (Object)""));
                tbItemNode2.SetValue("TIPS", StringHelper.Format((String)strNewTipFormat, (Object)strObjectName));
                tbItemNode2.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.GridNewHandler"));
                if (!StringHelper.IsNullOrEmpty((String)this.getPageModel())) {
                    this.RebuildGridViewNewAction(tbItemsNode, tbItemNode2, iDEHelper);
                }
            }
            if (bEditButton) {
                tbItemNode2 = new XMLNode();
                tbItemNode2.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
                tbItemsNode.AddNode(tbItemNode2);
                if (StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
                    tbItemNode2.SetValue("ICONCSSCLASS", "sx-tb-edit");
                }
                if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) == 0) {
                    tbItemNode2.SetValue("IMAGE", "../sasrfex/images/default/icon_edit.png");
                }
                if (bWFState) {
                    String strViewTipFormat = this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"GRIDVIEW", (String)"VIEW"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"VIEW"), "\u67e5\u770b%1$s");
                    tbItemNode2.SetValue("TIPS", StringHelper.Format((String)strViewTipFormat, (Object)strObjectName));
                } else {
                    String strEditTipFormat = this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"GRIDVIEW", (String)"EDIT"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"EDIT"), "\u7f16\u8f91%1$s");
                    tbItemNode2.SetValue("TIPS", StringHelper.Format((String)strEditTipFormat, (Object)strObjectName));
                }
                tbItemNode2.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.GridEditHandler"));
            }
            if (bCopyButton) {
                tbItemNode2 = new XMLNode();
                tbItemNode2.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
                tbItemsNode.AddNode(tbItemNode2);
                if (StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
                    tbItemNode2.SetValue("ICONCSSCLASS", "sx-tb-copy");
                } else if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) == 0) {
                    tbItemNode2.SetValue("IMAGE", "../sasrfex/images/default/icon_copy.png");
                }
                String strCopyTooltip = this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"GRIDVIEW", (String)"COPY"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"COPY"), "\u62f7\u8d1d%1$s");
                tbItemNode2.SetValue("TIPS", StringHelper.Format((String)strCopyTooltip, (Object)strObjectName));
                tbItemNode2.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.GridCopyHandler"));
            }
            if (bNewButton || bEditButton || bCopyButton) {
                DAConfigHelper.AddToolbarSeperator(tbItemsNode);
            }
            if (bRemoveButton && !bWFState) {
                tbItemNode2 = new XMLNode();
                tbItemNode2.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
                tbItemsNode.AddNode(tbItemNode2);
                if (StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
                    tbItemNode2.SetValue("ICONCSSCLASS", "sx-tb-delete");
                }
                if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) == 0) {
                    tbItemNode2.SetValue("IMAGE", "../sasrfex/images/default/icon_delete.png");
                }
                String strRemoveTooltip = this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"GRIDVIEW", (String)"REMOVE"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"REMOVE"), "\u5220\u9664%1$s");
                tbItemNode2.SetValue("TIPS", StringHelper.Format((String)strRemoveTooltip, (Object)strObjectName));
                tbItemNode2.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.GridRemoveHandler"));
                DAConfigHelper.AddToolbarSeperator(tbItemsNode);
            }
        } else if (bEditButton) {
            tbItemNode2 = new XMLNode();
            tbItemNode2.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
            tbItemsNode.AddNode(tbItemNode2);
            if (StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
                tbItemNode2.SetValue("ICONCSSCLASS", "sx-tb-edit");
            }
            if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) == 0) {
                tbItemNode2.SetValue("IMAGE", "../sasrfex/images/default/icon_edit.png");
            }
            if (bEditable) {
                String strEditFormat = this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"GRIDVIEW", (String)"EDIT"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"EDIT"), "\u7f16\u8f91");
                String strEditTipFormat = this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"GRIDVIEW", (String)"EDIT"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"EDIT"), "\u7f16\u8f91%1$s");
                tbItemNode2.SetValue(ToolbarButtonConfig.TAG_TEXT, strEditFormat);
                tbItemNode2.SetValue("TIPS", StringHelper.Format((String)strEditTipFormat, (Object)strObjectName));
            } else {
                String strViewFormat = this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"GRIDVIEW", (String)"VIEW"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"VIEW"), "\u67e5\u770b");
                String strViewTipFormat = this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"GRIDVIEW", (String)"VIEW"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"VIEW"), "\u67e5\u770b%1$s");
                tbItemNode2.SetValue(ToolbarButtonConfig.TAG_TEXT, strViewFormat);
                tbItemNode2.SetValue("TIPS", StringHelper.Format((String)strViewTipFormat, (Object)strObjectName));
            }
            tbItemNode2.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.GridEditHandler"));
            DAConfigHelper.AddToolbarSeperator(tbItemsNode);
        }
        if (bWFProcess && wfGetIAActionsResult != null && !StringHelper.IsNullOrEmpty((String)strWFStep)) {
            Object trButtonHandler;
            if (wfGetIAActionsResult.getIAActionList().size() > 0) {
                for (WFInteractiveActionConfig iaActionConfig : wfGetIAActionsResult.getIAActionList()) {
                    Page actionPage;
                    String strWFIAPAGE;
                    if (!iaActionConfig.isUserVisible()) continue;
                    tbItemNode = new XMLNode();
                    tbItemNode.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
                    tbItemsNode.AddNode(tbItemNode);
                    if (StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
                        tbItemNode.SetValue("ICONCSSCLASS", "sx-tb-commonaction");
                    }
                    if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) == 0) {
                        tbItemNode.SetValue("IMAGE", "../sasrfex/images/default/icon_gear.png");
                    }
                    tbItemNode.SetValue(ToolbarButtonConfig.TAG_TEXT, iaActionConfig.getLogicName());
                    tbItemNode.SetValue("TIPS", iaActionConfig.getLogicName());
                    tbItemNode.SetValue("WFIAACTIONLOGICNAME", iaActionConfig.getLogicName());
                    tbItemNode.SetValue("WFSTEP", strWFStep);
                    tbItemNode.SetValue("WFIAACTIONNAME", iaActionConfig.getName());
                    tbItemNode.SetValue("WFPROCESSNAME", wfGetIAActionsResult.getProcessName());
                    tbItemNode.SetValue("WFFORMNAME", iaActionConfig.getPanelId());
                    tbItemNode.SetValue("WFSUPPORTMULTI", iaActionConfig.isSupportMulti() ? "TRUE" : "FALSE");
                    trButtonHandler = "SA.SRFDA.WF.Ctrl.Toolbar.GridIAActionHandler";
                    if (!StringHelper.IsNullOrEmpty((String)iaActionConfig.getButtonActionHelper())) {
                        trButtonHandler = iaActionConfig.getButtonActionHelper();
                    }
                    tbItemNode.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, (String)trButtonHandler));
                    tbItemNode.SetValue("WFFAHELPER", iaActionConfig.getFAHelper());
                    tbItemNode.SetValue("WFIAPAGE", iaActionConfig.getPagePath());
                    tbItemNode.SetValue("WFIAPAGESTYLE", iaActionConfig.getPageStyle());
                    if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) != 0 && StringHelper.Compare((String)this.strPageModel, (String)"WinRT", (boolean)true) != 0 || StringHelper.IsNullOrEmpty((String)(strWFIAPAGE = iaActionConfig.getPagePath())) || strWFIAPAGE.indexOf(".jsp") != -1 || (actionPage = this.globalHelperEx.getDAModelStorage().FindPage(iaActionConfig.getPagePath())) == null) continue;
                    strWFIAPAGE = actionPage.GetTotalPagePath();
                    tbItemNode.SetValue("WFIAPAGE", strWFIAPAGE);
                    if (actionPage.getWIDTH() > 0) {
                        tbItemNode.SetValue("WFIAPAGEWIDTH", StringHelper.Format((String)"%1$s", (Object)actionPage.getWIDTH()));
                    }
                    if (actionPage.getHEIGHT() <= 0) continue;
                    tbItemNode.SetValue("WFIAPAGEHEIGHT", StringHelper.Format((String)"%1$s", (Object)actionPage.getHEIGHT()));
                }
                tbItemNode2 = new XMLNode();
                tbItemNode2.setNodeName(ToolbarSeperatorConfig.TAG_TOOLBARSEPARATOR);
                tbItemsNode.AddNode(tbItemNode2);
            }
            if (wfGetIAActionsResult.getUserActionList().size() > 0) {
                for (WFUserActionConfig userActionConfig : wfGetIAActionsResult.getUserActionList()) {
                    if (StringHelper.Compare((String)userActionConfig.getActionName(), (String)"DEBHGROUP", (boolean)true) == 0) {
                        toolbar.setDEBHGROUPID(userActionConfig.getReserver());
                        IToolbarItemWriter group1Writer = this.FindDEBHGroupToolbarItemWriter("1");
                        if (group1Writer == null) continue;
                        TBItemConfig tbItemConfig = new TBItemConfig();
                        tbItemConfig.setSeperator("NONE");
                        group1Writer.Export(rootNode, tbItemsNode, tbItemConfig, null, (IToolbarItemWriterContext)tbWriterContext, false);
                        continue;
                    }
                    tbItemNode = new XMLNode();
                    tbItemNode.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
                    tbItemsNode.AddNode(tbItemNode);
                    if (StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
                        tbItemNode.SetValue("ICONCSSCLASS", "sx-tb-commonaction");
                    }
                    if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) == 0) {
                        tbItemNode.SetValue("IMAGE", "../sasrfex/images/default/icon_gear.png");
                    }
                    tbItemNode.SetValue(ToolbarButtonConfig.TAG_TEXT, userActionConfig.getActionLogicName());
                    tbItemNode.SetValue("TIPS", userActionConfig.getActionLogicName());
                    tbItemNode.SetValue("WFUSERACTIONLOGICNAME", userActionConfig.getActionLogicName());
                    tbItemNode.SetValue("WFSTEP", strWFStep);
                    tbItemNode.SetValue("WFUSERACTIONNAME", userActionConfig.getActionName());
                    tbItemNode.SetValue("WFPROCESSNAME", wfGetIAActionsResult.getProcessName());
                    trButtonHandler = "";
                    if (StringHelper.Compare((String)userActionConfig.getActionName(), (String)WFACTION_RESUBMIT, (boolean)true) == 0) {
                        trButtonHandler = "SA.SRFDA.WF.Ctrl.Toolbar.GridResubmitActionHandler";
                        tbItemNode.SetValue("WFRESUBMIT", "TRUE");
                    } else if (StringHelper.Compare((String)userActionConfig.getActionName(), (String)WFACTION_REASSIGN, (boolean)true) == 0) {
                        trButtonHandler = "SA.SRFDA.WF.Ctrl.Toolbar.GridResubmitActionHandler";
                        tbItemNode.SetValue("WFRESUBMIT", "FALSE");
                    } else if (!StringHelper.IsNullOrEmpty((String)userActionConfig.getButtonActionHelper())) {
                        trButtonHandler = userActionConfig.getButtonActionHelper();
                    }
                    tbItemNode.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, (String)trButtonHandler));
                }
                tbItemNode2 = new XMLNode();
                tbItemNode2.setNodeName(ToolbarSeperatorConfig.TAG_TOOLBARSEPARATOR);
                tbItemsNode.AddNode(tbItemNode2);
            }
        }
        if ((bWFProcess || bWFState) && bRestartAction) {
            tbItemNode2 = new XMLNode();
            tbItemNode2.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
            tbItemsNode.AddNode(tbItemNode2);
            if (StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
                tbItemNode2.SetValue("ICONCSSCLASS", "sx-tb-restart");
            }
            if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) == 0) {
                tbItemNode2.SetValue("IMAGE", "../sasrfex/images/default/icon_restart.png");
            }
            String strRestartWFFormat = this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"WFGRIDVIEW", (String)"RESTARTWF"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"RESTARTWF"), "\u91cd\u542f\u6d41\u7a0b");
            String strRestartWFTipFormat = this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"WFGRIDVIEW", (String)"RESTARTWF"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"RESTARTWF"), "\u91cd\u542f\u6d41\u7a0b");
            tbItemNode2.SetValue(ToolbarButtonConfig.TAG_TEXT, strRestartWFFormat);
            tbItemNode2.SetValue("TIPS", strRestartWFTipFormat);
            tbItemNode2.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.GridCustomCallHandler"));
            tbItemNode2.SetValue("CALLID", "RESTARTWF");
            tbItemNode2.SetValue("CALLNAME", strRestartWFFormat);
        }
        if ((bWFProcess || bWFState) && bCancelAction) {
            tbItemNode2 = new XMLNode();
            tbItemNode2.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
            tbItemsNode.AddNode(tbItemNode2);
            if (StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
                tbItemNode2.SetValue("ICONCSSCLASS", "sx-tb-cancel");
            }
            if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) == 0) {
                tbItemNode2.SetValue("IMAGE", "../sasrfex/images/default/icon_cancel.png");
            }
            String strCancelWFFormat = this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"WFGRIDVIEW", (String)"CANCELWF"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"CANCELWF"), "\u53d6\u6d88");
            String strCancelWFTipFormat = this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"WFGRIDVIEW", (String)"CANCELWF"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"CANCELWF"), "\u53d6\u6d88\u6d41\u7a0b");
            tbItemNode2.SetValue(ToolbarButtonConfig.TAG_TEXT, strCancelWFFormat);
            tbItemNode2.SetValue("TIPS", strCancelWFTipFormat);
            tbItemNode2.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.GridCustomCallHandler"));
            tbItemNode2.SetValue("CALLID", "CANCELWF");
            tbItemNode2.SetValue("CALLNAME", strCancelWFFormat);
        }
        if ((bWFProcess || bWFState) && (bRestartAction || bCancelAction)) {
            DAConfigHelper.AddToolbarSeperator(tbItemsNode);
        }
        if (bEnableRowEdit) {
            if (bEditRowAction) {
                tbItemNode2 = new XMLNode();
                tbItemNode2.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
                tbItemsNode.AddNode(tbItemNode2);
                if (StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
                    tbItemNode2.SetValue("ICONCSSCLASS", "sx-tb-editrow");
                }
                if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) == 0) {
                    tbItemNode2.SetValue("IMAGE", "../sasrfex/images/default/icon_rowedit.png");
                }
                tbItemNode2.SetValue("TIPS", this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"GRIDVIEW", (String)"EDITROW"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"EDITROW"), "\u542f\u7528\u884c\u7f16\u8f91\u80fd\u529b"));
                tbItemNode2.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.GridRowEditableHandler"));
                tbItemNode2.SetValue("ENABLETOGGLE", "TRUE");
                tbItemNode2.SetValue("RESOURCEID", UniResHelper.GetDEDataResId((String)iDEHelper.getId(), (String)"UPDATE"));
            }
            if (bNewRowAction) {
                tbItemNode2 = new XMLNode();
                tbItemNode2.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
                tbItemsNode.AddNode(tbItemNode2);
                if (StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
                    tbItemNode2.SetValue("ICONCSSCLASS", "sx-tb-addrow");
                }
                if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) == 0) {
                    tbItemNode2.SetValue("IMAGE", "../sasrfex/images/default/icon_addrow.png");
                }
                tbItemNode2.SetValue("TIPS", this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"GRIDVIEW", (String)"NEWROW"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"NEWROW"), "\u65b0\u52a0\u884c"));
                tbItemNode2.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.GridNewRowHandler"));
                tbItemNode2.SetValue("RESOURCEID", UniResHelper.GetDEDataResId((String)iDEHelper.getId(), (String)"CREATE"));
            }
            if (StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
                tbItemNode2 = new XMLNode();
                tbItemNode2.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
                tbItemsNode.AddNode(tbItemNode2);
                if (StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
                    tbItemNode2.SetValue("ICONCSSCLASS", "sx-tb-saverow");
                }
                if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) == 0) {
                    tbItemNode2.SetValue("IMAGE", "../sasrfex/images/default/icon_rowsave.png");
                }
                tbItemNode2.SetValue("TIPS", this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"GRIDVIEW", (String)"SAVEROW"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"SAVEROW"), "\u4fdd\u5b58\u884c"));
                tbItemNode2.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.GridSaveRowHandler"));
                tbItemNode2.SetValue("RESOURCEID", UniResHelper.GetDEDataResId((String)iDEHelper.getId(), (String)"UPDATE"));
            }
            DAConfigHelper.AddToolbarSeperator(tbItemsNode);
        }
        if (bExportButton) {
            tbItemNode2 = new XMLNode();
            tbItemNode2.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
            tbItemsNode.AddNode(tbItemNode2);
            if (StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
                tbItemNode2.SetValue("ICONCSSCLASS", "sx-tb-export");
            }
            if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) == 0) {
                tbItemNode2.SetValue("IMAGE", "../sasrfex/images/default/icon_export.png");
            }
            String strExportTooltip = this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"GRIDVIEW", (String)"EXPORT"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"EXPORT"), "\u5bfc\u51fa%1$s\u5230Excel\u6587\u4ef6");
            tbItemNode2.SetValue("TIPS", StringHelper.Format((String)strExportTooltip, (Object)strObjectName));
            tbItemNode2.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.GridExportExcelHandler"));
            String strMaxRow = iDEHelper.GetProperty("MAXDOWNLOADROW", this.globalHelperEx.getWebExConfig().GetValue("SRFDA", "MAXDOWNLOADROW", "1000"));
            tbItemNode2.SetValue("MAXROW", strMaxRow);
        }
        if (bPrintAction) {
            tbItemNode2 = new XMLNode();
            tbItemNode2.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
            tbItemsNode.AddNode(tbItemNode2);
            if (StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
                tbItemNode2.SetValue("ICONCSSCLASS", "sx-tb-print");
            }
            if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) == 0) {
                tbItemNode2.SetValue("IMAGE", "../sasrfex/images/default/icon_print.png");
            }
            tbItemNode2.SetValue("TIPS", this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"GRIDVIEW", (String)"PRINT"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"PRINT"), "\u6253\u5370\u5f53\u524d\u6570\u636e"));
            tbItemNode2.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.GridPrintHandler"));
        }
        if (bExportButton || bPrintAction) {
            tbItemNode2 = new XMLNode();
            tbItemNode2.setNodeName(ToolbarSeperatorConfig.TAG_TOOLBARSEPARATOR);
            tbItemsNode.AddNode(tbItemNode2);
        }
        XMLNode userOtherAction = null;
        if (userToolbar != null && userToolbar.getChildNodes() != null) {
            boolean bAppendSeperator = false;
            for (XMLNode child : userToolbar.getChildNodes()) {
                String strID = child.getID();
                if (StringHelper.Compare((String)strID, (String)TAG_OTHERACTION, (boolean)true) != 0) {
                    if (StringHelper.Compare((String)child.getNodeName(), (String)"SRFDATBITEM", (boolean)true) == 0) {
                        bAppendSeperator = true;
                        this.ExportTBItem(rootNode, tbItemsNode, child, false, tbWriterContext, false);
                        continue;
                    }
                    int nPos = child.GetExtValue(TAG_POS, -1);
                    if (nPos == -1) {
                        bAppendSeperator = true;
                        tbItemsNode.AddNode(child);
                        continue;
                    }
                    tbItemsNode.AddNode(nPos, child);
                    continue;
                }
                userOtherAction = child;
            }
            if (bAppendSeperator) {
                tbItemNode = new XMLNode();
                tbItemNode.setNodeName(ToolbarSeperatorConfig.TAG_TOOLBARSEPARATOR);
                tbItemsNode.AddNode(tbItemNode);
            }
        }
        if (bOtherAction) {
            XMLNode tbItemNode3 = new XMLNode();
            tbItemNode3.setNodeName(ToolbarSplitButtonConfig.TAG_TOOLBARSPLITBUTTON);
            tbItemNode3.SetValue(ToolbarButtonConfig.TAG_TEXT, this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"GRIDVIEW", (String)"OTHER"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"OTHER"), "\u5176\u5b83"));
            tbItemNode3.SetValue("ICONCSSCLASS", "sx-tb-other");
            tbItemsNode.AddNode(tbItemNode3);
            XMLNode tbMenusNode = new XMLNode();
            tbMenusNode.setNodeName("SRFEXMAINMENUEX");
            tbItemNode3.AddNode(tbMenusNode);
            if (userOtherAction != null && userOtherAction.getChildNodes() != null) {
                for (XMLNode child : userOtherAction.getChildNodes()) {
                    if (StringHelper.Compare((String)child.getNodeName(), (String)"SRFDATBITEM", (boolean)true) == 0) {
                        this.ExportTBItem(rootNode, tbMenusNode, child, false, tbWriterContext, true);
                        continue;
                    }
                    tbMenusNode.AddNode(child);
                }
            }
            if (tbMenusNode.getChildNodes() == null || tbMenusNode.getChildNodes().size() == 0) {
                tbItemsNode.RemoveNode(tbItemNode3);
            } else {
                DAConfigHelper.AddToolbarSeperator(tbItemsNode);
            }
        }
        if (bSearchBar && StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
            XMLNode tbItemNode4 = new XMLNode();
            tbItemNode4.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
            tbItemsNode.AddNode(tbItemNode4);
            tbItemNode4.SetValue("ICONCSSCLASS", "sx-tb-filter");
            tbItemNode4.SetValue("TIPS", this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"GRIDVIEW", (String)"FILTER"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"FILTER"), "\u8fdb\u4e00\u6b65\u641c\u7d22\u6570\u636e"));
            tbItemNode4.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.SPShowHideHandler"));
            DAConfigHelper.AddToolbarSeperator(tbItemsNode);
        }
        if (bHelpAction) {
            XMLNode tbItemNode5 = new XMLNode();
            tbItemNode5.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
            tbItemsNode.AddNode(tbItemNode5);
            if (StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
                tbItemNode5.SetValue("ICONCSSCLASS", "sx-tb-help");
            }
            if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) == 0) {
                tbItemNode5.SetValue("IMAGE", "../sasrfex/images/default/icon_help16.png");
            }
            tbItemNode5.SetValue("TIPS", this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"GRIDVIEW", (String)"HELP"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"HELP"), "\u5e2e\u52a9"));
            tbItemNode5.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.HelpHandler"));
            tbItemNode5.SetValue("PAGETYPE", "WFGRIDVIEW");
        }
        DAConfigHelper.EraseToolbarUnnecessarySeperator(rootNode);
        if (!DAConfigHelper.ExportConfigFile((XMLNode)rootNode, (String)strTBFilePath)) {
            return "";
        }
        return strToolbarConfigId;
    }

    public String GetWFMgrGridViewToolbarConfigId(IDEHelper iDEHelper, Page page, DataGrid dataGrid) {
        XMLNode tbItemNode;
        String strToolbarConfigId = "";
        strToolbarConfigId = page == null ? StringHelper.Format((String)"DE%1$s.TB_GRID_%4$s_%2$s_%3$s", (Object)iDEHelper.getId(), (Object)iDEHelper.getVersion(), (Object)dataGrid.getDGVERSION(), (Object)"WFMGR") : StringHelper.Format((String)"DE%1$s.TB_%5$s_%6$s_GRID_%4$s_%2$s_%3$s", (Object)iDEHelper.getId(), (Object)iDEHelper.getVersion(), (Object)dataGrid.getDGVERSION(), (Object)"WFMGR", (Object)page.getPAGEID(), (Object)page.getVERSION());
        if (!StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
            strToolbarConfigId = String.valueOf(strToolbarConfigId) + StringHelper.Format((String)"_PM_%1$s", (Object)this.strPageModel);
        }
        if (!StringHelper.IsNullOrEmpty((String)this.strLanguage)) {
            strToolbarConfigId = String.valueOf(strToolbarConfigId) + StringHelper.Format((String)"_%1$s", (Object)this.strLanguage);
        }
        strToolbarConfigId = strToolbarConfigId.toUpperCase();
        String strTBFilePath = ConfigPathHelper.GetRuntimeToolbarConfigPath((String)this.globalHelperEx.GetAppRootPath(), (String)strToolbarConfigId);
        File file = new File(strTBFilePath);
        if (file.exists()) {
            return strToolbarConfigId;
        }
        DefaultToolbarWriterContext tbWriterContext = this.CreateTBWriterContext();
        tbWriterContext.setPage(page);
        tbWriterContext.setDEHelper(iDEHelper);
        tbWriterContext.setViewStyle("GRIDVIEW");
        XMLNode rootNode = new XMLNode();
        rootNode.setNodeName("SRFEXTOOLBAR");
        XMLNode tbItemsNode = new XMLNode();
        tbItemsNode.setNodeName(ToolbarItemsConfig.TAG_TOOLBARITEMS);
        rootNode.AddNode(tbItemsNode);
        XMLNode userToolbar = null;
        String strToolbarXML = dataGrid.getDGTOOLBAR();
        if (StringHelper.IsNullOrEmpty((String)strToolbarXML)) {
            if (page != null) {
                String strPageToolbar = page.getTOOLBAR();
                String strPTToolbar = page.getPTTOOLBAR();
                if (!StringHelper.IsNullOrEmpty((String)strPTToolbar)) {
                    if (userToolbar == null) {
                        userToolbar = new XMLNode();
                    }
                    XMLNode.LoadFromXML((String)strPTToolbar, (XMLConfig)userToolbar);
                }
                if (!StringHelper.IsNullOrEmpty((String)strPageToolbar)) {
                    if (userToolbar == null) {
                        userToolbar = new XMLNode();
                    }
                    XMLNode.LoadFromXML((String)strPageToolbar, (XMLConfig)userToolbar);
                }
            }
        } else {
            userToolbar = XMLNode.LoadFromXML((String)strToolbarXML);
        }
        boolean bCancelAction = true;
        boolean bRestartAction = true;
        boolean bOtherAction = true;
        boolean bSearchBar = true;
        boolean bIAGotoAction = true;
        boolean bHelpAction = iDEHelper.IsEnableHelp();
        if (userToolbar != null) {
            bCancelAction = userToolbar.GetExtValue(TAG_CANCELACTION, bCancelAction);
            bRestartAction = userToolbar.GetExtValue(TAG_RESTARTACTION, bRestartAction);
            bOtherAction = userToolbar.GetExtValue(TAG_OTHERACTION, bOtherAction);
            bSearchBar = userToolbar.GetExtValue(TAG_SEARCHBARACTION, bSearchBar);
            bIAGotoAction = userToolbar.GetExtValue(TAG_IAGOTOACTION, bIAGotoAction);
            bHelpAction = userToolbar.GetExtValue(TAG_HELPACTION, bHelpAction);
        }
        if (bIAGotoAction) {
            tbItemNode = new XMLNode();
            tbItemNode.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
            tbItemsNode.AddNode(tbItemNode);
            tbItemNode.SetValue("ICONCSSCLASS", "sx-tb-return");
            tbItemNode.SetValue(ToolbarButtonConfig.TAG_TEXT, "\u6b65\u9aa4\u91cd\u5b9a\u5411");
            tbItemNode.SetValue("TIPS", "\u6d41\u7a0b\u6b65\u9aa4\u91cd\u5b9a\u5411");
            tbItemNode.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.WF.Ctrl.Toolbar.GridIAGotoHandler"));
        }
        if (bRestartAction) {
            tbItemNode = new XMLNode();
            tbItemNode.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
            tbItemsNode.AddNode(tbItemNode);
            tbItemNode.SetValue("ICONCSSCLASS", "sx-tb-restart");
            tbItemNode.SetValue(ToolbarButtonConfig.TAG_TEXT, "\u91cd\u542f\u6d41\u7a0b");
            tbItemNode.SetValue("TIPS", "\u91cd\u542f\u6d41\u7a0b");
            tbItemNode.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.GridCustomCallHandler"));
            tbItemNode.SetValue("CALLID", "RESTARTWF");
            tbItemNode.SetValue("CALLNAME", "\u91cd\u542f\u6d41\u7a0b");
        }
        if (bCancelAction) {
            tbItemNode = new XMLNode();
            tbItemNode.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
            tbItemsNode.AddNode(tbItemNode);
            tbItemNode.SetValue("ICONCSSCLASS", "sx-tb-cancel");
            tbItemNode.SetValue(ToolbarButtonConfig.TAG_TEXT, "\u53d6\u6d88\u6d41\u7a0b");
            tbItemNode.SetValue("TIPS", "\u53d6\u6d88\u6d41\u7a0b");
            tbItemNode.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.GridCustomCallHandler"));
            tbItemNode.SetValue("CALLID", "CANCELWF");
            tbItemNode.SetValue("CALLNAME", "\u53d6\u6d88\u6d41\u7a0b");
        }
        if (bRestartAction || bCancelAction) {
            DAConfigHelper.AddToolbarSeperator(tbItemsNode);
        }
        XMLNode userOtherAction = null;
        if (userToolbar != null && userToolbar.getChildNodes() != null) {
            boolean bAppendSeperator = false;
            for (XMLNode child : userToolbar.getChildNodes()) {
                String strID = child.getID();
                if (StringHelper.Compare((String)strID, (String)TAG_OTHERACTION, (boolean)true) != 0) {
                    if (StringHelper.Compare((String)child.getNodeName(), (String)"SRFDATBITEM", (boolean)true) == 0) {
                        bAppendSeperator = true;
                        this.ExportTBItem(rootNode, tbItemsNode, child, false, tbWriterContext, false);
                        continue;
                    }
                    int nPos = child.GetExtValue(TAG_POS, -1);
                    if (nPos == -1) {
                        tbItemsNode.AddNode(child);
                        bAppendSeperator = true;
                        continue;
                    }
                    tbItemsNode.AddNode(nPos, child);
                    continue;
                }
                userOtherAction = child;
            }
            if (bAppendSeperator) {
                DAConfigHelper.AddToolbarSeperator(tbItemsNode);
            }
        }
        if (bOtherAction) {
            XMLNode tbItemNode2 = new XMLNode();
            tbItemNode2.setNodeName(ToolbarSplitButtonConfig.TAG_TOOLBARSPLITBUTTON);
            tbItemNode2.SetValue(ToolbarButtonConfig.TAG_TEXT, "\u5176\u5b83");
            tbItemNode2.SetValue("ICONCSSCLASS", "sx-tb-other");
            tbItemsNode.AddNode(tbItemNode2);
            XMLNode tbMenusNode = new XMLNode();
            tbMenusNode.setNodeName("SRFEXMAINMENUEX");
            tbItemNode2.AddNode(tbMenusNode);
            if (userOtherAction != null && userOtherAction.getChildNodes() != null) {
                for (XMLNode child : userOtherAction.getChildNodes()) {
                    if (StringHelper.Compare((String)child.getNodeName(), (String)"SRFDATBITEM", (boolean)true) == 0) {
                        this.ExportTBItem(rootNode, tbMenusNode, child, false, tbWriterContext, true);
                        continue;
                    }
                    tbMenusNode.AddNode(child);
                }
            }
            if (tbMenusNode.getChildNodes() == null || tbMenusNode.getChildNodes().size() == 0) {
                tbItemsNode.RemoveNode(tbItemNode2);
            } else {
                DAConfigHelper.AddToolbarSeperator(tbItemsNode);
            }
        }
        if (bSearchBar && StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
            XMLNode tbItemNode3 = new XMLNode();
            tbItemNode3.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
            tbItemsNode.AddNode(tbItemNode3);
            tbItemNode3.SetValue("ICONCSSCLASS", "sx-tb-filter");
            tbItemNode3.SetValue(ToolbarButtonConfig.TAG_TEXT, "\u8fc7\u6ee4");
            tbItemNode3.SetValue("TIPS", "\u8fdb\u4e00\u6b65\u641c\u7d22\u6570\u636e");
            tbItemNode3.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.SPShowHideHandler"));
        }
        if (bSearchBar && StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
            XMLNode tbItemNode4 = new XMLNode();
            tbItemNode4.setNodeName(ToolbarSeperatorConfig.TAG_TOOLBARSEPARATOR);
            tbItemsNode.AddNode(tbItemNode4);
        }
        if (bHelpAction) {
            XMLNode tbItemNode5 = new XMLNode();
            tbItemNode5.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
            tbItemsNode.AddNode(tbItemNode5);
            tbItemNode5.SetValue("ICONCSSCLASS", "sx-tb-help");
            tbItemNode5.SetValue("TIPS", "\u5e2e\u52a9");
            tbItemNode5.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.HelpHandler"));
            tbItemNode5.SetValue("PAGETYPE", "WFMGRGRIDVIEW");
        }
        if (!DAConfigHelper.ExportConfigFile((XMLNode)rootNode, (String)strTBFilePath)) {
            return "";
        }
        return strToolbarConfigId;
    }

    public String GetWFInfoViewToolbarConfigId(IDEHelper iDEHelper, Page page, String strWFState, String strWFStep, boolean bEnableSave, WFGetIAActionsResult wfGetIAActionsResult) {
        XMLNode tbItemNode;
        boolean bViewWFStepData;
        String strToolbarConfigId = StringHelper.Format((String)"DE%1$s.TB_INFOFORM_%3$s_%4$s_%5$s_%6$s_%7$s_%2$s", (Object)iDEHelper.getId(), (Object)iDEHelper.getVersion(), (Object)"WF", (Object)strWFState, (Object)strWFStep, (Object)(wfGetIAActionsResult != null ? wfGetIAActionsResult.getVersion() : 0), (Object)(bEnableSave ? "1" : "0"));
        if (wfGetIAActionsResult != null && !StringHelper.IsNullOrEmpty((String)wfGetIAActionsResult.getUserTag())) {
            strToolbarConfigId = String.valueOf(strToolbarConfigId) + StringHelper.Format((String)"_%1$s", (Object)wfGetIAActionsResult.getUserTag());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
            strToolbarConfigId = String.valueOf(strToolbarConfigId) + StringHelper.Format((String)"_PM_%1$s", (Object)this.strPageModel);
        }
        if (!StringHelper.IsNullOrEmpty((String)this.strLanguage)) {
            strToolbarConfigId = String.valueOf(strToolbarConfigId) + StringHelper.Format((String)"_%1$s", (Object)this.strLanguage);
        }
        strToolbarConfigId = strToolbarConfigId.replace(":", "__");
        strToolbarConfigId = strToolbarConfigId.toUpperCase();
        String strTBFilePath = ConfigPathHelper.GetRuntimeToolbarConfigPath((String)this.globalHelperEx.GetAppRootPath(), (String)strToolbarConfigId);
        File file = new File(strTBFilePath);
        if (file.exists()) {
            return strToolbarConfigId;
        }
        DefaultToolbarWriterContext tbWriterContext = this.CreateTBWriterContext();
        tbWriterContext.setPage(page);
        tbWriterContext.setDEHelper(iDEHelper);
        tbWriterContext.setViewStyle("EDITVIEW");
        tbWriterContext.setWFGetIAActionsResult(wfGetIAActionsResult);
        XMLNode rootNode = new XMLNode();
        rootNode.setNodeName("SRFEXTOOLBAR");
        XMLNode tbItemsNode = new XMLNode();
        tbItemsNode.setNodeName(ToolbarItemsConfig.TAG_TOOLBARITEMS);
        rootNode.AddNode(tbItemsNode);
        Toolbar toolbar = null;
        if (page != null) {
            String strToolbarId = page.getTOOLBARID();
            if (!StringHelper.IsNullOrEmpty((String)strToolbarId) && (toolbar = this.globalHelperEx.getDAModelStorage().FindToolbar(strToolbarId)) == null) {
                log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5de5\u5177\u680f[%1$s]\u914d\u7f6e", (Object)strToolbarId));
                return "";
            }
            String strTBTEMPLID = "";
            if (toolbar != null) {
                strTBTEMPLID = toolbar.getTBTEMPLID();
            }
            if (StringHelper.IsNullOrEmpty((String)strTBTEMPLID)) {
                strTBTEMPLID = page.GetParamStringValue("TBTEMPLID", "");
            }
            ToolbarConfig tbConfig = null;
            if (StringHelper.IsNullOrEmpty((String)strTBTEMPLID)) {
                if (toolbar != null && toolbar.getNODEFAULT()) {
                    tbConfig = toolbar.getToolbarConfig();
                }
            } else {
                TBTempl tbTempl = this.globalHelperEx.getDAModelStorage().FindTBTempl(strTBTEMPLID);
                if (tbTempl == null) {
                    log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5de5\u5177\u680f\u6a21\u677f[%1$s]\u914d\u7f6e", (Object)strTBTEMPLID));
                    return "";
                }
                tbConfig = tbTempl.getToolbarConfig();
            }
            if (tbConfig != null) {
                tbWriterContext.setToolbar(toolbar);
                CallResult callResult = this.ExportToolbar(rootNode, tbItemsNode, tbConfig, tbWriterContext);
                if (callResult.IsError()) {
                    log.error((Object)StringHelper.Format((String)"\u5bfc\u51fa\u5de5\u5177\u680f\u53d1\u751f\u9519\u8bef,%1$s", (Object)callResult.getErrorInfo()));
                    return "";
                }
                if (!DAConfigHelper.ExportConfigFile((XMLNode)rootNode, (String)strTBFilePath)) {
                    return "";
                }
                return strToolbarConfigId;
            }
        }
        XMLNode userToolbar = null;
        String strToolbarXML = "";
        userToolbar = DAConfigHelper.LoadToolbarConfig(strToolbarXML, page);
        boolean bOtherAction = true;
        boolean bPrintAction = iDEHelper.IsEnablePrint();
        boolean bHelpAction = iDEHelper.IsEnableHelp();
        boolean bViewWFStepActor = this.getWFStepActorPlacement() == 1;
        boolean bl = bViewWFStepData = this.getWFStepDataPlacement() == 1;
        if (toolbar != null) {
            tbWriterContext.setToolbar(toolbar);
            if (!toolbar.isHELPACTIONNull()) {
                bHelpAction = toolbar.getHELPACTION();
            }
            if (!toolbar.isOTHERACTIONNull()) {
                bOtherAction = toolbar.getOTHERACTION();
            }
            if (!toolbar.isPRINTACTIONNull()) {
                bPrintAction = toolbar.getPRINTACTION();
            }
        } else {
            toolbar = new Toolbar();
            toolbar.setNODEFDEBHGROUP(true);
            tbWriterContext.setToolbar(toolbar);
        }
        if (userToolbar != null) {
            bHelpAction = userToolbar.GetExtValue(TAG_HELPACTION, bHelpAction);
            bPrintAction = userToolbar.GetExtValue(TAG_PRINTACTION, bPrintAction);
            bOtherAction = userToolbar.GetExtValue(TAG_OTHERACTION, bOtherAction);
            bViewWFStepActor = userToolbar.GetExtValue(TAG_VIEWWFSTEPACTOR, bViewWFStepActor);
            bViewWFStepData = userToolbar.GetExtValue(TAG_VIEWWFSTEPDATA, bViewWFStepData);
        }
        if (StringHelper.Compare((String)strWFState, (String)"WFNOTFINISH", (boolean)true) == 0) {
            boolean bSaveAsIAAction = iDEHelper.GetDEWF().GetWFParam("WFINFOPAGE.SAVEASIAACTION", false);
            if (!StringHelper.IsNullOrEmpty((String)strWFStep)) {
                XMLNode tbItemNode2;
                if (bEnableSave || bSaveAsIAAction) {
                    tbItemNode = new XMLNode();
                    tbItemNode.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
                    tbItemsNode.AddNode(tbItemNode);
                    if (StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
                        tbItemNode.SetValue("ICONCSSCLASS", "sx-tb-save");
                    }
                    if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) == 0) {
                        tbItemNode.SetValue("IMAGE", "../sasrfex/images/default/icon_save.png");
                    }
                    tbItemNode.SetValue(ToolbarButtonConfig.TAG_TEXT, this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"EDITVIEW", (String)"SAVE"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"SAVE"), "\u4fdd\u5b58"));
                    tbItemNode.SetValue("TIPS", this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"EDITVIEW", (String)"SAVE"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"SAVE"), "\u4fdd\u5b58\u5f53\u524d\u6570\u636e"));
                    if (bSaveAsIAAction) {
                        tbItemNode.SetValue("SAVEANDCLOSE", "TRUE");
                    }
                    tbItemNode.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.FormSaveHandler"));
                    DAConfigHelper.AddToolbarSeperator(tbItemsNode);
                }
                if (!bSaveAsIAAction && wfGetIAActionsResult.getIAActionList().size() > 0) {
                    for (WFInteractiveActionConfig iaActionConfig : wfGetIAActionsResult.getIAActionList()) {
                        Page actionPage;
                        String strWFIAPAGE;
                        if (!iaActionConfig.isUserVisible()) continue;
                        tbItemNode2 = new XMLNode();
                        tbItemNode2.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
                        tbItemsNode.AddNode(tbItemNode2);
                        if (StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
                            tbItemNode2.SetValue("ICONCSSCLASS", "sx-tb-commonaction");
                        }
                        if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) == 0) {
                            tbItemNode2.SetValue("IMAGE", "../sasrfex/images/default/icon_gear.png");
                        }
                        tbItemNode2.SetValue(ToolbarButtonConfig.TAG_TEXT, iaActionConfig.getLogicName());
                        tbItemNode2.SetValue("TIPS", iaActionConfig.getLogicName());
                        tbItemNode2.SetValue("WFSTATE", strWFState);
                        tbItemNode2.SetValue("WFSTEP", strWFStep);
                        tbItemNode2.SetValue("WFIAACTIONNAME", iaActionConfig.getName());
                        tbItemNode2.SetValue("WFPROCESSNAME", wfGetIAActionsResult.getProcessName());
                        tbItemNode2.SetValue("WFFORMNAME", iaActionConfig.getPanelId());
                        tbItemNode2.SetValue("WFFAHELPER", iaActionConfig.getFAHelper());
                        tbItemNode2.SetValue("WFIAPAGE", iaActionConfig.getPagePath());
                        tbItemNode2.SetValue("WFIAPAGESTYLE", iaActionConfig.getPageStyle());
                        tbItemNode2.SetValue("WFENABLESAVE", bEnableSave ? "TRUE" : "FALSE");
                        if (!(StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) != 0 && StringHelper.Compare((String)this.strPageModel, (String)"WinRT", (boolean)true) != 0 || StringHelper.IsNullOrEmpty((String)(strWFIAPAGE = iaActionConfig.getPagePath())) || strWFIAPAGE.indexOf(".jsp") != -1 || (actionPage = this.globalHelperEx.getDAModelStorage().FindPage(iaActionConfig.getPagePath())) == null)) {
                            strWFIAPAGE = actionPage.GetTotalPagePath();
                            tbItemNode2.SetValue("WFIAPAGE", strWFIAPAGE);
                            if (actionPage.getWIDTH() > 0) {
                                tbItemNode2.SetValue("WFIAPAGEWIDTH", StringHelper.Format((String)"%1$s", (Object)actionPage.getWIDTH()));
                            }
                            if (actionPage.getHEIGHT() > 0) {
                                tbItemNode2.SetValue("WFIAPAGEHEIGHT", StringHelper.Format((String)"%1$s", (Object)actionPage.getHEIGHT()));
                            }
                        }
                        tbItemNode2.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.WF.Ctrl.Toolbar.FormIAActionHandler"));
                    }
                    tbItemNode = new XMLNode();
                    tbItemNode.setNodeName(ToolbarSeperatorConfig.TAG_TOOLBARSEPARATOR);
                    tbItemsNode.AddNode(tbItemNode);
                }
                if (!bSaveAsIAAction && wfGetIAActionsResult.getUserActionList().size() > 0) {
                    for (WFUserActionConfig userActionConfig : wfGetIAActionsResult.getUserActionList()) {
                        if (StringHelper.Compare((String)userActionConfig.getActionName(), (String)"DEBHGROUP", (boolean)true) == 0) {
                            toolbar.setDEBHGROUPID(userActionConfig.getReserver());
                            IToolbarItemWriter group1Writer = this.FindDEBHGroupToolbarItemWriter("1");
                            if (group1Writer == null) continue;
                            TBItemConfig tbItemConfig = new TBItemConfig();
                            tbItemConfig.setSeperator("NONE");
                            group1Writer.Export(rootNode, tbItemsNode, tbItemConfig, null, (IToolbarItemWriterContext)tbWriterContext, false);
                            continue;
                        }
                        tbItemNode2 = new XMLNode();
                        tbItemNode2.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
                        tbItemsNode.AddNode(tbItemNode2);
                        if (StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
                            tbItemNode2.SetValue("ICONCSSCLASS", "sx-tb-commonaction");
                        }
                        if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) == 0) {
                            tbItemNode2.SetValue("IMAGE", "../sasrfex/images/default/icon_gear.png");
                        }
                        tbItemNode2.SetValue(ToolbarButtonConfig.TAG_TEXT, userActionConfig.getActionLogicName());
                        tbItemNode2.SetValue("TIPS", userActionConfig.getActionLogicName());
                        tbItemNode2.SetValue("WFUSERACTIONLOGICNAME", userActionConfig.getActionLogicName());
                        tbItemNode2.SetValue("WFSTEP", strWFStep);
                        tbItemNode2.SetValue("WFUSERACTIONNAME", userActionConfig.getActionName());
                        tbItemNode2.SetValue("WFPROCESSNAME", wfGetIAActionsResult.getProcessName());
                        String trButtonHandler = "";
                        if (StringHelper.Compare((String)userActionConfig.getActionName(), (String)WFACTION_RESUBMIT, (boolean)true) == 0) {
                            trButtonHandler = "SA.SRFDA.WF.Ctrl.Toolbar.FormResubmitActionHandler";
                            tbItemNode2.SetValue("WFRESUBMIT", "TRUE");
                        } else if (StringHelper.Compare((String)userActionConfig.getActionName(), (String)WFACTION_REASSIGN, (boolean)true) == 0) {
                            trButtonHandler = "SA.SRFDA.WF.Ctrl.Toolbar.FormResubmitActionHandler";
                            tbItemNode2.SetValue("WFRESUBMIT", "FALSE");
                        } else if (!StringHelper.IsNullOrEmpty((String)userActionConfig.getButtonActionHelper())) {
                            trButtonHandler = userActionConfig.getButtonActionHelper();
                        }
                        tbItemNode2.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, trButtonHandler));
                    }
                    tbItemNode = new XMLNode();
                    tbItemNode.setNodeName(ToolbarSeperatorConfig.TAG_TOOLBARSEPARATOR);
                    tbItemsNode.AddNode(tbItemNode);
                }
            }
        }
        if (bViewWFStepActor || bViewWFStepData) {
            String strWFIAPAGE;
            Page actionPage;
            Object strTextTip;
            String strText;
            if (bViewWFStepData) {
                String strWFStepDataPageId = this.OnGetWFStepDataGridViewPage();
                tbItemNode = new XMLNode();
                tbItemNode.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
                tbItemsNode.AddNode(tbItemNode);
                if (StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
                    tbItemNode.SetValue("ICONCSSCLASS", "sx-tb-stepdata");
                }
                if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) == 0) {
                    tbItemNode.SetValue("IMAGE", "../sasrfex/images/default/icon_stepactor.png");
                }
                strText = this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"EDITVIEW", (String)TAG_VIEWWFSTEPDATA), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)TAG_VIEWWFSTEPDATA), "\u6d41\u7a0b\u5904\u7406\u6b65\u9aa4");
                strTextTip = this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"EDITVIEW", (String)TAG_VIEWWFSTEPDATA), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)TAG_VIEWWFSTEPDATA), "\u6d41\u7a0b\u5904\u7406\u6b65\u9aa4");
                tbItemNode.SetValue(ToolbarButtonConfig.TAG_TEXT, strText);
                tbItemNode.SetValue("TIPS", (String)strTextTip);
                tbItemNode.SetValue("WFIAPAGE", strWFStepDataPageId);
                if (!StringHelper.IsNullOrEmpty((String)this.getPageModel()) && (actionPage = this.globalHelperEx.getDAModelStorage().FindPage(strWFStepDataPageId)) != null) {
                    strWFIAPAGE = actionPage.GetTotalPagePath();
                    tbItemNode.SetValue("WFIAPAGE", strWFIAPAGE);
                    if (actionPage.getWIDTH() > 0) {
                        tbItemNode.SetValue("WFIAPAGEWIDTH", StringHelper.Format((String)"%1$s", (Object)actionPage.getWIDTH()));
                    }
                    if (actionPage.getHEIGHT() > 0) {
                        tbItemNode.SetValue("WFIAPAGEHEIGHT", StringHelper.Format((String)"%1$s", (Object)actionPage.getHEIGHT()));
                    }
                }
                tbItemNode.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.WF.Ctrl.Toolbar.FormViewWFStepDataHandler"));
            }
            if (bViewWFStepActor) {
                String strWFStepActorPageId = this.OnGetWFStepActorGridViewPage();
                tbItemNode = new XMLNode();
                tbItemNode.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
                tbItemsNode.AddNode(tbItemNode);
                if (StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
                    tbItemNode.SetValue("ICONCSSCLASS", "sx-tb-stepactor");
                }
                if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) == 0) {
                    tbItemNode.SetValue("IMAGE", "../sasrfex/images/default/icon_stepactor.png");
                }
                strText = this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"EDITVIEW", (String)"VIEWWFSTEP"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"VIEWWFSTEP"), "\u5f53\u524d\u6d41\u7a0b\u6b65\u9aa4");
                strTextTip = this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"EDITVIEW", (String)"VIEWWFSTEP"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"VIEWWFSTEP"), "\u5f53\u524d\u6d41\u7a0b\u6b65\u9aa4");
                tbItemNode.SetValue(ToolbarButtonConfig.TAG_TEXT, strText);
                tbItemNode.SetValue("TIPS", (String)strTextTip);
                tbItemNode.SetValue("WFIAPAGE", strWFStepActorPageId);
                if (!StringHelper.IsNullOrEmpty((String)this.getPageModel()) && (actionPage = this.globalHelperEx.getDAModelStorage().FindPage(strWFStepActorPageId)) != null) {
                    strWFIAPAGE = actionPage.GetTotalPagePath();
                    tbItemNode.SetValue("WFIAPAGE", strWFIAPAGE);
                    if (actionPage.getWIDTH() > 0) {
                        tbItemNode.SetValue("WFIAPAGEWIDTH", StringHelper.Format((String)"%1$s", (Object)actionPage.getWIDTH()));
                    }
                    if (actionPage.getHEIGHT() > 0) {
                        tbItemNode.SetValue("WFIAPAGEHEIGHT", StringHelper.Format((String)"%1$s", (Object)actionPage.getHEIGHT()));
                    }
                }
                tbItemNode.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.WF.Ctrl.Toolbar.FormViewWFStepActorHandler"));
            }
            DAConfigHelper.AddToolbarSeperator(tbItemsNode);
        }
        if (bPrintAction) {
            XMLNode tbItemNode3 = new XMLNode();
            tbItemNode3.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
            tbItemsNode.AddNode(tbItemNode3);
            if (StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
                tbItemNode3.SetValue("ICONCSSCLASS", "sx-tb-print");
            }
            if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) == 0) {
                tbItemNode3.SetValue("IMAGE", "../sasrfex/images/default/icon_print.png");
            }
            tbItemNode3.SetValue(ToolbarButtonConfig.TAG_TEXT, this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"INFOVIEW", (String)"PRINT"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"PRINT"), "\u6253\u5370"));
            tbItemNode3.SetValue("TIPS", this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"INFOVIEW", (String)"PRINT"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"PRINT"), "\u6253\u5370\u5f53\u524d\u6570\u636e"));
            tbItemNode3.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.FormPrintHandler"));
        }
        if (bPrintAction) {
            XMLNode tbItemNode4 = new XMLNode();
            tbItemNode4.setNodeName(ToolbarSeperatorConfig.TAG_TOOLBARSEPARATOR);
            tbItemsNode.AddNode(tbItemNode4);
        }
        XMLNode userOtherAction = null;
        if (userToolbar != null && userToolbar.getChildNodes() != null) {
            boolean bAppendSeperator = false;
            for (XMLNode child : userToolbar.getChildNodes()) {
                String strID = child.getID();
                if (StringHelper.Compare((String)strID, (String)TAG_OTHERACTION, (boolean)true) != 0) {
                    if (StringHelper.Compare((String)child.getNodeName(), (String)"SRFDATBITEM", (boolean)true) == 0) {
                        bAppendSeperator = true;
                        this.ExportTBItem(rootNode, tbItemsNode, child, false, tbWriterContext, false);
                        continue;
                    }
                    int nPos = child.GetExtValue(TAG_POS, -1);
                    if (nPos == -1) {
                        bAppendSeperator = true;
                        tbItemsNode.AddNode(child);
                        continue;
                    }
                    tbItemsNode.AddNode(nPos, child);
                    continue;
                }
                userOtherAction = child;
            }
            if (bAppendSeperator) {
                XMLNode tbItemNode5 = new XMLNode();
                tbItemNode5.setNodeName(ToolbarSeperatorConfig.TAG_TOOLBARSEPARATOR);
                tbItemsNode.AddNode(tbItemNode5);
            }
        }
        if (bOtherAction) {
            XMLNode tbItemNode6 = new XMLNode();
            tbItemNode6.setNodeName(ToolbarSplitButtonConfig.TAG_TOOLBARSPLITBUTTON);
            tbItemNode6.SetValue(ToolbarButtonConfig.TAG_TEXT, this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"EDITVIEW", (String)"OTHER"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"OTHER"), "\u5176\u5b83"));
            tbItemNode6.SetValue("ICONCSSCLASS", "sx-tb-other");
            tbItemsNode.AddNode(tbItemNode6);
            XMLNode tbMenusNode = new XMLNode();
            tbMenusNode.setNodeName("SRFEXMAINMENUEX");
            tbItemNode6.AddNode(tbMenusNode);
            if (userOtherAction != null && userOtherAction.getChildNodes() != null) {
                for (XMLNode child : userOtherAction.getChildNodes()) {
                    if (StringHelper.Compare((String)child.getNodeName(), (String)"SRFDATBITEM", (boolean)true) == 0) {
                        this.ExportTBItem(rootNode, tbMenusNode, child, false, tbWriterContext, true);
                        continue;
                    }
                    tbMenusNode.AddNode(child);
                }
            }
            if (tbMenusNode.getChildNodes() == null || tbMenusNode.getChildNodes().size() == 0) {
                tbItemsNode.RemoveNode(tbItemNode6);
            } else {
                DAConfigHelper.AddToolbarSeperator(tbItemsNode);
            }
        }
        if (bHelpAction) {
            XMLNode tbItemNode7 = new XMLNode();
            tbItemNode7.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
            tbItemsNode.AddNode(tbItemNode7);
            if (StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
                tbItemNode7.SetValue("ICONCSSCLASS", "sx-tb-help");
            }
            if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) == 0) {
                tbItemNode7.SetValue("IMAGE", "../sasrfex/images/default/icon_help16.png");
            }
            tbItemNode7.SetValue("TIPS", this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"EDITVIEW", (String)"HELP"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"HELP"), "\u5e2e\u52a9"));
            tbItemNode7.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.HelpHandler"));
            tbItemNode7.SetValue("PAGETYPE", "WFINFOVIEW");
        }
        DAConfigHelper.EraseToolbarUnnecessarySeperator(rootNode);
        if (!DAConfigHelper.ExportConfigFile((XMLNode)rootNode, (String)strTBFilePath)) {
            return "";
        }
        return strToolbarConfigId;
    }

    public String GetRIAMainMenuExConfigPath(SRFDAWebContext webContext, String strUserMode) {
        Vector<String> menuModeList = new Vector<String>();
        if (!StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
            if (!StringHelper.IsNullOrEmpty((String)this.strLanguage)) {
                menuModeList.add(StringHelper.Format((String)"%1$s:%2$s:%3$s", (Object)strUserMode, (Object)this.strLanguage, (Object)this.strPageModel));
            }
            menuModeList.add(StringHelper.Format((String)"%1$s:%2$s:%3$s", (Object)strUserMode, (Object)"", (Object)this.strPageModel));
        }
        menuModeList.add(StringHelper.Format((String)"%1$s:%2$s", (Object)strUserMode, (Object)this.strLanguage));
        menuModeList.add(strUserMode);
        MainMenu mainMenu = new MainMenu();
        CallResult callResult = null;
        String strCurMenuMode = "";
        for (String strItem : menuModeList) {
            callResult = this.globalHelperEx.getDAModelHelper().GetMainMenu(strItem, mainMenu);
            if (!callResult.IsOk()) continue;
            strCurMenuMode = strItem;
            break;
        }
        if (callResult == null || callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u7528\u6237[%1$s]\u4e3b\u83dc\u5355\u5931\u8d25\uff0c%2$s", (Object)strUserMode, (Object)(callResult == null ? "\u672a\u77e5\u9519\u8bef" : callResult.getErrorInfo())));
            return "";
        }
        String strMainMenuConfigId = StringHelper.Format((String)"MENUEX_RIA_%1$s_%2$s", (Object)strCurMenuMode, (Object)mainMenu.getMMVERSION());
        strMainMenuConfigId = strMainMenuConfigId.replace(":", "-");
        strMainMenuConfigId = strMainMenuConfigId.toUpperCase();
        String strMMFilePath = ConfigPathHelper.GetRuntimeMainMenuConfigPath((String)this.globalHelperEx.GetAppRootPath(), (String)strMainMenuConfigId);
        File file = new File(strMMFilePath);
        if (file.exists()) {
            return strMMFilePath;
        }
        if (StringHelper.IsNullOrEmpty((String)mainMenu.getMENUMODEL())) {
            log.error((Object)StringHelper.Format((String)"\u4e3b\u83dc\u5355[%1$s]\u914d\u7f6e\u65e0\u6548", (Object)strUserMode));
            return "";
        }
        XMLNode rootNode = XMLNode.LoadFromXML((String)mainMenu.getMENUMODEL());
        if (rootNode == null) {
            log.error((Object)StringHelper.Format((String)"\u4e3b\u83dc\u5355[%1$s]\u914d\u7f6e\u65e0\u6548", (Object)strUserMode));
            return "";
        }
        if (rootNode.getChildNodes() != null) {
            for (XMLNode mainMenuNode : rootNode.getChildNodes()) {
                this.PrepareRIAMenuItemConfig(webContext, mainMenuNode);
            }
        }
        if (!DAConfigHelper.ExportConfigFile((XMLNode)rootNode, (String)strMMFilePath)) {
            return "";
        }
        return strMMFilePath;
    }

    public String GetMainMenuExConfigId(SRFDAWebContext webContext) {
        return this.GetMainMenuExConfigId(webContext, "");
    }

    public String GetMainMenuExConfigId(SRFDAWebContext webContext, String strMenuMode2) {
        String strMenuMode = strMenuMode2;
        if (StringHelper.IsNullOrEmpty((String)strMenuMode)) {
            strMenuMode = webContext.getCurUserMode();
        }
        Vector<String> menuModeList = new Vector<String>();
        if (!StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
            if (!StringHelper.IsNullOrEmpty((String)this.strLanguage)) {
                menuModeList.add(StringHelper.Format((String)"%1$s:%2$s:%3$s", (Object)strMenuMode, (Object)this.strLanguage, (Object)this.strPageModel));
            }
            menuModeList.add(StringHelper.Format((String)"%1$s:%2$s:%3$s", (Object)strMenuMode, (Object)"", (Object)this.strPageModel));
        }
        menuModeList.add(StringHelper.Format((String)"%1$s:%2$s", (Object)strMenuMode, (Object)this.strLanguage));
        menuModeList.add(strMenuMode);
        MainMenu mainMenu = new MainMenu();
        CallResult callResult = null;
        String strCurMenuMode = "";
        for (String strItem : menuModeList) {
            callResult = this.globalHelperEx.getDAModelHelper().GetMainMenu(strItem, mainMenu);
            if (!callResult.IsOk()) continue;
            strCurMenuMode = strItem;
            break;
        }
        if (callResult == null || callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u7528\u6237[%1$s]\u4e3b\u83dc\u5355\u5931\u8d25\uff0c%2$s", (Object)webContext.getCurUserMode(), (Object)(callResult == null ? "\u672a\u77e5\u9519\u8bef" : callResult.getErrorInfo())));
            return "";
        }
        String strMainMenuConfigId = StringHelper.Format((String)"MENUEX_%1$s_%2$s", (Object)strCurMenuMode, (Object)mainMenu.getMMVERSION());
        strMainMenuConfigId = strMainMenuConfigId.replace(":", "-");
        strMainMenuConfigId = strMainMenuConfigId.toUpperCase();
        String strMMFilePath = ConfigPathHelper.GetRuntimeMainMenuConfigPath((String)this.globalHelperEx.GetAppRootPath(), (String)strMainMenuConfigId);
        File file = new File(strMMFilePath);
        if (file.exists()) {
            return strMainMenuConfigId;
        }
        if (StringHelper.IsNullOrEmpty((String)mainMenu.getMENUMODEL())) {
            log.error((Object)StringHelper.Format((String)"\u4e3b\u83dc\u5355[%1$s]\u914d\u7f6e\u65e0\u6548", (Object)strCurMenuMode));
            return "";
        }
        XMLNode rootNode = XMLNode.LoadFromXML((String)mainMenu.getMENUMODEL());
        if (rootNode == null) {
            log.error((Object)StringHelper.Format((String)"\u4e3b\u83dc\u5355[%1$s]\u914d\u7f6e\u65e0\u6548", (Object)strCurMenuMode));
            return "";
        }
        if (rootNode.getChildNodes() != null) {
            for (XMLNode mainMenuNode : rootNode.getChildNodes()) {
                this.PrepareMenuItemConfig(webContext, mainMenuNode);
            }
        }
        if (!DAConfigHelper.ExportConfigFile((XMLNode)rootNode, (String)strMMFilePath)) {
            return "";
        }
        return strMainMenuConfigId;
    }

    protected String GetFuncPagePath(SRFDAWebContext webContext, Func func) {
        String strResourceId = func.getRESOURCEID();
        boolean bGenResId = StringHelper.IsNullOrEmpty((String)strResourceId);
        if (StringHelper.Compare((String)func.getFUNCTYPE(), (String)"PAGELINK", (boolean)true) == 0) {
            return func.getPAGEPATH();
        }
        if (StringHelper.Compare((String)func.getFUNCTYPE(), (String)"DEDATAGRID", (boolean)true) == 0) {
            String strDEId = func.getDEID();
            if (StringHelper.IsNullOrEmpty((String)strDEId)) {
                return "";
            }
            IDEHelper iDEHelper = this.globalHelperEx.getDAModelStorage().FindDEHelper(strDEId);
            if (iDEHelper == null) {
                log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)strDEId));
                return "";
            }
            if (bGenResId) {
                func.setRESOURCEID(UniResHelper.GetDEDataResId((String)strDEId));
            }
            String strDGPage = "";
            String strGridPageId = iDEHelper.GetGridPageId();
            if (!StringHelper.IsNullOrEmpty((String)strGridPageId)) {
                Page page = new Page();
                CallResult callResult = this.globalHelperEx.getDAModelHelper().GetPage(strGridPageId, page);
                if (callResult.getRetCode() != 0) {
                    log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u9875\u9762[%1$s]\u5931\u8d25\uff0c%2$s", (Object)strGridPageId, (Object)callResult.getErrorInfo()));
                    return "";
                }
                strDGPage = page.GetTotalPagePath();
                if (bGenResId) {
                    func.setRESOURCEID(page.getRESOURCEID(""));
                }
            }
            if (StringHelper.IsNullOrEmpty((String)strDGPage)) {
                strDGPage = "../srfpage/gridview.jsp?";
            }
            strDGPage = URLHelper.AppendURLSeperator((String)strDGPage);
            strDGPage = String.valueOf(strDGPage) + StringHelper.Format((String)"%1$s=%2$s", (Object)"SRFDEID", (Object)strDEId);
            return strDGPage;
        }
        if (StringHelper.Compare((String)func.getFUNCTYPE(), (String)"DEGRIDVIEW", (boolean)true) == 0) {
            String strDataGridId = func.getDATAGRIDID();
            if (StringHelper.IsNullOrEmpty((String)strDataGridId)) {
                return "";
            }
            DataGrid dataGrid = new DataGrid();
            CallResult callResult = this.globalHelperEx.getDAModelHelper().GetUserDEDataGrid(strDataGridId, "SYSTEM", dataGrid);
            if (callResult.getRetCode() != 0) {
                log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6570\u636e\u8868\u683c[%1$s]\u5931\u8d25\uff0c%2$s", (Object)strDataGridId, (Object)callResult.getErrorInfo()));
                return "";
            }
            String strDEId = dataGrid.getDEID();
            if (StringHelper.IsNullOrEmpty((String)strDEId)) {
                return "";
            }
            IDEHelper iDEHelper = this.globalHelperEx.getDAModelStorage().FindDEHelper(strDEId);
            if (iDEHelper == null) {
                log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)strDEId));
                return "";
            }
            if (bGenResId) {
                func.setRESOURCEID(UniResHelper.GetDEDataResId((String)strDEId));
            }
            String strDGPage = "";
            String strGridPageId = iDEHelper.GetGridPageId();
            if (!StringHelper.IsNullOrEmpty((String)strGridPageId)) {
                Page page = new Page();
                callResult = this.globalHelperEx.getDAModelHelper().GetPage(strGridPageId, page);
                if (callResult.getRetCode() != 0) {
                    log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u9875\u9762[%1$s]\u5931\u8d25\uff0c%2$s", (Object)strGridPageId, (Object)callResult.getErrorInfo()));
                    return "";
                }
                strDGPage = page.GetTotalPagePath();
                if (bGenResId) {
                    func.setRESOURCEID(page.getRESOURCEID(""));
                }
            }
            if (StringHelper.IsNullOrEmpty((String)strDGPage)) {
                strDGPage = "../srfpage/gridview.jsp?";
            }
            strDGPage = String.valueOf(strDGPage) + StringHelper.Format((String)"%1$s=%2$s", (Object)"SRFGRIDVIEW", (Object)strDataGridId);
            return strDGPage;
        }
        if (StringHelper.Compare((String)func.getFUNCTYPE(), (String)"PAGE", (boolean)true) == 0) {
            String strPageId = func.getPAGEID();
            if (StringHelper.IsNullOrEmpty((String)strPageId)) {
                log.error((Object)StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u5185\u7f6e\u9875\u9762\u53c2\u6570"));
                return "";
            }
            Page page = this.globalHelperEx.getDAModelStorage().FindPage(strPageId);
            if (page == null) {
                log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5185\u7f6e\u9875\u9762[%1$s]", (Object)strPageId));
                return "";
            }
            String strDEId = func.getDEID();
            String strPagePath = page.GetTotalPagePath();
            if (!StringHelper.IsNullOrEmpty((String)strDEId)) {
                strPagePath = URLHelper.AppendURLSeperator((String)strPagePath);
                strPagePath = String.valueOf(strPagePath) + StringHelper.Format((String)"%1$s=%2$s", (Object)"SRFDEID", (Object)strDEId);
            }
            if (bGenResId) {
                func.setRESOURCEID(page.getRESOURCEID(""));
            }
            return strPagePath;
        }
        return "";
    }

    protected void PrepareMenuItemConfig(SRFDAWebContext webContext, XMLNode menuItemNode) {
        String strCustomObject;
        String strFuncId = menuItemNode.GetExtValue("FUNC_ID", "");
        if (!StringHelper.IsNullOrEmpty((String)strFuncId)) {
            Func func = new Func();
            CallResult callResult = this.globalHelperEx.getDAModelHelper().GetFunc(strFuncId, func);
            if (callResult.getRetCode() == 0) {
                if (StringHelper.Compare((String)func.getFUNCTYPE(), (String)"JSCODE", (boolean)true) == 0) {
                    String strJSCode = func.getJSCODE();
                    menuItemNode.SetValue("JSCODE", strJSCode);
                } else {
                    String strPathPath = this.GetFuncPagePath(webContext, func);
                    if (!StringHelper.IsNullOrEmpty((String)strPathPath)) {
                        menuItemNode.SetValue("PAGEPATH", strPathPath);
                    }
                }
                String strResourceId = func.getRESOURCEID();
                if (!StringHelper.IsNullOrEmpty((String)strResourceId) && StringHelper.Compare((String)strResourceId, (String)"NONE", (boolean)true) != 0) {
                    menuItemNode.SetValue("RESOURCEID", strResourceId);
                } else {
                    menuItemNode.SetValue("RESOURCEID", "NONE");
                }
            } else {
                log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6a21\u5757\u529f\u80fd[%1$s]\u5931\u8d25\uff0c%2$s", (Object)strFuncId, (Object)callResult.getErrorInfo()));
            }
        }
        if (!StringHelper.IsNullOrEmpty((String)(strCustomObject = menuItemNode.GetExtValue("CUSTOMOBJECT", "")))) {
            Object objCustom = ObjectHelper.Create((String)strCustomObject);
            if (objCustom == null) {
                log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u81ea\u5b9a\u4e49\u83dc\u5355\u5bf9\u8c61[%1$s]", (Object)strCustomObject));
            } else if (!(objCustom instanceof IDACustomMenuBuilder)) {
                log.error((Object)StringHelper.Format((String)"\u81ea\u5b9a\u4e49\u83dc\u5355\u5bf9\u8c61[%1$s]\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)strCustomObject));
            } else {
                CallResult callResult = ((IDACustomMenuBuilder)objCustom).Build(this.globalHelperEx, (ISRFDAWebContext)webContext, menuItemNode);
                if (callResult.IsError()) {
                    log.error((Object)StringHelper.Format((String)"\u81ea\u5b9a\u4e49\u83dc\u5355\u5bf9\u8c61\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
            }
        }
        if (menuItemNode.getChildNodes() == null) {
            return;
        }
        for (XMLNode mainMenuNode : menuItemNode.getChildNodes()) {
            this.PrepareMenuItemConfig(webContext, mainMenuNode);
        }
    }

    protected void PrepareRIAMenuItemConfig(SRFDAWebContext webContext, XMLNode menuItemNode) {
        String strFuncId = menuItemNode.GetExtValue("FUNC_ID", "");
        if (!StringHelper.IsNullOrEmpty((String)strFuncId)) {
            Func func = new Func();
            CallResult callResult = this.globalHelperEx.getDAModelHelper().GetFunc(strFuncId, func);
            if (callResult.getRetCode() == 0) {
                if (StringHelper.Compare((String)func.getFUNCTYPE(), (String)"JSCODE", (boolean)true) == 0) {
                    String strJSCode = func.getJSCODE();
                    menuItemNode.SetValue("JSCODE", strJSCode);
                } else {
                    String strPathPath = this.GetFuncPagePath(webContext, func);
                    if (!StringHelper.IsNullOrEmpty((String)strPathPath)) {
                        menuItemNode.SetValue("PAGEPATH", strPathPath);
                    }
                }
                String strResourceId = func.getRESOURCEID();
                if (!StringHelper.IsNullOrEmpty((String)strResourceId) && StringHelper.Compare((String)strResourceId, (String)"NONE", (boolean)true) != 0) {
                    menuItemNode.SetValue("RESOURCEID", strResourceId);
                } else {
                    menuItemNode.SetValue("RESOURCEID", "NONE");
                }
            } else {
                log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6a21\u5757\u529f\u80fd[%1$s]\u5931\u8d25\uff0c%2$s", (Object)strFuncId, (Object)callResult.getErrorInfo()));
            }
        }
        if (menuItemNode.getChildNodes() == null) {
            return;
        }
        for (XMLNode mainMenuNode : menuItemNode.getChildNodes()) {
            this.PrepareRIAMenuItemConfig(webContext, mainMenuNode);
        }
    }

    public String GetGridViewSPExConfigId(IDEHelper iDEHelper, DataGrid dataGrid) {
        String strSPExConfigId = StringHelper.Format((String)"DE%1$s.SPEX_GRID_%2$s_%3$s", (Object)iDEHelper.getId(), (Object)iDEHelper.getVersion(), (Object)dataGrid.getDGVERSION());
        if (!StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
            strSPExConfigId = String.valueOf(strSPExConfigId) + StringHelper.Format((String)"_PM_%1$s", (Object)this.strPageModel);
        }
        if (!StringHelper.IsNullOrEmpty((String)this.strLanguage)) {
            strSPExConfigId = String.valueOf(strSPExConfigId) + StringHelper.Format((String)"_%1$s", (Object)this.strLanguage);
        }
        strSPExConfigId = strSPExConfigId.toUpperCase();
        return this.GetDefaultSPExConfigId(iDEHelper, strSPExConfigId);
    }

    public String GetSPExConfigId(IDEHelper iDEHelper) {
        String strSPExConfigId = StringHelper.Format((String)"DE%1$s.SPEX_%2$s", (Object)iDEHelper.getId(), (Object)iDEHelper.getVersion());
        if (!StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
            strSPExConfigId = String.valueOf(strSPExConfigId) + StringHelper.Format((String)"_PM_%1$s", (Object)this.strPageModel);
        }
        if (!StringHelper.IsNullOrEmpty((String)this.strLanguage)) {
            strSPExConfigId = String.valueOf(strSPExConfigId) + StringHelper.Format((String)"_%1$s", (Object)this.strLanguage);
        }
        strSPExConfigId = strSPExConfigId.toUpperCase();
        return this.GetDefaultSPExConfigId(iDEHelper, strSPExConfigId);
    }

    public String GetGridViewExSPExConfigId(IDEHelper iDEHelper, DataGridEx dataGridEx) {
        String strSPExConfigId = StringHelper.Format((String)"DE%1$s.SPEX_GRIDEX_%2$s_%3$s", (Object)iDEHelper.getId(), (Object)iDEHelper.getVersion(), (Object)dataGridEx.getVERSION());
        if (!StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
            strSPExConfigId = String.valueOf(strSPExConfigId) + StringHelper.Format((String)"_PM_%1$s", (Object)this.strPageModel);
        }
        if (!StringHelper.IsNullOrEmpty((String)this.strLanguage)) {
            strSPExConfigId = String.valueOf(strSPExConfigId) + StringHelper.Format((String)"_%1$s", (Object)this.strLanguage);
        }
        strSPExConfigId = strSPExConfigId.toUpperCase();
        return this.GetDefaultSPExConfigId(iDEHelper, strSPExConfigId);
    }

    protected String GetDefaultSPExConfigId(IDEHelper iDEHelper, String strSPExConfigId) {
        String strSPExFilePath;
        File file;
        String strGroupColumns = "33%;33%;33%;";
        if (StringHelper.Compare((String)this.getPageModel(), (String)"WinRT", (boolean)true) == 0) {
            strGroupColumns = "";
        }
        if ((file = new File(strSPExFilePath = ConfigPathHelper.GetRuntimeSPConfigPath((String)this.globalHelperEx.GetAppRootPath(), (String)strSPExConfigId))).exists()) {
            return strSPExConfigId;
        }
        ArrayList commItemList = new ArrayList();
        TreeMap<String, ArrayList> pageItemMap = new TreeMap<String, ArrayList>();
        for (IDEFHelper iDEFHelper : iDEHelper.GetDEFHelpers()) {
            SearchModelConfig searchModelConfig = iDEFHelper.GetSearchModel();
            if (searchModelConfig == null) continue;
            for (SearchItemConfig searchItemConfig : searchModelConfig) {
                XMLNode formItemNode;
                if (!iDEFHelper.IsSupportSearchAction(searchItemConfig) || (formItemNode = this.globalHelperEx.getDAFormItemHelper().GetSearchFormCtrlNode(this.strPageModel, this.strLanguage, iDEHelper, iDEFHelper, searchItemConfig)) == null) continue;
                String strGroup = searchItemConfig.getGroup();
                if (searchItemConfig.getShowOrder() < 0) continue;
                formItemNode.SetValue("SHOWORDER", StringHelper.Format((String)"%1$s", (Object)searchItemConfig.getShowOrder()));
                if (searchItemConfig.getColSpan() > 1) {
                    formItemNode.SetValue("COLSPAN", StringHelper.Format((String)"%1$s", (Object)searchItemConfig.getColSpan()));
                }
                ArrayList list = null;
                if (StringHelper.IsNullOrEmpty((String)strGroup)) {
                    list = commItemList;
                } else if (pageItemMap.containsKey(strGroup)) {
                    list = (ArrayList)pageItemMap.get(strGroup);
                } else {
                    list = new ArrayList();
                    pageItemMap.put(strGroup, list);
                }
                int nInsertPos = -1;
                int nLastShowOrder = -1;
                int i = 0;
                while (i < list.size()) {
                    XMLNode xmlNode = (XMLNode)list.get(i);
                    nLastShowOrder = xmlNode.GetExtValue("SHOWORDER", 100);
                    if (nLastShowOrder > searchItemConfig.getShowOrder()) {
                        nInsertPos = i;
                        break;
                    }
                    ++i;
                }
                if (nInsertPos == -1) {
                    if (nLastShowOrder <= searchItemConfig.getShowOrder()) {
                        list.add(formItemNode);
                        continue;
                    }
                    list.add(0, formItemNode);
                    continue;
                }
                list.add(nInsertPos, formItemNode);
            }
        }
        XMLNode rootNode = new XMLNode();
        rootNode.setNodeName("SRFEXSPEX");
        XMLNode dpNode = new XMLNode();
        dpNode.setNodeName("SRFEXDP");
        rootNode.AddNode(dpNode);
        XMLNode dpCommonGroupNode = new XMLNode();
        dpCommonGroupNode.setNodeName("SRFEXDPPAGEGROUP");
        dpCommonGroupNode.SetValue("COLUMNS", strGroupColumns);
        dpCommonGroupNode.SetValue("CAPTION", this.GetLocalization(iDEHelper, "CONTROL.SPEX.STANDARDPAGE", "\u5e38\u89c4"));
        dpNode.AddNode(dpCommonGroupNode);
        for (XMLNode xmlNode : commItemList) {
            dpCommonGroupNode.AddNode(xmlNode);
        }
        for (String strCaption : pageItemMap.keySet()) {
            ArrayList groupList = (ArrayList)pageItemMap.get(strCaption);
            strCaption = this.GetLocalization(iDEHelper, "CONTROL.SPEX.CUSTOMPAGE." + strCaption, strCaption);
            XMLNode dpPageGroupNode = new XMLNode();
            dpPageGroupNode.setNodeName("SRFEXDPPAGEGROUP");
            dpPageGroupNode.SetValue("COLUMNS", strGroupColumns);
            dpPageGroupNode.SetValue("CAPTION", strCaption);
            dpNode.AddNode(dpPageGroupNode);
            for (XMLNode xmlNode : groupList) {
                dpPageGroupNode.AddNode(xmlNode);
            }
        }
        if (!DAConfigHelper.ExportConfigFile((XMLNode)rootNode, (String)strSPExFilePath)) {
            return "";
        }
        return strSPExConfigId;
    }

    public String GetRIAGridViewSPExConfigPath(IDEHelper iDEHelper, DataGrid dataGrid) {
        String strGroupColumns = "33%;33%;33%;";
        String strSPExConfigId = StringHelper.Format((String)"DE%1$s.SPEX_RIA_GRID_%2$s_%3$s", (Object)iDEHelper.getId(), (Object)iDEHelper.getVersion(), (Object)dataGrid.getDGVERSION());
        strSPExConfigId = strSPExConfigId.toUpperCase();
        String strSPExFilePath = ConfigPathHelper.GetRuntimeSPConfigPath((String)this.globalHelperEx.GetAppRootPath(), (String)strSPExConfigId);
        File file = new File(strSPExFilePath);
        if (file.exists()) {
            return strSPExFilePath;
        }
        ArrayList commItemList = new ArrayList();
        TreeMap<String, ArrayList> pageItemMap = new TreeMap<String, ArrayList>();
        for (IDEFHelper iDEFHelper : iDEHelper.GetDEFHelpers()) {
            SearchModelConfig searchModelConfig = iDEFHelper.GetSearchModel();
            if (searchModelConfig == null) continue;
            for (SearchItemConfig searchItemConfig : searchModelConfig) {
                XMLNode formItemNode;
                if (!iDEFHelper.IsSupportSearchAction(searchItemConfig) || (formItemNode = this.globalHelperEx.getDAFormItemHelper().GetSearchFormCtrlNode(this.strPageModel, this.strLanguage, iDEHelper, iDEFHelper, searchItemConfig)) == null) continue;
                String strGroup = searchItemConfig.getGroup();
                if (searchItemConfig.getShowOrder() < 0) continue;
                formItemNode.SetValue("SHOWORDER", StringHelper.Format((String)"%1$s", (Object)searchItemConfig.getShowOrder()));
                ArrayList list = null;
                if (StringHelper.IsNullOrEmpty((String)strGroup)) {
                    list = commItemList;
                } else if (pageItemMap.containsKey(strGroup)) {
                    list = (ArrayList)pageItemMap.get(strGroup);
                } else {
                    list = new ArrayList();
                    pageItemMap.put(strGroup, list);
                }
                int nInsertPos = -1;
                int nLastShowOrder = -1;
                int i = 0;
                while (i < list.size()) {
                    XMLNode xmlNode = (XMLNode)list.get(i);
                    nLastShowOrder = xmlNode.GetExtValue("SHOWORDER", 100);
                    if (nLastShowOrder > searchItemConfig.getShowOrder()) {
                        nInsertPos = i;
                        break;
                    }
                    ++i;
                }
                if (nInsertPos == -1) {
                    if (nLastShowOrder <= searchItemConfig.getShowOrder()) {
                        list.add(formItemNode);
                        continue;
                    }
                    list.add(0, formItemNode);
                    continue;
                }
                list.add(nInsertPos, formItemNode);
            }
        }
        XMLNode rootNode = new XMLNode();
        rootNode.setNodeName("SRFEXSPEX");
        XMLNode dpNode = new XMLNode();
        dpNode.setNodeName("SRFEXDP");
        rootNode.AddNode(dpNode);
        XMLNode dpCommonGroupNode = new XMLNode();
        dpCommonGroupNode.setNodeName("SRFEXDPPAGEGROUP");
        dpCommonGroupNode.SetValue("COLUMNS", strGroupColumns);
        dpCommonGroupNode.SetValue("CAPTION", this.GetLocalization(iDEHelper, "CONTROL.SPEX.STANDARDPAGE", "\u5e38\u89c4"));
        dpNode.AddNode(dpCommonGroupNode);
        for (XMLNode xmlNode : commItemList) {
            dpCommonGroupNode.AddNode(xmlNode);
        }
        for (String strCaption : pageItemMap.keySet()) {
            ArrayList groupList = (ArrayList)pageItemMap.get(strCaption);
            XMLNode dpPageGroupNode = new XMLNode();
            dpPageGroupNode.setNodeName("SRFEXDPPAGEGROUP");
            dpPageGroupNode.SetValue("COLUMNS", strGroupColumns);
            dpPageGroupNode.SetValue("CAPTION", strCaption);
            dpNode.AddNode(dpPageGroupNode);
            for (XMLNode xmlNode : groupList) {
                dpPageGroupNode.AddNode(xmlNode);
            }
        }
        if (!DAConfigHelper.ExportConfigFile((XMLNode)rootNode, (String)strSPExFilePath)) {
            return "";
        }
        return strSPExFilePath;
    }

    public String GetGridViewDGConfigId(IDEHelper iDEHelper, Page page, DataGrid dataGrid) {
        return this.GetGridViewDGConfigId(iDEHelper, page, dataGrid, "");
    }

    public String GetGridViewDGConfigId(IDEHelper iDEHelper, Page page, DataGrid dataGrid, String strAppendId) {
        String strDataGridConfigId = StringHelper.Format((String)"DE%1$s.DG_%2$s_%3$s%4$s", (Object)iDEHelper.getId(), (Object)iDEHelper.getVersion(), (Object)dataGrid.getDATAGRIDID(), (Object)dataGrid.getDGVERSION());
        if (!StringHelper.IsNullOrEmpty((String)strAppendId)) {
            strDataGridConfigId = String.valueOf(strDataGridConfigId) + "_" + strAppendId;
        }
        if (page != null) {
            strDataGridConfigId = String.valueOf(strDataGridConfigId) + StringHelper.Format((String)"_%1$s_%2$s", (Object)page.getPAGEID(), (Object)page.getVERSION());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
            strDataGridConfigId = String.valueOf(strDataGridConfigId) + StringHelper.Format((String)"_PM_%1$s", (Object)this.strPageModel);
        }
        if (!StringHelper.IsNullOrEmpty((String)this.strLanguage)) {
            strDataGridConfigId = String.valueOf(strDataGridConfigId) + StringHelper.Format((String)"_%1$s", (Object)this.strLanguage);
        }
        strDataGridConfigId = strDataGridConfigId.toUpperCase();
        String strDGFilePath = ConfigPathHelper.GetRuntimeDGConfigPath((String)this.globalHelperEx.GetAppRootPath(), (String)strDataGridConfigId);
        File file = new File(strDGFilePath);
        if (file.exists()) {
            return strDataGridConfigId;
        }
        PPDataGrid ppDataGrid = null;
        PPGridView ppGridView = null;
        if (page != null) {
            BaseDataEntity pageParam = page.getAdvPageParam("DATAGRID", "PP_DATAGRID");
            if (pageParam != null && pageParam instanceof PPDataGrid) {
                ppDataGrid = (PPDataGrid)pageParam;
            }
            if ((pageParam = page.getAdvPageParam("PAGE", "PPGRIDVIEW")) != null && pageParam instanceof PPGridView) {
                ppGridView = (PPGridView)pageParam;
            }
        }
        TreeMap<String, Object> params = new TreeMap<String, Object>();
        if (!dataGrid.isENABLEPAGINGNull() && !dataGrid.getENABLEPAGING()) {
            params.put("PAGING", dataGrid.getENABLEPAGING());
        }
        if (ppDataGrid != null && !ppDataGrid.isENABLEPAGINGNull()) {
            params.put("PAGING", ppDataGrid.getENABLEPAGING());
        }
        if (ppGridView != null && !StringHelper.IsNullOrEmpty((String)ppGridView.getDGMODE())) {
            params.put("DGMODE", ppGridView.getDGMODE());
        }
        this.OnPrepareDGConfigParams(iDEHelper, page, dataGrid, params);
        XMLNode rootNode = this.GetDGConfig(iDEHelper, dataGrid, params);
        if (!this.OnAfterPrepareGridViewDGConfig(rootNode, iDEHelper, page, dataGrid)) {
            return "";
        }
        if (!DAConfigHelper.ExportConfigFile((XMLNode)rootNode, (String)strDGFilePath)) {
            return "";
        }
        return strDataGridConfigId;
    }

    protected void OnPrepareDGConfigParams(IDEHelper iDEHelper, Page page, DataGrid dataGrid, TreeMap<String, Object> params) {
        String strDGMode = "";
        String strPaging = "";
        if (page != null) {
            strDGMode = page.GetPageProperty("PAGE.DGMODE", strDGMode);
            strPaging = page.GetPageProperty("PAGE.DATAGRID.PAGING", strPaging);
        }
        if (!StringHelper.IsNullOrEmpty((String)strPaging)) {
            params.put("PAGING", Boolean.parseBoolean(strPaging));
        }
        if (!StringHelper.IsNullOrEmpty((String)strDGMode)) {
            params.put("DGMODE", strDGMode);
        }
    }

    protected boolean OnAfterPrepareGridViewDGConfig(XMLNode rootNode, IDEHelper iDEHelper, Page page, DataGrid dataGrid) {
        return true;
    }

    protected XMLNode GetDGEditItemNode(IDEFHelper iDEFHelper, DGModeDetail dgModeDetail) {
        String strValueRuleInfo;
        XMLNode itemNode = new XMLNode();
        itemNode.setNodeName("SRFEXDATAGRIDEDITITEM");
        IDEFFormCtrl iFormCtrl = iDEFHelper.GetFormCtrl();
        itemNode.SetValue("DBFIELD", iDEFHelper.getName());
        itemNode.SetValue("NAME", iDEFHelper.getDGItem().GetCaption(dgModeDetail, this.strLanguage));
        if (iDEFHelper.GetPrecision() >= 0) {
            itemNode.SetValue("PRECISION", StringHelper.Format((String)"%1$s", (Object)iDEFHelper.GetPrecision()));
        }
        boolean bAllowEmpty = iFormCtrl.IsAllowEmpty();
        if (dgModeDetail != null) {
            bAllowEmpty = dgModeDetail.isALLOWEMPTY();
        }
        String strAllowEmpty = bAllowEmpty ? "TRUE" : "FALSE";
        itemNode.SetValue("ALLOWEMPTY", strAllowEmpty);
        if (iDEFHelper.GetFormCtrl().IsKey()) {
            itemNode.SetValue("KEY", "TRUE");
        }
        if (iDEFHelper.GetFormCtrl().GetStringLengthRule() > 0) {
            itemNode.SetValue("MAXLENGTH", StringHelper.Format((String)"%1$s", (Object)iDEFHelper.GetFormCtrl().GetStringLengthRule()));
        }
        if (!StringHelper.IsNullOrEmpty((String)iDEFHelper.GetStringCase())) {
            itemNode.SetValue("STRINGCASE", iDEFHelper.GetStringCase());
        }
        itemNode.SetValue("DV", iDEFHelper.getDGItem().GetDefaultValue(dgModeDetail));
        itemNode.SetValue("DVT", iDEFHelper.getDGItem().GetDefaultValueType(dgModeDetail));
        itemNode.SetValue("VALIDCOND", iDEFHelper.getDEField().getDGCOLVALIDCOND());
        String strValueRuleCode = iDEFHelper.GetValueRule();
        if (!StringHelper.IsNullOrEmpty((String)strValueRuleCode)) {
            strValueRuleCode = StringHelper.Format((String)strValueRuleCode, (Object)iDEFHelper.getName());
            itemNode.SetValue("VALUERULECODE", strValueRuleCode);
        }
        if (!StringHelper.IsNullOrEmpty((String)(strValueRuleInfo = iDEFHelper.GetValueRuleInfo()))) {
            strValueRuleInfo = StringHelper.Format((String)strValueRuleInfo, (Object)StringHelper.Format((String)"[%1$s]\u8f93\u5165\u4e0d\u6b63\u786e", (Object)iDEFHelper.getLogicName(this.strLanguage)));
            itemNode.SetValue("VALUERULEINFO", strValueRuleInfo);
        }
        if (dgModeDetail != null) {
            ValueRuleConfig valueRuleConfig;
            if (!StringHelper.IsNullOrEmpty((String)dgModeDetail.getDGCOLVALIDCOND())) {
                itemNode.SetValue("VALIDCOND", dgModeDetail.getDGCOLVALIDCOND());
            }
            String strValueRule = dgModeDetail.getVALUERULE();
            String strCustomValueRule = dgModeDetail.getCUSTOMVALUERULE();
            strValueRuleInfo = dgModeDetail.getVALUERULEINFO();
            if (!StringHelper.IsNullOrEmpty((String)strCustomValueRule)) {
                strValueRuleCode = strCustomValueRule;
            } else if (!StringHelper.IsNullOrEmpty((String)strValueRule)) {
                valueRuleConfig = this.globalHelperEx.getDAConfigMgr().getValueRuleMgr().FindRuleConfig(strValueRule);
                if (valueRuleConfig == null) {
                    log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u9884\u5b9a\u4e49\u503c\u89c4\u5219[%1$s]", (Object)strValueRule));
                } else {
                    strValueRuleCode = valueRuleConfig.getRule();
                }
            } else {
                strValueRuleCode = iDEFHelper.GetValueRule();
            }
            if (!StringHelper.IsNullOrEmpty((String)strValueRuleCode)) {
                strValueRuleCode = StringHelper.Format((String)strValueRuleCode, (Object)iDEFHelper.getName());
                itemNode.SetValue("VALUERULECODE", strValueRuleCode);
            }
            if (StringHelper.IsNullOrEmpty((String)strValueRuleInfo)) {
                if (!StringHelper.IsNullOrEmpty((String)strValueRule)) {
                    valueRuleConfig = this.globalHelperEx.getDAConfigMgr().getValueRuleMgr().FindRuleConfig(strValueRule);
                    if (valueRuleConfig == null) {
                        log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u9884\u5b9a\u4e49\u503c\u89c4\u5219[%1$s]", (Object)strValueRule));
                    } else {
                        strValueRuleInfo = valueRuleConfig.getRuleInfo();
                    }
                } else {
                    strValueRuleInfo = iDEFHelper.GetValueRuleInfo();
                }
            }
            if (!StringHelper.IsNullOrEmpty((String)strValueRuleInfo)) {
                strValueRuleInfo = StringHelper.Format((String)strValueRuleInfo, (Object)StringHelper.Format((String)"[%1$s]\u8f93\u5165\u4e0d\u6b63\u786e", (Object)iDEFHelper.getLogicName(this.strLanguage)));
                itemNode.SetValue("VALUERULEINFO", strValueRuleInfo);
            }
        }
        return itemNode;
    }

    protected XMLNode GetDGConfig(IDEHelper iDEHelper, DataGrid dataGrid, TreeMap<String, Object> params) {
        XMLNode dsItemNode;
        XMLNode dsItemsNode;
        XMLNode rootNode;
        DGMode dgMode;
        TreeMap<String, DGModeDetail> dgModeDetailMap;
        block122: {
            XMLNode dsItemParamsNode;
            String strInfoFields;
            block123: {
                IDEFHelper sortDEFHelper;
                String strDGMode = "";
                boolean bPaging = true;
                boolean bEditable = true;
                if (params != null) {
                    if (params.containsKey("DGMODE")) {
                        strDGMode = (String)params.get("DGMODE");
                    }
                    if (params.containsKey("PAGING")) {
                        bPaging = (Boolean)params.get("PAGING");
                    }
                    if (params.containsKey("EDITABLE")) {
                        bEditable = (Boolean)params.get("EDITABLE");
                    }
                }
                dgModeDetailMap = new TreeMap<String, DGModeDetail>();
                dgMode = null;
                if (!StringHelper.IsNullOrEmpty((String)strDGMode)) {
                    dgMode = new DGMode();
                    CallResult callResult = this.globalHelperEx.getDAModelHelper().GetDGMode(strDGMode, dgMode);
                    if (callResult.getRetCode() == 3) {
                        callResult = this.globalHelperEx.getDAModelHelper().GetDGMode(iDEHelper.getId(), strDGMode, dgMode);
                    }
                    if (callResult.getRetCode() == 0) {
                        Vector dgModeDetails = new Vector();
                        callResult = this.globalHelperEx.getDAModelHelper().GetDGModeDetails(dgMode.getDGMODEID(), dgModeDetails);
                        if (callResult == null || callResult.getRetCode() != 0) {
                            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u8868\u683c\u6a21\u5f0f\u660e\u7ec6\u5931\u8d25\uff0c%1$s", (Object)(callResult == null ? "\u4e0d\u660e" : callResult.getErrorInfo())));
                            return null;
                        }
                        for (DGModeDetail dgModeDetail : dgModeDetails) {
                            dgModeDetailMap.put(dgModeDetail.getDEFNAME().toUpperCase(), dgModeDetail);
                        }
                    } else {
                        if (callResult.getRetCode() != 3) {
                            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u8868\u683c\u6a21\u5f0f\u5931\u8d25\uff0c%1$s", (Object)(callResult == null ? "\u4e0d\u660e" : callResult.getErrorInfo())));
                            return null;
                        }
                        dgMode = null;
                    }
                }
                boolean bAppendMajorTextDSItem = true;
                boolean bAppendTempDataDSItem = true;
                DataGridModelConfig dataGridModelConfig = dataGrid.getDataGridModelConfig();
                TreeMap<String, DGModelColumnConfig> outputColumnMap = new TreeMap<String, DGModelColumnConfig>();
                for (DGModelColumnConfig columnConfig : dataGridModelConfig.getColumnsConfig()) {
                    outputColumnMap.put(columnConfig.getDEField().toUpperCase(), columnConfig);
                }
                rootNode = new XMLNode();
                rootNode.setNodeName("SRFEXDATAGRID");
                rootNode.SetValue("PAGING", bPaging ? "TRUE" : "FALSE");
                rootNode.SetValue("SELECTCOLUMN", "TRUE");
                rootNode.SetValue("LOADINGMSG", this.GetLocalization(iDEHelper, "CONTROL.DATAGRID.LOADINGMSG", "\u6b63\u5728\u52a0\u8f7d\u6570\u636e\uff0c\u8bf7\u7a0d\u5019"));
                if (!StringHelper.IsNullOrEmpty((String)this.getPageModel())) {
                    rootNode.SetValue("LVSTYLE", dataGrid.getLVSTYLE());
                    rootNode.SetValue("LVIDT", dataGrid.getLVIDT());
                }
                if (dgMode != null) {
                    if (!StringHelper.IsNullOrEmpty((String)dgMode.getRENDERMODE())) {
                        rootNode.SetValue("RENDERMODE", dgMode.getRENDERMODE());
                    }
                } else if (!StringHelper.IsNullOrEmpty((String)dataGrid.getRENDERMODE())) {
                    rootNode.SetValue("RENDERMODE", dataGrid.getRENDERMODE());
                }
                if (dataGrid.getROWEXPANDER()) {
                    rootNode.SetValue("ROWEXPANDER", "TRUE");
                    rootNode.SetValue("ROWEXPANDERPARAM", dataGrid.getROWEXPANDERPARAM());
                }
                if (!StringHelper.IsNullOrEmpty((String)this.strDGResponseType)) {
                    rootNode.SetValue("RESPONSETYPE", this.strDGResponseType);
                }
                if (iDEHelper.getDataEntity().getDGSUMMARYHEIGHT() > 0) {
                    rootNode.SetValue("SUMMARYHEIGHT", StringHelper.Format((String)"%1$s", (Object)iDEHelper.getDataEntity().getDGSUMMARYHEIGHT()));
                }
                if (!StringHelper.IsNullOrEmpty((String)iDEHelper.getDataEntity().getDGROWCLASSHELPER())) {
                    rootNode.SetValue("ROWCLASSHELPER", iDEHelper.getDataEntity().getDGROWCLASSHELPER());
                }
                if (!StringHelper.IsNullOrEmpty((String)dataGrid.getROWCLASSHELPER())) {
                    rootNode.SetValue("ROWCLASSHELPER", dataGrid.getROWCLASSHELPER());
                }
                if (!dataGrid.isHIDEHEADERNull() && dataGrid.getHIDEHEADER()) {
                    rootNode.SetValue("HIDEHEADER", "TRUE");
                }
                if (!dataGrid.isHIDEGROUPPANELNull() && dataGrid.getHIDEGROUPPANEL()) {
                    rootNode.SetValue("HIDEGROUPPANEL", "TRUE");
                }
                if (!dataGrid.isHIDEGROUPCOLUMNNull() && dataGrid.getHIDEGROUPCOLUMN()) {
                    rootNode.SetValue("HIDEGROUPCOLUMN", "TRUE");
                }
                if (!StringHelper.IsNullOrEmpty((String)dataGrid.getHIERARCHYDATA())) {
                    rootNode.SetValue("HIERARCHYDATA", dataGrid.getHIERARCHYDATA());
                }
                if (dgMode != null) {
                    if (dgMode.getSUMMARYHEIGHT() > 0) {
                        rootNode.SetValue("SUMMARYHEIGHT", StringHelper.Format((String)"%1$s", (Object)dgMode.getSUMMARYHEIGHT()));
                    }
                    if (!StringHelper.IsNullOrEmpty((String)dgMode.getROWCLASSHELPER())) {
                        rootNode.SetValue("ROWCLASSHELPER", dgMode.getROWCLASSHELPER());
                    }
                }
                if (dataGrid.isFORCEFIT()) {
                    rootNode.SetValue("FORCEFIT", "TRUE");
                }
                if (dataGrid.getFETCHTIMEOUT() > 0) {
                    rootNode.SetValue("TIMEOUT", StringHelper.Format((String)"%1$s", (Object)dataGrid.getFETCHTIMEOUT()));
                }
                XMLNode pagingNode = new XMLNode();
                pagingNode.setNodeName("SRFEXDATAGRIDPAGING");
                rootNode.AddNode(pagingNode);
                if (pagingNode != null) {
                    String strEmptyMsg;
                    String strAfterPageMsg;
                    String strBeforePageMsg;
                    pagingNode.SetValue("PAGESIZE", StringHelper.Format((String)"%1$s", (Object)dataGridModelConfig.getPageSize()));
                    String strDisplayMsg = this.GetLocalization(iDEHelper, "CONTROL.DATAGRID.PAGING.DISPLAYMSG", "");
                    if (!StringHelper.IsNullOrEmpty((String)strDisplayMsg)) {
                        pagingNode.SetValue("DISPLAYMSG", strDisplayMsg);
                    }
                    if (!StringHelper.IsNullOrEmpty((String)(strBeforePageMsg = this.GetLocalization(iDEHelper, "CONTROL.DATAGRID.PAGING.BEFOREPAGEMSG", "")))) {
                        pagingNode.SetValue("BEFOREPAGEMSG", strBeforePageMsg);
                    }
                    if (!StringHelper.IsNullOrEmpty((String)(strAfterPageMsg = this.GetLocalization(iDEHelper, "CONTROL.DATAGRID.PAGING.AFTERPAGEMSG", "")))) {
                        pagingNode.SetValue("AFTERPAGEMSG", strAfterPageMsg);
                    }
                    if (!StringHelper.IsNullOrEmpty((String)(strEmptyMsg = this.GetLocalization(iDEHelper, "CONTROL.DATAGRID.PAGING.EMPTYMSG", "")))) {
                        pagingNode.SetValue("EMPTYMSG", strEmptyMsg);
                    }
                }
                XMLNode cellNode = new XMLNode();
                cellNode.setNodeName("SRFEXDATAGRIDCELL");
                rootNode.AddNode(cellNode);
                if (!dataGrid.isCELLPANELHEIGHTNull() && dataGrid.getCELLPANELHEIGHT() > 0) {
                    cellNode.SetValue("HEIGHT", StringHelper.Format((String)"%1$s", (Object)dataGrid.getCELLPANELHEIGHT()));
                }
                if (!dataGrid.isCELLLONGPRESSEDITNull()) {
                    cellNode.SetValue("LONGPRESSEDIT", StringHelper.Format((String)"%1$s", (Object)(dataGrid.getCELLLONGPRESSEDIT() ? "TRUE" : "FALSE")));
                }
                if (!dataGrid.isCELLSELMODENull()) {
                    cellNode.SetValue("SELMODE", dataGrid.getCELLSELMODE());
                }
                if (!dataGrid.isCELLSELSTYLENull()) {
                    cellNode.SetValue("SELSTYLE", dataGrid.getCELLSELSTYLE());
                }
                dsItemsNode = new XMLNode();
                dsItemsNode.setNodeName("SRFEXDATAGRIDDS");
                rootNode.AddNode(dsItemsNode);
                if (dataGrid.getNOSORT()) {
                    dsItemsNode.SetValue("SORTABLE", "FALSE");
                }
                if (dataGrid.getNODEFSORT()) {
                    dsItemsNode.SetValue("NODEFSORT", "TRUE");
                }
                XMLNode colRendersNode = new XMLNode();
                colRendersNode.setNodeName("SRFEXDATAGRIDCOLUMNRENDERS");
                rootNode.AddNode(colRendersNode);
                XMLNode colEditorsNode = new XMLNode();
                colEditorsNode.setNodeName("SRFEXDATAGRIDCOLUMNEDITORS");
                rootNode.AddNode(colEditorsNode);
                if (!StringHelper.IsNullOrEmpty((String)dataGridModelConfig.getSortField()) && (sortDEFHelper = iDEHelper.GetDEFHelper(dataGridModelConfig.getSortField())) != null) {
                    dsItemsNode.SetValue("SORTFIELD", sortDEFHelper.getName());
                    dsItemsNode.SetValue("SORTDESC", dataGridModelConfig.getSortDesc() ? "TRUE" : "FALSE");
                }
                XMLNode dgColumnsNode = new XMLNode();
                dgColumnsNode.setNodeName("SRFEXDATAGRIDCOLUMNS");
                rootNode.AddNode(dgColumnsNode);
                XMLNode dsItemNode2 = new XMLNode();
                dsItemNode2.setNodeName("SRFEXDATAGRIDDSITEM");
                dsItemsNode.AddNode(dsItemNode2);
                dsItemNode2.setID("SRFROWID");
                XMLNode dsItemParamsNode2 = new XMLNode();
                dsItemParamsNode2.setNodeName("SRFEXITEMPARAMS");
                dsItemNode2.AddNode(dsItemParamsNode2);
                for (IDEFHelper iDEFHelper : iDEHelper.GetDEFHelpers()) {
                    XMLNode dsItemNode3;
                    DGModeDetail dgModeDetail = (DGModeDetail)dgModeDetailMap.get(iDEFHelper.getName());
                    if (iDEFHelper.IsKeyDEField()) {
                        XMLNode dgEditItemNode;
                        dsItemNode3 = new XMLNode();
                        dsItemNode3.setNodeName("SRFEXDATAGRIDDSITEM");
                        dsItemsNode.AddNode(dsItemNode3);
                        dsItemNode3.setID(iDEFHelper.getName());
                        dsItemNode3.SetValue("ITEMFORMAT", iDEFHelper.getDGItem().GetItemFormat(dgModeDetail));
                        dsItemNode3.SetValue("KEY", "TRUE");
                        if (!StringHelper.IsNullOrEmpty((String)iDEFHelper.getDGItem().GetCustom(dgModeDetail))) {
                            dsItemNode3.SetValue("CUSTOM", iDEFHelper.getDGItem().GetCustom(dgModeDetail));
                        }
                        dsItemNode3.SetValue("DATATYPE", iDEFHelper.GetStdDataType());
                        if (iDEFHelper.getDGItem().isEnableEdit((DGModeDetail)dgModeDetailMap.get(iDEFHelper.getName())) && (dgEditItemNode = this.GetDGEditItemNode(iDEFHelper, (DGModeDetail)dgModeDetailMap.get(iDEFHelper.getName()))) != null) {
                            dsItemNode3.AddNode(dgEditItemNode);
                        }
                    }
                    if (!iDEFHelper.IsKeyDEField() && iDEFHelper.getDEField().isFKEY()) {
                        XMLNode dgEditItemNode;
                        dsItemNode3 = new XMLNode();
                        dsItemNode3.setNodeName("SRFEXDATAGRIDDSITEM");
                        dsItemsNode.AddNode(dsItemNode3);
                        dsItemNode3.setID(iDEFHelper.getName());
                        dsItemNode3.SetValue("ITEMFORMAT", iDEFHelper.getDGItem().GetItemFormat(dgModeDetail));
                        dsItemNode3.SetValue("DATATYPE", iDEFHelper.GetStdDataType());
                        if (!StringHelper.IsNullOrEmpty((String)iDEFHelper.getDGItem().GetCustom(dgModeDetail))) {
                            dsItemNode3.SetValue("CUSTOM", iDEFHelper.getDGItem().GetCustom(dgModeDetail));
                        }
                        if (iDEFHelper.IsEnableDEFieldPriv()) {
                            dsItemNode3.SetValue("PRIVILEGEID", StringHelper.Format((String)"%1$s|%2$s", (Object)iDEFHelper.getDEHelper().getId(), (Object)iDEFHelper.getId()));
                        }
                        boolean bEditItem = false;
                        if (outputColumnMap.containsKey(iDEFHelper.getName())) {
                            if (iDEFHelper.getDGItem().isEnableEdit((DGModeDetail)dgModeDetailMap.get(iDEFHelper.getName()))) {
                                bEditItem = true;
                            }
                        } else {
                            IPickupDEFHelper iPickupDEFHelper;
                            if (iDEFHelper.getDGItem().isEnableEdit((DGModeDetail)dgModeDetailMap.get(iDEFHelper.getName()))) {
                                bEditItem = true;
                            }
                            if (!bEditItem && outputColumnMap.containsKey((iPickupDEFHelper = (IPickupDEFHelper)iDEFHelper).GetPickupTextDEFHelper().getName()) && iPickupDEFHelper.GetPickupTextDEFHelper().getDGItem().isEnableEdit((DGModeDetail)dgModeDetailMap.get(iPickupDEFHelper.GetPickupTextDEFHelper().getName()))) {
                                bEditItem = true;
                            }
                        }
                        if (bEditItem && (dgEditItemNode = this.GetDGEditItemNode(iDEFHelper, (DGModeDetail)dgModeDetailMap.get(iDEFHelper.getName()))) != null) {
                            dsItemNode3.AddNode(dgEditItemNode);
                        }
                    }
                    if (!iDEFHelper.IsMajorDEField()) continue;
                    dsItemNode3 = new XMLNode();
                    dsItemNode3.setNodeName("SRFEXDATAGRIDDSITEM");
                    dsItemsNode.AddNode(dsItemNode3);
                    dsItemNode3.setID("SRFMAJORTEXT");
                    XMLNode dsItemParamsNode3 = new XMLNode();
                    dsItemParamsNode3.setNodeName("SRFEXITEMPARAMS");
                    dsItemNode3.AddNode(dsItemParamsNode3);
                    XMLNode dsItemParamNode = new XMLNode();
                    dsItemParamNode.setNodeName("SRFEXITEMPARAM");
                    dsItemParamsNode3.AddNode(dsItemParamNode);
                    dsItemParamNode.setID(iDEFHelper.getName());
                    dsItemParamNode.SetValue("ITEMFORMAT", iDEFHelper.getDGItem().GetItemFormat(dgModeDetail));
                }
                if (dataGrid.isENABLEGROUP()) {
                    String strGroupColumn = dataGrid.getGROUPCOLUMN();
                    rootNode.SetValue("GROUP", "TRUE");
                    XMLNode groupNode = new XMLNode();
                    groupNode.setNodeName("SRFEXDATAGRIDGROUP");
                    rootNode.AddNode(groupNode);
                    groupNode.SetValue("GROUPITEM", strGroupColumn);
                    groupNode.SetValue("GROUPDIR", dataGrid.getGROUPDIR());
                }
                String strColumnSupportCellEditTip = this.GetLocalization(iDEHelper, "CONTROL.DATAGRID.COLUMNCELLEDITABLE", "\u5217\u652f\u6301\u884c\u7f16\u8f91");
                String strAutoExpandColumn = dataGrid.getAUTOEXPANDCOLUMN();
                String strRowBodyColumn = dataGrid.getROWBODYFIELD();
                if (!StringHelper.IsNullOrEmpty((String)strRowBodyColumn) && StringHelper.IsNullOrEmpty((String)rootNode.GetExtValue("ROWCLASSHELPER", ""))) {
                    rootNode.SetValue("ROWCLASSHELPER", RowBodyDataGridRowClassHelper.class.getName());
                }
                HashMap<String, DevStyle> devStyleMap = new HashMap<String, DevStyle>();
                TreeMap<String, String> colRenderParams = new TreeMap<String, String>();
                for (DGModelColumnConfig columnConfig : dataGridModelConfig.getColumnsConfig()) {
                    XMLNode dgEditItemNode;
                    XMLNode colEditorNode;
                    String strDataType;
                    String strSort;
                    DGModeDetail dgModeDetail;
                    IDEFHelper iDEFHelper = iDEHelper.GetDEFHelper(columnConfig.getDEField());
                    if (iDEFHelper == null || (dgModeDetail = (DGModeDetail)dgModeDetailMap.get(columnConfig.getDEField().toUpperCase())) != null && dgModeDetail.isDISABLE()) continue;
                    boolean bAppendCodeList = true;
                    String strCustom = iDEFHelper.getDGItem().GetCustom(dgModeDetail);
                    if (!StringHelper.IsNullOrEmpty((String)strCustom)) {
                        bAppendCodeList = false;
                    }
                    XMLNode dgColumnNode = new XMLNode();
                    dgColumnNode.setNodeName("SRFEXDATAGRIDCOLUMN");
                    dgColumnsNode.AddNode(dgColumnNode);
                    dgColumnNode.setID(iDEFHelper.getName());
                    if (iDEFHelper.IsEnableDEFieldPriv()) {
                        dgColumnNode.SetValue("PRIVILEGEID", StringHelper.Format((String)"%1$s|%2$s", (Object)iDEFHelper.getDEHelper().getId(), (Object)iDEFHelper.getId()));
                    }
                    dgColumnNode.SetValue("CAPTION", iDEFHelper.getDGItem().GetCaption(dgModeDetail, this.strLanguage));
                    dgColumnNode.SetValue("EXCELCAPTION", iDEFHelper.getDGItem().GetCaption(dgModeDetail, this.strLanguage));
                    if (columnConfig.isLocked()) {
                        dgColumnNode.SetValue("LOCKED", "TRUE");
                    }
                    dgColumnNode.SetValue("WIDTH", StringHelper.Format((String)"%1$s", (Object)columnConfig.getWidth()));
                    dgColumnNode.SetValue("SORTABLE", iDEFHelper.getDGItem().isSortable(dgModeDetail) ? "TRUE" : "FALSE");
                    dgColumnNode.SetValue("DSITEM", iDEFHelper.getName());
                    dgColumnNode.SetValue("FIUPDATEMODE", iDEFHelper.getDGItem().GetFIUpdateMode(dgModeDetail, columnConfig.getFIUpdateMode()));
                    dgColumnNode.SetValue("GROUPCOLUMN", columnConfig.getGroupColumn());
                    if (columnConfig.isHidden()) {
                        dgColumnNode.SetValue("HIDDEN", "TRUE");
                    }
                    if (StringHelper.Compare((String)strRowBodyColumn, (String)iDEFHelper.getName(), (boolean)true) == 0) {
                        dgColumnNode.SetValue("ROWBODY", "TRUE");
                    }
                    dgColumnNode.SetValue("CELLPOS", columnConfig.getCellPos());
                    dgColumnNode.SetValue("CELLPADDING", columnConfig.getCellPadding());
                    String strCellStyle = "";
                    if (!StringHelper.IsNullOrEmpty((String)columnConfig.getCellStyleId())) {
                        DevStyle devStyle;
                        if (!devStyleMap.containsKey(columnConfig.getCellStyleId())) {
                            devStyle = new DevStyle();
                            devStyle.setDEVSTYLEID(columnConfig.getCellStyleId());
                            IDEDataCtrl devStyleDataCtrl = this.getDAGlobalHelper().getDAModelStorage().FindDEDataCtrl("DE0254", "SYSTEM", null);
                            CallResult callResult = devStyleDataCtrl.Get((BaseDataEntity)devStyle);
                            if (callResult.IsError()) {
                                log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u9884\u5b9a\u4e49\u6837\u5f0f[%1$s]\u5931\u8d25, %2$s", (Object)columnConfig.getCellStyleId(), (Object)callResult.getErrorInfo()));
                            } else {
                                devStyleMap.put(columnConfig.getCellStyleId(), devStyle);
                            }
                        }
                        if ((devStyle = (DevStyle)devStyleMap.get(columnConfig.getCellStyleId())) != null) {
                            strCellStyle = devStyle.getSTYLEPARAM();
                        }
                    }
                    if (!StringHelper.IsNullOrEmpty((String)strCellStyle)) {
                        strCellStyle = String.valueOf(strCellStyle) + ";";
                    }
                    strCellStyle = String.valueOf(strCellStyle) + columnConfig.getCellStyle();
                    dgColumnNode.SetValue("CELLSTYLE", strCellStyle);
                    String strAlign = iDEFHelper.getDGItem().GetAlign(dgModeDetail);
                    if (!StringHelper.IsNullOrEmpty((String)strAlign)) {
                        dgColumnNode.SetValue("ALIGN", strAlign);
                    }
                    if (!StringHelper.IsNullOrEmpty((String)(strSort = columnConfig.getSort()))) {
                        if (StringHelper.IsNullOrEmpty((String)columnConfig.getSortColumn())) {
                            dsItemsNode.SetValue("SORTFIELD", iDEFHelper.getName());
                        } else {
                            dsItemsNode.SetValue("SORTFIELD", columnConfig.getSortColumn());
                        }
                        if (StringHelper.Compare((String)strSort, (String)"DESC", (boolean)true) == 0) {
                            dsItemsNode.SetValue("SORTDESC", "TRUE");
                        } else {
                            dsItemsNode.SetValue("SORTDESC", "FALSE");
                        }
                    }
                    if (StringHelper.Compare((String)strAutoExpandColumn, (String)iDEFHelper.getName(), (boolean)true) == 0) {
                        dgColumnsNode.SetValue("AUTPEXPANDCOLUMN", strAutoExpandColumn);
                    }
                    String strColumnType = "";
                    colRenderParams.clear();
                    String strDGColRenderCustom = "";
                    strDGColRenderCustom = dgModeDetail != null && !StringHelper.IsNullOrEmpty((String)dgModeDetail.getDGCOLRENDERCUSTOM()) ? dgModeDetail.getDGCOLRENDERCUSTOM() : iDEFHelper.getDEField().getDGCOLRENDERCUSTOM();
                    if (StringHelper.IsNullOrEmpty((String)strDGColRenderCustom)) {
                        String strDGColRender = "";
                        strDGColRender = dgModeDetail != null && !StringHelper.IsNullOrEmpty((String)dgModeDetail.getDGCOLRENDER()) ? dgModeDetail.getDGCOLRENDER() : iDEFHelper.getDEField().getDGCOLRENDER();
                        if (!StringHelper.IsNullOrEmpty((String)strDGColRender)) {
                            DGColRenderConfig dgColRenderConfig = this.globalHelperEx.getDAConfigMgr().getDGColRenderMgr().FindDGColRenderConfig(strDGColRender);
                            if (dgColRenderConfig == null) {
                                log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u8868\u683c\u5217\u7ed8\u5236\u5668[%1$s]\u914d\u7f6e\u5931\u8d25", (Object)strDGColRender));
                                return null;
                            }
                            strDGColRenderCustom = dgColRenderConfig.getObject();
                        }
                    }
                    if (StringHelper.IsNullOrEmpty((String)strDGColRenderCustom) && !StringHelper.IsNullOrEmpty((String)iDEFHelper.GetCodeList()) && bAppendCodeList) {
                        CodeListConfig codeListConfig = this.globalHelperEx.getCodeListMgr().GetCodeListConfig(iDEFHelper.GetCodeList());
                        if (codeListConfig == null) {
                            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u4ee3\u7801\u8868[%1$s]", (Object)iDEFHelper.GetCodeList()));
                            return null;
                        }
                        if (!codeListConfig.getStringOrMode() && !codeListConfig.getNumberOrMode()) {
                            strDGColRenderCustom = "SA.SRFDA.Ctrl.DataGrid.CodeListColumnRender";
                            colRenderParams.put("CODELIST", iDEFHelper.GetCodeList());
                            bAppendCodeList = false;
                            strColumnType = "CODELIST";
                        }
                    }
                    if (StringHelper.IsNullOrEmpty((String)strDGColRenderCustom) && !iDEFHelper.IsKeyDEField() && !iDEFHelper.getDEField().isFKEY() && StringHelper.Compare((String)(strDataType = iDEFHelper.GetDataType()), (String)"PICKUPTEXT", (boolean)true) == 0) {
                        LinkDEFHelper linkDEFHelper = (LinkDEFHelper)iDEFHelper;
                        strDGColRenderCustom = "SA.SRFDA.Ctrl.DataGrid.PickupColumnRender";
                        colRenderParams.put("DEID", linkDEFHelper.GetRealDEFHelper().getDEHelper().getId());
                        String strURL = DefaultPageHelper.GetEditViewPage();
                        String strEditPageId = linkDEFHelper.GetRealDEFHelper().getDEHelper().GetInfoPageId();
                        if (!StringHelper.IsNullOrEmpty((String)strEditPageId)) {
                            Page editPage = this.globalHelperEx.getDAModelStorage().FindPage(strEditPageId);
                            if (editPage == null) {
                                log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u9875\u9762[%1$s]", (Object)strEditPageId));
                                return null;
                            }
                            strURL = editPage.GetTotalPagePath();
                        }
                        strURL = URLHelper.AppendURLSeperator((String)strURL);
                        strURL = String.valueOf(strURL) + StringHelper.Format((String)"SRFDEID=%1$s", (Object)linkDEFHelper.GetRealDEFHelper().getDEHelper().getId());
                        strURL = URLHelper.AppendURLSeperator((String)strURL);
                        strURL = String.valueOf(strURL) + linkDEFHelper.GetRealDEFHelper().getDEHelper().GetKeyDEFHelper().getName();
                        strURL = String.valueOf(strURL) + "=";
                        colRenderParams.put("DATALINKPATH", strURL);
                        bAppendCodeList = false;
                        strColumnType = "PICKUP";
                    }
                    if (!StringHelper.IsNullOrEmpty((String)strDGColRenderCustom)) {
                        XMLNode colRenderNode = new XMLNode();
                        colRenderNode.setNodeName("SRFEXDATAGRIDCOLUMNRENDER");
                        colRendersNode.AddNode(colRenderNode);
                        colRenderNode.setID(iDEFHelper.getName());
                        colRenderNode.SetValue("OBJECT", strDGColRenderCustom);
                        try {
                            String strRenderParam = iDEFHelper.getDEField().getDGCOLRENDERPARAM();
                            if (!StringHelper.IsNullOrEmpty((String)strRenderParam)) {
                                Properties renderParams = PropertiesHelper.Load((String)strRenderParam);
                                for (Object objKey : renderParams.keySet()) {
                                    colRenderNode.SetValue(objKey.toString(), PropertiesHelper.GetProperty((Properties)renderParams, (String)objKey.toString()));
                                }
                            }
                        }
                        catch (Exception ex) {
                            log.error((Object)ex);
                            return null;
                        }
                        for (String strParam : colRenderParams.keySet()) {
                            colRenderNode.SetValue(strParam, (String)colRenderParams.get(strParam));
                        }
                        dgColumnNode.SetValue("RENDERID", iDEFHelper.getName());
                        bAppendCodeList = false;
                    }
                    if (iDEFHelper.getDGItem().isEnableEdit(dgModeDetail) && (colEditorNode = this.globalHelperEx.getDAFormItemHelper().GetDGEditorNode(this.strPageModel, this.strLanguage, iDEHelper, iDEFHelper, dgModeDetail)) != null) {
                        colEditorNode.setID(iDEFHelper.getName());
                        colEditorsNode.AddNode(colEditorNode);
                        dgColumnNode.SetValue("EDITORID", iDEFHelper.getName());
                        if (StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
                            String strCaption = dgColumnNode.GetExtValue("CAPTION", "");
                            strCaption = String.valueOf(StringHelper.Format((String)"<IMG src=\"../sasrfex/images/default/icon_rowedit2.png\" align=\"absmiddle\" alt=\"%1$s\">&nbsp;", (Object)strColumnSupportCellEditTip)) + strCaption;
                            dgColumnNode.SetValue("CAPTION", strCaption);
                        }
                    }
                    if (!StringHelper.IsNullOrEmpty((String)strColumnType)) {
                        dgColumnNode.SetValue("COLUMNTYPE", strColumnType);
                    }
                    String strDGItemCustom = iDEFHelper.getDGItem().GetCustom(dgModeDetail);
                    if (iDEFHelper.IsKeyDEField() || iDEFHelper.getDEField().isFKEY()) continue;
                    String strDataType2 = iDEFHelper.GetDataType();
                    if (StringHelper.Compare((String)strDataType2, (String)"PICKUPTEXT", (boolean)true) == 0) {
                        IPickupDEFHelper pickupDEFHelper = null;
                        ILinkDEFHelper linkDEFHelper = (ILinkDEFHelper)iDEFHelper;
                        for (IDEFHelper iDEFTemp : iDEFHelper.getDEHelper().GetDEFHelpers()) {
                            if (!(iDEFTemp instanceof IPickupDEFHelper)) continue;
                            pickupDEFHelper = (IPickupDEFHelper)iDEFTemp;
                            if (pickupDEFHelper.GetPickupTextDEFHelper() == linkDEFHelper) break;
                            pickupDEFHelper = null;
                        }
                        if (pickupDEFHelper == null) {
                            log.error((Object)StringHelper.Format((String)"\u6ca1\u6709\u5b9e\u4f53\u5c5e\u6027[%1$s]\u76f8\u5173\u7684PICKUP\u5c5e\u6027", (Object)linkDEFHelper.GetFullName()));
                            return null;
                        }
                        XMLNode dsItemNode4 = new XMLNode();
                        dsItemNode4.setNodeName("SRFEXDATAGRIDDSITEM");
                        dsItemsNode.AddNode(dsItemNode4);
                        dsItemNode4.setID(iDEFHelper.getName());
                        if (iDEFHelper.IsEnableDEFieldPriv()) {
                            dsItemNode4.SetValue("PRIVILEGEID", StringHelper.Format((String)"%1$s|%2$s", (Object)iDEFHelper.getDEHelper().getId(), (Object)iDEFHelper.getId()));
                        }
                        String strDSItemFormat = "%1$s||SRF||%2$s";
                        dsItemNode4.SetValue("ITEMFORMAT", strDSItemFormat);
                        dsItemNode4.SetValue("EXCELFORMAT", "%1$s");
                        if (!StringHelper.IsNullOrEmpty((String)strDGItemCustom)) {
                            dsItemNode4.SetValue("CUSTOM", strDGItemCustom);
                        }
                        if (!StringHelper.IsNullOrEmpty((String)columnConfig.getSortColumn())) {
                            dsItemNode4.SetValue("SORTPARAM", columnConfig.getSortColumn());
                        }
                        XMLNode dsItemParamsNode4 = new XMLNode();
                        dsItemParamsNode4.setNodeName("SRFEXITEMPARAMS");
                        dsItemNode4.AddNode(dsItemParamsNode4);
                        XMLNode dsItemParamNode = new XMLNode();
                        dsItemParamNode.setNodeName("SRFEXITEMPARAM");
                        dsItemParamsNode4.AddNode(dsItemParamNode);
                        dsItemParamNode.setID(linkDEFHelper.getName());
                        dsItemParamNode = new XMLNode();
                        dsItemParamNode.setNodeName("SRFEXITEMPARAM");
                        dsItemParamsNode4.AddNode(dsItemParamNode);
                        dsItemParamNode.setID(pickupDEFHelper.getName());
                        continue;
                    }
                    XMLNode dsItemNode5 = new XMLNode();
                    dsItemNode5.setNodeName("SRFEXDATAGRIDDSITEM");
                    dsItemsNode.AddNode(dsItemNode5);
                    dsItemNode5.setID(iDEFHelper.getName());
                    if (iDEFHelper.IsEnableDEFieldPriv()) {
                        dsItemNode5.SetValue("PRIVILEGEID", StringHelper.Format((String)"%1$s|%2$s", (Object)iDEFHelper.getDEHelper().getId(), (Object)iDEFHelper.getId()));
                    }
                    dsItemNode5.SetValue("ITEMFORMAT", iDEFHelper.getDGItem().GetItemFormat(dgModeDetail));
                    if (!StringHelper.IsNullOrEmpty((String)strDGItemCustom)) {
                        dsItemNode5.SetValue("CUSTOM", strDGItemCustom);
                    }
                    String strCodeList = iDEFHelper.GetCodeList();
                    dsItemNode5.SetValue("EXCELCODELIST", strCodeList);
                    if (!StringHelper.IsNullOrEmpty((String)strCodeList) && bAppendCodeList) {
                        dsItemNode5.SetValue("CODELIST", strCodeList);
                    }
                    dsItemNode5.SetValue("DATATYPE", iDEFHelper.GetStdDataType());
                    if (iDEFHelper.getDGItem().isEnableEdit((DGModeDetail)dgModeDetailMap.get(iDEFHelper.getName())) && (dgEditItemNode = this.GetDGEditItemNode(iDEFHelper, (DGModeDetail)dgModeDetailMap.get(iDEFHelper.getName()))) != null) {
                        dsItemNode5.AddNode(dgEditItemNode);
                    }
                    if (StringHelper.IsNullOrEmpty((String)columnConfig.getSortColumn())) continue;
                    dsItemNode5.SetValue("SORTPARAM", columnConfig.getSortColumn());
                }
                if (bAppendTempDataDSItem) {
                    dsItemNode = new XMLNode();
                    dsItemNode.setNodeName("SRFEXDATAGRIDDSITEM");
                    dsItemsNode.AddNode(dsItemNode);
                    dsItemNode.setID("SRFDATEMPKEYID");
                }
                if (!bAppendMajorTextDSItem) break block122;
                dsItemNode = new XMLNode();
                dsItemNode.setNodeName("SRFEXDATAGRIDDSITEM");
                dsItemsNode.AddNode(dsItemNode);
                dsItemNode.setID(TAG_SRFDAMAJORTEXT);
                strInfoFields = iDEHelper.GetInfoFields();
                String strInfoFormat = iDEHelper.GetInfoFormat();
                if (StringHelper.IsNullOrEmpty((String)strInfoFormat)) {
                    strInfoFormat = "%1$s";
                }
                dsItemNode.SetValue("ITEMFORMAT", strInfoFormat);
                dsItemParamsNode = new XMLNode();
                dsItemParamsNode.setNodeName("SRFEXITEMPARAMS");
                dsItemNode.AddNode(dsItemParamsNode);
                if (!StringHelper.IsNullOrEmpty((String)strInfoFields)) break block123;
                IDEFHelper majorDEFHelper = iDEHelper.GetMajorDEFHelper();
                if (majorDEFHelper == null) break block122;
                XMLNode dsItemParamNode = new XMLNode();
                dsItemParamNode.setNodeName("SRFEXITEMPARAM");
                dsItemParamsNode.AddNode(dsItemParamNode);
                dsItemParamNode.setID(majorDEFHelper.getName());
                dsItemParamNode.SetValue("ITEMFORMAT", majorDEFHelper.getDGItem().GetItemFormat(null));
                String strCodeList = majorDEFHelper.GetCodeList();
                if (StringHelper.IsNullOrEmpty((String)strCodeList)) break block122;
                dsItemParamNode.SetValue("CODELIST", strCodeList);
                break block122;
            }
            String[] parts = strInfoFields.split("[|]");
            int i = 0;
            while (i < parts.length) {
                String strParam = parts[i];
                IDEFHelper iDEFHelper = iDEHelper.GetDEFHelper(strParam = strParam.trim());
                if (iDEFHelper != null) {
                    XMLNode dsItemParamNode = new XMLNode();
                    dsItemParamNode.setNodeName("SRFEXITEMPARAM");
                    dsItemParamsNode.AddNode(dsItemParamNode);
                    dsItemParamNode.setID(iDEFHelper.getName());
                    dsItemParamNode.SetValue("ITEMFORMAT", iDEFHelper.getDGItem().GetItemFormat(null));
                    String strCodeList = iDEFHelper.GetCodeList();
                    if (!StringHelper.IsNullOrEmpty((String)strCodeList)) {
                        dsItemParamNode.SetValue("CODELIST", strCodeList);
                    }
                }
                ++i;
            }
        }
        if (iDEHelper.GetUpdateDateDEFHelper() != null) {
            dsItemNode = new XMLNode();
            dsItemNode.setNodeName("SRFEXDATAGRIDDSITEM");
            dsItemsNode.AddNode(dsItemNode);
            dsItemNode.setID("SRFDAUPDATEDATE");
            dsItemNode.SetValue("DATATYPE", "DATETIME");
            XMLNode dsItemParamsNode = new XMLNode();
            dsItemParamsNode.setNodeName("SRFEXITEMPARAMS");
            dsItemNode.AddNode(dsItemParamsNode);
            XMLNode dsItemParamNode = new XMLNode();
            dsItemParamNode.setNodeName("SRFEXITEMPARAM");
            dsItemParamsNode.AddNode(dsItemParamNode);
            dsItemParamNode.setID(iDEHelper.GetUpdateDateDEFHelper().getName());
            XMLNode itemNode = new XMLNode();
            itemNode.setNodeName("SRFEXDATAGRIDEDITITEM");
            itemNode.SetValue("DBFIELD", "SRFDAUPDATEDATE");
            itemNode.SetValue("NAME", "\u6700\u540e\u66f4\u65b0\u65f6\u95f4");
            itemNode.SetValue("ALLOWEMPTY", "TRUE");
            dsItemNode.AddNode(itemNode);
        }
        String strExtDSItems = dataGrid.getEXTDSITEM();
        if (dgMode != null && !StringHelper.IsNullOrEmpty((String)dgMode.getEXTDSITEM())) {
            strExtDSItems = dgMode.getEXTDSITEM();
        }
        if (!StringHelper.IsNullOrEmpty((String)strExtDSItems)) {
            strExtDSItems = strExtDSItems.toUpperCase();
            TreeMap<String, String> outputDSItems = new TreeMap<String, String>();
            if (dsItemsNode.getChildNodes() != null) {
                int i = 0;
                while (i < dsItemsNode.getChildNodes().size()) {
                    outputDSItems.put(((XMLNode)dsItemsNode.getChildNodes().get(i)).getID().toUpperCase(), "");
                    ++i;
                }
            }
            String[] items = strExtDSItems.split("[;]");
            int i = 0;
            while (i < items.length) {
                if (!outputDSItems.containsKey(items[i])) {
                    IDEFHelper iDEFHelper = iDEHelper.GetDEFHelper(items[i]);
                    if (iDEFHelper == null) {
                        log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u989d\u5916\u8f93\u51fa\u8868\u683c\u6570\u636e\u9879[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)items[i]));
                    } else {
                        XMLNode dgEditItemNode;
                        DGModeDetail dgModeDetail = (DGModeDetail)dgModeDetailMap.get(iDEFHelper.getName());
                        XMLNode dsItemNode6 = new XMLNode();
                        dsItemNode6.setNodeName("SRFEXDATAGRIDDSITEM");
                        dsItemsNode.AddNode(dsItemNode6);
                        dsItemNode6.setID(iDEFHelper.getName());
                        if (iDEFHelper.IsEnableDEFieldPriv()) {
                            dsItemNode6.SetValue("PRIVILEGEID", StringHelper.Format((String)"%1$s|%2$s", (Object)iDEFHelper.getDEHelper().getId(), (Object)iDEFHelper.getId()));
                        }
                        dsItemNode6.SetValue("ITEMFORMAT", iDEFHelper.getDGItem().GetItemFormat(dgModeDetail));
                        if (!StringHelper.IsNullOrEmpty((String)iDEFHelper.getDGItem().GetCustom(dgModeDetail))) {
                            dsItemNode6.SetValue("CUSTOM", iDEFHelper.getDGItem().GetCustom(dgModeDetail));
                        }
                        dsItemNode6.SetValue("DATATYPE", iDEFHelper.GetStdDataType());
                        if (iDEFHelper.getDGItem().isEnableEdit((DGModeDetail)dgModeDetailMap.get(iDEFHelper.getName())) && (dgEditItemNode = this.GetDGEditItemNode(iDEFHelper, (DGModeDetail)dgModeDetailMap.get(iDEFHelper.getName()))) != null) {
                            dsItemNode6.AddNode(dgEditItemNode);
                        }
                    }
                }
                ++i;
            }
        }
        return rootNode;
    }

    public String GetEditViewToolbarConfigId(IDEHelper iDEHelper, Page page, Form form, boolean bEmbedMode, boolean bInfoMode) {
        String strToolbarConfigId = "";
        strToolbarConfigId = page == null ? StringHelper.Format((String)"DE%1$s.TB_%4$s_EDIT_%2$s_%3$s", (Object)iDEHelper.getId(), (Object)iDEHelper.getVersion(), (Object)(form == null ? 0 : form.getFMVERSION()), (Object)(bEmbedMode ? "EMBED" : "")) : StringHelper.Format((String)"DE%1$s.TB_PAGE_%5$s_%6$s_%4$s_EDIT_%2$s_%3$s", (Object)iDEHelper.getId(), (Object)iDEHelper.getVersion(), (Object)(form == null ? 0 : form.getFMVERSION()), (Object)(bEmbedMode ? "EMBED" : ""), (Object)page.getPAGEID(), (Object)page.getVERSION());
        strToolbarConfigId = bInfoMode ? String.valueOf(strToolbarConfigId) + "_1" : String.valueOf(strToolbarConfigId) + "_0";
        if (!StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
            strToolbarConfigId = String.valueOf(strToolbarConfigId) + StringHelper.Format((String)"_PM_%1$s", (Object)this.strPageModel);
        }
        if (!StringHelper.IsNullOrEmpty((String)this.strLanguage)) {
            strToolbarConfigId = String.valueOf(strToolbarConfigId) + StringHelper.Format((String)"_%1$s", (Object)this.strLanguage);
        }
        strToolbarConfigId = strToolbarConfigId.toUpperCase();
        String strTBFilePath = ConfigPathHelper.GetRuntimeToolbarConfigPath((String)this.globalHelperEx.GetAppRootPath(), (String)strToolbarConfigId);
        File file = new File(strTBFilePath);
        if (file.exists()) {
            return strToolbarConfigId;
        }
        try {
            XMLNode rootNode = this.OnGetEditViewToolbarConfig(iDEHelper, page, form, bEmbedMode, bInfoMode);
            if (!DAConfigHelper.ExportConfigFile((XMLNode)rootNode, (String)strTBFilePath)) {
                return "";
            }
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u5bfc\u51fa\u7f16\u8f91\u754c\u9762\u5de5\u5177\u680f\u914d\u7f6e\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
        }
        return strToolbarConfigId;
    }

    protected XMLNode OnGetEditViewToolbarConfig(IDEHelper iDEHelper, Page page, Form form, boolean bEmbedMode, boolean bInfoMode) throws Exception {
        IToolbarItemWriter group2Writer;
        XMLNode tbItemNode;
        XMLNode tbItemNode2;
        DefaultToolbarWriterContext tbWriterContext = this.CreateTBWriterContext();
        tbWriterContext.setPage(page);
        tbWriterContext.setDEHelper(iDEHelper);
        tbWriterContext.setViewStyle("EDITVIEW");
        tbWriterContext.setAttribute(TAG_INFOMODE, bInfoMode);
        XMLNode rootNode = new XMLNode();
        rootNode.setNodeName("SRFEXTOOLBAR");
        XMLNode tbItemsNode = new XMLNode();
        tbItemsNode.setNodeName(ToolbarItemsConfig.TAG_TOOLBARITEMS);
        rootNode.AddNode(tbItemsNode);
        Toolbar toolbar = null;
        if (page != null) {
            String strToolbarId = page.getTOOLBARID();
            if (!StringHelper.IsNullOrEmpty((String)strToolbarId) && (toolbar = this.globalHelperEx.getDAModelStorage().FindToolbar(strToolbarId)) == null) {
                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5de5\u5177\u680f[%1$s]\u914d\u7f6e", (Object)strToolbarId));
            }
            String strTBTEMPLID = "";
            if (toolbar != null) {
                strTBTEMPLID = toolbar.getTBTEMPLID();
            }
            if (StringHelper.IsNullOrEmpty((String)strTBTEMPLID)) {
                strTBTEMPLID = page.GetParamStringValue("TBTEMPLID", "");
            }
            ToolbarConfig tbConfig = null;
            if (StringHelper.IsNullOrEmpty((String)strTBTEMPLID)) {
                if (toolbar != null && toolbar.getNODEFAULT()) {
                    tbConfig = toolbar.getToolbarConfig();
                }
            } else {
                TBTempl tbTempl = this.globalHelperEx.getDAModelStorage().FindTBTempl(strTBTEMPLID);
                if (tbTempl == null) {
                    throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5de5\u5177\u680f\u6a21\u677f[%1$s]\u914d\u7f6e", (Object)strTBTEMPLID));
                }
                tbConfig = tbTempl.getToolbarConfig();
            }
            if (tbConfig != null) {
                tbWriterContext.setToolbar(toolbar);
                CallResult callResult = this.ExportToolbar(rootNode, tbItemsNode, tbConfig, tbWriterContext);
                if (callResult.IsError()) {
                    throw new Exception(StringHelper.Format((String)"\u5bfc\u51fa\u5de5\u5177\u680f\u53d1\u751f\u9519\u8bef,%1$s", (Object)callResult.getErrorInfo()));
                }
                return rootNode;
            }
        }
        XMLNode userToolbar = null;
        String strToolbarXML = "";
        if (form != null) {
            strToolbarXML = form.getFORMTOOLBAR();
        }
        userToolbar = DAConfigHelper.LoadToolbarConfig(strToolbarXML, page);
        boolean bNewButton = this.globalHelperEx.getWebExConfig().GetValue("SRFDA", "EDITVIEWENABLENEW", true);
        if (bNewButton) {
            bNewButton = iDEHelper.IsEnableUserCreate();
        }
        boolean bSaveButton = iDEHelper.IsEnableUserUpdate();
        boolean bSaveAndExitButton = iDEHelper.IsEnableUserUpdate();
        boolean bRemoveAndExitButton = this.globalHelperEx.getWebExConfig().GetValue("SRFDA", "EDITVIEWENABLEREMOVE", false);
        if (bRemoveAndExitButton) {
            bRemoveAndExitButton = iDEHelper.IsEnableUserDelete();
        }
        boolean bCopyButton = iDEHelper.IsEnableUserCreate();
        boolean bOtherAction = true;
        boolean bPrintAction = iDEHelper.IsEnablePrint();
        boolean bSaveAndNewButton = iDEHelper.IsEnableUserUpdate() && iDEHelper.IsEnableUserCreate();
        boolean bSaveAndStartWFButton = true;
        boolean bAppendDataNavBar = true;
        boolean bReplaceDefault = false;
        boolean bViewWFStepActor = this.getWFStepActorPlacement() == 1;
        boolean bViewWFStepData = this.getWFStepDataPlacement() == 1;
        boolean bHelpAction = iDEHelper.IsEnableHelp();
        boolean bCloseButton = false;
        boolean bUnlockButton = false;
        if (!StringHelper.IsNullOrEmpty((String)this.getPageModel())) {
            bAppendDataNavBar = false;
            bUnlockButton = this.globalHelperEx.getWebExConfig().GetValue("SRFDA", "EDITVIEWENABLEUNLOCK", bUnlockButton);
        }
        String strSaveAndStartWFHandler = "";
        if (iDEHelper.IsEnableWF()) {
            bSaveAndStartWFButton = iDEHelper.GetDEWF().getUSERSTART();
            strSaveAndStartWFHandler = iDEHelper.GetDEWF().GetWFParam("TBB.FORMSAVEANDSTARTWFHANDLER", "SA.SRFDA.WF.Ctrl.Toolbar.FormSaveAndStartWFHandler");
        }
        if (StringHelper.Compare((String)iDEHelper.GetProperty("MULTIFORM"), (String)"TRUE", (boolean)true) == 0) {
            bAppendDataNavBar = false;
        }
        if (toolbar != null) {
            tbWriterContext.setToolbar(toolbar);
            if (!toolbar.isNEWACTIONNull()) {
                bNewButton = toolbar.getNEWACTION();
            }
            if (!toolbar.isSAVEACTIONNull()) {
                bSaveButton = toolbar.getSAVEACTION();
            }
            if (!toolbar.isSAVEANDEXITACTIONNull()) {
                bSaveAndExitButton = toolbar.getSAVEANDEXITACTION();
            }
            if (!toolbar.isSAVEANDNEWACTIONNull()) {
                bSaveAndNewButton = toolbar.getSAVEANDNEWACTION();
            }
            if (!toolbar.isHELPACTIONNull()) {
                bHelpAction = toolbar.getHELPACTION();
            }
            if (!toolbar.isREMOVEANDEXITACTIONNull()) {
                bRemoveAndExitButton = toolbar.getREMOVEANDEXITACTION();
            }
            if (!toolbar.isCOPYACTIONNull()) {
                bCopyButton = toolbar.getCOPYACTION();
            }
            if (!toolbar.isOTHERACTIONNull()) {
                bOtherAction = toolbar.getOTHERACTION();
            }
            if (!toolbar.isPRINTACTIONNull()) {
                bPrintAction = toolbar.getPRINTACTION();
            }
            if (!toolbar.isSAVEANDSTARTWFACTIONNull()) {
                bSaveAndStartWFButton = toolbar.getSAVEANDSTARTWFACTION();
            }
            if (!toolbar.isVIEWWFSTEPACTORNull()) {
                bViewWFStepActor = toolbar.getVIEWWFSTEPACTOR();
            }
            if (!toolbar.isDATANAVBARNull()) {
                bAppendDataNavBar = toolbar.getDATANAVBAR();
            }
            if (!toolbar.isINFOMODENull()) {
                bInfoMode = toolbar.getINFOMODE();
            }
        }
        if (userToolbar != null) {
            if (bReplaceDefault = userToolbar.GetExtValue(TAG_SRFREPLACEDEFAULT, bReplaceDefault)) {
                userToolbar.setNodeName("SRFEXTOOLBAR");
                return userToolbar;
            }
            if (bInfoMode = userToolbar.GetExtValue(TAG_INFOMODE, bInfoMode)) {
                bRemoveAndExitButton = false;
            }
            bNewButton = userToolbar.GetExtValue(TAG_NEWACTION, bNewButton);
            bSaveButton = userToolbar.GetExtValue(TAG_SAVEACTION, bSaveButton);
            bSaveAndExitButton = userToolbar.GetExtValue(TAG_SAVEANDEXITACTION, bSaveAndExitButton);
            bSaveAndNewButton = userToolbar.GetExtValue(TAG_SAVEANDNEWACTION, bSaveAndNewButton);
            bHelpAction = userToolbar.GetExtValue(TAG_HELPACTION, bHelpAction);
            bRemoveAndExitButton = userToolbar.GetExtValue(TAG_REMOVEANDEXITACTION, bRemoveAndExitButton);
            bCopyButton = userToolbar.GetExtValue(TAG_COPYACTION, bCopyButton);
            bOtherAction = userToolbar.GetExtValue(TAG_OTHERACTION, bOtherAction);
            bPrintAction = userToolbar.GetExtValue(TAG_PRINTACTION, bPrintAction);
            bSaveAndStartWFButton = userToolbar.GetExtValue(TAG_SAVEANDSTARTWFACTION, bSaveAndStartWFButton);
            bViewWFStepActor = userToolbar.GetExtValue(TAG_VIEWWFSTEPACTOR, bViewWFStepActor);
            bViewWFStepData = userToolbar.GetExtValue(TAG_VIEWWFSTEPDATA, bViewWFStepData);
            bAppendDataNavBar = userToolbar.GetExtValue(TAG_DATANAVBAR, bAppendDataNavBar);
        } else if (bInfoMode) {
            bRemoveAndExitButton = false;
        }
        IToolbarItemWriter group1Writer = this.FindDEBHGroupToolbarItemWriter("1");
        if (group1Writer != null) {
            TBItemConfig tbItemConfig = new TBItemConfig();
            tbItemConfig.setSeperator("LAST");
            group1Writer.Export(rootNode, tbItemsNode, tbItemConfig, null, (IToolbarItemWriterContext)tbWriterContext, false);
        }
        if (!bInfoMode) {
            if (bUnlockButton) {
                tbItemNode2 = new XMLNode();
                tbItemNode2.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
                tbItemsNode.AddNode(tbItemNode2);
                if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) == 0) {
                    tbItemNode2.SetValue("IMAGE", "../sasrfex/images/default/icon_unlock.png");
                }
                tbItemNode2.SetValue(ToolbarButtonConfig.TAG_TEXT, this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"EDITVIEW", (String)"UNLOCK"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"UNLOCK"), "\u89e3\u9501"));
                tbItemNode2.SetValue("TIPS", this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"EDITVIEW", (String)"UNLOCK"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"UNLOCK"), "\u89e3\u9501\u6570\u636e"));
                tbItemNode2.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.FormUnlockHandler"));
                tbItemNode2.SetValue("ENABLETOGGLE", "TRUE");
                DAConfigHelper.AddToolbarSeperator(tbItemsNode);
            }
            if (bSaveButton) {
                tbItemNode2 = new XMLNode();
                tbItemNode2.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
                tbItemsNode.AddNode(tbItemNode2);
                if (StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
                    tbItemNode2.SetValue("ICONCSSCLASS", "sx-tb-save");
                }
                if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) == 0) {
                    tbItemNode2.SetValue("IMAGE", "../sasrfex/images/default/icon_save.png");
                }
                tbItemNode2.SetValue(ToolbarButtonConfig.TAG_TEXT, this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"EDITVIEW", (String)"SAVE"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"SAVE"), "\u4fdd\u5b58"));
                tbItemNode2.SetValue("TIPS", this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"EDITVIEW", (String)"SAVE"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"SAVE"), "\u4fdd\u5b58\u5f53\u524d\u6570\u636e"));
                tbItemNode2.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.FormSaveHandler"));
                if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) == 0) {
                    tbItemNode2.SetValue("HANDLERTYPE", "EDITVIEW_SAVEACTION");
                }
                tbItemNode2.SetValue("IMPORTANCE", "HIGH");
            }
            if (bSaveAndNewButton && !bEmbedMode) {
                tbItemNode2 = new XMLNode();
                tbItemNode2.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
                tbItemsNode.AddNode(tbItemNode2);
                if (StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
                    tbItemNode2.SetValue("ICONCSSCLASS", "sx-tb-saveandnew");
                }
                if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) == 0) {
                    tbItemNode2.SetValue("IMAGE", "../sasrfex/images/default/icon_saveandnew.png");
                }
                tbItemNode2.SetValue(ToolbarButtonConfig.TAG_TEXT, this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"EDITVIEW", (String)"SAVEANDNEW"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"SAVEANDNEW"), "\u4fdd\u5b58\u5e76\u65b0\u5efa"));
                tbItemNode2.SetValue("TIPS", this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"EDITVIEW", (String)"SAVEANDNEW"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"SAVEANDNEW"), "\u4fdd\u5b58\u5e76\u65b0\u5efa\u6570\u636e"));
                tbItemNode2.SetValue("SAVEANDNEW", "TRUE");
                tbItemNode2.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.FormSaveHandler"));
                if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) == 0) {
                    tbItemNode2.SetValue("HANDLERTYPE", "EDITVIEW_SAVEACTION");
                }
            }
            if (bSaveAndExitButton && !bEmbedMode) {
                tbItemNode2 = new XMLNode();
                tbItemNode2.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
                tbItemsNode.AddNode(tbItemNode2);
                if (StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
                    tbItemNode2.SetValue("ICONCSSCLASS", "sx-tb-saveandclose");
                }
                if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) == 0) {
                    tbItemNode2.SetValue("IMAGE", "../sasrfex/images/default/icon_saveandclose.png");
                }
                tbItemNode2.SetValue(ToolbarButtonConfig.TAG_TEXT, this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"EDITVIEW", (String)"SAVEANDCLOSE"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"SAVEANDCLOSE"), "\u4fdd\u5b58\u5e76\u5173\u95ed"));
                tbItemNode2.SetValue("TIPS", this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"EDITVIEW", (String)"SAVEANDCLOSE"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"SAVEANDCLOSE"), "\u4fdd\u5b58\u5e76\u5173\u95ed\u7a97\u53e3"));
                tbItemNode2.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.FormSaveHandler"));
                tbItemNode2.SetValue("SAVEANDCLOSE", "TRUE");
                tbItemNode2.SetValue("IMPORTANCE", "HIGH");
            }
            if (bSaveButton || bSaveAndExitButton) {
                tbItemNode2 = new XMLNode();
                tbItemNode2.setNodeName(ToolbarSeperatorConfig.TAG_TOOLBARSEPARATOR);
                tbItemsNode.AddNode(tbItemNode2);
            }
            if (bRemoveAndExitButton && !bEmbedMode) {
                tbItemNode2 = new XMLNode();
                tbItemNode2.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
                tbItemsNode.AddNode(tbItemNode2);
                if (StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
                    tbItemNode2.SetValue("ICONCSSCLASS", "sx-tb-delete");
                }
                if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) == 0) {
                    tbItemNode2.SetValue("IMAGE", "../sasrfex/images/default/icon_delete.png");
                }
                tbItemNode2.SetValue(ToolbarButtonConfig.TAG_TEXT, this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"EDITVIEW", (String)"REMOVEANDCLOSE"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"REMOVEANDCLOSE"), "\u5220\u9664\u5e76\u5173\u95ed"));
                tbItemNode2.SetValue("TIPS", this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"EDITVIEW", (String)"REMOVEANDCLOSE"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"REMOVEANDCLOSE"), "\u5220\u9664\u5e76\u5173\u95ed\u7a97\u53e3"));
                tbItemNode2.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.FormRemoveHandler"));
                DAConfigHelper.AddToolbarSeperator(tbItemsNode);
            }
        } else {
            if (!bEmbedMode) {
                tbItemNode2 = new XMLNode();
                tbItemNode2.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
                tbItemsNode.AddNode(tbItemNode2);
                if (StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
                    tbItemNode2.SetValue("ICONCSSCLASS", "sx-tb-cancel");
                }
                if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) == 0) {
                    tbItemNode2.SetValue("IMAGE", "../sasrfex/images/default/icon_cancel.png");
                }
                tbItemNode2.SetValue(ToolbarButtonConfig.TAG_TEXT, this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"EDITVIEW", (String)"CLOSE"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"CLOSE"), "\u5173\u95ed"));
                tbItemNode2.SetValue("TIPS", this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"EDITVIEW", (String)"CLOSE"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"CLOSE"), "\u5173\u95ed\u7a97\u53e3"));
                tbItemNode2.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.FormCloseHandler"));
                DAConfigHelper.AddToolbarSeperator(tbItemsNode);
            }
            if (bRemoveAndExitButton && !bEmbedMode) {
                tbItemNode2 = new XMLNode();
                tbItemNode2.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
                tbItemsNode.AddNode(tbItemNode2);
                if (StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
                    tbItemNode2.SetValue("ICONCSSCLASS", "sx-tb-delete");
                }
                if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) == 0) {
                    tbItemNode2.SetValue("IMAGE", "../sasrfex/images/default/icon_delete.png");
                }
                tbItemNode2.SetValue(ToolbarButtonConfig.TAG_TEXT, this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"EDITVIEW", (String)"REMOVEANDCLOSE"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"REMOVEANDCLOSE"), "\u5220\u9664\u5e76\u5173\u95ed"));
                tbItemNode2.SetValue("TIPS", this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"EDITVIEW", (String)"REMOVEANDCLOSE"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"REMOVEANDCLOSE"), "\u5220\u9664\u5e76\u5173\u95ed\u7a97\u53e3"));
                tbItemNode2.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.FormRemoveHandler"));
                DAConfigHelper.AddToolbarSeperator(tbItemsNode);
            }
        }
        if (iDEHelper.IsEnableWF()) {
            String strWFIAPAGE;
            Page actionPage;
            Object strTextTip;
            String strText;
            XMLNode tbItemNode3;
            if (bSaveAndStartWFButton) {
                String strWFFirstAction = iDEHelper.GetDEWF().GetWFFIRSTACTION(this.strLanguage);
                tbItemNode3 = new XMLNode();
                tbItemNode3.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
                tbItemsNode.AddNode(tbItemNode3);
                if (StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
                    tbItemNode3.SetValue("ICONCSSCLASS", "sx-tb-saveandstart");
                }
                if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) == 0) {
                    tbItemNode3.SetValue("IMAGE", "../sasrfex/images/default/icon_saveandstart.png");
                }
                strText = "";
                strText = StringHelper.IsNullOrEmpty((String)strWFFirstAction) ? this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"EDITVIEW", (String)"STARTWF"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"STARTWF"), "\u5f00\u59cb\u6d41\u7a0b") : strWFFirstAction;
                tbItemNode3.SetValue(ToolbarButtonConfig.TAG_TEXT, strText);
                tbItemNode3.SetValue("TIPS", strText);
                tbItemNode3.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, strSaveAndStartWFHandler));
                if (!StringHelper.IsNullOrEmpty((String)iDEHelper.GetDEWF().getSTARTACTIONFORMID())) {
                    tbItemNode3.SetValue("WFSTARTFORM", "TRUE");
                    String strStartPageId = iDEHelper.GetDEWF().getSTARTACTIONPAGEID();
                    if (!StringHelper.IsNullOrEmpty((String)strStartPageId)) {
                        IPageHelper iStartPageHelper = this.getDAGlobalHelper().getDAModelStorage().FindPage2(strStartPageId);
                        tbItemNode3.SetValue("WFSTARTPAGE", iStartPageHelper.getFullPagePath());
                        if (iStartPageHelper.getWidth() > 0) {
                            tbItemNode3.SetValue("WFSTARTPAGEWIDTH", StringHelper.Format((String)"%1$s", (Object)iStartPageHelper.getWidth()));
                        }
                        if (iStartPageHelper.getHeight() > 0) {
                            tbItemNode3.SetValue("WFSTARTPAGEHEIGHT", StringHelper.Format((String)"%1$s", (Object)iStartPageHelper.getHeight()));
                        }
                    }
                }
            }
            if (bViewWFStepData) {
                String strWFStepDataPageId = this.OnGetWFStepDataGridViewPage();
                tbItemNode3 = new XMLNode();
                tbItemNode3.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
                tbItemsNode.AddNode(tbItemNode3);
                if (StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
                    tbItemNode3.SetValue("ICONCSSCLASS", "sx-tb-stepdata");
                }
                if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) == 0) {
                    tbItemNode3.SetValue("IMAGE", "../sasrfex/images/default/icon_stepactor.png");
                }
                strText = this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"EDITVIEW", (String)TAG_VIEWWFSTEPDATA), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)TAG_VIEWWFSTEPDATA), "\u6d41\u7a0b\u5904\u7406\u6b65\u9aa4");
                strTextTip = this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"EDITVIEW", (String)TAG_VIEWWFSTEPDATA), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)TAG_VIEWWFSTEPDATA), "\u6d41\u7a0b\u5904\u7406\u6b65\u9aa4");
                tbItemNode3.SetValue(ToolbarButtonConfig.TAG_TEXT, strText);
                tbItemNode3.SetValue("TIPS", (String)strTextTip);
                tbItemNode3.SetValue("WFIAPAGE", strWFStepDataPageId);
                if (!StringHelper.IsNullOrEmpty((String)this.getPageModel()) && (actionPage = this.globalHelperEx.getDAModelStorage().FindPage(strWFStepDataPageId)) != null) {
                    strWFIAPAGE = actionPage.GetTotalPagePath();
                    tbItemNode3.SetValue("WFIAPAGE", strWFIAPAGE);
                    if (actionPage.getWIDTH() > 0) {
                        tbItemNode3.SetValue("WFIAPAGEWIDTH", StringHelper.Format((String)"%1$s", (Object)actionPage.getWIDTH()));
                    }
                    if (actionPage.getHEIGHT() > 0) {
                        tbItemNode3.SetValue("WFIAPAGEHEIGHT", StringHelper.Format((String)"%1$s", (Object)actionPage.getHEIGHT()));
                    }
                }
                tbItemNode3.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.WF.Ctrl.Toolbar.FormViewWFStepDataHandler"));
            }
            if (bViewWFStepActor) {
                String strWFStepActorPageId = this.OnGetWFStepActorGridViewPage();
                tbItemNode3 = new XMLNode();
                tbItemNode3.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
                tbItemsNode.AddNode(tbItemNode3);
                if (StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
                    tbItemNode3.SetValue("ICONCSSCLASS", "sx-tb-stepactor");
                }
                if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) == 0) {
                    tbItemNode3.SetValue("IMAGE", "../sasrfex/images/default/icon_stepactor.png");
                }
                strText = this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"EDITVIEW", (String)"VIEWWFSTEP"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"VIEWWFSTEP"), "\u5f53\u524d\u6d41\u7a0b\u6b65\u9aa4");
                strTextTip = this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"EDITVIEW", (String)"VIEWWFSTEP"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"VIEWWFSTEP"), "\u5f53\u524d\u6d41\u7a0b\u6b65\u9aa4");
                tbItemNode3.SetValue(ToolbarButtonConfig.TAG_TEXT, strText);
                tbItemNode3.SetValue("TIPS", (String)strTextTip);
                tbItemNode3.SetValue("WFIAPAGE", strWFStepActorPageId);
                if (!StringHelper.IsNullOrEmpty((String)this.getPageModel()) && (actionPage = this.globalHelperEx.getDAModelStorage().FindPage(strWFStepActorPageId)) != null) {
                    strWFIAPAGE = actionPage.GetTotalPagePath();
                    tbItemNode3.SetValue("WFIAPAGE", strWFIAPAGE);
                    if (actionPage.getWIDTH() > 0) {
                        tbItemNode3.SetValue("WFIAPAGEWIDTH", StringHelper.Format((String)"%1$s", (Object)actionPage.getWIDTH()));
                    }
                    if (actionPage.getHEIGHT() > 0) {
                        tbItemNode3.SetValue("WFIAPAGEHEIGHT", StringHelper.Format((String)"%1$s", (Object)actionPage.getHEIGHT()));
                    }
                }
                tbItemNode3.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.WF.Ctrl.Toolbar.FormViewWFStepActorHandler"));
            }
            if (bSaveAndStartWFButton || bViewWFStepData || bViewWFStepActor) {
                tbItemNode2 = new XMLNode();
                tbItemNode2.setNodeName(ToolbarSeperatorConfig.TAG_TOOLBARSEPARATOR);
                tbItemsNode.AddNode(tbItemNode2);
            }
        }
        if (!bInfoMode) {
            if (bNewButton && !bEmbedMode) {
                tbItemNode2 = new XMLNode();
                tbItemNode2.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
                tbItemsNode.AddNode(tbItemNode2);
                if (StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
                    tbItemNode2.SetValue("ICONCSSCLASS", "sx-tb-new");
                }
                if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) == 0) {
                    tbItemNode2.SetValue("IMAGE", "../sasrfex/images/default/icon_new.png");
                }
                tbItemNode2.SetValue(ToolbarButtonConfig.TAG_TEXT, this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"EDITVIEW", (String)"NEW"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"NEW"), "\u65b0\u5efa"));
                tbItemNode2.SetValue("TIPS", this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"EDITVIEW", (String)"NEW"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"NEW"), "\u65b0\u5efa\u6570\u636e"));
                tbItemNode2.SetValue("RESOURCEID", UniResHelper.GetDEDataResId((String)iDEHelper.getId(), (String)"CREATE"));
                tbItemNode2.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.FormNewHandler"));
                if (!StringHelper.IsNullOrEmpty((String)this.getPageModel())) {
                    this.RebuildEditViewNewAction(tbItemsNode, tbItemNode2, iDEHelper);
                }
                DAConfigHelper.AddToolbarSeperator(tbItemsNode);
            }
            if (bCopyButton && !bEmbedMode) {
                tbItemNode2 = new XMLNode();
                tbItemNode2.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
                tbItemsNode.AddNode(tbItemNode2);
                if (StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
                    tbItemNode2.SetValue("ICONCSSCLASS", "sx-tb-copy");
                }
                if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) == 0) {
                    tbItemNode2.SetValue("IMAGE", "../sasrfex/images/default/icon_copy.png");
                }
                tbItemNode2.SetValue(ToolbarButtonConfig.TAG_TEXT, this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"EDITVIEW", (String)"COPY"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"COPY"), "\u62f7\u8d1d"));
                String strCopyTooltip = this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"EDITVIEW", (String)"COPY"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"COPY"), "\u62f7\u8d1d%1$s");
                tbItemNode2.SetValue("TIPS", StringHelper.Format((String)strCopyTooltip, (Object)iDEHelper.getLogicName(this.strLanguage)));
                tbItemNode2.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.FormCopyHandler"));
                DAConfigHelper.AddToolbarSeperator(tbItemsNode);
            }
        }
        if (bPrintAction) {
            tbItemNode2 = new XMLNode();
            tbItemNode2.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
            tbItemsNode.AddNode(tbItemNode2);
            if (StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
                tbItemNode2.SetValue("ICONCSSCLASS", "sx-tb-print");
            }
            if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) == 0) {
                tbItemNode2.SetValue("IMAGE", "../sasrfex/images/default/icon_print.png");
            }
            tbItemNode2.SetValue(ToolbarButtonConfig.TAG_TEXT, this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"EDITVIEW", (String)"PRINT"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"PRINT"), "\u6253\u5370"));
            tbItemNode2.SetValue("TIPS", this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"EDITVIEW", (String)"PRINT"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"PRINT"), "\u6253\u5370\u5f53\u524d\u6570\u636e"));
            tbItemNode2.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.FormPrintHandler"));
        }
        if (bPrintAction) {
            tbItemNode2 = new XMLNode();
            tbItemNode2.setNodeName(ToolbarSeperatorConfig.TAG_TOOLBARSEPARATOR);
            tbItemsNode.AddNode(tbItemNode2);
        }
        XMLNode userOtherAction = null;
        if (userToolbar != null && userToolbar.getChildNodes() != null) {
            boolean bAppendSeperator = false;
            for (XMLNode child : userToolbar.getChildNodes()) {
                String strID = child.getID();
                if (StringHelper.Compare((String)strID, (String)TAG_OTHERACTION, (boolean)true) != 0) {
                    if (StringHelper.Compare((String)child.getNodeName(), (String)"SRFDATBITEM", (boolean)true) == 0) {
                        bAppendSeperator = true;
                        this.ExportTBItem(rootNode, tbItemsNode, child, false, tbWriterContext, false);
                        continue;
                    }
                    int nPos = child.GetExtValue(TAG_POS, -1);
                    if (nPos == -1) {
                        bAppendSeperator = true;
                        tbItemsNode.AddNode(child);
                        continue;
                    }
                    tbItemsNode.AddNode(nPos, child);
                    continue;
                }
                userOtherAction = child;
            }
            if (bAppendSeperator) {
                tbItemNode = new XMLNode();
                tbItemNode.setNodeName(ToolbarSeperatorConfig.TAG_TOOLBARSEPARATOR);
                tbItemsNode.AddNode(tbItemNode);
            }
        }
        if ((group2Writer = this.FindDEBHGroupToolbarItemWriter("2")) != null) {
            TBItemConfig tbItemConfig = new TBItemConfig();
            tbItemConfig.setSeperator("LAST");
            group2Writer.Export(rootNode, tbItemsNode, tbItemConfig, null, (IToolbarItemWriterContext)tbWriterContext, false);
        }
        if (bOtherAction) {
            IToolbarItemWriter group4Writer;
            tbItemNode = new XMLNode();
            tbItemNode.setNodeName(ToolbarSplitButtonConfig.TAG_TOOLBARSPLITBUTTON);
            tbItemNode.SetValue(ToolbarButtonConfig.TAG_TEXT, this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"EDITVIEW", (String)"OTHER"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"OTHER"), "\u5176\u5b83"));
            tbItemNode.SetValue("ICONCSSCLASS", "sx-tb-other");
            tbItemsNode.AddNode(tbItemNode);
            XMLNode tbMenusNode = new XMLNode();
            tbMenusNode.setNodeName("SRFEXMAINMENUEX");
            tbItemNode.AddNode(tbMenusNode);
            IToolbarItemWriter group3Writer = this.FindDEBHGroupToolbarItemWriter("3");
            if (group3Writer != null) {
                TBItemConfig tbItemConfig = new TBItemConfig();
                tbItemConfig.setSeperator("LAST");
                group3Writer.Export(rootNode, tbMenusNode, tbItemConfig, null, (IToolbarItemWriterContext)tbWriterContext, true);
            }
            if (userOtherAction != null && userOtherAction.getChildNodes() != null) {
                for (XMLNode child : userOtherAction.getChildNodes()) {
                    if (StringHelper.Compare((String)child.getNodeName(), (String)"SRFDATBITEM", (boolean)true) == 0) {
                        this.ExportTBItem(rootNode, tbMenusNode, child, false, tbWriterContext, true);
                        continue;
                    }
                    tbMenusNode.AddNode(child);
                }
            }
            if ((group4Writer = this.FindDEBHGroupToolbarItemWriter("4")) != null) {
                TBItemConfig tbItemConfig = new TBItemConfig();
                tbItemConfig.setSeperator("FIRST");
                group4Writer.Export(rootNode, tbMenusNode, tbItemConfig, null, (IToolbarItemWriterContext)tbWriterContext, true);
            }
            if (tbMenusNode.getChildNodes() == null || tbMenusNode.getChildNodes().size() == 0) {
                tbItemsNode.RemoveNode(tbItemNode);
            } else {
                DAConfigHelper.AddToolbarSeperator(tbItemsNode);
            }
        }
        if (bAppendDataNavBar && !bEmbedMode) {
            tbItemNode = new XMLNode();
            tbItemNode.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
            tbItemsNode.AddNode(tbItemNode);
            if (StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
                tbItemNode.SetValue("ICONCSSCLASS", "x-tbar-page-first");
            }
            if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) == 0) {
                tbItemNode.SetValue("IMAGE", "../sasrfex/images/default/grid/icon_page-first.png");
            }
            tbItemNode.SetValue(ToolbarButtonConfig.TAG_TEXT, "");
            tbItemNode.SetValue("TIPS", this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"EDITVIEW", (String)"MOVEFIRST"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"MOVEFIRST"), "\u5b9a\u4f4d\u7b2c\u4e00\u6761\u6570\u636e"));
            tbItemNode.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.FormDataNavHandler"));
            tbItemNode.SetValue("NAVACTION", "FIRST");
            tbItemNode = new XMLNode();
            tbItemNode.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
            tbItemsNode.AddNode(tbItemNode);
            if (StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
                tbItemNode.SetValue("ICONCSSCLASS", "x-tbar-page-prev");
            }
            if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) == 0) {
                tbItemNode.SetValue("IMAGE", "../sasrfex/images/default/grid/icon_page-prev.png");
            }
            tbItemNode.SetValue(ToolbarButtonConfig.TAG_TEXT, "");
            tbItemNode.SetValue("TIPS", this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"EDITVIEW", (String)"MOVEPREV"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"MOVEPREV"), "\u5b9a\u4f4d\u4e0a\u4e00\u6761\u6570\u636e"));
            tbItemNode.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.FormDataNavHandler"));
            tbItemNode.SetValue("NAVACTION", "PREV");
            tbItemNode = new XMLNode();
            tbItemNode.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
            tbItemsNode.AddNode(tbItemNode);
            if (StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
                tbItemNode.SetValue("ICONCSSCLASS", "x-tbar-page-next");
            }
            if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) == 0) {
                tbItemNode.SetValue("IMAGE", "../sasrfex/images/default/grid/icon_page-next.png");
            }
            tbItemNode.SetValue(ToolbarButtonConfig.TAG_TEXT, "");
            tbItemNode.SetValue("TIPS", this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"EDITVIEW", (String)"MOVENEXT"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"MOVENEXT"), "\u5b9a\u4f4d\u4e0b\u4e00\u6761\u6570\u636e"));
            tbItemNode.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.FormDataNavHandler"));
            tbItemNode.SetValue("NAVACTION", "NEXT");
            tbItemNode = new XMLNode();
            tbItemNode.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
            tbItemsNode.AddNode(tbItemNode);
            if (StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
                tbItemNode.SetValue("ICONCSSCLASS", "x-tbar-page-last");
            }
            if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) == 0) {
                tbItemNode.SetValue("IMAGE", "../sasrfex/images/default/grid/icon_page-last.png");
            }
            tbItemNode.SetValue(ToolbarButtonConfig.TAG_TEXT, "");
            tbItemNode.SetValue("TIPS", this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"EDITVIEW", (String)"MOVELAST"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"MOVELAST"), "\u5b9a\u4f4d\u6700\u540e\u4e00\u6761\u6570\u636e"));
            tbItemNode.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.FormDataNavHandler"));
            tbItemNode.SetValue("NAVACTION", "LAST");
        }
        if (bAppendDataNavBar && !bEmbedMode) {
            tbItemNode = new XMLNode();
            tbItemNode.setNodeName(ToolbarSeperatorConfig.TAG_TOOLBARSEPARATOR);
            tbItemsNode.AddNode(tbItemNode);
        }
        if (bHelpAction) {
            tbItemNode = new XMLNode();
            tbItemNode.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
            tbItemsNode.AddNode(tbItemNode);
            if (StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
                tbItemNode.SetValue("ICONCSSCLASS", "sx-tb-help");
            }
            if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) == 0) {
                tbItemNode.SetValue("IMAGE", "../sasrfex/images/default/icon_help16.png");
            }
            tbItemNode.SetValue(ToolbarButtonConfig.TAG_TEXT, this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"EDITVIEW", (String)"HELP"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"HELP"), "\u5e2e\u52a9"));
            tbItemNode.SetValue("TIPS", this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"EDITVIEW", (String)"HELP"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"HELP"), "\u5e2e\u52a9"));
            tbItemNode.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.HelpHandler"));
            tbItemNode.SetValue("PAGETYPE", "EDITVIEW");
        }
        DAConfigHelper.EraseToolbarUnnecessarySeperator(rootNode);
        return rootNode;
    }

    public String GetWFEditViewToolbarConfigId(IDEHelper iDEHelper, Page page, Form form, boolean bStartWF, String strWFFirstAction) {
        String strToolbarConfigId = "";
        strToolbarConfigId = page == null ? StringHelper.Format((String)"DE%1$s.TB_%4$s_EDIT_%2$s_%3$s", (Object)iDEHelper.getId(), (Object)iDEHelper.getVersion(), (Object)(form == null ? 0 : form.getFMVERSION()), (Object)"WF") : StringHelper.Format((String)"DE%1$s.TB_PAGE_%5$s_%6$s_%4$s_EDIT_%2$s_%3$s", (Object)iDEHelper.getId(), (Object)iDEHelper.getVersion(), (Object)(form == null ? 0 : form.getFMVERSION()), (Object)"WF", (Object)page.getPAGEID(), (Object)page.getVERSION());
        if (!StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
            strToolbarConfigId = String.valueOf(strToolbarConfigId) + StringHelper.Format((String)"_PM_%1$s", (Object)this.strPageModel);
        }
        if (!StringHelper.IsNullOrEmpty((String)this.strLanguage)) {
            strToolbarConfigId = String.valueOf(strToolbarConfigId) + StringHelper.Format((String)"_%1$s", (Object)this.strLanguage);
        }
        strToolbarConfigId = strToolbarConfigId.toUpperCase();
        String strTBFilePath = ConfigPathHelper.GetRuntimeToolbarConfigPath((String)this.globalHelperEx.GetAppRootPath(), (String)strToolbarConfigId);
        File file = new File(strTBFilePath);
        if (file.exists()) {
            return strToolbarConfigId;
        }
        try {
            XMLNode rootNode = this.OnGetWFEditViewToolbarConfig(iDEHelper, page, form, bStartWF, strWFFirstAction);
            if (!DAConfigHelper.ExportConfigFile((XMLNode)rootNode, (String)strTBFilePath)) {
                return "";
            }
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u5bfc\u51fa\u6d41\u7a0b\u7f16\u8f91\u754c\u9762\u5de5\u5177\u680f\u914d\u7f6e\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
        }
        return strToolbarConfigId;
    }

    protected XMLNode OnGetWFEditViewToolbarConfig(IDEHelper iDEHelper, Page page, Form form, boolean bStartWF, String strWFFirstAction) throws Exception {
        String strWFIAPAGE;
        Page actionPage;
        Object strTextTip;
        String strText;
        XMLNode tbItemNode;
        XMLNode tbItemNode2;
        DefaultToolbarWriterContext tbWriterContext = this.CreateTBWriterContext();
        tbWriterContext.setPage(page);
        tbWriterContext.setDEHelper(iDEHelper);
        tbWriterContext.setViewStyle("EDITVIEW");
        XMLNode rootNode = new XMLNode();
        rootNode.setNodeName("SRFEXTOOLBAR");
        XMLNode tbItemsNode = new XMLNode();
        tbItemsNode.setNodeName(ToolbarItemsConfig.TAG_TOOLBARITEMS);
        rootNode.AddNode(tbItemsNode);
        XMLNode userToolbar = null;
        String strToolbarXML = "";
        if (form != null) {
            strToolbarXML = form.getFORMTOOLBAR();
        }
        userToolbar = DAConfigHelper.LoadToolbarConfig(strToolbarXML, page);
        boolean bSaveButton = true;
        boolean bSaveAndExitButton = true;
        boolean bOtherAction = true;
        boolean bPrintAction = iDEHelper.IsEnablePrint();
        boolean bSaveAndStartWFButton = true;
        boolean bHelpAction = iDEHelper.IsEnableHelp();
        boolean bViewWFStepActor = this.getWFStepActorPlacement() == 1;
        boolean bViewWFStepData = this.getWFStepDataPlacement() == 1;
        String strSaveAndStartWFHandler = "";
        if (iDEHelper.IsEnableWF()) {
            bSaveAndStartWFButton = iDEHelper.GetDEWF().getUSERSTART();
            strSaveAndStartWFHandler = iDEHelper.GetDEWF().GetWFParam("TBB.FORMSAVEANDSTARTWFHANDLER", "SA.SRFDA.WF.Ctrl.Toolbar.FormSaveAndStartWFHandler");
        } else {
            bViewWFStepActor = false;
            bViewWFStepData = false;
        }
        if (userToolbar != null) {
            bSaveButton = userToolbar.GetExtValue(TAG_SAVEACTION, bSaveButton);
            bSaveAndExitButton = userToolbar.GetExtValue(TAG_SAVEANDEXITACTION, bSaveAndExitButton);
            bSaveAndStartWFButton = userToolbar.GetExtValue(TAG_SAVEANDSTARTWFACTION, bSaveAndStartWFButton);
            bOtherAction = userToolbar.GetExtValue(TAG_OTHERACTION, bOtherAction);
            bPrintAction = userToolbar.GetExtValue(TAG_PRINTACTION, bPrintAction);
            bHelpAction = userToolbar.GetExtValue(TAG_HELPACTION, bHelpAction);
            bViewWFStepActor = userToolbar.GetExtValue(TAG_VIEWWFSTEPACTOR, bViewWFStepActor);
            bViewWFStepData = userToolbar.GetExtValue(TAG_VIEWWFSTEPDATA, bViewWFStepData);
        }
        if (bSaveButton) {
            tbItemNode2 = new XMLNode();
            tbItemNode2.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
            tbItemsNode.AddNode(tbItemNode2);
            tbItemNode2.SetValue("ICONCSSCLASS", "sx-tb-save");
            tbItemNode2.SetValue(ToolbarButtonConfig.TAG_TEXT, this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"EDITVIEW", (String)"SAVE"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"SAVE"), "\u4fdd\u5b58"));
            tbItemNode2.SetValue("TIPS", this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"EDITVIEW", (String)"SAVE"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"SAVE"), "\u4fdd\u5b58\u5f53\u524d\u6570\u636e"));
            tbItemNode2.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.FormSaveHandler"));
            tbItemNode2.SetValue("IMPORTANCE", "HIGH");
        }
        if (bSaveAndExitButton) {
            tbItemNode2 = new XMLNode();
            tbItemNode2.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
            tbItemsNode.AddNode(tbItemNode2);
            tbItemNode2.SetValue("ICONCSSCLASS", "sx-tb-save");
            tbItemNode2.SetValue(ToolbarButtonConfig.TAG_TEXT, this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"EDITVIEW", (String)"SAVEANDCLOSE"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"SAVEANDCLOSE"), "\u4fdd\u5b58\u5e76\u5173\u95ed"));
            tbItemNode2.SetValue("TIPS", this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"EDITVIEW", (String)"SAVEANDCLOSE"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"SAVEANDCLOSE"), "\u4fdd\u5b58\u5e76\u5173\u95ed\u7a97\u53e3"));
            tbItemNode2.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.FormSaveHandler"));
            tbItemNode2.SetValue("SAVEANDCLOSE", "TRUE");
            tbItemNode2.SetValue("IMPORTANCE", "HIGH");
        }
        if (bSaveButton || bSaveAndExitButton) {
            tbItemNode2 = new XMLNode();
            tbItemNode2.setNodeName(ToolbarSeperatorConfig.TAG_TOOLBARSEPARATOR);
            tbItemsNode.AddNode(tbItemNode2);
        }
        if (bSaveAndStartWFButton) {
            tbItemNode2 = new XMLNode();
            tbItemNode2.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
            tbItemsNode.AddNode(tbItemNode2);
            tbItemNode2.SetValue("ICONCSSCLASS", "sx-tb-save");
            String strText2 = "";
            strText2 = StringHelper.IsNullOrEmpty((String)strWFFirstAction) ? this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"EDITVIEW", (String)"STARTWF"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"STARTWF"), "\u5f00\u59cb\u6d41\u7a0b") : StringHelper.Format((String)"%1$s", (Object)strWFFirstAction);
            tbItemNode2.SetValue(ToolbarButtonConfig.TAG_TEXT, strText2);
            tbItemNode2.SetValue("TIPS", strText2);
            tbItemNode2.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, strSaveAndStartWFHandler));
            tbItemNode2.SetValue("SAVEANDCLOSE", "TRUE");
            if (!StringHelper.IsNullOrEmpty((String)iDEHelper.GetDEWF().getSTARTACTIONFORMID())) {
                tbItemNode2.SetValue("WFSTARTFORM", "TRUE");
                String strStartPageId = iDEHelper.GetDEWF().getSTARTACTIONPAGEID();
                if (!StringHelper.IsNullOrEmpty((String)strStartPageId)) {
                    IPageHelper iStartPageHelper = this.getDAGlobalHelper().getDAModelStorage().FindPage2(strStartPageId);
                    tbItemNode2.SetValue("WFSTARTPAGE", iStartPageHelper.getFullPagePath());
                    if (iStartPageHelper.getWidth() > 0) {
                        tbItemNode2.SetValue("WFSTARTPAGEWIDTH", StringHelper.Format((String)"%1$s", (Object)iStartPageHelper.getWidth()));
                    }
                    if (iStartPageHelper.getHeight() > 0) {
                        tbItemNode2.SetValue("WFSTARTPAGEHEIGHT", StringHelper.Format((String)"%1$s", (Object)iStartPageHelper.getHeight()));
                    }
                }
            }
            tbItemNode2.SetValue("IMPORTANCE", "HIGH");
        }
        if (bViewWFStepData) {
            String strWFStepDataPageId = this.OnGetWFStepDataGridViewPage();
            tbItemNode = new XMLNode();
            tbItemNode.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
            tbItemsNode.AddNode(tbItemNode);
            if (StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
                tbItemNode.SetValue("ICONCSSCLASS", "sx-tb-stepdata");
            }
            if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) == 0) {
                tbItemNode.SetValue("IMAGE", "../sasrfex/images/default/icon_stepactor.png");
            }
            strText = this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"EDITVIEW", (String)TAG_VIEWWFSTEPDATA), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)TAG_VIEWWFSTEPDATA), "\u6d41\u7a0b\u5904\u7406\u6b65\u9aa4");
            strTextTip = this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"EDITVIEW", (String)TAG_VIEWWFSTEPDATA), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)TAG_VIEWWFSTEPDATA), "\u6d41\u7a0b\u5904\u7406\u6b65\u9aa4");
            tbItemNode.SetValue(ToolbarButtonConfig.TAG_TEXT, strText);
            tbItemNode.SetValue("TIPS", (String)strTextTip);
            tbItemNode.SetValue("WFIAPAGE", strWFStepDataPageId);
            if (!StringHelper.IsNullOrEmpty((String)this.getPageModel()) && (actionPage = this.globalHelperEx.getDAModelStorage().FindPage(strWFStepDataPageId)) != null) {
                strWFIAPAGE = actionPage.GetTotalPagePath();
                tbItemNode.SetValue("WFIAPAGE", strWFIAPAGE);
                if (actionPage.getWIDTH() > 0) {
                    tbItemNode.SetValue("WFIAPAGEWIDTH", StringHelper.Format((String)"%1$s", (Object)actionPage.getWIDTH()));
                }
                if (actionPage.getHEIGHT() > 0) {
                    tbItemNode.SetValue("WFIAPAGEHEIGHT", StringHelper.Format((String)"%1$s", (Object)actionPage.getHEIGHT()));
                }
            }
            tbItemNode.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.WF.Ctrl.Toolbar.FormViewWFStepDataHandler"));
        }
        if (bViewWFStepActor) {
            String strWFStepActorPageId = this.OnGetWFStepActorGridViewPage();
            tbItemNode = new XMLNode();
            tbItemNode.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
            tbItemsNode.AddNode(tbItemNode);
            if (StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
                tbItemNode.SetValue("ICONCSSCLASS", "sx-tb-stepactor");
            }
            if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) == 0) {
                tbItemNode.SetValue("IMAGE", "../sasrfex/images/default/icon_stepactor.png");
            }
            strText = this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"EDITVIEW", (String)"VIEWWFSTEP"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"VIEWWFSTEP"), "\u5f53\u524d\u6d41\u7a0b\u6b65\u9aa4");
            strTextTip = this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"EDITVIEW", (String)"VIEWWFSTEP"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"VIEWWFSTEP"), "\u5f53\u524d\u6d41\u7a0b\u6b65\u9aa4");
            tbItemNode.SetValue(ToolbarButtonConfig.TAG_TEXT, strText);
            tbItemNode.SetValue("TIPS", (String)strTextTip);
            tbItemNode.SetValue("WFIAPAGE", strWFStepActorPageId);
            if (!StringHelper.IsNullOrEmpty((String)this.getPageModel()) && (actionPage = this.globalHelperEx.getDAModelStorage().FindPage(strWFStepActorPageId)) != null) {
                strWFIAPAGE = actionPage.GetTotalPagePath();
                tbItemNode.SetValue("WFIAPAGE", strWFIAPAGE);
                if (actionPage.getWIDTH() > 0) {
                    tbItemNode.SetValue("WFIAPAGEWIDTH", StringHelper.Format((String)"%1$s", (Object)actionPage.getWIDTH()));
                }
                if (actionPage.getHEIGHT() > 0) {
                    tbItemNode.SetValue("WFIAPAGEHEIGHT", StringHelper.Format((String)"%1$s", (Object)actionPage.getHEIGHT()));
                }
            }
            tbItemNode.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.WF.Ctrl.Toolbar.FormViewWFStepActorHandler"));
        }
        if (bSaveAndStartWFButton || bViewWFStepData || bViewWFStepActor) {
            tbItemNode2 = new XMLNode();
            tbItemNode2.setNodeName(ToolbarSeperatorConfig.TAG_TOOLBARSEPARATOR);
            tbItemsNode.AddNode(tbItemNode2);
        }
        if (bPrintAction) {
            tbItemNode2 = new XMLNode();
            tbItemNode2.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
            tbItemsNode.AddNode(tbItemNode2);
            tbItemNode2.SetValue("ICONCSSCLASS", "sx-tb-print");
            tbItemNode2.SetValue(ToolbarButtonConfig.TAG_TEXT, this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"EDITVIEW", (String)"PRINT"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"PRINT"), "\u6253\u5370"));
            tbItemNode2.SetValue("TIPS", this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"EDITVIEW", (String)"PRINT"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"PRINT"), "\u6253\u5370\u5f53\u524d\u6570\u636e"));
            tbItemNode2.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.FormPrintHandler"));
        }
        if (bPrintAction) {
            tbItemNode2 = new XMLNode();
            tbItemNode2.setNodeName(ToolbarSeperatorConfig.TAG_TOOLBARSEPARATOR);
            tbItemsNode.AddNode(tbItemNode2);
        }
        XMLNode userOtherAction = null;
        if (userToolbar != null && userToolbar.getChildNodes() != null) {
            boolean bAppendSeperator = false;
            for (XMLNode child : userToolbar.getChildNodes()) {
                String strID = child.getID();
                if (StringHelper.Compare((String)strID, (String)TAG_OTHERACTION, (boolean)true) != 0) {
                    if (StringHelper.Compare((String)child.getNodeName(), (String)"SRFDATBITEM", (boolean)true) == 0) {
                        bAppendSeperator = true;
                        this.ExportTBItem(rootNode, tbItemsNode, child, false, tbWriterContext, false);
                        continue;
                    }
                    int nPos = child.GetExtValue(TAG_POS, -1);
                    if (nPos == -1) {
                        bAppendSeperator = true;
                        tbItemsNode.AddNode(child);
                        continue;
                    }
                    tbItemsNode.AddNode(nPos, child);
                    continue;
                }
                userOtherAction = child;
            }
            if (bAppendSeperator) {
                XMLNode tbItemNode3 = new XMLNode();
                tbItemNode3.setNodeName(ToolbarSeperatorConfig.TAG_TOOLBARSEPARATOR);
                tbItemsNode.AddNode(tbItemNode3);
            }
        }
        if (bOtherAction) {
            XMLNode tbItemNode4 = new XMLNode();
            tbItemNode4.setNodeName(ToolbarSplitButtonConfig.TAG_TOOLBARSPLITBUTTON);
            tbItemNode4.SetValue(ToolbarButtonConfig.TAG_TEXT, this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"EDITVIEW", (String)"OTHER"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"OTHER"), "\u5176\u5b83"));
            tbItemNode4.SetValue("ICONCSSCLASS", "sx-tb-other");
            tbItemsNode.AddNode(tbItemNode4);
            XMLNode tbMenusNode = new XMLNode();
            tbMenusNode.setNodeName("SRFEXMAINMENUEX");
            tbItemNode4.AddNode(tbMenusNode);
            if (userOtherAction != null && userOtherAction.getChildNodes() != null) {
                for (XMLNode child : userOtherAction.getChildNodes()) {
                    if (StringHelper.Compare((String)child.getNodeName(), (String)"SRFDATBITEM", (boolean)true) == 0) {
                        this.ExportTBItem(rootNode, tbMenusNode, child, false, tbWriterContext, true);
                        continue;
                    }
                    tbMenusNode.AddNode(child);
                }
            }
            if (tbMenusNode.getChildNodes() == null || tbMenusNode.getChildNodes().size() == 0) {
                tbItemsNode.RemoveNode(tbItemNode4);
            } else {
                DAConfigHelper.AddToolbarSeperator(tbItemsNode);
            }
        }
        if (bHelpAction) {
            XMLNode tbItemNode5 = new XMLNode();
            tbItemNode5.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
            tbItemsNode.AddNode(tbItemNode5);
            tbItemNode5.SetValue("ICONCSSCLASS", "sx-tb-help");
            tbItemNode5.SetValue(ToolbarButtonConfig.TAG_TEXT, this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"EDITVIEW", (String)"HELP"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"HELP"), "\u5e2e\u52a9"));
            tbItemNode5.SetValue("TIPS", this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"EDITVIEW", (String)"HELP"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"HELP"), "\u5e2e\u52a9"));
            tbItemNode5.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.HelpHandler"));
            tbItemNode5.SetValue("PAGETYPE", "EDITVIEW");
        }
        DAConfigHelper.EraseToolbarUnnecessarySeperator(rootNode);
        return rootNode;
    }

    public static void EraseToolbarUnnecessarySeperator(XMLNode node) {
        if (node.getChildNodes() == null || node.getChildNodes().size() == 0) {
            return;
        }
        boolean bStop = false;
        block0: while (!bStop) {
            bStop = true;
            boolean bLastIsSeperator = false;
            int i = 0;
            while (i < node.getChildNodes().size()) {
                XMLNode childNode = (XMLNode)node.getChildNodes().get(i);
                if (StringHelper.Compare((String)childNode.getNodeName(), (String)ToolbarSeperatorConfig.TAG_TOOLBARSEPARATOR, (boolean)true) == 0 || StringHelper.Compare((String)childNode.getNodeName(), (String)"SRFEXMENUITEMEX", (boolean)true) == 0 && StringHelper.Compare((String)childNode.GetExtValue("CAPTION", ""), (String)"-", (boolean)true) == 0) {
                    if (bLastIsSeperator) {
                        bStop = false;
                        node.RemoveNode(childNode);
                        continue block0;
                    }
                    bLastIsSeperator = true;
                    if (i == node.getChildNodes().size() - 1) {
                        node.RemoveNode(childNode);
                        continue block0;
                    }
                    if (i == 0) {
                        bStop = false;
                        node.RemoveNode(childNode);
                        continue block0;
                    }
                } else {
                    bLastIsSeperator = false;
                    DAConfigHelper.EraseToolbarUnnecessarySeperator(childNode);
                }
                ++i;
            }
        }
    }

    public String GetEditViewTabViewConfigId(IDEHelper iDEHelper, Page page) {
        BaseDataEntity temp;
        String strTabViewConfigId = "";
        strTabViewConfigId = page == null ? StringHelper.Format((String)"DE%1$s.TABVIEW_%2$s", (Object)iDEHelper.getId(), (Object)iDEHelper.getVersion()) : StringHelper.Format((String)"DE%1$s.TABVIEW_%2$s_%3$s_%4$s", (Object)iDEHelper.getId(), (Object)iDEHelper.getVersion(), (Object)page.getPAGEID(), (Object)page.getVERSION());
        if (!StringHelper.IsNullOrEmpty((String)this.strLanguage)) {
            strTabViewConfigId = String.valueOf(strTabViewConfigId) + StringHelper.Format((String)"_%1$s", (Object)this.strLanguage);
        }
        strTabViewConfigId = strTabViewConfigId.toUpperCase();
        String strTVFilePath = ConfigPathHelper.GetRuntimeTVConfigPath((String)this.globalHelperEx.GetAppRootPath(), (String)strTabViewConfigId);
        File file = new File(strTVFilePath);
        if (file.exists()) {
            return strTabViewConfigId;
        }
        PPEVTabView ppEVTabView = null;
        if (page != null && (temp = page.getAdvPageParam(CONFIGTYPE_TABVIEW, "PP_EVTABVIEW")) != null && temp instanceof PPEVTabView) {
            ppEVTabView = (PPEVTabView)temp;
        }
        String strDERGroupId = "";
        if (ppEVTabView != null) {
            strDERGroupId = ppEVTabView.getDERGROUPID();
        }
        if (page != null && page.getPAGEProperties() != null) {
            strDERGroupId = page.GetPageProperty("PAGE.DERGROUP", strDERGroupId);
        }
        XMLNode rootNode = new XMLNode();
        rootNode.setNodeName("SRFEXTABVIEW");
        XMLNode editNode = new XMLNode();
        editNode.setNodeName("SRFEXTABVIEWPAGE");
        rootNode.AddNode(editNode);
        String strFormName = "";
        String strFormPageId = "";
        String strFormState = "";
        if (ppEVTabView != null) {
            strFormName = ppEVTabView.getFORMID();
            strFormPageId = ppEVTabView.getFORMPAGEID();
            strFormState = ppEVTabView.getFORMSTATE();
        }
        if (page != null && page.getPAGEProperties() != null) {
            strFormName = page.GetPageProperty("PAGE.FORM", strFormName);
            strFormPageId = page.GetPageProperty("PAGE.FORMPAGE", strFormPageId);
            strFormState = page.GetPageProperty("PAGE.FORMSTATE", strFormState);
        }
        String strFormPagePath = "";
        if (!StringHelper.IsNullOrEmpty((String)strFormPageId)) {
            Page formPage = this.globalHelperEx.getDAModelStorage().FindPage(strFormPageId);
            if (formPage == null) {
                log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u9875\u9762\u5bf9\u8c61[%1$s]\u5931\u8d25", (Object)strFormPageId));
                return "";
            }
            strFormPagePath = formPage.GetTotalPagePath();
            strFormPagePath = URLHelper.AppendURLSeperator((String)strFormPagePath);
        }
        if (StringHelper.IsNullOrEmpty((String)strFormPagePath)) {
            strFormPagePath = "../srfpage/formview.jsp?";
        }
        editNode.setID("EDIT");
        editNode.SetValue("CAPTION", iDEHelper.getLogicName(this.strLanguage));
        editNode.SetValue("GROUP", this.GetLocalization(iDEHelper, "PAGE.COMMON.EDITVIEW.DERGROUP.DETAIL", "\u8be6\u7ec6\u4fe1\u606f"));
        editNode.SetValue("GROUPICON", "../sasrfex/images/default/icon_details.png");
        editNode.SetValue("ICON", iDEHelper.getDataEntity().getSMALLICON());
        String strEditURL = StringHelper.Format((String)"%3$sSRFMAINFORM=TRUE&SRFDEID=%1$s&SRFFORMVIEW=%2$s", (Object)iDEHelper.getId(), (Object)strFormName, (Object)strFormPagePath);
        if (!StringHelper.IsNullOrEmpty((String)strFormState)) {
            strEditURL = URLHelper.AppendURLSeperator((String)strEditURL);
            strEditURL = String.valueOf(strEditURL) + StringHelper.Format((String)"SRFFORMSTATE=%1$s", (Object)strFormState);
        }
        editNode.SetValue("REMOTEURL", strEditURL);
        editNode.SetValue("APPENDPARAMS", "SRFPDEID|SRFDERID|SRFDEMAINSTATE|SRFDEMAINACTION|SRFFORMDIGEST");
        editNode.SetValue("APPENDPARAMSEX", SRFDAWebContext.getDAParams());
        editNode.SetValue("RESOURCEID", "NONE");
        if (StringHelper.IsNullOrEmpty((String)strDERGroupId)) {
            String strCaption;
            XMLNode rsNode;
            XMLNode rsNode2;
            Object iMinorDEHelper;
            DERType tempDERType;
            DERType derType;
            Object strDERTypeId;
            Vector sectionNodes;
            Vector derList = iDEHelper.GetDER1Ns(true);
            Vector der11List = iDEHelper.GetDER11s(true);
            Vector derIndexs = iDEHelper.GetDERINDEXs(false);
            Vector sumpagelist = new Vector();
            CallResult callResult = this.globalHelperEx.getDAModelHelper().GetSummaryPages(iDEHelper.getId(), "DER", sumpagelist);
            if (callResult == null || callResult.getRetCode() != 0) {
                log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u7f29\u7565\u754c\u9762\u5931\u8d25\uff0c%1$s", (Object)(callResult == null ? "\u4e0d\u660e" : callResult.getErrorInfo())));
                return "";
            }
            TreeMap derTypeNodesMap = new TreeMap();
            TreeMap<String, DERType> derTypeMap = new TreeMap<String, DERType>();
            Vector<DERType> derTypes = new Vector<DERType>();
            derTypeNodesMap.put("", new Vector());
            for (DER11 der11 : der11List) {
                if (der11.getSHOWORDER() < 0) continue;
                sectionNodes = null;
                strDERTypeId = der11.getDERTYPEID();
                if (!derTypeNodesMap.containsKey(strDERTypeId)) {
                    derType = null;
                    derType = new DERType();
                    callResult = this.globalHelperEx.getDAModelHelper().GetDERType((String)strDERTypeId, derType);
                    if (callResult.getRetCode() == 0) {
                        derTypeNodesMap.put(der11.getDERTYPEID(), new Vector());
                        derTypeMap.put(der11.getDERTYPEID(), derType);
                        boolean bAppendLast = true;
                        int i = 0;
                        while (i < derTypes.size()) {
                            tempDERType = (DERType)derTypes.get(i);
                            if (tempDERType.getORDERFLAG() > derType.getORDERFLAG()) {
                                derTypes.add(i, derType);
                                bAppendLast = false;
                                break;
                            }
                            ++i;
                        }
                        if (bAppendLast) {
                            derTypes.add(derType);
                        }
                    } else {
                        strDERTypeId = "";
                        log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u5173\u7cfb\u7c7b\u578b[%1$s]\u5931\u8d25\uff0c%2$s", (Object)der11.getDERTYPEID(), (Object)(callResult == null ? "\u4e0d\u660e" : callResult.getErrorInfo())));
                    }
                }
                sectionNodes = (Vector)derTypeNodesMap.get(strDERTypeId);
                iMinorDEHelper = this.globalHelperEx.getDAModelStorage().FindDEHelper(der11.getMINORDEID());
                rsNode2 = new XMLNode();
                rsNode2.setNodeName("SRFEXTABVIEWPAGE");
                rsNode2.SetValue("SHOWORDER", StringHelper.Format((String)"%1$s", (Object)der11.getSHOWORDER()));
                rsNode2.setID(der11.getDERID());
                rsNode2.SetValue("CAPTION", der11.getDERShowName());
                if (StringHelper.IsNullOrEmpty((String)der11.getSMALLICON())) {
                    rsNode2.SetValue("ICON", iMinorDEHelper.getDataEntity().getSMALLICON());
                } else {
                    rsNode2.SetValue("ICON", der11.getSMALLICON());
                }
                String strRemoteURL = StringHelper.Format((String)"../srfpage/ifformview.jsp?SRFPDEID=%1$s&SRFDEID=%2$s&SRFDERID=%3$s&SRFCAPTION=%4$s", (Object)der11.getMAJORDEID(), (Object)der11.getMINORDEID(), (Object)der11.getDERID(), (Object)SRFExWebContext.EncodeURLParamValue((String)der11.getDERShowName()));
                String strPageId = der11.getEDITPAGEID();
                if (!StringHelper.IsNullOrEmpty((String)strPageId)) {
                    Page embedEditPage = this.globalHelperEx.getDAModelStorage().FindPage(strPageId);
                    if (embedEditPage == null) {
                        log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u9875\u9762\u5bf9\u8c61[%1$s]\u5931\u8d25", (Object)strPageId));
                        return "";
                    }
                    strRemoteURL = URLHelper.AppendURLSeperator((String)strRemoteURL);
                    strRemoteURL = String.valueOf(strRemoteURL) + StringHelper.Format((String)"REALURL=%1$s&", (Object)SRFExWebContext.EncodeURLParamValue((String)embedEditPage.GetTotalPagePath()));
                }
                rsNode2.SetValue("REMOTEURL", strRemoteURL);
                rsNode2.SetValue("APPENDPARAMSEX", String.valueOf(SRFDAWebContext.getDAParams()) + "|" + iDEHelper.GetKeyDEFHelper().getName());
                if (StringHelper.IsNullOrEmpty((String)der11.getDERTYPENAME())) {
                    rsNode2.SetValue("GROUP", this.GetLocalization(iDEHelper, "PAGE.COMMON.EDITVIEW.DERGROUP.DETAIL", "\u8be6\u7ec6\u4fe1\u606f"));
                } else {
                    DERType derType2 = (DERType)derTypeMap.get(der11.getDERTYPEID());
                    if (derType2 != null) {
                        rsNode2.SetValue("GROUP", this.GetLocalization(iDEHelper, derType2.getDERTYPENAMELANRESID(), der11.getDERTYPENAME()));
                    } else {
                        rsNode2.SetValue("GROUP", der11.getDERTYPENAME());
                    }
                }
                rsNode2.SetValue("RESOURCEID", UniResHelper.GetDEDataResId((String)der11.getMINORDEID()));
                int nInsertPos = -1;
                int nCount = sectionNodes.size();
                int i = 0;
                while (i < nCount) {
                    XMLNode item = (XMLNode)sectionNodes.get(i);
                    int nPos = item.GetExtValue("SHOWORDER", 0);
                    if (der11.getSHOWORDER() < nPos) {
                        nInsertPos = i;
                        break;
                    }
                    ++i;
                }
                if (nInsertPos == -1) {
                    sectionNodes.add(rsNode2);
                    continue;
                }
                sectionNodes.add(nInsertPos, rsNode2);
            }
            for (DER1N der1n : derList) {
                if (der1n.getSHOWORDER() < 0) continue;
                sectionNodes = null;
                strDERTypeId = der1n.getDERTYPEID();
                if (!derTypeNodesMap.containsKey(strDERTypeId)) {
                    derType = null;
                    derType = new DERType();
                    callResult = this.globalHelperEx.getDAModelHelper().GetDERType((String)strDERTypeId, derType);
                    if (callResult.getRetCode() == 0) {
                        derTypeNodesMap.put(der1n.getDERTYPEID(), new Vector());
                        derTypeMap.put(der1n.getDERTYPEID(), derType);
                        boolean bAppendLast = true;
                        int i = 0;
                        while (i < derTypes.size()) {
                            tempDERType = (DERType)derTypes.get(i);
                            if (tempDERType.getORDERFLAG() > derType.getORDERFLAG()) {
                                derTypes.add(i, derType);
                                bAppendLast = false;
                                break;
                            }
                            ++i;
                        }
                        if (bAppendLast) {
                            derTypes.add(derType);
                        }
                    } else {
                        strDERTypeId = "";
                        log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u5173\u7cfb\u7c7b\u578b[%1$s]\u5931\u8d25\uff0c%2$s", (Object)der1n.getDERTYPEID(), (Object)(callResult == null ? "\u4e0d\u660e" : callResult.getErrorInfo())));
                    }
                }
                sectionNodes = (Vector)derTypeNodesMap.get(strDERTypeId);
                iMinorDEHelper = this.globalHelperEx.getDAModelStorage().FindDEHelper(der1n.getMINORDEID());
                if (iMinorDEHelper == null) {
                    log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61\u5931\u8d25", (Object)der1n.getMINORDEID()));
                    return "";
                }
                rsNode2 = new XMLNode();
                rsNode2.setNodeName("SRFEXTABVIEWPAGE");
                rsNode2.SetValue("SHOWORDER", StringHelper.Format((String)"%1$s", (Object)der1n.getSHOWORDER()));
                rsNode2.setID(der1n.getDERID());
                if (!StringHelper.IsNullOrEmpty((String)der1n.getTABVIEWBARCOND())) {
                    rsNode2.SetValue("TABVIEWBARCOND", der1n.getTABVIEWBARCOND());
                }
                rsNode2.SetValue("CAPTION", this.GetLocalization(iDEHelper, der1n.getSHOWNAMELANRESID(), der1n.getSHOWNAME1N()));
                if (StringHelper.IsNullOrEmpty((String)der1n.getDERTYPENAME())) {
                    rsNode2.SetValue("GROUP", this.GetLocalization(iDEHelper, "PAGE.COMMON.EDITVIEW.DERGROUP.RELATED", "\u76f8\u5173\u4fe1\u606f"));
                } else {
                    DERType derType3 = (DERType)derTypeMap.get(der1n.getDERTYPEID());
                    if (derType3 != null) {
                        rsNode2.SetValue("GROUP", this.GetLocalization(iDEHelper, derType3.getDERTYPENAMELANRESID(), der1n.getDERTYPENAME()));
                    } else {
                        rsNode2.SetValue("GROUP", der1n.getDERTYPENAME());
                    }
                }
                String strResourceId = UniResHelper.GetDEDataResId((String)der1n.getMINORDEID());
                String strDefaultPage = "../srfpage/ifgridview.jsp?";
                String strPageId = der1n.getRELATEDPAGEID();
                if (StringHelper.IsNullOrEmpty((String)strPageId)) {
                    strPageId = iMinorDEHelper.GetGridPageId();
                }
                if (!StringHelper.IsNullOrEmpty((String)strPageId)) {
                    Page relatedPage = this.globalHelperEx.getDAModelStorage().FindPage(strPageId);
                    if (relatedPage == null) {
                        log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u9875\u9762\u5bf9\u8c61[%1$s]\u5931\u8d25", (Object)strPageId));
                        return "";
                    }
                    strDefaultPage = String.valueOf(strDefaultPage) + StringHelper.Format((String)"REALURL=%1$s&", (Object)SRFExWebContext.EncodeURLParamValue((String)relatedPage.GetTotalPagePath()));
                    strResourceId = relatedPage.getRESOURCEID(der1n.getMINORDEID());
                }
                TreeMap<String, String> urlParams = new TreeMap<String, String>();
                urlParams.put("SRFPDEID", der1n.getMAJORDEID());
                urlParams.put("SRFDEID", der1n.getMINORDEID());
                urlParams.put("SRFDERID", der1n.getDERID());
                urlParams.put("SRFCAPTION", this.GetLocalization(iDEHelper, der1n.getSHOWNAMELANRESID(), der1n.getSHOWNAME1N()));
                if ((der1n.getDERSUBTYPE() & 0x10) != 0) {
                    urlParams.put("SRFINFOMODE", "TRUE");
                }
                if ((der1n.getDERSUBTYPE() & 0x20) != 0) {
                    urlParams.put("SRFFEWDATAMODE", "TRUE");
                }
                if (!StringHelper.IsNullOrEmpty((String)der1n.getTABVIEWBARCOND())) {
                    rsNode2.SetValue("TABVIEWBARCOND", der1n.getTABVIEWBARCOND());
                }
                rsNode2.SetValue("REMOTEURL", StringHelper.Format((String)"%1$s%2$s", (Object)strDefaultPage, (Object)URLHelper.GetQueryString(urlParams)));
                rsNode2.SetValue("APPENDPARAMSEX", String.valueOf(SRFDAWebContext.getDAParams()) + "|" + iDEHelper.GetKeyDEFHelper().getName());
                if (StringHelper.IsNullOrEmpty((String)der1n.getSMALLICON())) {
                    rsNode2.SetValue("ICON", iMinorDEHelper.getDataEntity().getSMALLICON());
                } else {
                    rsNode2.SetValue("ICON", der1n.getSMALLICON());
                }
                rsNode2.SetValue("RESOURCEID", strResourceId);
                int nInsertPos = -1;
                int nCount = sectionNodes.size();
                int i = 0;
                while (i < nCount) {
                    XMLNode item = (XMLNode)sectionNodes.get(i);
                    int nPos = item.GetExtValue("SHOWORDER", 0);
                    if (der1n.getSHOWORDER() < nPos) {
                        nInsertPos = i;
                        break;
                    }
                    ++i;
                }
                if (nInsertPos == -1) {
                    sectionNodes.add(rsNode2);
                    continue;
                }
                sectionNodes.add(nInsertPos, rsNode2);
            }
            for (DERINDEX derIndex : derIndexs) {
                Vector derList2 = new Vector();
                callResult = this.globalHelperEx.getDAModelHelper().GetDER1Ns(derIndex.getINDEXDEID(), derList2);
                if (callResult == null || callResult.getRetCode() != 0) {
                    log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53\u5173\u7cfb1:N\u5931\u8d25\uff0c%1$s", (Object)(callResult == null ? "\u4e0d\u660e" : callResult.getErrorInfo())));
                    return "";
                }
                for (DER1N der1n : derList2) {
                    if (der1n.getSHOWORDER() < 0) continue;
                    Vector sectionNodes2 = null;
                    String strDERTypeId2 = der1n.getDERTYPEID();
                    if (!derTypeNodesMap.containsKey(strDERTypeId2)) {
                        DERType derType4 = null;
                        derType4 = new DERType();
                        callResult = this.globalHelperEx.getDAModelHelper().GetDERType(strDERTypeId2, derType4);
                        if (callResult.getRetCode() == 0) {
                            derTypeNodesMap.put(der1n.getDERTYPEID(), new Vector());
                            derTypeMap.put(der1n.getDERTYPEID(), derType4);
                            boolean bAppendLast = true;
                            int i = 0;
                            while (i < derTypes.size()) {
                                DERType tempDERType2 = (DERType)derTypes.get(i);
                                if (tempDERType2.getORDERFLAG() > derType4.getORDERFLAG()) {
                                    derTypes.add(i, derType4);
                                    bAppendLast = false;
                                    break;
                                }
                                ++i;
                            }
                            if (bAppendLast) {
                                derTypes.add(derType4);
                            }
                        } else {
                            log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u5173\u7cfb\u7c7b\u578b[%1$s]\u5931\u8d25\uff0c%2$s", (Object)der1n.getDERTYPEID(), (Object)(callResult == null ? "\u4e0d\u660e" : callResult.getErrorInfo())));
                            strDERTypeId2 = "";
                        }
                    }
                    sectionNodes2 = (Vector)derTypeNodesMap.get(strDERTypeId2);
                    IDEHelper iMinorDEHelper2 = this.globalHelperEx.getDAModelStorage().FindDEHelper(der1n.getMINORDEID());
                    if (iMinorDEHelper2 == null) {
                        log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61\u5931\u8d25", (Object)der1n.getMINORDEID()));
                        return "";
                    }
                    XMLNode rsNode3 = new XMLNode();
                    rsNode3.setNodeName("SRFEXTABVIEWPAGE");
                    rsNode3.SetValue("SHOWORDER", StringHelper.Format((String)"%1$s", (Object)der1n.getSHOWORDER()));
                    rsNode3.setID(der1n.getDERID());
                    rsNode3.SetValue("CAPTION", this.GetLocalization(iDEHelper, der1n.getSHOWNAMELANRESID(), der1n.getSHOWNAME1N()));
                    if (StringHelper.IsNullOrEmpty((String)der1n.getDERTYPENAME())) {
                        rsNode3.SetValue("GROUP", this.GetLocalization(iDEHelper, "PAGE.COMMON.EDITVIEW.DERGROUP.RELATED", "\u76f8\u5173\u4fe1\u606f"));
                    } else {
                        DERType derType5 = (DERType)derTypeMap.get(der1n.getDERTYPEID());
                        if (derType5 != null) {
                            rsNode3.SetValue("GROUP", this.GetLocalization(iDEHelper, derType5.getDERTYPENAMELANRESID(), der1n.getDERTYPENAME()));
                        } else {
                            rsNode3.SetValue("GROUP", der1n.getDERTYPENAME());
                        }
                    }
                    String strResourceId = UniResHelper.GetDEDataResId((String)der1n.getMINORDEID());
                    String strDefaultPage = "../srfpage/ifgridview.jsp?";
                    String strPageId = der1n.getRELATEDPAGEID();
                    if (!StringHelper.IsNullOrEmpty((String)strPageId)) {
                        Page relatedPage = this.globalHelperEx.getDAModelStorage().FindPage(strPageId);
                        if (relatedPage == null) {
                            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u9875\u9762\u5bf9\u8c61[%1$s]\u5931\u8d25", (Object)strPageId));
                            return "";
                        }
                        strDefaultPage = String.valueOf(strDefaultPage) + StringHelper.Format((String)"REALURL=%1$s&", (Object)SRFExWebContext.EncodeURLParamValue((String)relatedPage.GetTotalPagePath()));
                        strResourceId = relatedPage.getRESOURCEID(der1n.getMINORDEID());
                    }
                    TreeMap<String, String> urlParams = new TreeMap<String, String>();
                    urlParams.put("SRFPDEID", der1n.getMAJORDEID());
                    urlParams.put("SRFDEID", der1n.getMINORDEID());
                    urlParams.put("SRFDERID", der1n.getDERID());
                    urlParams.put("SRFCAPTION", this.GetLocalization(iDEHelper, der1n.getSHOWNAMELANRESID(), der1n.getSHOWNAME1N()));
                    urlParams.put("SRFDERINDEXID", derIndex.getDERINDEXID());
                    if ((der1n.getDERSUBTYPE() & 0x10) != 0) {
                        urlParams.put("SRFINFOMODE", "TRUE");
                    }
                    if ((der1n.getDERSUBTYPE() & 0x20) != 0) {
                        urlParams.put("SRFFEWDATAMODE", "TRUE");
                    }
                    rsNode3.SetValue("REMOTEURL", StringHelper.Format((String)"%1$s%2$s", (Object)strDefaultPage, (Object)URLHelper.GetQueryString(urlParams)));
                    if (!StringHelper.IsNullOrEmpty((String)der1n.getTABVIEWBARCOND())) {
                        rsNode3.SetValue("TABVIEWBARCOND", der1n.getTABVIEWBARCOND());
                    }
                    rsNode3.SetValue("APPENDPARAMSEX", String.valueOf(SRFDAWebContext.getDAParams()) + "|" + iDEHelper.GetKeyDEFHelper().getName());
                    if (StringHelper.IsNullOrEmpty((String)der1n.getSMALLICON())) {
                        rsNode3.SetValue("ICON", iMinorDEHelper2.getDataEntity().getSMALLICON());
                    } else {
                        rsNode3.SetValue("ICON", der1n.getSMALLICON());
                    }
                    rsNode3.SetValue("RESOURCEID", strResourceId);
                    int nInsertPos = -1;
                    int nCount = sectionNodes2.size();
                    int i = 0;
                    while (i < nCount) {
                        XMLNode item = (XMLNode)sectionNodes2.get(i);
                        int nPos = item.GetExtValue("SHOWORDER", 0);
                        if (der1n.getSHOWORDER() < nPos) {
                            nInsertPos = i;
                            break;
                        }
                        ++i;
                    }
                    if (nInsertPos == -1) {
                        sectionNodes2.add(rsNode3);
                        continue;
                    }
                    sectionNodes2.add(nInsertPos, rsNode3);
                }
            }
            for (SummaryPage summaryPage : sumpagelist) {
                if (summaryPage.getDERSHOWORDER() < 0) continue;
                sectionNodes = null;
                strDERTypeId = summaryPage.getDERTYPEID();
                if (!derTypeNodesMap.containsKey(strDERTypeId)) {
                    derType = null;
                    derType = new DERType();
                    callResult = this.globalHelperEx.getDAModelHelper().GetDERType((String)strDERTypeId, derType);
                    if (callResult.getRetCode() == 0) {
                        derTypeNodesMap.put(summaryPage.getDERTYPEID(), new Vector());
                        derTypeMap.put(summaryPage.getDERTYPEID(), derType);
                        boolean bAppendLast = true;
                        int i = 0;
                        while (i < derTypes.size()) {
                            tempDERType = (DERType)derTypes.get(i);
                            if (tempDERType.getORDERFLAG() > derType.getORDERFLAG()) {
                                derTypes.add(i, derType);
                                bAppendLast = false;
                                break;
                            }
                            ++i;
                        }
                        if (bAppendLast) {
                            derTypes.add(derType);
                        }
                    } else {
                        log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u5173\u7cfb\u7c7b\u578b[%1$s]\u5931\u8d25\uff0c%2$s", (Object)summaryPage.getDERTYPEID(), (Object)(callResult == null ? "\u4e0d\u660e" : callResult.getErrorInfo())));
                        strDERTypeId = "";
                    }
                }
                sectionNodes = (Vector)derTypeNodesMap.get(strDERTypeId);
                rsNode = new XMLNode();
                rsNode.setNodeName("SRFEXTABVIEWPAGE");
                rsNode.SetValue("SHOWORDER", StringHelper.Format((String)"%1$s", (Object)summaryPage.getDERSHOWORDER()));
                rsNode.setID(summaryPage.getSUMMARYPAGEID());
                rsNode.SetValue("CAPTION", this.GetLocalization(iDEHelper, summaryPage.getNAMELANRESID(), summaryPage.getSUMMARYPAGENAME()));
                if (StringHelper.IsNullOrEmpty((String)summaryPage.getDERTYPENAME())) {
                    rsNode.SetValue("GROUP", this.GetLocalization(iDEHelper, "PAGE.COMMON.EDITVIEW.DERGROUP.RELATED", "\u76f8\u5173\u4fe1\u606f"));
                } else {
                    DERType derType6 = (DERType)derTypeMap.get(summaryPage.getDERTYPEID());
                    if (derType6 != null) {
                        rsNode.SetValue("GROUP", this.GetLocalization(iDEHelper, derType6.getDERTYPENAMELANRESID(), summaryPage.getDERTYPENAME()));
                    } else {
                        rsNode.SetValue("GROUP", summaryPage.getDERTYPENAME());
                    }
                }
                String strDefaultPage = "../srfpage/ifgridview.jsp?";
                String strPageId = summaryPage.getPAGEID();
                String strResourceId = "NONE";
                if (!StringHelper.IsNullOrEmpty((String)strPageId)) {
                    Page relatedPage = this.globalHelperEx.getDAModelStorage().FindPage(strPageId);
                    if (relatedPage == null) {
                        log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u9875\u9762\u5bf9\u8c61[%1$s]\u5931\u8d25", (Object)strPageId));
                        return "";
                    }
                    String strPageURL = relatedPage.GetTotalPagePath();
                    if (!StringHelper.IsNullOrEmpty((String)summaryPage.getAPPENDPARAM())) {
                        strPageURL = URLHelper.AppendURLSeperator((String)strPageURL);
                        strPageURL = String.valueOf(strPageURL) + summaryPage.getAPPENDPARAM();
                        strPageURL = URLHelper.AppendURLSeperator((String)strPageURL);
                    }
                    strDefaultPage = String.valueOf(strDefaultPage) + StringHelper.Format((String)"REALURL=%1$s&", (Object)SRFExWebContext.EncodeURLParamValue((String)strPageURL));
                    strResourceId = relatedPage.getRESOURCEID(iDEHelper.getId());
                }
                String strRemoteURL = StringHelper.Format((String)"%1$sSRFPDEID=%2$s&SRFCAPTION=%3$s", (Object)strDefaultPage, (Object)iDEHelper.getId(), (Object)SRFExWebContext.EncodeURLParamValue((String)this.GetLocalization(iDEHelper, summaryPage.getNAMELANRESID(), summaryPage.getSUMMARYPAGENAME())));
                rsNode.SetValue("REMOTEURL", strRemoteURL);
                rsNode.SetValue("APPENDPARAMSEX", String.valueOf(SRFDAWebContext.getDAParams()) + "|" + iDEHelper.GetKeyDEFHelper().getName());
                rsNode.SetValue("ICON", summaryPage.getSMALLICON());
                rsNode.SetValue("RESOURCEID", strResourceId);
                int nInsertPos = -1;
                int nCount = sectionNodes.size();
                int i = 0;
                while (i < nCount) {
                    XMLNode item = (XMLNode)sectionNodes.get(i);
                    int nPos = item.GetExtValue("SHOWORDER", 0);
                    if (summaryPage.getDERSHOWORDER() < nPos) {
                        nInsertPos = i;
                        break;
                    }
                    ++i;
                }
                if (nInsertPos == -1) {
                    sectionNodes.add(rsNode);
                    continue;
                }
                sectionNodes.add(nInsertPos, rsNode);
            }
            boolean bFirstNode = true;
            bFirstNode = true;
            Vector sectionNodes3 = (Vector)derTypeNodesMap.get("");
            for (XMLNode item : sectionNodes3) {
                if (bFirstNode) {
                    item.SetValue("GROUPICON", "../sasrfex/images/default/icon_related.png");
                } else {
                    item.RemoveExtValue("GROUPICON");
                }
                rootNode.AddNode(item);
            }
            for (DERType derType7 : derTypes) {
                bFirstNode = true;
                Vector sectionNodes4 = (Vector)derTypeNodesMap.get(derType7.getDERTYPEID());
                for (XMLNode item : sectionNodes4) {
                    if (bFirstNode) {
                        item.SetValue("GROUPICON", derType7.getSMALLICON());
                        item.SetValue("ISCOLLAPSE", derType7.getISCOLLAPSE() ? "TRUE" : "FALSE");
                        bFirstNode = false;
                    } else {
                        item.RemoveExtValue("GROUPICON");
                        item.RemoveExtValue("ISCOLLAPSE");
                    }
                    rootNode.AddNode(item);
                }
            }
            if (iDEHelper.IsEnableWF()) {
                boolean bWFStepData = this.globalHelperEx.getWebExConfig().GetValue("SRFDA.WF", "WFINFOPAGE_WFSTEPDATA", true);
                if (iDEHelper != null && iDEHelper.GetDEWF() != null) {
                    bWFStepData = iDEHelper.GetDEWF().GetWFParam("WFINFOPAGE.WFSTEPDATA", bWFStepData);
                }
                if (page != null) {
                    bWFStepData = page.GetPageProperty("WFINFOPAGE.WFSTEPDATA", bWFStepData);
                }
                if (bWFStepData) {
                    boolean bl = bWFStepData = this.getWFStepDataPlacement() == 0;
                }
                if (bWFStepData) {
                    strCaption = this.OnGetWFStepDataTabViewPageCaption();
                    String strWFStepDataPageId = this.OnGetWFStepDataGridViewPage();
                    rsNode = new XMLNode();
                    rsNode.setNodeName("SRFEXTABVIEWPAGE");
                    rsNode.setID("DER_WFSTEPDATA");
                    rsNode.SetValue("GROUP", this.OnGetWFStepDataTabViewPageDERGroup());
                    rsNode.SetValue("CAPTION", strCaption);
                    rsNode.SetValue("REMOTEURL", StringHelper.Format((String)"../srfpage/ifgridview.jsp?SRFPDEID=%1$s&SRFPAGEID=%3$s&SRFCAPTION=%2$s", (Object)iDEHelper.getId(), (Object)SRFExWebContext.EncodeURLParamValue((String)strCaption), (Object)strWFStepDataPageId));
                    rsNode.SetValue("RESOURCEID", "NONE");
                    rsNode.SetValue("APPENDPARAMSEX", String.valueOf(SRFDAWebContext.getDAParams()) + "|" + iDEHelper.GetKeyDEFHelper().getName());
                    rootNode.AddNode(rsNode);
                }
            }
            if (iDEHelper.IsEnableWF()) {
                boolean bWFStepActor = this.globalHelperEx.getWebExConfig().GetValue("SRFDA.WF", "WFINFOPAGE_WFSTEPACTOR", true);
                if (iDEHelper != null && iDEHelper.GetDEWF() != null) {
                    bWFStepActor = iDEHelper.GetDEWF().GetWFParam("WFINFOPAGE.WFSTEPACTOR", bWFStepActor);
                }
                if (page != null) {
                    bWFStepActor = page.GetPageProperty("WFINFOPAGE.WFSTEPACTOR", bWFStepActor);
                }
                if (bWFStepActor) {
                    boolean bl = bWFStepActor = this.getWFStepActorPlacement() == 0;
                }
                if (bWFStepActor) {
                    strCaption = this.OnGetWFStepActorTabViewPageCaption();
                    String strWFStepActorPageId = this.OnGetWFStepActorGridViewPage();
                    rsNode = new XMLNode();
                    rsNode.setNodeName("SRFEXTABVIEWPAGE");
                    rsNode.setID("DER_WFSTEPACTOR");
                    rsNode.SetValue("GROUP", this.OnGetWFStepActorTabViewPageDERGroup());
                    rsNode.SetValue("CAPTION", strCaption);
                    rsNode.SetValue("REMOTEURL", StringHelper.Format((String)"../srfpage/ifgridview.jsp?DEID=%1$s&SRFPAGEID=%3$s&SRFCAPTION=%2$s", (Object)iDEHelper.getId(), (Object)SRFExWebContext.EncodeURLParamValue((String)strCaption), (Object)strWFStepActorPageId));
                    rsNode.SetValue("RESOURCEID", "NONE");
                    rsNode.SetValue("APPENDPARAMSEX", String.valueOf(SRFDAWebContext.getDAParams()) + "|" + iDEHelper.GetKeyDEFHelper().getName());
                    rootNode.AddNode(rsNode);
                }
            }
            if (iDEHelper.IsSupportFA()) {
                XMLNode rsNode4 = new XMLNode();
                rsNode4.setNodeName("SRFEXTABVIEWPAGE");
                rsNode4.setID("DER_FILELIST");
                rsNode4.SetValue("GROUP", this.GetLocalization(iDEHelper, "PAGE.COMMON.EDITVIEW.DERGROUP.OTHER", "\u5176\u5b83"));
                strCaption = this.OnGetFileAttachmentTabViewPageCaption();
                rsNode4.SetValue("CAPTION", strCaption);
                rsNode4.SetValue("REMOTEURL", StringHelper.Format((String)"../srfpage/ifgridview.jsp?SRFPDEID=%1$s&SRFPAGEID=PAGE_00015&SRFCAPTION=%2$s", (Object)iDEHelper.getId(), (Object)SRFExWebContext.EncodeURLParamValue((String)strCaption)));
                rsNode4.SetValue("RESOURCEID", "NONE");
                rsNode4.SetValue("APPENDPARAMSEX", String.valueOf(SRFDAWebContext.getDAParams()) + "|" + iDEHelper.GetKeyDEFHelper().getName());
                rootNode.AddNode(rsNode4);
            }
            if (iDEHelper.IsEnableAudit()) {
                XMLNode rsNode5 = new XMLNode();
                rsNode5.setNodeName("SRFEXTABVIEWPAGE");
                rsNode5.setID("DER_DATAAUDIT");
                rsNode5.SetValue("GROUP", this.OnGetAuditTabViewPageDERGroup());
                rsNode5.SetValue("CAPTION", this.OnGetAuditTabViewPageCaption());
                rsNode5.SetValue("REMOTEURL", StringHelper.Format((String)"../srfpage/ifgridview.jsp?SRFPDEID=%1$s&SRFPAGEID=PAGE_00016&SRFCAPTION=%2$s", (Object)iDEHelper.getId(), (Object)SRFExWebContext.EncodeURLParamValue((String)this.OnGetAuditTabViewPageCaption())));
                rsNode5.SetValue("RESOURCEID", "NONE");
                rsNode5.SetValue("APPENDPARAMSEX", String.valueOf(SRFDAWebContext.getDAParams()) + "|" + iDEHelper.GetKeyDEFHelper().getName());
                rootNode.AddNode(rsNode5);
            }
        } else if (!this.AppendDERGroupTabViewPages(iDEHelper, rootNode, strDERGroupId, false)) {
            return "";
        }
        if (!DAConfigHelper.ExportConfigFile((XMLNode)rootNode, (String)strTVFilePath)) {
            return "";
        }
        return strTabViewConfigId;
    }

    protected String OnGetAuditTabViewPageCaption() {
        return this.GetLocalization(null, "PAGE.COMMON.EDITVIEW.DER.AUDIT", "\u8bbf\u95ee\u5ba1\u8ba1");
    }

    protected String OnGetFileAttachmentTabViewPageCaption() {
        return this.GetLocalization(null, "PAGE.COMMON.EDITVIEW.DER.FA", "\u6587\u4ef6\u9644\u4ef6");
    }

    protected String OnGetWFStepDataTabViewPageCaption() {
        return this.GetLocalization(null, "PAGE.COMMON.EDITVIEW.DER.WFSTEP", "\u6d41\u7a0b\u5904\u7406\u6b65\u9aa4");
    }

    protected String OnGetWFStepActorTabViewPageCaption() {
        return this.GetLocalization(null, "PAGE.COMMON.EDITVIEW.DER.ACTIVEWFSTEPACTOR", "\u5f53\u524d\u6d41\u7a0b\u5904\u7406");
    }

    protected String OnGetAuditTabViewPageDERGroup() {
        return this.GetLocalization(null, "PAGE.COMMON.EDITVIEW.DERGROUP.AUDIT", "\u5176\u5b83");
    }

    protected String OnGetWFStepDataTabViewPageDERGroup() {
        return this.GetLocalization(null, "PAGE.COMMON.EDITVIEW.DERGROUP.WFSTEP", "\u5176\u5b83");
    }

    protected String OnGetWFStepActorTabViewPageDERGroup() {
        return this.GetLocalization(null, "PAGE.COMMON.EDITVIEW.DERGROUP.ACTIVEWFSTEPACTOR", "\u5176\u5b83");
    }

    protected String OnGetFileAttachmentTabViewPageDERGroup() {
        return this.GetLocalization(null, "PAGE.COMMON.EDITVIEW.DERGROUP.FA", "\u5176\u5b83");
    }

    protected String OnGetWFStepActorGridViewPage() {
        return this.globalHelperEx.getWebExConfig().GetValue("SRFDA.WF", "WFSTEPACTORGRIDPAGE", "PAGE_WF0006_G001");
    }

    protected String OnGetWFStepDataGridViewPage() {
        return this.globalHelperEx.getWebExConfig().GetValue("SRFDA.WF", "WFSTEPDATAGRIDPAGE", "PAGE_00010");
    }

    public String GetWFInfoViewTabViewConfigId(IDEHelper iDEHelper, Page page, boolean bEnableUpdate) {
        BaseDataEntity temp;
        String strTabViewConfigId = "";
        strTabViewConfigId = page == null ? StringHelper.Format((String)"DE%1$s.TABVIEW_WF_%2$s_%3$s", (Object)iDEHelper.getId(), (Object)iDEHelper.getVersion(), (Object)(bEnableUpdate ? "UPDATE" : "NOUPDATE")) : StringHelper.Format((String)"DE%1$s.TABVIEW_WF_%2$s_%3$s_%4$s_%5$s", (Object)iDEHelper.getId(), (Object)iDEHelper.getVersion(), (Object)(bEnableUpdate ? "UPDATE" : "NOUPDATE"), (Object)page.getPAGEID(), (Object)page.getVERSION());
        if (!StringHelper.IsNullOrEmpty((String)this.strLanguage)) {
            strTabViewConfigId = String.valueOf(strTabViewConfigId) + StringHelper.Format((String)"_%1$s", (Object)this.strLanguage);
        }
        strTabViewConfigId = strTabViewConfigId.toUpperCase();
        String strTVFilePath = ConfigPathHelper.GetRuntimeTVConfigPath((String)this.globalHelperEx.GetAppRootPath(), (String)strTabViewConfigId);
        File file = new File(strTVFilePath);
        if (file.exists()) {
            return strTabViewConfigId;
        }
        PPEVTabView ppEVTabView = null;
        if (page != null && (temp = page.getAdvPageParam(CONFIGTYPE_TABVIEW, "PP_EVTABVIEW")) != null && temp instanceof PPEVTabView) {
            ppEVTabView = (PPEVTabView)temp;
        }
        String strDERGroupId = "";
        if (ppEVTabView != null) {
            strDERGroupId = ppEVTabView.getDERGROUPID();
        }
        if (page != null && page.getPAGEProperties() != null) {
            strDERGroupId = page.GetPageProperty("PAGE.DERGROUP", strDERGroupId);
        }
        XMLNode rootNode = new XMLNode();
        rootNode.setNodeName("SRFEXTABVIEW");
        XMLNode editNode = new XMLNode();
        editNode.setNodeName("SRFEXTABVIEWPAGE");
        rootNode.AddNode(editNode);
        String strFormName = "";
        String strFormPageId = "";
        String strFormState = "";
        if (page != null && page.getPAGEProperties() != null) {
            strFormName = page.GetPageProperty("PAGE.FORM", "");
            strFormPageId = page.GetPageProperty("PAGE.FORMPAGE", "");
            strFormState = page.GetPageProperty("PAGE.FORMSTATE", "");
        }
        String strFormPagePath = "";
        if (!StringHelper.IsNullOrEmpty((String)strFormPageId)) {
            Page formPage = this.globalHelperEx.getDAModelStorage().FindPage(strFormPageId);
            if (formPage == null) {
                log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u9875\u9762\u5bf9\u8c61[%1$s]\u5931\u8d25", (Object)strFormPageId));
                return "";
            }
            strFormPagePath = formPage.GetTotalPagePath();
            strFormPagePath = URLHelper.AppendURLSeperator((String)strFormPagePath);
        }
        if (StringHelper.IsNullOrEmpty((String)strFormPagePath)) {
            strFormPagePath = "../srfpage/formview.jsp?";
        }
        editNode.setID("EDIT");
        editNode.SetValue("CAPTION", iDEHelper.getLogicName(this.strLanguage));
        editNode.SetValue("GROUP", this.GetLocalization(iDEHelper, "PAGE.COMMON.EDITVIEW.DERGROUP.DETAIL", "\u8be6\u7ec6\u4fe1\u606f"));
        editNode.SetValue("ICON", iDEHelper.getDataEntity().getSMALLICON());
        editNode.SetValue("GROUPICON", "../sasrfex/images/default/icon_details.png");
        String strEditURL = StringHelper.Format((String)"%3$sSRFMAINFORM=TRUE&SRFDEID=%1$s&SRFFORMVIEW=%2$s&SRFWFMODE=TRUE&SRFWFUPDATE=%4$s", (Object)iDEHelper.getId(), (Object)strFormName, (Object)strFormPagePath, (Object)(bEnableUpdate ? "TRUE" : "FALSE"));
        if (!StringHelper.IsNullOrEmpty((String)strFormState)) {
            strEditURL = URLHelper.AppendURLSeperator((String)strEditURL);
            strEditURL = String.valueOf(strEditURL) + StringHelper.Format((String)"SRFFORMSTATE=%1$s", (Object)strFormState);
        }
        editNode.SetValue("REMOTEURL", strEditURL);
        editNode.SetValue("APPENDPARAMS", "SRFPDEID|SRFDERID|SRFDEMAINSTATE|SRFDEMAINACTION|SRFFORMDIGEST|SRFWFSTEP|SRFWFSUBSTEP");
        editNode.SetValue("APPENDPARAMSEX", SRFDAWebContext.getDAParams());
        editNode.SetValue("RESOURCEID", "NONE");
        if (StringHelper.IsNullOrEmpty((String)strDERGroupId)) {
            XMLNode rsNode;
            String strCaption;
            Object sectionNodes;
            Vector derList = iDEHelper.GetDER1Ns(true);
            Vector derIndexs = iDEHelper.GetDERINDEXs(false);
            TreeMap derTypeNodesMap = new TreeMap();
            TreeMap<String, DERType> derTypeMap = new TreeMap<String, DERType>();
            Vector<DERType> derTypes = new Vector<DERType>();
            derTypeNodesMap.put("", new Vector());
            for (DER1N der1n : derList) {
                if (der1n.getSHOWORDER() < 0 || (der1n.getDERSUBTYPE() & 2) == 0) continue;
                sectionNodes = null;
                if (!derTypeNodesMap.containsKey(der1n.getDERTYPEID())) {
                    DERType derType = null;
                    derType = new DERType();
                    CallResult callResult = this.globalHelperEx.getDAModelHelper().GetDERType(der1n.getDERTYPEID(), derType);
                    if (callResult != null && callResult.getRetCode() == 0) {
                        derTypeNodesMap.put(der1n.getDERTYPEID(), new Vector());
                        derTypeMap.put(der1n.getDERTYPEID(), derType);
                        boolean bAppendLast = true;
                        int i = 0;
                        while (i < derTypes.size()) {
                            DERType tempDERType = (DERType)derTypes.get(i);
                            if (tempDERType.getORDERFLAG() > derType.getORDERFLAG()) {
                                derTypes.add(i, derType);
                                bAppendLast = false;
                                break;
                            }
                            ++i;
                        }
                        if (bAppendLast) {
                            derTypes.add(derType);
                        }
                    } else {
                        log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u5173\u7cfb\u7c7b\u578b[%1$s]\u5931\u8d25\uff0c%2$s", (Object)der1n.getDERTYPEID(), (Object)(callResult == null ? "\u4e0d\u660e" : callResult.getErrorInfo())));
                    }
                }
                sectionNodes = (Vector)derTypeNodesMap.get(der1n.getDERTYPEID());
                IDEHelper iMinorDEHelper = this.globalHelperEx.getDAModelStorage().FindDEHelper(der1n.getMINORDEID());
                if (iMinorDEHelper == null) {
                    log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61\u5931\u8d25", (Object)der1n.getMINORDEID()));
                    return "";
                }
                XMLNode rsNode2 = new XMLNode();
                rsNode2.setNodeName("SRFEXTABVIEWPAGE");
                rsNode2.SetValue("SHOWORDER", StringHelper.Format((String)"%1$s", (Object)der1n.getSHOWORDER()));
                rsNode2.setID(der1n.getDERID());
                rsNode2.SetValue("CAPTION", this.GetLocalization(iDEHelper, der1n.getSHOWNAMELANRESID(), der1n.getSHOWNAME1N()));
                if (StringHelper.IsNullOrEmpty((String)der1n.getDERTYPENAME())) {
                    rsNode2.SetValue("GROUP", this.GetLocalization(iDEHelper, "PAGE.COMMON.EDITVIEW.DERGROUP.RELATED", "\u76f8\u5173\u4fe1\u606f"));
                } else {
                    DERType derType = (DERType)derTypeMap.get(der1n.getDERTYPEID());
                    if (derType != null) {
                        rsNode2.SetValue("GROUP", this.GetLocalization(iDEHelper, derType.getDERTYPENAMELANRESID(), der1n.getDERTYPENAME()));
                    } else {
                        rsNode2.SetValue("GROUP", der1n.getDERTYPENAME());
                    }
                }
                Object strResourceId = UniResHelper.GetDEDataResId((String)der1n.getMINORDEID());
                String strDefaultPage = "../srfpage/ifgridview.jsp?";
                String strPageId = der1n.getRELATEDPAGEID();
                if (!StringHelper.IsNullOrEmpty((String)strPageId)) {
                    Page relatedPage = this.globalHelperEx.getDAModelStorage().FindPage(strPageId);
                    if (relatedPage == null) {
                        log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u9875\u9762\u5bf9\u8c61[%1$s]\u5931\u8d25", (Object)strPageId));
                        return "";
                    }
                    strDefaultPage = String.valueOf(strDefaultPage) + StringHelper.Format((String)"REALURL=%1$s&", (Object)SRFExWebContext.EncodeURLParamValue((String)relatedPage.GetTotalPagePath()));
                    strResourceId = relatedPage.getRESOURCEID(der1n.getMINORDEID());
                }
                TreeMap<String, String> urlParams = new TreeMap<String, String>();
                urlParams.put("SRFPDEID", der1n.getMAJORDEID());
                urlParams.put("SRFDEID", der1n.getMINORDEID());
                urlParams.put("SRFDERID", der1n.getDERID());
                urlParams.put("SRFCAPTION", this.GetLocalization(iDEHelper, der1n.getSHOWNAMELANRESID(), der1n.getSHOWNAME1N()));
                if ((der1n.getDERSUBTYPE() & 0x10) != 0) {
                    urlParams.put("SRFINFOMODE", "TRUE");
                }
                if ((der1n.getDERSUBTYPE() & 0x20) != 0) {
                    urlParams.put("SRFFEWDATAMODE", "TRUE");
                }
                rsNode2.SetValue("REMOTEURL", StringHelper.Format((String)"%1$s%2$s", (Object)strDefaultPage, (Object)URLHelper.GetQueryString(urlParams)));
                if (!StringHelper.IsNullOrEmpty((String)der1n.getTABVIEWBARCOND())) {
                    rsNode2.SetValue("TABVIEWBARCOND", der1n.getTABVIEWBARCOND());
                }
                rsNode2.SetValue("APPENDPARAMSEX", String.valueOf(SRFDAWebContext.getDAParams()) + "|" + iDEHelper.GetKeyDEFHelper().getName());
                if (StringHelper.IsNullOrEmpty((String)der1n.getSMALLICON())) {
                    rsNode2.SetValue("ICON", iMinorDEHelper.getDataEntity().getSMALLICON());
                } else {
                    rsNode2.SetValue("ICON", der1n.getSMALLICON());
                }
                rsNode2.SetValue("RESOURCEID", (String)strResourceId);
                int nInsertPos = -1;
                int nCount = ((Vector)sectionNodes).size();
                int i = 0;
                while (i < nCount) {
                    XMLNode item = (XMLNode)((Vector)sectionNodes).get(i);
                    int nPos = item.GetExtValue("SHOWORDER", 0);
                    if (der1n.getSHOWORDER() < nPos) {
                        nInsertPos = i;
                        break;
                    }
                    ++i;
                }
                if (nInsertPos == -1) {
                    ((Vector)sectionNodes).add(rsNode2);
                    continue;
                }
                ((Vector)sectionNodes).add(nInsertPos, rsNode2);
            }
            for (DERINDEX derIndex : derIndexs) {
                Vector derList2 = new Vector();
                CallResult callResult = this.globalHelperEx.getDAModelHelper().GetDER1Ns(derIndex.getINDEXDEID(), derList2);
                if (callResult == null || callResult.getRetCode() != 0) {
                    log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53\u5173\u7cfb1:N\u5931\u8d25\uff0c%1$s", (Object)(callResult == null ? "\u4e0d\u660e" : callResult.getErrorInfo())));
                    return "";
                }
                for (DER1N der1n : derList2) {
                    if (der1n.getSHOWORDER() < 0) continue;
                    Vector sectionNodes2 = null;
                    String strDERTypeId = der1n.getDERTYPEID();
                    if (!derTypeNodesMap.containsKey(strDERTypeId)) {
                        DERType derType = null;
                        derType = new DERType();
                        callResult = this.globalHelperEx.getDAModelHelper().GetDERType(strDERTypeId, derType);
                        if (callResult.getRetCode() == 0) {
                            derTypeNodesMap.put(der1n.getDERTYPEID(), new Vector());
                            derTypeMap.put(der1n.getDERTYPEID(), derType);
                            boolean bAppendLast = true;
                            int i = 0;
                            while (i < derTypes.size()) {
                                DERType tempDERType = (DERType)derTypes.get(i);
                                if (tempDERType.getORDERFLAG() > derType.getORDERFLAG()) {
                                    derTypes.add(i, derType);
                                    bAppendLast = false;
                                    break;
                                }
                                ++i;
                            }
                            if (bAppendLast) {
                                derTypes.add(derType);
                            }
                        } else {
                            log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u5173\u7cfb\u7c7b\u578b[%1$s]\u5931\u8d25\uff0c%2$s", (Object)der1n.getDERTYPEID(), (Object)(callResult == null ? "\u4e0d\u660e" : callResult.getErrorInfo())));
                            strDERTypeId = "";
                        }
                    }
                    sectionNodes2 = (Vector)derTypeNodesMap.get(strDERTypeId);
                    IDEHelper iMinorDEHelper = this.globalHelperEx.getDAModelStorage().FindDEHelper(der1n.getMINORDEID());
                    if (iMinorDEHelper == null) {
                        log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61\u5931\u8d25", (Object)der1n.getMINORDEID()));
                        return "";
                    }
                    XMLNode rsNode3 = new XMLNode();
                    rsNode3.setNodeName("SRFEXTABVIEWPAGE");
                    rsNode3.SetValue("SHOWORDER", StringHelper.Format((String)"%1$s", (Object)der1n.getSHOWORDER()));
                    rsNode3.setID(der1n.getDERID());
                    rsNode3.SetValue("CAPTION", this.GetLocalization(iDEHelper, der1n.getSHOWNAMELANRESID(), der1n.getSHOWNAME1N()));
                    if (StringHelper.IsNullOrEmpty((String)der1n.getDERTYPENAME())) {
                        rsNode3.SetValue("GROUP", this.GetLocalization(iDEHelper, "PAGE.COMMON.EDITVIEW.DERGROUP.RELATED", "\u76f8\u5173\u4fe1\u606f"));
                    } else {
                        DERType derType = (DERType)derTypeMap.get(der1n.getDERTYPEID());
                        if (derType != null) {
                            rsNode3.SetValue("GROUP", this.GetLocalization(iDEHelper, derType.getDERTYPENAMELANRESID(), der1n.getDERTYPENAME()));
                        } else {
                            rsNode3.SetValue("GROUP", der1n.getDERTYPENAME());
                        }
                    }
                    String strResourceId = UniResHelper.GetDEDataResId((String)der1n.getMINORDEID());
                    String strDefaultPage = "../srfpage/ifgridview.jsp?";
                    String strPageId = der1n.getRELATEDPAGEID();
                    if (!StringHelper.IsNullOrEmpty((String)strPageId)) {
                        Page relatedPage = this.globalHelperEx.getDAModelStorage().FindPage(strPageId);
                        if (relatedPage == null) {
                            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u9875\u9762\u5bf9\u8c61[%1$s]\u5931\u8d25", (Object)strPageId));
                            return "";
                        }
                        strDefaultPage = String.valueOf(strDefaultPage) + StringHelper.Format((String)"REALURL=%1$s&", (Object)SRFExWebContext.EncodeURLParamValue((String)relatedPage.GetTotalPagePath()));
                        strResourceId = relatedPage.getRESOURCEID(der1n.getMINORDEID());
                    }
                    TreeMap<String, String> urlParams = new TreeMap<String, String>();
                    urlParams.put("SRFPDEID", der1n.getMAJORDEID());
                    urlParams.put("SRFDEID", der1n.getMINORDEID());
                    urlParams.put("SRFDERID", der1n.getDERID());
                    urlParams.put("SRFCAPTION", this.GetLocalization(iDEHelper, der1n.getSHOWNAMELANRESID(), der1n.getSHOWNAME1N()));
                    urlParams.put("SRFDERINDEXID", derIndex.getDERINDEXID());
                    if ((der1n.getDERSUBTYPE() & 0x10) != 0) {
                        urlParams.put("SRFINFOMODE", "TRUE");
                    }
                    if ((der1n.getDERSUBTYPE() & 0x20) != 0) {
                        urlParams.put("SRFFEWDATAMODE", "TRUE");
                    }
                    rsNode3.SetValue("REMOTEURL", StringHelper.Format((String)"%1$s%2$s", (Object)strDefaultPage, (Object)URLHelper.GetQueryString(urlParams)));
                    if (!StringHelper.IsNullOrEmpty((String)der1n.getTABVIEWBARCOND())) {
                        rsNode3.SetValue("TABVIEWBARCOND", der1n.getTABVIEWBARCOND());
                    }
                    rsNode3.SetValue("APPENDPARAMSEX", String.valueOf(SRFDAWebContext.getDAParams()) + "|" + iDEHelper.GetKeyDEFHelper().getName());
                    if (StringHelper.IsNullOrEmpty((String)der1n.getSMALLICON())) {
                        rsNode3.SetValue("ICON", iMinorDEHelper.getDataEntity().getSMALLICON());
                    } else {
                        rsNode3.SetValue("ICON", der1n.getSMALLICON());
                    }
                    rsNode3.SetValue("RESOURCEID", strResourceId);
                    int nInsertPos = -1;
                    int nCount = sectionNodes2.size();
                    int i = 0;
                    while (i < nCount) {
                        XMLNode item = (XMLNode)sectionNodes2.get(i);
                        int nPos = item.GetExtValue("SHOWORDER", 0);
                        if (der1n.getSHOWORDER() < nPos) {
                            nInsertPos = i;
                            break;
                        }
                        ++i;
                    }
                    if (nInsertPos == -1) {
                        sectionNodes2.add(rsNode3);
                        continue;
                    }
                    sectionNodes2.add(nInsertPos, rsNode3);
                }
            }
            for (DERType derType : derTypes) {
                DER1N der1n;
                sectionNodes = (Vector)derTypeNodesMap.get(derType.getDERTYPEID());
                der1n = ((Vector)sectionNodes).iterator();
                while (der1n.hasNext()) {
                    XMLNode item = (XMLNode)der1n.next();
                    item.SetValue("GROUPICON", derType.getSMALLICON());
                    item.SetValue("ISCOLLAPSE", derType.getISCOLLAPSE() ? "TRUE" : "FALSE");
                    rootNode.AddNode(item);
                }
            }
            Vector sectionNodes3 = (Vector)derTypeNodesMap.get("");
            for (XMLNode item : sectionNodes3) {
                item.SetValue("GROUPICON", "../sasrfex/images/default/icon_related.png");
                rootNode.AddNode(item);
            }
            boolean bWFStepData = this.globalHelperEx.getWebExConfig().GetValue("SRFDA.WF", "WFINFOPAGE_WFSTEPDATA", true);
            boolean bWFStepActor = this.globalHelperEx.getWebExConfig().GetValue("SRFDA.WF", "WFINFOPAGE_WFSTEPACTOR", true);
            if (iDEHelper != null && iDEHelper.GetDEWF() != null) {
                bWFStepData = iDEHelper.GetDEWF().GetWFParam("WFINFOPAGE.WFSTEPDATA", bWFStepData);
                bWFStepActor = iDEHelper.GetDEWF().GetWFParam("WFINFOPAGE.WFSTEPACTOR", bWFStepActor);
            }
            if (page != null) {
                bWFStepData = page.GetPageProperty("WFINFOPAGE.WFSTEPDATA", bWFStepData);
                bWFStepActor = page.GetPageProperty("WFINFOPAGE.WFSTEPACTOR", bWFStepActor);
            }
            if (bWFStepData) {
                boolean bl = bWFStepData = this.getWFStepDataPlacement() == 0;
            }
            if (bWFStepActor) {
                boolean bl = bWFStepActor = this.getWFStepActorPlacement() == 0;
            }
            if (iDEHelper.IsEnableWF() && bWFStepData) {
                strCaption = this.OnGetWFStepDataTabViewPageCaption();
                String strWFStepDataPageId = this.OnGetWFStepDataGridViewPage();
                rsNode = new XMLNode();
                rsNode.setNodeName("SRFEXTABVIEWPAGE");
                rsNode.setID("DER_WFSTEPDATA");
                rsNode.SetValue("GROUP", this.OnGetWFStepDataTabViewPageDERGroup());
                rsNode.SetValue("CAPTION", strCaption);
                rsNode.SetValue("RESOURCEID", "NONE");
                rsNode.SetValue("REMOTEURL", StringHelper.Format((String)"../srfpage/ifgridview.jsp?SRFPDEID=%1$s&SRFPAGEID=%2$s", (Object)iDEHelper.getId(), (Object)strWFStepDataPageId));
                rsNode.SetValue("APPENDPARAMSEX", String.valueOf(SRFDAWebContext.getDAParams()) + "|" + iDEHelper.GetKeyDEFHelper().getName());
                rootNode.AddNode(rsNode);
            }
            if (iDEHelper.IsEnableWF() && bWFStepActor) {
                strCaption = this.OnGetWFStepActorTabViewPageCaption();
                String strWFStepActorPageId = this.OnGetWFStepActorGridViewPage();
                rsNode = new XMLNode();
                rsNode.setNodeName("SRFEXTABVIEWPAGE");
                rsNode.setID("DER_WFSTEPACTOR");
                rsNode.SetValue("GROUP", this.OnGetWFStepActorTabViewPageDERGroup());
                rsNode.SetValue("CAPTION", strCaption);
                rsNode.SetValue("REMOTEURL", StringHelper.Format((String)"../srfpage/ifgridview.jsp?DEID=%1$s&SRFPAGEID=%3$s&SRFCAPTION=%2$s", (Object)iDEHelper.getId(), (Object)SRFExWebContext.EncodeURLParamValue((String)strCaption), (Object)strWFStepActorPageId));
                rsNode.SetValue("RESOURCEID", "NONE");
                rsNode.SetValue("APPENDPARAMSEX", String.valueOf(SRFDAWebContext.getDAParams()) + "|" + iDEHelper.GetKeyDEFHelper().getName());
                rootNode.AddNode(rsNode);
            }
            if (iDEHelper.IsEnableAudit()) {
                XMLNode rsNode4 = new XMLNode();
                rsNode4.setNodeName("SRFEXTABVIEWPAGE");
                rsNode4.setID("DER_DATAAUDIT");
                rsNode4.SetValue("GROUP", this.OnGetAuditTabViewPageDERGroup());
                rsNode4.SetValue("CAPTION", this.OnGetAuditTabViewPageCaption());
                rsNode4.SetValue("REMOTEURL", StringHelper.Format((String)"../srfpage/ifgridview.jsp?SRFPDEID=%1$s&SRFPAGEID=PAGE_00016&SRFCAPTION=%2$s", (Object)iDEHelper.getId(), (Object)SRFExWebContext.EncodeURLParamValue((String)this.OnGetAuditTabViewPageCaption())));
                rsNode4.SetValue("RESOURCEID", "NONE");
                rsNode4.SetValue("APPENDPARAMSEX", String.valueOf(SRFDAWebContext.getDAParams()) + "|" + iDEHelper.GetKeyDEFHelper().getName());
                rootNode.AddNode(rsNode4);
            }
        } else if (!this.AppendDERGroupTabViewPages(iDEHelper, rootNode, strDERGroupId, true)) {
            return "";
        }
        if (!DAConfigHelper.ExportConfigFile((XMLNode)rootNode, (String)strTVFilePath)) {
            return "";
        }
        return strTabViewConfigId;
    }

    protected boolean AppendDERGroupTabViewPages(IDEHelper iDEHelper, XMLNode rootNode, String strDERGroupId, boolean bWF) {
        XMLNode rsNode;
        Vector derGroupDetails = new Vector();
        CallResult callResult = this.globalHelperEx.getDAModelHelper().GetDERGroupDetails(strDERGroupId, derGroupDetails);
        if (callResult == null || callResult.getRetCode() != 0) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53\u5206\u7ec4\u5173\u7cfb\u660e\u7ec6\u5931\u8d25\uff0c%1$s", (Object)(callResult == null ? "\u4e0d\u660e" : callResult.getErrorInfo())));
            return false;
        }
        boolean bAppendWFStep = false;
        boolean bAppendWFStepActor = false;
        TreeMap<String, DERGroupFolder> derGroupFolders = new TreeMap<String, DERGroupFolder>();
        for (DERGroupDetail derGroupDetail : derGroupDetails) {
            IDEHelper iMinorDEHelper;
            XMLNode rsNode2 = new XMLNode();
            rsNode2.setNodeName("SRFEXTABVIEWPAGE");
            rsNode2.setID(derGroupDetail.getDERGROUPDETAILID());
            rsNode2.SetValue("CAPTION", derGroupDetail.getDERGROUPDETAILNAME());
            String strPageId = "";
            String strDefaultPage = "../srfpage/ifgridview.jsp?";
            String strDefaultPageParam = "";
            String strDefaultGroup = "\u76f8\u5173\u4fe1\u606f";
            String strCurDEId = "";
            String strTabViewBarCond = "";
            if (StringHelper.Compare((String)derGroupDetail.getDETAILTYPE(), (String)"PAGE", (boolean)true) == 0) {
                strPageId = derGroupDetail.getPAGEID();
            } else if (StringHelper.Compare((String)derGroupDetail.getDETAILTYPE(), (String)"PAGEPATH", (boolean)true) == 0) {
                strDefaultPage = String.valueOf(strDefaultPage) + StringHelper.Format((String)"REALURL=%1$s&", (Object)SRFExWebContext.EncodeURLParamValue((String)derGroupDetail.getPAGEPATH()));
            } else if (StringHelper.Compare((String)derGroupDetail.getDETAILTYPE(), (String)"WFSTEP", (boolean)true) == 0) {
                strPageId = this.OnGetWFStepDataGridViewPage();
                strCurDEId = iDEHelper.getId();
                bAppendWFStep = true;
            } else if (StringHelper.Compare((String)derGroupDetail.getDETAILTYPE(), (String)"WFSTEPACTOR", (boolean)true) == 0) {
                strPageId = this.OnGetWFStepActorGridViewPage();
                strCurDEId = iDEHelper.getId();
                bAppendWFStepActor = true;
            } else if (StringHelper.Compare((String)derGroupDetail.getDETAILTYPE(), (String)"FILELIST", (boolean)true) == 0) {
                strPageId = "PAGE_00015";
                strCurDEId = iDEHelper.getId();
            } else if (StringHelper.Compare((String)derGroupDetail.getDETAILTYPE(), (String)"DATAAUDIT", (boolean)true) == 0) {
                strPageId = "PAGE_00016";
                strCurDEId = iDEHelper.getId();
            } else if (StringHelper.Compare((String)derGroupDetail.getDETAILTYPE(), (String)"DER1N", (boolean)true) == 0) {
                DER1N der1n = new DER1N();
                callResult = this.globalHelperEx.getDAModelHelper().GetDER1N(derGroupDetail.getDER1NID(), der1n);
                if (callResult.getRetCode() != 0) {
                    log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f531N\u5173\u7cfb[%1$s]\u5931\u8d25\uff0c%2$s", (Object)derGroupDetail.getDER1NID(), (Object)callResult.getErrorInfo()));
                    return false;
                }
                strPageId = der1n.getRELATEDPAGEID();
                if (StringHelper.IsNullOrEmpty((String)strPageId)) {
                    iMinorDEHelper = this.globalHelperEx.getDAModelStorage().FindDEHelper(der1n.getMINORDEID());
                    if (iMinorDEHelper == null) {
                        log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61\u5931\u8d25", (Object)der1n.getMINORDEID()));
                        return false;
                    }
                    strPageId = iMinorDEHelper.GetGridPageId();
                }
                TreeMap<String, String> urlParams = new TreeMap<String, String>();
                urlParams.put("SRFDEID", der1n.getMINORDEID());
                urlParams.put("SRFDERID", der1n.getDERID());
                if ((der1n.getDERSUBTYPE() & 0x10) != 0) {
                    urlParams.put("SRFINFOMODE", "TRUE");
                }
                if ((der1n.getDERSUBTYPE() & 0x20) != 0) {
                    urlParams.put("SRFFEWDATAMODE", "TRUE");
                }
                strDefaultPageParam = URLHelper.GetQueryString(urlParams);
                strCurDEId = der1n.getMINORDEID();
                strTabViewBarCond = der1n.getTABVIEWBARCOND();
            } else if (StringHelper.Compare((String)derGroupDetail.getDETAILTYPE(), (String)"DER11", (boolean)true) == 0) {
                DER11 der11 = new DER11();
                callResult = this.globalHelperEx.getDAModelHelper().GetDER11(derGroupDetail.getDER11ID(), der11);
                if (callResult.getRetCode() != 0) {
                    log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f5311\u5173\u7cfb[%1$s]\u5931\u8d25\uff0c%2$s", (Object)derGroupDetail.getDER11ID(), (Object)callResult.getErrorInfo()));
                    return false;
                }
                strPageId = der11.getEDITPAGEID();
                if (StringHelper.IsNullOrEmpty((String)strPageId)) {
                    iMinorDEHelper = this.globalHelperEx.getDAModelStorage().FindDEHelper(der11.getMINORDEID());
                    if (iMinorDEHelper == null) {
                        log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61\u5931\u8d25", (Object)der11.getMINORDEID()));
                        return false;
                    }
                    strPageId = iMinorDEHelper.GetEditPageId();
                }
                strDefaultPageParam = StringHelper.Format((String)"SRFDEID=%1$s&SRFDERID=%2$s", (Object)der11.getMINORDEID(), (Object)der11.getDERID());
                strDefaultPage = "../srfpage/ifformview.jsp?";
                strDefaultGroup = "\u8be6\u7ec6\u4fe1\u606f";
                strCurDEId = der11.getMINORDEID();
            }
            String strResourceId = "NONE";
            if (!StringHelper.IsNullOrEmpty((String)strCurDEId)) {
                strResourceId = UniResHelper.GetDEDataResId((String)strCurDEId);
            }
            if (!StringHelper.IsNullOrEmpty((String)strPageId)) {
                Page relatedPage = this.globalHelperEx.getDAModelStorage().FindPage(strPageId);
                if (relatedPage == null) {
                    log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u9875\u9762\u5bf9\u8c61[%1$s]\u5931\u8d25", (Object)strPageId));
                    return false;
                }
                strDefaultPage = String.valueOf(strDefaultPage) + StringHelper.Format((String)"REALURL=%1$s&", (Object)SRFExWebContext.EncodeURLParamValue((String)relatedPage.GetTotalPagePath()));
                strResourceId = relatedPage.getRESOURCEID(strCurDEId);
            }
            String strRemoteURL = StringHelper.Format((String)"%1$sSRFPDEID=%2$s&SRFCAPTION=%3$s", (Object)strDefaultPage, (Object)iDEHelper.getId(), (Object)SRFExWebContext.EncodeURLParamValue((String)derGroupDetail.getDERGROUPDETAILNAME()));
            if (!StringHelper.IsNullOrEmpty((String)strDefaultPageParam)) {
                strRemoteURL = URLHelper.AppendURLSeperator((String)strRemoteURL);
                strRemoteURL = String.valueOf(strRemoteURL) + strDefaultPageParam;
            }
            if (!StringHelper.IsNullOrEmpty((String)derGroupDetail.getURLPARAM())) {
                strRemoteURL = URLHelper.AppendURLSeperator((String)strRemoteURL);
                strRemoteURL = String.valueOf(strRemoteURL) + derGroupDetail.getURLPARAM();
            }
            rsNode2.SetValue("REMOTEURL", strRemoteURL);
            rsNode2.SetValue("APPENDPARAMSEX", String.valueOf(SRFDAWebContext.getDAParams()) + "|" + iDEHelper.GetKeyDEFHelper().getName());
            rsNode2.SetValue("ICON", derGroupDetail.getSMALLICON());
            if (!StringHelper.IsNullOrEmpty((String)derGroupDetail.getRESOURCEID())) {
                strResourceId = derGroupDetail.getRESOURCEID();
            }
            rsNode2.SetValue("RESOURCEID", strResourceId);
            if (!StringHelper.IsNullOrEmpty((String)strTabViewBarCond)) {
                rsNode2.SetValue("TABVIEWBARCOND", strTabViewBarCond);
            }
            if (StringHelper.IsNullOrEmpty((String)derGroupDetail.getDERGROUPFOLDERID())) {
                rsNode2.SetValue("GROUP", strDefaultGroup);
            } else {
                DERGroupFolder derGroupFolder = null;
                if (!derGroupFolders.containsKey(derGroupDetail.getDERGROUPFOLDERID())) {
                    derGroupFolder = new DERGroupFolder();
                    callResult = this.globalHelperEx.getDAModelHelper().GetDERGroupFolder(derGroupDetail.getDERGROUPFOLDERID(), derGroupFolder);
                    if (callResult.getRetCode() == 0) {
                        derGroupFolders.put(derGroupDetail.getDERGROUPFOLDERID(), derGroupFolder);
                    } else {
                        log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u5173\u7cfb\u5206\u7ec4[%1$s]\u5931\u8d25\uff0c%2$s", (Object)derGroupDetail.getDERGROUPFOLDERID(), (Object)(callResult == null ? "\u4e0d\u660e" : callResult.getErrorInfo())));
                    }
                }
                if ((derGroupFolder = (DERGroupFolder)derGroupFolders.get(derGroupDetail.getDERGROUPFOLDERID())) != null) {
                    rsNode2.SetValue("GROUP", derGroupFolder.getDERGROUPFOLDERNAME());
                    rsNode2.SetValue("GROUPICON", derGroupFolder.getSMALLICON());
                    rsNode2.SetValue("ISCOLLAPSE", derGroupFolder.getISCOLLAPSE() ? "TRUE" : "FALSE");
                } else {
                    rsNode2.SetValue("GROUP", strDefaultGroup);
                }
            }
            rootNode.AddNode(rsNode2);
        }
        if (iDEHelper.IsEnableWF() && !bAppendWFStep && bWF) {
            String strWFStepDataPageId = this.OnGetWFStepDataGridViewPage();
            rsNode = new XMLNode();
            rsNode.setNodeName("SRFEXTABVIEWPAGE");
            rsNode.setID("DER_WFSTEPDATA");
            rsNode.SetValue("GROUP", "\u5176\u5b83");
            rsNode.SetValue("CAPTION", this.OnGetWFStepDataTabViewPageCaption());
            rsNode.SetValue("RESOURCEID", "NONE");
            rsNode.SetValue("REMOTEURL", StringHelper.Format((String)"../srfpage/ifgridview.jsp?SRFPDEID=%1$s&SRFPAGEID=%2$s", (Object)iDEHelper.getId(), (Object)strWFStepDataPageId));
            rsNode.SetValue("APPENDPARAMSEX", String.valueOf(SRFDAWebContext.getDAParams()) + "|" + iDEHelper.GetKeyDEFHelper().getName());
            rootNode.AddNode(rsNode);
        }
        if (iDEHelper.IsEnableWF() && !bAppendWFStepActor && bWF) {
            String strWFStepActorPageId = this.OnGetWFStepActorGridViewPage();
            rsNode = new XMLNode();
            rsNode.setNodeName("SRFEXTABVIEWPAGE");
            rsNode.setID("DER_WFSTEPACTOR");
            rsNode.SetValue("GROUP", "\u5176\u5b83");
            rsNode.SetValue("CAPTION", this.OnGetWFStepActorTabViewPageCaption());
            rsNode.SetValue("RESOURCEID", "NONE");
            rsNode.SetValue("REMOTEURL", StringHelper.Format((String)"../srfpage/ifgridview.jsp?DEID=%1$s&SRFPAGEID=%3$s&SRFCAPTION=%2$s", (Object)iDEHelper.getId(), (Object)SRFExWebContext.EncodeURLParamValue((String)this.OnGetWFStepActorTabViewPageCaption()), (Object)strWFStepActorPageId));
            rsNode.SetValue("APPENDPARAMSEX", String.valueOf(SRFDAWebContext.getDAParams()) + "|" + iDEHelper.GetKeyDEFHelper().getName());
            rootNode.AddNode(rsNode);
        }
        return true;
    }

    public String GetDPConfigId(IDEHelper iDEHelper, Form formView) {
        return this.GetEditViewDPId(iDEHelper, formView);
    }

    public String GetEditViewDPId(IDEHelper iDEHelper, Form formView) {
        if (!StringHelper.IsNullOrEmpty((String)formView.getCONFIGPATH())) {
            return formView.getCONFIGPATH();
        }
        String strFormId = formView.getFORMID().replace(".", "_");
        String strDPConfigId = StringHelper.Format((String)"DE%1$s.DPEX_%2$s_%3$s_%4$s", (Object)iDEHelper.getId(), (Object)iDEHelper.getVersion(), (Object)strFormId, (Object)formView.getFMVERSION());
        if (!StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
            strDPConfigId = String.valueOf(strDPConfigId) + StringHelper.Format((String)"_PM_%1$s", (Object)this.strPageModel);
        }
        if (!StringHelper.IsNullOrEmpty((String)this.strLanguage)) {
            strDPConfigId = String.valueOf(strDPConfigId) + "_" + this.strLanguage;
        }
        strDPConfigId = strDPConfigId.toUpperCase();
        String strDPFilePath = ConfigPathHelper.GetRuntimeDPConfigPath((String)this.globalHelperEx.GetAppRootPath(), (String)strDPConfigId);
        File file = new File(strDPFilePath);
        if (file.exists()) {
            return strDPConfigId;
        }
        String strFormModelXML = formView.getFORMMODEL();
        XMLNode rootNode = null;
        if (StringHelper.IsNullOrEmpty((String)strFormModelXML)) {
            String strFormModelPath = ConfigPathHelper.GetAdvDPConfigPath((String)this.globalHelperEx.GetAppRootPath(), (String)formView.getFORMMODELPATH());
            file = null;
            file = new File(strFormModelPath);
            if (!file.exists()) {
                log.error((Object)StringHelper.Format((String)"\u8868\u5355\u6a21\u578b\u6587\u4ef6[%1$s]\u4e0d\u5b58\u5728", (Object)strFormModelPath));
                return "";
            }
            rootNode = XMLNode.Load((String)strFormModelPath);
        } else {
            rootNode = XMLNode.LoadFromXML((String)strFormModelXML);
        }
        rootNode = this.GetDPConfig(iDEHelper, rootNode, formView);
        if (rootNode == null) {
            return "";
        }
        if (!StringHelper.IsNullOrEmpty((String)formView.getFORMPLUGIN())) {
            rootNode.SetValue("DPPLUGIN", formView.getFORMPLUGIN());
        }
        if (!StringHelper.IsNullOrEmpty((String)formView.getFORMSCRIPT())) {
            rootNode.SetValue("SCRIPT", formView.getFORMSCRIPT());
        }
        if (!StringHelper.IsNullOrEmpty((String)formView.getFIVCSCRIPT())) {
            rootNode.SetValue("FIVCSCRIPT", formView.getFIVCSCRIPT());
        }
        if (!StringHelper.IsNullOrEmpty((String)formView.getFORMSCRIPTEX())) {
            rootNode.SetValue("FORMSCRIPTEX", formView.getFORMSCRIPTEX());
        }
        if (!StringHelper.IsNullOrEmpty((String)formView.getFORMSCRIPTEX2())) {
            rootNode.SetValue("FORMSCRIPTEX2", formView.getFORMSCRIPTEX2());
        }
        if (!StringHelper.IsNullOrEmpty((String)formView.getFORMBSSCRIPT())) {
            rootNode.SetValue("FORMBSSCRIPT", formView.getFORMBSSCRIPT());
        }
        if (!DAConfigHelper.ExportConfigFile((XMLNode)rootNode, (String)strDPFilePath)) {
            return "";
        }
        return strDPConfigId;
    }

    public String GetGridViewExDGExId(IDEHelper iDEHelper, Page page, DataGridEx dataGridEx) {
        XMLNode dataGroupFetchNode;
        if (!StringHelper.IsNullOrEmpty((String)dataGridEx.getCONFIGPATH())) {
            return dataGridEx.getCONFIGPATH();
        }
        String strDGExId = dataGridEx.getDATAGRIDEXID().replace(".", "_");
        String strDPConfigId = StringHelper.Format((String)"DE%1$s.DGEX_%2$s_%3$s_%4$s", (Object)iDEHelper.getId(), (Object)iDEHelper.getVersion(), (Object)strDGExId, (Object)dataGridEx.getVERSION());
        if (!StringHelper.IsNullOrEmpty((String)this.strLanguage)) {
            strDPConfigId = String.valueOf(strDPConfigId) + "_" + this.strLanguage;
        }
        strDPConfigId = strDPConfigId.toUpperCase();
        String strDGFilePath = ConfigPathHelper.GetRuntimeDGConfigPath((String)this.globalHelperEx.GetAppRootPath(), (String)strDPConfigId);
        File file = new File(strDGFilePath);
        if (file.exists()) {
            return strDPConfigId;
        }
        String strDGExModelXML = dataGridEx.getDGEXMODEL();
        XMLNode rootNode = null;
        if (StringHelper.IsNullOrEmpty((String)strDGExModelXML)) {
            log.error((Object)StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u6269\u5c55\u8868\u683c\u903b\u8f91"));
            return "";
        }
        rootNode = XMLNode.LoadFromXML((String)strDGExModelXML);
        if ((rootNode = this.GetDGExConfig(iDEHelper, rootNode)) == null) {
            return "";
        }
        rootNode.SetValue("PAGING", "TRUE");
        rootNode.SetValue("RENDERMODE", dataGridEx.getRENDERMODE());
        XMLNode dataGroupNode = rootNode.GetChildNodeByNodeName("SRFEXDGEXDATAGROUP");
        if (dataGroupNode != null && (dataGroupFetchNode = dataGroupNode.GetChildNodeByNodeName("SRFEXDGEXDATAGROUPFETCH")) != null) {
            dataGroupFetchNode.SetValue("SORTFIELD", dataGridEx.getSORTFIELD());
            if (StringHelper.Compare((String)dataGridEx.getSORTDIR(), (String)"DESC", (boolean)true) == 0) {
                dataGroupFetchNode.SetValue("SORTDESC", "TRUE");
            } else {
                dataGroupFetchNode.SetValue("SORTDESC", "FALSE");
            }
        }
        XMLNode pagingToolbarNode = new XMLNode();
        pagingToolbarNode.setNodeName("SRFEXPAGINGTOOLBAR");
        if (pagingToolbarNode != null) {
            String strEmptyMsg;
            String strAfterPageMsg;
            String strBeforePageMsg;
            String strDisplayMsg;
            if (dataGridEx.getPAGESIZE() > 0) {
                pagingToolbarNode.SetValue("PAGESIZE", StringHelper.Format((String)"%1$s", (Object)dataGridEx.getPAGESIZE()));
            }
            if (!StringHelper.IsNullOrEmpty((String)(strDisplayMsg = this.GetLocalization(iDEHelper, "CONTROL.DATAGRID.PAGING.DISPLAYMSG", "")))) {
                pagingToolbarNode.SetValue("DISPLAYMSG", strDisplayMsg);
            }
            if (!StringHelper.IsNullOrEmpty((String)(strBeforePageMsg = this.GetLocalization(iDEHelper, "CONTROL.DATAGRID.PAGING.BEFOREPAGEMSG", "")))) {
                pagingToolbarNode.SetValue("BEFOREPAGEMSG", strBeforePageMsg);
            }
            if (!StringHelper.IsNullOrEmpty((String)(strAfterPageMsg = this.GetLocalization(iDEHelper, "CONTROL.DATAGRID.PAGING.AFTERPAGEMSG", "")))) {
                pagingToolbarNode.SetValue("AFTERPAGEMSG", strAfterPageMsg);
            }
            if (!StringHelper.IsNullOrEmpty((String)(strEmptyMsg = this.GetLocalization(iDEHelper, "CONTROL.DATAGRID.PAGING.EMPTYMSG", "")))) {
                pagingToolbarNode.SetValue("EMPTYMSG", strEmptyMsg);
            }
        }
        rootNode.AddNode(pagingToolbarNode);
        if (!DAConfigHelper.ExportConfigFile((XMLNode)rootNode, (String)strDGFilePath)) {
            return "";
        }
        return strDPConfigId;
    }

    public DGExConfig GetDGExConfig(IDEHelper iDEHelper, String strDGExModelXML) {
        XMLNode rootNode = XMLNode.LoadFromXML((String)strDGExModelXML);
        if ((rootNode = this.GetDGExConfig(iDEHelper, rootNode)) == null) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            SimpleXMLWriter writer = new SimpleXMLWriter(sb);
            writer.WriteRaw("<?xml version=\"1.0\" encoding=\"utf-8\" ?>\r\n");
            rootNode.Save(writer);
            InputSource is = new InputSource(new StringReader(sb.toString()));
            DOMParser parser = new DOMParser();
            parser.parse(is);
            Document doc = parser.getDocument();
            DGExConfig dgExConfig = new DGExConfig();
            dgExConfig.LoadConfig((Node)doc.getDocumentElement());
            return dgExConfig;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u5bfc\u5165\u914d\u7f6e\u6587\u4ef6\u5931\u8d25\uff0c\u539f\u56e0\uff1a%1$s", (Object)ex.getMessage()));
            return null;
        }
    }

    protected XMLNode GetDGExConfig(IDEHelper iDEHelper, XMLNode rootNode) {
        String strDEId;
        if (rootNode == null) {
            log.error((Object)StringHelper.Format((String)"\u8f7d\u5165\u8868\u683c\u6a21\u578b\u5931\u8d25"));
            return null;
        }
        TreeMap<String, IDEHelper> deHelperMap = new TreeMap<String, IDEHelper>();
        deHelperMap.put(iDEHelper.getId(), iDEHelper);
        ArrayList cellNodes = new ArrayList();
        rootNode.GetAllNodeByNodeName("SRFEXDGEXDATAGROUP", cellNodes);
        for (XMLNode cellNode : cellNodes) {
            String strORDERINFO;
            String strPDEId = cellNode.GetExtValue("PDEID", "");
            if (StringHelper.IsNullOrEmpty((String)strPDEId)) {
                XMLNode dataGroupFetchNode = new XMLNode();
                dataGroupFetchNode.setNodeName("SRFEXDGEXDATAGROUPFETCH");
                cellNode.AddNode(dataGroupFetchNode);
                continue;
            }
            cellNode.SetExtValue("ID", cellNode.GetExtValue("DATAGROUPID", ""));
            strDEId = cellNode.GetExtValue("DEID", "");
            String strSQLPARAM = cellNode.GetExtValue("SQLPARAM", "");
            IDEHelper pDEHelper = this.globalHelperEx.getDAModelStorage().FindDEHelper(strPDEId);
            if (pDEHelper == null) {
                log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)strPDEId));
                return null;
            }
            deHelperMap.put(strPDEId, pDEHelper);
            strSQLPARAM = pDEHelper.GetKeyDEFHelper().getName();
            String strSQL = cellNode.GetExtValue("SQL", "");
            if (StringHelper.IsNullOrEmpty((String)strSQL)) {
                IDEHelper curDEHelper = this.globalHelperEx.getDAModelStorage().FindDEHelper(strDEId);
                if (curDEHelper == null) {
                    log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)strDEId));
                    return null;
                }
                deHelperMap.put(strDEId, curDEHelper);
                String strFKey = "";
                Vector der1ns = curDEHelper.GetDER1Ns(false);
                for (DER1N der1n : der1ns) {
                    if (StringHelper.Compare((String)der1n.getMAJORDEID(), (String)strPDEId, (boolean)true) != 0) continue;
                    strFKey = der1n.getMAJORKEYDEFNAME();
                    break;
                }
                if (StringHelper.IsNullOrEmpty((String)strFKey)) {
                    log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u4e0e\u5b9e\u4f53[%2$s]\u7684\u5173\u7cfb\u5c5e\u6027", (Object)strDEId, (Object)strPDEId));
                    return null;
                }
                BaseDataEntity dataEntity = new BaseDataEntity();
                dataEntity.SetParamValue(strFKey, (Object)"");
                Vector procParams = new Vector();
                strSQL = curDEHelper.GetSelectCode(dataEntity, procParams);
            }
            if (!StringHelper.IsNullOrEmpty((String)(strORDERINFO = cellNode.GetExtValue("ORDERINFO", "")))) {
                strSQL = String.valueOf(strSQL) + " ";
                strSQL = String.valueOf(strSQL) + strORDERINFO;
            }
            XMLNode dataGroupFetchNode = new XMLNode();
            dataGroupFetchNode.setNodeName("SRFEXDGEXDATAGROUPFETCH");
            dataGroupFetchNode.SetValue("SQL", strSQL);
            dataGroupFetchNode.SetValue("SQLPARAMS", strSQLPARAM);
            cellNode.AddNode(dataGroupFetchNode);
        }
        cellNodes.clear();
        rootNode.GetAllNodeByNodeName("SRFEXDGEXCELL", cellNodes);
        rootNode.GetAllNodeByNodeName("SRFEXITEMPARAM", cellNodes);
        for (XMLNode cellNode : cellNodes) {
            String strCodeListId;
            String strDEFId = cellNode.GetExtValue("DEFID", "");
            strDEId = cellNode.GetExtValue("DEID", "");
            if (StringHelper.IsNullOrEmpty((String)strDEFId) || StringHelper.IsNullOrEmpty((String)strDEId)) {
                String strItemId = cellNode.GetExtValue("ITEMID", "");
                if (StringHelper.IsNullOrEmpty((String)strItemId)) continue;
                cellNode.setID(strItemId);
                continue;
            }
            IDEHelper curDEHelper = (IDEHelper)deHelperMap.get(strDEId);
            if (curDEHelper == null) {
                log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)strDEId));
                return null;
            }
            IDEFHelper iDEFHelper = curDEHelper.GetDEFHelper(strDEFId);
            if (iDEFHelper == null) {
                log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u5c5e\u6027[%2$s]\u8f85\u52a9\u5bf9\u8c61", (Object)strDEId, (Object)strDEFId));
                return null;
            }
            cellNode.setID(iDEFHelper.getName());
            String strItemFormat = cellNode.GetExtValue("ITEMFORMAT", "");
            if (StringHelper.IsNullOrEmpty((String)strItemFormat)) {
                cellNode.SetValue("ITEMFORMAT", iDEFHelper.getDGItem().GetItemFormat(null));
            }
            if (!StringHelper.IsNullOrEmpty((String)(strCodeListId = cellNode.GetExtValue("CODELISTID", "")))) continue;
            cellNode.SetValue("CODELIST", iDEFHelper.GetCodeList());
        }
        return rootNode;
    }

    public DPConfig GetDPConfig(IDEHelper iDEHelper, String strFormModelXML) {
        XMLNode rootNode = XMLNode.LoadFromXML((String)strFormModelXML);
        if ((rootNode = this.GetDPConfig(iDEHelper, rootNode, null)) == null) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            SimpleXMLWriter writer = new SimpleXMLWriter(sb);
            writer.WriteRaw("<?xml version=\"1.0\" encoding=\"utf-8\" ?>\r\n");
            rootNode.Save(writer);
            InputSource is = new InputSource(new StringReader(sb.toString()));
            DOMParser parser = new DOMParser();
            parser.parse(is);
            Document doc = parser.getDocument();
            DPConfig dpConfig = new DPConfig();
            dpConfig.LoadConfig((Node)doc.getDocumentElement());
            return dpConfig;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u5bfc\u5165\u914d\u7f6e\u6587\u4ef6\u5931\u8d25\uff0c\u539f\u56e0\uff1a%1$s", (Object)ex.getMessage()));
            return null;
        }
    }

    /*
     * Enabled aggressive exception aggregation
     */
    protected XMLNode GetDPConfig(IDEHelper iDEHelper, XMLNode rootNode, Form formView) {
        CallResult callResult = new CallResult();
        try {
            Object iDEFHelper;
            IDEDataCtrl formPartDataCtrl;
            if (rootNode == null) {
                log.error((Object)StringHelper.Format((String)"\u8f7d\u5165\u8868\u5355\u6a21\u578b\u5931\u8d25"));
                return null;
            }
            Hashtable<String, String> pkeys = new Hashtable<String, String>();
            if (iDEHelper.GetKeyDEFHelper() != null) {
                pkeys.put(iDEHelper.GetKeyDEFHelper().getId(), "");
            }
            if ((formPartDataCtrl = this.globalHelperEx.getDAModelStorage().FindDEDataCtrl("DE0083", "SYSTEM", null)) == null) {
                log.warn((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0083"));
                return null;
            }
            IDEDataCtrl rawFIStyleDataCtrl = null;
            TreeMap<String, RawFIStyle> rawFIStyleMap = new TreeMap<String, RawFIStyle>();
            if (this.globalHelperEx.getDAModelVersion() >= 10120900 && (rawFIStyleDataCtrl = this.globalHelperEx.getDAModelStorage().FindDEDataCtrl("DE0069", "SYSTEM", null)) == null) {
                log.warn((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0069"));
            }
            ArrayList rawItemNodes = new ArrayList();
            rootNode.GetAllNodeByNodeName("SRFEXDPRAWITEM", rawItemNodes);
            for (XMLNode rawItemNode : rawItemNodes) {
                boolean bDPModel = rawItemNode.GetExtValue("DPMODEL", false);
                boolean bDPModelFill = rawItemNode.GetExtValue("DPMODELFILL", false);
                if (!bDPModel || !bDPModelFill) continue;
                String strXML = "";
                String strFormPartId = rawItemNode.GetExtValue("FORMPARTID", "");
                if (!StringHelper.IsNullOrEmpty((String)strFormPartId)) {
                    FormPart formPart = new FormPart();
                    formPart.setFORMPARTID(strFormPartId);
                    callResult = formPartDataCtrl.Get((BaseDataEntity)formPart);
                    if (callResult.IsError()) {
                        log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u9884\u5b9a\u4e49\u8868\u5355\u90e8\u4ef6[%1$s]\u5931\u8d25\uff0c%2$s", (Object)strFormPartId, (Object)callResult.getErrorInfo()));
                        continue;
                    }
                    strXML = formPart.getFORMPARTMODEL();
                } else {
                    strXML = rawItemNode.GetExtValue("CONTENT", "");
                }
                if (StringHelper.IsNullOrEmpty((String)strXML)) {
                    log.error((Object)StringHelper.Format((String)"\u81ea\u5b9a\u4e49\u8868\u5355\u9879\u6307\u5b9a\u76f4\u63a5\u8868\u5355\u903b\u8f91\uff0c\u4f46\u6ca1\u6709\u5b9a\u4e49\u903b\u8f91\u5185\u5bb9\u3002"));
                    continue;
                }
                strXML = "<?xml version=\"1.0\" encoding=\"utf-8\" ?>" + strXML;
                rawItemNode.Reset();
                XMLConfig.LoadFromXML((String)strXML, (XMLConfig)rawItemNode);
            }
            rawItemNodes.clear();
            ArrayList tabPageNodes = new ArrayList();
            rootNode.GetAllNodeByNodeName("SRFEXDPPAGEGROUP", tabPageNodes);
            for (XMLNode tabPageNode : tabPageNodes) {
                String strCapLanResId = tabPageNode.GetExtValue("CAPLANRESID", "");
                if (!StringHelper.IsNullOrEmpty((String)strCapLanResId)) {
                    String strCaption = tabPageNode.GetExtValue("CAPTION", "");
                    strCaption = this.GetLocalization(iDEHelper, strCapLanResId, strCaption);
                    tabPageNode.SetExtValue("CAPTION", strCaption);
                }
                this.FillDPPageGroupNodeDERMode(iDEHelper, tabPageNode, formView);
            }
            ArrayList groupNodes = new ArrayList();
            rootNode.GetAllNodeByNodeName("SRFEXDPGROUP", groupNodes);
            for (XMLNode groupNode : groupNodes) {
                String strCapLanResId = groupNode.GetExtValue("CAPLANRESID", "");
                if (StringHelper.IsNullOrEmpty((String)strCapLanResId)) continue;
                String strCaption = groupNode.GetExtValue("CAPTION", "");
                strCaption = this.GetLocalization(iDEHelper, strCapLanResId, strCaption);
                groupNode.SetExtValue("CAPTION", strCaption);
            }
            ArrayList dpGroupNodes = new ArrayList();
            rootNode.GetAllNodeByNodeName("SRFEXDPGROUP", dpGroupNodes);
            rootNode.GetAllNodeByNodeName("SRFEXDPPAGEGROUP", dpGroupNodes);
            for (XMLNode dpGroupNode : dpGroupNodes) {
                String strCode;
                String strDPGroupLogic = dpGroupNode.GetExtValue("LOGICXML", "");
                if (StringHelper.IsNullOrEmpty((String)strDPGroupLogic)) continue;
                FormItemLogicConfig formItemLogicConfig = new FormItemLogicConfig();
                XMLConfig.LoadFromXML((String)strDPGroupLogic, (XMLConfig)formItemLogicConfig);
                DefaultFormItemLogicHelper defaultFormItemLogicHelper = new DefaultFormItemLogicHelper(this.globalHelperEx, iDEHelper);
                FormItemRuleConfig formItemRuleConfig = formItemLogicConfig.FindFormItemRuleConfig("CONTROLENABLE");
                if (formItemRuleConfig == null || !StringHelper.IsNullOrEmpty((String)(strCode = dpGroupNode.GetExtValue("ENABLECOND", ""))) || !(callResult = defaultFormItemLogicHelper.GetEnableCode(formItemRuleConfig)).IsOk() || StringHelper.IsNullOrEmpty((String)(strCode = (String)callResult.getUserObject()))) continue;
                dpGroupNode.SetValue("ENABLECOND", strCode);
            }
            ArrayList dpDataGridNodes = new ArrayList();
            rootNode.GetAllNodeByNodeName("SRFEXDPDATAGRIDITEM", dpDataGridNodes);
            if (dpDataGridNodes.size() > 0) {
                for (XMLNode dpDataGridNode : dpDataGridNodes) {
                    String strDERId = dpDataGridNode.GetExtValue("DER1NID", "");
                    Iterator strDGId = dpDataGridNode.GetExtValue("DGID", "");
                    String strURLParams = dpDataGridNode.GetExtValue("URLPARAMS", "");
                    String strRelatedFields = dpDataGridNode.GetExtValue("RELATEDFIELDS", "");
                    String strPageId = dpDataGridNode.GetExtValue("PAGEID", "");
                    String strSaveBeforeMajor = dpDataGridNode.GetExtValue("SAVEBEFOREMAJOR", "");
                    String strTempData = dpDataGridNode.GetExtValue("TEMPDATA", "");
                    String strSaveMajorTip = dpDataGridNode.GetExtValue("SAVEMAJORTIP", "");
                    String strRelatedFormState = dpDataGridNode.GetExtValue("RELATEDFORMSTATE", "");
                    String strIgnoreParams = dpDataGridNode.GetExtValue("APPENDCTXPARAMS", "");
                    if (StringHelper.IsNullOrEmpty((String)strDERId)) {
                        log.error((Object)StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u5185\u5d4c\u8868\u683cDER1N\u5173\u7cfb\u7f16\u53f7"));
                        return null;
                    }
                    TreeMap<String, Object> urlParams = new TreeMap<String, Object>();
                    urlParams.put("SRFGRIDVIEW", strDGId);
                    urlParams.put("SRFDERID", strDERId);
                    urlParams.put("SRFSUMMARYKEY", iDEHelper.GetKeyDEFHelper().getName().toUpperCase());
                    urlParams.put("SRFDGAL", "FALSE");
                    String strGridViewUrl = "";
                    if (StringHelper.IsNullOrEmpty((String)strPageId)) {
                        strGridViewUrl = "../srfpage/embedgridview.jsp";
                    } else {
                        Page page = this.globalHelperEx.getDAModelStorage().FindPage(strPageId);
                        if (page == null) {
                            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u9875\u9762\u5bf9\u8c61[%1$s]", (Object)strPageId));
                            return null;
                        }
                        strGridViewUrl = page.GetTotalPagePath();
                    }
                    strGridViewUrl = URLHelper.AppendURLSeperator((String)strGridViewUrl);
                    strGridViewUrl = String.valueOf(strGridViewUrl) + URLHelper.GetQueryString(urlParams);
                    if (!StringHelper.IsNullOrEmpty((String)strURLParams)) {
                        strGridViewUrl = URLHelper.AppendURLSeperator((String)strGridViewUrl);
                        strGridViewUrl = String.valueOf(strGridViewUrl) + strURLParams;
                    }
                    XMLNode dgItem = new XMLNode();
                    dgItem.setNodeName("SRFEXDPDATAGRID");
                    dgItem.SetValue("URL", strGridViewUrl);
                    String strKeys = String.valueOf(iDEHelper.GetKeyDEFHelper().getName()) + ";SRFDATEMPKEYID";
                    dgItem.SetValue("RELATEDFIELDS", strRelatedFields);
                    dgItem.SetValue("KEYFIELDS", strKeys);
                    dgItem.SetValue("HEIGHT", dpDataGridNode.GetExtValue("HEIGHT", "100"));
                    if (!StringHelper.IsNullOrEmpty((String)strSaveBeforeMajor)) {
                        dgItem.SetValue("SAVEBEFOREMAJOR", strSaveBeforeMajor);
                    }
                    if (!StringHelper.IsNullOrEmpty((String)strTempData)) {
                        dgItem.SetValue("TEMPDATA", strTempData);
                    }
                    if (!StringHelper.IsNullOrEmpty((String)strSaveMajorTip)) {
                        dgItem.SetValue("SAVEMAJORTIP", strSaveMajorTip);
                    }
                    if (!StringHelper.IsNullOrEmpty((String)strRelatedFormState)) {
                        dgItem.SetValue("RELATEDFORMSTATE", strRelatedFormState);
                    }
                    dgItem.SetValue("APPENDCTXPARAMS", strIgnoreParams);
                    dpDataGridNode.AddNode(dgItem);
                }
            }
            ArrayList formItemNodes = new ArrayList();
            rootNode.GetAllNodeByNodeName("SRFEXDPFORMITEM", formItemNodes);
            ArrayList<XMLNode> hiddenNodes = new ArrayList<XMLNode>();
            for (XMLNode formItemNode : formItemNodes) {
                XMLNode formCtrlNode;
                String strFormItemLogic;
                String strRawFIStyleId;
                String strDEField = formItemNode.GetExtValue("DEFIELD", "");
                if (StringHelper.IsNullOrEmpty((String)strDEField)) continue;
                iDEFHelper = iDEHelper.GetDEFHelper(strDEField);
                if (iDEFHelper == null) {
                    log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u8868\u5355\u9879[%1$s]\u7684\u5b57\u6bb5\u4fe1\u606f", (Object)strDEField));
                    continue;
                }
                formItemNode.SetValue("DEFName", iDEFHelper.getName());
                if (this.globalHelperEx.getDAModelVersion() >= 10120900 && !StringHelper.IsNullOrEmpty((String)(strRawFIStyleId = formItemNode.GetExtValue("RAWFISTYLEID", "")))) {
                    RawFIStyle rawFIStyle = (RawFIStyle)rawFIStyleMap.get(strRawFIStyleId);
                    if (rawFIStyle == null) {
                        rawFIStyle = new RawFIStyle();
                        rawFIStyle.setRAWFISTYLEID(strRawFIStyleId);
                        callResult = rawFIStyleDataCtrl.Get((BaseDataEntity)rawFIStyle);
                        if (callResult.IsError()) {
                            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u8868\u5355\u9879\u5bb9\u5668\u6837\u5f0f[%1$s]\u5931\u8d25,%2$s", (Object)strRawFIStyleId, (Object)callResult.getErrorInfo()));
                            continue;
                        }
                        rawFIStyleMap.put(strRawFIStyleId, rawFIStyle);
                    }
                    formItemNode.SetValue("BEGINHTML", rawFIStyle.getBEGINTAG());
                    formItemNode.SetValue("ENDHTML", rawFIStyle.getENDTAG());
                }
                if (!StringHelper.IsNullOrEmpty((String)(strFormItemLogic = formItemNode.GetExtValue("LOGICXML", "")))) {
                    String strCode;
                    FormItemLogicConfig formItemLogicConfig = new FormItemLogicConfig();
                    XMLConfig.LoadFromXML((String)strFormItemLogic, (XMLConfig)formItemLogicConfig);
                    DefaultFormItemLogicHelper defaultFormItemLogicHelper = new DefaultFormItemLogicHelper(this.globalHelperEx, iDEHelper);
                    FormItemRuleConfig formItemRuleConfig = formItemLogicConfig.FindFormItemRuleConfig("CONTROLENABLE");
                    if (formItemRuleConfig != null) {
                        strCode = formItemNode.GetExtValue("ENABLECOND", "");
                        if (StringHelper.IsNullOrEmpty((String)strCode)) {
                            callResult = defaultFormItemLogicHelper.GetEnableCode(formItemRuleConfig);
                            if (callResult.IsOk() && !StringHelper.IsNullOrEmpty((String)(strCode = (String)callResult.getUserObject()))) {
                                formItemNode.SetValue("ENABLECOND", strCode);
                            }
                        } else {
                            String strCode2;
                            callResult = defaultFormItemLogicHelper.GetEnableCode(formItemRuleConfig);
                            if (callResult.IsOk() && !StringHelper.IsNullOrEmpty((String)(strCode2 = (String)callResult.getUserObject()))) {
                                String strNewCode = "'('+" + strCode + "+')&&('+" + strCode2 + "+')'";
                                formItemNode.SetValue("ENABLECOND", strNewCode);
                            }
                        }
                    }
                    if ((formItemRuleConfig = formItemLogicConfig.FindFormItemRuleConfig("ALLOWEMPTY")) != null) {
                        strCode = formItemNode.GetExtValue("ALLOWEMPTYCOND", "");
                        if (StringHelper.IsNullOrEmpty((String)strCode) && (callResult = defaultFormItemLogicHelper.GetAllowEmptyCode(formItemRuleConfig)).IsOk() && !StringHelper.IsNullOrEmpty((String)(strCode = (String)callResult.getUserObject()))) {
                            formItemNode.SetValue("ALLOWEMPTYCOND", strCode);
                        }
                        if (StringHelper.IsNullOrEmpty((String)(strCode = formItemNode.GetExtValue("ALLOWEMPTYCOND2", ""))) && (callResult = defaultFormItemLogicHelper.GetBackendAllowEmptyCode(formItemRuleConfig)).IsOk() && !StringHelper.IsNullOrEmpty((String)(strCode = (String)callResult.getUserObject()))) {
                            formItemNode.SetValue("ALLOWEMPTYCOND2", strCode);
                        }
                    }
                }
                if ((formCtrlNode = this.globalHelperEx.getDAFormItemHelper().GetFormCtrlNode(this.strPageModel, this.strLanguage, iDEFHelper.getDEHelper(), (IDEFHelper)iDEFHelper, formItemNode)) != null) {
                    boolean bHiddenNode = false;
                    String strTag = formCtrlNode.getNodeName();
                    if (StringHelper.Compare((String)strTag, (String)"SRFEXHIDDEN", (boolean)true) == 0) {
                        bHiddenNode = true;
                        if (formItemNode.getParentNode() != null) {
                            formItemNode.getParentNode().RemoveNode(formItemNode);
                        }
                        hiddenNodes.add(formCtrlNode);
                    }
                    if (!bHiddenNode) {
                        formItemNode.AddNode(formCtrlNode);
                    }
                    if (iDEFHelper.IsKeyDEField()) {
                        pkeys.remove(iDEFHelper.getId());
                    }
                }
                if (!iDEFHelper.IsEnableDEFieldPriv()) continue;
                XMLNode hiddenNode = new XMLNode();
                hiddenNode.setNodeName("SRFEXHIDDEN");
                hiddenNode.setID("SRFIP_" + iDEFHelper.getName());
                XMLNode itemNode = new XMLNode();
                itemNode.setNodeName("SRFEXFORMITEM");
                hiddenNode.AddNode(itemNode);
                itemNode.SetValue("KEY", "FALSE");
                itemNode.SetValue("DATATYPE", "INT");
                hiddenNodes.add(hiddenNode);
            }
            rootNode.GetAllNodeByNodeName("SRFEXDPRAWITEM", rawItemNodes);
            for (XMLNode rawItemNode : rawItemNodes) {
                String strRawFIStyleId;
                String strIOSStyle;
                String strContent;
                boolean bDPModel = rawItemNode.GetExtValue("DPMODEL", false);
                if (bDPModel) {
                    String strXML = "";
                    String strCustom = rawItemNode.GetExtValue("CUSTOM", "");
                    if (StringHelper.IsNullOrEmpty((String)strCustom)) {
                        String strFormPartId = rawItemNode.GetExtValue("FORMPARTID", "");
                        if (!StringHelper.IsNullOrEmpty((String)strFormPartId)) {
                            FormPart formPart = new FormPart();
                            formPart.setFORMPARTID(strFormPartId);
                            callResult = formPartDataCtrl.Get((BaseDataEntity)formPart);
                            if (callResult.IsError()) {
                                log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u9884\u5b9a\u4e49\u8868\u5355\u90e8\u4ef6[%1$s]\u5931\u8d25\uff0c%2$s", (Object)strFormPartId, (Object)callResult.getErrorInfo()));
                                continue;
                            }
                            strXML = formPart.getFORMPARTMODEL();
                        } else {
                            strXML = rawItemNode.GetExtValue("CONTENT", "");
                        }
                        if (StringHelper.IsNullOrEmpty((String)strXML)) {
                            log.error((Object)StringHelper.Format((String)"\u81ea\u5b9a\u4e49\u8868\u5355\u9879\u6307\u5b9a\u76f4\u63a5\u8868\u5355\u903b\u8f91\uff0c\u4f46\u6ca1\u6709\u5b9a\u4e49\u903b\u8f91\u5185\u5bb9\u3002"));
                            continue;
                        }
                        strXML = "<?xml version=\"1.0\" encoding=\"utf-8\" ?>" + strXML;
                        rawItemNode.Reset();
                        XMLConfig.LoadFromXML((String)strXML, (XMLConfig)rawItemNode);
                        continue;
                    }
                    strXML = rawItemNode.GetExtValue("CONTENT", "");
                    Object objDAConfigHelperPlugin = ObjectHelper.Create((String)strCustom);
                    if (objDAConfigHelperPlugin == null) {
                        log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u63d2\u4ef6\u5bf9\u8c61[%1$s]", (Object)strCustom));
                        continue;
                    }
                    if (!(objDAConfigHelperPlugin instanceof IDAConfigHelperPlugin)) {
                        log.error((Object)StringHelper.Format((String)"\u63d2\u4ef6\u5bf9\u8c61[%1$s]\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)strCustom));
                        continue;
                    }
                    IDAConfigHelperPlugin iDAConfigHelperPlugin = (IDAConfigHelperPlugin)objDAConfigHelperPlugin;
                    rawItemNode.Reset();
                    iDAConfigHelperPlugin.Process((IDAConfigHelper)this, iDEHelper, null, strXML, rootNode, rawItemNode);
                    continue;
                }
                String strLanguageResId = rawItemNode.GetExtValue("LANGUAGERESID", "");
                if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) == 0 || StringHelper.Compare((String)this.strPageModel, (String)"WinRT", (boolean)true) == 0) {
                    strContent = rawItemNode.GetExtValue("SLCONTENT", "");
                    if (!StringHelper.IsNullOrEmpty((String)strContent)) {
                        rawItemNode.SetValue("CONTENT", strContent);
                        strLanguageResId = "";
                    }
                    strLanguageResId = rawItemNode.GetExtValue("SLLANGUAGERESID", strLanguageResId);
                }
                if (!StringHelper.IsNullOrEmpty((String)strLanguageResId)) {
                    strContent = rawItemNode.GetExtValue("CONTENT", "");
                    strContent = this.GetLocalization(iDEHelper, strLanguageResId, strContent);
                    rawItemNode.SetValue("CONTENT", strContent);
                }
                if (!StringHelper.IsNullOrEmpty((String)(strIOSStyle = rawItemNode.GetExtValue("IOSSTYLE", "")))) {
                    rawItemNode.SetValue("IOSSTYLE", strIOSStyle);
                }
                if (this.globalHelperEx.getDAModelVersion() < 10120900 || StringHelper.IsNullOrEmpty((String)(strRawFIStyleId = rawItemNode.GetExtValue("RAWFISTYLEID", "")))) continue;
                RawFIStyle rawFIStyle = (RawFIStyle)rawFIStyleMap.get(strRawFIStyleId);
                if (rawFIStyle == null) {
                    rawFIStyle = new RawFIStyle();
                    rawFIStyle.setRAWFISTYLEID(strRawFIStyleId);
                    callResult = rawFIStyleDataCtrl.Get((BaseDataEntity)rawFIStyle);
                    if (callResult.IsError()) {
                        log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u8868\u5355\u9879\u5bb9\u5668\u6837\u5f0f[%1$s]\u5931\u8d25,%2$s", (Object)strRawFIStyleId, (Object)callResult.getErrorInfo()));
                        continue;
                    }
                    rawFIStyleMap.put(strRawFIStyleId, rawFIStyle);
                }
                rawItemNode.SetValue("BEGINHTML", rawFIStyle.getBEGINTAG());
                rawItemNode.SetValue("ENDHTML", rawFIStyle.getENDTAG());
            }
            groupNodes.clear();
            rootNode.GetAllNodeByNodeName("SRFEXDPGROUP", groupNodes);
            for (XMLNode groupNode : groupNodes) {
                XMLNode newXMLNode;
                String strXML;
                XMLNode pageGroupNode;
                String strLoopFormId;
                if (groupNode.GetExtValue("ENABLELOOPMODE", false)) {
                    XMLNode pageGroupNode2;
                    int nLoopCnt = groupNode.GetExtValue("LOOPCNT", 5);
                    String strLoopTag = groupNode.GetExtValue("LOOPTAG", "_X_");
                    String strLoopFormId2 = groupNode.GetExtValue("LOOPFORMID", "");
                    if (StringHelper.IsNullOrEmpty((String)strLoopFormId2)) continue;
                    Form loopForm = new Form();
                    callResult = this.getDAGlobalHelper().getDAModelHelper().GetDEForm(strLoopFormId2, loopForm);
                    if (callResult.IsError()) {
                        log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5faa\u73af\u8868\u5355[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strLoopFormId2, (Object)callResult.getErrorInfo()));
                        return null;
                    }
                    XMLNode loopFormRootNode = XMLNode.LoadFromXML((String)loopForm.getFORMMODEL());
                    IDEHelper loopFormDEHelper = this.getGlobalHelper().getDAModelStorage().FindDEHelper(loopForm.getDEID());
                    loopFormRootNode = this.GetDPConfig(loopFormDEHelper, loopFormRootNode, loopForm);
                    if (loopFormRootNode == null) {
                        log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5faa\u73af\u8868\u5355[%1$s]\u6a21\u578b", (Object)strLoopFormId2));
                        return null;
                    }
                    ArrayList<String> childXMLList = new ArrayList<String>();
                    ArrayList<String> childXMLList2 = new ArrayList<String>();
                    ArrayList pageGroupNodes = new ArrayList();
                    loopFormRootNode.GetAllNodeByNodeName("SRFEXDPPAGEGROUP", pageGroupNodes);
                    if (pageGroupNodes.size() > 0 && (pageGroupNode2 = (XMLNode)pageGroupNodes.get(0)).getChildNodes() != null) {
                        for (XMLNode childNode : pageGroupNode2.getChildNodes()) {
                            childXMLList.add(XMLNode.Export((XMLNode)childNode));
                        }
                    }
                    ArrayList hiddenNodeList = new ArrayList();
                    loopFormRootNode.GetAllNodeByNodeName("SRFEXHIDDEN", hiddenNodeList);
                    if (hiddenNodeList.size() > 0) {
                        for (XMLNode hiddenXMLNode : hiddenNodeList) {
                            if (StringHelper.Compare((String)hiddenXMLNode.getID(), (String)"SRFDATEMPKEYID", (boolean)false) == 0 || StringHelper.Compare((String)hiddenXMLNode.getID(), (String)"SRFDAUPDATEDATE", (boolean)false) == 0 || StringHelper.Compare((String)hiddenXMLNode.getID(), (String)loopFormDEHelper.GetKeyDEFHelper().getName(), (boolean)false) == 0) continue;
                            childXMLList2.add(XMLNode.Export((XMLNode)hiddenXMLNode));
                        }
                    }
                    if (groupNode.getChildNodes() != null) {
                        groupNode.getChildNodes().clear();
                    }
                    int i = 0;
                    while (i < nLoopCnt) {
                        XMLNode newXMLNode2;
                        String strNewXML;
                        String strXML2;
                        Iterator iterator = childXMLList.iterator();
                        while (iterator.hasNext()) {
                            strNewXML = strXML2 = (String)iterator.next();
                            strNewXML = strNewXML.replace(strLoopTag, StringHelper.Format((String)"%1$03d", (Object)(i + 1)));
                            newXMLNode2 = XMLNode.LoadFromXML((String)strNewXML);
                            groupNode.AddNode(newXMLNode2);
                        }
                        iterator = childXMLList2.iterator();
                        while (iterator.hasNext()) {
                            strNewXML = strXML2 = (String)iterator.next();
                            strNewXML = strNewXML.replace(strLoopTag, StringHelper.Format((String)"%1$03d", (Object)(i + 1)));
                            newXMLNode2 = XMLNode.LoadFromXML((String)strNewXML);
                            hiddenNodes.add(newXMLNode2);
                        }
                        ++i;
                    }
                    continue;
                }
                if (!groupNode.GetExtValue("ENABLECHILDMODE", false) || StringHelper.IsNullOrEmpty((String)(strLoopFormId = groupNode.GetExtValue("CHILDFORMID", "")))) continue;
                Form loopForm = new Form();
                callResult = this.getDAGlobalHelper().getDAModelHelper().GetDEForm(strLoopFormId, loopForm);
                if (callResult.IsError()) {
                    log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5d4c\u5165\u8868\u5355[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strLoopFormId, (Object)callResult.getErrorInfo()));
                    return null;
                }
                XMLNode loopFormRootNode = XMLNode.LoadFromXML((String)loopForm.getFORMMODEL());
                IDEHelper loopFormDEHelper = this.getGlobalHelper().getDAModelStorage().FindDEHelper(loopForm.getDEID());
                loopFormRootNode = this.GetDPConfig(loopFormDEHelper, loopFormRootNode, loopForm);
                if (loopFormRootNode == null) {
                    log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u5d4c\u5165\u5faa\u73af\u8868\u5355[%1$s]\u6a21\u578b", (Object)strLoopFormId));
                    return null;
                }
                ArrayList<String> childXMLList = new ArrayList<String>();
                ArrayList<String> childXMLList2 = new ArrayList<String>();
                ArrayList pageGroupNodes = new ArrayList();
                loopFormRootNode.GetAllNodeByNodeName("SRFEXDPPAGEGROUP", pageGroupNodes);
                if (pageGroupNodes.size() > 0 && (pageGroupNode = (XMLNode)pageGroupNodes.get(0)).getChildNodes() != null) {
                    for (XMLNode childNode : pageGroupNode.getChildNodes()) {
                        childXMLList.add(XMLNode.Export((XMLNode)childNode));
                    }
                }
                ArrayList hiddenNodeList = new ArrayList();
                loopFormRootNode.GetAllNodeByNodeName("SRFEXHIDDEN", hiddenNodeList);
                if (hiddenNodeList.size() > 0) {
                    for (XMLNode hiddenXMLNode : hiddenNodeList) {
                        if (StringHelper.Compare((String)hiddenXMLNode.getID(), (String)"SRFDATEMPKEYID", (boolean)false) == 0 || StringHelper.Compare((String)hiddenXMLNode.getID(), (String)"SRFDAUPDATEDATE", (boolean)false) == 0 || StringHelper.Compare((String)hiddenXMLNode.getID(), (String)loopFormDEHelper.GetKeyDEFHelper().getName(), (boolean)false) == 0) continue;
                        childXMLList2.add(XMLNode.Export((XMLNode)hiddenXMLNode));
                    }
                }
                if (groupNode.getChildNodes() != null) {
                    groupNode.getChildNodes().clear();
                }
                Iterator iterator = childXMLList.iterator();
                while (iterator.hasNext()) {
                    String strNewXML = strXML = (String)iterator.next();
                    newXMLNode = XMLNode.LoadFromXML((String)strNewXML);
                    groupNode.AddNode(newXMLNode);
                }
                iterator = childXMLList2.iterator();
                while (iterator.hasNext()) {
                    String strNewXML = strXML = (String)iterator.next();
                    newXMLNode = XMLNode.LoadFromXML((String)strNewXML);
                    hiddenNodes.add(newXMLNode);
                }
            }
            XMLNode hiddenGroupNode = new XMLNode();
            hiddenGroupNode.setNodeName("SRFEXDPHIDDENGROUP");
            rootNode.AddNode(0, hiddenGroupNode);
            XMLNode hiddenNode = new XMLNode();
            hiddenNode.setNodeName("SRFEXHIDDEN");
            hiddenGroupNode.AddNode(hiddenNode);
            hiddenNode.setID("SRFDATEMPKEYID");
            XMLNode itemNode = new XMLNode();
            itemNode.setNodeName("SRFEXFORMITEM");
            hiddenNode.AddNode(itemNode);
            itemNode.SetValue("KEY", "FALSE");
            itemNode.SetValue("DATATYPE", "VARCHAR");
            itemNode.SetValue("REALID", "TRUE");
            if (this.OnGetDPCheckDataUpdateDate(formView)) {
                hiddenNode = new XMLNode();
                hiddenNode.setNodeName("SRFEXHIDDEN");
                hiddenGroupNode.AddNode(hiddenNode);
                hiddenNode.setID("SRFDAUPDATEDATE");
                itemNode = new XMLNode();
                itemNode.setNodeName("SRFEXFORMITEM");
                hiddenNode.AddNode(itemNode);
                itemNode.SetValue("KEY", "FALSE");
                itemNode.SetValue("DATATYPE", "DATETIME");
                itemNode.SetValue("REALID", "TRUE");
            }
            Enumeration en = pkeys.keys();
            while (en.hasMoreElements()) {
                String strKey = (String)en.nextElement();
                iDEFHelper = iDEHelper.GetDEFHelper(strKey);
                if (iDEFHelper == null) {
                    log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u8868\u5355\u9879[%1$s]\u7684\u5b57\u6bb5\u4fe1\u606f", (Object)strKey));
                    continue;
                }
                XMLNode hiddenNode2 = new XMLNode();
                hiddenNode2.setNodeName("SRFEXHIDDEN");
                hiddenGroupNode.AddNode(hiddenNode2);
                hiddenNode2.setID(iDEFHelper.getName());
                XMLNode itemNode2 = new XMLNode();
                itemNode2.setNodeName("SRFEXFORMITEM");
                hiddenNode2.AddNode(itemNode2);
                itemNode2.SetValue("KEY", "TRUE");
                itemNode2.SetValue("DATATYPE", iDEFHelper.GetStdDataType());
            }
            for (XMLNode xmlNode : hiddenNodes) {
                hiddenGroupNode.AddNode(xmlNode);
            }
            ArrayList defaultItemNodes = new ArrayList();
            rootNode.GetAllNodeByNodeName("SRFEXDEFAULTITEM", defaultItemNodes);
            for (XMLNode formItemNode : defaultItemNodes) {
                String strDEField = formItemNode.GetExtValue("DEFIELD", "");
                IDEFHelper iDEFHelper2 = iDEHelper.GetDEFHelper(strDEField);
                if (iDEFHelper2 == null) {
                    log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u8868\u5355\u9879[%1$s]\u7684\u5b57\u6bb5\u4fe1\u606f", (Object)strDEField));
                    continue;
                }
                formItemNode.SetValue("DEFName", iDEFHelper2.getName());
                formItemNode.setID(iDEFHelper2.getName());
                formItemNode.SetValue("DATATYPE", iDEFHelper2.GetStdDataType());
            }
            DAConfigHelper.OptimizeDPConfig(rootNode);
            return rootNode;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u8ba1\u7b97\u8868\u5355\u903b\u8f91\u65f6\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
            return null;
        }
    }

    protected void FillDPPageGroupNodeDERMode(IDEHelper iDEHelper, XMLNode tabPageNode, Form formView) throws Exception {
        String strDERMode = tabPageNode.GetExtValue("DERMODE", "");
        if (StringHelper.IsNullOrEmpty((String)strDERMode)) {
            return;
        }
        String strDERGroupId = tabPageNode.GetExtValue("DERGROUPID", "");
        if (StringHelper.IsNullOrEmpty((String)strDERGroupId)) {
            return;
        }
        int nHeight = tabPageNode.GetExtValue("HEIGHT", 500);
        XMLNode parentNode = tabPageNode.getParentNode();
        int nPos = parentNode.IndexOf(tabPageNode);
        parentNode.RemoveNode(tabPageNode);
        IDERGroupHelper iDERGroupHelper = iDEHelper.FindDERGroup(strDERGroupId);
        for (IDERGroupDetailHelper iDERGroupDetailHelper : iDERGroupHelper.getDetails()) {
            String strDetailType = iDERGroupDetailHelper.getDetailType();
            XMLNode newTabPageNode = new XMLNode();
            newTabPageNode.setNodeName("SRFEXDPPAGEGROUP");
            newTabPageNode.SetExtValue("CAPTION", iDERGroupDetailHelper.getCaption(this.getLanguage()));
            newTabPageNode.SetExtValue("RESOURCEID", iDERGroupDetailHelper.getResourceId());
            XMLNode dpRawItemNode = new XMLNode();
            dpRawItemNode.setNodeName("SRFEXDPRAWITEM");
            dpRawItemNode.SetExtValue("CUSTOM", "SA.SRFDA.Web.SRFDADPIframeItem");
            String strParams = "";
            if (StringHelper.Compare((String)strDetailType, (String)"DER1N", (boolean)true) == 0) {
                strParams = String.valueOf(strParams) + "IFMODE=DER1N\r\n";
                strParams = String.valueOf(strParams) + StringHelper.Format((String)"DERID=%1$s\r\n", (Object)iDERGroupDetailHelper.getDER1NId());
                if (!StringHelper.IsNullOrEmpty((String)iDERGroupDetailHelper.getUrlParam())) {
                    strParams = String.valueOf(strParams) + StringHelper.Format((String)"APPENDPARAMS=%1$s\r\n", (Object)iDERGroupDetailHelper.getUrlParam());
                }
            }
            strParams = String.valueOf(strParams) + StringHelper.Format((String)"HEIGHT=%1$s\r\n", (Object)nHeight);
            dpRawItemNode.SetExtValue("CONTENT", strParams);
            newTabPageNode.AddNode(dpRawItemNode);
            parentNode.AddNode(nPos, newTabPageNode);
            ++nPos;
        }
    }

    public String GetGridViewToolbarConfigId(IDEHelper iDEHelper, Page page, DataGrid dataGrid, boolean bPickupMode, boolean bMini, boolean bEnableRowEdit, boolean bInfoMode, boolean bEmbedMode, TreeMap<String, Boolean> buttonStateMap) {
        XMLNode tbItemNode;
        String strRemoveTooltip;
        String strViewTipFormat;
        String strViewFormat;
        XMLNode tbItemNode2;
        String strImportList;
        int i;
        String[] list;
        String strExportList;
        String strToolbarConfigId = "";
        if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) == 0 || StringHelper.Compare((String)this.strPageModel, (String)"WinRT", (boolean)true) == 0) {
            bMini = true;
        }
        strToolbarConfigId = page == null ? StringHelper.Format((String)"DE%1$s.TB_GRID_%5$s_%4$s_%2$s_%3$s", (Object)iDEHelper.getId(), (Object)iDEHelper.getVersion(), (Object)dataGrid.getDGVERSION(), (Object)(bMini ? "MINI" : ""), (Object)(bEnableRowEdit ? "1" : "0")) : StringHelper.Format((String)"DE%1$s.TB_PAGE_%5$s_%6$s_GRID_%4$s_%7$s_%2$s_%3$s", (Object)iDEHelper.getId(), (Object)iDEHelper.getVersion(), (Object)dataGrid.getDGVERSION(), (Object)(bMini ? "MINI" : ""), (Object)page.getPAGEID(), (Object)page.getVERSION(), (Object)(bEnableRowEdit ? "1" : "0"));
        if (bInfoMode) {
            strToolbarConfigId = String.valueOf(strToolbarConfigId) + "_I";
        }
        if (bPickupMode) {
            strToolbarConfigId = String.valueOf(strToolbarConfigId) + "_P";
        }
        if (bEmbedMode) {
            strToolbarConfigId = String.valueOf(strToolbarConfigId) + "_E";
        }
        if (!StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
            strToolbarConfigId = String.valueOf(strToolbarConfigId) + StringHelper.Format((String)"_PM_%1$s", (Object)this.strPageModel);
        }
        if (!StringHelper.IsNullOrEmpty((String)this.strLanguage)) {
            strToolbarConfigId = String.valueOf(strToolbarConfigId) + StringHelper.Format((String)"_%1$s", (Object)this.strLanguage);
        }
        strToolbarConfigId = strToolbarConfigId.toUpperCase();
        String strTBFilePath = ConfigPathHelper.GetRuntimeToolbarConfigPath((String)this.globalHelperEx.GetAppRootPath(), (String)strToolbarConfigId);
        File file = new File(strTBFilePath);
        if (file.exists()) {
            return strToolbarConfigId;
        }
        boolean bEnableUserCreate = iDEHelper.IsEnableUserCreate();
        boolean bEnableUserUpdate = iDEHelper.IsEnableUserUpdate();
        boolean bEnableUserView = iDEHelper.IsEnableUserView();
        boolean bEnableUserDelete = iDEHelper.IsEnableUserDelete();
        boolean bNewButton = bEnableUserCreate;
        boolean bEditButton = bEnableUserUpdate;
        boolean bViewButton = bEnableUserView;
        boolean bRemoveButton = bEnableUserDelete;
        boolean bCopyButton = bEnableUserCreate;
        boolean bExportButton = true;
        boolean bOtherAction = true;
        boolean bPrintAction = iDEHelper.IsEnablePrint();
        boolean bMultiPrint = false;
        boolean bSearchBar = true;
        boolean bExportXMLButton = true;
        boolean bReplaceDefault = false;
        boolean bNewRowAction = bEnableUserCreate;
        boolean bEditRowAction = bEnableUserUpdate;
        boolean bHelpAction = iDEHelper.IsEnableHelp();
        boolean bImportExcel = iDEHelper.IsEnableImport();
        if (!bEnableUserUpdate) {
            bEnableRowEdit = false;
        }
        String strObjectName = iDEHelper.getLogicName(this.strLanguage);
        bMultiPrint = this.globalHelperEx.getWebExConfig().GetValue("SRFDA", TAG_MULTIPRINT, "FALSE").equalsIgnoreCase("TRUE");
        switch (iDEHelper.getDataEntity().GetParamIntValue("ISMULTIPRINT", -1)) {
            case 0: {
                bMultiPrint = false;
                break;
            }
            case 1: {
                bMultiPrint = true;
                break;
            }
        }
        if (bPickupMode) {
            bExportButton = false;
        }
        if (bEmbedMode) {
            bPrintAction = false;
            bMultiPrint = false;
            bSearchBar = false;
            bHelpAction = false;
            bOtherAction = false;
        }
        if (buttonStateMap != null) {
            bNewButton = DAConfigHelper.GetButtonState(buttonStateMap, TAG_NEWACTION, bNewButton);
            bEditButton = DAConfigHelper.GetButtonState(buttonStateMap, TAG_EDITACTION, bEditButton);
            bViewButton = DAConfigHelper.GetButtonState(buttonStateMap, TAG_VIEWACTION, bEditButton);
            bRemoveButton = DAConfigHelper.GetButtonState(buttonStateMap, TAG_REMOVEACTION, bRemoveButton);
            bCopyButton = DAConfigHelper.GetButtonState(buttonStateMap, TAG_COPYACTION, bCopyButton);
            bExportButton = DAConfigHelper.GetButtonState(buttonStateMap, TAG_EXPORTACTION, bExportButton);
            bOtherAction = DAConfigHelper.GetButtonState(buttonStateMap, TAG_OTHERACTION, bOtherAction);
            bPrintAction = DAConfigHelper.GetButtonState(buttonStateMap, TAG_PRINTACTION, bPrintAction);
            bSearchBar = DAConfigHelper.GetButtonState(buttonStateMap, TAG_SEARCHBARACTION, bSearchBar);
            bExportXMLButton = DAConfigHelper.GetButtonState(buttonStateMap, TAG_EXPORTXMLACTION, bExportXMLButton);
            bNewRowAction = DAConfigHelper.GetButtonState(buttonStateMap, TAG_NEWROWACTION, bNewRowAction);
            bEditRowAction = DAConfigHelper.GetButtonState(buttonStateMap, TAG_EDITROWACTION, bEditRowAction);
            bHelpAction = DAConfigHelper.GetButtonState(buttonStateMap, TAG_HELPACTION, bHelpAction);
            bImportExcel = DAConfigHelper.GetButtonState(buttonStateMap, TAG_IMPORTEXCELACTION, bImportExcel);
        }
        if (bExportXMLButton && !StringHelper.IsNullOrEmpty((String)(strExportList = this.globalHelperEx.getWebExConfig().GetValue("SRFDA", "EXPORTMODEL", "")))) {
            bExportXMLButton = false;
            list = strExportList.split("[|]");
            i = 0;
            while (i < list.length) {
                if (StringHelper.Compare((String)list[i], (String)iDEHelper.getDataEntity().getDEGROUP(), (boolean)true) == 0) {
                    bExportXMLButton = true;
                    break;
                }
                if (StringHelper.Compare((String)list[i], (String)iDEHelper.getId(), (boolean)true) == 0) {
                    bExportXMLButton = true;
                    break;
                }
                ++i;
            }
        }
        if (bImportExcel && !StringHelper.IsNullOrEmpty((String)(strImportList = this.globalHelperEx.getWebExConfig().GetValue("SRFDA", "IMPORTEXCEL", "")))) {
            bImportExcel = false;
            list = strImportList.split("[|]");
            i = 0;
            while (i < list.length) {
                if (StringHelper.Compare((String)list[i], (String)iDEHelper.getDataEntity().getDEGROUP(), (boolean)true) == 0) {
                    bImportExcel = true;
                    break;
                }
                if (StringHelper.Compare((String)list[i], (String)iDEHelper.getId(), (boolean)true) == 0) {
                    bImportExcel = true;
                    break;
                }
                ++i;
            }
        }
        DefaultToolbarWriterContext tbWriterContext = this.CreateTBWriterContext();
        tbWriterContext.setPage(page);
        tbWriterContext.setDEHelper(iDEHelper);
        tbWriterContext.setViewStyle("GRIDVIEW");
        tbWriterContext.setSimpleMode(bMini || bEmbedMode);
        tbWriterContext.RegisterGlobal(TBCOND_ROWACTIONBAR, bEnableRowEdit);
        tbWriterContext.RegisterGlobal(TAG_NEWACTION, bNewButton);
        tbWriterContext.RegisterGlobal(TAG_EDITACTION, bEditButton);
        tbWriterContext.RegisterGlobal(TAG_VIEWACTION, bViewButton);
        tbWriterContext.RegisterGlobal(TAG_REMOVEACTION, bRemoveButton);
        tbWriterContext.RegisterGlobal(TAG_COPYACTION, bCopyButton);
        tbWriterContext.RegisterGlobal(TAG_EXPORTACTION, bExportButton);
        tbWriterContext.RegisterGlobal(TAG_OTHERACTION, bOtherAction);
        tbWriterContext.RegisterGlobal(TAG_PRINTACTION, bPrintAction);
        tbWriterContext.RegisterGlobal(TAG_SEARCHBARACTION, bSearchBar);
        tbWriterContext.RegisterGlobal(TAG_EXPORTXMLACTION, bExportXMLButton);
        tbWriterContext.RegisterGlobal(TAG_NEWROWACTION, bNewRowAction);
        tbWriterContext.RegisterGlobal(TAG_EDITROWACTION, bEditRowAction);
        tbWriterContext.RegisterGlobal(TAG_HELPACTION, bHelpAction);
        tbWriterContext.RegisterGlobal("IMPORTDATAACTION", bImportExcel);
        tbWriterContext.RegisterGlobal(TAG_INFOMODE, bInfoMode);
        XMLNode rootNode = new XMLNode();
        rootNode.setNodeName("SRFEXTOOLBAR");
        XMLNode tbItemsNode = new XMLNode();
        tbItemsNode.setNodeName(ToolbarItemsConfig.TAG_TOOLBARITEMS);
        rootNode.AddNode(tbItemsNode);
        Toolbar toolbar = null;
        if (page != null) {
            String strToolbarId = page.getTOOLBARID();
            if (!StringHelper.IsNullOrEmpty((String)strToolbarId) && (toolbar = this.globalHelperEx.getDAModelStorage().FindToolbar(strToolbarId)) == null) {
                log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5de5\u5177\u680f[%1$s]\u914d\u7f6e", (Object)strToolbarId));
                return "";
            }
            String strTBTEMPLID = "";
            if (toolbar != null) {
                strTBTEMPLID = toolbar.getTBTEMPLID();
            }
            if (StringHelper.IsNullOrEmpty((String)strTBTEMPLID)) {
                strTBTEMPLID = page.GetParamStringValue("TBTEMPLID", "");
            }
            ToolbarConfig tbConfig = null;
            if (StringHelper.IsNullOrEmpty((String)strTBTEMPLID)) {
                if (toolbar != null && toolbar.getNODEFAULT()) {
                    tbConfig = toolbar.getToolbarConfig();
                }
            } else {
                TBTempl tbTempl = this.globalHelperEx.getDAModelStorage().FindTBTempl(strTBTEMPLID);
                if (tbTempl == null) {
                    log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5de5\u5177\u680f\u6a21\u677f[%1$s]\u914d\u7f6e", (Object)strTBTEMPLID));
                    return "";
                }
                tbConfig = tbTempl.getToolbarConfig();
            }
            if (tbConfig != null) {
                tbWriterContext.setToolbar(toolbar);
                CallResult callResult = this.ExportToolbar(rootNode, tbItemsNode, tbConfig, tbWriterContext);
                if (callResult.IsError()) {
                    log.error((Object)StringHelper.Format((String)"\u5bfc\u51fa\u5de5\u5177\u680f\u53d1\u751f\u9519\u8bef,%1$s", (Object)callResult.getErrorInfo()));
                    return "";
                }
                if (!DAConfigHelper.ExportConfigFile((XMLNode)rootNode, (String)strTBFilePath)) {
                    return "";
                }
                return strToolbarConfigId;
            }
        }
        XMLNode userToolbar = null;
        String strToolbarXML = dataGrid.getDGTOOLBAR();
        userToolbar = DAConfigHelper.LoadToolbarConfig(strToolbarXML, page);
        if (toolbar != null) {
            tbWriterContext.setToolbar(toolbar);
            if (!toolbar.isNEWACTIONNull()) {
                bNewButton = toolbar.getNEWACTION();
            }
            if (!toolbar.isEDITACTIONNull()) {
                bEditButton = toolbar.getEDITACTION();
            }
            if (!toolbar.isVIEWACTIONNull()) {
                bViewButton = toolbar.getVIEWACTION();
            }
            if (!toolbar.isREMOVEACTIONNull()) {
                bRemoveButton = toolbar.getREMOVEACTION();
            }
            if (!toolbar.isCOPYACTIONNull()) {
                bCopyButton = toolbar.getCOPYACTION();
            }
            if (!toolbar.isOTHERACTIONNull()) {
                bOtherAction = toolbar.getOTHERACTION();
            }
            if (!toolbar.isPRINTACTIONNull()) {
                bPrintAction = toolbar.getPRINTACTION();
            }
            if (!toolbar.isEXPORTACTIONNull()) {
                bExportButton = toolbar.getEXPORTACTION();
            }
            if (!toolbar.isSEARCHBARACTIONNull()) {
                bSearchBar = toolbar.getSEARCHBARACTION();
            }
            if (!toolbar.isEXPORTXMLACTIONNull()) {
                bExportXMLButton = toolbar.getEXPORTXMLACTION();
            }
            if (!toolbar.isNEWROWACTIONNull()) {
                bNewRowAction = toolbar.getNEWROWACTION();
            }
            if (!toolbar.isEDITROWACTIONNull()) {
                bEditRowAction = toolbar.getEDITROWACTION();
            }
            if (!toolbar.isIMPORTDATAACTIONNull()) {
                bImportExcel = toolbar.getIMPORTDATAACTION();
            }
            if (!toolbar.isHELPACTIONNull()) {
                bHelpAction = toolbar.getHELPACTION();
            }
            if (!toolbar.isINFOMODENull()) {
                bInfoMode = toolbar.getINFOMODE();
            }
        }
        if (userToolbar != null) {
            if (bReplaceDefault = userToolbar.GetExtValue(TAG_SRFREPLACEDEFAULT, bReplaceDefault)) {
                userToolbar.setNodeName("SRFEXTOOLBAR");
                if (!DAConfigHelper.ExportConfigFile((XMLNode)userToolbar, (String)strTBFilePath)) {
                    return "";
                }
                return strToolbarConfigId;
            }
            if (bInfoMode = userToolbar.GetExtValue(TAG_INFOMODE, bInfoMode)) {
                bRemoveButton = false;
            }
            bNewButton = userToolbar.GetExtValue(TAG_NEWACTION, bNewButton);
            bEditButton = userToolbar.GetExtValue(TAG_EDITACTION, bEditButton);
            bViewButton = userToolbar.GetExtValue(TAG_VIEWACTION, bViewButton);
            bRemoveButton = userToolbar.GetExtValue(TAG_REMOVEACTION, bRemoveButton);
            bCopyButton = userToolbar.GetExtValue(TAG_COPYACTION, bCopyButton);
            bExportButton = userToolbar.GetExtValue(TAG_EXPORTACTION, bExportButton);
            bOtherAction = userToolbar.GetExtValue(TAG_OTHERACTION, bOtherAction);
            bPrintAction = userToolbar.GetExtValue(TAG_PRINTACTION, bPrintAction);
            bSearchBar = userToolbar.GetExtValue(TAG_SEARCHBARACTION, bSearchBar);
            bExportXMLButton = userToolbar.GetExtValue(TAG_EXPORTXMLACTION, bExportXMLButton);
            bNewRowAction = userToolbar.GetExtValue(TAG_NEWROWACTION, bNewRowAction);
            bEditRowAction = userToolbar.GetExtValue(TAG_EDITROWACTION, bEditRowAction);
            strObjectName = userToolbar.GetExtValue(TAG_OBJECTNAME, strObjectName);
            bHelpAction = userToolbar.GetExtValue(TAG_HELPACTION, bHelpAction);
            bImportExcel = userToolbar.GetExtValue(TAG_IMPORTEXCELACTION, bImportExcel);
        } else if (bInfoMode) {
            bRemoveButton = false;
        }
        this.OnAppendGridViewToolbar(1, rootNode, tbItemsNode, iDEHelper, page, dataGrid, bPickupMode, bMini, bEnableRowEdit, bInfoMode, bEmbedMode, buttonStateMap);
        IToolbarItemWriter group1Writer = this.FindDEBHGroupToolbarItemWriter("1");
        if (group1Writer != null) {
            TBItemConfig tbItemConfig = new TBItemConfig();
            tbItemConfig.setSeperator("LAST");
            group1Writer.Export(rootNode, tbItemsNode, tbItemConfig, null, (IToolbarItemWriterContext)tbWriterContext, false);
        }
        if (!bInfoMode) {
            if (bNewButton) {
                tbItemNode2 = new XMLNode();
                tbItemNode2.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
                tbItemsNode.AddNode(tbItemNode2);
                if (StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
                    tbItemNode2.SetValue("ICONCSSCLASS", "sx-tb-new");
                } else if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) == 0) {
                    tbItemNode2.SetValue("IMAGE", "../sasrfex/images/default/icon_new.png");
                }
                String strNewFormat = this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"GRIDVIEW", (String)"NEW"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"NEW"), "\u65b0\u5efa%1$s");
                String strNewTipFormat = this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"GRIDVIEW", (String)"NEW"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"NEW"), "\u65b0\u5efa%1$s");
                if (bMini) {
                    tbItemNode2.SetValue(ToolbarButtonConfig.TAG_TEXT, StringHelper.Format((String)strNewFormat, (Object)""));
                } else {
                    tbItemNode2.SetValue(ToolbarButtonConfig.TAG_TEXT, StringHelper.Format((String)strNewFormat, (Object)strObjectName));
                }
                tbItemNode2.SetValue("TIPS", StringHelper.Format((String)strNewTipFormat, (Object)strObjectName));
                tbItemNode2.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.GridNewHandler"));
                tbItemNode2.SetValue("RESOURCEID", UniResHelper.GetDEDataResId((String)iDEHelper.getId(), (String)"CREATE"));
                if (!StringHelper.IsNullOrEmpty((String)this.getPageModel())) {
                    this.RebuildGridViewNewAction(tbItemsNode, tbItemNode2, iDEHelper);
                }
            }
            if (bEditButton) {
                tbItemNode2 = new XMLNode();
                tbItemNode2.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
                tbItemsNode.AddNode(tbItemNode2);
                if (StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
                    tbItemNode2.SetValue("ICONCSSCLASS", "sx-tb-edit");
                }
                if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) == 0) {
                    tbItemNode2.SetValue("IMAGE", "../sasrfex/images/default/icon_edit.png");
                }
                String strEditFormat = this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"GRIDVIEW", (String)"EDIT"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"EDIT"), "\u7f16\u8f91");
                String strEditTipFormat = this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"GRIDVIEW", (String)"EDIT"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"EDIT"), "\u7f16\u8f91%1$s");
                tbItemNode2.SetValue(ToolbarButtonConfig.TAG_TEXT, strEditFormat);
                tbItemNode2.SetValue("TIPS", StringHelper.Format((String)strEditTipFormat, (Object)strObjectName));
                if (StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
                    tbItemNode2.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.GridEditHandler"));
                }
                if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) == 0) {
                    tbItemNode2.SetValue("HANDLERTYPE", "GRIDVIEW_EDITACTION");
                }
            } else if (bViewButton) {
                tbItemNode2 = new XMLNode();
                tbItemNode2.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
                tbItemsNode.AddNode(tbItemNode2);
                if (StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
                    tbItemNode2.SetValue("ICONCSSCLASS", "sx-tb-edit");
                }
                if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) == 0) {
                    tbItemNode2.SetValue("IMAGE", "../sasrfex/images/default/icon_edit.png");
                }
                strViewFormat = this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"GRIDVIEW", (String)"VIEW"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"VIEW"), "\u67e5\u770b");
                strViewTipFormat = this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"GRIDVIEW", (String)"VIEW"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"VIEW"), "\u67e5\u770b%1$s");
                tbItemNode2.SetValue(ToolbarButtonConfig.TAG_TEXT, strViewFormat);
                tbItemNode2.SetValue("TIPS", StringHelper.Format((String)strViewTipFormat, (Object)strObjectName));
                if (StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
                    tbItemNode2.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.GridEditHandler"));
                }
                if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) == 0) {
                    tbItemNode2.SetValue("HANDLERTYPE", "GRIDVIEW_EDITACTION");
                }
            }
            if (bCopyButton) {
                tbItemNode2 = new XMLNode();
                tbItemNode2.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
                tbItemsNode.AddNode(tbItemNode2);
                if (StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
                    tbItemNode2.SetValue("ICONCSSCLASS", "sx-tb-copy");
                } else if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) == 0) {
                    tbItemNode2.SetValue("IMAGE", "../sasrfex/images/default/icon_copy.png");
                }
                if (!bMini) {
                    tbItemNode2.SetValue(ToolbarButtonConfig.TAG_TEXT, this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"GRIDVIEW", (String)"COPY"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"COPY"), "\u62f7\u8d1d"));
                }
                String strCopyTooltip = this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"GRIDVIEW", (String)"COPY"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"COPY"), "\u62f7\u8d1d%1$s");
                tbItemNode2.SetValue("TIPS", StringHelper.Format((String)strCopyTooltip, (Object)strObjectName));
                tbItemNode2.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.GridCopyHandler"));
                tbItemNode2.SetValue("RESOURCEID", UniResHelper.GetDEDataResId((String)iDEHelper.getId(), (String)"CREATE"));
            }
            if (bNewButton || bEditButton || bCopyButton || bViewButton) {
                DAConfigHelper.AddToolbarSeperator(tbItemsNode);
            }
            if (bEnableRowEdit) {
                if (bEditRowAction) {
                    tbItemNode2 = new XMLNode();
                    tbItemNode2.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
                    tbItemsNode.AddNode(tbItemNode2);
                    if (StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
                        tbItemNode2.SetValue("ICONCSSCLASS", "sx-tb-editrow");
                    }
                    if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) == 0) {
                        tbItemNode2.SetValue("IMAGE", "../sasrfex/images/default/icon_rowedit.png");
                    }
                    tbItemNode2.SetValue(ToolbarButtonConfig.TAG_TEXT, this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"GRIDVIEW", (String)"EDITROW"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"EDITROW"), "\u884c\u7f16\u8f91"));
                    tbItemNode2.SetValue("TIPS", this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"GRIDVIEW", (String)"EDITROW"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"EDITROW"), "\u542f\u7528\u884c\u7f16\u8f91\u80fd\u529b"));
                    tbItemNode2.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.GridRowEditableHandler"));
                    tbItemNode2.SetValue("ENABLETOGGLE", "TRUE");
                    tbItemNode2.SetValue("RESOURCEID", UniResHelper.GetDEDataResId((String)iDEHelper.getId(), (String)"UPDATE"));
                }
                if (bNewRowAction) {
                    tbItemNode2 = new XMLNode();
                    tbItemNode2.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
                    tbItemsNode.AddNode(tbItemNode2);
                    if (StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
                        tbItemNode2.SetValue("ICONCSSCLASS", "sx-tb-addrow");
                    }
                    if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) == 0) {
                        tbItemNode2.SetValue("IMAGE", "../sasrfex/images/default/icon_addrow.png");
                    }
                    tbItemNode2.SetValue("TIPS", this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"GRIDVIEW", (String)"NEWROW"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"NEWROW"), "\u65b0\u52a0\u884c"));
                    tbItemNode2.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.GridNewRowHandler"));
                    tbItemNode2.SetValue("RESOURCEID", UniResHelper.GetDEDataResId((String)iDEHelper.getId(), (String)"CREATE"));
                }
                if (StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
                    tbItemNode2 = new XMLNode();
                    tbItemNode2.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
                    tbItemsNode.AddNode(tbItemNode2);
                    if (StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
                        tbItemNode2.SetValue("ICONCSSCLASS", "sx-tb-saverow");
                    }
                    if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) == 0) {
                        tbItemNode2.SetValue("IMAGE", "../sasrfex/images/default/icon_rowsave.png");
                    }
                    tbItemNode2.SetValue("TIPS", this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"GRIDVIEW", (String)"SAVEROW"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"SAVEROW"), "\u4fdd\u5b58\u884c"));
                    if (StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
                        tbItemNode2.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.GridSaveRowHandler"));
                    }
                    if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) == 0) {
                        tbItemNode2.SetValue("HANDLERTYPE", "GRIDVIEW_SAVEROW");
                    }
                    tbItemNode2.SetValue("RESOURCEID", UniResHelper.GetDEDataResId((String)iDEHelper.getId(), (String)"UPDATE"));
                }
                DAConfigHelper.AddToolbarSeperator(tbItemsNode);
            }
            if (bRemoveButton) {
                tbItemNode2 = new XMLNode();
                tbItemNode2.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
                tbItemsNode.AddNode(tbItemNode2);
                if (StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
                    tbItemNode2.SetValue("ICONCSSCLASS", "sx-tb-delete");
                }
                if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) == 0) {
                    tbItemNode2.SetValue("IMAGE", "../sasrfex/images/default/icon_delete.png");
                }
                if (!bMini) {
                    tbItemNode2.SetValue(ToolbarButtonConfig.TAG_TEXT, this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"GRIDVIEW", (String)"REMOVE"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"REMOVE"), "\u5220\u9664"));
                }
                strRemoveTooltip = this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"GRIDVIEW", (String)"REMOVE"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"REMOVE"), "\u5220\u9664%1$s");
                tbItemNode2.SetValue("TIPS", StringHelper.Format((String)strRemoveTooltip, (Object)strObjectName));
                tbItemNode2.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.GridRemoveHandler"));
                if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) == 0) {
                    tbItemNode2.SetValue("HANDLERTYPE", "GRIDVIEW_DELETE");
                }
                tbItemNode2.SetValue("RESOURCEID", UniResHelper.GetDEDataResId((String)iDEHelper.getId(), (String)"DELETE"));
                DAConfigHelper.AddToolbarSeperator(tbItemsNode);
            }
        } else {
            if (bEditButton || bViewButton) {
                tbItemNode2 = new XMLNode();
                tbItemNode2.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
                tbItemsNode.AddNode(tbItemNode2);
                if (StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
                    tbItemNode2.SetValue("ICONCSSCLASS", "sx-tb-edit");
                }
                if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) == 0) {
                    tbItemNode2.SetValue("IMAGE", "../sasrfex/images/default/icon_edit.png");
                }
                strViewFormat = this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"GRIDVIEW", (String)"VIEW"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"VIEW"), "\u67e5\u770b");
                strViewTipFormat = this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"GRIDVIEW", (String)"VIEW"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"VIEW"), "\u67e5\u770b%1$s");
                tbItemNode2.SetValue(ToolbarButtonConfig.TAG_TEXT, strViewFormat);
                tbItemNode2.SetValue("TIPS", StringHelper.Format((String)strViewTipFormat, (Object)strObjectName));
                if (StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
                    tbItemNode2.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.GridEditHandler"));
                }
                if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) == 0) {
                    tbItemNode2.SetValue("HANDLERTYPE", "GRIDVIEW_EDITACTION");
                }
            }
            if (bEditButton) {
                DAConfigHelper.AddToolbarSeperator(tbItemsNode);
            }
            if (bRemoveButton) {
                tbItemNode2 = new XMLNode();
                tbItemNode2.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
                tbItemsNode.AddNode(tbItemNode2);
                if (StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
                    tbItemNode2.SetValue("ICONCSSCLASS", "sx-tb-delete");
                }
                if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) == 0) {
                    tbItemNode2.SetValue("IMAGE", "../sasrfex/images/default/icon_delete.png");
                }
                if (!bMini) {
                    tbItemNode2.SetValue(ToolbarButtonConfig.TAG_TEXT, this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"GRIDVIEW", (String)"REMOVE"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"REMOVE"), "\u5220\u9664"));
                }
                strRemoveTooltip = this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"GRIDVIEW", (String)"REMOVE"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"REMOVE"), "\u5220\u9664%1$s");
                tbItemNode2.SetValue("TIPS", StringHelper.Format((String)strRemoveTooltip, (Object)strObjectName));
                if (StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
                    tbItemNode2.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.GridRemoveHandler"));
                }
                if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) == 0) {
                    tbItemNode2.SetValue("HANDLERTYPE", "GRIDVIEW_DELETE");
                }
                tbItemNode2.SetValue("RESOURCEID", UniResHelper.GetDEDataResId((String)iDEHelper.getId(), (String)"DELETE"));
                DAConfigHelper.AddToolbarSeperator(tbItemsNode);
            }
        }
        if (bExportButton) {
            tbItemNode2 = new XMLNode();
            tbItemNode2.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
            tbItemsNode.AddNode(tbItemNode2);
            if (StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
                tbItemNode2.SetValue("ICONCSSCLASS", "sx-tb-export");
            }
            if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) == 0) {
                tbItemNode2.SetValue("IMAGE", "../sasrfex/images/default/icon_export.png");
            }
            if (!bMini) {
                tbItemNode2.SetValue(ToolbarButtonConfig.TAG_TEXT, this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"GRIDVIEW", (String)"EXPORT"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"EXPORT"), "\u5bfc\u51fa"));
            }
            String strExportTooltip = this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"GRIDVIEW", (String)"EXPORT"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"EXPORT"), "\u5bfc\u51fa%1$s\u5230Excel\u6587\u4ef6");
            tbItemNode2.SetValue("TIPS", StringHelper.Format((String)strExportTooltip, (Object)strObjectName));
            tbItemNode2.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.GridExportExcelHandler"));
            if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) == 0) {
                tbItemNode2.SetValue("HANDLERTYPE", "GRIDVIEW_EXPORT");
            }
            String strMaxRow = iDEHelper.GetProperty("MAXDOWNLOADROW", this.globalHelperEx.getWebExConfig().GetValue("SRFDA", "MAXDOWNLOADROW", "1000"));
            tbItemNode2.SetValue("MAXROW", strMaxRow);
        }
        if (bPrintAction) {
            tbItemNode2 = new XMLNode();
            tbItemNode2.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
            tbItemsNode.AddNode(tbItemNode2);
            if (StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
                tbItemNode2.SetValue("ICONCSSCLASS", "sx-tb-print");
            }
            if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) == 0) {
                tbItemNode2.SetValue("IMAGE", "../sasrfex/images/default/icon_print.png");
            }
            if (!bMini) {
                tbItemNode2.SetValue(ToolbarButtonConfig.TAG_TEXT, this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"GRIDVIEW", (String)"PRINT"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"PRINT"), "\u6253\u5370"));
            }
            tbItemNode2.SetValue("TIPS", this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"GRIDVIEW", (String)"PRINT"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"PRINT"), "\u6253\u5370\u5f53\u524d\u6570\u636e"));
            tbItemNode2.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.GridPrintHandler"));
            if (bMultiPrint) {
                tbItemNode2.SetValue("ICONCSSCLASS", "sx-tb-mprint");
            }
            tbItemNode2.SetValue(TAG_MULTIPRINT, String.valueOf(bMultiPrint).toUpperCase());
        }
        if (bExportButton || bPrintAction) {
            DAConfigHelper.AddToolbarSeperator(tbItemsNode);
        }
        this.OnAppendGridViewToolbar(2, rootNode, tbItemsNode, iDEHelper, page, dataGrid, bPickupMode, bMini, bEnableRowEdit, bInfoMode, bEmbedMode, buttonStateMap);
        XMLNode userOtherAction = null;
        if (userToolbar != null && userToolbar.getChildNodes() != null) {
            boolean bAppendSeperator = false;
            for (XMLNode child : userToolbar.getChildNodes()) {
                String strID = child.getID();
                if (StringHelper.Compare((String)strID, (String)TAG_OTHERACTION, (boolean)true) != 0) {
                    if (StringHelper.Compare((String)child.getNodeName(), (String)"SRFDATBITEM", (boolean)true) == 0) {
                        bAppendSeperator = true;
                        this.ExportTBItem(rootNode, tbItemsNode, child, false, tbWriterContext, false);
                        continue;
                    }
                    int nPos = child.GetExtValue(TAG_POS, -1);
                    if (nPos == -1) {
                        tbItemsNode.AddNode(child);
                        bAppendSeperator = true;
                        continue;
                    }
                    tbItemsNode.AddNode(nPos, child);
                    continue;
                }
                userOtherAction = child;
            }
            if (bAppendSeperator && bOtherAction) {
                DAConfigHelper.AddToolbarSeperator(tbItemsNode);
            }
        }
        this.OnAppendGridViewToolbar(3, rootNode, tbItemsNode, iDEHelper, page, dataGrid, bPickupMode, bMini, bEnableRowEdit, bInfoMode, bEmbedMode, buttonStateMap);
        IToolbarItemWriter group2Writer = this.FindDEBHGroupToolbarItemWriter("2");
        if (group2Writer != null) {
            TBItemConfig tbItemConfig = new TBItemConfig();
            tbItemConfig.setSeperator("LAST");
            group2Writer.Export(rootNode, tbItemsNode, tbItemConfig, null, (IToolbarItemWriterContext)tbWriterContext, false);
        }
        if (bOtherAction) {
            IToolbarItemWriter group4Writer;
            tbItemNode = new XMLNode();
            tbItemNode.setNodeName(ToolbarSplitButtonConfig.TAG_TOOLBARSPLITBUTTON);
            if (!bMini) {
                tbItemNode.SetValue(ToolbarButtonConfig.TAG_TEXT, this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"GRIDVIEW", (String)"OTHER"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"OTHER"), "\u5176\u5b83"));
            } else {
                tbItemNode.SetValue(ToolbarButtonConfig.TAG_TEXT, this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"GRIDVIEW", (String)"OTHER"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"OTHER"), "\u5176\u5b83"));
            }
            tbItemNode.SetValue("ICONCSSCLASS", "sx-tb-other");
            tbItemsNode.AddNode(tbItemNode);
            XMLNode tbMenusNode = new XMLNode();
            tbMenusNode.setNodeName("SRFEXMAINMENUEX");
            tbItemNode.AddNode(tbMenusNode);
            IToolbarItemWriter group3Writer = this.FindDEBHGroupToolbarItemWriter("3");
            if (group3Writer != null) {
                TBItemConfig tbItemConfig = new TBItemConfig();
                tbItemConfig.setSeperator("LAST");
                group3Writer.Export(rootNode, tbMenusNode, tbItemConfig, null, (IToolbarItemWriterContext)tbWriterContext, true);
            }
            if (userOtherAction != null && userOtherAction.getChildNodes() != null) {
                for (XMLNode child : userOtherAction.getChildNodes()) {
                    if (StringHelper.Compare((String)child.getNodeName(), (String)"SRFDATBITEM", (boolean)true) == 0) {
                        this.ExportTBItem(rootNode, tbMenusNode, child, false, tbWriterContext, true);
                        continue;
                    }
                    tbMenusNode.AddNode(child);
                }
            }
            if (bExportXMLButton) {
                XMLNode tbMenuItemNode = new XMLNode();
                tbMenusNode.AddNode(tbMenuItemNode);
                tbMenuItemNode.setNodeName("SRFEXMENUITEMEX");
                tbMenuItemNode.SetValue("CAPTION", this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_MenuItemCaption((String)"GRIDVIEW", (String)"EXPORTSRF"), SRFDALocalizationHelper.GetRes_MenuItemCaption((String)"*", (String)"EXPORTSRF"), "\u5bfc\u51fa\u6570\u636e\u6a21\u578b"));
                tbMenuItemNode.SetValue("HANDLER", "SA.SRFDA.Ctrl.Toolbar.GridCustomCallHandler");
                tbMenuItemNode.SetValue("CALLID", "SRFDAEXPORTXML");
                tbMenuItemNode.SetValue("CALLNAME", "\u5bfc\u51faXML\u6a21\u578b");
                tbMenuItemNode.SetValue("CALLJSCODE", "if(confirm($P.msg['10100'])){_P.frameonly=true;}");
                tbMenuItemNode.SetValue("CONFIRM", "FALSE");
            }
            if (bImportExcel) {
                XMLNode tbMenuItemNode = new XMLNode();
                tbMenusNode.AddNode(tbMenuItemNode);
                tbMenuItemNode.setNodeName("SRFEXMENUITEMEX");
                tbMenuItemNode.SetValue("CAPTION", this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_MenuItemCaption((String)"GRIDVIEW", (String)"EXPORTIMPTEMPLATE"), SRFDALocalizationHelper.GetRes_MenuItemCaption((String)"*", (String)"EXPORTIMPTEMPLATE"), "\u4e0b\u8f7d\u5bfc\u5165\u6570\u636e\u6a21\u677f"));
                tbMenuItemNode.SetValue("HANDLER", "SA.SRFDA.Ctrl.Toolbar.GridCustomCall2Handler");
                tbMenuItemNode.SetValue("CALLID", "SRFDAEXPORTIMPTEMPLATE");
                tbMenuItemNode.SetValue("CALLNAME", "\u4e0b\u8f7d\u5bfc\u5165\u6570\u636e\u6a21\u677f");
                tbMenuItemNode.SetValue("CONFIRM", "FALSE");
                tbMenuItemNode = new XMLNode();
                tbMenusNode.AddNode(tbMenuItemNode);
                tbMenuItemNode.setNodeName("SRFEXMENUITEMEX");
                tbMenuItemNode.SetValue("CAPTION", this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_MenuItemCaption((String)"GRIDVIEW", (String)"IMPORTEXCEL"), SRFDALocalizationHelper.GetRes_MenuItemCaption((String)"*", (String)"IMPORTEXCEL"), "\u5bfc\u5165\u5916\u90e8\u6570\u636e\u6587\u4ef6"));
                tbMenuItemNode.SetValue("HANDLER", "SA.SRFDA.Ctrl.Toolbar.ImportExcelHandler");
            }
            if ((group4Writer = this.FindDEBHGroupToolbarItemWriter("4")) != null) {
                TBItemConfig tbItemConfig = new TBItemConfig();
                tbItemConfig.setSeperator("FIRST");
                group4Writer.Export(rootNode, tbMenusNode, tbItemConfig, null, (IToolbarItemWriterContext)tbWriterContext, true);
            }
            if (tbMenusNode.getChildNodes() == null || tbMenusNode.getChildNodes().size() == 0) {
                tbItemsNode.RemoveNode(tbItemNode);
            } else {
                DAConfigHelper.AddToolbarSeperator(tbItemsNode);
            }
        }
        this.OnAppendGridViewToolbar(4, rootNode, tbItemsNode, iDEHelper, page, dataGrid, bPickupMode, bMini, bEnableRowEdit, bInfoMode, bEmbedMode, buttonStateMap);
        if (bSearchBar && StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
            tbItemNode = new XMLNode();
            tbItemNode.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
            tbItemNode.setID(TAG_TBB_FILTER);
            tbItemsNode.AddNode(tbItemNode);
            tbItemNode.SetValue("ICONCSSCLASS", "sx-tb-filter");
            if (!bMini) {
                tbItemNode.SetValue(ToolbarButtonConfig.TAG_TEXT, this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"GRIDVIEW", (String)"FILTER"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"FILTER"), "\u8fc7\u6ee4"));
            }
            tbItemNode.SetValue("TIPS", this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"GRIDVIEW", (String)"FILTER"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"FILTER"), "\u8fdb\u4e00\u6b65\u641c\u7d22\u6570\u636e"));
            tbItemNode.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.SPShowHideHandler"));
            DAConfigHelper.AddToolbarSeperator(tbItemsNode);
        }
        if (bHelpAction) {
            tbItemNode = new XMLNode();
            tbItemNode.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
            tbItemsNode.AddNode(tbItemNode);
            if (StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
                tbItemNode.SetValue("ICONCSSCLASS", "sx-tb-help");
            }
            if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) == 0) {
                tbItemNode.SetValue("IMAGE", "../sasrfex/images/default/icon_help16.png");
            }
            if (!bMini) {
                tbItemNode.SetValue(ToolbarButtonConfig.TAG_TEXT, this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"GRIDVIEW", (String)"HELP"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"HELP"), "\u5e2e\u52a9"));
            }
            tbItemNode.SetValue("TIPS", this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"GRIDVIEW", (String)"HELP"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"HELP"), "\u5e2e\u52a9"));
            tbItemNode.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.HelpHandler"));
            tbItemNode.SetValue("PAGETYPE", "GRIDVIEW");
        }
        this.OnAppendGridViewToolbar(5, rootNode, tbItemsNode, iDEHelper, page, dataGrid, bPickupMode, bMini, bEnableRowEdit, bInfoMode, bEmbedMode, buttonStateMap);
        DAConfigHelper.EraseToolbarUnnecessarySeperator(rootNode);
        if (!DAConfigHelper.ExportConfigFile((XMLNode)rootNode, (String)strTBFilePath)) {
            return "";
        }
        return strToolbarConfigId;
    }

    protected void RebuildGridViewNewAction(XMLNode tbItemsNode, XMLNode tbItemNode, IDEHelper iDEHelper) {
        if (iDEHelper.GetCreateWizards() != null && iDEHelper.GetDefaultCreateWizard() != null) {
            DEWizard createWizard = iDEHelper.GetDefaultCreateWizard();
            tbItemNode.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.GridWizardHandler"));
            tbItemNode.SetValue("UP_DEWIZARDID", createWizard.getDEWIZARDID());
            if (createWizard.getWZHEIGHT() > 0) {
                tbItemNode.SetValue("UP_HEIGHT", StringHelper.Format((String)"%1$s", (Object)createWizard.getWZHEIGHT()));
            }
            if (createWizard.getWZWIDTH() > 0) {
                tbItemNode.SetValue("UP_WIDTH", StringHelper.Format((String)"%1$s", (Object)createWizard.getWZWIDTH()));
            }
            tbItemNode.SetValue("UP_SHOWDATA", createWizard.getSHOWDATAAFTERWZ() ? "TRUE" : "FALSE");
        }
        if (iDEHelper.GetCreateWizards() != null) {
            Vector<DEWizard> list = new Vector<DEWizard>();
            for (DEWizard deWizard : iDEHelper.GetCreateWizards()) {
                if (deWizard.getCREATEDEFAULT()) continue;
                list.add(deWizard);
            }
            if (list.size() > 0) {
                XMLNode tbItemNode2 = new XMLNode();
                tbItemNode2.setNodeName(ToolbarSplitButtonConfig.TAG_TOOLBARSPLITBUTTON);
                tbItemNode2.SetValue("TIPS", this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"GRIDVIEW", (String)"MORENEW"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"MORENEW"), "\u66f4\u591a\u65b0\u5efa"));
                tbItemsNode.AddNode(tbItemNode2);
                XMLNode tbMenusNode = new XMLNode();
                tbMenusNode.setNodeName("SRFEXMAINMENUEX");
                tbItemNode2.AddNode(tbMenusNode);
                tbItemNode2.SetValue("RESOURCEID", tbItemNode.GetExtValue("RESOURCEID", ""));
                for (DEWizard createWizard : list) {
                    XMLNode tbMenuItemNode = new XMLNode();
                    tbMenusNode.AddNode(tbMenuItemNode);
                    tbMenuItemNode.setNodeName("SRFEXMENUITEMEX");
                    tbMenuItemNode.SetValue("CAPTION", createWizard.getDEWIZARDNAME());
                    tbMenuItemNode.SetValue("HANDLER", "SA.SRFDA.Ctrl.Toolbar.GridWizardHandler");
                    tbMenuItemNode.SetValue("UP_DEWIZARDID", createWizard.getDEWIZARDID());
                    if (createWizard.getWZHEIGHT() > 0) {
                        tbMenuItemNode.SetValue("UP_HEIGHT", StringHelper.Format((String)"%1$s", (Object)createWizard.getWZHEIGHT()));
                    }
                    if (createWizard.getWZWIDTH() > 0) {
                        tbMenuItemNode.SetValue("UP_WIDTH", StringHelper.Format((String)"%1$s", (Object)createWizard.getWZWIDTH()));
                    }
                    tbMenuItemNode.SetValue("UP_SHOWDATA", createWizard.getSHOWDATAAFTERWZ() ? "TRUE" : "FALSE");
                    tbMenuItemNode.SetValue("RESOURCEID", tbItemNode.GetExtValue("RESOURCEID", ""));
                }
            }
        }
    }

    protected void RebuildEditViewNewAction(XMLNode tbItemsNode, XMLNode tbItemNode, IDEHelper iDEHelper) {
        if (iDEHelper.GetCreateWizards() != null && iDEHelper.GetDefaultCreateWizard() != null) {
            DEWizard createWizard = iDEHelper.GetDefaultCreateWizard();
            tbItemNode.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.FormWizardHandler"));
            tbItemNode.SetValue("UP_DEWIZARDID", createWizard.getDEWIZARDID());
            if (createWizard.getWZHEIGHT() > 0) {
                tbItemNode.SetValue("UP_HEIGHT", StringHelper.Format((String)"%1$s", (Object)createWizard.getWZHEIGHT()));
            }
            if (createWizard.getWZWIDTH() > 0) {
                tbItemNode.SetValue("UP_WIDTH", StringHelper.Format((String)"%1$s", (Object)createWizard.getWZWIDTH()));
            }
            tbItemNode.SetValue("UP_SHOWDATA", createWizard.getSHOWDATAAFTERWZ() ? "TRUE" : "FALSE");
        }
        if (iDEHelper.GetCreateWizards() != null) {
            Vector<DEWizard> list = new Vector<DEWizard>();
            for (DEWizard deWizard : iDEHelper.GetCreateWizards()) {
                if (deWizard.getCREATEDEFAULT()) continue;
                list.add(deWizard);
            }
            if (list.size() > 0) {
                XMLNode tbItemNode2 = new XMLNode();
                tbItemNode2.setNodeName(ToolbarSplitButtonConfig.TAG_TOOLBARSPLITBUTTON);
                tbItemNode2.SetValue("TIPS", this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"EDITVIEW", (String)"MORENEW"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"MORENEW"), "\u66f4\u591a\u65b0\u5efa"));
                tbItemsNode.AddNode(tbItemNode2);
                XMLNode tbMenusNode = new XMLNode();
                tbMenusNode.setNodeName("SRFEXMAINMENUEX");
                tbItemNode2.AddNode(tbMenusNode);
                tbItemNode2.SetValue("RESOURCEID", tbItemNode.GetExtValue("RESOURCEID", ""));
                for (DEWizard createWizard : list) {
                    XMLNode tbMenuItemNode = new XMLNode();
                    tbMenusNode.AddNode(tbMenuItemNode);
                    tbMenuItemNode.setNodeName("SRFEXMENUITEMEX");
                    tbMenuItemNode.SetValue("CAPTION", createWizard.getDEWIZARDNAME());
                    tbMenuItemNode.SetValue("HANDLER", "SA.SRFDA.Ctrl.Toolbar.FormWizardHandler");
                    tbMenuItemNode.SetValue("UP_DEWIZARDID", createWizard.getDEWIZARDID());
                    if (createWizard.getWZHEIGHT() > 0) {
                        tbMenuItemNode.SetValue("UP_HEIGHT", StringHelper.Format((String)"%1$s", (Object)createWizard.getWZHEIGHT()));
                    }
                    if (createWizard.getWZWIDTH() > 0) {
                        tbMenuItemNode.SetValue("UP_WIDTH", StringHelper.Format((String)"%1$s", (Object)createWizard.getWZWIDTH()));
                    }
                    tbMenuItemNode.SetValue("UP_SHOWDATA", createWizard.getSHOWDATAAFTERWZ() ? "TRUE" : "FALSE");
                    tbMenuItemNode.SetValue("RESOURCEID", tbItemNode.GetExtValue("RESOURCEID", ""));
                }
            }
        }
    }

    private static void OptimizeDPConfig(XMLNode xmlNode) {
        ArrayList xmlNodes;
        String strNodeName = xmlNode.getNodeName();
        if (StringHelper.Compare((String)strNodeName, (String)"SRFEXDPPAGEGROUP", (boolean)true) == 0) {
            xmlNode.RemoveExtValue("CAPLANRESID");
            xmlNode.RemoveExtValue("LOGICXML");
        }
        if (StringHelper.Compare((String)strNodeName, (String)"SRFEXDPGROUP", (boolean)true) == 0) {
            if (xmlNode.GetExtValue("COLSPAN", 1) == 1) {
                xmlNode.RemoveExtValue("COLSPAN");
            }
            xmlNode.RemoveExtValue("CAPLANRESID");
            xmlNode.RemoveExtValue("LOGICXML");
        }
        if (StringHelper.Compare((String)strNodeName, (String)"SRFEXDPFORMITEM", (boolean)true) == 0) {
            if (xmlNode.GetExtValue("COLSPAN", 1) == 1) {
                xmlNode.RemoveExtValue("COLSPAN");
            }
            xmlNode.RemoveExtValue("DEFNAME");
            xmlNode.RemoveExtValue("DEFIELD");
            xmlNode.RemoveExtValue("DEFLOGICNAME");
            xmlNode.RemoveExtValue("DEFID");
            xmlNode.RemoveExtValue("FIEXTPARAMS");
            xmlNode.RemoveExtValue("FI_DV");
            xmlNode.RemoveExtValue("ALLOWEMPTYCOND2");
            xmlNode.RemoveExtValue("CAPLANRESID");
            xmlNode.RemoveExtValue("LOGICXML");
            if (!xmlNode.GetExtValue("CAPTIONONTOP", false)) {
                xmlNode.RemoveExtValue("CAPTIONONTOP");
            }
            if (xmlNode.GetExtValue("SHOWCAPTION", true)) {
                xmlNode.RemoveExtValue("SHOWCAPTION");
            }
            if (xmlNode.GetExtValue("ALLOWEMPTY", true)) {
                xmlNode.RemoveExtValue("ALLOWEMPTY");
            }
            Vector<String> removeList = new Vector<String>();
            Hashtable extAttrs = xmlNode.getExtAttrs();
            if (extAttrs != null) {
                Enumeration en = extAttrs.keys();
                while (en.hasMoreElements()) {
                    String strKey = (String)en.nextElement();
                    if ((strKey = strKey.toUpperCase()).indexOf("FI_") != 0) continue;
                    removeList.add(strKey);
                }
            }
            for (String strKey : removeList) {
                xmlNode.RemoveExtValue(strKey);
            }
        }
        if (StringHelper.Compare((String)strNodeName, (String)"SRFEXFORMITEM", (boolean)true) == 0) {
            String strItemFormat;
            String strDataType;
            if (xmlNode.GetExtValue("ALLOWEMPTY", true)) {
                xmlNode.RemoveExtValue("ALLOWEMPTY");
            }
            if (StringHelper.Compare((String)(strDataType = xmlNode.GetExtValue("DATATYPE", "VARCHAR")), (String)"VARCHAR", (boolean)true) == 0) {
                xmlNode.RemoveExtValue("DATATYPE");
            }
            if (StringHelper.Compare((String)(strItemFormat = xmlNode.GetExtValue("ITEMFORMAT", "%1$s")), (String)"%1$s", (boolean)true) == 0) {
                xmlNode.RemoveExtValue("ITEMFORMAT");
            }
        }
        if (StringHelper.Compare((String)strNodeName, (String)"SRFEXDPDATAGRIDITEM", (boolean)true) == 0) {
            xmlNode.RemoveExtValue("URLPARAMS");
            xmlNode.RemoveExtValue("TBABILITY");
            xmlNode.RemoveExtValue("DER1NID");
            xmlNode.RemoveExtValue("DGID");
            xmlNode.RemoveExtValue("PAGEID");
            xmlNode.RemoveExtValue("PAGENAME");
            xmlNode.RemoveExtValue("RELATEDFIELDS");
            xmlNode.RemoveExtValue("SAVEBEFOREMAJOR");
            xmlNode.RemoveExtValue("TEMPDATA");
            xmlNode.RemoveExtValue("SAVEMAJORTIP");
            xmlNode.RemoveExtValue("RELATEDFORMSTATE");
            xmlNode.RemoveExtValue("APPENDCTXPARAMS");
            xmlNode.RemoveExtValue("HEIGHT");
        }
        if (StringHelper.Compare((String)strNodeName, (String)"SRFEXDPRAWITEM", (boolean)true) == 0) {
            xmlNode.RemoveExtValue("SLCONTENT");
            xmlNode.RemoveExtValue("LANGUAGERESID");
            xmlNode.RemoveExtValue("LANGUAGERESNAME");
            xmlNode.RemoveExtValue("SLLANGUAGERESID");
            xmlNode.RemoveExtValue("SLLANGUAGERESNAME");
        }
        if ((xmlNodes = xmlNode.getChildNodes()) == null) {
            return;
        }
        int i = 0;
        while (i < xmlNodes.size()) {
            DAConfigHelper.OptimizeDPConfig((XMLNode)xmlNodes.get(i));
            ++i;
        }
    }

    public String GetSPExId(IDEHelper iDEHelper, SearchForm searchForm) {
        return this.GetSPExConfigId(iDEHelper, searchForm);
    }

    public String GetSPExConfigId(IDEHelper iDEHelper, SearchForm searchForm) {
        String strSPConfigId = StringHelper.Format((String)"DE%1$s.SPEX_%2$s_%3$s_%4$s", (Object)iDEHelper.getId(), (Object)iDEHelper.getVersion(), (Object)searchForm.getSEARCHFORMID(), (Object)searchForm.getSFVERSION());
        if (!StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
            strSPConfigId = String.valueOf(strSPConfigId) + StringHelper.Format((String)"_PM_%1$s", (Object)this.strPageModel);
        }
        if (!StringHelper.IsNullOrEmpty((String)this.strLanguage)) {
            strSPConfigId = String.valueOf(strSPConfigId) + "_" + this.strLanguage;
        }
        strSPConfigId = strSPConfigId.toUpperCase();
        String strDGFilePath = ConfigPathHelper.GetRuntimeSPConfigPath((String)this.globalHelperEx.GetAppRootPath(), (String)strSPConfigId);
        File file = new File(strDGFilePath);
        if (file.exists()) {
            return strSPConfigId;
        }
        if (StringHelper.Compare((String)iDEHelper.getId(), (String)searchForm.getDEID(), (boolean)true) != 0) {
            iDEHelper = this.getDAGlobalHelper().getDAModelStorage().FindDEHelper(searchForm.getDEID());
        }
        String strFormModelXML = searchForm.getSFMODEL();
        XMLNode rootNode = null;
        if (StringHelper.IsNullOrEmpty((String)strFormModelXML)) {
            log.error((Object)StringHelper.Format((String)"\u8868\u5355\u6a21\u578b\u65e0\u6548"));
            return "";
        }
        rootNode = XMLNode.LoadFromXML((String)strFormModelXML);
        if ((rootNode = this.GetSPExConfig(iDEHelper, rootNode)) == null) {
            return "";
        }
        XMLNode dpNode = rootNode.GetChildNodeByNodeName("SRFEXDP");
        if (!StringHelper.IsNullOrEmpty((String)searchForm.getFORMPLUGIN())) {
            dpNode.SetValue("DPPLUGIN", searchForm.getFORMPLUGIN());
        }
        if (!StringHelper.IsNullOrEmpty((String)searchForm.getFORMSCRIPT())) {
            dpNode.SetValue("SCRIPT", searchForm.getFORMSCRIPT());
        }
        if (!StringHelper.IsNullOrEmpty((String)searchForm.getFIVCSCRIPT())) {
            dpNode.SetValue("FIVCSCRIPT", searchForm.getFIVCSCRIPT());
        }
        if (!StringHelper.IsNullOrEmpty((String)searchForm.getFORMSCRIPTEX())) {
            dpNode.SetValue("FORMSCRIPTEX", searchForm.getFORMSCRIPTEX());
        }
        if (!StringHelper.IsNullOrEmpty((String)searchForm.getFORMSCRIPTEX2())) {
            dpNode.SetValue("FORMSCRIPTEX2", searchForm.getFORMSCRIPTEX2());
        }
        if (!DAConfigHelper.ExportConfigFile((XMLNode)rootNode, (String)strDGFilePath)) {
            return "";
        }
        return strSPConfigId;
    }

    public String GetRIASPExConfigPath(IDEHelper iDEHelper, SearchForm searchForm) {
        String strSPConfigId = StringHelper.Format((String)"DE%1$s.SPEX_RIA_%2$s_%3$s_%4$s", (Object)iDEHelper.getId(), (Object)iDEHelper.getVersion(), (Object)searchForm.getSEARCHFORMID(), (Object)searchForm.getSFVERSION());
        strSPConfigId = strSPConfigId.toUpperCase();
        String strDGFilePath = ConfigPathHelper.GetRuntimeSPConfigPath((String)this.globalHelperEx.GetAppRootPath(), (String)strSPConfigId);
        File file = new File(strDGFilePath);
        if (file.exists()) {
            return strDGFilePath;
        }
        String strFormModelXML = searchForm.getSFMODEL();
        XMLNode rootNode = null;
        if (StringHelper.IsNullOrEmpty((String)strFormModelXML)) {
            log.error((Object)StringHelper.Format((String)"\u8868\u5355\u6a21\u578b\u65e0\u6548"));
            return "";
        }
        rootNode = XMLNode.LoadFromXML((String)strFormModelXML);
        if ((rootNode = this.GetSPExConfig(iDEHelper, rootNode)) == null) {
            return "";
        }
        if (!DAConfigHelper.ExportConfigFile((XMLNode)rootNode, (String)strDGFilePath)) {
            return "";
        }
        return strDGFilePath;
    }

    public SPExConfig GetSPExConfig(IDEHelper iDEHelper, String strSearchFormModelXML) {
        XMLNode rootNode = XMLNode.LoadFromXML((String)strSearchFormModelXML);
        if ((rootNode = this.GetSPExConfig(iDEHelper, rootNode)) == null) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            SimpleXMLWriter writer = new SimpleXMLWriter(sb);
            writer.WriteRaw("<?xml version=\"1.0\" encoding=\"utf-8\" ?>\r\n");
            rootNode.Save(writer);
            InputSource is = new InputSource(new StringReader(sb.toString()));
            DOMParser parser = new DOMParser();
            parser.parse(is);
            Document doc = parser.getDocument();
            SPExConfig spConfig = new SPExConfig();
            spConfig.LoadConfig((Node)doc.getDocumentElement());
            return spConfig;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u5bfc\u5165\u914d\u7f6e\u6587\u4ef6\u5931\u8d25\uff0c\u539f\u56e0\uff1a%1$s", (Object)ex.getMessage()));
            return null;
        }
    }

    protected XMLNode GetSPExConfig(IDEHelper iDEHelper, XMLNode rootNode) {
        if (rootNode == null) {
            log.error((Object)StringHelper.Format((String)"\u8f7d\u5165\u8868\u5355\u6a21\u578b\u5931\u8d25"));
            return null;
        }
        CallResult callResult = new CallResult();
        IDEDataCtrl formPartDataCtrl = this.globalHelperEx.getDAModelStorage().FindDEDataCtrl("DE0083", "SYSTEM", null);
        if (formPartDataCtrl == null) {
            log.warn((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0083"));
            return null;
        }
        IDEDataCtrl rawFIStyleDataCtrl = null;
        TreeMap<String, RawFIStyle> rawFIStyleMap = new TreeMap<String, RawFIStyle>();
        if (this.globalHelperEx.getDAModelVersion() >= 10120900 && (rawFIStyleDataCtrl = this.globalHelperEx.getDAModelStorage().FindDEDataCtrl("DE0069", "SYSTEM", null)) == null) {
            log.warn((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0069"));
        }
        ArrayList rawItemNodes = new ArrayList();
        rootNode.GetAllNodeByNodeName("SRFEXDPRAWITEM", rawItemNodes);
        for (XMLNode rawItemNode : rawItemNodes) {
            boolean bDPModel = rawItemNode.GetExtValue("DPMODEL", false);
            boolean bDPModelFill = rawItemNode.GetExtValue("DPMODELFILL", false);
            if (!bDPModel || !bDPModelFill) continue;
            String strXML = "";
            String strFormPartId = rawItemNode.GetExtValue("FORMPARTID", "");
            if (!StringHelper.IsNullOrEmpty((String)strFormPartId)) {
                FormPart formPart = new FormPart();
                formPart.setFORMPARTID(strFormPartId);
                callResult = formPartDataCtrl.Get((BaseDataEntity)formPart);
                if (callResult.IsError()) {
                    log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u9884\u5b9a\u4e49\u8868\u5355\u90e8\u4ef6[%1$s]\u5931\u8d25\uff0c%2$s", (Object)strFormPartId, (Object)callResult.getErrorInfo()));
                    continue;
                }
                strXML = formPart.getFORMPARTMODEL();
            } else {
                strXML = rawItemNode.GetExtValue("CONTENT", "");
            }
            if (StringHelper.IsNullOrEmpty((String)strXML)) {
                log.error((Object)StringHelper.Format((String)"\u81ea\u5b9a\u4e49\u8868\u5355\u9879\u6307\u5b9a\u76f4\u63a5\u8868\u5355\u903b\u8f91\uff0c\u4f46\u6ca1\u6709\u5b9a\u4e49\u903b\u8f91\u5185\u5bb9\u3002"));
                continue;
            }
            strXML = "<?xml version=\"1.0\" encoding=\"utf-8\" ?>" + strXML;
            rawItemNode.Reset();
            XMLConfig.LoadFromXML((String)strXML, (XMLConfig)rawItemNode);
        }
        rawItemNodes.clear();
        ArrayList tabPageNodes = new ArrayList();
        rootNode.GetAllNodeByNodeName("SRFEXDPPAGEGROUP", tabPageNodes);
        for (XMLNode tabPageNode : tabPageNodes) {
            String strCapLanResId = tabPageNode.GetExtValue("CAPLANRESID", "");
            if (StringHelper.IsNullOrEmpty((String)strCapLanResId)) continue;
            String strCaption = tabPageNode.GetExtValue("CAPTION", "");
            strCaption = this.GetLocalization(iDEHelper, strCapLanResId, strCaption);
            tabPageNode.SetExtValue("CAPTION", strCaption);
        }
        ArrayList groupNodes = new ArrayList();
        rootNode.GetAllNodeByNodeName("SRFEXDPGROUP", groupNodes);
        for (XMLNode groupNode : groupNodes) {
            String strCapLanResId = groupNode.GetExtValue("CAPLANRESID", "");
            if (StringHelper.IsNullOrEmpty((String)strCapLanResId)) continue;
            String strCaption = groupNode.GetExtValue("CAPTION", "");
            strCaption = this.GetLocalization(iDEHelper, strCapLanResId, strCaption);
            groupNode.SetExtValue("CAPTION", strCaption);
        }
        ArrayList dpGroupNodes = new ArrayList();
        rootNode.GetAllNodeByNodeName("SRFEXDPGROUP", dpGroupNodes);
        rootNode.GetAllNodeByNodeName("SRFEXDPPAGEGROUP", dpGroupNodes);
        for (XMLNode dpGroupNode : dpGroupNodes) {
            String strCode;
            String strDPGroupLogic = dpGroupNode.GetExtValue("LOGICXML", "");
            if (StringHelper.IsNullOrEmpty((String)strDPGroupLogic)) continue;
            FormItemLogicConfig formItemLogicConfig = new FormItemLogicConfig();
            XMLConfig.LoadFromXML((String)strDPGroupLogic, (XMLConfig)formItemLogicConfig);
            DefaultFormItemLogicHelper defaultFormItemLogicHelper = new DefaultFormItemLogicHelper(this.globalHelperEx, iDEHelper);
            FormItemRuleConfig formItemRuleConfig = formItemLogicConfig.FindFormItemRuleConfig("CONTROLENABLE");
            if (formItemRuleConfig == null || !StringHelper.IsNullOrEmpty((String)(strCode = dpGroupNode.GetExtValue("ENABLECOND", ""))) || !(callResult = defaultFormItemLogicHelper.GetEnableCode(formItemRuleConfig)).IsOk() || StringHelper.IsNullOrEmpty((String)(strCode = (String)callResult.getUserObject()))) continue;
            dpGroupNode.SetValue("ENABLECOND", strCode);
        }
        ArrayList dpDataGridNodes = new ArrayList();
        rootNode.GetAllNodeByNodeName("SRFEXDPDATAGRIDITEM", dpDataGridNodes);
        if (dpDataGridNodes.size() > 0) {
            for (XMLNode dpDataGridNode : dpDataGridNodes) {
                String strDERId = dpDataGridNode.GetExtValue("DER1NID", "");
                String strDGId = dpDataGridNode.GetExtValue("DGID", "");
                String strURLParams = dpDataGridNode.GetExtValue("URLPARAMS", "");
                String strRelatedFields = dpDataGridNode.GetExtValue("RELATEDFIELDS", "");
                String strPageId = dpDataGridNode.GetExtValue("PAGEID", "");
                String strSaveBeforeMajor = dpDataGridNode.GetExtValue("SAVEBEFOREMAJOR", "");
                String strTempData = dpDataGridNode.GetExtValue("TEMPDATA", "");
                String strSaveMajorTip = dpDataGridNode.GetExtValue("SAVEMAJORTIP", "");
                String strRelatedFormState = dpDataGridNode.GetExtValue("RELATEDFORMSTATE", "");
                String strIgnoreParams = dpDataGridNode.GetExtValue("APPENDCTXPARAMS", "");
                if (StringHelper.IsNullOrEmpty((String)strDERId)) {
                    log.error((Object)StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u5185\u5d4c\u8868\u683cDER1N\u5173\u7cfb\u7f16\u53f7"));
                    return null;
                }
                TreeMap<String, String> urlParams = new TreeMap<String, String>();
                urlParams.put("SRFGRIDVIEW", strDGId);
                urlParams.put("SRFDERID", strDERId);
                urlParams.put("SRFSUMMARYKEY", iDEHelper.GetKeyDEFHelper().getName().toUpperCase());
                String strGridViewUrl = "";
                if (StringHelper.IsNullOrEmpty((String)strPageId)) {
                    strGridViewUrl = "../srfpage/embedgridview.jsp";
                } else {
                    Page page = this.globalHelperEx.getDAModelStorage().FindPage(strPageId);
                    if (page == null) {
                        log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u9875\u9762\u5bf9\u8c61[%1$s]", (Object)strPageId));
                        return null;
                    }
                    strGridViewUrl = page.GetTotalPagePath();
                }
                strGridViewUrl = URLHelper.AppendURLSeperator((String)strGridViewUrl);
                strGridViewUrl = String.valueOf(strGridViewUrl) + URLHelper.GetQueryString(urlParams);
                if (!StringHelper.IsNullOrEmpty((String)strURLParams)) {
                    strGridViewUrl = URLHelper.AppendURLSeperator((String)strGridViewUrl);
                    strGridViewUrl = String.valueOf(strGridViewUrl) + strURLParams;
                }
                XMLNode dgItem = new XMLNode();
                dgItem.setNodeName("SRFEXDPDATAGRID");
                dgItem.SetValue("URL", strGridViewUrl);
                String strKeys = String.valueOf(iDEHelper.GetKeyDEFHelper().getName()) + ";SRFDATEMPKEYID";
                dgItem.SetValue("RELATEDFIELDS", strRelatedFields);
                dgItem.SetValue("KEYFIELDS", strKeys);
                dgItem.SetValue("HEIGHT", dpDataGridNode.GetExtValue("HEIGHT", "100"));
                if (!StringHelper.IsNullOrEmpty((String)strSaveBeforeMajor)) {
                    dgItem.SetValue("SAVEBEFOREMAJOR", strSaveBeforeMajor);
                }
                if (!StringHelper.IsNullOrEmpty((String)strTempData)) {
                    dgItem.SetValue("TEMPDATA", strTempData);
                }
                if (!StringHelper.IsNullOrEmpty((String)strSaveMajorTip)) {
                    dgItem.SetValue("SAVEMAJORTIP", strSaveMajorTip);
                }
                if (!StringHelper.IsNullOrEmpty((String)strRelatedFormState)) {
                    dgItem.SetValue("RELATEDFORMSTATE", strRelatedFormState);
                }
                dgItem.SetValue("APPENDCTXPARAMS", strIgnoreParams);
                dpDataGridNode.AddNode(dgItem);
            }
        }
        ArrayList formItemNodes = new ArrayList();
        rootNode.GetAllNodeByNodeName("SRFEXDPFORMITEM", formItemNodes);
        TreeMap<String, XMLNode> searchItemNodeMap = new TreeMap<String, XMLNode>();
        for (XMLNode formItemNode : formItemNodes) {
            String strDEField = formItemNode.GetExtValue("DEFIELD", "");
            searchItemNodeMap.put(strDEField.toUpperCase(), formItemNode);
        }
        for (IDEFHelper iDEFHelper : iDEHelper.GetDEFHelpers()) {
            SearchModelConfig searchModelConfig = iDEFHelper.GetSearchModel();
            if (searchModelConfig == null) continue;
            for (SearchItemConfig searchItemConfig : searchModelConfig) {
                if (!iDEFHelper.IsSupportSearchAction(searchItemConfig)) continue;
                String strFormItemId = this.globalHelperEx.getDAFormItemHelper().GetSearchFormItemId(iDEFHelper, searchItemConfig);
                XMLNode formItemNode = (XMLNode)searchItemNodeMap.get(strFormItemId = strFormItemId.toUpperCase());
                if (formItemNode == null) continue;
                formItemNode.SetValue("DEFName", iDEFHelper.getName());
                XMLNode formCtrlNode = this.globalHelperEx.getDAFormItemHelper().GetSearchFormCtrlNode(this.strPageModel, this.strLanguage, iDEHelper, iDEFHelper, searchItemConfig, formItemNode);
                if (formCtrlNode == null) continue;
                String strTag = formCtrlNode.getNodeName();
                if (StringHelper.Compare((String)strTag, (String)"SRFEXHIDDEN", (boolean)true) == 0) {
                    if (formItemNode.getParentNode() == null) continue;
                    formItemNode.getParentNode().RemoveNode(formItemNode);
                    continue;
                }
                formItemNode.AddNode(formCtrlNode);
                searchItemNodeMap.remove(strFormItemId);
            }
        }
        rootNode.GetAllNodeByNodeName("SRFEXDPRAWITEM", rawItemNodes);
        for (XMLNode rawItemNode : rawItemNodes) {
            String strRawFIStyleId;
            String strContent;
            boolean bDPModel = rawItemNode.GetExtValue("DPMODEL", false);
            if (bDPModel) {
                String strXML = "";
                String strCustom = rawItemNode.GetExtValue("CUSTOM", "");
                if (StringHelper.IsNullOrEmpty((String)strCustom)) {
                    String strFormPartId = rawItemNode.GetExtValue("FORMPARTID", "");
                    if (!StringHelper.IsNullOrEmpty((String)strFormPartId)) {
                        FormPart formPart = new FormPart();
                        formPart.setFORMPARTID(strFormPartId);
                        callResult = formPartDataCtrl.Get((BaseDataEntity)formPart);
                        if (callResult.IsError()) {
                            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u9884\u5b9a\u4e49\u8868\u5355\u90e8\u4ef6[%1$s]\u5931\u8d25\uff0c%2$s", (Object)strFormPartId, (Object)callResult.getErrorInfo()));
                            continue;
                        }
                        strXML = formPart.getFORMPARTMODEL();
                    } else {
                        strXML = rawItemNode.GetExtValue("CONTENT", "");
                    }
                    if (StringHelper.IsNullOrEmpty((String)strXML)) {
                        log.error((Object)StringHelper.Format((String)"\u81ea\u5b9a\u4e49\u8868\u5355\u9879\u6307\u5b9a\u76f4\u63a5\u8868\u5355\u903b\u8f91\uff0c\u4f46\u6ca1\u6709\u5b9a\u4e49\u903b\u8f91\u5185\u5bb9\u3002"));
                        continue;
                    }
                    strXML = "<?xml version=\"1.0\" encoding=\"utf-8\" ?>" + strXML;
                    rawItemNode.Reset();
                    XMLConfig.LoadFromXML((String)strXML, (XMLConfig)rawItemNode);
                    continue;
                }
                strXML = rawItemNode.GetExtValue("CONTENT", "");
                Object objDAConfigHelperPlugin = ObjectHelper.Create((String)strCustom);
                if (objDAConfigHelperPlugin == null) {
                    log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u63d2\u4ef6\u5bf9\u8c61[%1$s]", (Object)strCustom));
                    continue;
                }
                if (!(objDAConfigHelperPlugin instanceof IDAConfigHelperPlugin)) {
                    log.error((Object)StringHelper.Format((String)"\u63d2\u4ef6\u5bf9\u8c61[%1$s]\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)strCustom));
                    continue;
                }
                IDAConfigHelperPlugin iDAConfigHelperPlugin = (IDAConfigHelperPlugin)objDAConfigHelperPlugin;
                rawItemNode.Reset();
                iDAConfigHelperPlugin.Process((IDAConfigHelper)this, iDEHelper, null, strXML, rootNode, rawItemNode);
                continue;
            }
            String strLanguageResId = rawItemNode.GetExtValue("LANGUAGERESID", "");
            if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) == 0 || StringHelper.Compare((String)this.strPageModel, (String)"WinRT", (boolean)true) == 0) {
                strContent = rawItemNode.GetExtValue("SLCONTENT", "");
                if (!StringHelper.IsNullOrEmpty((String)strContent)) {
                    rawItemNode.SetValue("CONTENT", strContent);
                    strLanguageResId = "";
                }
                strLanguageResId = rawItemNode.GetExtValue("SLLANGUAGERESID", strLanguageResId);
            }
            if (!StringHelper.IsNullOrEmpty((String)strLanguageResId)) {
                strContent = "";
                strContent = this.GetLocalization(iDEHelper, strLanguageResId, strContent);
                rawItemNode.SetValue("CONTENT", strContent);
            }
            if (this.globalHelperEx.getDAModelVersion() < 10120900 || StringHelper.IsNullOrEmpty((String)(strRawFIStyleId = rawItemNode.GetExtValue("RAWFISTYLEID", "")))) continue;
            RawFIStyle rawFIStyle = (RawFIStyle)rawFIStyleMap.get(strRawFIStyleId);
            if (rawFIStyle == null) {
                rawFIStyle = new RawFIStyle();
                rawFIStyle.setRAWFISTYLEID(strRawFIStyleId);
                callResult = rawFIStyleDataCtrl.Get((BaseDataEntity)rawFIStyle);
                if (callResult.IsError()) {
                    log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u8868\u5355\u9879\u5bb9\u5668\u6837\u5f0f[%1$s]\u5931\u8d25,%2$s", (Object)strRawFIStyleId, (Object)callResult.getErrorInfo()));
                    continue;
                }
                rawFIStyleMap.put(strRawFIStyleId, rawFIStyle);
            }
            rawItemNode.SetValue("BEGINHTML", rawFIStyle.getBEGINTAG());
            rawItemNode.SetValue("ENDHTML", rawFIStyle.getENDTAG());
        }
        for (XMLNode formItemNode : searchItemNodeMap.values()) {
            if (formItemNode.getParentNode() == null) continue;
            formItemNode.getParentNode().RemoveNode(formItemNode);
        }
        DAConfigHelper.OptimizeDPConfig(rootNode);
        XMLNode spNode = new XMLNode();
        spNode.setNodeName("SRFEXSPEX");
        rootNode.setNodeName("SRFEXDP");
        spNode.AddNode(rootNode);
        return spNode;
    }

    public SPExConfig GetDEFGroupSPExConfig(String strDEFGroupId, String strSearchFormModelXML) {
        XMLNode rootNode = XMLNode.LoadFromXML((String)strSearchFormModelXML);
        if ((rootNode = this.GetDEFGroupSPExConfig(strDEFGroupId, rootNode)) == null) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            SimpleXMLWriter writer = new SimpleXMLWriter(sb);
            writer.WriteRaw("<?xml version=\"1.0\" encoding=\"utf-8\" ?>\r\n");
            rootNode.Save(writer);
            InputSource is = new InputSource(new StringReader(sb.toString()));
            DOMParser parser = new DOMParser();
            parser.parse(is);
            Document doc = parser.getDocument();
            SPExConfig spConfig = new SPExConfig();
            spConfig.LoadConfig((Node)doc.getDocumentElement());
            return spConfig;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u5bfc\u5165\u914d\u7f6e\u6587\u4ef6\u5931\u8d25\uff0c\u539f\u56e0\uff1a%1$s", (Object)ex.getMessage()));
            return null;
        }
    }

    protected XMLNode GetDEFGroupSPExConfig(String strDEFGroupId, XMLNode rootNode) {
        if (rootNode == null) {
            log.error((Object)StringHelper.Format((String)"\u8f7d\u5165\u8868\u5355\u6a21\u578b\u5931\u8d25"));
            return null;
        }
        ArrayList formItemNodes = new ArrayList();
        rootNode.GetAllNodeByNodeName("SRFEXDPFORMITEM", formItemNodes);
        TreeMap<String, XMLNode> searchItemNodeMap = new TreeMap<String, XMLNode>();
        for (XMLNode formItemNode : formItemNodes) {
            String strDEField = formItemNode.GetExtValue("DEFIELD", "");
            searchItemNodeMap.put(strDEField.toUpperCase(), formItemNode);
        }
        IDEDataCtrl iDEFGroupDetailDataCtrl = this.globalHelperEx.getDAModelStorage().FindDEDataCtrl("DE0161", "SYSTEM", null);
        if (iDEFGroupDetailDataCtrl == null) {
            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0161"));
            return null;
        }
        BaseDataEntity cond = new BaseDataEntity();
        cond.SetParamValue("DEFGROUPID", (Object)strDEFGroupId);
        Vector defGroupDetailList = new Vector();
        CallResult callResult = iDEFGroupDetailDataCtrl.Select(cond, defGroupDetailList);
        if (callResult.IsError()) {
            String strErrorInfo = StringHelper.Format((String)"\u67e5\u8be2\u5c5e\u6027\u5206\u7ec4[%1$s]\u660e\u7ec6\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strDEFGroupId, (Object)callResult.getErrorInfo());
            log.error((Object)strErrorInfo);
            return null;
        }
        DEFGroupDetail defGroupDetail = new DEFGroupDetail();
        for (BaseDataEntity dataEntity : defGroupDetailList) {
            defGroupDetail.Proxy(dataEntity);
            if (StringHelper.IsNullOrEmpty((String)defGroupDetail.getSEARCHMODEL())) continue;
            SearchModelConfig searchModelConfig = new SearchModelConfig();
            if (!XMLConfig.LoadFromXML((String)defGroupDetail.getSEARCHMODEL(), (XMLConfig)searchModelConfig)) continue;
            IDEHelper iDEHelper = this.globalHelperEx.getDAModelStorage().FindDEHelper(defGroupDetail.getDEID());
            if (iDEHelper == null) {
                log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u64cd\u4f5c\u5bf9\u8c61", (Object)defGroupDetail.getDEID()));
                return null;
            }
            IDEFHelper iDEFHelper = iDEHelper.GetDEFHelper(defGroupDetail.getDEFID());
            if (iDEFHelper == null) {
                log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5c5e\u6027[%1$s]\u8f85\u52a9\u64cd\u4f5c\u5bf9\u8c61", (Object)defGroupDetail.getDEFID()));
                return null;
            }
            for (SearchItemConfig searchItemConfig : searchModelConfig) {
                if (!iDEFHelper.IsSupportSearchAction(searchItemConfig)) continue;
                String strFormItemId = this.globalHelperEx.getDAFormItemHelper().GetSearchFormItemId(iDEFHelper, searchItemConfig);
                strFormItemId = strFormItemId.toUpperCase();
                XMLNode formItemNode = (XMLNode)searchItemNodeMap.get(strFormItemId = strFormItemId.replace("_" + iDEFHelper.getName() + "_", "_" + defGroupDetail.getDEFGROUPDETAILNAME().toUpperCase() + "_"));
                if (formItemNode == null) continue;
                formItemNode.SetValue("DEFName", iDEFHelper.getName());
                XMLNode formCtrlNode = this.globalHelperEx.getDAFormItemHelper().GetSearchFormCtrlNode(this.strPageModel, this.strLanguage, iDEHelper, iDEFHelper, searchItemConfig, formItemNode);
                if (formCtrlNode == null) continue;
                String strTag = formCtrlNode.getNodeName();
                if (StringHelper.Compare((String)strTag, (String)"SRFEXHIDDEN", (boolean)true) == 0) {
                    if (formItemNode.getParentNode() == null) continue;
                    formItemNode.getParentNode().RemoveNode(formItemNode);
                    continue;
                }
                formItemNode.AddNode(formCtrlNode);
                searchItemNodeMap.remove(strFormItemId);
            }
        }
        for (XMLNode formItemNode : searchItemNodeMap.values()) {
            if (formItemNode.getParentNode() == null) continue;
            formItemNode.getParentNode().RemoveNode(formItemNode);
        }
        XMLNode spNode = new XMLNode();
        spNode.setNodeName("SRFEXSPEX");
        rootNode.setNodeName("SRFEXDP");
        spNode.AddNode(rootNode);
        return spNode;
    }

    protected static void AddToolbarSeperator(XMLNode tbItemsNode) {
        XMLNode tbItemNode = new XMLNode();
        tbItemNode.setNodeName(ToolbarSeperatorConfig.TAG_TOOLBARSEPARATOR);
        tbItemsNode.AddNode(tbItemNode);
    }

    protected static XMLNode LoadToolbarConfig(String strToolbarXML, Page page) {
        XMLNode userToolbar = null;
        if (StringHelper.IsNullOrEmpty((String)strToolbarXML)) {
            if (page != null) {
                String strPageToolbar = page.getTOOLBAR();
                String strPTToolbar = page.getPTTOOLBAR();
                if (!StringHelper.IsNullOrEmpty((String)strPTToolbar)) {
                    if (userToolbar == null) {
                        userToolbar = new XMLNode();
                    }
                    XMLNode.LoadFromXML((String)strPTToolbar, (XMLConfig)userToolbar);
                }
                if (!StringHelper.IsNullOrEmpty((String)strPageToolbar)) {
                    if (userToolbar == null) {
                        userToolbar = new XMLNode();
                    }
                    XMLNode.LoadFromXML((String)strPageToolbar, (XMLConfig)userToolbar);
                }
            }
        } else {
            userToolbar = XMLNode.LoadFromXML((String)strToolbarXML);
        }
        return userToolbar;
    }

    protected DefaultToolbarWriterContext CreateTBWriterContext() {
        DefaultToolbarWriterContext tbWriterContext = new DefaultToolbarWriterContext();
        tbWriterContext.setPageModel(this.strPageModel);
        tbWriterContext.setLanguage(this.strLanguage);
        tbWriterContext.setDAGlobalHelper(this.globalHelperEx);
        return tbWriterContext;
    }

    protected CallResult ExportToolbar(XMLNode rootNode, XMLNode tbItemsNode, ToolbarConfig tbConfig, DefaultToolbarWriterContext writerContext) {
        return this.ExportTBItem(rootNode, tbItemsNode, (TBItemConfig)tbConfig, true, writerContext, false);
    }

    protected CallResult ExportTBItem(XMLNode rootNode, XMLNode tbItemsNode, XMLNode xmlNode, boolean bRoot, DefaultToolbarWriterContext writerContext, boolean bMenu) {
        TBItemConfig tbItemConfig = new TBItemConfig();
        Hashtable attrs = xmlNode.getExtAttrs();
        if (attrs != null) {
            Enumeration en = attrs.keys();
            while (en.hasMoreElements()) {
                Object objKey = en.nextElement();
                Object objValue = attrs.get(objKey);
                tbItemConfig.SetProperty(objKey.toString(), objValue.toString());
            }
        }
        return this.ExportTBItem(rootNode, tbItemsNode, tbItemConfig, bRoot, writerContext, bMenu);
    }

    protected CallResult ExportTBItem(XMLNode rootNode, XMLNode tbItemsNode, TBItemConfig tbItemConfig, boolean bRoot, DefaultToolbarWriterContext writerContext, boolean bMenu) {
        CallResult callResult = new CallResult();
        if (!bRoot) {
            DEBehavior deBehavior = null;
            if (!StringHelper.IsNullOrEmpty((String)tbItemConfig.getDEBehaviorId()) && (deBehavior = this.globalHelperEx.getDAModelStorage().FindDEBehavior(tbItemConfig.getDEBehaviorId())) == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u754c\u9762\u884c\u4e3a[%1$s]", (Object)tbItemConfig.getDEBehaviorId()));
                return callResult;
            }
            IToolbarItemWriter toolbarItemWriter = this.FindToolbarItemWriter(tbItemConfig, deBehavior);
            if (toolbarItemWriter == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5de5\u5177\u680f\u9879\u76ee[%1$s][%2$s]\u5bf9\u5e94\u7684\u7ed8\u5236\u5668", (Object)tbItemConfig.getCaption(), (Object)tbItemConfig.getDEBehaviorId()));
                log.error((Object)callResult.getErrorInfo());
                return callResult;
            }
            callResult = toolbarItemWriter.Export(rootNode, tbItemsNode, tbItemConfig, deBehavior, (IToolbarItemWriterContext)writerContext, bMenu);
            if (callResult.IsError()) {
                return callResult;
            }
            if (callResult.getUserObject() != null) {
                tbItemsNode = (XMLNode)callResult.getUserObject();
            }
        }
        if (tbItemConfig.getItems().size() > 0) {
            for (TBItemConfig tbChildItemConfig : tbItemConfig.getItems()) {
                if (!writerContext.TestCondition(tbChildItemConfig.getVisibleCond()) || !(callResult = this.ExportTBItem(rootNode, tbItemsNode, tbChildItemConfig, false, writerContext, !bRoot)).IsError()) continue;
                return callResult;
            }
            if (tbItemsNode.getChildNodes() == null || tbItemsNode.getChildNodes().size() == 0) {
                if (StringHelper.Compare((String)tbItemsNode.getNodeName(), (String)"SRFEXMAINMENUEX", (boolean)true) == 0) {
                    tbItemsNode = tbItemsNode.getParentNode();
                }
                tbItemsNode.getParentNode().RemoveNode(tbItemsNode);
            }
        }
        return callResult;
    }

    protected IToolbarItemWriter FindToolbarItemWriter(TBItemConfig tbItemConfig, DEBehavior deBehavior) {
        if (tbItemConfig.getItems().size() > 0) {
            return this.splitTBItemWriter;
        }
        if (StringHelper.IsNullOrEmpty((String)tbItemConfig.getDEBehaviorId()) && StringHelper.Compare((String)tbItemConfig.getCaption(), (String)"-", (boolean)true) == 0) {
            return this.separatorTBItemWriter;
        }
        IToolbarItemWriter toolbarItemWriter = null;
        if (!StringHelper.IsNullOrEmpty((String)tbItemConfig.getDEBehaviorId())) {
            toolbarItemWriter = this.globalHelperEx.getDAConfigMgr().getToolbarItemWriterMgr().FindToolbarItemWriter(tbItemConfig.getDEBehaviorId());
            if (toolbarItemWriter != null) {
                return toolbarItemWriter;
            }
            return this.deBehaviorTBItemWriter;
        }
        return toolbarItemWriter;
    }

    protected IToolbarItemWriter FindDEBHGroupToolbarItemWriter(String strGroupId) {
        String strTempId = "VIEW_DEBHGROUP";
        if (StringHelper.Length((String)strGroupId) == 1) {
            strTempId = String.valueOf(strTempId) + "00";
            strTempId = String.valueOf(strTempId) + strGroupId;
        } else if (StringHelper.Length((String)strGroupId) == 2) {
            strTempId = String.valueOf(strTempId) + "0";
            strTempId = String.valueOf(strTempId) + strGroupId;
        } else {
            strTempId = String.valueOf(strTempId) + strGroupId;
        }
        return this.globalHelperEx.getDAConfigMgr().getToolbarItemWriterMgr().FindToolbarItemWriter(strTempId);
    }

    public String GetLocalization(IDEHelper iDEHelper, String strResId, String strDefault) {
        if (StringHelper.IsNullOrEmpty((String)strResId)) {
            return strDefault;
        }
        if (iDEHelper == null) {
            return this.globalHelperEx.getLocalizationHelper().GetLocalization(this.getLanguage(), strResId, strDefault);
        }
        return this.globalHelperEx.getLocalizationHelper().GetLocalization(this.getLanguage(), StringHelper.Format((String)"_%1$s_.%2$s", (Object)iDEHelper.getId(), (Object)strResId), strResId, strDefault);
    }

    public String GetLocalization(IDEHelper iDEHelper, String strResId, String strResId2, String strDefault) {
        if (StringHelper.IsNullOrEmpty((String)strResId) && StringHelper.IsNullOrEmpty((String)strResId2)) {
            return strDefault;
        }
        if (iDEHelper == null) {
            return this.globalHelperEx.getLocalizationHelper().GetLocalization(this.getLanguage(), strResId, strResId2, strDefault);
        }
        String strTempValue = this.globalHelperEx.getLocalizationHelper().GetLocalization(this.getLanguage(), StringHelper.Format((String)"_%1$s_.%2$s", (Object)iDEHelper.getId(), (Object)strResId), StringHelper.Format((String)"_%1$s_.%2$s", (Object)iDEHelper.getId(), (Object)strResId2), null);
        if (strTempValue != null) {
            return strTempValue;
        }
        return this.globalHelperEx.getLocalizationHelper().GetLocalization(this.getLanguage(), strResId, strResId2, strDefault);
    }

    public String GetConfigId(String strConfigType, IDAConfigPublishContext iDAConfigPublishContext) throws Exception {
        File file;
        IDAConfigPublisher iDAConfigPublisher = this.GetConfigPublisher(strConfigType, iDAConfigPublishContext);
        String strConfigId = iDAConfigPublisher.GetConfigId(iDAConfigPublishContext);
        String strConfigFilePath = iDAConfigPublisher.GetConfigFilePath(strConfigId);
        if (!iDAConfigPublishContext.isAlwaysPublish() && (file = new File(strConfigFilePath)).exists()) {
            return strConfigId;
        }
        XMLNode rootNode = iDAConfigPublisher.Publish(iDAConfigPublishContext);
        if (!DAConfigHelper.ExportConfigFile((XMLNode)rootNode, (String)strConfigFilePath)) {
            throw new Exception("\u53d1\u5e03\u914d\u7f6e\u6587\u4ef6\u53d1\u751f\u9519\u8bef");
        }
        return strConfigId;
    }

    protected IDAConfigPublisher GetConfigPublisher(String strConfigType, IDAConfigPublishContext iDAConfigPublishContext) throws Exception {
        String strPublisherId;
        IDAConfigPublisher iDAConfigPublisher;
        String strDEId;
        String strPageType = iDAConfigPublishContext.getPage().getPageType();
        String strConfigMode = iDAConfigPublishContext.getConfigMode();
        if (StringHelper.IsNullOrEmpty((String)strConfigMode)) {
            strConfigMode = "*";
        }
        if (StringHelper.IsNullOrEmpty((String)(strDEId = iDAConfigPublishContext.getDEId()))) {
            strDEId = "*";
        }
        if ((iDAConfigPublisher = this.daConfigPublisherMap.get(strPublisherId = StringHelper.Format((String)"%1$s|%2$s|%3$s|%4$s", (Object)strPageType, (Object)strConfigType, (Object)strConfigMode, (Object)strDEId))) != null) {
            return iDAConfigPublisher;
        }
        strPublisherId = StringHelper.Format((String)"%1$s|%2$s|%3$s|%4$s", (Object)strPageType, (Object)strConfigType, (Object)"*", (Object)strDEId);
        iDAConfigPublisher = this.daConfigPublisherMap.get(strPublisherId);
        if (iDAConfigPublisher != null) {
            return iDAConfigPublisher;
        }
        strPublisherId = StringHelper.Format((String)"%1$s|%2$s|%3$s|%4$s", (Object)strPageType, (Object)strConfigType, (Object)strConfigMode, (Object)"*");
        iDAConfigPublisher = this.daConfigPublisherMap.get(strPublisherId);
        if (iDAConfigPublisher != null) {
            return iDAConfigPublisher;
        }
        throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6[%1$s]\u914d\u7f6e\u53d1\u5e03\u5bf9\u8c61", (Object)strPublisherId));
    }

    protected void PrepareDAConfigPublishers() throws Exception {
        Vector configPublishers = new Vector();
        CallResult callResult = this.getGlobalHelper().getDAModelHelper().GetConfigPublishers(configPublishers);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u914d\u7f6e\u53d1\u5e03\u5668\u5bf9\u8c61\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        for (ConfigPublisher configPublisher : configPublishers) {
            String strDEId;
            Object objConfigPublisher = ObjectHelper.Create((String)configPublisher.getPUBLISHEROBJ());
            if (objConfigPublisher == null) {
                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u914d\u7f6e\u53d1\u5e03\u5668\u5bf9\u8c61[%1$s]", (Object)configPublisher.getPUBLISHEROBJ()));
            }
            if (!(objConfigPublisher instanceof IDAConfigPublisher)) {
                throw new Exception(StringHelper.Format((String)"\u914d\u7f6e\u53d1\u5e03\u5668\u5bf9\u8c61[%1$s]\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)configPublisher.getPUBLISHEROBJ()));
            }
            IDAConfigPublisher iDAConfigPublisher = (IDAConfigPublisher)objConfigPublisher;
            iDAConfigPublisher.Init((IDAConfigHelperContext)this, configPublisher);
            String strPageType = configPublisher.getPAGETYPE();
            String strConfigType = configPublisher.getCONFIGTYPE();
            String strConfigMode = configPublisher.getCONFIGMODE();
            if (StringHelper.IsNullOrEmpty((String)strConfigMode)) {
                strConfigMode = "*";
            }
            if (StringHelper.IsNullOrEmpty((String)(strDEId = configPublisher.getDEID()))) {
                strDEId = "*";
            }
            String strPublisherName = StringHelper.Format((String)"%1$s|%2$s|%3$s|%4$s", (Object)strPageType, (Object)strConfigType, (Object)strConfigMode, (Object)strDEId);
            this.daConfigPublisherMap.put(strPublisherName, iDAConfigPublisher);
        }
    }

    public ISRFDAGlobalHelper getDAGlobalHelper() {
        return this.globalHelperEx;
    }

    protected String GetToolbarButtonHandler(IDEHelper iDEHelper, String strDefault) {
        return this.getDAGlobalHelper().getDAModelStorage().GetDETBBHandler(iDEHelper == null ? "*" : iDEHelper.getId(), strDefault);
    }

    protected int OnGetWFStepActorPlacement() {
        String strWFRelatedInfoPresentMode = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFDA.WF", "WFSTEPACTORPLACEMENT", "");
        if (StringHelper.Compare((String)strWFRelatedInfoPresentMode, (String)CONFIGTYPE_TOOLBAR, (boolean)true) == 0) {
            return 1;
        }
        return 0;
    }

    protected int OnGetWFStepDataPlacement() {
        String strWFRelatedInfoPresentMode = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFDA.WF", "WFSTEPDATAPLACEMENT", "");
        if (StringHelper.Compare((String)strWFRelatedInfoPresentMode, (String)CONFIGTYPE_TOOLBAR, (boolean)true) == 0) {
            return 1;
        }
        return 0;
    }

    protected int getWFStepActorPlacement() {
        return this.nWFStepActorPlacement;
    }

    protected int getWFStepDataPlacement() {
        return this.nWFStepDataPlacement;
    }

    protected boolean OnGetDPCheckDataUpdateDate(Form formView) {
        if (formView != null) {
            if (formView.isSAVECHECKNull()) {
                return true;
            }
            return formView.getSAVECHECK();
        }
        return true;
    }
}

