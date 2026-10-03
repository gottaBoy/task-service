package net.ibizsys.paas.demodel;

import net.ibizsys.paas.core.IDEDTSQueue;
import net.ibizsys.paas.core.IModelBase3;
import net.ibizsys.paas.dts.IDTSQueueModel;

/**
 * 实体分布事务队列模型
 * @author Administrator
 *
 */
public interface IDEDTSQueueModel extends IDEDTSQueue,IModelBase3 {

	
	/**
	 * 获取系统分布事务队列模型对象
	 * @return
	 * @throws Exception
	 */
	IDTSQueueModel getDTSQueueModel() throws Exception;
	
}
