package net.ibizsys.paas.core;

/**
 * 实体数据同步（输出）
 * 
 * @author Administrator
 *
 */
public interface IDEDataSyncOut extends IDEDataSync {

	/**
	 * 获取判断是否输入的实体行为
	 * 
	 * @return
	 */
	String getTestDEActionName();

	/**
	 * 获取存储文件值的属性
	 * 
	 * @return
	 */
	java.util.Iterator<String> getFileFields();
}
