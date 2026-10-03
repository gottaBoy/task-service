package net.ibizsys.paas.datasync;

import net.ibizsys.psrt.srv.common.entity.DataSyncIn;
import net.ibizsys.psrt.srv.common.entity.DataSyncOut;

/**
 * 数据同步参数对象接口
 * 
 * @author LionLau
 *
 */
public interface IDataSyncParam {

	/**
	 * 获取输出数据对象
	 * 
	 * @return
	 */
	DataSyncOut getDataSyncOut();

	/**
	 * 添加输入数据
	 * 
	 * @param dataSyncIn
	 */
	void addDataSyncIn(DataSyncIn dataSyncIn);

}
