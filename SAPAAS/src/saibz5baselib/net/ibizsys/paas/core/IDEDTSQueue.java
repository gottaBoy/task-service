package net.ibizsys.paas.core;


/**
 * 实体分布事务队列接口对象
 * 
 * @author lionlau
 *
 */
public interface IDEDTSQueue extends IDataEntityObject {
	/**
	 * 初始化
	 * 
	 * @param iDataEntity
	 * @throws Exception
	 */
	void init(IDataEntity iDataEntity) throws Exception;


}
