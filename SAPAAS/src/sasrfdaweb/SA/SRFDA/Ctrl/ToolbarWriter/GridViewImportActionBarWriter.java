/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.DEBehavior
 *  SA.SRFDA.Ctrl.ToolbarWriter.IToolbarItemWriterContext
 *  SA.SRFDA.Ctrl.ToolbarWriter.TBItemConfig
 *  SA.SRFDA.Localization.SRFDALocalizationHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig
 *  SA.SRFramework.XML.XMLNode
 */
package SA.SRFDA.Ctrl.ToolbarWriter;

import SA.SRFDA.Ctrl.Data.DEBehavior;
import SA.SRFDA.Ctrl.ToolbarWriter.BaseToolbarItemWriter;
import SA.SRFDA.Ctrl.ToolbarWriter.IToolbarItemWriterContext;
import SA.SRFDA.Ctrl.ToolbarWriter.TBItemConfig;
import SA.SRFDA.Localization.SRFDALocalizationHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig;
import SA.SRFramework.XML.XMLNode;

public class GridViewImportActionBarWriter
extends BaseToolbarItemWriter {
    public CallResult Export(XMLNode tbNode, XMLNode pNode, TBItemConfig tbItemConfig, DEBehavior deBehavior, IToolbarItemWriterContext context, boolean bMenu) {
        CallResult callResult = new CallResult();
        String strLanguage = context.getLanguage();
        if (bMenu) {
            XMLNode tbMenuItemNode = new XMLNode();
            pNode.AddNode(tbMenuItemNode);
            tbMenuItemNode.setNodeName("SRFEXMENUITEMEX");
            tbMenuItemNode.SetValue("CAPTION", this.globalHelperEx.getLocalizationHelper().GetLocalization(strLanguage, SRFDALocalizationHelper.GetRes_MenuItemCaption((String)"GRIDVIEW", (String)"EXPORTIMPTEMPLATE"), SRFDALocalizationHelper.GetRes_MenuItemCaption((String)"*", (String)"EXPORTIMPTEMPLATE"), "\u4e0b\u8f7d\u5bfc\u5165\u6570\u636e\u6a21\u677f"));
            tbMenuItemNode.SetValue("HANDLER", "SA.SRFDA.Ctrl.Toolbar.GridCustomCallHandler");
            tbMenuItemNode.SetValue("CALLID", "SRFDAEXPORTIMPTEMPLATE");
            tbMenuItemNode.SetValue("CALLNAME", "\u4e0b\u8f7d\u5bfc\u5165\u6570\u636e\u6a21\u677f");
            tbMenuItemNode.SetValue("CONFIRM", "FALSE");
            tbMenuItemNode = new XMLNode();
            pNode.AddNode(tbMenuItemNode);
            tbMenuItemNode.setNodeName("SRFEXMENUITEMEX");
            tbMenuItemNode.SetValue("CAPTION", this.globalHelperEx.getLocalizationHelper().GetLocalization(strLanguage, SRFDALocalizationHelper.GetRes_MenuItemCaption((String)"GRIDVIEW", (String)"IMPORTEXCEL"), SRFDALocalizationHelper.GetRes_MenuItemCaption((String)"*", (String)"IMPORTEXCEL"), "\u5bfc\u5165\u5916\u90e8\u6570\u636e\u6587\u4ef6"));
            tbMenuItemNode.SetValue("HANDLER", "SA.SRFDA.Ctrl.Toolbar.ImportExcelHandler");
        } else {
            XMLNode tbMenuItemNode = new XMLNode();
            pNode.AddNode(tbMenuItemNode);
            tbMenuItemNode.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
            tbMenuItemNode.SetValue(ToolbarButtonConfig.TAG_TEXT, this.globalHelperEx.getLocalizationHelper().GetLocalization(strLanguage, SRFDALocalizationHelper.GetRes_TBBText((String)"GRIDVIEW", (String)"EXPORTIMPTEMPLATE"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"EXPORTIMPTEMPLATE"), "\u4e0b\u8f7d\u5bfc\u5165\u6570\u636e\u6a21\u677f"));
            tbMenuItemNode.SetValue("HANDLER", "SA.SRFDA.Ctrl.Toolbar.GridCustomCallHandler");
            tbMenuItemNode.SetValue("CALLID", "SRFDAEXPORTIMPTEMPLATE");
            tbMenuItemNode.SetValue("CALLNAME", "\u4e0b\u8f7d\u5bfc\u5165\u6570\u636e\u6a21\u677f");
            tbMenuItemNode.SetValue("CONFIRM", "FALSE");
            tbMenuItemNode = new XMLNode();
            pNode.AddNode(tbMenuItemNode);
            tbMenuItemNode.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
            tbMenuItemNode.SetValue(ToolbarButtonConfig.TAG_TEXT, this.globalHelperEx.getLocalizationHelper().GetLocalization(strLanguage, SRFDALocalizationHelper.GetRes_TBBText((String)"GRIDVIEW", (String)"IMPORTEXCEL"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"IMPORTEXCEL"), "\u5bfc\u5165\u5916\u90e8\u6570\u636e\u6587\u4ef6"));
            tbMenuItemNode.SetValue("HANDLER", "SA.SRFDA.Ctrl.Toolbar.ImportExcelHandler");
        }
        return callResult;
    }
}

