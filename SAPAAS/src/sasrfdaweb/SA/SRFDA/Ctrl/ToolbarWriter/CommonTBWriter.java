/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.DEBehavior
 *  SA.SRFDA.Ctrl.ToolbarWriter.IToolbarItemWriterContext
 *  SA.SRFDA.Ctrl.ToolbarWriter.TBItemConfig
 *  SA.SRFramework.Base.PropertyConfig
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig
 *  SA.SRFramework.XML.XMLNode
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl.ToolbarWriter;

import SA.SRFDA.Ctrl.Data.DEBehavior;
import SA.SRFDA.Ctrl.ToolbarWriter.BaseToolbarItemWriter;
import SA.SRFDA.Ctrl.ToolbarWriter.IToolbarItemWriterContext;
import SA.SRFDA.Ctrl.ToolbarWriter.TBItemConfig;
import SA.SRFramework.Base.PropertyConfig;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig;
import SA.SRFramework.XML.XMLNode;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CommonTBWriter
extends BaseToolbarItemWriter {
    private static final Log log = LogFactory.getLog(CommonTBWriter.class);

    public CallResult Export(XMLNode tbNode, XMLNode pNode, TBItemConfig tbItemConfig, DEBehavior deBehavior, IToolbarItemWriterContext context, boolean bMenu) {
        CallResult callResult = new CallResult();
        if (deBehavior == null && !StringHelper.IsNullOrEmpty((String)tbItemConfig.getDEBehaviorId()) && (deBehavior = this.globalHelperEx.getDAModelStorage().FindDEBehavior(tbItemConfig.getDEBehaviorId())) == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u754c\u9762\u884c\u4e3a[%1$s]", (Object)tbItemConfig.getDEBehaviorId()));
            return callResult;
        }
        try {
            String strObjectName = context.getDEHelper().getLogicName(context.getLanguage());
            XMLNode tbItemNode = new XMLNode();
            if (bMenu) {
                tbItemNode.setNodeName("SRFEXMENUITEMEX");
                if (StringHelper.IsNullOrEmpty((String)context.getPageModel())) {
                    tbItemNode.SetValue("ICONCLS", this.GetItemIconCls(context, deBehavior, tbItemConfig, ""));
                } else if (StringHelper.Compare((String)context.getPageModel(), (String)"SL", (boolean)true) == 0) {
                    tbItemNode.SetValue("IMAGEPATH", this.GetItemImage(context, deBehavior, tbItemConfig, ""));
                }
                if (this.toolbarWriterConfig.getPropertiesConfig() != null) {
                    for (PropertyConfig propertyConfig : this.toolbarWriterConfig.getPropertiesConfig()) {
                        tbItemNode.SetValue(propertyConfig.getID(), propertyConfig.getValue());
                    }
                }
                String strNewFormat = this.GetItemCaption(context, deBehavior, tbItemConfig, "");
                tbItemNode.SetValue("CAPTION", StringHelper.Format((String)strNewFormat, (Object)""));
                tbItemNode.SetValue("HANDLER", this.GetItemHandler(context, deBehavior, tbItemConfig));
                tbItemNode.SetValue("RESOURCEID", this.GetItemResourceId(context, deBehavior, tbItemConfig));
                pNode.AddNode(tbItemNode);
            } else {
                tbItemNode.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
                if (tbItemConfig.IsShowIcon(!context.getSimpleMode())) {
                    if (StringHelper.IsNullOrEmpty((String)context.getPageModel())) {
                        tbItemNode.SetValue("ICONCSSCLASS", this.GetItemIconCls(context, deBehavior, tbItemConfig, ""));
                    } else if (StringHelper.Compare((String)context.getPageModel(), (String)"SL", (boolean)true) == 0) {
                        tbItemNode.SetValue("IMAGE", this.GetItemImage(context, deBehavior, tbItemConfig, ""));
                    }
                }
                if (this.toolbarWriterConfig.getPropertiesConfig() != null) {
                    for (PropertyConfig propertyConfig : this.toolbarWriterConfig.getPropertiesConfig()) {
                        tbItemNode.SetValue(propertyConfig.getID(), propertyConfig.getValue());
                    }
                }
                if (tbItemConfig.IsShowShortWord(!context.getSimpleMode()) || tbItemConfig.IsShowWord(!context.getSimpleMode())) {
                    String strNewFormat = this.GetItemCaption(context, deBehavior, tbItemConfig, "");
                    tbItemNode.SetValue(ToolbarButtonConfig.TAG_TEXT, StringHelper.Format((String)strNewFormat, (Object)""));
                }
                String strNewTipFormat = this.GetItemToolTip(context, deBehavior, tbItemConfig, "");
                tbItemNode.SetValue("TIPS", StringHelper.Format((String)strNewTipFormat, (Object)strObjectName));
                tbItemNode.SetValue("HANDLER", this.GetItemHandler(context, deBehavior, tbItemConfig));
                pNode.AddNode(tbItemNode);
            }
            callResult = this.OnAfterExport(tbNode, pNode, tbItemNode, tbItemConfig, deBehavior, context, bMenu);
        }
        catch (Exception e) {
            log.error((Object)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    protected CallResult OnAfterExport(XMLNode tbNode, XMLNode pNode, XMLNode tbItemNode, TBItemConfig tbItemConfig, DEBehavior deBehavior, IToolbarItemWriterContext context, boolean bMenu) {
        return new CallResult();
    }
}

