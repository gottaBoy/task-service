package net.ibizsys.paas.core;

import net.ibizsys.paas.data.IDataItem;

/**
 * 实体自动填充模式接口
 * 
 * @author Administrator
 *
 */
public interface IDEACMode extends IDataEntityObject {
	/**
	 * 值数据项
	 */
	final static String DATAITEM_VALUE = "value";

	/**
	 * 显示文本数据项
	 */
	final static String DATAITEM_TEXT = "text";

	/**
	 * 实际文本数据项
	 */
	final static String DATAITEM_REALTEXT = "realtext";

	/**
	 * 初始化
	 * 
	 * @param iDataEntity
	 * @throws Exception
	 */
	void init(IDataEntity iDataEntity) throws Exception;

	/**
	 * 获取默认排序字段
	 * 
	 * @return
	 */
	String getMinorSortField();

	/**
	 * 获取默认排序方向
	 * 
	 * @return
	 */
	String getMinorSortDir();

	/**
	 * 获取数据项集合
	 * 
	 * @return
	 */
	java.util.Iterator<IDataItem> getDataItems();

	/**
	 * 是否为默认模式
	 * 
	 * @return
	 */
	boolean isDefaultMode();

}
