/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.Form
 *  SA.SRFDA.Ctrl.Data.Page
 *  SA.SRFDA.Ctrl.Data.TBTempl
 *  SA.SRFDA.Ctrl.Data.Toolbar
 *  SA.SRFDA.Ctrl.IDEBehaviorHelper
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Ctrl.IDEMainActionHelper
 *  SA.SRFDA.Ctrl.ToolbarWriter.IToolbarItemWriter
 *  SA.SRFDA.Ctrl.ToolbarWriter.IToolbarItemWriterContext
 *  SA.SRFDA.Ctrl.ToolbarWriter.TBItemConfig
 *  SA.SRFDA.Ctrl.ToolbarWriter.ToolbarConfig
 *  SA.SRFDA.Localization.SRFDALocalizationHelper
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
import SA.SRFDA.Ctrl.Data.Form;
import SA.SRFDA.Ctrl.Data.Page;
import SA.SRFDA.Ctrl.Data.TBTempl;
import SA.SRFDA.Ctrl.Data.Toolbar;
import SA.SRFDA.Ctrl.IDEBehaviorHelper;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Ctrl.IDEMainActionHelper;
import SA.SRFDA.Ctrl.ToolbarWriter.DefaultToolbarWriterContext;
import SA.SRFDA.Ctrl.ToolbarWriter.IToolbarItemWriter;
import SA.SRFDA.Ctrl.ToolbarWriter.IToolbarItemWriterContext;
import SA.SRFDA.Ctrl.ToolbarWriter.TBItemConfig;
import SA.SRFDA.Ctrl.ToolbarWriter.ToolbarConfig;
import SA.SRFDA.Localization.SRFDALocalizationHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarItemsConfig;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarSeperatorConfig;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarSplitButtonConfig;
import SA.SRFramework.XML.XMLNode;

