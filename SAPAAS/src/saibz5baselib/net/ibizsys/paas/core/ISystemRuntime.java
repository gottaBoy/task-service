package net.ibizsys.paas.core;

import net.ibizsys.paas.db.IDatabase;

/**
 * 系统运行时接口
 * 
 * @author Administrator
 *
 */
public interface ISystemRuntime {
	/**
	 * 获取当前数据库
	 * 
	 * @return
	 * @throws Exception
	 */
	IDatabase getDatabase() throws Exception;

	/**
	 * 获取数据库
	 * 
	 * @param strDBId 指定数据连接
	 * @return
	 * @throws Exception
	 */
	IDatabase getDatabase(String strDBId) throws Exception;

	/**
	 * 获取系统设置
	 * 
	 * @param strKey
	 * @return
	 */
	String getSystemSetting(String strKey, String strDefault);
}
