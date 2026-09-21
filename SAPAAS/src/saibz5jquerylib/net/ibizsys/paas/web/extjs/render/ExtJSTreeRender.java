/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.control.tree.ITreeNode
 *  net.ibizsys.paas.control.tree.TreeNode
 *  net.ibizsys.paas.ctrlhandler.ITreeRender
 *  net.ibizsys.paas.ctrlmodel.ITreeModel
 *  net.ibizsys.paas.web.IWebContext
 *  net.ibizsys.paas.web.MDAjaxActionResult
 */
package net.ibizsys.paas.web.extjs.render;

import java.util.ArrayList;
import net.ibizsys.paas.control.tree.ITreeNode;
import net.ibizsys.paas.control.tree.TreeNode;
import net.ibizsys.paas.ctrlhandler.ITreeRender;
import net.ibizsys.paas.ctrlmodel.ITreeModel;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.MDAjaxActionResult;
import net.ibizsys.paas.web.extjs.render.MDCtrlRenderBase;

public class ExtJSTreeRender
extends MDCtrlRenderBase
implements ITreeRender {
    public String getNodeId(IWebContext iWebContext) throws Exception {
        return iWebContext.getPostValue("node");
    }

    public void fillFetchResult(ITreeModel iTreeModel, MDAjaxActionResult fetchResult, ArrayList<ITreeNode> treeNodeList) throws Exception {
        for (ITreeNode iTreeNode : treeNodeList) {
            fetchResult.getRows().add(TreeNode.toJSONObject((ITreeNode)iTreeNode, (boolean)false));
        }
    }
}

