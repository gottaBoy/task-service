package net.ibizsys.psba.dao;

import net.ibizsys.paas.db.ISelectCond;

/**
 * 大数据数据查询上下文
 * @author Administrator
 *
 */
public interface IBASelectContext extends ISelectCond {

	/**
	 * 获取列族集合
	 * @return
	 */
	String[] getColSets();
	
	
	
	
	/**
	 * 设置行记录前缀
	 * @return
	 */
	String getRowKeyPrefix();
	
	
	
	/**
	 * 获取最大的版本数
	 * @return
	 */
	int getMaxVersions();
	
	
	
	/**
	 * 获取开始的时间戳
	 * @return
	 */
	java.util.Date getStartTimeStamp();
	
	
	
	
	/**
	 * 获取开始的时间戳
	 * @return
	 */
	java.util.Date getStopTimeStamp();
	
	
	/**
	 * 获取其实行
	 * @return
	 */
	String getStartRowKey();
	
	
	/**
	 * 获取其实行
	 * @return
	 */
	String getStopRowKey();
	
	
	
	/**
	 * 获取最大的单元格数量，非行记录
	 * @return
	 */
	int getBatchSize();
	
	
	
	
	
	/**
	 * 获取指定的时间戳
	 * @return
	 */
	java.util.Date getTimeStamp();
	

	

}
