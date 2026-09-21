/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Web;

import SA.SRFramework.Web.TreeNode;
import java.util.ArrayList;

public class TreeNodeCollection {
    private static String SATAB = "##SA_TAB##";
    private static String SARET = "##SA_RET##";
    protected ArrayList arrTreeNode = new ArrayList();
    private TreeNode curNode = null;

    public void setTreeNode(TreeNode curNode) {
        this.curNode = curNode;
    }

    public void Add(TreeNode treeNode) {
        treeNode.setParent(this.curNode);
        this.arrTreeNode.add(treeNode);
    }

    public void Insert(int nPos, TreeNode treeNode) {
        treeNode.setParent(this.curNode);
        this.arrTreeNode.add(nPos, treeNode);
    }

    public int size() {
        return this.arrTreeNode.size();
    }

    public TreeNode Get(int nIndex) {
        return (TreeNode)this.arrTreeNode.get(nIndex);
    }

    public void Clear() {
        this.arrTreeNode.clear();
    }

    public void Remove(TreeNode treeNode) {
        this.arrTreeNode.remove(treeNode);
    }

    public void Remove(int nIndex) {
        this.arrTreeNode.remove(nIndex);
    }

    public TreeNode FindByValue(String strValue) {
        int nItemCount = this.arrTreeNode.size();
        int i = 0;
        while (i < nItemCount) {
            TreeNode temp = (TreeNode)this.arrTreeNode.get(i);
            if (strValue.compareTo(temp.getValue()) == 0) {
                return temp;
            }
            ++i;
        }
        return null;
    }
}

