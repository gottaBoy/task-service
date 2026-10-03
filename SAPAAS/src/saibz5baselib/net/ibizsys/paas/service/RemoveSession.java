package net.ibizsys.paas.service;

import java.util.HashMap;

import net.ibizsys.paas.util.StringHelper;

/**
 * 删除会话
 * 
 * @author lionlau
 *
 */
@Deprecated
public class RemoveSession {
	protected HashMap<String, String> removeDataMap = new HashMap<String, String>();

	/**
	 * 注册删除数据
	 * 
	 * @param strDEId
	 * @param objKeyValue
	 * @return
	 */
	public boolean register(String strDEId, Object objKeyValue) {
		String strRemoveTag = StringHelper.format("%1$s||%2$s", strDEId, objKeyValue);
		if (removeDataMap.containsKey(strRemoveTag)) {
			return false;
		}
		removeDataMap.put(strRemoveTag, "");
		return true;
	}
}
