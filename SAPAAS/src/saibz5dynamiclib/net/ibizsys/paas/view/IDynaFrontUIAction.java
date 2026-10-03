package net.ibizsys.paas.view;

/**
 * 前端界面行为对象接口
 * @author Administrator
 *
 */
public interface IDynaFrontUIAction extends IUIAction {
	
	//定义前台处理模式代码表

	/**
	*向导处理
	*/
	public final static String FRONTPROCESSTYPE_WIZARD = "WIZARD" ;

	/**
	*打开页面
	*/
	public final static String FRONTPROCESSTYPE_SHOWPAGE = "SHOWPAGE" ;

	/**
	*打开HTML页面
	*/
	public final static String FRONTPROCESSTYPE_OPENHTMLPAGE = "OPENHTMLPAGE" ;
	
	/**
	*其它
	*/
	public final static String FRONTPROCESSTYPE_OTHER = "OTHER" ;
	
	
	/**
	 * 获取前端处理类型，值参考 net.ibizsys.paas.view.IDynaFrontUIAction.FRONTPROCESSTYPE_XXX 定义
	 * @return
	 */
	String getFrontProcessType();
	
	
	
	
	/**
	 * 获取前端视图标识
	 * @return
	 */
	String getFrontViewId();
}
