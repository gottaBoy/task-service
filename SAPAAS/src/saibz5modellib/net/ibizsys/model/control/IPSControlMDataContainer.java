package net.ibizsys.model.control;

/**
 * 多数据部件容器对象接口
 * @author Administrator
 *
 */
public interface IPSControlMDataContainer extends IPSControlXDataContainer {

	/**
	 * 新建数据模式，默认
	 */
	public final static String NEWDATAMODE_NORMAL= "NORMAL";
	
	
	/**
	 * 新建数据模式，向导
	 */
	public final static String NEWDATAMODE_WIZARD= "WIZARD";
	
	/**
	 * 新建数据模式，多表单
	 */
	public final static String NEWDATAMODE_MULTIFORM= "MULTIFORM";
	
	/**
	 * 单项添加及批添加
	 */
	public final static String NEWDATAMODE_ENABATADD= "ENABATADD";
	
	/**
	 * 仅限批添加
	 */
	public final static String NEWDATAMODE_BATADDONLY= "BATADDONLY";
	
	
	/**
	 * 新建数据模式，索引实体
	 */
	public final static String NEWDATAMODE_INDEXDE= "INDEXDE";
	
	
	/**
	 * 编辑数据模式，默认
	 */
	public final static String EDITDATAMODE_NORMAL= "NORMAL";
	
	
	/**
	 * 编辑数据模式，多表单
	 */
	public final static String EDITDATAMODE_MULTIFORM= "MULTIFORM";
	
	
	/**
	 * 编辑数据模式，索引实体
	 */
	public final static String EDITDATAMODE_INDEXDE= "INDEXDE";
	
	/**
	 * 获取新建数据模式
	 * @return
	 */
	String getNewDataMode();
	
	
	
	/**
	 * 获取更新数据模式
	 * @return
	 */
	String getEditDataMode();
	
	
	
	/**
	 * 是否为默认加载
	 * @return
	 */
	boolean isLoadDefault();
	
	
	/**
	 * 是否支持批添加
	 * @return
	 */
	boolean isEnableBatchAdd();
	
	
	/**
	 * 只支持批添加
	 * @return
	 */
	boolean isBatchAddOnly();
	
	
	/**
	 * 是否处于拾取模式
	 * 
	 * @return
	 */
	boolean isPickupMode();
	
	

	/**
	 * 是否支持查看数据
	 * @return
	 */
	boolean isEnableViewData();

	
	
	/**
	 * 支持数据导入
	 * @return
	 */
	boolean isEnableImport();
	
	
	
	
	/**
	 * 支持数据导出
	 * @return
	 */
	boolean isEnableExport();
	
	
	
	
	/**
	 * 支持数据过滤
	 * @return
	 */
	boolean isEnableFilter();
	
	
	
	/**
	 * 是否支持快速搜索
	 * @return
	 */
	boolean isEnableQuickSearch();
	
	
	
	
	/**
	 * 是否支持搜索
	 * @return
	 */
	boolean isEnableSearch();
	
	
	
	/**
	 * 是否启用快速建立模式
	 * @return
	 */
	boolean isEnableQuickCreate();
}
