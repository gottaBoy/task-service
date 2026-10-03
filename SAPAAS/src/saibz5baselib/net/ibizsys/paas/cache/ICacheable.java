package net.ibizsys.paas.cache;

/**
 * 缓存支持接口
 * @author Administrator
 *
 */
public interface ICacheable {

		
	/**
	 * 是否支持缓存
	 * @return
	 */
	boolean isEnableCache();
	
	
	/**
	 * 获取缓存范围，值参考 net.ibizsys.paas.cache.ICacheManager.CACHESCOPE_XXX 定义
	 * @return
	 */
	int getCacheScope();
	
	
	
	/**
	 * 获取缓存过期时长（毫秒）
	 * @return
	 */
	int getCacheTimeout();
	
	
	
	/**
	 * 获取统一状态对象标识
	 * @return
	 */
	String getUniStateId();
	
	
	
	/**
	 * 获取统一状态的检查键值
	 * @return
	 */
	Object getUniStateKeyValue();
	
	
	
	/**
	 * 获取统一状态的状态属性
	 * @return
	 */
	String getUniStateField();
}
