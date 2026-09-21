/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.DEBehavior
 *  SA.SRFDA.Ctrl.ToolbarWriter.IToolbarItemWriterContext
 *  SA.SRFDA.Ctrl.ToolbarWriter.TBItemConfig
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.ToolBar.UI.ToolbarSplitButtonConfig
 *  SA.SRFramework.XML.XMLNode
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl.ToolbarWriter;

import SA.SRFDA.Ctrl.Data.DEBehavior;
import SA.SRFDA.Ctrl.ToolbarWriter.BaseToolbarItemWriter;
import SA.SRFDA.Ctrl.ToolbarWriter.IToolbarItemWriterContext;
import SA.SRFDA.Ctrl.ToolbarWriter.TBItemConfig;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarSplitButtonConfig;
import SA.SRFramework.XML.XMLNode;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SplitTBItemWriter
extends BaseToolbarItemWriter {
    private static final Log log = LogFactory.getLog(SplitTBItemWriter.class);

    public CallResult Export(XMLNode tbNode, XMLNode pNode, TBItemConfig tbItemConfig, DEBehavior deBehavior, IToolbarItemWriterContext context, boolean bMenu) {
        CallResult callResult = new CallResult();
        try {
            if (!bMenu) {
                XMLNode splitButtonNode = new XMLNode();
                splitButtonNode.setNodeName(ToolbarSplitButtonConfig.TAG_TOOLBARSPLITBUTTON);
                pNode.AddNode(splitButtonNode);
                splitButtonNode.SetValue(ToolbarSplitButtonConfig.TAG_TEXT, this.GetItemCaption(context, null, tbItemConfig, ""));
                splitButtonNode.SetValue("ICONCSSCLASS", this.GetItemIconCls(context, null, tbItemConfig, "sx-tb-other"));
                XMLNode mainMenuExNode = new XMLNode();
                mainMenuExNode.setNodeName("SRFEXMAINMENUEX");
                splitButtonNode.AddNode(mainMenuExNode);
                callResult.setUserObject((Object)mainMenuExNode);
            }
        }
        catch (Exception e) {
            log.error((Object)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)e.getMessage()));
            return callResult;
        }
        return callResult;
    }
}

