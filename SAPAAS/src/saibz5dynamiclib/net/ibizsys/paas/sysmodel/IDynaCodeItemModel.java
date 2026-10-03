package net.ibizsys.paas.sysmodel;

import net.ibizsys.paas.core.IDynaModelJsonLoader;

/**
 * 动态系统代码项模型对象接口
 * @author Administrator
 *
 */
public interface IDynaCodeItemModel extends ICodeItemModel,IDynaModelJsonLoader {

	/**
	 * 代码表子项集合
	 */
	final static String ATTR_ITEMS = "items";
	
	/**
	 * 模型属性：项值
	 */
	final static String ATTR_VALUE = "value";
	
	/**
	 * 模型属性：文本
	 */
	final static String ATTR_TEXT = "text";
	
	/**
	 * 模型属性：实际文本
	 */
	final static String ATTR_REALTEXT = "realtext";
	
	/**
	 * 模型属性：父项值
	 */
	final static String ATTR_PARENTVALUE = "parentvalue";
	
	/**
	 * 模型属性：图标样式
	 */
	final static String ATTR_ICONCLS = "iconcls";
	
	/**
	 * 模型属性：图标样式（X）
	 */
	final static String ATTR_ICONCLSX = "iconclsx";
	
	
	/**
	 * 模型属性：图标路径
	 */
	final static String ATTR_ICONPATH = "iconpath";
	
	/**
	 * 模型属性：图标路径（X）
	 */
	final static String ATTR_ICONPATHX = "iconpathx";
	
	/**
	 * 模型属性：禁止选择
	 */
	final static String ATTR_DISABLESELECT = "disableselect";
	
	/**
	 * 模型属性：用户数据
	 */
	final static String ATTR_USERDATA = "userdata";
	
	/**
	 * 模型属性：用户数据2
	 */
	final static String ATTR_USERDATA2 = "userdata2";

	
	
	/**
	 * 初始化
	 * @param iDynaCodeListModel
	 * @param parentModel
	 * @param modelObject
	 * @throws Exception
	 */
	void init(IDynaCodeListModel iDynaCodeListModel, IDynaCodeItemModel parentModel, Object modelObject) throws Exception;
	
	
	
	/**
	 * 获取动态代码表模型
	 * @return
	 */
	IDynaCodeListModel getDynaCodeListModel();
	
	
	
	/**
	 * 获取父项对象
	 * @return
	 */
	IDynaCodeItemModel getParentModel();
	 
}
