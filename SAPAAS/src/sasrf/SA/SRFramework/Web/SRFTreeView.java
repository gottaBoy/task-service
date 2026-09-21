/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.jsp.JspWriter
 */
package SA.SRFramework.Web;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.Web.SRFWebControl;
import SA.SRFramework.Web.TreeNode;
import SA.SRFramework.Web.TreeNodeCollection;
import javax.servlet.jsp.JspWriter;

public class SRFTreeView
extends SRFWebControl {
    private TreeNodeCollection nodes = new TreeNodeCollection();
    private String strTarget = "";
    private TreeNode selectNode = null;

    public TreeNodeCollection getNodes() {
        return this.nodes;
    }

    public String getTarget() {
        return this.strTarget;
    }

    public void setTarget(String strTarget) {
        this.strTarget = strTarget;
    }

    public void setSelectNode(TreeNode selectNode) {
        this.selectNode = selectNode;
    }

    public TreeNode getSelectNode() {
        return this.selectNode;
    }

    @Override
    protected void OnRender(JspWriter output) {
        try {
            output.print(StringHelper.Format("<div style=\"OVERFLOW: auto; WIDTH: %1$spx; HEIGHT: %2$spx\">", this.getWidth(), this.getHeight()));
            output.print("<SCRIPT type=\"text/javascript\">\n");
            output.print("d = new dTree('d');\n");
            output.print(StringHelper.Format("d.config.target = '%1$s';\n", this.strTarget));
            int i = 0;
            while (i < this.nodes.size()) {
                TreeNode childNode = this.nodes.Get(i);
                this.OutputTreeNode(output, childNode);
                ++i;
            }
            output.print(" document.write(d);\n");
            output.print("</SCRIPT>\n");
            output.print("</div>");
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    private void OutputTreeNode(JspWriter output, TreeNode node) {
        try {
            String strParentId = "-1";
            if (node.getParent() != null) {
                strParentId = node.getParent().getId();
            }
            output.print(StringHelper.Format("d.add(\"%1$s\",\"%2$s\",\"%3$s\",\"%4$s\",\"%5$s\",\"%6$s\",\"%7$s\",\"%8$s\",\"%9$s\",\"\");\n", node.getId(), strParentId, node.getText(), node.getURL(), node.getTitle(), node.getTarget(), node.getImage(), node.getSelectImage(), node.getOpen(), node.getValue()));
            int i = 0;
            while (i < node.getChilds().size()) {
                TreeNode childNode = node.getChilds().Get(i);
                this.OutputTreeNode(output, childNode);
                ++i;
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }
}

