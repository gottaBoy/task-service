package net.ibizsys.paas.view;

import net.ibizsys.paas.core.IModelBase;


/**
 * 视图界面行为对象接口
 * @author Administrator
 *
 */
public interface IUIAction extends IModelBase {
	
	/**
	 * 行为无权限显示模式：隐藏且默认隐藏
	 */
	public final static int NOPRIVDISPLAYMODE_HIDEDEFAULT = 6;
	
	
	//定义数据目标代码表

	/**
	*数据目标：单项数据
	*/
	public final static String ACTIONTARGET_SINGLE = "SINGLE" ;

	/**
	*数据目标：单项数据（主键）
	*/
	public final static String ACTIONTARGET_SINGLEKEY = "SINGLEKEY" ;

	/**
	*数据目标：多项数据（主键）
	*/
	public final static String ACTIONTARGET_MULTI = "MULTI" ;

	/**
	*数据目标：单项或多项数据（主键）
	*/
	public final static String ACTIONTARGET_ALL = "ALL" ;

	/**
	*数据目标：无数据
	*/
	public final static String ACTIONTARGET_NONE = "NONE" ;
	
	
	
	/**
	 * 获取界面行为标识
	 * @return
	 */
	String getUIActionTag();
	
	/**
	 * 获取界面操作类型
	 * @return
	 */
	String getUIActionType();
	
	
	/**
	 * 获取界面操作模式
	 * @return
	 */
	String getUIActionMode();
	
	
	/**
	 * 获取标题
	 * @return
	 */
	String getCaption();
	
	
	/**
	 * 获取工具栏提示
	 * @return
	 */
	String getTooltip();
	
	
	/**
	 * 获取标题语言资源
	 * @return
	 */
	String getCapLanResTag();
	
	
	/**
	 * 获取提示语言资源
	 * @return
	 */
	String getTooltipLanResTag();
	
	/**
	 * 获取数据操作目标，值参考 net.ibizsys.paas.view.IUIAction.ACTIONTARGET_XXX 定义
	 * @return
	 */
	String getActionTarget();

	
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
	 * 是否支持运行时模型，运行时模型指从后台实时获取界面行为模型进行处理，完成诸如动态提示信息等功能
	 * @return
	 */
	boolean isEnableRuntimeModel();
	
	
	
	
	/**
	 * 关闭弹出视图
	 * 
	 * @return
	 */
	boolean isClosePopupView();
}
