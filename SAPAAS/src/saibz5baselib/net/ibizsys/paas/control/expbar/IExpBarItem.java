package net.ibizsys.paas.control.expbar;

/**
 * 导航栏项接口
 * 
 * @author lionlau
 *
 */
public interface IExpBarItem {
	/**
	 * 无模式
	 */
	final static int COUNTERMODE_NONE = 0;

	/**
	 * 0 值时隐藏
	 */
	final static int COUNTERMODE_HIDEZERO = 1;

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
	java.util.ArrayList<IExpBarItem> getItems();

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
	 * 获取计数器标识
	 * 
	 * @return
	 */
	String getCounterId();

	/**
	 * 获取计数器模式
	 * 
	 * @return
	 */
	int getCounterMode();

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
	String getExpViewId();

	/**
	 * 设置导航视图参数
	 * 
	 * @param strKey
	 * @param objValue
	 */
	void setViewParam(String strKey, String objValue);

	/**
	 * 设置导航视图参数
	 * 
	 * @param strKey
	 * @return
	 */
	String getViewParam(String strKey);

	/**
	 * 获取导航视图参数的名称集合
	 * 
	 * @return
	 */
	java.util.Iterator<String> getViewParamNames();

	/**
	 * 获取文本语言资源标识
	 * 
	 * @return
	 */
	String getTextLanResTag();
}
