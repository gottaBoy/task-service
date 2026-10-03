package net.ibizsys.psba.core;

/**
 * 大数据架构运行体系
 * 
 * @author Administrator
 *
 */
public interface IBASchemeRuntime {

	/**
	 * 获取大数据源
	 * 
	 * @return
	 */
	IBADataSource getBADataSource();

	/**
	 * 获取大数据适配器
	 * 
	 * @return
	 */
	IBADialect getBADialect();

	/**
	 * 安装模型
	 * 
	 * @throws Exception
	 */
	void install() throws Exception;
	
	
	/**
	 * 获取运行环境的命名空间
	 * @return
	 */
	String getNamespace();
	
	
	
	/**
	 * 获取存储的最大版本
	 * @return
	 */
	int getMaxVersions();
}
