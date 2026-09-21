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
 */
package SA.SRFDA.Ctrl.ToolbarWriter;

import SA.SRFDA.Ctrl.Data.DEBHGroup;
import SA.SRFDA.Ctrl.Data.DEBehavior;
import SA.SRFDA.Ctrl.ToolbarWriter.BaseToolbarItemWriter;
import SA.SRFDA.Ctrl.ToolbarWriter.DEBehaviorWriter;
import SA.SRFDA.Ctrl.ToolbarWriter.IToolbarItemWriter;
import SA.SRFDA.Ctrl.ToolbarWriter.IToolbarItemWriterContext;
import SA.SRFDA.Ctrl.ToolbarWriter.TBItemConfig;
import SA.SRFDA.Ctrl.ToolbarWriter.ToolbarItemWriterConfig;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.XML.XMLNode;

public class DEBHGroupWriter
extends BaseToolbarItemWriter {
    private String strGroupId = "";
    protected DEBehaviorWriter deBehaviorTBItemWriter = new DEBehaviorWriter();
    public static final String TAG_NODEFDEBHGROUP = "NODEFDEBHGROUP";

    @Override
    public CallResult Init(ToolbarItemWriterConfig toolbarWriterConfig, ISRFDAGlobalHelper globalHelperEx) {
        CallResult callResult = super.Init(toolbarWriterConfig, globalHelperEx);
        if (callResult.IsError()) {
            return callResult;
        }
        this.deBehaviorTBItemWriter.Init(new ToolbarItemWriterConfig(), globalHelperEx);
        this.strGroupId = toolbarWriterConfig.GetExtValue("GROUPID", "");
        return callResult;
    }

    public CallResult Export(XMLNode tbNode, XMLNode pNode, TBItemConfig tbItemConfig, DEBehavior deBehavior, IToolbarItemWriterContext context, boolean bMenu) {
        DEBHGroup deBHGroup;
        CallResult callResult = new CallResult();
        String strDEBHGroupId = context.FindDEBHGroup(this.strGroupId);
        if (StringHelper.IsNullOrEmpty((String)strDEBHGroupId)) {
            if (context.TestCondition(TAG_NODEFDEBHGROUP)) {
                return callResult;
            }
            String strTempId = "DEBHGROUP";
            if (StringHelper.Length((String)this.strGroupId) == 1) {
                strTempId = String.valueOf(strTempId) + "00";
                strTempId = String.valueOf(strTempId) + this.strGroupId;
            } else if (StringHelper.Length((String)this.strGroupId) == 2) {
                strTempId = String.valueOf(strTempId) + "0";
                strTempId = String.valueOf(strTempId) + this.strGroupId;
            } else {
                strTempId = String.valueOf(strTempId) + this.strGroupId;
            }
            strDEBHGroupId = StringHelper.Format((String)"%1$s|%2$s|%3$s", (Object)context.getDEHelper().getId(), (Object)context.getViewStyle(), (Object)strTempId);
        }
        if ((deBHGroup = context.getDAGlobalHelper().getDAModelStorage().FindDEBHGroup(strDEBHGroupId)) == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u754c\u9762\u884c\u4e3a\u5206\u7ec4[%1$s]", (Object)strDEBHGroupId));
            return callResult;
        }
        if (deBHGroup.getDEBehaviors() == null || deBHGroup.getDEBehaviors().size() == 0) {
            return callResult;
        }
        if (StringHelper.Compare((String)tbItemConfig.getSeperator(), (String)"ALL", (boolean)true) == 0 || StringHelper.Compare((String)tbItemConfig.getSeperator(), (String)"FIRST", (boolean)true) == 0) {
            DEBHGroupWriter.AddToolbarSeperator(pNode, bMenu);
        }
        for (DEBehavior childdeBehavior : deBHGroup.getDEBehaviors()) {
            IToolbarItemWriter tbItemWriter = this.FindToolbarItemWriter(childdeBehavior);
            if (tbItemWriter == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u754c\u9762\u884c\u4e3a[%1$s]\u5bf9\u5e94\u7684\u5de5\u5177\u680f\u9879\u76ee\u7ed8\u5236\u5668", (Object)childdeBehavior.getDEBEHAVIORID()));
                return callResult;
            }
            callResult = tbItemWriter.Export(tbNode, pNode, tbItemConfig, childdeBehavior, context, bMenu);
            if (!callResult.IsError()) continue;
            return callResult;
        }
        if (StringHelper.Compare((String)tbItemConfig.getSeperator(), (String)"ALL", (boolean)true) == 0 || StringHelper.Compare((String)tbItemConfig.getSeperator(), (String)"LAST", (boolean)true) == 0) {
            DEBHGroupWriter.AddToolbarSeperator(pNode, bMenu);
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

