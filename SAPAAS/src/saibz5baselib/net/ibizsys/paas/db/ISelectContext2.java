package net.ibizsys.paas.db;

/**
 * 数据查询上下文条件2，提供开始行，分页，用于非视图模式查询
 * @author Administrator
 *
 */
public interface ISelectContext2 extends ISelectContext {

	/**
	 * 是否支持分页
	  * @return
	 */
	boolean isPaging();
	
	
	/**
	 * 开始行数
	 * 
	 * @return
	 */
	int getStartRow();

	/**
	 * 分页大小
	 * 
	 * @return
	 */
	int getPageSize();

}
