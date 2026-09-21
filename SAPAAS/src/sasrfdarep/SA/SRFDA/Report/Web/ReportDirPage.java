/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Default.BaseMainPage
 *  SA.SRFDA.Web.SRFDAPage
 *  SA.SRFDA.Web.ViewModel.PageModel
 *  SA.SRFramework.CodeList.CodeItemConfig
 *  SA.SRFramework.CodeList.CodeListConfig
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.SRFExControl
 *  SA.SRFramework.WebEx.SRFExIFrame
 *  SA.SRFramework.WebEx.SRFExTreePanel
 *  SA.SRFramework.WebEx.Script.TreeJSHelper
 *  SA.SRFramework.WebEx.UI.TreeNodeConfig
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.Report.Web;

import SA.SRFDA.Report.Ctrl.Tree.ReportTreeActionHelper;
import SA.SRFDA.Report.Web.ViewModel.ReportDirViewModel;
import SA.SRFDA.Web.Default.BaseMainPage;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFDA.Web.ViewModel.PageModel;
import SA.SRFramework.CodeList.CodeItemConfig;
import SA.SRFramework.CodeList.CodeListConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.SRFExIFrame;
import SA.SRFramework.WebEx.SRFExTreePanel;
import SA.SRFramework.WebEx.Script.TreeJSHelper;
import SA.SRFramework.WebEx.UI.TreeNodeConfig;
import net.sf.json.JSONObject;

