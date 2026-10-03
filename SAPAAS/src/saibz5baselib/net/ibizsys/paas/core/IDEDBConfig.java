package net.ibizsys.paas.core;

/**
 * 实体数据库配置模型
 * @author Administrator
 *
 */
public interface IDEDBConfig {


	/**
	 * 获取主数据表名
	 * 
	 * @return
	 */
	String getTableName();

	/**
	 * 获取扩展数据表名
	 * 
	 * @return
	 */
	String getUserTable();

	/**
	 * 获取视图名称
	 * 
	 * @return
	 */
	String getViewName();

	
	/**
	 * 获取级别2视图名称
	 * 
	 * @return
	 */
	String getView2Name();
	
	
	
	/**
	 * 获取级别3视图名称
	 * 
	 * @return
	 */
	String getView3Name();
	
	
	
	/**
	 * 获取级别4视图名称
	 * 
	 * @return
	 */
	String getView4Name();
	
	
	/**
	 * 获取指定级别的视图名称
	 * @param nViewLevel
	 * @return
	 */
	String getViewName(int nViewLevel);
	
	
	
}
