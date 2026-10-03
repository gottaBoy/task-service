package net.ibizsys.paas.web.jquery.render;

import java.util.ArrayList;

import net.ibizsys.paas.control.drctrl.IDRCtrlItem;
import net.ibizsys.paas.ctrlhandler.IDRBarRender;
import net.ibizsys.paas.ctrlmodel.IDRBarModel;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.MDAjaxActionResult;
import net.ibizsys.paas.web.WebContext;
import net.sf.json.JSONObject;

/**
 * JQuery JSTree 关系栏绘制器
 * 
 * @author Administrator
 *
 */
public class DRBarJSTreeRender extends JSTreeRenderBase implements IDRBarRender {

	@Override
	public void fillFetchResult(IDRBarModel iDRBarModel, MDAjaxActionResult fetchResult) throws Exception {
		fetchResult.setArrayMode(true);
		for (IDRCtrlItem iDRBarItem : iDRBarModel.getRootItem().getItems()) {
			JSONObject jo = DRBarJSTreeRender.toJSONObject(iDRBarModel, iDRBarItem, null);
			if (jo != null) {
				fetchResult.getRows().add(jo);
			}
		}
	}

	/**
	 * 导出到JSON对象
	 * 
	 * @param iDRBarModel 关系栏模型
	 * @param iExpBarItem 数据部件数据项接口
	 * @param jsonObject 导出对象
	 * @return
	 * @throws Exception
	 */
	public static JSONObject toJSONObject(IDRBarModel iDRBarModel, IDRCtrlItem iExpBarItem, JSONObject jsonObject) throws Exception {
		if (!iDRBarModel.testDRCtrlItemEnabled(iExpBarItem)) return null;

		if (jsonObject == null) jsonObject = new JSONObject();
		jsonObject.put(TREENODE_ID, JSONObjectHelper.stripQuotes(iExpBarItem.getId()));
		String strText = iExpBarItem.getText();
		String strTextLanResTag = iExpBarItem.getTextLanResTag();
		if(!StringHelper.isNullOrEmpty(strTextLanResTag)){
			strText = WebContext.getCurrent().getLocalization(strTextLanResTag, strText);
		}
		jsonObject.put(TREENODE_TEXT,JSONObjectHelper.stripQuotes(strText));
		jsonObject.put(TREENODE_TEXTCLS, JSONObjectHelper.stripQuotes(iExpBarItem.getTextCls()));
		if (!StringHelper.isNullOrEmpty(iExpBarItem.getIconCls())) {
			jsonObject.put(TREENODE_ICON, JSONObjectHelper.stripQuotes(iExpBarItem.getIconCls()));
		} else if (!StringHelper.isNullOrEmpty(iExpBarItem.getIconPath())) {
			jsonObject.put(TREENODE_ICON, JSONObjectHelper.stripQuotes(iExpBarItem.getIconPath()));
		}

		jsonObject.put(TREENODE_COUNTERID, JSONObjectHelper.stripQuotes(iExpBarItem.getCounterId()));

		JSONObject stateJO = new JSONObject();
		stateJO.put(TREENODE_EXPANDED, iExpBarItem.isExpanded());
		jsonObject.put(TREENODE_STATE, stateJO);

		JSONObject drItemJO = new JSONObject();
		drItemJO.put(TREENODE_VIEWID, JSONObjectHelper.stripQuotes(iExpBarItem.getDRViewId()));

		JSONObject viewParamJO = new JSONObject();

		java.util.Iterator<String> viewParamKeys = iExpBarItem.getViewParamNames();
		while (viewParamKeys.hasNext()) {
			String strKey = viewParamKeys.next();
			Object objValue = iExpBarItem.getViewParam(strKey);
			JSONObjectHelper.put(viewParamJO,strKey, objValue);
		}
		drItemJO.put(TREENODE_VIEWPARAM, viewParamJO);

		jsonObject.put(TREENODE_DRITEM, drItemJO);

		if (iExpBarItem.getItems().size() == 0) {
			jsonObject.put(TREENODE_ITEMS, false);
		} else {
			ArrayList<JSONObject> items = new ArrayList<JSONObject>();
			for (IDRCtrlItem childExpBarItem : iExpBarItem.getItems()) {
				JSONObject jsonItem = toJSONObject(iDRBarModel, childExpBarItem, null);
				if (jsonItem != null) {
					items.add(jsonItem);
				}
			}
			if (items.size() == 0) {
				jsonObject.put(TREENODE_ITEMS, false);
			} else {
				jsonObject.put(TREENODE_ITEMS, items.toArray());
			}
		}
		return jsonObject;
	}
}
