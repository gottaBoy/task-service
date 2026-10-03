package net.ibizsys.paas.core;

/**
 * 属性数据库值函数
 * @author Administrator
 *
 */
public interface IDEFDBValueFunc extends IModelBase {

	/**
	 * 获取代码格式化串
	 * @return
	 */
	String getCodeFormat();
	
	
	/**
	 * 获取相关的字段集合
	 * @return
	 */
	String[] getFields();
}