public class ActionViewToolbarConfigPublisher
extends BaseEditViewToolbarConfigPublisher {
    @Override
    protected XMLNode OnPublish(IToolbarConfigPublishContext iDAConfigPublishContext) throws Exception {
        IToolbarItemWriter group2Writer;
        XMLNode tbItemNode;
        XMLNode tbItemNode2;
        IToolbarItemWriter group1Writer;
        IEditViewToolbarConfigPublishContext iEditViewToolbarConfigPublishContext = this.getEditViewToolbarConfigPublishContext(iDAConfigPublishContext);
        if (iEditViewToolbarConfigPublishContext.getDEMainAction() == null) {
            throw new Exception("\u5fc5\u987b\u6307\u5b9a\u5b9e\u4f53\u4e3b\u64cd\u4f5c");
        }
        IDEMainActionHelper iDEMainActionHelper = iDAConfigPublishContext.getDEMainAction();
        String strDEBehaviorId = iDAConfigPublishContext.getDEMainAction().getDEBehaviorId();
        if (StringHelper.IsNullOrEmpty((String)strDEBehaviorId)) {
            throw new Exception(StringHelper.Format((String)"\u5b9e\u4f53\u4e3b\u64cd\u4f5c[%1$s]\u6ca1\u6709\u6307\u5b9a\u754c\u9762\u884c\u4e3a", (Object)iDAConfigPublishContext.getDEMainAction().getId()));
        }
        IDEBehaviorHelper iDEBehaviorHelper = this.getDAModelStorage().FindDEBehavior2(strDEBehaviorId);
        Page page = null;
        if (iEditViewToolbarConfigPublishContext.getPage() != null && iEditViewToolbarConfigPublishContext.getPage().getPageData() != null) {
            page = iEditViewToolbarConfigPublishContext.getPage().getPageData().getData();
        }
        IDEHelper iDEHelper = iEditViewToolbarConfigPublishContext.getDEHelper();
        boolean bEnableUserCreate = iDEHelper.IsEnableUserCreate();
        boolean bEnableUserUpdate = iDEHelper.IsEnableUserUpdate();
        boolean bEnableUserView = iDEHelper.IsEnableUserView();
        boolean bEnableUserDelete = iDEHelper.IsEnableUserDelete();
        Form form = iEditViewToolbarConfigPublishContext.getForm();
        DefaultToolbarWriterContext tbWriterContext = this.CreateTBWriterContext();
        tbWriterContext.setPage(page);
        tbWriterContext.setDEHelper(iDEHelper);
        tbWriterContext.setViewStyle(iDAConfigPublishContext.getPage().getPageType());
        tbWriterContext.setAttribute("INFOMODE", false);
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
        userToolbar = ActionViewToolbarConfigPublisher.LoadToolbarConfig(strToolbarXML, page);
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
        boolean bViewWFStepActor = false;
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
        }
        if (userToolbar != null) {
            if (bReplaceDefault = userToolbar.GetExtValue("SRFREPLACEDEFAULT", bReplaceDefault)) {
                userToolbar.setNodeName("SRFEXTOOLBAR");
                return userToolbar;
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
            bAppendDataNavBar = userToolbar.GetExtValue("DATANAVBAR", bAppendDataNavBar);
        }
        if ((group1Writer = this.FindDEBHGroupToolbarItemWriter("1")) != null) {
            TBItemConfig tbItemConfig = new TBItemConfig();
            tbItemConfig.setSeperator("LAST");
            group1Writer.Export(rootNode, tbItemsNode, tbItemConfig, null, (IToolbarItemWriterContext)tbWriterContext, false);
        }
        if (bSaveAndExitButton) {
            tbItemNode2 = new XMLNode();
            tbItemNode2.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
            tbItemsNode.AddNode(tbItemNode2);
            if (StringHelper.IsNullOrEmpty((String)this.getPageModel())) {
                tbItemNode2.SetValue("ICONCSSCLASS", "sx-tb-saveandclose");
            }
            if (StringHelper.Compare((String)this.getPageModel(), (String)"SL", (boolean)true) == 0) {
                tbItemNode2.SetValue("IMAGE", "../sasrfex/images/default/icon_saveandclose.png");
            }
            tbItemNode2.SetValue(ToolbarButtonConfig.TAG_TEXT, this.GetLocalization(iDEHelper, iDEBehaviorHelper.getCapLanResId(), iDEBehaviorHelper.getCaption()));
            tbItemNode2.SetValue("TIPS", this.GetLocalization(iDEHelper, iDEBehaviorHelper.getTipLanResId(), iDEBehaviorHelper.getTooltip()));
            if (iDEMainActionHelper != null) {
                tbItemNode2.SetValue("DATAACTION", iDEMainActionHelper.getName());
            }
            tbItemNode2.SetValue("HANDLER", "SA.SRFDA.Ctrl.Toolbar.FormSaveHandler");
            tbItemNode2.SetValue("SAVEANDCLOSE", "TRUE");
        }
        if (bSaveButton || bSaveAndExitButton) {
            ActionViewToolbarConfigPublisher.AddToolbarSeperator(tbItemsNode);
        }
        tbItemNode2 = new XMLNode();
        tbItemNode2.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
        tbItemsNode.AddNode(tbItemNode2);
        if (StringHelper.IsNullOrEmpty((String)this.getPageModel())) {
            tbItemNode2.SetValue("ICONCSSCLASS", "sx-tb-cancel");
        }
        if (StringHelper.Compare((String)this.getPageModel(), (String)"SL", (boolean)true) == 0) {
            tbItemNode2.SetValue("IMAGE", "../sasrfex/images/default/icon_cancel.png");
        }
        tbItemNode2.SetValue(ToolbarButtonConfig.TAG_TEXT, this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"EDITVIEW", (String)"CLOSE"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"CLOSE"), "\u5173\u95ed"));
        tbItemNode2.SetValue("TIPS", this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"EDITVIEW", (String)"CLOSE"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"CLOSE"), "\u5173\u95ed\u7a97\u53e3"));
        tbItemNode2.SetValue("HANDLER", "SA.SRFDA.Ctrl.Toolbar.DialogCancelHandler");
        ActionViewToolbarConfigPublisher.AddToolbarSeperator(tbItemsNode);
        if (bPrintAction) {
            tbItemNode2 = new XMLNode();
            tbItemNode2.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
            tbItemsNode.AddNode(tbItemNode2);
            if (StringHelper.IsNullOrEmpty((String)this.getPageModel())) {
                tbItemNode2.SetValue("ICONCSSCLASS", "sx-tb-print");
            }
            if (StringHelper.Compare((String)this.getPageModel(), (String)"SL", (boolean)true) == 0) {
                tbItemNode2.SetValue("IMAGE", "../sasrfex/images/default/icon_print.png");
            }
            tbItemNode2.SetValue(ToolbarButtonConfig.TAG_TEXT, this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"EDITVIEW", (String)"PRINT"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"PRINT"), "\u6253\u5370"));
            tbItemNode2.SetValue("TIPS", this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"EDITVIEW", (String)"PRINT"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"PRINT"), "\u6253\u5370\u5f53\u524d\u6570\u636e"));
            tbItemNode2.SetValue("HANDLER", "SA.SRFDA.Ctrl.Toolbar.FormPrintHandler");
        }
        if (bPrintAction) {
            ActionViewToolbarConfigPublisher.AddToolbarSeperator(tbItemsNode);
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
                ActionViewToolbarConfigPublisher.AddToolbarSeperator(tbItemsNode);
            }
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
            tbItemNode.SetValue("HANDLER", "SA.SRFDA.Ctrl.Toolbar.HelpHandler");
            tbItemNode.SetValue("PAGETYPE", "EDITVIEW");
        }
        ActionViewToolbarConfigPublisher.EraseToolbarUnnecessarySeperator(rootNode);
        return rootNode;
    }
}

