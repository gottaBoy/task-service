/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.DEBehavior
 *  SA.SRFDA.Ctrl.ToolbarWriter.IToolbarItemWriterContext
 *  SA.SRFDA.Ctrl.ToolbarWriter.TBItemConfig
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.ToolBar.UI.ToolbarSeperatorConfig
 *  SA.SRFramework.XML.XMLNode
 */
package SA.SRFDA.Ctrl.ToolbarWriter;

import SA.SRFDA.Ctrl.Data.DEBehavior;
import SA.SRFDA.Ctrl.ToolbarWriter.BaseToolbarItemWriter;
import SA.SRFDA.Ctrl.ToolbarWriter.IToolbarItemWriterContext;
import SA.SRFDA.Ctrl.ToolbarWriter.TBItemConfig;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarSeperatorConfig;
import SA.SRFramework.XML.XMLNode;

public class SeparatorTBItemWriter
extends BaseToolbarItemWriter {
    public CallResult Export(XMLNode tbNode, XMLNode pNode, TBItemConfig tbItemConfig, DEBehavior deBehavior, IToolbarItemWriterContext context, boolean bMenu) {
        CallResult callResult = new CallResult();
        if (pNode.getChildNodes() == null || pNode.getChildNodes().size() == 0) {
            return callResult;
        }
        if (!bMenu) {
            XMLNode xmlNode;
            if (pNode.getChildNodes() != null && pNode.getChildNodes().size() > 0 && StringHelper.Compare((String)(xmlNode = (XMLNode)pNode.getChildNodes().get(pNode.getChildNodes().size() - 1)).getNodeName(), (String)ToolbarSeperatorConfig.TAG_TOOLBARSEPARATOR, (boolean)true) == 0) {
                return callResult;
            }
            XMLNode seperatorButtonNode = new XMLNode();
            seperatorButtonNode.setNodeName(ToolbarSeperatorConfig.TAG_TOOLBARSEPARATOR);
            pNode.AddNode(seperatorButtonNode);
        }
        return callResult;
    }
}

