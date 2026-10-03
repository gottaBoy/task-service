package net.ibizsys.paas.core;

/**
 * 数据导入结果
 * @author Administrator
 *
 */
public interface IDEDataImportResult {

	/**
	 * 获取结果信息
	 * @return
	 */
	String getRetInfo();

	
	/**
	 * 获取错误代码
	 * @return
	 */
	int getRetCode();
	
	
	
	/**
	 * 获取行号
	 * @return
	 */
	int getRowSN();
}
