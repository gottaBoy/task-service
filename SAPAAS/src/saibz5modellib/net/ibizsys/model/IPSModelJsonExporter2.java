package net.ibizsys.model;

import java.util.ArrayList;

import com.fasterxml.jackson.databind.node.ObjectNode;

public interface IPSModelJsonExporter2 {

	/**
	 * 将模型导出到JsonObject 列表
	 * @param objectNodeList
	 * @return
	 * @throws Exception
	 */
	ArrayList<ObjectNode> toJsonObjects(ArrayList<ObjectNode> objectNodeList)throws Exception;
}
