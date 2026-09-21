/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.DEBehavior
 *  SA.SRFDA.Ctrl.ToolbarWriter.BaseToolbarItemWriter
 *  SA.SRFDA.Ctrl.ToolbarWriter.IToolbarItemWriterContext
 *  SA.SRFDA.Ctrl.ToolbarWriter.TBItemConfig
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig
 *  SA.SRFramework.WebEx.ToolBar.UI.ToolbarSeperatorConfig
 *  SA.SRFramework.XML.XMLNode
 *  SRFWF.Client.WFGetIAActionsResult
 *  SRFWF.Model.WFInteractiveActionConfig
 *  SRFWF.Model.WFUserActionConfig
 */
package SA.SRFDA.WF.Ctrl.ToolbarWriter;

import SA.SRFDA.Ctrl.Data.DEBehavior;
import SA.SRFDA.Ctrl.ToolbarWriter.BaseToolbarItemWriter;
import SA.SRFDA.Ctrl.ToolbarWriter.IToolbarItemWriterContext;
import SA.SRFDA.Ctrl.ToolbarWriter.TBItemConfig;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarSeperatorConfig;
import SA.SRFramework.XML.XMLNode;
import SRFWF.Client.WFGetIAActionsResult;
import SRFWF.Model.WFInteractiveActionConfig;
import SRFWF.Model.WFUserActionConfig;

public class GridViewWFIAActionBarWriter
extends BaseToolbarItemWriter {
    public static final String WFACTION_RESUBMIT = "SRFWFRESUBMIT";
    public static final String WFACTION_REASSIGN = "SRFWFREASSIGN";

    public CallResult Export(XMLNode tbNode, XMLNode pNode, TBItemConfig tbItemConfig, DEBehavior deBehavior, IToolbarItemWriterContext context, boolean bMenu) {
        CallResult callResult = new CallResult();
        if (context.getWFGetIAActionsResult() == null) {
            return callResult;
        }
        String strWFStep = "";
        Object objWFStep = context.getAttribute("WFSTEP");
        if (objWFStep != null) {
            strWFStep = objWFStep.toString();
        }
        if (StringHelper.IsNullOrEmpty((String)strWFStep)) {
            return callResult;
        }
        WFGetIAActionsResult wfGetIAActionsResult = context.getWFGetIAActionsResult();
        if (!bMenu) {
            String trButtonHandler;
            XMLNode tbItemNode;
            if (wfGetIAActionsResult.getIAActionList().size() > 0) {
                for (WFInteractiveActionConfig iaActionConfig : wfGetIAActionsResult.getIAActionList()) {
                    if (!iaActionConfig.isUserVisible()) continue;
                    tbItemNode = new XMLNode();
                    tbItemNode.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
                    pNode.AddNode(tbItemNode);
                    tbItemNode.SetValue("ICONCSSCLASS", "sx-tb-commonaction");
                    tbItemNode.SetValue(ToolbarButtonConfig.TAG_TEXT, iaActionConfig.getLogicName());
                    tbItemNode.SetValue("TIPS", iaActionConfig.getLogicName());
                    tbItemNode.SetValue("WFIAACTIONLOGICNAME", iaActionConfig.getLogicName());
                    tbItemNode.SetValue("WFSTEP", strWFStep);
                    tbItemNode.SetValue("WFIAACTIONNAME", iaActionConfig.getName());
                    tbItemNode.SetValue("WFPROCESSNAME", wfGetIAActionsResult.getProcessName());
                    tbItemNode.SetValue("WFFORMNAME", iaActionConfig.getPanelId());
                    tbItemNode.SetValue("WFSUPPORTMULTI", iaActionConfig.isSupportMulti() ? "TRUE" : "FALSE");
                    trButtonHandler = "SA.SRFDA.WF.Ctrl.Toolbar.GridIAActionHandler";
                    if (!StringHelper.IsNullOrEmpty((String)iaActionConfig.getButtonActionHelper())) {
                        trButtonHandler = iaActionConfig.getButtonActionHelper();
                    }
                    tbItemNode.SetValue("HANDLER", trButtonHandler);
                    tbItemNode.SetValue("WFFAHELPER", iaActionConfig.getFAHelper());
                    tbItemNode.SetValue("WFIAPAGE", iaActionConfig.getPagePath());
                    tbItemNode.SetValue("WFIAPAGESTYLE", iaActionConfig.getPageStyle());
                }
                XMLNode tbItemNode2 = new XMLNode();
                tbItemNode2.setNodeName(ToolbarSeperatorConfig.TAG_TOOLBARSEPARATOR);
                pNode.AddNode(tbItemNode2);
            }
            if (wfGetIAActionsResult.getUserActionList().size() > 0) {
                for (WFUserActionConfig userActionConfig : wfGetIAActionsResult.getUserActionList()) {
                    tbItemNode = new XMLNode();
                    tbItemNode.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
                    pNode.AddNode(tbItemNode);
                    tbItemNode.SetValue("ICONCSSCLASS", "sx-tb-commonaction");
                    tbItemNode.SetValue(ToolbarButtonConfig.TAG_TEXT, userActionConfig.getActionLogicName());
                    tbItemNode.SetValue("TIPS", userActionConfig.getActionLogicName());
                    tbItemNode.SetValue("WFUSERACTIONLOGICNAME", userActionConfig.getActionLogicName());
                    tbItemNode.SetValue("WFSTEP", strWFStep);
                    tbItemNode.SetValue("WFUSERACTIONNAME", userActionConfig.getActionName());
                    tbItemNode.SetValue("WFPROCESSNAME", wfGetIAActionsResult.getProcessName());
                    trButtonHandler = "";
                    if (StringHelper.Compare((String)userActionConfig.getActionName(), (String)WFACTION_RESUBMIT, (boolean)true) == 0) {
                        trButtonHandler = "SA.SRFDA.WF.Ctrl.Toolbar.GridResubmitActionHandler";
                        tbItemNode.SetValue("WFRESUBMIT", "TRUE");
                    } else if (StringHelper.Compare((String)userActionConfig.getActionName(), (String)WFACTION_REASSIGN, (boolean)true) == 0) {
                        trButtonHandler = "SA.SRFDA.WF.Ctrl.Toolbar.GridResubmitActionHandler";
                        tbItemNode.SetValue("WFRESUBMIT", "FALSE");
                    } else if (!StringHelper.IsNullOrEmpty((String)userActionConfig.getButtonActionHelper())) {
                        trButtonHandler = userActionConfig.getButtonActionHelper();
                    }
                    tbItemNode.SetValue("HANDLER", trButtonHandler);
                }
            }
        }
        return callResult;
    }
}

