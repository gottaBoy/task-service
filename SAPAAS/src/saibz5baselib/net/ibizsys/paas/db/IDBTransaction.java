package net.ibizsys.paas.db;

import net.ibizsys.paas.service.ITransaction;

/**
 * 数据库事物对象
 * 
 * @author Administrator
 *
 */
public interface IDBTransaction extends ITransaction {
	/**
	 * 获取当前连接
	 * 
	 * @return
	 */
	java.sql.Connection getConnection();
}
