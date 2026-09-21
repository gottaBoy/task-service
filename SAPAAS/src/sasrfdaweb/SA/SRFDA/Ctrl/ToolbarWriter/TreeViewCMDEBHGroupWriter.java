/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.DEBHGroup
 *  SA.SRFDA.Ctrl.Data.DEBehavior
 *  SA.SRFDA.Ctrl.ToolbarWriter.IToolbarItemWriter
 *  SA.SRFDA.Ctrl.ToolbarWriter.IToolbarItemWriterContext
 *  SA.SRFDA.Ctrl.ToolbarWriter.TBItemConfig
 *  SA.SRFDA.Ctrl.ToolbarWriter.ToolbarItemWriterConfig
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.XML.XMLNode
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl.ToolbarWriter;

import SA.SRFDA.Ctrl.Data.DEBHGroup;
import SA.SRFDA.Ctrl.Data.DEBehavior;
import SA.SRFDA.Ctrl.ToolbarWriter.BaseToolbarItemWriter;
import SA.SRFDA.Ctrl.ToolbarWriter.IToolbarItemWriter;
import SA.SRFDA.Ctrl.ToolbarWriter.IToolbarItemWriterContext;
import SA.SRFDA.Ctrl.ToolbarWriter.TBItemConfig;
import SA.SRFDA.Ctrl.ToolbarWriter.ToolbarItemWriterConfig;
import SA.SRFDA.Ctrl.ToolbarWriter.TreeViewCMDEBehaviorWriter;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.XML.XMLNode;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class TreeViewCMDEBHGroupWriter
extends BaseToolbarItemWriter {
    protected TreeViewCMDEBehaviorWriter deBehaviorTBItemWriter = new TreeViewCMDEBehaviorWriter();
    private static final Log log = LogFactory.getLog(TreeViewCMDEBHGroupWriter.class);

    @Override
    public CallResult Init(ToolbarItemWriterConfig toolbarWriterConfig, ISRFDAGlobalHelper globalHelperEx) {
        CallResult callResult = super.Init(toolbarWriterConfig, globalHelperEx);
        if (callResult.IsError()) {
            return callResult;
        }
        this.deBehaviorTBItemWriter.Init(new ToolbarItemWriterConfig(), globalHelperEx);
        return callResult;
    }

    public CallResult Export(XMLNode tbNode, XMLNode pNode, TBItemConfig tbItemConfig, DEBehavior deBehavior, IToolbarItemWriterContext context, boolean bMenu) {
        CallResult callResult = new CallResult();
        String strDEBHGroupId = tbItemConfig.GetExtValue("DEBHGROUPID", "");
        if (StringHelper.IsNullOrEmpty((String)strDEBHGroupId)) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u5b9e\u4f53\u754c\u9762\u884c\u4e3a\u5206\u7ec4"));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        DEBHGroup deBHGroup = context.getDAGlobalHelper().getDAModelStorage().FindDEBHGroup(strDEBHGroupId);
        if (deBHGroup == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u754c\u9762\u884c\u4e3a\u5206\u7ec4[%1$s]", (Object)strDEBHGroupId));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        if (deBHGroup.getDEBehaviors() == null || deBHGroup.getDEBehaviors().size() == 0) {
            return callResult;
        }
        if (StringHelper.Compare((String)tbItemConfig.getSeperator(), (String)"ALL", (boolean)true) == 0 || StringHelper.Compare((String)tbItemConfig.getSeperator(), (String)"FIRST", (boolean)true) == 0) {
            TreeViewCMDEBHGroupWriter.AddToolbarSeperator(pNode, bMenu);
        }
        for (DEBehavior childdeBehavior : deBHGroup.getDEBehaviors()) {
            IToolbarItemWriter tbItemWriter = this.FindToolbarItemWriter(childdeBehavior);
            if (tbItemWriter == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u754c\u9762\u884c\u4e3a[%1$s]\u5bf9\u5e94\u7684\u5de5\u5177\u680f\u9879\u76ee\u7ed8\u5236\u5668", (Object)childdeBehavior.getDEBEHAVIORID()));
                log.error((Object)callResult.getErrorInfo());
                return callResult;
            }
            callResult = tbItemWriter.Export(tbNode, pNode, tbItemConfig, childdeBehavior, context, bMenu);
            if (!callResult.IsError()) continue;
            return callResult;
        }
        if (StringHelper.Compare((String)tbItemConfig.getSeperator(), (String)"ALL", (boolean)true) == 0 || StringHelper.Compare((String)tbItemConfig.getSeperator(), (String)"LAST", (boolean)true) == 0) {
            TreeViewCMDEBHGroupWriter.AddToolbarSeperator(pNode, bMenu);
        }
        return callResult;
    }

    protected IToolbarItemWriter FindToolbarItemWriter(DEBehavior deBehavior) {
        IToolbarItemWriter toolbarItemWriter = null;
        toolbarItemWriter = this.globalHelperEx.getDAConfigMgr().getToolbarItemWriterMgr().FindToolbarItemWriter(deBehavior.getDEBEHAVIORID());
        if (toolbarItemWriter != null) {
            return toolbarItemWriter;
        }
        return this.deBehaviorTBItemWriter;
    }
}

