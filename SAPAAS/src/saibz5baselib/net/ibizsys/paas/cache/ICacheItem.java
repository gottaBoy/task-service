package net.ibizsys.paas.cache;

/**
 * 缓存项对象接口
 * @author Administrator
 *
 */
public interface ICacheItem {

	/**
	 * 获取缓存数据
	 * @return
	 */
	Object getData();
	
	
	/**
	 * 获取过期时间
	 * @return
	 */
	long getExpiredTime();
	
	
	
	/**
	 * 获取缓存标记
	 * @return
	 */
	String getUniqueTag();
	
	
	
	/**
	 * 获取缓存数据的状态值
	 * @return
	 */
	Object getState();
}
