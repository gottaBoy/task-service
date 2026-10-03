package net.ibizsys.paas.db;

import net.ibizsys.paas.data.ISimpleDataObject;

/**
 * 数据库行记录对象接口
 * 
 * @author Administrator
 *
 */
public interface IDataRow extends ISimpleDataObject {
	/**
	 * 获取数据表对象
	 * 
	 * @return
	 */
	IDataTable getDataTable();

	/**
	 * 通过索引获取值
	 * 
	 * @param nIndex
	 * @return
	 * @throws Exception
	 */
	Object get(int nIndex) throws Exception;

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.data.ISimpleDataObject#get(java.lang.String)
	 */
	Object get(String strColumnName) throws Exception;

	/**
	 * 判断指定索引位置值是否为空
	 * 
	 * @param nIndex
	 * @return
	 * @throws Exception
	 */
	boolean isDBNull(int nIndex) throws Exception;

	/**
	 * 指定字段是否为空值
	 * 
	 * @param strColumnName
	 * @return
	 * @throws Exception
	 */
	boolean isDBNull(String strColumnName) throws Exception;

	/**
	 * 释放
	 */
	void reset();
}
