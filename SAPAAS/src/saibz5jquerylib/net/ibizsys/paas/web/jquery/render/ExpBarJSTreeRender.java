package net.ibizsys.paas.web.jquery.render;

import java.util.ArrayList;

import net.ibizsys.paas.control.expbar.IExpBarItem;
import net.ibizsys.paas.control.tree.ITreeNode;
import net.ibizsys.paas.ctrlhandler.IExpBarRender;
import net.ibizsys.paas.ctrlmodel.IExpBarModel;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.MDAjaxActionResult;
import net.ibizsys.paas.web.WebContext;
import net.sf.json.JSONObject;

/**
 * JQuery JSTree 导航栏绘制器
 * 
 * @author Administrator
 *
 */
public class ExpBarJSTreeRender extends JSTreeRenderBase implements IExpBarRender {
	public final static String EXPBARITEM_COUNTERID = "counterid";
	public final static String EXPBARITEM_COUNTERMODE = "countermode";
	public final static String EXPBARITEM_ID = "id";
	public final static String EXPBARITEM_PID = "pid";
	public final static String EXPBARITEM_TEXT = "text";
	public final static String EXPBARITEM_ICONPATH = "icon";
	public final static String EXPBARITEM_TEXTCLS = "textcls";
	public final static String EXPBARITEM_ICONCLS = "iconcls";
	public final static String EXPBARITEM_ITEMS = "children";
	public final static String EXPBARITEM_LEAF = "leaf";
	public final static String EXPBARITEM_VIEWID = "viewid";
	public final static String EXPBARITEM_EXPITEM = "expitem";
	public final static String EXPBARITEM_VIEWPARAM = "viewparam";
	public final static String EXPBARITEM_EXPANDED = "opened";
	public final static String EXPBARITEM_STATE = "state";

	@Override
	public void fillFetchResult(IExpBarModel iExpBarModel, MDAjaxActionResult fetchResult) throws Exception {
		fetchResult.setArrayMode(isFetchResultArrayMode());
		for (IExpBarItem iExpBarItem : iExpBarModel.getRootItem().getItems()) {
			JSONObject jo = ExpBarJSTreeRender.toJSONObject(iExpBarItem, null);
			fetchResult.getRows().add(jo);
		}
	}

