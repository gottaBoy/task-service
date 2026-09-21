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
import SA.SRFDA.Ctrl.ToolbarWriter.BaseToolbarItemWriter;
import SA.SRFDA.Ctrl.ToolbarWriter.IToolbarItemWriterContext;
import SA.SRFDA.Ctrl.ToolbarWriter.TBItemConfig;
import SA.SRFDA.Localization.SRFDALocalizationHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig;
import SA.SRFramework.XML.XMLNode;

public class GridViewExportXMLActionWriter
extends BaseToolbarItemWriter {
    public CallResult Export(XMLNode tbNode, XMLNode pNode, TBItemConfig tbItemConfig, DEBehavior deBehavior, IToolbarItemWriterContext context, boolean bMenu) {
        CallResult callResult = new CallResult();
        boolean bExportXMLButton = true;
        String strExportList = this.globalHelperEx.getWebExConfig().GetValue("SRFDA", "EXPORTMODEL", "");
        if (!StringHelper.IsNullOrEmpty((String)strExportList)) {
            bExportXMLButton = false;
            String[] list = strExportList.split("[|]");
            int i = 0;
            while (i < list.length) {
                if (StringHelper.Compare((String)list[i], (String)context.getDEHelper().getDataEntity().getDEGROUP(), (boolean)true) == 0) {
                    bExportXMLButton = true;
                    break;
                }
                if (StringHelper.Compare((String)list[i], (String)context.getDEHelper().getId(), (boolean)true) == 0) {
                    bExportXMLButton = true;
                    break;
                }
                ++i;
            }
        }
        if (!bExportXMLButton) {
            return callResult;
        }
        if (bMenu) {
            XMLNode tbMenuItemNode = new XMLNode();
            pNode.AddNode(tbMenuItemNode);
            tbMenuItemNode.setNodeName("SRFEXMENUITEMEX");
            tbMenuItemNode.SetValue("CAPTION", this.globalHelperEx.getLocalizationHelper().GetLocalization(context.getLanguage(), SRFDALocalizationHelper.GetRes_MenuItemCaption((String)"GRIDVIEW", (String)"EXPORTSRF"), SRFDALocalizationHelper.GetRes_MenuItemCaption((String)"*", (String)"EXPORTSRF"), "\u5bfc\u51fa\u6570\u636e\u6a21\u578b"));
            tbMenuItemNode.SetValue("HANDLER", "SA.SRFDA.Ctrl.Toolbar.GridCustomCallHandler");
            tbMenuItemNode.SetValue("CALLID", "SRFDAEXPORTXML");
            tbMenuItemNode.SetValue("CALLNAME", "\u5bfc\u51faXML\u6a21\u578b");
            tbMenuItemNode.SetValue("CALLJSCODE", "if(confirm($P.msg['10100'])){_P.frameonly=true;}");
            tbMenuItemNode.SetValue("CONFIRM", "FALSE");
        } else {
            XMLNode tbItemNode = new XMLNode();
            pNode.AddNode(tbItemNode);
            tbItemNode.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
            tbItemNode.SetValue(ToolbarButtonConfig.TAG_TEXT, this.globalHelperEx.getLocalizationHelper().GetLocalization(context.getLanguage(), SRFDALocalizationHelper.GetRes_TBBText((String)"GRIDVIEW", (String)"EXPORTSRF"), SRFDALocalizationHelper.GetRes_MenuItemCaption((String)"*", (String)"EXPORTSRF"), "\u5bfc\u51fa\u6570\u636e\u6a21\u578b"));
            tbItemNode.SetValue("TIPS", this.globalHelperEx.getLocalizationHelper().GetLocalization(context.getLanguage(), SRFDALocalizationHelper.GetRes_TBBText((String)"GRIDVIEW", (String)"EXPORTSRF"), SRFDALocalizationHelper.GetRes_MenuItemCaption((String)"*", (String)"EXPORTSRF"), "\u5bfc\u51fa\u6570\u636e\u6a21\u578b"));
            tbItemNode.SetValue("HANDLER", "SA.SRFDA.Ctrl.Toolbar.GridCustomCallHandler");
            tbItemNode.SetValue("CALLID", "SRFDAEXPORTXML");
            tbItemNode.SetValue("CALLNAME", "\u5bfc\u51faXML\u6a21\u578b");
            tbItemNode.SetValue("CALLJSCODE", "if(confirm($P.msg['10100'])){_P.frameonly=true;}");
            tbItemNode.SetValue("CONFIRM", "FALSE");
        }
        return callResult;
    }
}

