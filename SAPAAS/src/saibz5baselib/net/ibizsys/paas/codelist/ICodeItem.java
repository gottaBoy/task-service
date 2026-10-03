package net.ibizsys.paas.codelist;

import net.ibizsys.paas.core.IModelBase;

/**
 * 代码项对象接口
 * 
 * @author lionlau
 *
 */
public interface ICodeItem extends IModelBase {
	
	/**
	 * 获取代码表对象
	 * 
	 * @return
	 */
	ICodeList getCodeList();

	/**
	 * 获取父代码项
	 * 
	 * @return
	 */
	ICodeItem getParentCodeItem();

	/**
	 * 获取子代码列表
	 * 
	 * @return
	 */
	java.util.Iterator<ICodeItem> getCodeItems() throws Exception;

	/**
	 * 获取实际文本
	 * 
	 * @return
	 */
	String getRealText();

	/**
	 * 获取文本
	 * 
	 * @return
	 */
	String getText();

	/**
	 * 获取值
	 * 
	 * @return
	 */
	String getValue();

	/**
	 * 获取对应的颜色
	 * 
	 * @return
	 */
	String getColor();

	/**
	 * 获取图标路径
	 * 
	 * @return
	 */
	String getIconPath();

	/**
	 * 获取图标路径显示倍数格式化串
	 * 
	 * @return
	 */
	String getIconPathX();

	/**
	 * 获取图标路径
	 * 
	 * @param nX 显示倍数
	 * @return
	 */
	String getIconPath(int nX);

	/**
	 * 获取备注
	 * 
	 * @return
	 */
	String getMemo();

	/**
	 * 获取图标样式
	 * 
	 * @return
	 */
	String getIconCls();

	/**
	 * 获取图标样式显示倍数格式化串
	 * 
	 * @return
	 */
	String getIconClsX();

	/**
	 * 获取图标样式
	 * 
	 * @param nX 显示倍数
	 * @return
	 */
	String getIconCls(int nX);

	/**
	 * 获取文本式样
	 * 
	 * @return
	 */
	String getTextCls();

	/**
	 * 通过文本获取列表项
	 * 
	 * @param strText 文本
	 * @param bRecursion 是否递归查找
	 * @return
	 */
	ICodeItem getCodeItemByText(String strText, boolean bRecursion) throws Exception;

	/**
	 * 通过值获取列表项
	 * 
	 * @param strValue 值
	 * @param bRecursion 是否递归查找
	 * @return
	 */
	ICodeItem getCodeItem(String strValue, boolean bRecursion) throws Exception;

	
	/**
	 * 通过文本获取列表项，递归查找符合条件的子项
	 * 
	 * @param strText 文本
	 * @return
	 */
	ICodeItem getCodeItemByText(String strText) throws Exception;

	/**
	 * 通过值获取列表项，递归查找符合条件的子项
	 * 
	 * @param strValue 值
	 * @return
	 */
	ICodeItem getCodeItem(String strValue) throws Exception;
	
	/**
	 * 获取上级值
	 * 
	 * @return
	 */
	String getParentValue();

	/**
	 * 获取用户自定义数据
	 * 
	 * @return
	 */
	String getUserData();

	/**
	 * 获取用户自定义数据2
	 * 
	 * @return
	 */
	String getUserData2();

	/**
	 * 获取代码项是否禁止选择（应用于选项部件）
	 * 
	 * @return
	 */
	boolean isDisableSelect();
	
	
	
	/**
	 * 获取文本语言资源标识
	 * @return
	 */
	String getTextLanResTag();
}
