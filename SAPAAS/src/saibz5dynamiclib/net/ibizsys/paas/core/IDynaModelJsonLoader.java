package net.ibizsys.paas.core;

import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * 动态模型Json加载器对象接口
 * @author Administrator
 *
 */
public interface IDynaModelJsonLoader {

	
	/**
	 * 加载JSON对象
	 * @param jsonNode
	 * @throws Exception
	 */
	void loadJsonObject(ObjectNode jsonObject)throws Exception;
}
