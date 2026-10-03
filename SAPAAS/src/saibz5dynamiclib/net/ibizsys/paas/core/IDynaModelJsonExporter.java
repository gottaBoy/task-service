package net.ibizsys.paas.core;

import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * 动态模型Json输出器对象接口
 * @author Administrator
 *
 */
public interface IDynaModelJsonExporter {

	/**
	 * 将模型导出到JsonObject
	 * @param objectNode
	 * @return
	 * @throws Exception
	 */
	ObjectNode toJsonObject(ObjectNode objectNode)throws Exception;
	
}
