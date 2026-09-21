/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.ConfigPathHelper
 *  SA.SRFDA.Ctrl.Data.DEBehavior
 *  SA.SRFDA.Ctrl.Data.DEMSMA
 *  SA.SRFDA.Ctrl.Data.Page
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Ctrl.IDEMainActionHelper
 *  SA.SRFDA.Ctrl.IDEMainStateHelper
 *  SA.SRFDA.Ctrl.ToolbarWriter.IToolbarItemWriter
 *  SA.SRFDA.Ctrl.ToolbarWriter.IToolbarItemWriterContext
 *  SA.SRFDA.Ctrl.ToolbarWriter.TBItemConfig
 *  SA.SRFDA.Ctrl.ToolbarWriter.ToolbarConfig
 *  SA.SRFDA.Ctrl.ToolbarWriter.ToolbarItemWriterConfig
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.ToolBar.UI.ToolbarSeperatorConfig
 *  SA.SRFramework.XML.XMLNode
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl.Config;

import SA.SRFDA.Ctrl.Config.DAConfigPublisher;
import SA.SRFDA.Ctrl.Config.IToolbarConfigPublishContext;
import SA.SRFDA.Ctrl.Config.IToolbarConfigPublisherContext;
import SA.SRFDA.Ctrl.ConfigPathHelper;
import SA.SRFDA.Ctrl.Data.DEBehavior;
import SA.SRFDA.Ctrl.Data.DEMSMA;
import SA.SRFDA.Ctrl.Data.Page;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Ctrl.IDEMainActionHelper;
import SA.SRFDA.Ctrl.IDEMainStateHelper;
import SA.SRFDA.Ctrl.ToolbarWriter.DEBehaviorWriter;
import SA.SRFDA.Ctrl.ToolbarWriter.DEMainActionWriter;
import SA.SRFDA.Ctrl.ToolbarWriter.DefaultToolbarWriterContext;
import SA.SRFDA.Ctrl.ToolbarWriter.IToolbarItemWriter;
import SA.SRFDA.Ctrl.ToolbarWriter.IToolbarItemWriterContext;
import SA.SRFDA.Ctrl.ToolbarWriter.SeparatorTBItemWriter;
import SA.SRFDA.Ctrl.ToolbarWriter.SplitTBItemWriter;
import SA.SRFDA.Ctrl.ToolbarWriter.TBItemConfig;
import SA.SRFDA.Ctrl.ToolbarWriter.ToolbarConfig;
import SA.SRFDA.Ctrl.ToolbarWriter.ToolbarItemWriterConfig;
import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarSeperatorConfig;
import SA.SRFramework.XML.XMLNode;
import java.util.Enumeration;
import java.util.Hashtable;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class ToolbarConfigPublisher
extends DAConfigPublisher<IToolbarConfigPublishContext>
implements IToolbarConfigPublisherContext {
    private static final Log log = LogFactory.getLog(ToolbarConfigPublisher.class);
    public static final String TAG_DATAACTION = "DATAACTION";
    protected SeparatorTBItemWriter separatorTBItemWriter = new SeparatorTBItemWriter();
    protected SplitTBItemWriter splitTBItemWriter = new SplitTBItemWriter();
    protected DEBehaviorWriter deBehaviorTBItemWriter = new DEBehaviorWriter();
    protected DEMainActionWriter deMainActionWriter = new DEMainActionWriter();
    private boolean bMultiPrint = false;
    protected Hashtable<String, String> exportXMLDataEntityMap = new Hashtable();
    protected Hashtable<String, String> importExcelDataEntityMap = new Hashtable();
    protected int nWFStepActorPlacement = 0;
    protected int nWFStepDataPlacement = 0;

    @Override
    protected void OnInit() throws Exception {
        String strImportList;
        super.OnInit();
        this.separatorTBItemWriter.Init(new ToolbarItemWriterConfig(), this.getDAGlobalHelper());
        this.splitTBItemWriter.Init(new ToolbarItemWriterConfig(), this.getDAGlobalHelper());
        this.deBehaviorTBItemWriter.Init(new ToolbarItemWriterConfig(), this.getDAGlobalHelper());
        this.deMainActionWriter.Init(new ToolbarItemWriterConfig(), this.getDAGlobalHelper());
        this.bMultiPrint = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFDA", "MULTIPRINT", this.bMultiPrint);
        this.nWFStepActorPlacement = this.OnGetWFStepActorPlacement();
        this.nWFStepDataPlacement = this.OnGetWFStepDataPlacement();
        String strExportList = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFDA", "EXPORTMODEL", "");
        if (!StringHelper.IsNullOrEmpty((String)strExportList)) {
            String[] list = strExportList.split("[|]");
            int i = 0;
            while (i < list.length) {
                this.exportXMLDataEntityMap.put(list[i], "");
                ++i;
            }
        }
        if (!StringHelper.IsNullOrEmpty((String)(strImportList = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFDA", "IMPORTEXCEL", "")))) {
            String[] list = strImportList.split("[|]");
            int i = 0;
            while (i < list.length) {
                this.importExcelDataEntityMap.put(list[i], "");
                ++i;
            }
        }
    }

    protected boolean getEnableExportXML(IDEHelper iDEHelper) {
        if (this.exportXMLDataEntityMap.containsKey(iDEHelper.getDataEntity().getDEGROUP())) {
            return true;
        }
        if (this.exportXMLDataEntityMap.containsKey(iDEHelper.getId())) {
            return true;
        }
        return this.exportXMLDataEntityMap.size() == 0;
    }

    protected boolean getEnableImportExcel(IDEHelper iDEHelper) {
        if (this.importExcelDataEntityMap.containsKey(iDEHelper.getDataEntity().getDEGROUP())) {
            return true;
        }
        if (this.importExcelDataEntityMap.containsKey(iDEHelper.getId())) {
            return true;
        }
        return iDEHelper.IsEnableImport();
    }

    protected boolean getEnableHelp(IDEHelper iDEHelper) {
        return iDEHelper.IsEnableHelp();
    }

    protected boolean getEnableMultiPrint(IDEHelper iDEHelper) {
        return this.bMultiPrint && iDEHelper.getDataEntity().GetParamIntValue("ISMULTIPRINT", -1) == 1;
    }

    public String GetConfigFilePath(String strConfigId) throws Exception {
        return ConfigPathHelper.GetRuntimeToolbarConfigPath((String)this.getDAGlobalHelper().GetAppRootPath(), (String)strConfigId);
    }

    protected static void EraseToolbarUnnecessarySeperator(XMLNode node) {
        if (node.getChildNodes() == null || node.getChildNodes().size() == 0) {
            return;
        }
        boolean bStop = false;
        block0: while (!bStop) {
            bStop = true;
            boolean bLastIsSeperator = false;
            int i = 0;
            while (i < node.getChildNodes().size()) {
                XMLNode childNode = (XMLNode)node.getChildNodes().get(i);
                if (StringHelper.Compare((String)childNode.getNodeName(), (String)ToolbarSeperatorConfig.TAG_TOOLBARSEPARATOR, (boolean)true) == 0 || StringHelper.Compare((String)childNode.getNodeName(), (String)"SRFEXMENUITEMEX", (boolean)true) == 0 && StringHelper.Compare((String)childNode.GetExtValue("CAPTION", ""), (String)"-", (boolean)true) == 0) {
                    if (bLastIsSeperator) {
                        bStop = false;
                        node.RemoveNode(childNode);
                        continue block0;
                    }
                    bLastIsSeperator = true;
                    if (i == node.getChildNodes().size() - 1) {
                        node.RemoveNode(childNode);
                        continue block0;
                    }
                    if (i == 0) {
                        bStop = false;
                        node.RemoveNode(childNode);
                        continue block0;
                    }
                } else {
                    bLastIsSeperator = false;
                    ToolbarConfigPublisher.EraseToolbarUnnecessarySeperator(childNode);
                }
                ++i;
            }
        }
    }

    protected static void AddToolbarSeperator(XMLNode tbItemsNode) {
        XMLNode tbItemNode = new XMLNode();
        tbItemNode.setNodeName(ToolbarSeperatorConfig.TAG_TOOLBARSEPARATOR);
        tbItemsNode.AddNode(tbItemNode);
    }

    protected static XMLNode LoadToolbarConfig(String strToolbarXML, Page page) {
        XMLNode userToolbar = null;
        if (StringHelper.IsNullOrEmpty((String)strToolbarXML)) {
            if (page != null) {
                String strPageToolbar = page.getTOOLBAR();
                String strPTToolbar = page.getPTTOOLBAR();
                if (!StringHelper.IsNullOrEmpty((String)strPTToolbar)) {
                    if (userToolbar == null) {
                        userToolbar = new XMLNode();
                    }
                    XMLNode.LoadFromXML((String)strPTToolbar, (XMLConfig)userToolbar);
                }
                if (!StringHelper.IsNullOrEmpty((String)strPageToolbar)) {
                    if (userToolbar == null) {
                        userToolbar = new XMLNode();
                    }
                    XMLNode.LoadFromXML((String)strPageToolbar, (XMLConfig)userToolbar);
                }
            }
        } else {
            userToolbar = XMLNode.LoadFromXML((String)strToolbarXML);
        }
        return userToolbar;
    }

    protected DefaultToolbarWriterContext CreateTBWriterContext() {
        DefaultToolbarWriterContext tbWriterContext = new DefaultToolbarWriterContext();
        tbWriterContext.setPageModel(this.getPageModel());
        tbWriterContext.setLanguage(this.getLanguage());
        tbWriterContext.setDAGlobalHelper(this.getDAGlobalHelper());
        return tbWriterContext;
    }

    protected CallResult ExportToolbar(XMLNode rootNode, XMLNode tbItemsNode, ToolbarConfig tbConfig, DefaultToolbarWriterContext writerContext) {
        return this.ExportTBItem(rootNode, tbItemsNode, (TBItemConfig)tbConfig, true, writerContext, false);
    }

    protected CallResult ExportTBItem(XMLNode rootNode, XMLNode tbItemsNode, XMLNode xmlNode, boolean bRoot, DefaultToolbarWriterContext writerContext, boolean bMenu) {
        TBItemConfig tbItemConfig = new TBItemConfig();
        Hashtable attrs = xmlNode.getExtAttrs();
        if (attrs != null) {
            Enumeration en = attrs.keys();
            while (en.hasMoreElements()) {
                Object objKey = en.nextElement();
                Object objValue = attrs.get(objKey);
                tbItemConfig.SetProperty(objKey.toString(), objValue.toString());
            }
        }
        return this.ExportTBItem(rootNode, tbItemsNode, tbItemConfig, bRoot, writerContext, bMenu);
    }

    protected CallResult ExportTBItem(XMLNode rootNode, XMLNode tbItemsNode, TBItemConfig tbItemConfig, boolean bRoot, DefaultToolbarWriterContext writerContext, boolean bMenu) {
        CallResult callResult = new CallResult();
        if (!bRoot) {
            DEBehavior deBehavior = null;
            if (!StringHelper.IsNullOrEmpty((String)tbItemConfig.getDEBehaviorId()) && (deBehavior = this.getDAModelStorage().FindDEBehavior(tbItemConfig.getDEBehaviorId())) == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u754c\u9762\u884c\u4e3a[%1$s]", (Object)tbItemConfig.getDEBehaviorId()));
                return callResult;
            }
            IToolbarItemWriter toolbarItemWriter = this.FindToolbarItemWriter(tbItemConfig, deBehavior);
            if (toolbarItemWriter == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5de5\u5177\u680f\u9879\u76ee[%1$s][%2$s]\u5bf9\u5e94\u7684\u7ed8\u5236\u5668", (Object)tbItemConfig.getCaption(), (Object)tbItemConfig.getDEBehaviorId()));
                log.error((Object)callResult.getErrorInfo());
                return callResult;
            }
            callResult = toolbarItemWriter.Export(rootNode, tbItemsNode, tbItemConfig, deBehavior, (IToolbarItemWriterContext)writerContext, bMenu);
            if (callResult.IsError()) {
                return callResult;
            }
            if (callResult.getUserObject() != null) {
                tbItemsNode = (XMLNode)callResult.getUserObject();
            }
        }
        if (tbItemConfig.getItems().size() > 0) {
            for (TBItemConfig tbChildItemConfig : tbItemConfig.getItems()) {
                if (!writerContext.TestCondition(tbChildItemConfig.getVisibleCond()) || !(callResult = this.ExportTBItem(rootNode, tbItemsNode, tbChildItemConfig, false, writerContext, !bRoot)).IsError()) continue;
                return callResult;
            }
            if (tbItemsNode.getChildNodes() == null || tbItemsNode.getChildNodes().size() == 0) {
                if (StringHelper.Compare((String)tbItemsNode.getNodeName(), (String)"SRFEXMAINMENUEX", (boolean)true) == 0) {
                    tbItemsNode = tbItemsNode.getParentNode();
                }
                tbItemsNode.getParentNode().RemoveNode(tbItemsNode);
            }
        }
        return callResult;
    }

    protected IToolbarItemWriter FindToolbarItemWriter(TBItemConfig tbItemConfig, DEBehavior deBehavior) {
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

    protected IToolbarItemWriter FindDEBHGroupToolbarItemWriter(String strGroupId) {
        String strTempId = "VIEW_DEBHGROUP";
        if (StringHelper.Length((String)strGroupId) == 1) {
            strTempId = String.valueOf(strTempId) + "00";
            strTempId = String.valueOf(strTempId) + strGroupId;
        } else if (StringHelper.Length((String)strGroupId) == 2) {
            strTempId = String.valueOf(strTempId) + "0";
            strTempId = String.valueOf(strTempId) + strGroupId;
        } else {
            strTempId = String.valueOf(strTempId) + strGroupId;
        }
        return this.getDAGlobalHelper().getDAConfigMgr().getToolbarItemWriterMgr().FindToolbarItemWriter(strTempId);
    }

    protected int ExportDEMainStateActions(IToolbarConfigPublishContext iDAConfigPublishContext, XMLNode tbNode, XMLNode pNode, IDEMainStateHelper iDEMainStateHelper, boolean bMenu) throws Exception {
        int nCount = 0;
        IDEHelper iDEHelper = iDEMainStateHelper.getDEHelper();
        DefaultToolbarWriterContext tbWriterContext = this.CreateTBWriterContext();
        tbWriterContext.setDEHelper(iDEHelper);
        tbWriterContext.setViewStyle(iDAConfigPublishContext.getPage().getPageType());
        tbWriterContext.setLanguage(this.getLanguage());
        tbWriterContext.setPageModel(this.getPageModel());
        Enumeration en = iDEMainStateHelper.getDEMainActions();
        while (en.hasMoreElements()) {
            DEMSMA deMSMA = (DEMSMA)en.nextElement();
            IDEMainActionHelper iDEMainActionHelper = iDEHelper.FindDEMainAction(deMSMA.getDEMAINACTIONID());
            if (StringHelper.IsNullOrEmpty((String)iDEMainActionHelper.getDEBehaviorId())) continue;
            DEBehavior deBehavior = this.getDAModelStorage().FindDEBehavior(iDEMainActionHelper.getDEBehaviorId());
            if (deBehavior == null) {
                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u754c\u9762\u884c\u4e3a[%1$s]", (Object)iDEMainActionHelper.getDEBehaviorId()));
            }
            tbWriterContext.setAttribute("DEMAINACTION", iDEMainActionHelper);
            CallResult callResult = this.deMainActionWriter.Export(tbNode, pNode, new TBItemConfig(), deBehavior, tbWriterContext, bMenu);
            if (callResult.IsError()) {
                throw new Exception(StringHelper.Format((String)"\u5bfc\u51fa\u5b9e\u4f53\u4e3b\u64cd\u4f5c\u754c\u9762\u884c\u4e3a\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            ++nCount;
        }
        return nCount;
    }

    protected String GetToolbarButtonHandler(IDEHelper iDEHelper, String strDefault) {
        return this.getDAGlobalHelper().getDAModelStorage().GetDETBBHandler(iDEHelper == null ? "*" : iDEHelper.getId(), strDefault);
    }

    protected int getWFStepActorPlacement() {
        return this.nWFStepActorPlacement;
    }

    protected int getWFStepDataPlacement() {
        return this.nWFStepDataPlacement;
    }

    protected int OnGetWFStepActorPlacement() {
        String strWFRelatedInfoPresentMode = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFDA.WF", "WFSTEPACTORPLACEMENT", "");
        if (StringHelper.Compare((String)strWFRelatedInfoPresentMode, (String)"TOOLBAR", (boolean)true) == 0) {
            return 1;
        }
        return 0;
    }

    protected int OnGetWFStepDataPlacement() {
        String strWFRelatedInfoPresentMode = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFDA.WF", "WFSTEPDATAPLACEMENT", "");
        if (StringHelper.Compare((String)strWFRelatedInfoPresentMode, (String)"TOOLBAR", (boolean)true) == 0) {
            return 1;
        }
        return 0;
    }

    protected String getWFStepActorGridViewPage() {
        return this.getDAGlobalHelper().getWebExConfig().GetValue("SRFDA.WF", "WFSTEPACTORGRIDPAGE", "PAGE_WF0006_G001");
    }

    protected String getWFStepDataGridViewPage() {
        return this.getDAGlobalHelper().getWebExConfig().GetValue("SRFDA.WF", "WFSTEPDATAGRIDPAGE", "PAGE_00010");
    }
}

