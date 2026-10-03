package net.ibizsys.paas.core;

/**
 * 实体相关大数据表
 * @author Administrator
 *
 */
public interface IDEBATable extends IDataEntityObject{

	/**
	 * 获取大数据表实体类型
	 * @return
	 */
	int getBATableDEType();
	
	
	/**
	 * 获取响应的大数据架构标识
	 * @return
	 */
	String getBAThemeId();
	
	
	
	/**
	 * 获取响应的大数据表名称
	 * @return
	 */
	String getBATableName();
	
	
	
	/**
	 * 获取默认列族名称
	 * @return
	 */
	String getBAColSetName();
	
	

	
}
