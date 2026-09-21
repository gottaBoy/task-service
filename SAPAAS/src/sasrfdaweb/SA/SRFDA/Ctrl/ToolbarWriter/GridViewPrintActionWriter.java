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
import SA.SRFDA.Ctrl.ToolbarWriter.CommonTBWriter;
import SA.SRFDA.Ctrl.ToolbarWriter.IToolbarItemWriterContext;
import SA.SRFDA.Ctrl.ToolbarWriter.TBItemConfig;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.XML.XMLNode;

public class GridViewPrintActionWriter
extends CommonTBWriter {
    public static final String TAG_MULTIPRINT = "MULTIPRINT";

    @Override
    protected CallResult OnAfterExport(XMLNode tbNode, XMLNode pNode, XMLNode tbItemNode, TBItemConfig tbItemConfig, DEBehavior deBehavior, IToolbarItemWriterContext context, boolean bMenu) {
        CallResult callResult = super.OnAfterExport(tbNode, pNode, tbItemNode, tbItemConfig, deBehavior, context, bMenu);
        if (callResult.IsError()) {
            return callResult;
        }
        boolean bMultiPrint = this.globalHelperEx.getWebExConfig().GetValue("SRFDA", TAG_MULTIPRINT, "FALSE").equalsIgnoreCase("TRUE");
        switch (context.getDEHelper().getDataEntity().GetParamIntValue("ISMULTIPRINT", -1)) {
            case 0: {
                bMultiPrint = false;
                break;
            }
            case 1: {
                bMultiPrint = true;
                break;
            }
        }
        if (bMultiPrint) {
            tbItemNode.SetValue("ICONCSSCLASS", "sx-tb-mprint");
        }
        tbItemNode.SetValue(TAG_MULTIPRINT, String.valueOf(bMultiPrint).toUpperCase());
        return callResult;
    }
}

