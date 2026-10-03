package net.ibizsys.paas.service;

/**
 * 数据上下文参数对象接口
 * 
 * @author Administrator
 *
 */
public interface IDataContextParam {
	/**
	 * 获取实体名称
	 * 
	 * @return
	 */
	String getDEName();

	/**
	 * 获取实体属性名称
	 * 
	 * @return
	 */
	String getDEFName();

	/**
	 * 获取引用项
	 * 
	 * @return
	 */
	String getReferItem();

	/**
	 * 是否忽略空值条件
	 * 
	 * @return
	 */
	boolean isIgnoreEmpty();
}
