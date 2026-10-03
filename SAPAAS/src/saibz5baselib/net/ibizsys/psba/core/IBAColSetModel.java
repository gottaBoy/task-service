package net.ibizsys.psba.core;

/**
 * 列族模型接口对象
 * 
 * @author Administrator
 *
 */
public interface IBAColSetModel extends IBAColSet {
	
	/**
	 * 注册数据列
	 * 
	 * @param iBAColumn
	 */
	void registerBAColumn(IBAColumn iBAColumn)  throws Exception;
	
}
