package net.ibizsys.model.app.view;

/**
 * 应用重定向视图对象接口
 * @author Administrator
 *
 */
public interface IPSAppRedirectView extends IPSAppView
{
	/**
	 * 视图引用模式，重定向项
	 */
	public final static String VIEWREFMODE_RDITEM = "RDITEM";
	
	/**
	 * 获取重定向的视图集合
	 * @return
	 */
	java.util.Iterator<IPSAppView> getRedirectPSAppViews();
	
	
	/**
	 * 获取重定向模式
	 * @return
	 */
	java.util.Iterator<String> getRedirectModes(); 
	
	
	/**
	 * 获取视图引用定义的重定向模式
	 * @return
	 */
	java.util.Iterator<String> getRefRedirectModes(); 
	
	/**
	 * 获取重定向视图
	 * @param strMode
	 * @param bTryMode
	 * @return
	 * @throws Exception
	 */
	IPSAppView getRedirectPSAppView(String strMode,boolean bTryMode) throws Exception;
	

}
