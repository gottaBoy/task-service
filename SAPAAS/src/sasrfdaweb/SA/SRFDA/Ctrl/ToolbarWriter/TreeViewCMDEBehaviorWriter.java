/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.DEBehavior
 *  SA.SRFDA.Ctrl.ToolbarWriter.IToolbarItemWriterContext
 *  SA.SRFDA.Ctrl.ToolbarWriter.TBItemConfig
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.XML.XMLNode
 */
package SA.SRFDA.Ctrl.ToolbarWriter;

import SA.SRFDA.Ctrl.Data.DEBehavior;
import SA.SRFDA.Ctrl.ToolbarWriter.DEBehaviorWriter;
import SA.SRFDA.Ctrl.ToolbarWriter.IToolbarItemWriterContext;
import SA.SRFDA.Ctrl.ToolbarWriter.TBItemConfig;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.XML.XMLNode;

public class TreeViewCMDEBehaviorWriter
extends DEBehaviorWriter {
    @Override
    protected CallResult FillItemUserParams(XMLNode tbItemNode, TBItemConfig tbItemConfig, DEBehavior deBehavior, IToolbarItemWriterContext context, boolean bMenu) {
        CallResult callResult = super.FillItemUserParams(tbItemNode, tbItemConfig, deBehavior, context, bMenu);
        if (callResult.IsError()) {
            return callResult;
        }
        tbItemNode.SetValue("UP_TREENODEPARAM", tbItemConfig.GetExtValue("TREENODEPARAM", ""));
        return callResult;
    }
}

