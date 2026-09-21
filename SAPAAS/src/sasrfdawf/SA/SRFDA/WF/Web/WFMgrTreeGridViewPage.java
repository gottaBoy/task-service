/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDAConfigHelper
 *  SA.SRFDA.Ctrl.ConfigPathHelper
 *  SA.SRFDA.Ctrl.Data.Page
 *  SA.SRFDA.Web.ViewModel.PageModel
 *  SA.SRFramework.CodeList.CodeItemConfig
 *  SA.SRFramework.CodeList.CodeListConfig
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.SRFExTreePanel
 *  SA.SRFramework.WebEx.UI.TabViewConfig
 *  SA.SRFramework.WebEx.UI.TabViewPageConfig
 *  SA.SRFramework.WebEx.UI.TreeNodeConfig
 *  SA.SRFramework.WebEx.Utility.URLHelper
 *  SA.SRFramework.XML.XMLNode
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.WF.Web;

import SA.SRFDA.Ctrl.BaseDAConfigHelper;
import SA.SRFDA.Ctrl.ConfigPathHelper;
import SA.SRFDA.Ctrl.Data.Page;
import SA.SRFDA.WF.Web.ViewModel.WFTreeGridViewModel;
import SA.SRFDA.WF.Web.WFBaseTreeGridViewPage;
import SA.SRFDA.Web.ViewModel.PageModel;
import SA.SRFramework.CodeList.CodeItemConfig;
import SA.SRFramework.CodeList.CodeListConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.SRFExTreePanel;
import SA.SRFramework.WebEx.UI.TabViewConfig;
import SA.SRFramework.WebEx.UI.TabViewPageConfig;
import SA.SRFramework.WebEx.UI.TreeNodeConfig;
import SA.SRFramework.WebEx.Utility.URLHelper;
import SA.SRFramework.XML.XMLNode;
import java.io.File;
import java.net.URLEncoder;
import net.sf.json.JSONObject;

