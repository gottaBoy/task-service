package net.ibizsys.paas.core;

/**
 * 模型存储对象接口
 * 
 * @author Administrator
 *
 */
public interface IModelStorage {
	/**
	 * 获取系统
	 * 
	 * @param strSystemId
	 * @return
	 * @throws Exception
	 */
	ISystem getSystem(String strSystemId) throws Exception;

	/**
	 * 获取系统应用
	 * 
	 * @param strApplicationId
	 * @return
	 * @throws Exception
	 */
	IApplication getApplication(String strApplicationId) throws Exception;

	/**
	 * 获取系统运行
	 * 
	 * @param strSystemId
	 * @return
	 * @throws Exception
	 */
	ISystemRuntime getSystemRuntime(String strSystemId) throws Exception;

	/**
	 * 获取系统运行
	 * 
	 * @param strSystemId
	 * @return
	 * @throws Exception
	 */
	IApplicationRuntime getApplicationRuntime(String strApplicationId) throws Exception;

	/**
	 * 获取系统设置
	 * 
	 * @param strKey
	 * @return
	 */
	String getSystemSetting(String strKey, String strDefault);
}
