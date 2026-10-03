package net.ibizsys.paas.core;

/**
 * 属性搜索项对象接口
 * 
 * @author lionlau
 *
 */
public interface IDEFSearchMode extends IModelBase {
	
	/**
	 * 获取属性名称
	 * 
	 * @return
	 */
	String getDEFName();

	/**
	 * 获取值函数标识
	 * 
	 * @return
	 */
	String getValueFunc();

	/**
	 * 获取值操作符号标识
	 * 
	 * @return
	 */
	String getValueOp();
}
