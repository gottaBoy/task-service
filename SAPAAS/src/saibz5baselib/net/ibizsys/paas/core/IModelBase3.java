package net.ibizsys.paas.core;

/**
 * 模型基础接口3
 * @author Administrator
 *
 */
public interface IModelBase3 extends IModelBase2 {
	
	/**
	 * 获取模型属性
	 * 
	 * @param strKey
	 * @return
	 */
	Object getAttribute(String strKey) throws Exception;

	/**
	 * 获取boolean 模型属性
	 * 
	 * @param strKey
	 * @param bDefault 默认值
	 * @return
	 */
	boolean getAttribute(String strKey, boolean bDefault) throws Exception;

	/**
	 * 获取String 模型属性
	 * 
	 * @param strKey
	 * @param strDefault 默认值
	 * @return
	 */
	String getAttribute(String strKey, String strDefault) throws Exception;

	/**
	 * 获取Integer 模型属性
	 * 
	 * @param strKey
	 * @param nDefault 默认值
	 * @return
	 */
	int getAttribute(String strKey, int nDefault) throws Exception;

	/**
	 * 获取Double 模型属性
	 * 
	 * @param strKey
	 * @param fDefault 默认值
	 * @return
	 */
	double getAttribute(String strKey, double fDefault) throws Exception;

	/**
	 * 设置模型属性
	 * 
	 * @param strKey
	 * @param objValue
	 */
	void setAttribute(String strKey, Object objValue) throws Exception;
}
