package net.ibizsys.paas.core;

import net.ibizsys.paas.db.IProcParam;

/**
 * 实体系统存储过程行为
 * 
 * @author Administrator
 *
 */
public interface IDEDBSysProcAction extends IDEAction {
	/**
	 * 获取数据库超时
	 * 
	 * @return
	 */
	int getTimeOut();

	/**
	 * 获取过程名称
	 * 
	 * @return
	 */
	String getDBProcName();

	/**
	 * 获取操作模式
	 * 
	 * @return
	 */
	String getActionMode();

	/**
	 * 获取过程参数名称
	 * 
	 * @param strDBType
	 * @return
	 * @throws Exception
	 */
	java.util.Iterator<IProcParam> getProcParams(String strDBType) throws Exception;
}
