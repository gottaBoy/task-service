package net.ibizsys.paas.core;

/**
 * 实体数据同步接口
 * 
 * @author Administrator
 *
 */
public interface IDEDataSync extends IDataEntityObject {
	/**
	 * 同步方向：输入
	 */
	public final static String SYNCDIR_IN = "IN";

	/**
	 * 同步方向：输出
	 */
	public final static String SYNCDIR_OUT = "OUT";

	// 定义监控同步事件代码表

	/**
	 * 同步监控事件：新建
	 */
	public final static int EVENTTYPE_CREATE = 1;

	/**
	 * 同步监控事件：更新
	 */
	public final static int EVENTTYPE_UPDATE = 2;

	/**
	 * 同步监控事件：删除
	 */
	public final static int EVENTTYPE_DELETE = 4;

	/**
	 * 初始化
	 * 
	 * @param iDataEntity
	 * @throws Exception
	 */
	void init(IDataEntity iDataEntity) throws Exception;

	/**
	 * 获取同步代理标识
	 * 
	 * @return
	 */
	String getSyncAgent();

	/**
	 * 获取事件类型
	 * 
	 * @return
	 */
	int getEventType();

	/**
	 * 是否为输入模式
	 * 
	 * @return
	 */
	boolean isInMode();

	/**
	 * 获取同步标识
	 * 
	 * @return
	 */
	String getSyncTag();
}
