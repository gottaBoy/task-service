package net.ibizsys.paas.controller;


/**
 * 视图控制器全局对象插件
 * @author Administrator
 *
 */
public interface IViewControllerGlobalPlugin {
	/**
	 * 注册视图控制器
	 * 
	 * @param strViewControllerClsType
	 * @param iViewController
	 */
	  void registerViewController(String strViewControllerClsType, IViewController iViewController) throws Exception;

	/**
	 * 注册视图控制器插件
	 * 
	 * @param strViewControllerClsType
	 * @param iViewControllerPlugin
	 */
	  void registerViewControllerPlugin(String strViewControllerClsType, IViewControllerPlugin iViewControllerPlugin)  throws Exception ;
		  
	/**
	 * 获取视图控制器
	 * 
	 * @param strViewControllerClsType
	 * @return
	 * @throws Exception
	 */
	  IViewController getViewController(Class cls) throws Exception ;

	/**
	 * 获取视图控制器
	 * 
	 * @param strViewControllerClsType
	 * @return
	 * @throws Exception
	 */
	IViewController getViewController(String strViewControllerClsType) throws Exception;
}
