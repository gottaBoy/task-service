package net.ibizsys.paas.core;

/**
 * 实体数据集合分组参数接口
 * 
 * @author lionlau
 *
 */
public interface IDEDataSetGroupParam extends IModelBase {
	/**
	 * 获取数据集合
	 * 
	 * @return
	 */
	IDEDataSet getDEDataSet();

	/**
	 * 获取分组代码
	 * 
	 * @return
	 */
	String getGroupCode();

	/**
	 * 获取分组属性
	 * 
	 * @return
	 */
	String[] getGroupFields();

	/**
	 * 获取排序方向
	 * 
	 * @return
	 */
	String getSortDir();

	/**
	 * 获取排序次序
	 * 
	 * @return
	 */
	int getSortOrder();

	/**
	 * 是否为重新计算
	 * 
	 * @return
	 */
	boolean isReCalc();

	/**
	 * 是否启用分组
	 * 
	 * @return
	 */
	boolean isEnableGroup();
}
