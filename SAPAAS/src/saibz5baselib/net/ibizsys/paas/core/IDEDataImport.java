package net.ibizsys.paas.core;

/**
 * 实体数据导入接口
 * 
 * @author Administrator
 *
 */
public interface IDEDataImport extends IDataEntityObject {
	/**
	 * 初始化
	 * 
	 * @param iDataEntity
	 * @throws Exception
	 */
	void init(IDataEntity iDataEntity) throws Exception;
	
	
	
	/**
	 * 获取数据导入项集合
	 * @return
	 */
	java.util.Iterator<IDEDataImportItem> getDEDataImportItems();
	
	
	/**
	 * 是否忽略导入错误，进行导入
	 * @return
	 */
	boolean isIgnoreError();
	
	
	
	/**
	 * 获取建立数据实体行为名称
	 * @return
	 */
	String getCreateDEActionName();
	
	
	/**
	 * 获取更新数据实体行为名称
	 * @return
	 */
	String getUpdateDEActionName();
	
	
	/**
	 * 是否为默认数据导入处理
	 * @return
	 */
	boolean isDefault();
	
	
	/**
	 * 获取创建数据需要的访问行为
	 * @return
	 */
	String getCreateDataAccessAction();
	
	
	/**
	 * 获取更新数据需要的访问行为
	 * @return
	 */
	String getUpdateDataAccessAction();
}
