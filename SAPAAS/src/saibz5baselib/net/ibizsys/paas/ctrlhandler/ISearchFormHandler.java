package net.ibizsys.paas.ctrlhandler;

/**
 * 搜索表单处理对象接口
 * 
 * @author lionlau
 *
 */
public interface ISearchFormHandler extends ICtrlHandler {
	public final static String ITEMACTIONTYPE_FORMITEM = "FI:";

	public final static String ITEMACTIONTYPE_FORMITEMUPDATE = "FIU:";

	/**
	 * 更新表单项
	 */
	final static String ACTION_UPDATEFORMITEM = "updateformitem";

	/**
	 * 搜索
	 */
	public final static String ACTION_SEARCH = "search";

	/**
	 * 表单项数据
	 */
	public final static String ACTION_ITEMFETCH = "itemfetch";

	/**
	 * 获取草稿数据
	 */
	final static String ACTION_LOADDRAFT = "loaddraft";

	/**
	 * 加载指定查询条件
	 */
	final static String ACTION_LOAD = "load";
	
	
	/**
	 * 建立过滤器
	 */
	final static String ACTION_CREATE = "create";
	
	
	/**
	 *更新过滤器
	 */
	final static String ACTION_UPDATE = "update";
	
	/**
	 *移除过滤器
	 */
	final static String ACTION_REMOVE = "remove";
	
	/**
	 *获取过滤器清单
	 */
	final static String ACTION_FETCH = "fetch";
}