public class ReportDirPage
extends BaseMainPage {
    protected SRFExIFrame iFrame = null;
    protected SRFExTreePanel treePanel = null;
    protected ReportDirViewModel reportViewModel = null;

    protected boolean PreparePageEnv() {
        if (!super.PreparePageEnv()) {
            return false;
        }
        this.getWebContext().SetParamValue("SRFDEID", "DE0081");
        this.strPageDataEntityId = "DE0081";
        return this.LoadPageDataEntity();
    }

    protected PageModel CreatePageModel() {
        return new ReportDirViewModel();
    }

    protected void PreparePageModel() {
        super.PreparePageModel();
        this.reportViewModel = (ReportDirViewModel)this.pageModel;
    }

    protected boolean OnFillPageModel(JSONObject jsonObject) {
        return super.OnFillPageModel(jsonObject);
    }

    protected void OnInitComponents() {
        super.OnInitComponents();
        this.LoadTreePanel();
        this.LoadIFrame();
        if (this.reportViewModel != null) {
            this.reportViewModel.getTreePanelModel().setDefaultLevel(this.OnGetTreeShowNodeLevel());
            this.reportViewModel.setLeftDockWidth(this.OnGetTreeDockWidth());
        }
    }

    protected void LoadCtrlInfo() {
        if (this.reportViewModel != null) {
            String strLeftWidth = this.webContext.GetParamValue("LEFTDOCKWIDTH");
            if (StringHelper.IsNullOrEmpty((String)strLeftWidth)) {
                strLeftWidth = this.getPageParam("LEFTDOCKWIDTH", "180");
            }
            this.reportViewModel.setLeftDockWidth(this.OnGetTreeDockWidth());
        }
    }

    protected void OnInit() {
        super.OnInit();
        StringBuilderEx script = new StringBuilderEx();
        script.Append("var node=$P.tree['%1$s'].getSelectionModel().getSelectedNode();if(node==null)return;\r\n", (Object)this.treePanel.getUniqueID());
        script.Append("if(node == $P.tree['%1$s'].getRootNode()) return;\r\n", (Object)this.treePanel.getUniqueID());
        script.Append("if(node.parentNode == $P.tree['%1$s'].getRootNode()) return;\r\n", (Object)this.treePanel.getUniqueID());
        script.Append("Ext.getDom('%1$s').src='../srfreport/reportframeview.jsp?REPORTID='+node.id;", (Object)this.iFrame.getUniqueID());
        this.RegisterOnReadyScript(3, TreeJSHelper.getOnSelectionchangeEventScript((String)this.treePanel.getUniqueID(), (String)script.toString()));
    }

    protected void LoadTreePanel() {
        this.treePanel = ReportDirPage.CreateTreePanel((SRFDAPage)this, (String)"treePanel", (double)200.0, (double)200.0, (String)"SRFREPORT.TV_DEFAULT");
        if (this.treePanel != null) {
            this.treePanel.getTreePanelConfig().setBorder(false);
            this.treePanel.getTreePanelConfig().setRootVisible(false);
            this.treePanel.getTreePanelConfig().setShowLine(false);
            this.OnFillTreeMenuConfig(this.treePanel);
            if (this.reportViewModel != null) {
                this.reportViewModel.getTreePanelModel().setShowRoot(this.treePanel.getTreePanelConfig().isRootVisible());
                this.reportViewModel.getTreePanelModel().setCtrlId("treePanel");
                this.reportViewModel.getTreePanelModel().setRemoteCtrlId(this.treePanel.getUniqueID());
                this.reportViewModel.getTreePanelModel().setConfigId("SRFDEFAULT.TV_DEFAULT");
                this.reportViewModel.getTreePanelModel().setCodeListId("CODELIST_00012");
                this.reportViewModel.getTreePanelModel().setMultiSelect(false);
                this.reportViewModel.getTreePanelModel().setRootNodeText(this.OutputPageCaption());
                this.reportViewModel.getTreePanelModel().setDefaultLevel(this.OnGetTreeShowNodeLevel());
            }
        }
    }

    protected int OnGetTreeShowNodeLevel() {
        String strDefaultLevel = this.webContext.GetParamValue("DEFAULTLEVEL");
        if (!StringHelper.IsNullOrEmpty((String)strDefaultLevel)) {
            int nLevel = 0;
            try {
                nLevel = Integer.parseInt(strDefaultLevel);
            }
            catch (Exception exception) {
                // empty catch block
            }
            return nLevel;
        }
        return this.getPageParam("PAGE.TREE.DEFAULTLEVEL", 0);
    }

    protected int OnGetTreeDockWidth() {
        String strLeftWidth = this.webContext.GetParamValue("LEFTDOCKWIDTH");
        if (!StringHelper.IsNullOrEmpty((String)strLeftWidth)) {
            int nLeftWidth = 0;
            try {
                nLeftWidth = Integer.parseInt(strLeftWidth);
            }
            catch (Exception exception) {
                // empty catch block
            }
            return nLeftWidth;
        }
        return this.getPageParam("PAGE.TREE.LEFTDOCKWIDTH", 0);
    }

    protected void OnFillTreeMenuConfig(SRFExTreePanel treePanel) {
        TreeNodeConfig rootNodeConfig = treePanel.getTreePanelConfig().getRootNodeConfig();
        CodeListConfig reportFolderCodeList = this.getWebContext().getCodeListMgr().GetCodeListConfig("CODELIST_00012", this.getLanguage());
        if (reportFolderCodeList == null) {
            this.PageLog((Object)this, 1, "\u65e0\u6cd5\u83b7\u53d6\u62a5\u8868\u76ee\u5f55\u4ee3\u7801\u8868");
            return;
        }
        if (reportFolderCodeList.getCodeItems() == null) {
            return;
        }
        int nItemCount = reportFolderCodeList.getCodeItems().size();
        int i = 0;
        while (i < nItemCount) {
            CodeItemConfig codeItemConfig = (CodeItemConfig)reportFolderCodeList.getCodeItems().get(i);
            TreeNodeConfig treeNodeConfig = new TreeNodeConfig();
            treeNodeConfig.setText(codeItemConfig.getText());
            treeNodeConfig.setID(codeItemConfig.getValue());
            treeNodeConfig.setAsyncMode(true);
            treeNodeConfig.setExpand(true);
            treeNodeConfig.setLeaf(false);
            rootNodeConfig.AddChildNode(treeNodeConfig);
            ++i;
        }
    }

    protected void LoadIFrame() {
        if (this.iFrame != null) {
            return;
        }
        this.iFrame = new SRFExIFrame();
        this.iFrame.InitConfig();
        this.iFrame.setID("iframe");
        this.iFrame.getIFrameConfig().setWidth(0);
        this.iFrame.getIFrameConfig().setHeight(0);
        this.iFrame.getIFrameConfig().setScroll("no");
        this.AddControl((SRFExControl)this.iFrame);
    }

    protected String OnGetPageCaption() {
        return this.getPageParam("PAGE.CAPTION", "\u5168\u90e8\u62a5\u8868");
    }

    protected void OnInitBackEnd() {
        super.OnInitBackEnd();
        this.setPageParam("PAGE.TREEACTIONHELPER.PID", "REPORTFOLDER");
        this.setPageParam("PAGE.TREE.SORT.MAJOR", "REPORTNAME");
        this.RegisterTreeActionHelper(this.treePanel.getUniqueID(), ReportTreeActionHelper.class.getName());
    }
}

