/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.SRFDAPage
 *  SA.SRFDA.Web.SRFDAPageEx
 *  SA.SRFramework.CodeList.CodeItemConfig
 *  SA.SRFramework.CodeList.CodeListConfig
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.SRFExControl
 *  SA.SRFramework.WebEx.SRFExIFrame
 *  SA.SRFramework.WebEx.SRFExTreePanel
 *  SA.SRFramework.WebEx.Script.TreeJSHelper
 *  SA.SRFramework.WebEx.UI.TreeNodeConfig
 */
package SA.SRFDA.BI.Web;

import SA.SRFDA.Web.SRFDAPage;
import SA.SRFDA.Web.SRFDAPageEx;
import SA.SRFramework.CodeList.CodeItemConfig;
import SA.SRFramework.CodeList.CodeListConfig;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.SRFExIFrame;
import SA.SRFramework.WebEx.SRFExTreePanel;
import SA.SRFramework.WebEx.Script.TreeJSHelper;
import SA.SRFramework.WebEx.UI.TreeNodeConfig;

public class BIDirPage
extends SRFDAPageEx {
    protected SRFExIFrame iFrame = null;
    protected SRFExTreePanel treePanel = null;

    protected boolean PreparePageEnv() {
        if (!super.PreparePageEnv()) {
            return false;
        }
        this.getWebContext().SetParamValue("SRFDEID", "DE0081");
        this.strPageDataEntityId = "DE0081";
        return this.LoadPageDataEntity();
    }

    protected void OnInitComponents() {
        super.OnInitComponents();
        this.LoadTreePanel();
        this.LoadIFrame();
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
        this.treePanel = BIDirPage.CreateTreePanel((SRFDAPage)this, (String)"treePanel", (double)200.0, (double)200.0, (String)"SRFREPORT.TV_DEFAULT");
        if (this.treePanel != null) {
            this.treePanel.getTreePanelConfig().setBorder(false);
            this.treePanel.getTreePanelConfig().setRootVisible(false);
            this.treePanel.getTreePanelConfig().setShowLine(false);
            this.OnFillTreeMenuConfig(this.treePanel);
        }
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

    public String OutputPageCaption() {
        return this.OnGetPageCaption();
    }

    protected String OnGetPageCaption() {
        return this.getPageParam("PAGE.CAPTION", "\u5168\u90e8\u62a5\u8868");
    }

    protected void OnInitBackEnd() {
        super.OnInitBackEnd();
        this.setPageParam("PAGE.TREEACTIONHELPER.PID", "REPORTFOLDER");
        this.setPageParam("PAGE.TREE.SORT.MAJOR", "REPORTNAME");
    }
}

