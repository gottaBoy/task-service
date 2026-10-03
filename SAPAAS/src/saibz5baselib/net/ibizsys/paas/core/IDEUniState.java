package net.ibizsys.paas.core;


/**
 * 实体统一状态接口对象
 * 
 * @author lionlau
 *
 */
public interface IDEUniState extends IDataEntityObject {
	/**
	 * 初始化
	 * 
	 * @param iDataEntity
	 * @throws Exception
	 */
	void init(IDataEntity iDataEntity) throws Exception;

	
	
	/**
	 * 是否默认
	 * @return
	 */
	boolean isDefault();
}
