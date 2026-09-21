/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlmodel;

import java.util.ArrayList;
import net.ibizsys.paas.control.tree.ITreeNode;
import net.ibizsys.paas.control.tree.TreeNode;
import net.ibizsys.paas.ctrlhandler.ITreeNodeFetchContext;
import net.ibizsys.paas.ctrlmodel.ITreeStaticNodeModel;
import net.ibizsys.paas.ctrlmodel.TreeNodeModelBase;
import net.ibizsys.paas.util.StringHelper;

public class TreeStaticNodeModel
extends TreeNodeModelBase
implements ITreeStaticNodeModel {
    private String strNodeValue = "";

    @Override
    public String getTreeNodeType() {
        return "STATIC";
    }

    @Override
    public String getNodeValue() {
        return this.strNodeValue;
    }

    public void setNodeValue(String strNodeValue) {
        this.strNodeValue = strNodeValue;
    }

    @Override
    public void fillFetchResult(ITreeNodeFetchContext iTreeNodeFetchContext, ArrayList<ITreeNode> treeNodeList) throws Exception {
        TreeNode treeNodeConfig = new TreeNode();
        String strNodeId = this.getId();
        if (!StringHelper.isNullOrEmpty(this.getNodeValue())) {
            strNodeId = String.valueOf(strNodeId) + ";";
            strNodeId = String.valueOf(strNodeId) + this.getNodeValue();
        }
        if (!StringHelper.isNullOrEmpty(iTreeNodeFetchContext.getRealNodeId()) && (this.isAppendPNodeId() || StringHelper.isNullOrEmpty(this.getNodeValue()))) {
            strNodeId = String.valueOf(strNodeId) + ";";
            strNodeId = String.valueOf(strNodeId) + iTreeNodeFetchContext.getRealNodeId();
        }
        treeNodeConfig.setId(strNodeId);
        treeNodeConfig.setText(this.getName());
        treeNodeConfig.setNodeDataType(this.getNodeDataType());
        treeNodeConfig.setIconCssClass(this.getIconCls());
        if (StringHelper.isNullOrEmpty(treeNodeConfig.getIconCssClass()) && !StringHelper.isNullOrEmpty(this.getIconPath())) {
            treeNodeConfig.setIcon(this.getTreeModel().getViewController().getAppModel().getAppPFHelper().mapImageRealUrl(this.getIconPath()));
        }
        treeNodeConfig.setAsyncMode(true);
        treeNodeConfig.setLeaf(!this.hasTreeNodeRSModel());
        treeNodeConfig.setExpanded(this.isExpanded() || iTreeNodeFetchContext.isAutoExpand());
        treeNodeConfig.setEnableCheck(this.isEnableCheck());
        if (!StringHelper.isNullOrEmpty(this.getNodeType())) {
            treeNodeConfig.setTagValue("srfnodetype", this.getNodeType());
            treeNodeConfig.setTreeNodeType(this.getNodeType());
        }
        if (!StringHelper.isNullOrEmpty(this.getNodeValue())) {
            treeNodeConfig.setTagValue("srfkey", this.getNodeValue());
        }
        treeNodeConfig.setTagValue("srfmajortext", this.getName());
        treeNodeConfig.setDataSource(this);
        if (this.isEnableCheck()) {
            treeNodeConfig.setChecked(this.isChecked());
        }
        treeNodeConfig.setCounterId(this.getCounterId());
        treeNodeConfig.setCounterMode(this.getCounterMode());
        treeNodeList.add(treeNodeConfig);
    }
}

