/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.DEWizard
 *  SA.SRFDA.Ctrl.Data.DataGrid
 *  SA.SRFDA.Ctrl.Data.Page
 *  SA.SRFDA.Ctrl.Data.TBTempl
 *  SA.SRFDA.Ctrl.Data.Toolbar
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Ctrl.IDEMainStateHelper
 *  SA.SRFDA.Ctrl.ToolbarWriter.IToolbarItemWriter
 *  SA.SRFDA.Ctrl.ToolbarWriter.IToolbarItemWriterContext
 *  SA.SRFDA.Ctrl.ToolbarWriter.TBItemConfig
 *  SA.SRFDA.Ctrl.ToolbarWriter.ToolbarConfig
 *  SA.SRFDA.Localization.SRFDALocalizationHelper
 *  SA.SRFDA.Security.UniResHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig
 *  SA.SRFramework.WebEx.ToolBar.UI.ToolbarItemsConfig
 *  SA.SRFramework.WebEx.ToolBar.UI.ToolbarSplitButtonConfig
 *  SA.SRFramework.XML.XMLNode
 */
package SA.SRFDA.Ctrl.Config;

import SA.SRFDA.Ctrl.Config.IGridViewToolbarConfigPublishContext;
import SA.SRFDA.Ctrl.Config.IToolbarConfigPublishContext;
import SA.SRFDA.Ctrl.Config.ToolbarConfigPublisher;
import SA.SRFDA.Ctrl.Data.DEWizard;
import SA.SRFDA.Ctrl.Data.DataGrid;
import SA.SRFDA.Ctrl.Data.Page;
import SA.SRFDA.Ctrl.Data.TBTempl;
import SA.SRFDA.Ctrl.Data.Toolbar;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Ctrl.IDEMainStateHelper;
import SA.SRFDA.Ctrl.ToolbarWriter.DefaultToolbarWriterContext;
import SA.SRFDA.Ctrl.ToolbarWriter.IToolbarItemWriter;
import SA.SRFDA.Ctrl.ToolbarWriter.IToolbarItemWriterContext;
import SA.SRFDA.Ctrl.ToolbarWriter.TBItemConfig;
import SA.SRFDA.Ctrl.ToolbarWriter.ToolbarConfig;
import SA.SRFDA.Localization.SRFDALocalizationHelper;
import SA.SRFDA.Security.UniResHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarItemsConfig;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarSplitButtonConfig;
import SA.SRFramework.XML.XMLNode;
import java.util.Vector;

