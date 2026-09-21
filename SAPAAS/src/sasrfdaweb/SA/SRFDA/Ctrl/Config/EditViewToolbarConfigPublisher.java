/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.DEWizard
 *  SA.SRFDA.Ctrl.Data.Form
 *  SA.SRFDA.Ctrl.Data.Page
 *  SA.SRFDA.Ctrl.Data.TBTempl
 *  SA.SRFDA.Ctrl.Data.Toolbar
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Ctrl.IDEMainActionHelper
 *  SA.SRFDA.Ctrl.IDEMainStateHelper
 *  SA.SRFDA.Ctrl.IPageHelper
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
 *  SA.SRFramework.WebEx.ToolBar.UI.ToolbarSeperatorConfig
 *  SA.SRFramework.WebEx.ToolBar.UI.ToolbarSplitButtonConfig
 *  SA.SRFramework.XML.XMLNode
 */
package SA.SRFDA.Ctrl.Config;

import SA.SRFDA.Ctrl.Config.BaseEditViewToolbarConfigPublisher;
import SA.SRFDA.Ctrl.Config.IEditViewToolbarConfigPublishContext;
import SA.SRFDA.Ctrl.Config.IToolbarConfigPublishContext;
import SA.SRFDA.Ctrl.Data.DEWizard;
import SA.SRFDA.Ctrl.Data.Form;
import SA.SRFDA.Ctrl.Data.Page;
import SA.SRFDA.Ctrl.Data.TBTempl;
import SA.SRFDA.Ctrl.Data.Toolbar;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Ctrl.IDEMainActionHelper;
import SA.SRFDA.Ctrl.IDEMainStateHelper;
import SA.SRFDA.Ctrl.IPageHelper;
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
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarSeperatorConfig;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarSplitButtonConfig;
import SA.SRFramework.XML.XMLNode;
import java.util.Vector;

