/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.ConfigPathHelper
 *  SA.SRFDA.Ctrl.Data.Page
 *  SA.SRFDA.Ctrl.Data.TBTempl
 *  SA.SRFDA.Ctrl.Data.Toolbar
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Ctrl.ToolbarWriter.IToolbarItemWriter
 *  SA.SRFDA.Ctrl.ToolbarWriter.IToolbarItemWriterContext
 *  SA.SRFDA.Ctrl.ToolbarWriter.TBItemConfig
 *  SA.SRFDA.Ctrl.ToolbarWriter.ToolbarConfig
 *  SA.SRFDA.Localization.SRFDALocalizationHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig
 *  SA.SRFramework.WebEx.ToolBar.UI.ToolbarItemsConfig
 *  SA.SRFramework.WebEx.ToolBar.UI.ToolbarSeperatorConfig
 *  SA.SRFramework.WebEx.ToolBar.UI.ToolbarSplitButtonConfig
 *  SA.SRFramework.XML.XMLNode
 *  SRFWF.Client.WFGetIAActionsResult
 *  SRFWF.Model.WFInteractiveActionConfig
 *  SRFWF.Model.WFUserActionConfig
 *  net.sf.json.JSONArray
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.ConfigPathHelper;
import SA.SRFDA.Ctrl.DAConfigHelper;
import SA.SRFDA.Ctrl.Data.Page;
import SA.SRFDA.Ctrl.Data.TBTempl;
import SA.SRFDA.Ctrl.Data.Toolbar;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Ctrl.ToolbarWriter.DefaultToolbarWriterContext;
import SA.SRFDA.Ctrl.ToolbarWriter.IToolbarItemWriter;
import SA.SRFDA.Ctrl.ToolbarWriter.IToolbarItemWriterContext;
import SA.SRFDA.Ctrl.ToolbarWriter.TBItemConfig;
import SA.SRFDA.Ctrl.ToolbarWriter.ToolbarConfig;
import SA.SRFDA.Localization.SRFDALocalizationHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarItemsConfig;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarSeperatorConfig;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarSplitButtonConfig;
import SA.SRFramework.XML.XMLNode;
import SRFWF.Client.WFGetIAActionsResult;
import SRFWF.Model.WFInteractiveActionConfig;
import SRFWF.Model.WFUserActionConfig;
import java.io.File;
import java.util.ArrayList;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DAConfigHelper_LT
extends DAConfigHelper {
    private static final Log log = LogFactory.getLog(DAConfigHelper_LT.class);

    @Override
    public String GetWFInfoViewToolbarConfigId(IDEHelper iDEHelper, Page page, String strWFState, String strWFStep, boolean bEnableSave, WFGetIAActionsResult wfGetIAActionsResult) {
        XMLNode tbItemNode;
        XMLNode tbItemNode2;
        boolean bViewWFStepData;
        String strToolbarConfigId = StringHelper.Format((String)"DE%1$s.TB_INFOFORM_%3$s_%4$s_%5$s_%6$s_%7$s_%2$s", (Object)iDEHelper.getId(), (Object)iDEHelper.getVersion(), (Object)"WF", (Object)strWFState, (Object)strWFStep, (Object)(wfGetIAActionsResult != null ? wfGetIAActionsResult.getVersion() : 0), (Object)(bEnableSave ? "1" : "0"));
        if (wfGetIAActionsResult != null && !StringHelper.IsNullOrEmpty((String)wfGetIAActionsResult.getUserTag())) {
            strToolbarConfigId = String.valueOf(strToolbarConfigId) + StringHelper.Format((String)"_%1$s", (Object)wfGetIAActionsResult.getUserTag());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
            strToolbarConfigId = String.valueOf(strToolbarConfigId) + StringHelper.Format((String)"_PM_%1$s", (Object)this.strPageModel);
        }
        if (!StringHelper.IsNullOrEmpty((String)this.strLanguage)) {
            strToolbarConfigId = String.valueOf(strToolbarConfigId) + StringHelper.Format((String)"_%1$s", (Object)this.strLanguage);
        }
        strToolbarConfigId = strToolbarConfigId.replace(":", "__");
        strToolbarConfigId = strToolbarConfigId.toUpperCase();
        String strTBFilePath = ConfigPathHelper.GetRuntimeToolbarConfigPath((String)this.globalHelperEx.GetAppRootPath(), (String)strToolbarConfigId);
        File file = new File(strTBFilePath);
        if (file.exists()) {
            return strToolbarConfigId;
        }
        DefaultToolbarWriterContext tbWriterContext = this.CreateTBWriterContext();
        tbWriterContext.setPage(page);
        tbWriterContext.setDEHelper(iDEHelper);
        tbWriterContext.setViewStyle("EDITVIEW");
        tbWriterContext.setWFGetIAActionsResult(wfGetIAActionsResult);
        XMLNode rootNode = new XMLNode();
        rootNode.setNodeName("SRFEXTOOLBAR");
        XMLNode tbItemsNode = new XMLNode();
        tbItemsNode.setNodeName(ToolbarItemsConfig.TAG_TOOLBARITEMS);
        rootNode.AddNode(tbItemsNode);
        Toolbar toolbar = null;
        if (page != null) {
            String strToolbarId = page.getTOOLBARID();
            if (!StringHelper.IsNullOrEmpty((String)strToolbarId) && (toolbar = this.globalHelperEx.getDAModelStorage().FindToolbar(strToolbarId)) == null) {
                log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5de5\u5177\u680f[%1$s]\u914d\u7f6e", (Object)strToolbarId));
                return "";
            }
            String strTBTEMPLID = "";
            if (toolbar != null) {
                strTBTEMPLID = toolbar.getTBTEMPLID();
            }
            if (StringHelper.IsNullOrEmpty((String)strTBTEMPLID)) {
                strTBTEMPLID = page.GetParamStringValue("TBTEMPLID", "");
            }
            ToolbarConfig tbConfig = null;
            if (StringHelper.IsNullOrEmpty((String)strTBTEMPLID)) {
                if (toolbar != null && toolbar.getNODEFAULT()) {
                    tbConfig = toolbar.getToolbarConfig();
                }
            } else {
                TBTempl tbTempl = this.globalHelperEx.getDAModelStorage().FindTBTempl(strTBTEMPLID);
                if (tbTempl == null) {
                    log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5de5\u5177\u680f\u6a21\u677f[%1$s]\u914d\u7f6e", (Object)strTBTEMPLID));
                    return "";
                }
                tbConfig = tbTempl.getToolbarConfig();
            }
            if (tbConfig != null) {
                tbWriterContext.setToolbar(toolbar);
                CallResult callResult = this.ExportToolbar(rootNode, tbItemsNode, tbConfig, tbWriterContext);
                if (callResult.IsError()) {
                    log.error((Object)StringHelper.Format((String)"\u5bfc\u51fa\u5de5\u5177\u680f\u53d1\u751f\u9519\u8bef,%1$s", (Object)callResult.getErrorInfo()));
                    return "";
                }
                if (!DAConfigHelper_LT.ExportConfigFile((XMLNode)rootNode, (String)strTBFilePath)) {
                    return "";
                }
                return strToolbarConfigId;
            }
        }
        XMLNode userToolbar = null;
        String strToolbarXML = "";
        userToolbar = DAConfigHelper_LT.LoadToolbarConfig(strToolbarXML, page);
        boolean bOtherAction = true;
        boolean bPrintAction = iDEHelper.IsEnablePrint();
        boolean bHelpAction = iDEHelper.IsEnableHelp();
        boolean bViewWFStepActor = this.getWFStepActorPlacement() == 1;
        boolean bl = bViewWFStepData = this.getWFStepDataPlacement() == 1;
        if (toolbar != null) {
            tbWriterContext.setToolbar(toolbar);
            if (!toolbar.isHELPACTIONNull()) {
                bHelpAction = toolbar.getHELPACTION();
            }
            if (!toolbar.isOTHERACTIONNull()) {
                bOtherAction = toolbar.getOTHERACTION();
            }
            if (!toolbar.isPRINTACTIONNull()) {
                bPrintAction = toolbar.getPRINTACTION();
            }
        } else {
            toolbar = new Toolbar();
            toolbar.setNODEFDEBHGROUP(true);
            tbWriterContext.setToolbar(toolbar);
        }
        if (userToolbar != null) {
            bHelpAction = userToolbar.GetExtValue("HELPACTION", bHelpAction);
            bPrintAction = userToolbar.GetExtValue("PRINTACTION", bPrintAction);
            bOtherAction = userToolbar.GetExtValue("OTHERACTION", bOtherAction);
            bViewWFStepActor = userToolbar.GetExtValue("VIEWWFSTEPACTOR", bViewWFStepActor);
            bViewWFStepData = userToolbar.GetExtValue("VIEWWFSTEPDATA", bViewWFStepData);
        }
        if (StringHelper.Compare((String)strWFState, (String)"WFNOTFINISH", (boolean)true) == 0) {
            boolean bSaveAsIAAction = iDEHelper.GetDEWF().GetWFParam("WFINFOPAGE.SAVEASIAACTION", false);
            if (!StringHelper.IsNullOrEmpty((String)strWFStep)) {
                if (bEnableSave || bSaveAsIAAction) {
                    tbItemNode2 = new XMLNode();
                    tbItemNode2.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
                    tbItemsNode.AddNode(tbItemNode2);
                    if (StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
                        tbItemNode2.SetValue("ICONCSSCLASS", "sx-tb-save");
                    }
                    if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) == 0) {
                        tbItemNode2.SetValue("IMAGE", "../sasrfex/images/default/icon_save.png");
                    }
                    tbItemNode2.SetValue(ToolbarButtonConfig.TAG_TEXT, this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"EDITVIEW", (String)"SAVE"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"SAVE"), "\u4fdd\u5b58"));
                    tbItemNode2.SetValue("TIPS", this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"EDITVIEW", (String)"SAVE"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"SAVE"), "\u4fdd\u5b58\u5f53\u524d\u6570\u636e"));
                    if (bSaveAsIAAction) {
                        tbItemNode2.SetValue("SAVEANDCLOSE", "TRUE");
                    }
                    tbItemNode2.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.FormSaveHandler"));
                    DAConfigHelper_LT.AddToolbarSeperator(tbItemsNode);
                }
                if (!bSaveAsIAAction && wfGetIAActionsResult.getIAActionList().size() > 0) {
                    ArrayList<JSONObject> actionList = new ArrayList<JSONObject>();
                    for (WFInteractiveActionConfig iaActionConfig : wfGetIAActionsResult.getIAActionList()) {
                        if (!iaActionConfig.isUserVisible()) continue;
                        JSONObject actionJsonObject = new JSONObject();
                        actionJsonObject.put("logicname", (Object)iaActionConfig.getLogicName());
                        actionJsonObject.put("action", (Object)iaActionConfig.getName());
                        actionList.add(actionJsonObject);
                    }
                    tbItemNode = new XMLNode();
                    tbItemNode.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
                    tbItemsNode.AddNode(tbItemNode);
                    if (StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
                        tbItemNode.SetValue("ICONCSSCLASS", "sx-tb-commonaction");
                    }
                    if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) == 0) {
                        tbItemNode.SetValue("IMAGE", "../sasrfex/images/default/icon_gear.png");
                    }
                    tbItemNode.SetValue(ToolbarButtonConfig.TAG_TEXT, "\u5904\u7406");
                    tbItemNode.SetValue("TIPS", "\u5904\u7406");
                    tbItemNode.SetValue("WFSTATE", strWFState);
                    tbItemNode.SetValue("WFSTEP", strWFStep);
                    tbItemNode.SetValue("WFIAACTIONS", JSONArray.fromArray((Object[])actionList.toArray()).toString());
                    tbItemNode.SetValue("WFPROCESSNAME", wfGetIAActionsResult.getProcessName());
                    tbItemNode.SetValue("WFENABLESAVE", bEnableSave ? "TRUE" : "FALSE");
                    tbItemNode.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.WF.Ctrl.Toolbar.FormIAActionHandler_LT"));
                    tbItemNode = new XMLNode();
                    tbItemNode.setNodeName(ToolbarSeperatorConfig.TAG_TOOLBARSEPARATOR);
                    tbItemsNode.AddNode(tbItemNode);
                }
                if (!bSaveAsIAAction && wfGetIAActionsResult.getUserActionList().size() > 0) {
                    for (WFUserActionConfig userActionConfig : wfGetIAActionsResult.getUserActionList()) {
                        if (StringHelper.Compare((String)userActionConfig.getActionName(), (String)"DEBHGROUP", (boolean)true) == 0) {
                            toolbar.setDEBHGROUPID(userActionConfig.getReserver());
                            IToolbarItemWriter group1Writer = this.FindDEBHGroupToolbarItemWriter("1");
                            if (group1Writer == null) continue;
                            TBItemConfig tbItemConfig = new TBItemConfig();
                            tbItemConfig.setSeperator("NONE");
                            group1Writer.Export(rootNode, tbItemsNode, tbItemConfig, null, (IToolbarItemWriterContext)tbWriterContext, false);
                            continue;
                        }
                        XMLNode tbItemNode3 = new XMLNode();
                        tbItemNode3.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
                        tbItemsNode.AddNode(tbItemNode3);
                        if (StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
                            tbItemNode3.SetValue("ICONCSSCLASS", "sx-tb-commonaction");
                        }
                        if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) == 0) {
                            tbItemNode3.SetValue("IMAGE", "../sasrfex/images/default/icon_gear.png");
                        }
                        tbItemNode3.SetValue(ToolbarButtonConfig.TAG_TEXT, userActionConfig.getActionLogicName());
                        tbItemNode3.SetValue("TIPS", userActionConfig.getActionLogicName());
                        tbItemNode3.SetValue("WFUSERACTIONLOGICNAME", userActionConfig.getActionLogicName());
                        tbItemNode3.SetValue("WFSTEP", strWFStep);
                        tbItemNode3.SetValue("WFUSERACTIONNAME", userActionConfig.getActionName());
                        tbItemNode3.SetValue("WFPROCESSNAME", wfGetIAActionsResult.getProcessName());
                        String trButtonHandler = "";
                        if (StringHelper.Compare((String)userActionConfig.getActionName(), (String)"SRFWFRESUBMIT", (boolean)true) == 0) {
                            trButtonHandler = "SA.SRFDA.WF.Ctrl.Toolbar.FormResubmitActionHandler";
                            tbItemNode3.SetValue("WFRESUBMIT", "TRUE");
                        } else if (StringHelper.Compare((String)userActionConfig.getActionName(), (String)"SRFWFREASSIGN", (boolean)true) == 0) {
                            trButtonHandler = "SA.SRFDA.WF.Ctrl.Toolbar.FormResubmitActionHandler";
                            tbItemNode3.SetValue("WFRESUBMIT", "FALSE");
                        } else if (!StringHelper.IsNullOrEmpty((String)userActionConfig.getButtonActionHelper())) {
                            trButtonHandler = userActionConfig.getButtonActionHelper();
                        }
                        tbItemNode3.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, trButtonHandler));
                    }
                    tbItemNode2 = new XMLNode();
                    tbItemNode2.setNodeName(ToolbarSeperatorConfig.TAG_TOOLBARSEPARATOR);
                    tbItemsNode.AddNode(tbItemNode2);
                }
            }
        }
        if (bViewWFStepActor || bViewWFStepData) {
            String strWFIAPAGE;
            Page actionPage;
            Object strTextTip;
            String strText;
            if (bViewWFStepData) {
                String strWFStepDataPageId = this.OnGetWFStepDataGridViewPage();
                tbItemNode2 = new XMLNode();
                tbItemNode2.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
                tbItemsNode.AddNode(tbItemNode2);
                if (StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
                    tbItemNode2.SetValue("ICONCSSCLASS", "sx-tb-stepdata");
                }
                if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) == 0) {
                    tbItemNode2.SetValue("IMAGE", "../sasrfex/images/default/icon_stepactor.png");
                }
                strText = this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"EDITVIEW", (String)"VIEWWFSTEPDATA"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"VIEWWFSTEPDATA"), "\u6d41\u7a0b\u5904\u7406\u6b65\u9aa4");
                strTextTip = this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"EDITVIEW", (String)"VIEWWFSTEPDATA"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"VIEWWFSTEPDATA"), "\u6d41\u7a0b\u5904\u7406\u6b65\u9aa4");
                tbItemNode2.SetValue(ToolbarButtonConfig.TAG_TEXT, strText);
                tbItemNode2.SetValue("TIPS", (String)strTextTip);
                tbItemNode2.SetValue("WFIAPAGE", strWFStepDataPageId);
                if (!StringHelper.IsNullOrEmpty((String)this.getPageModel()) && (actionPage = this.globalHelperEx.getDAModelStorage().FindPage(strWFStepDataPageId)) != null) {
                    strWFIAPAGE = actionPage.GetTotalPagePath();
                    tbItemNode2.SetValue("WFIAPAGE", strWFIAPAGE);
                    if (actionPage.getWIDTH() > 0) {
                        tbItemNode2.SetValue("WFIAPAGEWIDTH", StringHelper.Format((String)"%1$s", (Object)actionPage.getWIDTH()));
                    }
                    if (actionPage.getHEIGHT() > 0) {
                        tbItemNode2.SetValue("WFIAPAGEHEIGHT", StringHelper.Format((String)"%1$s", (Object)actionPage.getHEIGHT()));
                    }
                }
                tbItemNode2.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.WF.Ctrl.Toolbar.FormViewWFStepDataHandler"));
            }
            if (bViewWFStepActor) {
                String strWFStepActorPageId = this.OnGetWFStepActorGridViewPage();
                tbItemNode2 = new XMLNode();
                tbItemNode2.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
                tbItemsNode.AddNode(tbItemNode2);
                if (StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
                    tbItemNode2.SetValue("ICONCSSCLASS", "sx-tb-stepactor");
                }
                if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) == 0) {
                    tbItemNode2.SetValue("IMAGE", "../sasrfex/images/default/icon_stepactor.png");
                }
                strText = this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"EDITVIEW", (String)"VIEWWFSTEP"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"VIEWWFSTEP"), "\u5f53\u524d\u6d41\u7a0b\u6b65\u9aa4");
                strTextTip = this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"EDITVIEW", (String)"VIEWWFSTEP"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"VIEWWFSTEP"), "\u5f53\u524d\u6d41\u7a0b\u6b65\u9aa4");
                tbItemNode2.SetValue(ToolbarButtonConfig.TAG_TEXT, strText);
                tbItemNode2.SetValue("TIPS", (String)strTextTip);
                tbItemNode2.SetValue("WFIAPAGE", strWFStepActorPageId);
                if (!StringHelper.IsNullOrEmpty((String)this.getPageModel()) && (actionPage = this.globalHelperEx.getDAModelStorage().FindPage(strWFStepActorPageId)) != null) {
                    strWFIAPAGE = actionPage.GetTotalPagePath();
                    tbItemNode2.SetValue("WFIAPAGE", strWFIAPAGE);
                    if (actionPage.getWIDTH() > 0) {
                        tbItemNode2.SetValue("WFIAPAGEWIDTH", StringHelper.Format((String)"%1$s", (Object)actionPage.getWIDTH()));
                    }
                    if (actionPage.getHEIGHT() > 0) {
                        tbItemNode2.SetValue("WFIAPAGEHEIGHT", StringHelper.Format((String)"%1$s", (Object)actionPage.getHEIGHT()));
                    }
                }
                tbItemNode2.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.WF.Ctrl.Toolbar.FormViewWFStepActorHandler"));
            }
            DAConfigHelper_LT.AddToolbarSeperator(tbItemsNode);
        }
        if (bPrintAction) {
            XMLNode tbItemNode4 = new XMLNode();
            tbItemNode4.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
            tbItemsNode.AddNode(tbItemNode4);
            if (StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
                tbItemNode4.SetValue("ICONCSSCLASS", "sx-tb-print");
            }
            if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) == 0) {
                tbItemNode4.SetValue("IMAGE", "../sasrfex/images/default/icon_print.png");
            }
            tbItemNode4.SetValue(ToolbarButtonConfig.TAG_TEXT, this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"INFOVIEW", (String)"PRINT"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"PRINT"), "\u6253\u5370"));
            tbItemNode4.SetValue("TIPS", this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"INFOVIEW", (String)"PRINT"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"PRINT"), "\u6253\u5370\u5f53\u524d\u6570\u636e"));
            tbItemNode4.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.FormPrintHandler"));
        }
        if (bPrintAction) {
            XMLNode tbItemNode5 = new XMLNode();
            tbItemNode5.setNodeName(ToolbarSeperatorConfig.TAG_TOOLBARSEPARATOR);
            tbItemsNode.AddNode(tbItemNode5);
        }
        XMLNode userOtherAction = null;
        if (userToolbar != null && userToolbar.getChildNodes() != null) {
            boolean bAppendSeperator = false;
            for (XMLNode child : userToolbar.getChildNodes()) {
                String strID = child.getID();
                if (StringHelper.Compare((String)strID, (String)"OTHERACTION", (boolean)true) != 0) {
                    if (StringHelper.Compare((String)child.getNodeName(), (String)"SRFDATBITEM", (boolean)true) == 0) {
                        bAppendSeperator = true;
                        this.ExportTBItem(rootNode, tbItemsNode, child, false, tbWriterContext, false);
                        continue;
                    }
                    int nPos = child.GetExtValue("POS", -1);
                    if (nPos == -1) {
                        bAppendSeperator = true;
                        tbItemsNode.AddNode(child);
                        continue;
                    }
                    tbItemsNode.AddNode(nPos, child);
                    continue;
                }
                userOtherAction = child;
            }
            if (bAppendSeperator) {
                tbItemNode = new XMLNode();
                tbItemNode.setNodeName(ToolbarSeperatorConfig.TAG_TOOLBARSEPARATOR);
                tbItemsNode.AddNode(tbItemNode);
            }
        }
        if (bOtherAction) {
            XMLNode tbItemNode6 = new XMLNode();
            tbItemNode6.setNodeName(ToolbarSplitButtonConfig.TAG_TOOLBARSPLITBUTTON);
            tbItemNode6.SetValue(ToolbarButtonConfig.TAG_TEXT, this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBText((String)"EDITVIEW", (String)"OTHER"), SRFDALocalizationHelper.GetRes_TBBText((String)"*", (String)"OTHER"), "\u5176\u5b83"));
            tbItemNode6.SetValue("ICONCSSCLASS", "sx-tb-other");
            tbItemsNode.AddNode(tbItemNode6);
            XMLNode tbMenusNode = new XMLNode();
            tbMenusNode.setNodeName("SRFEXMAINMENUEX");
            tbItemNode6.AddNode(tbMenusNode);
            if (userOtherAction != null && userOtherAction.getChildNodes() != null) {
                for (XMLNode child : userOtherAction.getChildNodes()) {
                    if (StringHelper.Compare((String)child.getNodeName(), (String)"SRFDATBITEM", (boolean)true) == 0) {
                        this.ExportTBItem(rootNode, tbMenusNode, child, false, tbWriterContext, true);
                        continue;
                    }
                    tbMenusNode.AddNode(child);
                }
            }
            if (tbMenusNode.getChildNodes() == null || tbMenusNode.getChildNodes().size() == 0) {
                tbItemsNode.RemoveNode(tbItemNode6);
            } else {
                DAConfigHelper_LT.AddToolbarSeperator(tbItemsNode);
            }
        }
        if (bHelpAction) {
            XMLNode tbItemNode7 = new XMLNode();
            tbItemNode7.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
            tbItemsNode.AddNode(tbItemNode7);
            if (StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
                tbItemNode7.SetValue("ICONCSSCLASS", "sx-tb-help");
            }
            if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) == 0) {
                tbItemNode7.SetValue("IMAGE", "../sasrfex/images/default/icon_help16.png");
            }
            tbItemNode7.SetValue("TIPS", this.GetLocalization(iDEHelper, SRFDALocalizationHelper.GetRes_TBBTooltip((String)"EDITVIEW", (String)"HELP"), SRFDALocalizationHelper.GetRes_TBBTooltip((String)"*", (String)"HELP"), "\u5e2e\u52a9"));
            tbItemNode7.SetValue("HANDLER", this.GetToolbarButtonHandler(iDEHelper, "SA.SRFDA.Ctrl.Toolbar.HelpHandler"));
            tbItemNode7.SetValue("PAGETYPE", "WFINFOVIEW");
        }
        DAConfigHelper_LT.EraseToolbarUnnecessarySeperator(rootNode);
        if (!DAConfigHelper_LT.ExportConfigFile((XMLNode)rootNode, (String)strTBFilePath)) {
            return "";
        }
        return strToolbarConfigId;
    }
}

