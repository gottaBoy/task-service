package net.ibizsys.psba.core;

/**
 * 列族模型接口对象
 * 
 * @author Administrator
 *
 */
public interface IBAColSet extends IBATableObject {

	/**
	 * 获取数据列集合
	 * @return
	 */
	java.util.Iterator<IBAColumn> getBAColumns();
	
	
	/**
	 * 获取指定列对象
	 * 
	 * @param strBAColumnName
	 * @return
	 * @throws Exception
	 */
	IBAColumn getBAColumn(String strBAColumnName) throws Exception;
}