	/**
	 * 导出到JSON对象
	 * 
	 * @param iExpBarItem
	 * @param jsonObject
	 * @return
	 * @throws Exception
	 */
	public static JSONObject toJSONObject(IExpBarItem iExpBarItem, JSONObject jsonObject) throws Exception {
		if (jsonObject == null) jsonObject = new JSONObject();
		String strText = iExpBarItem.getText();
		String strTextLanResTag = iExpBarItem.getTextLanResTag();
		if(!StringHelper.isNullOrEmpty(strTextLanResTag)){
			strText = WebContext.getCurrent().getLocalization(strTextLanResTag, strText);
		}
		jsonObject.put(EXPBARITEM_ID, JSONObjectHelper.stripQuotes(iExpBarItem.getId()));
		jsonObject.put(EXPBARITEM_TEXT, JSONObjectHelper.stripQuotes(strText));
		jsonObject.put(EXPBARITEM_TEXTCLS, JSONObjectHelper.stripQuotes(iExpBarItem.getTextCls()));
		jsonObject.put(EXPBARITEM_ICONPATH, JSONObjectHelper.stripQuotes(iExpBarItem.getIconPath()));
		// jsonObject.put(EXPBARITEM_ICONCLS, iExpBarItem.getIconCls());
		jsonObject.put(EXPBARITEM_COUNTERID, JSONObjectHelper.stripQuotes(iExpBarItem.getCounterId()));
		if (iExpBarItem.getCounterMode() != 0) {
			jsonObject.put(EXPBARITEM_COUNTERMODE, iExpBarItem.getCounterMode());
		}

		JSONObject stateJO = new JSONObject();
		stateJO.put(EXPBARITEM_EXPANDED, iExpBarItem.isExpanded());
		jsonObject.put(EXPBARITEM_STATE, stateJO);

		JSONObject drItemJO = new JSONObject();
		drItemJO.put(EXPBARITEM_VIEWID, JSONObjectHelper.stripQuotes(iExpBarItem.getExpViewId()));

		JSONObject viewParamJO = new JSONObject();

		java.util.Iterator<String> viewParamKeys = iExpBarItem.getViewParamNames();
		while (viewParamKeys.hasNext()) {
			String strKey = viewParamKeys.next();
			Object objValue = iExpBarItem.getViewParam(strKey);
			JSONObjectHelper.put(viewParamJO,strKey, objValue);
		}
		drItemJO.put(EXPBARITEM_VIEWPARAM, viewParamJO);

		jsonObject.put(EXPBARITEM_EXPITEM, drItemJO);

		if (iExpBarItem.getItems().size() == 0) {
			// jsonObject.put(EXPBARITEM_LEAF, true);
			jsonObject.put(EXPBARITEM_ITEMS, false);
		} else {
			ArrayList<JSONObject> items = new ArrayList<JSONObject>();
			for (IExpBarItem childExpBarItem : iExpBarItem.getItems()) {
				JSONObject jsonItem = toJSONObject(childExpBarItem, null);
				items.add(jsonItem);
			}
			jsonObject.put(EXPBARITEM_ITEMS, items.toArray());
		}
		return jsonObject;
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
		jsonObject.put(EXPBARITEM_ID,JSONObjectHelper.stripQuotes(iTreeNode.getId()));
		jsonObject.put(EXPBARITEM_TEXT, JSONObjectHelper.stripQuotes(iTreeNode.getText()));
		jsonObject.put(EXPBARITEM_TEXTCLS, JSONObjectHelper.stripQuotes(iTreeNode.getCssClass()));
		jsonObject.put(EXPBARITEM_ICONPATH, JSONObjectHelper.stripQuotes(iTreeNode.getIcon()));
		jsonObject.put(EXPBARITEM_ICONCLS,JSONObjectHelper.stripQuotes( iTreeNode.getIconCssClass()));
		jsonObject.put(EXPBARITEM_COUNTERID, JSONObjectHelper.stripQuotes(iTreeNode.getCounterId()));
		if (iTreeNode.getCounterMode() != 0) {
			jsonObject.put(EXPBARITEM_COUNTERMODE, iTreeNode.getCounterMode());
		}

		JSONObject stateJO = new JSONObject();
		stateJO.put(EXPBARITEM_EXPANDED, iTreeNode.isExpanded());
		jsonObject.put(EXPBARITEM_STATE, stateJO);

		JSONObject drItemJO = new JSONObject();
		drItemJO.put(EXPBARITEM_VIEWID, iTreeNode.getTreeNodeType());

		JSONObject viewParamJO = new JSONObject();

		// java.util.Iterator<String> viewParamKeys = iTreeNode.getViewParamNames();
		// while(viewParamKeys.hasNext())
		// {
		// String strKey = viewParamKeys.next();
		// Object objValue = iTreeNode.getViewParam(strKey);
		// viewParamJO.put(strKey, objValue);
		// }
		drItemJO.put(EXPBARITEM_VIEWPARAM, viewParamJO);

		jsonObject.put(EXPBARITEM_EXPITEM, drItemJO);

		if (iTreeNode.getChildNodes() == null) {
			// jsonObject.put(EXPBARITEM_LEAF, true);
			jsonObject.put(EXPBARITEM_ITEMS, false);
		} else {
			ArrayList<JSONObject> items = new ArrayList<JSONObject>();
			java.util.Iterator<ITreeNode> treeNodes = iTreeNode.getChildNodes();
			while (treeNodes.hasNext()) {
				ITreeNode childTreeNode = treeNodes.next();
				JSONObject jsonItem = toJSONObject(childTreeNode, null);
				items.add(jsonItem);
			}
			jsonObject.put(EXPBARITEM_ITEMS, items.toArray());
		}
		return jsonObject;
	}

	@Override
	public void fillFetchResult(ArrayList<ITreeNode> treeNodeList, MDAjaxActionResult fetchResult) throws Exception {
		fetchResult.setArrayMode(isFetchResultArrayMode());
		for (ITreeNode iTreeNode : treeNodeList) {
			JSONObject jo = ExpBarJSTreeRender.toJSONObject(iTreeNode, null);
			fetchResult.getRows().add(jo);
		}
	}
}
