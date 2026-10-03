package net.ibizsys.paas.service;

import java.util.HashMap;

import net.ibizsys.paas.util.StringHelper;

/**
 * 导入会话
 * 
 * @author lionlau
 *
 */
public class ImportSession {
	
	protected HashMap<String, String> importDataMap = new HashMap<String, String>();
	private String strName = "";
	
	/**
	 * 获取名称
	 * 
	 * @return
	 */
	public String getName() {
		return this.strName;
	}

	/**
	 * 设置名称
	 * 
	 * @param strName
	 */
	public void setName(String strName) {
		this.strName = strName;
	}
	
	/**
	 * 注册导入数据
	 * 
	 * @param strDEId
	 * @param objKeyValue
	 * @return
	 */
	public boolean register(String strDEId, Object objKeyValue) {
		String strImportTag = StringHelper.format("%1$s||%2$s", strDEId, objKeyValue);
		if (importDataMap.containsKey(strImportTag)) {
			return false;
		}
		importDataMap.put(strImportTag, "");
		return true;
	}
}
