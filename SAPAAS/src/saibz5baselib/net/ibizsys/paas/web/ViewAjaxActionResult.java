package net.ibizsys.paas.web;

import java.util.ArrayList;

import net.ibizsys.paas.core.Errors;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 视图异步请求结果对象
 * 
 * @author lionlau
 *
 */
public class ViewAjaxActionResult extends AjaxActionResult {
	protected ArrayList itemList = new ArrayList();

	public ViewAjaxActionResult() {

	}

	/**
	 * 获取数据列表
	 * 
	 * @return
	 */
	public ArrayList getItems() {
		return itemList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.web.SDAjaxActionResult#fillJSONObject(net.sf.json.JSONObject)
	 */
	@Override
	protected void fillJSONObject(JSONObject objJSON) {
		super.fillJSONObject(objJSON);

		if (this.getRetCode() != Errors.OK) {
			objJSON.put("items", new JSONArray());
		} else {
			objJSON.put("items", JSONArray.fromArray(itemList.toArray()));
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.web.AjaxActionResult#fromJSONObject(net.sf.json.JSONObject)
	 */
	@Override
	public void fromJSONObject(JSONObject jo) throws Exception {
		JSONArray ja = jo.optJSONArray("items");
		this.itemList.clear();
		if (ja != null) {
			for (int i = 0; i < ja.length(); i++) {
				this.itemList.add(ja.get(i));
			}
		}
		JSONObjectHelper.remove(jo, "items");

		super.fromJSONObject(jo);
	}
}
