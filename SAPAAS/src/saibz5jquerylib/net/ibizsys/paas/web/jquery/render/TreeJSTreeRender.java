package net.ibizsys.paas.web.jquery.render;

import java.util.ArrayList;

import net.ibizsys.paas.control.tree.ITreeNode;
import net.ibizsys.paas.ctrlhandler.ITreeRender;
import net.ibizsys.paas.ctrlmodel.ITreeModel;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.MDAjaxActionResult;
import net.ibizsys.psrt.srv.web.WebContext;
import net.sf.json.JSONObject;

/**
 * JQuery JSTree 树视图绘制器
 * 
 * @author Administrator
 *
 */
public class TreeJSTreeRender extends JSTreeRenderBase implements ITreeRender {

	@Override
	public String getNodeId(IWebContext iWebContext) throws Exception {
		return WebContext.getNodeId(iWebContext);
	}

	@Override
	public void fillFetchResult(ITreeModel iTreeModel, MDAjaxActionResult fetchResult, java.util.ArrayList<ITreeNode> treeNodeList) throws Exception {
		fetchResult.setArrayMode(isFetchResultArrayMode());
		for (ITreeNode iTreeNode : treeNodeList) {
			fetchResult.getRows().add(toJSONObject(iTreeNode, null));
		}
	}

	/**
	 * 导出到JSON对象
	 * 
	 * @param iTreeNode
	 * @param jsonObject
	 * @return
	 * @throws Exception
	 */
	public static JSONObject toJSONObject(ITreeNode iTreeNode, JSONObject jsonObject) throws Exception {
		if (jsonObject == null) jsonObject = new JSONObject();
		jsonObject.put(TREENODE_ID, JSONObjectHelper.stripQuotes(iTreeNode.getId()));
		jsonObject.put(TREENODE_TEXT, JSONObjectHelper.stripQuotes(iTreeNode.getText()));
		// jsonObject.put(TREENODE_TEXTCLS, iTreeNode.getTextCls());
		if (!StringHelper.isNullOrEmpty(iTreeNode.getIconCssClass())) {
			jsonObject.put(TREENODE_ICON, JSONObjectHelper.stripQuotes(iTreeNode.getIconCssClass()));
		} else if (!StringHelper.isNullOrEmpty(iTreeNode.getIcon())) {
			jsonObject.put(TREENODE_ICON, JSONObjectHelper.stripQuotes(iTreeNode.getIcon()));
		}

		// jsonObject.put(TREENODE_COUNTERID, iTreeNode.getCounterId());
		// if(iTreeNode.getCounterMode() != 0)
		// {
		// jsonObject.put(TREENODE_COUNTERMODE, iTreeNode.getCounterMode());
		// }

		JSONObject stateJO = new JSONObject();
		stateJO.put(TREENODE_EXPANDED, iTreeNode.isExpanded());
		jsonObject.put(TREENODE_STATE, stateJO);

		if (iTreeNode.getTag() != null) {
			jsonObject.put(TREENODE_TAG, iTreeNode.getTag());
		} else {
			// jsonObject.put(TREENODE_TAG, iTreeNode.getTag());
		}

		if (iTreeNode.isLeaf()) {
			jsonObject.put(TREENODE_ITEMS, false);
		} else {
			if (iTreeNode.getChildNodes() == null) {
				jsonObject.put(TREENODE_ITEMS, true);
			} else {
				ArrayList<JSONObject> items = new ArrayList<JSONObject>();
				java.util.Iterator<ITreeNode> treeNodes = iTreeNode.getChildNodes();
				while (treeNodes.hasNext()) {
					ITreeNode childTreeNode = treeNodes.next();
					JSONObject jsonItem = toJSONObject(childTreeNode, null);
					items.add(jsonItem);
				}
				jsonObject.put(TREENODE_ITEMS, items.toArray());
			}
		}
		return jsonObject;
	}
}
