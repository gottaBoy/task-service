package net.ibizsys.psba.dao;

/**
 * 大数据访问作业
 * 
 * @author Administrator
 *
 */
public interface IBADAOWork {

	/**
	 * 执行作业
	 * 
	 * @param objConn
	 * @throws Exception
	 */
	void execute(Object objConn) throws Exception;
}
