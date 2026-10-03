package net.ibizsys.paas.web.extjs.render;

import java.util.ArrayList;

import net.ibizsys.paas.control.tree.ITreeNode;
import net.ibizsys.paas.control.tree.TreeNode;
import net.ibizsys.paas.ctrlhandler.ITreeRender;
import net.ibizsys.paas.ctrlmodel.ITreeModel;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.MDAjaxActionResult;

public class ExtJSTreeRender extends MDCtrlRenderBase implements ITreeRender {

	public ExtJSTreeRender() {
	}

	@Override
	public String getNodeId(IWebContext iWebContext) throws Exception {
		return iWebContext.getPostValue("node");
	}

	@Override
	public void fillFetchResult(ITreeModel iTreeModel, MDAjaxActionResult fetchResult, ArrayList<ITreeNode> treeNodeList) throws Exception {

		for (ITreeNode iTreeNode : treeNodeList) {
			fetchResult.getRows().add(TreeNode.toJSONObject(iTreeNode, false));
		}
	}

}
