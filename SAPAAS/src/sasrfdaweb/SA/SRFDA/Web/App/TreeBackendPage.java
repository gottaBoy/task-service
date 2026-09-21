/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.TreeView
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.SRFDAWebCTXHelper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.SRFExTreePanel
 */
package SA.SRFDA.Web.App;

import SA.SRFDA.Ctrl.Data.TreeView;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.SRFDAPageEx;
import SA.SRFDA.Web.SRFDAWebCTXHelper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.SRFExTreePanel;

public class TreeBackendPage
extends SRFDAPageEx {
    protected SRFExTreePanel treePanel = null;
    protected TreeView treeView = null;

    @Override
    protected boolean PreparePageEnv() {
        if (!super.PreparePageEnv()) {
            return false;
        }
        String strTreeViewId = this.OnGetTreeView();
        if (StringHelper.IsNullOrEmpty((String)strTreeViewId)) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u6811\u89c6\u56fe"));
            return false;
        }
        this.treeView = this.getDAModelStorage().FindTreeView(strTreeViewId);
        if (this.treeView == null) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6811\u89c6\u56fe[%1$s]", (Object)strTreeViewId));
            return false;
        }
        this.setPageParam("TREEVIEW", this.treeView);
        this.strPageDataEntityId = !StringHelper.IsNullOrEmpty((String)this.treeView.getDEID()) ? this.treeView.getDEID() : this.GetDefaultPageDataEntityId();
        return this.LoadPageDataEntity();
    }

    protected String OnGetTreeView() {
        return this.getPageParam("PAGE.TREEVIEW", SRFDAWebCTXHelper.GetTreeView((ISRFDAWebContext)this.getWebContext()));
    }

    protected void OnInitComponents() {
        super.OnInitComponents();
        this.LoadTreePanel();
    }

    protected void LoadTreePanel() {
        this.treePanel = TreeBackendPage.CreateTreePanel(this, "treePanel", 200.0, 200.0, "SRFDEFAULT.TV_DEFAULT");
        if (this.treePanel != null && !this.IsBackEndMode()) {
            this.treePanel.getTreePanelConfig().setBorder(false);
            this.treePanel.getTreePanelConfig().setShowLine(false);
            this.treePanel.getTreePanelConfig().setRootVisible(this.treeView.getSHOWROOT());
            this.treePanel.getTreePanelConfig().getRootNodeConfig().setText(this.treeView.getRootTreeNode().getTREENODENAME());
            this.treePanel.getTreePanelConfig().getRootNodeConfig().setAlwaysAsyncMode(true);
            this.treePanel.getTreePanelConfig().getRootNodeConfig().setLeaf(false);
        }
    }

    protected void OnInitBackEnd() {
        super.OnInitBackEnd();
        this.getWebContext().SetParamValue("srftreeid", this.treePanel.getUniqueID());
        this.getWebContext().SetParamValue("srfactiontype", "treeaction");
        this.RegisterTreeActionHelper(this.treePanel.getUniqueID(), this.GetTreeActionHelper());
    }

    protected String GetTreeActionHelper() {
        if (!StringHelper.IsNullOrEmpty((String)this.treeView.getBACKENDCTRL())) {
            return this.treeView.getBACKENDCTRL();
        }
        return "SA.SRFDA.Ctrl.Tree.BaseDATreeActionHelperEx";
    }
}