public class WFMgrTreeGridViewPage
extends WFBaseTreeGridViewPage {
    protected CodeListConfig wfStateCodeListConfig = null;
    protected WFTreeGridViewModel wfTreeGridViewModel = null;

    @Override
    protected boolean PreparePageEnv() {
        if (!super.PreparePageEnv()) {
            return false;
        }
        this.strActiveWFFolder = "PROCESSING";
        return true;
    }

    protected PageModel CreatePageModel() {
        return new WFTreeGridViewModel();
    }

    @Override
    protected void PreparePageModel() {
        super.PreparePageModel();
        this.wfTreeGridViewModel = (WFTreeGridViewModel)this.pageModel;
    }

    @Override
    protected boolean OnLoadWFConfig() {
        if (!super.OnLoadWFConfig()) {
            return false;
        }
        this.wfStateCodeListConfig = this.getWebContext().getCodeListMgr().GetCodeListConfig("SRFWF.CODELIST_WFSTATE2", this.getLanguage());
        if (this.wfStateCodeListConfig == null) {
            this.PageLog((Object)this, 1, "\u65e0\u6cd5\u83b7\u53d6\u5de5\u4f5c\u6d41\u5b9e\u4f8b\u72b6\u6001\u4ee3\u7801\u8868");
            return false;
        }
        return true;
    }

    @Override
    protected void OnFillTreeMenuConfig(SRFExTreePanel treePanel) {
        TreeNodeConfig rootNodeConfig = treePanel.getTreePanelConfig().getRootNodeConfig();
        TreeNodeConfig treeNodeConfig = new TreeNodeConfig();
        treeNodeConfig.setText(StringHelper.Format((String)"%1$s[\u5168\u90e8\u6d41\u7a0b\u4e2d]", (Object)this.GetWFDataName()));
        treeNodeConfig.setID("PROCESSING");
        rootNodeConfig.AddChildNode(treeNodeConfig);
        int j = 0;
        while (j < this.wfStateCodeListConfig.getCodeItems().size()) {
            CodeItemConfig wfStateCodeItemConfig = (CodeItemConfig)this.wfStateCodeListConfig.getCodeItems().get(j);
            TreeNodeConfig wfStepTreeNodeConfig = new TreeNodeConfig();
            wfStepTreeNodeConfig.setText(wfStateCodeItemConfig.getText());
            wfStepTreeNodeConfig.setID(StringHelper.Format((String)"%1$s:%2$s", (Object)"PROCESSING", (Object)wfStateCodeItemConfig.getValue()));
            if (!StringHelper.IsNullOrEmpty((String)wfStateCodeItemConfig.getIcon())) {
                wfStepTreeNodeConfig.setIcon(wfStateCodeItemConfig.getIcon());
            }
            treeNodeConfig.AddChildNode(wfStepTreeNodeConfig);
            ++j;
        }
        treeNodeConfig.setExpand(true);
    }

    protected void OnFillTreeMenuModel(XMLNode rootNode) {
        XMLNode processNode = new XMLNode();
        processNode.setNodeName("SRFEXTREENODE");
        processNode.SetValue("TEXT", StringHelper.Format((String)"%1$s[\u5168\u90e8\u6d41\u7a0b\u4e2d]", (Object)this.GetWFDataName()));
        processNode.setID("PROCESSING");
        rootNode.AddNode(processNode);
        processNode.SetValue("EXPAND", "TRUE");
        int j = 0;
        while (j < this.wfStateCodeListConfig.getCodeItems().size()) {
            CodeItemConfig wfStateCodeItemConfig = (CodeItemConfig)this.wfStateCodeListConfig.getCodeItems().get(j);
            XMLNode wfStepTreeNodeConfig = new XMLNode();
            wfStepTreeNodeConfig.setNodeName("SRFEXTREENODE");
            wfStepTreeNodeConfig.SetValue("TEXT", wfStateCodeItemConfig.getText());
            wfStepTreeNodeConfig.setID(StringHelper.Format((String)"%1$s:%2$s", (Object)"PROCESSING", (Object)wfStateCodeItemConfig.getValue()));
            if (!StringHelper.IsNullOrEmpty((String)wfStateCodeItemConfig.getIcon())) {
                wfStepTreeNodeConfig.SetValue("ICON", wfStateCodeItemConfig.getIcon());
            }
            processNode.AddNode(wfStepTreeNodeConfig);
            ++j;
        }
    }

    @Override
    protected void OnFillTabViewConfig(TabViewConfig tabViewConfig) {
        try {
            String strIfGridViewPath = "../srfpage/ifgridview2.jsp?REALURL=%1$s";
            TabViewPageConfig tvpConfig = new TabViewPageConfig();
            tvpConfig.setID("PROCESSING");
            tvpConfig.setResourceId("NONE");
            String strPagePath = this.GetSectorPagePath("PROCESSING");
            if (!StringHelper.IsNullOrEmpty((String)strPagePath)) {
                strPagePath = URLHelper.AppendURLSeperator((String)strPagePath);
                strPagePath = String.valueOf(strPagePath) + StringHelper.Format((String)"SRFDEID=%1$s&SRFCAPTION=%2$s&SRFWFDATAGROUP=%3$s", (Object)this.getPageDataEntityId(), (Object)URLEncoder.encode("\u5168\u90e8\u6d41\u7a0b\u4e2d", "UTF-8"), (Object)"PROCESSING");
                tvpConfig.setRemoteURL(StringHelper.Format((String)strIfGridViewPath, (Object)URLEncoder.encode(strPagePath, "UTF-8")));
                tabViewConfig.AddTabPage(tvpConfig);
            }
            int i = 0;
            while (i < this.wfStateCodeListConfig.getCodeItems().size()) {
                CodeItemConfig codeItemConfig = (CodeItemConfig)this.wfStateCodeListConfig.getCodeItems().get(i);
                TabViewPageConfig statetvpConfig = new TabViewPageConfig();
                statetvpConfig.setID(StringHelper.Format((String)"%1$s:%2$s", (Object)"PROCESSING", (Object)codeItemConfig.getValue()));
                statetvpConfig.setResourceId("NONE");
                strPagePath = this.GetSectorPagePath("PROCESSING", codeItemConfig.getValue());
                if (!StringHelper.IsNullOrEmpty((String)strPagePath)) {
                    strPagePath = URLHelper.AppendURLSeperator((String)strPagePath);
                    strPagePath = String.valueOf(strPagePath) + StringHelper.Format((String)"SRFDEID=%1$s&SRFCAPTION=%2$s&SRFWFSTATE=%3$s&SRFWFDATAGROUP=%4$s", (Object)this.getPageDataEntityId(), (Object)URLEncoder.encode(codeItemConfig.getText(), "UTF-8"), (Object)codeItemConfig.getValue(), (Object)"PROCESSING");
                    statetvpConfig.setRemoteURL(StringHelper.Format((String)strIfGridViewPath, (Object)URLEncoder.encode(strPagePath, "UTF-8")));
                    tabViewConfig.AddTabPage(statetvpConfig);
                }
                ++i;
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    protected void OnFillTabViewModel(XMLNode tabViewConfig) {
        try {
            String strIfGridViewPath = "../srfpage/ifgridview2.jsp?REALURL=%1$s";
            XMLNode tvpConfig = new XMLNode();
            tvpConfig.setNodeName("SRFEXTABVIEWPAGE");
            tvpConfig.setID("PROCESSING");
            tvpConfig.SetValue("RESOURCEID", "NONE");
            String strPagePath = this.GetSectorPagePath("PROCESSING");
            if (!StringHelper.IsNullOrEmpty((String)strPagePath)) {
                strPagePath = URLHelper.AppendURLSeperator((String)strPagePath);
                strPagePath = String.valueOf(strPagePath) + StringHelper.Format((String)"SRFDEID=%1$s&SRFCAPTION=%2$s&SRFWFDATAGROUP=%3$s", (Object)this.getPageDataEntityId(), (Object)URLEncoder.encode("\u5168\u90e8\u6d41\u7a0b\u4e2d", "UTF-8"), (Object)"PROCESSING");
                tvpConfig.SetValue("REMOTEURL", StringHelper.Format((String)strIfGridViewPath, (Object)URLEncoder.encode(strPagePath, "UTF-8")));
                tabViewConfig.AddNode(tvpConfig);
            }
            int i = 0;
            while (i < this.wfStateCodeListConfig.getCodeItems().size()) {
                CodeItemConfig codeItemConfig = (CodeItemConfig)this.wfStateCodeListConfig.getCodeItems().get(i);
                XMLNode statetvpConfig = new XMLNode();
                statetvpConfig.setNodeName("SRFEXTABVIEWPAGE");
                statetvpConfig.setID(StringHelper.Format((String)"%1$s:%2$s", (Object)"PROCESSING", (Object)codeItemConfig.getValue()));
                statetvpConfig.SetValue("REMOTEURL", "NONE");
                strPagePath = this.GetSectorPagePath("PROCESSING", codeItemConfig.getValue());
                if (!StringHelper.IsNullOrEmpty((String)strPagePath)) {
                    strPagePath = URLHelper.AppendURLSeperator((String)strPagePath);
                    strPagePath = String.valueOf(strPagePath) + StringHelper.Format((String)"SRFDEID=%1$s&SRFCAPTION=%2$s&SRFWFSTATE=%3$s&SRFWFDATAGROUP=%4$s", (Object)this.getPageDataEntityId(), (Object)URLEncoder.encode(codeItemConfig.getText(), "UTF-8"), (Object)codeItemConfig.getValue(), (Object)"PROCESSING");
                    statetvpConfig.SetValue("REMOTEURL", StringHelper.Format((String)strIfGridViewPath, (Object)URLEncoder.encode(strPagePath, "UTF-8")));
                    tabViewConfig.AddNode(statetvpConfig);
                }
                ++i;
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String GetWFDataName() {
        return this.pageDataEntity.getDELOGICNAME();
    }

    protected String GetSectorPagePath(String strGroup) {
        String strPageId = this.getPageParam(StringHelper.Format((String)"%1$s.%2$s", (Object)"PAGE.SECTOR.PAGE", (Object)strGroup), "");
        if (!StringHelper.IsNullOrEmpty((String)strPageId)) {
            Page page = this.getDAModelStorage().FindPage(strPageId);
            if (page == null) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u9875\u9762\u5bf9\u8c61[%1$s]\u5931\u8d25", (Object)strPageId));
                return "";
            }
            return page.GetTotalPagePath();
        }
        return "../srfwf/wfgridview.jsp";
    }

    protected String GetSectorPagePath(String strGroup, String strState) {
        String strPageId = this.getPageParam(StringHelper.Format((String)"%1$s.%2$s:%3$s", (Object)"PAGE.SECTOR.PAGE", (Object)strGroup, (Object)strState), "");
        if (!StringHelper.IsNullOrEmpty((String)strPageId)) {
            Page page = this.getDAModelStorage().FindPage(strPageId);
            if (page == null) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u9875\u9762\u5bf9\u8c61[%1$s]\u5931\u8d25", (Object)strPageId));
                return "";
            }
            return page.GetTotalPagePath();
        }
        return "../srfwf/wfgridview.jsp";
    }

    @Override
    protected boolean OnFillPageModel(JSONObject jsonObject) {
        if (!super.OnFillPageModel(jsonObject)) {
            return false;
        }
        String strTreeViewConfigId = StringHelper.Format((String)"%1$s.WFMGRTREEVIEW_%2$s", (Object)this.getDEHelper().getId(), (Object)this.getDEHelper().getVersion());
        if (!StringHelper.IsNullOrEmpty((String)this.getLanguage())) {
            strTreeViewConfigId = String.valueOf(strTreeViewConfigId) + StringHelper.Format((String)"_%1$s", (Object)this.getLanguage());
        }
        strTreeViewConfigId = strTreeViewConfigId.toUpperCase();
        String strTreeViewFilePath = ConfigPathHelper.GetRuntimeTreeViewConfigPath((String)this.getWebContext().getGlobalHelper().GetAppRootPath(), (String)strTreeViewConfigId);
        File file = new File(strTreeViewFilePath);
        if (!file.exists()) {
            XMLNode treeNode = new XMLNode();
            treeNode.setNodeName("SRFEXTREEPANEL");
            treeNode.SetValue("ROOTVISIBLE", "FALSE");
            XMLNode rootNode = new XMLNode();
            rootNode.setNodeName("SRFEXTREENODE");
            treeNode.SetValue("EXPAND", "TRUE");
            treeNode.AddNode(rootNode);
            this.OnFillTreeMenuModel(rootNode);
            if (!BaseDAConfigHelper.ExportConfigFile((XMLNode)treeNode, (String)strTreeViewFilePath)) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u5bfc\u51fa\u5de5\u4f5c\u6d41\u7ba1\u7406\u6811\u83dc\u5355\u914d\u7f6e\u5931\u8d25"));
            }
        }
        this.wfTreeGridViewModel.getTreePanelModel().setConfigId(strTreeViewConfigId);
        String strTabViewConfigId = StringHelper.Format((String)"%1$s.WFMGRTABVIEW_%2$s", (Object)this.getDEHelper().getId(), (Object)this.getDEHelper().getVersion());
        if (!StringHelper.IsNullOrEmpty((String)this.getLanguage())) {
            strTabViewConfigId = String.valueOf(strTabViewConfigId) + StringHelper.Format((String)"_%1$s", (Object)this.getLanguage());
        }
        strTabViewConfigId = strTabViewConfigId.toUpperCase();
        String strTabViewFilePath = ConfigPathHelper.GetRuntimeTVConfigPath((String)this.getWebContext().getGlobalHelper().GetAppRootPath(), (String)strTabViewConfigId);
        File file2 = new File(strTabViewFilePath);
        if (!file2.exists()) {
            XMLNode tabViewNode = new XMLNode();
            tabViewNode.setNodeName("SRFEXTABVIEW");
            this.OnFillTabViewModel(tabViewNode);
            if (!BaseDAConfigHelper.ExportConfigFile((XMLNode)tabViewNode, (String)strTabViewFilePath)) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u5bfc\u51fa\u5de5\u4f5c\u6d41\u7ba1\u7406\u5206\u9875\u89c6\u56fe\u914d\u7f6e\u5931\u8d25"));
            }
        }
        this.wfTreeGridViewModel.getTabViewModel().setConfigId(strTabViewConfigId);
        this.wfTreeGridViewModel.setWFId(this.dewf.getWFID());
        return true;
    }
}

