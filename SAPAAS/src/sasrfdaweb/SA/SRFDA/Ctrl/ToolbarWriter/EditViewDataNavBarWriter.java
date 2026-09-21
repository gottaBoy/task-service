/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.DEBehavior
 *  SA.SRFDA.Ctrl.ToolbarWriter.IToolbarItemWriterContext
 *  SA.SRFDA.Ctrl.ToolbarWriter.TBItemConfig
 *  SA.SRFDA.Localization.SRFDALocalizationHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig
 *  SA.SRFramework.XML.XMLNode
 */
package SA.SRFDA.Ctrl.ToolbarWriter;

import SA.SRFDA.Ctrl.Data.DEBehavior;
import SA.SRFDA.Ctrl.ToolbarWriter.BaseEditViewTBWriter;
import SA.SRFDA.Ctrl.ToolbarWriter.IToolbarItemWriterContext;
import SA.SRFDA.Ctrl.ToolbarWriter.TBItemConfig;
import SA.SRFDA.Localization.SRFDALocalizationHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig;
import SA.SRFramework.XML.XMLNode;

public class EditViewDataNavBarWriter
extends BaseEditViewTBWriter {
    public CallResult Export(XMLNode tbNode, XMLNode pNode, TBItemConfig tbItemConfig, DEBehavior deBehavior, IToolbarItemWriterContext context, boolean bMenu) {
        CallResult callResult = new CallResult();
        if (!bMenu) {
            XMLNode tbItemNode = new XMLNode();
            tbItemNode.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
            pNode.AddNode(tbItemNode);
            if (StringHelper.IsNullOrEmpty((String)context.getPageModel())) {
                tbItemNode.SetValue("ICONCSSCLASS", "x-tbar-page-first");
            }
            if (StringHelper.Compare((String)context.getPageModel(), (String)"SL", (boolean)true) == 0) {
                tbItemNode.SetValue("IMAGE", "../sasrfex/images/default/grid/icon_page-first.png");
            }
            tbItemNode.SetValue(ToolbarButtonConfig.TAG_TEXT, "");
            tbItemNode.SetValue("TIPS", this.globalHelperEx.getLocalizationHelper().GetLocalization(context.getLanguage(), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"EDITVIEW", (String)"MOVEFIRST"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"MOVEFIRST"), "\u5b9a\u4f4d\u7b2c\u4e00\u6761\u6570\u636e"));
            tbItemNode.SetValue("HANDLER", "SA.SRFDA.Ctrl.Toolbar.FormDataNavHandler");
            tbItemNode.SetValue("NAVACTION", "FIRST");
            tbItemNode = new XMLNode();
            tbItemNode.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
            pNode.AddNode(tbItemNode);
            if (StringHelper.IsNullOrEmpty((String)context.getPageModel())) {
                tbItemNode.SetValue("ICONCSSCLASS", "x-tbar-page-prev");
            }
            if (StringHelper.Compare((String)context.getPageModel(), (String)"SL", (boolean)true) == 0) {
                tbItemNode.SetValue("IMAGE", "../sasrfex/images/default/grid/icon_page-prev.png");
            }
            tbItemNode.SetValue(ToolbarButtonConfig.TAG_TEXT, "");
            tbItemNode.SetValue("TIPS", this.globalHelperEx.getLocalizationHelper().GetLocalization(context.getLanguage(), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"EDITVIEW", (String)"MOVEPREV"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"MOVEPREV"), "\u5b9a\u4f4d\u4e0a\u4e00\u6761\u6570\u636e"));
            tbItemNode.SetValue("HANDLER", "SA.SRFDA.Ctrl.Toolbar.FormDataNavHandler");
            tbItemNode.SetValue("NAVACTION", "PREV");
            tbItemNode = new XMLNode();
            tbItemNode.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
            pNode.AddNode(tbItemNode);
            if (StringHelper.IsNullOrEmpty((String)context.getPageModel())) {
                tbItemNode.SetValue("ICONCSSCLASS", "x-tbar-page-next");
            }
            if (StringHelper.Compare((String)context.getPageModel(), (String)"SL", (boolean)true) == 0) {
                tbItemNode.SetValue("IMAGE", "../sasrfex/images/default/grid/icon_page-next.png");
            }
            tbItemNode.SetValue(ToolbarButtonConfig.TAG_TEXT, "");
            tbItemNode.SetValue("TIPS", this.globalHelperEx.getLocalizationHelper().GetLocalization(context.getLanguage(), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"EDITVIEW", (String)"MOVENEXT"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"MOVENEXT"), "\u5b9a\u4f4d\u4e0b\u4e00\u6761\u6570\u636e"));
            tbItemNode.SetValue("HANDLER", "SA.SRFDA.Ctrl.Toolbar.FormDataNavHandler");
            tbItemNode.SetValue("NAVACTION", "NEXT");
            tbItemNode = new XMLNode();
            tbItemNode.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
            pNode.AddNode(tbItemNode);
            if (StringHelper.IsNullOrEmpty((String)context.getPageModel())) {
                tbItemNode.SetValue("ICONCSSCLASS", "x-tbar-page-last");
            }
            if (StringHelper.Compare((String)context.getPageModel(), (String)"SL", (boolean)true) == 0) {
                tbItemNode.SetValue("IMAGE", "../sasrfex/images/default/grid/icon_page-last.png");
            }
            tbItemNode.SetValue(ToolbarButtonConfig.TAG_TEXT, "");
            tbItemNode.SetValue("TIPS", this.globalHelperEx.getLocalizationHelper().GetLocalization(context.getLanguage(), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"EDITVIEW", (String)"MOVELAST"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"MOVELAST"), "\u5b9a\u4f4d\u6700\u540e\u4e00\u6761\u6570\u636e"));
            tbItemNode.SetValue("HANDLER", "SA.SRFDA.Ctrl.Toolbar.FormDataNavHandler");
            tbItemNode.SetValue("NAVACTION", "LAST");
        }
        return callResult;
    }
}

