/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.ISRFExTreeActionHelper;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.SRFExPage;
import SA.SRFramework.WebEx.SRFExTreePanel;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.UI.TreeNodeConfig;
import java.util.ArrayList;
import java.util.Vector;

public class SRFExTreeActionHelper
implements ISRFExTreeActionHelper {
    protected SRFExPage page = null;
    protected String strTreeId = "";
    protected String strTreeNodeId = "";
    protected SRFExTreePanel treePanel = null;

    @Override
    public boolean Process(SRFExPage page, String strTreeId, String strTreeNodeId) {
        this.page = page;
        this.strTreeId = strTreeId;
        this.strTreeNodeId = strTreeNodeId;
        if (!this.OnBeforeProcess()) {
            return false;
        }
        return this.OnLoadChildNodes(strTreeNodeId);
    }

    @Override
    public boolean Process(SRFExPage page, String strTreeId, String strTreeNodeId, String strActionType) {
        this.page = page;
        this.strTreeId = strTreeId;
        this.strTreeNodeId = strTreeNodeId;
        if (!this.OnBeforeProcess()) {
            return false;
        }
        if (StringHelper.Compare((String)"load", (String)strActionType, (boolean)true) == 0) {
            return this.OnLoadChildNodes(strTreeNodeId);
        }
        if (StringHelper.Compare((String)"create", (String)strActionType, (boolean)true) == 0) {
            return this.OnCreateChildNodes(strTreeNodeId);
        }
        if (StringHelper.Compare((String)"remove", (String)strActionType, (boolean)true) == 0) {
            return this.OnRemoveNode(strTreeNodeId);
        }
        if (StringHelper.Compare((String)"update", (String)strActionType, (boolean)true) == 0) {
            return this.OnUpdateNode(strTreeNodeId);
        }
        return false;
    }

    protected boolean OnBeforeProcess() {
        return true;
    }

    protected boolean OnLoadChildNodes(String strTreeNodeId) {
        return false;
    }

    protected boolean OnCreateChildNodes(String strTreeNodeId) {
        return false;
    }

    protected boolean OnRemoveNode(String strTreeNodeId) {
        return false;
    }

    protected boolean OnUpdateNode(String strTreeNodeId) {
        return false;
    }

    @Override
    public boolean ShowTreeNodeLevel(SRFExPage page, SRFExTreePanel treePanel, int nLevel) {
        this.page = page;
        this.treePanel = treePanel;
        if (nLevel <= 0) {
            return true;
        }
        Vector<TreeNodeConfig> parentNodes = new Vector<TreeNodeConfig>();
        if (!treePanel.getTreePanelConfig().getRootNodeConfig().getAsyncMode()) {
            return true;
        }
        parentNodes.add(treePanel.getTreePanelConfig().getRootNodeConfig());
        Vector<TreeNodeConfig> parentNodes2 = new Vector<TreeNodeConfig>();
        while (nLevel > 0) {
            parentNodes2.clear();
            for (TreeNodeConfig parentNodeConfig : parentNodes) {
                if (!parentNodeConfig.getAsyncMode()) continue;
                if (!this.OnLoadChildNodes(parentNodeConfig)) {
                    return false;
                }
                if (parentNodeConfig.getChildNodes() != null) {
                    for (Object objChild : parentNodeConfig.getChildNodes()) {
                        parentNodes2.add((TreeNodeConfig)objChild);
                    }
                }
                if (parentNodeConfig.getAlwaysAsyncMode()) {
                    parentNodeConfig.setAsyncMode(true);
                } else {
                    parentNodeConfig.setAsyncMode(false);
                }
                parentNodeConfig.setExpand(true);
            }
            if (parentNodes2.size() == 0) {
                return true;
            }
            parentNodes.clear();
            parentNodes.addAll(parentNodes2);
            --nLevel;
        }
        return true;
    }

    @Override
    public boolean ShowTreeNode(SRFExPage page, SRFExTreePanel treePanel, String strShowTreeNodeId) {
        this.page = page;
        this.treePanel = treePanel;
        if (StringHelper.Length((String)strShowTreeNodeId) == 0) {
            return false;
        }
        if (this.getTree().getTreePanelConfig().getRootNodeConfig().ContainTreeNode(strShowTreeNodeId)) {
            return true;
        }
        ArrayList<String> arrList = new ArrayList<String>();
        String strCurNodeId = strShowTreeNodeId;
        while (true) {
            String strParentNodeId;
            if (StringHelper.Length((String)(strParentNodeId = this.OnGetTreeNodeParentId(strCurNodeId))) == 0) {
                return false;
            }
            arrList.add(0, strParentNodeId);
            if (this.getTree().getTreePanelConfig().getRootNodeConfig().ContainTreeNode(strParentNodeId)) break;
            strCurNodeId = strParentNodeId;
        }
        int nParentCount = arrList.size();
        int i = 0;
        while (i < nParentCount) {
            String strParentNodeId = (String)arrList.get(i);
            TreeNodeConfig parentNodeConfig = this.getTree().getTreePanelConfig().getRootNodeConfig().FindTreeNode(strParentNodeId);
            if (parentNodeConfig == null) {
                return false;
            }
            if (!this.OnLoadChildNodes(parentNodeConfig)) {
                return false;
            }
            if (parentNodeConfig.getAlwaysAsyncMode()) {
                parentNodeConfig.setAsyncMode(true);
            } else {
                parentNodeConfig.setAsyncMode(false);
            }
            parentNodeConfig.setExpand(true);
            ++i;
        }
        return true;
    }

    protected String OnGetTreeNodeParentId(String strShowTreeNodeId) {
        return "";
    }

    protected boolean OnLoadChildNodes(TreeNodeConfig parentNodeConfig) {
        return false;
    }

    protected SRFExPage getPage() {
        return this.page;
    }

    protected SRFExWebContext getWebContext() {
        if (this.page == null) {
            return null;
        }
        return this.page.getWebContext();
    }

    protected SRFExTreePanel getTree() {
        if (this.treePanel != null) {
            return this.treePanel;
        }
        SRFExControl obj = this.getPage().LookForControlByUniqueId(this.strTreeId);
        if (obj == null) {
            return null;
        }
        if (obj instanceof SRFExTreePanel) {
            return (SRFExTreePanel)obj;
        }
        return null;
    }
}

