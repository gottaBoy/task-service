package net.ibizsys.paas.core;

/**
 * 实体数据库配置对象接口2，增加了临时表及视图的定义
 * @author Administrator
 *
 */
public interface IDEDBConfig2 extends IDEDBConfig{

	/**
	 * 获取临时主数据表名
	 * 
	 * @return
	 */
	String getTempTableName();

	/**
	 * 获取临时扩展数据表名
	 * 
	 * @return
	 */
	String getTempUserTable();

	/**
	 * 获取临时视图名称
	 * 
	 * @return
	 */
	String getTempViewName();

	
	/**
	 * 获取级别2临时视图名称
	 * 
	 * @return
	 */
	String getTempView2Name();
	
	
	
	/**
	 * 获取级别3临时视图名称
	 * 
	 * @return
	 */
	String getTempView3Name();
	
	
	
	/**
	 * 获取级别4临时视图名称
	 * 
	 * @return
	 */
	String getTempView4Name();
	
	
	/**
	 * 获取指定级别的临时视图名称
	 * @param nViewLevel
	 * @return
	 */
	String getTempViewName(int nViewLevel);
	
}
