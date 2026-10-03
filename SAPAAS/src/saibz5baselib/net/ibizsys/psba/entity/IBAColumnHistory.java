package net.ibizsys.psba.entity;

/**
 * 大数据列历史对象
 * @author Administrator
 *
 */
public interface IBAColumnHistory {
	
	/**
	 * 获取版本集合
	 * @return
	 */
	java.util.Iterator<Long> getTimestamps();
	
	/**
	 * 获取版本值
	 * @param nTimestamp
	 * @return
	 */
	Object getValue(long nTimestamp) throws Exception;
	
	

	/**
	 * 获取最新的值
	 * @return
	 */
	Object getLastValue();
}
