package net.ibizsys.model;

import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * 模型Json导出器
 * @author Administrator
 *
 */
public interface IPSModelJsonExporter {

	/**
	 * 标识
	 */
	final static String ATTR_ID = "id";
	
	
	/**
	 * 名称
	 */
	final static String ATTR_NAME = "name";
	
	/**
	 * 类型
	 */
	final static String ATTR_TYPE = "type";
	
	/**
	 * 子项集合
	 */
	final static String ATTR_ITEMS = "items";
	
	/**
	 * 标题
	 */
	final static String ATTR_CAPTION = "caption";
	
	/**
	 * 显示标题
	 */
	final static String ATTR_SHOWCAP = "showcap";
	
	/**
	 * 宽度
	 */
	final static String ATTR_WIDTH = "width";
	
	/**
	 * 高度
	 */
	final static String ATTR_HEIGHT = "height";
	
	/**
	 * 模式
	 */
	final static String ATTR_MODE = "mode";
	
	
	/**
	 * 抬头
	 */
	final static String ATTR_TITLE = "title";
	
	
	/**
	 * 视图节点
	 */
	final static String ATTR_VIEW = "view";
	
	
	/**
	 * 路径
	 */
	final static String ATTR_URL = "url";
	
	
	/**
	 * 视图打开模式
	 */
	final static String ATTR_OPENMODE = "OPENMODE";
	
	
	/**
	 * 重定向视图
	 */
	final static String ATTR_REDIRECTVIEW = "redirectview";
	
	
	/**
	 * 标记
	 */
	final static String ATTR_TAG = "tag";
	

	/**
	 * 值
	 */
	final static String ATTR_VALUE = "value";
	
	
	
	/**
	 * 文本
	 */
	final static String ATTR_TEXT = "text";
	
	
	/**
	 * 将模型导出到JsonObject
	 * @param objectNode
	 * @return
	 * @throws Exception
	 */
	ObjectNode toJsonObject(ObjectNode objectNode)throws Exception;
}
