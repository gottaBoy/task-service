package net.ibizsys.paas.core;

/**
 * 实体数据导入项对象接口
 * @author Administrator
 *
 */
public interface IDEDataImportItem extends IModelBase {

	/**
	 * 获取实体数据导入对象
	 * @return
	 */
	IDEDataImport getDEDataImport();
	
	/**
	 * 获取实体属性名称
	 * @return
	 */
	String getDEFName();
	
	/**
	 * 获取标题
	 * @return
	 */
	String getCaption();
	
	
	/**
	 * 获取标题语言资源标识
	 * @return
	 */
	String getCapLanResTag();
	
	
	
	/**
	 * 是否为唯一数据识别项
	 * @return
	 */
	boolean isUniqueItem();
	
	
	/**
	 * 获取实体属性
	 * @return
	 */
	IDEField getDEField();
}
