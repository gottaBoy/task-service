package net.ibizsys.paas.control.drctrl;

/**
 * 数据部件数据项接口
 * 
 * @author lionlau
 *
 */
public interface IDRCtrlItem {
	/**
	 * 启用模式，全部启用
	 */
	final static String ENABLEMODE_ALL = "ALL";

	/**
	 * 启用模式，全部流程状态（流程中，已完成，已取消）
	 */
	final static String ENABLEMODE_ALLWF = "ALLWF";

	/**
	 * 启用模式，流程中
	 */
	final static String ENABLEMODE_INWF = "INWF";

	/**
	 * 启用模式，编辑
	 */
	final static String ENABLEMODE_EDIT = "EDIT";

	/**
	 * 实体操作标识
	 */
	final static String ENABLEMODE_DEOPPRIV = "DEOPPRIV";

	/**
	 * 自定义
	 */
	final static String ENABLEMODE_CUSTOM = "CUSTOM";

	/**
	 * 获取标识
	 * 
	 * @return
	 */
	String getId();

	/**
	 * 获取父标识
	 * 
	 * @return
	 */
	String getPId();

	/**
	 * 获取文本
	 * 
	 * @return
	 */
	String getText();

	/**
	 * 是否展开
	 * 
	 * @return
	 */
	boolean isExpanded();

	/**
	 * 获取项集合
	 * 
	 * @return
	 */
	java.util.ArrayList<IDRCtrlItem> getItems();

	/**
	 * 获取文本样式
	 * 
	 * @return
	 */
	String getTextCls();

	/**
	 * 获取图标样式
	 * 
	 * @return
	 */
	String getIconCls();

	/**
	 * 获取图标路径
	 * 
	 * @return
	 */
	String getIconPath();
	
	/**
	 * 获取图标样式（X）
	 * 
	 * @return
	 */
	String getIconClsX();

	/**
	 * 获取图标路径（X）
	 * 
	 * @return
	 */
	String getIconPathX();
	

	/**
	 * 获取计数器标识
	 * 
	 * @return
	 */
	String getCounterId();
	
//	/**
//	 * 获取计数器模式
//	 * 
//	 * @return
//	 */
//	int getCounterMode();
	

	/**
	 * 设置属性
	 * 
	 * @param strName
	 * @param objValue
	 */
	void setAttribute(String strName, Object objValue);

	/**
	 * 获取属性
	 * 
	 * @param strName
	 * @return
	 */
	Object getAttribute(String strName);

	/**
	 * 获取导航视图标识
	 * 
	 * @return
	 */
	String getDRViewId();

	/**
	 * 设置视图参数
	 * 
	 * @param strKey
	 * @param objValue
	 */
	void setViewParam(String strKey, String objValue);

	/**
	 * 设置视图参数
	 * 
	 * @param strKey
	 * @return
	 */
	String getViewParam(String strKey);

	/**
	 * 获取视图参数的名称集合
	 * 
	 * @return
	 */
	java.util.Iterator<String> getViewParamNames();

	/**
	 * 获取功能访问模式
	 * 
	 * @return
	 */
	int getAccUserMode();

	/**
	 * 获取功能访问资源标识
	 * 
	 * @return
	 */
	String getAccessKey();

	/**
	 * 获取启用模式
	 * 
	 * @return
	 */
	String getEnableMode();

	/**
	 * 获取判断启用实体操作名称
	 * 
	 * @return
	 */
	String getTestEnableDEActionName();

	/**
	 * 获取判断启用实体操作标识
	 * 
	 * @return
	 */
	String getTestEnableDEOPPriv();
	
	/**
	 * 获取文本语言资源标识
	 * 
	 * @return
	 */
	String getTextLanResTag();
	
	
	
	/**
	 * 获取数据树标识
	 * @return
	 */
	String getDataTreeId();
}
