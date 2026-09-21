/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Web;

import SA.SRFramework.Web.TreeNodeCollection;

public class TreeNode {
    private TreeNode parentNode = null;
    private String strId = "";
    private String strText = "";
    private String strValue = "";
    private String strImage = "";
    private String strSelectImage = "";
    private String strTarget = "_parent";
    private String strURL = "";
    private String strTitle = "";
    private boolean bOpen = false;
    private TreeNodeCollection childs = new TreeNodeCollection();

    public TreeNode() {
        this.childs.setTreeNode(this);
    }

    public TreeNode(String strId, String strText, String strValue) {
        this.childs.setTreeNode(this);
        this.strId = strId;
        this.strText = strText;
        this.strValue = strValue;
    }

    public TreeNode(String strId, String strText, String strValue, String strImage) {
        this.childs.setTreeNode(this);
        this.strId = strId;
        this.strText = strText;
        this.strValue = strValue;
        this.strImage = strImage;
    }

    public TreeNode(String strId, String strText, String strValue, String strImage, String strSelectImage) {
        this.childs.setTreeNode(this);
        this.strId = strId;
        this.strText = strText;
        this.strValue = strValue;
        this.strImage = strImage;
        this.strSelectImage = strSelectImage;
    }

    public TreeNode getParent() {
        return this.parentNode;
    }

    public void setParent(TreeNode treeNode) {
        this.parentNode = treeNode;
    }

    public String getId() {
        return this.strId;
    }

    public void setId(String strId) {
        this.strId = strId;
    }

    public String getText() {
        return this.strText;
    }

    public void setText(String strText) {
        this.strText = strText;
    }

    public String getValue() {
        return this.strValue;
    }

    public void setValue(String strValue) {
        this.strValue = strValue;
    }

    public String getImage() {
        return this.strImage;
    }

    public void setImage(String strImage) {
        this.strImage = strImage;
    }

    public String getSelectImage() {
        return this.strSelectImage;
    }

    public void setSelectImage(String strSelectImage) {
        this.strSelectImage = strSelectImage;
    }

    public String getTarget() {
        return this.strTarget;
    }

    public void setTarget(String strTarget) {
        this.strTarget = strTarget;
    }

    public String getURL() {
        return this.strURL;
    }

    public void setURL(String strURL) {
        this.strURL = strURL;
    }

    public String getTitle() {
        return this.strTitle;
    }

    public void setTitle(String strTitle) {
        this.strTitle = strTitle;
    }

    public boolean getOpen() {
        return this.bOpen;
    }

    public void Expand() {
        this.bOpen = true;
    }

    public void ExpandAll() {
        this.Expand();
        int i = 0;
        while (i < this.childs.size()) {
            TreeNode childNode = this.childs.Get(i);
            childNode.ExpandAll();
            ++i;
        }
    }

    public void Collapse() {
        this.bOpen = false;
    }

    public void Toggle() {
        if (this.bOpen) {
            this.Collapse();
        } else {
            this.Expand();
        }
    }

    public TreeNodeCollection getChilds() {
        return this.childs;
    }
}

