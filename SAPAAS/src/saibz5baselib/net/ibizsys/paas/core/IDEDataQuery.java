package net.ibizsys.paas.core;

/**
 * 实体数据查询接口
 * 
 * @author lionlau
 *
 */
public interface IDEDataQuery extends IDataEntityObject {
	/**
	 * 初始化
	 * 
	 * @param iDataEntity
	 * @throws Exception
	 */
	void init(IDataEntity iDataEntity) throws Exception;

	/**
	 * 获取实体数据库代码
	 * 
	 * @param strDBType
	 * @return
	 * @throws Exception
	 */
	IDEDataQueryCode getDEDataQueryCode(String strDBType) throws Exception;

	/**
	 * 是否为默认查询
	 * 
	 * @return
	 */
	boolean isDefaultMode();
	
	
	
	/**
	 * 获取视图级别
	 * @return
	 */
	int getViewLevel();
}
