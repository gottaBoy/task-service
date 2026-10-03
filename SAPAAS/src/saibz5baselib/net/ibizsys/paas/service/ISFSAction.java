package net.ibizsys.paas.service;

/**
 * 会话工厂会话操作对象，用于完成在事物提交后执行的操作
 * @author Administrator
 *
 */
public interface ISFSAction {

	
	/**
	 * 提交
	 */
	void commit();
	
	
	
	/**
	 * 回滚
	 */
	void rollback();
}