public class EditViewToolbarConfigPublisher
extends BaseEditViewToolbarConfigPublisher {
    @Override
    protected XMLNode OnPublish(IToolbarConfigPublishContext iDAConfigPublishContext) throws Exception {
        IToolbarItemWriter group2Writer;
        XMLNode tbItemNode;
        XMLNode tbItemNode2;
        boolean bExportDEMainStateActions;
        XMLNode tbItemNode3;
        IEditViewToolbarConfigPublishContext iEditViewToolbarConfigPublishContext = this.getEditViewToolbarConfigPublishContext(iDAConfigPublishContext);
        Page page = null;
        if (iEditViewToolbarConfigPublishContext.getPage() != null && iEditViewToolbarConfigPublishContext.getPage().getPageData() != null) {
            page = iEditViewToolbarConfigPublishContext.getPage().getPageData().getData();
        }
        IDEHelper iDEHelper = iEditViewToolbarConfigPublishContext.getDEHelper();
        IDEMainStateHelper iDEMainStateHelper = iEditViewToolbarConfigPublishContext.getDEMainState();
        IDEMainActionHelper iDEMainActionHelper = null;
        iDEMainActionHelper = iDEMainStateHelper != null ? iDEMainStateHelper.getEditDEMainAction() : iEditViewToolbarConfigPublishContext.getDEMainAction();
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
        boolean bInfoMode = iEditViewToolbarConfigPublishContext.getReadOnlyMode();
        Form form = iEditViewToolbarConfigPublishContext.getForm();
        boolean bEmbedMode = iEditViewToolbarConfigPublishContext.getEmbedMode();
        boolean bMini = iEditViewToolbarConfigPublishContext.getMiniMode();
        DefaultToolbarWriterContext tbWriterContext = this.CreateTBWriterContext();
        tbWriterContext.setPage(page);
        tbWriterContext.setDEHelper(iDEHelper);
        tbWriterContext.setViewStyle(iDAConfigPublishContext.getPage().getPageType());
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
        String strToolbarXML = "";
        if (form != null) {
            strToolbarXML = form.getFORMTOOLBAR();
        }
        userToolbar = EditViewToolbarConfigPublisher.LoadToolbarConfig(strToolbarXML, page);
        boolean bNewButton = this.getEnableNew();
        if (bNewButton) {
            bNewButton = bEnableUserCreate;
        }
        boolean bSaveButton = bEnableUserUpdate;
        boolean bSaveAndExitButton = bEnableUserUpdate;
        boolean bRemoveAndExitButton = this.getEnableRemoveAndExit();
        if (bRemoveAndExitButton) {
            bRemoveAndExitButton = bEnableUserDelete;
        }
        boolean bCopyButton = bEnableUserCreate;
        boolean bOtherAction = true;
        boolean bPrintAction = iDEHelper.IsEnablePrint();
        boolean bSaveAndNewButton = bEnableUserUpdate && bEnableUserCreate;
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
            bUnlockButton = this.getEnableUnlock();
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
            if (bReplaceDefault = userToolbar.GetExtValue("SRFREPLACEDEFAULT", bReplaceDefault)) {
                userToolbar.setNodeName("SRFEXTOOLBAR");
                return userToolbar;
            }
            if (bInfoMode = userToolbar.GetExtValue("INFOMODE", bInfoMode)) {
                bRemoveAndExitButton = false;
            }
            bNewButton = userToolbar.GetExtValue("NEWACTION", bNewButton);
            bSaveButton = userToolbar.GetExtValue("SAVEACTION", bSaveButton);
            bSaveAndExitButton = userToolbar.GetExtValue("SAVEANDEXITACTION", bSaveAndExitButton);
            bSaveAndNewButton = userToolbar.GetExtValue("SAVEANDNEWACTION", bSaveAndNewButton);
            bHelpAction = userToolbar.GetExtValue("HELPACTION", bHelpAction);
            bRemoveAndExitButton = userToolbar.GetExtValue("REMOVEANDEXITACTION", bRemoveAndExitButton);
            bCopyButton = userToolbar.GetExtValue("COPYACTION", bCopyButton);
            bOtherAction = userToolbar.GetExtValue("OTHERACTION", bOtherAction);
            bPrintAction = userToolbar.GetExtValue("PRINTACTION", bPrintAction);
            bSaveAndStartWFButton = userToolbar.GetExtValue("SAVEANDSTARTWFACTION", bSaveAndStartWFButton);
            bViewWFStepActor = userToolbar.GetExtValue("VIEWWFSTEPACTOR", bViewWFStepActor);
            bViewWFStepData = userToolbar.GetExtValue("VIEWWFSTEPDATA", bViewWFStepData);
            bAppendDataNavBar = userToolbar.GetExtValue("DATANAVBAR", bAppendDataNavBar);
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
                tbItemNode3 = new XMLNode();
                tbItemNode3.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
                tbItemsNode.AddNode(tbItemNode3);
                if (StringHelper.Compare((String)this.getPageModel(), (String)"SL", (boolean)true) == 0) {
                    tbItemNode3.SetValue("IMAGE", "../sasrfex/images/default/icon_unlock.png");
                }
                tbItemNode3.SetValue(ToolbarButtonConfig.TAG_TEXT, this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"EDITVIEW", (String)"UNLOCK"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"UNLOCK"), "\u89e3\u9501"));
                tbItemNode3.SetValue("TIPS", this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"EDITVIEW", (String)"UNLOCK"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"UNLOCK"), "\u89e3\u9501\u6570\u636e"));
                tbItemNode3.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.FormUnlockHandler"));
                tbItemNode3.SetValue("ENABLETOGGLE", "TRUE");
                EditViewToolbarConfigPublisher.AddToolbarSeperator(tbItemsNode);
            }
            if (bSaveButton) {
                tbItemNode3 = new XMLNode();
                tbItemNode3.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
                tbItemsNode.AddNode(tbItemNode3);
                if (StringHelper.IsNullOrEmpty((String)this.getPageModel())) {
                    tbItemNode3.SetValue("ICONCSSCLASS", "sx-tb-save");
                }
                if (StringHelper.Compare((String)this.getPageModel(), (String)"SL", (boolean)true) == 0) {
                    tbItemNode3.SetValue("IMAGE", "../sasrfex/images/default/icon_save.png");
                }
                tbItemNode3.SetValue(ToolbarButtonConfig.TAG_TEXT, this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"EDITVIEW", (String)"SAVE"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"SAVE"), "\u4fdd\u5b58"));
                tbItemNode3.SetValue("TIPS", this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"EDITVIEW", (String)"SAVE"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"SAVE"), "\u4fdd\u5b58\u5f53\u524d\u6570\u636e"));
                tbItemNode3.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.FormSaveHandler"));
                if (iDEMainActionHelper != null) {
                    tbItemNode3.SetValue("DATAACTION", iDEMainActionHelper.getDataAccessAction());
                }
                if (StringHelper.Compare((String)this.getPageModel(), (String)"SL", (boolean)true) == 0) {
                    tbItemNode3.SetValue("HANDLERTYPE", "EDITVIEW_SAVEACTION");
                }
            }
            if (bSaveAndNewButton && !bEmbedMode) {
                tbItemNode3 = new XMLNode();
                tbItemNode3.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
                tbItemsNode.AddNode(tbItemNode3);
                if (StringHelper.IsNullOrEmpty((String)this.getPageModel())) {
                    tbItemNode3.SetValue("ICONCSSCLASS", "sx-tb-saveandnew");
                }
                if (StringHelper.Compare((String)this.getPageModel(), (String)"SL", (boolean)true) == 0) {
                    tbItemNode3.SetValue("IMAGE", "../sasrfex/images/default/icon_saveandnew.png");
                }
                tbItemNode3.SetValue(ToolbarButtonConfig.TAG_TEXT, this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"EDITVIEW", (String)"SAVEANDNEW"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"SAVEANDNEW"), "\u4fdd\u5b58\u5e76\u65b0\u5efa"));
                tbItemNode3.SetValue("TIPS", this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"EDITVIEW", (String)"SAVEANDNEW"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"SAVEANDNEW"), "\u4fdd\u5b58\u5e76\u65b0\u5efa\u6570\u636e"));
                tbItemNode3.SetValue("SAVEANDNEW", "TRUE");
                if (iDEMainActionHelper != null) {
                    tbItemNode3.SetValue("DATAACTION", iDEMainActionHelper.getDataAccessAction());
                }
                tbItemNode3.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.FormSaveHandler"));
                if (StringHelper.Compare((String)this.getPageModel(), (String)"SL", (boolean)true) == 0) {
                    tbItemNode3.SetValue("HANDLERTYPE", "EDITVIEW_SAVEACTION");
                }
            }
            if (bSaveAndExitButton && !bEmbedMode) {
                tbItemNode3 = new XMLNode();
                tbItemNode3.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
                tbItemsNode.AddNode(tbItemNode3);
                if (StringHelper.IsNullOrEmpty((String)this.getPageModel())) {
                    tbItemNode3.SetValue("ICONCSSCLASS", "sx-tb-saveandclose");
                }
                if (StringHelper.Compare((String)this.getPageModel(), (String)"SL", (boolean)true) == 0) {
                    tbItemNode3.SetValue("IMAGE", "../sasrfex/images/default/icon_saveandclose.png");
                }
                tbItemNode3.SetValue(ToolbarButtonConfig.TAG_TEXT, this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"EDITVIEW", (String)"SAVEANDCLOSE"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"SAVEANDCLOSE"), "\u4fdd\u5b58\u5e76\u5173\u95ed"));
                tbItemNode3.SetValue("TIPS", this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"EDITVIEW", (String)"SAVEANDCLOSE"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"SAVEANDCLOSE"), "\u4fdd\u5b58\u5e76\u5173\u95ed\u7a97\u53e3"));
                if (iDEMainActionHelper != null) {
                    tbItemNode3.SetValue("DATAACTION", iDEMainActionHelper.getDataAccessAction());
                }
                tbItemNode3.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.FormSaveHandler"));
                tbItemNode3.SetValue("SAVEANDCLOSE", "TRUE");
            }
            if (bSaveButton || bSaveAndExitButton) {
                tbItemNode3 = new XMLNode();
                tbItemNode3.setNodeName(ToolbarSeperatorConfig.TAG_TOOLBARSEPARATOR);
                tbItemsNode.AddNode(tbItemNode3);
            }
            bExportDEMainStateActions = false;
            if (iDEMainStateHelper != null) {
                boolean bl = bExportDEMainStateActions = this.ExportDEMainStateActions(iDAConfigPublishContext, rootNode, tbItemsNode, iDEMainStateHelper, false) != 0;
            }
            if (bExportDEMainStateActions) {
                EditViewToolbarConfigPublisher.AddToolbarSeperator(tbItemsNode);
            }
            if (bRemoveAndExitButton && !bEmbedMode) {
                tbItemNode2 = new XMLNode();
                tbItemNode2.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
                tbItemsNode.AddNode(tbItemNode2);
                if (StringHelper.IsNullOrEmpty((String)this.getPageModel())) {
                    tbItemNode2.SetValue("ICONCSSCLASS", "sx-tb-delete");
                }
                if (StringHelper.Compare((String)this.getPageModel(), (String)"SL", (boolean)true) == 0) {
                    tbItemNode2.SetValue("IMAGE", "../sasrfex/images/default/icon_delete.png");
                }
                tbItemNode2.SetValue(ToolbarButtonConfig.TAG_TEXT, this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"EDITVIEW", (String)"REMOVEANDCLOSE"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"REMOVEANDCLOSE"), "\u5220\u9664\u5e76\u5173\u95ed"));
                tbItemNode2.SetValue("TIPS", this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"EDITVIEW", (String)"REMOVEANDCLOSE"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"REMOVEANDCLOSE"), "\u5220\u9664\u5e76\u5173\u95ed\u7a97\u53e3"));
                tbItemNode2.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.FormRemoveHandler"));
                EditViewToolbarConfigPublisher.AddToolbarSeperator(tbItemsNode);
            }
        } else {
            if (!bEmbedMode) {
                tbItemNode3 = new XMLNode();
                tbItemNode3.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
                tbItemsNode.AddNode(tbItemNode3);
                if (StringHelper.IsNullOrEmpty((String)this.getPageModel())) {
                    tbItemNode3.SetValue("ICONCSSCLASS", "sx-tb-cancel");
                }
                if (StringHelper.Compare((String)this.getPageModel(), (String)"SL", (boolean)true) == 0) {
                    tbItemNode3.SetValue("IMAGE", "../sasrfex/images/default/icon_cancel.png");
                }
                tbItemNode3.SetValue(ToolbarButtonConfig.TAG_TEXT, this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"EDITVIEW", (String)"CLOSE"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"CLOSE"), "\u5173\u95ed"));
                tbItemNode3.SetValue("TIPS", this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"EDITVIEW", (String)"CLOSE"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"CLOSE"), "\u5173\u95ed\u7a97\u53e3"));
                tbItemNode3.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.FormCloseHandler"));
                EditViewToolbarConfigPublisher.AddToolbarSeperator(tbItemsNode);
            }
            bExportDEMainStateActions = false;
            if (iDEMainStateHelper != null) {
                boolean bl = bExportDEMainStateActions = this.ExportDEMainStateActions(iDAConfigPublishContext, rootNode, tbItemsNode, iDEMainStateHelper, false) != 0;
            }
            if (bExportDEMainStateActions) {
                EditViewToolbarConfigPublisher.AddToolbarSeperator(tbItemsNode);
            }
            if (bRemoveAndExitButton && !bEmbedMode) {
                tbItemNode2 = new XMLNode();
                tbItemNode2.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
                tbItemsNode.AddNode(tbItemNode2);
                if (StringHelper.IsNullOrEmpty((String)this.getPageModel())) {
                    tbItemNode2.SetValue("ICONCSSCLASS", "sx-tb-delete");
                }
                if (StringHelper.Compare((String)this.getPageModel(), (String)"SL", (boolean)true) == 0) {
                    tbItemNode2.SetValue("IMAGE", "../sasrfex/images/default/icon_delete.png");
                }
                tbItemNode2.SetValue(ToolbarButtonConfig.TAG_TEXT, this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"EDITVIEW", (String)"REMOVEANDCLOSE"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"REMOVEANDCLOSE"), "\u5220\u9664\u5e76\u5173\u95ed"));
                tbItemNode2.SetValue("TIPS", this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"EDITVIEW", (String)"REMOVEANDCLOSE"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"REMOVEANDCLOSE"), "\u5220\u9664\u5e76\u5173\u95ed\u7a97\u53e3"));
                tbItemNode2.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.FormRemoveHandler"));
                EditViewToolbarConfigPublisher.AddToolbarSeperator(tbItemsNode);
            }
        }
        if (iDEHelper.IsEnableWF()) {
            String strWFIAPAGE;
            Page actionPage;
            Object strTextTip;
            String strText;
            if (bSaveAndStartWFButton) {
                String strWFFirstAction = iDEHelper.GetDEWF().GetWFFIRSTACTION(this.getLanguage());
                tbItemNode2 = new XMLNode();
                tbItemNode2.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
                tbItemsNode.AddNode(tbItemNode2);
                if (StringHelper.IsNullOrEmpty((String)this.getPageModel())) {
                    tbItemNode2.SetValue("ICONCSSCLASS", "sx-tb-saveandstart");
                }
                if (StringHelper.Compare((String)this.getPageModel(), (String)"SL", (boolean)true) == 0) {
                    tbItemNode2.SetValue("IMAGE", "../sasrfex/images/default/icon_saveandstart.png");
                }
                strText = "";
                strText = StringHelper.IsNullOrEmpty((String)strWFFirstAction) ? this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"EDITVIEW", (String)"STARTWF"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"STARTWF"), "\u5f00\u59cb\u6d41\u7a0b") : strWFFirstAction;
                tbItemNode2.SetValue(ToolbarButtonConfig.TAG_TEXT, strText);
                tbItemNode2.SetValue("TIPS", strText);
                tbItemNode2.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, strSaveAndStartWFHandler));
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
            }
            if (bViewWFStepData) {
                String strWFStepDataPageId = this.getWFStepDataGridViewPage();
                tbItemNode2 = new XMLNode();
                tbItemNode2.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
                tbItemsNode.AddNode(tbItemNode2);
                if (StringHelper.IsNullOrEmpty((String)this.getPageModel())) {
                    tbItemNode2.SetValue("ICONCSSCLASS", "sx-tb-stepdata");
                }
                if (StringHelper.Compare((String)this.getPageModel(), (String)"SL", (boolean)true) == 0) {
                    tbItemNode2.SetValue("IMAGE", "../sasrfex/images/default/icon_stepactor.png");
                }
                strText = this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"EDITVIEW", (String)"VIEWWFSTEPDATA"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"VIEWWFSTEPDATA"), "\u6d41\u7a0b\u5904\u7406\u6b65\u9aa4");
                strTextTip = this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"EDITVIEW", (String)"VIEWWFSTEPDATA"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"VIEWWFSTEPDATA"), "\u6d41\u7a0b\u5904\u7406\u6b65\u9aa4");
                tbItemNode2.SetValue(ToolbarButtonConfig.TAG_TEXT, strText);
                tbItemNode2.SetValue("TIPS", (String)strTextTip);
                tbItemNode2.SetValue("WFIAPAGE", strWFStepDataPageId);
                if (!StringHelper.IsNullOrEmpty((String)this.getPageModel()) && (actionPage = this.getDAGlobalHelper().getDAModelStorage().FindPage(strWFStepDataPageId)) != null) {
                    strWFIAPAGE = actionPage.GetTotalPagePath();
                    tbItemNode2.SetValue("WFIAPAGE", strWFIAPAGE);
                    if (actionPage.getWIDTH() > 0) {
                        tbItemNode2.SetValue("WFIAPAGEWIDTH", StringHelper.Format((String)"%1$s", (Object)actionPage.getWIDTH()));
                    }
                    if (actionPage.getHEIGHT() > 0) {
                        tbItemNode2.SetValue("WFIAPAGEHEIGHT", StringHelper.Format((String)"%1$s", (Object)actionPage.getHEIGHT()));
                    }
                }
                tbItemNode2.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.WF.Ctrl.Toolbar.FormViewWFStepDataHandler"));
            }
            if (bViewWFStepActor) {
                String strWFStepActorPageId = this.getWFStepActorGridViewPage();
                tbItemNode2 = new XMLNode();
                tbItemNode2.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
                tbItemsNode.AddNode(tbItemNode2);
                if (StringHelper.IsNullOrEmpty((String)this.getPageModel())) {
                    tbItemNode2.SetValue("ICONCSSCLASS", "sx-tb-stepactor");
                }
                if (StringHelper.Compare((String)this.getPageModel(), (String)"SL", (boolean)true) == 0) {
                    tbItemNode2.SetValue("IMAGE", "../sasrfex/images/default/icon_stepactor.png");
                }
                strText = this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"EDITVIEW", (String)"VIEWWFSTEP"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"VIEWWFSTEP"), "\u5f53\u524d\u6d41\u7a0b\u6b65\u9aa4");
                strTextTip = this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"EDITVIEW", (String)"VIEWWFSTEP"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"VIEWWFSTEP"), "\u5f53\u524d\u6d41\u7a0b\u6b65\u9aa4");
                tbItemNode2.SetValue(ToolbarButtonConfig.TAG_TEXT, strText);
                tbItemNode2.SetValue("TIPS", (String)strTextTip);
                tbItemNode2.SetValue("WFIAPAGE", strWFStepActorPageId);
                if (!StringHelper.IsNullOrEmpty((String)this.getPageModel()) && (actionPage = this.getDAGlobalHelper().getDAModelStorage().FindPage(strWFStepActorPageId)) != null) {
                    strWFIAPAGE = actionPage.GetTotalPagePath();
                    tbItemNode2.SetValue("WFIAPAGE", strWFIAPAGE);
                    if (actionPage.getWIDTH() > 0) {
                        tbItemNode2.SetValue("WFIAPAGEWIDTH", StringHelper.Format((String)"%1$s", (Object)actionPage.getWIDTH()));
                    }
                    if (actionPage.getHEIGHT() > 0) {
                        tbItemNode2.SetValue("WFIAPAGEHEIGHT", StringHelper.Format((String)"%1$s", (Object)actionPage.getHEIGHT()));
                    }
                }
                tbItemNode2.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.WF.Ctrl.Toolbar.FormViewWFStepActorHandler"));
            }
            if (bSaveAndStartWFButton || bViewWFStepActor || bViewWFStepData) {
                XMLNode tbItemNode4 = new XMLNode();
                tbItemNode4.setNodeName(ToolbarSeperatorConfig.TAG_TOOLBARSEPARATOR);
                tbItemsNode.AddNode(tbItemNode4);
            }
        }
        if (!bInfoMode) {
            if (bNewButton && !bEmbedMode) {
                XMLNode tbItemNode5 = new XMLNode();
                tbItemNode5.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
                tbItemsNode.AddNode(tbItemNode5);
                if (StringHelper.IsNullOrEmpty((String)this.getPageModel())) {
                    tbItemNode5.SetValue("ICONCSSCLASS", "sx-tb-new");
                }
                if (StringHelper.Compare((String)this.getPageModel(), (String)"SL", (boolean)true) == 0) {
                    tbItemNode5.SetValue("IMAGE", "../sasrfex/images/default/icon_new.png");
                }
                tbItemNode5.SetValue(ToolbarButtonConfig.TAG_TEXT, this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"EDITVIEW", (String)"NEW"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"NEW"), "\u65b0\u5efa"));
                tbItemNode5.SetValue("TIPS", this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"EDITVIEW", (String)"NEW"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"NEW"), "\u65b0\u5efa\u6570\u636e"));
                tbItemNode5.SetValue("RESOURCEID", UniResHelper.GetDEDataResId((String)iDEHelper.getId(), (String)"CREATE"));
                tbItemNode5.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.FormNewHandler"));
                if (!StringHelper.IsNullOrEmpty((String)this.getPageModel())) {
                    this.RebuildEditViewNewAction(tbItemsNode, tbItemNode5, iDEHelper);
                }
                EditViewToolbarConfigPublisher.AddToolbarSeperator(tbItemsNode);
            }
            if (bCopyButton && !bEmbedMode) {
                XMLNode tbItemNode6 = new XMLNode();
                tbItemNode6.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
                tbItemsNode.AddNode(tbItemNode6);
                if (StringHelper.IsNullOrEmpty((String)this.getPageModel())) {
                    tbItemNode6.SetValue("ICONCSSCLASS", "sx-tb-copy");
                }
                if (StringHelper.Compare((String)this.getPageModel(), (String)"SL", (boolean)true) == 0) {
                    tbItemNode6.SetValue("IMAGE", "../sasrfex/images/default/icon_copy.png");
                }
                tbItemNode6.SetValue(ToolbarButtonConfig.TAG_TEXT, this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"EDITVIEW", (String)"COPY"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"COPY"), "\u62f7\u8d1d"));
                String strCopyTooltip = this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"EDITVIEW", (String)"COPY"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"COPY"), "\u62f7\u8d1d%1$s");
                tbItemNode6.SetValue("TIPS", StringHelper.Format((String)strCopyTooltip, (Object)iDEHelper.getLogicName(this.getLanguage())));
                tbItemNode6.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.FormCopyHandler"));
            }
        }
        if (bPrintAction) {
            XMLNode tbItemNode7 = new XMLNode();
            tbItemNode7.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
            tbItemsNode.AddNode(tbItemNode7);
            if (StringHelper.IsNullOrEmpty((String)this.getPageModel())) {
                tbItemNode7.SetValue("ICONCSSCLASS", "sx-tb-print");
            }
            if (StringHelper.Compare((String)this.getPageModel(), (String)"SL", (boolean)true) == 0) {
                tbItemNode7.SetValue("IMAGE", "../sasrfex/images/default/icon_print.png");
            }
            tbItemNode7.SetValue(ToolbarButtonConfig.TAG_TEXT, this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"EDITVIEW", (String)"PRINT"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"PRINT"), "\u6253\u5370"));
            tbItemNode7.SetValue("TIPS", this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"EDITVIEW", (String)"PRINT"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"PRINT"), "\u6253\u5370\u5f53\u524d\u6570\u636e"));
            tbItemNode7.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.FormPrintHandler"));
        }
        if (bPrintAction) {
            XMLNode tbItemNode8 = new XMLNode();
            tbItemNode8.setNodeName(ToolbarSeperatorConfig.TAG_TOOLBARSEPARATOR);
            tbItemsNode.AddNode(tbItemNode8);
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
                EditViewToolbarConfigPublisher.AddToolbarSeperator(tbItemsNode);
            }
        }
        if (bAppendDataNavBar && !bEmbedMode) {
            tbItemNode = new XMLNode();
            tbItemNode.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
            tbItemsNode.AddNode(tbItemNode);
            if (StringHelper.IsNullOrEmpty((String)this.getPageModel())) {
                tbItemNode.SetValue("ICONCSSCLASS", "x-tbar-page-first");
            }
            if (StringHelper.Compare((String)this.getPageModel(), (String)"SL", (boolean)true) == 0) {
                tbItemNode.SetValue("IMAGE", "../sasrfex/images/default/grid/icon_page-first.png");
            }
            tbItemNode.SetValue(ToolbarButtonConfig.TAG_TEXT, "");
            tbItemNode.SetValue("TIPS", this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"EDITVIEW", (String)"MOVEFIRST"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"MOVEFIRST"), "\u5b9a\u4f4d\u7b2c\u4e00\u6761\u6570\u636e"));
            tbItemNode.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.FormDataNavHandler"));
            tbItemNode.SetValue("NAVACTION", "FIRST");
            tbItemNode = new XMLNode();
            tbItemNode.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
            tbItemsNode.AddNode(tbItemNode);
            if (StringHelper.IsNullOrEmpty((String)this.getPageModel())) {
                tbItemNode.SetValue("ICONCSSCLASS", "x-tbar-page-prev");
            }
            if (StringHelper.Compare((String)this.getPageModel(), (String)"SL", (boolean)true) == 0) {
                tbItemNode.SetValue("IMAGE", "../sasrfex/images/default/grid/icon_page-prev.png");
            }
            tbItemNode.SetValue(ToolbarButtonConfig.TAG_TEXT, "");
            tbItemNode.SetValue("TIPS", this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"EDITVIEW", (String)"MOVEPREV"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"MOVEPREV"), "\u5b9a\u4f4d\u4e0a\u4e00\u6761\u6570\u636e"));
            tbItemNode.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.FormDataNavHandler"));
            tbItemNode.SetValue("NAVACTION", "PREV");
            tbItemNode = new XMLNode();
            tbItemNode.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
            tbItemsNode.AddNode(tbItemNode);
            if (StringHelper.IsNullOrEmpty((String)this.getPageModel())) {
                tbItemNode.SetValue("ICONCSSCLASS", "x-tbar-page-next");
            }
            if (StringHelper.Compare((String)this.getPageModel(), (String)"SL", (boolean)true) == 0) {
                tbItemNode.SetValue("IMAGE", "../sasrfex/images/default/grid/icon_page-next.png");
            }
            tbItemNode.SetValue(ToolbarButtonConfig.TAG_TEXT, "");
            tbItemNode.SetValue("TIPS", this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"EDITVIEW", (String)"MOVENEXT"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"MOVENEXT"), "\u5b9a\u4f4d\u4e0b\u4e00\u6761\u6570\u636e"));
            tbItemNode.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.FormDataNavHandler"));
            tbItemNode.SetValue("NAVACTION", "NEXT");
            tbItemNode = new XMLNode();
            tbItemNode.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
            tbItemsNode.AddNode(tbItemNode);
            if (StringHelper.IsNullOrEmpty((String)this.getPageModel())) {
                tbItemNode.SetValue("ICONCSSCLASS", "x-tbar-page-last");
            }
            if (StringHelper.Compare((String)this.getPageModel(), (String)"SL", (boolean)true) == 0) {
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
            if (StringHelper.IsNullOrEmpty((String)this.getPageModel())) {
                tbItemNode.SetValue("ICONCSSCLASS", "sx-tb-help");
            }
            if (StringHelper.Compare((String)this.getPageModel(), (String)"SL", (boolean)true) == 0) {
                tbItemNode.SetValue("IMAGE", "../sasrfex/images/default/icon_help16.png");
            }
            tbItemNode.SetValue(ToolbarButtonConfig.TAG_TEXT, this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"EDITVIEW", (String)"HELP"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"HELP"), "\u5e2e\u52a9"));
            tbItemNode.SetValue("TIPS", this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"EDITVIEW", (String)"HELP"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"HELP"), "\u5e2e\u52a9"));
            tbItemNode.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.HelpHandler"));
            tbItemNode.SetValue("PAGETYPE", "EDITVIEW");
        }
        EditViewToolbarConfigPublisher.EraseToolbarUnnecessarySeperator(rootNode);
        return rootNode;
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
}

