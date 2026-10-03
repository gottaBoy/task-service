package net.ibizsys.paas.core;

/**
 * 实体行为接口
 * 
 * @author lionlau
 *
 */
public interface IDEAction extends IDataEntityObject {
	/**
	 * 系统存储过程
	 */
	final static String ACTIONTYPE_SYSDBPROC = "SYSDBPROC";

	/**
	 * 用户存储过程
	 */
	final static String ACTIONTYPE_USERDBPROC = "USERDBPROC";

	/**
	 * 用户自定义
	 */
	final static String ACTIONTYPE_USERCUSTOM = "USERCUSTOM";

	/**
	 * 实体处理逻辑
	 */
	final static String ACTIONTYPE_DELOGIC = "DELOGIC";

	/**
	 * 内置方法
	 */
	final static String ACTIONTYPE_BUILTIN = "BUILTIN";

	/**
	 * 获取操作超时
	 * 
	 * @return
	 */
	int getTimeOut();

	/**
	 * 获取行为类型
	 * 
	 * @return
	 */
	String getActionType();

	/**
	 * 获取调用器对象
	 * 
	 * @return
	 */
	String getCallerObject();

	/**
	 * 获取实体行为调用器
	 * 
	 * @return
	 * @throws Exception
	 */
	IDEActionCaller getDEActionCaller() throws Exception;

	/**
	 * 释放实体行为调用器
	 * 
	 * @param iDEActionCaller
	 */
	void releaseDEActionCaller(IDEActionCaller iDEActionCaller);

}
