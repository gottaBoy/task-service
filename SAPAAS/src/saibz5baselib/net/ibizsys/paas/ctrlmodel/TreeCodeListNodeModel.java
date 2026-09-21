/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlmodel;

import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.codelist.ICodeItem;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.control.tree.ITreeNode;
import net.ibizsys.paas.control.tree.TreeNode;
import net.ibizsys.paas.controller.ViewController;
import net.ibizsys.paas.ctrlhandler.ITreeNodeFetchContext;
import net.ibizsys.paas.ctrlmodel.ITreeCodeListNodeModel;
import net.ibizsys.paas.ctrlmodel.TreeNodeModelBase;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.util.StringHelper;

public class TreeCodeListNodeModel
extends TreeNodeModelBase
implements ITreeCodeListNodeModel {
    private String strCodeListId = "";

    public void setCodeListId(String strCodeListId) {
        this.strCodeListId = strCodeListId;
    }

    @Override
    public String getCodeListId() {
        return this.strCodeListId;
    }

    @Override
    public String getTreeNodeType() {
        return "CODELIST";
    }

    @Override
    public void fillFetchResult(ITreeNodeFetchContext iTreeNodeFetchContext, ArrayList<ITreeNode> treeNodeList) throws Exception {
        ICodeList iCodeList = CodeListGlobal.getCodeList(this.getCodeListId(), ViewController.getCurrent().getSessionFactory());
        ICodeList rootCodeItemConfig = iCodeList;
        if (rootCodeItemConfig.getCodeItems() == null) {
            return;
        }
        Iterator<ICodeItem> codeItems = rootCodeItemConfig.getCodeItems();
        while (codeItems.hasNext()) {
            ICodeItem iCodeItem = codeItems.next();
            String strNodeId = this.getId();
            strNodeId = String.valueOf(strNodeId) + ";";
            strNodeId = String.valueOf(strNodeId) + iCodeItem.getValue();
            if (!StringHelper.isNullOrEmpty(iTreeNodeFetchContext.getRealNodeId()) && this.isAppendPNodeId()) {
                strNodeId = String.valueOf(strNodeId) + ";";
                strNodeId = String.valueOf(strNodeId) + iTreeNodeFetchContext.getRealNodeId();
            }
            TreeNode treeNodeConfig = new TreeNode();
            treeNodeConfig.setId(strNodeId);
            treeNodeConfig.setText(iCodeItem.getText());
            treeNodeConfig.setNodeDataType(this.getNodeDataType());
            if (!StringHelper.isNullOrEmpty(this.getIconCls())) {
                treeNodeConfig.setIconCssClass(this.getIconCls());
            } else {
                treeNodeConfig.setIcon(iCodeItem.getIconPath());
                treeNodeConfig.setIconCssClass(iCodeItem.getIconCls());
            }
            treeNodeConfig.setAsyncMode(true);
            treeNodeConfig.setLeaf(!this.hasTreeNodeRSModel());
            treeNodeConfig.setExpanded(this.isExpanded() || iTreeNodeFetchContext.isAutoExpand());
            treeNodeConfig.setEnableCheck(this.isEnableCheck());
            if (this.isEnableCheck()) {
                treeNodeConfig.setChecked(this.isChecked());
            }
            if (!StringHelper.isNullOrEmpty(this.getNodeType())) {
                treeNodeConfig.setTagValue("srfnodetype", this.getNodeType());
                treeNodeConfig.setTreeNodeType(this.getNodeType());
            }
            treeNodeConfig.setTagValue("srfkey", iCodeItem.getValue());
            treeNodeConfig.setTagValue("srfmajortext", iCodeItem.getText());
            treeNodeConfig.setDataSource(iCodeItem);
            treeNodeConfig.setCounterId(this.getCounterId());
            treeNodeConfig.setCounterMode(this.getCounterMode());
            treeNodeList.add(treeNodeConfig);
        }
    }
}

