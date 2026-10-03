package net.ibizsys.paas.util;

/**
 * 全局对象接口
 * 
 * @author lionlau
 *
 */
public interface IGlobalContext {

	// /**
	// * 获取动态模型存储对象
	// * @return
	// */
	// IDynamicModelStorage getDynamicModelStorage();

	/**
	 * 获取Global值
	 * 
	 * @param strKey
	 * @return
	 */
	Object getValue(String strKey);

	/**
	 * 设置Global值
	 * 
	 * @param strKey
	 * @param objValue
	 */
	void setValue(String strKey, Object objValue);
}
