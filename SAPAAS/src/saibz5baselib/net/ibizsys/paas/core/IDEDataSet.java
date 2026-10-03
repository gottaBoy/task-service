package net.ibizsys.paas.core;

import net.ibizsys.paas.cache.IDataCacheSupporter;

/**
 * 实体数据集接口
 * 
 * @author lionlau
 *
 */
public interface IDEDataSet extends IDataEntityObject,IDEDataRange,IDataCacheSupporter {
	/**
	 * 索引实体
	 */
	final static String PREDEFINETYPE_INDEXDE = "INDEXDE";

	/**
	 * 多表单
	 */
	final static String PREDEFINETYPE_MULTIFORM = "MULTIFORM";

	
	
	/**
	 * 初始化
	 * 
	 * @param iDataEntity
	 * @throws Exception
	 */
	void init(IDataEntity iDataEntity) throws Exception;

	/**
	 * 是否支持分组
	 * 
	 * @return
	 */
	boolean isEnableGroup();

	/**
	 * 获取分组的获取记录数
	 * 
	 * @return
	 */
	int getGroupTopCount();

	

	
	
	/**
	 * 获取一级排序属性
	 * @return
	 */
	String getMajorSortField();
	
	/**
	 * 获取一级排序方向
	 * @return
	 */
	String getMajorSortDir();
	
	
	/**
	 * 获取二级排序属性
	 * @return
	 */
	String getMinorSortField();
	
	/**
	 * 获取二级排序方向
	 * @return
	 */
	String getMinorSortDir();
	
	
	/**
	 * 获取默认分页大小
	 * @return
	 */
	int getPageSize();
	
	/**
	 * 获取相关数据查询
	 * 
	 * @return
	 */
	java.util.Iterator<IDEDataSetQuery> getDEDataSetQueries();

	/**
	 * 获取分组参数集合
	 * 
	 * @return
	 */
	java.util.Iterator<IDEDataSetGroupParam> getDEDataSetGroupParams();

	/**
	 * 获取数据查询集合
	 * 
	 * @return
	 * @throws Exception
	 */
	java.util.Iterator<IDEDataQuery> getDEDataQueries() throws Exception;

	
	
	/**
	 * 获取当前数据对象计算逻辑
	 * @return
	 */
	String getActiveDataDELogicId();
}
