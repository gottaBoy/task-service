package net.ibizsys.paas.db;

import java.sql.SQLException;

/**
 * 数据集对象接口
 * 
 * @author lionlau
 *
 */
public interface IDataSet {
	/**
	 * 获取数据表数量
	 * 
	 * @return
	 */
	int getDataTableCount();

	/**
	 * 获取指定数据表
	 * 
	 * @param nIndex
	 * @return
	 */
	IDataTable getDataTable(int nIndex);

	/**
	 * 关闭数据集合，释放表对象
	 */
	void close();

	/**
	 * 预读记录
	 * 
	 * @param nSize
	 * @return
	 * @throws SQLException
	 */
	void cacheDataRow() throws SQLException;

	/**
	 * 获取Sql信息
	 * 
	 * @return
	 */
	String getSqlInfo();
}
