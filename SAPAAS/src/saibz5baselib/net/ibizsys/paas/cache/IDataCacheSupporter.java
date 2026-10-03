package net.ibizsys.paas.cache;

/**
 * 数据缓存支持接口
 * @author Administrator
 *
 */
public interface IDataCacheSupporter {

	/**
	* 缓存范围 - 全局 
	*/
	public final static String CACHESCOPE_GLOBAL = "GLOBAL" ;

	/**
	*缓存范围 - 组织
	*/
	public final static String CACHESCOPE_ORG = "ORG" ;

	/**
	*缓存范围 - 用户
	*/
	public final static String CACHESCOPE_USER = "USER" ;
	
	

	
	/**
	 * 是否支持缓存
	 * @return
	 */
	boolean isEnableCache();
	
	
	/**
	 * 获取缓存范围
	 * @return
	 */
	String getCacheScope();
	
	
	
	/**
	 * 获取缓存过期时长（毫秒）
	 * @return
	 */
	int getCacheTimeout();
	
	
	
	/**
	 * 获取统一状态标识
	 * @return
	 */
	String getCacheUniStateId();
	
	
	
	/**
	 * 获取缓存状态计算逻辑
	 * @return
	 */
	String getCacheUniStateDELogicId();
	
	
	
	/**
	 * 获取缓存的关注状态
	 * @return
	 */
	String getCacheHookState();
	
	

}
