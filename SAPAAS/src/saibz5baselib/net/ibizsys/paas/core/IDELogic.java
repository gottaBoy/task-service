package net.ibizsys.paas.core;

/**
 * 实体逻辑接口
 * 
 * @author lionlau
 *
 */
public interface IDELogic extends IDataEntityObject {
	/**
	 * 初始化
	 * 
	 * @param iDataEntity
	 * @throws Exception
	 */
	void init(IDataEntity iDataEntity) throws Exception;

	/**
	 * 获取默认参数名称
	 * 
	 * @return
	 */
	String getDefaultParamName();
}
