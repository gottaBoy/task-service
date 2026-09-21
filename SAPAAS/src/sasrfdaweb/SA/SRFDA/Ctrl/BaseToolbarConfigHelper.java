/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.DEBehavior
 *  SA.SRFDA.Ctrl.ToolbarWriter.IToolbarItemWriter
 *  SA.SRFDA.Ctrl.ToolbarWriter.IToolbarItemWriterContext
 *  SA.SRFDA.Ctrl.ToolbarWriter.TBItemConfig
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.XML.XMLNode
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.DAConfigHelper;
import SA.SRFDA.Ctrl.Data.DEBehavior;
import SA.SRFDA.Ctrl.ToolbarWriter.DEBehaviorWriter;
import SA.SRFDA.Ctrl.ToolbarWriter.IToolbarItemWriter;
import SA.SRFDA.Ctrl.ToolbarWriter.IToolbarItemWriterContext;
import SA.SRFDA.Ctrl.ToolbarWriter.SeparatorTBItemWriter;
import SA.SRFDA.Ctrl.ToolbarWriter.SplitTBItemWriter;
import SA.SRFDA.Ctrl.ToolbarWriter.TBItemConfig;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.XML.XMLNode;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BaseToolbarConfigHelper {
    private static final Log log = LogFactory.getLog(DAConfigHelper.class);
    protected ISRFDAGlobalHelper iDAGlobalHelper = null;
    protected SeparatorTBItemWriter separatorTBItemWriter = new SeparatorTBItemWriter();
    protected SplitTBItemWriter splitTBItemWriter = new SplitTBItemWriter();
    protected DEBehaviorWriter deBehaviorTBItemWriter = new DEBehaviorWriter();

    public void Init(ISRFDAGlobalHelper iDAGlobalHelper) throws Exception {
        this.iDAGlobalHelper = iDAGlobalHelper;
    }

    protected ISRFDAGlobalHelper getDAGlobalHelper() {
        return this.iDAGlobalHelper;
    }

    protected void ExportTBItem(XMLNode rootNode, XMLNode tbItemsNode, TBItemConfig tbItemConfig, boolean bRoot, IToolbarItemWriterContext iToolbarItemWriterContext, boolean bMenu) throws Exception {
        if (!bRoot) {
            DEBehavior deBehavior = null;
            if (!StringHelper.IsNullOrEmpty((String)tbItemConfig.getDEBehaviorId()) && (deBehavior = this.getDAGlobalHelper().getDAModelStorage().FindDEBehavior(tbItemConfig.getDEBehaviorId())) == null) {
                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u754c\u9762\u884c\u4e3a[%1$s]", (Object)tbItemConfig.getDEBehaviorId()));
            }
            IToolbarItemWriter toolbarItemWriter = this.FindToolbarItemWriter(tbItemConfig, deBehavior);
            if (toolbarItemWriter == null) {
                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5de5\u5177\u680f\u9879\u76ee[%1$s][%2$s]\u5bf9\u5e94\u7684\u7ed8\u5236\u5668", (Object)tbItemConfig.getCaption(), (Object)tbItemConfig.getDEBehaviorId()));
            }
            CallResult callResult = toolbarItemWriter.Export(rootNode, tbItemsNode, tbItemConfig, deBehavior, iToolbarItemWriterContext, bMenu);
            if (callResult.IsError()) {
                throw new Exception(callResult.getErrorInfo());
            }
            if (callResult.getUserObject() != null) {
                tbItemsNode = (XMLNode)callResult.getUserObject();
            }
        }
        if (tbItemConfig.getItems().size() > 0) {
            for (TBItemConfig tbChildItemConfig : tbItemConfig.getItems()) {
                if (!iToolbarItemWriterContext.TestCondition(tbChildItemConfig.getVisibleCond())) continue;
                this.ExportTBItem(rootNode, tbItemsNode, tbChildItemConfig, false, iToolbarItemWriterContext, !bRoot);
            }
            if (tbItemsNode.getChildNodes() == null || tbItemsNode.getChildNodes().size() == 0) {
                if (StringHelper.Compare((String)tbItemsNode.getNodeName(), (String)"SRFEXMAINMENUEX", (boolean)true) == 0) {
                    tbItemsNode = tbItemsNode.getParentNode();
                }
                tbItemsNode.getParentNode().RemoveNode(tbItemsNode);
            }
        }
    }

    protected IToolbarItemWriter FindToolbarItemWriter(TBItemConfig tbItemConfig, DEBehavior deBehavior) throws Exception {
        if (tbItemConfig.getItems().size() > 0) {
            return this.splitTBItemWriter;
        }
        if (StringHelper.IsNullOrEmpty((String)tbItemConfig.getDEBehaviorId()) && StringHelper.Compare((String)tbItemConfig.getCaption(), (String)"-", (boolean)true) == 0) {
            return this.separatorTBItemWriter;
        }
        IToolbarItemWriter toolbarItemWriter = null;
        if (!StringHelper.IsNullOrEmpty((String)tbItemConfig.getDEBehaviorId())) {
            toolbarItemWriter = this.getDAGlobalHelper().getDAConfigMgr().getToolbarItemWriterMgr().FindToolbarItemWriter(tbItemConfig.getDEBehaviorId());
            if (toolbarItemWriter != null) {
                return toolbarItemWriter;
            }
            return this.deBehaviorTBItemWriter;
        }
        return toolbarItemWriter;
    }
}

