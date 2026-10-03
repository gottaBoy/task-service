package net.ibizsys.paas.datasync;

/**
 * 数据同步输入引擎
 * 
 * @author Administrator
 *
 */
public interface IDataSyncInEngine extends IDataSyncEngine {

	/**
	 * 检查是否接收到数据
	 * 
	 * @return
	 */
	boolean checkRecv() throws Exception;

	/**
	 * 接收数据
	 * 
	 * @param iDataSyncParam
	 * @throws Exception
	 */
	void recv(IDataSyncParam iDataSyncParam) throws Exception;

}
