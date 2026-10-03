package net.ibizsys.paas.core;


/**
 * 动态模型对象接口
 * @author Administrator
 *
 */
public interface IDynaModel extends IModelBase {
	
	/**
	 * 模型属性：类型
	 */
	public final static String ATTR_TYPE = "type";
	
	/**
	 * 模型属性：标识
	 */
	public final static String ATTR_ID = "id";
	
	/**
	 * 模型属性：名称
	 */
	public final static String ATTR_NAME = "name";
	
	/**
	 * 动态模型：模型
	 */
	public final static String ATTR_MODEL = "model";
	

	/**
	 * 模型属性：标记
	 */
	public final static String ATTR_TAG = "tag";
	
	
	/**
	 * 模型属性：模式
	 */
	public final static String ATTR_MODE = "mode";
}
