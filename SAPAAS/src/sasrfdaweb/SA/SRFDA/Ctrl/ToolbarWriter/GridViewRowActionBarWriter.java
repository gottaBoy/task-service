/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.DEBehavior
 *  SA.SRFDA.Ctrl.ToolbarWriter.IToolbarItemWriterContext
 *  SA.SRFDA.Ctrl.ToolbarWriter.TBItemConfig
 *  SA.SRFDA.Localization.SRFDALocalizationHelper
 *  SA.SRFDA.Security.UniResHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig
 *  SA.SRFramework.XML.XMLNode
 */
package SA.SRFDA.Ctrl.ToolbarWriter;

import SA.SRFDA.Ctrl.Data.DEBehavior;
import SA.SRFDA.Ctrl.ToolbarWriter.BaseToolbarItemWriter;
import SA.SRFDA.Ctrl.ToolbarWriter.IToolbarItemWriterContext;
import SA.SRFDA.Ctrl.ToolbarWriter.TBItemConfig;
import SA.SRFDA.Localization.SRFDALocalizationHelper;
import SA.SRFDA.Security.UniResHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig;
import SA.SRFramework.XML.XMLNode;

public class GridViewRowActionBarWriter
extends BaseToolbarItemWriter {
    public CallResult Export(XMLNode tbNode, XMLNode pNode, TBItemConfig tbItemConfig, DEBehavior deBehavior, IToolbarItemWriterContext context, boolean bMenu) {
        CallResult callResult = new CallResult();
        if (!bMenu) {
            String strPageModel = context.getPageModel();
            String strLanguage = context.getLanguage();
            XMLNode tbItemNode = new XMLNode();
            tbItemNode.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
            pNode.AddNode(tbItemNode);
            if (StringHelper.IsNullOrEmpty((String)strPageModel)) {
                tbItemNode.SetValue("ICONCSSCLASS", "sx-tb-editrow");
            }
            if (StringHelper.Compare((String)strPageModel, (String)"SL", (boolean)true) == 0) {
                tbItemNode.SetValue("IMAGE", "../sasrfex/images/default/icon_rowedit.png");
            }
            tbItemNode.SetValue(ToolbarButtonConfig.TAG_TEXT, this.globalHelperEx.getLocalizationHelper().GetLocalization(strLanguage, SRFDALocalizationHelper.GetRes_TBBText((String)"GRIDVIEW", (String)"EDITROW"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"EDITROW"), "\u884c\u7f16\u8f91"));
            tbItemNode.SetValue("TIPS", this.globalHelperEx.getLocalizationHelper().GetLocalization(strLanguage, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"GRIDVIEW", (String)"EDITROW"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"EDITROW"), "\u542f\u7528\u884c\u7f16\u8f91\u80fd\u529b"));
            if (StringHelper.IsNullOrEmpty((String)strPageModel)) {
                tbItemNode.SetValue("HANDLER", "SA.SRFDA.Ctrl.Toolbar.GridRowEditableHandler");
            }
            if (StringHelper.Compare((String)strPageModel, (String)"SL", (boolean)true) == 0) {
                tbItemNode.SetValue("HANDLERTYPE", "GRIDVIEW_EDITROW");
            }
            tbItemNode.SetValue("RESOURCEID", UniResHelper.GetDEDataResId((String)context.getDEHelper().getId(), (String)"UPDATE"));
            if (context.TestCondition("NEWROWACTION")) {
                tbItemNode = new XMLNode();
                tbItemNode.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
                pNode.AddNode(tbItemNode);
                if (StringHelper.IsNullOrEmpty((String)strPageModel)) {
                    tbItemNode.SetValue("ICONCSSCLASS", "sx-tb-addrow");
                }
                if (StringHelper.Compare((String)strPageModel, (String)"SL", (boolean)true) == 0) {
                    tbItemNode.SetValue("IMAGE", "../sasrfex/images/default/icon_addrow.png");
                }
                tbItemNode.SetValue("TIPS", this.globalHelperEx.getLocalizationHelper().GetLocalization(strLanguage, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"GRIDVIEW", (String)"NEWROW"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"NEWROW"), "\u65b0\u52a0\u884c"));
                if (StringHelper.IsNullOrEmpty((String)strPageModel)) {
                    tbItemNode.SetValue("HANDLER", "SA.SRFDA.Ctrl.Toolbar.GridNewRowHandler");
                }
                if (StringHelper.Compare((String)strPageModel, (String)"SL", (boolean)true) == 0) {
                    tbItemNode.SetValue("HANDLERTYPE", "GRIDVIEW_ADDROW");
                }
                tbItemNode.SetValue("RESOURCEID", UniResHelper.GetDEDataResId((String)context.getDEHelper().getId(), (String)"CREATE"));
            }
            tbItemNode = new XMLNode();
            tbItemNode.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
            pNode.AddNode(tbItemNode);
            if (StringHelper.IsNullOrEmpty((String)strPageModel)) {
                tbItemNode.SetValue("ICONCSSCLASS", "sx-tb-saverow");
            }
            if (StringHelper.Compare((String)strPageModel, (String)"SL", (boolean)true) == 0) {
                tbItemNode.SetValue("IMAGE", "../sasrfex/images/default/icon_rowsave.png");
            }
            tbItemNode.SetValue("TIPS", this.globalHelperEx.getLocalizationHelper().GetLocalization(strLanguage, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"GRIDVIEW", (String)"SAVEROW"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"SAVEROW"), "\u4fdd\u5b58\u884c"));
            if (StringHelper.IsNullOrEmpty((String)strPageModel)) {
                tbItemNode.SetValue("HANDLER", "SA.SRFDA.Ctrl.Toolbar.GridSaveRowHandler");
            }
            if (StringHelper.Compare((String)strPageModel, (String)"SL", (boolean)true) == 0) {
                tbItemNode.SetValue("HANDLERTYPE", "GRIDVIEW_SAVEROW");
            }
            tbItemNode.SetValue("RESOURCEID", UniResHelper.GetDEDataResId((String)context.getDEHelper().getId(), (String)"UPDATE"));
        }
        return callResult;
    }
}

