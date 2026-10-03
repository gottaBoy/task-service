package net.ibizsys.paas.web;

import net.ibizsys.paas.core.Errors;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.sf.json.JSONObject;

/**
 * 单项数据异步请求结果对象
 * 
 * @author lionlau
 *
 */
public class SDAjaxActionResult extends AjaxActionResult {
	/**
	 * 数据访问对象
	 */
	protected JSONObject dataAccAction = null;
	protected JSONObject data = null;
	protected JSONObject error = null;
	private boolean bReloadData = false;

	public SDAjaxActionResult() {

	}

	/**
	 * 获取结果数据对象
	 * 
	 * @param bCreate 不存在时是否建立
	 * @return
	 */
	public JSONObject getData(boolean bCreate) {
		if (data != null) return data;

		if (bCreate) data = new JSONObject();
		return data;
	}

	/**
	 * 设置结果数据对象
	 * 
	 * @param data
	 */
	public void setData(JSONObject data) {
		this.data = data;
	}

	/**
	 * 获取错误对象
	 * 
	 * @param bCreate 不存在时是否建立
	 * @return
	 */
	public JSONObject getError(boolean bCreate) {
		if (error != null) return error;

		if (bCreate) error = new JSONObject();
		return error;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.web.AjaxActionResult#fillJSONObject(net.sf.json.JSONObject)
	 */
	@Override
	protected void fillJSONObject(JSONObject objJSON) {
		super.fillJSONObject(objJSON);
		if (this.getRetCode() != Errors.OK) {
			if (this.getError(false) != null) {
				objJSON.put("error", this.getError(false));
			}
			return;
		}

		if (this.getData(false) != null) {
			objJSON.put("data", this.getData(false));
		}

		if (this.getDataAccAction(false) != null) {
			objJSON.put("dataaccaction", this.getDataAccAction(false));
		}

		if (isReloadData()) {
			objJSON.put("reloadData", true);
		}
	}

	/**
	 * 获取是否重新加载数据
	 * 
	 * @return the bReloadData
	 */
	public boolean isReloadData() {
		return bReloadData;
	}

	/**
	 * 设置是否重新加载数据
	 * 
	 * @param bReloadData the bReloadData to set
	 */
	public void setReloadData(boolean bReloadData) {
		this.bReloadData = bReloadData;
	}

	/**
	 * 获取数据访问控制对象
	 * 
	 * @param bCreate 不存在时是否建立
	 * @return
	 */
	public JSONObject getDataAccAction(boolean bCreate) {
		if (dataAccAction != null) return dataAccAction;

		if (bCreate) dataAccAction = new JSONObject();
		return dataAccAction;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.web.AjaxActionResult#fromJSONObject(net.sf.json.JSONObject)
	 */
	@Override
	public void fromJSONObject(JSONObject jo) throws Exception {
		this.error = jo.optJSONObject("error");
		JSONObjectHelper.remove(jo, "error");

		this.data = jo.optJSONObject("data");
		JSONObjectHelper.remove(jo, "data");

		this.dataAccAction = jo.optJSONObject("dataaccaction");
		JSONObjectHelper.remove(jo, "dataaccaction");

		this.bReloadData = jo.optBoolean("reloadData", false);
		JSONObjectHelper.remove(jo, "reloadData");

		super.fromJSONObject(jo);
	}

}
