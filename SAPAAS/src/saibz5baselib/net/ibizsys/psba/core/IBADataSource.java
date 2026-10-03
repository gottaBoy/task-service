package net.ibizsys.psba.core;

/**
 * 大数据体系数据源接口
 * 
 * @author Administrator
 *
 */
public interface IBADataSource {

	/**
	 * 获取连接对象
	 * 
	 * @return
	 * @throws Exception
	 */
	Object getConnection() throws Exception;

	/**
	 * 关闭连接对象
	 * 
	 * @param connection
	 * @throws Exception
	 */
	void closeConnection(Object connection) throws Exception;
	
	
	
	
	/**
	 * 获取命名空间
	 * @return
	 */
	String getNamespace();
	
	
	
	/**
	 * 获取最大版本号
	 * @return
	 */
	int getMaxVersions();
}
