package net.ibizsys.paas.datasync;

/**
 * 数据同步输出引擎接口
 * 
 * @author LionLau
 *
 */
public interface IDataSyncOutEngine extends IDataSyncEngine {

	/**
	 * 检查发送功能是否正常
	 * 
	 * @return
	 * @throws Exception
	 */
	boolean checkSend() throws Exception;

	/**
	 * 发送数据
	 * 
	 * @param iDataSyncParam
	 * @throws Exception
	 */
	void send(IDataSyncParam iDataSyncParam) throws Exception;
}
