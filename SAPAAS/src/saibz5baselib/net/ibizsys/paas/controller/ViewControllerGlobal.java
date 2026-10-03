package net.ibizsys.paas.controller;

import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.ibizsys.paas.util.StringHelper;

/**
 * 视图控制器全局对象
 * 
 * @author lionlau
 *
 */
public class ViewControllerGlobal {
	
	private static final Log log = LogFactory.getLog(ViewControllerGlobal.class);
	private static HashMap<String, IViewController> viewControllerMap = new HashMap<String, IViewController>();
	private static IViewControllerGlobalPlugin iViewControllerGlobalPlugin = null;
	
	/**
	 * 注册视图控制器
	 * 
	 * @param strViewControllerClsType
	 * @param iViewController
	 */
	public static void registerViewController(String strViewControllerClsType, IViewController iViewController) throws Exception {
		if(getPlugin()!=null){
			getPlugin().registerViewController(strViewControllerClsType, iViewController);
			return ;
		}
		if (!viewControllerMap.containsKey(strViewControllerClsType)) {
			// log.info(StringHelper.format("注册视图控制器[%1$s][%2$s]",strViewControllerClsType,iViewController));
			viewControllerMap.put(strViewControllerClsType, iViewController);
		}
	}
	
	
	

	/**
	 * 获取视图控制器
	 * 
	 * @param strViewControllerClsType
	 * @return
	 * @throws Exception
	 */
	public static IViewController getViewController(Class cls) throws Exception {
		if(getPlugin()!=null){
			return getPlugin().getViewController(cls);
		}
		return getViewController(cls.getCanonicalName());
	}

	/**
	 * 获取视图控制器
	 * 
	 * @param strViewControllerClsType
	 * @return
	 * @throws Exception
	 */
	public static IViewController getViewController(String strViewControllerClsType) throws Exception {
		
		if(getPlugin()!=null){
			return getPlugin().getViewController(strViewControllerClsType);
		}
		
		IViewController iViewController = viewControllerMap.get(strViewControllerClsType);
		if (iViewController == null){
			throw new Exception(StringHelper.format("无法获取指定控制器[%1$s]", strViewControllerClsType));
		}
		return iViewController;
	}

	/**
	 * 重置全部动态视图实例缓存
	 */
	public static void resetAllDynaViewControllerInsts() throws Exception {
		for(Entry<String, IViewController> entry : viewControllerMap.entrySet()) {
			IViewController iViewController = entry.getValue();
			if(iViewController instanceof IDynaViewController) {
				IDynaViewController iDynaViewController = (IDynaViewController)iViewController;
				iDynaViewController.resetDynaViewControllerInsts();
			}
			
		}
	}
	
	/**
	 * 设置插件
	 * @param iViewControllerGlobalPlugin
	 */
	public static void setPlugin(IViewControllerGlobalPlugin iViewControllerGlobalPlugin){
		ViewControllerGlobal.iViewControllerGlobalPlugin = iViewControllerGlobalPlugin;
	}
	
	/**
	 * 获取视图控制器插件
	 * @return
	 */
	public static IViewControllerGlobalPlugin getPlugin(){
		return ViewControllerGlobal.iViewControllerGlobalPlugin; 
	}
	
	
	

}