public class GridViewToolbarConfigPublisher
extends ToolbarConfigPublisher {
    @Override
    protected String OnGetConfigId(IToolbarConfigPublishContext iDAConfigPublishContext) throws Exception {
        IGridViewToolbarConfigPublishContext iGridViewToolbarConfigPublishContext = this.getGridViewToolbarConfigPublishContext(iDAConfigPublishContext);
        String strConfigId = "";
        strConfigId = StringHelper.Format((String)"DE%1$s.TB_%2$s", (Object)iDAConfigPublishContext.getDEHelper().getId(), (Object)iDAConfigPublishContext.getDEHelper().getVersion());
        if (iGridViewToolbarConfigPublishContext.getDEMainState() != null) {
            strConfigId = String.valueOf(strConfigId) + StringHelper.Format((String)"_%1$s", (Object)iGridViewToolbarConfigPublishContext.getDEMainState().getName());
        }
        if (iGridViewToolbarConfigPublishContext.getDataGrid() != null) {
            strConfigId = String.valueOf(strConfigId) + StringHelper.Format((String)"_DG%1$s_%2$s", (Object)iGridViewToolbarConfigPublishContext.getDataGrid().getDATAGRIDID(), (Object)iGridViewToolbarConfigPublishContext.getDataGrid().getDGVERSION());
        }
        strConfigId = GridViewToolbarConfigPublisher.AppendPageId(strConfigId, iDAConfigPublishContext);
        if (iGridViewToolbarConfigPublishContext.getReadOnlyMode()) {
            strConfigId = String.valueOf(strConfigId) + "_I";
        }
        if (iGridViewToolbarConfigPublishContext.getPickupMode()) {
            strConfigId = String.valueOf(strConfigId) + "_P";
        }
        if (iGridViewToolbarConfigPublishContext.getEmbedMode()) {
            strConfigId = String.valueOf(strConfigId) + "_E";
        }
        if (iGridViewToolbarConfigPublishContext.getMiniMode()) {
            strConfigId = String.valueOf(strConfigId) + "_M";
        }
        if (iGridViewToolbarConfigPublishContext.getEnableRowEdit()) {
            strConfigId = String.valueOf(strConfigId) + "_R";
        }
        return strConfigId;
    }

    @Override
    protected XMLNode OnPublish(IToolbarConfigPublishContext iDAConfigPublishContext) throws Exception {
        XMLNode tbItemNode;
        IToolbarItemWriter group2Writer;
        String strRemoveTooltip;
        XMLNode tbItemNode2;
        boolean bExportDEMainStateActions;
        String strViewTipFormat;
        String strViewFormat;
        XMLNode tbItemNode3;
        IGridViewToolbarConfigPublishContext iGridViewToolbarConfigPublishContext = this.getGridViewToolbarConfigPublishContext(iDAConfigPublishContext);
        Page page = null;
        if (iGridViewToolbarConfigPublishContext.getPage() != null && iGridViewToolbarConfigPublishContext.getPage().getPageData() != null) {
            page = iGridViewToolbarConfigPublishContext.getPage().getPageData().getData();
        }
        IDEHelper iDEHelper = iGridViewToolbarConfigPublishContext.getDEHelper();
        IDEMainStateHelper iDEMainStateHelper = iGridViewToolbarConfigPublishContext.getDEMainState();
        boolean bEnableUserCreate = iDEHelper.IsEnableUserCreate();
        boolean bEnableUserUpdate = iDEHelper.IsEnableUserUpdate();
        boolean bEnableUserView = iDEHelper.IsEnableUserView();
        boolean bEnableUserDelete = iDEHelper.IsEnableUserDelete();
        if (iDEMainStateHelper != null) {
            bEnableUserCreate = iDEMainStateHelper.isEnableUserCreate();
            bEnableUserUpdate = iDEMainStateHelper.isEnableUserUpdate();
            bEnableUserView = iDEMainStateHelper.isEnableUserView();
            bEnableUserDelete = iDEMainStateHelper.isEnableUserDelete();
        }
        boolean bEnableRowEdit = iGridViewToolbarConfigPublishContext.getEnableRowEdit();
        boolean bInfoMode = iGridViewToolbarConfigPublishContext.getReadOnlyMode();
        DataGrid dataGrid = iGridViewToolbarConfigPublishContext.getDataGrid();
        boolean bPickupMode = iGridViewToolbarConfigPublishContext.getPickupMode();
        boolean bEmbedMode = iGridViewToolbarConfigPublishContext.getEmbedMode();
        boolean bMini = iGridViewToolbarConfigPublishContext.getMiniMode();
        if (StringHelper.Compare((String)this.getPageModel(), (String)"SL", (boolean)true) == 0) {
            bMini = true;
        }
        DefaultToolbarWriterContext tbWriterContext = this.CreateTBWriterContext();
        tbWriterContext.setPage(page);
        tbWriterContext.setDEHelper(iDEHelper);
        tbWriterContext.setViewStyle(iDAConfigPublishContext.getPage().getPageType());
        tbWriterContext.setLanguage(this.getLanguage());
        tbWriterContext.setPageModel(this.getPageModel());
        tbWriterContext.RegisterGlobal("ROWACTIONBAR", bEnableRowEdit);
        tbWriterContext.setAttribute("INFOMODE", bInfoMode);
        XMLNode rootNode = new XMLNode();
        rootNode.setNodeName("SRFEXTOOLBAR");
        XMLNode tbItemsNode = new XMLNode();
        tbItemsNode.setNodeName(ToolbarItemsConfig.TAG_TOOLBARITEMS);
        rootNode.AddNode(tbItemsNode);
        Toolbar toolbar = null;
        if (page != null) {
            String strToolbarId = page.getTOOLBARID();
            if (!StringHelper.IsNullOrEmpty((String)strToolbarId) && (toolbar = this.getDAModelStorage().FindToolbar(strToolbarId)) == null) {
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
                TBTempl tbTempl = this.getDAModelStorage().FindTBTempl(strTBTEMPLID);
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
        String strToolbarXML = dataGrid.getDGTOOLBAR();
        userToolbar = GridViewToolbarConfigPublisher.LoadToolbarConfig(strToolbarXML, page);
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
        boolean bHelpAction = this.getEnableHelp(iDEHelper);
        boolean bImportExcel = bEnableUserCreate;
        if (!bEnableUserUpdate) {
            bEnableRowEdit = false;
        }
        String strObjectName = iDEHelper.getLogicName(this.getLanguage());
        bMultiPrint = this.getEnableMultiPrint(iDEHelper);
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
        if (bExportXMLButton) {
            bExportXMLButton = this.getEnableExportXML(iDEHelper);
        }
        if (bImportExcel) {
            bImportExcel = this.getEnableImportExcel(iDEHelper);
        }
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
            if (bReplaceDefault = userToolbar.GetExtValue("SRFREPLACEDEFAULT", bReplaceDefault)) {
                userToolbar.setNodeName("SRFEXTOOLBAR");
                return userToolbar;
            }
            if (bInfoMode = userToolbar.GetExtValue("INFOMODE", bInfoMode)) {
                bRemoveButton = false;
            }
            bNewButton = userToolbar.GetExtValue("NEWACTION", bNewButton);
            bEditButton = userToolbar.GetExtValue("EDITACTION", bEditButton);
            bViewButton = userToolbar.GetExtValue("VIEWACTION", bViewButton);
            bRemoveButton = userToolbar.GetExtValue("REMOVEACTION", bRemoveButton);
            bCopyButton = userToolbar.GetExtValue("COPYACTION", bCopyButton);
            bExportButton = userToolbar.GetExtValue("EXPORTACTION", bExportButton);
            bOtherAction = userToolbar.GetExtValue("OTHERACTION", bOtherAction);
            bPrintAction = userToolbar.GetExtValue("PRINTACTION", bPrintAction);
            bSearchBar = userToolbar.GetExtValue("SEARCHBARACTION", bSearchBar);
            bExportXMLButton = userToolbar.GetExtValue("EXPORTXMLACTION", bExportXMLButton);
            bNewRowAction = userToolbar.GetExtValue("NEWROWACTION", bNewRowAction);
            bEditRowAction = userToolbar.GetExtValue("EDITROWACTION", bEditRowAction);
            strObjectName = userToolbar.GetExtValue("OBJECTNAME", strObjectName);
            bHelpAction = userToolbar.GetExtValue("HELPACTION", bHelpAction);
            bImportExcel = userToolbar.GetExtValue("IMPORTEXCELACTION", bImportExcel);
        } else if (bInfoMode) {
            bRemoveButton = false;
        }
        IToolbarItemWriter group1Writer = this.FindDEBHGroupToolbarItemWriter("1");
        if (group1Writer != null) {
            TBItemConfig tbItemConfig = new TBItemConfig();
            tbItemConfig.setSeperator("LAST");
            group1Writer.Export(rootNode, tbItemsNode, tbItemConfig, null, (IToolbarItemWriterContext)tbWriterContext, false);
        }
        if (!bInfoMode) {
            if (bNewButton) {
                tbItemNode3 = new XMLNode();
                tbItemNode3.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
                tbItemsNode.AddNode(tbItemNode3);
                if (StringHelper.IsNullOrEmpty((String)this.getPageModel())) {
                    tbItemNode3.SetValue("ICONCSSCLASS", "sx-tb-new");
                } else if (StringHelper.Compare((String)this.getPageModel(), (String)"SL", (boolean)true) == 0) {
                    tbItemNode3.SetValue("IMAGE", "../sasrfex/images/default/icon_new.png");
                }
                String strNewFormat = this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"GRIDVIEW", (String)"NEW"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"NEW"), "\u65b0\u5efa%1$s");
                String strNewTipFormat = this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"GRIDVIEW", (String)"NEW"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"NEW"), "\u65b0\u5efa%1$s");
                if (bMini) {
                    tbItemNode3.SetValue(ToolbarButtonConfig.TAG_TEXT, StringHelper.Format((String)strNewFormat, (Object)""));
                } else {
                    tbItemNode3.SetValue(ToolbarButtonConfig.TAG_TEXT, StringHelper.Format((String)strNewFormat, (Object)strObjectName));
                }
                tbItemNode3.SetValue("TIPS", StringHelper.Format((String)strNewTipFormat, (Object)strObjectName));
                tbItemNode3.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.GridNewHandler"));
                tbItemNode3.SetValue("RESOURCEID", UniResHelper.GetDEDataResId((String)iDEHelper.getId(), (String)"CREATE"));
                if (!StringHelper.IsNullOrEmpty((String)this.getPageModel())) {
                    this.RebuildGridViewNewAction(tbItemsNode, tbItemNode3, iDEHelper);
                }
            }
            if (bEditButton) {
                tbItemNode3 = new XMLNode();
                tbItemNode3.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
                tbItemsNode.AddNode(tbItemNode3);
                if (StringHelper.IsNullOrEmpty((String)this.getPageModel())) {
                    tbItemNode3.SetValue("ICONCSSCLASS", "sx-tb-edit");
                }
                if (StringHelper.Compare((String)this.getPageModel(), (String)"SL", (boolean)true) == 0) {
                    tbItemNode3.SetValue("IMAGE", "../sasrfex/images/default/icon_edit.png");
                }
                String strEditFormat = this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"GRIDVIEW", (String)"EDIT"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"EDIT"), "\u7f16\u8f91");
                String strEditTipFormat = this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"GRIDVIEW", (String)"EDIT"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"EDIT"), "\u7f16\u8f91%1$s");
                tbItemNode3.SetValue(ToolbarButtonConfig.TAG_TEXT, strEditFormat);
                tbItemNode3.SetValue("TIPS", StringHelper.Format((String)strEditTipFormat, (Object)strObjectName));
                if (StringHelper.IsNullOrEmpty((String)this.getPageModel())) {
                    tbItemNode3.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.GridEditHandler"));
                }
                if (StringHelper.Compare((String)this.getPageModel(), (String)"SL", (boolean)true) == 0) {
                    tbItemNode3.SetValue("HANDLERTYPE", "GRIDVIEW_EDITACTION");
                }
            } else if (bViewButton) {
                tbItemNode3 = new XMLNode();
                tbItemNode3.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
                tbItemsNode.AddNode(tbItemNode3);
                if (StringHelper.IsNullOrEmpty((String)this.getPageModel())) {
                    tbItemNode3.SetValue("ICONCSSCLASS", "sx-tb-edit");
                }
                if (StringHelper.Compare((String)this.getPageModel(), (String)"SL", (boolean)true) == 0) {
                    tbItemNode3.SetValue("IMAGE", "../sasrfex/images/default/icon_edit.png");
                }
                strViewFormat = this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"GRIDVIEW", (String)"VIEW"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"VIEW"), "\u67e5\u770b");
                strViewTipFormat = this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"GRIDVIEW", (String)"VIEW"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"VIEW"), "\u67e5\u770b%1$s");
                tbItemNode3.SetValue(ToolbarButtonConfig.TAG_TEXT, strViewFormat);
                tbItemNode3.SetValue("TIPS", StringHelper.Format((String)strViewTipFormat, (Object)strObjectName));
                if (StringHelper.IsNullOrEmpty((String)this.getPageModel())) {
                    tbItemNode3.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.GridEditHandler"));
                }
                if (StringHelper.Compare((String)this.getPageModel(), (String)"SL", (boolean)true) == 0) {
                    tbItemNode3.SetValue("HANDLERTYPE", "GRIDVIEW_EDITACTION");
                }
            }
            bExportDEMainStateActions = false;
            if (iDEMainStateHelper != null) {
                boolean bl = bExportDEMainStateActions = this.ExportDEMainStateActions(iDAConfigPublishContext, rootNode, tbItemsNode, iDEMainStateHelper, false) != 0;
            }
            if (bCopyButton) {
                tbItemNode2 = new XMLNode();
                tbItemNode2.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
                tbItemsNode.AddNode(tbItemNode2);
                if (StringHelper.IsNullOrEmpty((String)this.getPageModel())) {
                    tbItemNode2.SetValue("ICONCSSCLASS", "sx-tb-copy");
                } else if (StringHelper.Compare((String)this.getPageModel(), (String)"SL", (boolean)true) == 0) {
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
            if (bNewButton || bEditButton || bCopyButton || bViewButton || bExportDEMainStateActions) {
                GridViewToolbarConfigPublisher.AddToolbarSeperator(tbItemsNode);
            }
            if (bEnableRowEdit) {
                if (bEditRowAction) {
                    tbItemNode2 = new XMLNode();
                    tbItemNode2.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
                    tbItemsNode.AddNode(tbItemNode2);
                    if (StringHelper.IsNullOrEmpty((String)this.getPageModel())) {
                        tbItemNode2.SetValue("ICONCSSCLASS", "sx-tb-editrow");
                    }
                    if (StringHelper.Compare((String)this.getPageModel(), (String)"SL", (boolean)true) == 0) {
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
                    if (StringHelper.IsNullOrEmpty((String)this.getPageModel())) {
                        tbItemNode2.SetValue("ICONCSSCLASS", "sx-tb-addrow");
                    }
                    if (StringHelper.Compare((String)this.getPageModel(), (String)"SL", (boolean)true) == 0) {
                        tbItemNode2.SetValue("IMAGE", "../sasrfex/images/default/icon_addrow.png");
                    }
                    tbItemNode2.SetValue("TIPS", this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"GRIDVIEW", (String)"NEWROW"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"NEWROW"), "\u65b0\u52a0\u884c"));
                    tbItemNode2.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.GridNewRowHandler"));
                    tbItemNode2.SetValue("RESOURCEID", UniResHelper.GetDEDataResId((String)iDEHelper.getId(), (String)"CREATE"));
                }
                if (StringHelper.IsNullOrEmpty((String)this.getPageModel())) {
                    tbItemNode2 = new XMLNode();
                    tbItemNode2.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
                    tbItemsNode.AddNode(tbItemNode2);
                    if (StringHelper.IsNullOrEmpty((String)this.getPageModel())) {
                        tbItemNode2.SetValue("ICONCSSCLASS", "sx-tb-saverow");
                    }
                    if (StringHelper.Compare((String)this.getPageModel(), (String)"SL", (boolean)true) == 0) {
                        tbItemNode2.SetValue("IMAGE", "../sasrfex/images/default/icon_rowsave.png");
                    }
                    tbItemNode2.SetValue("TIPS", this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"GRIDVIEW", (String)"SAVEROW"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"SAVEROW"), "\u4fdd\u5b58\u884c"));
                    if (StringHelper.IsNullOrEmpty((String)this.getPageModel())) {
                        tbItemNode2.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.GridSaveRowHandler"));
                    }
                    if (StringHelper.Compare((String)this.getPageModel(), (String)"SL", (boolean)true) == 0) {
                        tbItemNode2.SetValue("HANDLERTYPE", "GRIDVIEW_SAVEROW");
                    }
                    tbItemNode2.SetValue("RESOURCEID", UniResHelper.GetDEDataResId((String)iDEHelper.getId(), (String)"UPDATE"));
                }
                GridViewToolbarConfigPublisher.AddToolbarSeperator(tbItemsNode);
            }
            if (bRemoveButton) {
                tbItemNode2 = new XMLNode();
                tbItemNode2.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
                tbItemsNode.AddNode(tbItemNode2);
                if (StringHelper.IsNullOrEmpty((String)this.getPageModel())) {
                    tbItemNode2.SetValue("ICONCSSCLASS", "sx-tb-delete");
                }
                if (StringHelper.Compare((String)this.getPageModel(), (String)"SL", (boolean)true) == 0) {
                    tbItemNode2.SetValue("IMAGE", "../sasrfex/images/default/icon_delete.png");
                }
                if (!bMini) {
                    tbItemNode2.SetValue(ToolbarButtonConfig.TAG_TEXT, this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"GRIDVIEW", (String)"REMOVE"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"REMOVE"), "\u5220\u9664"));
                }
                strRemoveTooltip = this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"GRIDVIEW", (String)"REMOVE"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"REMOVE"), "\u5220\u9664%1$s");
                tbItemNode2.SetValue("TIPS", StringHelper.Format((String)strRemoveTooltip, (Object)strObjectName));
                tbItemNode2.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.GridRemoveHandler"));
                if (StringHelper.Compare((String)this.getPageModel(), (String)"SL", (boolean)true) == 0) {
                    tbItemNode2.SetValue("HANDLERTYPE", "GRIDVIEW_DELETE");
                }
                tbItemNode2.SetValue("RESOURCEID", UniResHelper.GetDEDataResId((String)iDEHelper.getId(), (String)"DELETE"));
                GridViewToolbarConfigPublisher.AddToolbarSeperator(tbItemsNode);
            }
        } else {
            if (bEditButton || bViewButton) {
                tbItemNode3 = new XMLNode();
                tbItemNode3.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
                tbItemsNode.AddNode(tbItemNode3);
                if (StringHelper.IsNullOrEmpty((String)this.getPageModel())) {
                    tbItemNode3.SetValue("ICONCSSCLASS", "sx-tb-edit");
                }
                if (StringHelper.Compare((String)this.getPageModel(), (String)"SL", (boolean)true) == 0) {
                    tbItemNode3.SetValue("IMAGE", "../sasrfex/images/default/icon_edit.png");
                }
                strViewFormat = this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"GRIDVIEW", (String)"VIEW"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"VIEW"), "\u67e5\u770b");
                strViewTipFormat = this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"GRIDVIEW", (String)"VIEW"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"VIEW"), "\u67e5\u770b%1$s");
                tbItemNode3.SetValue(ToolbarButtonConfig.TAG_TEXT, strViewFormat);
                tbItemNode3.SetValue("TIPS", StringHelper.Format((String)strViewTipFormat, (Object)strObjectName));
                if (StringHelper.IsNullOrEmpty((String)this.getPageModel())) {
                    tbItemNode3.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.GridEditHandler"));
                }
                if (StringHelper.Compare((String)this.getPageModel(), (String)"SL", (boolean)true) == 0) {
                    tbItemNode3.SetValue("HANDLERTYPE", "GRIDVIEW_EDITACTION");
                }
            }
            bExportDEMainStateActions = false;
            if (iDEMainStateHelper != null) {
                boolean bl = bExportDEMainStateActions = this.ExportDEMainStateActions(iDAConfigPublishContext, rootNode, tbItemsNode, iDEMainStateHelper, false) != 0;
            }
            if (bEditButton || bExportDEMainStateActions) {
                GridViewToolbarConfigPublisher.AddToolbarSeperator(tbItemsNode);
            }
            if (bRemoveButton) {
                tbItemNode2 = new XMLNode();
                tbItemNode2.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
                tbItemsNode.AddNode(tbItemNode2);
                if (StringHelper.IsNullOrEmpty((String)this.getPageModel())) {
                    tbItemNode2.SetValue("ICONCSSCLASS", "sx-tb-delete");
                }
                if (StringHelper.Compare((String)this.getPageModel(), (String)"SL", (boolean)true) == 0) {
                    tbItemNode2.SetValue("IMAGE", "../sasrfex/images/default/icon_delete.png");
                }
                if (!bMini) {
                    tbItemNode2.SetValue(ToolbarButtonConfig.TAG_TEXT, this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"GRIDVIEW", (String)"REMOVE"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"REMOVE"), "\u5220\u9664"));
                }
                strRemoveTooltip = this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"GRIDVIEW", (String)"REMOVE"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"REMOVE"), "\u5220\u9664%1$s");
                tbItemNode2.SetValue("TIPS", StringHelper.Format((String)strRemoveTooltip, (Object)strObjectName));
                if (StringHelper.IsNullOrEmpty((String)this.getPageModel())) {
                    tbItemNode2.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.GridRemoveHandler"));
                }
                if (StringHelper.Compare((String)this.getPageModel(), (String)"SL", (boolean)true) == 0) {
                    tbItemNode2.SetValue("HANDLERTYPE", "GRIDVIEW_DELETE");
                }
                tbItemNode2.SetValue("RESOURCEID", UniResHelper.GetDEDataResId((String)iDEHelper.getId(), (String)"DELETE"));
                GridViewToolbarConfigPublisher.AddToolbarSeperator(tbItemsNode);
            }
        }
        if (bExportButton) {
            XMLNode tbItemNode4 = new XMLNode();
            tbItemNode4.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
            tbItemsNode.AddNode(tbItemNode4);
            if (StringHelper.IsNullOrEmpty((String)this.getPageModel())) {
                tbItemNode4.SetValue("ICONCSSCLASS", "sx-tb-export");
            }
            if (StringHelper.Compare((String)this.getPageModel(), (String)"SL", (boolean)true) == 0) {
                tbItemNode4.SetValue("IMAGE", "../sasrfex/images/default/icon_export.png");
            }
            if (!bMini) {
                tbItemNode4.SetValue(ToolbarButtonConfig.TAG_TEXT, this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"GRIDVIEW", (String)"EXPORT"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"EXPORT"), "\u5bfc\u51fa"));
            }
            String strExportTooltip = this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"GRIDVIEW", (String)"EXPORT"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"EXPORT"), "\u5bfc\u51fa%1$s\u5230Excel\u6587\u4ef6");
            tbItemNode4.SetValue("TIPS", StringHelper.Format((String)strExportTooltip, (Object)strObjectName));
            tbItemNode4.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.GridExportExcelHandler"));
            if (StringHelper.Compare((String)this.getPageModel(), (String)"SL", (boolean)true) == 0) {
                tbItemNode4.SetValue("HANDLERTYPE", "GRIDVIEW_EXPORT");
            }
            String strMaxRow = iDEHelper.GetProperty("MAXDOWNLOADROW", this.getDAGlobalHelper().getWebExConfig().GetValue("SRFDA", "MAXDOWNLOADROW", "1000"));
            tbItemNode4.SetValue("MAXROW", strMaxRow);
        }
        if (bPrintAction) {
            XMLNode tbItemNode5 = new XMLNode();
            tbItemNode5.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
            tbItemsNode.AddNode(tbItemNode5);
            if (StringHelper.IsNullOrEmpty((String)this.getPageModel())) {
                tbItemNode5.SetValue("ICONCSSCLASS", "sx-tb-print");
            }
            if (StringHelper.Compare((String)this.getPageModel(), (String)"SL", (boolean)true) == 0) {
                tbItemNode5.SetValue("IMAGE", "../sasrfex/images/default/icon_print.png");
            }
            if (!bMini) {
                tbItemNode5.SetValue(ToolbarButtonConfig.TAG_TEXT, this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"GRIDVIEW", (String)"PRINT"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"PRINT"), "\u6253\u5370"));
            }
            tbItemNode5.SetValue("TIPS", this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"GRIDVIEW", (String)"PRINT"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"PRINT"), "\u6253\u5370\u5f53\u524d\u6570\u636e"));
            tbItemNode5.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.GridPrintHandler"));
            if (bMultiPrint) {
                tbItemNode5.SetValue("ICONCSSCLASS", "sx-tb-mprint");
            }
            tbItemNode5.SetValue("MULTIPRINT", String.valueOf(bMultiPrint).toUpperCase());
        }
        if (bExportButton || bPrintAction) {
            GridViewToolbarConfigPublisher.AddToolbarSeperator(tbItemsNode);
        }
        XMLNode userOtherAction = null;
        if (userToolbar != null && userToolbar.getChildNodes() != null) {
            boolean bAppendSeperator = false;
            for (XMLNode child : userToolbar.getChildNodes()) {
                String strID = child.getID();
                if (StringHelper.Compare((String)strID, (String)"OTHERACTION", (boolean)true) != 0) {
                    if (StringHelper.Compare((String)child.getNodeName(), (String)"SRFDATBITEM", (boolean)true) == 0) {
                        bAppendSeperator = true;
                        this.ExportTBItem(rootNode, tbItemsNode, child, false, tbWriterContext, false);
                        continue;
                    }
                    int nPos = child.GetExtValue("POS", -1);
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
                GridViewToolbarConfigPublisher.AddToolbarSeperator(tbItemsNode);
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
                GridViewToolbarConfigPublisher.AddToolbarSeperator(tbItemsNode);
            }
        }
        if (bSearchBar && StringHelper.IsNullOrEmpty((String)this.getPageModel())) {
            tbItemNode = new XMLNode();
            tbItemNode.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
            tbItemNode.setID("TBB_FILTER");
            tbItemsNode.AddNode(tbItemNode);
            tbItemNode.SetValue("ICONCSSCLASS", "sx-tb-filter");
            if (!bMini) {
                tbItemNode.SetValue(ToolbarButtonConfig.TAG_TEXT, this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"GRIDVIEW", (String)"FILTER"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"FILTER"), "\u8fc7\u6ee4"));
            }
            tbItemNode.SetValue("TIPS", this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"GRIDVIEW", (String)"FILTER"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"FILTER"), "\u8fdb\u4e00\u6b65\u641c\u7d22\u6570\u636e"));
            tbItemNode.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.SPShowHideHandler"));
            GridViewToolbarConfigPublisher.AddToolbarSeperator(tbItemsNode);
        }
        if (bHelpAction) {
            tbItemNode = new XMLNode();
            tbItemNode.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
            tbItemsNode.AddNode(tbItemNode);
            if (StringHelper.IsNullOrEmpty((String)this.getPageModel())) {
                tbItemNode.SetValue("ICONCSSCLASS", "sx-tb-help");
            }
            if (StringHelper.Compare((String)this.getPageModel(), (String)"SL", (boolean)true) == 0) {
                tbItemNode.SetValue("IMAGE", "../sasrfex/images/default/icon_help16.png");
            }
            if (!bMini) {
                tbItemNode.SetValue(ToolbarButtonConfig.TAG_TEXT, this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"GRIDVIEW", (String)"HELP"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"HELP"), "\u5e2e\u52a9"));
            }
            tbItemNode.SetValue("TIPS", this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"GRIDVIEW", (String)"HELP"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"HELP"), "\u5e2e\u52a9"));
            tbItemNode.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.HelpHandler"));
            tbItemNode.SetValue("PAGETYPE", "GRIDVIEW");
        }
        GridViewToolbarConfigPublisher.EraseToolbarUnnecessarySeperator(rootNode);
        return rootNode;
    }

    protected IGridViewToolbarConfigPublishContext getGridViewToolbarConfigPublishContext(IToolbarConfigPublishContext iDAConfigPublishContext) throws Exception {
        if (!(iDAConfigPublishContext instanceof IGridViewToolbarConfigPublishContext)) {
            throw new Exception("\u4f20\u5165\u53c2\u6570\u7c7b\u578b\u65e0\u6548");
        }
        return (IGridViewToolbarConfigPublishContext)iDAConfigPublishContext;
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
}

