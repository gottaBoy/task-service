package net.ibizsys.paas.web;

import net.ibizsys.paas.core.Errors;
import net.sf.json.JSONObject;

/**
 * 表单异步请求处理结果对象
 * 
 * @author lionlau
 *
 */
public class FormAjaxActionResult extends SDAjaxActionResult {
	/**
	 * 属性：关闭编辑视图
	 */
	public final static String ATTR_CLOSEEDITVIEW = "closeEditview";

	protected JSONObject state = null;

	/**
	 * 获取状态对象
	 * 
	 * @param bCreate 不存在时是否建立
	 * @return
	 */
	public JSONObject getState(boolean bCreate) {
		if (state != null) return state;

		if (bCreate) state = new JSONObject();
		return state;
	}

	protected JSONObject config = null;

	/**
	 * 获取配置对象
	 * 
	 * @param bCreate 不存在时是否建立
	 * @return
	 */
	public JSONObject getConfig(boolean bCreate) {
		if (config != null) return config;

		if (bCreate) config = new JSONObject();
		return config;
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
			return;
		}

		if (this.getState(false) != null) {
			objJSON.put("state", this.getState(false));
		}

		if (this.getConfig(false) != null) {
			objJSON.put("config", this.getConfig(false));
		}
	}
}
