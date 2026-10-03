package net.ibizsys.paas.datasync;

import net.ibizsys.psrt.srv.common.entity.DataSyncAgent;

/**
 * 数据同步引擎
 * 
 * @author Administrator
 *
 */
public interface IDataSyncEngine {
	/**
	 * 数据输入
	 */
	final static String SYNCDIR_IN = "IN";

	/**
	 * 数据输出
	 */
	final static String SYNCDIR_OUT = "OUT";

	/**
	 * 初始化
	 * 
	 * @param dataSyncAgent
	 * @throws Exception
	 */
	void init(DataSyncAgent dataSyncAgent) throws Exception;

	/**
	 * 退出释放引擎
	 * 
	 * @throws Exception
	 */
	void quit() throws Exception;

	/**
	 * 获取引擎标识
	 * 
	 * @return
	 */
	String getId();

	/**
	 * 获取引擎名称
	 * 
	 * @return
	 */
	String getName();

	/**
	 * 获取同步方向
	 * 
	 * @return
	 */
	String getSyncDir();

}
