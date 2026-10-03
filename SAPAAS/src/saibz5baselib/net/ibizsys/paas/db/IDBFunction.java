package net.ibizsys.paas.db;


/**
 * 数据库函数对象
 * @author Administrator
 *
 */
public interface IDBFunction {

	/**
	 * 获取名称
	 * @return
	 */
	String getName();
	
	
	/**
	 * 获取数据库的函数代码
	 * 
	 * @param 是否为数据插入时使用
	 * @param 列名称
	 * @return
	 * @throws Exception
	 */
	String getFuncSQL(boolean bInsert, String[] args) throws Exception;
	

	
	
	/**
	 * 获取返回的数据类型
	 * @return
	 */
	int getOutputDataType();
}
