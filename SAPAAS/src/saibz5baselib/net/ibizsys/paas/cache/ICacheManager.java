package net.ibizsys.paas.cache;

/**
 * 缓存管理对象接口
 * 
 * @author Administrator
 *
 */
public interface ICacheManager {

	/**
	 * 缓存范围 - 未定义
	 */
	public final static int CACHESCOPE_NONE = 0;
	
	
	/**
	 * 缓存范围 - 全局
	 */
	public final static int CACHESCOPE_GLOBAL = 1;

	/**
	 * 缓存范围 - 组织
	 */
	public final static int CACHESCOPE_ORG = 2;

	/**
	 * 缓存范围 - 用户
	 */
	public final static int CACHESCOPE_USER = 3;

	/**
	 * 缓存范围 - 应用程序级别
	 */
	public final static int CACHESCOPE_APP = 4;
	
	

	/**
	 * 获取数据
	 * 
	 * @param strCacheTag
	 * @param objState
	 * @return
	 * @throws Exception
	 */
	Object getData(String strCacheTag, Object objState) throws Exception;

	/**
	 * 更新缓存数据
	 * 
	 * @param strCacheTag
	 * @param objState
	 * @param objData
	 * @return
	 * @throws Exception
	 */
	ICacheItem updateData(String strCacheTag, Object objState, Object objData) throws Exception;

	/**
	 * 更新缓存数据
	 * 
	 * @param strCacheTag
	 * @param objState
	 * @param objData
	 * @param nTimeout 超时时长，-1为不超时
	 * @return
	 * @throws Exception
	 */
	ICacheItem updateData(String strCacheTag, Object objState, Object objData, long nTimeout) throws Exception;

	/**
	 * 移除数据
	 * 
	 * @param strCacheTag
	 * @throws Exception
	 */
	ICacheItem removeData(String strCacheTag) throws Exception;

	/**
	 * 获取指定数据缓存项
	 * 
	 * @param strCacheTag
	 * @return
	 */
	ICacheItem getCacheItem(String strCacheTag);
	
	
	/**
	 * 清空全部缓存
	 */
	void removeAll();
}
