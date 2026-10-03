package net.ibizsys.paas.web;

import net.ibizsys.paas.core.Errors;
import net.ibizsys.paas.util.Base64Helper;
import net.sf.json.JSONObject;

/**
 * 应用数据异步请求对象结果
 * @author Administrator
 *
 */
public class AppDataAjaxActionResult extends AjaxActionResult {
	
	/**
	 * 本地应用数据
	 */
	protected JSONObject localAppDataJO = null;
	
	
	/**
	 * 远端应用数据
	 */
	protected JSONObject remoteAppDataJO = null;
	
	
	/**
	 * 界面配置数据
	 */
	protected JSONObject appUIJO = null;
	
	

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.web.AjaxActionResult#fillJSONObject(net.sf.json.JSONObject)
	 */
	@Override
	protected void fillJSONObject(JSONObject objJSON) {
		
		super.fillJSONObject(objJSON);
		
		if (this.getRetCode() == Errors.OK) {
			if (this.getLocalAppData(false) != null) {
				objJSON.put("local", this.getLocalAppData(false));
			}
			
			if (this.getRemoteAppData(false) != null) {
				String strRemoteTag = Base64Helper.encodeBytes(this.getRemoteAppData(false).toString().getBytes()).replace("\r", "").replace("\n", "");
				objJSON.put("remotetag",strRemoteTag);
			}
			
			if (this.getUIConfig(false) != null) {
				objJSON.put("ui", this.getUIConfig(false));
			}
		}
	}
	
	
	
	/**
	 * 获取本地应用数据
	 * @param bCreate
	 * @return
	 */
	public JSONObject getLocalAppData(boolean bCreate){
		if (localAppDataJO != null) return localAppDataJO;

		if (bCreate) localAppDataJO = new JSONObject();
		return localAppDataJO;
	}
	
	
	/**
	 * 获取远端应用数据
	 * @param bCreate
	 * @return
	 */
	public JSONObject getRemoteAppData(boolean bCreate){
		if (remoteAppDataJO != null) return remoteAppDataJO;

		if (bCreate) remoteAppDataJO = new JSONObject();
		return remoteAppDataJO;
	}
	
	


	/**
	 * 获取应用界面配置
	 * @param bCreate
	 * @return
	 */
	public JSONObject getUIConfig(boolean bCreate){
		if (appUIJO != null) return appUIJO;

		if (bCreate) appUIJO = new JSONObject();
		return appUIJO;
	}
	
	
}
