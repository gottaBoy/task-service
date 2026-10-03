package net.ibizsys.paas.dts;

import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.sysmodel.ISystemModel;

/**
 * 系统分布式事务队列对象模型
 * @author Administrator
 *
 */
public interface IDTSQueueModel extends IDTSQueue {
	
	/**
	 * 初始化
	 * @param iSystemModel
	 * @throws Exception
	 */
	void init(ISystemModel iSystemModel)throws Exception;
	
	
	
	/**
	 * 获取实体对象模型
	 * @return
	 */
	IDataEntityModel getDEModel();
	
	
	/**
	 * 推入队列，将请求发送至目标
	 * @param iEntity
	 * @throws Exception
	 */
	void push(IEntity iEntity) throws Exception;
	
	
	
	
	/**
	 * 获取数据库中数据过期时长
	 * @return
	 */
	int getQueryCancelTimeout();
	
//	/**
//	 * 弹出队列，取消请求
//	 * @param iEntity
//	 * @param strReason
//	 * @throws Exception
//	 */
//	void pop(IEntity iEntity,String strReason)throws Exception;
}
