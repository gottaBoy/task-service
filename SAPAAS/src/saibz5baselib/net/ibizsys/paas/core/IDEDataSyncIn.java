package net.ibizsys.paas.core;

/**
 * 实体数据同步（输入）对象接口
 * 
 * @author Administrator
 *
 */
public interface IDEDataSyncIn extends IDEDataSync {

	/**
	 * 获取输入数据的实体名称集合
	 * 
	 * @return
	 */
	java.util.Iterator<String> getDENames();

	/**
	 * 获取判断是否输入的实体行为
	 * 
	 * @return
	 */
	String getTestDEActionName();

	/**
	 * 获取导入数据实体行为名称
	 * 
	 * @return
	 */
	String getImportDEActionName();

}
