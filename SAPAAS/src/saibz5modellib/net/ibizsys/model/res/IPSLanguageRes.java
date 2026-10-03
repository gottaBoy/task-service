package net.ibizsys.model.res;

import net.ibizsys.model.IPSSystemObject;

/**
 * 系统语言资源对象接口
 * @author lionlau
 *
 */
public interface IPSLanguageRes extends IPSSystemObject
{
	/**
	*实体逻辑名称
	*/
	final static String LANRESTYPE_DE_LNAME = "DE.LNAME" ;

	/**
	*属性逻辑名称
	*/
	final static String LANRESTYPE_DEF_LNAME = "DEF.LNAME" ;

	/**
	*代码表项
	*/
	final static String LANRESTYPE_CL_ITEM_LNAME = "CL.ITEM.LNAME" ;

	/**
	*工具栏按钮文本
	*/
	final static String LANRESTYPE_TBB_TEXT = "TBB.TEXT" ;

	/**
	*工具栏按钮提示
	*/
	final static String LANRESTYPE_TBB_TOOLTIP = "TBB.TOOLTIP" ;

	/**
	*菜单项文本
	*/
	final static String LANRESTYPE_MENUITEM_CAPTION = "MENUITEM.CAPTION" ;

	/**
	*界面头部标题
	*/
	final static String LANRESTYPE_PAGE_HEADER = "PAGE.HEADER" ;

	/**
	*界面常规
	*/
	final static String LANRESTYPE_PAGE_COMMON = "PAGE.COMMON" ;

	/**
	*控件文本
	*/
	final static String LANRESTYPE_CONTROL = "CONTROL" ;

	/**
	*标准错误
	*/
	final static String LANRESTYPE_ERROR_STD = "ERROR.STD" ;

	/**
	*处理逻辑
	*/
	final static String LANRESTYPE_CTRL = "CTRL" ;

	/**
	*通用
	*/
	final static String LANRESTYPE_COMMON = "COMMON" ;

	/**
	*其它
	*/
	final static String LANRESTYPE_OTHER = "OTHER" ;


	
	/**
	 * 获取语言资源类型
	 * @return
	 */
	String getLanResType();
	
	/**
	 * 获取语言资源标记
	 * @return
	 */
	String getLanResTag();
	
	
	/**
	 * 获取语言资源短标记
	 * @return
	 */
	String getShortLanResTag();
	

	/**
	 * 获取默认内容
	 * @return
	 */
	String getDefaultContent();
	
	
	
	/**
	 * 获取指定语言内容
	 * @param strLocale
	 * @return
	 */
	String getContent(String strLocale)throws Exception;
	
	
	/**
	 * 获取指定语言内容
	 * @param strLocale
	 * @param bDefault 
	 * @return
	 */
	String getContent(String strLocale,boolean bDefault)throws Exception;
	
	
	/**
	 * 是否有短标识
	 * @return
	 */
	boolean hasShortLanResTag();
	
	
/* INTERNAL-BEGIN */
	
	/**
	 * 是否为用户引用
	 * @return
	 */
	boolean isUserRef();
	

	
	
	
	/**
	 * 标记系统引用
	 * @param objRef  引用对象
	 * @param strMemo
	 */
	void markSysRef(Object objRef,String strMemo);
	
	
	
	/**
	 * 标记系统引用
	 */
	void markSysRef();
	
	
	
	/**
	 * 获取引用标志
	 * @return
	 */
	boolean getRefFlag();
/* INTERNAL-END */
}
