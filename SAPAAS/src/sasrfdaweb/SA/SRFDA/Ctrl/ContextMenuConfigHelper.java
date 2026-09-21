/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.ToolbarWriter.IToolbarItemWriterContext
 *  SA.SRFDA.Ctrl.ToolbarWriter.TBItemConfig
 *  SA.SRFDA.Ctrl.ToolbarWriter.ToolbarConfig
 *  SA.SRFramework.XML.XMLNode
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.BaseToolbarConfigHelper;
import SA.SRFDA.Ctrl.ToolbarWriter.IToolbarItemWriterContext;
import SA.SRFDA.Ctrl.ToolbarWriter.TBItemConfig;
import SA.SRFDA.Ctrl.ToolbarWriter.ToolbarConfig;
import SA.SRFramework.XML.XMLNode;

public class ContextMenuConfigHelper
extends BaseToolbarConfigHelper {
    public XMLNode Export(ToolbarConfig tbConfig, IToolbarItemWriterContext iToolbarItemWriterContext) throws Exception {
        XMLNode menuNode = new XMLNode();
        menuNode.setNodeName("SRFEXMENUEX");
        XMLNode mainMenuNode = new XMLNode();
        mainMenuNode.setNodeName("SRFEXMAINMENUEX");
        menuNode.AddNode(mainMenuNode);
        if (tbConfig.getItems() != null && tbConfig.getItems().size() > 0) {
            for (TBItemConfig tbChildItemConfig : tbConfig.getItems()) {
                if (!iToolbarItemWriterContext.TestCondition(tbChildItemConfig.getVisibleCond())) continue;
                this.ExportTBItem(menuNode, mainMenuNode, tbChildItemConfig, false, iToolbarItemWriterContext, true);
            }
            if (mainMenuNode.getChildNodes() == null || mainMenuNode.getChildNodes().size() == 0) {
                menuNode.RemoveNode(mainMenuNode);
            }
        }
        return menuNode;
    }
}

