package net.ibizsys.paas.web;

import net.ibizsys.paas.core.Errors;
import net.sf.json.JSONObject;

/**
 * 界面行为后台异步处理结果对象
 * @author Administrator
 *
 */
public class UIActionAjaxActionResult extends AjaxActionResult{

	/**
	 * 属性：关闭编辑视图
	 */
	public final static String ATTR_CLOSEEDITVIEW = "closeEditview";

	
	/**
	 * 属性：重新刷新数据
	 */
	public final static String ATTR_RELOADDATA = "reloadData";
	
	private boolean bReloadData = false;
	
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

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.web.AjaxActionResult#fillJSONObject(net.sf.json.JSONObject)
	 */
	@Override
	protected void fillJSONObject(JSONObject objJSON) {
		super.fillJSONObject(objJSON);

		if (isReloadData()) {
			objJSON.put(ATTR_RELOADDATA, true);
		}
		
		if (this.getRetCode() != Errors.OK) {
			return;
		}
	}
}
