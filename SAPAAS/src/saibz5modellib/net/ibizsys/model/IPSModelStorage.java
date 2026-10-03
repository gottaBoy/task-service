package net.ibizsys.model;

/**
 * 系统模型存储对象
 * @author Administrator
 *
 */
public interface IPSModelStorage {

	
	/**
	 * 获取部署方案系统
	 * @param strPSDepSlnSysId
	 * @return
	 * @throws Exception
	 */
	IPSDepSlnSys getPSDepSlnSys(String strPSDepSlnSysId)throws Exception;
	
	
	
	/**
	 * 模型存储对象是否已经加载完成
	 * @return
	 */
	boolean isLoaded();
	
	
	
	/**
	 * 获取当前系统模型
	 * @return
	 * @throws Exception
	 */
	IPSSystem getPSSystem()throws Exception;
	
	
	
	/**
	 * 获取当前系统模型
	 * @param bCache 缓存
	 * @return
	 * @throws Exception
	 */
	IPSSystem getPSSystem(boolean bCache)throws Exception;
}
