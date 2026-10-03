package net.ibizsys.paas.db;

/**
 * 数据表列接口
 * 
 * @author Administrator
 *
 */
public interface IDataColumn {
	/**
	 * 获取分类名词
	 * 
	 * @return
	 */
	String getCatalogName();

	/**
	 * 获取列类名词
	 * 
	 * @return
	 */
	String getColumnClassName();

	/**
	 * 获取显示长度
	 * 
	 * @return
	 */
	int getDisplaySize();

	/**
	 * 获取列类型
	 * 
	 * @return
	 */
	int getColumnType();

	/**
	 * 获取列名称
	 * 
	 * @return
	 */
	String getName();

	/**
	 * 获取数据库数据类型
	 * 
	 * @return
	 */
	String getDBDataType();

	/**
	 * 获取类索引
	 * 
	 * @return
	 */
	int getIndex();
}
