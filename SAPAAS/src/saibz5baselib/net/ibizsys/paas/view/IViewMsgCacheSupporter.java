package net.ibizsys.paas.view;

/**
 * 视图消息缓存支持对象
 * @author Administrator
 *
 */
public interface IViewMsgCacheSupporter {

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
	 * 获取缓存标识属性
	 * @return
	 */
	String getCacheTagField();
	
	
	/**
	 * 获取缓存标识2属性
	 * @return
	 */
	String getCacheTag2Field();
}
