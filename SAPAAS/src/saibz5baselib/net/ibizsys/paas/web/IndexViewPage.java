package net.ibizsys.paas.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.ibizsys.paas.util.Base64Helper;
import net.sf.json.JSONObject;

/**
 * 首页视图
 * 
 * @author lionlau
 *
 */
public class IndexViewPage extends Page {
	private static final Log log = LogFactory.getLog(IndexViewPage.class);

	private JSONObject appDataJO = new JSONObject();
	private JSONObject appDataJO2 = new JSONObject();

	@Override
	protected void onInit() throws Exception {
		super.onInit();
	}

	/**
	 * 获取应用数据对象（远程，用于交互）
	 * 
	 * @return
	 */
	protected JSONObject getAppDataObject() {
		return appDataJO;
	}

	/**
	 * 获取本地应用数据对象
	 * 
	 * @return
	 */
	protected JSONObject getLocalAppDataObject() {
		return appDataJO2;
	}

	/**
	 * 获取应用数据字符串
	 * 
	 * @return
	 */
	public String getAppDataString() {
		return Base64Helper.encodeBytes(appDataJO.toString().getBytes()).replace("\r", "").replace("\n", "");
	}

	/**
	 * 获取本地应用数据字符串
	 * 
	 * @return
	 */
	public String getLocalAppDataString() {
		return appDataJO2.toString();
	}
}
