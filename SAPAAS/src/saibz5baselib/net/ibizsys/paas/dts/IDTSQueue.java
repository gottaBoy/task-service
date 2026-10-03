package net.ibizsys.paas.dts;

import net.ibizsys.paas.core.IModelBase2;

/**
 * 系统分布式事务队列对象接口
 * @author Administrator
 *
 */
public interface IDTSQueue extends IModelBase2 {

	/**
	 * 队列状态，已建立
	 */
	public final static int STATE_UNKNOWN = 0;
	
	
	/**
	 * 队列状态，已建立
	 */
	public final static int STATE_CREATED = 10;
	
	/**
	 * 队列状态，处理中
	 */
	public final static int STATE_PROCESSING = 20; 
	
	
	/**
	 * 队列状态，已完成
	 */
	public final static int STATE_FINISHED = 30; 
	
	
	/**
	 * 队列状态，已失败
	 */
	public final static int STATE_FAILED = 40; 
	
	
	/**
	 * 队列状态，已取消
	 */
	public final static int STATE_CANCELLED = 41;
	
	
	
	/**
	 * 获取实体名称
	 * @return
	 */
	String getDEName();
	
	
	/**
	 * 获取临时队列实体名称
	 * @return
	 */
	String getHistoryDEName();
	
	
	
	/**
	 * 获取状态标记属性
	 * @return
	 */
	String getStateField();
	
	
	
	/**
	 * 获取错误信息存储属性
	 * @return
	 */
	String getErrorField();
	
	
	
	/**
	 * 获取时间标记属性
	 * @return
	 */
	String getTimeField();
	
	
	/**
	 * 获取操作确认的实体行为名称
	 * @return
	 */
	String getConfirmDEActionName();
	
	
	
	/**
	 * 获取操作取消的实体行为名称
	 * @return
	 */
	String getCancelDEActionName();
	
	
	
	/**
	 * 获取取消的超时时长（毫秒）
	 * @return
	 */
	int getCancelTimeout();
	
	
	
	
	/**
	 * 获取刷新的计数间隔（毫秒）
	 * @return
	 */
	int getRefreshTimer();
	
	
	
	/**
	 * 获取推送队列的实体行为名称
	 * @return
	 */
	String getPushDEActionName();
	
	/**
	 * 获取刷新队列的实体行为名称
	 * @return
	 */
	String getRefreshDEActionName();
}
