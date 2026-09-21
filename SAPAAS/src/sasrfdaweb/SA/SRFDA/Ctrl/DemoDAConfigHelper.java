/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.ConfigPathHelper
 *  SA.SRFDA.Ctrl.Data.Form
 *  SA.SRFDA.Ctrl.Data.Page
 *  SA.SRFDA.Ctrl.Data.TBTempl
 *  SA.SRFDA.Ctrl.Data.Toolbar
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Ctrl.IPageHelper
 *  SA.SRFDA.Ctrl.ToolbarWriter.IToolbarItemWriter
 *  SA.SRFDA.Ctrl.ToolbarWriter.IToolbarItemWriterContext
 *  SA.SRFDA.Ctrl.ToolbarWriter.TBItemConfig
 *  SA.SRFDA.Ctrl.ToolbarWriter.ToolbarConfig
 *  SA.SRFDA.Localization.SRFDALocalizationHelper
 *  SA.SRFDA.Security.UniResHelper
 *  SA.SRFDA.Web.ISRFDAPage
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig
 *  SA.SRFramework.WebEx.ToolBar.UI.ToolbarItemsConfig
 *  SA.SRFramework.WebEx.ToolBar.UI.ToolbarSeperatorConfig
 *  SA.SRFramework.WebEx.ToolBar.UI.ToolbarSplitButtonConfig
 *  SA.SRFramework.XML.XMLNode
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.ConfigPathHelper;
import SA.SRFDA.Ctrl.DAConfigHelper;
import SA.SRFDA.Ctrl.Data.Form;
import SA.SRFDA.Ctrl.Data.Page;
import SA.SRFDA.Ctrl.Data.TBTempl;
import SA.SRFDA.Ctrl.Data.Toolbar;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Ctrl.IPageHelper;
import SA.SRFDA.Ctrl.ToolbarWriter.DefaultToolbarWriterContext;
import SA.SRFDA.Ctrl.ToolbarWriter.IToolbarItemWriter;
import SA.SRFDA.Ctrl.ToolbarWriter.IToolbarItemWriterContext;
import SA.SRFDA.Ctrl.ToolbarWriter.TBItemConfig;
import SA.SRFDA.Ctrl.ToolbarWriter.ToolbarConfig;
import SA.SRFDA.Localization.SRFDALocalizationHelper;
import SA.SRFDA.Security.UniResHelper;
import SA.SRFDA.Web.IActiveDataPage;
import SA.SRFDA.Web.ISRFDAPage;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarItemsConfig;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarSeperatorConfig;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarSplitButtonConfig;
import SA.SRFramework.XML.XMLNode;
import java.io.File;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DemoDAConfigHelper
extends DAConfigHelper {
    private static final Log log = LogFactory.getLog(DemoDAConfigHelper.class);

    protected String getDataState() {
        try {
            BaseDataEntity data;
            ISRFDAPage iDAPage = this.getCurPage();
            IActiveDataPage activeDataPage = null;
            if (iDAPage != null && iDAPage instanceof IActiveDataPage && (activeDataPage = (IActiveDataPage)iDAPage).isEnableActiveData() && (data = activeDataPage.getActiveData()) != null) {
                String strLockState = iDAPage.getDEHelper().GetDEWF().GetWFParam("", "");
                return data.GetParamStringValue("SQZT", "");
            }
        }
        catch (Exception ex) {
            return "";
        }
        return "";
    }

    @Override
    public String GetEditViewToolbarConfigId(IDEHelper iDEHelper, Page page, Form form, boolean bEmbedMode, boolean bInfoMode) {
        String strDataState = this.getDataState();
        String strToolbarConfigId = "";
        strToolbarConfigId = page == null ? StringHelper.Format((String)"DE%1$s.TB_%4$s_EDIT_%2$s_%3$s", (Object)iDEHelper.getId(), (Object)iDEHelper.getVersion(), (Object)(form == null ? 0 : form.getFMVERSION()), (Object)(bEmbedMode ? "EMBED" : "")) : StringHelper.Format((String)"DE%1$s.TB_PAGE_%5$s_%6$s_%4$s_EDIT_%2$s_%3$s", (Object)iDEHelper.getId(), (Object)iDEHelper.getVersion(), (Object)(form == null ? 0 : form.getFMVERSION()), (Object)(bEmbedMode ? "EMBED" : ""), (Object)page.getPAGEID(), (Object)page.getVERSION());
        if (!StringHelper.IsNullOrEmpty((String)strDataState)) {
            strToolbarConfigId = String.valueOf(strToolbarConfigId) + "_" + strDataState;
        }
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
            if (!DemoDAConfigHelper.ExportConfigFile((XMLNode)rootNode, (String)strTBFilePath)) {
                return "";
            }
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u5bfc\u51fa\u7f16\u8f91\u754c\u9762\u5de5\u5177\u680f\u914d\u7f6e\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
        }
        return strToolbarConfigId;
    }

    @Override
    protected XMLNode OnGetEditViewToolbarConfig(IDEHelper iDEHelper, Page page, Form form, boolean bEmbedMode, boolean bInfoMode) throws Exception {
        IToolbarItemWriter group2Writer;
        XMLNode tbItemNode;
        XMLNode tbItemNode2;
        String strDataState = this.getDataState();
        DefaultToolbarWriterContext tbWriterContext = this.CreateTBWriterContext();
        tbWriterContext.setPage(page);
        tbWriterContext.setDEHelper(iDEHelper);
        tbWriterContext.setViewStyle("EDITVIEW");
        tbWriterContext.setAttribute("INFOMODE", bInfoMode);
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
        userToolbar = DemoDAConfigHelper.LoadToolbarConfig(strToolbarXML, page);
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
        boolean bViewWFStepActor = false;
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
                DemoDAConfigHelper.AddToolbarSeperator(tbItemsNode);
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
                DemoDAConfigHelper.AddToolbarSeperator(tbItemsNode);
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
                DemoDAConfigHelper.AddToolbarSeperator(tbItemsNode);
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
                DemoDAConfigHelper.AddToolbarSeperator(tbItemsNode);
            }
        }
        if (iDEHelper.IsEnableWF()) {
            if (bSaveAndStartWFButton) {
                String strWFFirstAction = iDEHelper.GetDEWF().GetWFFIRSTACTION(this.strLanguage);
                XMLNode tbItemNode3 = new XMLNode();
                tbItemNode3.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
                tbItemsNode.AddNode(tbItemNode3);
                if (StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
                    tbItemNode3.SetValue("ICONCSSCLASS", "sx-tb-saveandstart");
                }
                if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) == 0) {
                    tbItemNode3.SetValue("IMAGE", "../sasrfex/images/default/icon_saveandstart.png");
                }
                String strText = "";
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
            if (bViewWFStepActor) {
                tbItemNode2 = new XMLNode();
                tbItemNode2.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
                tbItemsNode.AddNode(tbItemNode2);
                if (StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
                    tbItemNode2.SetValue("ICONCSSCLASS", "sx-tb-stepactor");
                }
                if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) == 0) {
                    tbItemNode2.SetValue("IMAGE", "../sasrfex/images/default/icon_stepactor.png");
                }
                String strText = this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"EDITVIEW", (String)"VIEWWFSTEP"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"VIEWWFSTEP"), "\u5f53\u524d\u6d41\u7a0b\u6b65\u9aa4");
                String strTextTip = this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"EDITVIEW", (String)"VIEWWFSTEP"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"VIEWWFSTEP"), "\u5f53\u524d\u6d41\u7a0b\u6b65\u9aa4");
                tbItemNode2.SetValue(ToolbarButtonConfig.TAG_TEXT, strText);
                tbItemNode2.SetValue("TIPS", strTextTip);
                tbItemNode2.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.WF.Ctrl.Toolbar.FormViewWFStepActorHandler"));
            }
            if (bSaveAndStartWFButton || bViewWFStepActor) {
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
                DemoDAConfigHelper.AddToolbarSeperator(tbItemsNode);
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
                DemoDAConfigHelper.AddToolbarSeperator(tbItemsNode);
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
        DemoDAConfigHelper.EraseToolbarUnnecessarySeperator(rootNode);
        return rootNode;
    }

    @Override
    public String GetWFEditViewToolbarConfigId(IDEHelper iDEHelper, Page page, Form form, boolean bStartWF, String strWFFirstAction) {
        ISRFDAPage iDAPage = this.getCurPage();
        IActiveDataPage activeDataPage = null;
        if (iDAPage != null && iDAPage instanceof IActiveDataPage) {
            activeDataPage = (IActiveDataPage)iDAPage;
        }
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
            if (!DemoDAConfigHelper.ExportConfigFile((XMLNode)rootNode, (String)strTBFilePath)) {
                return "";
            }
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u5bfc\u51fa\u6d41\u7a0b\u7f16\u8f91\u754c\u9762\u5de5\u5177\u680f\u914d\u7f6e\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
        }
        return strToolbarConfigId;
    }

    @Override
    protected XMLNode OnGetWFEditViewToolbarConfig(IDEHelper iDEHelper, Page page, Form form, boolean bStartWF, String strWFFirstAction) throws Exception {
        XMLNode tbItemNode;
        ISRFDAPage iDAPage = this.getCurPage();
        IActiveDataPage activeDataPage = null;
        if (iDAPage != null && iDAPage instanceof IActiveDataPage) {
            activeDataPage = (IActiveDataPage)iDAPage;
        }
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
        userToolbar = DemoDAConfigHelper.LoadToolbarConfig(strToolbarXML, page);
        boolean bSaveButton = true;
        boolean bSaveAndExitButton = true;
        boolean bOtherAction = true;
        boolean bPrintAction = iDEHelper.IsEnablePrint();
        boolean bSaveAndStartWFButton = true;
        boolean bHelpAction = iDEHelper.IsEnableHelp();
        String strSaveAndStartWFHandler = "";
        if (iDEHelper.IsEnableWF()) {
            bSaveAndStartWFButton = iDEHelper.GetDEWF().getUSERSTART();
            strSaveAndStartWFHandler = iDEHelper.GetDEWF().GetWFParam("TBB.FORMSAVEANDSTARTWFHANDLER", "SA.SRFDA.WF.Ctrl.Toolbar.FormSaveAndStartWFHandler");
        }
        if (userToolbar != null) {
            bSaveButton = userToolbar.GetExtValue("SAVEACTION", bSaveButton);
            bSaveAndExitButton = userToolbar.GetExtValue("SAVEANDEXITACTION", bSaveAndExitButton);
            bSaveAndStartWFButton = userToolbar.GetExtValue("SAVEANDSTARTWFACTION", bSaveAndStartWFButton);
            bOtherAction = userToolbar.GetExtValue("OTHERACTION", bOtherAction);
            bPrintAction = userToolbar.GetExtValue("PRINTACTION", bPrintAction);
            bHelpAction = userToolbar.GetExtValue("HELPACTION", bHelpAction);
        }
        if (bSaveButton) {
            tbItemNode = new XMLNode();
            tbItemNode.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
            tbItemsNode.AddNode(tbItemNode);
            tbItemNode.SetValue("ICONCSSCLASS", "sx-tb-save");
            tbItemNode.SetValue(ToolbarButtonConfig.TAG_TEXT, this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"EDITVIEW", (String)"SAVE"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"SAVE"), "\u4fdd\u5b58"));
            tbItemNode.SetValue("TIPS", this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"EDITVIEW", (String)"SAVE"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"SAVE"), "\u4fdd\u5b58\u5f53\u524d\u6570\u636e"));
            tbItemNode.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.FormSaveHandler"));
        }
        if (bSaveAndExitButton) {
            tbItemNode = new XMLNode();
            tbItemNode.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
            tbItemsNode.AddNode(tbItemNode);
            tbItemNode.SetValue("ICONCSSCLASS", "sx-tb-save");
            tbItemNode.SetValue(ToolbarButtonConfig.TAG_TEXT, this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"EDITVIEW", (String)"SAVEANDCLOSE"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"SAVEANDCLOSE"), "\u4fdd\u5b58\u5e76\u5173\u95ed"));
            tbItemNode.SetValue("TIPS", this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"EDITVIEW", (String)"SAVEANDCLOSE"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"SAVEANDCLOSE"), "\u4fdd\u5b58\u5e76\u5173\u95ed\u7a97\u53e3"));
            tbItemNode.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.FormSaveHandler"));
            tbItemNode.SetValue("SAVEANDCLOSE", "TRUE");
        }
        if (bSaveButton || bSaveAndExitButton) {
            tbItemNode = new XMLNode();
            tbItemNode.setNodeName(ToolbarSeperatorConfig.TAG_TOOLBARSEPARATOR);
            tbItemsNode.AddNode(tbItemNode);
        }
        if (bSaveAndStartWFButton) {
            tbItemNode = new XMLNode();
            tbItemNode.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
            tbItemsNode.AddNode(tbItemNode);
            tbItemNode.SetValue("ICONCSSCLASS", "sx-tb-save");
            String strText = "";
            strText = StringHelper.IsNullOrEmpty((String)strWFFirstAction) ? this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"EDITVIEW", (String)"STARTWF"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"STARTWF"), "\u5f00\u59cb\u6d41\u7a0b") : StringHelper.Format((String)"%1$s", (Object)strWFFirstAction);
            tbItemNode.SetValue(ToolbarButtonConfig.TAG_TEXT, strText);
            tbItemNode.SetValue("TIPS", strText);
            tbItemNode.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, strSaveAndStartWFHandler));
            tbItemNode.SetValue("SAVEANDCLOSE", "TRUE");
            if (!StringHelper.IsNullOrEmpty((String)iDEHelper.GetDEWF().getSTARTACTIONFORMID())) {
                tbItemNode.SetValue("WFSTARTFORM", "TRUE");
                String strStartPageId = iDEHelper.GetDEWF().getSTARTACTIONPAGEID();
                if (!StringHelper.IsNullOrEmpty((String)strStartPageId)) {
                    IPageHelper iStartPageHelper = this.getDAGlobalHelper().getDAModelStorage().FindPage2(strStartPageId);
                    tbItemNode.SetValue("WFSTARTPAGE", iStartPageHelper.getFullPagePath());
                    if (iStartPageHelper.getWidth() > 0) {
                        tbItemNode.SetValue("WFSTARTPAGEWIDTH", StringHelper.Format((String)"%1$s", (Object)iStartPageHelper.getWidth()));
                    }
                    if (iStartPageHelper.getHeight() > 0) {
                        tbItemNode.SetValue("WFSTARTPAGEHEIGHT", StringHelper.Format((String)"%1$s", (Object)iStartPageHelper.getHeight()));
                    }
                }
            }
        }
        if (bSaveAndStartWFButton) {
            tbItemNode = new XMLNode();
            tbItemNode.setNodeName(ToolbarSeperatorConfig.TAG_TOOLBARSEPARATOR);
            tbItemsNode.AddNode(tbItemNode);
        }
        if (bPrintAction) {
            tbItemNode = new XMLNode();
            tbItemNode.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
            tbItemsNode.AddNode(tbItemNode);
            tbItemNode.SetValue("ICONCSSCLASS", "sx-tb-print");
            tbItemNode.SetValue(ToolbarButtonConfig.TAG_TEXT, this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"EDITVIEW", (String)"PRINT"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"PRINT"), "\u6253\u5370"));
            tbItemNode.SetValue("TIPS", this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"EDITVIEW", (String)"PRINT"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"PRINT"), "\u6253\u5370\u5f53\u524d\u6570\u636e"));
            tbItemNode.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.FormPrintHandler"));
        }
        if (bPrintAction) {
            tbItemNode = new XMLNode();
            tbItemNode.setNodeName(ToolbarSeperatorConfig.TAG_TOOLBARSEPARATOR);
            tbItemsNode.AddNode(tbItemNode);
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
                XMLNode tbItemNode2 = new XMLNode();
                tbItemNode2.setNodeName(ToolbarSeperatorConfig.TAG_TOOLBARSEPARATOR);
                tbItemsNode.AddNode(tbItemNode2);
            }
        }
        if (bOtherAction) {
            XMLNode tbItemNode3 = new XMLNode();
            tbItemNode3.setNodeName(ToolbarSplitButtonConfig.TAG_TOOLBARSPLITBUTTON);
            tbItemNode3.SetValue(ToolbarButtonConfig.TAG_TEXT, this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"EDITVIEW", (String)"OTHER"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"OTHER"), "\u5176\u5b83"));
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
                DemoDAConfigHelper.AddToolbarSeperator(tbItemsNode);
            }
        }
        if (bHelpAction) {
            XMLNode tbItemNode4 = new XMLNode();
            tbItemNode4.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
            tbItemsNode.AddNode(tbItemNode4);
            tbItemNode4.SetValue("ICONCSSCLASS", "sx-tb-help");
            tbItemNode4.SetValue(ToolbarButtonConfig.TAG_TEXT, this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"EDITVIEW", (String)"HELP"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"HELP"), "\u5e2e\u52a9"));
            tbItemNode4.SetValue("TIPS", this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"EDITVIEW", (String)"HELP"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"HELP"), "\u5e2e\u52a9"));
            tbItemNode4.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.HelpHandler"));
            tbItemNode4.SetValue("PAGETYPE", "EDITVIEW");
        }
        DemoDAConfigHelper.EraseToolbarUnnecessarySeperator(rootNode);
        return rootNode;
    }
}

