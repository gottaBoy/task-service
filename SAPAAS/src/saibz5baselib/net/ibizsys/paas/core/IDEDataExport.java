package net.ibizsys.paas.core;

/**
 * 实体数据导出接口
 * 
 * @author Administrator
 *
 */
public interface IDEDataExport extends IDataEntityObject {
	/**
	 * 初始化
	 * 
	 * @param iDataEntity
	 * @throws Exception
	 */
	void init(IDataEntity iDataEntity) throws Exception;

	/**
	 * 获取导出项集合
	 * 
	 * @return
	 */
	java.util.Iterator<IDEDataExportItem> getDEDataExportItems();
}
