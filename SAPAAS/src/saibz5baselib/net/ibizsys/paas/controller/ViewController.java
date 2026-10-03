package net.ibizsys.paas.controller;

/**
 * 视图控制器静态对象
 * 
 * @author Administrator
 *
 */
public class ViewController {
	
	private static ThreadLocal<IViewController> viewController = new ThreadLocal<IViewController>();

	/**
	 * 获取当前视图控制器
	 * 
	 * @return
	 */
	public static IViewController getCurrent() {
		return viewController.get();
	}

	/**
	 * 设置当前视图控制器
	 * 
	 * @param value
	 */
	public static void setCurrent(IViewController value) {
		viewController.set(value);
	}
}
